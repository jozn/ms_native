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
public class MsgCell_TextMe extends MsgCell_AbstractViewHolder {
    @Bind(R.id.msg_time) TextView time_txt;
    @Bind(R.id.msg_delivery_status) TextView msg_delivery_status;
    @Bind(R.id.msg_text) EmojiconTextView msg_text;
    Message msg;

    public MsgCell_TextMe(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static MsgCell_AbstractViewHolder makeNew(ViewGroup parent){
        return new MsgCell_TextMe(AppUtil.inflate(R.layout.msg_row_text_me,parent));
    }

    @Override
    public void bindToView(Message msg) {
        Log.d("Msg","bindToView Me");
        if(EmojiMaper.isJustEmoji(msg.Text)){
            Log.d("Emoji","isJustEmoji true");
//            msg_text.setJustEmojiconSize(AndroidUtil.dpToPx(40));
        }else {
//            msg_text.restOreEmojiSize();
        }
        time_txt.setText(MsgCommon.msgRawTime2(msg));
        msg_text.setText(""+msg.Text);
        MsgCommon.msgDelviryStatusText(msg,msg_delivery_status);
//        ViewHelper.msgDelviryStatusText(msg,msg_delivery_status);
    }



}
