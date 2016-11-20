package com.mardomsara.social.ui.views.play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 7/14/2016.
 */
public class IconAnTextView_DEP_MAYBE extends TextView {
    public IconAnTextView_DEP_MAYBE(Context context) {
        super(context);
        init();
    }

    public IconAnTextView_DEP_MAYBE(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IconAnTextView_DEP_MAYBE(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Paint paintIonic = new Paint();
    Paint paintIran = new Paint();
    private void init() {
        paintIonic.setStyle(Paint.Style.FILL_AND_STROKE);
        paintIonic.setTypeface(FontCache.getIonic());
        paintIran.setTypeface(FontCache.get(AndroidUtil.getString(R.string.font_iran)));


    }

    String text="";
    String count="";
    String icon="";
    float textSize;
    float countSize;
    float icontSize;

    public void setTexts(String text, String count, String icon){
        this.text= text;
        this.count = count;
        this.icon = icon;
        init2();
    }

    private void init2() {

        textSize = paintIran.measureText(text);
        countSize = paintIran.measureText(count);
        icontSize = paintIonic.measureText(icon);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        init2();
        canvas.save();
//        super.onDraw(canvas);
        paintIonic.setAntiAlias(true);
        paintIran.setAntiAlias(true);
        paintIonic.setStyle(Paint.Style.FILL_AND_STROKE);
        paintIran.setStyle(Paint.Style.FILL_AND_STROKE);
        paintIonic.setColor(Color.BLACK);
        paintIran.setColor(Color.RED);
        paintIonic.setTextSize(getTextSize());
        paintIran.setTextSize(getTextSize());
        paintIonic.setTextAlign(Paint.Align.LEFT);
        paintIran.setTextAlign(Paint.Align.LEFT);
        paintIonic.setStyle(Paint.Style.FILL_AND_STROKE);
        paintIran.setStyle(Paint.Style.FILL_AND_STROKE);

        float pl = getPaddingLeft();
        float pt = ((float)getHeight())/2.0f;
//        canvas.drawRect(0,0,getWidth(),getHeight(),paintIran);

        canvas.drawText(text,pl+0,pt,paintIran);
        canvas.drawText(count,pl+textSize+countSize,pt,paintIran);
        canvas.drawText(icon,pl+countSize+icontSize,pt,paintIonic);
        paintIonic.reset();
        paintIonic.reset();
        canvas.restore();
    }
   /* private void centerTextWhitPadding(Canvas yourCanvas, Paint mPaint, String pageTitle) {
//        mPaint.setTextAlign(Paint.Align.LEFT);
//        mPaint.setColor(Color.argb(100, 0, 0, 255));
        r = yourCanvas.getClipBounds();
        RectF bounds = new RectF(r);
        bounds.right = mPaint.measureText(pageTitle, 0, pageTitle.length());
        bounds.bottom = mPaint.descent() - mPaint.ascent();
        bounds.left += (r.width() - bounds.right) / 2.0f;
        bounds.top += (r.height() - bounds.bottom) / 2.0f;
        yourCanvas.drawText(pageTitle, bounds.left, bounds.top - mPaint.ascent(), mPaint);
    }*/
}
