package com.mardomsara.social.ui.presenter.chat_realm.inbox;


import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.base_rv.BaseQuickAdapter;
import com.mardomsara.base_rv.BaseViewHolder;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.lib.realm.RealmRecyclerViewAdapter;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.ui.cells.chat_realm.RoomsListCell;

import java.util.List;

import io.realm.RealmResults;


final class InboxChatsListAdaptor2 extends BaseQuickAdapter<RealmChatView,InboxChatsListAdaptor2.RV > {

	public InboxChatsListAdaptor2(@Nullable List<RealmChatView> data) {
		super(data);


	}

	@Override
	protected void convert(RV helper, RealmChatView item) {

	}

	static class RV extends BaseViewHolder {

		public RV(View view) {
			super(view);
		}
	}
}