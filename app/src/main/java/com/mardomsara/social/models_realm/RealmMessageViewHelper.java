package com.mardomsara.social.models_realm;

import android.support.annotation.Nullable;

import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageViewFields;
//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;
//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Hamid on 9/4/2017.
 */

public class RealmMessageViewHelper {

	@Nullable
	public static RealmMessageView getLastMessageForChat(Realm realm ,String roomKey){
		return realm.where(RealmMessageView.class).equalTo(RealmMessageViewFields.ROOM_KEY,roomKey)
			.findFirst();
	}

	@Nullable
	public static RealmMessageView getMessageByMessageId(Realm realm ,long msgId){
		return realm.where(RealmMessageView.class).equalTo(RealmMessageViewFields.MESSAGE_ID,msgId)
			.findFirst();
	}

	@Nullable
	public static RealmMessageView getMessageByMessagKey(Realm realm ,String msgKey){
		return realm.where(RealmMessageView.class).equalTo(RealmMessageViewFields.MESSAGE_KEY,msgKey)
			.findFirst();
	}

	public static int getUnseenCountForChat(Realm realm ,String chatId, long lastSeen){
		RealmResults<RealmMessageView> results = realm.where(RealmMessageView.class)
			 .equalTo("ChatKey",chatId)
			 .greaterThan(RealmMessageViewFields.MESSAGE_ID ,lastSeen).findAll();
		return results.size();
	}

	@Nullable
	public static boolean isMessageByMe(RealmMessageView msg ){
		return Session.isUserIdMe(msg.UserId);
	}
}
