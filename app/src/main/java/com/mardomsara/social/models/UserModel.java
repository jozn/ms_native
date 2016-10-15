package com.mardomsara.social.models;

import android.support.annotation.Nullable;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AppUtil;
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
    public static void create(User user){
        DB.db.insertIntoUser(user);
    }

    @Nullable
    public static User getByUserId(int id){
        User user = DB.db.selectFromUser().UserIdEq(id).getOrNull(0);
		MemoryStore_Users.set(user);
        return DB.db.selectFromUser().UserIdEq(id).getOrNull(0);
    }

    /////////////////////////////

	public static void saveNewUser(User user) {
		AppUtil.log("saveNewUser()");
//		AndroidUtil.runInBackgroundNoPanic(()->{
			if(user == null)return;
			Map<String,ContactsCopy> map= ContactsCopyModel.getCacheOfContactsCopy();
			String phone = user.Phone;
			if( ! user.PhoneNormalizedNumber.equals("")){
				phone=user.PhoneNormalizedNumber;
			}
			if(map.containsKey(phone)){
				ContactsCopy cc = map.get(phone);
				user.PhoneContactRowId = cc.PhoneContactRowId;
				user.PhoneDisplayName = cc.PhoneDisplayName;
				user.PhoneNumber = cc.PhoneNumber;
				user.PhoneNormalizedNumber = phone;
			}
			user.save();
//		});
	}

    public static List<User> getAllFollowings() {
        return DB.db.selectFromUser().FollowingTypeEq(1).toList();
    }

    public static List<User> getAllRegisteredContacts() {
        return DB.db.selectFromUser().IsPhoneContactEq(1).or().PhoneNormalizedNumberNotEq("").toList();
    }

}
