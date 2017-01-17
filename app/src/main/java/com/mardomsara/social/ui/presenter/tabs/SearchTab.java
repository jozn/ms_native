package com.mardomsara.social.ui.presenter.tabs;

import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.presenter.social.SuggestionsPostsPresenter;
import com.mardomsara.social.ui.presenter.social.SuggestionsTagsPresenter;
import com.mardomsara.social.ui.presenter.social.SuggestionsUsersPresenter;
import com.mardomsara.social.ui.presenter.social.search.SearchUserAndTagPage;
import com.mardomsara.social.ui.ui.TabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTab extends BasePresenter {
    @Override
    public View buildView() {
		TabPagerAdaptor tabs = new TabPagerAdaptor();
		tabs.addTab(new TabPagerAdaptor.Tab("تگ",()-> new SuggestionsTagsPresenter().buildView() ));
		tabs.addTab(new TabPagerAdaptor.Tab("کاربر",()-> new SuggestionsUsersPresenter().buildView() ));
		tabs.addTab(new TabPagerAdaptor.Tab("پست",()-> new SuggestionsPostsPresenter().buildView() ));

		Cells.NavAndPagerSwipe navAndPager = new Cells.NavAndPagerSwipe(tabs);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchUserAndTagPage());});

        return navAndPager.rootView;
    }

}
