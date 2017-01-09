package com.mardomsara.social.ui.presenter.social;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.presenter.social.search.SearchPresenter;
import com.mardomsara.social.ui.ui.TabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
		TabPagerAdaptor tabs = new TabPagerAdaptor();
		tabs.addTab(new TabPagerAdaptor.Tab("تگ",()-> new SuggestionsTagsPresenter().buildView() ));
		tabs.addTab(new TabPagerAdaptor.Tab("کاربر",()-> new SuggestionsUsersPresenter().buildView() ));
		tabs.addTab(new TabPagerAdaptor.Tab("پست",()-> new SuggestionsPostsPresenter().buildView() ));

		PageCells.NavAndPager navAndPager = new PageCells.NavAndPager(tabs);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchPresenter());});

        return navAndPager.rootView;
    }

}
