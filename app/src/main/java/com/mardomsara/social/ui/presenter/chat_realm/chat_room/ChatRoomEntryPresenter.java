package com.mardomsara.social.ui.presenter.chat_realm.chat_room;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.IntentHelper;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.models_old.tables.Message;
import com.mardomsara.social.models_realm.RealmChatViewHelper;
import com.mardomsara.social.models_realm.helpers.HelperMessageAdd;
import com.mardomsara.social.models_realm.pb_realm.RealmChatView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageView;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageViewFields;
import com.mardomsara.social.del.pipe_pb.from_net_calls.events.MsgReceivedToServerEvent;
import com.mardomsara.social.del.pipe_pb.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.del.pipe_pb.from_net_calls.json.MsgAddOneJson;
import com.mardomsara.social.del.pipe_pb.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.del.pipe_pb.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.del.pipe_pb.from_net_calls.json.MsgSeenByPeerJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.chats.adaptors.ChatEntryAdaptor;
import com.mardomsara.social.ui.cells.general.KeyboardAttachmentCell;
import com.mardomsara.social.ui.views.EmojiKeyboard;
import com.squareup.picasso.Picasso;
import com.sw926.imagefileselector.ImageFileSelector;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Hamid on 5/4/2016.
 */
public class ChatRoomEntryPresenter extends BasePresenter implements
	KeyboardAttachmentCell.KeyboardAttachmentListener, AppHeaderFooterRecyclerViewAdapter.LoadNextPage {
	//constants
	final int ATTACH_CAMERA_IMAGE = 1001;
	final int ATTACH_CAMERA_VIDEO = 1002;
	final int ATTACH_FILE = 1003;
	public RealmChatView room;
	//	ArrayListHashSetKey<Message,String> messages;
	ChatEntryAdaptor messagesAdaptor_DEP;
	//    com.mardomsara.social.ui.presenter.chat_realm.chat_room.del.ChatRoomEntryAdaptor adaptor;
//	RealmChatAdaptor_DEP adaptor_depp;
	ChatRoomEntryAdaptor adaptor2;
	KeyboardAttachmentCell attachment_view;
	LinearLayoutManager mLayoutManager;
	ChatRoomEntryPresenter that;
	IntentHelper intentHelper;
	Uri file_uri;
	EmojiKeyboard emojiKeyboard;
	X.ChatRoom_ScreenParent x;
	RealmResults<RealmMessageView> realmResults;
	private ImageFileSelector mImageFileSelector;

	@Override
	public View buildView() {
		x = new X.ChatRoom_ScreenParent();

		Nav.hideFooter();

		AndroidUtil.runInUi(() -> {


			x.send_msg_btn.setOnClickListener((v) -> addNewMsg());

			x.edit_field.setOnClickListener((v) -> {
				AppUtil.log("Keyboard");
			});
			x.edit_field.requestFocus();


			Realm realm = AppRealm.getChatRealm();
			realmResults = realm.where(RealmMessageView.class).equalTo(RealmMessageViewFields.CHAT_KEY, room.ChatKey).findAllSorted(RealmMessageViewFields.MESSAGE_ID, Sort.DESCENDING);

			/*List<RealmMessageViewWrapper> newMessageViewList = new ArrayList<>();
			for (RealmMessageView messageView: realmResults){
				RealmMessageViewWrapper viewWrapper = new RealmMessageViewWrapper();
				viewWrapper.messageView = messageView;
				newMessageViewList.add(viewWrapper);
			}*/

			messagesAdaptor_DEP = new ChatEntryAdaptor();
//        adaptor = new com.mardomsara.social.ui.presenter.chat_realm.chat_room.del.ChatRoomEntryAdaptor();
//        adaptor_depp = new RealmChatAdaptor_DEP(realmResults,true);
			RealmViewWrapperHolder wrapper = new RealmViewWrapperHolder();
//		wrapper.newMessageViewList = newMessageViewList;
			wrapper.realmResults = realmResults;
			adaptor2 = new ChatRoomEntryAdaptor(wrapper);


//		messages = messagesAdaptor_DEP.msgs;

			mLayoutManager = new LinearLayoutManager(AppUtil.getContext());

			mLayoutManager.setSmoothScrollbarEnabled(true);
			mLayoutManager.setReverseLayout(true);
			mLayoutManager.setStackFromEnd(true);
			mLayoutManager.scrollToPositionWithOffset(0, 10000);

//        x.recycler_view.setAdapter(messagesAdaptor_DEP);
//        x.recycler_view.setAdapter(adaptor_depp);
			x.recycler_view.setAdapter(adaptor2);
			x.recycler_view.setLayoutManager(mLayoutManager);
			x.recycler_view.setHasFixedSize(false);

//        messagesAdaptor_DEP.setUpForPaginationWith(x.recycler_view,mLayoutManager,this);
//		messagesAdaptor_DEP.setRecyclerView(x.recycler_view);

//		adaptor.setUpForPaginationWith(x.recycler_view,mLayoutManager,this);
//		adaptor.setRecyclerView(x.recycler_view);

			x.back.setOnClickListener((v) -> {
				onBack();
				Nav.pop();
			});

//        x.room_name.setText(room.getRoomName());
			x.room_name.setText(RealmChatViewHelper.getRoomName(room));
			App.getBus().register(this);

			emojiKeyboard = new EmojiKeyboard(x.edit_field, x.emoji_opener_btn, AppUtil.global_window);

			that = this;
			x.attach_btn.setOnClickListener((v) -> {
				showAttachmentWindow();
			});
			//todo later fix this for G
//        AppUtil.listanAndSaveKewordSize(view);

			setUpInputOnTextTextChanged();

			Uri imageUri = Helper.PathToUserAvatarUri(RealmChatViewHelper.getRoomAvatarUrl(room));
			Picasso.with(AppUtil.getContext())
				.load(imageUri)
				.into(x.avatar);

//		RoomModel.updateRoomSeenMsgsToNow_BG(room);


		});


		return x.root;
	}

	@Override
	public void onDestroy() {
		if (realmResults != null) {
			realmResults.removeAllChangeListeners();
		}
		/*super.onDestroy();
		App.getBus().unregister(this);
        AppUtil.unRegisterKeywoardlistaner(view);

        if(emojiKeyboard != null) emojiKeyboard.destroy();*/
	}

	public void onFocus() {
        /*super.onFocus();
        AppUtil.log("chatroom onFocus()");
        RoomModel.onRoomOpened_InBackground(room);*/
	}

	@Override
	public void onBack() {
		super.onBack();
		if (emojiKeyboard != null) {
			emojiKeyboard.destroy();
		}

		Nav.showFooter();
	}

	void setUpInputOnTextTextChanged() {
		x.edit_field.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				if (charSequence.length() > 0) {
					x.attach_btn.setVisibility(View.GONE);
					x.send_msg_btn.setVisibility(View.VISIBLE);
				} else {
					x.attach_btn.setVisibility(View.VISIBLE);
					x.send_msg_btn.setVisibility(View.GONE);
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});
	}

	void addNewMsg() {

		HelperMessageAdd.addNewTextMessage(room, x.edit_field.getText().toString());
		x.edit_field.setText("");
		adaptor2.notifyDataSetChanged();
		mLayoutManager.scrollToPosition(0);

        /*Message msg =  MessageModel.newTextMsgForRoom_ByMe(room);
        msg.MessageTypeId = Constants.MESSAGE_TEXT;
        msg.Text = x.edit_field.getText().toString();
        msg.insertInBackground();

        x.edit_field.setText("");
        MessageModel.syncTextMsgToServer(msg);

        onHereAddedNewMsgEvent_UI(msg);*/
	}

	void onHereAddedNewMsgEvent_UI(Message msg) {
		/*AndroidUtil.runInUiNoPanic(()->{
			messages.addStart(msg);
			messagesAdaptor_DEP.notifyContentItemInserted(0);
			mLayoutManager.scrollToPosition(0);

			MessageModel.didMsgAddedByMe(msg);
//			App.getBus().post(new RoomOrderChanged());
			Events.publish(new Events.RoomOrderChanged());
		});*/
	}

	public void showAttachmentWindow() {
		attachment_view = new KeyboardAttachmentCell(this, x.bottom_container);
	}

	///////////////////////////////////////////////////
	/////////////// Keyboard listener ////////////////
	@Override
	public void onCameraPhotoClick() {
		intentHelper = new IntentHelper();
		attachment_view.dismiss();
		file_uri = intentHelper.captureImage(getActivity(), ATTACH_CAMERA_IMAGE, "back");
	}

	@Override
	public void onGalleryClick() {
        /*attachment_view.dismiss();
        GalleryChooserPresenter gallery =new GalleryChooserPresenter();
        FIxme: gallery.chatEntryPresenter to interface
//        gallery.chatEntryPresenter = this;
        Nav.push(gallery);*/
	}

	@Override
	public void onVideoClick() {
        /*attachment_view.dismiss();
        String tempPath = AppFiles.APP_TEMP_DIR_PATH+"VID_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.mp4";
        String resizedPath = FileUtil.createNextName(tempPath);

        intentHelper = new IntentHelper();
        file_uri = intentHelper.recordVideo(getActivity(),ATTACH_CAMERA_VIDEO,"back",resizedPath);*/
	}

	@Override
	public void onAudioClick() {
		comingSoon();
	}

	@Override
	public void onLocationClick() {

	}

	@Override
	public void onFileClick() {
		comingSoon();
		//keep this

	}

	void comingSoon() {
		Helper.showMessage("به زودی در نسخه های بعد ...");
	}

	@Override
	public void onContactClick() {

	}

	@Override
	public void onRecentImagesSendClicked(List<String> imagesPath) {
		attachment_view.dismiss();

		for (String image : imagesPath) {
			AndroidUtil.runInUiNoPanic(() -> {//Async
				_sendMsgImage(image, false);
				scrollToBottom();
			});
		}

		/*AndroidUtil.runInUiNoPanic(()->{//Async
			for(String image : imagesPath){
				_sendMsgImage(image,false);
			}
		});*/
	}

	;


	public void onGalleryChooserVideoClicked(List<String> videoPaths) {
        /*attachment_view.dismiss();
		AndroidUtil.runInBackgroundNoPanic(()->{
			for(String image : videoPaths){
				_sendMsgVideo(image);
			}
		});*/
	}

	;

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*super.onActivityResult(requestCode, resultCode, data);
        logIt("onActivityResult: chat "+requestCode+ " " + resultCode+ Activity.RESULT_OK + " " +data);
        if(resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case ATTACH_CAMERA_IMAGE:
                    createMsgPhotoFromCamera();
                    break;
                case ATTACH_CAMERA_VIDEO:
                    createMsgVideoFromCamera();
                    break;
            }
        }*/
	}

	//// TODO: migrate to _sendMsgImage(path)
	void createMsgPhotoFromCamera() {
        /*logIt("file_uri: "+ file_uri);
        if(file_uri == null)return;
        _sendMsgImage(file_uri.getPath(),true);*/
	}

	void createMsgVideoFromCamera() {
        /*logIt("createMsgVideoFromCamera() file_uri: "+ file_uri);
        String path = file_uri.getPath();
        File file = new File(file_uri.getPath());
        _sendMsgVideo(file_uri.getPath());*/
	}

	void _sendMsgImage(String path, final boolean deleteOriginal) {
		HelperMessageAdd.addSingleImageMessage(room, "new 2image !!!" + path, path, deleteOriginal);
//		scrollToBottom();


        /*logIt("_sendMsgImage: "+ path + " "+deleteOriginal);
        if(path== null || path.equals("")) return;
        File fileOriginal = new File(path);
		if( ! fileOriginal.exists() ){
			_showToastFileAreNotExist();
			return;
		}

        String $resizedPath = AppFiles.PHOTO_SENT_DIR_PATH+"IMG_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.jpg";
        String resizedPath = FileUtil.createNextName($resizedPath);
        ImageUtil.resizeImage(path,resizedPath,1080);
        File resizedFile = new File(resizedPath);

        if(!resizedFile.exists()){
			_showToastFileAreNotExist();
            return;
        }
        Message msg =  MessageModel.newTextMsgForRoom_ByMe(room);
        msg.setMsgFile_Status(Constants.Msg_Media_To_Push_And_Upload);
        msg.MessageTypeId = Constants.MESSAGE_IMAGE;
        MessageModel.setPhotoParams_ME(msg,resizedPath);
        msg.saveWithRoom();

		MsgsCallToServer.sendNewPhoto(msg,resizedFile,fileOriginal,deleteOriginal);
		onHereAddedNewMsgEvent_UI(msg);*/

	}

	private void _showToastFileAreNotExist() {
		Helper.showMessage("فایل موجود نیست");
	}

	void _sendMsgVideo(String savedPath) {
        /*logIt("_sendMsgVideo: "+ savedPath);
        String $resizedPath = AppFiles.VIDEO_SENT_DIR_PATH+"VID_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.mp4";
        String thumbPath = AppFiles.VIDEO_SENT_DIR_PATH+"THUMB_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.jpg";
        String resizedPath = savedPath;
        thumbPath = FileUtil.createNextName(thumbPath);
        Bitmap bitmap = ImageUtil.createVideoThumbnail(savedPath, 1024,360);
        if(bitmap != null){
            ImageUtil.saveToFile(bitmap,thumbPath);
        }
        File resizedFile = new File(resizedPath);


        if(!resizedFile.exists()){
            Toast.makeText(getContext(),"فایل موجود نیست",Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg =  MessageModel.newTextMsgForRoom_ByMe(room);
        msg.setMsgFile_Status((Constants.Msg_Media_To_Push_And_Upload));
        msg.MessageTypeId = (Constants.MESSAGE_VIDEO);
        MessageModel.setVideoParams(msg,thumbPath,resizedPath);
        msg.saveWithRoom();

		MsgsCallToServer.sendNewVideo(msg,resizedFile);

		onHereAddedNewMsgEvent_UI(msg);*/

	}

	//// TODO: 1/30/2017 do in background
	//pageNum is actuly is alaways >= 1
	@Override
	public void loadNextPage(int pageNum) {
		/*messagesAdaptor_DEP.nextPageIsLoaded();

        int size = messagesAdaptor_DEP.msgs.size();
        List<Message> msgs = null;
		long lastSortId = 0;
        if(size > 0){
            lastSortId = messagesAdaptor_DEP.msgs.get(size -1).SortId;
        }
		msgs = MessageModel.getRoomMessagesTimeOffset(room.RoomKey,lastSortId);
		if(msgs.size() >0){
			messagesAdaptor_DEP.msgs.addAllEnd(msgs);
//                messagesAdaptor_DEP.notifyDataChanged();
		}else if (pageNum == 1){
			messagesAdaptor_DEP.setEmptyNoteView(new X.Msg_FullPageEmptyNote(x.recycler_view).root);
			messagesAdaptor_DEP.showEmptyView();
		}else {
			messagesAdaptor_DEP.setHasMorePage(false);
		}

		//fix for no jumping for first few msgs
        if(msgs.size() < MessageModel.MSGS_PER_PAGE){
            messagesAdaptor_DEP.setHasMorePage(false);
        }

		messagesAdaptor_DEP.notifyDataChanged();

        Helper.showDebugMessage("page : "+pageNum);*/
	}

	void scrollToBottom() {
		AndroidUtil.runInUiNoPanic(() -> {
			mLayoutManager.scrollToPosition(0);
		});
	}

	//all deprecated
	/////////////////// Events /////////////////////////

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(@NonNull MsgAddOneJson data) {
		/*logIt("event new: MsgAddOneJson " + data.toString());
		Message msg = data.Message;
		if(msg.RoomKey.equals(room.RoomKey)){
			if(!messagesAdaptor_DEP.msgs.contains(msg)){
				try {
					messagesAdaptor_DEP.msgs.addStart(msg);
					messagesAdaptor_DEP.notifyDataChanged();

				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		RoomModel.updateRoomSeenMsgsToNow_BG(room);*/
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(@NonNull MsgAddManyJson data) {
		/*logIt("event new: MsgAddManyJson " + data.toString());
		List<Message> msgs = data.Messages;
		for(Message msg : msgs){
			if(msg.RoomKey.equals(room.RoomKey)) {
				if (!messagesAdaptor_DEP.msgs.contains(msg)) {
					try {
						messagesAdaptor_DEP.msgs.addStart(msg);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		messagesAdaptor_DEP.notifyDataChanged();

		RoomModel.updateRoomSeenMsgsToNow_BG(room);*/
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(@NonNull MsgReceivedToServerEvent data) {
		/*logIt("event new: MsgReceivedToServerEvent " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor_DEP.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.ServerReceivedTime = data.AtTime;
					messagesAdaptor_DEP.notifyDataChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}*/
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(@NonNull MsgDeletedFromServerJson data) {
		/*logIt("event new: MsgDeletedFromServerJson " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor_DEP.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.ServerDeletedTime = data.AtTime;
					messagesAdaptor_DEP.notifyDataChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}*/
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(@NonNull MsgReceivedToPeerJson data) {
		/*logIt("event new: MsgReceivedToPeerJson  " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor_DEP.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.PeerReceivedTime = data.AtTime;
					messagesAdaptor_DEP.notifyDataChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}*/
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(@NonNull MsgSeenByPeerJson data) {
		/*logIt("event new: MsgSeenByPeerJson " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor_DEP.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.PeerSeenTime = data.AtTime;
					messagesAdaptor_DEP.notifyDataChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}*/
	}

}