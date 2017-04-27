package com.mardomsara.social.app;

import com.mardomsara.social.PresenterPage;
import com.mardomsara.social.Nav;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.ui.presenter.HelloPresenter;
import com.mardomsara.social.ui.presenter.chats.ChatRoomPresenter;
import com.mardomsara.social.ui.presenter.settings.SettingsPresenter;
import com.mardomsara.social.ui.presenter.tabs.ChatTab;
import com.mardomsara.social.ui.presenter.chats.GalleryChooserPresenter;
import com.mardomsara.social.ui.presenter.tabs.AcitivityTab;
import com.mardomsara.social.ui.presenter.pages.CommentsPage;
import com.mardomsara.social.ui.presenter.pages.FollowsListAboutPage;
import com.mardomsara.social.ui.presenter.tabs.HomeTab;
import com.mardomsara.social.ui.presenter.pages.PostEntryPage_OLD;
import com.mardomsara.social.ui.presenter.pages.ProfilePage;
import com.mardomsara.social.ui.presenter.tabs.ProfileTab;
import com.mardomsara.social.ui.presenter.tabs.SearchTab;
import com.mardomsara.social.ui.presenter.pages.TagsPage;

/**
 * Created by Hamid on 1/30/2016.
 */
public class Router {
    public static PresenterPage getLikesPage(int PostId) {
//        return new LikesPresenter(PostId);
//        return new FollowsListPresenter(PostId, FollowsListPresenter.Type.LIKES);
        return new FollowsListAboutPage(PostId, FollowsListAboutPage.Type.LIKES);
    }

    public static PresenterPage getFollowersPage(int UserId) {
        return new FollowsListAboutPage(UserId, FollowsListAboutPage.Type.FOLLOWERS);
    }

    public static PresenterPage getFollowingsPage(int UserId) {
        return new FollowsListAboutPage(UserId, FollowsListAboutPage.Type.FOLLOWING);
    }

    public static PresenterPage getCommontsPage(int PostId) {
//        return new CommontsPresnter_DEP(PostId);
        return new CommentsPage(PostId);
    }

    /*@Deprecated
    public static FragmentPage getRoomEntry(RoomsListTable room) {
        ChatEntryPresenter p = new ChatEntryPresenter();
        p.room = room;
        return p;
    }*/

    public static PresenterPage getRoomEntry(Room room) {
        ChatRoomPresenter p = new ChatRoomPresenter();
        p.room = room;
        return p;
    }

    public static PresenterPage getHelloWolrdPage() {
        return new HelloPresenter();
    }

    public static PresenterPage getGalleryChooserPage() {
        return new GalleryChooserPresenter();
    }

    public static void goToProfile(int userId) {
        Nav.push(new ProfilePage(userId));
    }

    public static void goToPost(PostRowJson postRowJson) {
        Nav.push(new PostEntryPage_OLD(postRowJson));
    }

	public static void goToPost_PartialData(PostRowJson postRowJson) {
		Nav.push(new PostEntryPage_OLD(postRowJson,false));
	}

    public static void goToTag(String tag) {
        Nav.push(new TagsPage(tag));
    }

    public static void goToUserChatEntry(int UserId){
        Room room = RoomModel.getRoomByForUserAndLoadUser(UserId);
        Nav.push(Router.getRoomEntry(room));
    }

    public static ProfilePage getMyProfile() {
        return new ProfilePage(Session.getUserId(),true);
    }

	public static SettingsPresenter getSettings() {
		return new SettingsPresenter();
	}

    public static void goToMyProfile() {
        Nav.push(new ProfilePage(Session.getUserId()));
    }


	//////// Tabs -just must use in default Nav ////////////
	public static PresenterPage getChatTab() {
		return new ChatTab();
	}

	public static PresenterPage getActivityTab() {
		return new AcitivityTab();
	}

	public static PresenterPage getHomeTab() {
		return new HomeTab();
	}

	public static PresenterPage getSearchTab() {
		return new SearchTab();
	}

	public static PresenterPage getProfileTab() {
		return new ProfileTab();
	}



}