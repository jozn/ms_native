package com.mardomsara.social;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.mardomsara.x.iconify.XIconify;
import com.squareup.leakcanary.RefWatcher;

//import android.support.multidex.MultiDexApplication;

/**
 * Created by Hamid on 6/17/2016.
 */
//public class AppAplication extends MultiDexApplication  {
public class AppAplication extends Application {

    public static RefWatcher getRefWatcher(Context context) {
//        AppAplication application = (AppAplication) context.getApplicationContext();
//        return application.refWatcher;
        return refWatcher;
    }

    static RefWatcher refWatcher;

    @Override public void onCreate() {
        super.onCreate();
        Iconify
                .with(new SimpleLineIconsModule())
                .with(new IoniconsModule());

		XIconify
			.with(new com.mardomsara.x.iconify.icons.SimpleLineIconsModule())
			.with(new com.mardomsara.x.iconify.icons.IoniconsModule())
			.with(new com.mardomsara.x.iconify.icons.MaterialModule());

//        LeakCanary.install(this);
        //refWatcher = LeakCanary.install(this);
    }

	/*private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
		@Override
		protected boolean getUseDeveloperSupport() {
			return BuildConfig.DEBUG;
		}

		@Override
		protected List<ReactPackage> getPackages() {
			return Arrays.<ReactPackage>asList(
				new MSMainReactPackage()
			);
		}
	};

	@Override
	public ReactNativeHost getReactNativeHost() {
		return mReactNativeHost;
	}*/
}
