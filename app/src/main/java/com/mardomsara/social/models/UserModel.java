package com.mardomsara.social.models;

import android.support.annotation.Nullable;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.models.memory_store.MemoryStore_Users;
import com.mardomsara.social.models.tables.ContactsCopy;
import com.mardomsara.social.models.tables.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 9/6/2016.
 */
public class UserModel {

	//////////// CRUD ///////////
	public static void create(User user) {
		DB.db.insertIntoUser(user);
	}

	@Nullable
	public static User getByUserId(int id) {
		User user = DB.db.selectFromUser().UserIdEq(id).getOrNull(0);
		MemoryStore_Users.set(user);
		return DB.db.selectFromUser().UserIdEq(id).getOrNull(0);
	}

	/////////////////////////////

	public static void saveNewUser(User user) {
		AppUtil.log("saveNewUser()");
		if (user == null) return;
		Map<String, ContactsCopy> map = ContactsCopyModel.getCacheOfContactsCopy();
		String phone = user.Phone;
		if (user.PhoneNormalizedNumber != null || !user.PhoneNormalizedNumber.equals("")) {
			phone = user.PhoneNormalizedNumber;
		}
		if (phone != null && !phone.equals("") && map.containsKey(phone)) {
			ContactsCopy cc = map.get(phone);
			user.IsPhoneContact = 1;
			user.PhoneContactRowId = cc.PhoneContactRowId;
			user.PhoneDisplayName = cc.PhoneDisplayName;
			user.PhoneNumber = cc.PhoneNumber;
			user.PhoneNormalizedNumber = phone;
		} else {
			user.IsPhoneContact = -1;
			user.PhoneContactRowId = 0;
			user.PhoneDisplayName = "";
			user.PhoneNumber = "";
			user.PhoneNormalizedNumber = "";
		}
		user.save();
//		});
	}

	public static List<User> getAllFollowings() {
		return DB.db.selectFromUser().FollowingTypeEq(1).toList();
	}

	public static List<User> getAllRegisteredContacts() {
		return DB.db.selectFromUser().IsPhoneContactEq(1).toList();
	}

	public static void onFollowedUser(UserInfoJson userJson) {
		if (userJson == null) return;
		User user = getByUserId(userJson.getUserId());
		if (user != null) {
			user.FollowingType = 1;
			AndroidUtil.runInBackgroundNoPanic(() -> {
				user.save();
			});
		} else {//insert new user
			User u2 = UserInfoJsonToUserTable(userJson);
			u2.FollowingType = 1;
			AndroidUtil.runInBackgroundNoPanic(() -> {
				u2.save();
			});
		}

	}

	//dont delete row beacuse we may have do some chat with him: - // TODO: 11/9/2016 some gc for User Table??? 
	public static void onUnFollowedUser(UserInfoJson userJson) {
		if (userJson == null) return;
		User user = getByUserId(userJson.getUserId());
		if (user != null) {
			user.FollowingType = 0;
			AndroidUtil.runInBackgroundNoPanic(() -> {
				user.save();
			});
		}
	}

	public static User UserInfoJsonToUserTable(UserInfoJson userJson) {
		User u = new User();
		u.UserId = userJson.getUserId();
		u.FollowingType = userJson.FollowingType;
		u.About = userJson.About;
		u.FirstName = userJson.FirstName;
		u.LastName = userJson.LastName;
		u.FullName = userJson.FullName;
		u.AvatarUrl = userJson.AvatarUrl;

		u.PrivacyProfile = userJson.PrivacyProfile;
		u.AppVersion = 1;

		return u;
	}

	public static User UserMeViewJsonToUserTable(JV.UserMeView userJson) {
		User u = new User();
		u.UserId = userJson.UserId;
		u.FollowingType = userJson.FollowingType;
		u.About = userJson.About;
		u.FirstName = userJson.FirstName;
		u.LastName = userJson.LastName;
		u.FullName = userJson.FullName;
		u.AvatarUrl = userJson.AvatarUrl;

		u.PrivacyProfile = userJson.PrivacyProfile;
		u.AppVersion = 1;

		return u;
	}

	public static UserInfoJson UserTableToUserInfoJson(User user) {
		UserInfoJson uj = new UserInfoJson();
		uj.UserId = uj.Id = user.UserId;
		uj.FollowingType = user.FollowingType;
		uj.About = user.About;
		uj.FirstName = user.FirstName;
		uj.LastName = user.LastName;
		uj.FullName = user.FullName;
		uj.AvatarUrl = user.AvatarUrl;

		uj.PrivacyProfile = user.PrivacyProfile;
//		uj.AppVersion = 1;

		return uj;
	}

}
