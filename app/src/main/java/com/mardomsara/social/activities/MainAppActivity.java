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
import com.mardomsara.emojicon.EmojiconsPopup;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.play.Play_TestsPresenter;

import io.fabric.sdk.android.Fabric;
import pl.tajchert.nammu.Nammu;

/**
 * Created by Hamid on 1/31/2016.
 */
public class MainAppActivity extends AppActivity {
	public static MainAppActivity instance;
	TextView st;

	boolean isFirstInited = false;


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
		Fabric.with(this, new Crashlytics());

		setContentView(R.layout.activity_main_app);
		ViewGroup global_window = (ViewGroup) findViewById(R.id.global_window);
		AppUtil.global_window = global_window;

		//Important: set context to this activity not getContext(), beacuse some
		//libs like:Calligraphy and android TabLayout seems to use Acticity stuffs based on
		//context for their work
		App.init(this);//(getApplicationContext())
//        LeakCanary.install(this);
		App.activity(this);
		App.mFragmentManager = getSupportFragmentManager();
		//EventBus.getDefault().register(this);

//		startService(new Intent(this, PingService.class));
		logIt("onCreate");

		///////// Nav ////////////
		ViewGroup container = (ViewGroup) findViewById(R.id.frag1);
		ViewGroup foooter = (ViewGroup) findViewById(R.id.footerbar_holder);
		Nav.setUpDefault(container, foooter);
		Nav.setUpFooterBar();
		/////////////////////////

		Crashlytics.log("Higgs-Boson detected! Bailing out...");
		Crashlytics.getInstance().core.setUserEmail("aSa@gmail.com");
		Crashlytics.getInstance().core.setUserIdentifier("158");
		Crashlytics.getInstance().core.setUserName("AtashN");

		LifeCycle.onAppActivityStarted();

		EmojiconsPopup.setUpLayoutListnr(global_window);

	}

	@Override
	protected void onStart() {
		super.onStart();
		logIt("onStart");

		if (isFirstInited == false) {//just onCreaate
			Nav.goToBranch("chat");// must be here will c
			isFirstInited = true;// rash onCreate()
		}

		LifeCycle.onAfterAppActivityStarted();

	}

	@Override
	protected void onResume() {
		super.onResume();

		logIt("onResume");
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		logIt("onTrimMemory");
		Helper.showDebugMessage("onTrimMemory - leve:" + level);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		logIt("onLowMemory");
		Helper.showDebugMessage("onLowMemory");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	String classTag = "";

	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}

	public static void setMargins(View v, int l) {//, int t, int r, int b) {
		if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
			ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
			p.setMargins(l, 0, 0, 0);
			v.requestLayout();
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		logIt("onSaveInstanceState");
	}

	@Override
	public void onPause() {
		super.onPause();

		logIt("onPause");
	}

	@Override
	public void onStop() {
		super.onStop();
		logIt("onStop");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		logIt("onConfigurationChanged");
	}


	@Override
	public void onDestroy() {
		super.onDestroy();

		logIt("onDestroy");
		Nav.reset();
	}

	@Override
	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		logIt("onPostCreate");
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		logIt("onPostResume");
	}

	@Override
	public void onSupportActionModeStarted(ActionMode mode) {
		super.onSupportActionModeStarted(mode);
		logIt("onSupportActionModeStarted");
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		logIt("onContentChanged");
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		logIt("onAttachFragment");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		logIt("onRestoreInstanceState");
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onRestoreInstanceState(savedInstanceState, persistentState);
		logIt("onRestoreInstanceState");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		logIt("onRestart");
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		logIt("onAttachedToWindow");
	}

	@Override
	public void onSupportActionModeFinished(ActionMode mode) {
		super.onSupportActionModeFinished(mode);
		logIt("onSupportActionModeFinished");
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		logIt("onActivityResult :" + requestCode + " " + resultCode + " " + data);
		Nav.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	protected void logIt(String str) {
		String cls = classTag.equals("") ? getClass().getSimpleName() : classTag;
		Log.v("Activity: ", " : " + str);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		AppUtil.log("called onKeyDown: " + keyCode);
		if (Config.IS_DEBUG && keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			Nav.push(new Play_TestsPresenter());
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}