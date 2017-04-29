package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.FontCache;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/17/2016.
 */
//"Use XIcon"
@Deprecated
public class TextViewWithIcon_DEP extends LinearLayout {
    /*@Bind(R.id.text) TextView text;
    @Bind(R.id.icon) TextView icon;*/
	X.WidgetTextAndIcon x;

    public TextViewWithIcon_DEP(Context context) {
        super(context);
        init();
    }

    public TextViewWithIcon_DEP(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewWithIcon_DEP(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
		x =  new X.WidgetTextAndIcon(this);
//        LayoutInflater.from(getContext()).inflate(R.layout.widget_text_and_icon, this, true);
//        ButterKnife.bind(this,this);
        setOrientation(HORIZONTAL);
//        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
		x.icon.setTypeface(FontCache.getIonic());
		setClickable(true);
		setFocusable(true);
		setFocusableInTouchMode(true);
        requestLayout();
    }

    public void setTextAndIcon(String txt, String _icon){
        x.text.setText(txt);
        x.icon.setText(_icon);
        requestLayout();
    }

}
