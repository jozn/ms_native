package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
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
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

import butterknife.Bind;

/**
 * Created by Hamid on 8/24/2016.
 */
public class TagsPresenter extends BasePresenter
        implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage{
    String tagName = "";

    ViewGroup viewRoot;
    @Bind(R.id.content)
    ViewGroup content;
    @Bind(R.id.loading) View loading;
//    @Bind(R.id.recycler_view) RecyclerView recycler_view;


    UIPostsList.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;

    public TagsPresenter(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public View buildView() {
//        viewRoot = (ViewGroup) AppUtil.inflate(R.layout.preseter_home_stream);
//        ButterKnife.bind(this, viewRoot);
        PageCells.NavAndEmptyView page = new PageCells.NavAndEmptyView();
        page.simpleTopNav.setTitle(getTagNameTitle(this.tagName));
        viewRoot = page.rootView;
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
                Helper.showDebugMessage("re");
				adaptor.reload();
//                loadFromServer();
            }
        });
//        loadFromServer();
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

	@Deprecated
	private void loadFromServer_dep() {
		AndroidUtil.runInBackground(()->{
			HttpOld.Req req = new HttpOld.Req();
//            req.absUrl = API.POSTS_STREAM_GET.toString();
//            req.absUrl = "http://localhost:5000/v1/post/stream";
			req.absPath = API.TAGS_LIST;
			req.urlParams.put("tag",tagName);
			HttpOld.Result res = HttpOld.get(req);
			if(res.ok){
				AndroidUtil.runInUi(()->{
                   /*TextView tv= (TextView)viewRoot.findViewById(R.id.loading);
                    tv.setText(res.data);*/
					loadedPostsFromNet(res);

				});
			}
		});
	}
    private void loadedPostsFromNet(HttpOld.Result res) {
//        loading.setVisibility(View.GONE);
//        content.setVisibility(View.VISIBLE);
        HomeStreamJson data= JsonUtil.fromJson(res.data, HomeStreamJson.class);
        if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){

//            content.addView(UIPostsList.buildNew(data.Load));


            //////////NEW
            if(data.Payload != null){
                adaptor.posts.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            }

//            UIPostsList_DEP.HomeStreamAdaptor_Dep adaptor = new UIPostsList_DEP.HomeStreamAdaptor_Dep();
//            adaptor.posts = data.Load;
//            recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
//            recycler_view.setAdapter(adaptor);
        }
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
