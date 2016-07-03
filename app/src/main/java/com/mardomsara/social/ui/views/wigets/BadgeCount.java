package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.mardomsara.social.helpers.AndroidUtil;

/**
 * Created by Hamid on 6/26/2016.
 */
public class BadgeCount extends TextView {

    Paint paint = new Paint();
    public BadgeCount(Context context) {
        super(context);
        init();
    }

    public BadgeCount(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BadgeCount(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
//        super.onDraw(canvas);
        canvas.save();
        int vPadding = getPaddingTop() + getPaddingBottom();
        int hPadding = getPaddingRight() + getPaddingLeft();
        float w = getWidth() - hPadding;
        float h = getHeight() - vPadding;
        float cx = w/2 + getPaddingLeft();
        float cy = (h)/2 + getPaddingTop();
//        float cy = (getHeight())/2 - (paint.descent() - paint.ascent() ) /2 ;
//        float cy = (getHeight())/2 ;//+getPaddingTop()  ;//(paint.descent() - paint.ascent() ) /2 ;
        float r = Math.min(w/2,h/2);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(cx,cy,r,paint);

        float tw = w/2;
        float th = (h/2 - (paint.descent()+paint.ascent()))/2;
        paint.setColor(Color.RED);
        paint.setTextAlign(Paint.Align.CENTER);
//        paint.set
        paint.setTextSize(AndroidUtil.dpToPx(14));

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawRect(getPaddingLeft(),getPaddingTop(),getWidth() -getPaddingRight(),getHeight()-getPaddingBottom(),paint);
//        canvas.drawRoundRect(getPaddingLeft(),getPaddingTop(),getWidth() -getPaddingRight(),getHeight()-getPaddingBottom(),20,20,paint);
        drawRoundedRect(canvas,(float)getPaddingLeft(),(float)getPaddingTop(),(float)getWidth() -(float)getPaddingRight(),(float)getHeight()-getPaddingBottom(),20,20,paint);
//        canvas.drawRoundRect();
        Log.d("canvas","cx , cy "+ cx + " " + cy + " "+paint.descent() + " "+paint.ascent() + " cx "+cx + " th "+th+  " th "+th);

        canvas.drawText("H6",tw,th,paint);
//        canvas.drawText(getText(),(w/2),(h/2),w,h,paint);

//        canvas.drawOval(0,0,w,h,paint);
        String s = new String(""+getText());
        centerText(canvas,paint,s);

        paint.reset();
        canvas.restore();
    }

    private Rect r = new Rect();
    // VinceStyling (light blue color):
    private void centerText(Canvas yourCanvas, Paint mPaint, String pageTitle) {
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setColor(Color.argb(100, 0, 0, 255));
        r = yourCanvas.getClipBounds();
        RectF bounds = new RectF(r);
        bounds.right = mPaint.measureText(pageTitle, 0, pageTitle.length());
        bounds.bottom = mPaint.descent() - mPaint.ascent();
        bounds.left += (r.width() - bounds.right) / 2.0f;
        bounds.top += (r.height() - bounds.bottom) / 2.0f;
        yourCanvas.drawText(pageTitle, bounds.left, bounds.top - mPaint.ascent(), mPaint);
    }

    private void drawRoundedRect2(Canvas canvas, float left, float top, float right, float bottom,float cx,float cy,Paint mainPaint) {
//        float radius = getHeight() / 2;
        float radius = Math.abs(bottom-top)/2;
        canvas.drawCircle(radius, radius, radius, mainPaint);
        canvas.drawCircle(right - radius, radius, radius, mainPaint);
        canvas.drawRect(left + radius, top, right - radius, bottom, mainPaint);
    }

    private void drawRoundedRect(Canvas canvas, float left, float top, float right, float bottom,float cx,float cy,Paint mainPaint) {
//        float radius = getHeight() / 2;
        float radius = Math.abs(bottom-top)/2;
        canvas.drawCircle(left+radius, top+radius, radius, mainPaint);
        canvas.drawCircle(right - radius, top+radius, radius, mainPaint);
        canvas.drawRect(left + radius, top, right - radius, bottom, mainPaint);
    }

}
