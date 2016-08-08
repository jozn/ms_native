package com.mardomsara.social.ui.views;

import android.content.Context;
import android.util.AttributeSet;

import com.mardomsara.emojicon.EmojiconTextView;

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

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(LinkerText.linkerText(text,this),type);
    }
}
