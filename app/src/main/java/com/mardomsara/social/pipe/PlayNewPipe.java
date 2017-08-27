package com.mardomsara.social.pipe;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.models.Message;
//import com.mardomsara.social.pipe.del.Pipe;

import java.util.List;

import ir.ms.pb.PB_MsgParam_AddNewTextMessage;
import ir.ms.pb.PB_MsgResponse_AddNewTextMessage;

/**
 * Created by Hamid on 5/24/2017.
 */

public class PlayNewPipe {
	interface PB_MsgResponse_AddNewTextMessage_Caller {
		void onRes(PB_MsgResponse_AddNewTextMessage res);
	}

	interface Errorback {
		void onRes(PB_MsgResponse_AddNewTextMessage res);
	}

	void Addmsg(PB_MsgParam_AddNewTextMessage parm, PB_MsgResponse_AddNewTextMessage_Caller res, Errorback err, Runnable reached ){
		Pipe.send("rpc",parm,null,null);
		/*SuccessCallback callback = null;
		if(res != null){
			SuccessCallback callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_AddNewTextMessage d =PB_MsgResponse_AddNewTextMessage.parseFrom(data);
						res.onRes(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_AddNewTextMessage");
					}
				}
			};
		}*/

	}

	public static void run1(){
		PipeWS.getInstance();

		AndroidUtil.runInBackgroundNoPanic(()->{
			int i =0;
			List<Message> msgs=  DB.db.selectFromMessage().toList();
			for (Message m : msgs){
				/*PipeCallBack<PB_ResponseMsgAddOne> callBack = (pb_responsMsgAddOne) -> pb_responsMsgAddOne.getResponse() ;
				Runnable err = ()->{
					AppUtil.log("+++++++++++++++++ ERRoR");
					Helper.showDebugMessage("TTTTT");
				};

				PB_Message pb_message = PBConv.Message_toNew_PB_Message(m);
				AppUtil.log("MSG_ADD_DAT " + pb_message.toString());
				Pipe.makeCall("MSG_ADD" ,pb_message, callBack,err ) ;
				if (i == 2) return;
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			}

		});

	}
}
