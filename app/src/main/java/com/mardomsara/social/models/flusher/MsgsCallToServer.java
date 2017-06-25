package com.mardomsara.social.models.flusher;

import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Req;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgSeen;
import com.mardomsara.social.pipe_pb.PBConv;
import com.mardomsara.social.pipe_pb.Pipe;
import com.mardomsara.social.pipe_pb.from_net_calls.events.MsgReceivedToServerEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_RequestMsgAddMany;
import ir.ms.pb.PB_RequestMsgsSeen;
import ir.ms.pb.PB_ResRpcAddMsg;

import static com.mardomsara.social.base.Http.Http.upload;

/**
 * Created by Hamid on 10/12/2016.
 */

public class MsgsCallToServer {
	public static void addNewTextMsg(Message msg){

		PB_Message pb_message = PBConv.Message_toNew_PB_Message(msg);
		PB_RequestMsgAddMany pb_requestMsgAddMany = PB_RequestMsgAddMany.newBuilder()
			.addMessages(pb_message)
			.build();

		Runnable succ =  ()->{
			msg.setToPush(0);
			msg.ServerReceivedTime = TimeUtil.getTimeSec();
			msg.saveWithRoom();

			MsgReceivedToServerEvent.publishNew(msg);
		};

		Pipe.makeCall(Pipe.REQUESTS.PB_RequestMsgAddMany,
			pb_requestMsgAddMany ,
			succ,null
		);

	}

	public static void addManyMsgs(List<Message> msgs){
		List<PB_Message> pb_message = PBConv.Message_toNew_PB_Message_List(msgs);
		PB_RequestMsgAddMany pb_requestMsgAddMany = PB_RequestMsgAddMany.newBuilder()
			.addAllMessages(pb_message)
			.build();

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

		Pipe.makeCall(Pipe.REQUESTS.PB_RequestMsgAddMany,
			pb_requestMsgAddMany ,
			succ,null
		);

	}

	public static void sendNewPhoto(Message msg, File resizedFile,File fileOriginal, final boolean deleteOrginal){
		msg.setNetWorkTransferring(true);

		AndroidUtil.runInBackgroundNoPanic(()->{
			PB_ResRpcAddMsg resRpcAddMsg = GRPC.getNewBlockingMsgRpc().uploadNewMsg(PBConv.Message_toNew_PB_Message(msg));
			Helper.showDebugMessage("sendNewPhoto: "+resRpcAddMsg.hasResponse());
			if(resRpcAddMsg != null){
				msg.setNetWorkTransferring(false);
				msg.setMsgFile_Status((Constants.Msg_Media_Uploaded));
				msg.setToPush(0);
				msg.ServerReceivedTime = TimeUtil.getTimeSec();
				msg.saveWithRoom();
				if(deleteOrginal == true &&  fileOriginal != null){
					fileOriginal.delete();
				}

				MsgReceivedToServerEvent.publishNew(msg);
			}


		});


		Req req = Http.upload(API.BASE_DOMAIN_URL_STR+"/msgs/v1/add_one",resizedFile)
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
		Req req = upload(API.BASE_DOMAIN_URL_STR +"msgs/v1/add_one",resizedFile)
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

		PB_RequestMsgsSeen pb_request = PB_RequestMsgsSeen.newBuilder()
			.addAllSeen(PBConv.MsgSeen_to_PB_MsgSeen_List(msgsSeen))
			.build();

		Runnable succ =  ()->{
			DB.db.transactionSync(()->{
				List<Long> ids = new ArrayList<Long>();
				for (MsgSeen seen: msgsSeen){
					ids.add(seen.NanoId);
				}
				DB.db.deleteFromMsgSeen().NanoIdIn(ids).execute();
			});
		};

		Pipe.makeCall(Pipe.REQUESTS.PB_RequestMsgsSeen,
			pb_request,
			succ,null);
	}


	////////////////////////// OLD - DELETE //////////////////////

	public static void sendNewPhoto_OLD(Message msg, File resizedFile,File fileOriginal, final boolean deleteOrginal){
		msg.setNetWorkTransferring(true);
		Req req = Http.upload(API.BASE_DOMAIN_URL_STR +"/msgs/v1/add_one",resizedFile)
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

	void play(){
		/*Double.MAX_VALUE;

		Float.MIN_NORMAL*/

	}

}
