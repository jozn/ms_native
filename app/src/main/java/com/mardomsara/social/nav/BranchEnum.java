package com.mardomsara.social.nav;


import com.mardomsara.social.R;
import com.mardomsara.social.ui.pages.tabs.ActivityTabFragment;
import com.mardomsara.social.ui.pages.tabs.ChatTabFragment;
import com.mardomsara.social.ui.pages.tabs.HomeTabFragment;
import com.mardomsara.social.ui.pages.tabs.SampleTabFragment;
import com.mardomsara.social.ui.pages.tabs.ProfileTabFragment;
import com.mardomsara.social.ui.pages.tabs.SearchTabFragment;

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

	static Map<Integer, BranchEnum> map = new HashMap<>();
	int layoutId;
	String fragmentBranchTagId;

	BranchEnum(int layoutId) {
		this.layoutId = layoutId;
		fragmentBranchTagId = "branch_tag_" + layoutId;
	}

	BranchHolderFragment getNewBrangch() {
		BranchHolderFragment holerFragment = null;
		switch (this) {
			case Chat:
				holerFragment = new ChatTabFragment();
				break;
			case Home:
				holerFragment = new HomeTabFragment();
				break;
			case Search:
				holerFragment = new SearchTabFragment();
				break;
			case Activity:
				holerFragment = new ActivityTabFragment();
				break;
			case Profile:
				holerFragment = new ProfileTabFragment();
		}

		return holerFragment;
	}

}
