package com.mardomsara.social.models_old.syncer;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.UserSyncJson;
import com.mardomsara.social.models_old.ContactsCopyModel;
import com.mardomsara.social.models_old.stores.Store;
import com.mardomsara.social.models_old.stores.StoreConstants;
import com.mardomsara.social.models_old.tables.ContactsCopy;
import com.mardomsara.social.models_old.tables.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 10/2/2016.
 */
public class UserSyncer {
	public static void syncChangedUser_BG(){
		AndroidUtil.runInUiNoPanic(()->{
			int last = Store.getInt(StoreConstants.LAST_USER_TABLE_SYNCED);
			syncChangedUserImpl(last,null);
		});
	}

	public static void forceSyncChangedUser(Runnable runnable){
		syncChangedUserImpl(0,runnable);
	}

	// Privates
	private static void syncChangedUserImpl(int last,Runnable runnable){
		AppUtil.log("syncChangedUser_BG");

		Http.getPath("/v1/sync_users")
			.setQueryParam("last",last)
			.doAsync((result)->{
				if(result.isOk()){
					HttpJsonList<UserSyncJson> res = Result.fromJsonList(result, UserSyncJson.class);
					if(res != null && res.Payload != null){
						List<User> newUsers = new ArrayList<User>();
						for(UserSyncJson row: res.Payload){
							newUsers.add(UserJsonToNewUserTable(row));
						}
						saveNewUsers(newUsers);
						Store.putInt(StoreConstants.LAST_USER_TABLE_SYNCED, res.ServerTime);
					}
				}

				if(runnable != null) runnable.run();
			});

	}

	private static void saveNewUsers (List<User> newUsers) {
		DB.getAppDB().transactionSync(()->{
			for(User u: newUsers){
				u.save();
			}
		});
	}

	private  static User UserJsonToNewUserTable(UserSyncJson row){
		User user = new User();
		user.UserId = row.Id;
		user.FirstName = row.FirstName;
		user.LastName = row.LastName;
		user.FullName = row.FullName == null ? "" : row.FullName;
		user.AvatarUrl = row.AvatarUrl;
		user.About = row.About;
		user.AppVersion = row.AppVersion;
		user.UpdatedTime = row.UpdatedTime;
		user.FollowingType = row.FollowingType;
		user.PrivacyProfile = row.PrivacyProfile;

		if(row.Phone != null && row.Phone != ""){
			Map<String,ContactsCopy> map= ContactsCopyModel.getCacheOfContactsCopy();
			if(map.containsKey(row.Phone)){
				ContactsCopy cc = map.get(row.Phone);
				user.PhoneContactRowId = cc.PhoneContactRowId;
				user.PhoneDisplayName = cc.PhoneDisplayName;
				user.PhoneNumber = cc.PhoneNumber;
				user.PhoneNormalizedNumber = row.Phone;
			}
		}

		if(user.PhoneContactRowId == 0 ){
			user.PhoneContactRowId = 0;
			user.PhoneDisplayName = "";
			user.PhoneNumber = "";
			user.PhoneNormalizedNumber = "";
		}
		return user;
	}




}
