package com.mardomsara.social.ui.presenter.chats.old;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.tables.MessagesModel;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.RoomsListTable;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.wigets.CountView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 5/2/2016.
 */
@Deprecated
public class ChatRoomsListPresenter extends BasePresenter {
    View v;
    List<RoomsListTable> list;
    RecyclerView rv;
    RoomsListAdaptor adp;
    @Override
    public View buildView() {
       v = AppUtil.inflate(R.layout.list_rooms_presenter);
       list  = RoomsListTable.getAllRoomsList(0);

       rv = (RecyclerView) v.findViewById(R.id.contacts_list);
       adp = new RoomsListAdaptor(list);
//        EventBus.getDefault().register(adp);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(fragment.getActivity());
//        mLayoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(fragment.getActivity(), DividerItemDecoration.VERTICAL_LIST);
//        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(adp);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(mLayoutManager);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * Created by Hamid on 5/4/2016.
     */
    public static class RoomsListAdaptor extends  RecyclerView.Adapter<RoomsListAdaptor.ViewHolder> {
        private static final String TAG = "RoomsListAdaptor";
        public static  Runnable up = ()->{};

        private List<RoomsListTable> roomsList;
        //todo remove this
    //    RoomsListTable ___room ;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public RoomsListTable room;

            private final View self;
            private final TextView textView;
            public final SimpleDraweeView avatar;
            public TextView date_txt;
    //        public BadgeView date_txt;
            public TextView name_txt;
            public CountView unseen_count_txt;
            public ImageView unseen_count_image;
            public TextView last_msg_txt;
            public View row;

            RoomsListAdaptor adaptor;

            public ViewHolder(View v) {
                super(v);
                self = v;
                v.setOnClickListener((vv)->{
                    RoomsListTable r = room;//(RoomsListTable) vv.getTag();
                    Log.d(TAG, "Romm raw list " + r.getRoomName() + " clicked.");
                    Nav.push(Router.getRoomEntery(r));
                });

                v.setOnLongClickListener((vv)->{
                    openMoreOptionDialog(room);
                    return true;
                });

                textView = (TextView) v.findViewById(R.id.textView);
                date_txt = (TextView) v.findViewById(R.id.date_txt);
                name_txt = (TextView) v.findViewById(R.id.name_txt);
                unseen_count_txt = (CountView) v.findViewById(R.id.unseen_count_txt);
    //            unseen_count_image = (ImageView) v.findViewById(R.id.unseen_count_image);
                last_msg_txt = (TextView) v.findViewById(R.id.last_msg_txt);
                avatar = (SimpleDraweeView) v.findViewById(R.id.avatar);
                row = v;

            }

            public TextView getTextView() {
                return textView;
            }

            void openMoreOptionDialog(RoomsListTable room){
                List<DialogHelper.MenuItem> items = new ArrayList<>();
                items.add(new DialogHelper.MenuItem("پاک کردن پیام ها",(v)->{
//                    Toast.makeText(AppUtil.getContext(),room.User.FirstName,Toast.LENGTH_SHORT).show();
                    MessagesModel.clearAllMessagesOfRoom(room.getRoomKey());
//                    LastMsgOfRoomsCache.getInstance().removeForRoom(room.getRoomKey());
                    room.setUnseenMessageCount(0);
                    room.save();
                    adaptor.notifyDataSetChanged();
                }));

                items.add(new DialogHelper.MenuItem("حذف گفتگو",(v)->{
                    RoomsListTable.deleteRoom(room.getRoomKey());
                    adaptor.roomsList.remove(room);
                    adaptor.notifyDataSetChanged();
                }));

                items.add(new DialogHelper.MenuItem("رفتن به پروفایل",(v)->{

                }));

                DialogHelper.simpleMenu(items);
            }
        }
        public RoomsListAdaptor(List<RoomsListTable> dataSet) {
            roomsList = dataSet;
            EventBus.getDefault().register(this);
        }

        @Override
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
            EventBus.getDefault().unregister(this);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view.
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.chat_list_row, viewGroup, false);

            return new ViewHolder(v);
        }
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
    //        Log.d(TAG, "Element " + position + " set.");
            RoomsListTable room = roomsList.get(position);
            MessagesTable lastMsg = LastMsgOfRoomsCache.getInstance().getForRoom(room);
            ViewHolder vh = viewHolder;
            vh.room = room;
            vh.adaptor = this;
            vh.name_txt.setText(room.getRoomName());
            vh.date_txt.setText(""+ FormaterUtil.frindlyTimeClockOrDay(room.getUpdatedMs()));//+"قبل");
            vh.unseen_count_txt.setCount(room.getUnseenMessageCount());

            if(lastMsg != null){
//                AppUtil.log(lastMsg.toString());
                vh.last_msg_txt.setText(_getLastMsgFormatedText(lastMsg));
            }else {//clear from previus
                vh.last_msg_txt.setText("");
            }

            vh.self.setTag(room);
            Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
//            Helper.SetAvatar(vh.avatar, room.getRoomAvatarUrl());
            vh.avatar.setImageURI(imageUri);
        }

        String _getLastMsgFormatedText(MessagesTable lastMsg){
            String txt = "";
            int limit = 40;
            switch (lastMsg.getMessageTypeId()){
                case Constants.MESSAGE_TEXT:
                    txt = LangUtil.limitText(lastMsg.getText(), limit);
                    break;
                case Constants.MESSAGE_IMAGE:
                    txt = "[عکس] " + LangUtil.limitText(lastMsg.getText(), limit);
                    break;
                case Constants.MESSAGE_VIDEO:
                    txt = "[ویدیو] " +LangUtil.limitText(lastMsg.getText(), limit);
                    break;
                case Constants.MESSAGE_FILE:
                    txt = "[فایل] " +LangUtil.limitText(lastMsg.getText(), limit);
                    break;
                case Constants.MESSAGE_AUDIO:
                    txt = "[صوتی] " +LangUtil.limitText(lastMsg.getText(), limit);
                    break;
                case Constants.MESSAGE_STICKER:
                    txt = "[استیکر] " +LangUtil.limitText(lastMsg.getText(), limit);
                    break;
                case Constants.MESSAGE_lOCATION:
                    txt = "[مکان] " +LangUtil.limitText(lastMsg.getText(), limit);
                    break;
            }
            return txt;
        }

        @Override
        public int getItemCount() {
            return roomsList.size();
        }


        //////////// Events ////////////////

        @Subscribe(threadMode = ThreadMode.MAIN)
    //    public void onEvent(MessagesTable msg){
        public void onNewMsgEvent(MessagesTable msg){
            logIt("event new msg: " + msg.toString());
    //        notifyItemChanged(0);
            //remove
            int size = roomsList.size();
            RoomsListTable room;
            int index = -1;
            for(int i =0; i< size; i++){
                room = roomsList.get(i);
                if(room == null) {size =-1; break;};
                if(room.getRoomKey().equals(msg.getRoomKey())){
                    index = roomsList.indexOf(room);
                    roomsList.remove(index);
                    size=-1;//must break loop all -- bug indexOutOfRange
                }
            }
            RoomsListTable firstRoomRow = RoomsListTable.getRoomByRoomKeyAndLoadUser(msg.getRoomKey());
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
            notifyItemChanged(0);
        }

        @Subscribe(threadMode = ThreadMode.MAIN)
        public void onRoomInfoChangedEvent(RoomInfoChangedEvent event){
            logIt("event onRoomInfoChangedEvent: " + event.toString());
            int size = roomsList.size();
            RoomsListTable room;
            RoomsListTable newRoomRow = RoomsListTable.getRoomByRoomKeyAndLoadUser(event.RoomKey);
            int index = -1;
            int i =0;
            for(; i< size; i++){
                room = roomsList.get(i);
                if(room == null)  break;
                if(room.getRoomKey().equals(event.RoomKey)){
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
    //        for(RoomsListTable room: roomsList){
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
}
