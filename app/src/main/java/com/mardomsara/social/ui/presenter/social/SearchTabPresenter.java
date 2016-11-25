package com.mardomsara.social.ui.presenter.social;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.presenter.social.search.SearchPresenter;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
		SearchTabPagerAdaptor pad = new SearchTabPagerAdaptor(getFragment().getChildFragmentManager(),fragment.getActivity());

		PageCells.NavAndPager navAndPager = new PageCells.NavAndPager(pad);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchPresenter());});

        return navAndPager.rootView;
    }

    public static class SearchTabPagerAdaptor extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[] { "تگ","کاربر","پست"};//, "Tab3","Tab222","Tab222","Tab222" };
        private Context context;

        public SearchTabPagerAdaptor(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new SuggestionsTagsPresenter().getFragment();
                case 1:
                    return new SuggestionsUsersPresenter().getFragment();
                default:
                    return new SuggestionsPostsPresenter().getFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
