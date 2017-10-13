package com.mardomsara.social.ui.presenter.chats;

import android.view.View;

import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.presenter.chat_realm.inbox.InboxChatsListCell;

/**
 * Created by Hamid on 5/2/2016.
 */
@Deprecated
public class RoomsListPresenter extends BasePresenter {

    /*@Override
    public View buildView() {
        RoomsListCell roomsListCell = new RoomsListCell();
        return roomsListCell.root_view;

    }*/

	@Override
	public View buildView() {
		return new InboxChatsListCell().xChatList.root;

	}

}
