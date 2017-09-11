package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.view.ViewGroup;

import com.mardomsara.base_rv.BaseMultiItemQuickAdapter;
import com.mardomsara.base_rv.BaseQuickAdapter;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.X;
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
//public class ChatRoomEntryAdaptor2 extends BaseMultiItemQuickAdapter<RealmMessageView, MsgCell_AbstractViewHolder> {
public class ChatRoomEntryAdaptor2 extends BaseQuickAdapter<RealmMessageView, MsgCell_AbstractViewHolder> {

	final int ME_SHIFT = 100;
	Wrapper wraper;

//	public ChatRoomEntryAdaptor2(List<RealmMessageViewWrapper> data) {
	public ChatRoomEntryAdaptor2(Wrapper data) {
		super(data.realmResults);
		this.wraper = data;
//		setDefaultViewTypeLayout(X.Msg_Empty.IDS.LAYOUT);
//		addItemType(RoomMessageTypeEnum.UNKNOWN_MESSAGE_TYPE_VALUE, X.Msg_Empty.IDS.LAYOUT);

		setMultiTypeDelegate(new MultiDelegate());
/*
		//peers default - me id + 100
		addItemType(RoomMessageTypeEnum.TEXT_VALUE, X.Msg_RowTextPeer.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.IMAGE_VALUE, X.Msg_RowImagePeer.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.IMAGE_TEXT_VALUE, X.Msg_RowImagePeer.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.VIDEO_VALUE, X.Msg_RowVideoMe.IDS.LAYOUT);//// TODO: 9/10/2017 fix me
		addItemType(RoomMessageTypeEnum.VIDEO_TEXT_VALUE, X.Msg_RowVideoMe.IDS.LAYOUT);//TODO: 9/10/2017 fix me
		//// TODO: 9/10/2017  add others message types

		//me

		addItemType(RoomMessageTypeEnum.TEXT_VALUE + ME_SHIFT, X.Msg_RowTextMe.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.IMAGE_VALUE + ME_SHIFT, X.Msg_RowImageMe.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.IMAGE_TEXT_VALUE + ME_SHIFT, X.Msg_RowImageMe.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.VIDEO_VALUE + ME_SHIFT, X.Msg_RowVideoMe.IDS.LAYOUT);
		addItemType(RoomMessageTypeEnum.VIDEO_TEXT_VALUE + ME_SHIFT, X.Msg_RowVideoMe.IDS.LAYOUT);*/

	}

	@Override
	protected MsgCell_AbstractViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId, int viewType) {
		/*if(viewType > ME_SHIFT){
			viewType = viewType - ME_SHIFT;
		}*/
//		super.createBaseViewHolder()

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
//				cell = MsgCell_NotSupported.makeNew(parent);
				cell = MsgCell_TextMe.makeNew(parent);
		}
		AppUtil.log("MSG: type of message "+ viewType + " layout: " +layoutResId);
		return cell;
	}

	@Override
	protected void convert(MsgCell_AbstractViewHolder helper, RealmMessageView item) {
//		item.getItemType();
		helper.bindToView(item);
	}
}
/*
	static LayoutInflater _infl = LayoutInflater.from(AppUtil.getContext());

//	public final ArrayListHashSetKey<RealmMessageView, String> msgs = new ArrayListHashSetKey<>((msg) -> msg.toString());
	public final ArrayList<RealmMessageView> msgs = new ArrayList();

	public void setMsgs(List<RealmMessageView> msgs) {
		this.msgs.clear();
		this.msgs.addAll(msgs);
	}

	*/
/*@Override
	protected int getContentItemCount() {
		return msgs.size();
	}*//*


	@Override
	protected MsgCell_AbstractViewHolder creaViewHolder(ViewGroup parent, int contentViewType) {
		// Create a new view.
		View rowView = null;// _infl.inflate(R.layout.msg__empty, null, false);
		AppUtil.log("onCreateViewHolder: " + contentViewType);

		MsgCell_AbstractViewHolder msgView = MsgCell_Empty.makeNew();
		if (contentViewType % 2 == 0) {//even: peer
			switch (contentViewType) {
				case 10:
					msgView = MsgCell_TextPeer.makeNew(parent);
					break;
				case 12:
					rowView = _infl.inflate(R.layout.msg__row_contact_peer, parent, false);
					break;
				case 14:
					rowView = _infl.inflate(R.layout.msg__row_location_peer, parent, false);
					break;
				case 16:
					rowView = _infl.inflate(R.layout.msg__row_sticker_peer, parent, false);
					break;
				case 30:
					rowView = _infl.inflate(R.layout.msg__row_post_peer, parent, false);
					break;
				case 40://// TODO: 6/11/2016  :change to msg__row_image_peer
					msgView = MsgCell_PhotoPeer.makeNew(parent);
					break;
				case 42:
					msgView = MsgCell_VideoMe.makeNew(parent);
					break;
				case 44:
					rowView = _infl.inflate(R.layout.msg__row_file_peer, parent, false);
					break;
				default:
					msgView = MsgCell_NotSupported.makeNew(parent);
			}
		} else {//odd views: is ME
			switch (contentViewType - 1) {//1 comes from .isMsgByMe()
				case 10:
					msgView = MsgCell_TextMe.makeNew(parent);
					break;
				case 12:
					rowView = _infl.inflate(R.layout.msg__row_contact_me, parent, false);
					break;
				case 14:
					rowView = _infl.inflate(R.layout.msg__row_location_me, parent, false);
					break;
				case 16:
					rowView = _infl.inflate(R.layout.msg__row_sticker_me, parent, false);
					break;
				case 30:
					rowView = _infl.inflate(R.layout.msg__row_post_me, parent, false);
					break;
				case 40:
					msgView = MsgCell_PhotoMe.makeNew(parent);
					break;
				case 42:
					msgView = MsgCell_VideoMe.makeNew(parent);
					break;
				case 44:
					rowView = _infl.inflate(R.layout.msg__row_file_me, parent, false);
					break;
				default://todo needs it's kind of file( user cant do something that is not no his devise)
					msgView = MsgCell_NotSupported.makeNew(parent);
			}
		}

		if (contentViewType == 1 || contentViewType == 2) {
			rowView = _infl.inflate(R.layout.msg__row_system, parent, false);
		}
		return msgView;

	}

	@Override
	protected void onBindContentItemViewHolder(MsgCell_AbstractViewHolder msgAbstractViewHolder, int position) {
		RealmMessageView msg = msgs.get(position);
		if(msgAbstractViewHolder != null){
			msgAbstractViewHolder.bindToView(msg);
		}
	}

	@Override
	protected int getContentItemViewType(int position) {
		int type = 10;
		RealmMessageView m = msgs.get(position);
		if (m == null) return type;
		int me =0;
		if(m.IsByMe) me = 1;
		type = m.MessageTypeEnumId + me;
		return type;
	}

	@Override
	public void onViewRecycled(RecyclerView.ViewHolder holder) {
		if(holder instanceof MsgCell_AbstractViewHolder){
			((MsgCell_AbstractViewHolder) holder).onRecycled();
		}
	}

	@Override
	protected void convert(MsgCell_AbstractViewHolder helper, RealmMessageView item) {

	}
}
*/
