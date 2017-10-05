package com.mardomsara.social.ui.presenter.chat_realm.inbox;

import android.support.v7.widget.LinearLayoutManager;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmChatViewFields;
import com.mardomsara.social.ui.X;

import io.realm.RealmResults;
import io.realm.Sort;


/**
 * Created by Hamid on 9/7/2016.
 */
public class InboxChatsListCell {

	public X.InboxChatList xChatList = new X.InboxChatList();
	InboxChatsListAdaptor adaptor;
	LinearLayoutManager layoutManager = new LinearLayoutManager(AppUtil.getContext());

	public InboxChatsListCell() {
		AndroidUtil.runInUi(()->{
			inint();
		});
	}

	private void inint(){
		RealmResults<RealmChatView> realmResults = AppRealm.getChatRealm().where(RealmChatView.class).findAllSorted(RealmChatViewFields.UPDATED_MS, Sort.DESCENDING);

//		adaptor = new InboxChatsListAdaptor(realmResults);
		/*List<RealmChatView> newChatViewList = new ArrayList<>();
		for (RealmChatView r : realmResults){
			newChatViewList.add(r);
		}*/

		adaptor = new InboxChatsListAdaptor(realmResults, true);

		xChatList.recycler_view.setAdapter(adaptor);
		xChatList.recycler_view.setHasFixedSize(true);
		xChatList.recycler_view.setLayoutManager(layoutManager);
	}

}
