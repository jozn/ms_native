package com.mardomsara.social.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;

//import com.mardomsara.old.nav4.R;

/**
 * Created by Hamid on 1/1/2018.
 */

public class NavFooterBar extends Fragment {
	static String TAG = "NAV";

	static String FOOTER_BAR_ACTIVE_TAB ="FOOTER_BAR_ACTIVE_TAB";
	static String FOOTER_BAR_VISIBILITY ="FOOTER_BAR_VISIBILITY";

	static String FOOTER_BAR_FRAGMENT_TAG_ID = "FOOTER_BAR_FRAGMENT_TAG_ID";
	FooterBarCell footerBarCell;
	BranchEnum activeBranchEnum = BranchEnum.Search;
	BranchOrderStacks branchOrderStacks = new BranchOrderStacks();

	public NavFooterBar() {

	}

	public static NavFooterBar getDef() {
		Fragment fragment = AppState.getInstance().mainActivity.getSupportFragmentManager().findFragmentByTag(FOOTER_BAR_FRAGMENT_TAG_ID);
		NavFooterBar navFooterBar;
		if (fragment == null) {
			navFooterBar = new NavFooterBar();
			AppState.getInstance().mainActivity.getSupportFragmentManager().beginTransaction()
				.replace(AppStatic.footerbar_holder_id, navFooterBar, FOOTER_BAR_FRAGMENT_TAG_ID)
				.runOnCommit(new Runnable() {
					@Override
					public void run() {
						//Nav.goToBranch(navFooterBar.activeBranchEnum);
					}
				})
				.commit();
		} else {
			navFooterBar = (NavFooterBar) fragment;
		}
		return navFooterBar;
	}


	public static NavFooterBar setUp() {
		return getDef();
	}

	public FooterBarCell getFooterBarCell() {
		if (footerBarCell == null) {
			footerBarCell = new FooterBarCell(getActivity());
		}
		return footerBarCell;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState != null){
			activeBranchEnum = BranchEnum.valueOf(savedInstanceState.getString(FOOTER_BAR_ACTIVE_TAB));
			branchOrderStacks = BranchOrderStacks.fromBundle(savedInstanceState);
		}
		branchOrderStacks.push(activeBranchEnum);
		goToBranch(activeBranchEnum);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		return getFooterBarCell().root;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		getFooterBarCell().activateBranch(activeBranchEnum);
	}

	public void push(final PageFragment page) {
		try {
			Fragment activeBranch = getFragmentManager().findFragmentByTag(activeBranchEnum.fragmentBranchTagId);
			if (activeBranch == null) {
				Log.d(TAG, "push() activeBranch fragmet not found ");
				getFragmentManager()
					.beginTransaction()
					.replace(activeBranchEnum.layoutId, activeBranchEnum.getNewBrangch(), activeBranchEnum.fragmentBranchTagId)
					.runOnCommit(new Runnable() {
						@Override
						public void run() {
						}
					})
					.addToBackStack(null)
					.commit();

			} else {
				Log.d(TAG, "push() activeBranch fragmet found ");
				BranchHolderFragment branchHolerFragment = ((BranchHolderFragment) activeBranch);
				branchHolerFragment.push(page);

//			Log.d(TAG, "push() chiles  s" + getF)
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void replace(PageFragment page) {

	}

	public void pop() {
		onBackPressed();
	}

	public void pop(int size) {
		for (int i = 0; i < size; i++) {
			onBackPressed();
		}
	}

	public void hideFooter() {
		try {
			if(getActivity()!= null){
				getActivity().findViewById(R.id.footerbar_holder).setVisibility(View.GONE);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void showFooter() {
		try {
			if(getActivity()!= null){
				getActivity().findViewById(R.id.footerbar_holder).setVisibility(View.VISIBLE);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//todo instead of replacing just attach and detach
	public void goToBranch(BranchEnum branchEnum) {

		activeBranchEnum = branchEnum;
		branchOrderStacks.push(branchEnum);
		Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(branchEnum.fragmentBranchTagId);
		if (fragment == null) {
			Log.d(TAG, "goToBranch NULL fragment + " +branchEnum.fragmentBranchTagId);
			getActivity().getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.fg1, branchEnum.getNewBrangch(),branchEnum.fragmentBranchTagId)
				.addToBackStack(null)
				.commit();
		}else {
			Log.d(TAG, "goToBranch with fragment + " +branchEnum.fragmentBranchTagId);
			getActivity().getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.fg1, fragment,branchEnum.fragmentBranchTagId)
				.addToBackStack(null)
				.commit();
		}

		getFooterBarCell().activateBranch(branchEnum);
	}

	//Fixme: .pop() events + bug: get longcliked branced not active
	public void resetBranch(BranchEnum branch) {
		try {
			if(getBranch(branch) != null){
				getBranch(branch).reset();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(FOOTER_BAR_ACTIVE_TAB, activeBranchEnum.toString());
		if(getView() != null){
			outState.putInt(FOOTER_BAR_VISIBILITY,0);
		}
		branchOrderStacks.toBundle(outState);
	}

	public boolean onBackPressed() {
		if(getActiveBranch() == null){
			return false;
		}
		boolean hanledOfLastBranch = getActiveBranch().pop();
		if(hanledOfLastBranch){
			return true;
		}else {
			activeBranchEnum = branchOrderStacks.pop();
			activeBranchEnum = branchOrderStacks.pop();
			if(activeBranchEnum != null){
				goToBranch(activeBranchEnum);
				return true;
			}
			return false;
		}
	}

	@Nullable
	private BranchHolderFragment getActiveBranch(){
		if(getActivity() == null || activeBranchEnum == null) return null;
		Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(activeBranchEnum.fragmentBranchTagId);
		if(fragment != null){
			return  (BranchHolderFragment) fragment;
		}
		return null;
	}

	@Nullable
	private BranchHolderFragment getBranch(BranchEnum branchEnum){
		if(getActivity() == null || branchEnum == null) return null;
		Fragment fragment = getActivity().getSupportFragmentManager().findFragmentByTag(branchEnum.fragmentBranchTagId);
		if(fragment != null){
			return  (BranchHolderFragment) fragment;
		}
		return null;
	}

}
