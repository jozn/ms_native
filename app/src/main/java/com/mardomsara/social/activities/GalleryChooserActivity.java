package com.mardomsara.social.activities;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
//import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.amirarcane.recentimages.RecentImages;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.MediaFacade.media.image.ImageCursor;
import com.mardomsara.MediaFacade.media.image.ImageFacade;
import com.mardomsara.MediaFacade.media.image.ImageProviderHelper;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.CursorRecyclerViewAdapter;
import com.mardomsara.social.ui.views.RecentImagesView;

//import it.gmariotti.recyclerview.itemanimator.*;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GalleryChooserActivity extends AppCompatActivity {
    String Tag = "Gallery";
    Cursor cursor ;

//    @Bind(R.id.recycler_view) RecyclerView recycler_view;
    @Bind(R.id.frame_layout) ViewGroup frame_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_chooser);
        RecentImagesView r = new RecentImagesView();
//        setContentView(r.recycler_view);
        ButterKnife.bind(this);
        r.insertInto(frame_layout);
//        ImageCursor imageCursor = ImageProviderHelper.getLastImages();
//
//        Galley galley = new Galley(this,imageCursor);
//        AlphaInAnimationAdapter anim = new AlphaInAnimationAdapter(galley,0.4f);
////        recycler_view.setAdapter(galley);
//        recycler_view.setAdapter(anim);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
////        layoutManager.
//        recycler_view.setLayoutManager(layoutManager);
////        recycler_view.getItemAnimator().s
////        recycler_view.setItemAnimator(new SlideInOutLeftItemAnimator(recycler_view));
//        recycler_view.setItemAnimator(new FadeInRightAnimator());

    }


//    static class Galley extends RecyclerView.Adapter<Galley.VH>{
    static class Galley extends CursorRecyclerViewAdapter<Galley.VH> {
        ImageCursor _cursor;

        //fresco
        GenericDraweeHierarchyBuilder builder ;
        GenericDraweeHierarchy hierarchy;
        public Galley(Context context, ImageCursor cursor) {
            super(context, cursor);
            _cursor = cursor;
           builder = new GenericDraweeHierarchyBuilder(context.getResources());
            hierarchy= builder
                    .setFadeDuration(300)
                    .setRoundingParams(RoundingParams.asCircle())
                    .setPlaceholderImage(AndroidUtil.getDrawable(R.drawable.holder_recent_image))
                    .build();
        }

        @Override
        public void onBindViewHolder(VH viewHolder, Cursor cursor, int position) {
            viewHolder.bind(_cursor);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VH(AppUtil.inflate(R.layout.recent_images_image_item));
        }

    @Override
    public void onViewRecycled(VH holder) {
        super.onViewRecycled(holder);
        holder.image.setImageBitmap(null);
    }

//    @Override protected Animator[] getAnimators(View view) {
//        return new Animator[] { ObjectAnimator.ofFloat(view, "alpha", mFrom, 1f) };
//    }

    public class VH extends RecyclerView.ViewHolder {
            @Bind(R.id.image) SimpleDraweeView image;
                public VH(View itemView) {
                    super(itemView);
                    ButterKnife.bind(this,itemView);

                }
                void bind(ImageCursor imageCursor){
                    File file = new File(imageCursor.data());
                    image.setHierarchy(hierarchy);
//                    hierarchy= builder
//                            .setFadeDuration(1000)
//                            .setRoundingParams(RoundingParams.asCircle())
//                            .setPlaceholderImage(AndroidUtil.getDrawable(R.drawable.holder_recent_image))
//                            .build();

                    Bitmap bm = ImageProviderHelper.getMicroThumnail(imageCursor.id());
//                    image.setImageURI(Uri.fromFile(file));

                    image.setImageBitmap(bm);
                }
            }

    }


    protected void __onCreate__DEP(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_chooser);

        ImageFacade facade = ImageFacade.getInstance(this);
        ImageFacade.Bucket foldeers = facade.bucket();
        new RecentImages();

        cursor = ImageProviderHelper.getLastImages();
        ImageCursor wrapper = new ImageCursor(cursor);
        while (cursor.moveToNext()){
//            Log.d(Tag,cursor.getString(2));
            Log.d(Tag,wrapper.mimeType());
            Log.d(Tag,"d: "+ wrapper.data());
            Log.d(Tag,"d: "+ wrapper.bucketName());
//            Log.d(Tag,"d: "+ wrapper.b());
        }

        ImageCursor ff = foldeers.fetch();
        while (ff.moveToNext()){
//            Log.d(Tag,cursor.getString(2));
            Log.d(Tag,"folder "+ ff.bucketName());
            ImageCursor inFF = ImageProviderHelper.getImagesForBucket(ff.bucketId());
            while (inFF.moveToNext()){
                Log.d(Tag,"folder inside "+ inFF.bucketName() + " "  +inFF.displayName());
            }
        }

        try {
//            Log.d("Gallery",facade.bucket().fetch().mimeType());
//            Log.d("Gallery",facade.image().fetch().moveToNext().mimeType());
            Log.d("Gallery", " size 22 : "+cursor.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Log.d("Gallery",facade.image().fetch().bucketId());
 /*       SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item_image, null,
                new String[] {MediaStore.Images.Media.BUCKET_DISPLAY_NAME},
                new int[] {R.id.text}, 0) {
            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                super.bindView(view, context, cursor);
                ImageCursor wrapper = new ImageCursor(cursor);
                ImageView iv = (ImageView) view.findViewById(R.id.image);
                long id = wrapper.id();

//                Picasso.with(context).load(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id))
//                        .resizeDimen(R.dimen.image_size, R.dimen.image_size)
//                        .centerCrop()
//                        .into(iv);
            }
        };
 */
    }



}
