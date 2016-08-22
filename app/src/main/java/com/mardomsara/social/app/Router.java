package com.mardomsara.social.app;

import com.mardomsara.social.FragmentPage;
import com.mardomsara.social.Nav;
import com.mardomsara.social.tables.RoomsListTable;
import com.mardomsara.social.ui.presenter.HelloPresenter;
import com.mardomsara.social.ui.presenter.chats.ChatEntryPresenter;
import com.mardomsara.social.ui.presenter.chats.GalleryChooserPresenter;
import com.mardomsara.social.ui.presenter.main_pages.ChatMainBranch;
import com.mardomsara.social.ui.presenter.social.CommontsPresnter;
import com.mardomsara.social.ui.presenter.social.HomeStreamPresenter;
import com.mardomsara.social.ui.presenter.social.LikesPresenter;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;

/**
 * Created by Hamid on 1/30/2016.
 */
public class Router {
    public static FragmentPage getLikesPage(int PostId){
        return  new LikesPresenter(PostId);
//        return  new HelloPresenter();
/*        ChatEntryPresenter p = new ChatEntryPresenter();
        p.room = RoomsListTable.getRoomByRoomKey("u5");
        return p;*/
    }

    public static FragmentPage getCommontsPage(int PostId){
        return  new CommontsPresnter(PostId);
    }

    public static FragmentPage getChatPage(){
        return new HelloPresenter();
//       return FragmentPage.fromPresenter(new HelloPresenter());
    }

    public static FragmentPage getHomePage(){
        return new HomeStreamPresenter();
//        return new HelloPresenter();
    }

    public static FragmentPage getRoomEntery(RoomsListTable room){
        ChatEntryPresenter p = new ChatEntryPresenter();
        p.room = room;
        return p;
    }

    public static FragmentPage getSearchPage(){
        return new ChatMainBranch();
    }

    public static FragmentPage getHelloWolrdPage(){
        return new HelloPresenter();
    }

    public static FragmentPage getGalleryChooserPage(){
        return new GalleryChooserPresenter();
    }

    public static void goToProfile(int userId) {
        Nav.push(new ProfilePresenter(userId));
    }


    ///////////////////////

//    static FragmentPage _getFragmentPage(){
//        return new FragmentPage();
//    }
//    SwipeRefreshLayout
}


//    public static FragmentPage getChatPage_bk(){
//        FragmentPage f = new FragmentPage();
//        f.fragment = new ChatBranchPage();
//        return f;
//    }

//    public static FragmentPage getHomePage(){
//        FragmentPage f = new FragmentPage();
//        f.fragment = new ChatBranchPage();
//        return f;
//    }

//    public static FragmentPage getRoomEntery(RoomsListTable room){
//        FragmentPage f = _getFragmentPage();
//        f.fragment = new ChatEnteryPage();
//        Bundle b = new Bundle();
//
//        f.fragment.params.put("room", room);
//        return f;
//    }