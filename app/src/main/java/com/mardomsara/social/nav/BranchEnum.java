package com.mardomsara.social.nav;


import com.mardomsara.social.R;
import com.mardomsara.social.ui.pages.tabs.HomeTabPageFragment;
import com.mardomsara.social.ui.pages.tabs.SampleTabPageFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 1/9/2017.
 */

public enum BranchEnum {
	Chat(R.id.holder_chat),
	Home(R.id.holder_home),
	Search(R.id.holder_search),
	Activity(R.id.holder_activity),
	Profile(R.id.holder_profile);

	int layoutId;
	String fragmentBranchTagId;
	static Map<Integer,BranchEnum> map = new HashMap<>();
	BranchEnum(int layoutId) {
		this.layoutId = layoutId;
		fragmentBranchTagId = "branch_tag_"+layoutId;
	}

	BranchHolderFragment getNewBrangch() {
		BranchHolderFragment holerFragment = null;
		switch (this) {
			case Chat:
				holerFragment = new HomeBranch();
				break;
			case Home:
				holerFragment = new HomeBranch();
				break;
			case Search:
//				holerFragment = new HomeBranch();
				holerFragment = new SampleTabPageFragment();
				break;
			case Activity:
				holerFragment = new HomeTabPageFragment();
				break;
			case Profile:
				holerFragment = new HomeBranch();
		}

		return holerFragment;
	}

}
