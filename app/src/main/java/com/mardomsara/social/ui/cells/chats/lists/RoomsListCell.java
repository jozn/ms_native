package com.mardomsara.social.ui.cells.chats.lists;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.mardomsara.social.models.LastMsgOfRoomsCache2;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
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
    List<Room> list;
    RecyclerView rv;
    RoomsListAdaptor adp;

    public RoomsListCell() {
        init();
    }

    private void init() {
        root_view = AppUtil.inflate(R.layout.list_rooms_presenter);
        list  = RoomModel.getAllRoomsList(0);
        LastMsgOfRoomsCache2.getInstance().setForRooms(list);

        rv = (RecyclerView) root_view.findViewById(R.id.contacts_list);
        adp = new RoomsListAdaptor(list);
//        EventBus.getDefault().register(adp);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(AppUtil.getContext());
//        mLayoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(AppUtil.getContext(), DividerItemDecoration.VERTICAL_LIST);
//        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(adp);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(mLayoutManager);
    }


    public static class RoomsListAdaptor extends AppHeaderFooterRecyclerViewAdapter<RoomRowCellHolder> {
        List<Room> roomsList = new ArrayList<>();

        public RoomsListAdaptor(List<Room> rooms) {
            if(rooms != null){
                this.roomsList.addAll(rooms);
            }
            App.getBus().register(this);
        }

        @Override
        protected int getContentItemCount() {
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

        //////////// Events ////////////////

        @Subscribe(threadMode = ThreadMode.MAIN)
        //    public void onEvent(Message msg){
        public void onNewMsgEvent(Message msg){
            logIt("event new msg: " + msg.toString());
            //        notifyItemChanged(0);
            //remove
            int size = roomsList.size();
            Room room;
            int index = -1;
            for(int i =0; i< size; i++){
                room = roomsList.get(i);
                if(room == null) {size =-1; break;};
                if(room.RoomKey.equals(msg.RoomKey)){
                    index = roomsList.indexOf(room);
                    roomsList.remove(index);
                    size=-1;//must break loop all -- bug indexOutOfRange
                }
            }
            Room firstRoomRow = RoomModel.getRoomByRoomKeyAndLoadUser(msg.RoomKey);
            roomsList.add(0,firstRoomRow);


            //        if(index>0){//move : 1,2,3
            //            notifyItemMoved(index,0);
            //        }else if (index == 0){
            //
            //        }
            //root_view itself update

            //Keep it simple
            if(index>0){
                notifyItemRemoved(index);
            }
//            notifyItemChanged(0);//buggy
            notifyDataSetChanged();
        }

        @Subscribe(threadMode = ThreadMode.MAIN)
        public void onRoomInfoChangedEvent(RoomInfoChangedEvent event){
            logIt("event onRoomInfoChangedEvent: " + event.toString());
            int size = roomsList.size();
            Room room;
            Room newRoomRow = RoomModel.getRoomByRoomKeyAndLoadUser(event.RoomKey);
            int index = -1;
            int i =0;
            for(; i< size; i++){
                room = roomsList.get(i);
                if(room == null)  break;
                if(room.RoomKey.equals(event.RoomKey)){
                    //                roomsList.remove(i);
                    roomsList.set(i,newRoomRow);
                    break;//must break loop all -- bug indexOutOfRange
                }
            }
            notifyItemChanged(i);
        }

        @Subscribe
        public void onEvent(MessageSyncMeta mete){
            logIt("event meta: " + mete.toString());
        }

        @Subscribe
        public void onEvent(MsgsSyncMetaReceivedToServer mete){
            logIt("event meta: " + mete.toString());
            //        for(Room room: roomsList){
            //            if(room.getRoomKey().equals(mete.RoomKey)){
            //                int index = roomsList.indexOf(room);
            //                roomsList.remove(index);
            //                notifyItemRemoved(index);
            //            }
            //        }

        }

        @Subscribe
        public void onEvent(MsgsSyncMetaReceivedToPeer mete){
            logIt("event meta: " + mete.toString());
        }

        @Subscribe
        public void onEvent(MsgsSyncMetaDeletedFromServer mete){
            logIt("event meta: " + mete.toString());
        }

        @Subscribe
        public void onEvent(MsgsSyncMetaSeenByPeer mete){
            logIt("event meta: " + mete.toString());
        }

        protected void logIt(String str) {
            Log.d(" "+ this.getClass().getSimpleName() ," "+ str);
        }
    }

    public static class RoomRowCellHolder extends RecyclerView.ViewHolder{
        public Room room;
        public View root_view;
        RoomRowCell roomRowCell;

        RoomsListAdaptor adaptor;


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
            root_view = AppUtil.inflate(R.layout.chat_list_row_new_rel2,parent);
            ButterKnife.bind(this,root_view);
            this.adaptor = adaptor;

            root_view.setOnClickListener((vv)->{
//                Room r = room;//(RoomsListTable) vv.getTag();
//                AppUtil.log("Romm raw list " + r.RoomName + " clicked.");
                if (room!= null) Nav.push(Router.getRoomEntery(room));
            });

            root_view.setOnLongClickListener((vv)->{
                RoomHelper.moreRoomOptin(room,adaptor);
                return true;
            });
        }

        public void bind(Room room){
            Message lastMsg = LastMsgOfRoomsCache2.getInstance().getForRoom(room);
            this.room = room;
            name_txt.setText(room.getRoomName());
            date_txt.setText(""+ FormaterUtil.frindlyTimeClockOrDay(room.UpdatedMs));//+"قبل");
            unseen_count_txt.setCount(room.UnseenMessageCount);

            if(lastMsg != null){
//                AppUtil.log(lastMsg.toString());
                last_msg_txt.setText(RoomHelper.getLastMsgFormatedText(lastMsg));
            }else {//clear from previus
                last_msg_txt.setText("");
            }

//            self.setTag(room);
            Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
//            Helper.SetAvatar(vh.avatar, room.getRoomAvatarUrl());
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
