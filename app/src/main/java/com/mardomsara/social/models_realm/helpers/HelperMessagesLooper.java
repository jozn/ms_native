package com.mardomsara.social.models_realm.helpers;

import com.mardomsara.social.app.AppRealm;
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

public class HelperMessagesLooper {

	public static void loopOnMainThread() {
		RealmResults<RealmMessageView> msgs = AppRealm.getChatRealm().where(RealmMessageView.class)
			.equalTo(RealmMessageViewFields.DELIVIRY_STATUS_ENUM_ID, RoomMessageDeliviryStatusEnum.NEED_TO_SINK_VALUE)
			.findAll();

		msgs.addChangeListener(new RealmChangeListener<RealmResults<RealmMessageView>>() {
			@Override
			public void onChange(RealmResults<RealmMessageView> realmMessageViews) {
				for (RealmMessageView realmMessageView : realmMessageViews) {
					RealmMessageViewWrapper wrapper =RealmMessageViewWrapperBank.getInstance().getOrLoad(realmMessageView.MessageId);
					if(wrapper != null){
						wrapper.retryUploading();
					}
				}
			}
		});

	}

}
