package com.mardomsara.social;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Hamid on 5/9/2016.
 */
public interface FragmentPage  {

	@Deprecated
    public Fragment getFragment();

    //just called during Nav changes pages
    public void onFocus();

    public void callOnFocus();

    //when
    public void onBlur();

    public void onBack();
    public void onKeyDown();
    public void onActivityResult(int requestCode, int resultCode, Intent data);

}
