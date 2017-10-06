package com.mardomsara.social.models_realm.helpers;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.Database;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_UserView;

/**
 * Created by Hamid on 10/5/2017.
 */

public class HelperPushAndRefreshHandlerOfData {

	public static void newChatViewList(List<PB_ChatView> pbChats){
		if(pbChats == null || pbChats.size() ==0 ) return;

		/*List chats = new ArrayList();
		for (PB_ChatView pb_chatView : pbChats) {
			RealmChatView realmChatView = RealmChatView.fromPB(pb_chatView);

			if(pb_chatView.getUserView() != null){
				AppUtil.log("pb: handling - realm users: " + pb_chatView.getUserView().getUserName());
				realmChatView.UserView = RealmUserView.fromPB(pb_chatView.getUserView());
			}
			realmChatView.LastMessage = RealmMessageViewHelper.getLastMessageForChat(AppRealm.getChatRealm(),realmChatView.ChatKey);

			chats.add(realmChatView);
		}
		AppRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(chats);
		});*/

		Realm realm = AppRealm.getChatRealm();
		for (PB_ChatView pb_chatView : pbChats) {
			RealmChatView realmChatView = Database.getRealmChatView(realm, pb_chatView.getChatKey());
			if (realmChatView == null) {//create new chat
//				realmChatView = realm.createObject(RealmChatView.class);
				realmChatView = RealmChatView.fromPB(pb_chatView);
				//realmChatView.user = Database.getRealmUserView(realm, pb_chatView.getUserId());
//				if (realmChatView.user == null);// continue;//user must set

			} else {//update existing ine

			}

			if(pb_chatView.getUserView() != null){//must alwase be true
				realmChatView.UserView = RealmUserView.fromPB(pb_chatView.getUserView());
			}else {
				AppUtil.log("pb: handling - realm users: " + pb_chatView.getUserView().getUserName());
			}

			realmChatView.LastMessage = RealmMessageViewHelper.getLastMessageForChat(AppRealm.getChatRealm(),realmChatView.RoomKey);
			realmChatView.UnseenCount = RealmMessageViewHelper.getUnseenCountForChat(AppRealm.getChatRealm(),realmChatView.ChatKey,realmChatView.LastSeenMessageId);

			RealmChatView chatView2 = realmChatView;
			realm.executeTransaction((r)->{
				r.copyToRealmOrUpdate(chatView2);
			});


		}
		realm.close();
	}

	public static void newMessageViewList(List<PB_MessageView> chats){
		if(chats == null || chats.size() ==0 ) return;

		List<RealmMessageView> msgs = new ArrayList();
		for (PB_MessageView pbMessageView :chats) {
			RealmMessageView t = RealmMessageView.fromPB(pbMessageView);
			if(pbMessageView.getMessageFileView() != null){
				t.MessageFileView = RealmMessageFileView.fromPB(pbMessageView.getMessageFileView());
			}
			msgs.add(t);
		}

		AppRealm.getChatRealm().executeTransaction((trans) -> {
			trans.copyToRealmOrUpdate(msgs);
		});
	}

	public static void userViewList(List<PB_UserView> chats){}

}
