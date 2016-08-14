package com.mardomsara.social.models;

import android.os.Build;

import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.ServerUserTableJson;
import com.mardomsara.social.json.social.UserSenderJson;
import com.mardomsara.social.json.social.server.ServerUserTable;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Hamid on 7/30/2016.
 */
public class Session {
    private static ServerUserTable userInfo = null;

    static {
        getUserInfo();
    }

    public static void fetchUserInfoFromServer(){
        AndroidUtil.runInBackgroundNoPanic(()->{
            Http.Req req = new Http.Req();
            req.absPath = API.SESSION_INFO.toString();
            Http.Result res = Http.masterSendPost(req);
            boolean isError = false;
            if(res.ok){
                ServerUserTableJson data = JsonUtil.fromJson(res.data,ServerUserTableJson.class);
                if(data != null && data.Status.equalsIgnoreCase("OK")){
                    Hawk.put(Constants.SessionUserInfo,data.Payload);
                    userInfo = data.Payload;
                }else {
                    isError = true;
                }
            }
        });
    }

    public static int getUserId(){
        if(userInfo!=null){
            return userInfo.Id;
        }
        //// TODO: 7/30/2016 Delete this
        //falback for new installed
        if(AndroidUtil.getAndroidSdkVersion() >= Build.VERSION_CODES.LOLLIPOP){
            return 6;
        }else{
            return 2;
        }
    }

    public static ServerUserTable getUserInfo(){
        if(userInfo!= null){
            return userInfo;
        }
        ServerUserTable u = Hawk.get(Constants.SessionUserInfo);
        userInfo = u;
        return u;
    }

    public static UserSenderJson buildUserSender(){
        if(userInfo== null){
            return null;
        }
        UserSenderJson sender = new UserSenderJson();
        sender.UserId = userInfo.Id;
        sender.FullName = userInfo.getFullName();
        sender.AvatarUrl = userInfo.AvatarUrl;
        sender.UserName = userInfo.UserName;

        return sender;
    }

}
