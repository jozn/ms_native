package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import com.mardomsara.base_rv.entity.MultiItemEntity;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

/**
 * Created by Hamid on 9/10/2017.
 */

public class RealmMessageViewWrapper implements MultiItemEntity {
	RealmMessageView messageView;

	@Override
	public int getItemType() {
		return messageView.MessageTypeEnumId;
	}
}
