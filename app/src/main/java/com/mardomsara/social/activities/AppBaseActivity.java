package com.mardomsara.social.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.app.memory.TrimMemory;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models.realm_play.RealmPlay;
import com.mardomsara.social.play.Play_TestsPresenter;

import pl.tajchert.nammu.Nammu;

/**
 * Created by Hamid on 1/27/2016.
 */
public abstract class AppBaseActivity extends AppCompatActivity {

	boolean isFirstInited = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//        App.context = getApplicationContext();
		logIt("onCreate");
		App.init(getApplicationContext());
		LifeCycle.initFromActivity(getApplicationContext());
		//ConfigStetho.config(this);
		RealmPlay.play();
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
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		logIt("onSaveInstanceState");
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
	protected void onResume() {
		super.onResume();

		logIt("onResume");
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		logIt("onTrimMemory");
		Helper.showDebugMessage("onTrimMemory - level:" + level);
		TrimMemory.trimFromActivities(level);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		logIt("onLowMemory");
		Helper.showDebugMessage("onLowMemory");
		TrimMemory.trimLow();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		logIt("onDestroy");
	}

	protected void logIt(String str) {
		String cls = getClass().getSimpleName();
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


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

}
