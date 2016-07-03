package com.mardomsara.social.models;

import android.support.annotation.Nullable;
import android.util.Log;

import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.MessagesTable_Table;
import com.mardomsara.social.tables.RoomsListTable;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 5/31/2016.
 */
public class LastMsgOfRoomsCache {
    private static LastMsgOfRoomsCache _instance;
    private Map<String,MessagesTable> _map = new HashMap<>();

    public static LastMsgOfRoomsCache getInstance(){
        if(_instance == null){
            _instance = new LastMsgOfRoomsCache();
        }
        return _instance;
    }

    public LastMsgOfRoomsCache() {
        EventBus.getDefault().register(this);
    }

    public void setForRoom(RoomsListTable room, MessagesTable msg){
        _map.put(room.getRoomKey(),msg);
    }

    public void removeForRoom(String roomKey){
        _map.put(roomKey,null);
    }

    public void setForRoom(String roomkey, MessagesTable msg){
        _map.put(roomkey,msg);
    }

    public void setForRooms(List<RoomsListTable> rooms){
       List<String> roomKeys = new ArrayList();
       for(RoomsListTable r : rooms){
           roomKeys.add(r.getRoomKey());
       }

        List<MessagesTable> msgs = SQLite.select().from(MessagesTable.class)
                .where(MessagesTable_Table.RoomKey.in(roomKeys))
                .groupBy(MessagesTable_Table.RoomKey)
                .orderBy(MessagesTable_Table.CreatedMs,false)
                .queryList();
        for (MessagesTable msg : msgs){
            setForRoom(msg.getRoomKey(),msg);
        }
    }

    public @Nullable MessagesTable getForRoom(RoomsListTable room){
        return _map.get(room.getRoomKey());
    }

    public boolean isThisLastMsgOfRoom(String msgKey ,RoomsListTable room){
        return msgKey.equals(_map.get(room.getRoomKey()).getMessageKey());
    }

    @Subscribe
    public void onEvent(MessagesTable msg){
        logIt("event new msg: " + msg.toString());
        setForRoom(msg.getRoomKey(),msg);
    }

    @Subscribe
    public void onEvent(MessageSyncMeta mete){
        logIt("event meta: " + mete.toString());
    }

    @Subscribe
    public void onEvent(MsgsSyncMetaReceivedToServer mete){
        logIt("event meta: " + mete.toString());

    }

    @Subscribe
    public void onEvent(MsgsSyncMetaReceivedToPeer mete){
        logIt("event meta: " + mete.toString());

    }

    @Subscribe
    public void onEvent(MsgsSyncMetaDeletedFromServer mete){
        logIt("event meta: " + mete.toString());

    }

    @Subscribe
    public void onEvent(MsgsSyncMetaSeenByPeer mete){
        logIt("event meta: " + mete.toString());

    }


    protected void logIt(String str) {
        Log.d(" "+ this.getClass().getSimpleName() ," "+ str);
    }

    public void onNewMsg(MessagesTable msg) {}
    //?????
    public void onNewMsgRemote(MessagesTable msg) {}

    //Deperected
    public void onMsgRevivedToServer(MessageSyncMeta msg) {}
    public void onMsgRevivedToPeer(MessageSyncMeta msg) {}
    public void onMsgSeenByPeer(MessageSyncMeta msg) {}
    public void onMsgDeletedFromServer(MessageSyncMeta msg) {}

}
