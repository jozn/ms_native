package com.mardomsara.social.nav;


import com.mardomsara.social.R;

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
		BranchHolderFragment holerFragment;
		switch (this) {
			case Chat:
				holerFragment = new HomeBranch();
			case Home:
				holerFragment = new HomeBranch();
			case Search:
				holerFragment = new HomeBranch();
			case Activity:
				holerFragment = new HomeBranch();
			default:
				holerFragment = new HomeBranch();
		}

		return holerFragment;
	}

}
