package com.mardomsara.social.nav;

import android.support.v4.app.Fragment;

import com.mardomsara.social.R;

import java.util.List;

/**
 * Created by Hamid on 1/1/2018.
 */

public class BranchHolderFragment extends PageFragment {

	public void push(PageFragment page) {
		getChildFragmentManager()
			.beginTransaction()
			.add(R.id.child_frame_deep, page, page.getTagId())
			.addToBackStack(null)
			.commit();
		Nav.alert("chil" + getChildFragmentManager().getFragments().size());

	}

	public void replace(PageFragment page) {

	}

	public boolean pop() {
		List<Fragment> list =getChildFragmentManager().getFragments();
		if(list.size() > 0){
			boolean handled = ((PageFragment)list.get(list.size()-1)).onBackPressed();
			if(handled){
				return true;
			}else {
				return getChildFragmentManager().popBackStackImmediate();
			}
		}

		return getChildFragmentManager().popBackStackImmediate();
	}

	public void reset() {
		while (getChildFragmentManager().popBackStackImmediate()){

		}
	}
}
