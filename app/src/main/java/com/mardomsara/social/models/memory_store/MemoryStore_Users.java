package com.mardomsara.social.models.memory_store;

import com.mardomsara.social.models.tables.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 10/15/2016.
 */

public class MemoryStore_Users {
	final static Map<Integer,User> map = new HashMap<>();

	public static void set(User user){
		if(user == null || user.UserId == 0)return;
		synchronized (map){
			map.put(user.UserId ,user);
		}
	}

	public static User getOrNull(int userId){
		synchronized (map){
			return map.get(userId);
		}
	}


}
