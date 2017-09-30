package com.mardomsara.social.rpc;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;

import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_MsgResponse_GetFreshChatList;
import ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList;
import ir.ms.pb.PB_SyncResponse_GetDirectUpdates;
import ir.ms.pb.PB_SyncResponse_GetGeneralUpdates;
import ir.ms.pb.PB_SyncResponse_GetNotifyUpdates;
import ir.ms.pb.RPC_HANDLERS;

/**
 * Created by Hamid on 9/30/2017.
 */

public class Rpc_MsgResponseHandler extends RPC_HANDLERS.RPC_Msg_Empty{
	@Override
	public void GetFreshChatList(PB_MsgResponse_GetFreshChatList pb, boolean handled) {
		super.GetFreshChatList(pb, handled);
		RealmChatViewHelper.insertOrUpdateNewChatsFromPipe(pb.getChatsList());
	}

	@Override
	public void GetFreshRoomMessagesList(PB_MsgResponse_GetFreshRoomMessagesList pb, boolean handled) {
		super.GetFreshRoomMessagesList(pb, handled);
		List<RealmMessageView> msgs = new ArrayList();
		for (PB_MessageView pbMessageView : pb.getMessagesList()) {
			RealmMessageView t = RealmMessageView.fromPB(pbMessageView);
			if(pbMessageView.getMessageFileView() != null){
				t.MessageFileView = RealmMessageFileView.fromPB(pbMessageView.getMessageFileView());
			}
			msgs.add(t);
		}

		AppRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(msgs);
		});
	}
}
