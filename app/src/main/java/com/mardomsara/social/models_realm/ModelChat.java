package com.mardomsara.social.models_realm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmChatViewFields;
import com.mardomsara.social.models_realm.realm.RealmMessageView;
import com.mardomsara.social.models_realm.realm.RealmUserView;

import java.util.List;

import io.realm.Realm;
import ir.ms.pb.PB_ChatView;

/**
 * Created by Hamid on 9/1/2017.
 */

public class ModelChat {

	public static @Nullable RealmChatView getChatByChatId(long chatId){
		Realm realm = MSRealm.getChatRealm();
		RealmChatView chatView = realm.where(RealmChatView.class).equalTo(RealmChatViewFields.CHAT_ID, chatId).findFirst();
		realm.close();

		return chatView;
	}

	public static void remoteCleanChatHistory(RealmChatView realmChatView){


	}

	public static void remoteDeleteChatHistory(RealmChatView realmChatView){

	}

	public static void onRoomOpened_InBackground(RealmChatView realmChatView){

	}

	public static RealmChatView getRoomByForUserAndLoadUser(int peerUserId){
		return null;
	}

	private static int countUnseenMsgsForRoom(String RoomKey, long LastSeenTimeMs ){
		return 0;
	}

	public static RealmChatView onReceivedNewMsg_NotSave(@NonNull RealmMessageView msg, RealmChatView roomMem){

		return null;
	}

	public static void onByMeNewMsg(@NonNull RealmMessageView msg){
;
	}

	public static void updateRoomSeenMsgsToNow_BG(RealmChatView room){

	}

	public static void insertOrUpdateNewChatsFromPipe(List<ir.ms.pb.PB_ChatView> chatViews){
		Realm realm = MSRealm.getChatRealm();
		for (PB_ChatView m : chatViews) {
			RealmChatView chatView = getChatByChatId(m.getChatId());
			if(chatView == null) {//create new chat
				chatView = realm.createObject(RealmChatView.class);
				chatView.user = RealmUserView.getUserByUserId(m.getUserId());
				if(chatView.user == null) continue;//user must set

			}else {//update existing ine

			}

			RealmChatView chatView2 = chatView;
			MSRealm.getChatRealm().executeTransactionAsync((r -> {
					r.copyToRealmOrUpdate(chatView2);
			}));
		}

	}

}
