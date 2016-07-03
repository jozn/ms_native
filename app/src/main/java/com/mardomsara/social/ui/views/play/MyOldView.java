package com.mardomsara.social.ui.views.play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.ui.views.wigets.ColorGenerator;

/**
 * Created by Hamid on 6/25/2016.
 */
public class MyOldView extends TextView {
    public MyOldView(Context context) {
        super(context);
        init();
    }

    public MyOldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyOldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
        OnClickListener on = new OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("asd");
            }
        };

        setOnClickListener(on);
    }

    Paint paint = new Paint();

    ColorGenerator x = ColorGenerator.MATERIAL;

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        paint.setTextSize(140);
        Rect r = canvas.getClipBounds();
        int i = canvas.save();
        int w = getWidth();
        int h = getHeight();
//        canvas.drawText("adasdas",0,110,0,60,paint);
        paint.setColor(Color.BLACK);
        canvas.drawRect(10,0,50,150,paint);

//        paint.setColor(Color.BLACK);
        paint.setColor(x.getRandomColor());
        canvas.drawText("jhbhbh",10,110,paint);
        canvas.drawText("ساتم",10,310,paint);
        canvas.drawText("\uD83D\uDE1F \uD83D\uDE24 \uD83D\uDE22 \uD83D\uDE2D \uD83D\uDE26 \uD83D\uDE27 ",10,510,paint);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0,0,w,h,paint);

        paint.setColor(x.getRandomColor());
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(w/2,h/2,100,paint);
        canvas.restoreToCount(i);

    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }
}
