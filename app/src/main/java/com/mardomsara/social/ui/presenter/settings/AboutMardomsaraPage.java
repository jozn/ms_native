package com.mardomsara.social.ui.presenter.settings;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.cells.Cells;

/**
 * Created by Hamid on 2/20/2017.
 */

public class AboutMardomsaraPage extends FragmentPage {
	@Override
	public View getView(Bundle savedInstanceState) {
		Cells.NavAndEmptyView x = new Cells.NavAndEmptyView();
		x.simpleTopNav.setTitle("مردم سرا");

		return x.rootView;
	}


}
