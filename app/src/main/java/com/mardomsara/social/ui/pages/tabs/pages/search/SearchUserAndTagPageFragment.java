package com.mardomsara.social.ui.pages.tabs.pages.search;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.TagRowJson;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;
import com.mardomsara.social.ui.ui.UserListUI;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/23/2016.
 */
//keep this for sample of Sectioned
public class SearchUserAndTagPageFragment extends FragmentPage {
	final static String TRY_SEARCH = "جستجو کنید...";
	final static String NO_RESULT = "یافت نشد";

	SearchTagPagerPresenter tagPresenter = new SearchTagPagerPresenter();
	SearchUserPresenter userPresenter = new SearchUserPresenter();

	@Override
	public View getView(Bundle savedInstanceState) {

        View l = AppUtil.inflate(R.layout.nav_header_search);
        EditText search_input = (EditText)l.findViewById(R.id.search_input);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("تگ", ()-> tagPresenter.buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("کاربر", ()-> userPresenter.buildView() ));

		vp.setAdapter(tabs);
        tabLayout.setupWithViewPager(vp);

		tabs.setTabLayout(tabLayout);

        search_input.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textChanged(s.toString());
            }
        });

        vp.setCurrentItem(tabs.getCount()-1);
        return l;
    }

    void textChanged(String txt){
		if(tagPresenter!= null){
			tagPresenter.runQuery(txt);
		}

		if(userPresenter!= null){
			userPresenter.runQuery(txt);
		}
    }

	public static class SearchTagPagerPresenter  {
		RecyclerView recyclerView;
		LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext(),LinearLayoutManager.VERTICAL,false);
		SearchResultTagsListCell.TagsAdaptor adapter;

		public View buildView() {
			recyclerView = ViewHelper.newRecyclerViewMatch();
			adapter = new SearchResultTagsListCell.TagsAdaptor();
			recyclerView.setAdapter(adapter);
			recyclerView.setLayoutManager(layoutManager);
			adapter.setRecyclerView(recyclerView);
			adapter.setEmptyMessage("جستجو کنید...");
			adapter.setEnableAutoShowEmptyView(true);
			itIsEmpty(TRY_SEARCH);
			return recyclerView;
		}

		void runQuery(String search){
			if(search!= null && search.length() >0){
				load(search);
			} else {
				itIsEmpty(TRY_SEARCH);
			}
		}

		void itIsEmpty(String msg){
			adapter.list.clear();
			adapter.showEmptyView(msg);
		}

		void load(String query){
			Http.getPath("/v1/search/tags")
				.setQueryParam("q",query)
				.doAsyncUi(result -> {
					adapter.nextPageIsLoaded(result);
					if(result.isOk()){
						HttpJsonList<TagRowJson> data = Result.fromJsonList(result, TagRowJson.class);
						if(data.isPayloadNoneEmpty()){
							adapter.hideEmptyView();
							adapter.list.clear();
							adapter.list.addAll(data.Payload);
							adapter.notifyDataChanged();
						}else {
							itIsEmpty(NO_RESULT);

						}
						adapter.notifyDataChanged();
					}else {
//						adapter.showFullTryReload(result);
					}
				});
		}

	}

	public static class SearchUserPresenter  {

		RecyclerView recyclerView;
		LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext(),LinearLayoutManager.VERTICAL,false);

		UserListUI.Adapter adapter;

		public View buildView() {
			recyclerView = ViewHelper.newRecyclerViewMatch();
			adapter = new UserListUI.Adapter();
			recyclerView.setAdapter(adapter);
			recyclerView.setLayoutManager(layoutManager);
			adapter.setEmptyMessage(TRY_SEARCH);
			adapter.setRecyclerView(recyclerView);
			adapter.setEnableAutoShowEmptyView(true);
			itIsEmpty(TRY_SEARCH);
			return recyclerView;
		}

		void runQuery(String search){
			if(search!= null && search.length() >0){
				load(search);
			}else {
				itIsEmpty(TRY_SEARCH);
			}
		}

		void itIsEmpty(String msg){
			adapter.list.clear();
			adapter.showEmptyView(msg);
		}

		void load(String querey){
			Http.getPath("/v1/search/users")
				.setQueryParam("q",querey)
				.doAsyncUi(result -> {
					adapter.nextPageIsLoaded(result);
					Helper.showDebugMessage("load users 1");
					if(result.isOk()){
						HttpJsonList<UserInfoJson> data = Result.fromJsonList(result, UserInfoJson.class);
						if(data.isPayloadNoneEmpty()){
							Helper.showDebugMessage("load users 2 - "+data.Payload.size());
							adapter.list.clear();
							adapter.hideEmptyView();
							adapter.list.addAll(data.Payload);
							adapter.notifyDataChanged();
						}else {
							itIsEmpty(NO_RESULT);
						}
						adapter.notifyDataChanged();
					}
				});
		}

	}
}
