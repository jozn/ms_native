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

	//sett
	RealmUserView r = new RealmUserView();
	
	r.UserId = ;//0
	r.UserName = ;//1
	r.FirstName = ;//2
	r.LastName = ;//3
	r.About = ;//4
	r.FullName = ;//5
	r.AvatarUrl = ;//6
	r.PrivacyProfile = ;//7
	r.IsDeleted = ;//8
	r.FollowersCount = ;//9
	r.FollowingCount = ;//10
	r.PostsCount = ;//11
	r.UpdatedTime = ;//12
	r.AppVersion = ;//13
	r.LastActivityTime = ;//14
	r.FollowingType = ;//15

	//sett - no tag number 
	RealmUserView r = new RealmUserView();
	
	r.UserId = ;
	r.UserName = ;
	r.FirstName = ;
	r.LastName = ;
	r.About = ;
	r.FullName = ;
	r.AvatarUrl = ;
	r.PrivacyProfile = ;
	r.IsDeleted = ;
	r.FollowersCount = ;
	r.FollowingCount = ;
	r.PostsCount = ;
	r.UpdatedTime = ;
	r.AppVersion = ;
	r.LastActivityTime = ;
	r.FollowingType = ;

	//get
	
	m. = r.UserId ;//0
	m. = r.UserName ;//1
	m. = r.FirstName ;//2
	m. = r.LastName ;//3
	m. = r.About ;//4
	m. = r.FullName ;//5
	m. = r.AvatarUrl ;//6
	m. = r.PrivacyProfile ;//7
	m. = r.IsDeleted ;//8
	m. = r.FollowersCount ;//9
	m. = r.FollowingCount ;//10
	m. = r.PostsCount ;//11
	m. = r.UpdatedTime ;//12
	m. = r.AppVersion ;//13
	m. = r.LastActivityTime ;//14
	m. = r.FollowingType ;//15

	//get - no tag number
	
	m. = r.UserId ;
	m. = r.UserName ;
	m. = r.FirstName ;
	m. = r.LastName ;
	m. = r.About ;
	m. = r.FullName ;
	m. = r.AvatarUrl ;
	m. = r.PrivacyProfile ;
	m. = r.IsDeleted ;
	m. = r.FollowersCount ;
	m. = r.FollowingCount ;
	m. = r.PostsCount ;
	m. = r.UpdatedTime ;
	m. = r.AppVersion ;
	m. = r.LastActivityTime ;
	m. = r.FollowingType ;
	
*/
