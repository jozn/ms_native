package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmResults;

/**
 * Created by Hamid on 9/11/2017.
 */

public class Wrapper {
	RealmResults<RealmMessageView> realmResults;
	//	List<RealmMessageView> messageViewList;
	Map<RealmMessageView, RealmMessageViewWrapper> map = new HashMap<>();
}
