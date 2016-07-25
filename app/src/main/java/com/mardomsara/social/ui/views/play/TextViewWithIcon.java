package com.mardomsara.social.ui.views.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/17/2016.
 */
public class TextViewWithIcon extends LinearLayout {
    @Bind(R.id.text) TextView text;
    @Bind(R.id.icon) TextView icon;

    public TextViewWithIcon(Context context) {
        super(context);
        init();
    }

    public TextViewWithIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewWithIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.widget_text_and_icon, this, true);
        ButterKnife.bind(this,this);
        setOrientation(HORIZONTAL);
//        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        requestLayout();
    }

    public void setTextAndIcon(String txt, String _icon){
        text.setText(txt);
        icon.setText(_icon);
        requestLayout();
    }

}
