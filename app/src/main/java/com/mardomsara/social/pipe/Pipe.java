package com.mardomsara.social.pipe;

import android.support.annotation.Nullable;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ir.ms.pb.PB_CommandToServer;

/**
 * Created by Hamid on 8/22/2017.
 */

public class Pipe {
	static Map<Long, CommandFrame> CommandFrameMap = Collections.synchronizedMap(new HashMap<>());

	public static void send(String rpcName, AbstractMessageLite dataMessage , @Nullable SuccessCallback successCallback , @Nullable ErrorCallback errorCallback ) {
		if(dataMessage == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(rpcName))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(dataMessage.toByteArray()))
			.build();

		if(PipeWS.getInstance().isOpen()){
			CommandFrame callRespondCallback = new CommandFrame(successCallback,errorCallback,callId);
			callRespondCallback.setDelayer();
			CommandFrameMap.put(callId,callRespondCallback);

			PipeWS.getInstance().sendCall(pb_commandToServer);
		}else {
			if(errorCallback != null){
				errorCallback.onError(new ErrorReason(ErrorReason.Reason.NO_CONNECTIONS));
			}
		}
	};

	public void sendOffline(){};

	@Deprecated
	static void tryReachedServer(Long clientCallId) {
		CommandFrame cf = CommandFrameMap.get(clientCallId);
		if (cf!=null){
			if(cf.getSuccessCallback() != null){
				//
			}
		}
	}

}
