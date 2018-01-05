package com.mardomsara.social.app;

import com.mardomsara.social.json.JV;
import com.mardomsara.social.nav.Nav;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.pages.tabs.pages.CommentsPageFragment;
import com.mardomsara.social.ui.pages.tabs.pages.FollowsListAboutPageFragment;
import com.mardomsara.social.ui.pages.tabs.pages.PostEntryPageFragment;
import com.mardomsara.social.ui.pages.tabs.pages.ProfilePageFragment;
import com.mardomsara.social.ui.pages.tabs.pages.TagsPageFragment;

public class Router {

	public static FragmentPage getFollowingsPage(int UserId) {
		return FollowsListAboutPageFragment.newInstance(UserId, FollowsListAboutPageFragment.Type.FOLLOWING);
	}

	public static void goToFollowingsPage(int userId) {
		Nav.push(FollowsListAboutPageFragment.newInstance(userId, FollowsListAboutPageFragment.Type.FOLLOWING));
	}

	public static void goToFollowersPage(int userid) {
		Nav.push(FollowsListAboutPageFragment.newInstance(userid, FollowsListAboutPageFragment.Type.FOLLOWERS));
	}

	public static void goToLikesPage(int PostId) {
		Nav.push(FollowsListAboutPageFragment.newInstance(PostId, FollowsListAboutPageFragment.Type.LIKES));
	}

	public static void goToCommontsPage(int PostId) {
		Nav.push(CommentsPageFragment.getInstance(PostId));
	}


	public static void goToProfile(int userId) {
		Nav.push(ProfilePageFragment.newInstance(userId, null, false));
	}

	public static void goToProfile(String userName) {
		Nav.push(ProfilePageFragment.newInstance(0, userName, false));
	}

	public static void goToPostEntryPage(JV.PostView post ) {
		Nav.push(PostEntryPageFragment.newInstance(post,false));
	}

	public static void goToTagPage(String tagName) {
		Nav.push(TagsPageFragment.newInstance(tagName));
	}

	public static void goToUserChatEntry(int userId) {
	}
}