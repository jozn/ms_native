package com.mardomsara.social.tables;

import android.support.annotation.Nullable;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.LastMsgOfRoomsCache;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang3.math.NumberUtils;
import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

//@TableModelSpec(className = "RoomListsTable",tableName = "room_list")
//@Message
@Deprecated
@Table(name = "rooms_list",database = AppDB.class)
public class RoomsListTable  extends BaseModel {

    @PrimaryKey
    public String RoomKey;

    @Column(defaultValue = "1")
    public int RoomTypeId=1;

    @Column(defaultValue = "\"\"")
    public String RoomName;//???????

    @Column(defaultValue = "0")
    public int UseCustomRoomSettings;

    @Column(defaultValue = "0")
    public long LastRoomOpenedTimeMs;

    @Column(defaultValue = "0")
    public int UnseenMessageCount;

    @Column(defaultValue = "\"\"")
    public String LastSeenMessageKey;

    @Column(defaultValue = "\"\"")
    public String MessageDraftText;

    @Column(defaultValue = "0")
    public long UpdatedMs;

    @Column(defaultValue = "0")
    public long CreatedMs;

    @Column(defaultValue = "0")
    public long SortTimeMs;

    //DEPRECATED
//    @Column(defaultValue = "10")
//    public int LastMessageType=10;
//
//    @Column(defaultValue = "\"\"")
//    public String LastMessageText;
//
//    @Column(defaultValue = "0")
//    public int LastMessageDeliveryStatus;
//
//    @Column(defaultValue = "0")
//    public int UpdatedTimestampMs;
//
//    @Column(defaultValue = "0")
//    public int CreatedTimestamp;


    ////////////////////// No Sqlite //////////////////

    public UsersTable User;

    public int getUserId(){
        //todo add support for groups
        if(getRoomTypeId() == 1 && false ) return 0;
        Integer id =NumberUtils.createInteger(getRoomKey().substring(1));
        return id;
    }

    public UsersTable loadAndGetUser(){
        User = UsersTable.getByUserId(getUserId());
        return User;
    }

    public String getRoomName() {
        if(User != null){
            return User.getFullName();
        }
        return "RoomName";
    }

    public String getRoomAvatarUrl(){
        if(User != null){
            return User.getAvatarUrl();
        }
        return "public/avatars/no.jpg";
    }

    //////////////////////// Static /////////////////////////

    public static RoomsListTable getRoomByRoomKey(String roomKey){
        RoomsListTable room =SQLite.select().from(RoomsListTable.class)
                .where(RoomsListTable_Table.RoomKey.eq(roomKey)).querySingle();
        return room;
    }

    @Nullable
    public static RoomsListTable getRoomByRoomKeyAndLoadUser(String roomKey){
        RoomsListTable room =SQLite.select().from(RoomsListTable.class)
                .where(RoomsListTable_Table.RoomKey.eq(roomKey)).querySingle();
        if(room == null) {
            room = new RoomsListTable();
            room.setRoomKey(roomKey);
        };
        room.loadAndGetUser();
        return room;
    }

    public static void onRoomOpened(RoomsListTable room){
        room.setLastRoomOpenedTimeMs(TimeUtil.getTimeMs());
        room.setUnseenMessageCount(0);
        room.save();
        RoomInfoChangedEvent event = new RoomInfoChangedEvent();
        event.RoomKey = room.getRoomKey();
        EventBus.getDefault().post(event);
    }

    public static void onRecivedNewMsg(MessagesTable msg){
        RoomsListTable room = getRoomByRoomKey(msg.getRoomKey());
        if(room == null){
            room = new RoomsListTable();
            room.setRoomKey(msg.getRoomKey());
            room.setRoomTypeId(1);//todo: extarct from here
            room.setCreatedMs(TimeUtil.getTimeMs());
        }
        room.setUnseenMessageCount(room.getUnseenMessageCount()+1);
        room.setUpdatedMs(msg.getCreatedMs());//this one we show to user
        room.setSortTimeMs(TimeUtil.getTimeMs());//just for sorting needs accurte user own device
        room.save();
    }

    public static List<RoomsListTable> getAllRoomsList(int page) {
//        List<RoomsListTable> roomsRes = new ArrayList<>();
        List<RoomsListTable> rooms =SQLite.select().from(RoomsListTable.class)
                .orderBy(RoomsListTable_Table.UpdatedMs,false)
                .queryList();
        loadAllUserForRooms(rooms);
        LastMsgOfRoomsCache.getInstance().setForRooms(rooms);
        return rooms;
    }

    public static void loadAllUserForRooms(List<RoomsListTable> rooms) {
        int[] in  = new int[rooms.size()];
        int i =0;
        for (RoomsListTable room : rooms){
            in[i] = room.getUserId();
            i++;
        }
        List<UsersTable> users =  SQLite.select().from(UsersTable.class)
                .where(UsersTable_Table.UserId.in(-1,in))
                .queryList();

        Map<Integer,UsersTable> usersMap = LangUtil.listToHashMap(users,(u)->u.getUserId());
        for (RoomsListTable room : rooms){
            room.User = usersMap.get(room.getUserId());
        }
    }

    public static List<RoomsListTable> getAllRoomsList__DEP(int page) {
        List<RoomsListTable> rooms =SQLite.select().from(RoomsListTable.class)
                .orderBy(RoomsListTable_Table.UpdatedMs,false)
                .queryList();
        for(RoomsListTable room: rooms){
            room.loadAndGetUser();
        }
        return rooms;
    }

    public static void goToUserChatEntery(int UserId){
        RoomsListTable room = RoomsListTable.getRoomByRoomKeyAndLoadUser("u"+UserId);
        Nav.push(Router.getRoomEntery(room));
    }

    public static void deleteRoom(String roomKey){
        RoomsListTable room = getRoomByRoomKey(roomKey);
        if(room != null){
            room.delete();
        }
        MessagesModel.clearAllMessagesOfRoom(roomKey);

    }


        ////////////////////////////////////////////////

    public String getRoomKey() {
        return RoomKey;
    }

    public void setRoomKey(String roomKey) {
        RoomKey = roomKey;
    }

    public int getRoomTypeId() {
        return RoomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        RoomTypeId = roomTypeId;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public int getUseCustomRoomSettings() {
        return UseCustomRoomSettings;
    }

    public void setUseCustomRoomSettings(int useCustomRoomSettings) {
        UseCustomRoomSettings = useCustomRoomSettings;
    }


    public long getLastRoomOpenedTimeMs() {
        return LastRoomOpenedTimeMs;
    }

    public void setLastRoomOpenedTimeMs(long lastRoomOpenedTimeMs) {
        LastRoomOpenedTimeMs = lastRoomOpenedTimeMs;
    }

    public int getUnseenMessageCount() {
        return UnseenMessageCount;
    }

    public void setUnseenMessageCount(int unseenMessageCount) {
        UnseenMessageCount = unseenMessageCount;
    }

    public String getLastSeenMessageKey() {
        return LastSeenMessageKey;
    }

    public void setLastSeenMessageKey(String lastSeenMessageKey) {
        LastSeenMessageKey = lastSeenMessageKey;
    }

    public String getMessageDraftText() {
        return MessageDraftText;
    }

    public void setMessageDraftText(String messageDraftText) {
        MessageDraftText = messageDraftText;
    }


    public long getUpdatedMs() {
        return UpdatedMs;
    }

    public void setUpdatedMs(long updatedMs) {
        UpdatedMs = updatedMs;
    }

    public long getCreatedMs() {
        return CreatedMs;
    }

    public void setCreatedMs(long createdMs) {
        CreatedMs = createdMs;
    }

    public long getSortTimeMs() {
        return SortTimeMs;
    }

    public void setSortTimeMs(long sortTimeMs) {
        SortTimeMs = sortTimeMs;
    }
}
//    public String AvatarUrl;
//    public String AvatarPath;
//    public int CreatedTimestampMS;
//    public int OnlineStatusId;
//    public int OnlineStatus;
//    public int LastVisitedTimestamp;
//    public int RoomType;

//public static void onRecivedNewMsg(MessagesTable msg){
//    RoomsListTable room = getRoomByRoomKey(msg.getRoomKey());
//    if(room == null){
//        room = new RoomsListTable();
//        room.setRoomKey(msg.getRoomKey());
//        room.setRoomTypeId(1);//todo: extarct from here
//    }
//    room.setUpdatedMs(AppUtil.getTimeMs());
//    room.setLastMessageText(msg.getText());
//    room.setLastMessageType(msg.getMessageTypeId());
//    room.setUnseenMessageCount(room.getUnseenMessageCount()+1);
//
//    room.save();
//}


