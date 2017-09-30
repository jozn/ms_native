package com.mardomsara.social.pipe;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.pipe.push_handling.PushRouter;

import ir.ms.pb.PB_CommandReachedToServer;
import ir.ms.pb.PB_PushHolderView;
import ir.ms.pb.PB_ResponseToClient;
import ir.ms.pb.RPC_HANDLERS;

/**
 * Created by Hamid on 8/21/2017.
 */

class RouterLayerOneHandler {
	@Deprecated//we don't use reachToServer anymore just use response to client
	static PipeNetEventHandler handle_PB_CommandReachedToServer = (data) -> {
		Long clientCallId = PB_CommandReachedToServer.parseFrom(data).getClientCallId();
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
					e.printStackTrace();
				}

				Pipe.CommandFrameMap.remove(pb_responseToClient.getClientCallId());
			} else {
				AppUtil.error("ws pipe error in handling handle_PB_ResponseToClient for " + pb_responseToClient.getPBClass() + " " + pb_responseToClient.getClientCallId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		AndroidUtil.runInBackgroundNoPanic(() -> {
			DB.getRpcDB().deleteFromRpcOffline().ClientCallIdEq(pb_responseToClient.getClientCallId()).execute();
		});

		try {
			RPC_HANDLERS.HandleRowRpcResponse x =  RPC_HANDLERS.getRouter().get(pb_responseToClient.getRpcFullName());
			if(x != null){
				x.handle(parsedResultOfRpcResponse,handeledRpceByMe);
			}else {
				AppUtil.log("Rpc: no default hander for RPC responses :" + pb_responseToClient.getPBClass());
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	};

	static PipeNetEventHandler handle_PB_PushDirectLogViewsMany = (data) -> {
		PB_PushHolderView pb_pushHolderView = PB_PushHolderView.parseFrom(data);
		PushRouter.handle(pb_pushHolderView);
	};
}
