package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.models_realm.RealmMessageViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import java.util.WeakHashMap;

/**
 * Created by Hamid on 10/9/2017.
 */

public class RealmMessageViewWrapperBank {
	static RealmMessageViewWrapperBank instance;

	private WeakHashMap<Long, RealmMessageViewWrapper> map = new WeakHashMap<>();

	public RealmMessageViewWrapperBank() {

	}

	public static RealmMessageViewWrapperBank getInstance() {
		if (instance == null) {
			instance = new RealmMessageViewWrapperBank();
		}
		return instance;
	}

	public void register(RealmMessageViewWrapper messageViewWrapper) {
		if (messageViewWrapper == null) return;
		map.put(messageViewWrapper.MessageBankKey, messageViewWrapper);
	}

//////////////////////////////////

	public RealmMessageViewWrapper getOrLoad(Long MessageId) {
		RealmMessageViewWrapper msg = map.get(MessageId);
		if (msg == null) {
			RealmMessageView msgView = RealmMessageViewHelper.getMessageByMessageId(AppRealm.getChatRealm(), MessageId);
			if (msgView != null) {
				msg = new RealmMessageViewWrapper(msgView);
			}
		}
		return msg;
	}
}
