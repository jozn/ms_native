package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.EmojiKeyboard;

/**
 * Created by Hamid on 7/27/2016.
 */
public class SimpleAddText extends FrameLayout {
	public X.InputTextAddSimpleText x;
    public SimpleAddText(Context context) {
        super(context);
        init();
    }

    public SimpleAddText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleAddText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    OnAddText onAddListener;

    EmojiKeyboard emojiKeybord;
    private void init() {

		x= new X.InputTextAddSimpleText();
        addView(x.root);
        emojiKeybord= new EmojiKeyboard(x.input ,x.emoji_opener_btn, AppUtil.global_window);

        x.send_btn.setOnClickListener((e)->{
            if(onAddListener != null){
                onAddListener.onAddText(x.input.getText().toString());
                x.input.setText("");
            }
        });

    }

    public void setOnAddListener(OnAddText onAddListener) {
        this.onAddListener = onAddListener;
    }


    public interface OnAddText{
        void onAddText(String text);
    }

}
