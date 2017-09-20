package com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoPeer extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImagePeer x;

	@NonNull
	MsgImageWrapper imageWrapper;
//	RealmMessageViewWrapper wrapper;


	public MsgCell_PhotoPeer(X.Msg_RowImagePeer xv) {
        super(xv.root);
		x = xv;
		imageWrapper = new MsgImageWrapper(xv.image_holder);
	}

    public static MsgCell_PhotoPeer makeNew(ViewGroup parent){
        return new MsgCell_PhotoPeer(new X.Msg_RowImagePeer(parent));
    }

    @Override
    public void bindToView(RealmMessageViewWrapper wrapper) {
        AppUtil.log("bindToView Peer");
		imageWrapper.bind(wrapper);
        MsgCommon.setTextForImages(wrapper.messageView,x.msg_text);
        x.msg_time.setText(MsgCommon.msgRawTime2(wrapper.messageView));

    }

}
