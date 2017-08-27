package com.mardomsara.social.pipe_pb;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.models.Message;

import java.util.List;

/**
 * Created by Hamid on 5/24/2017.
 */

public class PlayNewPipe {

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
