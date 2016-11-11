package com.mardomsara.social.models;

import android.os.Build;

import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.ServerUserTableJson;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.json.social.rows.UserTableJson;
import com.mardomsara.social.models.stores.Store;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Hamid on 7/30/2016.
 */
public class Session {
    private static UserTableJson userInfo = null;

    static {
        getUserInfo();
    }

    public static void fetchUserInfoFromServer(){
        AndroidUtil.runInBackgroundNoPanic(()->{
            HttpOld.Req req = new HttpOld.Req();
            req.absPath = API.SESSION_INFO.toString();
            HttpOld.Result res = HttpOld.masterSendPost(req);
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
		if(Config.IS_DEBUG){
			if(AndroidUtil.getAndroidSdkVersion() >= Build.VERSION_CODES.LOLLIPOP){
				return 6;
			}else{
				return 2;
			}
		}
		return 0;
    }

	public static boolean isUserIdMe(int peerId){
		if(getUserId() == peerId)return true;
		return false;
	}

    public static UserTableJson getUserInfo(){
        if(userInfo!= null){
            return userInfo;
        }
        UserTableJson u = Hawk.get(Constants.SessionUserInfo);
        userInfo = u;
        return u;
    }

    public static UserInfoJson buildUserSender(){
        if(userInfo== null){
            return null;
        }
        UserInfoJson sender = new UserInfoJson();
        sender.UserId = userInfo.Id;
        sender.FullName = userInfo.getFullName();
        sender.AvatarUrl = userInfo.AvatarUrl;
        sender.UserName = userInfo.UserName;

        return sender;
    }

    static void play(){
        Store.getFloat("dd");
    }

}
