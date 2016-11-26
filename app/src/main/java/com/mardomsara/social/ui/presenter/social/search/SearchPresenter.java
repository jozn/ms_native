package com.mardomsara.social.ui.presenter.social.search;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.ui.UserListUI;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SearchPresenter extends BasePresenter {
    SearchTagsListCell listCell;
    SearchTabPagerAdaptor pad;

    @Override
    public View buildView() {
//        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.hello_world_row,null);
//        return v;

        View l = AppUtil.inflate(R.layout.nav_header_search);
        EditText search_input = (EditText)l.findViewById(R.id.search_input);
        ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
        TabLayout tab = (TabLayout)l.findViewById(R.id.sliding_tabs);
        tab.setBackgroundColor(0xeeeeee);
        pad = new SearchTabPagerAdaptor(fragment.getChildFragmentManager(),fragment.getActivity());

        tab.setTabMode(TabLayout.MODE_FIXED);
//
        vp.setAdapter(pad);
        tab.setupWithViewPager(vp);

        //must called here
        for (int i = 0; i < tab.getTabCount(); i++) {
            TabLayout.Tab t = tab.getTabAt(i);
            t.setCustomView( pad.getTabView(i) );
        }

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

        vp.setCurrentItem(pad.getCount()-1);
        return l;
    }

    void textChanged(String txt){
        if(listCell != null){
            listCell.setNewTag(txt);
            pad.presenter.listCell.setNewTag(txt);

        }
        pad.presenter.listCell.setNewTag(txt);
        AppUtil.log("listCell: " +listCell);
        AppUtil.log("listCell: " +pad.presenter.listCell);
    }

    public  class SearchTabPagerAdaptor extends FragmentPagerAdapter {
        private String tabTitles[] = new String[] { "تگ","کاربر"};//, "Tab3","Tab222","Tab222","Tab222" };
        private Context context;

        public SearchTabPagerAdaptor(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        SearchTagPagerPresenter presenter;

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    presenter = new SearchTagPagerPresenter();
                    listCell = presenter.listCell;
                    return presenter.getFragment();

                default:
                    return new SearchUserPresenter().getFragment();

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

    public static class SearchTagPagerPresenter extends BasePresenter {
        ViewGroup viewRoot;
        SearchTagsListCell listCell;

        @Override
        public View buildView() {
            listCell = new SearchTagsListCell("");
            viewRoot = listCell.getViewRoot();
            return viewRoot;
        }

    }

	public static class SearchUserPresenter extends BasePresenter {
		RecyclerView recyclerView;
		SearchTagsListCell listCell;

		UserListUI.Adapter adapter;
		@Override
		public View buildView() {
			recyclerView = ViewHelper.newRecyclerViewMatch();
			adapter = new UserListUI.Adapter();
			recyclerView.setAdapter(adapter);
			adapter.setEmptyMessage("یافت نشد");
			load();
			return recyclerView;
		}

		void load(){
			Http.getPath("/v1/search/users")
				.setQueryParam("q","ح")
				.doAsyncUi(result -> {
					if(result.isOk()){
						HttpJsonList<UserInfoJson> data = Result.fromJsonList(result, UserInfoJson.class);
						if(data.isPayloadNoneEmpty()){
							adapter.list.addAll(data.Payload);
							adapter.notifyDataChanged();
						}
					}
				});
		}

	}
}
