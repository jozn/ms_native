package com.mardomsara.social.app;

import android.os.Environment;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.models_old.stores.SharedStore;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hamid on 3/19/2016.
 */
public class AppFiles {
    public static File PUBLIC_ROOT_DIR = Environment.getExternalStorageDirectory();
    public static String PUBLIC_ROOT_DIR_PATH = PUBLIC_ROOT_DIR.getAbsolutePath()+"/";

    public static String APP_STORAGE_DIR_PATH = PUBLIC_ROOT_DIR_PATH + "MardomSara/";
    public static String APP_MEDIA_DIR_PATH = APP_STORAGE_DIR_PATH ;//+ "Media/";

    public static String APP_TEMP_DIR_PATH = APP_STORAGE_DIR_PATH + ".Temp/";

    public static String APP_AVATAR_DIR_PATH = APP_STORAGE_DIR_PATH + "MardomSara Avatars/";
    public static String VOICE_NOTE_DIR_PATH = APP_MEDIA_DIR_PATH + "MardomSara Voice Notes/";
    public static String VOICE_NOTE_SENT_DIR_PATH = VOICE_NOTE_DIR_PATH + "Sent/";

    public static String PHOTO_DIR_PATH = APP_MEDIA_DIR_PATH + "MardomSara Images/";
    public static String PHOTO_SENT_DIR_PATH = PHOTO_DIR_PATH + "Sent/";

    public static String VIDEO_DIR_PATH = APP_MEDIA_DIR_PATH + "MardomSara Videos/";
    public static String VIDEO_SENT_DIR_PATH = VIDEO_DIR_PATH + "Sent/";
    public static String VIDEO_THUMB_DIR_PATH = VIDEO_DIR_PATH + "Thumb/";

    public static String DOCUMENTS_DIR_PATH = APP_MEDIA_DIR_PATH + "MardomSara Documents/";
    public static String DOCUMENTS_SENT_DIR_PATH = DOCUMENTS_DIR_PATH + "Sent/";

    public static String AUDIO_DIR_PATH = APP_MEDIA_DIR_PATH + "MardomSara Audio/";
    public static String AUDIO_SENT_DIR_PATH = AUDIO_DIR_PATH + "Sent/";

    public static String PROFILE_DIR_PATH = APP_MEDIA_DIR_PATH + "MardomSara Profiles/";

    public static String NOMEDIA = ".nomedia";
    private static String LOG_TAG = "AppFiles";
    static {
//        buildAllDirs();
    }
    void asd(){
        File f =new File(VIDEO_DIR_PATH +"asdas.mp4");
//        f.createNewFile();
    }

    public static void buildAllDirs(){
        AppUtil.log("Making Files Dirs like: "+ VIDEO_SENT_DIR_PATH);
//        AppUtil.log("Making Files Dirs like: res: "+ );
        createDires(AppFiles.APP_STORAGE_DIR_PATH);
        createDires(AppFiles.APP_MEDIA_DIR_PATH);

        createNoMediaDires(AppFiles.APP_TEMP_DIR_PATH);

        createDires(AppFiles.PHOTO_DIR_PATH);
        createNoMediaDires(AppFiles.PHOTO_SENT_DIR_PATH);


        createNoMediaDires(AppFiles.VOICE_NOTE_DIR_PATH);
        createNoMediaDires(AppFiles.VOICE_NOTE_SENT_DIR_PATH);

        createDires(AppFiles.VIDEO_DIR_PATH);
        createNoMediaDires(AppFiles.VIDEO_SENT_DIR_PATH);
        createNoMediaDires(AppFiles.VIDEO_THUMB_DIR_PATH);

        createDires(AppFiles.DOCUMENTS_DIR_PATH);
        createNoMediaDires(AppFiles.DOCUMENTS_SENT_DIR_PATH);

        createDires(AppFiles.AUDIO_DIR_PATH);
        createNoMediaDires(AppFiles.AUDIO_SENT_DIR_PATH);

        createNoMediaDires(AppFiles.APP_AVATAR_DIR_PATH);
        createNoMediaDires(AppFiles.PROFILE_DIR_PATH);

        //create for no media

//        FileChooserFileUtils.
    }

	public static void changedNomediaSetings(){
		boolean show = SharedStore.getSetingStore().getShowMediasInGallery();
		if(show){
			FileUtil.tryDelete(AppFiles.PHOTO_DIR_PATH+NOMEDIA);
			FileUtil.tryDelete(AppFiles.VIDEO_DIR_PATH+NOMEDIA);
		}else {
			createFileNoMeida(AppFiles.PHOTO_DIR_PATH);
			createFileNoMeida(AppFiles.VIDEO_DIR_PATH);
		}
	}

    private static void createNoMediaDires(String path){
        try {
            File fd =new File(path);
            fd.mkdirs();
            File fn =new File(path+NOMEDIA);
            fn.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private static void createFileNoMeida(String path){
		try {
			File fd =new File(path);
			fd.mkdirs();
			File fn =new File(path+NOMEDIA);
			fn.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private static void createDires(String path){
        try {
            File fd =new File(path);
            fd.mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUserAvatarFileName(int UserId, String AvatarSrc){
//        int last = AvatarSrc.hashCode();
        String[] strs = AvatarSrc.split("/");
        String last2 = strs.length >0 && AvatarSrc != "" ? strs[strs.length-1] : ".jpg";
        return ""+ UserId+"_"+last2;
    }

    public static void getPostPhotoFileName(int UserId, String AvatarSrc) {
    }


    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

}
//
////    public File getPublicStorageDir(String albumName) {
////        // Get the directory for the user's public pictures directory.
////        File file = new File(Environment.getExternalStorageDirectory(
////                Environment.DIRECTORY_PICTURES), albumName);
////        if (!file.mkdirs()) {
////            Log.e(LOG_TAG, "Directory not created");
////        }
////        return file;
////    }
//
//    public File getAlbumStorageDir(String albumName) {
//        // Get the directory for the user's public pictures directory.
//        File file = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES), albumName);
//        if (!file.mkdirs()) {
//            Log.e(LOG_TAG, "Directory not created");
//        }
//        return file;
//    }
