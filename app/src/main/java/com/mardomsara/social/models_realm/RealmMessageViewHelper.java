package com.mardomsara.social.models_realm;

import android.support.annotation.Nullable;

import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;
//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;

import io.realm.Realm;

/**
 * Created by Hamid on 9/4/2017.
 */

public class RealmMessageViewHelper {

	@Nullable
	public static RealmMessageView getLastMessageForChat(Realm realm ,long chatId){
		return realm.where(RealmMessageView.class).equalTo("ChatId",chatId)
			.findFirst();
	}
}
