package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import com.mardomsara.base_rv.util.MultiTypeDelegate;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.ui.X;

import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 9/10/2017.
 */

public class MultiDelegate  extends MultiTypeDelegate<RealmMessageView>{
	final int ME_SHIFT = 100;
	public MultiDelegate() {
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
		addItemType(RoomMessageTypeEnum.VIDEO_TEXT_VALUE + ME_SHIFT, X.Msg_RowVideoMe.IDS.LAYOUT);
	}

	@Override
	protected int getItemType(RealmMessageView realmMessageViewWrapper) {
		int i = realmMessageViewWrapper.MessageTypeEnumId;
		if(realmMessageViewWrapper.UserId == Session.getUserId()){
			i = 100 + i;
		}
		return i;
	}
}
