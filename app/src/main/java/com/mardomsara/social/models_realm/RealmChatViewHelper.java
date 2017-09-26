package com.mardomsara.social.models_realm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmChatViewFields;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import java.util.List;

import io.realm.Realm;
import ir.ms.pb.PB_ChatView;

//import com.mardomsara.social.models_realm.realm_local.RealmChatViewFields;

/**
 * Created by Hamid on 9/1/2017.
 */

public class RealmChatViewHelper {

	/////////////////////////////////////////
	public static String getRoomName(RealmChatView chatView){
		if(chatView.UserView != null){
			return "" + chatView.UserView.FirstName + " " + chatView.UserView.LastName;
		}
		return "name: " + chatView.ChatKey;
	}

	public static String getRoomAvatarUrl(RealmChatView chatView){
		if(chatView.UserView != null){
			return chatView.UserView.AvatarUrl;
		}
		return "http://192.168.0.105:5000/upload/avatar/1/21_mOId_200.jpg";
	}

	public static int getUserId(RealmChatView chatView){
		if(chatView.UserView != null){
			return chatView.UserView.UserId;
		}
		return 12;
	}

	/////////////////////////////////////////

	public static
	@Nullable
	RealmChatView getChatByChatId(long chatId) {
		Realm realm = AppRealm.getChatRealm();
		RealmChatView chatView = realm.where(RealmChatView.class).equalTo("ChatId", chatId).findFirst();
		realm.close();

		return chatView;
	}

	public static
	@Nullable RealmChatView getChatByChatKey(Realm realm,String chatId) {
		RealmChatView chatView = realm.where(RealmChatView.class).equalTo(RealmChatViewFields.CHAT_KEY, chatId).findFirst();
		return chatView;
	}

	public static void remoteCleanChatHistory(RealmChatView realmChatView) {


	}

	public static void remoteDeleteChatHistory(RealmChatView realmChatView) {

	}

	public static void onRoomOpened_InBackground(RealmChatView realmChatView) {

	}

	public static RealmChatView getRoomByForUserAndLoadUser(int peerUserId) {
		return null;
	}

	private static int countUnseenMsgsForRoom(String RoomKey, long LastSeenTimeMs) {
		return 0;
	}

	public static RealmChatView onReceivedNewMsg_NotSave(@NonNull RealmMessageView msg, RealmChatView roomMem) {

		return null;
	}

	public static void onByMeNewMsg(@NonNull RealmMessageView msg) {
		;
	}

	public static void updateRoomSeenMsgsToNow_BG(RealmChatView room) {

	}

	public static void insertOrUpdateNewChatsFromPipe(List<ir.ms.pb.PB_ChatView> chatViews) {
		Realm realm = AppRealm.getChatRealm();
		for (PB_ChatView m : chatViews) {
			RealmChatView chatView = Database.getRealmChatView(realm, m.getChatId());
			if (chatView == null) {//create new chat
//				chatView = realm.createObject(RealmChatView.class);
//				chatView = PBToRealm.from_chatView(m);
				//chatView.user = Database.getRealmUserView(realm, m.getUserId());
//				if (chatView.user == null);// continue;//user must set

			} else {//update existing ine

			}

			RealmChatView chatView2 = chatView;
			realm.executeTransaction((r)->{
				r.insertOrUpdate(chatView2);
			});


		}
		realm.close();

	}

	public static void insertOrUpdateNewChatsFromPipe_bk(List<ir.ms.pb.PB_ChatView> chatViews) {
		Realm realm = AppRealm.getChatRealm();
		for (PB_ChatView m : chatViews) {
			RealmChatView chatView = getChatByChatId(m.getChatId());
			if (chatView == null) {//create new chat
				chatView = realm.createObject(RealmChatView.class);
//				chatView.user = RealmUserView.getUserByUserId(m.getUserId());
//				if (chatView.user == null) continue;//user must set

			} else {//update existing ine

			}

			RealmChatView chatView2 = chatView;
			AppRealm.getChatRealm().executeTransactionAsync((r -> {
				r.copyToRealmOrUpdate(chatView2);
			}));
		}

	}

}
