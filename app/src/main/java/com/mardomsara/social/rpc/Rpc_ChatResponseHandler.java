package com.mardomsara.social.rpc;

import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.RealmMessageFileViewHelper;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.helpers.HelperPushAndRefreshHandlerOfData;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import io.realm.Realm;
import ir.ms.pb.PB_ChatResponse_AddNewMessage;
import ir.ms.pb.PB_ChatResponse_GetChatList;
import ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList;
import ir.ms.pb.RPC_HANDLERS;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;

/**
 * Created by Hamid on 9/30/2017.
 */

public class Rpc_ChatResponseHandler extends RPC_HANDLERS.RPC_Chat_Empty{
	@Override
	public void AddNewMessage(PB_ChatResponse_AddNewMessage pb, boolean handled) {
		super.AddNewMessage(pb, handled);

		//Message
		Realm realm = AppRealm.getChatRealm();
		RealmMessageView realmMessageView = RealmMessageViewHelper.getMessageByMessagKey(realm,pb.getMessageKey());
		if(realmMessageView != null){
			realm.executeTransaction((r)->{
				realmMessageView.RemoteId = pb.getNewMessageId();
				realmMessageView.MessageFileId = pb.getNewMessageFileId();
				if(realmMessageView.DeliviryStatusEnumId < RoomMessageDeliviryStatusEnum.SENT_VALUE){
					realmMessageView.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.SENT_VALUE;
				}
			});
		}

		//MessageFileView
		if(pb.getNewMessageFileId() > 0){
			RealmMessageFileView messageFileView = RealmMessageFileViewHelper.getMessageFileByMessagFileKey(realm,pb.getMessageFileKey());
			if(messageFileView != null){
				realm.executeTransaction((r)->{
					messageFileView.RemoteMessageFileId = pb.getNewMessageFileId();
				});
			}
		}
	}

	@Override
	public void GetChatList(PB_ChatResponse_GetChatList pb, boolean handled) {
		super.GetChatList(pb, handled);
//		RealmChatViewHelper.insertOrUpdateNewChatsFromPipe(pb.getChatsList());
		if(Config.IS_DEBUG){
			AppLogger.getRpcMsgLogger().d("GetFreshChatList(): " + AppUtil.toJsonPretty(pb));
		}
		HelperPushAndRefreshHandlerOfData.newChatViewList(pb.getChatsList());
	}

	@Override
	public void GetFreshAllDirectMessagesList(PB_ChatResponse_GetFreshAllDirectMessagesList pb, boolean handled) {
		super.GetFreshAllDirectMessagesList(pb, handled);
		if(Config.IS_DEBUG){
			AppLogger.getRpcMsgLogger().d("GetFreshAllDirectMessagesList(): " + AppUtil.toJsonPretty(pb));
		}
		HelperPushAndRefreshHandlerOfData.newMessageViewList(pb.getMessagesList());
	}

}
