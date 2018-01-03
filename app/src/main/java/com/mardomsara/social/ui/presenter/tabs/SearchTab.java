package com.mardomsara.social.ui.presenter.tabs;

import android.view.View;

import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.presenter.chat_realm.inbox.InboxChatsListCell;
import com.mardomsara.social.ui.presenter.social.SuggestionsPostsPresenter;
import com.mardomsara.social.ui.presenter.social.SuggestionsTagsPresenter;
import com.mardomsara.social.ui.presenter.social.SuggestionsUsersPresenter;
import com.mardomsara.social.ui.presenter.social.search.SearchUserAndTagPage;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchTab extends BasePresenter {
    @Override
    public View buildView() {
		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("تگ",()-> new SuggestionsTagsPresenter().buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("کاربر",()-> new SuggestionsUsersPresenter().buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("پست",()-> new SuggestionsPostsPresenter().buildView() ));

		Cells.NavAndPagerSwipe navAndPager = new Cells.NavAndPagerSwipe(tabs);

		navAndPager.addIcon("{ion-ios-search-strong 26dp}",()->{ Nav_DEP.push(new SearchUserAndTagPage());});

//        return navAndPager.rootView;




		///play
        return  new InboxChatsListCell().xChatList.root;
    }

}
