package com.mardomsara.social.ui.cells.chats.lists;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.cells.chats.msgs.MsgAbstractViewHolder;
import com.mardomsara.social.ui.cells.chats.msgs.MsgEmptyView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgPhotoMeView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgPhotoPeerView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgTextMeView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgTextPeerView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgVideoMeView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 9/8/2016.
 */
public class MsgsListCell_List {
    View root_view;
    public ChatEntaryAdaptor adaptor;

    public MsgsListCell_List() {
        this.adaptor = new ChatEntaryAdaptor();
    }


//    public class ChatEntaryAdaptor extends RecyclerView.Adapter<MsgAbstractViewHolder> {
    public class ChatEntaryAdaptor extends AppHeaderFooterRecyclerViewAdapter<MsgAbstractViewHolder> {

        public List<Message> msgs = new ArrayList<>();
        public void setMsgs(List<Message> msgs) {
            this.msgs = msgs;
        }

        @Override
        protected int getContentItemCount() {
            return msgs.size();
        }

        @Override
        protected MsgAbstractViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            // Create a new view.
            LayoutInflater _infl = LayoutInflater.from(parent.getContext());
            View rowView =  _infl.inflate(R.layout.empty, null, false);
            AppUtil.log("onCreateViewHolder: "+contentViewType);

            MsgAbstractViewHolder msgView = MsgEmptyView.makeNew();
            if(contentViewType % 2 == 0){//even: peer
                switch (contentViewType) {
                    case 10:
    //                    rowView = _infl.inflate(R.layout.msg_row_text_peer, parent, false);
                        msgView = MsgTextPeerView.makeNew(parent);
                        break;
                    case 12:
                        rowView = _infl.inflate(R.layout.msg_row_contact_peer, parent, false);
                        break;
                    case 14:
                        rowView = _infl.inflate(R.layout.msg_row_location_peer, parent, false);
                        break;
                    case 16:
                        rowView = _infl.inflate(R.layout.msg_row_sticker_peer, parent, false);
                        break;
                    case 30:
                        rowView = _infl.inflate(R.layout.msg_row_post_peer, parent, false);
                        break;
                    case 40://// TODO: 6/11/2016  :change to msg_row_image_peer
                        msgView = MsgPhotoPeerView.makeNew(parent);
    //                    rowView = _infl.inflate(R.layout.msg_row_image_me, parent, false);
                        break;
                    case 42:
                        msgView = MsgVideoMeView.makeNew(parent);
    //                    rowView = _infl.inflate(R.layout.msg_row_audio_peer, parent, false);
                        break;
                    case 44:
                        rowView = _infl.inflate(R.layout.msg_row_file_peer, parent, false);
                        break;
                }
            }else {//odd views: is ME
                switch (contentViewType-1) {//1 comes from .isByMe()
                    case 10:
    //                    rowView = _infl.inflate(R.layout.msg_row_text_me, parent, false);
                        msgView = MsgTextMeView.makeNew(parent);
                        break;
                    case 12:
                        rowView = _infl.inflate(R.layout.msg_row_contact_me, parent, false);
                        break;
                    case 14:
                        rowView = _infl.inflate(R.layout.msg_row_location_me, parent, false);
                        break;
                    case 16:
                        rowView = _infl.inflate(R.layout.msg_row_sticker_me, parent, false);
                        break;
                    case 30:
                        rowView = _infl.inflate(R.layout.msg_row_post_me, parent, false);
                        break;
                    case 40:
                        msgView = MsgPhotoMeView.makeNew(parent);
    //                    rowView = _infl.inflate(R.layout.msg_row_image_me, parent, false);
                        break;
                    case 42:
                        msgView = MsgVideoMeView.makeNew(parent);
    //                    rowView = _infl.inflate(R.layout.msg_row_audio_me, parent, false);
                        break;
                    case 44:
                        rowView = _infl.inflate(R.layout.msg_row_file_me, parent, false);
                        break;
                }
            }

            if(contentViewType == 1 || contentViewType == 2){
                rowView = _infl.inflate(R.layout.msg_row_system, parent, false);
            }
            return msgView;

        }

        @Override
        protected void onBindContentItemViewHolder(MsgAbstractViewHolder msgAbstractViewHolder, int position) {
            Message msg = msgs.get(position);
            msgAbstractViewHolder.bindToView(msg);
        }

        @Override
        protected int getContentItemViewType(int position) {
            int type = 10;
            Message m =msgs.get(position);
            if (m == null) return type;
            type = m.MessageTypeId+m.IsByMe;
            return type;
        }

        @Subscribe
        public void onEvent(MessageSyncMeta meta){
            logIt("event meta: XXXXX " + meta.toString());
        }

        protected void logIt(String str) {
            Log.d(" "+ this.getClass().getSimpleName() ," "+ str);
        }
    }



}
