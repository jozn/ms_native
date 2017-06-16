package com.mardomsara.social.models;

import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.pipe_pb.PBConv;

import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_PushMsgAddMany;
import ir.ms.pb.PB_UserWithMe;

/**
 * Created by Hamid on 6/16/2017.
 */

public class MessageNetModel {
	public static void onNewMessagesFromPipe(PB_PushMsgAddMany pbPushMsgAddMany){
		for (PB_Message pbMsg :pbPushMsgAddMany.getMessagesList()){
			handleNewSingleMsg(PBConv.PB_Message_toNew_Message(pbMsg));
		}

		for (PB_UserWithMe pbMsg :pbPushMsgAddMany.getUsersList()){
			handleNewUser(PBConv.PB_UserWithMe_toNew_User(pbMsg));
		}

		Helper.showDebugMessage("Msg: "+pbPushMsgAddMany.getMessagesList().size() + " Users: "  + pbPushMsgAddMany.getUsersList().size() );
	}
	public static void onNewMessagesEventsFromPipe(){}

}
