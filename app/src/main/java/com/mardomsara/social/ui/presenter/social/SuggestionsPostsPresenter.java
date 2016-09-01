package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.HomeStreamJson;
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

//        LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
        GridLayoutManager layoutManager = new GridLayoutManager(AppUtil.getContext(),3);
        /*layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int size = adaptor.posts.size();
                if(position == 0 ) return 3;
                if(position == size ) return 3;
                return 1;
            }
        });*/
        layoutManager.setSpanSizeLookup(adaptor.getSpanSizeForSimpleContentGridLayput(3));
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adaptor);
        adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);
//        adaptor.setRecyclerView(recycler_view);
        adaptor.showLoading();

        TitleCellsGroup.BigClickAbleTitle recent = new TitleCellsGroup.BigClickAbleTitle(recycler_view);
        recent.setText("مشاهده جدیدترین پست ها");
        recent.setIcon("\uf2ca");

        TitleCellsGroup.InfoTitle topTitle = new TitleCellsGroup.InfoTitle(recycler_view);
        topTitle.setText("پست های داغ");

//        TextView txt2 = new TextView(AppUtil.getContext());
//        View txt = AppUtil.inflate(R.layout.title_string_clickable,recycler_view);
//        View txt3 = AppUtil.inflate(R.layout.title_string_clickable,recycler_view);
//        txt2.setText("زنزده");
        recent.rootView.setOnClickListener((v)->{
            Nav.push(new LastPostsPresenter());
        });
        adaptor.appendViewToHeader(recent.rootView);
        adaptor.appendViewToHeader(topTitle.rootView);
//        txt3.setLayoutParams();
//        adaptor.appendViewToHeader(txt2);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Helper.showMessage("re");
                loadFromServer();
            }
        });
        loadFromServer();
    }

    private void loadFromServer() {
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
            req.absPath = API.RECOMMEND_TOP_POST;
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedPostsFromNet(res);
                });
            }
        });
    }

    private void loadedPostsFromNet(Http.Result res) {
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

    }
}
