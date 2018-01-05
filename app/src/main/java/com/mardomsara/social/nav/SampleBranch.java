package com.mardomsara.social.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mardomsara.social.R;

import java.util.Random;

/**
 * Created by Hamid on 1/1/2018.
 */

public class SampleBranch extends BranchHolderFragment {
	static int C = 0;
	int col = new Random().nextInt();
	int i = 0;

	public SampleBranch() {
		Log.d("NAV", "HomeBranch on instance");
	}

	@Override
	public View getView(Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.branch_holder, null);

		if (savedInstanceState != null) {
			col = savedInstanceState.getInt("c");
			i = savedInstanceState.getInt("i");
		}
		if (i == 0) i = C++;
		Log.d("NAV", "HomeBranch on create");
		((TextView) view.findViewById(R.id.button3)).setText("" + i);
		view.setBackgroundColor(col);
		Log.d("NAV", "home oncreat " + savedInstanceState);
		return view;
	}

	/*@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.branch_holder, null);

		if (savedInstanceState != null) {
			col = savedInstanceState.getInt("c");
			i = savedInstanceState.getInt("i");
		}
		if (i == 0) i = C++;
		Log.d("NAV", "HomeBranch on create");
		((TextView) view.findViewById(R.id.button3)).setText("" + i);
		view.setBackgroundColor(col);
		Log.d("NAV", "home oncreat " + savedInstanceState);
		return view;
	}*/

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("c", col);
		outState.putInt("i", i);
	}
}
