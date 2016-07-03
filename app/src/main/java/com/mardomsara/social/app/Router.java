package com.mardomsara.social.app;

import com.mardomsara.social.FragmentPage;
import com.mardomsara.social.tables.RoomsListTable;
import com.mardomsara.social.ui.presenter.HelloPresenter;
import com.mardomsara.social.ui.presenter.chats.ChatEntryPresenter;
import com.mardomsara.social.ui.presenter.chats.GalleryChooserPresenter;
import com.mardomsara.social.ui.presenter.main_pages.ChatMainBranch;

/**
 * Created by Hamid on 1/30/2016.
 */
public class Router {
    public static FragmentPage getLikesPage(){
        ChatEntryPresenter p = new ChatEntryPresenter();
        p.room = RoomsListTable.getRoomByRoomKey("u5");
        return p;
    }

    public static FragmentPage getChatPage(){
        return new HelloPresenter();
//       return FragmentPage.fromPresenter(new HelloPresenter());
    }

    public static FragmentPage getHomePage(){
        return new ChatMainBranch();
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