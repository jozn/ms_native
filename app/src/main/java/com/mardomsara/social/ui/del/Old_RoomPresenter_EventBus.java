package com.mardomsara.social.ui.del;

import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgGeneralChangeChangeEvent;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.pipe.from_net_calls.json.MsgDeletedFromServerJson;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Hamid on 10/13/2016.
 */

public class Old_RoomPresenter_EventBus {
	/*@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgDeletedFromServerJson meta){
		logIt("event MsgDeletedFromServerJson: " + meta.toString());
//        _updateMsgForMeta(meta);
		if(meta == null ) return;
		if(meta.RoomKey.equals(room.RoomKey)){
			if(!messagesAdaptor.msgs.contains(msg)){
				try {
					messagesAdaptor.msgs.addStart(0,msg);
					messagesAdaptor.notifyDataSetChanged();

				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}

		Message msg;
		if(meta.RoomKey.equals(room.RoomKey)){
			int sizeMsgs = messagesAdaptor.msgs.size();
			int sizeMetas = meta.ExtraData.size();
			String metaMsgsKey ;
			for(int j=0; j<sizeMetas ;j++){
				metaMsgsKey = meta.ExtraData.get(j);
				for(int i=0; i< sizeMsgs; i++){
					msg = messagesAdaptor.msgs.get(i);
					if(msg.MessageKey.equals(metaMsgsKey)){
						Message msg2 = MessageModel.getMessageByKey(metaMsgsKey);
						messagesAdaptor.msgs.remove(i);
						messagesAdaptor.msgs.addStart(i,msg2);
						messagesAdaptor.notifyContentItemChanged(i);
//                        messagesAdaptor.notifyDataSetChanged();
					}
				}
			}
		}
	}

	//    @Subscribe old
	//todo remove old events
	public void onEvent(MessageSyncMeta meta){
		logIt("event meta: XXXXX " + meta.toString());
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgGeneralChangeChangeEvent meta){
		logIt("event meta: MsgGeneralChangeChangeEvent " + meta.toString());
		_updateMsgForMeta(meta);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgsSyncMetaReceivedToServer meta){
		logIt("event meta: REcived " + meta.toString());
		_updateMsgForMeta(meta);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgsSyncMetaReceivedToPeer meta){
		logIt("event meta: " + meta.toString());
		_updateMsgForMeta(meta);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgsSyncMetaDeletedFromServer meta){
		logIt("event meta: " + meta.toString());
		_updateMsgForMeta(meta);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgsSyncMetaSeenByPeer meta){
		logIt("event meta: " + meta.toString());
//        _updateMsgForMeta(meta);
		if(meta == null || meta.ExtraData == null) return;

		Message msg;
		if(meta.RoomKey.equals(room.RoomKey)){
			int sizeMsgs = messagesAdaptor.msgs.size();
			int sizeMetas = meta.ExtraData.size();
			String metaMsgsKey ;
			for(int j=0; j<sizeMetas ;j++){
				metaMsgsKey = meta.ExtraData.get(j);
				for(int i=0; i< sizeMsgs; i++){
					msg = messagesAdaptor.msgs.get(i);
					if(msg.MessageKey.equals(metaMsgsKey)){
						Message msg2 = MessageModel.getMessageByKey(metaMsgsKey);
						messagesAdaptor.msgs.remove(i);
						messagesAdaptor.msgs.addStart(i,msg2);
						messagesAdaptor.notifyContentItemChanged(i);
//                        messagesAdaptor.notifyDataSetChanged();
					}
				}
			}
		}
	}

	//udate for all metas -- fist msg must be saved
	void _updateMsgForMeta(MessageSyncMeta meta){
		Message msg;
		if(meta.RoomKey.equals(room.RoomKey)){
			int size = messagesAdaptor.msgs.size();
			for(int i=0; i< size; i++){
				msg = messagesAdaptor.msgs.get(i);
				if(msg.MessageKey.equals(meta.MessageKey)){
					Message msg2 = MessageModel.getMessageByKey(meta.MessageKey);
					messagesAdaptor.msgs.remove(i);
					messagesAdaptor.msgs.addStart(i,msg2);
					messagesAdaptor.notifyDataSetChanged();
				}
			}
		}
	}
*/
}
