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

package com.mardomsara.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;

//import android.text.SpannableString;

/**
 * @author Hieu Rocker (rockerhieu@gmail.com).
 */
@Deprecated //use XTextView
public class EmojiconTextView extends TextView {
    private int mEmojiconSize;
    private int mEmojiconAlignment;
    private int mEmojiconTextSize;
    private int mTextStart = 0;
    private int mTextLength = -1;
    private boolean mUseSystemDefault = false;

    public EmojiconTextView(Context context) {
        super(context);
        init(null);
    }

    public EmojiconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EmojiconTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mEmojiconTextSize = (int) getTextSize();
        if (attrs == null) {
            mEmojiconSize = (int) getTextSize();
        } else {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Emojicon);
            mEmojiconSize = (int) a.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize());//52// getTextSize()+0);
            mEmojiconAlignment = a.getInt(R.styleable.Emojicon_emojiconAlignment, DynamicDrawableSpan.ALIGN_BASELINE);
            mTextStart = a.getInteger(R.styleable.Emojicon_emojiconTextStart, 0);
            mTextLength = a.getInteger(R.styleable.Emojicon_emojiconTextLength, -1);
            mUseSystemDefault = a.getBoolean(R.styleable.Emojicon_emojiconUseSystemDefault, false);
//            mEmojiconSize = (int) Math.round(1.5 * mEmojiconSize);//alwase 2
//			setEmojiconSizePolicy((float) mEmojiconSize);//this mEmojiconSize == getTextSize()
			mEmojiconSize = calEmojiconSizePolicy(mEmojiconSize);
            a.recycle();
        }
//		setLineSpacing(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35.0f,  getResources().getDisplayMetrics()),20f);

		setText(getText());
	}

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!TextUtils.isEmpty(text)){// && false) {

//            SpannableStringBuilder builder = new SpannableStringBuilder(text);
            SpannableString builder = new SpannableString(text);
//            SimpleSpan builder = new SimpleSpan(text);
//            SpannableString builder = new SimpleSpannble00(text);
//            EmojiconHandler.addEmojis(getContext(), builder, mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mTextStart, mTextLength, mUseSystemDefault);
//            EmojiMaper.addEmojis(getContext(), builder, mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mTextStart, mTextLength, mUseSystemDefault);
			if(isSetMultiple){
				setLineSpacing(multiEmojiSize/2f,1.1f);
				setPxTextSize(multiTextSize);
				EmojiMaper.addEmojis(getContext(), builder, multiEmojiSize, mEmojiconAlignment,(int) multiTextSize, mTextStart,mTextLength, mUseSystemDefault);
			}else {
//				setPxTextSize(mEmojiconTextSize);
				setLineSpacing(0,1);
				EmojiMaper.addEmojis(getContext(), builder, mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mTextStart, mTextLength, mUseSystemDefault);
			}
//			mEmojiconTextSize  = (int)getTextSize();//Me: mEmojiconTextSize changes based on mEmojiconSize sizes

            text = builder;
        }
        super.setText(text, type);
    }

	void setEmojiconSizePolicy(float textSize){
		AppUtil.log("setEmojiconSizePolicy: "+textSize);
		mEmojiconSize = (int) Math.round(1.5 * textSize);//alwase 2
	}

	int calEmojiconSizePolicy(float textSize){
		AppUtil.log("calEmojiconSizePolicy: "+textSize);
		return  (int) Math.round(1.5 * textSize);//alwase 2

	}

	boolean isSetMultiple = false;
	int multiEmojiSize = 0;
	float multiTextSize = 0;
	float ratio = 1f;
	public void setSizeMultiple(float ratio) {
		isSetMultiple = true;
		if(multiEmojiSize == 0 && multiTextSize == 0){
			this.ratio = ratio;
			multiTextSize = (getTextSize()*ratio);
			setPxTextSize(multiTextSize);
			multiEmojiSize = calEmojiconSizePolicy(multiTextSize);
			super.setText(getText());
		}
	}

	public void restSizes() {
		isSetMultiple = false;
		multiEmojiSize = 0;
		multiTextSize = 0;
		setPxTextSize(mEmojiconTextSize);
		super.setText(getText());
	}

	void setPxTextSize(float size){
		setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
	}

	@Override
	public int getLineHeight() {
		if(isSetMultiple){
			return super.getLineHeight() + multiEmojiSize;
		}
		return super.getLineHeight();
	}

    /**
     * Set whether to use system default emojicon
     */
    public void setUseSystemDefault(boolean useSystemDefault) {
        mUseSystemDefault = useSystemDefault;
    }
}



/*


		/////All below are deprecated:

    */
/**
 * Set the size of emojicon in pixels.
 *//*

	@Deprecated
    public void setEmojiconSize(int pixels) {
        mEmojiconSize = pixels;
        super.setText(getText());
    }

    float _oldTextSize =-1;
    int _oldmEmojiconSize =-1;
    public void setJustEmojiconSize(int pixels) {
//        getLineHeight();
		backupOldSizes();

        setTextSize(pixels);
//        setLineSpacing(pixels,1);
        mEmojiconSize = pixels;
        super.setText(getText());
    }

	boolean hasSetMultiple = false;
	public void setEmojiSizeMultiple(float ratio) {
		if(hasSetMultiple == true)return;

		hasSetMultiple = true;

		backupOldSizes();

		float pixels = (getTextSize()*ratio);
		setTextSize(pixels);
		setEmojiconSizePolicy(pixels);
		super.setText(getText());
	}

    public void restOriginalEmojiSize() {
		hasSetMultiple = false;
        resetOldSizes();
		super.setText(getText());
    }

	private void backupOldSizes(){
		if(_oldTextSize == -1){
			_oldTextSize = getTextSize();
			_oldmEmojiconSize = mEmojiconSize;
		}
	}

	private void resetOldSizes(){
		if(_oldTextSize != -1){
			setTextSize(_oldTextSize);
			mEmojiconSize = _oldmEmojiconSize;

			_oldTextSize = -1;
			_oldmEmojiconSize = -1;
		}
	}
*/


