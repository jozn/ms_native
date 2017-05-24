package com.mardomsara.social.pipe_pb.from_net_calls;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Req;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgSeen;
import com.mardomsara.social.pipe_pb.Call_DEP;
import com.mardomsara.social.pipe_pb.Pipe_DEP;
import com.mardomsara.social.pipe_pb.from_net_calls.events.MsgReceivedToServerEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.mardomsara.social.base.Http.Http.upload;

/**
 * Created by Hamid on 10/12/2016.
 */

public class MsgsCallToServer {
	public static void addNewTextMsg(Message msg){
		Call_DEP call = new Call_DEP("MsgsAddOne",msg);

		Runnable succ =  ()->{
			msg.setToPush(0);
			msg.ServerReceivedTime = TimeUtil.getTimeSec();
			msg.saveWithRoom();

			MsgReceivedToServerEvent.publishNew(msg);
		};

		Pipe_DEP.sendCall(call,succ,null);
	}

	public static void addManyMsgs(List<Message> msgs){
		Call_DEP call = new Call_DEP("MsgsAddMany",msgs);

		Runnable succ =  ()->{
			DB.db.transactionSync(()->{
				for(Message msg: msgs){
					msg.setToPush(0);
					msg.ServerReceivedTime = TimeUtil.getTimeSec();
					msg.saveWithRoom();
				}
			});

			for(Message msg: msgs){
				MsgReceivedToServerEvent.publishNew(msg);
			}
		};

		Pipe_DEP.sendCall(call,succ,null);
	}

	public static void sendNewPhoto(Message msg, File resizedFile,File fileOriginal, final boolean deleteOrginal){
		msg.setNetWorkTransferring(true);
		Req req = Http.upload("http://localhost:5000/msgs/v1/add_one",resizedFile)
			.setFormParam("message", JsonUtil.toJson(msg))
			.setUploadProgress(msg)
			.doAsync(
				(result)->{
					Helper.showDebugMessage("sendNewPhoto "+result.isOk());
					msg.setNetWorkTransferring(false);
					if (result.isOk()){
						Helper.showDebugMessage("sendNewPhoto ok");
						msg.setMsgFile_Status((Constants.Msg_Media_Uploaded));
						msg.setToPush(0);
						msg.ServerReceivedTime = TimeUtil.getTimeSec();
						msg.saveWithRoom();
						if(deleteOrginal == true &&  fileOriginal != null){
							fileOriginal.delete();
						}

						MsgReceivedToServerEvent.publishNew(msg);
					}else {

					}
				});

		msg.req = req;
	}


	public static void sendNewVideo(Message msg, File resizedFile){
		msg.setNetWorkTransferring(true);
		Req req = upload("http://localhost:5000/msgs/v1/add_one",resizedFile)
			.setFormParam("message", JsonUtil.toJson(msg))
			.setUploadProgress(msg)
			.doAsync(
				(result)->{
					msg.setNetWorkTransferring(false);
					if (result.isOk()){
						msg.setMsgFile_Status((Constants.Msg_Media_Uploaded));
						msg.setToPush(0);
						msg.ServerReceivedTime = TimeUtil.getTimeSec();
						msg.saveWithRoom();

						MsgReceivedToServerEvent.publishNew(msg);
					};
				});

		msg.req = req;

	}

	public static void sendSeenMsgs(List<MsgSeen> msgsSeen) {
		Call_DEP call = new Call_DEP("MsgsSeenMany",msgsSeen);

		Runnable succ =  ()->{
			DB.db.transactionSync(()->{
				List<Long> ids = new ArrayList<Long>();
				for (MsgSeen seen: msgsSeen){
					ids.add(seen.NanoId);
				}
				DB.db.deleteFromMsgSeen().NanoIdIn(ids).execute();
			});
		};

		Pipe_DEP.sendCall(call,succ,null);
	}

}
