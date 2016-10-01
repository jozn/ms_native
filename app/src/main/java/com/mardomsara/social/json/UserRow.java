package com.mardomsara.social.json;

import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.tables.UsersTable;

/**
 * Created by Hamid on 4/4/2016.
 * @deprecated switvh to UserSyncJson
 */
public class UserRow {
    public Integer Id;
    public String UserName;
    public String FullName;
    public String FirstName;
    public String LastName;
    public String AvatarSrc;
    public String AvatarUrl;
//    public Integer IsProfilePrivate;
//    public Boolean AmIFollowing;
    public Integer IFollowType;//dep
    public Object FollowingLists;
    public Integer FollowingType;

    //just for contacts
    public String Phone;
    public Integer UpdatedTime;
    public Integer UpdatedTimestamp;
    public Integer UpdatedTimestampMs;

    public Integer FollowersCount;
    public Integer FollowingCount;
    public Integer PostsCount;

    @Deprecated
    public void setUserTableParams(UsersTable user){
        user.setUserId(Id);
//            c.setId(user.Id);// the same of setUserId() -- SquidDb limitions
        user.setIsFollowing(FollowingType);//
        user.setFollowingType(FollowingType);//
        user.setFirstName(FirstName);
        user.setLastName(LastName);
//        user.setFullName(user.FullName);
        user.setUserName(UserName);
        user.setAvatarUrl(AvatarUrl);
        user.setUpdateTimestamp(UpdatedTimestamp);
    }

    public void setUserTableParams(User user){
        user.UserId = (Id);
//            c.setId(user.Id);// the same of setUserId() -- SquidDb limitions
        user.IsFollowing = (FollowingType);//
        user.FollowingType = (FollowingType);//
        user.FirstName = (FirstName);
        user.LastName = (LastName);
//        user.setFullName(user.FullName);
        user.UserName = (UserName);
        user.AvatarUrl = (AvatarUrl);
        user.UpdatedTime = UpdatedTime;
    }

}
