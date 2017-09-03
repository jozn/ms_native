package com.mardomsara.social.models_realm;

import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmMessageView;
import com.mardomsara.social.models_realm.realm.RealmUserView;

import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_UserView;

/**
 * Created by Hamid on 9/1/2017.
 */

public class PBToRealm {
	public static RealmMessageView from_messageView(PB_MessageView m) {
		RealmMessageView t = new RealmMessageView();
		t.MessageId = m.getMessageId();
		t.RoomKey = m.getRoomKey();
		t.UserId = m.getUserId();
		t.MessageFileId = m.getMessageFileId();
		t.MessageTypeEnumId = m.getMessageTypeEnumId();
		t.Text = m.getText();
		t.Time = m.getTime();
		t.PeerReceivedTime = m.getPeerReceivedTime();
		t.PeerSeenTime = m.getPeerSeenTime();
		t.DeliviryStatusEnumId = m.getDeliviryStatusEnumId();


		return t;
	}

	public static RealmChatView from_chatView(PB_ChatView m) {
		RealmChatView t = new RealmChatView();
		t.ChatId = m.getChatId();
		t.ChatKey = m.getChatKey();
		t.RoomTypeEnumId = m.getRoomTypeEnumId();
		t.UserId = m.getUserId();
		t.LastSeqSeen = m.getLastSeqSeen();
		t.LastSeqDelete = m.getLastSeqDelete();
		t.PeerUserId = m.getPeerUserId();
		t.GroupId = m.getGroupId();
		t.CreatedTime = m.getCreatedTime();
		t.CurrentSeq = m.getCurrentSeq();
		t.UpdatedMs = m.getUpdatedMs();
		t.DirectLastMessageId = m.getDirectLastMessageId();
		t.LastSeenMessageId = m.getDirectLastMessageId();
		t.LastSeqSeen = m.getLastSeqSeen();
		t.LastSeqDelete = m.getLastSeqDelete();
		t.CurrentSeq = m.getCurrentSeq();

		if(m.getUser() != null){
			t.user = from_userView(m.getUser());
		}

		return t;
	}

	public static RealmUserView from_userView(PB_UserView m) {
		RealmUserView t = new RealmUserView();
		t.UserId = m.getUserId();
		t.UserName = m.getUserName();
		t.FirstName = m.getFirstName();
		t.LastName = m.getLastName();
		t.About = m.getAbout();
		t.FullName = m.getFullName();
		t.AvatarUrl = m.getAvatarUrl();
		t.PrivacyProfile = m.getPrivacyProfile();
		t.IsDeleted = m.getIsDeleted();
		t.FollowersCount = m.getFollowersCount();
		t.FollowingCount = m.getFollowingCount();
		t.PostsCount = m.getPostsCount();
		t.UpdatedTime = m.getUpdatedTime();
		t.AppVersion = m.getAppVersion();
		t.LastActivityTime = m.getLastActivityTime();
		t.FollowingType = m.getFollowingType();

		return t;
	}


}
