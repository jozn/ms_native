package com.mardomsara.social.ui.presenter.chats;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.models.LastMsgOfRoomsCache;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.events.RoomInfoChangedEvent;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.RoomsListTable;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.play.BadgeDrawable;
import com.mardomsara.social.ui.views.wigets.CountView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 5/2/2016.
 */
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
//        ChatListAdaptor adp = new RoomsListAdaptor(list.toArray(new RoomsListTable[]{}));
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
    void showMeas(){
        Toast.makeText(App.context,"w: "+v.getMeasuredWidth() + " h: "+ v.getMeasuredHeight(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        showMeas();
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

            public ViewHolder(View v) {
                super(v);
                self = v;
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vv) {
                        RoomsListTable r = (RoomsListTable) vv.getTag();
                        Log.d(TAG, "Romm raw list " + r.getRoomName() + " clicked.");
                        Nav.push(Router.getRoomEntery(r));
                    }});

                v.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View vv) {
//                        DialogHelper.simpleAlert(vv.getContext(), "ایران ما", "تتای عیشسعی یادشسیاسش یشسیشست ");
                        openMoreOptionDialog(null);
                        return true;
                    }
                });

                textView = (TextView) v.findViewById(R.id.textView);
                date_txt = (TextView) v.findViewById(R.id.date_txt);
                name_txt = (TextView) v.findViewById(R.id.name_txt);
                unseen_count_txt = (CountView) v.findViewById(R.id.unseen_count_txt);
    //            unseen_count_image = (ImageView) v.findViewById(R.id.unseen_count_image);
                last_msg_txt = (TextView) v.findViewById(R.id.last_msg_txt);
                avatar = (SimpleDraweeView) v.findViewById(R.id.avatar);
                row = v;

    //            avatar.setOnClickListener((vv)->{
                /*avatar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vv) {
//                        openMoreOptionDialog(null);
//                        DialogHelper.simpleMenu(null);
                        *//*RoomListRowOptionsPresenter op = new RoomListRowOptionsPresenter();
                        DialogHelper.alertViewWithListner(vv.getContext(),op.getGrandView(),op);
                        com.orhanobut.dialogplus.ViewHolder vh = new com.orhanobut.dialogplus.ViewHolder(op.getGrandView());*//*
                    }
                });*/
            }

            public TextView getTextView() {
                return textView;
            }

            static void openMoreOptionDialog(RoomsListTable room){
                List<DialogHelper.MenuItem> items = new ArrayList<>();
                items.add(new DialogHelper.MenuItem("پاک کردن همه پیام ها",(v)->{
                    Toast.makeText(AppUtil.getContext(),"asdas",Toast.LENGTH_SHORT).show();
                }));

                items.add(new DialogHelper.MenuItem("حذف گفتگو",(v)->{

                }));

                items.add(new DialogHelper.MenuItem("رفتن به پروفایل",(v)->{

                }));

                DialogHelper.simpleMenu(items);
            }
        }
        public RoomsListAdaptor(List<RoomsListTable> dataSet) {
            roomsList = dataSet;

    //        ___room = RoomsListTable.getRoomByRoomKeyAndLoadUser("u2");
    //        ___room.setRoomName("dsddd");
    //        ___room.setUnseenMessageCount(100);
    //        ___room.User = UsersTable.getByUserId(2);
            EventBus.getDefault().register(this);
            /*up =()-> {
                roomsList.clear();
                roomsList.addAll(RoomsListTable.getAllRoomsList(0));
    //            notifyItemRangeChanged(0,10);
                notifyDataSetChanged();
    //            notifyItemChanged(0);
    //            notifyItemInserted(0);
            };*/
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
    //        RoomsListTable room = ___room;
    //        room = ___room;
            MessagesTable lastMsg = LastMsgOfRoomsCache.getInstance().getForRoom(room);
    //         lastMsg = null;

            ViewHolder vh = viewHolder;
            vh.name_txt.setText(room.getRoomName());
    //        vh.last_msg_txt.setText(room.getLastMessageText());
    //        vh.unseen_count_txt.setText(""+room.getUpdatedMs());

            vh.date_txt.setText(""+ FormaterUtil.frindlyTimeClockOrDay(room.getUpdatedMs()));//+"قبل");
    //        vh.date_txt.setText("*&*"+ (room.getUpdatedMs()));//+"قبل");
    //        vh.unseen_count_txt.setText("" + room.getUnseenMessageCount());
    //        vh.unseen_count_txt.setBadgeBackgroundColor(Color.BLUE);
    //        vh.unseen_count_txt.setText("" + room.getUnseenMessageCount());
            vh.unseen_count_txt.setCount(room.getUnseenMessageCount());
    //        vh.unseen_count_txt.show();

            BadgeDrawable badge = new BadgeDrawable.Builder().type(BadgeDrawable.TYPE_NUMBER).number(room.getUnseenMessageCount())
                    .badgeColor(Color.BLACK).textColor(Color.WHITE).build();

    //        vh.unseen_count_image.setImageDrawable(badge);




            if(lastMsg != null){
                ////limiting text very important performance optimazations
                vh.last_msg_txt.setText(LangUtil.limitText(lastMsg.getText(),50));
            }
    //        vh.last_msg_txt.setText(" \uD83D\uDE02 \uD83D\uDE03 \uD83D\uDE04 \uD83D\uDE05 \uD83D\uDE06 \uD83D\uDE09 \uD83D\uDE0A \uD83D\uDE1A ☺️ \uD83D\uDE42 \uD83E\uDD17 \uD83D\uDE07 \uD83E\uDD13 \uD83E\uDD14 \uD83D\uDE10 \uD83D\uDE11 \uD83D\uDE36 \uD83D\uDE44");


            vh.self.setTag(room);
    //        Uri imageUri = Uri.parse("http://localhost:5000/public/avatars/"+ RandomUtils.nextInt(0,15) +".jpg");
    //        Uri imageUri = Uri.parse("http://localhost:5000/public/avatars/101.jpg");
            Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
            vh.avatar.setImageURI(imageUri);

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
            //row itself update

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
