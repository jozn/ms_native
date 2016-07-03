/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mardomsara.emojicon;

import android.text.GetChars;
import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.Objects;

public  class SimpleSpan implements CharSequence, GetChars, Spannable {

    private String mText;
    private Object[] mSpans;
    private int[] mSpanData;
    private int mSpanCount;

    int _txtLength =0;

    static final Object[] EMPTY = new Object[0];

    private static final int START = 0;
    private static final int END = 1;
    private static final int FLAGS = 2;
    private static final int COLUMNS = 3;

     SimpleSpan(CharSequence source) {
         this(source,0,source.length());
     }
     SimpleSpan(CharSequence source, int start, int end) {
        if (start == 0 && end == source.length())
            mText = source.toString();
        else
            mText = source.toString().substring(start, end);

        mSpans = new Object[10] ;//= EmptyArray.OBJECT;
        mSpanData = new int[10*3]; //EmptyArray.INT;
        _txtLength = source.length();

    }

    public final int length() {
        return mText.length();
    }

    public final char charAt(int i) {
        return mText.charAt(i);
    }

    public final String toString() {
        return mText;
    }

    /* subclasses must do subSequence() to preserve type */

    public final void getChars(int start, int end, char[] dest, int off) {
        mText.getChars(start, end, dest, off);
    }

    public final CharSequence subSequence(int start, int end) {
        return new SimpleSpan(mText, start, end);
    }

    public void setSpan(Object what, int start, int end, int flags) {
        int nstart = start;
        int nend = end;

        checkRange("setSpan", start, end);

        if ((flags & Spannable.SPAN_PARAGRAPH) == Spannable.SPAN_PARAGRAPH) {
            if (start != 0 && start != length()) {
                char c = charAt(start - 1);

                if (c != '\n')
                    throw new RuntimeException(
                            "PARAGRAPH span must start at paragraph boundary" +
                            " (" + start + " follows " + c + ")");
            }

            if (end != 0 && end != length()) {
                char c = charAt(end - 1);

                if (c != '\n')
                    throw new RuntimeException(
                            "PARAGRAPH span must end at paragraph boundary" +
                            " (" + end + " follows " + c + ")");
            }
        }

        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;

        //grow arrays
        if (mSpanCount + 1 >= mSpans.length) {
            Object[] newtags = new Object[mSpanCount*2];
            int[] newdata = new int[newtags.length * 3];

            System.arraycopy(mSpans, 0, newtags, 0, mSpanCount);
            System.arraycopy(mSpanData, 0, newdata, 0, mSpanCount * 3);

            mSpans = newtags;
            mSpanData = newdata;
        }

        mSpans[mSpanCount] = what;
        mSpanData[mSpanCount * COLUMNS + START] = start;
        mSpanData[mSpanCount * COLUMNS + END] = end;
        mSpanData[mSpanCount * COLUMNS + FLAGS] = flags;
        mSpanCount++;

    }

    public void removeSpan(Object what) {

    }

    public int getSpanStart(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;

        for (int i = count - 1; i >= 0; i--) {
            if (spans[i] == what) {
                return data[i * COLUMNS + START];
            }
        }

        return -1;
    }

    public int getSpanEnd(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;

        for (int i = count - 1; i >= 0; i--) {
            if (spans[i] == what) {
                return data[i * COLUMNS + END];
            }
        }

        return -1;
    }

    public int getSpanFlags(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;

        for (int i = count - 1; i >= 0; i--) {
            if (spans[i] == what) {
                return data[i * COLUMNS + FLAGS];
            }
        }

        return 0; 
    }

//    HashMap<Class,>

    ///ME: added _cashe: getSpans() is called many times because of statics text hust retun
    // the pervious one

    public interface CachedSpan{

    }


    Object[] _periousSpan = null;
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
//        Log.d("Spans","__txtLength: "+ _txtLength + " queryStart: "+ queryStart + " queryEnd: "+ queryEnd + " kind " + kind.getSimpleName());
        boolean _toCache = false;
//        Log.d("Spans","klass: "+Object.class.equals(kind));
        if(queryEnd == _txtLength && queryStart ==0 ){
//            Log.d("Spans","from 111 cache");
//            if( CachedSpan.class.isInstance(kind)){// || Objects.class.equals(kind)){
            if( Object.class.equals(kind) == true){// || Objects.class.equals(kind)){
//                Log.d("Spans","from 22222 cache");
                _toCache = true;
                if (_periousSpan != null) {
//                    Log.d("Spans","from cache");
                    return (T[])_periousSpan;
                }
            }
        }
//        if(null != _periousSpan) return (T[])_periousSpan;
        int count = 0;


        int spanCount = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        Object[] ret = null;
        Object ret1 = null;

        for (int i = 0; i < spanCount; i++) {
            int spanStart = data[i * COLUMNS + START];
            int spanEnd = data[i * COLUMNS + END];

            if (spanStart > queryEnd) {
                continue;
            }
            if (spanEnd < queryStart) {
                continue;
            }

            if (spanStart != spanEnd && queryStart != queryEnd) {
                if (spanStart == queryEnd) {
                    continue;
                }
                if (spanEnd == queryStart) {
                    continue;
                }
            }

            // verify span class as late as possible, since it is expensive
            if (kind != null && !kind.isInstance(spans[i])) {
                continue;
            }

            if (count == 0) {
                ret1 = spans[i];
                count++;
            } else {
                if (count == 1) {
                    ret = (Object[]) Array.newInstance(kind, spanCount - i + 1);
                    ret[0] = ret1;
                }

                ret[count++] = spans[i];
            }
        }

        if (count == 0) {
            ret = (T[]) Array.newInstance(kind, 0);
//            _periousSpan = n;
        }else if (count == 1) {
            ret = (Object[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
        }

        if(_toCache ==true) _periousSpan = ret;
        return (T[]) ret;
//
//        Object[] nret = (Object[]) Array.newInstance(kind, count);
//        System.arraycopy(ret, 0, nret, 0, count);
//        _periousSpan = nret;
//        return (T[]) nret;
    }

    public int nextSpanTransition(int start, int limit, Class kind) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;

        if (kind == null) {
            kind = Object.class;
        }

        for (int i = 0; i < count; i++) {
            int st = data[i * COLUMNS + START];
            int en = data[i * COLUMNS + END];

            if (st > start && st < limit && kind.isInstance(spans[i]))
                limit = st;
            if (en > start && en < limit && kind.isInstance(spans[i]))
                limit = en;
        }

        return limit;
    }


    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    private void checkRange(final String operation, int start, int end) {
        if (end < start) {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
        }

        int len = length();

        if (start > len || end > len) {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
        }

        if (start < 0 || end < 0) {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
        }
    }

    // Same as SpannableStringBuilder
    @Override
    public boolean equals(Object o) {
        if (o instanceof Spanned &&
                toString().equals(o.toString())) {
            Spanned other = (Spanned) o;
            // Check span data
            Object[] otherSpans = other.getSpans(0, other.length(), Object.class);
            if (mSpanCount == otherSpans.length) {
                for (int i = 0; i < mSpanCount; ++i) {
                    Object thisSpan = mSpans[i];
                    Object otherSpan = otherSpans[i];
                    if (thisSpan == this) {
                        if (other != otherSpan ||
                                getSpanStart(thisSpan) != other.getSpanStart(otherSpan) ||
                                getSpanEnd(thisSpan) != other.getSpanEnd(otherSpan) ||
                                getSpanFlags(thisSpan) != other.getSpanFlags(otherSpan)) {
                            return false;
                        }
                    } else if (!thisSpan.equals(otherSpan) ||
                            getSpanStart(thisSpan) != other.getSpanStart(otherSpan) ||
                            getSpanEnd(thisSpan) != other.getSpanEnd(otherSpan) ||
                            getSpanFlags(thisSpan) != other.getSpanFlags(otherSpan)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // Same as SpannableStringBuilder
    @Override
    public int hashCode() {
        int hash = toString().hashCode();
        hash = hash * 31 + mSpanCount;
        for (int i = 0; i < mSpanCount; ++i) {
            Object span = mSpans[i];
            if (span != this) {
                hash = hash * 31 + span.hashCode();
            }
            hash = hash * 31 + getSpanStart(span);
            hash = hash * 31 + getSpanEnd(span);
            hash = hash * 31 + getSpanFlags(span);
        }
        return hash;
    }


}
/*
    public <T> T[] getSpans_dep(int queryStart, int queryEnd, Class<T> kind) {
        Log.d("Spans"," queryStart: "+ queryStart + " queryEnd: "+ queryEnd + " kind " + kind.getSimpleName());
        if(null != _periousSpan) return (T[])_periousSpan;
        int count = 0;


        int spanCount = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        Object[] ret = null;
        Object ret1 = null;

        for (int i = 0; i < spanCount; i++) {
            int spanStart = data[i * COLUMNS + START];
            int spanEnd = data[i * COLUMNS + END];

            if (spanStart > queryEnd) {
                continue;
            }
            if (spanEnd < queryStart) {
                continue;
            }

            if (spanStart != spanEnd && queryStart != queryEnd) {
                if (spanStart == queryEnd) {
                    continue;
                }
                if (spanEnd == queryStart) {
                    continue;
                }
            }

            // verify span class as late as possible, since it is expensive
            if (kind != null && !kind.isInstance(spans[i])) {
                continue;
            }

            if (count == 0) {
                ret1 = spans[i];
                count++;
            } else {
                if (count == 1) {
                    ret = (Object[]) Array.newInstance(kind, spanCount - i + 1);
                    ret[0] = ret1;
                }

                int prio = data[i * COLUMNS + FLAGS] & Spanned.SPAN_PRIORITY;
                if (prio != 0) {
                    int j;

                    for (j = 0; j < count; j++) {
                        int p = getSpanFlags(ret[j]) & Spanned.SPAN_PRIORITY;

                        if (prio > p) {
                            break;
                        }
                    }

                    System.arraycopy(ret, j, ret, j + 1, count - j);
                    ret[j] = spans[i];
                    count++;
                } else {
                    ret[count++] = spans[i];
                }
            }
        }

        if (count == 0) {
//            return (T[]) null;//ArrayUtils.emptyArray(kind);
            T[] n = (T[]) Array.newInstance(kind, 0);
//            _periousSpan = n;
            return n;//(T[]) Array.newInstance(kind, 0);//ArrayUtils.emptyArray(kind);
        }
        if (count == 1) {
            ret = (Object[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
            _periousSpan = ret;
            return (T[]) ret;
        }
        if (count == ret.length) {
            _periousSpan = ret;
            return (T[]) ret;
        }

        Object[] nret = (Object[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
        _periousSpan = nret;
        return (T[]) nret;
    }
*/
