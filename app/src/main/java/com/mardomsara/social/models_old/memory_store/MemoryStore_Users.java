package com.mardomsara.social.models_old.memory_store;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.models_old.tables.Room;
import com.mardomsara.social.models_old.tables.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 10/15/2016.
 */

@Deprecated //use CacheBank
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

	public static void loadAutoForRoomKeys(Iterable<String> roomKeys){
		if(roomKeys == null /*|| roomKeys.size() ==0*/)return;
		List<Integer> ints = new ArrayList<>();

		for(String key : roomKeys) {
			ints.add(Room.roomKeyToPeerId(key));
		}

		List<User> users = DB.getAppDB().selectFromUser().UserIdIn(ints).toList();

		for (User user : users){
			set(user);
		}
	}


}
