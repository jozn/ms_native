package com.mardomsara.social.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.X;

import java.util.List;

/**
 * Created by Hamid on 1/1/2018.
 */

public abstract class BranchHolderFragment extends PageFragment {

	X.BranchHolder branchHolder;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (branchHolder == null) {
			branchHolder = new X.BranchHolder();
			rootHolder = branchHolder.root;
		}
		return rootHolder;
	}

	public void push(PageFragment page) {
		getChildFragmentManager()
			.beginTransaction()
			.replace(R.id.child_frame_deep, page, page.getTagId())
//			.add(R.id.fg1, page, page.getTagId())
			.addToBackStack(null)
			.commit();
		Nav.alert("chil" + getChildFragmentManager().getFragments().size());

	}

	public void replace(PageFragment page) {

	}

	public boolean pop() {
		List<Fragment> list = getChildFragmentManager().getFragments();
		if (list.size() > 0) {
			boolean handled = ((PageFragment) list.get(list.size() - 1)).onBackPressed();
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
