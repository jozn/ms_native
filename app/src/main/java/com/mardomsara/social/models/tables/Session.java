package com.mardomsara.social.models.tables;

import android.os.Build;

import com.mardomsara.social.app.Config;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.models.stores.Store;
import com.mardomsara.social.models.stores.StoreConstants;

/**
 * Created by Hamid on 7/30/2016.
 */
public class Session {
    private static JV.UserMeView userInfo = null;

    static {
        loadUserInfo();
    }

	public static void fetchUserInfoFromServer(){
		AndroidUtil.runInBackgroundNoPanic(()->{
			Http.postPath("/v1/session/info")
				.doAsync(result -> {
					if(result.isOk()){
						HttpJson<JV.UserMeView> data = Result.fromJson(result,JV.UserMeView.class);
						if(data.Status.equalsIgnoreCase("OK") && data.isPayloadNoneEmpty()){
							Store.putString(StoreConstants.SessionUserInfo,JsonUtil.toJson(data.Payload));
							userInfo = data.Payload;
						}
					}
				});
		});
	}

    public static int getUserId(){
		loadUserInfo();

		if(userInfo!=null){
            return userInfo.Id;
        }

        //// TODO: 7/30/2016 Delete this
        //falback for new installed
		if(Config.IS_DEBUG&&true){
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

    public static JV.UserMeView loadUserInfo(){
        if(userInfo!= null){
            return userInfo;
        }
		String data = Store.getString(StoreConstants.SessionUserInfo);
		if(data != null && !data.equals("")){
			JV.UserMeView json = JsonUtil.fromJson(data,JV.UserMeView.class);
			if(json!=null){
				userInfo = json;
			}
		}
        return userInfo;
    }


	public static JV.UserInlineView buildUserSenderJV(){
		if(userInfo== null){
			return null;
		}
		JV.UserInlineView sender = new JV.UserInlineView();
		sender.UserId = userInfo.Id;
		sender.FullName = userInfo.FullName;
		sender.AvatarUrl = userInfo.AvatarUrl;
		sender.UserName = userInfo.UserName;

		return sender;
	}

}
