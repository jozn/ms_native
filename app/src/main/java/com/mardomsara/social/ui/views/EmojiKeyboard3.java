package com.mardomsara.social.ui.views;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconsPopup;
import com.mardomsara.emojicon.OnEmojiconBackspaceClickedListener;
import com.mardomsara.emojicon.OnEmojiconClickedListener;
import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.social.App;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

/**
 * Created by Hamid on 5/15/2016.
 */
public class EmojiKeyboard3 {
    EmojiconEditText emojiconEditText;
    View rootView ;
    ImageView emojiButton;

    TextView emojiIcon;
    ImageView submitButton;

    // Give the topmost view of your activity layout hierarchy. This will be used to measure soft keyboard height
    EmojiconsPopup popup ;

    String textIconKeyboard = "\uE837";
    String textIconFace = "\uE854";

    public EmojiKeyboard3(EmojiconEditText emojiconEditText, TextView emojiIcon, View rootView) {
        this.emojiconEditText = emojiconEditText;
        this.emojiIcon = emojiIcon;
        this.rootView = rootView;
        emojiIcon.setTypeface(FontCache.getLinear());
        emojiIcon.setTextSize(AndroidUtil.dpToPx(12));
        changeTextIcon(textIconFace);
        init();
    }

    void init(){
        popup = new EmojiconsPopup(rootView, AppUtil.getContext());
        //Will automatically set size according to the soft keyboard size
//        popup.setSizeForSoftKeyboard_dep();
//        popup.setSiz();

        //If the emoji popup is dismissed, change emojiButton to smiley icon
        popup.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
//                changeEmojiKeyboardIcon(emojiButton, R.drawable.emoji_1f1e6_1f1ee);
                changeTextIcon(textIconFace);
            }
        });

        //If the text keyboard closes, also dismiss the emoji popup
        popup.setOnSoftKeyboardOpenCloseListener(new EmojiconsPopup.OnSoftKeyboardOpenCloseListener() {

            @Override
            public void onKeyboardOpen(int keyBoardHeight) {

            }

            @Override
            public void onKeyboardClose() {
                if(popup.isShowing())
                    popup.dismiss();
            }
        });

        //On emoji clicked, addStart it to edittext
        popup.setOnEmojiconClickedListener(new OnEmojiconClickedListener() {

            @Override
            public void onEmojiconClicked(Emojicon emojicon) {
                if (emojiconEditText == null || emojicon == null) {
                    return;
                }

                int start = emojiconEditText.getSelectionStart();
                int end = emojiconEditText.getSelectionEnd();
                if (start < 0) {
                    emojiconEditText.append(emojicon.getEmoji());
                } else {
                    emojiconEditText.getText().replace(Math.min(start, end),
                            Math.max(start, end), emojicon.getEmoji(), 0,
                            emojicon.getEmoji().length());
                }
            }
        });

        //On backspace clicked, emulate the KEYCODE_DEL key event
        popup.setOnEmojiconBackspaceClickedListener(new OnEmojiconBackspaceClickedListener() {

            @Override
            public void onEmojiconBackspaceClicked(View v) {
                KeyEvent event = new KeyEvent(
                        0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
                emojiconEditText.dispatchKeyEvent(event);
            }
        });


        // To toggle between text keyboard and emoji keyboard keyboard(Popup)
        emojiIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //If popup is not showing => emoji keyboard is not visible, we need to show it
                if(!popup.isShowing()){

                    //If keyboard is visible, simply show the emoji popup
                    if(popup.isKeyBoardOpen()){
                        popup.showAtBottom();
//                        changeEmojiKeyboardIcon(emojiButton, R.drawable.emoji_1f1e8_1f1e6);
                        changeTextIcon(textIconFace);
                    }

                    //else, open the text keyboard first and immediately after that show the emoji popup
                    else{
                        emojiconEditText.setFocusableInTouchMode(true);
                        emojiconEditText.requestFocus();
                        popup.showAtBottomPending();
                        final InputMethodManager inputMethodManager = (InputMethodManager) App.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.showSoftInput(emojiconEditText, InputMethodManager.SHOW_IMPLICIT);
//                        changeEmojiKeyboardIcon(emojiButton, R.drawable.e_1f1e8_1f1f1);
//                        changeTextIcon(textIconKeyboard);
                    }
                }

                //If popup is showing, simply dismiss it to show the undelying text keyboard
                else{
                    popup.dismiss();
//                    changeTextIcon(textIconFace);
                }

                changeIcony();
            }
        });


    }
    int i =0;
    void changeIcony(){
        if(i%2 == 0){
            changeTextIcon(textIconKeyboard);
        }else{
            changeTextIcon(textIconFace);
        }
        i++;
    }
    //for avoid memory leaks
    public void destroy() {
        popup.dismiss();
        AndroidUtil.hideKeyboard(emojiconEditText);

        EmojiconsPopup.currentListner = null;
    }

    private void changeEmojiKeyboardIcon(ImageView iconToBeChanged, int drawableResourceId){
        iconToBeChanged.setImageResource(drawableResourceId);
    }

    private void changeTextIcon(String txt){
        emojiIcon.setText(txt);
    }


}