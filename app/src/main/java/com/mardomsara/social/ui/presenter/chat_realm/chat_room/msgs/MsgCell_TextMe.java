package com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs;

import android.util.Log;
import android.view.ViewGroup;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapper;

/**
 * Created by Hamid on 6/13/2016.
 */
public class MsgCell_TextMe extends MsgCell_AbstractViewHolder {
	X.Msg_RowTextMe x;
	RealmMessageView msg;

	public MsgCell_TextMe(X.Msg_RowTextMe xv) {
		super(xv.root);
		x = xv;
	}

	public static MsgCell_AbstractViewHolder makeNew(ViewGroup parent){
		return new MsgCell_TextMe(new X.Msg_RowTextMe(parent));
	}

    @Override
    public void bindToView(RealmMessageViewWrapper wrapper) {
        Log.d("Msg","bindToView Me");
        this.msg = wrapper.messageView;

		x.msg_time.setText(MsgCommon.msgRawTime2(msg));
		x.msg_text.setText(""+msg.Text+" ");

		if( msg.Text != null && msg.Text.length() < 1000 && EmojiMaper.isJustEmoji(msg.Text)){
            Log.d("Emoji","isJustEmoji true: "+msg.Text);
			x.msg_text.setSizeMultiple(2f);
        }else {
			x.msg_text.restSizes();
        }

        x.root.setOnClickListener((v)->{
			wrapper.retryUploading();
		});

        MsgCommon.msgDeliveryStatusText(msg,x.msg_delivery_status);
    }

}
