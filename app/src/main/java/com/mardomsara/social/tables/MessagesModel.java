package com.mardomsara.social.tables;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
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
import com.mardomsara.social.models.LastMsgOfRoomsCache;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgGeneralChangeChangeEvent;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.extra.MsgExtraPhotoThumbnail;
import com.mardomsara.social.service.WSService;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MessagesModel {

    /////////////////// Static /////////////

    public static List<MessagesTable> getRoomMessage(String roomKey,int page) {
        List<MessagesTable> msgs = SQLite.select().from(MessagesTable.class)
                .where(MessagesTable_Table.RoomKey.eq(roomKey))
                .orderBy(MessagesTable_Table.CreatedMs,false)
                .queryList();
        return msgs;
    }

    public static List<MessagesTable> getAllRoomsMessages(String roomKey) {
        List<MessagesTable> msgs = SQLite.select().from(MessagesTable.class)
                .where(MessagesTable_Table.RoomKey.eq(roomKey))
                .orderBy(MessagesTable_Table.CreatedMs,false)
                .queryList();
        return msgs;
    }

    public static MessagesTable getMessageByKey(String msgKey) {
        MessagesTable msg = SQLite.select().from(MessagesTable.class)
                .where(MessagesTable_Table.MessageKey.eq(msgKey))
                .orderBy(MessagesTable_Table.CreatedMs,false)
                .querySingle();
        return msg;
    }

    public static  MessagesTable NewTextMsgForRoom(RoomsListTable room){
        MessagesTable msg = new MessagesTable();
        msg.setRoomKey(room.getRoomKey());
        msg.setDeliveryStatus(0);
        msg.setIsByMe(1);
        msg.setRoomTypeId(room.getRoomTypeId());
        msg.setCreatedMs(AppUtil.getTimeMs());
        msg.setCreatedDeviceMs(AppUtil.getTimeMs());
        msg.setMessageTypeId(Constants.MESSAGE_TEXT);
        msg.setUserId(com.mardomsara.social.models.Session.getUserId());
        msg.setMessageKey(LangUtil.getRandomString(20));
        msg.setToPush(1);
        return msg;
    }

    public static  void setParamsForNewMsgRecivedFromNet(MessagesTable msg){
        msg.setCreatedDeviceMs(TimeUtil.getTimeMs());
        msg.setIsByMe(0);
        //msg.setRoomKey("u"+msg.getUserId());
        msg.setToPush(0);
        msg.setMediaStatus(0);
//        return msg;
    }

    public static  int getUserId(MessagesTable msg) {
        return msg.getUserId();
    }

    public static void onNewMsgRecied(MessagesTable msg){

    }
    public static void syncToServer(MessagesTable msg ) {
        Command cmd = new Command();
        cmd.Name = Constants.MsgsAddNew;
        cmd.Data = JsonUtil.toJson(msg);

        WSService.sendCommand(cmd);
        //onAddedNewMsgEvent(msg);
    }


    public static void sendToServerMsgsSeenByPeerCmd(MessagesTable msg){
        Command cmd = Command.getNew(Constants.MsgsSeenByPeer);
        ArrayList<String> seenList = new ArrayList<String>();
        seenList.add(msg.getMessageKey());

        MsgsSyncMetaSeenByPeer meta = new MsgsSyncMetaSeenByPeer();
        meta.ByUserId = com.mardomsara.social.models.Session.getUserId();
        meta.MessageKey = msg.getMessageKey();
        meta.ExtraData = seenList;
        meta.RoomKey = msg.getRoomKey();
        meta.AtTimeMs = TimeUtil.getTimeMs();

        cmd.addToDataArray(meta);
        cmd.makeDataReady();
        WSService.sendCommand(cmd);
    }

    public static void sendToServerAllMsgsSeenbyPeerCmdForRoom(RoomsListTable room){

        List<MessagesTable> msgs =  SQLite.select().from(MessagesTable.class)
                .where(MessagesTable_Table.IsByMe.eq(0))
                .and(MessagesTable_Table.RoomKey.eq(room.getRoomKey()))
                .and(MessagesTable_Table.CreatedDeviceMs.greaterThan(room.getLastRoomOpenedTimeMs()))
                .queryList();

        if(msgs == null || msgs.size() == 0 ) return;

        List<String> seenMsgKeys = new ArrayList<>();
        for(MessagesTable msg : msgs){
            seenMsgKeys.add(msg.getMessageKey());
        }

        Command cmd = Command.getNew(Constants.MsgsSeenByPeer);
        MsgsSyncMetaSeenByPeer meta = new MsgsSyncMetaSeenByPeer();
        meta.ByUserId = com.mardomsara.social.models.Session.getUserId();
//        meta.MessageKey = msg.getMessageKey();
        meta.ExtraData = seenMsgKeys;
        meta.RoomKey = room.getRoomKey();
        meta.AtTimeMs = TimeUtil.getTimeMs();

        cmd.addToDataArray(meta);
        cmd.makeDataReady();
        WSService.sendAnStoreCommand(cmd);

    }

    public static void makeMsgsSeen(List<String> msgKeys, MsgsSyncMetaSeenByPeer meta){
        SQLite.update(MessagesTable.class).orIgnore()
                .set(MessagesTable_Table.PeerSeenTime.eq(TimeUtil.timeMsToSec(meta.AtTimeMs)))
                .where(MessagesTable_Table.RoomKey.eq(meta.RoomKey))
                .and(MessagesTable_Table.MessageKey.in(msgKeys))
                .execute();
    }

    public static void clearAllMessagesOfRoom(RoomsListTable room){
        AndroidUtil.runInBackground(()->{
            List<MessagesTable> msgs = getAllRoomsMessages(room.getRoomKey());
            for(MessagesTable msg : msgs){
                String src = msg.getMediaLocalSrc();
                if(src != null && !src.equals("")){
                    FileUtil.tryDelete(src);
                }
            }
            for(MessagesTable msg : msgs){
                msg.delete();
            }
            LastMsgOfRoomsCache.getInstance().removeForRoom(room.getRoomKey());
            room.setUnseenMessageCount(0);
            room.save();
        });
    }

    public static void clearAllMessagesOfRoom(String roomKey){
        AndroidUtil.runInBackground(()->{
            List<MessagesTable> msgs = getAllRoomsMessages(roomKey);
            for(MessagesTable msg : msgs){
                String src = msg.getMediaLocalSrc();
                if(src != null && !src.equals("")){
                    FileUtil.tryDelete(src);
                }
            }
            for(MessagesTable msg : msgs){
                msg.delete();
            }
            LastMsgOfRoomsCache.getInstance().removeForRoom(roomKey);
        });
    }

    //just eventBus
    public static void publishNewMsgEvent(MessagesTable msg) {
        //onAddedNewMsgEvent(msg);
    }

    public static void publishMsgGeneralChangeEvent(MessagesTable msg) {
        //onAddedNewMsgEvent(msg);
        MsgGeneralChangeChangeEvent meta = new MsgGeneralChangeChangeEvent(msg);
        EventBus.getDefault().post(meta);
    }

    public static void setPhotoParams(MessagesTable msg, Bitmap bm) {

    }

    public static void setPhotoParams(MessagesTable msg, String filePath) {
        File file = new File(filePath);
        Bitmap mBitmap = BitmapFactory.decodeFile(filePath);
        msg.setMediaThumb64(ImageUtil.blurThumbnailToBase64(mBitmap));
        msg.setMediaHeight(mBitmap.getHeight());
        msg.setMediaWidth(mBitmap.getWidth());
        msg.setMediaLocalSrc(filePath);
        msg.setMediaSize((int)file.length());
        msg.setMediaName(file.getName());
        msg.setMediaExtension(FileUtil.getFileExtensionWithDot(filePath));
        msg.setMediaDuration(0);
    }

    public static void setVideoParams(MessagesTable msg, String thumbPath, String videoPath) {
        File fileVideo = new File(videoPath);

        VideoMetasHelper meta = new VideoMetasHelper(videoPath);

        msg.setMediaHeight(meta.getVideoHeight());
        msg.setMediaWidth(meta.getVideoWidth());
        msg.setMediaLocalSrc(videoPath);
        msg.setMediaSize(((int)fileVideo.length()));
        msg.setMediaName(fileVideo.getName());
        msg.setMediaExtension(FileUtil.getFileExtensionWithDot(videoPath));
        msg.setMediaDuration(meta.getVideoLength());

        //Extra
        setVideoExtraParams(msg,videoPath);
    }
    public static void setVideoExtraParams(MessagesTable msg, String videoPath) {
        String $thumbPath = AppFiles.VIDEO_THUMB_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msg.getMediaExtension();
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
            msg.setExtraJson(JsonUtil.toJson(extr));
            msg.setMediaThumb64(ImageUtil.blurThumbnailToBase64(thumbBitmap));
        }
    }

    public static void sendToServerMsgsReceivedToPeerCmd(MessagesTable msg){
        Command cmd = Command.getNew(Constants.MsgsReceivedToPeer);
        MessageSyncMeta meta = new MessageSyncMeta();
        meta.ByUserId = com.mardomsara.social.models.Session.getUserId();
        meta.MessageKey = msg.getMessageKey();
        meta.RoomKey = msg.getRoomKey();
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




//    @ColumnSpec(defaultValue = "")
//    public String MessageName;
//    @ColumnSpec(defaultValue = "")
//    public String Text;
//    @ColumnSpec(defaultValue = "0")
//    public int UserId;

