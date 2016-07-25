package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

/**
 * Created by Hamid on 7/20/2016.
 */
public class LoadingView extends FrameLayout {
    View v;
    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
         v = AppUtil.inflate(R.layout.loading,this);
        addView(v);
    }

    public void hide(){
        v.setVisibility(GONE);
    }

    public void replace(View view){
        v.setVisibility(GONE);
        addView(view);
    }
}
