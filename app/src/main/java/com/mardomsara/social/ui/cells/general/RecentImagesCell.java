package com.mardomsara.social.ui.cells.general;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.mardomsara.MediaFacade.media.image.ImageCursor;
import com.mardomsara.MediaFacade.media.image.ImageProviderHelper;
import com.mardomsara.social.App;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.CursorRecyclerViewAdapter;
import com.mardomsara.social.ui.X;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

//import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

/**
 * Created by Hamid on 6/17/2016.
 */
//image size is 80dp
public class RecentImagesCell {

    int maxSelection = 10;

    onRecentImageClicked listener;

    List<String> selected = new ArrayList<>();

    public RecyclerView recycler_view;
    Context context = AppUtil.getContext();

    public RecentImagesCell(ViewGroup parent) {
        recycler_view = (RecyclerView) AppUtil.inflate(R.layout.recent_images_view_recycler_view,parent);
        askPermissions();
    }

    void afterPermissionsGranted(){
        ImageCursor imageCursor = ImageProviderHelper.getLastImages();

        Galley galley = new Galley(AppUtil.getContext(),imageCursor);

		//// TODO: 11/15/2016 add animatio with suport library comtaible
		/*AlphaInAnimationAdapter anim = new AlphaInAnimationAdapter(galley,0.3f);
        anim.setStartPosition(6);*///disable animating for fisrt six images
        recycler_view.setAdapter(galley);
//        recycler_view.setAdapter(anim);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true);
        recycler_view.setLayoutManager(layoutManager);
//        recycler_view.setItemAnimator(new FadeInRightAnimator());
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

        Nammu.askForPermission(App.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE,callback);
    }
    public void insertInto(ViewGroup viewGroup){
        viewGroup.addView(recycler_view);
    }

    public RecyclerView getView(){
        return(recycler_view);
    }
    public List<String> getSelected() {
        return selected;
    }

    public void setMaxSelection(int maxSelection) {
        this.maxSelection = maxSelection;
    }

    public void setListener(onRecentImageClicked listener) {
        this.listener = listener;
    }


    ////////////////////////////////////////

    public static interface onRecentImageClicked{
        void onRecentImageAdded(String filePath);
        void onRecentImageRemoved(String filePath);
        void onRecentImageClicked(String filePath);
    }


    ///////////////////////////////////////////////////////////////////

    class Galley extends CursorRecyclerViewAdapter<Galley.VH> implements View.OnClickListener {
        ImageCursor _cursor;
        Galley that;
        //fresco
        GenericDraweeHierarchyBuilder builder ;
        GenericDraweeHierarchy hierarchy;
        public Galley(Context context, ImageCursor cursor) {
            super(context, cursor);
            _cursor = cursor;
            that = this;
            builder = new GenericDraweeHierarchyBuilder(context.getResources());
            hierarchy= builder
                    .setFadeDuration(300)
//                    .setRoundingParams(RoundingParams.asCircle())
                    .setPlaceholderImage(AndroidUtil.getDrawable(R.drawable.holder_recent_image))
                    .build();
        }

        @Override
        public void onBindViewHolder(VH viewHolder, Cursor cursor, int position) {
            viewHolder.bind(_cursor,position);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new VH(AppUtil.inflate(R.layout.recent_images__image_item));
            return new VH(new X.RecentImages_ImageItem(parent));
        }

        @Override
        public void onViewRecycled(VH holder) {
            super.onViewRecycled(holder);
            holder.x.image.setImageBitmap(null);
        }

        //on select item
        @Override
        public void onClick(View v) {

        }

        public class VH extends RecyclerView.ViewHolder {

			X.RecentImages_ImageItem x;
            String filePath;

            View.OnClickListener onSelect = (v)->{
                if(selected.contains(filePath)){
                    selected.remove(filePath);
                    if(listener != null) listener.onRecentImageRemoved(filePath);
                }else {
                    if(selected.size() < maxSelection){
                        selected.add(filePath);
                        if(listener != null) listener.onRecentImageAdded(filePath);
                    }else {
                        //TODO: Toast user that max is 10 for example
                    }

                }
                notifyItemChanged((int)v.getTag());
                if(listener != null) listener.onRecentImageClicked(filePath);
            };

            public VH(X.RecentImages_ImageItem x) {
                super(x.root);
				this.x = x;
                x.root.setOnClickListener(onSelect);
            }
            Long thisViewcurrentId;
            void bind(ImageCursor imageCursor,int position){
                //in main thread
                String path;
                final Long thisRunid;
                synchronized (imageCursor){
                    File file = new File(imageCursor.data());
                    thisViewcurrentId = imageCursor.id();
                    thisRunid = imageCursor.id();
                    path = imageCursor.data();
                    filePath = imageCursor.data();
                    x.root.setTag(position);
                    if(selected.contains(filePath)){
                        x.text_icon.setVisibility(View.VISIBLE);
                        x.text_holder.setBackgroundColor(AndroidUtil.getColor(R.color.transparent_selection));
                    }else{//for recyled this is neccessory
                        x.text_icon.setVisibility(View.INVISIBLE);
                        x.text_holder.setBackgroundColor(AndroidUtil.getColor(R.color.transparent_0));
                    }
                    x.image.setHierarchy(hierarchy);
                }

//                synchronized (image){
                    AndroidUtil.runInSingleBackground(()->{
                        Bitmap bm = ImageProviderHelper.getMicroThumnail(thisRunid);
//                Bitmap bm = ImageProviderHelper.getMiniThumnail(imageCursor.id());
//                    image.setImageURI(Uri.fromFile(file));
                        AndroidUtil.runInUi(()->{
                            Log.d("Recent",""+thisRunid+" "+thisViewcurrentId);
//                            synchronized (thisViewcurrentId){
                                if(bm==null){
                                    if(thisRunid.equals(thisViewcurrentId)){
//                                        image.setImageURI(path);
                                        x.image.setImageURI(Uri.parse(path));
                                    }
                                }else {
                                    if(thisRunid.equals(thisViewcurrentId)) {
                                        x.image.setImageBitmap(bm);
                                    }
                                }
//                            }
                        });

                    });
//                }
            }
        }


    }

}
//if(bm==null){
//        if(thisRunid == thisViewcurrentId){
//        AndroidUtil.runInUi(()->image.setImageURI(path));
//        }
//        }else {
//        if(thisRunid == thisViewcurrentId) {
//        AndroidUtil.runInUi(()->image.setImageBitmap(bm));
//        }
//        }
