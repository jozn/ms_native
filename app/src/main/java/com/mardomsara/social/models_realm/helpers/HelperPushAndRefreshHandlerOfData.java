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
import ir.ms.pb.PB_UpdateMessageMeta;
import ir.ms.pb.PB_UserView;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;

/**
 * Created by Hamid on 10/5/2017.
 */

public class HelperPushAndRefreshHandlerOfData {

	public static void newChatViewList(List<PB_ChatView> pbChats) {
		if (pbChats == null || pbChats.size() == 0) return;

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
			try {
				RealmChatView realmChatView = Database.getRealmChatView(realm, pb_chatView.getChatKey());
				if (realmChatView == null) {//create new chat
//				realmChatView = realm.createObject(RealmChatView.class);
					realmChatView = RealmChatView.fromPB(pb_chatView);
					//realmChatView.user = Database.getRealmUserView(realm, pb_chatView.getUserId());
//				if (realmChatView.user == null);// continue;//user must set

				} else {//update existing ine

				}

				if (pb_chatView.getUserView() != null) {//must alwase be true
					realmChatView.UserView = RealmUserView.fromPB(pb_chatView.getUserView());
				} else {
					AppUtil.log("pb: handling - realm users: " + pb_chatView.getUserView().getUserName());
				}

				realmChatView.LastMessage = RealmMessageViewHelper.getLastMessageForChat(AppRealm.getChatRealm(), realmChatView.RoomKey);
				realmChatView.UnseenCount = RealmMessageViewHelper.getUnseenCountForChat(AppRealm.getChatRealm(), realmChatView.ChatKey, realmChatView.LastSeenMessageId);

				RealmChatView chatView2 = realmChatView;
				realm.executeTransaction((r) -> {
					r.copyToRealmOrUpdate(chatView2);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		realm.close();
	}

	public static void newMessageViewList(List<PB_MessageView> chats) {
		if (chats == null || chats.size() == 0) return;

		try {
			List<RealmMessageView> msgs = new ArrayList();
			for (PB_MessageView pbMessageView : chats) {
				RealmMessageView t = RealmMessageView.fromPB(pbMessageView);
				if (pbMessageView.getMessageFileView() != null) {
					t.MessageFileView = RealmMessageFileView.fromPB(pbMessageView.getMessageFileView());
				}
				msgs.add(t);
			}

			AppRealm.getChatRealm().executeTransaction((trans) -> {
				trans.copyToRealmOrUpdate(msgs);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void userViewList(List<PB_UserView> chats) {
	}


	/////////////// Messages Metas /////////////////
	public static void messagesDelivierdToServer(List<PB_UpdateMessageMeta> metas) {
		if (metas == null || metas.size() == 0) return;

		try {
			Realm realm = AppRealm.getChatRealm();
//			List<RealmMessageView> msgs = new ArrayList();
			for (PB_UpdateMessageMeta meta : metas) {
				RealmMessageView msg = RealmMessageViewHelper.getMessageByMessageId(realm, meta.getMessageId());
				AppUtil.log("updating messagesDelivierdToServer : "+ meta.getMessageId());
				if (msg != null) {
					realm.executeTransaction((t)->{

					});
					msg.setDeliviryStatusEnumId( RoomMessageDeliviryStatusEnum.SENT_VALUE);
				}
//				msgs.add(msg);
			}

			/*AppRealm.getChatRealm().executeTransaction((trans) -> {
				trans.insertOrUpdate(msgs);
			});*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void messagesDelivierdToPeerList(List<PB_UpdateMessageMeta> metas) {
		if (metas == null || metas.size() == 0) return;

		try {
			Realm realm = AppRealm.getChatRealm();
			List<RealmMessageView> msgs = new ArrayList();
			for (PB_UpdateMessageMeta meta : metas) {
				RealmMessageView msg = RealmMessageViewHelper.getMessageByMessageId(realm, meta.getMessageId());
				if (msg != null) {
					msg.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.DELIVERED_VALUE;
					msg.PeerReceivedTime = (int)meta.getAtTime();
				}
				msgs.add(msg);
			}

			AppRealm.getChatRealm().executeTransaction((trans) -> {
				trans.copyToRealmOrUpdate(msgs);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void messagesDeletedFromServerList(List<PB_UpdateMessageMeta> metas) {
		if (metas == null || metas.size() == 0) return;

		try {
			Realm realm = AppRealm.getChatRealm();
			List<RealmMessageView> msgs = new ArrayList();
			for (PB_UpdateMessageMeta meta : metas) {
				RealmMessageView msg = RealmMessageViewHelper.getMessageByMessageId(realm, meta.getMessageId());
				if (msg != null) {
//					msg.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.;
//					msg.PeerReceivedTime = (int)meta.getAtTime();
				}
				msgs.add(msg);
			}

			AppRealm.getChatRealm().executeTransaction((trans) -> {
				trans.copyToRealmOrUpdate(msgs);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void messagesSeenByPeerList(List<PB_UpdateMessageMeta> metas) {
		if (metas == null || metas.size() == 0) return;

		try {
			Realm realm = AppRealm.getChatRealm();
			List<RealmMessageView> msgs = new ArrayList();
			for (PB_UpdateMessageMeta meta : metas) {
				RealmMessageView msg = RealmMessageViewHelper.getMessageByMessageId(realm, meta.getMessageId());
				if (msg != null) {
					msg.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.SEEN2_VALUE;
					msg.PeerSeenTime= (int)meta.getAtTime();
				}
				msgs.add(msg);
			}

			AppRealm.getChatRealm().executeTransaction((trans) -> {
				trans.copyToRealmOrUpdate(msgs);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
