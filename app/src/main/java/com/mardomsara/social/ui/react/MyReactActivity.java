package com.mardomsara.social.ui.react;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.react.BuildConfig;
//import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class MyReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
	private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MSMainReactPackage())
                .setUseDeveloperSupport(true)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "Hello", null);

        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }


	@Override
	protected void onPause() {
		super.onPause();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostPause(this);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostResume(this, this);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostDestroy(this);
		}
	}



	/*@Override
	protected void onPause() {
		super.onPause();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onPause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onResume( this, this );
		}
	}

	@Override
	public void onBackPressed() {
		if (mReactInstanceManager != null) {
			mReactInstanceManager.onBackPressed();
		} else {
			super.onBackPressed();
		}
	}*/

}