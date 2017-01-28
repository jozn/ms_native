package com.mardomsara.social.ui.cells.chats.lists;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.events.RoomOrderChanged;
import com.mardomsara.social.models.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models.memory_store.MemoryStore_Rooms;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.ui.views.wigets.CountView2;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 9/7/2016.
 */
public class RoomsListCell {
    public View root_view;
    ArrayListHashSetKey<Room,String> listRooms = MemoryStore_Rooms.getListRooms();//new ArrayListHashSetKey<>((room)->room.RoomKey);
    RecyclerView rv;
    RoomsListAdaptor adp;

    public RoomsListCell() {
        init();
    }

    private void init() {
        root_view = AppUtil.inflate(R.layout.list_rooms_presenter);
		MemoryStore_Rooms.reloadForAll();
		listRooms = MemoryStore_Rooms.getListRooms();

        rv = (RecyclerView) root_view.findViewById(R.id.contacts_list);
        adp = new RoomsListAdaptor(listRooms);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(AppUtil.getContext());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(AppUtil.getContext(), DividerItemDecoration.VERTICAL_LIST);
//        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(adp);
        rv.setHasFixedSize(true);

		App.getBus().register(this);

		rv.setLayoutManager(mLayoutManager);
    }

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(RoomOrderChanged data){
		AppUtil.log("event RoomOrderChanged");
		listRooms = MemoryStore_Rooms.getListRooms();
		adp.notifyDataSetChanged();
	}

	public static class RoomsListAdaptor extends AppHeaderFooterRecyclerViewAdapter<RoomRowCellHolder> {
		ArrayListHashSetKey<Room,String> roomsList = null;//; new ArrayList<>();

        public RoomsListAdaptor(ArrayListHashSetKey<Room,String> rooms) {
            if(rooms != null){
                this.roomsList = rooms;
            }
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
            App.getBus().unregister(this);
        }

    }

    public static class RoomRowCellHolder extends RecyclerView.ViewHolder{
        public Room room;
        public View root_view;
        RoomRowCell roomRowCell;

        public RoomRowCellHolder(RoomRowCell rowCell) {
            super(rowCell.root_view);
            roomRowCell =rowCell;

            root_view = rowCell.root_view;
        }

        public void bind(Room room){
            this.room = room;
            roomRowCell.bind(room);
        }

        public static RoomRowCellHolder getNew(ViewGroup parent, RoomsListAdaptor adaptor){
            RoomRowCell roomRowCell = new RoomRowCell(parent,adaptor);
            return new RoomRowCellHolder(roomRowCell);
        }
    }

    public static class RoomRowCell{
        public Room room;
        RoomsListAdaptor adaptor;

        private View root_view;
        @Bind(R.id.avatar)public SimpleDraweeView avatar;
        @Bind(R.id.date_txt) public TextView date_txt;
        @Bind(R.id.name_txt) public TextView name_txt;
        @Bind(R.id.unseen_count_txt)public CountView2 unseen_count_txt;
        @Bind(R.id.last_msg_txt)public TextView last_msg_txt;

        public RoomRowCell(ViewGroup parent, RoomsListAdaptor adaptor) {
            root_view = AppUtil.inflate(R.layout.chat__list_row,parent);
            ButterKnife.bind(this,root_view);
            this.adaptor = adaptor;

            root_view.setOnClickListener((vv)->{
                if (room!= null) Nav.push(Router.getRoomEntry(room));
            });

            root_view.setOnLongClickListener((vv)->{
                RoomHelper.moreRoomOptin(room,adaptor);
                return true;
            });
        }

        public void bind(Room room){
            Message lastMsg = MemoryStore_LastMsgs.getForRoom(room);
            this.room = room;
            name_txt.setText(room.getRoomName());
            date_txt.setText(""+ FormaterUtil.friendlyTimeClockOrDayMs(room.UpdatedMs));//+"قبل");
            unseen_count_txt.setCount(room.UnseenMessageCount);

            if(lastMsg != null){
                last_msg_txt.setText(RoomHelper.getLastMsgFormatedText(lastMsg));
            }else {//clear from previus
                last_msg_txt.setText("");
            }
            Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
            avatar.setImageURI(imageUri);
        }
    }


    public static class RoomHelper {

        public static String getLastMsgFormatedText(Message lastMsg){
            String txt = "";
            int limit = 40;
            switch (lastMsg.MessageTypeId){
                case Constants.MESSAGE_TEXT:
                    txt = LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_IMAGE:
                    txt = "[عکس] " + LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_VIDEO:
                    txt = "[ویدیو] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_FILE:
                    txt = "[فایل] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_AUDIO:
                    txt = "[صوتی] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_STICKER:
                    txt = "[استیکر] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_lOCCASION:
                    txt = "[مکان] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
            }
            return txt;
        }

        public static void moreRoomOptin(Room room, RoomsListAdaptor adaptor) {
            if(room == null || adaptor == null) return;
            List<DialogHelper.MenuItem> items = new ArrayList<>();
            items.add(new DialogHelper.MenuItem("پاک کردن پیام ها",(v)->{
                AndroidUtil.runInBackgroundNoPanic(()-> RoomModel.clearRoomMsgs(room));
                adaptor.notifyDataSetChanged();
            }));

            items.add(new DialogHelper.MenuItem("حذف گفتگو",(v)->{
                AndroidUtil.runInBackgroundNoPanic(()-> RoomModel.deleteRoom(room.RoomKey) );
                adaptor.roomsList.remove(room);
                adaptor.notifyDataSetChanged();
            }));

            items.add(new DialogHelper.MenuItem("رفتن به پروفایل",(v)->{
                Router.goToProfile(room.getUserId());
            }));

            DialogHelper.simpleMenu(items);
        }
    }

}
