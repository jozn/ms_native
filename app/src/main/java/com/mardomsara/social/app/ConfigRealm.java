package com.mardomsara.social.app;

import android.content.Context;

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


}
