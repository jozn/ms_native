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
import com.mardomsara.social.ui.views.buttons.ButtonPostMultiWayView;

/**
 * Created by Hamid on 3/19/2017.
 */
/*important Note :somehow we MUST set app:xTitle and app:xLeftTitle to anything other wise the
	inflation will crach with an execption about binary error - have wasted alot of time debugin this*/
public class XTopNav extends RelativeLayout {
	OnBackButtonLiner backButtonLiner;

	OnClick onLeftClick;
	com.mardomsara.social.ui.X.X_TopNav x;
	String title ;
	String titleLeft;
	boolean isPostMultiWay = false;
	ButtonPostMultiWayView buttonPostMultiWayView;

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
			TypedArray a = getContext()
				.getTheme()
				.obtainStyledAttributes(attrs, R.styleable.XTopNav,0,R.style.XTopNavDef);
			try {
				title = a.getString(R.styleable.XTopNav_xTitle);
				titleLeft = a.getString(R.styleable.XTopNav_xLeftTitle);
				isPostMultiWay = a.getBoolean(R.styleable.XTopNav_xPostMultiWay,false);
			}finally {
				a.recycle();
			}

			x.left_text.setText(titleLeft);
			x.title_text.setText(title);
			if(isPostMultiWay){
				buttonPostMultiWayView = new X.ButtonPostMultiway(x.left_container).root;
				x.left_container.addView(buttonPostMultiWayView,0);
			}
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

	public ButtonPostMultiWayView getButtonPostMultiWayView() {
		return buttonPostMultiWayView;
	}

	//true: custm handed dont do anything
	public interface OnBackButtonLiner{
		boolean onBack();
	}

	public interface OnClick{
		void onClick();
	}
}
