package com.mardomsara.social.models_realm;

import android.support.annotation.Nullable;

import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmChatViewFields;
import com.mardomsara.social.models_realm.realm.RealmMessageView;
import com.mardomsara.social.models_realm.realm.RealmMessageViewFields;
import com.mardomsara.social.models_realm.realm.RealmUserView;
import com.mardomsara.social.models_realm.realm.RealmUserViewFields;

import io.realm.Realm;

/**
 * Created by Hamid on 9/2/2017.
 */

public class Database {

	@Nullable
	public static RealmChatView getRealmChatView(Realm realm, long chatId){
		return realm.where(RealmChatView.class).equalTo(RealmChatViewFields.CHAT_ID, chatId).findFirst();
	}

	@Nullable
	public static RealmUserView getRealmUserView(Realm realm, long userId){
		return realm.where(RealmUserView.class).equalTo(RealmUserViewFields.USER_ID, userId).findFirst();
	}

	@Nullable
	public static RealmMessageView getRealmMessageView(Realm realm, long messageId){
		return realm.where(RealmMessageView.class).equalTo(RealmMessageViewFields.MESSAGE_ID, messageId).findFirst();
	}
}
