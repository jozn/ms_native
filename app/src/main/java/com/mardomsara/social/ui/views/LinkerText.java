package com.mardomsara.social.ui.views;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hamid on 2/4/2016.
 */
public class LinkerText extends TextView {
    String TAG ="LinkerText";
    public LinkerText(Context context) {
        super(context);
        init();
    }

    public LinkerText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinkerText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

//    @Override
    public  void setText2(CharSequence text) {
//        setText(text, mBufferType);
        super.setText(text);
        init2(text);
    }

    void init(){
        CharSequence txt = getText();
        init2(txt);
    }

    void init2(CharSequence txt){
        SpannableStringBuilder builder = new SpannableStringBuilder();
        TextParser.Lexing lex=  new TextParser.Lexing(txt.toString());
        lex.parse();

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "dolor", Toast.LENGTH_LONG).show();
            }
        };

        for(TextParser.LexEntry ent  :lex.chunks){
            SpannableString s1 = new SpannableString(ent.text);
            Log.d(TAG,ent.text + "-" + ent.type);
            switch (ent.type){
                case SimpleText:

                    break;

                case UserName:
                    s1.setSpan(buildclick(s1),0,s1.length(), Spanned.SPAN_MARK_MARK);
                    break;

                case Tag:
                    s1.setSpan(buildclick(s1),0,s1.length(),Spanned.SPAN_MARK_MARK);
                    break;
            }
            builder.append(s1);
        }

        setMovementMethod(LinkMovementMethod.getInstance());
        setText(builder);

    }

    ClickableSpan buildclick(final CharSequence s){

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
            }
        };
        return clickableSpan;
    }
}
