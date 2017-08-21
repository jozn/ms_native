package com.mardomsara.social.pipe;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mardomsara.social.App;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.app.MonitorCraches;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.MessageNetModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgSeenByPeerJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ir.ms.pb.PB_MsgEvent;
import ir.ms.pb.PB_PushMsgAddMany;
import ir.ms.pb.PB_PushMsgEvents;

/**
 * Created by Hamid on 5/2/2016.
 */
class PipeCallsFromServerProxy {
    static PipeNetEventHandler PB_PushMsgAddMany_Handler = (data) -> {
		try {
			PB_PushMsgAddMany pbPushMsgAddMany = PB_PushMsgAddMany.parseFrom(data);
			MessageNetModel.onNewMessagesFromPipe(pbPushMsgAddMany);
		}catch (InvalidProtocolBufferException e){
			MonitorCraches.log(e);
		}
    };

    static PipeNetEventHandler PB_PushMsgEvents_Handler = (data) -> {
		try {
			MessageNetModel.onNewMessagesEventsFromPipe(PB_PushMsgEvents.parseFrom(data));
		}catch (InvalidProtocolBufferException e){
			MonitorCraches.log(e);
		}
    };


}
