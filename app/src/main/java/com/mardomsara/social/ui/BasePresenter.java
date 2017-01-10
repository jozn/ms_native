package com.mardomsara.social.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.PresenterPage;

/**
 * Created by Hamid on 2/19/2016.
 */
public  abstract class BasePresenter implements PresenterPage {
    //todo: remove-migrate this
    boolean calledInit = false;

    public static Context context;//setOrReplace thif from App.init()
    public Activity activity;//setOrReplace thif from App.init()


    private View grandView;

    public BasePresenter() {

    }

    public View getGrandView(){
        return grandView;
    }

	//subclass must overight thi
    public abstract View buildView();

	@Override
	public View getFinalView(ViewGroup parent) {
		if(grandView == null){
			grandView = buildView();
		}
		return grandView;
	}

	//todo remove
	@Deprecated
	@Override
	public Fragment getFragment() {
		return null;
	}

	public void onDestroy(){

    }

    //fragment on onStart
    public void onStart(){
        if(calledInit == false){
            calledInit = true;
            onFocus();
        }
    }
    public void onResume(){

	}
//    public void onFocus(){}

    @Override
    public void onFocus() {
        logIt("onFocus");
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
        return activity;
    }

    public Context getContext(){
        return activity;
    }

	//todo remove this
	@Deprecated
	public void onAfterView() {

	}
}
