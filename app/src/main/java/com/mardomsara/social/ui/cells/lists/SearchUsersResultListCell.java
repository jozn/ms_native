package com.mardomsara.social.ui.cells.lists;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.http.HomeStreamJson;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/29/2016.
 */
public class SearchUsersResultListCell {
/*    public SearchUsersResultListCell() {
        init();
    }

    private void init() {
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
                Helper.showMessage("re");
                loadFromServer(0);
            }
        });
//        loadFromServer();
    }

    String endPointAbsPath;
    public void setLoadingEndPoint(String absUrl){
        this.endPointAbsPath = absUrl;
    }

    public void loadFromServer(int page) {
        if(endPointAbsPath == null){
            throw new IllegalArgumentException("In PostsListCell endPointAbsPath url must be set for loading posts");
        }
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();

            req.absUrl = endPointAbsPath;
            req.urlQueryParams.put("page",""+page);
            req.urlQueryParams.put("last",""+getLastPostId());
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                    loadedPostsFromNet(res, page);
                });
            }
        });
    }



    public ViewGroup getViewRoot() {
        return refreshLayout;
    }*/

}
