package com.mardomsara.social.ui.views;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;

import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.Spanny;

/**
 * Created by Hamid on 8/5/2016.
 */
public class EmojiLinkerText extends EmojiconTextView {
    public EmojiLinkerText(Context context) {
        super(context);
        init();
    }

    public EmojiLinkerText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmojiLinkerText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
    }

	private int limit = -1;
    @Override
    public void setText(CharSequence text, BufferType type) {
		SpannableStringBuilder sb = null;//LinkerText.linkerText(text,this);

		CharSequence txtLimited = LangUtil.limitCharSequence(text,limit);
		sb = LinkerText.linkerText(txtLimited,this);

		if(text.length()>limit && limit >0  ){
			String txtLimited2 = txtLimited+shomeMore;
//			sb = LinkerText.linkerText(txtLimited,this);
			ClickableSpan clickableSpan = new ClickableSpan() {
				@Override
				public void onClick(View widget) {
					limit = 0;
					setText(text);
					Helper.showDebugMessage(txtLimited.toString());
				}
			};
			SpannableString s1 = new SpannableString(shomeMore);
			s1.setSpan(clickableSpan,0,s1.length(), Spanned.SPAN_MARK_MARK);
			sb.append(s1);
		}else {
//			setText(text);
		}

        super.setText(sb,type);
    }

	private static String shomeMore = "... بیشتر";
	public void setTextWithLimit(String text, int size) {
		limit = size;
		setText(text);
		/*String txtLimited = LangUtil.limitText(text,size);
		if(text.length()>size && size >0 ){
			String txtLimited2 = txtLimited+shomeMore;
			SpannableStringBuilder sb = LinkerText.linkerText(txtLimited,this);
			ClickableSpan clickableSpan = new ClickableSpan() {
				@Override
				public void onClick(View widget) {
					Helper.showDebugMessage(txtLimited);
				}
			};
			SpannableString s1 = new SpannableString(shomeMore);
			s1.setSpan(clickableSpan,0,s1.length(), Spanned.SPAN_MARK_MARK);
			sb.append(s1);
			super.se
		}else {
			setText(text);
		}*/
	}
}
