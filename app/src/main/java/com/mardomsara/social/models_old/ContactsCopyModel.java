package com.mardomsara.social.models_old;

import android.support.annotation.NonNull;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.models_old.tables.ContactsCopy;
import com.mardomsara.social.models_old.tables.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 10/3/2016.
 */
public class ContactsCopyModel {

	static Map<String,ContactsCopy> cacheMap = null;
	public static Map<String,ContactsCopy> getCacheOfContactsCopy(){
		if(cacheMap == null){
			cacheMap = new HashMap<>();
			List<ContactsCopy> list = DB.getAppDB().selectFromContactsCopy().toList();
			for (ContactsCopy row: list){
				if(row.PhoneNormalizedNumber != null && !row.PhoneNormalizedNumber.equals("")){
					cacheMap.put(row.PhoneNormalizedNumber, row);
				}
			}
		}
		return cacheMap;
	}

	public static List<ContactsCopy> getAllContactsCopy(){
		return DB.getAppDB().selectFromContactsCopy().PhoneNormalizedNumberNotEq("").toList();
	}

	@NonNull
	public static  List<ContactsCopy> getContactsNotRegisterd(List<User> usersRegisterd){
		List<String> regs = new ArrayList<>();
		regs.add("");
		for (User u: usersRegisterd){
			regs.add(u.PhoneNormalizedNumber);
		}

		return DB.getAppDB().selectFromContactsCopy().PhoneNormalizedNumberNotIn(regs).toList();
	}

}
