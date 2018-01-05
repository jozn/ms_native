package com.mardomsara.social.ui.presenter.tabs;

import android.view.View;

import com.mardomsara.social.app.Router_DEP;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
@Deprecated
public class ProfileTab extends BasePresenter {
    @Override
    public View buildView() {

		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("تنظیمات", Router_DEP.getSettings() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("پروفایل", Router_DEP.getMyProfile() ));

		Cells.NavAndPagerSwipe navAndPager = new Cells.NavAndPagerSwipe(tabs);

        return navAndPager.rootView;
    }

}
