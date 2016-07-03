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

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;

/**
 * Created by Hamid on 6/26/2016.
 */
public class CountView extends TextView {

    //    int color = Color.argb(255,50,50,200);
    int color = AndroidUtil.getColor(R.color.unseen_count_background);
    int countHPadding = AndroidUtil.dpToPx(4);
    int countVPadding = AndroidUtil.dpToPx(2);

    Paint paint = new Paint();
    public CountView(Context context) {
        super(context);
        init();
    }

    public CountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
        initPaint();
        setPaddingRelative(getPaddingLeft() + countHPadding ,
                getPaddingTop() + countVPadding
                ,getPaddingRight() + countHPadding ,
                getPaddingBottom() + countVPadding
        );
//        setMinimumWidth(AndroidUtil.dpToPx(30));
    }

    void initPaint(){
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

//        setPaddingRelative();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initPaint();
        canvas.save();
        int vPadding = getPaddingTop() + getPaddingBottom();
        int hPadding = getPaddingRight() + getPaddingLeft();
        float w = getWidth() - hPadding;// +countHPadding;
        float h = getHeight() - vPadding;// + countVPadding;
        float cx = w/2 + getPaddingLeft();
        float cy = (h)/2 + getPaddingTop();
        float r = Math.min(w/2,h/2);

        paint.setStyle(Paint.Style.STROKE);

        float tw = w/2;
        float th = (h/2 - (paint.descent()+paint.ascent()))/2;

        //draw Rect
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(color);
        drawEdgeRoundedRect(
                canvas,
                (float)getPaddingLeft()-countHPadding ,
                (float)getPaddingTop() - countVPadding ,
                (float)getWidth() -(float)getPaddingRight() + countHPadding ,
                (float)getHeight()- getPaddingBottom() + countVPadding ,
                paint);

        //draw count
        paint.setColor(Color.WHITE);
        paint.setTextSize(getTextSize());
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        centerText(canvas,paint,getText().toString());

//        Log.d("canvas","cx , cy "+ cx + " " + cy + " "+paint.descent() + " "+paint.ascent() + " cx "+cx + " th "+th+  " th "+th);

        paint.reset();
        canvas.restore();
    }

    public void setCount(int count){
        setText(""+count);
        if(count>0){
            setVisibility(VISIBLE);
        }else {
            setVisibility(INVISIBLE);
        }
    }

    public void setColor(int color) {
        this.color = color;
    }

    //TODO: extarct canvas funcs to CanvasUtil

    private Rect r = new Rect();
    // VinceStyling (light blue color):
    private void centerText(Canvas yourCanvas, Paint mPaint, String pageTitle) {
        mPaint.setTextAlign(Paint.Align.LEFT);
//        mPaint.setColor(Color.argb(100, 0, 0, 255));
        r = yourCanvas.getClipBounds();
        RectF bounds = new RectF(r);
        bounds.right = mPaint.measureText(pageTitle, 0, pageTitle.length());
        bounds.bottom = mPaint.descent() - mPaint.ascent();
        bounds.left += (r.width() - bounds.right) / 2.0f;
        bounds.top += (r.height() - bounds.bottom) / 2.0f;
        yourCanvas.drawText(pageTitle, bounds.left, bounds.top - mPaint.ascent(), mPaint);
    }

    private void centerTextWhitPadding(Canvas yourCanvas, Paint mPaint, String pageTitle) {
//        mPaint.setTextAlign(Paint.Align.LEFT);
//        mPaint.setColor(Color.argb(100, 0, 0, 255));
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

    private void drawEdgeRoundedRect(Canvas canvas, float left, float top, float right, float bottom, Paint mainPaint) {
//        float radius = getHeight() / 2;
        float radius = Math.abs(bottom-top)/2;
        canvas.drawCircle(left+radius, top+radius, radius, mainPaint);
        canvas.drawCircle(right - radius, top+radius, radius, mainPaint);
        canvas.drawRect(left + radius, top, right - radius, bottom, mainPaint);
    }

}
