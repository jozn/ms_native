package com.mardomsara.social.models.events;

import com.mardomsara.social.tables.MessagesTable;

/**
 * Created by Hamid on 6/11/2016.
 */
public class MsgGeneralChangeChangeEvent extends MessageSyncMeta {
    public MsgGeneralChangeChangeEvent(MessagesTable msg) {
        super(msg);
    }
}
