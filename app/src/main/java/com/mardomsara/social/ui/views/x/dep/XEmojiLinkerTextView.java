package com.mardomsara.social.ui.views.x.dep;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;

import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.ui.views.utils.XTextViewUtils;

/**
 * Created by Hamid on 8/5/2016.
 */
@Deprecated //delete this
public class XEmojiLinkerTextView extends EmojiconTextView {
    public XEmojiLinkerTextView(Context context) {
        super(context);
        init();
    }

    public XEmojiLinkerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XEmojiLinkerTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
    }

	static int SHOW_MORE = 1;
	static int SHOW_LESS = 2;
	static int SHOW_More_LESS_Color = AndroidUtil.getColor(R.color.text_gray_3);
	static String SHOW_MORE_TEXT = " ..."+ LangUtil.halfSpace + "ادامه";
	static String SHOW_LESS_TEXT = " کمتر";

	int showMoreLessNextActive = SHOW_MORE;
	int limit = -1;

    @Override
    public void setText(CharSequence text, BufferType type) {
		CharSequence txtLimited = LangUtil.limitCharSequence(text,limit);
		SpannableStringBuilder sb = null;

		//if we must short text and show "more/less"
		if(text.length()>limit && limit >0 ){
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
				setShowMoreColor(s1);
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
				setShowMoreColor(s1);
				sb = XTextViewUtils.linkerText(text,this);
			}

			sb.append(s1);
		}else {//if text is short enough
			sb = XTextViewUtils.linkerText(text,this);
		}

        super.setText(sb,type);
    }

	public void setTextWithLimits(String text, int size) {
		limit = size;
		showMoreLessNextActive = SHOW_MORE;//must reset because of reusing in RV
		setText(text);
	}

	void setShowMoreColor(SpannableString s1){
		s1.setSpan(new StyleSpan(Typeface.BOLD),0,s1.length(), Spanned.SPAN_MARK_MARK);
		s1.setSpan(new ForegroundColorSpan(SHOW_More_LESS_Color),0,s1.length(), Spanned.SPAN_MARK_MARK);
	}
}
