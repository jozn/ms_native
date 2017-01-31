package com.mardomsara.social.ui.cells.chats.msgs;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.X;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_TextPeer extends MsgCell_AbstractViewHolder {
    Message msg;

	@NonNull X.Msg_RowTextPeer x;

    public MsgCell_TextPeer(X.Msg_RowTextPeer xv) {
        super(xv.root);
		x = xv;
    }

    public static MsgCell_AbstractViewHolder makeNew(ViewGroup parent){
        return new MsgCell_TextPeer(new X.Msg_RowTextPeer(parent));
    }

    @Override
    public void bindToView(Message msg) {
        AppUtil.log("bindToView Peer");

		x.msg_time.setText(MsgCommon.msgRawTime2(msg));
		x.msg_text.setText(msg.Text + " ");// " " is for emoji not to break

		if( msg.Text != null && msg.Text.length() < 1000 && EmojiMaper.isJustEmoji(msg.Text)){
			x.msg_text.setSizeMultiple(2f);
		}else {
			x.msg_text.restSizes();
		}
    }

}
