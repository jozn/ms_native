package com.mardomsara.social.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Hamid on 1/4/2016.
 */
//@TableModelSpec(className = "MessagesTable",tableName = "messages")

//TOdo; add: IsSeenByPeer() IsRe....
@Deprecated
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

