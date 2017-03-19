package com.mardomsara.social.ui.views.x;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 3/19/2017.
 */

public class XTopNav extends RelativeLayout {
	OnBackButtonLiner backButtonLiner;

	OnClick onLeftClick;
	com.mardomsara.social.ui.X.X_TopNav x;
	String title ;
	String titleLeft;

	public XTopNav(@NonNull Context context) {
		super(context);
		init(context, null);
	}

	public XTopNav(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public XTopNav(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		x = new X.X_TopNav(this);
		setBackgroundResource(R.drawable.background_tab);

		if (attrs != null) {
			TypedArray a= getContext().obtainStyledAttributes(attrs, R.styleable.XTopNav);;
			try {
				title = a.getString(R.styleable.XTopNav_xTitle);
				titleLeft = a.getString(R.styleable.XTopNav_xLeftTitle);
			}finally {
				a.recycle();
			}
			x.left_text.setText(titleLeft);
			x.title_text.setText(title);
		}

		x.back_btn.setOnClickListener(this::backImple);
		x.left_text.setOnClickListener(this::leftClikcImple);
	}

	void backImple(View v){
		if(backButtonLiner != null){
			boolean res = backButtonLiner.onBack();
			if(res){
				return;
			}
		}
		Nav.pop();
	}

	void leftClikcImple(View v){
		if(onLeftClick != null){
			onLeftClick.onClick();
		}
	}

	public void setTitle(String title){
		x.title_text.setText(title);
	}

	public void setLeftTitle(String title){
		x.left_text.setText(title);
	}

	public void setOnLeftClick(OnClick onLeftClick) {
		this.onLeftClick = onLeftClick;
	}

	public void setOnClickLisner(OnBackButtonLiner onBackButtonLiner){
		backButtonLiner = onBackButtonLiner;
	}

	//true: custm handed dont do anything
	public interface OnBackButtonLiner{
		boolean onBack();
	}

	public interface OnClick{
		void onClick();
	}
}
