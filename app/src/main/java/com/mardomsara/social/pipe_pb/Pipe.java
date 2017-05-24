package com.mardomsara.social.pipe_pb;

import com.google.protobuf.AbstractMessageLite;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.TimeUtil;

import ir.ms.pb.PB_CommandToClient;
import ir.ms.pb.PB_CommandToServer;

/**
 * Created by Hamid on 10/5/2016.
 */
public class Pipe {

	public static void sendCall(Call_DEP call, Runnable success , Runnable error){
		/*AndroidUtil.runInBackgroundNoPanic(()->{
			if(WS.getInstance().isOpen()){
				CallRespondCallback respondCallback = new CallRespondCallback(call, success,error);
				CallRespondCallbacksRegistery_DEP.register(respondCallback);
				WS_DEP.getInstance().sendCall(call);
			}else {
				if(error != null){
					error.run();
				}
			}
		});*/
	}

	public static void cancelCall(Call_DEP call){
		AndroidUtil.runInBackgroundNoPanic(()->{
			//WS_DEP.getInstance().cancelCall(call);
		});
	}

	public static <T> void makeCall(String command, AbstractMessageLite data, CommandCallBack<T> callBack, Runnable errorBack){
		if(data == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommand(command)
			.setCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();


		if(WS.getInstance().isOpen()){
			CallRespondCallback callRespondCallback = new CallRespondCallback(callBack,errorBack,callId);
			CallRespondCallbacksRegistery.register(callRespondCallback);
			WS.getInstance().sendCall(pb_commandToServer);
//			WS.getInstance().sendCall(call);
		}else {
			if(errorBack != null){
				errorBack.run();
			}
		}


	}

}
