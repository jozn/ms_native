package com.mardomsara.social.ui.pages.tabs.pages;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.nav.Nav;
import com.mardomsara.social.ui.adaptors.PostsGridAdaptor;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/23/2016.
 */
public class SuggestionsPostsCell implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

    public View buildView() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
        load();
        return refreshLayout;
    }

    PostsGridAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    private void load() {
        adaptor = new PostsGridAdaptor();
        RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
        refreshLayout.addView(recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(AppUtil.getContext(),3);

        layoutManager.setSpanSizeLookup(adaptor.getSpanSizeForSimpleContentGridLayout(3));
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);
        adaptor.showLoading();

        Cells.Title_BigClickAble recent = new Cells.Title_BigClickAble(recycler_view);
        recent.setText("مشاهده جدیدترین پست ها");
        recent.setIcon("\uf2ca");

        Cells.Title_Info topTitle = new Cells.Title_Info(recycler_view);
        topTitle.setText("پست های داغ");

        recent.rootView.setOnClickListener((v)->{
            Nav.push(new LastPostsPageFragment());
        });
        adaptor.appendViewToHeader(recent.rootView);
        adaptor.appendViewToHeader(topTitle.rootView);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showDebugMessage("re");
//                loadFromServer(1);
				adaptor.reload();
            }
        });
    }

    private void loadFromServer(int page) {
		Helper.showDebugMessage("suggestion page: "+page);
        AndroidUtil.runInBackground(()->{
			Http.getPath("/v1/recommend/top_posts")
				.setQueryParam("page",""+page)
				.setQueryParam("last",""+getLastId())
				.setQueryParam("limit",""+ 45)
				.doAsyncUi((result -> {
					refreshLayout.setRefreshing(false);
					adaptor.nextPageIsLoaded(result);
					if(result.isOk()){
						HttpJsonList<JV.PostView> data = Result.fromJsonList(result,JV.PostView.class);
						if(data.isPayloadNoneEmpty()){
							if(page==1){
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

//					adaptor.nextPageIsLoaded();
				}));
        });
    }

	int getLastId(){
		/* Must be Recomendetion Id not post id - use http meta
		if(adaptor.posts.size()>0){
			return adaptor.posts.get(adaptor.posts.size()-1).Id;
		}*/
		return 0;
	}
    @Override
    public void loadNextPage(int pageNum) {
		Helper.showDebugMessage("suggestion page: "+pageNum);
		loadFromServer(pageNum);
    }
}
