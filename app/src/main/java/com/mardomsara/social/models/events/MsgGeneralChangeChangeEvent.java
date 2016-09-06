package com.mardomsara.social.models.events;

import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.tables.MessagesTable;

/**
 * Created by Hamid on 6/11/2016.
 */
public class MsgGeneralChangeChangeEvent extends MessageSyncMeta {
    @Deprecated
    public MsgGeneralChangeChangeEvent(MessagesTable msg) {
        super(msg);
    }

    public MsgGeneralChangeChangeEvent(Message msg) {
        super(msg);
    }
}
