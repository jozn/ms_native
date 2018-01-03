package com.mardomsara.social.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.mardomsara.emojicon.EmojiconsPopup;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.R;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.helpers.AppUtil;

/**
 * Created by Hamid on 1/31/2016.
 */
public class MainAppActivity extends AppBaseActivity {
	public static MainAppActivity instance;

	@Override
	public void onBackPressed() {
		if (!Nav_DEP.onBackPress()) {
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

		///////// Nav ////////////
		ViewGroup container = (ViewGroup) findViewById(R.id.frag1);
		ViewGroup foooter = (ViewGroup) findViewById(R.id.footerbar_holder);
		Nav_DEP.setUpDefault(container, foooter);
		Nav_DEP.setUpFooterBar();
		/////////////////////////

		LifeCycle.onAppActivityStarted();

		EmojiconsPopup.setUpLayoutListnr(global_window);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Nav_DEP.reset();
	}

	//Fixme Nav.onActivityResult() must be called getDefulat
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		logIt("onActivityResult :" + requestCode + " " + resultCode + " " + data);
		Nav_DEP.onActivityResult(requestCode, resultCode, data);
	}


}