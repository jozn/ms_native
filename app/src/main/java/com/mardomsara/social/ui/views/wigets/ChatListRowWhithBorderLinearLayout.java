package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Hamid on 6/27/2016.
 */
public class ChatListRowWhithBorderLinearLayout extends LinearLayout {
    public ChatListRowWhithBorderLinearLayout(Context context) {
        super(context);
    }

    public ChatListRowWhithBorderLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChatListRowWhithBorderLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();
//    Path paint = new Paint();
//    Paint paint = new Paint();
    int xoff = -1;
    View child;
    View child0;
    int color = Color.parseColor("#dddddd");
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(xoff == -1 ){
            child = getChildAt(1);
            child0 = getChildAt(0);
            xoff = getPaddingRight() + child.getWidth() +child.getPaddingLeft()+child.getPaddingRight() + child0.getPaddingRight();
        }

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(color);
        canvas.drawLine(0,getHeight()-1,getWidth()-xoff,getHeight()-1,paint);
//        canvas.drawRect(0,getHeight(),getWidth(),getHeight(),paint);
//        canvas.drawCircle(0,0,100,paint);


    }
}
