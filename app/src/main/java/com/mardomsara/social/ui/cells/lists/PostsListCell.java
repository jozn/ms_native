package com.mardomsara.social.ui.cells.lists;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.http.HomeStreamJson;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class PostsListCell
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

    View loading;
    public UIPostsList.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    public PostsListCell() {
        init();
    }

    private void init() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
        adaptor = new UIPostsList.PostsAdaptor();
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);
        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("reload");
                loadFromServer(1);
            }
        });
    }

    String endPointAbsPath;
    public void setLoadingEndPoint(String absPath){
        this.endPointAbsPath = absPath;
    }

    public void loadFromServer(int page) {
        if(endPointAbsPath == null){
            throw new IllegalArgumentException("In PostsListCell endPointAbsPath url must be setOrReplace for loading posts");
        }

		Http.get(endPointAbsPath)
			.setQueryParam("page",""+page)
			.setQueryParam("last",""+getLastPostId(page))
			.doAsyncUi((result)->{
				loadedPostsFromNetNew(result,page);
				adaptor.nextPageIsLoaded();
			});
    }

    private int getLastPostId(int page) {
		if(page == 1)return 0;//fix for refreshing
        if(adaptor.posts.size() > 0 ){
            return adaptor.posts.get(adaptor.posts.size()-1).Id;
        }
        return 0;
    }

	private void loadedPostsFromNetNew(Result res, int page) {
		hideRefreshLoading();
		HttpJsonList<PostRowJson> data= Result.fromJsonList(res, PostRowJson.class);
		if(data != null){
			AndroidUtil.runInUiNoPanic(()->{
				if(data.Payload.size() == 0){
					adaptor.setHasMorePage(false);
				}
				if( data.isPayloadNoneEmpty() ){
					if(page == 1){
						adaptor.posts.clear();
					}
					adaptor.posts.addAll(data.Payload);
					adaptor.notifyDataSetChanged();
				}
			});
		}
	}

	private void hideRefreshLoading(){
		refreshLayout.setRefreshing(false);
	}

    public ViewGroup getViewRoot() {
        return refreshLayout;
    }

	//pageNum is >= 1
    @Override
    public void loadNextPage(int pageNum) {
        Helper.showDebugMessage("pageNum: "+pageNum);
        loadFromServer(pageNum);
    }
}


/*
AndroidUtil.runInBackground(()->{
	HttpOld.Req req = new HttpOld.Req();

	req.absPath = endPointAbsPath;
	req.urlParams.put("page",""+page);
	req.urlParams.put("last",""+getLastPostId());
	HttpOld.Result res = HttpOld.get(req);
	if(res.ok){
	AndroidUtil.runInUi(()->{
	loadedPostsFromNet(res, page);
	});
	}
	});

	@Deprecated
    private void loadedPostsFromNet(HttpOld.Result res, int page) {
		hideRefreshLoading();
        HomeStreamJson data= JsonUtil.fromJson(res.data, HomeStreamJson.class);
        if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){
            if(data.Payload != null){
                if(page == 0){
                    adaptor.posts.clear();
                }
                adaptor.posts.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            }
        }
    }



*/

