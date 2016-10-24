package com.mardomsara.social.ui.cells.chats.msgs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_TextPeer extends MsgCell_AbstractViewHolder {
    @Bind(R.id.msg_time) TextView time_txt;
    @Bind(R.id.msg_text) TextView msg_text;

    Message msg;

    public MsgCell_TextPeer(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
//        itemView.((int)(AndroidUtil.getScreenWidth()*.8));
    }

    public static MsgCell_AbstractViewHolder makeNew(ViewGroup parent){
        return new MsgCell_TextPeer(AppUtil.inflate(R.layout.msg_row_text_peer,parent));
    }


    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");
        time_txt.setText(MsgCommon.msgRawTime2(msg));
        msg_text.setText(msg.Text);
//        msg_text.setText2(msg.getText());
    }



}
