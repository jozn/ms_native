package com.mardomsara.social.models_realm;

import android.support.annotation.Nullable;

import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileViewFields;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageViewFields;

import io.realm.Realm;
import io.realm.RealmResults;

//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;
//import com.mardomsara.social.models_realm.realm_local.RealmMessageViewFields;

/**
 * Created by Hamid on 9/4/2017.
 */

public class RealmMessageFileViewHelper {

	@Nullable
	public static RealmMessageView getMessageByMessageId(Realm realm ,long msgId){
		return realm.where(RealmMessageView.class).equalTo(RealmMessageViewFields.MESSAGE_ID,msgId)
			.findFirst();
	}

	@Nullable
	public static RealmMessageFileView getMessageFileByMessagFileKey(Realm realm ,String msgKey){
		return realm.where(RealmMessageFileView.class).equalTo(RealmMessageFileViewFields.MESSAGE_FILE_KEY,msgKey)
			.findFirst();
	}


}
