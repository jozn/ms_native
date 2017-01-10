package com.mardomsara.social;

//import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.ui.fragments.FooterBarFragment;
import com.mardomsara.social.ui.ui.FooterBarCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import hugo.weaving.DebugLog;

/**
 * Created by Hamid on 1/30/2016.
 */
public class Nav {

	public Nav() {

	}

	public static void setUp(ViewGroup containerFrame,ViewGroup footerFrame) {
		defaultTree = new NavTree(containerFrame,footerFrame);
	}

	public static NavTree getDefaultTree() {
		return defaultTree;
	}

	static NavTree defaultTree;

    public static void push(PresenterPage page){
		getDefaultTree().push(page);
    }

    public static void pop() {
		getDefaultTree().onBackPress();
    }

    public static void pop(int size) {
		getDefaultTree().pop(size);
    }

    public static void hideFooter(){
		getDefaultTree().hideFooter();
    }

    public static void showFooter(){
		getDefaultTree().showFooter();
    }

    @DebugLog
    public static void goToBranch(Branch bra) {
		getDefaultTree().goToBranch(bra);
    }

	@Deprecated
	public static void goToBranch(String bra) {
		getDefaultTree().goToBranch(Branch.Chat);
	}

    @DebugLog
    public static void  _attachPage2(PresenterPage frag){

    }

    public static void detachaLstOne(){

    }

    //Fixme: .pop() events + bug: get longcliked branced not active
    public static void resetBranch(Branch branch) {
		getDefaultTree().resetBranch(branch);
    }


    //returns means: true Nav handeld - activit don't do anything --- false: we didn't handle activity handle it
    public static boolean onBackPress() {
		return getDefaultTree().onBackPress();
    }


    public static void addCustomOnBackPressHandler(OnBackPressHandler handler) {
		getDefaultTree().customOnBackPressHandler.add(handler);
    }

    public static void removeCustomOnBackPressHandler(OnBackPressHandler handler) {
		getDefaultTree().customOnBackPressHandler.remove(handler);
    }

	public static void setUpFooetrBar() {
		getDefaultTree().setUpFooetrBar();
	}

	public static class FooterBar extends Fragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

    }

    public static void reset(){
		getDefaultTree().reset();
    }

    public static void onActivityResult(int requestCode, int resultCode, Intent data){
		getDefaultTree().onActivityResult(requestCode, resultCode, data);
    }

    public interface OnBackPressHandler{
        boolean handle();
    }






	///////////////////////////////////////////////////
	////////////////////////////////////////////////////
	///////////////////////////////////////////////////

	public static class BranchCell {
		public Stack<PresenterPage> pageStacks = new Stack<>();//all contents hsbeen attched so we can call attach/deattach
		public Branch name;
		public PresenterPage defaultPage;

		void setDefaultPage(PresenterPage defaultPage){
			this.defaultPage = defaultPage;
			pageStacks.add(0,defaultPage);
		}
	}

	//used for ordering backstack of active branches
	static class BranchOrderStacks {
		Set<String> branchSet = new LinkedHashSet<>();
		static List<Branch> branchList = new ArrayList<>();

		public static void push(Branch bra) {
			branchList.remove(bra);//remove older
			branchList.add(bra); //apend
		}

		@Nullable
		public static Branch peek() {
			Branch res = null;
			if (branchList.size()>0){
				res = branchList.get(branchList.size()-1);
			}
			return res;
		}

		@Nullable
		public static Branch pop() {
			int size = branchList.size();
			Branch res = null;
			if (size > 0) {
				res = branchList.get(size - 1);
				branchList.remove(size - 1);
			}
			return res;
		}
	}


	static void setDefultBranc(Map<Branch,BranchCell> branchMapHolder){
		for (Branch b : Branch.values()){
			BranchCell cell = new BranchCell();
			cell.name = b;
			switch (b){
				case Chat:
//					cell.setDefaultPage(Router.getChatPage());
					cell.setDefaultPage(Router.getFollowingsPage(2));
					break;
				case Home:
					cell.setDefaultPage(Router.getHomePage());
					break;
				case Search:
					cell.setDefaultPage(Router.getSearchPage());
					break;
				case Activity:
					cell.setDefaultPage(Router.getAactivityPage());
					break;
				case Profile:
					cell.setDefaultPage(Router.getMyProfile());
					break;
			}
			branchMapHolder.put(b,cell);
		}
	}

	static class NavTree {
		static String TAG = "Nav";
		int MAX_BRANCH_STACKE_SIZE = 10;

		PresenterPage lastPage;
		Map<Branch,BranchCell> branchMapHolder = new HashMap<>();
		FooterBarFragment footFrag;
		private static List<OnBackPressHandler> customOnBackPressHandler = new ArrayList();
		Branch activeBranch = Branch.Chat;
		ViewGroup containerFrame;
		ViewGroup footerFrame;

		public NavTree(ViewGroup containerFrame,ViewGroup footerFrame) {
			Nav.setDefultBranc(branchMapHolder);
			this.containerFrame = containerFrame;
			this.footerFrame = footerFrame;
		}

		//todo pagelimits
		public void push(PresenterPage frag){
			_getActiveBranchCell().pageStacks.add(frag);
			if (getContainerFrame().getChildCount()>0){
				getContainerFrame().removeViewAt(0);
			}
			getContainerFrame().addView(frag.getFinalView(containerFrame));
//			getContainerFrame().addView(frag.getFinalView());
		}

		public void pop() {
			//stay on branch
			if (_getActiveBranchCell().pageStacks.size()>1){
				getContainerFrame().removeView(_getActiveBranchCell().pageStacks.pop().getFinalView(containerFrame));
			}
			//go to another branch
		}

		public void pop(int size) {

		}

		public void hideFooter(){
			footerFrame.setVisibility(View.GONE);
		}

		public void showFooter(){
			footerFrame.setVisibility(View.VISIBLE);
		}

		public void goToBranch(Branch bra) {
//			push(Router.getFollowingsPage(2));
			if (getContainerFrame().getChildCount()>0){
				getContainerFrame().removeViewAt(0);
			}
			activeBranch = bra;
			getContainerFrame().addView(_getActiveBranchCell().pageStacks.get(_getActiveBranchCell().pageStacks.size()-1).getFinalView(containerFrame));
		}

		@DebugLog
		public void  _attachPage2(PresenterPage frag){

		}

		public void detachaLstOne(){

		}

		ViewGroup getContainerFrame(){
			return containerFrame;
		}

		//Fixme: .pop() events + bug: get longcliked branced not active
		public void resetBranch(Branch branch) {

		}

		@DebugLog
		public void setUpFooetrBar(){
			FooterBarCell footFrag = new FooterBarCell(footerFrame);
			footerFrame.addView(footFrag.getRoot());

		}

		//returns means: true Nav handeld - activit don't do anything --- false: we didn't handle activity handle it
		public boolean onBackPress() {
			return false;
		}
		static void  removePageFromGlobaFragment(PresenterPage fp){

		}

		public void addCustomOnBackPressHandler(OnBackPressHandler handler) {

		}

		public void removeCustomOnBackPressHandler(OnBackPressHandler handler) {

		}

		private Nav.BranchCell _getActiveBranchCell(){
			return branchMapHolder.get(activeBranch);
		}


		static void setDefultBranc(){

		}

		public void reset(){

		}

		public void onActivityResult(int requestCode, int resultCode, Intent data){

		}

	}
}
