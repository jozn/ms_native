package com.mardomsara.social.models.memory_store;

import com.mardomsara.social.App;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.events.RoomOrderChanged;
import com.mardomsara.social.models.tables.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 10/15/2016.
 */

public class MemoryStore_Rooms {
//	final static Map<String,Room> map = new HashMap<>();
	final static ArrayListHashSetKey<Room,String> listRooms = new ArrayListHashSetKey<>((room)->room.RoomKey);


	public static void set(Room room){
		if(room == null || room.RoomKey == null || room.RoomKey.equals(""))return;
		synchronized (listRooms){
			listRooms.setOrReplace(0,room);
			listRooms.sort();
		}
		App.getBus().post(new RoomOrderChanged());
	}

	public static void sort(){
		synchronized (listRooms){
			listRooms.sort();
		}
	}

	public static Room getOrNull(String roomKey){
		synchronized (listRooms){
			return listRooms.getByKey(roomKey);
		}
	}

	public static ArrayListHashSetKey<Room,String> getListRooms(){
		return listRooms;
	}


}
