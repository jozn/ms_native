package com.mardomsara.social.ui.views;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.mardomsara.emojicon.EmojiconGridFragment;
import com.mardomsara.emojicon.EmojiconsFragment;
import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 5/15/2016.
 */
public class EmojiKeybord implements EmojiconsFragment.OnEmojiconBackspaceClickedListener, EmojiconGridFragment.OnEmojiconClickedListener {
    View windowHolder;
    FragmentManager childFM;//childFragmentManager
    boolean useSystemDefault = false;
    EmojiconsFragment emoji_window;
//    TextView emojiOpenerBtn;
    ImageButton emojiOpenerBtn;
    EditText editInput;
    List<String> strInput = new ArrayList<>();

    //icon
    int emojiIcon = R.drawable.input_emoji;
    int keyboardIcon = R.drawable.input_keyboard;
    //states
    boolean isEmojiOpen = false;
    boolean isKeybordOpen = false;

    public EmojiKeybord(View windowHolderFrameLayout, FragmentManager childFragmentManager) {

        windowHolder = windowHolderFrameLayout;
        childFM = childFragmentManager;

    }

    public void build(){
        emoji_window = EmojiconsFragment.newInstance(useSystemDefault);
        emoji_window.setEmojiBackListener(this);
        emoji_window.setmOnEmojiconClickedListener(this);
        childFM.beginTransaction()
                .add(R.id.emoji_window_holder, emoji_window)
                .commit();

        emojiOpenerBtn.setOnClickListener((v)-> {
            AppUtil.log("emojiOpenerBtn.setOnClickListener "+ v.toString());
            emojiBtnClicked();
        });

        editInput.setOnClickListener((v)-> {
            AppUtil.log("editInput.setOnClickListener "+ v.toString());
            inputClicked();
        });


        }

    public void setEmojiOpenerBtn(ImageButton emojiOpenerBtn) {
        this.emojiOpenerBtn = emojiOpenerBtn;
//        emojiOpenerBtn.setOnClickListener((e)->{
//            if(isOpen ==false){
//                AndroidUtil.showKeyboard();
//            }
//        });
    }

    public void setEditInput(EditText editInput) {
        this.editInput = editInput;
//        editInput.setInputType(InputType.TYPE_NULL);
        editInput.setTextIsSelectable(true);
    }

    @Override
    public void onEmojiconBackspaceClicked(View v) {
        String txt = editInput.getText().toString();
        if(txt.length() >= 2){
            txt =txt.substring(0, txt.length()-1);//.substring(): not including upper limit
            editInput.setText(txt);
        }
    }

    protected void emojiBtnClicked(){
        if(isEmojiOpen == false){
            if(isKeybordOpen == false){//thi is minimized
                openEmojiSchedule();
//                closeKeyboard();//
//                openEmoji();
            }else { //switch from open keywoard to emoji keyboard
                openEmojiSchedule();
//                closeKeyboard();
//                openEmoji();
            }
        }else {//open keyborad
            openKeyboardchedule();
        }
    }

    protected void inputClicked(){
        if(isKeybordOpen == false){
            if(isEmojiOpen == false){//thi is minimized
                openKeyboardchedule();
//                closeEmoji();
//                openKeyboard();
            }
        }else {// keyborad is open
            //bug work around
            if(isEmojiOpen == false){//there is a bug when keyboard is open and user clicks
                                // back btn, in this case this class states hash not change
                                // this code is a work around that bug
                openKeyboardchedule();
//                closeEmoji();
//                openKeyboard();
            }
        }
    }

    protected void openKeyboardchedule() {
        closeEmoji();
        AndroidUtil.runInUiWithSleep(()->{
            openKeyboard();
            emojiOpenerBtn.setImageResource(keyboardIcon);
        },1);
    }

    protected void openEmojiSchedule() {
        closeKeyboard();
        AndroidUtil.runInUiWithSleep(()->{
            openEmoji();
            emojiOpenerBtn.setImageResource(emojiIcon);
        },1);
    }

    protected void openEmoji(){
        AppUtil.log("openEmoji()");
        isEmojiOpen = true;
        windowHolder.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                Hawk.get(Config.KEYBOARD_HEIGHT, Config.KEYBOARD_HEIGHT_DEFAULT)));

    }
    protected void closeEmoji(){
        AppUtil.log("closeEmoji()");
        isEmojiOpen = false;
//        windowHolder.setVisibility(View.INVISIBLE);
        windowHolder.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        );
    }
    protected void openKeyboard(){
        AppUtil.log("openKeyboard()");
        isKeybordOpen  = true;
        AndroidUtil.showKeyboard(editInput);
    }

    protected void closeKeyboard(){
        AppUtil.log("closeKeyboard()");
        isKeybordOpen = false;
        AndroidUtil.hideKeyboard(editInput);
    }

    public boolean isEmojiWindowOpen(){
        return isEmojiOpen;
    }

    public void closeEmojiWindow(){
        closeEmoji();
    }

    @Override
    public void onEmojiconClicked(Emojicon emojicon) {
//        strInput.add(emojicon.getEmoji());
//         editInput.setText(inputToStr());

        String txt = editInput.getText().toString();
        txt =txt+ emojicon.getEmoji();
        editInput.setText(txt);
    }

    private String inputToStr(){
        StringBuffer sb = new StringBuffer("");
        for (String str : strInput){
            sb.append(str);
        }
        return sb.toString();
    }
}
