package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.nav.BranchHolderFragment;
import com.mardomsara.social.ui.pages.tabs.pages.ActivityCell;
import com.mardomsara.social.ui.pages.tabs.pages.NotifyCell;
import com.mardomsara.social.ui.presenter.social.search.SearchUserAndTagPage;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class ActivityTabFragment extends BranchHolderFragment {

	@Override
	public View getView(Bundle savedInstanceState) {
		View l = AppUtil.inflate(R.layout.nav_header_pager_menu);
		ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
		TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
		tabLayout.setBackgroundColor(0xeeeeee);

		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("دنبال شدگان",()-> new ActivityCell().buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("شما", ()-> new NotifyCell().buildView() ));

		vp.setAdapter(tabs);
		tabLayout.setupWithViewPager(vp);

		tabs.setTabLayout(tabLayout);
		vp.setCurrentItem(tabs.getCount()-1);

		//////TEMP/////////////
		View searchBtn = l.findViewById(R.id.search);
//		searchBtn.setOnClickListener((v)-> Nav_DEP.push(new SearchUserAndTagPage()));
		/////////////////

		return l;
	}

}
