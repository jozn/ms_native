package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hamid on 6/27/2016.
 */
public class SimpleTopNav extends RelativeLayout {


    @Bind(R.id.left_text) TextView left_text ;
    @Bind(R.id.title_text) TextView title_text ;
    @Bind(R.id.back_btn) TextView  back_btn ;

    public static SimpleTopNav newDefualt(){
        SimpleTopNav nav = new SimpleTopNav(AppUtil.getContext());
        nav.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,AndroidUtil.dpToPx(50)));
        return nav;
    }

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
//        View v = AppUtil.inflate(R.layout.widget_simple_top_nav, this);
        LayoutInflater.from(getContext()).inflate(R.layout.widget_simple_top_nav, this, true);
        ButterKnife.bind(this,this);
//        setOrientation(HORIZONTAL);
//        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                AndroidUtil.dpToPx(50)));
        setBackgroundResource(R.drawable.background_tab);
        requestLayout();
    }

    @OnClick(R.id.back_btn)
    void goBack(){
        Nav.pop();
    }


    public void setTitle(String title) {
        this.title = title;
        title_text.setText(title);
//        requestLayout();
    }

    public void setLeftText(String leftText) {
        this.leftText = leftText;
        requestLayout();
    }




}
