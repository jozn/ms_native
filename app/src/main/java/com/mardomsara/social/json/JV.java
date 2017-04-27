package com.mardomsara.social.json;

import java.util.List;

/**
 * Created by Hamid on 4/27/2017.
 */
//copy from here:  http://localhost:5000/i/java
//needs manual changes

public class JV {
	/*public static class ActivityView {
		public J.Activity Activity;
		public ActivityPayload Load;
	}

	public static class ActivityPayload {
		public J.User Actor;
		public J.Post Post;
		public J.Comment Comment;

	}

	public static class NotificationView {
		public J.Notification Notification;
		public J.Load Load;

	}

	public static class NotifPayload {
		public J.Actor Actor;
		public J.Post Post;
		public J.Comment Comment;

	}

	public static class NotifPayload {
		public J.Actor Actor;
		public J.Post Post;
		public J.Comment Comment;

	}
*/
	public static class TopTagsWithPostsView {
		public J.Tag Tag;
		public List<PostView> Posts;

	}

	public static class UserInlineView {
		public int UserId;
		public String UserName;
		public String FullName;
		public String AvatarUrl;

	}

	public static class PhotoView {
		public int PhotoId;
		public int UserId;
		public int PostId;
		public int AlbumId;
		public int ImageTypeId;
		public int Width;
		public int Height;
		public float Ratio;
		public String UrlFormat;
		public List<Integer> Sizes;
	}

	public static class PostView extends J.Post{
		public String TypeName;
		public UserInlineView Sender;
		public PhotoView PhotoView;
		public boolean AmIlike;
		public int MyLike;

	}

	public static class CommentInlineInfoView extends J.Comment {
		public UserInlineView Sender;
	}

	public static class UserBasic {
		public int Id;
		public String UserName;
		public String FirstName;
		public String LastName;
		public String FullName;
		public String AvatarUrl;
		public int PrivacyProfile;
		public String About;

	}

	public static class UserBasicAndMe extends  UserBasic {
		public int UserId;
		public int UpdatedTime;
		public int FollowingType;
	}

	public static class UserSyncAndMeView extends UserBasic{
		public int UserId;
		public int FollowingType;
		public int AppVersion;
		public String Phone;
		public int UpdatedTime;

	}

	/*public static class UserSession {
		public String SessionUuid;
		public String DeviceUuid;
		public int AppVersion;
		public int LastLoginTime;
		public int LastActivityTime;
		public String LastIpAddress;
		public String LastWifiMacAddress;
		public String LastNetworkType;

	}*/

	/*public static class UserExtra {
		public String Email;
		public int PrimaryFollowingList;
		public int CreatedTime;
		public int UpdatedTime;
		public int LastPostTime;
		public int LastActionTime;

	}*/

}
