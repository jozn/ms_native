package com.mardomsara.social.ui.presenter.chat_realm.inbox;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmChatViewFields;
import com.mardomsara.social.ui.cells.chat_realm.*;
import com.mardomsara.social.ui.cells.chat_realm.RoomsListCell;

import io.realm.Realm;
import io.realm.Sort;


public  class InboxRoomsListAdaptor extends AppHeaderFooterRecyclerViewAdapter<RoomRowCellHolder> {
		ArrayListHashSetKey<Room,String> roomsList = null;//; new ArrayList<>();

        public InboxRoomsListAdaptor(ArrayListHashSetKey<Room,String> rooms) {
			if(rooms != null){
                this.roomsList = rooms;
            }
			Realm.getDefaultInstance().where(RealmChatView.class).findAllSorted(RealmChatViewFields.UPDATED_MS, Sort.DESCENDING);
        }

        @Override
        protected int getContentItemCount() {
//			Helper.showDebugMessage("rooms size:" + roomsList.size());
            return roomsList.size();
        }

        @Override
        protected RoomRowCellHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            return RoomRowCellHolder.getNew(parent,this);
        }

        @Override
        protected void onBindContentItemViewHolder(RoomRowCellHolder roomRowCellHolder, int position) {
            roomRowCellHolder.bind(roomsList.get(position));
        }

        @Override
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
//            App.getBus().unregister(this);
        }


	public static class RoomRowCellHolder extends RecyclerView.ViewHolder{
		public Room room;
		public View root_view;
		RoomsListCell.RoomRowCell roomRowCell;

		public RoomRowCellHolder(RoomsListCell.RoomRowCell rowCell) {
			super(rowCell.x.root);
			roomRowCell =rowCell;

			root_view = rowCell.x.root;
		}

		public void bind(Room room){
			this.room = room;
			roomRowCell.bind(room);
		}

		public static RoomsListCell.RoomRowCellHolder getNew(ViewGroup parent, RoomsListCell.RoomsListAdaptor adaptor){
			RoomsListCell.RoomRowCell roomRowCell = new RoomsListCell.RoomRowCell(parent,adaptor);
			return new RoomsListCell.RoomRowCellHolder(roomRowCell);
		}
	}


    }