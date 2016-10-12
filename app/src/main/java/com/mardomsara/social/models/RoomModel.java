package com.mardomsara.social.models;

import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.OnConflict;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models.tables.Room_Schema;
import com.mardomsara.social.models.tables.User;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 9/5/2016.
 */
public class RoomModel {

    //////////////////// CRUD ////////////////////
    public static void update(Room room) {
//        DB.updateAuto(room, Room_Schema.INSTANCE);
		DB.db.prepareInsertIntoRoom(OnConflict.REPLACE,true).execute(room);
    }

    public static void updateOrInsert(Room room) {
        DB.db.prepareInsertIntoRoom(OnConflict.REPLACE,true).execute(room);
    }

    @Nullable
    public static Room getRoomByRoomKey(String roomKey){
        return DB.db.selectFromRoom().RoomKeyEq(roomKey).getOrNull(0);
     /*   RoomsListTable room = SQLite.select().from(RoomsListTable.class)
                .where(RoomsListTable_Table.RoomKey.eq(roomKey)).querySingle();
        return room;*/
    }

    @Nullable
    public static Room getRoomByRoomKeyAndLoadUser(String roomKey){
        Room room =  getRoomByRoomKey(roomKey);

//        if(room == null){
//            return null;
//        }
        if(room == null) {
            room = new Room();
            room.RoomKey = (roomKey);
        }

        room.loadAndGetUser();
        return room;
    }


    public static void onRoomOpenedInBackground(Room room){
        room.LastRoomOpenedTimeMs = TimeUtil.getTimeMs();
        room.UnseenMessageCount = 0;
        AndroidUtil.runInBackgroundNoPanic(()->{
            update(room);
            RoomInfoChangedEvent event = new RoomInfoChangedEvent();
            event.RoomKey = room.RoomKey;
            EventBus.getDefault().post(event);
        });

    }

    public static void onRecivedNewMsg(Message msg){
        Room room = getRoomByRoomKey(msg.RoomKey);
        if(room == null){
            room = new Room();
            room.RoomKey = msg.RoomKey;
            room.RoomTypeId = 1;//todo: extarct from here
            room.CreatedMs = TimeUtil.getTimeMs();
        }
        room.UnseenMessageCount = room.UnseenMessageCount +1;
        room.UpdatedMs = msg.CreatedMs;//this one we show to user
        room.SortTimeMs = TimeUtil.getTimeMs();//just for sorting needs accurte user own device
        updateOrInsert(room);
//        room.save();
//        msg.getClass().getAnnotation(Column.class).value();
    }

	public static void messageHasInsertIntoRoomUpdateRoomInfo(Message msg){
		Room room = getRoomByRoomKey(msg.RoomKey);
		if(room == null){
			room = new Room();
			room.RoomKey = msg.RoomKey;
			room.RoomTypeId = 1;//todo: extarct from here
			room.CreatedMs = TimeUtil.getTimeMs();
		}
		int count = DB.db.relationOfMessage().RoomKeyEq(msg.RoomKey).AmISeenEq(0).count();
		room.UnseenMessageCount = count;
		room.UpdatedMs = msg.CreatedMs;//this one we show to user
		room.SortTimeMs = TimeUtil.getTimeMs();//just for sorting needs accurte user own device
		updateOrInsert(room);
//        room.save();
//        msg.getClass().getAnnotation(Column.class).value();
	}

    //todo mereg with above func
    public static void onHereNewMsg(Message msg){
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
    }

    public static List<Room> getAllRoomsList(int page) {
        List<Room> rooms = DB.db.selectFromRoom().orderBySortTimeMsDesc().toList();
//        List<RoomsListTable> roomsRes = new ArrayList<>();

        loadAllUserForRooms(rooms);
        LastMsgOfRoomsCache2.getInstance().setForRooms(rooms);
        return rooms;
    }

    public static void loadAllUserForRooms(List<Room> rooms) {

        List<Integer> in  = new ArrayList<>();
        for (Room room : rooms){
            in.add(room.getUserId());
        }
        List<User> users = DB.db.selectFromUser().UserIdIn(in).toList();
        Map<Integer,User> usersMap = LangUtil.listToHashMap(users,(u)->u.UserId);
        for (Room room : rooms) {
            room.User = usersMap.get(room.getUserId());
        }
    }

    public static void deleteRoom(String roomKey){
        Room room = getRoomByRoomKey(roomKey);
        if(room != null){
            clearRoomMsgs(room);
            DB.db.deleteFromRoom().RoomKeyEq(room.RoomKey).execute();
        }
        //???for safety if room somehow dosent exit
        MessageModel.clearAllMessagesOfRoom(roomKey);
    }

    public static void clearRoomMsgs(Room room){
        MessageModel.clearAllMessagesOfRoom(room.RoomKey);
        LastMsgOfRoomsCache2.getInstance().removeForRoom(room.RoomKey);
        room.UnseenMessageCount = 0;
        room.save();
    }

    ///////////////////////////////////////
    public static void sendRoomInfoChangedEvent(String roomKey){

    }



}
