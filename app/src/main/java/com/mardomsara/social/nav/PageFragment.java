package com.mardomsara.social.nav;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

public abstract class PageFragment extends Fragment {
	static int counter = 0;

	String tagId = "";

	public PageFragment() {
		tagId = "tagId_" + counter;
		counter++;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		Log.d("TAG1","onAttach");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d("TAG1","onDetach");
	}

	boolean onBackPressed(){
		return false;
	}




	public String getTagId() {
		return tagId;
	}
	//just called during Nav changes pages
	/*abstract void onInit();
	abstract void onFocus();
	abstract void onBack();
    abstract void onBlur();
    abstract void onDestroy55();
//    void onKeyDown();
	abstract boolean isInitiated();
    abstract void onActivityResult55(int requestCode, int resultCode, Intent data);

	//abstract View getFinalView(ViewGroup parent);*/
}
