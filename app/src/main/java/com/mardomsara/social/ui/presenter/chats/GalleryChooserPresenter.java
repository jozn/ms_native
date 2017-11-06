package com.mardomsara.social.ui.presenter.chats;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.MediaFacade.media.MediaCursor;
import com.mardomsara.MediaFacade.media.image.ImageCursor;
import com.mardomsara.MediaFacade.media.image.ImageProviderHelper;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.CursorRecyclerViewAdapter;
import com.mardomsara.social.ui.presenter.chat_realm.chat_room.ChatRoomEntryPresenter;
import com.mardomsara.social.ui.ui.AppTabPagerAdaptor;
import com.mardomsara.social.ui.views.FontCache;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

/**
 * Created by Hamid on 6/17/2016.
 */
public class GalleryChooserPresenter extends BasePresenter {
    //Must permision be granted
    Map<Long, String> thumbs_paths_map;//= ImageProviderHelper.loadAllTumbsPaths();;
    Map<Long, String> thumbs_video_paths_map;//= ImageProviderHelper.loadAllMoviesTumbsPaths();;

    Map<String, Integer> folder_count_cache = new HashMap<>();;
    Map<String, Integer> folder_count_video_cache = new HashMap<>();;

//    public ChatRoomPresenter_OLD chatEntryPresenter;
    public ChatRoomEntryPresenter chatEntryPresenter;

    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;

    View v;
    @Override
    public View buildView() {
        v = AppUtil.inflate(R.layout.presenter_gallery_chooser);
        askPermissions();

        return v;
    }

    void afterPermissionsGranted(){
        thumbs_paths_map= ImageProviderHelper.loadAllTumbsPaths();;
        thumbs_video_paths_map= ImageProviderHelper.loadAllMoviesTumbsPaths();;

        TabLayout tabs = (TabLayout) v.findViewById(R.id.tab_layout);
        ButterKnife.bind(this, v);

        AppTabPagerAdaptor tabsPager = new AppTabPagerAdaptor();
		tabsPager.addTab( new AppTabPagerAdaptor.Tab("ویدیو", new MediaExplorer(MediaType.VIDEO)) );
		tabsPager.addTab( new AppTabPagerAdaptor.Tab("عکس", new MediaExplorer(MediaType.IMAGE)) );

        view_pager.setAdapter(tabsPager);
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.setTabMode(TabLayout.MODE_FIXED);
        view_pager.setCurrentItem(1);

		tabsPager.setTabLayout(tab_layout);
    }

    private void askPermissions() {
        PermissionCallback callback = new PermissionCallback(){
            @Override
            public void permissionGranted() {
                AppUtil.log("permissionGranted() callback");
                afterPermissionsGranted();
            }

            @Override
            public void permissionRefused() {
                AppUtil.log("permissionRefused() callback");
            }
        };

        Nammu.askForPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE,callback);
    }

    Integer _getFoldersCountImages(String buketId){
        Integer cnt = folder_count_cache.get(buketId);
        if(cnt == null){
            ImageCursor c  = ImageProviderHelper.getImagesForBucket(buketId);
            if(c!= null){
                cnt = c.getCount();
            }
            folder_count_cache.put(buketId,cnt);
            ImageProviderHelper.tryClose(c);
        }
        if(cnt == null) cnt = 0;
        return cnt;
    }

    Integer _getFoldersCountVideos(String buketId){
        Integer cnt = folder_count_video_cache.get(buketId);
        if(cnt == null){
            MediaCursor c  = ImageProviderHelper.getVideosForBucket(buketId);
            if(c!= null){
                cnt = c.getCount();
            }
            folder_count_video_cache.put(buketId,cnt);
            ImageProviderHelper.tryClose(c);
        }
        if(cnt == null) cnt = 0;
        return cnt;
    }

    /////////////////////////////////////////////////////////////////////////
    class MediaExplorer extends BasePresenter {
        @BindView(R.id.recycler_view) RecyclerView recycler_view;
        Map<Long,Bitmap> _cache= new HashMap();
//        Map<Integer, String> thumbs_paths_map= null;
        MediaType type;
        public MediaExplorer(MediaType type) {
            this.type = type;
        }

        @Override
        public View buildView() {
            View v = LayoutInflater.from(context).inflate(R.layout.gallery_chooser_folders_recyicler_view, null);
            ButterKnife.bind(this,v);
            FolderAdaptor folderAdaptor;
            if(type == MediaType.IMAGE){
                folderAdaptor = new FolderAdaptor(getContext(), ImageProviderHelper.getFolders());
            }else {
                folderAdaptor = new FolderAdaptor(getContext(), ImageProviderHelper.getVideoFolders());
            }

            recycler_view.setAdapter(folderAdaptor);
//            recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
            recycler_view.setLayoutManager(new GridLayoutManager(getContext(),2));
//            thumbs_paths_map = ImageProviderHelper.loadAllTumbsPaths();
            Log.d("Thumbs: ",""+thumbs_paths_map.size());
            Log.d("Thumbs: ",""+thumbs_paths_map.get(100));
            return v;
        }

        class FolderAdaptor extends CursorRecyclerViewAdapter<FolderAdaptor.ViewHolder> {
            MediaCursor _cursor;
            public FolderAdaptor(Context context, MediaCursor cursor) {
                super(context, cursor);
                _cursor =cursor;
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor, int position) {
                viewHolder.bind((MediaCursor) cursor);
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(AppUtil.inflate(R.layout.gallery_chooser_presenter_folder_entery));
            }

            class ViewHolder extends RecyclerView.ViewHolder{
                View v;
                @BindView(R.id.image_view) SimpleDraweeView image_view;
                @BindView(R.id.folder_name) TextView folder_name;
                @BindView(R.id.folder_count) TextView folder_count;
                @BindView(R.id.icon_video) TextView icon_video;
                public ViewHolder(View itemView) {

                    super(itemView);
                    v= itemView;
                    ButterKnife.bind(this,v);
                }
                void bind(MediaCursor cursor) {
//                    ImageCursor folder = ImageProviderHelper.getImagesForBucket(cursor.bucketId());
                    Log.d("Thumbs: cursor.id()",""+cursor.id());
                    String path = "";
                    int folderCounts = 0;
                    path = thumbs_paths_map.get(cursor.id());
                    if(path != null && !path.equals("")){
                        Log.d("Thumbs: 22 ",""+path);
                        File f = new File(path);
                        Log.d("Thumbs: 22 "," exis "+f.exists());
                        image_view.setImageURI(Uri.fromFile(f));
                    }

                    if(type == MediaType.IMAGE){
                        icon_video.setVisibility(View.INVISIBLE);
                        folderCounts = _getFoldersCountImages(cursor.bucketId());
                    }

                    if (type == MediaType.VIDEO) {
                        icon_video.setVisibility(View.VISIBLE);
                        path= thumbs_video_paths_map.get(cursor.id());
                        if(path != null && !path.equals("")){
                            File f = new File(path);
                            image_view.setImageURI(Uri.fromFile(f));
                        }
                        folderCounts = _getFoldersCountVideos(cursor.bucketId());
                    }

                    folder_name.setText(cursor.bucketName());
                    folder_count.setText("" + folderCounts);
                    String bucketId = cursor.bucketId();
//                    ImageProviderHelper.tryClose(folder);
                    v.setOnClickListener((v)->{
                        Nav.push(new MediaBrowserFolderInsidePresenter(type, bucketId));
                    });
                }

            }
        }
//        MediaStore.Images.Thumbnails
    }

    class MediaBrowserFolderInsidePresenter extends BasePresenter {
        MediaType type;
        @BindView(R.id.recycler_view) RecyclerView recycler_view;
        @BindView(R.id.left_side) View left_side;
        @BindView(R.id.text_icon) TextView text_icon;
        @BindView(R.id.send_btn) TextView send_btn;
        @BindView(R.id.back_btn) TextView back_btn;
        @BindView(R.id.title) TextView title;

        List<String> selectedReal = new ArrayList<>();
        List<String> selectedThumbs = new ArrayList<>();
        int maxSelection = 10;


        Map<Long,Bitmap> _cache= new HashMap();
        String buketId;

        public MediaBrowserFolderInsidePresenter(MediaType type, String buketId) {
            this.type = type;
            this.buketId = buketId;
        }

        @Override
        public View buildView() {
            View v = AppUtil.inflate(R.layout.gallery_chooser_media_list, null);
            ButterKnife.bind(this, v);
//            send_btn.setTypeface(FontCache.getIonic());
            back_btn.setTypeface(FontCache.getIonic());
            send_btn.setTypeface(FontCache.getIran());
            title.setTypeface(FontCache.getIran());
            FolderAdaptor folderAdaptor;
            if (type == MediaType.IMAGE) {
                folderAdaptor = new FolderAdaptor(getContext(), ImageProviderHelper.getImagesForBucket(buketId));
            } else {
                folderAdaptor = new FolderAdaptor(getContext(), ImageProviderHelper.getVideosForBucket(buketId));
            }

            recycler_view.setAdapter(folderAdaptor);
//            recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
            recycler_view.setLayoutManager(new GridLayoutManager(getContext(), 2));
            _updateSendText();
            return v;
        }

        @OnClick(R.id.back_btn)
        void goBack(){
            Nav.pop();
        }

        @OnClick(R.id.left_side)
        void sendResult(){
            Nav.pop(2);
            if(selectedReal.size()>0){
                if(type==MediaType.IMAGE){
                    AndroidUtil.runInUi(()->{//async
                        chatEntryPresenter.onRecentImagesSendClicked(selectedReal);
                    });
                }else {//Video
                    AndroidUtil.runInUi(()->{//async
                        chatEntryPresenter.onGalleryChooserVideoClicked(selectedReal);
                    });
                }
            }
        }

        void _updateSendText(){
            int size = selectedReal.size();
            if(size > 0 ){
                left_side.setVisibility(View.VISIBLE);
                send_btn.setText("بفرس("+size +")");

            }else {
                left_side.setVisibility(View.INVISIBLE);
            }
        }

        ////////////////////////

        class FolderAdaptor extends CursorRecyclerViewAdapter<FolderAdaptor.ViewHolder> {
            MediaCursor _cursor;

            public FolderAdaptor(Context context, MediaCursor cursor) {
                super(context, cursor);
                _cursor = cursor;
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor, int position) {
                viewHolder.bindThumb((MediaCursor) cursor);
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(AppUtil.inflate(R.layout.gallery_chooser_presenter_image_entery));
            }

            class ViewHolder extends RecyclerView.ViewHolder {
                View v;
                @BindView(R.id.image) SimpleDraweeView image_view;
                @BindView(R.id.text_holder) View text_holder;
                String thumbsSignatuer;// for images: thumb_path for video: path+id
                MediaCursor _curser;
                long mediaId;

                View.OnClickListener onSelect = (v)->{
                    if(selectedThumbs.contains(thumbsSignatuer)){
                        selectedThumbs.remove(thumbsSignatuer);
                        if(type==MediaType.IMAGE){
                            selectedReal.remove(ImageProviderHelper.getImagePathByImaheId(mediaId));
                        }else {
                            selectedReal.remove(ImageProviderHelper.getVideoPathByImaheId(mediaId));
                        }
                    }else {
                        if(selectedThumbs.size() < maxSelection){
                            selectedThumbs.add(thumbsSignatuer);
                            if(type==MediaType.IMAGE){
                                selectedReal.add(ImageProviderHelper.getImagePathByImaheId(mediaId));
                            }else {
                                selectedReal.add(ImageProviderHelper.getVideoPathByImaheId(mediaId));
                            }
                        }else {
                            //TODO: Toast user that max is 10 for example
                        }
                    }
                    _updateSendText();
                    notifyDataSetChanged();
                };
                
                public ViewHolder(View itemView) {
                    super(itemView);
                    v = itemView;
                    ButterKnife.bind(this, v);
                    v.setOnClickListener(onSelect);
                }
                void bindThumb(MediaCursor cursor) {
                    String path;
                    _curser = cursor;
                    mediaId = cursor.id();
                    if(type == MediaType.IMAGE){
                        path = thumbs_paths_map.get(cursor.id());
                        if(path == null){//sometimes thumbnails dosnot genertae
                            path = cursor.data();
                        }
                         thumbsSignatuer = path;
                    }else {
                        path = thumbs_video_paths_map.get(cursor.id());
                        thumbsSignatuer = path + cursor.id(); //videio thumbs path + video_id // android shows one thumbs for multi video
                    }
                    if(path != null && !path.equals("")){
                        File f = new File(path);
                        image_view.setImageURI(Uri.fromFile(f));
                    }
                    if(selectedThumbs.contains(thumbsSignatuer)){
                        text_holder.setVisibility(View.VISIBLE);
                    }else{
                        text_holder.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }

    enum MediaType {
        IMAGE,
        VIDEO
    }
    ////////////////////////////////////////////////////////////////////////////
}
