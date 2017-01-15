package com.mardomsara.social.ui.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mardomsara.social.Nav;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.AppClickableSpan;
import com.mardomsara.social.ui.presenter.pages.TagsPage;

/**
 * Created by Hamid on 2/4/2016.
 */
public class LinkerTextView extends TextView {
    static String TAG ="LinkerText";
    public LinkerTextView(Context context) {
        super(context);
        init();
    }

    public LinkerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinkerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    int i = 0;
    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(linkerText(text,this),type);
    }


    void init(){
        CharSequence txt = getText();
//        linkerText(txt);
    }

    ///////////////////////////////////////////////////
    /////////// Stattics //////////////////////////

    static ClickableSpan buildclick(final CharSequence s){

        ClickableSpan clickableSpan = new AppClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AppUtil.getContext(), s, Toast.LENGTH_LONG).show();
            }
        };
        return clickableSpan;
    }

    static ClickableSpan buildclickTag(final CharSequence s){

        ClickableSpan clickableSpan = new AppClickableSpan() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AppUtil.getContext(), s, Toast.LENGTH_LONG).show();
                Nav.push(new TagsPage(s.toString()));
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
            Log.d(TAG,ent.text + "-" + ent.type);
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
