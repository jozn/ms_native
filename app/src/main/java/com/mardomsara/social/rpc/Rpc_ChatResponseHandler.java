package com.mardomsara.social.rpc;

import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.helpers.HelperPushAndRefreshHandlerOfData;

import ir.ms.pb.PB_ChatResponse_GetChatList;
import ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList;
import ir.ms.pb.RPC_HANDLERS;

/**
 * Created by Hamid on 9/30/2017.
 */

public class Rpc_ChatResponseHandler extends RPC_HANDLERS.RPC_Chat_Empty{
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
