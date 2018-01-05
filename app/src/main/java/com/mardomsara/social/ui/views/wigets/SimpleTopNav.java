package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.mardomsara.social.R;
import com.mardomsara.social.nav.Nav;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 6/27/2016.
 */
public class SimpleTopNav extends RelativeLayout {

	com.mardomsara.social.ui.X.Nav_Simple x;

    String title = "";
    String leftText = "";
    public SimpleTopNav(Context context) {
        super(context);
        init();
    }

    public SimpleTopNav(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleTopNav(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    void init(){
		x = new X.Nav_Simple(this);
		x.back_btn.setOnClickListener( (v)-> goBack() );
        setBackgroundResource(R.drawable.background_tab);
        requestLayout();
    }


    void goBack(){
        Nav.pop();
    }


    public void setTitle(String title) {
        this.title = title;
        x.title_text.setText(title);
//        requestLayout();
    }

    public void setLeftText(String leftText) {
        this.leftText = leftText;
        requestLayout();
    }




}
