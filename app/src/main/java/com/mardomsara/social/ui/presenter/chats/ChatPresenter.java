package com.mardomsara.social.ui.presenter.chats;

import android.view.View;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.chats.lists.RoomsListCell;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatPresenter extends BasePresenter {

    @Override
    public View buildView() {
        RoomsListCell roomsListCell = new RoomsListCell();
        return roomsListCell.root_view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
