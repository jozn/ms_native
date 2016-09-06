package com.mardomsara.social.models;

import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models.tables.Room_Schema;
import com.mardomsara.social.models.tables.Room_Updater;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.RoomsListTable_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Hamid on 9/5/2016.
 */
public class RoomModel {

    //////////////////// CRUD ////////////////////
    public static void update(Room room) {
        DB.updateAuto(room, Room_Schema.INSTANCE);
    }

    public static void updateOrInsert(Room room) {
        DB.db.prepareInsertIntoRoom(OnConflict.REPLACE,false).execute(room);
    }

    //FIXME :getsingle row? how to
    public static Room getRoomByRoomKey(String roomKey){
        return DB.db.selectFromRoom().RoomKeyEq(roomKey).getOrNull(0);
     /*   RoomsListTable room = SQLite.select().from(RoomsListTable.class)
                .where(RoomsListTable_Table.RoomKey.eq(roomKey)).querySingle();
        return room;*/
    }

    @Nullable
    public static Room getRoomByRoomKeyAndLoadUser(String roomKey){
        Room room =  getRoomByRoomKey(roomKey);



//        DB.db.selectFromRoom().RoomKeyEq(roomKey).execute();
//        Room_Schema.INSTANCE.newModelFromCursor(DB.db.getConnection(),)
//        RoomsListTable room =SQLite.select().from(RoomsListTable.class)
//                .where(RoomsListTable_Table.RoomKey.eq(roomKey)).querySingle();
//        if(room == null) {
//            room = new RoomsListTable();
//            room.setRoomKey(roomKey);
//        };
//        room.loadAndGetUser();
        return room;
    }



    public static void onRoomOpened(Room room){
        room.LastRoomOpenedTimeMs = TimeUtil.getTimeMs();
        room.UnseenMessageCount = 0;
        update(room);
        RoomInfoChangedEvent event = new RoomInfoChangedEvent();
        event.RoomKey = room.RoomKey;
        EventBus.getDefault().post(event);
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
        msg.getClass().getAnnotation(Column.class).value();
    }

    public static List<Room> getAllRoomsList(int page) {
        List<Room> rooms = DB.db.selectFromRoom().orderBySortTimeMsDesc().toList();
//        List<RoomsListTable> roomsRes = new ArrayList<>();

        loadAllUserForRooms(rooms);
        //FIXME
//        LastMsgOfRoomsCache.getInstance().setForRooms(rooms);
        return rooms;
    }

    //// TODO: 9/6/2016 implement this
    public static void loadAllUserForRooms(List<Room> rooms) {
        /*int[] in  = new int[rooms.size()];
        int i =0;
        for (Room room : rooms){
            in[i] = room.UserId;
            i++;
        }
        List<UsersTable> users =  SQLite.select().from(UsersTable.class)
                .where(UsersTable_Table.UserId.in(-1,in))
                .queryList();

        Map<Integer,UsersTable> usersMap = LangUtil.listToHashMap(users,(u)->u.getUserId());
        for (RoomsListTable room : rooms){
            room.User = usersMap.get(room.getUserId());
        }*/
    }

    //FIXME
    public static void deleteRoom(String roomKey){
        Room room = getRoomByRoomKey(roomKey);
        if(room != null){
            DB.db.deleteFromRoom().RoomKeyEq(room.RoomKey).execute();
        }
        //MessagesModel.clearAllMessagesOfRoom(roomKey);

    }


}
