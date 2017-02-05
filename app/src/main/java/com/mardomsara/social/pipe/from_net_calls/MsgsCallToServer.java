package com.mardomsara.social.pipe.from_net_calls;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.listener.UploadProgressListener;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgSeen;
import com.mardomsara.social.pipe.Call;
import com.mardomsara.social.pipe.Pipe;
import com.mardomsara.social.pipe.from_net_calls.events.MsgReceivedToServerEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/12/2016.
 */

public class MsgsCallToServer {
	public static void addNewMsg(Message msg){
		Call call = new Call("MsgsAddOne",msg);

		Runnable succ =  ()->{
			msg.ToPush = 0;
			msg.ServerReceivedTime = TimeUtil.getTime();
			msg.saveWithRoom();

			MsgReceivedToServerEvent.publishNew(msg);
		};

		Pipe.sendCall(call,succ,null);
	}

	public static void addManyMsgs(List<Message> msgs){
		Call call = new Call("MsgsAddMany",msgs);

		Runnable succ =  ()->{
			DB.db.transactionSync(()->{
				for(Message msg: msgs){
					msg.ToPush = 0;
					msg.ServerReceivedTime = TimeUtil.getTime();
					msg.saveWithRoom();
				}
			});

			for(Message msg: msgs){
				MsgReceivedToServerEvent.publishNew(msg);
			}
		};

		Pipe.sendCall(call,succ,null);
	}

	public static void sendNewPhoto(Message msg, File resizedFile,File fileOriginal, final boolean deleteOrginal){
		Http.upload("http://localhost:5000/msgs/v1/add_one",resizedFile)
			.setFormParam("message", JsonUtil.toJson(msg))
			.setUploadProgress(new UploadProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					AppUtil.log("progress: "+ bytesRead + " " + contentLength + " " + done );
				}
			})
			.doAsync(
				(result)->{
					if (result.isOk()){
						msg.MsgFile_Status = (Constants.Msg_Media_Uploaded);
						msg.ToPush = 0;
						msg.ServerReceivedTime = TimeUtil.getTime();
						msg.saveWithRoom();
						if(deleteOrginal == true &&  fileOriginal != null){
							fileOriginal.delete();
						}

						MsgReceivedToServerEvent.publishNew(msg);
					};
				});

	}


	public static void sendNewVideo(Message msg, File resizedFile){
		Http.upload("http://localhost:5000/msgs/v1/add_one",resizedFile)
			.setFormParam("message", JsonUtil.toJson(msg))
			.doAsync(
				(result)->{
					if (result.isOk()){
						msg.MsgFile_Status = (Constants.Msg_Media_Uploaded);
						msg.ToPush = 0;
						msg.ServerReceivedTime = TimeUtil.getTime();
						msg.saveWithRoom();

						MsgReceivedToServerEvent.publishNew(msg);
					};
				});

	}

	public static void sendSeenMsgs(List<MsgSeen> msgsSeen) {
		Call call = new Call("MsgsSeenMany",msgsSeen);

		Runnable succ =  ()->{
			DB.db.transactionSync(()->{
				List<Long> ids = new ArrayList<Long>();
				for (MsgSeen seen: msgsSeen){
					ids.add(seen.NanoId);
				}
				DB.db.deleteFromMsgSeen().NanoIdIn(ids).execute();
			});
		};

		Pipe.sendCall(call,succ,null);
	}

}
