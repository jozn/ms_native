package com.mardomsara.social.models;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.helpers.VideoMetasHelper;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.extra.MsgExtraPhotoThumbnail;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.service.WSService;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 9/5/2016.
 */
public class MessageModel {

    public static List<Message> getRoomMessages(String roomKey, int page) {
        return DB.db.selectFromMessage().RoomKeyEq(roomKey).orderByCreatedDeviceMsDesc().toList();
    }

    public static List<Message> getAllRoomsMessages(String roomKey) {
        return DB.db.selectFromMessage().RoomKeyEq(roomKey).orderByCreatedDeviceMsDesc().toList();
    }

    //FIXME: Primery key??
    public static Message getMessageByKey(String msgKey) {
        return DB.db.selectFromMessage().MessageKeyEq(msgKey).getOrNull(0);
//        return null;
    }

    public static Message newTextMsgForRoom(Room room) {
        Message msg = new Message();
        msg.RoomKey = room.RoomKey;
        msg.DeliveryStatus = 0;
        msg.IsByMe = 1;
        msg.RoomTypeId = room.RoomTypeId;
        msg.CreatedMs = AppUtil.getTimeMs();
        msg.CreatedDeviceMs = AppUtil.getTimeMs();
        msg.MessageTypeId = Constants.MESSAGE_TEXT;
        msg.UserId = Session.getUserId();
        msg.MessageKey = LangUtil.getRandomString(20);
        msg.ToPush = 1;
        return msg;
    }

    public static  void setParamsForNewMsgRecivedFromNet(Message msg){
        msg.CreatedDeviceMs = TimeUtil.getTimeMs();
        msg.IsByMe = 0;
        msg.ToPush = 0;
        msg.MediaStatus =0 ;
    }

    public static  int getUserId(Message msg) {
        return msg.UserId;
    }

    public static void syncToServer(Message msg ) {
        Command cmd = new Command();
        cmd.Name = Constants.MsgsAddNew;
        cmd.Data = JsonUtil.toJson(msg);

        WSService.sendCommand(cmd);
        //onAddedNewMsgEvent(msg);
    }

    public static void sendToServerMsgsSeenByPeerCmd(Message msg){
        Command cmd = Command.getNew(Constants.MsgsSeenByPeer);
        ArrayList<String> seenList = new ArrayList<String>();
        seenList.add(msg.MessageKey);

        MsgsSyncMetaSeenByPeer meta = new MsgsSyncMetaSeenByPeer();
        meta.ByUserId = Session.getUserId();
        meta.MessageKey = msg.MessageKey;
        meta.ExtraData = seenList;
        meta.RoomKey = msg.RoomKey;
        meta.AtTimeMs = TimeUtil.getTimeMs();

        cmd.addToDataArray(meta);
        cmd.makeDataReady();
        WSService.sendCommand(cmd);
    }

    public static void sendToServerAllMsgsSeenbyPeerCmdForRoom(Room room){
        List<Message> msgs =  DB.db.selectFromMessage()
                .IsByMeEq(0)
                .RoomKeyEq(room.RoomKey)
                .CreatedDeviceMsGt(room.LastRoomOpenedTimeMs)
                .toList();

        if(msgs == null || msgs.size() == 0 ) return;

        List<String> seenMsgKeys = new ArrayList<>();
        for(Message msg : msgs){
            seenMsgKeys.add(msg.MessageKey);
        }

        Command cmd = Command.getNew(Constants.MsgsSeenByPeer);
        MsgsSyncMetaSeenByPeer meta = new MsgsSyncMetaSeenByPeer();
        meta.ByUserId = Session.getUserId();
//        meta.MessageKey = msg.getMessageKey();
        meta.ExtraData = seenMsgKeys;
        meta.RoomKey = room.RoomKey;
        meta.AtTimeMs = TimeUtil.getTimeMs();

        cmd.addToDataArray(meta);
        cmd.makeDataReady();
        WSService.sendAnStoreCommand(cmd);
    }

    public static void makeMsgsSeen(List<String> msgKeys, MsgsSyncMetaSeenByPeer meta){
        DB.db.updateMessage()
                //Update
                .PeerSeenTime(TimeUtil.timeMsToSec(meta.AtTimeMs))
                //Where
                .RoomKeyEq(meta.RoomKey)
                .MessageKeyIn(msgKeys)
                .execute();
    }

    public static void clearAllMessagesOfRoom(String roomKey){
        AndroidUtil.runInBackground(()->{
            List<Message> msgs = getAllRoomsMessages(roomKey);
            for(Message msg : msgs){
                String src = msg.MediaLocalSrc;
                if(src != null && !src.equals("")){
                    FileUtil.tryDelete(src);
                }
            }
            List<String> list = new ArrayList<String>();
            for(Message msg : msgs){
                list.add(msg.RoomKey);
            }
            DB.db.deleteFromMessage().MessageKeyIn(list);
            LastMsgOfRoomsCache.getInstance().removeForRoom(roomKey);
        });
    }

    //FIXME : after updates of events
    public static void publishMsgGeneralChangeEvent(Message msg) {
/*        MsgGeneralChangeChangeEvent meta = new MsgGeneralChangeChangeEvent(msg);
        EventBus.getDefault().post(meta);*/
    }

    public static void setPhotoParams(Message msg, String filePath) {
        File file = new File(filePath);
        Bitmap mBitmap = BitmapFactory.decodeFile(filePath);
        msg.MediaThumb64 = ImageUtil.blurThumbnailToBase64(mBitmap);
        msg.MediaHeight = mBitmap.getHeight();
        msg.MediaWidth = mBitmap.getWidth();
        msg.MediaLocalSrc = filePath;
        msg.MediaSize = (int)file.length();
        msg.MediaName = file.getName();
        msg.MediaDuration = 0;
    }

    public static void setVideoParams(Message msg, String thumbPath, String videoPath) {
        File fileVideo = new File(videoPath);

        VideoMetasHelper meta = new VideoMetasHelper(videoPath);

        msg.MediaHeight = meta.getVideoHeight();
        msg.MediaWidth = meta.getVideoWidth();
        msg.MediaLocalSrc = videoPath;
        msg.MediaSize = (int)fileVideo.length();
        msg.MediaName = fileVideo.getName();
        msg.MediaExtension = FileUtil.getFileExtensionWithDot(videoPath);
        msg.MediaDuration = meta.getVideoLength();

        //Extra
        setVideoExtraParams(msg,videoPath);
    }

    public static void setVideoExtraParams(Message msg, String videoPath) {
        String $thumbPath = AppFiles.VIDEO_THUMB_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.MediaExtension;
        String thumbPath = FileUtil.createNextName($thumbPath);

        File fileThumb = new File(thumbPath);
        Bitmap bitmap = ImageUtil.createVideoThumbnail(videoPath, 1024,360);
        if(bitmap != null){
            ImageUtil.saveToFile(bitmap,thumbPath);
        }
        Bitmap thumbBitmap = bitmap;//BitmapFactory.decodeFile(thumbPath);
        if(thumbBitmap != null){
            MsgExtraPhotoThumbnail extr = new MsgExtraPhotoThumbnail();
            extr.LocalSrc = thumbPath;
            extr.Height = thumbBitmap.getHeight();
            extr.Width = thumbBitmap.getWidth();
            extr.Size = (int) fileThumb.length();
            msg.ExtraJson = JsonUtil.toJson(extr);
            msg.MediaThumb64 = ImageUtil.blurThumbnailToBase64(thumbBitmap);
        }
    }

    public static void sendToServerMsgsReceivedToPeerCmd(Message msg){
        Command cmd = Command.getNew(Constants.MsgsReceivedToPeer);
        MessageSyncMeta meta = new MessageSyncMeta();
        meta.ByUserId = com.mardomsara.social.models.Session.getUserId();
        meta.MessageKey = msg.MessageKey;
        meta.RoomKey = msg.RoomKey;
        meta.AtTimeMs = TimeUtil.getTimeMs();

        cmd.addToDataArray(meta);
        cmd.makeDataReady();
        WSService.sendCommand(cmd);
    }

    public static void publishEvent(MessageSyncMeta msg) {
        Log.d("EVENT", "publishEvent: "+ msg.toString());
//        LastMsgOfRoomsCache.getInstance().onEvent(msg);
        EventBus.getDefault().post(msg);
    }

    public static void onMsgRevivedToServer(MessageSyncMeta msg) {}
    public static void onMsgRevivedToPeer(MessageSyncMeta msg) {}
    public static void onMsgSeenByPeer(MessageSyncMeta msg) {}
    public static void onMsgDeletedFromServer(MessageSyncMeta msg) {}
}