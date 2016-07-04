package com.mardomsara.social.ui.views;

import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconGridFragment;
import com.mardomsara.emojicon.EmojiconsFragment;
import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.social.Nav;
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
public class EmojiKeybord2 implements EmojiconsFragment.OnEmojiconBackspaceClickedListener, EmojiconGridFragment.OnEmojiconClickedListener {
    View windowHolder;

//    TextView emojiOpenerBtn;
    ImageButton emojiOpenerBtn;
//    EditText editInput;
    List<String> strInput = new ArrayList<>();

    //icon
    int emojiIcon = R.drawable.input_emoji;
    int keyboardIcon = R.drawable.input_keyboard;
    //states
    boolean isEmojiOpen = false;
    boolean isKeybordOpen = false;

    Nav.OnBackPressHandler backPressHandler =()->{
        if(isEmojiOpen){
            closeEmojiWindow();
            return true;
        }
        return false;
    };

    public EmojiKeybord2(View windowHolderFrameLayout, FragmentManager childFragmentManager) {

        windowHolder = windowHolderFrameLayout;
        childFM = childFragmentManager;

        Nav.addCustomOnBackPressHandler(backPressHandler);

    }

    //////////////////////////////////////////////////////
    View iconText;
    EmojiconEditText editInput;
    FragmentManager childFM;//childFragmentManager
    boolean useSystemDefault = false;
    EmojiconsFragment emoji_window;
    PopupWindow attachWindow;
    public View emoji_window_holder;

    public EmojiKeybord2(View iconTexx, EmojiconEditText editInput ,FragmentManager childFragmentManager) {
        this.iconText = iconTexx;
        this.editInput = editInput;
        childFM = childFragmentManager;
    }
    public void build(){
        emoji_window = EmojiconsFragment.newInstance(useSystemDefault);
        emoji_window.setEmojiBackListener(this);
        emoji_window.setmOnEmojiconClickedListener(this);

        ViewGroup popupView = (ViewGroup) AppUtil.inflate(R.layout.keywoard_emoji);


        emoji_window.onCreateView(LayoutInflater.from(AppUtil.getContext()),popupView,null);

        attachWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                700);//kybordSize);

        popupView.addView(emoji_window.getView());

//        popupView.findViewById(R.id.emoji_window_holder2);

//        childFM.beginTransaction()
//                .add(R.id.emoji_window_holder2, emoji_window)
//                .commit();

   /*     childFM.beginTransaction()
                .add(R.id.emoji_window_holder, emoji_window)
                .commit();*/



        /*emojiOpenerBtn.setOnClickListener((v)-> {
            AppUtil.log("emojiOpenerBtn.setOnClickListener "+ v.toString());
            emojiBtnClicked();
        });*/
        iconText.setOnClickListener((v)-> {
            AppUtil.log("emojiOpenerBtn.setOnClickListener "+ v.toString());
            emojiBtnClicked();
        });

        editInput.setOnClickListener((v)-> {
            AppUtil.log("editInput.setOnClickListener "+ v.toString());
            inputClicked();
        });


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
                attachWindow.showAtLocation(AppUtil.global_window, Gravity.END,0,150);
//                openEmojiSchedule();
            }else { //switch from open keywoard to emoji keyboard
//                openEmojiSchedule();
                attachWindow.dismiss();
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
//            emojiOpenerBtn.setImageResource(keyboardIcon);
        },1);
    }

    protected void openEmojiSchedule() {
        closeKeyboard();
        AndroidUtil.runInUiWithSleep(()->{
            openEmoji();
//            emojiOpenerBtn.setImageResource(emojiIcon);
        },1);
    }

    protected void openEmoji(){
        AppUtil.log("openEmoji()");
        isEmojiOpen = true;
        attachWindow.showAtLocation(emoji_window_holder, Gravity.END,0,15000);

        /*windowHolder.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                Hawk.get(Config.KEYBOARD_HEIGHT, Config.KEYBOARD_HEIGHT_DEFAULT)));*/

    }
    protected void closeEmoji(){
        AppUtil.log("closeEmoji()");
        attachWindow.dismiss();
/*        isEmojiOpen = false;
//        windowHolder.setVisibility(View.INVISIBLE);
        windowHolder.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        );*/
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
