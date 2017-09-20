package com.mardomsara.social.app.stetho;

import android.content.Context;
import android.os.Environment;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import okhttp3.OkHttpClient;

/**
 * Created by Hamid on 7/4/2017.
 */

public class ConfigStetho {

	public static void config(Context context){

		RealmInspectorModulesProvider provider = RealmInspectorModulesProvider.builder(context)
			.withFolder(context.getFilesDir())
//			.withEncryptionKey("encrypted.realm", key)
			.withMetaTables()
			.withDescendingOrder()
			.withLimit(1000)
			.databaseNamePattern(Pattern.compile(".+\\.realm"))
			.build();

		new OkHttpClient.Builder()
			.addNetworkInterceptor(new StethoInterceptor())
			.build();

		Stetho.initialize(
			Stetho.newInitializerBuilder(context)
				.enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
//				.enableWebKitInspector(RealmInspectorModulesProvider.builder(context).build())
				.enableWebKitInspector(provider)
				.build());
	}
}
