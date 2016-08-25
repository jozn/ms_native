package com.mardomsara.social.json.social.rows;

/**
 * Created by Hamid on 7/30/2016.
 */
public class UserTableJson extends UserInfoJson {

    /*public int Id;
    public String UserName;
    public String FirstName;
    public String LastName;
    public String FullName;
    public String AvatarUrl;
    public String About;*/

    public String Phone;
    public int IsDeleted;

    public int FollowersCount;
    public int FollowingCount;
    public int PostsCount;
    public int MediaCount;
    public int LikesCount;
    public int ResharedCount;
    public int CommentsCount;

    public String SessionUuid;
    public String DeviceUuid;
    public int AppVersion;
    public int LastLoginTime;
    public int LastActivityTime;
    public String LastIpAddress;
    public String LastWifiMacAddress;
    public String LastNetworkType;
    public int UpdatedTime;
    public int LastPostTime;
    public int LastActionTime;

    public String getFullName(){
        return FirstName+ " "+ LastName;
    }

}
