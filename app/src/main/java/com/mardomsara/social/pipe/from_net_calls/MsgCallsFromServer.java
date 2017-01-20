package com.mardomsara.social.pipe.from_net_calls;

import com.mardomsara.social.App;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.pipe.NetEventHandler;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddOneJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgSeenByPeerJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 5/2/2016.
 */
public class MsgCallsFromServer {
    public static NetEventHandler MsgAddOne = ( data) ->{
		MsgAddOneJson jd = AppUtil.fromJson(data,MsgAddOneJson.class);
        if(jd==null || jd.Message == null )return;
        AppUtil.log("NotifyRemoveMany: -> "+data);

		handleNewSingleMsg(jd.Message);
		handleNewUser(jd.User);
		App.getBus().post(jd);
    };

	public static NetEventHandler MsgAddMany = ( data) ->{
		MsgAddManyJson jd = AppUtil.fromJson(data,MsgAddManyJson.class);
		if(jd==null || jd.Messages == null )return;
		AppUtil.log("NotifyAddOne: cmd -> "+data);

		DB.db.transactionSync(()->{
			for(Message msg: jd.Messages){
				//Modifications of handleNewSingleMsg
				MessageModel.setParamsForNewMsgRecivedFromNet(msg);
//				RoomModel.onRecivedNewMsg(msg);
				handleNewMsgFunctionalitiesForTypes(msg);
//				App.getBus().post(msg);

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
//			RoomModel.messageHasInsertIntoRoomUpdateRoomInfo(msg);
			roomS.put(msg.RoomKey,msg);
		}
//		RoomModel.massUpdateOfRoomsForNewMsgs(roomS.keySet());
		RoomModel.massUpdateOfRoomsForNewMsgs(roomS.values());



		App.getBus().post(jd);
	};

	static void handleNewSingleMsg(Message msg){
		MessageModel.setParamsForNewMsgRecivedFromNet(msg);
//		RoomModel.onRecivedNewMsg(msg);
//		RoomModel.messageHasInsertIntoRoomUpdateRoomInfo(msg);
		handleNewMsgFunctionalitiesForTypes(msg);

		msg.saveWithRoom();

		App.getBus().post(msg);

//		MessageModel.sendToServerMsgsReceivedToPeerCmd(msg);
	}

	static void handleNewUser(User user){
		UserModel.saveNewUser(user);
	}


	public static NetEventHandler MsgsReceivedToPeerMany = ( data) ->{
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

	public static NetEventHandler MsgsDeletedFromServerMany = ( data) ->{
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

	public static NetEventHandler MsgsSeenByPeerMany = ( data) ->{
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
//                    String fileName = AppFiles.PHOTO_DIR_PATH + msg.getMediaName();
                    String $fileName = AppFiles.PHOTO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.MediaExtension;
//                    File file = new File(fileName);
//                    File file = FileUtil.createNextName($fileName);
                    String fileName = FileUtil.createNextName($fileName);
                    msg.MediaLocalSrc = fileName;
                    msg.MediaStatus = Constants.Msg_Media_To_Upload;
                    msg.saveWithRoom();
                    HttpOld.downloadFile(msg.MediaServerSrc,fileName,
                            ()->{//callback
                                msg.MediaStatus = Constants.Msg_Media_Downloaded ;
                                msg.saveWithRoom();
                                MessageModel.publishMsgGeneralChangeEvent(msg);

                            },
                            ()->{//errorback

                            });
                });
                break;

            case Constants.MESSAGE_VIDEO:
                AndroidUtil.runInBackground(()->{
                    String $fileName = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.MediaExtension;
                    String fileName = FileUtil.createNextName($fileName);
                    msg.MediaLocalSrc = fileName;
                    msg.MediaStatus = Constants.Msg_Media_To_Upload;
                    msg.saveWithRoom();
                    HttpOld.downloadFile(msg.MediaServerSrc ,fileName,
                            ()->{//callback
//                                String $thumbPath = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.getMediaExtension();
//                                String thumbPath = FileUtil.createNextName($thumbPath);
                                msg.MediaStatus = Constants.Msg_Media_Downloaded;
                                MessageModel.setVideoExtraParams(msg,fileName );
                                msg.saveWithRoom();
                                MessageModel.publishMsgGeneralChangeEvent(msg);
                            },
                            ()->{//errorback

                            });
                });
                break;



        }
    }

}
