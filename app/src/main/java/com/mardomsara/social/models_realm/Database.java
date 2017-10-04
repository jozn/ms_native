package com.mardomsara.social.models_realm;

import android.support.annotation.Nullable;

import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
//import com.mardomsara.social.models_realm.realm_local.RealmChatViewFields;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;
//import com.mardomsara.social.models_realm.realm_local.RealmUserViewFields;

import io.realm.Realm;

/**
 * Created by Hamid on 9/2/2017.
 */

public class Database {

	@Nullable
	public static RealmChatView getRealmChatView(Realm realm, String chatId){
		return realm.where(RealmChatView.class).equalTo("ChatKey", chatId).findFirst();
	}

	@Nullable
	public static RealmUserView getRealmUserView(Realm realm, long userId){
		return realm.where(RealmUserView.class).equalTo("UserId", userId).findFirst();
	}

	@Nullable
	public static RealmMessageView getRealmMessageView(Realm realm, long messageId){
		return realm.where(RealmMessageView.class).equalTo("MessageId", messageId).findFirst();
	}
}
