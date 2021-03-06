package com.mardomsara.social.ui.pages.tabs.pages;

import android.os.Bundle;
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
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.cells.lists.UserListWithAboutCell;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 8/6/2016.
 */
public class FollowsListAboutPageFragment extends FragmentPage implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

	static final String OBJECT_ID = "POST_JSON";
	static final String ENUM_TYPE_ID = "POST_JSON";
    public enum Type {
        FOLLOWING,
        FOLLOWERS,
        LIKES
    }

    Cells.NavAndRecylerView pageCell;


    int ObjectId;
    Type listType;
    String urlEndpoint;

	public FollowsListAboutPageFragment() {
	}

	public static FollowsListAboutPageFragment newInstance(int objectId, Type type){
		Bundle bundle = new Bundle();
		bundle.putInt(OBJECT_ID,objectId);
		bundle.putString(ENUM_TYPE_ID,type.name());
		FollowsListAboutPageFragment fragment = new FollowsListAboutPageFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View getView(Bundle savedInstanceState) {
        pageCell = new Cells.NavAndRecylerView();
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
			adaptor.setEnableAutoShowEmptyView(true);

            refreshLayout.addView(recycler_view);
            pageCell.rootView.addView(refreshLayout);

//            loadFromServer(1);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    adaptor.reload();
//                    loadFromServer(1);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadNextPage(int pageNum) {
		Helper.showDebugMessage("pageNum: * " + pageNum);
        loadFromServer(pageNum);
    }

    private void loadFromServer(int page) {
//        int pageCnt = page ;

		Http.get(urlEndpoint)
			.setQueryParam("username","abas")
			.setQueryParam("peer_id",""+ObjectId)
			.setQueryParam("post_id",""+ObjectId)
			.setQueryParam("page",""+page)
			.setQueryParam("limit",""+10)
			.doAsyncUi((result)->{
				adaptor.nextPageIsLoaded();
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
					Helper.showDebugMessage("load next"+page);
						adaptor.setHasMorePage(false);
				}
				AndroidUtil.runInUiNoPanic(()->{
					refreshLayout.setRefreshing(false);
				});

			});

    }

    void setTitle() {
        String title ="دنبال کنندگان";
        switch (listType){
            case FOLLOWING:
                title ="دنبال می کند";
                break;
            case FOLLOWERS:
                title ="دنبال کنندگان";
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
