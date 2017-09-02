package com.mardomsara.social.ui.presenter.chat_realm.inbox;

import android.view.View;

import com.mardomsara.social.ui.BasePresenter;

/**
 * Created by Hamid on 5/2/2016.
 */
public class InboxPresenter extends BasePresenter {

    @Override
    public View buildView() {

        return new InboxChatsListCell().xChatList.root;

    }

}
