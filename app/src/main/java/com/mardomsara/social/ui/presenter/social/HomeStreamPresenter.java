package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.HomeStreamJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.cells.PageCells;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import butterknife.Bind;

/**
 * Created by Hamid on 7/13/2016.
 */
public class HomeStreamPresenter extends BasePresenter implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
    ViewGroup viewRoot;
    @Bind(R.id.content)
    ViewGroup content;
    @Bind(R.id.loading) View loading;
//    @Bind(R.id.recycler_view) RecyclerView recycler_view;


    UIPostsList.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;
    @Override
    public View buildView() {
//        viewRoot = (ViewGroup) AppUtil.inflate(R.layout.preseter_home_stream);
//        ButterKnife.bind(this, viewRoot);
        viewRoot = new PageCells.NavAndEmptyView().rootView;
        load();
//        loadFromServer();
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
//        adaptor.setRecyclerView(recycler_view);
        adaptor.showLoading();

        refreshLayout.addView(recycler_view);
        viewRoot.addView(refreshLayout);
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
//            req.absPath = API.POSTS_STREAM_GET.toString();
            req.absPath = "http://localhost:5000/v1/post/stream";
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                   /*TextView tv= (TextView)viewRoot.findViewById(R.id.loading);
                    tv.setText(res.data);*/
                    loadedPostsFromNet(res);

                });
            }
        });
    }

    private void loadedPostsFromNet(Http.Result res) {
//        loading.setVisibility(View.GONE);
//        content.setVisibility(View.VISIBLE);
        HomeStreamJson data= JsonUtil.fromJson(res.data, HomeStreamJson.class);
        if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){

//            content.addView(UIPostsList.buildNew(data.Payload));


            //////////NEW
            if(data.Payload != null){
                adaptor.posts.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            }

//            UIPostsList_DEP.HomeStreamAdaptor_Dep adaptor = new UIPostsList_DEP.HomeStreamAdaptor_Dep();
//            adaptor.posts = data.Payload;
//            recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
//            recycler_view.setAdapter(adaptor);
        }
    }

    @Override
    public void loadNextPage(int pageNum) {

    }
}
