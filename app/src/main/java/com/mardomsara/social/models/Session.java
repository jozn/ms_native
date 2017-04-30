package com.mardomsara.social.models;

import android.os.Build;

import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.json.social.rows.UserTableJson;
import com.mardomsara.social.models.stores.Store;
import com.mardomsara.social.models.stores.StoreConstants;
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
			Http.postPath("/v1/session/info")
				.doAsync(result -> {
					if(result.isOk()){
						HttpJson<UserTableJson> data = Result.fromJson(result,UserTableJson.class);
						if(data.Status.equalsIgnoreCase("OK") && data.isPayloadNoneEmpty()){
							Store.putString(StoreConstants.SessionUserInfo,JsonUtil.toJson(data.Payload));
							userInfo = data.Payload;
						}
					}
				});
		});
	}

    public static int getUserId(){
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

		String data = Store.getString(StoreConstants.SessionUserInfo);
		if(data != null && !data.equals("")){
			UserTableJson json = JsonUtil.fromJson(data,UserTableJson.class);
			if(json!=null){
				userInfo = json;
				return json.Id;
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

	public static JV.UserInlineView buildUserSenderJV(){
		if(userInfo== null){
			return null;
		}
		JV.UserInlineView sender = new JV.UserInlineView();
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
