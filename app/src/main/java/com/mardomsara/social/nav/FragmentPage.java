package com.mardomsara.social.nav;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.X;

public abstract class FragmentPage extends Fragment {
	private static final String TAG = "PageFragment";
	static int counter = 0;

	X.Framelayout xFramelayout;
	ViewGroup rootHolder;
	View genView;
	String tagId = "";

	public FragmentPage() {
		tagId = "tagId_" + counter;
		counter++;
	}

	public abstract View getView(Bundle savedInstanceState);

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		log("onAttach");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		log("onDetach");
	}

	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//		return new X.FragmentPages_DefaultParent(getActivity(),null).rootHolder;
		if (xFramelayout == null) {
			xFramelayout = new X.Framelayout();
			rootHolder = xFramelayout.root;
		}
		return rootHolder;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		log("onActivityCreated:");
		if (genView == null) {
			genView = getView(savedInstanceState);
			if (genView != null) {
				rootHolder.addView(genView);
			}
		}
	}


	boolean onBackPressed() {
		log("onBackPressed");
		return false;
	}

	public String getTagId() {
		return tagId;
	}

	///////////////////// just loggers /////////////////

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		log("onCreate");
	}

	@Override
	public void onStart() {
		super.onStart();
		log("onStart");
	}

	@Override
	public void onPause() {
		super.onPause();
		log("onPause");


	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		log("onSaveInstanceState:");

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		log("onViewCreated:");
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		log("onActivityResult:");
	}

	@Override
	public void onAttachFragment(Fragment childFragment) {
		super.onAttachFragment(childFragment);
		log("onAttachFragment:");
	}

	@Override
	public void onResume() {
		super.onResume();
		log("onResume:");
	}

	@Override
	public void onStop() {
		super.onStop();
		log("onStop:");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		log("onLowMemory:");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		log("onDestroyView:");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		log("onDestroy:");
	}

	void log(String m) {
		Log.d(TAG, "" + m + " " + tagId);
	}

	//just called during Nav changes pages
	/*abstract void onInit();
	abstract void onFocus();
	abstract void onBack();
    abstract void onBlur();
    abstract void onDestroy55();
//    void onKeyDown();
	abstract boolean isInitiated();
    abstract void onActivityResult55(int requestCode, int resultCode, Intent data);

	//abstract View getFinalView(ViewGroup parent);*/
}
