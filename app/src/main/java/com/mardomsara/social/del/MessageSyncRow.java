package com.mardomsara.social.del;

/**
 * Created by Hamid on 5/14/2016.
 */
public class MessageSyncRow {

    public String MessageKey;
    public String RoomKey;
    public int UserId;//-1: system
    public int MessageTypeId = 1;//1: text,...
    public String Text;
    public String ExtraJson;
    public long CreatedMs;

    /// Media
    public int MediaSize;
    public int MediaDuration;
    public String MediaThumb64;
    public String MediaName;

}

