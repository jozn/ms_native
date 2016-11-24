package com.mardomsara.social.ui.presenter.social;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
//        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.hello_world_row,null);
//        return v;
		SearchTabPagerAdaptor pad = new SearchTabPagerAdaptor(getFragment().getChildFragmentManager(),fragment.getActivity());

		PageCells.NavAndPager navAndPager =new PageCells.NavAndPager(pad);
        /*View l = AppUtil.inflate(R.layout.nav_header_pager_menu);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tab = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tab.setBackgroundColor(0xeeeeee);*/

/*

        navAndPager.tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tab.setTabMode(TabLayout.MODE_FIXED);
//
		navAndPager.viewPager.setAdapter(pad);
//        vp.setAdapter(pad);
		navAndPager.tabLayout.setupWithViewPager(navAndPager.viewPager);
//        tab.setupWithViewPager(vp);

        //must called here
        for (int i = 0; i < navAndPager.tabLayout.getTabCount(); i++) {
            TabLayout.Tab t = navAndPager.tabLayout.getTabAt(i);
            t.setCustomView( pad.getTabView(i) );
        }

		navAndPager.viewPager.setCurrentItem(pad.getCount()-1);

*/
        //////TEMP/////////////
//        View searchBtn = l.findViewById(R.id.search);
//        searchBtn.setOnClickListener((v)-> Nav.push(new SearchPresenter()));
        /////////////////
		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchPresenter());});

        return navAndPager.rootView;
    }

    public static class SearchTabPagerAdaptor extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[] { "تگ","کاربر","پست"};//, "Tab3","Tab222","Tab222","Tab222" };
        private Context context;
        //    private String tabTitles[] = new String[] { "Tab1", "Tab2" };
        private int[] imageResId = { R.drawable.ic_menu_send, R.drawable.ic_menu_camera};//, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage };

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

		@Deprecated
        public View getTabView(int position) {
            // Given you have a custom layout in `response/layout/custom_tab.xml` with a TextView and ImageView
            View v = LayoutInflater.from(context).inflate(R.layout.tab_cell_general, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);
            tv.setText(tabTitles[position]);
//        ImageView img = (ImageView) v.findViewById(R.id.imgView);
            //img.setImageResource(imageResId[position]);
            return v;
        }
    }
}
