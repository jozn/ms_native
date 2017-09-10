package com.mardomsara.social.ui.presenter.chat_realm.inbox;


import android.graphics.Color;
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


final class InboxChatsListAdaptor2 extends BaseQuickAdapter<RealmChatView, InboxChatsListAdaptor2.RV> {

	public InboxChatsListAdaptor2(@Nullable List<RealmChatView> data) {
		super(data);
	}

	@Override
	protected int getDefItemViewType(int position) {
		return super.getDefItemViewType(position);
	}

	/*@Override
	public void onBindViewHolder(RV holder, int position, List<Object> payloads) {
		super.onBindViewHolder(holder, position, payloads);
	}*/

	/*@Override
	public RV onCreateViewHolder(ViewGroup parent, int viewType) {
		return super.onCreateViewHolder(parent, viewType);
	}*/

	@Override
	protected RV createBaseViewHolder(ViewGroup parent, int layoutResId, int typeId) {
		return new RV(new InboxRowCell(parent, this));
	}

	@Override
	protected void convert(RV helper, RealmChatView item) {
//		super.convert();
		helper.bind(item);
	}

	/*static class RV extends BaseViewHolder {

		public RV(View view) {
			super(view);
		}
	}*/

	static class RV extends BaseViewHolder {
		public RealmChatView room;
		public View root_view;
		InboxRowCell roomRowCell;

		RV(InboxRowCell rowCell) {
			super(rowCell.x.root);
			roomRowCell = rowCell;

			root_view = rowCell.x.root;
		}

		public static RoomsListCell.RoomRowCellHolder getNew(ViewGroup parent, RoomsListCell.RoomsListAdaptor adaptor) {
			RoomsListCell.RoomRowCell roomRowCell = new RoomsListCell.RoomRowCell(parent, adaptor);
			return new RoomsListCell.RoomRowCellHolder(roomRowCell);
		}

		public void bind(RealmChatView room) {
			this.room = room;
			roomRowCell.bind(room);
			roomRowCell.x.root.setBackgroundColor(Color.CYAN);
		}
	}
}