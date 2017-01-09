package com.mardomsara.social;

//import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.ui.fragments.FooterBarFragment;

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
public class Nav2 {

	public Nav2() {

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
		public PresenterPage defaultRoute;
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


	static void setDefultBranc2(Map<Branch,BranchCell> branchMapHolder){
		for (Branch b : Branch.values()){
			BranchCell cell = new BranchCell();
			cell.name = b;
			switch (b){
				case Chat:
					cell.defaultRoute = Router.getChatPage();
					break;
				case Home:
					cell.defaultRoute = Router.getHomePage();
					break;
				case Search:
					cell.defaultRoute = Router.getSearchPage();
					break;
				case Activity:
					cell.defaultRoute = Router.getAactivityPage();
					break;
				case Profile:
					cell.defaultRoute = Router.getMyProfile();
					break;
			}
			branchMapHolder.put(b,cell);
		}
	}

	static class NavTree {
		static String TAG = "Nav";
		static int MAX_BRANCH_STACKE_SIZE = 10;
		public String _activeBranch;
		public PresenterPage _lastFragmentPage;

		public Map<Branch,BranchCell> branchMapHolder = new HashMap<>();
		public FooterBarFragment footFrag;
		private static List<OnBackPressHandler> customOnBackPressHandler = new ArrayList();

		Branch activeBranch = Branch.Chat;

		public NavTree() {
			setDefultBranc2(branchMapHolder);
		}

		public void push(PresenterPage frag){

		}

		public void pop() {

		}

		public void pop(int size) {

		}

		public void hideFooter(){

		}

		public void showFooter(){

		}

		public void goToBranch(Branch bra) {

		}

		@DebugLog
		public void  _attachPage2(PresenterPage frag){

		}

		public void detachaLstOne(){

		}

		//Fixme: .pop() events + bug: get longcliked branced not active
		public void resetBranch(Branch branch) {

		}

		@DebugLog
		public void setUpFooetrBar(){

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

		private Nav2.BranchCell _getActiveBranchCell(){
			return null;
		}


		static void setDefultBranc(){

		}

		public void reset(){

		}

		public void onActivityResult(int requestCode, int resultCode, Intent data){

		}

	}
}
