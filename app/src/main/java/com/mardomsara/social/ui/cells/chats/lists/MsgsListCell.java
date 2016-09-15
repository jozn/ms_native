package com.mardomsara.social.ui.cells.chats.lists;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
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

import java.util.List;

/**
 * Created by Hamid on 9/8/2016.
 */
public class MsgsListCell {
    View root_view;
    public ChatEntaryAdaptor adaptor;

    public MsgsListCell() {
        this.adaptor = new ChatEntaryAdaptor();
    }


    public class ChatEntaryAdaptor extends RecyclerView.Adapter<MsgAbstractViewHolder> {
        //    @Bind()
        public List<Message> msgs;
        public void setMsgs(List<Message> msgs) {
            this.msgs = msgs;
        }


        @Override
        public MsgAbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create a new view.
            LayoutInflater _infl = LayoutInflater.from(parent.getContext());
            View rowView =  _infl.inflate(R.layout.empty, null, false);
            AppUtil.log("onCreateViewHolder: "+viewType);

            MsgAbstractViewHolder msgView = MsgEmptyView.makeNew();
            if(viewType % 2 == 0){//even: peer
                switch (viewType) {
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
                switch (viewType-1) {//1 comes from .isByMe()
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

            if(viewType == 1 || viewType == 2){
                rowView = _infl.inflate(R.layout.msg_row_system, parent, false);
            }
            return msgView;
//        return new UserRowViewHolder(rowView,viewType);
        }

        @Override
        public void onBindViewHolder(MsgAbstractViewHolder vh, int position) {
            AppUtil.log("onBindViewHolder"+position+ " :: " +vh);
            Message msg = msgs.get(position);
            vh.bindToView(msg);
        }

        @Override
        public int getItemViewType(int position) {
            int type = 10;
            Message m =msgs.get(position);
            if (m == null) return type;
            type = m.MessageTypeId+m.IsByMe;
            return type;
//        notifyDataSetChanged();
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);


        }

        @Override
        public int getItemCount() {
            return msgs.size();
        }

        @Override
        public void onViewRecycled(MsgAbstractViewHolder holder) {
            super.onViewRecycled(holder);
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
