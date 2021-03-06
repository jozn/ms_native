package com.mardomsara.social.json.social.rows;

import android.support.annotation.Nullable;

import com.mardomsara.social.models_old.interfaces.IUserAndMe;

/**
 * Created by Hamid on 7/13/2016.
 */
public class UserInfoJson implements IUserAndMe {
    public int Id;

    @Deprecated
    public int UserId;
    public @Nullable String FirstName;
    public @Nullable String LastName;
    public @Nullable String FullName;
    public String UserName;
    public String AvatarUrl;

    public String About = "";

	//with me
    public int FollowingType = 0;
    public int PrivacyProfile = 0;


    public String getFullName() {
        return ( FullName == null || FullName.equals("") ) ? FirstName + " " + LastName : FullName;
    }

//    public int getUserId() {
//        return Id;
//    }

    ///////////// Extra methods //////////////////////
    @Override
    public int getFollowingType() {
        return FollowingType;
    }

    @Override
    public void setFollowingType(int type) {
        FollowingType = type;
    }

    @Override
    public int getIsProfilePrivate() {
        return 0;
    }

    @Override
    public void setIsProfilePrivate(int type) {

    }

	public int getUserId(){
		if(Id < 0){
			return UserId;
		}
		return Id;
	}
}
//UserId: 6,
//        UserName: "Edris",
//        FullName: "Edris اعتماد",
//        AvatarUrl: "public/avatars/105.jpg"