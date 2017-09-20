package com.mardomsara.social.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.mardomsara.social.App;
import com.mardomsara.social.PresenterPage;

/**
 * Created by Hamid on 2/19/2016.
 */
public  abstract class BasePresenter implements PresenterPage {
	boolean isInited = false;
    public static Context context;//setOrReplace thif from App.init()
    public Activity activity;//setOrReplace thif from App.init()

    private View grandView;

    public BasePresenter() {}

	//subclass must overight thi
    public abstract View buildView();

	@Override
	public View getFinalView(ViewGroup parent) {
		if(grandView == null){
			onInit();
			isInited =true;
			grandView = buildView();
		}
		return grandView;
	}

	@Override
	public boolean isInitiated() {
		return isInited;
	}

	@Override
	public void onDestroy(){

    }

	@Override
	public void onInit() {
		logIt("onFocus");
	}

    @Override
    public void onFocus() {
        logIt("onFocus");
    }

    @Override
    public void onBlur() {
        logIt("onBlur");

    }

    @Override
    public void onBack() {
        logIt("onBack");
    }

    public void logIt(String str){
        Log.d("Presenter: "," "+ this.getClass().getSimpleName() + " : "+ str);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        logIt("onActivityResult: BasePresenter:  "+ this.getClass().getSimpleName());
    }

    public Activity getActivity(){
        return App.getActivity();
    }

    public Context getContext(){
        return activity;
    }

    public void keyboard_noResize(){
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
	}

	public void keyboard_adjust(){
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
	}

	/*//todo remove this
	@Deprecated
	public void onAfterView() {

	}*/
}
