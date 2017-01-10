package com.mardomsara.social.activities;

import android.content.Context;
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
import com.mardomsara.social.service.PingService;

import io.fabric.sdk.android.Fabric;
import pl.tajchert.nammu.Nammu;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//import com.mardomsara.emojicon.dep.EmojiconGridFragment;
//import com.mardomsara.emojicon.dep.EmojiconsFragment;

/**
 * Created by Hamid on 1/31/2016.
 */
public class MainAppActivity extends AppActivity{// implements DefaultHardwareBackBtnHandler {
    public static MainAppActivity instance;
    TextView st;

    boolean isFirstInited = false;

//	public static ReactInstanceManager mReactInstanceManager;

    @Override
    public void onBackPressed() {
        if( !Nav.onBackPress()){
            super.onBackPressed();
        };
//        Spinner
    }

/*
	public static void initReact(Activity activity){
		if(mReactInstanceManager == null){
			mReactInstanceManager = ReactInstanceManager.builder()
				.setApplication(activity.getApplication())
				.setBundleAssetName("index.android.bundle")
				.setJSMainModuleName("index.android")
				.addPackage(new MSMainReactPackage())
				.setUseDeveloperSupport(true)
				.setInitialLifecycleState(LifecycleState.RESUMED)
				.build();
			*/
/*mReactInstanceManager = ReactInstanceManager.builder()
				.setApplication(App.getActivity().getApplication())
				.setBundleAssetName("index.android.bundle")
				.setJSMainModuleName("index.android")
				.addPackage(new MSMainReactPackage())
				.setUseDeveloperSupport(BuildConfig.DEBUG)
				.setInitialLifecycleState(LifecycleState.RESUMED)
				.build();*//*

		}
	}
*/
    @Override
    protected void attachBaseContext(Context newBase) {
        Log.d("Calligraphy"," called");
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main_app);
        ViewGroup global_window = (ViewGroup)findViewById(R.id.global_window);
        AppUtil.global_window = global_window;

		//Important: set context to this activity not getContext(), beacuse some
		//libs like:Calligraphy and android TabLayout seems to use Acticity stuffs based on
		//context for their work
        App.init(this);//(getApplicationContext())
//        LeakCanary.install(this);
        App.activity(this);
        App.mFragmentManager = getSupportFragmentManager();
        //EventBus.getDefault().register(this);

        startService(new Intent(this, PingService.class));
        logIt("onCreate");

		///////// Nav ////////////
		ViewGroup container = (ViewGroup)findViewById(R.id.frag1);
		ViewGroup foooter = (ViewGroup)findViewById(R.id.footerbar_holder);
		Nav.setUpDefualt(container,foooter);
		Nav.setUpFooterBar();
		/////////////////////////

        Crashlytics.log("Higgs-Boson detected! Bailing out...");
        Crashlytics.getInstance().core.setUserEmail("aSa@gmail.com");
        Crashlytics.getInstance().core.setUserIdentifier("158");
        Crashlytics.getInstance().core.setUserName("AtashN");

        LifeCycle.onAppActivityStarted();

        EmojiconsPopup.setUpLayoutListnr(global_window);

//		initReact(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logIt("onStart");
//        ContextCompat.ch


//////////////////////////////////////////
//        App.init(getApplicationContext());
//        App.mFragmentManager = getSupportFragmentManager();
//        //EventBus.getDefault().register(this);
//
//        startService(new Intent(this, PingService.class));
//
//        Nav.setUpFooterBar();
//        AsyncTask?
////////////////////////////////////////

        if(isFirstInited == false){//just onCreaate
            Nav.goToBranch("chat");// must be here will c
            isFirstInited = true;// rash onCreate()
        }

        LifeCycle.onAfterAppActivityStarted();

    }

    @Override
    protected void onResume() {
        super.onResume();

		/*if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostResume(this, this);
		}*/

        logIt("onResume");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        logIt("onTrimMemory");
        Helper.showDebugMessage("onTrimMemory - leve:"+ level);
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


//    @DebugLog
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        logIt("onActivityCreated");
//        App.init(getActivity());
//    }

    public static void setMargins (View v, int l){//, int t, int r, int b) {
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
/*
		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostPause(this);
		}*/

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

		/*if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostDestroy(this);
		}*/

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
        logIt("onActivityResult :" +requestCode +" " +resultCode+ " "+data);
        Nav.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    protected void logIt(String str){
        String cls = classTag.equals("") ? getClass().getSimpleName() : classTag;
        Log.v("Activity: ",  " : "+ str);
    }
//
//    public void onEventMainThread(RoomListsTable r){
//        st.setText(r.getRoomName());
//    }
//
//    public void onEvent(RoomListsTable r){
//        st.setText(r.getRoomName());
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        AppUtil.log("called onKeyUp: "+keyCode);
        if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
            openOptionsMenu();
//            getWindow().openPanel(Window.FEATURE_OPTIONS_PANEL, null);
            Intent its = new Intent(this,PlayAdvanced.class);
            startActivity(its);
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AppUtil.log("called onKeyDown: "+keyCode);
        if(Config.IS_DEBUG && keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            Nav.push(new Play_TestsPresenter());
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

	/*//For React
	@Override
	public void invokeDefaultOnBackPressed() {
		super.onBackPressed();
	}*/

/*    @Override
    public void onEmojiconBackspaceClicked(View v) {

    }

    @Override
    public void onEmojiconClicked(Emojicon emojicon) {

    }*/
}

//
//android.app.FragmentManager fm = getFragmentManager();
//FragmentTransaction ft2= fm.beginTransaction();
//FooterBarFragment foot = new FooterBarFragment();
////            Play1Fragment f4 =  new Play1Fragment();
//ReactFragment f4 =  new ReactFragment();
//ft2.add(R.id.frag1, f4, null);
////        ft2.add(R.id.footerbar_holder, foot, null);
////        ft2.addToBackStack(null);
//
//        ft2.commit();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_app);
//        App.init(getApplicationContext());
//        App.mFragmentManager = getFragmentManager();
//        EventBus.getDefault().register(this);
//
//        st = (TextView) findViewById(R.id.status);
//
//        startService(new Intent(this, PingService.class));
//        ReactFragment f2 =  new ReactFragment();
//
//        Nav.setUpFooterBar();
//
//        Button btn = (Button)findViewById(R.id.btn1);
//        btn.setOnClickListener((v)->{
//            Nav.push(Router.getLikesPage());
//        });
//
//        MessageStoreDatabase db = DBSingletons.getInstance(this);
//        AppDatabase appDb = DBSingletons.getAppDataBase(this);
//
//        BlockedUsersTable blocked = new BlockedUsersTable();
//        blocked.setBlockedUserId(14);
//        appDb.persist(blocked);
//
//    }
