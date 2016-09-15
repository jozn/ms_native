package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.views.EmojiKeyboard3;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/27/2016.
 */
public class SimpleAddText extends FrameLayout {
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

    @Bind(R.id.emoji_opener_btn)
    TextView emoji_opener_btn;

    @Bind(R.id.input)
    EmojiconEditText input;

    @Bind(R.id.send_btn)
    Button send_btn;


    OnAddText onAddListener;

    EmojiKeyboard3 emojiKeybord;
    private void init() {
        View view = AppUtil.inflate(R.layout.widget_add_simple_text);
        ButterKnife.bind(this,view);
        addView(view);
        emojiKeybord= new EmojiKeyboard3(input ,emoji_opener_btn, AppUtil.global_window);

        send_btn.setOnClickListener((e)->{
            if(onAddListener != null){
                onAddListener.onAddText(input.getText().toString());
                input.setText("");
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
