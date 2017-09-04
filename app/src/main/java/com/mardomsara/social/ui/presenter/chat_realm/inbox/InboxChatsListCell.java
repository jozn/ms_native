package com.mardomsara.social.ui.presenter.chat_realm.inbox;

import android.support.v7.widget.LinearLayoutManager;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.realm_local.RealmChatViewFields;
import com.mardomsara.social.ui.X;

import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Hamid on 9/7/2016.
 */
public class InboxChatsListCell {

    InboxChatsListAdaptor adaptor;
	LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
	public X.InboxChatList xChatList = new X.InboxChatList();

    public InboxChatsListCell() {
		RealmResults<RealmChatView> realmResults = MSRealm.getChatRealm().where(RealmChatView.class).findAllSorted(RealmChatViewFields.UPDATED_MS, Sort.DESCENDING);

		adaptor = new InboxChatsListAdaptor(realmResults);

		xChatList.recycler_view.setAdapter(adaptor);
		xChatList.recycler_view.setHasFixedSize(true);
		xChatList.recycler_view.setLayoutManager(layoutManager);

    }

}
