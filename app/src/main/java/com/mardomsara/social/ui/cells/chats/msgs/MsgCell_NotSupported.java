package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.models_old.tables.Message;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_NotSupported extends MsgCell_AbstractViewHolder {
	@NonNull
	X.Msg_RowNotSupportedPeer x;

    public MsgCell_NotSupported(X.Msg_RowNotSupportedPeer xv) {
        super(xv.root);
		x = xv;
    }

    public static MsgCell_AbstractViewHolder makeNew(ViewGroup parent){
        return new MsgCell_NotSupported(new X.Msg_RowNotSupportedPeer(parent));
    }

    @Override
    public void bindToView(Message msg) {

    }

}
