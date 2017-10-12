package com.mardomsara.social.app;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Hamid on 7/4/2017.
 */

public class AppRealm {

	static RealmConfiguration realmChatConfiguration;

	private static RealmConfiguration getConfig() {
		if (realmChatConfiguration == null) {
			realmChatConfiguration = new RealmConfiguration.Builder()
				.deleteRealmIfMigrationNeeded()
				.name("app_chats7.realm")
				.build();
		}
		return realmChatConfiguration;
	}

	public static Realm getChatRealm() {
		return Realm.getInstance(getConfig());
	}

	public static Realm getInstance2() {
		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
			.deleteRealmIfMigrationNeeded()
			.name("app_chats.realm")
			.build();
		return Realm.getInstance(realmConfiguration);
	}


}
