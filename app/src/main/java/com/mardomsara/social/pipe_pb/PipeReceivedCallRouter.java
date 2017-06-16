package com.mardomsara.social.pipe_pb;

import android.util.Log;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.pipe_pb.from_net_calls.del.MsgCallsFromServer_DEP;
import com.mardomsara.social.pipe_pb.from_net_calls.del.NotifyCallsFromServer_DEP;
import com.mardomsara.social.pipe_pb.from_net_calls.PipeMsgCallsFromServer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ir.ms.pb.PB_CommandReceivedToServer;
import okio.ByteString;

/**
 * Created by Hamid on 3/31/2016.
 */
public class PipeReceivedCallRouter {
	private static ExecutorService singleReciverHandlerExecuter = Executors.newSingleThreadExecutor();

    static {
        mapper = new HashMap<>();//must be here - otherwise it will not inintilaze befor buildMapper()
        buildMapper();
    }

    static Map<String,PipeNetEventHandler> mapper;

    static void register_old(String command, NetEventHandler_DEP handler){
//        mapper.put(command,handler);
    }

	private static void register(String command, PipeNetEventHandler handler){
        mapper.put(command,handler);
	}

    private static void handlePushes(String command, byte[] data){

        try {
            PipeNetEventHandler handler =  mapper.get(command);
            if(handler != null){
                handler.handle(data);
            }else if(command.equals("TimeMs")) {
//				TimeMs(data);
			}else {
                AppUtil.error(" ws NetEventRouter for "+ command +" has not been registered. ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

	private static void buildMapper() {

		//Messages
		register(Constants.PB_PushMsgAddMany, PipeMsgCallsFromServer.PB_PushMsgAddMany_Handler);
		register(Constants.PB_PushMsgEvents, PipeMsgCallsFromServer.PB_PushMsgAddMany_Handler);





		register_old("MsgAddMany", MsgCallsFromServer_DEP.MsgAddMany);
		register_old("MsgsReceivedToPeerMany", MsgCallsFromServer_DEP.MsgsReceivedToPeerMany);
		register_old("MsgsDeletedFromServerMany", MsgCallsFromServer_DEP.MsgsDeletedFromServerMany);
		register_old("MsgsSeenByPeerMany", MsgCallsFromServer_DEP.MsgsSeenByPeerMany);

		//Notify
		register_old("NotifyAddOne", NotifyCallsFromServer_DEP.NotifyAddOne);
		register_old("NotifyRemoveMany", NotifyCallsFromServer_DEP.NotifyRemoveMany);

//		register_old("NotifyRemoveMany", MsgCallsFromServer.PB_PushMsgAddMany_Handler);
//		register_old("NotifyAddOne", MsgCallsFromServer.MsgAddMany);
	}

    private static void buildMapper2() {

        //Messages
		register_old("PB_PushMsgAddMany_Handler", MsgCallsFromServer_DEP.MsgAddOne);
		register_old("MsgAddMany", MsgCallsFromServer_DEP.MsgAddMany);
        register_old("MsgsReceivedToPeerMany", MsgCallsFromServer_DEP.MsgsReceivedToPeerMany);
        register_old("MsgsDeletedFromServerMany", MsgCallsFromServer_DEP.MsgsDeletedFromServerMany);
        register_old("MsgsSeenByPeerMany", MsgCallsFromServer_DEP.MsgsSeenByPeerMany);

		//Notify
        register_old("NotifyAddOne", NotifyCallsFromServer_DEP.NotifyAddOne);
        register_old("NotifyRemoveMany", NotifyCallsFromServer_DEP.NotifyRemoveMany);

//		register_old("NotifyRemoveMany", MsgCallsFromServer.PB_PushMsgAddMany_Handler);
//		register_old("NotifyAddOne", MsgCallsFromServer.MsgAddMany);
    }

	/*static void TimeMs(Call_DEP call) {
		AppModel.timeDiffToServer = call.TimeMs - TimeUtil.getTimeMs();

	}*/

	static void handleNetWSMessage(ByteString body) {
		if(body == null) return;

		Runnable r = ()->{
			try {
				ir.ms.pb.PB_CommandToClient pbCommandToClient = ir.ms.pb.PB_CommandToClient.parseFrom(body.toByteArray());
				Log.i("WS: " ,"onMessage: message Command :" + pbCommandToClient.getCommand() + " " + pbCommandToClient.getServerCallId() + " size: " + pbCommandToClient.getData().size());

				if (pbCommandToClient.getCommand().equals(Constants.PB_CommandReceivedToServer)) {
					Long clientCallId =  PB_CommandReceivedToServer.parseFrom(pbCommandToClient.getData()).getClientCallId();
					CallRespondCallbacksRegistery.tryReachedServer(clientCallId);
					return;
				}

				if (pbCommandToClient.getServerCallId() != 0) {//respond call
					PipeWS.getInstance().sendToServer_CallReceivedToAndroid(pbCommandToClient.getServerCallId());
				}

				if (pbCommandToClient.getCommand().equals("CallReceivedToServer")) {
					CallRespondCallbacksRegistery.tryReachedServer(pbCommandToClient.getServerCallId());
					return;
				}else if(pbCommandToClient.getCommand().equals("CallResponse")){
					CallRespondCallbacksRegistery.trySucceeded(pbCommandToClient.getServerCallId() , pbCommandToClient.getData().toByteArray());
				}else {
					PipeReceivedCallRouter.handlePushes(pbCommandToClient.getCommand(), pbCommandToClient.getData().toByteArray() );

				}

			}catch (Exception e){
				e.printStackTrace();
			}
		};
		singleReciverHandlerExecuter.execute(r);
	}
}
