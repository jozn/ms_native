package com.mardomsara.social.pipe_pb;

import com.google.protobuf.AbstractMessageLite;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.TimeUtil;

import ir.ms.pb.PB_CommandToServer;

public class Pipe {
	public static class REQUESTS {
		public static final String  REQUEST_PB_CommandToServer = "PB_CommandToServer";
		public static final String  REQUEST_PB_CommandToClient = "PB_CommandToClient";

		public static final String  PB_RequestMsgAddMany = "PB_RequestMsgAddMany";
		public static final String  PB_RequestMsgsSeen = "PB_RequestMsgsSeen";
		public static final String  REQUEST_PB_RequestMsgAddOne = "PB_ResponseMsgAddMany";

		public static final String  REQUEST_PB_PushMsgAddMany = "PB_PushMsgAddMany";
	}



	public static void cancelCall(long callid){
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

	public static <T> void makeCall(String command, AbstractMessageLite data, CommandCallBack<T> callBack, Runnable errorBack ,Class cls){
		if(data == null) return;
		long callId = TimeUtil.getTimeNano();
		PB_CommandToServer pb_commandToServer = PB_CommandToServer.newBuilder()
			.setCommand(command)
			.setCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();


		if(WS.getInstance().isOpen()){
			CallRespondCallback callRespondCallback = new CallRespondCallback(callBack,errorBack,callId);
			callRespondCallback.responseClass = cls.getName();
			CallRespondCallbacksRegistery.register(callRespondCallback);
			WS.getInstance().sendCall(pb_commandToServer);
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
			.setCommand(command)
			.setCallId(callId)
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();

		if(WS.getInstance().isOpen()){
			CallRespondCallback callRespondCallback = new CallRespondCallback(succBack,errorBack,callId);
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
