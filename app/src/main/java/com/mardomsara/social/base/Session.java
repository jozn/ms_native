package com.mardomsara.social.base;

import android.os.Build;

import com.mardomsara.social.helpers.AndroidUtil;

/**
 * Created by Hamid on 5/14/2016.
 */
public class Session {

    public static int getUserId(){
        if(AndroidUtil.getAndroidSdkVersion() >= Build.VERSION_CODES.LOLLIPOP){
            return 6;
        }else{
            return 2;
        }
    }
}
