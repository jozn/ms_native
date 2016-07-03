package com.mardomsara.emojicon.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Hamid on 6/25/2016.
 */
public class SimpleText extends View {
    public SimpleText(Context context) {
        super(context);
    }

    public SimpleText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
