package com.mardomsara.social.pipe_pb;

import android.util.Log;

import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.AppModel;
import com.mardomsara.social.pipe_pb.from_net_calls.MsgCallsFromServer;
import com.mardomsara.social.pipe_pb.from_net_calls.NotifyCallsFromServer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okio.ByteString;

/**
 * Created by Hamid on 3/31/2016.
 */
public class WSCallRouter {


	private static ExecutorService singleReciverHandlerExecuter = Executors.newSingleThreadExecutor();

    static {
        mapper = new HashMap<>();//must be here - otherwise it will not inintilaze befor buildMapper()
        buildMapper();
    }

    static Map<String,NetEventHandler> mapper;

    static void register(String command, NetEventHandler handler){
        mapper.put(command,handler);
    }

    public static void handlePushes(String command, byte[] call){
		/*AppUtil.log("WS handlePushes: "+ command + " data : "+ call.length);
		if(call == null || command == null || command.equals("") ) return;

        try {
            NetEventHandler handler =  mapper.get(command);
            if(handler != null){
                handler.handle(data);
            }else if(command.equals("TimeMs")) {
				TimeMs(call);
			}else {
                AppUtil.error("NetEventRouter for "+ command +" has not been registered. ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    private static void buildMapper() {

        //Messages
		register("MsgAddOne", MsgCallsFromServer.MsgAddOne);
		register("MsgAddMany", MsgCallsFromServer.MsgAddMany);
        register("MsgsReceivedToPeerMany", MsgCallsFromServer.MsgsReceivedToPeerMany);
        register("MsgsDeletedFromServerMany", MsgCallsFromServer.MsgsDeletedFromServerMany);
        register("MsgsSeenByPeerMany", MsgCallsFromServer.MsgsSeenByPeerMany);

		//Notify
        register("NotifyAddOne", NotifyCallsFromServer.NotifyAddOne);
        register("NotifyRemoveMany", NotifyCallsFromServer.NotifyRemoveMany);

//		register("NotifyRemoveMany", MsgCallsFromServer.MsgAddOne);
//		register("NotifyAddOne", MsgCallsFromServer.MsgAddMany);
    }

	/*static void TimeMs(Call_DEP call) {
		AppModel.timeDiffToServer = call.TimeMs - TimeUtil.getTimeMs();

	}*/

	public static void handleNetWSMessage(ByteString body) {
		if(body == null) return;
		Log.i("WS: " ,"onMessage: message :" + body);

		Runnable r = ()->{
			try {
				ir.ms.pb.PB_CommandToClient pbCommandToClient = ir.ms.pb.PB_CommandToClient.parseFrom(body.toByteArray());
				if (pbCommandToClient.getCallId() != 0) {//respond call
//					WS.getInstance().sendToServer_CallReceivedToAndroid(pbCommandToClient.getCallId());
				}

				if (pbCommandToClient.getCommand().equals("CallReceivedToServer")) {
					CallRespondCallbacksRegistery.tryReachedServer(pbCommandToClient.getCallId());
					return;
				}else if(pbCommandToClient.getCommand().equals("CallResponse")){
					CallRespondCallbacksRegistery.trySucceeded(pbCommandToClient.getCallId() , pbCommandToClient.getData().toByteArray());
				}else {
					WSCallRouter.handlePushes(pbCommandToClient.getCommand(), pbCommandToClient.getData().toByteArray() );

				}

			}catch (Exception e){
				e.printStackTrace();
			}
		};
		singleReciverHandlerExecuter.execute(r);
	}
}
