package com.mardomsara.social;

//import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.Helper;
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
public class Nav {
    static String TAG = "Nav";
    static int MAX_BRANCH_STACKE_SIZE = 10;
    public static Map<String,FragmentPage> branchsDef;
    public static List<FragmentPage> branchsPageStacks;
    public static String _activeBranch;
    public static FragmentPage _lastFragmentPage;
    public static Map<String,BranchCell> branchMapHolder = new HashMap<>();
    public static FooterBarFragment footFrag;



    private static List<OnBackPressHandler> customOnBackPressHandler = new ArrayList();
    static {
        setDefultBranc();
        _activeBranch= "home";
    }

    public static void push(FragmentPage frag){
        _attachPage2(frag);
        _getActiveBranchCell().fragmentsPageStacks.add(frag);
        if(_getActiveBranchCell().fragmentsPageStacks.size()>MAX_BRANCH_STACKE_SIZE){
            FragmentPage frag2 = _getActiveBranchCell().fragmentsPageStacks.remove(1);
            removePageFromGlobaFragment(frag2);
            Log.d(TAG, " removed max extra:");
        }
    }

    public static void pop() {
        onBackPress();//TODo extart functionality
    }

    public static void pop(int size) {
        for(int i=0; i< size;i++){
            onBackPress();//TODo extart functionality
        }
    }

    public static void hideFooter(){
        FragmentTransaction ft = App.mFragmentManager.beginTransaction();
        ft.hide(footFrag);
        ft.commit();
    }

    public static void showFooter(){
        FragmentTransaction ft = App.mFragmentManager.beginTransaction();
        ft.show(footFrag);
        ft.commit();
    }

    @DebugLog //play
    public static void goToBranch_play(String bra) {
//        if (bra == _activeBranch ){ return; };
        _activeBranch = bra;
        BranchCell bc = _getActiveBranchCell();
        Log.d(TAG, "Branch "+bra + " stacke size " +bc.fragmentsPageStacks.size());
//        if(bc.fragmentsPageStacks.size() == 0 ){
            push(bc.defaultRoute);
//        }else{
//            /_attachPage2(bc.fragmentsPageStacks.peek());
//        }
        footFrag.activateBranch(_activeBranch);
    }


    @DebugLog
    public static void goToBranch(String bra) {
//        if (bra == _activeBranch ){ return; };
        _activeBranch = bra;
        BranchCell bc = _getActiveBranchCell();
        Log.d(TAG, "Branch "+bra + " stacke size " +bc.fragmentsPageStacks.size());
        if(bc.fragmentsPageStacks.size() == 0 ){
            push(bc.defaultRoute);
        }else{
            _attachPage2(bc.fragmentsPageStacks.peek());
        }
        footFrag.activateBranch(_activeBranch);
    }

    @DebugLog
    public static void  _attachPage2(FragmentPage frag){
        BranchOrderStacks.push(_activeBranch);
//        if(frag == _lastFragmentPage ) {return;};//fix bug: happens when we are in 'home' and clikks home
        try {
            FragmentTransaction ft = App.mFragmentManager.beginTransaction();
            if(_lastFragmentPage != null && _lastFragmentPage != frag ){
                _lastFragmentPage.onBlur();

                ft.hide(_lastFragmentPage.getFragment());
            }
            Log.d(TAG, "frag + "+frag.getFragment().isAdded());
            _lastFragmentPage = frag;
            boolean isAttached = false;
            if(frag.getFragment().isAdded() && frag.getFragment().isHidden()){
                ft.show(frag.getFragment());
                isAttached = true;
            }else if(!frag.getFragment().isAdded()){
                ft.add(R.id.frag1, frag.getFragment());
                isAttached = true;
            }
            ft.commit();
            if(isAttached == true) frag.callOnFocus();
        } catch (Exception e){
            Log.e(TAG, "Execption for attachng fragment "+ e.toString());
        }
    }

    public static void detachaLstOne(){

    }

    //Fixme: .pop() events + bug: get longcliked branced not active
    public static void resetBranch(String branch) {
        Helper.showDebugMessage("resetBranch");
       BranchCell bc =  _getActiveBranchCell();
        while (bc.fragmentsPageStacks.size()>1){
            bc.fragmentsPageStacks.pop();
        }
        resetBranch(branch);
    }

    @DebugLog
    public static void setUpFooetrBar(){
        FragmentTransaction ft = App.mFragmentManager.beginTransaction();
        footFrag = new FooterBarFragment();
        ft.replace(R.id.footerbar_holder, footFrag, "FooterBarFragment");
        ft.commit();
//        footFrag.activateBranch(_activeBranch);

    }

    //returns means: true Nav handeld - activit don't do anything --- false: we didn't handle activity handle it
    public static boolean onBackPress() {
        boolean res = true;

        ///////////////////////////////////////////////
        //handle customs
        boolean customHandled = false;
        for(OnBackPressHandler handler : customOnBackPressHandler){
            customHandled = handler.handle();
            if(customHandled == true) return true;
        }
        ///////////////////////////////////////////////

        if(_lastFragmentPage != null) _lastFragmentPage.onBack();
        FragmentTransaction ft = App.mFragmentManager.beginTransaction();
//        if(_lastFragmentPage != null){
//            ft.detach(_lastFragmentPage.fragment);
//        }
//        ft.add(R.id.frag1, frag.fragment);
        BranchCell bc = _getActiveBranchCell();
        if( bc.fragmentsPageStacks.size()>=2){//will stay in the same branch
            FragmentPage fp = bc.fragmentsPageStacks.pop();
            fp.onBlur();
            ft.remove(fp.getFragment());
            FragmentPage fp2 = bc.fragmentsPageStacks.peek();
            _lastFragmentPage = fp2;
            ft.show(fp2.getFragment());
        }else if(bc.fragmentsPageStacks.size()==1){
            //check if we can switch to previuos branch
            BranchOrderStacks.pop();
            String preBranch = BranchOrderStacks.peek();
            if (preBranch != null){
                goToBranch(preBranch);
            }else {//exit from app
                res= false;
            }
        }else{
            //throw new Exception("")
        }
        ft.commit();
        return res;
    }
    static void  removePageFromGlobaFragment(FragmentPage fp){
        FragmentTransaction ft = App.mFragmentManager.beginTransaction();
        fp.onBlur();
        ft.remove(fp.getFragment());
        ft.commit();
    }

    public static void addCustomOnBackPressHandler(OnBackPressHandler handler) {
        Nav.customOnBackPressHandler.add(handler);
    }

    public static void removeCustomOnBackPressHandler(OnBackPressHandler handler) {
        Nav.customOnBackPressHandler.remove(handler);
    }

    private static BranchCell _getActiveBranchCell(){
        return branchMapHolder.get(_activeBranch);
    }

    public static class BranchCell{
        public Stack<FragmentPage> fragmentsPageStacks = new Stack<>();//all contents hsbeen attched so we can call attach/deattach
        public String name;
        public FragmentPage defaultRoute;
    }

    //just _attachPage() will call this
    public static class BranchOrderStacks {
        Set<String> branchSet = new LinkedHashSet<>();
        static List<String> branchList = new ArrayList<>();

        public static void push(String bra) {
            branchList.remove(bra);//remove older
            branchList.add(bra); //apend
        }

        public static String peek() {
            String res = null;
            if (branchList.size()>0){
                res = branchList.get(branchList.size()-1);
            }
            return res;
        }

        public static String pop() {
            int size = branchList.size();
            String res = null;
            if (size > 0) {
                res = branchList.get(size - 1);
                branchList.remove(size - 1);
            }
            return res;
        }
    }

    public static class FooterBar extends Fragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

    }

    static void setDefultBranc(){
        String[] branchs = new String[]{"chat","home","search","activity","profile"};
        for (String b : branchs){
            BranchCell c = new BranchCell();
            c.name = b;
            c.defaultRoute = Router.getLikesPage(2);
            if(b.equals("chat")){
                c.defaultRoute = Router.getChatPage();
            }
            if(b.equals("home")){
                c.defaultRoute = Router.getHomePage();
            }
            if(b.equals("search")){
                c.defaultRoute = Router.getSearchPage();
            }
            if(b.equals("activity")){
                c.defaultRoute = Router.getAactivityPage();
            }
            if(b.equals("profile")){
//                c.defaultRoute = Router.getAactivityPage();
                c.defaultRoute = Router.getMyProfile();
            }
            branchMapHolder.put(b,c);
        }
    }

    public static void reset(){
        branchMapHolder = new HashMap<>();
        _lastFragmentPage = null;
        setDefultBranc();
        _activeBranch= "home";
        Log.d(TAG, "called Nav.reset()");

    }

    public static void onActivityResult(int requestCode, int resultCode, Intent data){
        if( _lastFragmentPage != null) {
            _lastFragmentPage.onActivityResult(requestCode, resultCode,data);
        }
    }

    public interface OnBackPressHandler{
        boolean handle();
    }
}
