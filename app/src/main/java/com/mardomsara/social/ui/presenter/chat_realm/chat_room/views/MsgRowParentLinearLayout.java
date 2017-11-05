package com.mardomsara.social.ui.presenter.chat_realm.chat_room.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 11/5/2017.
 */

public class MsgRowParentLinearLayout extends LinearLayout {
	public MsgRowParentLinearLayout(Context context) {
		super(context);
		init();
	}

	public MsgRowParentLinearLayout(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public MsgRowParentLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	com.mardomsara.social.ui.X.Msg_ParentDateSepration dateSepration = new X.Msg_ParentDateSepration(this.getContext(),this);

	void init(){
		addView(dateSepration.root,0);
	}

	public void setTime(String time){
		dateSepration.date_text.setText(time);
	}
}
