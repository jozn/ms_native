package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 6/27/2016.
 */
public class SimpleText extends View {
    public SimpleText(Context context) {
        super(context);
        init();
    }

    public SimpleText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener((v)->{
            Log.d("Text","clicked");
        });
//        setOnTouchListener((l,e)->{
////            e.
//        });
    }

    Paint p = new Paint();
    Typeface typeface = FontCache.get(AndroidUtil.getString(R.string.font_iran));
    TextPaint mTextPaint=new TextPaint();
    String mText = "sdasd ام به شم sad تهیتس سهبدس\uD83D\uDE00 \uD83D\uDE01 \uD83D\uDE02 \uD83D\uDE03 \uD83D\uDE04 \uD83D\uDE05 \uD83D\uDE06 \uD83D\uDE09 \uD83D\uDE0A \uD83D\uDE0B \uD83D\uDE0E \uD83D\uDE0D \uD83D\uDE18 \uD83D\uDE17 \uD83D\uDE19 \uD83D\uDE1A ☺️ \uD83D\uDE42 \uD83E\uDD17 \uD83D\uDE07 \uD83E\uDD13 \uD83E\uDD14 \uD83D\uDE10 \uD83D\uDE11یب سبسیبسیعبدب سبسدق صضفدثق سنلبیل یلبنیبتلبیل یبلنتس";
    @Override
    protected void onDraw(Canvas c) {

        p.setTypeface(typeface);
        mTextPaint.setTypeface(typeface);

        p.setTextSize(40);
        mTextPaint.setTextSize(40);
//        p.setLinearText();

//        centerText(c,p,"لام به شم sad تهیتس سهبدسیب سبسیبسیعبدب سبسدق صضفدثق سنلبیل یلبنیبتلبیل یبلنتسیدلتیل یخضهقصخهق کرمرو تاشسبا قهصعهقص فخحثقفنحثقنیب لیستلدسیتلا sdsfsd 785 ");

/*        c.drawText("This is", 100, 100, p);
        c.drawText("multi-line", 100, 150, p);
        c.drawText("text", 100, 200, p);
        c.drawText("text شسیشسیشس", 100, 250, p);
//        c.drawRect(0,0,getWidth(),getHeight(),p);
        c.drawText("adasdasd",0,0,getWidth(),getHeight(),p);*/
//        c.drawText("adasdas");
//        TextPaint;
//        StaticLayout

        StaticLayout mTextLayout = new StaticLayout(mText, mTextPaint, c.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
//        Linkify;
//        ClickableSpan;
//        LinkMovementMethod.getInstance()
        mTextLayout.draw(c);

    }

    private Rect r = new Rect();
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

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }
}
