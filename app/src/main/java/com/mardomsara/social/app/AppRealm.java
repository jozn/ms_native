package com.mardomsara.social.app;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.exceptions.RealmMigrationNeededException;

/**
 * Created by Hamid on 7/4/2017.
 */

public class AppRealm {

	private static RealmConfiguration realmChatConfiguration;

	private static RealmConfiguration getConfig() {
		if (realmChatConfiguration == null) {
			realmChatConfiguration = new RealmConfiguration.Builder()
				.deleteRealmIfMigrationNeeded()
				.name("app_chats17.realm")
				.build();
		}
		return realmChatConfiguration;
	}

	public static Realm getChatRealm() {
		Realm realm = null;
		try{
			realm = Realm.getInstance(getConfig());
		}catch (RealmMigrationNeededException e){
			throw e;
		}
		return realm;
	}

	public static Realm getInstance2() {
		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
			.deleteRealmIfMigrationNeeded()
			.name("app_chats.realm")
			.build();
		return Realm.getInstance(realmConfiguration);
	}


}
