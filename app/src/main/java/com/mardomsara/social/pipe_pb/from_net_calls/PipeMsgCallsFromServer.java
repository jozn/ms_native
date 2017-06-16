package com.mardomsara.social.pipe_pb.from_net_calls;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mardomsara.social.App;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.app.Monitor;
import com.mardomsara.social.app.MonitorCraches;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.MessageNetModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.pipe_pb.NetEventHandler_DEP;
import com.mardomsara.social.pipe_pb.PBConv;
import com.mardomsara.social.pipe_pb.PipeNetEventHandler;
import com.mardomsara.social.pipe_pb.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe_pb.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.pipe_pb.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.pipe_pb.from_net_calls.json.MsgSeenByPeerJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ir.ms.pb.PB_Message;
import ir.ms.pb.PB_PushMsgAddMany;
import ir.ms.pb.PB_UserWithMe;

/**
 * Created by Hamid on 5/2/2016.
 */
public class PipeMsgCallsFromServer {
    public static PipeNetEventHandler PB_PushMsgAddMany_Handler = (data) -> {
		try {
			PB_PushMsgAddMany pbPushMsgAddMany = PB_PushMsgAddMany.parseFrom(data);
			MessageNetModel.onNewMessagesFromPipe(pbPushMsgAddMany);
		}catch (InvalidProtocolBufferException e){
			MonitorCraches.log(e);
		}
    };

	public static PipeNetEventHandler PB_PushMsgAddMany_Handler2 = (data) ->{
		PB_PushMsgAddMany pbPushMsgAddMany = PB_PushMsgAddMany.parseFrom(data);
		for (PB_Message pbMsg :pbPushMsgAddMany.getMessagesList()){
			handleNewSingleMsg(PBConv.PB_Message_toNew_Message(pbMsg));
		}

		DB.db.transactionSync(()->{

			/*for(Message msg: jd.Messages){
				MessageModel.setParamsForNewMsgRecivedFromNet(msg);
				handleNewMsgFunctionalitiesForTypes(msg);

				msg.save();
			}*/
		});

		DB.db.transactionSync(()->{
			/*for(User user: jd.Users){
				UserModel.saveNewUser(user);
			}*/
		});

		for (PB_UserWithMe pbMsg :pbPushMsgAddMany.getUsersList()){
			handleNewUser(PBConv.PB_UserWithMe_toNew_User(pbMsg));
		}

		Helper.showDebugMessage("Msg: "+pbPushMsgAddMany.getMessagesList().size() + " Users: "  + pbPushMsgAddMany.getUsersList().size() );

		/*MsgAddOneJson jd = AppUtil.fromJson(data,MsgAddOneJson.class);
        if(jd==null || jd.Message == null )return;
        AppUtil.log("NotifyRemoveMany: -> "+data);

		handleNewSingleMsg(jd.Message);
		handleNewUser(jd.User);*/
//		App.getBus().post(jd);
	};

	public static NetEventHandler_DEP MsgAddMany = (data) ->{
		MsgAddManyJson jd = AppUtil.fromJson(data,MsgAddManyJson.class);
		if(jd==null || jd.Messages == null )return;
		AppUtil.log("NotifyAddOne: cmd -> "+data);

		DB.db.transactionSync(()->{
			for(Message msg: jd.Messages){
				MessageModel.setParamsForNewMsgRecivedFromNet(msg);
				handleNewMsgFunctionalitiesForTypes(msg);

				msg.save();
			}
		});

		DB.db.transactionSync(()->{
			for(User user: jd.Users){
				UserModel.saveNewUser(user);
			}
		});

		Map<String,Message> roomS = new HashMap<>();
		for(Message msg: jd.Messages){
			roomS.put(msg.RoomKey,msg);
		}
		RoomModel.massUpdateOfRoomsForNewMsgs(roomS.values());



		App.getBus().post(jd);
	};

	private static void handleNewSingleMsg(Message msg){
		MessageModel.setParamsForNewMsgRecivedFromNet(msg);
		handleNewMsgFunctionalitiesForTypes(msg);

		msg.saveWithRoom();

		App.getBus().post(msg);

	}

	static void handleNewUser(User user){
		UserModel.saveNewUser(user);
	}


	public static NetEventHandler_DEP MsgsReceivedToPeerMany = (data) ->{
		AppUtil.log("MsgsReceivedToPeerMany: cmd -> "+data);
		List<MsgReceivedToPeerJson> res = JsonUtil.fromJsonList(data,MsgReceivedToPeerJson.class);
		if(res == null || res.size() ==0)return;

		DB.db.transactionSync(()->{
			for(MsgReceivedToPeerJson meta : res){
				AppUtil.log("MsgsReceivedToPeerMany: for  -> "+meta);
				DB.db.updateMessage()
					.PeerReceivedTime(meta.AtTime)//updtaed
					.MessageKeyEq(meta.MsgKey)
					.RoomKeyEq(meta.RoomKey)
					.execute();
			}
		});

		for(MsgReceivedToPeerJson meta : res){
			App.getBus().post(meta);
		}
	};

	public static NetEventHandler_DEP MsgsDeletedFromServerMany = (data) ->{
		List<MsgDeletedFromServerJson> res = JsonUtil.fromJsonList(data,MsgDeletedFromServerJson.class);
		if(res == null || res.size() ==0)return;

		DB.db.transactionSync(()->{
			for(MsgDeletedFromServerJson meta : res){
				DB.db.updateMessage()
					.ServerDeletedTime(meta.AtTime)//updtaed
					.MessageKeyEq(meta.MsgKey)
					.RoomKeyEq(meta.RoomKey)
					.execute();
			}
		});

		for(MsgDeletedFromServerJson meta : res){
			App.getBus().post(meta);
		}
	};

	public static NetEventHandler_DEP MsgsSeenByPeerMany = (data) ->{
		List<MsgSeenByPeerJson> res = JsonUtil.fromJsonList(data, MsgSeenByPeerJson.class);
		if(res == null || res.size() ==0)return;

		DB.db.transactionSync(()->{
			for(MsgSeenByPeerJson meta : res){
				DB.db.updateMessage()
					.PeerSeenTime(meta.AtTime)//updtaed
					.MessageKeyEq(meta.MsgKey)
					.RoomKeyEq(meta.RoomKey)
					.execute();
			}
		});

		for(MsgSeenByPeerJson meta : res){
			App.getBus().post(meta);
		}
	};

    //don't block return fast
    private static void handleNewMsgFunctionalitiesForTypes(Message msg) {
        switch (msg.MessageTypeId){
            case Constants.MESSAGE_TEXT:
//                msg.saveWithRoom();
                break;

            case Constants.MESSAGE_IMAGE:
                AndroidUtil.runInBackground(()->{
					MsgFile msgFile = msg.MsgFile;
					if(msgFile!= null){
						String $fileName = AppFiles.PHOTO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msgFile.Extension;
						String fileName = FileUtil.createNextName($fileName);
						msgFile.LocalSrc = fileName;
						msgFile.Origin = Constants.Msg_Media_Origin_Server;
						msg.MsgFile_LocalSrc = fileName;
						msg.setMsgFile_Status(Constants.Msg_Media_To_Download);
						msg.saveWithRoom();
						/*HttpOld.downloadFile(msgFile.ServerSrc,fileName,
							()->{//callback
								msg.setMsgFile_Status(Constants.Msg_Media_Downloaded);
								msg.saveWithRoom();
								MessageModel.publishMsgGeneralChangeEvent(msg);

							},
							()->{//errorback

							});*/
					}
				});
                break;

            case Constants.MESSAGE_VIDEO:
                AndroidUtil.runInBackground(()->{
					MsgFile msgFile = msg.MsgFile;
					if(msgFile != null){
						String $fileName = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msgFile.Extension;
						String fileName = FileUtil.createNextName($fileName);
						msg.MsgFile_LocalSrc = fileName;
						msgFile.LocalSrc = fileName;
						msgFile.Origin = Constants.Msg_Media_Origin_Server;
						msg.setMsgFile_Status(Constants.Msg_Media_To_Download);
						msg.saveWithRoom();
						HttpOld.downloadFile(msgFile.ServerSrc ,fileName,
							()->{//callback
								msg.setMsgFile_Status(Constants.Msg_Media_Downloaded);
								MessageModel.setVideoExtraParams(msgFile,fileName );
								msg.saveWithRoom();
								MessageModel.publishMsgGeneralChangeEvent(msg);
							},
							()->{//errorback

							});
					}

                });
                break;



        }
    }

}
