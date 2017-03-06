package com.mardomsara.x.iconify.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.mardomsara.x.iconify.Iconify;
import com.mardomsara.x.iconify.internal.HasOnViewAttachListener;

public class XIcon extends AppCompatTextView implements HasOnViewAttachListener {

    private HasOnViewAttachListenerDelegate delegate;

    public XIcon(Context context) {
        super(context);
        init();
    }

    public XIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setTransformationMethod(null);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(Iconify.compute(getContext(), text, this), type);
    }


    public void setFullText(CharSequence text){

	}


    @Override
    public void setOnViewAttachListener(OnViewAttachListener listener) {
        if (delegate == null) delegate = new HasOnViewAttachListenerDelegate(this);
        delegate.setOnViewAttachListener(listener);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        delegate.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        delegate.onDetachedFromWindow();
    }
}
