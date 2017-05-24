package com.mardomsara.social.pipe_pb;

import com.google.protobuf.AbstractMessageLite;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;

import ir.ms.pb.PB_CommandToClient;
import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_RequestMsgAddMany;
import ir.ms.pb.PB_ResponsMsgAddMany;
import ir.ms.pb.PB_UserWithMe;

/**
 * Created by Hamid on 5/23/2017.
 */

public class Call2<T> {
	public static void make(String command, byte[] data ){
		if(data == null) return;
		PB_CommandToClient pbCommandToClient = PB_CommandToClient.newBuilder()
			.setCommand(command)
			.setCallId(LangUtil.getRandom(10000000))
			.setData(com.google.protobuf.ByteString.copyFrom(data))
			.build();

	}

	public static void make(String command, AbstractMessageLite data ){
		if(data == null) return;
		PB_CommandToClient pbCommandToClient = PB_CommandToClient.newBuilder()
			.setCommand(command)
			.setCallId(LangUtil.getRandom(10000000))
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();

	}


	public static void sendCall(Call2 call, Runnable success , Runnable error){

	}


	void play(){
		PB_Message msg = PB_Message.newBuilder()
			.setIsByMe(0)
			.setText("dasdasd")
			.setUserId(125L)
			.setCreatedMs(TimeUtil.getTimeMs())
			.build();

		make("MsgAddMsg", msg.toByteArray());

		PB_RequestMsgAddMany pb_requestMsgAddMany = PB_RequestMsgAddMany.newBuilder()
			.addMessages(msg)
			.addMessages(msg)
			.addUsers(PB_UserWithMe.newBuilder().setAbout("scsd").setFullName("sdc").setUserId(25).build())
			.build();

		make2("MsgAddMany", pb_requestMsgAddMany,new CommandCallBack<PB_ResponsMsgAddMany>(){

			@Override
			public void onResponse(PB_ResponsMsgAddMany res) {
				res.getRespons().getStatus();
			}
		});


		make2("MsgAddMany", pb_requestMsgAddMany, (PB_ResponsMsgAddMany res)->res.getRespons() );

	}

	public static <T> void make2(String command, AbstractMessageLite data, CommandCallBack<T> callBack ){
		if(data == null) return;
		PB_CommandToClient pbCommandToClient = PB_CommandToClient.newBuilder()
			.setCommand(command)
			.setCallId(LangUtil.getRandom(10000000))
			.setData(com.google.protobuf.ByteString.copyFrom(data.toByteArray()))
			.build();
	}

	static class Res<N>{
		N response;

	}
}
