package com.mardomsara.social.ui.cells.chats.lists;

import com.mardomsara.social.ui.cells.chats.adaptors.ChatEntryAdaptor;

/**
 * Created by Hamid on 9/8/2016.
 */
@Deprecated
public class MsgsListCell {
    public ChatEntryAdaptor adaptor;

    public MsgsListCell() {
        this.adaptor = new ChatEntryAdaptor();
    }


}
