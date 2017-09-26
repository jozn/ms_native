package com.mardomsara.social.models_old;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.OnConflict;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.app.Events;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models_old.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models_old.memory_store.MemoryStore_Rooms;
import com.mardomsara.social.models_old.flusher.MsgsCallToServer;
import com.mardomsara.social.models_old.tables.Message;
import com.mardomsara.social.models_old.tables.MsgSeen;
import com.mardomsara.social.models_old.tables.Room;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.models_old.tables.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 9/5/2016.
 */
public class RoomModel {

    //////////////////// CRUD ////////////////////
    public static void updateOrInsert(Room room) {
        DB.getAppDB().prepareInsertIntoRoom(OnConflict.REPLACE,true).execute(room);
    }

    @Nullable
    public static Room getRoomByRoomKey(@NonNull String roomKey){
        return DB.getAppDB().selectFromRoom().RoomKeyEq(roomKey).getOrNull(0);
    }

	public static List<Room> loadListOfRoomByRoomKeys(List<String> roomKeys){
		List<Room> rooms = DB.getAppDB().selectFromRoom().RoomKeyIn(roomKeys).toList();
		for (Room r : rooms){
			CacheBank.getRoom().put(r.RoomKey,r);
		}
		return rooms;
	}



	@Nullable
	public static Room getRoomByForUserAndLoadUser(int peerUserId){
		String roomKey = roomKeyForPeerUserId(peerUserId);
		Room room =  getRoomByRoomKey(roomKey);

		if(room == null) {
			room = new Room();
			room.RoomKey = roomKey;
			room.RoomTypeId = 1;//todo: extarct from here
			room.CreatedMs = TimeUtil.getTimeMs();
		}

		room.loadAndGetUser();
		return room;
	}

	public static void onRoomOpened_InBackground(Room room){
        room.LastRoomOpenedTimeMs = TimeUtil.getTimeMs();
        room.UnseenMessageCount = 0;
        AndroidUtil.runInBackgroundNoPanic(()->{
			//just if we actuly has message in the room, not just opening the room
			if(DB.getAppDB().selectFromMessage().RoomKeyEq(room.RoomKey).count() > 0 ){
				updateOrInsert(room);
				/*RoomInfoChangedEvent event = new RoomInfoChangedEvent();
				event.RoomKey = room.RoomKey;
				EventBus.getDefault().post(event);*/
				Events.publish(new Events.RoomInfoChangedEvent(room.RoomKey));
			}
        });
    }

	private static int countUnseenMsgsForRoom(String RoomKey, long LastSeenTimeMs ){
		int count = DB.getAppDB().relationOfMessage()
			.RoomKeyEq(RoomKey)
			.NanoIdGe(LastSeenTimeMs*1000000)
			.IsByMeEq(0)
			.ISeenTimeEq(0)
			.count();
		return count;
	}

	public static Room onReceivedNewMsg_NotSave(@NonNull Message msg, Room roomMem){
		if(roomMem == null){
			roomMem = getRoomByRoomKey(msg.RoomKey);
		}
		if(roomMem == null){
			roomMem = new Room();
			roomMem.RoomKey = msg.RoomKey;
			roomMem.RoomTypeId = 1;//todo: extarct from here
			roomMem.CreatedMs = TimeUtil.getTimeMs();
		}

		int count = countUnseenMsgsForRoom(msg.RoomKey,roomMem.LastSeenTimeMs);
		roomMem.UnseenMessageCount = count;

		roomMem.UpdatedMs = msg.CreatedMs;//this one we show to user
		roomMem.SortTimeMs = TimeUtil.getTimeMs();//just for sorting needs accurte user own device
		return roomMem;
	}

	public static void massUpdateOfRoomsForNewMsgs(Collection<Message> LastMsgs){
		List<Room> rooms = new ArrayList<>();
		for(Message msg: LastMsgs){
			Room room = onReceivedNewMsg_NotSave(msg,null);
			rooms.add(room);
		}
		DB.getAppDB().transactionSync(()->{
			for(Room room: rooms){
				room.save();
			}
		});

		MemoryStore_Rooms.reloadForAllAndEmit();
	}

    public static void onByMeNewMsg(@NonNull Message msg){
        Room room = getRoomByRoomKey(msg.RoomKey);
        if(room == null){
            room = new Room();
            room.RoomKey = msg.RoomKey;
            room.RoomTypeId = 1;//todo: extarct from here
            room.CreatedMs = TimeUtil.getTimeMs();
        }
//        room.UnseenMessageCount = room.UnseenMessageCount +1;
        room.UpdatedMs = msg.CreatedMs;//this one we show to user
        room.SortTimeMs = TimeUtil.getTimeMs();//just for sorting needs accurte user own device
        updateOrInsert(room);
		MemoryStore_Rooms.sort();
    }

    public static List<Room> getAllRoomsList(int page) {
        List<Room> rooms = DB.getAppDB().selectFromRoom().orderBySortTimeMsDesc().toList();
        loadAllUserForRooms(rooms);
		MemoryStore_LastMsgs.setAutoForRoom(rooms);
        return rooms;
    }

    private static void loadAllUserForRooms(List<Room> rooms) {

        List<Integer> in  = new ArrayList<>();
        for (Room room : rooms){
            in.add(room.getUserId());
        }
		if(in.size() == 0)return;
        List<User> users = DB.getAppDB().selectFromUser().UserIdIn(in).toList();
        Map<Integer,User> usersMap = LangUtil.listToHashMap(users,(u)->u.UserId);
        for (Room room : rooms) {
            room.User = usersMap.get(room.getUserId());
        }
    }

    public static void deleteRoom(String roomKey){
        Room room = getRoomByRoomKey(roomKey);
        if(room != null){
            clearRoomMsgs(room);
            DB.getAppDB().deleteFromRoom().RoomKeyEq(room.RoomKey).execute();
        }
        //???for safety if room somehow doesn't exit
        MessageModel.clearAllMessagesOfRoom_BG(roomKey);
    }

    public static void clearRoomMsgs(Room room){
        MessageModel.clearAllMessagesOfRoom_BG(room.RoomKey);
		MemoryStore_LastMsgs.removeForRoom(room.RoomKey);
        room.UnseenMessageCount = 0;
        room.saveAndEmit();
    }

	public static void updateRoomSeenMsgsToNow_BG(Room room){
		long now = TimeUtil.getTimeSec();
		long nowMs = TimeUtil.getTimeMs();
		long nowNano = TimeUtil.getTimeNano();
		long lastNano = TimeUtil.getTimeNano();

		AndroidUtil.runInBackgroundNoPanic(()->{
			List<Message> msgs = DB.getAppDB().selectFromMessage()
				.RoomKeyEq(room.RoomKey)
				.ISeenTimeEq(0)
				.IsByMeEq(0)
				.NanoIdGe(room.LastSeenTimeMs*1000000)
				.toList();

			if(msgs == null || msgs.size() == 0) return;

			List<MsgSeen> msgsSeen = new ArrayList<MsgSeen>(msgs.size());
			for (Message msg: msgs){
				MsgSeen mseen = new MsgSeen();
				mseen.MsgKey = msg.MessageKey;
				mseen.RoomKey = msg.RoomKey;
				mseen.ToUserId = (int) msg.UserId;
				msgsSeen.add(mseen);
			}

			DB.getAppDB().transactionSync(()->{
				DB.getAppDB().updateMessage()
					.ISeenTime(now)//onDownloadProgress
					.RoomKeyEq(room.RoomKey)//where
					.ISeenTimeEq(0)
					.NanoIdGt(room.LastSeenTimeMs*1000000)
					.execute()
				;

				room.LastSeenTimeMs = nowMs;
				room.saveAndEmit();

				for (MsgSeen seen: msgsSeen){
					seen.save();
				}
			});

			MsgsCallToServer.sendSeenMsgs(msgsSeen);

		});
	}

	private static String roomKeyForPeerUserId(int PeerUserId){
		int me = Session.getUserId();
		if(me < PeerUserId){
			return "p"+me+"_"+PeerUserId;
		}

		return "p"+PeerUserId+"_"+me;
	}


	////////////////////////////// New api - after PB///////////////
	public static void onNewMsgsRecivedForRooms(Iterable<String> roomKeys){
//		List<Room> rooms =  DB.db.selectFromRoom().RoomKeyIn(roomKeys).orderByCreatedMsAsc();
//		DB.db.selectFromRoom()
//		List<Room> rooms = new ArrayList<>();
		/*for(Message msg: LastMsgs){
			Room room = onReceivedNewMsg_NotSave(msg,null);
			rooms.add(room);
		}
		DB.db.transactionSync(()->{
			for(Room room: rooms){
				room.save();
			}
		});*/

		Map<String, Room> roomsMap = CacheBank.getOrLoadRoomsMapByRoomKeys(roomKeys);

		for (String rk: roomKeys){
			Room roomMem = roomsMap.get(rk);
			Message lastMsg  = MemoryStore_LastMsgs.getForRoom(rk);
			if(roomMem == null){//create new room
				roomMem = new Room();
				roomMem.RoomKey = rk;
				roomMem.RoomTypeId = 1;//todo: extarct from here
				if(lastMsg != null){
					roomMem.CreatedMs = lastMsg.CreatedMs; //must be last msg not
				}
				roomsMap.put(rk,roomMem);
			}

			if(lastMsg != null){
				roomMem.SortTimeMs = lastMsg.CreatedMs; //must be last msg not
				roomMem.UpdatedMs = lastMsg.CreatedMs; //must be last msg not
			}else {//???
				roomMem.UpdatedMs = TimeUtil.getTimeMs();//this one we show to user
			}
			roomMem.UnseenMessageCount = countUnseenMsgsForRoom(rk,roomMem.LastSeenTimeMs);
		}

		DB.getAppDB().transactionSync(()->{
			roomsMap.values().forEach(Room::save);
		});
	}



}
