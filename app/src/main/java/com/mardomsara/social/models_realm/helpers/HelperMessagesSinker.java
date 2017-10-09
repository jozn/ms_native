package com.mardomsara.social.models_realm.helpers;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageViewFields;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapper;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.RealmMessageViewWrapperBank;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;

/**
 * Created by Hamid on 10/9/2017.
 */

public class HelperMessagesSinker {

	public static void sinkAll() {
		RealmResults<RealmMessageView> msgs = AppRealm.getChatRealm().where(RealmMessageView.class)
			.equalTo(RealmMessageViewFields.DELIVIRY_STATUS_ENUM_ID, RoomMessageDeliviryStatusEnum.NEED_TO_SINK_VALUE)
//			.or().equalTo(RealmMessageViewFields.DELIVIRY_STATUS_ENUM_ID, RoomMessageDeliviryStatusEnum.FAILED_VALUE)
			.equalTo(RealmMessageViewFields.USER_ID, Session.getUserId())
			.findAll();

		RealmMessageViewWrapperBank.getInstance().register(msgs);


		for (RealmMessageView msg : msgs) {
			RealmMessageViewWrapper m = RealmMessageViewWrapperBank.getInstance().get(msg.MessageId);
			if (m != null) {
				m.retryUploading();
			}
		}

	}

}
