package com.mardomsara.social.ui.views.msgs;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.tables.MessagesTable;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgTextMeView extends MsgAbstractViewHolder {
    @Bind(R.id.msg_time) TextView time_txt;
    @Bind(R.id.msg_delivery_status) TextView msg_delivery_status;
    @Bind(R.id.msg_text) EmojiconTextView msg_text;
    MessagesTable msg;

    public MsgTextMeView(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static MsgAbstractViewHolder makeNew(ViewGroup parent){
        return new MsgTextMeView(AppUtil.inflate(R.layout.msg_row_text_me,parent));
    }

    @Override
    public void bindToView(MessagesTable msg) {
        Log.d("Msg","bindToView Me");
        if(EmojiMaper.isJustEmoji(msg.getText())){
            Log.d("Emoji","isJustEmoji true");
//            msg_text.setJustEmojiconSize(AndroidUtil.dpToPx(40));
        }else {
//            msg_text.restOreEmojiSize();
        }
        time_txt.setText(MsgCommon.msgRawTime2(msg));
        msg_text.setText(""+msg.getText());
        MsgCommon.msgDelviryStatusText(msg,msg_delivery_status);
//        ViewHelper.msgDelviryStatusText(msg,msg_delivery_status);
    }



}
