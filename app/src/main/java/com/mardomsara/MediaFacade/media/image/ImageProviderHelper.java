package com.mardomsara.MediaFacade.media.image;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;

import com.mardomsara.MediaFacade.media.MediaCursor;
import com.mardomsara.MediaFacade.media.video.VideoCursor;
import com.mardomsara.MediaFacade.media.video.VideoFacade;
import com.mardomsara.social.helpers.AppUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 6/17/2016.
 */
public class ImageProviderHelper {
    private static Context getContext(){
        return AppUtil.getContext();
    }

    public static ImageCursor getLastImages(){
        ImageCursor imageCursor = new ImageFacade(getContext()).image().fetch();
        return imageCursor;
    }

    public static ImageCursor getFolders(){
        ImageCursor imageCursor = new ImageFacade(getContext()).bucket().fetch();
        return imageCursor;
    }

    public static ImageCursor getImagesForBucket(String BUCKET_ID){
        Cursor cursor = null;
        try {
            //NOT USED :: fetchALl
            String[] projection = new String[]{
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA,
                    MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                    MediaStore.Images.ImageColumns.DATE_TAKEN,
                    MediaStore.Images.ImageColumns.DATE_MODIFIED,
                    MediaStore.Images.ImageColumns.MIME_TYPE,
            };
            String order = MediaStore.Images.ImageColumns.DATE_MODIFIED + " DESC";
            String whereSelection = " "+MediaStore.Images.ImageColumns.BUCKET_ID + " = " + BUCKET_ID;

            cursor =  getContext().getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    null,
                    whereSelection,
                    null, order);

            int size = 0;
            if(cursor!=null) size = cursor.getCount();
            Log.d("ImageProviderHelper", " getImagesForBucket size : "+size+" " +BUCKET_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageCursor(cursor);
    }

    public static MediaCursor getVideosForBucket(String BUCKET_ID){
        Cursor cursor = null;
        try {
            String order = MediaStore.Images.ImageColumns.DATE_MODIFIED + " DESC";
            String whereSelection = " "+MediaStore.Video.Media.BUCKET_ID + " = " + BUCKET_ID;

            cursor =  getContext().getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    null,
                    whereSelection,
                    null, order);

            int size = 0;
            if(cursor!=null) size = cursor.getCount();
            Log.d("getVideosForBucket", " getVideosForBucket size : "+size+" " +BUCKET_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new VideoCursor(cursor);
    }

    public static MediaCursor getVideoFolders(){
        MediaCursor imageCursor = VideoFacade.getInstance(getContext()).bucket().fetch();
        return imageCursor;
    }

    public static Bitmap getVideoMicroThumnail(long imageId){
        return VideoFacade.getInstance(getContext()).thumbnail().fetch(imageId, MediaStore.Video.Thumbnails.MICRO_KIND);
    }

    public static Bitmap getVideoMiniThumnail(long imageId){
        return VideoFacade.getInstance(getContext()).thumbnail().fetch(imageId, MediaStore.Video.Thumbnails.MINI_KIND);
    }

    public static Map<Long, String> loadAllTumbsPaths(){
        Cursor cursor = null;
        Map<Long, String> map = new HashMap<>();
        try {
            String[] projection = new String[]{
                    MediaStore.Images.Thumbnails.IMAGE_ID,
                    MediaStore.Images.Thumbnails.DATA
            };
//            String order = "datetaken DESC";

            cursor =  getContext().getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, projection, null, null, null);
            while (cursor.moveToNext()){
                map.put(cursor.getLong(0),cursor.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<Long, String> loadAllMoviesTumbsPaths(){
        Cursor cursor = null;
        Map<Long, String> map = new HashMap<>();
        try {
            String[] projection = new String[]{
                    MediaStore.Video.Thumbnails.VIDEO_ID,
                    MediaStore.Video.Thumbnails.DATA
            };
//            String order = "datetaken DESC";

            cursor =  getContext().getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, projection, null, null, null);
            while (cursor.moveToNext()){
                map.put(cursor.getLong(0),cursor.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    public static void tryClose(Cursor cursor){
        if(cursor != null) {
            cursor.close();
        }
    }

    public static Bitmap getMicroThumnail(long imageId){
        Log.d("Media", "getMicroThumnail +" + imageId);
        return _getMiniThumnail(imageId, MediaStore.Images.Thumbnails.MICRO_KIND);
    }

    public static Bitmap getMiniThumnail(long imageId){
        return _getMiniThumnail(imageId, MediaStore.Images.Thumbnails.MINI_KIND);
    }

    public static String getImagePathByImaheId(long imageId){
        String res = "";
        String where = ""+MediaStore.Images.Media._ID + " = " + imageId;
        Cursor cursor =  getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, where, null, null);
        if(cursor != null){
            try {
                MediaCursor ic= new ImageCursor(cursor);
                ic.moveToFirst();
                res = ic.data();
            }catch (Exception e){
            }
        }
        return res;
    }

    public static String getVideoPathByImaheId(long videoId){
        String res = "";
        String where = ""+MediaStore.Video.Media._ID + " = " + videoId;
        Cursor cursor =  getContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, where, null, null);
        if(cursor != null){
            try {
                MediaCursor ic= new VideoCursor(cursor);
                ic.moveToFirst();
                res = ic.data();
            }catch (Exception e){
            }
        }
        return res;
    }


    static Bitmap _getMiniThumnail(long imageId, int kind){
        Bitmap bitmap = MediaStore.Images.Thumbnails.getThumbnail(
                getContext().getContentResolver(),
                imageId, kind,
                null);
        return bitmap;
    }











    ////////////////////////////////////////////////////////////

    public static Cursor __getLastImages_DEP(Context context){
        Cursor cursor = null;
        try {
            String[] projection = new String[]{
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA,
                    MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                    MediaStore.Images.ImageColumns.DATE_TAKEN,
                    MediaStore.Images.ImageColumns.MIME_TYPE,
            };
            String order = "datetaken DESC";

            cursor =  context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, order);
            int size = 0;
            if(cursor!=null) size = cursor.getCount();
            Log.d("ImageProviderHelper", " getLastImages size : "+size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursor;
    }





}
