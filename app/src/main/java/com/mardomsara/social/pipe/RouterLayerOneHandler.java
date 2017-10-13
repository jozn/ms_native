package com.mardomsara.social.pipe;

import android.util.Log;

import com.mardomsara.social.app.AppLog;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import ir.ms.pb.PB_AllLivePushes;
import ir.ms.pb.PB_CommandReachedToServer;
import ir.ms.pb.PB_ResponseToClient;
import ir.ms.pb.RPC_HANDLERS;
import ir.ms.pb.RpcNameToResponseMapper;

/**
 * Created by Hamid on 8/21/2017.
 */

class RouterLayerOneHandler {
	@Deprecated//we don't use reachToServer anymore just use response to client
	static PipeNetEventHandler handle_PB_CommandReachedToServer = (data) -> {
		Long clientCallId = PB_CommandReachedToServer.parseFrom(data).getClientCallId();
		if(Config.IS_DEBUG){
			AppLog.getPushLogger().d("- RouterLayerOneHandler.handle_PB_CommandReachedToServer() -ClientCallId: "+ clientCallId);
		}
		Pipe.tryReachedServer(clientCallId);
		return;
	};

	@SuppressWarnings("")
	static PipeNetEventHandler handle_PB_ResponseToClient = (data) -> {
		PB_ResponseToClient pb_responseToClient = PB_ResponseToClient.parseFrom(data);
		CommandFrame cf = Pipe.CommandFrameMap.get(pb_responseToClient.getClientCallId());
		Object parsedResultOfRpcResponse = null;
		boolean handeledRpceByMe = false;
		try {
			if (cf != null) {
				try {
					if (cf.getSuccessCallback() != null) {
						parsedResultOfRpcResponse = cf.getSuccessCallback().handle(pb_responseToClient.getData().toByteArray());
						handeledRpceByMe = true;
					}
				}catch (Exception e){
//					e.printStackTrace();
					AppLog.getExecptionsLogger().e(e);
				}

				Pipe.CommandFrameMap.remove(pb_responseToClient.getClientCallId());
			} else {
				AppUtil.error("response  " + pb_responseToClient.getPBClass() + " " + pb_responseToClient.getClientCallId());
			}

			if(Config.IS_DEBUG){
				AppLog.getPushLogger().d("--> Response To client Rpc: handeled: "+ handeledRpceByMe + " Data: "+ AppUtil.toJsonPretty(parsedResultOfRpcResponse));
			}
		} catch (Exception e) {
//			e.printStackTrace();
			AppLog.getExecptionsLogger().e(e);
		}

		AndroidUtil.runInBackgroundNoPanic(() -> {
			DB.getRpcDB().deleteFromRpcOffline().ClientCallIdEq(pb_responseToClient.getClientCallId()).execute();
		});

		try {
			RPC_HANDLERS.HandleRowRpcResponse x =  RPC_HANDLERS.getRouter().get(pb_responseToClient.getRpcFullName());
			if(x != null){
				//this happens for offlines RPC and those with no handelers registeried -- could upgrade RPCs to use just this way of decoding
				if(parsedResultOfRpcResponse == null){
					try {
						com.google.protobuf.GeneratedMessageLite parseData= RpcNameToResponseMapper.getMap().get(pb_responseToClient.getRpcFullName()).parseData(pb_responseToClient.getData());
						x.handle(parseData,handeledRpceByMe);
					}catch (Exception e){
						Log.e("Rpc", "Error in reflection in RPC_Router for rpc: " +pb_responseToClient.getRpcFullName() );
						AppLog.getPushLogger().e("Error in reflection in RPC_Router for rpc: " +pb_responseToClient.getRpcFullName() );
//						e.printStackTrace();
						AppLog.getExecptionsLogger().e(e);
					}
					//x.handle(parsedResultOfRpcResponse,handeledRpceByMe);
				}else {
					x.handle(parsedResultOfRpcResponse,handeledRpceByMe);
				}
			}else {
				AppUtil.log("Rpc: no default handler for RPC responses :" + pb_responseToClient.getPBClass());
				AppLog.getPushLogger().e("Rpc: no default handler for RPC responses :" + pb_responseToClient.getPBClass());
			}
		}catch (Exception e){
			AppLog.getExecptionsLogger().e(e);
//			e.printStackTrace();
		}

	};

	@SuppressWarnings("")
	static PipeNetEventHandler handle_PB_AllLivePushes = (data) -> {
		PB_AllLivePushes pb_allLivePushes = PB_AllLivePushes.parseFrom(data);
		RPC_HANDLERS.RPC_Sync_Default_Handler.GetDirectUpdates(pb_allLivePushes.getDirectUpdates(),false);
		RPC_HANDLERS.RPC_Sync_Default_Handler.GetGeneralUpdates(pb_allLivePushes.getGeneralUpdates(),false);
	};

	/*@Deprecated
	static PipeNetEventHandler handle_PB_PushDirectLogViewsMany = (data) -> {
		PB_PushHolderView pb_pushHolderView = PB_PushHolderView.parseFrom(data);
		PushRouter.handle(pb_pushHolderView);
	};*/
}
