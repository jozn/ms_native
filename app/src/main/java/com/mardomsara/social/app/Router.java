package com.mardomsara.social.app;

import com.mardomsara.social.PresenterPage;
import com.mardomsara.social.Nav;
import com.mardomsara.social.json.social.rows.PostRowJson;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.ui.presenter.HelloPresenter;
import com.mardomsara.social.ui.presenter.chats.ChatRoomPresenter;
import com.mardomsara.social.ui.presenter.chats.ChatTabPresenter;
import com.mardomsara.social.ui.presenter.chats.GalleryChooserPresenter;
import com.mardomsara.social.ui.presenter.social.AcitivityTabPresenter;
import com.mardomsara.social.ui.presenter.social.CommentsPresenter;
import com.mardomsara.social.ui.presenter.social.FollowsListAboutPresenter;
import com.mardomsara.social.ui.presenter.social.HomeStream2Presenter;
import com.mardomsara.social.ui.presenter.social.PostEntryPresenter;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
import com.mardomsara.social.ui.presenter.social.SearchTabPresenter;
import com.mardomsara.social.ui.presenter.social.TagsPresenter;

/**
 * Created by Hamid on 1/30/2016.
 */
public class Router {
    public static PresenterPage getLikesPage(int PostId) {
//        return new LikesPresenter(PostId);
//        return new FollowsListPresenter(PostId, FollowsListPresenter.Type.LIKES);
        return new FollowsListAboutPresenter(PostId, FollowsListAboutPresenter.Type.LIKES);
    }

    public static PresenterPage getFollowersPage(int UserId) {
        return new FollowsListAboutPresenter(UserId, FollowsListAboutPresenter.Type.FOLLOWERS);
    }

    public static PresenterPage getFollowingsPage(int UserId) {
        return new FollowsListAboutPresenter(UserId, FollowsListAboutPresenter.Type.FOLLOWING);
    }

    public static PresenterPage getCommontsPage(int PostId) {
//        return new CommontsPresnter_DEP(PostId);
        return new CommentsPresenter(PostId);
    }

    public static PresenterPage getChatPage() {
        return new ChatTabPresenter();
//        return new ChatMainBranch();
    }

    public static PresenterPage getHomePage() {
        return new HomeStream2Presenter();
    }

    /*@Deprecated
    public static FragmentPage getRoomEntery(RoomsListTable room) {
        ChatEntryPresenter p = new ChatEntryPresenter();
        p.room = room;
        return p;
    }*/

    public static PresenterPage getRoomEntery(Room room) {
        ChatRoomPresenter p = new ChatRoomPresenter();
        p.room = room;
        return p;
    }

    public static PresenterPage getSearchPage() {
        return new SearchTabPresenter();
    }

    public static PresenterPage getHelloWolrdPage() {
        return new HelloPresenter();
    }

    public static PresenterPage getGalleryChooserPage() {
        return new GalleryChooserPresenter();
    }

    public static void goToProfile(int userId) {
        Nav.push(new ProfilePresenter(userId));
    }

    public static void goToPost(PostRowJson postRowJson) {
        Nav.push(new PostEntryPresenter(postRowJson));
    }

    public static void goToTag(String tag) {
        Nav.push(new TagsPresenter(tag));
    }

    public static void goToUserChatEntry(int UserId){
        Room room = RoomModel.getRoomByForUserAndLoadUser(UserId);
        Nav.push(Router.getRoomEntery(room));
    }

    public static PresenterPage getMyProfile() {
        return new ProfilePresenter(Session.getUserId());
    }
    public static void goToMyProfile() {
        Nav.push(new ProfilePresenter(Session.getUserId()));
    }

    public static PresenterPage getAactivityPage() {
        return new AcitivityTabPresenter();
//        return new HelloPresenter();
//        return new ProfilePresenter(Session.getUserId());
    }
}