package com.mardomsara.social.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mardomsara.social.PresenterPage;
import com.mardomsara.social.app.Singletons;

/**
 * Created by Hamid on 2/19/2016.
 */
public  abstract class BasePresenter implements PresenterPage {
    //todo: remove-migrate this
    boolean calledInit = false;
    public static Fragment presenterToFragment(BasePresenter presenter) {
        SinglePresenterFragment frag = new SinglePresenterFragment();
        frag.setPresenter(presenter);
        return frag;
    }

	@Deprecated
    protected Fragment fragment ;

    public static Context context;//setOrReplace thif from App.init()

    //dep
    @Deprecated
    public static LayoutInflater inflater;

    @Deprecated
    protected View grandView;

    public BasePresenter() {
        PresenterFragment presenterFrag = new PresenterFragment();
        presenterFrag.setPresenter(this);
        presenterFrag.setClassTag(this.getClass().getSimpleName());//for debug
        setFragment(presenterFrag);
    }

    public View getGrandView(){
        return buildGrandView();
    }

    protected void runInBackgeound(Runnable r){
        Singletons.getThreadPool().execute(r);
    }

    //deprecated
    protected  View buildGrandView(){
        return null;
    };

    public abstract View buildView();

    //needed ? use ButterKingh
    //dep todo: extract this ti ViewHelper
    protected TextView getTextView(int id){
       return  (TextView) grandView.findViewById(id);
    }

    //dep
    protected ImageView getImageView(int id){
        return  (ImageView) grandView.findViewById(id);
    }

	@Deprecated
    public Fragment getFragment() {
        return fragment;
    }


	@Deprecated
    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public void onDestroy(){

    }


	public void onAfterView(){

	}

    //fragment on onStart
    public void onStart(){
        if(calledInit == false){
            calledInit = true;
            onFocus();
        }
    }
    public void onResume(){}
//    public void onFocus(){}

    @Override
    public void onFocus() {
        logIt("onFocus");
        if(fragment != null){
            View v = ((PresenterFragment) fragment).presenterViewHolder;
            v.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void callOnFocus() {
        if(calledInit == true){//only call onFocus() when fragment has been added to view in next event loop from Fragment Transactions
            onFocus();
        }
    }

    @Override
    public void onBlur() {
        logIt("onBlur");
        if(fragment != null){
           View v = ((PresenterFragment) fragment).presenterViewHolder;
            if(v != null){
                v.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onBack() {
        logIt("onBack");
    }

    @Override
    public void onKeyDown() {
        logIt("onKeyDown");
    }

    public void logIt(String str){
        Log.d("Presenter: "," "+ this.getClass().getSimpleName() + " : "+ str);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        logIt("onActivityResult: BasePresenter");
    }

    public Activity getActivity(){
        return getFragment().getActivity();
    }

    public Context getContext(){
        return getFragment().getActivity();
    }

	/////////////// just for new funcs

	@Override
	public View getFinalView() {
		return null;
	}
}
