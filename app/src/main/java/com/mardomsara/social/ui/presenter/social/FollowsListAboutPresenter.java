package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.lists.UserListWithAboutCell;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/6/2016.
 */
public class FollowsListAboutPresenter extends BasePresenter implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

    public enum Type {
        FOLLOWING,
        FOLLOWERS,
        LIKES
    }

    PageCells.NavAndRecylerView pageCell;


    int ObjectId;
    Type listType;
    String urlEndpoint;

    public FollowsListAboutPresenter(int objectId, Type type) {
        ObjectId = objectId;
        this.listType = type;
    }

    @Override
    public View buildView() {
        pageCell = new PageCells.NavAndRecylerView();
        init();
        return pageCell.rootView;
    }

    SwipeRefreshLayout refreshLayout;
    RecyclerView recycler_view;
    LinearLayoutManager layoutManager;
    UserListWithAboutCell.Adapter adaptor;
    void init() {
        try {
            setTitle();
            setUrl();

            refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);

            recycler_view = ViewHelper.newRecyclerViewMatch();
            layoutManager = new LinearLayoutManager(AppUtil.getContext());
            recycler_view.setLayoutManager(layoutManager);
//            adaptor = new UserListUI.Adapter();
            adaptor = new UserListWithAboutCell.Adapter();
            recycler_view.setAdapter(adaptor);
            adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);

            refreshLayout.addView(recycler_view);
            pageCell.rootView.addView(refreshLayout);

            loadFromServer(1);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    loadFromServer(1);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadNextPage(int pageNum) {
//        loadFromServer(pageNum);
    }

    private void loadFromServer(int page) {
        int pageCnt = page -1;

		Http.get(urlEndpoint)
			.setQueryParam("username","abas")
			.setQueryParam("peer_id",""+ObjectId)
			.setQueryParam("post_id",""+ObjectId)
			.doAsyncUi((result)->{
				if(result.isOk()){
					HttpJsonList<UserInfoJson> data = Result.fromJsonList(result, UserInfoJson.class);
					if(data.isPayloadNoneEmpty()){
						if(page <= 1) adaptor.list.clear();
						if(data.Payload != null && data.Payload.size() >0){
							adaptor.list.addAll(data.Payload);
							adaptor.notifyDataSetChanged();
						}
					}else {
						adaptor.setHasMorePage(false);
					}
				}else {
					Helper.showDebugMessage("load next"+pageCnt);
						adaptor.setHasMorePage(false);
					}
					AndroidUtil.runInUiNoPanic(()->{
						refreshLayout.setRefreshing(false);
					});

			});


        /*AndroidUtil.runInBackgroundNoPanic(()->{
            HttpOld.Req req = new HttpOld.Req();
            req.urlParams.put("username","abas");
            req.urlParams.put("peer_id",""+ObjectId);// for follows types
            req.urlParams.put("post_id",""+ObjectId);// for follows types
            req.absPath = urlEndpoint;
            HttpOld.Result res = HttpOld.get(req);

            boolean hideLoading = false;
            AndroidUtil.runInUiNoPanic(() -> {
                if(res.ok) {
                    LikesListJson data = JsonUtil.fromJson(res.data, LikesListJson.class);
                    if (data.Status.equalsIgnoreCase("OK") && data.Payload != null && data.Payload.size() >0) {
                        if(page <= 1) adaptor.list.clear();
                        if(data.Payload != null && data.Payload.size() >0){
                            adaptor.list.addAll(data.Payload);
                            adaptor.notifyDataSetChanged();
                        }
                    }else {
                        adaptor.setHasMorePage(false);
                    }
                }else {
                    Helper.showDebugMessage("load next"+pageCnt);
                    adaptor.setHasMorePage(false);
                }
                AndroidUtil.runInUiNoPanic(()->{
                    refreshLayout.setRefreshing(false);
                });
            });

        });*/
    }

    void setTitle() {
        String title ="دنبال کنندگان";
        switch (listType){
            case FOLLOWING:
                title ="دنبال کنندگان";
                break;
            case FOLLOWERS:
                title ="دنبال می کند";
                break;
            case LIKES:
                title ="پسندیدند";
        }
        pageCell.simpleTopNav.setTitle(title);
    }

    void setUrl() {
        urlEndpoint = API.FOLLOWERS_GET.toString();
        switch (listType){
            case FOLLOWING:
                urlEndpoint = API.FOLLOWINGS_GET.toString();
                break;
            case FOLLOWERS:
                urlEndpoint = API.FOLLOWERS_GET.toString();
                break;
            case LIKES:
                urlEndpoint = API.LIKES_GET.toString();;
        }
    }
}
