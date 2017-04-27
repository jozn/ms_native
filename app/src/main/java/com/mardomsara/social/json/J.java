package com.mardomsara.social.json;

public class J {
	public static class Activity {
		public Integer Id;
		public Integer ActorUserId;
		public Integer ActionTypeId;
		public Integer TargetId;
		public Integer RefId;
		public Integer CreatedAt;
	}

	public static class Bucket {
		public Integer BucketId;
		public String BucketName;
		public Integer Server1Id;
		public Integer Server2Id;
		public Integer BackupServerId;
		public Integer ContentObjectTypeId;
		public Integer ContentObjectCount;
		public Integer CreatedTime;
	}

	public static class Comment {
		public Integer Id;
		public Integer UserId;
		public Integer PostId;
		public String Text;
		public Integer CreatedTime;
	}

	public static class FollowingList {
		public Integer Id;
		public Integer UserId;
		public Integer ListType;
		public String Name;
		public Integer Count;
		public Integer IsAuto;
		public Integer IsPimiry;
		public Integer CreatedTime;
	}

	public static class FollowingListMember {
		public Integer Id;
		public Integer ListId;
		public Integer UserId;
		public Integer FollowedUserId;
		public Integer FollowType;
		public Integer UpdatedTimeMs;
	}

	public static class FollowingListMemberHistory {
		public Integer Id;
		public Integer ListId;
		public Integer UserId;
		public Integer FollowedUserId;
		public Integer FollowType;
		public Integer UpdatedTimeMs;
		public Integer FollowId;
	}

	public static class Like {
		public Integer Id;
		public Integer PostId;
		public Integer PostTypeId;
		public Integer UserId;
		public Integer TypeId;
		public Integer CreatedTime;
	}

	public static class Media {
		public Integer Id;
		public Integer UserId;
		public Integer PostId;
		public Integer AlbumId;
		public Integer TypeId;
		public Integer CreatedTime;
		public String Src;
	}

	public static class Message {
		public Integer Id;
		public Integer ToUserId;
		public String RoomKey;
		public String MessageKey;
		public Integer FromUserID;
		public String Data;
		public Integer TimeMs;
	}

	public static class MsgDeletedFromServer {
		public Integer Id;
		public Integer ToUserId;
		public String MsgKey;
		public Integer PeerUserId;
		public String RoomKey;
		public Integer AtTime;
	}

	public static class MsgReceivedToPeer {
		public Integer Id;
		public Integer ToUserId;
		public String MsgKey;
		public String RoomKey;
		public Integer PeerUserId;
		public Integer AtTime;
	}

	public static class MsgSeenByPeer {
		public Integer Id;
		public Integer ToUserId;
		public String MsgKey;
		public String RoomKey;
		public Integer PeerUserId;
		public Integer AtTime;
	}

	public static class Notification {
		public Integer Id;
		public Integer ForUserId;
		public Integer ActorUserId;
		public Integer ActionTypeId;
		public Integer ObjectTypeId;
		public Integer TargetId;
		public Integer ObjectId;
		public Integer SeenStatus;
		public Integer CreatedTime;
	}

	public static class NotificationRemoved {
		public Integer NotificationId;
		public Integer ForUserId;
	}

	public static class PhoneContact {
		public Integer Id;
		public String PhoneDisplayName;
		public String PhoneFamilyName;
		public String PhoneNumber;
		public String PhoneNormalizedNumber;
		public Integer PhoneContactRowId;
		public Integer UserId;
		public Integer DeviceUuidId;
		public Integer CreatedTime;
		public Integer UpdatedTime;
	}

	public static class Photo {
		public Integer PhotoId;
		public Integer UserId;
		public Integer PostId;
		public Integer AlbumId;
		public Integer ImageTypeId;
		public String Title;
		public String Src;
		public String PathSrc;
		public Integer BucketId;
		public Integer Width;
		public Integer Height;
		public Float Ratio;
		public String HashMd5;
		public Integer CreatedTime;
		public Integer W1080;
		public Integer W720;
		public Integer W480;
		public Integer W320;
		public Integer W160;
		public Integer W80;
	}

	public static class Post {
		public Integer Id;
		public Integer UserId;
		public Integer TypeId;
		public String Text;
		public String FormatedText;
		public Integer MediaCount;
		public Integer SharedTo;
		public Integer DisableComment;
		public Integer HasTag;
		public Integer LikesCount;
		public Integer CommentsCount;
		public Integer EditedTime;
		public Integer CreatedTime;
	}

	public static class RecommendUser {
		public Integer Id;
		public Integer UserId;
		public Integer TargetId;
		public Float Weight;
		public Integer CreatedTime;
	}

	public static class SearchClicked {
		public Integer Id;
		public String Query;
		public Integer ClickType;
		public Integer TargetId;
		public Integer UserId;
		public Integer CreatedAt;
	}

	public static class Session {
		public Integer Id;
		public Integer UserId;
		public String SessionUuid;
		public String ClientUuid;
		public String DeviceUuid;
		public Integer LastActivityTime;
		public String LastIpAddress;
		public String LastWifiMacAddress;
		public String LastNetworkType;
		public Integer LastNetworkTypeId;
		public Integer AppVersion;
		public Integer UpdatedTime;
		public Integer CreatedTime;
	}

	public static class Tag {
		public Integer Id;
		public String Name;
		public Integer Count;
		public Integer IsBlocked;
		public Integer CreatedTime;
	}

	public static class TagsPost {
		public Integer Id;
		public Integer TagId;
		public Integer PostId;
		public Integer TypeId;
		public Integer CreatedTime;
	}

	public static class User {
		public Integer Id;
		public String UserName;
		public String FirstName;
		public String LastName;
		public String About;
		public String FullName;
		public String AvatarUrl;
		public Integer PrivacyProfile;
		public String Phone;
		public String Email;
		public Integer IsDeleted;
		public String PasswordHash;
		public String PasswordSalt;
		public Integer FollowersCount;
		public Integer FollowingCount;
		public Integer PostsCount;
		public Integer MediaCount;
		public Integer LikesCount;
		public Integer ResharedCount;
		public Integer LastActionTime;
		public Integer LastPostTime;
		public Integer PrimaryFollowingList;
		public Integer CreatedTime;
		public Integer UpdatedTime;
		public String SessionUuid;
		public String DeviceUuid;
		public String LastWifiMacAddress;
		public String LastNetworkType;
		public Integer AppVersion;
		public Integer LastActivityTime;
		public Integer LastLoginTime;
		public String LastIpAddress;
	}

	public static class UserMetaInfo {
		public Integer UserId;
		public Integer IsNotificationDirty;
		public Integer LastUserRecGen;
	}

	public static class UserPassword {
		public Integer UserId;
		public String Password;
		public Integer CreatedTime;
	}

}