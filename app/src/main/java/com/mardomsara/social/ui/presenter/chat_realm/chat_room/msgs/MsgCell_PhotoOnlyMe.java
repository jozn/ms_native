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
public class MsgCell_PhotoOnlyMe extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImageOnlyMe x;

	@NonNull
	MsgImageWrapper imageWrapper;

	RealmMessageView msg;
	RealmMessageViewWrapper wrapper;

    public MsgCell_PhotoOnlyMe(X.Msg_RowImageOnlyMe xv) {
        super(xv.root);
		x = xv;
		imageWrapper = new MsgImageWrapper(xv.image_holder);
    }

    public static MsgCell_PhotoOnlyMe makeNew(ViewGroup parent){
        return new MsgCell_PhotoOnlyMe(new X.Msg_RowImageOnlyMe(parent));
    }

    @Override
    public void bindToView(RealmMessageViewWrapper wrapper) {
		this.msg = wrapper.messageView;
		this.wrapper = wrapper;
        AppUtil.log("bindToView Me -- ");
        x.msg_time.setText(MsgCommon.msgRawTime2(msg));
		imageWrapper.bind(wrapper);
//        msg_text.setText(msg.getText());
//        MsgCommon.setImage2(msg,x.image_holder);
//        MsgCommon.setContentMaxwhidth(msg,msg_image);
        ViewHelper.setViewSizesPrecentaion(x.msg_content_holder,0.8f);

        MsgCommon.msgDeliveryStatusText(msg,x.msg_delivery_status);


    }

	@Override
	public void onRecycled() {
//		AppUtil.log("onRecycled msg me image: "+ msg.MessageKey);
		imageWrapper.unbind(wrapper);
	}
}
