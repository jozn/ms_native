package com.mardomsara.social.ui.presenter.chats;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ipaulpro.afilechooser.FileChooserActivity;
import com.ipaulpro.afilechooser.utils.FileChooserFileUtils;
import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.social.App;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.IntentHelper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgGeneralChangeChangeEvent;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.chats.lists.MsgsListCell;
import com.mardomsara.social.ui.views.EmojiKeyboard3;
import com.mardomsara.social.ui.cells.general.KeywordAttachmentCell;
import com.squareup.picasso.Picasso;
import com.sw926.imagefileselector.ImageFileSelector;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 5/4/2016.
 */
public class ChatRoomPresenter extends BasePresenter implements
        KeywordAttachmentCell.Callbacks{
    public Room room;

    ////// Views Bindings//////
    @Bind(R.id.emoji_opener_btn)
    TextView emoji_opener_btn;

    @Bind(R.id.emoji_window_holder)
    FrameLayout emoji_window_holder;

    @Bind(R.id.edit_filed)
    EmojiconEditText edit_filed;

    @Bind(R.id.send_msg)
    TextView send_msg;

    @Bind(R.id.bottom_container)
    View bottom_container;

    @Bind(R.id.attach)
    View attach;

    @Bind(R.id.recycler_view)
    RecyclerView recycler_view;

    @Bind(R.id.avatar)
    ImageView avatar;

    //constants
    final int ATTACH_CAMERA_IMAGE = 1001;
    final int ATTACH_CAMERA_VIDEO = 1002;
    final int ATTACH_FILE = 1003;

    private ImageFileSelector mImageFileSelector;
    ViewGroup.LayoutParams vv;
    View view;

    List<Message> messages;
    MsgsListCell messagesCell;
    MsgsListCell.ChatEntaryAdaptor messagesAdaptor;

    KeywordAttachmentCell attachmentView;
    ChatRoomPresenter that;

    IntentHelper intentHelper;
    Uri file_uri;
    EmojiKeyboard3 emojiKeyboard;

    @Override
    public View buildView() {
        view = AppUtil.inflate(R.layout.presenter_chat_room);
        ButterKnife.bind(this,view);

        send_msg.setOnClickListener((v)->addNewMsg());

        edit_filed.setOnClickListener((v)->{
            AppUtil.log("Keybord");
            showMeas();
        });
        edit_filed.requestFocus();

        Nav.hideFooter();

        messages = MessageModel.getRoomMessages(room.RoomKey,0);
        messagesCell = new MsgsListCell();
        messagesAdaptor =messagesCell.adaptor;

        messagesAdaptor.setMsgs(messages);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(fragment.getActivity());

        mLayoutManager.setSmoothScrollbarEnabled(true);
        mLayoutManager.setReverseLayout(true);

        recycler_view.setAdapter(messagesAdaptor);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setHasFixedSize(true);

        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nav.pop();
//                Nav.showFooter();*/
                onBack();
            }
        });

        TextView roomTitle = (TextView) view.findViewById(R.id.room_name);
        roomTitle.setText(room.getRoomName());
//        EventBus.getDefault().register(this);
        App.getBus().register(this);

        emojiKeyboard = new EmojiKeyboard3(edit_filed,emoji_opener_btn, AppUtil.global_window);

        that = this;
        attach.setOnClickListener((v)->{ showAttachmentWindow();});
        //todo later fix this for G
//        AppUtil.listanAndSaveKewordSize(view);

        setUpInputOnTextTextCjanged();

        Uri imageUri = Helper.PathToUserAvatarUri(room.getRoomAvatarUrl());
//            Helper.SetAvatar(vh.avatar, room.getRoomAvatarUrl());
//        avatar.setImageURI(imageUri);
        Picasso.with(AppUtil.getContext())
                .load(imageUri)
                .into(avatar);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.getBus().unregister(this);
        AppUtil.unRegisterKeywoardlistaner(view);

        if(emojiKeyboard != null) emojiKeyboard.destroy();
    }


    @Override
    public void onResume() {
        super.onResume();
        AppUtil.log("after?? Chatroom onResume()");
//        showMeas();
    }
    public void onFocus() {
        super.onFocus();
        AppUtil.log("after?? Chatroom onFocus()");
        MessageModel.sendToServerAllMsgsSeenbyPeerCmdForRoom(room);
        RoomModel.onRoomOpenedInBackground(room);
    }

    @Override
    public void onBack() {
        super.onBack();
        Nav.showFooter();
//        emojiKeyboard.unregisterOnBackListener();
        if(emojiKeyboard != null){
            emojiKeyboard.destroy();
        }

    }

    private void endThis() {
        Nav.pop();
    }

    void setUpInputOnTextTextCjanged(){
        edit_filed.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()>0){
                    attach.setVisibility(View.GONE);
                    send_msg.setVisibility(View.VISIBLE);
                }else {
                    attach.setVisibility(View.VISIBLE);
                    send_msg.setVisibility(View.GONE);
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
        msg.Text = edit_filed.getText().toString();
        msg.insertInBackground();

        edit_filed.setText("");
        MessageModel.syncToServer(msg);

        onHereAddedNewMsgEvent(msg);
    }

    void onHereAddedNewMsgEvent(Message msg){
        messages.add(0,msg);
        messagesAdaptor.notifyItemInserted(0);
        recycler_view.scrollBy(0,1000);
    }

    void showMeas(){
        return;
    }

    public void showAttachmentWindow(){
        attachmentView = new KeywordAttachmentCell(this,bottom_container);
    }

    ////////////////////////////////////
    //////////// Events ////////////////

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Message msg){
        logIt("event new msg: " + msg.toString());
        try {
            messagesAdaptor.msgs.add(0,msg);
            messagesAdaptor.notifyDataSetChanged();

        }catch (Exception e){
            e.printStackTrace();
        }
        //todo: if app in not focuesd dont to this, instead in refouce do it
        MessageModel.sendToServerMsgsSeenByPeerCmd(msg);
    }

    //    @Subscribe
    public void onEvent(MessageSyncMeta meta){
        logIt("event meta: XXXXX " + meta.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgGeneralChangeChangeEvent meta){
        logIt("event meta: MsgGeneralChangeChangeEvent " + meta.toString());
        _updateMsgForMeta(meta);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgsSyncMetaReceivedToServer meta){
        logIt("event meta: REcived " + meta.toString());
        _updateMsgForMeta(meta);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgsSyncMetaReceivedToPeer meta){
        logIt("event meta: " + meta.toString());
        _updateMsgForMeta(meta);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgsSyncMetaDeletedFromServer meta){
        logIt("event meta: " + meta.toString());
        _updateMsgForMeta(meta);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MsgsSyncMetaSeenByPeer meta){
        logIt("event meta: " + meta.toString());
//        _updateMsgForMeta(meta);
        if(meta == null || meta.ExtraData == null) return;

        Message msg;
        if(meta.RoomKey.equals(room.RoomKey)){
            int sizeMsgs = messagesAdaptor.msgs.size();
            int sizeMetas = meta.ExtraData.size();
            String metaMsgsKey ;
            for(int j=0; j<sizeMetas ;j++){
                metaMsgsKey = meta.ExtraData.get(j);
                for(int i=0; i< sizeMsgs; i++){
                    msg = messagesAdaptor.msgs.get(i);
                    if(msg.MessageKey.equals(metaMsgsKey)){
                        Message msg2 = MessageModel.getMessageByKey(metaMsgsKey);
                        messagesAdaptor.msgs.remove(i);
                        messagesAdaptor.msgs.add(i,msg2);
                        messagesAdaptor.notifyItemChanged(i);
//                        messagesAdaptor.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    //udate for all metas -- fist msg must be saved
    void _updateMsgForMeta(MessageSyncMeta meta){
        Message msg;
        if(meta.RoomKey.equals(room.RoomKey)){
            int size = messagesAdaptor.msgs.size();
            for(int i=0; i< size; i++){
                msg = messagesAdaptor.msgs.get(i);
                if(msg.MessageKey.equals(meta.MessageKey)){
                    Message msg2 = MessageModel.getMessageByKey(meta.MessageKey);
                    messagesAdaptor.msgs.remove(i);
                    messagesAdaptor.msgs.add(i,msg2);
                    messagesAdaptor.notifyDataSetChanged();
                }
            }
        }
    }

    void _updateMsgForMetaWithExtraDataList(MessageSyncMeta meta) {

    }

    /////////////// End Events /////////////////////
    ////////////////////////////////////////////////
//        protected void logIt(String str) {
//        Log.d(" "+ this.getClass().getSimpleName() ," "+ str);
//    }


    //keyborad listener
    @Override
    public void onCameraPhotoClick() {
        intentHelper = new IntentHelper();
//        attachWindow.dismiss();
        attachmentView.dismiss();
        file_uri =  intentHelper.captureImage(getFragment().getActivity(), ATTACH_CAMERA_IMAGE,"back");

    ///play
//        Intent intent = new Intent(getContext(),GalleryChooserActivity.class);
//        getActivity().startActivityForResult(intent,333);


    }

    ArrayList<String> selectedPhotos = new ArrayList<>();
    @Override
    public void onGalleryClick() {
        attachmentView.dismiss();
        GalleryChooserPresenter gallery =new GalleryChooserPresenter();
        //FIxme: gallery.chatEntryPresenter to interface
        gallery.chatEntryPresenter = this;
        Nav.push(gallery);
    }

    @Override
    public void onVideoClick() {
        attachmentView.dismiss();
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
    public void onRecentImagesClick(List<String> imagesPath){
        attachmentView.dismiss();
        for(String image : imagesPath){
            _sendMsgImage(image,false);
        }
    };


    public void onGalleryChoserVideoClicked(List<String> videoPaths){
        attachmentView.dismiss();
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
        File fileOrginal = new File(path);

        String $resizedPath = AppFiles.PHOTO_SENT_DIR_PATH+"IMG_"+ FormaterUtil.getFullyYearToSecondsSolarName()+"$.jpg";
        String resizedPath ;//= $resizedPath.replace("$","");
//        resizedPath = FileUtil.createNextFile($resizedPath).getAbsolutePath();
        resizedPath = FileUtil.createNextName($resizedPath);
        ImageUtil.resizeImage(path,resizedPath,1024);
        File resizedFile = new File(resizedPath);

        if(!resizedFile.exists()){
            Toast.makeText(getContext(),"فایل موجود نیست",Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg =  MessageModel.newTextMsgForRoom(room);
        msg.MediaStatus = Constants.Msg_Media_To_Push;
        msg.MessageTypeId = Constants.MESSAGE_IMAGE;
        MessageModel.setPhotoParams(msg,resizedPath);
        msg.save();

        Http.Req req = new Http.Req();
        req._finalUrl = AppUtil.toUrl("http://localhost:5000/MsgUpload");
        req.absPath = "http://localhost:5000/MsgUpload";
        req.file = resizedFile;
//        req.urlParams.put("message",JsonUtil.toJson(msg));
        req.form.put("message",JsonUtil.toJson(msg));

        AndroidUtil.runInBackground(()->{
            Http.Result res = Http.uploadFile(req);
            if(res.ok){
                msg.MediaStatus = (Constants.Msg_Media_Uploaded);
                msg.save();
                if(deleteOrginal == true){
                    fileOrginal.delete();

                }
            }
//            res.response.body().byteStream().
        });
        onHereAddedNewMsgEvent(msg);
//        intentHelper.previewCapturedImage(imageView);

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


        //no need
//        try {
//            FileUtils.moveFile(tempFile,resizedFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if(!resizedFile.exists()){
            Toast.makeText(getContext(),"فایل موجود نیست",Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg =  MessageModel.newTextMsgForRoom(room);
        msg.MediaStatus = (Constants.Msg_Media_To_Push);
        msg.MessageTypeId = (Constants.MESSAGE_VIDEO);
        MessageModel.setVideoParams(msg,thumbPath,resizedPath);
        msg.save();

        Http.Req req = new Http.Req();
        req._finalUrl = AppUtil.toUrl("http://localhost:5000/MsgUpload");
        req.absPath = "http://localhost:5000/MsgUpload";
        req.file = resizedFile;
//        req.urlParams.put("message",JsonUtil.toJson(msg));
        req.form.put("message",JsonUtil.toJson(msg));

        AndroidUtil.runInBackground(()->{
            Http.Result res = Http.uploadFile(req);
            if(res.ok){
                msg.MediaStatus = (Constants.Msg_Media_Uploaded);
                msg.save();
//                tempFile.delete();
            }
//            res.response.body().byteStream().
        });
        onHereAddedNewMsgEvent(msg);
//        intentHelper.previewCapturedImage(imageView);
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




