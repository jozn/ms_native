package com.mardomsara.social.pipe.del;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.pipe.PipeWS;

import ir.ms.pb.PB_CommandToServer;

public class Pipe {

	public static void cancelCall(long callid){
		AndroidUtil.runInBackgroundNoPanic(()->{
			//WS_DEP.getInstance().cancelCall(call);
		});
	}

	public static <T> void makeCall(String command, AbstractMessageLite data, ReachedToServerCallBack<T> callBack, Runnable errorBack){
		if(data == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(command))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();


		if(PipeWS.getInstance().isOpen()){
			CallRespondCallback callRespondCallback = new CallRespondCallback(callBack,errorBack,callId);
			CallRespondCallbacksRegistery.register(callRespondCallback);
			PipeWS.getInstance().sendCall(pb_commandToServer);
//			WS.getInstance().sendCall(call);
		}else {
			if(errorBack != null){
				errorBack.run();
			}
		}


	}

	public static <T> void makeCall(String command, AbstractMessageLite data, ReachedToServerCallBack<T> callBack, Runnable errorBack , Class cls){
		if(data == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommand(command)
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();


		if(PipeWS.getInstance().isOpen()){
			CallRespondCallback callRespondCallback = new CallRespondCallback(callBack,errorBack,callId);
			callRespondCallback.responseClass = cls.getName();
			CallRespondCallbacksRegistery.register(callRespondCallback);
			PipeWS.getInstance().sendCall(pb_commandToServer);
//			WS.getInstance().sendCall(call);
		}else {
			if(errorBack != null){
				errorBack.run();
			}
		}


	}

	public static <T> void makeCall(String command, AbstractMessageLite data, Runnable succBack , Runnable errorBack){
		if(data == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommandBytes(ByteString.copyFromUtf8(command))
			.setClientCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();

		if(PipeWS.getInstance().isOpen()){
			CallRespondCallback callRespondCallback = new CallRespondCallback(succBack,errorBack,callId);
			CallRespondCallbacksRegistery.register(callRespondCallback);
			PipeWS.getInstance().sendCall(pb_commandToServer);
//			WS.getInstance().sendCall(call);
		}else {
			if(errorBack != null){
				errorBack.run();
			}
		}


	}

}
