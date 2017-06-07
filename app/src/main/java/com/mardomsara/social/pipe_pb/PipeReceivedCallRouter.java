package com.mardomsara.social.pipe_pb;

import android.util.Log;

import com.mardomsara.social.pipe_pb.from_net_calls.MsgCallsFromServer_DEP;
import com.mardomsara.social.pipe_pb.from_net_calls.NotifyCallsFromServer_DEP;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    static void register(String command, NetEventHandler handler){
//        mapper.put(command,handler);
    }

	static void register2(String command, PipeNetEventHandler handler){
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
		register("MsgAddOne", MsgCallsFromServer_DEP.MsgAddOne);
		register("MsgAddMany", MsgCallsFromServer_DEP.MsgAddMany);
        register("MsgsReceivedToPeerMany", MsgCallsFromServer_DEP.MsgsReceivedToPeerMany);
        register("MsgsDeletedFromServerMany", MsgCallsFromServer_DEP.MsgsDeletedFromServerMany);
        register("MsgsSeenByPeerMany", MsgCallsFromServer_DEP.MsgsSeenByPeerMany);

		//Notify
        register("NotifyAddOne", NotifyCallsFromServer_DEP.NotifyAddOne);
        register("NotifyRemoveMany", NotifyCallsFromServer_DEP.NotifyRemoveMany);

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
				if (pbCommandToClient.getServerCallId() != 0) {//respond call
//					WS.getInstance().sendToServer_CallReceivedToAndroid(pbCommandToClient.getCallId());
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
