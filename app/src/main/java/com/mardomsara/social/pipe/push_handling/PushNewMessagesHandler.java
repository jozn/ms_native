package com.mardomsara.social.pipe.push_handling;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.PBToRealm;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;

import java.util.ArrayList;
import java.util.List;

import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_PushHolderView;
import ir.ms.pb.PB_UserView;

/**
 * Created by Hamid on 8/30/2017.
 */

final class PushNewMessagesHandler {

	//first insert users > messages > chats
	public static void handle(PB_PushHolderView push) {
		AppUtil.log("push: handling - new messages count: " + push.getNewMessagesCount());
		int c = MSRealm.getChatRealm().where(RealmMessageView.class).findAll().size();
		AppUtil.log("push: handling - realm messages count: " + c + " chat count " + push.getChatsCount());


		List<RealmUserView> users = new ArrayList();
		for (PB_UserView m : push.getUsersList()) {
			RealmUserView t = PBToRealm.from_userView(m);

			users.add(t);
		}
		MSRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(users);
		});

		List<RealmMessageView> msgs = new ArrayList();
		for (PB_MessageView m : push.getNewMessagesList()) {
			RealmMessageView t = PBToRealm.from_messageView(m);
			msgs.add(t);
		}

		MSRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(msgs);
		});

		List chats = new ArrayList();
		for (PB_ChatView m : push.getChatsList()) {
			RealmChatView t = PBToRealm.from_chatView(m);

			chats.add(t);
		}
		MSRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(chats);
		});

		RealmChatViewHelper.insertOrUpdateNewChatsFromPipe(push.getChatsList());


	}
}
