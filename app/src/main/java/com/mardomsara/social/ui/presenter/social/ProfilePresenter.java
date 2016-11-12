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
import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.http.HomeStreamJson;
import com.mardomsara.social.json.social.http.ProfileAndPostsJson;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.json.social.rows.UserTableJson;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.lists.PostsListCell;
import com.mardomsara.social.ui.ui.UIPostsList;
import com.mardomsara.social.ui.views.helpers.ViewHelper;
import com.mardomsara.social.ui.views.wigets.ChatButtonView;
import com.mardomsara.social.ui.views.wigets.FollowingButtonView;
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
    boolean isMyProfile =false;
    public ProfilePresenter(int userId) {
        UserId = userId;
    }

    @Override
    public View buildView() {
        viewRoot =(ViewGroup) AppUtil.inflate(R.layout.presenter_profile);
        ButterKnife.bind(this,viewRoot);
        nav.setTitle("پروفایل");
        load2();
        return viewRoot;
    }

    ProfileTopInfo profileTopInfo;
//    UIPostsList.PostsAdaptor adaptor;
	public UIPostsList.PostsAdaptor adaptor;
	PostsListCell postsListCell;
    SwipeRefreshLayout refreshLayout;

	void load2(){//copy of PostsListCell
		profileTopInfo = new ProfileTopInfo(UserId);
		refreshLayout = ViewHelper.newSwipeRefreshLayout(ViewHelper.MATCH_PARENT,ViewHelper.MATCH_PARENT);
		adaptor = new UIPostsList.PostsAdaptor();
		RecyclerView recycler_view = ViewHelper.newRecyclerViewMatch();
		LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
		recycler_view.setLayoutManager(layoutManager);
		recycler_view.setAdapter(adaptor);
		adaptor.setUpForPaginationWith(recycler_view,layoutManager,this);
		adaptor.showLoading();

		adaptor.appendViewToHeader(profileTopInfo.view);

		refreshLayout.addView(recycler_view);

		viewRoot.addView(refreshLayout);

		if(Session.isUserIdMe(UserId)){
			profileTopInfo.bind(Session.getUserInfo());
		}

		reload();
		refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				Helper.showDebugMessage("reload");
				reload();
			}
		});
	}

	void reload(){
		loadToInfoFromServer();
		loadPostsFromServer2(1);
	}

	private void loadToInfoFromServer() {
		Http.getPath("/v1/profile/info")
			.setQueryParam("profile_id",""+UserId)
			.doAsyncUi((result)->{
				if(result.isOk()){
					HttpJson<UserTableJson> data = Result.fromJson(result,UserTableJson.class);
					if(data.isPayloadNoneEmpty()){
						profileTopInfo.bind(data.Payload);
						adaptor.notifyDataSetChanged();
					}
				}
			});
	}

	private void loadPostsFromServer2(int page) {
		Http.getPath("/v1/profile/posts")
			.setQueryParam("page",""+page)
			.setQueryParam("last",""+getLastPostId(page))
			.setQueryParam("profile_id",""+UserId)
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
			AndroidUtil.runInUi(()->{
				if(!data.isPayloadNoneEmpty() ){
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

	@Override
	public void loadNextPage(int pageNum) {
		Helper.showMessage("load next"+pageNum);
		if(pageNum <= 1){
			reload();
		}else {
			loadPostsFromServer2(pageNum);
		}
	}


	////////////////////////////////////////////////////////////

    public static View.OnClickListener getFollowings_click(int Userid) {
        return (v)->{
//            Nav.push(new FollowsListPresenter(Userid, FollowsListPresenter.Type.FOLLOWING));
            Nav.push(Router.getFollowingsPage(Userid));
        };
    }

    public static View.OnClickListener getFollowers_click(int Userid) {
        return (v)->{
            Nav.push(Router.getFollowersPage(Userid));
//            Nav.push(new FollowsListPresenter(Userid, FollowsListPresenter.Type.FOLLOWERS));
        };
    }

    static class ProfileTopInfo{
		int UserId;

        View view;
        @Bind(R.id.avatar) SimpleDraweeView avatar;
        @Bind(R.id.fullname) TextView fullname;
        @Bind(R.id.about) TextView about;

        @Bind(R.id.posts_count) TextView posts_count;
        @Bind(R.id.followings_count) TextView followings_count;
        @Bind(R.id.followers_count) TextView followers_count;

        @Bind(R.id.followers_holder) View followers_holder;
        @Bind(R.id.followings_holder) View followings_holder;

        @Bind(R.id.chat_button) ChatButtonView chat_button;
        @Bind(R.id.follow_button) FollowingButtonView follow_button;

        public ProfileTopInfo(int userId) {
            view = AppUtil.inflate(R.layout.profile_top_info);
            ButterKnife.bind(this,view);
			UserId=userId;
			hideShowMyButns();
        }

        ProfileTopInfo bind(UserTableJson user){
			if(user == null)return this;

			hideShowMyButns();

            Helper.SetAvatar(avatar,user.AvatarUrl);
            fullname.setText(user.getFullName());
            about.setText(""+user.About);

            posts_count.setText(""+user.PostsCount);
            followings_count.setText(""+user.FollowingCount);
            followers_count.setText(""+user.FollowersCount);

            //clicks
            followings_holder.setOnClickListener(getFollowings_click(user.Id));
            followers_holder.setOnClickListener(getFollowers_click(user.Id));

			chat_button.setUser(user);
			follow_button.setUser(user);

            return this;
        }

		void hideShowMyButns(){
			if(Session.isUserIdMe(UserId)){
				chat_button.setVisibility(View.GONE);
				follow_button.setVisibility(View.GONE);
			}else {
				chat_button.setVisibility(View.VISIBLE);
				follow_button.setVisibility(View.VISIBLE);
			}
		}
    }

}
