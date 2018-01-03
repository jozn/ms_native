package com.mardomsara.social.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class BranchOrderStacks {
	List<BranchEnum> branchList = new ArrayList<>();

	void push(BranchEnum bra) {
		branchList.remove(bra);//remove older
		branchList.add(bra); //apend
	}

	@Nullable
	BranchEnum peek() {
		BranchEnum res = null;
		if (branchList.size() > 0) {
			res = branchList.get(branchList.size() - 1);
		}
		return res;
	}

	@Nullable
	BranchEnum pop() {
		int size = branchList.size();
		BranchEnum res = null;
		if (size > 0) {
			res = branchList.get(size - 1);
			branchList.remove(size - 1);
		}
		return res;
	}

	int size(){
		return branchList.size();
	}
	static String BUNDLE_LIST_BRANCHES = "BUNDLE_LIST_BRANCHES";

	void toBundle(Bundle save){
		ArrayList<String> list = new ArrayList<>();
		for (BranchEnum branch : branchList){
			list.add(branch.toString());
		}
		save.putStringArrayList(BUNDLE_LIST_BRANCHES,list);
	}

	static BranchOrderStacks fromBundle(Bundle bundle){
		BranchOrderStacks branchOrderStacks = new BranchOrderStacks();
		if(bundle != null && bundle.getStringArrayList(BUNDLE_LIST_BRANCHES) != null){
			for (String enumVal: bundle.getStringArrayList(BUNDLE_LIST_BRANCHES)){
				branchOrderStacks.push(BranchEnum.valueOf(enumVal));
			}
		}
		return branchOrderStacks;
	}

}
