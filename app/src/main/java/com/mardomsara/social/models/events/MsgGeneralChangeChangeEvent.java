package com.mardomsara.social.models.events;

import com.mardomsara.social.models.tables.Message;

/**
 * Created by Hamid on 6/11/2016.
 */
public class MsgGeneralChangeChangeEvent extends MessageSyncMeta {

    public MsgGeneralChangeChangeEvent(Message msg) {
        super(msg);
    }
}
