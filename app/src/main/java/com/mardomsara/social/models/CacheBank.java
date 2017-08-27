package com.mardomsara.social.models;


import android.support.annotation.NonNull;
import android.util.LruCache;

import com.mardomsara.social.app.DB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 6/20/2017.
 */

public class CacheBank {

	private static final LruCache<String, Room> room = new LruCache<>(200);
	private static final LruCache<String, Message> message = new LruCache<>(200);
	private static final LruCache<String, MsgFile> msgFile = new LruCache<>(200);
	private static final LruCache<Integer, User> user = new LruCache<>(200);


	public static LruCache<String, Room> getRoom() {
		return room;
	}

	public static LruCache<String, Message> getMessage() {
		return message;
	}

	public static LruCache<String, MsgFile> getMsgFile() {
		return msgFile;
	}

	public static LruCache<Integer, User> getUser() {
		return user;
	}

	////////////////////////////////////////////


	public static void loadUsersAutoForRoomKeys(Iterable<String> roomKeys) {
		if (roomKeys == null /*|| roomKeys.size() ==0*/) return;
		List<Integer> ints = new ArrayList<>();

		for (String key : roomKeys) {
			ints.add(Room.roomKeyToPeerId(key));
		}
		if (ints.size() == 0) return;

		List<User> users = DB.db.selectFromUser().UserIdIn(ints).toList();

		for (User user : users) {
			getUser().put(user.UserId, user);
		}
	}

	public static List<Room> getOrLoadRoomsByRoomKeys(@NonNull Iterable<String> roomKeys) {
		List<Integer> ints = new ArrayList<>();

		List<Room> rooms = new ArrayList<>();
		List<String> roomsKeysToLoad = new ArrayList<>();

		for (String key : roomKeys) {
			Room r = getRoom().get(key);
			if (r != null) {
				rooms.add(r);
			} else {
				roomsKeysToLoad.add(key);
			}
		}

		if (roomsKeysToLoad.size() > 0) {
			rooms.addAll(RoomModel.loadListOfRoomByRoomKeys(roomsKeysToLoad));
		}

		Collections.sort(rooms);

		return rooms;
	}

	//load from cache or DB and merge them
	public static Map<String, Room> getOrLoadRoomsMapByRoomKeys(@NonNull Iterable<String> roomKeys) {
		List<Room> rooms = getOrLoadRoomsByRoomKeys(roomKeys);
		Map<String, Room> map = new HashMap<>();
		for (Room r : rooms) {
			map.put(r.RoomKey, r);
		}

		return map;
	}


}
