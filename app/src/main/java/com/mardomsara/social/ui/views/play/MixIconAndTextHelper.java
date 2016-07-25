package com.mardomsara.social.ui.views.play;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 7/14/2016.
 */
public class MixIconAndTextHelper {
    public static Spannable MixIconAndText(String text, String iconIonic) {
//        Spannable span = new SpannableString(mTextView.getText());
//        span.setSpan(FontCache.getIonic(),0,17,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        span.setSpan(robotoLight,18,37,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        TypefaceSpan face = new TypefaceSpan()
        int txtLength = text.length()+1;
        int iconLength = iconIonic.length();
        Typeface font1 = FontCache.get(AndroidUtil.getString(R.string.font_iran));
        Typeface font2 = FontCache.getIonic();
        //hack: problem in mixi RTL and LTR
        int color = Color.parseColor("#00000000");
        ForegroundColorSpan hide = new ForegroundColorSpan(color);
        CustomTypefaceSpan c1 = new CustomTypefaceSpan("sans-serif",font1);
        CustomTypefaceSpan c2 = new CustomTypefaceSpan("sans-serif",font2);
//        Span
//        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(iconIonic+text);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("I"+text+iconIonic);
        stringBuilder.setSpan(hide,0,1, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c1,1,txtLength, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        stringBuilder.setSpan(c2,txtLength,txtLength+iconLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        stringBuilder.setSpan(c1,txtLength,txtLength+iconLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c2,txtLength,iconLength+txtLength, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        stringBuilder.setSpan(c2,txtLength+iconLength,txtLength+iconLength*2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return stringBuilder;
    }

    public static Spannable MixIconAndText(String text,String numStr ,String iconIonic) {
//        Spannable span = new SpannableString(mTextView.getText());
//        span.setSpan(FontCache.getIonic(),0,17,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        span.setSpan(robotoLight,18,37,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        TypefaceSpan face = new TypefaceSpan()
        int txtLength = text.length();
        int numLength = numStr.length();
        int iconLength = iconIonic.length();
        Typeface font1 = FontCache.get(AndroidUtil.getString(R.string.font_iran));
        Typeface font2 = FontCache.getIonic();
        //hack: problem in mixi RTL and LTR
        int color = Color.parseColor("#00000000");
        ForegroundColorSpan hide = new ForegroundColorSpan(color);
        CustomTypefaceSpan c1 = new CustomTypefaceSpan("sans-serif",font1);
        CustomTypefaceSpan c2 = new CustomTypefaceSpan("sans-serif",font2);
//        Span
//        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(iconIonic+text);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("I"+text+numStr+iconIonic);
        stringBuilder.setSpan(hide,0,1, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c1,1,txtLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c1,1+txtLength,1+numLength+txtLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        stringBuilder.setSpan(c2,txtLength,txtLength+iconLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        stringBuilder.setSpan(c1,txtLength,txtLength+iconLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c2,1+numLength+txtLength,1+numLength+txtLength+iconLength, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        /*SpannableStringBuilder stringBuilder = new SpannableStringBuilder("I"+numStr+text+iconIonic);
        stringBuilder.setSpan(hide,0,1, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c1,1,numLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c1,1+numLength,1+numLength+txtLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        stringBuilder.setSpan(c2,txtLength,txtLength+iconLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        stringBuilder.setSpan(c1,txtLength,txtLength+iconLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c2,1+numLength+txtLength,1+numLength+txtLength+iconLength, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        */
//        stringBuilder.setSpan(c2,txtLength+iconLength,txtLength+iconLength*2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return stringBuilder;
    }

    public static Spannable MixIconAndText4(String text,String numStr ,String iconIonic) {
        int txtLength = text.length();
        int numLength = numStr.length();
        int iconLength = iconIonic.length();
        Typeface font1 = FontCache.get(AndroidUtil.getString(R.string.font_iran));
        Typeface font2 = FontCache.getIonic();
        //hack: problem in mixi RTL and LTR
        int color = Color.parseColor("#00000000");
        ForegroundColorSpan hide = new ForegroundColorSpan(color);
        CustomTypefaceSpan c1 = new CustomTypefaceSpan("sans-serif",font1);
        CustomTypefaceSpan c2 = new CustomTypefaceSpan("sans-serif",font2);
//        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("I"+text+numStr+iconIonic);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("I"+numStr+text+iconIonic+numStr);
        stringBuilder.setSpan(c1,0,numLength, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c2,numLength,txtLength+numLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c1,numLength,txtLength+numLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        stringBuilder.setSpan(c2,txtLength+numLength,numLength+txtLength+iconLength, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

//        BitmapDrawable
        return stringBuilder;
    }


}
