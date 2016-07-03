package com.mardomsara.social.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Hamid on 6/26/2016.
 */
public class CounterView extends View {
    public CounterView(Context context) {
        super(context);
    }

    Rect r ;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        r = canvas.getClipBounds();

        canvas.save();

        canvas.save();

        canvas.restore();
    }
}
