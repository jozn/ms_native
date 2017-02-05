package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 2/5/2017.
 */

public class ChatMediaNetworkLoader extends FrameLayout {
	public X.Msg_MediaNetworkLoader x;

	public ChatMediaNetworkLoader(Context context) {
		super(context);
		init(context);
	}

	public ChatMediaNetworkLoader(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ChatMediaNetworkLoader(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		x = new X.Msg_MediaNetworkLoader(this);
//		setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

//		addView(x.root);
	}

}
