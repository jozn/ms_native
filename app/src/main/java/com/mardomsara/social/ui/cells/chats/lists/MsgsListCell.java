package com.mardomsara.social.ui.cells.chats.lists;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.ui.cells.chats.msgs.MsgAbstractViewHolder;
import com.mardomsara.social.ui.cells.chats.msgs.MsgEmptyView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgPhotoMeView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgPhotoPeerView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgTextMeView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgTextPeerView;
import com.mardomsara.social.ui.cells.chats.msgs.MsgVideoMeView;

import java.util.List;

/**
 * Created by Hamid on 9/8/2016.
 */
public class MsgsListCell {
    View root_view;
    public ChatEntryAdaptor adaptor;

    public MsgsListCell() {
        this.adaptor = new ChatEntryAdaptor();
    }

	static LayoutInflater _infl = LayoutInflater.from(AppUtil.getContext());

	public class ChatEntryAdaptor extends AppHeaderFooterRecyclerViewAdapter<MsgAbstractViewHolder> {

        public ArrayListHashSetKey<Message,String> msgs = new ArrayListHashSetKey<>((msg)-> msg.MessageKey);

		public void setMsgs(List<Message> msgs) {
			this.msgs.fromList(msgs);
        }

        @Override
        protected int getContentItemCount() {
            return msgs.size();
        }

		@Override
        protected MsgAbstractViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
            // Create a new view.
            View rowView =  null ;// _infl.inflate(R.layout.msg_empty, null, false);
            AppUtil.log("onCreateViewHolder: "+contentViewType);

            MsgAbstractViewHolder msgView = MsgEmptyView.makeNew();
            if(contentViewType % 2 == 0){//even: peer
                switch (contentViewType) {
                    case 10:
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
                        break;
                    case 42:
                        msgView = MsgVideoMeView.makeNew(parent);
                        break;
                    case 44:
                        rowView = _infl.inflate(R.layout.msg_row_file_peer, parent, false);
                        break;
                }
            }else {//odd views: is ME
                switch (contentViewType-1) {//1 comes from .isByMe()
                    case 10:
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
                        break;
                    case 42:
                        msgView = MsgVideoMeView.makeNew(parent);
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
    }



}
