package com.mardomsara.social.ui.presenter.settings;

import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 2/20/2017.
 */

public class EditProfilePresenter extends BasePresenter {
	@Override
	public View buildView() {
		X.Page_EditProfile x = new X.Page_EditProfile();
		x.simpleTopNav.setTitle("ویرایش پروفایل");

		AndroidUtil.inflate(R.layout.comment_row);



		return x.root;
	}


}
