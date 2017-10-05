package com.mardomsara.social.app;

import android.content.Context;

import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmUserView;
import com.scand.realmbrowser.RealmBrowser;

import io.realm.Realm;

/**
 * Created by Hamid on 9/4/2017.
 */

public class ConfigRealmBrowser {
	public static void init(Context context) {
		try {
			Realm realm = AppRealm.getChatRealm();
			new RealmBrowser.Builder(context)
				.add(realm, RealmChatView.class)
				.add(realm, RealmMessageView.class)
				.add(realm, RealmUserView.class)
				.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
