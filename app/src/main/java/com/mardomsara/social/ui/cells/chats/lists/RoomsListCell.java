package com.mardomsara.social.ui.cells.chats.lists;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.App;
import com.mardomsara.social.Nav_DEP;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Events;
import com.mardomsara.social.app.Router_DEP;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models_old.RoomModel;
import com.mardomsara.social.models_old.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models_old.memory_store.MemoryStore_Rooms;
import com.mardomsara.social.models_old.tables.Message;
import com.mardomsara.social.models_old.tables.Room;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.ui.X;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

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

        rv = (RecyclerView) root_view.findViewById(R.id.contacts_list_rv);
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

    /*@Deprecated
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(RoomOrderChanged data){
		AppUtil.log("event RoomOrderChanged");
		listRooms = MemoryStore_Rooms.getListRooms();
		adp.notifyDataSetChanged();
	}*/

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(Events.RoomOrderChanged data){
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
            super(rowCell.x.root);
            roomRowCell =rowCell;

            root_view = rowCell.x.root;
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

		X.Chat_ListRow x;

        public RoomRowCell(ViewGroup parent, RoomsListAdaptor adaptor) {
			x = new X.Chat_ListRow(parent);
            this.adaptor = adaptor;

            x.root.setOnClickListener((vv)->{
                if (room!= null) Nav_DEP.push(Router_DEP.getRoomEntry(room));
            });

            x.root.setOnLongClickListener((vv)->{
                RoomHelper.moreRoomOptin(room,adaptor);
                return true;
            });
        }

        public void bind(Room room){
            Message lastMsg = MemoryStore_LastMsgs.getForRoom(room);
            this.room = room;
            x.name_txt.setText(room.getRoomName());
            x.date_txt.setText(""+ FormaterUtil.friendlyTimeClockOrDayMs(room.UpdatedMs));//+"قبل");
            x.unseen_count_txt.setCount(room.UnseenMessageCount);

            if(lastMsg != null){
                x.last_msg_txt.setText(RoomHelper.getLastMsgFormatedText(lastMsg));
            }else {//clear from previus
                x.last_msg_txt.setText("");
            }
            Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
//			x.avatar.setBackgroundColor(ColorGenerator.MATERIAL.getColor(imageUri));
			/*GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(x.avatar.getResources())
				.setFadeDuration(300)
				.setPlaceholderImage( new IconColorfulDrawable(x.avatar.getContext(),"ion-ios-person-outline"))
//				.setPlaceholderImage( TextDrawable.builder().buildRect("م", ColorGenerator.MATERIAL.getColor(imageUri)))
//				.setPlaceholderImage( R.drawable.user_avatar)
				.setRoundingParams(RoundingParams.fromCornersRadius(30f))
//				.setBackground(background)
//				.setOverlays(overlaysList)
				.build();*/
//			x.avatar.setHierarchy(hierarchy);
            x.avatar.setImageURIAndId(imageUri, room.getUserId());
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
                Router_DEP.goToProfile(room.getUserId());
            }));

            DialogHelper.simpleMenu(items);
        }
    }

}
