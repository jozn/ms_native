package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.view.ViewGroup;

import com.mardomsara.base_rv.BaseRealmRecyclerViewAdapter;
import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_AbstractViewHolder;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_Empty;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_PhotoMe;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_PhotoOnlyMe;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_PhotoOnlyPeer;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_PhotoPeer;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_TextMe;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_TextPeer;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.msgs.MsgCell_VideoMe;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.views.MsgRowParentLinearLayout;

import java.util.Date;

import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 1/28/2017.
 */
public class ChatRoomEntryAdaptor extends BaseRealmRecyclerViewAdapter<RealmMessageView, MsgCell_AbstractViewHolder> {

	final int ME_SHIFT = 100;
	RealmViewWrapperHolder wrapperHolder;

	public ChatRoomEntryAdaptor(RealmViewWrapperHolder data) {
		super(data.realmResults, true);
		this.wrapperHolder = data;

		setMultiTypeDelegate(new MultiDelegate());

	}

	@Override
	protected MsgCell_AbstractViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId, int viewType) {
		MsgCell_AbstractViewHolder cell = MsgCell_Empty.makeNew();
		switch (viewType) {
			case RoomMessageTypeEnum.TEXT_VALUE:
			case RoomMessageTypeEnum.EMOJI_VALUE:
				cell = MsgCell_TextPeer.makeNew(parent);
				break;
			case RoomMessageTypeEnum.TEXT_VALUE + ME_SHIFT:
			case RoomMessageTypeEnum.EMOJI_VALUE + ME_SHIFT:
				cell = MsgCell_TextMe.makeNew(parent);
				break;

			case RoomMessageTypeEnum.IMAGE_VALUE:
				cell = MsgCell_PhotoOnlyPeer.makeNew(parent);
				break;

			case RoomMessageTypeEnum.IMAGE_VALUE + ME_SHIFT:
				cell = MsgCell_PhotoOnlyMe.makeNew(parent);
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
				cell = MsgCell_Empty.makeNew();// MsgCell_TextMe.makeNew(parent);
		}
		AppLogger.getChatLogger().d("MSG: type of message " + viewType + " layout: " + layoutResId);
		return cell;
	}

	@Override
	protected void convert(MsgCell_AbstractViewHolder helper, RealmMessageView item, int position) {
		RealmMessageViewWrapper wrapper = new RealmMessageViewWrapper(item);
//		wrapper.messageView = item;
		helper.bindToView(wrapper);
		if (helper.getGrandView() instanceof MsgRowParentLinearLayout) {
			try {
				if (wrapperHolder.realmResults.size() >= position + 1) {
					String sep = FormaterUtil.friendlyMsgSeprationTime(item.CreatedSe, wrapperHolder.realmResults.get(position + 1).CreatedSe);
					((MsgRowParentLinearLayout) helper.getGrandView()).setTime(sep);
				} else {
					String sep = FormaterUtil.friendlyMsgSeprationTime(item.CreatedSe, TimeUtil.getTimeSecInt());
					((MsgRowParentLinearLayout) helper.getGrandView()).setTime(sep);
				}
			} catch (Exception e) {
				((MsgRowParentLinearLayout) helper.getGrandView()).hide();
			}
		}
	}
}
