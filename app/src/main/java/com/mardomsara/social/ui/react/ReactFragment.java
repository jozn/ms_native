package com.mardomsara.social.ui.react;

import android.content.Context;

import com.facebook.react.BuildConfig;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.mardomsara.social.App;
import com.mardomsara.social.ui.PresenterFragment;

/**
 * Created by Hamid on 11/14/2016.
 */

public class ReactFragment extends PresenterFragment {
	private ReactRootView mReactRootView;
	private static ReactInstanceManager mReactInstanceManager;

	static {
//		initReact();
	}
	/*@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		mReactRootView = new ReactRootView(getContext());
		if(mReactInstanceManager == null){
			mReactInstanceManager = ReactInstanceManager.builder()
				.setApplication(getActivity().getApplication())
				.setBundleAssetName("index.android.bundle")
				.setJSMainModuleName("index.android")
				.addPackage(new MainReactPackage())
				.setUseDeveloperSupport(BuildConfig.DEBUG)
				.setInitialLifecycleState(LifecycleState.RESUMED)
				.build();
		}
		mReactRootView.startReactApplication(mReactInstanceManager, "HelloWorld", null);
		return (mReactRootView);
	}*/


	/*@Override
	public void onPause() {
		super.onPause();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostPause(getActivity());
		}
	}

	@Override
	 public void onResume() {
		super.onResume();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostResume(getActivity());//(), this);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (mReactInstanceManager != null) {
			mReactInstanceManager.onHostDestroy(this);
		}
	}*/


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

/*	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();*/
//	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
/*
	@Override
	public void onDestroy() {
		super.onDestroy();
	}*/

	@Override
	public void onDetach() {
		super.onDetach();
	}

	public static void initReact(){
		if(mReactInstanceManager == null){
			mReactInstanceManager = ReactInstanceManager.builder()
				.setApplication(App.getActivity().getApplication())
				.setBundleAssetName("index.android.bundle")
				.setJSMainModuleName("index.android")
				.addPackage(new MSMainReactPackage())
				.setUseDeveloperSupport(BuildConfig.DEBUG)
				.setInitialLifecycleState(LifecycleState.RESUMED)
				.build();
		}
	}
}
