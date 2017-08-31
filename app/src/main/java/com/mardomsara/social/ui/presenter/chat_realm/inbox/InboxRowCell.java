package com.mardomsara.social.ui.presenter.chat_realm.inbox;


import android.net.Uri;
import android.view.ViewGroup;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.chat_realm.RoomsListCell;

public  class InboxRowCell {
	public Room room;
        RoomsListCell.RoomsListAdaptor adaptor;

		X.Chat_ListRow x;

        public InboxRowCell(ViewGroup parent, InboxRoomsListAdaptor adaptor) {
			x = new X.Chat_ListRow(parent);
            this.adaptor = adaptor;

            x.root.setOnClickListener((vv)->{
                if (room!= null) Nav.push(Router.getRoomEntry(room));
            });

            x.root.setOnLongClickListener((vv)->{
                RoomHelper.moreRoomOptin(room,adaptor);
                return true;
            });
        }

        public void bind(Room room){
            Message lastMsg = MemoryStore_LastMsgs.getForRoom(room);
            this.room = room;
            x.name_txt.setText(room.getRoomName());
            x.date_txt.setText(""+ FormaterUtil.friendlyTimeClockOrDayMs(room.UpdatedMs));//+"قبل");
            x.unseen_count_txt.setCount(room.UnseenMessageCount);

            if(lastMsg != null){
                x.last_msg_txt.setText(RoomHelper.getLastMsgFormatedText(lastMsg));
            }else {//clear from previus
                x.last_msg_txt.setText("");
            }
            Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
//			x.avatar.setBackgroundColor(ColorGenerator.MATERIAL.getColor(imageUri));
			/*GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(x.avatar.getResources())
				.setFadeDuration(300)
				.setPlaceholderImage( new IconColorfulDrawable(x.avatar.getContext(),"ion-ios-person-outline"))
//				.setPlaceholderImage( TextDrawable.builder().buildRect("م", ColorGenerator.MATERIAL.getColor(imageUri)))
//				.setPlaceholderImage( R.drawable.user_avatar)
				.setRoundingParams(RoundingParams.fromCornersRadius(30f))
//				.setBackground(background)
//				.setOverlays(overlaysList)
				.build();*/
//			x.avatar.setHierarchy(hierarchy);
            x.avatar.setImageURIAndId(imageUri, room.getUserId());
        }
    }