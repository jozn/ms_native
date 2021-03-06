package com.mardomsara.social.models_realm.helpers;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.Database;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileViewFields;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageViewFields;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ir.ms.pb.PB_ChatView;
import ir.ms.pb.PB_MessageView;
import ir.ms.pb.PB_UpdateMessageId;
import ir.ms.pb.PB_UpdateMessageMeta;
import ir.ms.pb.PB_UserView;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;

/**
 * Created by Hamid on 10/5/2017.
 */

public class HelperPushAndRefreshHandlerOfData {

	public static void newChatViewList(List<PB_ChatView> pbChats) {
		if (pbChats == null || pbChats.size() == 0) return;

		Realm realm = AppRealm.getChatRealm();
		for (PB_ChatView pb_chatView : pbChats) {
			try {
				RealmChatView realmChatView = Database.getRealmChatView(realm, pb_chatView.getChatKey());
				if (realmChatView == null) {//create new chat
					realmChatView = RealmChatView.fromPB(pb_chatView);
				} else {//update existing ine

				}

				final RealmUserView realmUserView = RealmUserView.fromPB(pb_chatView.getUserView());

				RealmChatView chatView2 = realmChatView;
				realm.executeTransaction((r) -> {
					chatView2.UserView = r.copyToRealmOrUpdate(realmUserView);

					chatView2.LastMessage = RealmMessageViewHelper.getLastMessageForChat(r, chatView2.RoomKey);
					chatView2.UnseenCount = RealmMessageViewHelper.getUnseenCountForChat(r, chatView2.ChatKey, chatView2.LastSeenMessageId);

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
				AppUtil.log("updating messagesDelivierdToServer : " + meta.getMessageId());
				if (msg != null) {
					realm.executeTransaction((t) -> {

					});
					msg.DeliviryStatusEnumId = (RoomMessageDeliviryStatusEnum.SENT_VALUE);
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
					msg.PeerReceivedTime = (int) meta.getAtTime();
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
					msg.PeerSeenTime = (int) meta.getAtTime();
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

	/////////////// Messages Idss changes - must called before meta changes( they use ids /////////////////
	public static void messagesChangeIdsList(List<PB_UpdateMessageId> changes) {
		if (changes == null || changes.size() == 0) return;

		try {
			Realm realm = AppRealm.getChatRealm();
//			List<RealmMessageView> msgs = new ArrayList();
			for (PB_UpdateMessageId ch : changes) {
				RealmMessageView msg = RealmMessageViewHelper.getMessageByMessageId(realm, ch.getOldMessageId());
//				AppUtil.log("updating messagesDelivierdToServer : "+ ch.getMessageId());
				if (msg != null) {
					realm.executeTransaction((t) -> {

					});
					msg.RemoteId = ch.getNewMessageId();
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

	public static void messagesFileChangeIdsList(List<PB_UpdateMessageId> changes) {
		if (changes == null || changes.size() == 0) return;

		try {
			Realm realm = AppRealm.getChatRealm();
//			List<RealmMessageView> msgs = new ArrayList();
			for (PB_UpdateMessageId ch : changes) {
				RealmMessageFileView msg = realm.where(RealmMessageFileView.class).equalTo(RealmMessageFileViewFields.MESSAGE_FILE_ID, ch.getOldMessageId())
					.findFirst();
//				AppUtil.log("updating messagesDelivierdToServer : "+ ch.getMessageId());
				if (msg != null) {

					msg.RemoteMessageFileId = ch.getNewMessageId();
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

}
