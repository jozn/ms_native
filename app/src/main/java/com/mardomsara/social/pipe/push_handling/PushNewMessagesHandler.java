package com.mardomsara.social.pipe.push_handling;

import com.mardomsara.social.app.ConfigRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmMessageView;
import com.mardomsara.social.models_realm.realm.RealmUserView;
import com.mardomsara.social.pipe_pb.PBConv;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_PushHolderView;
import ir.ms.pb.PB_UserView;

/**
 * Created by Hamid on 8/30/2017.
 */

final class PushNewMessagesHandler {
	public static void handle(PB_PushHolderView push) {
		AppUtil.log("push: handling - new messages count: " + push.getNewMessagesCount());
		int c = ConfigRealm.getInstance().where(RealmMessageView.class).findAll().size();
		AppUtil.log("push: handling - realm messages count: " + c);

		List<RealmMessageView> msgs = new ArrayList();
		for (PB_MessageView m : push.getNewMessagesList()) {
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

			msgs.add(t);
		}
		ConfigRealm.getInstance().executeTransaction((trans) -> {
			trans.copyToRealm(msgs);
		});

		List chats = new ArrayList();
		for (PB_ChatView m : push.getChatsList()) {
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

			chats.add(t);
		}
		ConfigRealm.getInstance().executeTransaction((trans) -> {
			trans.copyToRealm(chats);
		});

		List<RealmUserView> users = new ArrayList();
		for (PB_UserView m : push.getUsersList()) {
			RealmUserView t = new RealmUserView();
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

			users.add(t);
		}
		ConfigRealm.getInstance().executeTransaction((trans) -> {
			trans.copyToRealm(users);
		});

	}
}
