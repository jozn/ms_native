package com.mardomsara.social.ui.cells.chats.msgs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_old.tables.Message;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_VideoMe extends MsgCell_AbstractViewHolder {
    @BindView(R.id.msg_time) TextView time_txt;
    @BindView(R.id.msg_delivery_status) TextView msg_delivery_status;
    @BindView(R.id.msg_text) TextView msg_text;
    @BindView(R.id.msg_image) SimpleDraweeView msg_image;
    @BindView(R.id.msg_content_holder) ViewGroup msg_content_holder;
//    LinkerText msg_text;
    Message msg;

    public MsgCell_VideoMe(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static MsgCell_VideoMe makeNew(ViewGroup parent){
        return new MsgCell_VideoMe(AppUtil.inflate(R.layout.msg__row_video_me,parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
        time_txt.setText(MsgCommon.msgRawTime2(msg));
        msg_text.setText(msg.Text);
        MsgCommon.msgDeliveryStatusText(msg,msg_delivery_status);
        MsgCommon.setVideoImage(msg,msg_image);
    }


}
