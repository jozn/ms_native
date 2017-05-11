package com.mardomsara.social.ui.presenter.settings;

import android.view.View;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;

/**
 * Created by Hamid on 2/20/2017.
 */

public class EditPhonePresenter extends BasePresenter {
	@Override
	public View buildView() {
		/*Cells.NavAndEmptyView x = new Cells.NavAndEmptyView();
		x.simpleTopNav.setTitle("شماره تلفن");*/

		X.Page_EditProfile x= new X.Page_EditProfile();

		return x.root;
	}


}
