package com.mardomsara.social.ui.presenter.settings;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 2/20/2017.
 */

public class EditPhonePage extends FragmentPage {
	@Override
	public View getView(Bundle savedInstanceState) {
		/*Cells.NavAndEmptyView x = new Cells.NavAndEmptyView();
		x.simpleTopNav.setTitle("شماره تلفن");*/

		X.Page_EditProfile x= new X.Page_EditProfile();

		return x.root;
	}


}
