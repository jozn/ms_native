package com.mardomsara.social.ui.presenter.tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.presenter.chats.RoomsListPresenter;
import com.mardomsara.social.ui.presenter.chats.UserAndContactsPresenter;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatTab extends BasePresenter {
    @Override
    public View buildView() {
        View l = AppUtil.inflate(R.layout.main_branch_chat);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tabLayout.setBackgroundColor(0xeeeeee);

		AppTabPagerAdaptor tabsPager = new AppTabPagerAdaptor();
		tabsPager.addTab(new AppTabPagerAdaptor.Tab("کاربران", new UserAndContactsPresenter()));
		tabsPager.addTab(new AppTabPagerAdaptor.Tab("گفتگو ها", new RoomsListPresenter()));

        vp.setAdapter(tabsPager);
        tabLayout.setupWithViewPager(vp);
		tabsPager.setTabLayout(tabLayout);

        vp.setCurrentItem(1);
        return l;
    }

}


