package com.mardomsara.social.ui.presenter.chat_realm.inbox;

import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;

import java.util.ArrayList;
import java.util.List;

final class InboxRoomHelper {

        public static String getLastMsgFormatedText(RealmMessageView lastMsg){
			String txt = "";
            int limit = 40;
            switch (lastMsg.MessageTypeEnumId){
                case Constants.MESSAGE_TEXT:
                    txt = LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_IMAGE:
                    txt = "[عکس] " + LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_VIDEO:
                    txt = "[ویدیو] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_FILE:
                    txt = "[فایل] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_AUDIO:
                    txt = "[صوتی] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_STICKER:
                    txt = "[استیکر] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
                case Constants.MESSAGE_lOCCASION:
                    txt = "[مکان] " +LangUtil.limitText(lastMsg.Text, limit);
                    break;
            }
            return txt;
        }

        public static void moreRoomOptin(RealmChatView room, InboxChatsListAdaptor adaptor) {
            if(room == null || adaptor == null) return;
            List<DialogHelper.MenuItem> items = new ArrayList<>();
            items.add(new DialogHelper.MenuItem("پاک کردن پیام ها",(v)->{
				//TODO
//                AndroidUtil.runInBackgroundNoPanic(()-> RoomModel.clearRoomMsgs(room));
                adaptor.notifyDataSetChanged();
            }));

			//TODO
            items.add(new DialogHelper.MenuItem("حذف گفتگو",(v)->{
//                AndroidUtil.runInBackgroundNoPanic(()-> RoomModel.deleteRoom(room.RoomKey) );

//                adaptor.roomsList.remove(room);
                adaptor.notifyDataSetChanged();
            }));

            items.add(new DialogHelper.MenuItem("رفتن به پروفایل",(v)->{
                Router.goToProfile(RealmChatViewHelper.getUserId(room));
            }));

            DialogHelper.simpleMenu(items);
        }
    }