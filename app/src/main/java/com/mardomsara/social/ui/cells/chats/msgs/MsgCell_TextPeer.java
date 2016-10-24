package com.mardomsara.social.ui.cells.chats.msgs;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.emojicon.EmojiconTextView;
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
    @Bind(R.id.msg_text) EmojiconTextView msg_text;

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
		msg_text.setText(msg.Text + " ");// " " is for emoji not to break

		if( msg.Text != null && msg.Text.length() < 1000 && EmojiMaper.isJustEmoji(msg.Text)){
			msg_text.setSizeMultiple(2f);
		}else {
			msg_text.restSizes();
		}

    }

}
