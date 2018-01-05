package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.nav.BranchHolderFragment;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 1/4/2018.
 */

public class SampleTabFragment extends BranchHolderFragment {
	X.HelloWorldRow x;

	@Override
	public View getView(Bundle savedInstanceState) {
		x = new X.HelloWorldRow(getActivity(),null);
		return x.root;
	}


//	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////		return super.onCreateView(inflater, container, savedInstanceState);
//		x = new X.HelloWorldRow(getActivity(),null);
//		return x.root;
//	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		x.btn.setText("BBBBBBBBBBBBBBBBBBBBBB");

	}
}
