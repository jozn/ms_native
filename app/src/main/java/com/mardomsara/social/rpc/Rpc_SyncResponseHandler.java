package com.mardomsara.social.rpc;

import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AppUtil;

import ir.ms.pb.PB_SyncResponse_GetGeneralUpdates;
import ir.ms.pb.PB_SyncResponse_GetNotifyUpdates;
import ir.ms.pb.RPC_HANDLERS;

/**
 * Created by Hamid on 9/30/2017.
 */

//public class Rpc_SyncResposeHandler implements RPC_HANDLERS.RPC_Sync{
public class Rpc_SyncResponseHandler extends RPC_HANDLERS.RPC_Sync_Empty{
	/*@Override
	public void GetDirectUpdates(PB_SyncResponse_GetDirectUpdates pb, boolean handled) {
		if(Config.IS_DEBUG){
			AppLogger.getRpcMsgLogger().d("GetDirectUpdates: " + AppUtil.toJsonPretty(pb));
		}

		HelperPushAndRefreshHandlerOfData.newMessageViewList(pb.getNewMessagesList());
		HelperPushAndRefreshHandlerOfData.newChatViewList(pb.getChatsList());

		HelperPushAndRefreshHandlerOfData.messagesChangeIdsList(pb.getMessagesChangeIdsList());
		HelperPushAndRefreshHandlerOfData.messagesChangeIdsList(pb.getMessagesFileChangeIdsList());

		HelperPushAndRefreshHandlerOfData.messagesDelivierdToServer(pb.getMessagesDelivierdToServerList());
		HelperPushAndRefreshHandlerOfData.messagesDelivierdToPeerList(pb.getMessagesDelivierdToPeerList());
		HelperPushAndRefreshHandlerOfData.messagesDeletedFromServerList(pb.getMessagesDeletedFromServerList());
		HelperPushAndRefreshHandlerOfData.messagesSeenByPeerList(pb.getMessagesSeenByPeerList());


		AppUtil.log("pb: Rpc_SyncResponseHandler.GetDirectUpdates - new messages count: " + pb.getNewMessagesCount());
		int c = AppRealm.getChatRealm().where(RealmMessageView.class).findAll().size();
		AppUtil.log("pb:  Rpc_SyncResponseHandler.GetDirectUpdates - realm messages count: " + c + " chat count " + pb.getChatsCount());

		*//*List<RealmUserView> users = new ArrayList();
		for (PB_UserView m : pb.getUsersList()) {
			RealmUserView t = PBToRealm.from_userView(m);

			users.add(t);
		}
		MSRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(users);
		});*//*


//		RealmChatViewHelper.insertOrUpdateNewChatsFromPipe(pb.getChatsList());
	}*/

	@Override
	public void GetGeneralUpdates(PB_SyncResponse_GetGeneralUpdates pb, boolean handled) {
		if(Config.IS_DEBUG){
			AppLogger.getRpcMsgLogger().d("GetGeneralUpdates: " + AppUtil.toJsonPretty(pb));
		}
	}

	@Override
	public void GetNotifyUpdates(PB_SyncResponse_GetNotifyUpdates pb, boolean handled) {

	}

}
