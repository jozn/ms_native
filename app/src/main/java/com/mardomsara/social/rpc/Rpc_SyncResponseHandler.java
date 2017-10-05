package com.mardomsara.social.rpc;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.helpers.HelperPushAndRefreshHandlerOfData;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;

import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_SyncResponse_GetDirectUpdates;
import ir.ms.pb.PB_SyncResponse_GetGeneralUpdates;
import ir.ms.pb.PB_SyncResponse_GetNotifyUpdates;
import ir.ms.pb.RPC_HANDLERS;

/**
 * Created by Hamid on 9/30/2017.
 */

//public class Rpc_SyncResposeHandler implements RPC_HANDLERS.RPC_Sync{
public class Rpc_SyncResponseHandler extends RPC_HANDLERS.RPC_Sync_Empty{
	@Override
	public void GetDirectUpdates(PB_SyncResponse_GetDirectUpdates pb, boolean handled) {

		HelperPushAndRefreshHandlerOfData.newChatViewList(pb.getChatsList());
		HelperPushAndRefreshHandlerOfData.newMessageViewList(pb.getNewMessagesList());

		AppUtil.log("pb: Rpc_SyncResponseHandler.GetDirectUpdates - new messages count: " + pb.getNewMessagesCount());
		int c = AppRealm.getChatRealm().where(RealmMessageView.class).findAll().size();
		AppUtil.log("pb:  Rpc_SyncResponseHandler.GetDirectUpdates - realm messages count: " + c + " chat count " + pb.getChatsCount());

		/*List<RealmUserView> users = new ArrayList();
		for (PB_UserView m : pb.getUsersList()) {
			RealmUserView t = PBToRealm.from_userView(m);

			users.add(t);
		}
		MSRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(users);
		});*/


//		RealmChatViewHelper.insertOrUpdateNewChatsFromPipe(pb.getChatsList());
	}

	@Override
	public void GetGeneralUpdates(PB_SyncResponse_GetGeneralUpdates pb, boolean handled) {

	}

	@Override
	public void GetNotifyUpdates(PB_SyncResponse_GetNotifyUpdates pb, boolean handled) {

	}

}
