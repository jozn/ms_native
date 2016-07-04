package com.mardomsara.social.ui.presenter.chats;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ipaulpro.afilechooser.FileChooserActivity;
import com.ipaulpro.afilechooser.utils.FileChooserFileUtils;
import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconsFragment;
import com.mardomsara.social.AppAplication;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.IntentHelper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.events.MessageSyncMeta;
import com.mardomsara.social.models.events.MsgGeneralChangeChangeEvent;
import com.mardomsara.social.models.events.MsgsSyncMetaDeletedFromServer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToPeer;
import com.mardomsara.social.models.events.MsgsSyncMetaReceivedToServer;
import com.mardomsara.social.models.events.MsgsSyncMetaSeenByPeer;
import com.mardomsara.social.tables.MessagesModel;
import com.mardomsara.social.tables.MessagesTable;
import com.mardomsara.social.tables.RoomsListTable;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.adaptors.ChatEnteryAdaptor;
import com.mardomsara.social.ui.views.EmojiKeybord;
import com.mardomsara.social.ui.views.EmojiKeybord2;
import com.mardomsara.social.ui.views.chat.KeywordAttachmentView;
import com.orhanobut.hawk.Hawk;
import com.squareup.leakcanary.RefWatcher;
import com.sw926.imagefileselector.ImageFileSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import org.msgpack.core.MessagePack;

/**
 * Created by Hamid on 5/4/2016.
 */
public class ChatEntryPresenter extends BasePresenter implements
        EmojiconsFragment.OnEmojiconBackspaceClickedListener,
        KeywordAttachmentView.Callbacks{
    public RoomsListTable room;
    ImageButton emoji_opener_btn;
    FrameLayout emoji_window_holder;
//    EmojiconEditText edit_filed;
    EmojiconEditText edit_filed;
    Button send_msg;
    View bottom_container;
    View attach;
    ImageView imageView;

    //constants
    final int ATTACH_CAMERA_IMAGE = 1001;
    final int ATTACH_CAMERA_VIDEO = 1002;
    final int ATTACH_FILE = 1003;

    private ImageFileSelector mImageFileSelector;


    int hw1,hw2 =0;
    int kybordSize = Hawk.get(Config.KEYBOARD_HEIGHT, Config.KEYBOARD_HEIGHT_DEFAULT);
    ///debug
    ViewGroup.LayoutParams vv;
    View view;

    //recylecer views
    List<MessagesTable> messages;
    ChatEnteryAdaptor messagesAdaptor;
    RecyclerView recylerView;


    PopupWindow attachWindow;
    KeywordAttachmentView attachmentView;
    ChatEntryPresenter that;

    IntentHelper intentHelper;
    Uri file_uri;
    EmojiKeybord emojiKeybord;

    @Override
    public View buildView() {
        view = AppUtil.inflate(R.layout.fragment_chat_entery_page);
        emoji_opener_btn = (ImageButton)view.findViewById(R.id.emoji_opener_btn);
        emoji_window_holder = (FrameLayout) view.findViewById(R.id.emoji_window_holder);
        edit_filed = (EmojiconEditText) view.findViewById(R.id.edit_filed);
//        edit_filed = (EditText) view.findViewById(R.id.edit_filed);
        send_msg = (Button) view.findViewById(R.id.send_msg);
        bottom_container =  view.findViewById(R.id.bottom_container);
        attach =  view.findViewById(R.id.attach);
        imageView =  (ImageView)view.findViewById(R.id.imageView);

        send_msg.setOnClickListener((v)->addNewMsg());

        edit_filed.setOnClickListener((v)->{
            AppUtil.log("Keybord");
            showMeas();
//            return false;
        });
        edit_filed.requestFocus();
        Nav.hideFooter();

        recylerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        messages = MessagesModel.getRoomMessage(room.getRoomKey(),0);
        messagesAdaptor =new ChatEnteryAdaptor();

        messagesAdaptor.setMsgs(messages);
//        EventBus.getDefault().register(messagesAdaptor);
//        AppUtil.log(messages.get(messages.size()-1));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(fragment.getActivity());

//        mLayoutManager.setSmoothScrollbarEnabled(true);
        mLayoutManager.setReverseLayout(true);
//        mLayoutManager

//        mLayoutManager.
        recylerView.setAdapter(messagesAdaptor);
        recylerView.setLayoutManager(mLayoutManager);
        recylerView.setHasFixedSize(true);
//        recylerView


//        view.findViewById(R.id.back).setOnClickListener(v -> Nav.pop());
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
        EventBus.getDefault().register(this);

/*

        emojiKeybord = new EmojiKeybord(emoji_window_holder, getFragment().getChildFragmentManager());
        emojiKeybord.setEditInput(edit_filed);
        emojiKeybord.setEmojiOpenerBtn(emoji_opener_btn);
        emojiKeybord.build();

*/


//        EmojiKeybord2 emojiKeybord = new EmojiKeybord2(emoji_window_holder, getFragment().getChildFragmentManager());
//        EmojiKeybord2 emojiKeybord = new EmojiKeybord2(emoji_opener_btn, edit_filed,getFragment().getChildFragmentManager());
        EmojiKeybord2 emojiKeybord = new EmojiKeybord2(emoji_opener_btn, edit_filed,getFragment().getFragmentManager());
//        emojiKeybord.setEditInput(edit_filed);
//        emojiKeybord.setEmojiOpenerBtn(emoji_opener_btn);
        emojiKeybord.emoji_window_holder = bottom_container;
        emojiKeybord.build();



        that = this;
        attach.setOnClickListener((v)->{ showAttachmentWindow();});
        //todo later fix this for G
//        AppUtil.listanAndSaveKewordSize(view);
        return view;
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(MessagesTable event){
//        Toast.makeText(App.context,event.getText(),Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        AppUtil.unRegisterKeywoardlistaner(view);
//        fragment.getActivity().getSupportFragmentManager()
//                .beginTransaction();
        RefWatcher refWatcher = AppAplication.getRefWatcher(getActivity());
        if(null != refWatcher)  refWatcher.watch(this, " ChatChat");

    }

    @Override
    public void onEmojiconBackspaceClicked(View v) {
//        Toast.makeText(fragment.getActivity(),"Asdas",Toast.LENGTH_LONG).show();
        showMeas();
        edit_filed.setText(" \uD83D\uDE3B \uD83D\uDE3C \uD83D\uDE3D \uD83D\uDE40 \uD83D\uDE3F \uD83D\uDE3E \uD83D\uDE48 \uD83D\uDE49 \uD83D\uDE4A \uD83D\uDC66 \uD83D\uDC66");
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
        MessagesModel.sendToServerAllMsgsSeenbyPeerCmdForRoom(room);
        RoomsListTable.onRoomOpened(room);
//        showMeas();

    }

    @Override
    public void onBack() {
        super.onBack();
        Nav.showFooter();
//        emojiKeybord.unregisterOnBackListener();

    }

    private void endThis() {
        Nav.pop();
    }
    ////play

    void addNewMsg(){
        MessagesTable msg =  MessagesModel.NewTextMsgForRoom(room);
        msg.setMessageTypeId(Constants.MESSAGE_TEXT);
        msg.setText(edit_filed.getText().toString());
        msg.insert();

        edit_filed.setText("");
        MessagesModel.syncToServer(msg);

        onHereAddedNewMsgEvent(msg);
    }

    void onHereAddedNewMsgEvent(MessagesTable msg){
        messages.add(0,msg);
        messagesAdaptor.notifyItemInserted(0);
        recylerView.scrollBy(0,1000);
    }

    void showMeas(){
        return;
//        View v = view.getRootView();
//        Toast.makeText(App.context,"w: "+v.getMeasuredWidth() + " h: "+ v.getMeasuredHeight()+
//                getFragment().isAdded(),Toast.LENGTH_LONG).show();
    }

   public void alert(View v){
        Toast.makeText(getFragment().getContext(),"video",Toast.LENGTH_SHORT).show();
//       new IntentHelper().captureImage(getFragment().getActivity(),15,"back");
    }

    public void showAttachmentWindow(){
        attachmentView = new KeywordAttachmentView(this,bottom_container);

    }

    //////////// Events ////////////////

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessagesTable msg){
        logIt("event new msg: " + msg.toString());
        try {
            messagesAdaptor.msgs.add(0,msg);
            messagesAdaptor.notifyDataSetChanged();

        }catch (Exception e){
            e.printStackTrace();
        }
        //todo: if app in not focuesd dont to this, instead in refouce do it
        MessagesModel.sendToServerMsgsSeenByPeerCmd(msg);
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

        MessagesTable msg;
        if(meta.RoomKey.equals(room.getRoomKey())){
            int sizeMsgs = messagesAdaptor.msgs.size();
            int sizeMetas = meta.ExtraData.size();
            String metaMsgsKey ;
            for(int j=0; j<sizeMetas ;j++){
                metaMsgsKey = meta.ExtraData.get(j);
                for(int i=0; i< sizeMsgs; i++){
                    msg = messagesAdaptor.msgs.get(i);
                    if(msg.getMessageKey().equals(metaMsgsKey)){
                        MessagesTable msg2 = MessagesModel.getMessageByKey(metaMsgsKey);
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
        MessagesTable msg;
        if(meta.RoomKey.equals(room.getRoomKey())){
            int size = messagesAdaptor.msgs.size();
            for(int i=0; i< size; i++){
                msg = messagesAdaptor.msgs.get(i);
                if(msg.getMessageKey().equals(meta.MessageKey)){
                    MessagesTable msg2 = MessagesModel.getMessageByKey(meta.MessageKey);
                    messagesAdaptor.msgs.remove(i);
                    messagesAdaptor.msgs.add(i,msg2);
                    messagesAdaptor.notifyDataSetChanged();
                }
            }
        }
    }

    void _updateMsgForMetaWithExtraDataList(MessageSyncMeta meta) {

    }

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
        MessagesTable msg =  MessagesModel.NewTextMsgForRoom(room);
        msg.setMediaStatus(Constants.Msg_Media_To_Push);
        msg.setMessageTypeId(Constants.MESSAGE_IMAGE);
        MessagesModel.setPhotoParams(msg,resizedPath);
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
                msg.setMediaStatus(Constants.Msg_Media_Uploaded);
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
        MessagesTable msg =  MessagesModel.NewTextMsgForRoom(room);
        msg.setMediaStatus(Constants.Msg_Media_To_Push);
        msg.setMessageTypeId(Constants.MESSAGE_VIDEO);
        MessagesModel.setVideoParams(msg,thumbPath,resizedPath);
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
                msg.setMediaStatus(Constants.Msg_Media_Uploaded);
                msg.save();
//                tempFile.delete();
            }
//            res.response.body().byteStream().
        });
        onHereAddedNewMsgEvent(msg);
//        intentHelper.previewCapturedImage(imageView);
    }

}
//
//mImageFileSelector = new ImageFileSelector(getFragment().getContext());
//        mImageFileSelector.setCallback(new ImageFileSelector.Callback() {
//@Override
//public void onSuccess(final String file_uri) {
//        logIt("onActivityResult: result " + file_uri);
//        if (!TextUtils.isEmpty(file_uri)) {
//        //loadImage(file_uri);
//        //mCurrentSelectFile = new File(file_uri);
//        //mBtnCrop.setVisibility(View.VISIBLE);
//        Toast.makeText(getFragment().getContext(), "select image file_uri SUUCESS", Toast.LENGTH_LONG).show();
//        } else {
//        Toast.makeText(getFragment().getContext(), "select image file_uri error", Toast.LENGTH_LONG).show();
//        }
//        }
//
//@Override
//public void onError() {
//        Toast.makeText(getFragment().getContext(), "select image file_uri error", Toast.LENGTH_LONG).show();
//        }
//        });
//        mImageFileSelector.selectImage(getFragment());
//        alert(v);

//    void addNewMsg__DEP(){
//        MessagesTable msg = new MessagesTable();
//        msg.setRoomKey(room.getRoomKey());
//        msg.setDeliveryStatus(0);
//        msg.setIsByMe(1);
//        msg.setRoomTypeId(room.getRoomTypeId());
//        msg.setCreatedMs(AppUtil.getTimeMs());
//        msg.setMessageTypeId(10);
//        msg.setUserId(6);
//        msg.setMessageKey(LangUtil.getRandomString(20));
//        msg.setText(edit_filed.getText().toString());
////        msg.save();
//        msg.insert();
//
//        edit_filed.setText("");
//
//        Command cmd = new Command();
//        cmd.Name = Constants.MsgsAddNew;
//        cmd.Data = JsonUtil.toJson(msg);
//
//        WSService.sendCommand(cmd);
//        onHereAddedNewMsgEvent(msg);
//    }


//        if(f.exists()){
//            logIt("onActivityResult: File f exist");
//            imageView.setImageURI(file_uri);
//        }else if(data != null){
//            logIt("onActivityResult: chat data "+data.getData());
//            imageView.setImageURI(data.getData());
//        }
//        file_uri=null;
//        mImageFileSelector.onActivityResult(requestCode, resultCode, data);
//        mImageCropper.onActivityResult(requestCode, resultCode, data);


//    public void onActivityResult__OLD(int requestCode, int resultCode, Intent data) {
/////        super.onActivityResult(requestCode, resultCode, data);
//        logIt("onActivityResult: chat "+requestCode+ resultCode + " " +data);
////        Uri u =intentHelper.getOutputMediaFileUri(15);
////        intentHelper.
////        data.getExtras();
//        logIt("file_uri: "+file_uri);
////        File f = new File(file_uri.getPath());
//
//        MessagesTable msg = new MessagesTable();
//        msg.MessageKey = LangUtil.getRandomString(20);
//        Http.Req req = new Http.Req();
//        req._finalUrl = AppUtil.toUrl("http://localhost:5000/MsgUpload");
//        req.absPath = "http://localhost:5000/MsgUpload";
//        req.file_uri = new File(file_uri.getPath());
//        req.urlParams.put("message",JsonUtil.toJson(msg));
//        AndroidUtil.runInBackground(()->{
//            Http.Result res = Http.uploadFile(req);
////            res.response.body().byteStream().
//        });
//        intentHelper.previewCapturedImage(imageView);
//        if(data != null){
////            Uri f = data.getExtras().get
//        }
//
//    }


//    public void showAttachmentWindow_dep(){
//        //            View popupView = AppUtil.inflate(R.layout.activity_test_web_socket);
//
//        KeywoardAttachmentBinding binding = DataBindingUtil.bind(AppUtil.inflate(R.layout.keywoard_attachment___dep));
//        binding.setHandler(that);
//
//
//        View popupView = binding.getRoot();//AppUtil.inflate(R.layout.keywoard_attachment___dep);
//        attachWindow = new PopupWindow(
//                popupView,
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);//kybordSize);
//
////            binding.setHandler();
//        View btnDismiss = popupView.findViewById(R.id.attachment_top);
//        View main = popupView.findViewById(R.id.attachment_main);
//        main.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,kybordSize));
//        btnDismiss.setOnClickListener(new Button.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                attachWindow.dismiss();
//            }});
////                attachWindow.showAsDropDown(btnOpenPopup, 50, -30);
////        attachWindow.setHeight(540);
//        attachWindow.showAtLocation(bottom_container, Gravity.END,0,15000);
//    }

//    public void onCameraPhotoClick(View v) {
////        intentHelper = new IntentHelper();
////        attachWindow.dismiss();
////        file_uri =  intentHelper.captureImage(getFragment().getActivity(), ATTACH_CAMERA_IMAGE,"back");
//    }
//
//    public void onGalleryClick(View v) {
////       (intentHelper =new IntentHelper()).pickImage(getFragment().getActivity(),11);
////       attachWindow.dismiss();
//    }
//
//    public void onVideoClick(View v) {
////        alert(v);
////        intentHelper = new IntentHelper();
////        intentHelper.recordVideo(getFragment().getActivity(),15,"back");
//
//    }

//        Intent intent = new Intent(getContext(),GalleryAlbumActivity.class);
//        getActivity().startActivityForResult(intent,777);
//        PhotoAdapter photoAdapter = new PhotoAdapter(getFragment().getContext(), selectedPhotos);
//        Intent intent = new Intent(getFragment().getContext() ,PhotoPagerActivity.class);
//        PhotoPickerIntent.setPhotoCount(intent, 9);
//        PhotoPickerIntent.setColumn(intent, 4);
//
//        getFragment().getActivity().startActivityForResult(intent, 111);




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




