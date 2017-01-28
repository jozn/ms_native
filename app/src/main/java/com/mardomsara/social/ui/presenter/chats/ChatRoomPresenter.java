package com.mardomsara.social.ui.presenter.chats;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ipaulpro.afilechooser.FileChooserActivity;
import com.ipaulpro.afilechooser.utils.FileChooserFileUtils;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.IntentHelper;
import com.mardomsara.social.lib.AppHeaderFooterRecyclerViewAdapter;
import com.mardomsara.social.lib.ms.ArrayListHashSetKey;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.events.RoomOrderChanged;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.pipe.from_net_calls.MsgsCallToServer;
import com.mardomsara.social.pipe.from_net_calls.events.MsgReceivedToServerEvent;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddOneJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgSeenByPeerJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.chats.lists.MsgsListCell;
import com.mardomsara.social.ui.cells.general.KeyboardAttachmentCell;
import com.mardomsara.social.ui.views.EmojiKeyboard;
import com.squareup.picasso.Picasso;
import com.sw926.imagefileselector.ImageFileSelector;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Hamid on 5/4/2016.
 */
public class ChatRoomPresenter extends BasePresenter implements
        KeyboardAttachmentCell.Callbacks , AppHeaderFooterRecyclerViewAdapter.LoadNextPage{
    public Room room;

    //constants
    final int ATTACH_CAMERA_IMAGE = 1001;
    final int ATTACH_CAMERA_VIDEO = 1002;
    final int ATTACH_FILE = 1003;

    private ImageFileSelector mImageFileSelector;
    View view;

	ArrayListHashSetKey<Message,String> messages;
    MsgsListCell messagesCell;
    MsgsListCell.ChatEntryAdaptor messagesAdaptor;

    KeyboardAttachmentCell attachment_view;
    LinearLayoutManager mLayoutManager;
    ChatRoomPresenter that;

    IntentHelper intentHelper;
    Uri file_uri;
    EmojiKeyboard emojiKeyboard;

	X.Chat_EntryRoom x;

    @Override
    public View buildView() {
		x = new X.Chat_EntryRoom();
        view = x.root;

        x.send_msg_btn.setOnClickListener((v)->addNewMsg());

        x.edit_field.setOnClickListener((v)->{
            AppUtil.log("Keybord");
        });
        x.edit_field.requestFocus();

        Nav.hideFooter();

        messagesCell = new MsgsListCell();
        messagesAdaptor =messagesCell.adaptor;

		messages = messagesAdaptor.msgs;

        mLayoutManager = new LinearLayoutManager(AppUtil.getContext());

        mLayoutManager.setSmoothScrollbarEnabled(false);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mLayoutManager.scrollToPositionWithOffset(0,10000);

        x.recycler_view.setAdapter(messagesAdaptor);
        x.recycler_view.setLayoutManager(mLayoutManager);
        x.recycler_view.setHasFixedSize(false);

        messagesAdaptor.setUpForPaginationWith(x.recycler_view,mLayoutManager,this);
		messagesAdaptor.setRecyclerView(x.recycler_view);

        x.back.setOnClickListener((v)-> {
                Nav.pop();
                onBack();
		});

        x.room_name.setText(room.getRoomName());
        App.getBus().register(this);

        emojiKeyboard = new EmojiKeyboard(x.edit_field,x.emoji_opener_btn, AppUtil.global_window);

        that = this;
        x.attach_btn.setOnClickListener((v)->{ showAttachmentWindow();});
        //todo later fix this for G
//        AppUtil.listanAndSaveKewordSize(view);

        setUpInputOnTextTextChanged();

        Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
        Picasso.with(AppUtil.getContext())
                .load(imageUri)
                .into(x.avatar);

		RoomModel.updateRoomSeenMsgsToNow_BG(room);

		return view;
    }

	@Override
    public void onDestroy() {
        super.onDestroy();
        App.getBus().unregister(this);
        AppUtil.unRegisterKeywoardlistaner(view);

        if(emojiKeyboard != null) emojiKeyboard.destroy();
    }

    public void onFocus() {
        super.onFocus();
        AppUtil.log("chatroom onFocus()");
        RoomModel.onRoomOpenedInBackground(room);
    }

    @Override
    public void onBack() {
        super.onBack();
        Nav.showFooter();
        if(emojiKeyboard != null){
            emojiKeyboard.destroy();
        }

    }

    void setUpInputOnTextTextChanged(){
        x.edit_field.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()>0){
                    x.attach_btn.setVisibility(View.GONE);
                    x.send_msg_btn.setVisibility(View.VISIBLE);
                }else {
                    x.attach_btn.setVisibility(View.VISIBLE);
                    x.send_msg_btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    void addNewMsg(){
        Message msg =  MessageModel.newTextMsgForRoom(room);
        msg.MessageTypeId = Constants.MESSAGE_TEXT;
        msg.Text = x.edit_field.getText().toString();
        msg.insertInBackground();

        x.edit_field.setText("");
        MessageModel.syncToServer(msg);

        onHereAddedNewMsgEvent(msg);
    }

    void onHereAddedNewMsgEvent(Message msg){
        messages.addStart(msg);
        messagesAdaptor.notifyContentItemInserted(0);
        mLayoutManager.scrollToPosition(0);

        MessageModel.didMsgsAdded(msg);
		App.getBus().post(new RoomOrderChanged());
    }

    public void showAttachmentWindow(){
        attachment_view = new KeyboardAttachmentCell(this,x.bottom_container);
    }

	/////////////////// Events /////////////////////////

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgAddOneJson data){
		logIt("event new: MsgAddOneJson " + data.toString());
		Message msg = data.Message;
		if(msg.RoomKey.equals(room.RoomKey)){
			if(!messagesAdaptor.msgs.contains(msg)){
				try {
					messagesAdaptor.msgs.addStart(msg);
					messagesAdaptor.notifyDataSetChanged();

				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		RoomModel.updateRoomSeenMsgsToNow_BG(room);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgAddManyJson data){
		logIt("event new: MsgAddManyJson " + data.toString());
		List<Message> msgs = data.Messages;
		for(Message msg : msgs){
			if(msg.RoomKey.equals(room.RoomKey)) {
				if (!messagesAdaptor.msgs.contains(msg)) {
					try {
						messagesAdaptor.msgs.addStart(msg);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		messagesAdaptor.notifyDataSetChanged();

		RoomModel.updateRoomSeenMsgsToNow_BG(room);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgReceivedToServerEvent data){
		logIt("event new: MsgReceivedToServerEvent " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.ServerReceivedTime = data.AtTime;
					messagesAdaptor.notifyDataSetChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgDeletedFromServerJson data){
		logIt("event new: MsgDeletedFromServerJson " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.ServerDeletedTime = data.AtTime;
					messagesAdaptor.notifyDataSetChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgReceivedToPeerJson data){
		logIt("event new: MsgReceivedToPeerJson  " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.PeerReceivedTime = data.AtTime;
					messagesAdaptor.notifyDataSetChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(MsgSeenByPeerJson data){
		logIt("event new: MsgSeenByPeerJson " + data.toString());
		if(data.RoomKey.equals(room.RoomKey)){
			Message msg = messagesAdaptor.msgs.getByKey(data.MsgKey);
			if(msg != null){
				try {
					msg.PeerSeenTime = data.AtTime;
					messagesAdaptor.notifyDataSetChanged();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

    //keyborad listener
    @Override
    public void onCameraPhotoClick() {
        intentHelper = new IntentHelper();
//        attachWindow.dismiss();
        attachment_view.dismiss();
        file_uri =  intentHelper.captureImage(getActivity(), ATTACH_CAMERA_IMAGE,"back");
    }

    ArrayList<String> selectedPhotos = new ArrayList<>();
    @Override
    public void onGalleryClick() {
        attachment_view.dismiss();
        GalleryChooserPresenter gallery =new GalleryChooserPresenter();
        //FIxme: gallery.chatEntryPresenter to interface
        gallery.chatEntryPresenter = this;
        Nav.push(gallery);
    }

    @Override
    public void onVideoClick() {
        attachment_view.dismiss();
//        String $resizedPath = AppFiles.VIDEO_SENT_DIR_PATH+"VID_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.mp4";
        String tempPath = AppFiles.APP_TEMP_DIR_PATH+"VID_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.mp4";
        String resizedPath = FileUtil.createNextName(tempPath);

        intentHelper = new IntentHelper();
        file_uri = intentHelper.recordVideo(getActivity(),ATTACH_CAMERA_VIDEO,"back",resizedPath);
    }

    @Override
    public void onAudioClick() {

    }

    @Override
    public void onLocationClick() {
        Intent target = new Intent(getActivity(), FileChooserActivity.class);
        // Create the chooser Intent
        Intent intent = Intent.createChooser(
                target, "CCCCCCCC");
        try {
            getActivity().startActivityForResult(target, 555);
        } catch (ActivityNotFoundException e) {
            // The reason for the existence of aFileChooser
        }
//        ContentProvider
    }

    @Override
    public void onFileClick() {
//        private void showChooser() {
            // Use the GET_CONTENT intent from the utility class
            Intent target = FileChooserFileUtils.createGetContentIntent();
            // Create the chooser Intent
            Intent intent = Intent.createChooser(
                    target, "CCCCCCCC");
            try {
                getActivity().startActivityForResult(intent, 555);
            } catch (ActivityNotFoundException e) {
                // The reason for the existence of aFileChooser
            }
//        }
    }

    @Override
    public void onContactClick() {

    }

    @Override
    public void onRecentImagesSendClicked(List<String> imagesPath){
        attachment_view.dismiss();
        for(String image : imagesPath){
            _sendMsgImage(image,false);
        }
    };


    public void onGalleryChoserVideoClicked(List<String> videoPaths){
        attachment_view.dismiss();
        for(String image : videoPaths){
            _sendMsgVideo(image);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        logIt("onActivityResult: chat "+requestCode+ " " + resultCode+ Activity.RESULT_OK + " " +data);
        if(resultCode == Activity.RESULT_OK){
//            logIt("onActivityResult: 11 ");

            switch (requestCode){
                case ATTACH_CAMERA_IMAGE:
//                    AndroidUtil.runInBackground(()->{createMsgPhotoFromCamera();});
                    createMsgPhotoFromCamera();
//                    logIt("onActivityResult: 22 ");
                    break;
                case ATTACH_CAMERA_VIDEO:
                    createMsgVideoFromCamera();
                    break;
            }
        }
    }

    //// TODO: migrate to _sendMsgImage(path)
    void createMsgPhotoFromCamera(){
        logIt("file_uri: "+ file_uri);
        if(file_uri == null)return;
        String path = file_uri.getPath();
        File file = new File(file_uri.getPath());
        _sendMsgImage(file_uri.getPath(),true);

    }

    void createMsgVideoFromCamera(){
        logIt("createMsgVideoFromCamera() file_uri: "+ file_uri);
        String path = file_uri.getPath();
        File file = new File(file_uri.getPath());
        _sendMsgVideo(file_uri.getPath());
    }

    void _sendMsgImage(String path, final boolean deleteOrginal){
        logIt("_sendMsgImage: "+ path + " "+deleteOrginal);
//        String path = file_uri.getPath();
        if(path== null || path.equals("")) return;
        File fileOrginal = new File(path);

        String $resizedPath = AppFiles.PHOTO_SENT_DIR_PATH+"IMG_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.jpg";
        String resizedPath ;//= $resizedPath.replace("$","");
//        resizedPath = FileUtil.createNextFile($resizedPath).getAbsolutePath();
        resizedPath = FileUtil.createNextName($resizedPath);
        ImageUtil.resizeImage(path,resizedPath,1080);
        File resizedFile = new File(resizedPath);

        if(!resizedFile.exists()){
            Toast.makeText(getContext(),"فایل موجود نیست",Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg =  MessageModel.newTextMsgForRoom(room);
        msg.MediaStatus = Constants.Msg_Media_To_Push;
        msg.MessageTypeId = Constants.MESSAGE_IMAGE;
        MessageModel.setPhotoParams(msg,resizedPath);
        msg.saveWithRoom();

		MsgsCallToServer.sendNewPhoto(msg,resizedFile,fileOrginal,deleteOrginal);
		onHereAddedNewMsgEvent(msg);

    }

    void _sendMsgVideo(String savedPath){
        logIt("_sendMsgVideo: "+ savedPath);
//        String path = file_uri.getPath();
//        File tempFile = new File(savedPath);

        String $resizedPath = AppFiles.VIDEO_SENT_DIR_PATH+"VID_R_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.mp4";
//        String resizedPath ;//= $resizedPath.replace("$","");
        String thumbPath = AppFiles.VIDEO_SENT_DIR_PATH+"THUMB_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.jpg";
//        resizedPath = FileUtil.createNextFile($resizedPath).getAbsolutePath();
//        resizedPath = FileUtil.createNextName($resizedPath);
        String resizedPath = savedPath;
//        Log.d("Viseo", "size: "+ new File(resizedPath).length());
        thumbPath = FileUtil.createNextName(thumbPath);
//        ImageUtil.resizeImage(path,resizedPath,1024);
//        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(savedPath, MediaStore.Video.Thumbnails.MINI_KIND);
        Bitmap bitmap = ImageUtil.createVideoThumbnail(savedPath, 1024,360);
        if(bitmap != null){
            ImageUtil.saveToFile(bitmap,thumbPath);
        }
        File resizedFile = new File(resizedPath);


        if(!resizedFile.exists()){
            Toast.makeText(getContext(),"فایل موجود نیست",Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg =  MessageModel.newTextMsgForRoom(room);
        msg.MediaStatus = (Constants.Msg_Media_To_Push);
        msg.MessageTypeId = (Constants.MESSAGE_VIDEO);
        MessageModel.setVideoParams(msg,thumbPath,resizedPath);
        msg.saveWithRoom();

		MsgsCallToServer.sendNewVideo(msg,resizedFile);

		onHereAddedNewMsgEvent(msg);

    }

	//pageNum is actuly is alaways >= 1
    @Override
    public void loadNextPage(int pageNum) {
        int size = messagesAdaptor.msgs.size();
        List<Message> msgs = null;
		long lastSortId = 0;
        if(size > 0){
            lastSortId = messagesAdaptor.msgs.get(size -1).SortId;
        }
		msgs = MessageModel.getRoomMessagesTimeOffset(room.RoomKey,lastSortId);
		if(msgs != null){
			messagesAdaptor.msgs.addAllEnd(msgs);
//                messagesAdaptor.notifyDataSetChanged();
		}

        if(msgs == null || msgs.size() == 0 || msgs.size() < MessageModel.MSGS_PER_PAGE){
            messagesAdaptor.setHasMorePage(false);
        }

		messagesAdaptor.notifyDataSetChanged();

        Helper.showDebugMessage("page : "+pageNum);
    }

}


//////////////////////////////////////////////////////////////
/////////////// KEEP This codes //////////////////////////////
//////////////////////////////////////////////////////////////
/*
//        if(Build.VERSION.SDK_INT >= 18){
            AndroidUtil.runInBackground(()->{
                Uri inputUri = Uri.parse(savedPath); //uris[0];
                Uri outputUri = Uri.parse(resizedPath); //uris[1];

                VideoResampler resampler = new VideoResampler();
                resampler.addSamplerClip( new SamplerClip( inputUri ) );
                // resampler.setInput( inputUri );
                resampler.setOutput( outputUri );
                Resolution res = Resolution.RESOLUTION_360P;

                resampler.setOutputResolution( res.getWidth(), res.getHeight() );
                resampler.setOutputBitRate( 512000 );
                resampler.setOutputFrameRate( 25 );
                resampler.setOutputIFrameInterval( 1 );
                Log.d("resampler","starting");
                try {
                    resampler.start();
                } catch ( Throwable e ) {
                    e.printStackTrace();
                }

            });
//        }
*/




