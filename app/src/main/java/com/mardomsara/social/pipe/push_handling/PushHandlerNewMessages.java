package com.mardomsara.social.pipe.push_handling;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;

import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_PushHolderView;

/**
 * Created by Hamid on 8/30/2017.
 */

final class PushHandlerNewMessages {

	//first insert users > messages > chats
	public static void handle(PB_PushHolderView push) {
		AppUtil.log("push: handling - new messages count: " + push.getNewMessagesCount());
		int c = AppRealm.getChatRealm().where(RealmMessageView.class).findAll().size();
		AppUtil.log("push: handling - realm messages count: " + c + " chat count " + push.getChatsCount());


		/*List<RealmUserView> users = new ArrayList();
		for (PB_UserView m : push.getUsersList()) {
			RealmUserView t = PBToRealm.from_userView(m);

			users.add(t);
		}
		MSRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(users);
		});*/

		List<RealmMessageView> msgs = new ArrayList();
		for (PB_MessageView pbMessageView : push.getNewMessagesList()) {
			RealmMessageView t = RealmMessageView.fromPB(pbMessageView);
			if(pbMessageView.getMessageFileView() != null){
				t.MessageFileView = RealmMessageFileView.fromPB(pbMessageView.getMessageFileView());
			}
			msgs.add(t);
		}

		AppRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(msgs);
		});

		List chats = new ArrayList();
		for (PB_ChatView pb_chatView : push.getChatsList()) {
			RealmChatView realmChatView = RealmChatView.fromPB(pb_chatView);

			if(pb_chatView.getUserView() != null){
				AppUtil.log("push: handling - realm users: " + pb_chatView.getUserView().getUserName());
				realmChatView.UserView = RealmUserView.fromPB(pb_chatView.getUserView());
			}
			realmChatView.LastMessage = RealmMessageViewHelper.getLastMessageForChat(AppRealm.getChatRealm(),realmChatView.ChatId);

			chats.add(realmChatView);
		}
		AppRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(chats);
		});

		RealmChatViewHelper.insertOrUpdateNewChatsFromPipe(push.getChatsList());

	}
}
