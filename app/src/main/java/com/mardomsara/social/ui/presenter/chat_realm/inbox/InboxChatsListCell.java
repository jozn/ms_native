package com.mardomsara.social.ui.presenter.chat_realm.inbox;

import android.support.v7.widget.LinearLayoutManager;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.ui.X;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;
import io.realm.Sort;


/**
 * Created by Hamid on 9/7/2016.
 */
public class InboxChatsListCell {

    InboxChatsListAdaptor2 adaptor;
	LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());
	public X.InboxChatList xChatList = new X.InboxChatList();

    public InboxChatsListCell() {
		RealmResults<RealmChatView> realmResults = MSRealm.getChatRealm().where(RealmChatView.class).findAllSorted("UpdatedMs", Sort.DESCENDING);

//		adaptor = new InboxChatsListAdaptor(realmResults);
		List<RealmChatView> chatViewList = new ArrayList<>();
		for (RealmChatView r : realmResults){
			chatViewList.add(r);
		}

		adaptor = new InboxChatsListAdaptor2(chatViewList);

		xChatList.recycler_view.setAdapter(adaptor);
		xChatList.recycler_view.setHasFixedSize(true);
		xChatList.recycler_view.setLayoutManager(layoutManager);

    }

}
