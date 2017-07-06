package com.mardomsara.social.app;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Hamid on 7/4/2017.
 */

public class ConfigRealm {
	public static void config(Context context) {
		Realm.init(context);
		/*new RealmConfiguration.Builder()
			.deleteRealmIfMigrationNeeded()
			.build();
		Realm.getDefaultConfiguration()
			.shouldDeleteRealmIfMigrationNeeded();*/
	}

	public static Realm getInstance() {
		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
			.deleteRealmIfMigrationNeeded()
			.name("app_chats.realm")
			.build();
		return Realm.getInstance(realmConfiguration);
	}


}
