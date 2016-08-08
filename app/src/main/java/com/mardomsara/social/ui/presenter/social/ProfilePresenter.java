package com.mardomsara.social.ui.presenter.social;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.social.HomeStreamJson;
import com.mardomsara.social.json.social.ProfileAndPostsJson;
import com.mardomsara.social.json.social.server.ServerUserTable;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/14/2016.
 */
public class ProfilePresenter extends BasePresenter implements AppHeaderFooterRecyclerViewAdapter.LoadNextPage {

//    @Bind(R.id.fullname) TextView fullname;

    ViewGroup viewRoot;
    @Bind(R.id.simpleTopNav) SimpleTopNav nav;
    int UserId;
    public ProfilePresenter(int userId) {
        UserId = userId;
    }

    @Override
    public View buildView() {
        viewRoot =(ViewGroup) AppUtil.inflate(R.layout.presenter_profile);
        ButterKnife.bind(this,viewRoot);
        nav.setTitle("پروفایل");
        load();
        return viewRoot;
    }

    ProfileTopInfo profileTopInfo;
    UIPostsList.PostsAdaptor adaptor;
    SwipeRefreshLayout refreshLayout;
    private void load() {
        refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
        adaptor = new UIPostsList.PostsAdaptor();
        profileTopInfo = new ProfileTopInfo();
        adaptor.appendViewToHeader(profileTopInfo.view);
//        RecyclerView rv = UIPostsList.buildNew(adaptor);
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
                loadPostsAndProfileFromServer(1);
            }
        });

//        loadPostsAndProfileFromServer();
    }

    //////////////////////////////////////////////////////////////////
    //// For profile ///////////////////
    private void loadPostsAndProfileFromServer(int page) {
        int pageCnt = page -1;
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
//            req.absPath = API.POSTS_STREAM_GET.toString();
            req.absPath = API.PROFILE_ALL.toString();
            req.urlParams.put("profile_id",""+UserId);
            req.urlParams.put("page",""+pageCnt);
            Http.Result res = Http.get(req);
            if(res.ok){
                AndroidUtil.runInUi(()->{
                   /*TextView tv= (TextView)viewRoot.findViewById(R.id.loading);
                    tv.setText(res.data);*/
                    loadedPostsAndProfileFromNet(res);

                });
            }
            AndroidUtil.runInUiNoPanic(()->{
                refreshLayout.setRefreshing(false);
            });
        });
    }

    private void loadedPostsAndProfileFromNet(Http.Result res) {
        ProfileAndPostsJson data= JsonUtil.fromJson(res.data, ProfileAndPostsJson.class);
        if(data != null && data.Status.equalsIgnoreCase("OK")){
            AndroidUtil.runInUiNoPanic(()->{
                profileTopInfo.bind(data.Payload.User);
                adaptor.posts.clear();
                adaptor.posts.addAll(data.Payload.Posts);
                adaptor.notifyDataSetChanged();
            });
        }
    }
    ///////////////////////////////////////////////////////////////////////

    private void loadPostsFromServer(int page) {
        int pageCnt = page -1;
        AndroidUtil.runInBackground(()->{
            Http.Req req = new Http.Req();
//            req.absPath = API.POSTS_STREAM_GET.toString();
            req.absPath = API.PROFILE_POSTS.toString();
            req.urlParams.put("profile_id",""+UserId);
            req.urlParams.put("peer_id",""+UserId);
            req.urlParams.put("page",""+pageCnt);
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
            AndroidUtil.runInUiNoPanic(()->{
                adaptor.posts.addAll(data.Payload);
                adaptor.notifyDataSetChanged();
            });
        }
    }

    @Override
    public void loadNextPage(int pageNum) {
        Helper.showMessage("load next"+pageNum);
        if(pageNum <= 1){
            loadPostsAndProfileFromServer(1);
        }else {
            loadPostsFromServer(pageNum);
        }
    }


    public static View.OnClickListener getFollowings_click(int Userid) {
        return (v)->{
            Nav.push(new FollowsListPresenter(Userid, FollowsListPresenter.Type.FOLLOWING));
        };
    }

    public static View.OnClickListener getFollers_click(int Userid) {
        return (v)->{
            Nav.push(new FollowsListPresenter(Userid, FollowsListPresenter.Type.FOLLOWERS));
        };
    }

    static class ProfileTopInfo{
        View view;
        @Bind(R.id.avatar) SimpleDraweeView avatar;
        @Bind(R.id.fullname) TextView fullname;
        @Bind(R.id.about) TextView about;

        @Bind(R.id.posts_count) TextView posts_count;
        @Bind(R.id.followings_count) TextView followings_count;
        @Bind(R.id.followers_count) TextView followers_count;

        @Bind(R.id.followers_holder) View followers_holder;
        @Bind(R.id.followings_holder) View followings_holder;

        public ProfileTopInfo() {
            view = AppUtil.inflate(R.layout.profile_top_info);
            ButterKnife.bind(this,view);
        }

        ProfileTopInfo bind(ServerUserTable user){

            Helper.SetAvatar(avatar,user.AvatarUrl);
            fullname.setText(user.getFullName());
            about.setText(""+user.About);

            posts_count.setText(""+user.PostsCount);
            followings_count.setText(""+user.FollowingCount);
            followers_count.setText(""+user.FollowersCount);

            //clicks
            followings_holder.setOnClickListener(getFollowings_click(user.Id));
            followers_holder.setOnClickListener(getFollers_click(user.Id));

            return this;
        }
    }

}
