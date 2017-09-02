package com.mardomsara.social.ui.presenter.chat_realm.inbox;


import android.net.Uri;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models_realm.realm.RealmChatView;
import com.mardomsara.social.models_realm.realm.RealmMessageView;
import com.mardomsara.social.ui.X;

class InboxRowCell {
	RealmChatView room;
	InboxChatsListAdaptor adaptor;

	X.Chat_ListRow x;

	InboxRowCell(ViewGroup parent, InboxChatsListAdaptor adaptor) {
		x = new X.Chat_ListRow(parent);
		this.adaptor = adaptor;

		x.root.setOnClickListener((vv) -> {
			if (room != null) Nav.push(Router.getRoomEntry(room));
		});

		x.root.setOnLongClickListener((vv) -> {
			InboxRoomHelper.moreRoomOptin(room, adaptor);
			return true;
		});
	}

	RealmMessageView lastMsg;
	public void bind(RealmChatView room) {
//            Message lastMsg = MemoryStore_LastMsgs.getForRoom(room);
		this.room = room;
		x.name_txt.setText(room.getRoomName());
		x.date_txt.setText("" + FormaterUtil.friendlyTimeClockOrDayMs(room.UpdatedMs));//+"قبل");
		x.unseen_count_txt.setCount(room.LastSeqSeen);

		if (lastMsg != null) {
			x.last_msg_txt.setText(InboxRoomHelper.getLastMsgFormatedText(lastMsg));
		} else {//clear from previus
			x.last_msg_txt.setText("");
		}
		Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
//
		x.avatar.setImageURIAndId(imageUri, room.getUserId());
	}
}