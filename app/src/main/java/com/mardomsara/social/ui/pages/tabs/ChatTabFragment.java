package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.nav.BranchHolderFragment;
import com.mardomsara.social.ui.pages.tabs.pages.UserAndContactsCell;
import com.mardomsara.social.ui.presenter.chat_realm.inbox.InboxChatsListCell;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatTabFragment extends BranchHolderFragment {
	@Override
	public View getView(Bundle savedInstanceState) {
		View l = AppUtil.inflate(R.layout.main_branch_chat);
		ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
		TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
		tabLayout.setBackgroundColor(0xeeeeee);

		AppTabPagerAdaptor tabsPager = new AppTabPagerAdaptor();
		tabsPager.addTab(new AppTabPagerAdaptor.Tab("کاربران", ()-> new UserAndContactsCell().buildView()));
		tabsPager.addTab(new AppTabPagerAdaptor.Tab("گفتگو ها",()-> new InboxChatsListCell().getView()));

		vp.setAdapter(tabsPager);
		tabLayout.setupWithViewPager(vp);
		tabsPager.setTabLayout(tabLayout);

		vp.setCurrentItem(1);
		return l;
	}

}


