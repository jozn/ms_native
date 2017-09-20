package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.view.ViewGroup;

import com.mardomsara.base_rv.BaseRealmRecyclerViewAdapter;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_AbstractViewHolder;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_Empty;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_PhotoMe;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_PhotoPeer;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_TextMe;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_TextPeer;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_VideoMe;

import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 1/28/2017.
 */
public class ChatRoomEntryAdaptor extends BaseRealmRecyclerViewAdapter<RealmMessageView, MsgCell_AbstractViewHolder> {

	final int ME_SHIFT = 100;
	RealmViewWrapperHolder wrapperHolder;

	public ChatRoomEntryAdaptor(RealmViewWrapperHolder data) {
		super(data.realmResults,true);
		this.wrapperHolder = data;

		setMultiTypeDelegate(new MultiDelegate());

	}

	@Override
	protected MsgCell_AbstractViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId, int viewType) {
		MsgCell_AbstractViewHolder cell = MsgCell_Empty.makeNew();
		switch (viewType) {
			case RoomMessageTypeEnum.TEXT_VALUE:
				cell = MsgCell_TextPeer.makeNew(parent);
				break;
			case RoomMessageTypeEnum.TEXT_VALUE + ME_SHIFT:
				cell = MsgCell_TextMe.makeNew(parent);
				break;

			case RoomMessageTypeEnum.IMAGE_VALUE:
				cell = MsgCell_PhotoPeer.makeNew(parent);
				break;

			case RoomMessageTypeEnum.IMAGE_VALUE + ME_SHIFT:
				cell = MsgCell_PhotoMe.makeNew(parent);
				break;

			case RoomMessageTypeEnum.IMAGE_TEXT_VALUE:
				cell = MsgCell_PhotoPeer.makeNew(parent);
				break;

			case RoomMessageTypeEnum.IMAGE_TEXT_VALUE + ME_SHIFT:
				cell = MsgCell_PhotoMe.makeNew(parent);
				break;

			case RoomMessageTypeEnum.VIDEO_VALUE:
				cell = MsgCell_VideoMe.makeNew(parent);//// TODO: 9/10/2017 fixme
				break;

			case RoomMessageTypeEnum.VIDEO_VALUE + ME_SHIFT:
				cell = MsgCell_VideoMe.makeNew(parent);//// TODO: 9/10/2017 fixme
				break;

			default:
				cell = MsgCell_TextMe.makeNew(parent);
		}
		AppUtil.log("MSG: type of message " + viewType + " layout: " + layoutResId);
		return cell;
	}

	@Override
	protected void convert(MsgCell_AbstractViewHolder helper, RealmMessageView item) {
		RealmMessageViewWrapper wrapper = new RealmMessageViewWrapper();
		wrapper.messageView = item;
		helper.bindToView(wrapper);
	}
}
