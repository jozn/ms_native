package com.mardomsara.social.ui.presenter.pages;

import android.view.View;

import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Result;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.adaptors.PostGeneralListCell;

/**
 * Created by Hamid on 8/14/2016.
 */
public class ProfilePage extends BasePresenter {

	X.Profile_Parent x;
    int UserId;
	String userName ="";
    boolean isMyProfile =false;
    public ProfilePage(int userId) {
        UserId = userId;
    }

	public ProfilePage(int userId,boolean isMyProfile) {
		UserId = userId;
		this.isMyProfile = isMyProfile;
	}

	public ProfilePage(String userName) {
		this.userName = userName;
	}
    @Override
    public View buildView() {
		x = new X.Profile_Parent();
        x.top_nav.setTitle("پروفایل");

		if(isMyProfile){
			x.top_nav.setVisibility(View.GONE);
		}
        load2();

        return x.root;
    }

    ProfileTopInfo profileTopInfo;
	PostGeneralListCell postCell;

	void load2(){
		profileTopInfo = new ProfileTopInfo(UserId);

		if(Session.isUserIdMe(UserId)){
			profileTopInfo.bind(Session.loadUserInfo());
		}

		postCell = new PostGeneralListCell(x.top_nav.getButtonPostMultiWayView(), (page, cell) -> {
			if(page == 1){
				loadToInfoFromServer();
			}

			Http.getPath("/v1/profile/posts")
				.setQueryParam("page",""+page)
				.setQueryParam("last",""+cell.getLastPostId(page))
				.setQueryParam("profile_id",""+UserId)
				.setQueryParam("user_name",""+userName)
				.doAsyncUi((result)->{
					cell.loadedPostsFromNetNew(result,page);
				});
		});

//		postCell.loadFromServer(1);

		postCell.getAdaptor().appendViewToHeader(profileTopInfo.x.root);

		x.container.addView(postCell.getViewRoot());

//		loadToInfoFromServer();

	}

	private void loadToInfoFromServer() {
		if(Session.isUserIdMe(UserId)){
			Session.fetchUserInfoFromServer();
		}

		Http.getPath("/v1/profile/info")
			.setQueryParam("profile_id",""+UserId)
			.setQueryParam("user_name",""+userName)
			.doAsyncUi((result)->{
				if(result.isOk()){
					HttpJson<JV.UserMeView> data = Result.fromJson(result, JV.UserMeView.class);
					if(data.isPayloadNoneEmpty()){
						profileTopInfo.bind(data.Payload);
					}
				}
			});
	}

	////////////////////////////////////////////////////////////

    public static View.OnClickListener getFollowings_click(int Userid) {
        return (v)->{
            Nav_DEP.push(Router.getFollowingsPage(Userid));
        };
    }

    public static View.OnClickListener getFollowers_click(int Userid) {
        return (v)->{
            Nav_DEP.push(Router.getFollowersPage(Userid));
        };
    }

    static class ProfileTopInfo{
		int UserId;
		X.Profile_TopInfo x;

        public ProfileTopInfo(int userId) {
			x = new X.Profile_TopInfo();

			UserId=userId;
			hideShowMyButns();
        }

        ProfileTopInfo bind(JV.UserMeView user){
			if(user == null)return this;

			hideShowMyButns();

            Helper.SetAvatar(x.avatar,user.AvatarUrl);
            x.fullname.setText(user.FullName);
            x.about.setText(""+user.About);

            x.posts_count.setText(""+user.PostsCount);
            x.followings_count.setText(""+user.FollowingCount);
            x.followers_count.setText(""+user.FollowersCount);

            //clicks
            x.followings_holder.setOnClickListener(getFollowings_click(user.Id));
            x.followers_holder.setOnClickListener(getFollowers_click(user.Id));

			x.chat_button.setUser(user);
			x.follow_button.setUser(user);

            return this;
        }

		void hideShowMyButns(){
			x.button_edit_profile.setIconAndClicker("ویرایش پروفایل {icon-energy 26dp}",()->{

			});

			if(Session.isUserIdMe(UserId)){
				x.chat_button.setVisibility(View.GONE);
				x.follow_button.setVisibility(View.GONE);
				x.button_edit_profile.setVisibility(View.VISIBLE);
			}else {
				x.chat_button.setVisibility(View.VISIBLE);
				x.follow_button.setVisibility(View.VISIBLE);
				x.button_edit_profile.setVisibility(View.GONE);
			}
		}
    }

}
