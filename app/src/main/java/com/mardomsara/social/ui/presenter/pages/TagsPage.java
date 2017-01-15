package com.mardomsara.social.ui.presenter.pages;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import butterknife.Bind;

/**
 * Created by Hamid on 8/24/2016.
 */
public class TagsPage extends BasePresenter
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage{
    String tagName = "";

    ViewGroup viewRoot;
    @Bind(R.id.content)
    ViewGroup content;
    @Bind(R.id.loading) View loading;


    UIPostsList.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    public TagsPage(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public View buildView() {
        Cells.NavAndEmptyView page = new Cells.NavAndEmptyView();
        page.simpleTopNav.setTitle(getTagNameTitle(this.tagName));
        viewRoot = page.rootView;
        load();
        return viewRoot;
    }

    private void load() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
        adaptor = new UIPostsList.PostsAdaptor();
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);
        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        viewRoot.addView(refreshLayout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("re");
				adaptor.reload();
            }
        });
    }

    private void loadFromServer(int pageNum) {
		Http.getPath("/v1/tags/list")
			.setQueryParam("tag",tagName)
			.setQueryParam("limit",30)
			.setQueryParam("last","")
			.doAsyncUi((result -> {

				refreshLayout.setRefreshing(false);
				adaptor.nextPageIsLoaded();

				if(result.isOk()){
					HttpJsonList<PostRowJson> data = Result.fromJsonList(result,PostRowJson.class);
					if(data.isPayloadNoneEmpty()){
						if(pageNum==1){
							adaptor.posts.clear();
						}
						adaptor.posts.addAll(data.Payload);
						adaptor.notifyDataSetChanged();
					}else {
						adaptor.setHasMorePage(false);
					}
				}else {
					adaptor.setHasMorePage(false);
				}

			}));
    }

	String getTagNameTitle(String tagName){
		if(tagName!=null&&tagName.length()>0){
			if(!tagName.startsWith("#")) {
				return "#" + tagName;
			}
			else {
				return tagName;
			}
		}
		return "";
	}

    @Override
    public void loadNextPage(int pageNum) {
		Helper.showDebugMessage("tags list: "+pageNum);
		loadFromServer(pageNum);
    }
}
