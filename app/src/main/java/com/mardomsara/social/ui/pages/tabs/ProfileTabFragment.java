package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.nav.BranchHolderFragment;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.pages.tabs.pages.ProfileCell;
import com.mardomsara.social.ui.presenter.settings.SettingsCell;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class ProfileTabFragment extends BranchHolderFragment {
	@Override
	public View getView(Bundle savedInstanceState) {

		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("تنظیمات", ()-> new SettingsCell().buildView()));
		tabs.addTab(new AppTabPagerAdaptor.Tab("پروفایل", ()-> new ProfileCell(Session.getUserId(),true).buildView() ));

		Cells.NavAndPagerSwipe navAndPager = new Cells.NavAndPagerSwipe(tabs);

		return navAndPager.rootView;
	}

}
