
package com.mardomsara.social.del;

import com.mardomsara.social.json.HttpBaseProtocol;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class UserListFollowJson extends HttpBaseProtocol {

    public List<UserListFollow> Payload ;//= new ArrayList<UserListFollow>();

    public static class UserListFollow {

        public Integer UserId;
        public String UserName;
        public String userName;
        public String FullName;
        public String AvatarSrc;
        public Boolean IsProfilePrivate;
        public Boolean AmIFollowing;
        public Integer IFollowType;
        public Object FollowingLists;

    }

}
