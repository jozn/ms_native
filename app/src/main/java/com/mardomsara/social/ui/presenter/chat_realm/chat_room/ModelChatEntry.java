package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.support.annotation.NonNull;

import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.NanoTimestamp;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import io.realm.Realm;
import ir.ms.pb.RoomMessageDeliviryStatusEnum;
import ir.ms.pb.RoomMessageTypeEnum;

/**
 * Created by Hamid on 9/11/2017.
 */

public class ModelChatEntry {

	public static void addNewTextMessage(@NonNull RealmChatView chatView, @NonNull String text){
		Realm realm = MSRealm.getChatRealm();

//		realm.executeTransaction();
		RealmMessageView r = new RealmMessageView();

		r.MessageId = NanoTimestamp.getNano();//0
		r.RoomKey = chatView.ChatKey ;//1
		r.UserId = chatView.UserId;//2
		r.MessageFileId = 0;//3
		r.MessageTypeEnumId = RoomMessageTypeEnum.TEXT_VALUE;//4
		r.Text = text;//5
		r.Time = (int) AppUtil.getTime();//6
		r.PeerReceivedTime = 0;//7
		r.PeerSeenTime = 0;//8
		r.DeliviryStatusEnumId = RoomMessageDeliviryStatusEnum.SENDING_VALUE;//9
		r.ChatId = chatView.ChatId;//10
		r.RoomTypeEnumId = chatView.RoomTypeEnumId ;//11
		r.IsByMe = true;//12

//		chatView.LastMessage = r;
//		r.File = ;//13

//		realm.copyFromRealm()
//		RealmChatView chatView2 = chatView;
		String chatKey = chatView.ChatKey;
		/*realm.executeTransactionAsync((trans)->{
			trans.copyToRealmOrUpdate(r);
			trans.copyToRealmOrUpdate(chatView);
		});*/


		RealmMessageView lastMsg;
		realm.beginTransaction();
		lastMsg = realm.copyToRealmOrUpdate(r);
		realm.commitTransaction();
		Helper.showDebugMessage("lastMsg: "+lastMsg.Text);

		RealmChatView chatView2 = RealmChatViewHelper.getChatByChatKey(MSRealm.getChatRealm(),chatKey);
		if(chatView2 != null){
			MSRealm.getChatRealm().executeTransaction((re)->{
				chatView2.UpdatedMs = AppUtil.getTimeMs();
				chatView2.LastMessage = lastMsg;
//				re.copyToRealmOrUpdate(chatView2);
			});
		}



	}
}
