package com.mardomsara.social.pipe;

import android.util.Log;

import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AppUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okio.ByteString;

/**
 * Created by Hamid on 8/21/2017.
 */

final class RouterForDataReceived {
	private static ExecutorService singleReciverHandlerExecuter = Executors.newSingleThreadExecutor();

	static {
		buildMapper();
	}
	private static Map<String,PipeNetEventHandler> mapper = null;

	private static void handlePushes(String command, byte[] data){
		buildMapper();
		try {
			/*if(Config.IS_DEBUG){
				AppLog.getWsLogger().d("=====> WS handlePushes" +clientCallId + " Status: "+status.toString());
			}*/

			PipeNetEventHandler handler =  mapper.get(command);
			if(handler != null){
				AppUtil.log(" ws NetEventRouter handled "+ command +" , size of map: " + mapper.size());
				handler.handle(data);

			}else if(command.equals("TimeMs")) {
//				TimeMs(data);
			}else {
				AppUtil.error(" ws NetEventRouter for "+ command +" has not been registered. mapper size: " + mapper.size());
			}
		}catch (Exception e){
			AppUtil.error(" ws NetEventRouter crached for "+ command +" . mapper size: " + mapper.size());
			if(Config.IS_DEBUG){
				AppLogger.getWsLogger().d("=====> WS crash in handlePushes: " + e.getMessage());
			}
			e.printStackTrace();
		}
	}

	private static void register(String command, PipeNetEventHandler handler){
		mapper.put(command,handler);
	}

	private static void buildMapper() {
		if(mapper != null && mapper.size() >0) return;
		mapper = new HashMap<>();

		register("PB_CommandReachedToServer", RouterLayerOneHandler.handle_PB_CommandReachedToServer);
		register("PB_ResponseToClient", RouterLayerOneHandler.handle_PB_ResponseToClient);
		register("PB_AllLivePushes", RouterLayerOneHandler.handle_PB_AllLivePushes);
//		register("PB_PushDirectLogViewsMany", RouterLayerOneHandler.handle_PB_PushDirectLogViewsMany);//dep
//		register("PB_PushHolderView", RouterLayerOneHandler.handle_PB_PushDirectLogViewsMany);//dep
	}

	static void handleNetWSMessage(ByteString body) {
		if(body == null) return;

		Runnable r = ()->{
			try {
				ir.ms.pb.PB_CommandToClient pbCommandToClient = ir.ms.pb.PB_CommandToClient.parseFrom(body.toByteArray());
				Log.i("WS: " ,"onMessage: message Command :" + pbCommandToClient.getCommand() + " " + pbCommandToClient.getServerCallId() + " size: " + pbCommandToClient.getData().size());

				AppLogger.getWsLogger().d("Pushed from server to WS :" + pbCommandToClient.getCommand() + " CallId: " + pbCommandToClient.getServerCallId());

				/*if (pbCommandToClient.getCommand().equals(Constants.PB_CommandReachedToServer)) {
					Long clientCallId =  PB_CommandReachedToServer.parseFrom(pbCommandToClient.getData()).getClientCallId();
					CallRespondCallbacksRegistery.tryReachedServer(clientCallId);
					return;
				}*/


				if (pbCommandToClient.getRespondReached() == true && pbCommandToClient.getServerCallId() != 0) {//respond call
					PipeWS.getInstance().sendToServer_CallReceivedToAndroid(pbCommandToClient.getServerCallId());
				}

				handlePushes(pbCommandToClient.getCommand(), pbCommandToClient.getData().toByteArray() );
			}catch (com.google.protobuf.InvalidProtocolBufferException e){
				e.printStackTrace();
			}
		};
		singleReciverHandlerExecuter.execute(r);
	}
}
