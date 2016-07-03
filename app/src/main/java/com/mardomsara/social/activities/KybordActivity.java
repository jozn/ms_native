package com.mardomsara.social.activities;


import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconGridFragment;
import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.emojicon.EmojiconsFragment;
import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.social.R;


public class KybordActivity extends FragmentActivity {//implements EmojiconsFragment.OnEmojiconBackspaceClickedListener , EmojiconGridFragment.OnEmojiconClickedListener {

    int orginalHeight;
    int orginalWidth;

    EmojiconEditText edit ;
    EmojiconTextView txt ;
    ImageView btn ;
    FrameLayout keybord1;
    View parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kybord);

        edit = (EmojiconEditText)findViewById(R.id.txt);
        txt = (EmojiconTextView)findViewById(R.id.txt1);
        btn = (ImageView)findViewById(R.id.emoji);
        keybord1 = (FrameLayout)findViewById(R.id.keybord1);
        parent = (View)findViewById(R.id.parent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int w2 = orginalHeight - parent.getRootView().getMeasuredHeight();
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(orginalWidth,Math.abs(w2));
                keybord1.setLayoutParams(lp );
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.keybord1, EmojiconsFragment.newInstance(false))
                        .commit();
                updateSize();
            }
        });


        updateSize();

        parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int heightDiff = parent.getRootView().getHeight() - parent.getHeight();
                edit.setText(""+ heightDiff);
                // IF height diff is more then 150, consider keyboard as visible.
            }
        });

        TextView log = (TextView) findViewById(R.id.log1);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.keybord1, EmojiconsFragment.newInstance(false))
//                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateSize();
        orginalHeight= parent.getRootView().getMeasuredHeight();

    }

//    @Override
//    public void onEmojiconBackspaceClicked(View v) {
//
//    }
//
//    @Override
//    public void onEmojiconClicked(Emojicon emojicon){
//        edit.setText(edit.getText() + emojicon.getEmoji());
//        txt.setText(txt.getText()+emojicon.getEmoji());
//    }

    void updateSize(){
        Display display = getWindowManager().getDefaultDisplay();
        int w = parent.getMeasuredWidth();
        int h = parent.getMeasuredHeight();
        int h2 = parent.getRootView().getMeasuredHeight();
        Point size = new Point();
        display.getSize(size);

        int width = size.x;
        int height = size.y;

        orginalHeight = h;
        orginalWidth = width;

        txt.setText("w: "+width+" h: "+ height + " w2:" +w + " h2: "+ h + " h-root: "+ h2);
    }

}
