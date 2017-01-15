package com.mardomsara.social.ui.presenter.tabs;

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
import com.mardomsara.social.ui.presenter.social.ActivityPresenter;
import com.mardomsara.social.ui.presenter.social.NotifyPresenter;
import com.mardomsara.social.ui.presenter.social.search.SearchPresenter;
import com.mardomsara.social.ui.ui.TabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class AcitivityTab extends BasePresenter {
    @Override
    public View buildView() {
        View l = AppUtil.inflate(R.layout.nav_header_pager_menu);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tabLayout.setBackgroundColor(0xeeeeee);

		TabPagerAdaptor tabs = new TabPagerAdaptor();
		tabs.addTab(new TabPagerAdaptor.Tab("دنبال شدگان",()-> new ActivityPresenter().buildView() ));
		tabs.addTab(new TabPagerAdaptor.Tab("شما", ()-> new NotifyPresenter().buildView() ));

        vp.setAdapter(tabs);
        tabLayout.setupWithViewPager(vp);

		tabs.setTabLayout(tabLayout);
        vp.setCurrentItem(tabs.getCount()-1);

        //////TEMP/////////////
        View searchBtn = l.findViewById(R.id.search);
        searchBtn.setOnClickListener((v)-> Nav.push(new SearchPresenter()));
        /////////////////

        return l;
    }
}
