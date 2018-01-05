package com.mardomsara.social.ui.pages.tabs.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;

/**
 * Created by Hamid on 8/14/2016.
 */
public class ProfilePageFragment extends FragmentPage {

	static final String USER_ID = "USER_ID";
	static final String USER_Name = "USER_Name";
	static final String IS_MY_PROFILE = "IS_MY_PROFILE";

	X.Profile_Parent x;
	int UserId;
	String userName = "";
	boolean isMyProfile = false;
	ProfileTopInfo profileTopInfo;
	PostGeneralListCell postCell;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getArguments() != null){
			UserId = getArguments().getInt(USER_ID);
			userName = getArguments().getString(USER_Name);
			this.isMyProfile = getArguments().getInt(IS_MY_PROFILE) == 1;
		}
	}

	public static ProfilePageFragment newInstance(int userId, String userName, boolean isMyProfile) {
		Bundle bundle = new Bundle();
		bundle.putInt(USER_ID, userId);
		bundle.putString(USER_Name, userName);
		bundle.putInt(IS_MY_PROFILE, isMyProfile ? 1 : 0);
		ProfilePageFragment fragment = new ProfilePageFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	public static View.OnClickListener getFollowings_click(int Userid) {
		return (v) -> {
			Router.goToFollowingsPage(Userid);
		};
	}

	public static View.OnClickListener getFollowers_click(int Userid) {
		return (v) -> {
			Router.goToFollowersPage(Userid);
		};
	}

	@Override
	public View getView(Bundle savedInstanceState) {
		x = new X.Profile_Parent();
		x.top_nav.setTitle("پروفایل");

		if (isMyProfile) {
			x.top_nav.setVisibility(View.GONE);
		}
		load2();

		return x.root;
	}

	////////////////////////////////////////////////////////////

	void load2() {
		profileTopInfo = new ProfileTopInfo(UserId);

		if (Session.isUserIdMe(UserId)) {
			profileTopInfo.bind(Session.loadUserInfo());
		}

		postCell = new PostGeneralListCell(x.top_nav.getButtonPostMultiWayView(), (page, cell) -> {
			if (page == 1) {
				loadToInfoFromServer();
			}

			Http.getPath("/v1/profile/posts")
				.setQueryParam("page", "" + page)
				.setQueryParam("last", "" + cell.getLastPostId(page))
				.setQueryParam("profile_id", "" + UserId)
				.setQueryParam("user_name", "" + userName)
				.doAsyncUi((result) -> {
					cell.loadedPostsFromNetNew(result, page);
				});
		});

//		postCell.loadFromServer(1);

		postCell.getAdaptor().appendViewToHeader(profileTopInfo.x.root);

		x.container.addView(postCell.getViewRoot());

//		loadToInfoFromServer();

	}

	private void loadToInfoFromServer() {
		if (Session.isUserIdMe(UserId)) {
			Session.fetchUserInfoFromServer();
		}

		Http.getPath("/v1/profile/info")
			.setQueryParam("profile_id", "" + UserId)
			.setQueryParam("user_name", "" + userName)
			.doAsyncUi((result) -> {
				if (result.isOk()) {
					HttpJson<JV.UserMeView> data = Result.fromJson(result, JV.UserMeView.class);
					if (data.isPayloadNoneEmpty()) {
						profileTopInfo.bind(data.Payload);
					}
				}
			});
	}

	static class ProfileTopInfo {
		int UserId;
		X.Profile_TopInfo x;

		public ProfileTopInfo(int userId) {
			x = new X.Profile_TopInfo();

			UserId = userId;
			hideShowMyButns();
		}

		ProfileTopInfo bind(JV.UserMeView user) {
			if (user == null) return this;

			hideShowMyButns();

			Helper.SetAvatar(x.avatar, user.AvatarUrl);
			x.fullname.setText(user.FullName);
			x.about.setText("" + user.About);

			x.posts_count.setText("" + user.PostsCount);
			x.followings_count.setText("" + user.FollowingCount);
			x.followers_count.setText("" + user.FollowersCount);

			//clicks
			x.followings_holder.setOnClickListener(getFollowings_click(user.Id));
			x.followers_holder.setOnClickListener(getFollowers_click(user.Id));

			x.chat_button.setUser(user);
			x.follow_button.setUser(user);

			return this;
		}

		void hideShowMyButns() {
			x.button_edit_profile.setIconAndClicker("ویرایش پروفایل {icon-energy 26dp}", () -> {

			});

			if (Session.isUserIdMe(UserId)) {
				x.chat_button.setVisibility(View.GONE);
				x.follow_button.setVisibility(View.GONE);
				x.button_edit_profile.setVisibility(View.VISIBLE);
			} else {
				x.chat_button.setVisibility(View.VISIBLE);
				x.follow_button.setVisibility(View.VISIBLE);
				x.button_edit_profile.setVisibility(View.GONE);
			}
		}
	}

}
