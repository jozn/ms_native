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
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.pipe.NetEventHandler;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddOneJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgSeenByPeerJson;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Hamid on 5/2/2016.
 */
public class MsgCalls {
    public static NetEventHandler MsgAddOne = ( data) ->{
		MsgAddOneJson jd = AppUtil.fromJson(data,MsgAddOneJson.class);
        if(jd==null || jd.Message == null )return;
        AppUtil.log("MsgAddOne: -> "+data);

		handleNewMsg(jd.Message);
		handleNewUser(jd.User);
		App.getBus().post(jd);
    };

	public static NetEventHandler MsgAddMany = ( data) ->{
		MsgAddManyJson jd = AppUtil.fromJson(data,MsgAddManyJson.class);
		if(jd==null || jd.Messages == null )return;
		AppUtil.log("MsgAddMany: cmd -> "+data);

		DB.db.transactionSync(()->{
			for(Message msg: jd.Messages){
				//Modifications of handleNewMsg
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

		for(Message msg: jd.Messages){
			RoomModel.messageHasInsertIntoRoomUpdateRoomInfo(msg);
		}
	};

	static void handleNewMsg(Message msg){
		MessageModel.setParamsForNewMsgRecivedFromNet(msg);
//		RoomModel.onRecivedNewMsg(msg);
		RoomModel.messageHasInsertIntoRoomUpdateRoomInfo(msg);
		handleNewMsgFunctionalitiesForTypes(msg);
		App.getBus().post(msg);

		msg.save();
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

	///////////////////// Deps ///////////////////////////////
    public static NetEventHandler SetUserForTable = ( data) -> {
        User c = JsonUtil.fromJson(data,User.class);
        UserModel.create(c);
    };

    public static NetEventHandler MsgsAddNew = (data) ->{
        Message[] msgs = AppUtil.fromJson(data,Message[].class);
        if(msgs==null)return;
        AppUtil.log("MsgsAddNew: cmd -> "+data);
        for (Message msg : msgs) {
            MessageModel.setParamsForNewMsgRecivedFromNet(msg);


            RoomModel.onRecivedNewMsg(msg);
            UserModel.onRecivedNewMsg(msg);
//            AppUtil.runInUi(()->{RoomsListAdaptor.up.run();});
//            EventBus.getDefault().
//            msg.save();
            handleNewMsgFunctionalitiesForTypes(msg);
            EventBus.getDefault().post(msg);


            MessageModel.sendToServerMsgsReceivedToPeerCmd(msg);
        }
    };

    //don't block return fast
    private static void handleNewMsgFunctionalitiesForTypes(Message msg) {
        switch (msg.MessageTypeId){
            case Constants.MESSAGE_TEXT:
                msg.save();
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
                    msg.save();
                    HttpOld.downloadFile(msg.MediaServerSrc,fileName,
                            ()->{//callback
                                msg.MediaStatus = Constants.Msg_Media_Downloaded ;
                                msg.save();
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
                    msg.save();
                    HttpOld.downloadFile(msg.MediaServerSrc ,fileName,
                            ()->{//callback
//                                String $thumbPath = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.getMediaExtension();
//                                String thumbPath = FileUtil.createNextName($thumbPath);
                                msg.MediaStatus = Constants.Msg_Media_Downloaded;
                                MessageModel.setVideoExtraParams(msg,fileName );
                                msg.save();
                                MessageModel.publishMsgGeneralChangeEvent(msg);
                            },
                            ()->{//errorback

                            });
                });
                break;



        }
    }

    public static NetEventHandler MsgsReceivedToServer = (data) ->{
        MsgsSyncMetaReceivedToServer[] metas = JsonUtil.fromJson(data, MsgsSyncMetaReceivedToServer[].class);
        if(metas == null) return;
        AppUtil.log("MsgsReceivedToServer size:" + metas.length);
        for (MsgsSyncMetaReceivedToServer m : metas){
            Message msg = MessageModel.getMessageByKey(m.MessageKey);
            AppUtil.log("MsgsReceivedToServer For: " + m.toString() + msg);
            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
                msg.ServerReceivedTime = ((int) (m.AtTimeMs/1000));
                msg.ToPush = 0;
                msg.save();
//                MessagesModel.publishEvent(m);
                EventBus.getDefault().post(m);
            }
            //todo: implement event to UI
        }

    };

    public static NetEventHandler MsgsReceivedToPeer = (data) ->{
        MsgsSyncMetaReceivedToPeer[] metas = JsonUtil.fromJson(data, MsgsSyncMetaReceivedToPeer[].class);
        if(metas == null) return;
        AppUtil.log("MsgsReceivedToPeer" + metas.toString());
        for (MsgsSyncMetaReceivedToPeer m : metas){
            Message msg = MessageModel.getMessageByKey(m.MessageKey);
            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
                msg.PeerReceivedTime = ((int) (m.AtTimeMs/1000));
                msg.save();
//                MessagesModel.publishEvent(m);
                EventBus.getDefault().post(m);
            }
            //todo: implement event to UI
        }
    };

    public static NetEventHandler MsgsSeenByPeer = (data) ->{
        MsgsSyncMetaSeenByPeer[] metas = JsonUtil.fromJson(data, MsgsSyncMetaSeenByPeer[].class);
        if(metas == null) return;
        AppUtil.log("MsgsSeenByPeer " + metas.toString());
        for (MsgsSyncMetaSeenByPeer m : metas){
            MessageModel.makeMsgsSeen(m.ExtraData ,m);
            EventBus.getDefault().post(m);
//            MessagesTable msg = MessagesModel.getMessageByKey(m.MessageKey);
//            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
//                msg.setPeerSeenTime((int) (m.AtTimeMs/1000));
//                msg.save();
////                MessagesModel.publishEvent(m);
//                EventBus.getDefault().post(m);
//            }
            //todo: implement event to UI
        }
    };

    public static NetEventHandler MsgsDeletedFromServer = (data) ->{
        MessageSyncMeta[] metas = JsonUtil.fromJson(data, MessageSyncMeta[].class);
        if(metas == null) return;
        AppUtil.log("MsgsDeletedFromServer " + metas.toString());
        for (MessageSyncMeta m : metas){
            Message msg = MessageModel.getMessageByKey(m.MessageKey);
            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
                msg.ServerDeletedTime = ((int) (m.AtTimeMs/1000));
                msg.save();
//                MessagesTable.publishEvent(m);
                EventBus.getDefault().post(m);
            }
            //todo: implement event to UI
        }
    };

}
