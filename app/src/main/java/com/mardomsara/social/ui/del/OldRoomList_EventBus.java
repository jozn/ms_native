package com.mardomsara.social.ui.del;

import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Hamid on 10/15/2016.
 */

public class OldRoomList_EventBus {
/*
	@Subscribe(threadMode = ThreadMode.MAIN)
	//    public void onEvent(Message msg){
	public void onNewMsgEvent(Message msg){
		logIt("event new msg: " + msg.toString());
		//        notifyItemChanged(0);
		//remove
		int size = roomsList.size();
		Room room;
		int index = -1;
		for(int i =0; i< size; i++){
			room = roomsList.get(i);
			if(room == null) {size =-1; break;};
			if(room.RoomKey.equals(msg.RoomKey)){
				index = roomsList.indexOf(room);
				roomsList.remove(index);
				size=-1;//must break loop all -- bug indexOutOfRange
			}
		}
		Room firstRoomRow = RoomModel.getRoomByRoomKeyAndLoadUser(msg.RoomKey);
		roomsList.add(0,firstRoomRow);


		//        if(index>0){//move : 1,2,3
		//            notifyItemMoved(index,0);
		//        }else if (index == 0){
		//
		//        }
		//root_view itself update

		//Keep it simple
		if(index>0){
			notifyItemRemoved(index);
		}
//            notifyItemChanged(0);//buggy
		notifyDataSetChanged();
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onRoomInfoChangedEvent(RoomInfoChangedEvent event){
		logIt("event onRoomInfoChangedEvent: " + event.toString());
		int size = roomsList.size();
		Room room;
		Room newRoomRow = RoomModel.getRoomByRoomKeyAndLoadUser(event.RoomKey);
		int index = -1;
		int i =0;
		for(; i< size; i++){
			room = roomsList.get(i);
			if(room == null)  break;
			if(room.RoomKey.equals(event.RoomKey)){
				//                roomsList.remove(i);
				roomsList.setOrReplace(i,newRoomRow);
				break;//must break loop all -- bug indexOutOfRange
			}
		}
		notifyItemChanged(i);
	}

	@Subscribe
	public void onEvent(MessageSyncMeta mete){
		logIt("event meta: " + mete.toString());
	}

	@Subscribe
	public void onEvent(MsgsSyncMetaReceivedToServer mete){
		logIt("event meta: " + mete.toString());
		//        for(Room room: roomsList){
		//            if(room.getRoomKey().equals(mete.RoomKey)){
		//                int index = roomsList.indexOf(room);
		//                roomsList.remove(index);
		//                notifyItemRemoved(index);
		//            }
		//        }

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
*/

}
