package com.mardomsara.social.tables;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.base.Session;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.helpers.VideoMetasHelper;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgGeneralChangeChangeEvent;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.extra.MsgExtraPhotoThumbnail;
import com.mardomsara.social.service.WSService;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 1/4/2016.
 */
//@TableModelSpec(className = "MessagesTable",tableName = "messages")

//TOdo; add: IsSeenByPeer() IsRe....
@Table(name = "messages",database = AppDB.class, cachingEnabled = false)
public class MessagesTable extends BaseModel {
    @PrimaryKey
    @NotNull
    public String MessageKey;

    @Column
    @NotNull
    public String RoomKey;

    @Column(defaultValue = "0")
    public int UserId;//-1: system

    @Column(defaultValue = "1")
    public int RoomTypeId =1;//1: peer-to-peer 2:private-group

    @Column(defaultValue = "1")
    @NotNull
    public int MessageTypeId = 1;//1: text,...

    @Column(defaultValue = "\"\"")
    public String Text;

    @Column(defaultValue = "\"\"")
    public String ExtraJson;

    @Column(defaultValue = "0")
    public int IsByMe;

    @Column(defaultValue = "0")
    public int IsStared;//REMOVE??????? its table????

    @Column(defaultValue = "0")
    public int DeliveryStatus;//0:not-me  1: need-push 2: resic=ved-server 3:rc-clint; 4:seen-client 5: removed-server

    @Column(defaultValue = "0")
    public long CreatedMs;

    @Column(defaultValue = "0")
    public long CreatedDeviceMs;

    @Column(defaultValue = "0")
    public int PeerSeenTime;

    @Column(defaultValue = "0")
    public int ServerReceivedTime;

    @Column(defaultValue = "0")
    public int PeerReceivedTime;

    @Column(defaultValue = "0")
    public int ServerDeletedTime;

    @Column(defaultValue = "0")
    public int ToPush;

    @Column(defaultValue = "0")
    public int MediaStatus;

    /// Media
    @Column(defaultValue = "\"\"")
    public String MediaThumb64;

    @Column(defaultValue = "\"\"")
    public String MediaName;

    @Column(defaultValue = "\"\"")
    public String MediaLocalSrc;

    @Column(defaultValue = "\"\"")
    public String MediaServerSrc;

    @Column(defaultValue = "-1")
    public int MediaSize;

    @Column(defaultValue = "-1")
    public int MediaDuration;

    @Column(defaultValue = "-1")
    public int MediaHeight;

    @Column(defaultValue = "-1")
    public int MediaWidth;

    @Column(defaultValue = "\"\"")
    public String MediaExtension;

    //deprecated

//    @Column(defaultValue = "\"\"")
//    public String MediaUrl;
//
//    @Column(defaultValue = "\"\"")
//    public String MediaLocalPath;
//
//    @Column(defaultValue = "0")
//    public int IsSeen;//REMOVE???????

    ///instance funcs

    public boolean isReceivedToPeer() {
        return (PeerReceivedTime > 0 );
    }

//    public boolean isSeenByPeer() {
//        return ( > 0 );
//    }

    public boolean issSeenByPeer() {
        return (PeerSeenTime > 0 );
    }

    public boolean isReceivedToServer() {
        return (ServerReceivedTime > 0 );
    }

    public boolean isDeletedFromServer() {
        return (ServerDeletedTime > 0 );
    }


    /////////////////// Static /////////////

    public static List<MessagesTable> getRoomMessage(String roomKey,int page) {
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
        msg.setUserId(Session.getUserId());
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
        meta.ByUserId = Session.getUserId();
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
        meta.ByUserId = Session.getUserId();
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
        meta.ByUserId = Session.getUserId();
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

        /////// Assosiation  /////////////////

//    public FilesTable _FilesTable_;
//    public ImageBinary _ImageBinary_;

    public int getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }

    public String getMessageKey() {
        return MessageKey;
    }

    public void setMessageKey(String messageKey) {
        MessageKey = messageKey;
    }

    public String getRoomKey() {
        return RoomKey;
    }

    public void setRoomKey(String roomKey) {
        RoomKey = roomKey;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getRoomTypeId() {
        return RoomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        RoomTypeId = roomTypeId;
    }

    public int getMessageTypeId() {
        return MessageTypeId;
    }

    public void setMessageTypeId(int messageTypeId) {
        MessageTypeId = messageTypeId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getExtraJson() {
        return ExtraJson;
    }

    public void setExtraJson(String extraJson) {
        ExtraJson = extraJson;
    }

    public int getIsByMe() {
        return IsByMe;
    }

    public void setIsByMe(int isByMe) {
        IsByMe = isByMe;
    }

    public int getIsStared() {
        return IsStared;
    }

    public void setIsStared(int isStared) {
        IsStared = isStared;
    }

    public long getCreatedMs() {
        return CreatedMs;
    }

    public void setCreatedMs(long createdMs) {
        CreatedMs = createdMs;
    }

    public int getPeerSeenTime() {
        return PeerSeenTime;
    }

    public void setPeerSeenTime(int peerSeenTime) {
        PeerSeenTime = peerSeenTime;
    }

    public int getServerReceivedTime() {
        return ServerReceivedTime;
    }

    public void setServerReceivedTime(int serverReceivedTime) {
        ServerReceivedTime = serverReceivedTime;
    }



    public int getServerDeletedTime() {
        return ServerDeletedTime;
    }

    public void setServerDeletedTime(int serverDeletedTime) {
        ServerDeletedTime = serverDeletedTime;
    }

    public int getPeerReceivedTime() {
        return PeerReceivedTime;
    }

    public void setPeerReceivedTime(int peerReceivedTime) {
        PeerReceivedTime = peerReceivedTime;
    }

    public int getMediaSize() {
        return MediaSize;
    }

    public void setMediaSize(int mediaSize) {
        MediaSize = mediaSize;
    }

    public int getMediaDuration() {
        return MediaDuration;
    }

    public void setMediaDuration(int mediaDuration) {
        MediaDuration = mediaDuration;
    }

    public String getMediaThumb64() {
        return MediaThumb64;
    }

    public void setMediaThumb64(String mediaThumb64) {
        MediaThumb64 = mediaThumb64;
    }

    public String getMediaName() {
        return MediaName;
    }

    public void setMediaName(String mediaName) {
        MediaName = mediaName;
    }

    public String getMediaExtension() {
        return MediaExtension;
    }

    public void setMediaExtension(String mediaExtension) {
        MediaExtension = mediaExtension;
    }

    public int getMediaWidth() {
        return MediaWidth;
    }

    public void setMediaWidth(int mediaWidth) {
        MediaWidth = mediaWidth;
    }

    public int getMediaHeight() {
        return MediaHeight;
    }

    public void setMediaHeight(int mediaHeight) {
        MediaHeight = mediaHeight;
    }

    public String getMediaServerSrc() {
        return MediaServerSrc;
    }

    public void setMediaServerSrc(String mediaServerSrc) {
        MediaServerSrc = mediaServerSrc;
    }

    public String getMediaLocalSrc() {
        return MediaLocalSrc;
    }

    public void setMediaLocalSrc(String mediaLocalSrc) {
        MediaLocalSrc = mediaLocalSrc;
    }

    public int getMediaStatus() {
        return MediaStatus;
    }

    public void setMediaStatus(int mediaStatus) {
        MediaStatus = mediaStatus;
    }

    public int getToPush() {
        return ToPush;
    }

    public void setToPush(int toPush) {
        ToPush = toPush;
    }

    public long getCreatedDeviceMs() {
        return CreatedDeviceMs;
    }

    public void setCreatedDeviceMs(long createdDeviceMs) {
        CreatedDeviceMs = createdDeviceMs;
    }
}




//    @ColumnSpec(defaultValue = "")
//    public String MessageName;
//    @ColumnSpec(defaultValue = "")
//    public String Text;
//    @ColumnSpec(defaultValue = "0")
//    public int UserId;

