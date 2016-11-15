package com.mardomsara.social.ui.react;

import android.view.View;

import com.facebook.react.BuildConfig;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.mardomsara.social.App;
import com.mardomsara.social.activities.MainAppActivity;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.react.MSMainReactPackage;
import com.mardomsara.social.ui.react.ReactFragment;

/**
 * Created by Hamid on 2/19/2016.
 */
public  class ReactPresenter extends BasePresenter{
	private ReactRootView mReactRootView;
	private static ReactInstanceManager mReactInstanceManager;


	/*ReactFragment reactFragment;
	public ReactPresenter() {
		reactFragment= new ReactFragment();
		reactFragment.setPresenter(this);
		setFragment(reactFragment);
	}*/

	@Override
	public View buildView() {
		mReactRootView = new ReactRootView(getContext());

		mReactRootView.startReactApplication(MainAppActivity.mReactInstanceManager, "Hello", null);
		return (mReactRootView);
	}


}