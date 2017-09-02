package com.mardomsara.social.app;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Hamid on 7/4/2017.
 */

public class MSRealm {
	static RealmConfiguration realmChatConfiguration = new RealmConfiguration.Builder()
		.deleteRealmIfMigrationNeeded()
		.name("app_chats.realm")
		.build();

	public static Realm getChatRealm() {
		return Realm.getInstance(realmChatConfiguration);
	}

	public static Realm getInstance2() {
		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
			.deleteRealmIfMigrationNeeded()
			.name("app_chats.realm")
			.build();
		return Realm.getInstance(realmConfiguration);
	}


}
