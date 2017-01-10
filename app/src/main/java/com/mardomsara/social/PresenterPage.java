package com.mardomsara.social;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hamid on 5/9/2016.
 */
public interface PresenterPage {
    //just called during Nav changes pages
	void onInit();
    void onFocus();
	void onBack();
    void onBlur();
    void onDestroy();
//    void onKeyDown();
	boolean isInitiated();
    void onActivityResult(int requestCode, int resultCode, Intent data);

	View getFinalView(ViewGroup parent);
}
