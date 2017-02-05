package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_PhotoMe extends MsgCell_AbstractViewHolder {

	@NonNull
	X.Msg_RowImageMe x;

    public MsgCell_PhotoMe(X.Msg_RowImageMe xv) {
        super(xv.root);
		x = xv;
    }

    public static MsgCell_PhotoMe makeNew(ViewGroup parent){
        return new MsgCell_PhotoMe(new X.Msg_RowImageMe(parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
        x.msg_time.setText(MsgCommon.msgRawTime2(msg));
//        msg_text.setText(msg.getText());
        MsgCommon.setImage(msg,x.image_holder.x.msg_image);
//        MsgCommon.setContentMaxwhidth(msg,msg_image);
        MsgCommon.setTextForImages(msg,x.msg_text);
        ViewHelper.setViewSizesPrecentaion(x.msg_content_holder,0.8f);

        MsgCommon.msgDeliveryStatusText(msg,x.msg_delivery_status);


    }


}
