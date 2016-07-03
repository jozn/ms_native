package com.mardomsara.social.events.from_server;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.base.NetEventHandler;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.tables.UsersTable;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.RoomsListTable;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Hamid on 5/2/2016.
 */
public class MsgCommand {
    public static NetEventHandler addSingleMsg = ( data) ->{
        MessagesTable msg = AppUtil.fromJson(data,MessagesTable.class);
        if(msg==null)return;
        AppUtil.log("addSingleMsg: cmd -> "+data);
        RoomsListTable.onRecivedNewMsg(msg);
        UsersTable.onRecivedNewMsg(msg);
//        AppUtil.runInUi(()->{RoomsListAdaptor.up.run();});
        EventBus.getDefault().post(msg);
        msg.save();
    };

    public static NetEventHandler SetUserForTable = ( data) -> {
        UsersTable c = JsonUtil.fromJson(data,UsersTable.class);

        c.save();

    };

    public static NetEventHandler MsgsAddNew = (data) ->{
        MessagesTable[] msgs = AppUtil.fromJson(data,MessagesTable[].class);
        if(msgs==null)return;
        AppUtil.log("MsgsAddNew: cmd -> "+data);
        for (MessagesTable msg : msgs) {
            MessagesTable.setParamsForNewMsgRecivedFromNet(msg);


            RoomsListTable.onRecivedNewMsg(msg);
            UsersTable.onRecivedNewMsg(msg);
//            AppUtil.runInUi(()->{RoomsListAdaptor.up.run();});
//            EventBus.getDefault().
//            msg.save();
            handleNewMsgFunctionalitiesForTypes(msg);
            EventBus.getDefault().post(msg);


            MessagesTable.sendToServerMsgsReceivedToPeerCmd(msg);
        }
    };

    //don't block return fast
    private static void handleNewMsgFunctionalitiesForTypes(MessagesTable msg) {
        switch (msg.getMessageTypeId() ){
            case Constants.MESSAGE_TEXT:
                msg.save();
                break;

            case Constants.MESSAGE_IMAGE:
                AndroidUtil.runInBackground(()->{
//                    String fileName = AppFiles.PHOTO_DIR_PATH + msg.getMediaName();
                    String $fileName = AppFiles.PHOTO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.getMediaExtension();
//                    File file = new File(fileName);
//                    File file = FileUtil.createNextName($fileName);
                    String fileName = FileUtil.createNextName($fileName);
                    msg.setMediaLocalSrc(fileName);
                    msg.setMediaStatus(Constants.Msg_Media_To_Upload);
                    msg.save();
                    Http.downloadFile(msg.getMediaServerSrc(),fileName,
                            ()->{//callback
                                msg.setMediaStatus(Constants.Msg_Media_Downloaded);
                                msg.save();
                                MessagesTable.publishMsgGeneralChangeEvent(msg);

                            },
                            ()->{//errorback

                            });
                });
                break;

            case Constants.MESSAGE_VIDEO:
                AndroidUtil.runInBackground(()->{
                    String $fileName = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.getMediaExtension();
                    String fileName = FileUtil.createNextName($fileName);
                    msg.setMediaLocalSrc(fileName);
                    msg.setMediaStatus(Constants.Msg_Media_To_Upload);
                    msg.save();
                    Http.downloadFile(msg.getMediaServerSrc(),fileName,
                            ()->{//callback
//                                String $thumbPath = AppFiles.VIDEO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.getMediaExtension();
//                                String thumbPath = FileUtil.createNextName($thumbPath);
                                msg.setMediaStatus(Constants.Msg_Media_Downloaded);
                                MessagesTable.setVideoExtraParams(msg,fileName );
                                msg.save();
                                MessagesTable.publishMsgGeneralChangeEvent(msg);
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
            MessagesTable msg = MessagesTable.getMessageByKey(m.MessageKey);
            AppUtil.log("MsgsReceivedToServer For: " + m.toString() + msg);
            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
                msg.setServerReceivedTime((int) (m.AtTimeMs/1000));
                msg.setToPush(0);
                msg.save();
//                MessagesTable.publishEvent(m);
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
            MessagesTable msg = MessagesTable.getMessageByKey(m.MessageKey);
            if(msg != null && msg.getRoomKey().equals(m.RoomKey)){
                msg.setPeerReceivedTime((int) (m.AtTimeMs/1000));
                msg.save();
//                MessagesTable.publishEvent(m);
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
            MessagesTable.makeMsgsSeen(m.ExtraData ,m);
            EventBus.getDefault().post(m);
//            MessagesTable msg = MessagesTable.getMessageByKey(m.MessageKey);
//            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
//                msg.setPeerSeenTime((int) (m.AtTimeMs/1000));
//                msg.save();
////                MessagesTable.publishEvent(m);
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
            MessagesTable msg = MessagesTable.getMessageByKey(m.MessageKey);
            if(msg != null && msg.RoomKey.equals(m.RoomKey)){
                msg.setServerDeletedTime((int) (m.AtTimeMs/1000));
                msg.save();
//                MessagesTable.publishEvent(m);
                EventBus.getDefault().post(m);
            }
            //todo: implement event to UI
        }
    };

}
