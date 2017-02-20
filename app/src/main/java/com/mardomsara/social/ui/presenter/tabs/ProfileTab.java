package com.mardomsara.social.ui.presenter.tabs;

import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.presenter.social.search.SearchUserAndTagPage;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class ProfileTab extends BasePresenter {
    @Override
    public View buildView() {
		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("تنظیمات", Router.getSettings() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("پروفایل", Router.getMyProfile() ));

		Cells.NavAndPagerSwipe navAndPager = new Cells.NavAndPagerSwipe(tabs);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchUserAndTagPage());});

        return navAndPager.rootView;
    }

}
