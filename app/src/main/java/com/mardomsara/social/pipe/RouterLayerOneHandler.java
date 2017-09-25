package com.mardomsara.social.pipe;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.pipe.push_handling.PushRouter;

import ir.ms.pb.PB_CommandReachedToServer;
import ir.ms.pb.PB_PushHolderView;
import ir.ms.pb.PB_ResponseToClient;

/**
 * Created by Hamid on 8/21/2017.
 */

class RouterLayerOneHandler {
	@Deprecated//we don't use reachToServer anymore just use response to client
	static PipeNetEventHandler handle_PB_CommandReachedToServer = (data)->{
			Long clientCallId =  PB_CommandReachedToServer.parseFrom(data).getClientCallId();
			Pipe.tryReachedServer(clientCallId);
			return;
	};

	static PipeNetEventHandler handle_PB_ResponseToClient = (data)->{
		PB_ResponseToClient pb_responseToClient = PB_ResponseToClient.parseFrom(data);
		CommandFrame cf = Pipe.CommandFrameMap.get(pb_responseToClient.getClientCallId());
		if (cf!=null){
			if(cf.getSuccessCallback() != null){
				cf.getSuccessCallback().handle(pb_responseToClient.getData().toByteArray());
			}

			Pipe.CommandFrameMap.remove(pb_responseToClient.getClientCallId());
		}else {
			AppUtil.error("ws pipe error in handling handle_PB_ResponseToClient for "+pb_responseToClient.getPBClass() + " "+ pb_responseToClient.getClientCallId());
		}

		AndroidUtil.runInBackgroundNoPanic(()->{
			DB.getRpcDB().deleteFromRpcOffline().CallIdEq(pb_responseToClient.getClientCallId()).execute();
		});

	};

	static PipeNetEventHandler handle_PB_PushDirectLogViewsMany = (data)->{
		PB_PushHolderView pb_pushHolderView = PB_PushHolderView.parseFrom(data);
		PushRouter.handle(pb_pushHolderView);
	};
}
