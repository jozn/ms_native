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
import com.mardomsara.social.ui.X;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_TextMe extends MsgCell_AbstractViewHolder {
	//    @Bind(R.id.msg_time) TextView msg_time;
//    @Bind(R.id.msg_delivery_status) TextView msg_delivery_status;
//    @Bind(R.id.msg_text) EmojiconTextView msg_text;
	Message msg;

	X.Msg_RowTextMe x;

	public MsgCell_TextMe(X.Msg_RowTextMe xv) {
		super(xv.root);
		x = xv;
//        ButterKnife.bind(this, itemView);
	}

	public static MsgCell_AbstractViewHolder makeNew(ViewGroup parent){
		return new MsgCell_TextMe(new X.Msg_RowTextMe(parent));
	}

    @Override
    public void bindToView(Message msg) {
        Log.d("Msg","bindToView Me");

		x.msg_time.setText(MsgCommon.msgRawTime2(msg));
		x.msg_text.setText(""+msg.Text+" ");

		if( msg.Text != null && msg.Text.length() < 1000 && EmojiMaper.isJustEmoji(msg.Text)){
            Log.d("Emoji","isJustEmoji true: "+msg.Text);
//			msg_text.setJustEmojiconSize(AndroidUtil.dpToPx(12)*3);
			x.msg_text.setSizeMultiple(2f);
//            msg_text.setJustEmojiconSize(AndroidUtil.dpToPx(40));
//			grandView.requestLayout();
        }else {
			x.msg_text.restSizes();
//			msg_text.setSizeMultiple(3);
        }
//		msg_text.setLineSpacing(200,3);
        MsgCommon.msgDelviryStatusText(msg,x.msg_delivery_status);
//        ViewHelper.msgDelviryStatusText(msg,msg_delivery_status);
    }



}
