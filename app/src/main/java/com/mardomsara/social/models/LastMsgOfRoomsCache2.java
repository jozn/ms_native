package com.mardomsara.social.models;

import android.support.annotation.Nullable;
import android.util.Log;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddOneJson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hamid on 5/31/2016.
 */
public class LastMsgOfRoomsCache2 {
    private static LastMsgOfRoomsCache2 _instance;
    private Map<String,Message> _map = new HashMap<>();

    public static LastMsgOfRoomsCache2 getInstance(){
        if(_instance == null){
            _instance = new LastMsgOfRoomsCache2();
        }
        return _instance;
    }

    public LastMsgOfRoomsCache2() {
        EventBus.getDefault().register(this);
    }

    public void setForRoom(Room room, Message msg){
        _map.put(room.RoomKey,msg);
    }

    public void removeForRoom(String roomKey){
        _map.put(roomKey,null);
    }

    public void setForRoom(String roomkey, Message msg){
		if(roomkey == null || roomkey.equals("") || msg == null) return;
        _map.put(roomkey,msg);
    }

    public void setForRooms(List<Room> rooms){
       List<String> roomKeys = new ArrayList();
       for(Room r : rooms){
           roomKeys.add(r.RoomKey);
       }
        List<Message> msgs = DB.db.selectFromMessage().RoomKeyIn(roomKeys).toList();
        for (Message msg : msgs){
            setForRoom(msg.RoomKey,msg);
        }
    }

	public void setForRooms(ArrayListHashSetKey<Room,String> rooms){
//		List<String> roomKeys = new ArrayList();
//		for(Room r : rooms){
//			roomKeys.add(r.RoomKey);
//		}
		Set<String> roomKeys = rooms.getKeys();
		List<Message> msgs = DB.db.selectFromMessage().RoomKeyIn(roomKeys).toList();
		for (Message msg : msgs){
			setForRoom(msg.RoomKey,msg);
		}
	}

    public @Nullable Message getForRoom(Room room){
		if(room == null)return null;
        return _map.get(room.RoomKey);
    }

    public boolean isThisLastMsgOfRoom(String msgKey ,Room room){
        return msgKey.equals(_map.get(room.RoomKey).MessageKey);
    }


	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgAddOneJson data){
		logIt("event new: MsgAddOneJson " + data.toString());
		Message msg = data.Message;
		setForRoom(msg.RoomKey,msg);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgAddManyJson data){
		logIt("event new: MsgAddManyJson " + data.toString());
		List<Message> msgs = data.Messages;
		for(Message msg : msgs){
			setForRoom(msg.RoomKey,msg);
		}
	}


	@Subscribe
    public void onEvent(Message msg){
        logIt("event new msg: " + msg.toString());
        setForRoom(msg.RoomKey,msg);
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

    public void onNewMsg(Message msg) {}
    //?????
    public void onNewMsgRemote(Message msg) {}

    //Deperected
    public void onMsgRevivedToServer(MessageSyncMeta msg) {}
    public void onMsgRevivedToPeer(MessageSyncMeta msg) {}
    public void onMsgSeenByPeer(MessageSyncMeta msg) {}
    public void onMsgDeletedFromServer(MessageSyncMeta msg) {}

}
