package com.mardomsara.social.app;

import com.mardomsara.social.FragmentPage;
import com.mardomsara.social.Nav;
import com.mardomsara.social.tables.RoomsListTable;
import com.mardomsara.social.ui.presenter.HelloPresenter;
import com.mardomsara.social.ui.presenter.chats.ChatEntryPresenter;
import com.mardomsara.social.ui.presenter.chats.GalleryChooserPresenter;
import com.mardomsara.social.ui.presenter.main_pages.ChatMainBranch;
import com.mardomsara.social.ui.presenter.social.CommontsPresnter;
import com.mardomsara.social.ui.presenter.social.HomeStream2Presenter;
import com.mardomsara.social.ui.presenter.social.LikesPresenter;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
import com.mardomsara.social.ui.presenter.social.SearchTabPresenter;

/**
 * Created by Hamid on 1/30/2016.
 */
public class Router {
    public static FragmentPage getLikesPage(int PostId) {
        return new LikesPresenter(PostId);
    }

    public static FragmentPage getCommontsPage(int PostId) {
        return new CommontsPresnter(PostId);
    }

    public static FragmentPage getChatPage() {
        return new ChatMainBranch();
    }

    public static FragmentPage getHomePage() {
        return new HomeStream2Presenter();
    }

    public static FragmentPage getRoomEntery(RoomsListTable room) {
        ChatEntryPresenter p = new ChatEntryPresenter();
        p.room = room;
        return p;
    }

    public static FragmentPage getSearchPage() {
        return new SearchTabPresenter();
    }

    public static FragmentPage getHelloWolrdPage() {
        return new HelloPresenter();
    }

    public static FragmentPage getGalleryChooserPage() {
        return new GalleryChooserPresenter();
    }

    public static void goToProfile(int userId) {
        Nav.push(new ProfilePresenter(userId));
    }

    public static FragmentPage getAactivityPage() {
        return new HelloPresenter();
    }
}