package com.mardomsara.social.models;


import android.util.LruCache;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models.tables.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 6/20/2017.
 */

public class CacheBank {

	private static LruCache<String, Room> room = new LruCache<>(200);
	private static LruCache<String, Message> message = new LruCache<>(200);
	private static LruCache<String, MsgFile> msgFile = new LruCache<>(200);
	private static LruCache<Integer, User> user = new LruCache<>(200);


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
			getUser().put(user.UserId , user);
		}
	}
}
