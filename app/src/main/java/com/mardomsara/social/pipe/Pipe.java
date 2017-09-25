package com.mardomsara.social.pipe;

import android.support.annotation.Nullable;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.pipe.table.RpcOffline;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ir.ms.pb.PB_CommandToServer;

/**
 * Created by Hamid on 8/22/2017.
 */

public class Pipe {
	static Map<Long, CommandFrame> CommandFrameMap = Collections.synchronizedMap(new HashMap<>());

	public static void send(String rpcName, AbstractMessageLite dataMessage, @Nullable SuccessCallback successCallback, @Nullable ErrorCallback errorCallback) {
		if (dataMessage == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(rpcName))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(dataMessage.toByteArray()))
			.build();

		if (PipeWS.getInstance().isOpen()) {
			CommandFrame callRespondCallback = new CommandFrame(successCallback, errorCallback, callId);
			callRespondCallback.setDelayer();
			CommandFrameMap.put(callId, callRespondCallback);

			PipeWS.getInstance().sendCall(pb_commandToServer);
		} else {
			if (errorCallback != null) {
				errorCallback.onError(new ErrorReason(ErrorReason.Reason.NO_CONNECTIONS));
			}
		}
	}

	;

	public static void sendOffline(String CommandKey, String rpcName, AbstractMessageLite dataMessage, @Nullable SuccessCallback successCallback, @Nullable ErrorCallback errorCallback) {
		if (dataMessage == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(rpcName))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(dataMessage.toByteArray()))
			.build();

		try {
			if(CommandKey == null || CommandKey.equals("")){
				CommandKey = LangUtil.getRandomString(40);
			}
			RpcOffline rpcOffline = new RpcOffline();
			rpcOffline.CallId = callId;
			rpcOffline.CommandKey = CommandKey;
			rpcOffline.RpcMethod = rpcName;
			rpcOffline.Blob = pb_commandToServer.toByteArray();

			DB.getRpcDB().insertIntoRpcOffline(rpcOffline);
		} catch (Exception e) {
			e.printStackTrace();
		}


		if (PipeWS.getInstance().isOpen()) {
			CommandFrame callRespondCallback = new CommandFrame(successCallback, errorCallback, callId);
			callRespondCallback.setDelayer();
			CommandFrameMap.put(callId, callRespondCallback);

			PipeWS.getInstance().sendCall(pb_commandToServer);
		} else {
			if (errorCallback != null) {
				errorCallback.onError(new ErrorReason(ErrorReason.Reason.NO_CONNECTIONS));
			}
		}
	}

	;

	@Deprecated
	static void tryReachedServer(Long clientCallId) {
		CommandFrame cf = CommandFrameMap.get(clientCallId);
		if (cf != null) {
			if (cf.getSuccessCallback() != null) {
				//
			}
		}
	}

	public void sendOffline() {
	}

}
