package com.mardomsara.social.models.memory_store;

import com.mardomsara.social.App;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.events.RoomOrderChanged;
import com.mardomsara.social.models.tables.Room;

import java.util.List;

/**
 * Created by Hamid on 10/15/2016.
 */

public class MemoryStore_Rooms {
//	final static Map<String,Room> map = new HashMap<>();
	//TODO upgrade this collection to some java deualt class???
	static final ArrayListHashSetKey<Room,String> listRooms = new ArrayListHashSetKey<>((room)->room.RoomKey);


	public static void setAndEmit(Room room){
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



	public static void reloadForAll(){
		List<Room> list = RoomModel.getAllRoomsList(-1);
		listRooms.clear();
		listRooms.fromList(list);
		listRooms.sort();

		MemoryStore_LastMsgs.loadAutoForRoomKeys(listRooms.getKeys());
		MemoryStore_Users.loadAutoForRoomKeys(listRooms.getKeys());
	}

	public static void reloadForAllAndEmit() {
		reloadForAll();
		App.getBus().post(new RoomOrderChanged());
	}

}
