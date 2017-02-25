package com.mardomsara.social.helpers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.VideoView;

import com.mardomsara.social.app.AppFiles;

import java.io.File;

/**
 * Created by Hamid on 5/9/2016.
 */
public class IntentHelper {
    private  Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
//    public static final String IMAGE_DIRECTORY_NAME = "CommonDirectory";
    public static final String IMAGE_DIRECTORY_NAME = AppFiles.APP_TEMP_DIR_PATH;

    /**
     * Captures image in Common Directory
     *
     * @param mContext
     * @param CAMERA_CAPTURE_IMAGE_REQUEST_CODE
     * @param camera
     */
    public Uri captureImage(Context mContext, int CAMERA_CAPTURE_IMAGE_REQUEST_CODE, String camera) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 400000);
        intent.putExtra("outputX", 750);
        if (camera.equalsIgnoreCase("Front")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_FRONT);
        } else if (camera.equalsIgnoreCase("Back")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_BACK);
        }

        ((Activity) mContext).startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
        return fileUri;
    }

    public void pickImage(Context mContext, int CAMERA_PICK_IMAGE_REQUEST_CODE) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((Activity) mContext).startActivityForResult(intent, CAMERA_PICK_IMAGE_REQUEST_CODE);
    }

    public void previewCapturedImage(ImageView ivImagePreview) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(), options);
            ivImagePreview.setImageBitmap(bitmap);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError outOfMemoryError) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            // downsizing image as it throws OutOfMemory Exception for larger images
            options.inSampleSize = 2;
            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(), options);
            ivImagePreview.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Uri recordVideo(Context mContext, int CAMERA_CAPTURE_VIDEO_REQUEST_CODE, String camera, String savePath) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//        fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
        fileUri = Uri.fromFile(new File(savePath));
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);//1 high quality
//        intent.putExtra(MediaStore.EXTRA_, 0);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        if (camera.equalsIgnoreCase("Front")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_FRONT);
        } else if (camera.equalsIgnoreCase("Back")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_BACK);
        }
        ((Activity) mContext).startActivityForResult(intent, CAMERA_CAPTURE_VIDEO_REQUEST_CODE);
        return fileUri;
    }

    public void pickVideo(Context mContext, int CAMERA_PICK_VIDEO_REQUEST_CODE) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("video/*");
        ((Activity) mContext).startActivityForResult(intent, CAMERA_PICK_VIDEO_REQUEST_CODE);
    }

    public void previewVideo(VideoView videoPreview) {
        try {
            videoPreview.setVideoPath(fileUri.getPath());
            // start playing
            videoPreview.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }
    private File getOutputMediaFile(int type) {
//        String rooz = Rooz.fromTimeMs(new Date().getTimeSec()).getFormatedForFoldersName("-");
      /*  String rooz = Rooz.fromTimeMs(1424123123000l).getFormatedForFoldersName("-");
        String houersFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(1424123123000l));
        String fileName = rooz + "_" + houersFormat ;
      */
        String fileName =  FormaterUtil.getFullyYearToSecondsSolarName() ;
//        File mediaFile = _makeFile(fileName,type);
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(IMAGE_DIRECTORY_NAME + "/" + "IMG_" + fileName + "$.jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(IMAGE_DIRECTORY_NAME + "/" + "VID_" + fileName + "$.mp4");
        }else {return null;}

//        mediaFile = FileUtil.createNextFile(mediaFile.getAbsolutePath());
        mediaFile = new File(FileUtil.createNextName(mediaFile.getAbsolutePath()));
//        int count = 1;
//        while (mediaFile.exists()){
//            mediaFile = _makeFile(fileName+"~"+count,type);
//            count++;
//        }

        return mediaFile;
    }

    File _makeFile(String fileName, int type){
        File mediaStorageDir = new File(IMAGE_DIRECTORY_NAME);
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + fileName + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_" + fileName + ".mp4");
        } else {
            return null;
        }
        return mediaFile;
    }

    /**
     * getpath of picked image or video
     *
     * @param context
     * @param uri
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {

            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();

            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file absUrl.
     */
    public String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }




}



// External sdcard location
//        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), IMAGE_DIRECTORY_NAME);
/*
        File mediaStorageDir = new File(IMAGE_DIRECTORY_NAME);
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }
*/
// Create a media file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());



//        if (type == MEDIA_TYPE_IMAGE) {
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + fileName + ".jpg");
//        } else if (type == MEDIA_TYPE_VIDEO) {
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_" + fileName + ".mp4");
//        } else {
//            return null;
//        }