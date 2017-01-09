package com.mardomsara.social.ui.presenter.social.search;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.TagRowJson;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.ui.TabPagerAdaptor;
import com.mardomsara.social.ui.ui.UserListUI;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/23/2016.
 */
//keep this for sample of Sectioned
public class SearchPresenter extends BasePresenter {
//    SearchTabPagerAdaptor pad;

	SearchTagPagerPresenter tagPresenter = new SearchTagPagerPresenter();
	SearchUserPresenter userPresenter = new SearchUserPresenter();
    @Override
    public View buildView() {

        View l = AppUtil.inflate(R.layout.nav_header_search);
        EditText search_input = (EditText)l.findViewById(R.id.search_input);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
		TabPagerAdaptor tabs = new TabPagerAdaptor();
		tabs.addTab(new TabPagerAdaptor.Tab("تگ", ()-> tagPresenter.buildView() ));
		tabs.addTab(new TabPagerAdaptor.Tab("کاربر", ()-> userPresenter.buildView() ));

//        tab.setBackgroundColor(0xeeeeee);
//        pad = new SearchTabPagerAdaptor(fragment.getChildFragmentManager(),fragment.getActivity());

//        tab.setTabMode(TabLayout.MODE_FIXED);
//
//        vp.setAdapter(pad);
		vp.setAdapter(tabs);
        tabLayout.setupWithViewPager(vp);

		tabs.setTabLayout(tabLayout);
       /* //must called here
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab t = tabLayout.getTabAt(i);
            t.setCustomView( pad.getTabView(i) );
        }*/

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

    public  class SearchTabPagerAdaptor extends FragmentPagerAdapter {
        private String tabTitles[] = new String[] { "تگ","کاربر"};
        private Context context;

        public SearchTabPagerAdaptor(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        SearchTagPagerPresenter tagPresenter;
        SearchUserPresenter userPresenter;

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    tagPresenter = new SearchTagPagerPresenter();
                    return tagPresenter.getFragment();

                default:
					userPresenter =  new SearchUserPresenter();
                    return userPresenter.getFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        public View getTabView(int position) {
            View v = LayoutInflater.from(context).inflate(R.layout.tab_cell_general, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);
            tv.setText(tabTitles[position]);
            return v;
        }
    }


	public static class SearchTagPagerPresenter extends BasePresenter {
		RecyclerView recyclerView;
		LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext(),LinearLayoutManager.VERTICAL,false);
		SearchResultTagsListCell.TagsAdaptor adapter;

		@Override
		public View buildView() {
			recyclerView = ViewHelper.newRecyclerViewMatch();
			adapter = new SearchResultTagsListCell.TagsAdaptor();
			recyclerView.setAdapter(adapter);
			recyclerView.setLayoutManager(layoutManager);
			adapter.setEmptyMessage("یافت نشد");
			adapter.setEnableAutoShowEmptyView(true);
			return recyclerView;
		}

		void runQuery(String search){
			if(search!= null && search.length() >0){
				load(search);
			}
		}

		void load(String query){
			Http.getPath("/v1/search/tags")
				.setQueryParam("q",query)
				.doAsyncUi(result -> {
					adapter.nextPageIsLoaded();
					if(result.isOk()){
						HttpJsonList<TagRowJson> data = Result.fromJsonList(result, TagRowJson.class);
						if(data.isPayloadNoneEmpty()){
							adapter.list.clear();
							adapter.list.addAll(data.Payload);
							adapter.notifyDataChanged();
						}else {
							adapter.list.clear();
							adapter.showEmptyView();
						}
						adapter.notifyDataChanged();
					}
				});
		}

	}

	public static class SearchUserPresenter extends BasePresenter {
		RecyclerView recyclerView;
		LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext(),LinearLayoutManager.VERTICAL,false);

		UserListUI.Adapter adapter;
		@Override
		public View buildView() {
			recyclerView = ViewHelper.newRecyclerViewMatch();
			adapter = new UserListUI.Adapter();
			recyclerView.setAdapter(adapter);
			recyclerView.setLayoutManager(layoutManager);
			adapter.setEmptyMessage("یافت نشد");
			adapter.setEnableAutoShowEmptyView(true);
			return recyclerView;
		}

		void runQuery(String search){
			if(search!= null && search.length() >0){
				load(search);
			}
		}

		void load(String querey){
			Http.getPath("/v1/search/users")
				.setQueryParam("q",querey)
				.doAsyncUi(result -> {
					adapter.nextPageIsLoaded();
					Helper.showDebugMessage("load users 1");
					if(result.isOk()){
						HttpJsonList<UserInfoJson> data = Result.fromJsonList(result, UserInfoJson.class);
						if(data.isPayloadNoneEmpty()){
							adapter.list.clear();
							Helper.showDebugMessage("load users 2 - "+data.Payload.size());
							adapter.list.addAll(data.Payload);
							adapter.notifyDataChanged();
						}else {
							adapter.list.clear();
							adapter.showEmptyView();
						}
						adapter.notifyDataChanged();
					}
				});
		}

	}
}
