package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.nav.BranchHolderFragment;
import com.mardomsara.social.nav.Nav;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.pages.tabs.pages.SuggestionsPostsCell;
import com.mardomsara.social.ui.pages.tabs.pages.SuggestionsTagsCell;
import com.mardomsara.social.ui.pages.tabs.pages.SuggestionsUsersCell;
import com.mardomsara.social.ui.pages.tabs.pages.search.SearchUserAndTagPageFragment;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTabFragment extends BranchHolderFragment {
	@Override
	public View getView(Bundle savedInstanceState) {
		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("تگ",()-> new SuggestionsTagsCell().buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("کاربر",()-> new SuggestionsUsersCell().buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("پست",()-> new SuggestionsPostsCell().buildView() ));

		Cells.NavAndPagerSwipe navAndPager = new Cells.NavAndPagerSwipe(tabs);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav.push(new SearchUserAndTagPageFragment());});

//		return  new InboxChatsListCell().xChatList.root;
		return  navAndPager.rootView;
	}

}
