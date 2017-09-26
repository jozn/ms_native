package com.mardomsara.social.pipe_pb;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mardomsara.social.app.MonitorCraches;
import com.mardomsara.social.models_old.MessageNetModel;

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
