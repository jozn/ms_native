package com.mardomsara.social.ui.presenter.chats;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hamid on 6/17/2016.
 */
public class GalleryChooserPresenter extends BasePresenter {
    Map<Long, String> thumbs_paths_map= ImageProviderHelper.loadAllTumbsPaths();;
    Map<Long, String> thumbs_video_paths_map= ImageProviderHelper.loadAllMoviesTumbsPaths();;
    Map<String, Integer> folder_count_cache = new HashMap<>();;
    Map<String, Integer> folder_count_video_cache = new HashMap<>();;

//    public ChatEntryPresenter chatEntryPresenter;
    public ChatRoomPresenter chatEntryPresenter;

    @Bind(R.id.view_pager)
    ViewPager view_pager;
    @Bind(R.id.tab_layout)
    TabLayout tab_layout;
    GalleryChooserPresenterPagerAdaptor pagerAdaptor;
    @Override
    public View buildView() {
        View v = AppUtil.inflate(R.layout.gallery_chooser_presenter);
        TabLayout tabs = (TabLayout) v.findViewById(R.id.tab_layout);
        ButterKnife.bind(this, v);

        pagerAdaptor = new GalleryChooserPresenterPagerAdaptor(getFragment().getChildFragmentManager(),getContext());


        view_pager.setAdapter(pagerAdaptor);
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.setTabMode(TabLayout.MODE_FIXED);
        view_pager.setCurrentItem(1);

        //must be here
        for (int i = 0; i < tabs.getTabCount(); i++) {
            TabLayout.Tab t = tabs.getTabAt(i);
            t.setCustomView(pagerAdaptor.getTabView(i) );
        }

        return v;
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


    public class GalleryChooserPresenterPagerAdaptor extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        Context context;
        private String tabTitles[] = new String[]{"ویدیو", "عکس"};//, "Tab3","Tab222","Tab222","Tab222" };
        public GalleryChooserPresenterPagerAdaptor(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MediaExplorer(MediaType.VIDEO).getFragment();
                case 1:
                    return new MediaExplorer(MediaType.IMAGE).getFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        public View getTabView(int position) {
            // Given you have a custom layout in `response/layout/custom_tab.xml` with a TextView and ImageView
            View v = AppUtil.inflate(R.layout.tab_cell_general);
            TextView tv = (TextView) v.findViewById(R.id.textView);
            tv.setText(tabTitles[position]);
            ImageView img = (ImageView) v.findViewById(R.id.imgView);
            //img.setImageResource(imageResId[position]);
            return v;
        }
    }

    /////////////////////////////////////////////////////////////////////////
    class MediaExplorer extends BasePresenter {
        @Bind(R.id.recycler_view) RecyclerView recycler_view;
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
                @Bind(R.id.image_view) SimpleDraweeView image_view;
                @Bind(R.id.folder_name) TextView folder_name;
                @Bind(R.id.folder_count) TextView folder_count;
                @Bind(R.id.icon_video) TextView icon_video;
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
                        Nav.push(new MediaBrowserEnteryPresenter(type, bucketId));
                    });
                }

            }
        }
//        MediaStore.Images.Thumbnails
    }

    class MediaBrowserEnteryPresenter extends BasePresenter {
        MediaType type;
        @Bind(R.id.recycler_view) RecyclerView recycler_view;
        @Bind(R.id.left_side) View left_side;
        @Bind(R.id.text_icon) TextView text_icon;
        @Bind(R.id.send_btn) TextView send_btn;
        @Bind(R.id.back_btn) TextView back_btn;
        @Bind(R.id.title) TextView title;

        List<String> selectedReal = new ArrayList<>();
        List<String> selectedThumbs = new ArrayList<>();
        int maxSelection = 10;


        Map<Long,Bitmap> _cache= new HashMap();
        String buketId;

        public MediaBrowserEnteryPresenter(MediaType type, String buketId) {
            this.type = type;
            this.buketId = buketId;
        }

        @Override
        public View buildView() {
            View v = LayoutInflater.from(context).inflate(R.layout.gallery_chooser_media_list, null);
            ButterKnife.bind(this, v);
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
                        chatEntryPresenter.onRecentImagesClick(selectedReal);
                    });
                }else {//Video
                    AndroidUtil.runInUi(()->{//async
                        chatEntryPresenter.onGalleryChoserVideoClicked(selectedReal);
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
                @Bind(R.id.image) SimpleDraweeView image_view;
                @Bind(R.id.text_holder) View text_holder;
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
