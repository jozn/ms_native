package com.mardomsara.social.ui.views.utils;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.ui.presenter.pages.ProfilePage;
import com.mardomsara.social.ui.presenter.pages.TagsPage;
import com.mardomsara.social.ui.views.TextParser;

/**
 * Created by Hamid on 3/9/2017.
 */

public class XTextViewUtils {
	///////////////////////////////////////////////////
	/////////// Stattics //////////////////////////

	static ClickableSpan buildclick(final CharSequence s){

		ClickableSpan clickableSpan = new AppClickableSpan() {
			@Override
			public void onClick(View view) {
//				Toast.makeText(AppUtil.getContext(), s, Toast.LENGTH_LONG).show();
				Nav_DEP.push(new ProfilePage(s.toString()));
			}
		};
		return clickableSpan;
	}

	static ClickableSpan buildclickTag(final CharSequence s){

		ClickableSpan clickableSpan = new AppClickableSpan() {
			@Override
			public void onClick(View view) {
//                Toast.makeText(AppUtil.getContext(), s, Toast.LENGTH_LONG).show();
				Nav_DEP.push(new TagsPage(s.toString()));
			}
		};
		return clickableSpan;
	}

	public static SpannableStringBuilder linkerText(CharSequence txt, TextView textView){
		SpannableStringBuilder builder = new SpannableStringBuilder();
		TextParser.Lexing lex=  new TextParser.Lexing(txt.toString());
		lex.parse();

		for(TextParser.LexEntry ent  :lex.chunks){
			SpannableString s1 = new SpannableString(ent.text);
//			Log.d(TAG,ent.text + "-" + ent.type);
			switch (ent.type){
				case SimpleText:

					break;

				case UserName:
					s1.setSpan(buildclick(s1),0,s1.length(), Spanned.SPAN_MARK_MARK);
					s1.setSpan(new StyleSpan(Typeface.BOLD),0,s1.length(), Spanned.SPAN_MARK_MARK);
					break;

				case Tag:
					s1.setSpan(buildclickTag(s1),0,s1.length(),Spanned.SPAN_MARK_MARK);
					s1.setSpan(new StyleSpan(Typeface.BOLD),0,s1.length(), Spanned.SPAN_MARK_MARK);
					break;
			}
			builder.append(s1);
		}

		textView.setMovementMethod(LinkMovementMethod.getInstance());
//        setText(builder);
		return builder;

	}
}
