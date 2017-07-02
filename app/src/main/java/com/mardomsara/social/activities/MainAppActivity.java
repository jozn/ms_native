package com.mardomsara.social.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.mardomsara.emojicon.EmojiconsPopup;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.play.Play_TestsPresenter;
import com.mardomsara.x.iconify.XIconify;

import java.util.HashSet;
import java.util.Set;

import io.fabric.sdk.android.Fabric;
import pl.tajchert.nammu.Nammu;

/**
 * Created by Hamid on 1/31/2016.
 */
public class MainAppActivity extends AppBaseActivity {
	public static MainAppActivity instance;

	@Override
	public void onBackPressed() {
		if (!Nav.onBackPress()) {
			super.onBackPressed();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;

		setContentView(R.layout.activity_main_app);
		ViewGroup global_window = (ViewGroup) findViewById(R.id.global_window);
		AppUtil.global_window = global_window;

		//Important: set context to this activity not getContext(), beacuse some
		//libs like:Calligraphy and android TabLayout seems to use Acticity stuffs based on
		//context for their work
		App.init(this);//(getApplicationContext())
//        LeakCanary.install(this);
		App.activity(this);
		LifeCycle.initFromActivity(this);

		App.mFragmentManager = getSupportFragmentManager();
		//EventBus.getDefault().register(this);

		//////////////////// Fresco ////////////////////////
		/*Set<RequestListener> requestListeners = new HashSet<>();
		requestListeners.add(new RequestLoggingListener());
		ImagePipelineConfig config = ImagePipelineConfig.newBuilder(getApplicationContext())
			// other setters
			.setRequestListeners(requestListeners)
			.build();
		Fresco.initialize(getApplicationContext(), config);*/
		/////////////////// End of Fresco ////////////////////////

//		startService(new Intent(this, PingService.class));
		logIt("onCreate");

		///////// Nav ////////////
		ViewGroup container = (ViewGroup) findViewById(R.id.frag1);
		ViewGroup foooter = (ViewGroup) findViewById(R.id.footerbar_holder);
		Nav.setUpDefault(container, foooter);
		Nav.setUpFooterBar();
		/////////////////////////

		LifeCycle.onAppActivityStarted();

		EmojiconsPopup.setUpLayoutListnr(global_window);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Nav.reset();
	}

	//Fixme Nav.onActivityResult() must be called getDefulat
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		logIt("onActivityResult :" + requestCode + " " + resultCode + " " + data);
		Nav.onActivityResult(requestCode, resultCode, data);
	}


}