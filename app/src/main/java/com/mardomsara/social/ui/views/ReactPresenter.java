package com.mardomsara.social.ui.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.react.BuildConfig;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.shell.MainReactPackage;
import com.mardomsara.social.FragmentPage;
import com.mardomsara.social.app.Singletons;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.PresenterFragment;
import com.mardomsara.social.ui.SinglePresenterFragment;
import com.mardomsara.social.ui.react.MSMainReactPackage;
import com.mardomsara.social.ui.react.ReactFragment;

/**
 * Created by Hamid on 2/19/2016.
 */
public  class ReactPresenter extends BasePresenter{
	private ReactRootView mReactRootView;
	private static ReactInstanceManager mReactInstanceManager;

	ReactFragment reactFragment;
	public ReactPresenter() {
		reactFragment= new ReactFragment();
		reactFragment.setPresenter(this);
		setFragment(reactFragment);
	}

	@Override
	public View buildView() {
		mReactRootView = new ReactRootView(getContext());
		if(mReactInstanceManager == null){
			mReactInstanceManager = ReactInstanceManager.builder()
				.setApplication(getActivity().getApplication())
				.setBundleAssetName("index.android.bundle")
				.setJSMainModuleName("index.android")
				.addPackage(new MSMainReactPackage())
				.setUseDeveloperSupport(BuildConfig.DEBUG)
				.setInitialLifecycleState(LifecycleState.RESUMED)
				.build();
		}
		mReactRootView.startReactApplication(mReactInstanceManager, "HelloWorld", null);
		return (mReactRootView);
	}
}