package com.mardomsara.social.ui.views;

import android.content.Context;
import android.util.AttributeSet;

import com.mardomsara.social.ui.views.utils.XTextViewUtils;

/**
 * Created by Hamid on 2/4/2016.
 */
public class XLinkerTextView extends android.support.v7.widget.AppCompatTextView {
    static String TAG ="LinkerText";
    public XLinkerTextView(Context context) {
        super(context);
        init();
    }

    public XLinkerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XLinkerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    int i = 0;
    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(XTextViewUtils.linkerText(text,this),type);
    }


    void init(){

    }

}
