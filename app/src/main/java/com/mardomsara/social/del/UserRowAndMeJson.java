package com.mardomsara.social.del;

import com.mardomsara.social.models.interfaces.IUserAndMe;

/**
 * Created by Hamid on 7/18/2016.
 * @deprecated  use UserInfoJson
 */
public class UserRowAndMeJson implements IUserAndMe {
    public int UserId;
    public String UserName;
    public String FullName;
    public String AvatarUrl;
    public int IFollowType;

    @Override
    public int getFollowingType() {
        return IFollowType;
    }

    @Override
    public void setFollowingType(int type) {
        IFollowType = type;
    }

    @Override
    public int getIsProfilePrivate() {
        return 0;
    }

    @Override
    public void setIsProfilePrivate(int type) {

    }
}
