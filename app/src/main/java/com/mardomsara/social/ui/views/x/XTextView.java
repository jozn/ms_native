package com.mardomsara.social.ui.views.x;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;

import com.mardomsara.emojicon.EmojiMaper;
import com.mardomsara.social.R;
import com.mardomsara.social.activities.MainAppActivity;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.utils.XTextViewUtils;

// this class is the master of all Emoji, linker, limiter

//Note: if you want to pass onClick to it's parent we must, set app:xEnableLinker="false" to dissable click handling in this object itself
public class XTextView extends android.support.v7.widget.AppCompatTextView {

	//////////////// Limits /////////////////////
	static final int SHOW_MORE = 1;
	static final int SHOW_LESS = 2;
	static final int SHOW_More_LESS_Color = AndroidUtil.getColor(R.color.text_gray_3);
	static final String SHOW_MORE_TEXT = " ..."+ LangUtil.halfSpace + "ادامه";
	static final String SHOW_LESS_TEXT = " کمتر";

	int showMoreLessNextActive = SHOW_MORE;
	int xLimitText = -1;

	/////////////// Emoji attrs //////////////
	private int mEmojiconSize;
	private float mEmojiconSizeRatio;
	private int mEmojiconAlignment;
	private int mEmojiconTextSize;
	private int mTextStart = 0;
	private int mTextLength = -1;
	private boolean mUseSystemDefault = false;
	//////////////////////////////////////////

	boolean xEnableEmoji = true;
	boolean xEnableLinker = false;

	IranFonts iranFonts = IranFonts.Iran;

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
			TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.XTextView);
			mEmojiconSize = (int) a.getDimension(R.styleable.XTextView_xEmojiconSize, getTextSize());//52// getTextSize()+0);
			mEmojiconAlignment = a.getInt(R.styleable.XTextView_xEmojiconAlignment, DynamicDrawableSpan.ALIGN_BASELINE);
			mTextStart = a.getInteger(R.styleable.XTextView_xEmojiconTextStart, 0);
			mTextLength = a.getInteger(R.styleable.XTextView_xEmojiconTextLength, -1);
			mUseSystemDefault = a.getBoolean(R.styleable.XTextView_xEmojiconUseSystemDefault, false);

			mEmojiconSizeRatio = a.getFloat(R.styleable.XTextView_xEmojiconSizeRatio,1.4f);
			mEmojiconSize = calEmojiconSizePolicy(mEmojiconSize,mEmojiconSizeRatio);

			//not emojis
			xEnableEmoji = a.getBoolean(R.styleable.XTextView_xEnableEmoji,xEnableEmoji);
			xEnableLinker = a.getBoolean(R.styleable.XTextView_xEnableLinker,xEnableLinker);
			xLimitText = a.getInteger(R.styleable.XTextView_xLimitText,-1);

			int indx = a.getInteger(R.styleable.XTextView_xFont,0);
			iranFonts = IranFonts.values()[indx];
			setTypeface(FontCache.get(iranFonts.path));

			a.recycle();
		}

		setText(getText());
	}

	@Override
	public void setText(CharSequence text, BufferType type) {

		/*if(xLimitText > 0 ){
			text = tolimitLinker(text);
		}else { //// TODO: 3/13/2017 imple for not linker enabled
			text = XTextViewUtils.linkerText(text,this);
		}*/

		if(xLimitText > 0 ){
			text = tolimitLinker(text);
		}else if (xEnableLinker){ //// TODO: 3/13/2017 imple for not linker enabled
			text = XTextViewUtils.linkerText(text,this);
		}

		if(xEnableEmoji){
			text = toEmojis(text);
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

	public CharSequence tolimitLinker(CharSequence text) {
		CharSequence txtLimited = LangUtil.limitCharSequence(text, xLimitText);
		SpannableStringBuilder sb = null;

		//if we must short text and show "more/less"
		if(text.length()> xLimitText && xLimitText >0 ){
			SpannableString s1 = null;
			if(showMoreLessNextActive == SHOW_MORE){
				ClickableSpan clickableSpan = new AppClickableSpan() {
					@Override
					public void onClick(View widget) {
						showMoreLessNextActive = SHOW_LESS;
						setText(text);
					}
				};
				s1 = new SpannableString(SHOW_MORE_TEXT);
				s1.setSpan(clickableSpan,0,s1.length(), Spanned.SPAN_MARK_MARK);
				limiter_setShowMoreColor(s1);
				sb = XTextViewUtils.linkerText(txtLimited,this);
			}else {//active: show less -- complete text
				ClickableSpan clickableSpan = new AppClickableSpan() {
					@Override
					public void onClick(View widget) {
						showMoreLessNextActive = SHOW_MORE;
						setText(text);
					}
				};
				s1 = new SpannableString(SHOW_LESS_TEXT);
				s1.setSpan(clickableSpan,0,s1.length(), Spanned.SPAN_MARK_MARK);
				limiter_setShowMoreColor(s1);
				sb = XTextViewUtils.linkerText(text,this);
			}

			sb.append(s1);
		}else {//if text is short enough
			sb = XTextViewUtils.linkerText(text,this);
		}

		return sb;
	}

	public void setTextWithLimits(String text, int size) {
		xLimitText = size;
		showMoreLessNextActive = SHOW_MORE;//must reset because of reusing in RV
		setText(text);
	}

	void limiter_setShowMoreColor(SpannableString s1){
		s1.setSpan(new StyleSpan(Typeface.BOLD),0,s1.length(), Spanned.SPAN_MARK_MARK);
		s1.setSpan(new ForegroundColorSpan(SHOW_More_LESS_Color),0,s1.length(), Spanned.SPAN_MARK_MARK);
	}

	void setEmojiconSizePolicy(float textSize){
		AppUtil.log("setEmojiconSizePolicy: "+textSize);
		mEmojiconSize = (int) Math.round(1.5 * textSize);//alwase 2
	}


	int calEmojiconSizePolicy(float textSize,float ratio){
//		AppUtil.log("calEmojiconSizePolicy: "+textSize);
		return  (int) Math.round(ratio * textSize);//alwase 2

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
			multiEmojiSize = calEmojiconSizePolicy(multiTextSize,mEmojiconSizeRatio);
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

	void play() {
		AppUtil.getContext();
	}

}
