package com.mardomsara.social.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;

import java.util.List;

/**
 * Created by Hamid on 1/1/2018.
 */

public abstract class BranchHolderFragment extends FragmentPage {

//	X.BranchHolder branchHolder;
	BranchTreeAutoVisibilityView holderView;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		if (holderView == null) {
			holderView = new BranchTreeAutoVisibilityView(getContext());
			rootHolder = holderView;
		}
		return rootHolder;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		log("onActivityCreated:");
		if (genView == null) {
			genView = getView(savedInstanceState);
			if (genView != null) {
				holderView.branchHolder.default_frame.addView(genView);
			}
		}
		super.onActivityCreated(savedInstanceState);
	}

	public void push(FragmentPage page) {
		getChildFragmentManager()
			.beginTransaction()
			.replace(R.id.child_frame_deep, page, page.getTagId())
//			.add(R.id.fg1, page, page.getTagId())
			.addToBackStack(null)
			.commit();
//		branchHolder.default_frame.setVisibility(View.GONE);
//		branchHolder.child_frame_deep.setVisibility(View.VISIBLE);
		Nav.alert("chil" + getChildFragmentManager().getFragments().size());

	}

	public void replace(FragmentPage page) {

	}

	public boolean pop() {
		List<Fragment> list = getChildFragmentManager().getFragments();
		if (list.size() > 0) {
			boolean handled = ((FragmentPage) list.get(list.size() - 1)).onBackPressed();
			if (handled) {
				return true;
			} else {
				return getChildFragmentManager().popBackStackImmediate();
			}
		}

		return getChildFragmentManager().popBackStackImmediate();
	}

	public void reset() {
		while (getChildFragmentManager().popBackStackImmediate()) {

		}
	}
}
