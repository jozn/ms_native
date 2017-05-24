package com.mardomsara.social;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.Helper;
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

	static NavTree defaultTree;
	public static void setUpDefault(ViewGroup containerFrame, ViewGroup footerFrame) {
		defaultTree = new NavTree(containerFrame,footerFrame);
	}

	public static NavTree getDefaultTree() {
		return defaultTree;
	}

    public static void push(PresenterPage page){
		getDefaultTree().push(page);
    }

	public static void replace(PresenterPage page){
		getDefaultTree().replace(page);
	}

    public static void pop() {
		getDefaultTree().pop();
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

    public static void goToBranch(Branch bra) {
		getDefaultTree().goToBranch(bra);
    }

	@Deprecated
	public static void goToBranch(String bra) {
		getDefaultTree().goToBranch(Branch.Chat);
	}

    //Fixme: .pop() events + bug: get longcliked branced not active
    public static void resetBranch(Branch branch) {
		getDefaultTree().resetBranch(branch);
    }

    //returns means: true Nav handeld - activit don't do anything --- false: we didn't handlePushes activity handlePushes it
    public static boolean onBackPress() {
		return getDefaultTree().onBackPress();
    }

    public static void addCustomOnBackPressHandler(OnBackPressHandler handler) {
		getDefaultTree().addCustomOnBackPressHandler(handler);
    }

    public static void removeCustomOnBackPressHandler(OnBackPressHandler handler) {
		getDefaultTree().removeCustomOnBackPressHandler(handler);
    }

	public static void setUpFooterBar() {
		getDefaultTree().setUpFooterBar();
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

	////////////// Implementation /////////////

	public static class BranchCell {
		public Stack<PresenterPage> pageStacks = new Stack<>();//all contents hsbeen attched so we can call attach/deattach
		public Branch name;
		public PresenterPage defaultPage;

		void setDefaultPage(PresenterPage defaultPage){
			this.defaultPage = defaultPage;
			pageStacks.add(0,defaultPage);
		}

		PresenterPage popPage(){
			PresenterPage page = pageStacks.get(pageStacks.size()-1);
			page.onBlur();
			page.onDestroy();
			return page;
		}

		PresenterPage getLastPage(){
			PresenterPage page = pageStacks.get(pageStacks.size()-1);
			return page;
		}

	}

	//used for ordering backstack of active branches
	static class BranchOrderStacks {
		Set<String> branchSet = new LinkedHashSet<>();
		List<Branch> branchList = new ArrayList<>();

		public void push(Branch bra) {
			branchList.remove(bra);//remove older
			branchList.add(bra); //apend
		}

		@Nullable
		public Branch peek() {
			Branch res = null;
			if (branchList.size()>0){
				res = branchList.get(branchList.size()-1);
			}
			return res;
		}

		@Nullable
		public Branch pop() {
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
					cell.setDefaultPage(Router.getChatTab());
					break;
				case Home:
					cell.setDefaultPage(Router.getHomeTab());
					break;
				case Search:
					cell.setDefaultPage(Router.getSearchTab());
					break;
				case Activity:
					cell.setDefaultPage(Router.getActivityTab());
					break;
				case Profile:
					cell.setDefaultPage(Router.getProfileTab());
					break;
			}
			branchMapHolder.put(b,cell);
		}
	}

	static class NavTree {
		static String TAG = "Nav";
		int MAX_BRANCH_STACKE_SIZE = 8;

		Map<Branch,BranchCell> branchMapHolder = new HashMap<>();

		private List<OnBackPressHandler> customOnBackPressHandler = new ArrayList();
		BranchOrderStacks branchOrderStacks = new BranchOrderStacks();
		Branch activeBranch = Branch.Chat;
		ViewGroup containerFrame;
		ViewGroup footerFrame;
		FooterBarCell footerCell;

		public NavTree(ViewGroup containerFrame,ViewGroup footerFrame) {
			Nav.setDefultBranc(branchMapHolder);
			this.containerFrame = containerFrame;
			this.footerFrame = footerFrame;
		}

		//todo pagelimits
		public void push(PresenterPage page){
			PresenterPage last = getLastPage();
			if(last!=null){
				last.onBlur();
			}
//			_addPageToContainer(page);
			if (getContainerFrame().getChildCount()>0){
				getContainerFrame().removeViewAt(0);
			}

			BranchCell bc = _getActiveBranchCell();
			if(bc.pageStacks.size()>= MAX_BRANCH_STACKE_SIZE){
				_removePage(bc.pageStacks.get(1),bc);
			}
			bc.pageStacks.add(page);
			getContainerFrame().addView(page.getFinalView(containerFrame));
			page.onFocus();
		}

		public void replace(PresenterPage page1){
			PresenterPage last = getLastPage();

			BranchCell bc = _getActiveBranchCell();

			if(last!=null){
				bc.pageStacks.remove(last);
				last.onBlur();
				last.onBack();
				last.onDestroy();
			}

			//// TODO: 3/30/2017 a bug wwhen we push we should not do  last.onBlur(); on the .push() method
			push(page1);
		}

		public void pop() {
			onBackPress();
		}

		public void pop(int size) {
			Helper.closeKeyboard();
			for(int i=0; i< size;i++){
				onBackPress();
			}
		}

		public void hideFooter(){
			footerFrame.setVisibility(View.GONE);
		}

		public void showFooter(){
			footerFrame.setVisibility(View.VISIBLE);
		}

		public void goToBranch(Branch bra) {
			branchOrderStacks.push(bra);
			if (getContainerFrame().getChildCount()>0){
				getContainerFrame().removeViewAt(0);
			}

			PresenterPage last = _getActiveBranchCell().getLastPage();
			if(last.isInitiated()){
				last.onBlur();
				last.onBack();
			}

			activeBranch = bra;
			footerCell.activateBranch(bra);

			BranchCell bc = _getActiveBranchCell();
			PresenterPage page = bc.pageStacks.get(_getActiveBranchCell().pageStacks.size()-1);
			getContainerFrame().addView(page.getFinalView(containerFrame));
			page.onFocus();
		}

		boolean goOnePageBack(){
			//stay on branch
			BranchCell bc = _getActiveBranchCell();
			if ( bc.pageStacks.size() >= 2){//default page ust remain
				PresenterPage page = bc.pageStacks.pop();
				page.onBlur();
				page.onBack();
				page.onDestroy();
				getContainerFrame().removeView(page.getFinalView(containerFrame));

				PresenterPage page2 = bc.pageStacks.peek();
				getContainerFrame().addView(page2.getFinalView(containerFrame));
				page2.onFocus();

				return true;
			}else if(branchOrderStacks.branchList.size() >= 2) {//go to another branch
				//event of root of branch
				PresenterPage page = _getActiveBranchCell().pageStacks.peek();
				page.onBlur();
				page.onBack();

				branchOrderStacks.pop();
				goToBranch(branchOrderStacks.peek());
				return true;
			}
			return false;
		}


		ViewGroup getContainerFrame(){
			return containerFrame;
		}

		//Fixme: .pop() events + bug: get longcliked branced not active
		public void resetBranch(Branch branch) {
			BranchCell bc = branchMapHolder.get(branch);
			PresenterPage page;
			while (bc.pageStacks.size() >1 ){
				page = bc.pageStacks.get(bc.pageStacks.size()-1);
				_removePage(page,bc);
			}
		}

		@DebugLog
		public void setUpFooterBar(){
			footerCell = new FooterBarCell(footerFrame);
			footerFrame.addView(footerCell.getRoot());
		}

		//returns means: true Nav handeld - activit don't do anything --- false: we didn't handlePushes activity handlePushes it
		public boolean onBackPress() {
			//handlePushes customs
			boolean customHandled = false;
			for(OnBackPressHandler handler : customOnBackPressHandler){
				customHandled = handler.handle();
				if(customHandled == true) return true;
			}

			return goOnePageBack();
		}

		public void addCustomOnBackPressHandler(OnBackPressHandler handler) {
			customOnBackPressHandler.add(handler);
		}

		public void removeCustomOnBackPressHandler(OnBackPressHandler handler) {
			customOnBackPressHandler.remove(handler);
		}

		private Nav.BranchCell _getActiveBranchCell(){
			return branchMapHolder.get(activeBranch);
		}

		public void reset(){
			branchMapHolder = new HashMap<>();
			setDefultBranc(branchMapHolder);
			activeBranch = Branch.Chat;
		}

		public void onActivityResult(int requestCode, int resultCode, Intent data){
			if( getLastPage() != null) {
				getLastPage().onActivityResult(requestCode, resultCode,data);
			}
		}

		PresenterPage getLastPage(){
			BranchCell bc = _getActiveBranchCell();
			return bc.pageStacks.peek();
		}

		void _addPageToContainer(PresenterPage page){
			if (getContainerFrame().getChildCount()>0){
				getContainerFrame().removeViewAt(0);
			}

			_getActiveBranchCell().pageStacks.add(page);
			getContainerFrame().addView(page.getFinalView(containerFrame));
			page.onFocus();
		}

		void _removePage(PresenterPage page, BranchCell bc){
			bc.pageStacks.remove(page);
			page.onBlur();
			page.onDestroy();
		}

	}
}
