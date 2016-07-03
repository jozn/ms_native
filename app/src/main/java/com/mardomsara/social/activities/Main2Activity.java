package com.mardomsara.social.activities;

/**
 * Created by Hamid on 5/7/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.emojicon.EmojiconsFragment;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.TextParser;
import com.mardomsara.social.ui.views.TextWatcherAdapter;


public class Main2Activity extends FragmentActivity{//} implements EmojiconGridFragment.OnEmojiconClickedListener, EmojiconsFragment.OnEmojiconBackspaceClickedListener {
    EmojiconEditText mEditEmojicon;
    EmojiconTextView mTxtEmojicon;
    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_emoij_2);

        ///////////////////////////
        TextView richTextView = (TextView)findViewById(R.id.rich_text);
        TextView go2 = (TextView)findViewById(R.id.go2);
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),KybordActivity.class);
                startActivity(i);
            }
        });

        // this is the text we'll be operating on
        SpannableString text = new SpannableString("Lorem ipsum dolor sit amet");

        // make "Lorem" (characters 0 to 5) red
        text.setSpan(new ForegroundColorSpan(Color.RED), 0, 5, 0);

        // make "ipsum" (characters 6 to 11) one and a half time bigger than the textbox
        text.setSpan(new RelativeSizeSpan(1.5f), 6, 11, 0);

        // make "dolor" (characters 12 to 17) display a toast message when touched
        final Context context = this;
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "dolor", Toast.LENGTH_LONG).show();
            }
        };
        text.setSpan(clickableSpan, 12, 17, 0);

        // make "sit" (characters 18 to 21) struck through
        text.setSpan(new StrikethroughSpan(), 18, 21, 0);

        // make "amet" (characters 22 to 26) twice as big, green and a link to this site.
        // it's important to set the color after the URLSpan or the standard
        // link color will override it.
        text.setSpan(new RelativeSizeSpan(2f), 22, 26, 0);
        text.setSpan(new URLSpan("http://www.chrisumbel.com"), 22, 26, 0);
        text.setSpan(new ForegroundColorSpan(Color.GREEN), 22, 26, 0);

        // make our ClickableSpans and URLSpans work
        richTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // shove our styled text into the TextView
        richTextView.setText(text, TextView.BufferType.SPANNABLE);

        String str = "@kjnk #iuiiu ijiiiii ijwiu      #   # ! @ #$ sjki";
        new TextParser();
        TextParser.Lexing ps = new TextParser.Lexing(str);
        ps.parse();
        for (TextParser.LexEntry l : ps.chunks){
            Log.d("lex", l.text + "-" +l.type);
        }
        Log.d("lex", "dasdasdasd");

        /////

        SpannableStringBuilder sb = new SpannableStringBuilder();
        final SpannableString  s1 = new SpannableString("#himmmmmmmmmmmmm");
        final Context that = this;
        final ClickableSpan  cs = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(that, "ssss",Toast.LENGTH_LONG).show();
                Log.d("text","YYYY "+ widget.toString());
                TextPaint tp = new TextPaint();
                tp.bgColor = 0xeeeeee;
                // cs.updateDrawState(tp);
            }
        };

        s1.setSpan(cs, 0, s1.length(), Spanned.SPAN_MARK_MARK);
//        s1.setSpan(new UnderlineSpan(),0,s1.length(),0);
        sb.append(s1);
        TextView txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setMovementMethod(LinkMovementMethod.getInstance());

        txt2.setText(sb);


        ////////////////////////////////
        mEditEmojicon = (EmojiconEditText) findViewById(R.id.editEmojicon);
        mTxtEmojicon = (EmojiconTextView) findViewById(R.id.txtEmojicon);
        mEditEmojicon.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTxtEmojicon.setText(s);
            }
        });
        mCheckBox = (CheckBox) findViewById(R.id.use_system_default);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mEditEmojicon.setUseSystemDefault(b);
                mTxtEmojicon.setUseSystemDefault(b);
                setEmojiconFragment(b);
            }
        });

        setEmojiconFragment(false);
    }

    private void setEmojiconFragment(boolean useSystemDefault) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.emojicons, EmojiconsFragment.newInstance(useSystemDefault))
                .commit();
    }

//    @Override
//    public void onEmojiconClicked(Emojicon emojicon) {
//        EmojiconsFragment.input(mEditEmojicon, emojicon);
//    }
//
//    @Override
//    public void onEmojiconBackspaceClicked(View v) {
//        EmojiconsFragment.backspace(mEditEmojicon);
//    }


}

