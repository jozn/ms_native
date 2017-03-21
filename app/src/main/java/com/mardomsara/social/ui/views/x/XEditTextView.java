/*
 * Copyright 2014 Hieu Rocker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mardomsara.social.ui.views.x;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.FontCache;

// a copy of EmojiconEditText -- just added font and styalable to XEditTextView
//// TODO: 3/21/2017 not all styleable works
public class XEditTextView extends AppCompatEditText {
    private int mEmojiconSize;
    private int mEmojiconAlignment;
    private int mEmojiconTextSize;
    private boolean mUseSystemDefault = false;

	IranFonts iranFonts = IranFonts.Iran;

    public XEditTextView(Context context) {
        super(context);
        mEmojiconSize = (int) getTextSize();
        mEmojiconTextSize = (int) getTextSize();
    }

    public XEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public XEditTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.XEditTextView);
		try {
			mEmojiconSize = (int) a.getDimension(R.styleable.XEditTextView_xEmojiconSize, getTextSize());
			mEmojiconAlignment = a.getInt(R.styleable.XEditTextView_xEmojiconAlignment, DynamicDrawableSpan.ALIGN_BASELINE);
			mUseSystemDefault = a.getBoolean(R.styleable.XEditTextView_xEmojiconUseSystemDefault, false);
			mEmojiconTextSize = (int) getTextSize();
			mEmojiconSize = (int) Math.round(1.5 * mEmojiconSize);//alwase

			//font iran
			int indx = a.getInteger(R.styleable.XEditTextView_xFont,0);
			iranFonts = IranFonts.values()[indx];
		}finally {
			a.recycle();
		}

		setTypeface(FontCache.get(iranFonts.path));
        setText(getText());
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        updateText();
    }

    /**
     * Set the size of emojicon in pixels.
     */
    public void setEmojiconSize(int pixels) {
        mEmojiconSize = pixels;

        updateText();
    }

    private void updateText() {
//        EmojiconHandler.addEmojis(getContext(), getText(), mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mUseSystemDefault);
        EmojiMaper.addEmojis(getContext(), getText(), mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mUseSystemDefault);

    }

    /**
     * Set whether to use system default emojicon
     */
    public void setUseSystemDefault(boolean useSystemDefault) {
        mUseSystemDefault = useSystemDefault;
    }
}
