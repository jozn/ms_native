package com.mardomsara.social.app;

import android.content.Context;
import android.content.Intent;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.facebook.common.logging.FLog;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.mardomsara.social.App;
import com.mardomsara.social.BuildConfig;
import com.mardomsara.social.app.fresco.FrescoConfig;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_old.NotifyModel;
import com.mardomsara.social.models_old.stores.Store;
import com.mardomsara.social.models_old.syncer.ContactsCopySyncer;
import com.mardomsara.social.models_old.syncer.UserSyncer;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.play.Play_RunOnStart;
import com.mardomsara.social.service.BackgroundService;
import com.mardomsara.x.iconify.XIconify;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import io.fabric.sdk.android.Fabric;
import pl.tajchert.nammu.Nammu;

/**
 * Created by Hamid on 7/2/2016.
 */
public class LifeCycle {

	static boolean _afterActivityCalled = false;
	static boolean _afterCalled = false;
	private static boolean isActivitesInited = false;
	private static boolean isInitialized = false;

	public static void initFromActivity(Context context) {
		if (isActivitesInited) return;
		initCommon(context);
		if (true) {
			Intent i = new Intent(context, BackgroundService.class);
			context.startService(i);
		}


		Iconify
			.with(new SimpleLineIconsModule())
			.with(new IoniconsModule());

		XIconify
			.with(new com.mardomsara.x.iconify.icons.SimpleLineIconsModule())
			.with(new com.mardomsara.x.iconify.icons.IoniconsModule())
			.with(new com.mardomsara.x.iconify.icons.MaterialModule());


		// Initializes Fabric for builds that don't use the debug build type.
		Crashlytics crashlyticsKit = new Crashlytics.Builder()
			.core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
			.build();

		Fabric.with(context, crashlyticsKit);

		FrescoConfig.init(context);
		ConfigRealm.config(context);

		Crashlytics.log("Higgs-Boson detected! Bailing out...");
		Crashlytics.getInstance().core.setUserEmail("aSa@gmail.com");
		Crashlytics.getInstance().core.setUserIdentifier("158");
		Crashlytics.getInstance().core.setUserName("AtashN 25k s");

		Play_RunOnStart.run();
	}

	public static void initFromBackground(Context ctx) {
		initCommon(ctx);
		AppUtil.setContext(ctx);
		onAfterAppStartedCommon();
	}

	public static void initCommon(Context ctx) {
		AppUtil.setContext(ctx);
		App.context = ctx;

		//init SHared Prefrences
		Store.init(ctx, "store");

		//////

		if (isInitialized == false) {
			isInitialized = true;
			//////////////////////////////////////////
			Picasso p = new Picasso.Builder(ctx)
				.memoryCache(new LruCache(100000000))
				.build();
			Picasso.setSingletonInstance(p);
//         Picasso.with(AppUtil.getContext()).setIndicatorsEnabled(true);
			Picasso.with(AppUtil.getContext()).setLoggingEnabled(true);
			/////////////////////////////////////////

			Nammu.init(ctx);
/*            Set<RequestListener> requestListeners = new HashSet<>();
			requestListeners.add(new RequestLoggingListener());*/
			/*ImagePipelineConfig config = ImagePipelineConfig.newBuilder(ctx)
                    // other setters
                    .setRequestListeners(requestListeners)
                    .build();
            Fresco.initialize(ctx, config);*/
			FLog.setMinimumLoggingLevel(FLog.VERBOSE);
//         LeakCanary.install(ctx);

//			BasePresenter.context = ctx;
//            BasePresenter.inflater = LayoutInflater.from(ctx);

//			DB.init();

		}
	}

	public static void onAppActivityStarted() {
//        Sync.syncAllFollowings();
//        Sync.checkSyncContacts();
//        Sync.syncAllFollowings();

		AndroidUtil.runInBackgroundNoPanic(() -> NotifyModel.loadFromServer(false));
	}

	public static void onAfterAppActivityStarted() {
		if (_afterActivityCalled) return;

		onAfterAppStartedCommon();

		ContactsCopySyncer.checkChangesAndSyncToServer_BG();
		UserSyncer.syncChangedUser_BG();

		_afterActivityCalled = true;
	}

	public static void onAfterAppStartedCommon() {
		if (_afterCalled) return;
		//////////////
		AppFiles.buildAllDirs();
		//////////////
//		Pipe_OLD.sendCall("Echo","",null,null);

//		PlayNewPipe.run1();

        /*Command cmd = new Command();
        cmd.Name = "Echo";
        WS_DEP.sendCommand(cmd);*/
		Session.fetchUserInfoFromServer();
		/////////////
		_afterCalled = true;
	}


	public static void onAppActivityStartedNowHttpConnected() {

	}

	public static void onAppActivityStartedNowWebsocketConnected() {

	}

	public static void onAppBackgroundStarted() {


	}


}
