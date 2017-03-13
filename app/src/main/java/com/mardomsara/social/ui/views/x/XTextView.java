package com.mardomsara.social.ui.views.x;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.utils.XTextViewUtils;
import com.mardomsara.social.ui.views.x.internal.ZCommonXTextViewStates;

// this class is the master of all Emoji, linker, limiter
public class XTextView extends android.support.v7.widget.AppCompatTextView {

	/////////////// Emoji attrs //////////////
	private int mEmojiconSize;
	private int mEmojiconAlignment;
	private int mEmojiconTextSize;
	private int mTextStart = 0;
	private int mTextLength = -1;
	private boolean mUseSystemDefault = false;
	//////////////////////////////////////////

	boolean xEnableEmoji = false;
	boolean xEnableLinker = false;

	public XTextView(Context context) {
		super(context);
		init(null);
	}

	public XTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public XTextView(Context context, AttributeSet attrs, int defStyle) {
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
			mEmojiconSize = calEmojiconSizePolicy(mEmojiconSize);
			a.recycle();
		}

		setText(getText());
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		if(xEnableEmoji){
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
		}

		super.setText(text, type);
	}

	private CharSequence toEmojis(CharSequence text){
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
		return text;
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
