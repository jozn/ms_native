package com.mardomsara.social.nav;

import android.widget.Toast;

/**
 * Created by Hamid on 1/1/2018.
 */

public class Nav {

	static NavFooterBar getDefaultFooter() {
		return NavFooterBar.getDef();
	}

	public static void setUpDef() {
		if (getDefaultFooter() == null) {
			NavFooterBar.setUp();
		}
	}

	///////////////// Statics /////////////
	public static void push(PageFragment page) {
		getDefaultFooter().push(page);
	}

	public static void replace(PageFragment page) {
		getDefaultFooter().replace(page);
	}

	public static void pop() {
		getDefaultFooter().pop();
	}

	public static void pop(int size) {
		getDefaultFooter().pop(size);
	}

	public static void hideFooter() {
		getDefaultFooter().hideFooter();
	}

	public static void showFooter() {
		getDefaultFooter().showFooter();
	}

	public static boolean onBackPressed() {
		return getDefaultFooter().onBackPressed();
	}

	public static void goToBranch(BranchEnum branchEnum) {
		getDefaultFooter().goToBranch(branchEnum);
	}


	//Fixme: .pop() events + bug: get longcliked branced not active
	public static void resetBranch(BranchEnum branch) {
		getDefaultFooter().resetBranch(branch);
	}

	static void alert(String s){
		Toast.makeText(AppState.getInstance().mainActivity,s,Toast.LENGTH_SHORT).show();
	}

}
