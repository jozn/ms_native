package com.mardomsara.emojicon;

import android.text.Spannable;
import android.text.Spanned;

import java.lang.reflect.Array;

/**
 * Created by Hamid on 6/25/2016.
 */
public class SimpleSpannble00 implements  Spannable,Spanned {
    CharSequence _text;
    public SimpleSpannble00(CharSequence text) {
        _text = text;
    }

    @Override
    public void setSpan(Object what, int start, int end, int flags) {

    }

    @Override
    public void removeSpan(Object what) {

    }

    @Override
    public <T> T[] getSpans(int start, int end, Class<T> type) {
        return (T[]) Array.newInstance(type,0);
    }

    @Override
    public int getSpanStart(Object tag) {
        return 0;
    }

    @Override
    public int getSpanEnd(Object tag) {
        return 0;
    }

    @Override
    public int getSpanFlags(Object tag) {
        return 0;
    }

    @Override
    public int nextSpanTransition(int start, int limit, Class type) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
