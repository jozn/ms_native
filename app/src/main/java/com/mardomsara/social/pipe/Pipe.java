package com.mardomsara.social.pipe;

import android.support.annotation.Nullable;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.mardomsara.social.app.AppLog;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.pipe.table.RpcOffline;
import com.mardomsara.social.rpc.Rpc_MsgResponseHandler;
import com.mardomsara.social.rpc.Rpc_SyncResponseHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ir.ms.pb.PB_CommandToServer;
import ir.ms.pb.RPC_HANDLERS;

/**
 * Created by Hamid on 8/22/2017.
 */

public class Pipe {

	//todo extrac this to some where else
	static {
		RPC_HANDLERS.RPC_Sync_Default_Handler= new Rpc_SyncResponseHandler();
		RPC_HANDLERS.RPC_Msg_Default_Handler= new Rpc_MsgResponseHandler();
	}

	static Map<Long, CommandFrame> CommandFrameMap = Collections.synchronizedMap(new HashMap<>());

	public static void send(String rpcName, AbstractMessageLite dataMessage, @Nullable SuccessCallback successCallback, @Nullable ErrorCallback errorCallback) {
		if (dataMessage == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(rpcName))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(dataMessage.toByteArray()))
			.build();

		if(Config.IS_DEBUG){
			AppLog.getWsLogger().d("=> Pipe.send("+ rpcName + "dataMessage: "+ dataMessage.toString() + " pb_commandToServer: "+pb_commandToServer.toString());
//			AppLog.getWsLogger().d("==> WS Pipe.send("+ rpcName + "dataMessage: "+ dataMessage.toString() + " pb_commandToServer: "+pb_commandToServer.toString());
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

	public static void sendDirect_PB_CommandToServer(PB_CommandToServer pb_commandToServer) {
		PipeWS.getInstance().sendCall(pb_commandToServer);
	}

	public static void sendOffline(final String CommandKey, String rpcName, AbstractMessageLite dataMessage, @Nullable SuccessCallback successCallback, @Nullable ErrorCallback errorCallback) {
		if (dataMessage == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(rpcName))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(dataMessage.toByteArray()))
			.build();

		if(Config.IS_DEBUG){
			AppLog.getWsLogger().d("=> Pipe.sendOffline("+ rpcName + "dataMessage: "+ dataMessage.toString() + " pb_commandToServer: "+pb_commandToServer.toString());
		}

		AndroidUtil.runInBackgroundNoPanic(()->{
			try {
				String CommandKey2 = CommandKey;
				if(CommandKey == null || CommandKey.equals("")){
					CommandKey2 = LangUtil.getRandomString(40);
				}
				RpcOffline rpcOffline = new RpcOffline();
				rpcOffline.ClientCallId = callId;
				rpcOffline.CommandKey = CommandKey2;
				rpcOffline.RpcMethod = rpcName;
				rpcOffline.Blob = pb_commandToServer.toByteArray();
				rpcOffline.CreatedMs = TimeUtil.getTimeMs();

				DB.getRpcDB().insertIntoRpcOffline(rpcOffline);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


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
