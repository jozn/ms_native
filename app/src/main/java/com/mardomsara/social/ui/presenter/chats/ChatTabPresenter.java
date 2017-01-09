package com.mardomsara.social.ui.presenter.chats;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.ui.TabPagerAdaptor;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatTabPresenter extends BasePresenter {
    @Override
    public View buildView() {
        View l = AppUtil.inflate(R.layout.main_branch_chat);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tabLayout.setBackgroundColor(0xeeeeee);

		TabPagerAdaptor tabsPager = new TabPagerAdaptor();
		tabsPager.addTab(new TabPagerAdaptor.Tab("کاربران", new UserAndContactsPresenter()));
		tabsPager.addTab(new TabPagerAdaptor.Tab("گفتگو ها", new RoomsListPresenter()));

        vp.setAdapter(tabsPager);
        tabLayout.setupWithViewPager(vp);
		tabsPager.setTabLayout(tabLayout);

        vp.setCurrentItem(1);
        return l;
    }

}


