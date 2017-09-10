package com.mardomsara.social.ui.presenter.chat_realm.inbox;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.lib.realm.RealmRecyclerViewAdapter;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.ui.cells.chat_realm.RoomsListCell;

import io.realm.RealmResults;


final class InboxChatsListAdaptor extends RealmRecyclerViewAdapter<RealmChatView, InboxChatsListAdaptor.RoomRowCellHolder> {
	ArrayListHashSetKey<Room, String> roomsList = null;//; new ArrayList<>();

	RealmResults<RealmChatView> rooms;

	InboxChatsListAdaptor(RealmResults<RealmChatView> rooms) {
		super(rooms, true);
		this.rooms = rooms;
	}

	@Override
	public RoomRowCellHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//		return new RoomRowCellHolder(new InboxRowCell(parent, this));
		return null;
	}

	@Override
	public void onBindViewHolder(RoomRowCellHolder holder, int position) {
		holder.bind(rooms.get(position));
	}

	static class RoomRowCellHolder extends RecyclerView.ViewHolder {
		public RealmChatView room;
		public View root_view;
		InboxRowCell roomRowCell;

		RoomRowCellHolder(InboxRowCell rowCell) {
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
		}
	}


}