package com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoOnlyPeer extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImageOnlyPeer x;

	@NonNull
	MsgImageWrapper imageWrapper;
//	RealmMessageViewWrapper wrapper;


	public MsgCell_PhotoOnlyPeer(X.Msg_RowImageOnlyPeer xv) {
        super(xv.root);
		x = xv;
		imageWrapper = new MsgImageWrapper(xv.image_holder);
	}

    public static MsgCell_PhotoOnlyPeer makeNew(ViewGroup parent){
        return new MsgCell_PhotoOnlyPeer(new X.Msg_RowImageOnlyPeer(parent));
    }

    @Override
    public void bindToView(RealmMessageViewWrapper wrapper) {
        AppUtil.log("bindToView Peer");
		imageWrapper.bind(wrapper);
        x.msg_time.setText(MsgCommon.msgRawTime2(wrapper.messageView));

    }

}
