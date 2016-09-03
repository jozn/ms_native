package com.mardomsara.social.ui.presenter.social;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;

/**
 * Created by Hamid on 8/23/2016.
 */
public class AcitivityTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
//        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.hello_world_row,null);
//        return v;

        View l = AppUtil.inflate(R.layout.nav_header_pager_menu);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tab = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tab.setBackgroundColor(0xeeeeee);
        ActivityTabPagerAdaptor pad = new ActivityTabPagerAdaptor(fragment.getChildFragmentManager(),fragment.getActivity());

        tab.setTabMode(TabLayout.MODE_FIXED);
//

        vp.setAdapter(pad);
        tab.setupWithViewPager(vp);

        //must called here
        for (int i = 0; i < tab.getTabCount(); i++) {
            TabLayout.Tab t = tab.getTabAt(i);
            t.setCustomView( pad.getTabView(i) );
        }

        vp.setCurrentItem(pad.getCount()-1);

        //////TEMP/////////////
        View searchBtn = l.findViewById(R.id.search);
        searchBtn.setOnClickListener((v)-> Nav.push(new SearchPresenter()));
        /////////////////

        return l;
    }

    public static class ActivityTabPagerAdaptor extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        private String tabTitles[] = new String[] { "دنبال شدگان","شما"};//, "Tab3","Tab222","Tab222","Tab222" };
        private Context context;
        //    private String tabTitles[] = new String[] { "Tab1", "Tab2" };
        private int[] imageResId = { R.drawable.ic_menu_send, R.drawable.ic_menu_camera};//, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage, R.drawable.ic_menu_manage };

        public ActivityTabPagerAdaptor(FragmentManager fm, Context context) {
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
                    return new ComingSoonPresenter().getFragment();
                default:
                    return new NotifyPresenter().getFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

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
