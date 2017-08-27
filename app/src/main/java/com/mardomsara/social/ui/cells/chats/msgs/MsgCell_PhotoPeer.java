package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoPeer extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImagePeer x;

	@NonNull
	MsgImageWrapper imageWrapper;

    public MsgCell_PhotoPeer(X.Msg_RowImagePeer xv) {
        super(xv.root);
		x = xv;
		imageWrapper = new MsgImageWrapper(xv.image_holder);
	}

    public static MsgCell_PhotoPeer makeNew(ViewGroup parent){
        return new MsgCell_PhotoPeer(new X.Msg_RowImagePeer(parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
		imageWrapper.bind(msg);
        MsgCommon.setTextForImages(msg,x.msg_text);
        x.msg_time.setText(MsgCommon.msgRawTime2(msg));

    }

}
