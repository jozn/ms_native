package com.mardomsara.social.models.events;

import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.tables.Message;

/**
 * Created by Hamid on 5/14/2016.
 */
public class MessageSyncMeta {
    public String MessageKey;
    public String RoomKey;
    public int ByUserId;
    public long AtTimeMs;
//    public Object ExtraData;

    public MessageSyncMeta() {}

    public MessageSyncMeta(Message msg) {
        MessageKey = msg.MessageKey;
        RoomKey = msg.RoomKey;
        ByUserId = msg.UserId;
        AtTimeMs = TimeUtil.getTimeMs();
    }

    @Override
    public String toString() {
        return "" + this.getClass().getSimpleName()+"{"+
                "MessageKey='" + MessageKey + '\'' +
                ", RoomKey='" + RoomKey + '\'' +
                ", PeerUserId=" + ByUserId +
                ", AtTimeMs=" + AtTimeMs +
//                ", Object=" + ExtraData +
                '}';
    }

    //deprecated
    public static class MsgsReceivedToServer extends MessageSyncMeta {

    }
}

//    MessageKey         string
//    RoomKey            string
//UserId             int
//        AtTimeMs int// this is client time

