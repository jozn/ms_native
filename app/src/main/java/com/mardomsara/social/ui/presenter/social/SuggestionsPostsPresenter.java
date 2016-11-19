package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.API;
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
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.TitleCellsGroup;
import com.mardomsara.social.ui.ui.UIPostsListGrid;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SuggestionsPostsPresenter extends BasePresenter
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
    @Override
    public View buildView() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
        load();
        return refreshLayout;
    }

    UIPostsListGrid.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    private void load() {
        adaptor = new UIPostsListGrid.PostsAdaptor();
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        refreshLayout.addView(recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(AppUtil.getContext(),3);

        layoutManager.setSpanSizeLookup(adaptor.getSpanSizeForSimpleContentGridLayout(3));
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);
        adaptor.showLoading();

        TitleCellsGroup.BigClickAbleTitle recent = new TitleCellsGroup.BigClickAbleTitle(recycler_view);
        recent.setText("مشاهده جدیدترین پست ها");
        recent.setIcon("\uf2ca");

        TitleCellsGroup.InfoTitle topTitle = new TitleCellsGroup.InfoTitle(recycler_view);
        topTitle.setText("پست های داغ");

        recent.rootView.setOnClickListener((v)->{
            Nav.push(new LastPostsPresenter());
        });
        adaptor.appendViewToHeader(recent.rootView);
        adaptor.appendViewToHeader(topTitle.rootView);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("re");
                loadFromServer(1);
            }
        });
    }

    private void loadFromServer(int page) {
        AndroidUtil.runInBackground(()->{
			Http.getPath("/v1/recommend/top_posts")
				.setQueryParam("page",""+page)
				.doAsyncUi((result -> {
					if(result.isOk()){
						HttpJsonList<PostRowJson> data = Result.fromJsonList(result,PostRowJson.class);
						if(data.isPayloadNoneEmpty()){
							if(page==1){
								adaptor.posts.clear();
							}
							adaptor.posts.addAll(data.Payload);
							adaptor.notifyDataSetChanged();
						}else {
							adaptor.hideLoading();
						}
					}else {
						adaptor.hideLoading();
					}
				}));
        });
    }

	@Deprecated
	private void loadFromServer_bk() {
		AndroidUtil.runInBackground(()->{
			HttpOld.Req req = new HttpOld.Req();
			req.absPath = API.RECOMMEND_TOP_POST;
			HttpOld.Result res = HttpOld.get(req);
			if(res.ok){
				AndroidUtil.runInUi(()->{
					loadedPostsFromNet(res);
				});
			}
		});
	}

	@Deprecated
    private void loadedPostsFromNet(HttpOld.Result res) {
        HomeStreamJson data= JsonUtil.fromJson(res.data, HomeStreamJson.class);
        if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){

            if(data.Payload != null){
                adaptor.posts.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void loadNextPage(int pageNum) {
		Helper.showDebugMessage("suggestion page: "+pageNum);
		loadFromServer(1);
    }
}
