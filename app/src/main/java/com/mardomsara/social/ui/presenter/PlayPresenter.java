package com.mardomsara.social.ui.presenter;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconsPopup;
import com.mardomsara.emojicon.OnEmojiconBackspaceClickedListener;
import com.mardomsara.emojicon.EmojiconsPopup.OnSoftKeyboardOpenCloseListener;
import com.mardomsara.emojicon.OnEmojiconClickedListener;
import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.BasePresenter;

//import ;

/**
 * Created by Hamid on 5/2/2016.
 */
public class PlayPresenter extends BasePresenter {
    Integer count = 0;
    @Override
    public View buildView() {
       ViewGroup v = (ViewGroup)inflater.inflate(R.layout.presenter_sample,null);

//        setContentView(R.layout.activity_main_app);
        ListView lv = (ListView) v.findViewById(R.id.lv);
        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getContext(), R.layout.presenter_sample_list);
        lv.setAdapter(mAdapter);
        final EmojiconEditText emojiconEditText = (EmojiconEditText) v.findViewById(R.id.emojicon_edit_text);
        final View rootView = v.findViewById(R.id.root_view);
        final ImageView emojiButton = (ImageView) v.findViewById(R.id.emoji_btn);
        final ImageView submitButton = (ImageView) v.findViewById(R.id.submit_btn);

        // Give the topmost view of your activity layout hierarchy. This will be used to measure soft keyboard height
        final EmojiconsPopup popup = new EmojiconsPopup(rootView, getContext());

        //Will automatically set size according to the soft keyboard size
//        popup.setSizeForSoftKeyboard_dep();

        //If the emoji popup is dismissed, change emojiButton to smiley icon
        popup.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                changeEmojiKeyboardIcon(emojiButton, R.drawable.emoji_1f1e6_1f1ee);
            }
        });

        //If the text keyboard closes, also dismiss the emoji popup
        popup.setOnSoftKeyboardOpenCloseListener(new OnSoftKeyboardOpenCloseListener() {

            @Override
            public void onKeyboardOpen(int keyBoardHeight) {

            }

            @Override
            public void onKeyboardClose() {
                if(popup.isShowing())
                    popup.dismiss();
            }
        });

        //On emoji clicked, add it to edittext
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
        emojiButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //If popup is not showing => emoji keyboard is not visible, we need to show it
                if(!popup.isShowing()){

                    //If keyboard is visible, simply show the emoji popup
                    if(popup.isKeyBoardOpen()){
                        popup.showAtBottom();
                        changeEmojiKeyboardIcon(emojiButton, R.drawable.emoji_1f1e8_1f1e6);
                    }

                    //else, open the text keyboard first and immediately after that show the emoji popup
                    else{
                        emojiconEditText.setFocusableInTouchMode(true);
                        emojiconEditText.requestFocus();
                        popup.showAtBottomPending();
                        final InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.showSoftInput(emojiconEditText, InputMethodManager.SHOW_IMPLICIT);
                        changeEmojiKeyboardIcon(emojiButton, R.drawable.e_1f1e8_1f1f1);
                    }
                }

                //If popup is showing, simply dismiss it to show the undelying text keyboard
                else{
                    popup.dismiss();
                }
            }
        });

        //On submit, add the edittext text to listview and clear the edittext
        submitButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String newText = emojiconEditText.getText().toString();
                emojiconEditText.getText().clear();
                mAdapter.add(newText);
                mAdapter.notifyDataSetChanged();

            }
        });
        return v;
    }

    private void changeEmojiKeyboardIcon(ImageView iconToBeChanged, int drawableResourceId){
        iconToBeChanged.setImageResource(drawableResourceId);
    }

}
