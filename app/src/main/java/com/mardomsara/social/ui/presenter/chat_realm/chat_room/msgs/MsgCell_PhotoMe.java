package com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapper;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoMe extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImageMe x;

	@NonNull
	MsgImageWrapper imageWrapper;

	RealmMessageView msg;
	RealmMessageViewWrapper wrapper;

    public MsgCell_PhotoMe(X.Msg_RowImageMe xv) {
        super(xv.root);
		x = xv;
		imageWrapper = new MsgImageWrapper(xv.image_holder);
    }

    public static MsgCell_PhotoMe makeNew(ViewGroup parent){
        return new MsgCell_PhotoMe(new X.Msg_RowImageMe(parent));
    }

    @Override
    public void bindToView(RealmMessageViewWrapper wrapper) {
		this.msg = wrapper.messageView;
		this.wrapper = wrapper;
        AppUtil.log("bindToView Peer -- ");
        x.msg_time.setText(MsgCommon.msgRawTime2(msg));
		imageWrapper.bind(wrapper);
//        msg_text.setText(msg.getText());
//        MsgCommon.setImage2(msg,x.image_holder);
//        MsgCommon.setContentMaxwhidth(msg,msg_image);
        MsgCommon.setTextForImages(msg,x.msg_text);
        ViewHelper.setViewSizesPrecentaion(x.msg_content_holder,0.8f);

        MsgCommon.msgDeliveryStatusText(msg,x.msg_delivery_status);


    }

	@Override
	public void onRecycled() {
//		AppUtil.log("onRecycled msg me image: "+ msg.MessageKey);
		imageWrapper.unbind(wrapper);
	}
}
