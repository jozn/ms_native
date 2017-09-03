package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;



public class RealmUserView extends RealmObject {
		 @PrimaryKey 
		public int UserId;//0 				 PB 1
		public String UserName;//1 				 PB 3
		public String FirstName;//2 				 PB 7
		public String LastName;//3 				 PB 9
		public String About;//4 				 PB 11
		public String FullName;//5 				 PB 13
		public String AvatarUrl;//6 				 PB 15
		public int PrivacyProfile;//7 				 PB 17
		public int IsDeleted;//8 				 PB 23
		public int FollowersCount;//9 				 PB 29
		public int FollowingCount;//10 				 PB 31
		public int PostsCount;//11 				 PB 33
		public int UpdatedTime;//12 				 PB 49
		public int AppVersion;//13 				 PB 59
		public int LastActivityTime;//14 				 PB 61
		public int FollowingType;//15 				 PB 62
	

	public static RealmUserView fromPB(PB_UserView pb){
		RealmUserView r = new RealmUserView();
		
	    r.UserId = pb.getUserId();//0
	    r.UserName = pb.getUserName();//1
	    r.FirstName = pb.getFirstName();//2
	    r.LastName = pb.getLastName();//3
	    r.About = pb.getAbout();//4
	    r.FullName = pb.getFullName();//5
	    r.AvatarUrl = pb.getAvatarUrl();//6
	    r.PrivacyProfile = pb.getPrivacyProfile();//7
	    r.IsDeleted = pb.getIsDeleted();//8
	    r.FollowersCount = pb.getFollowersCount();//9
	    r.FollowingCount = pb.getFollowingCount();//10
	    r.PostsCount = pb.getPostsCount();//11
	    r.UpdatedTime = pb.getUpdatedTime();//12
	    r.AppVersion = pb.getAppVersion();//13
	    r.LastActivityTime = pb.getLastActivityTime();//14
	    r.FollowingType = pb.getFollowingType();//15

	    return r;
	}

}
	/*
	folding

	PBFlatTypes.PB_UserView t = new PBFlatTypes.PB_UserView();
    t.UserId = pb.getUserId();
    t.UserName = pb.getUserName();
    t.FirstName = pb.getFirstName();
    t.LastName = pb.getLastName();
    t.About = pb.getAbout();
    t.FullName = pb.getFullName();
    t.AvatarUrl = pb.getAvatarUrl();
    t.PrivacyProfile = pb.getPrivacyProfile();
    t.IsDeleted = pb.getIsDeleted();
    t.FollowersCount = pb.getFollowersCount();
    t.FollowingCount = pb.getFollowingCount();
    t.PostsCount = pb.getPostsCount();
    t.UpdatedTime = pb.getUpdatedTime();
    t.AppVersion = pb.getAppVersion();
    t.LastActivityTime = pb.getLastActivityTime();
    t.FollowingType = pb.getFollowingType();
	*/

	/*
	PBFlatTypes.PB_UserView t = new PBFlatTypes.PB_UserView();
	t.UserId = ;
	t.UserName = ;
	t.FirstName = ;
	t.LastName = ;
	t.About = ;
	t.FullName = ;
	t.AvatarUrl = ;
	t.PrivacyProfile = ;
	t.IsDeleted = ;
	t.FollowersCount = ;
	t.FollowingCount = ;
	t.PostsCount = ;
	t.UpdatedTime = ;
	t.AppVersion = ;
	t.LastActivityTime = ;
	t.FollowingType = ;
	*/

	/*
	PB_UserView t = new PB_UserView();
	t.UserId = m.getUserId() ;
	t.UserName = m.getUserName() ;
	t.FirstName = m.getFirstName() ;
	t.LastName = m.getLastName() ;
	t.About = m.getAbout() ;
	t.FullName = m.getFullName() ;
	t.AvatarUrl = m.getAvatarUrl() ;
	t.PrivacyProfile = m.getPrivacyProfile() ;
	t.IsDeleted = m.getIsDeleted() ;
	t.FollowersCount = m.getFollowersCount() ;
	t.FollowingCount = m.getFollowingCount() ;
	t.PostsCount = m.getPostsCount() ;
	t.UpdatedTime = m.getUpdatedTime() ;
	t.AppVersion = m.getAppVersion() ;
	t.LastActivityTime = m.getLastActivityTime() ;
	t.FollowingType = m.getFollowingType() ;
	
*/
