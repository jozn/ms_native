package com.mardomsara.social.app;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.pipe.Pipe;
import com.mardomsara.social.pipe.table.RpcOffline;

import java.util.List;

import ir.ms.pb.PB_CommandToServer;
import ir.ms.pb.PB_MsgParam_Echo;
import ir.ms.pb.PB_SyncParam_GetDirectUpdates;
import ir.ms.pb.PB_SyncParam_GetGeneralUpdates;
import ir.ms.pb.RPC;

/**
 * Created by Hamid on 9/30/2017.
 */

public class AppSyncCycle {

	public static void onWsPipeOpened() {
		//replace this with ping
		RPC.RPC_Msg.Echo(PB_MsgParam_Echo.newBuilder().build(), null, null);

		sendOfflineRpcs();

		RPC.RPC_Sync.GetDirectUpdates(PB_SyncParam_GetDirectUpdates.newBuilder().build(), null, null);
		RPC.RPC_Sync.GetGeneralUpdates(PB_SyncParam_GetGeneralUpdates.newBuilder().build(), null, null);

	}

	private static void sendOfflineRpcs(){
		AndroidUtil.runInBackgroundNoPanic(()->{
			List<RpcOffline> rows = DB.getRpcDB().selectFromRpcOffline().ClientCallIdGe(1).toList();
			for(RpcOffline rpcOffline : rows){
				try {
					if(rpcOffline.CreatedMs + Config.OFFLINE_RPC_FLUSH_TIMEOUT_MS < TimeUtil.getTimeMs()){
						DB.getRpcDB().deleteFromRpcOffline().ClientCallIdEq(rpcOffline.ClientCallId).execute();
					}else {
						PB_CommandToServer pb_commandToServer = PB_CommandToServer.parseFrom(rpcOffline.Blob);
						Pipe.sendDirect_PB_CommandToServer(pb_commandToServer);
					}

				}catch (Exception e){
					e.printStackTrace();
				}
			}

		});
	}


	public static void onWsFailure(){}
	public static void onWsClose(){}


}
