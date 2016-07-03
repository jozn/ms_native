package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.models.IUserAndMe;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 6/27/2016.
 */
public class followingButton extends TextView {
    String icon_isFollowing = "\uf47d";//"\uf213";//ion-person
//    String icon_isFollowing = "\uf213";//ion-person
    String icon_notFollowing = "\uf47f" ;//"\uf211";//ion-person-add
    String icon_isPravate = "\uf200";//ion-locked
    String icon_isWaiting = "\uf403";//ion-ios-clock

    int background_isFollowing = R.drawable.follow_btn_following;
    int background_notFollowing = R.drawable.follow_btn_not_following;
    int background_isPravate = R.drawable.follow_btn_following;
    int background_isWaiting = R.drawable.follow_btn_waiteing;

    int coloer_isFollowing =AndroidUtil.getColor(R.color.white);
    int coloer_notFollowing =AndroidUtil.getColor(R.color.following_blue);
    int coloer_inactive =AndroidUtil.getColor(R.color.following_inactive);

    IUserAndMe userAndMe = null;

    //todo complete http actions
    OnClickListener switchFollowing = (v)->{
        if(userAndMe == null) return;
        int type =userAndMe.getFollowingType();
        if(type == 0){//not foolowing
            if(userAndMe.getIsProfilePrivate() == 1){

            }

        }else if(type == 1){//following - unfollow

        }else if(type == 2){//requested following

        }
    };

    public followingButton(Context context) {
        super(context);
        init();
    }

    public followingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public followingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        setOnClickListener(switchFollowing);
    }

    private void init() {
        setMinimumWidth(AndroidUtil.dpToPx(80));
//        setMinimumWidth(AndroidUtil.dpToPx(80));
        setLayoutParams(new ViewGroup.LayoutParams(AndroidUtil.dpToPx(150),AndroidUtil.dpToPx(20)));
        uiNotFollowing();
//        uiIsFollowing();
        setTypeface(FontCache.getIonic());
        setGravity(Gravity.CENTER);

        setTextSize(AndroidUtil.dpToPx(12));
    }

    //deprecate
    public void setUser(IUserAndMe user){
        userAndMe = user;
        updateUi();
    }

    void updateUi(){
        if(userAndMe == null) return;
        switch (userAndMe.getFollowingType()){
            case 0:
                uiNotFollowing();
                break;
            case 1:
                uiIsFollowing();
                break;
            case 2:
                uiWaiting();
                break;
        }
    }

    void uiIsFollowing(){
        setText(icon_isFollowing);
        setTextColor(coloer_isFollowing);
        setBackgroundResource(background_isFollowing);
    }

    void uiNotFollowing(){
        setText(icon_notFollowing);
        setTextColor(coloer_notFollowing);
        setBackgroundResource(background_notFollowing);
    }

    void uiWaiting(){
        setText(icon_isWaiting);
        setTextColor(0xffffff);
        setBackgroundResource(background_isWaiting);
    }

//    public void setForUser(int userId, int followingType){
//        userAndMe = null;
//
//    }
}
