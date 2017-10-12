package com.mardomsara.social.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamid on 5/9/2016.
 */
public class FileUtil {
    public static void tryDelete(String path) {
        try {
            File file = new File(path);
            if(file.exists()){
                if(!file.isDirectory()){
                    file.delete();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean createFolderRec(Context mContext, String path){
        File SDCardRoot = new File(path);
        if (!SDCardRoot.exists()) {
            return SDCardRoot.mkdirs();
        }
        return false;
    }

    public static boolean createFolderRecRelative(String path){
        File SDCardRoot = new File(Environment.getExternalStorageDirectory().getPath()+"/"+path);
        if (!SDCardRoot.exists()) {
            return SDCardRoot.mkdirs();
        }
        return false;
    }
                                       /**
                                        * use to create folder in your directory
                                        *
                                        * @param mContext
                                        * @param path       location in which you have to create folder
                                        * @param folderName name of the folder
                                        */
    public static boolean createFolder(Context mContext, String path,
                                       String folderName) {
        File SDCardRoot = new File(path, folderName);
        if (!SDCardRoot.exists()) {
            return SDCardRoot.mkdir();
        }
//        else {
//            Toast.makeText(mContext, "fail", Toast.LENGTH_LONG).show();
//        }
        return false;
    }

    /**
     * get no of file counts from your directory
     *
     * @param format        of file extensions like .jpg, .png, .mp3, .mp4
     * @param directoryPath location of the directory
     * @return give counter integer
     */
    public static int getFileCounts(String format,
                                    String directoryPath) {
        int Sdcardcount = 0;
        File fileCount = new File(directoryPath);
        if (fileCount.exists()) {
            File[] list = fileCount.listFiles();
            for (File f : list) {
                String name = f.getName();
                if (name.endsWith(format))
                    Sdcardcount++;
            }
        }
        return Sdcardcount;
    }

    public static String getFileExtension(String filePath){
        File f = new File(filePath);
        String fileName = f.getName();
        int separatorIndex = fileName.lastIndexOf(".");
        return (separatorIndex < 0) ? "" : fileName.substring(separatorIndex + 1, fileName.length());
    }
    public static String getFileExtensionWithDot(String filePath){
        File f = new File(filePath);
        String fileName = f.getName();
        int separatorIndex = fileName.lastIndexOf(".");
        return (separatorIndex < 0) ? "" : fileName.substring(separatorIndex , fileName.length());
    }

    //"$" sign to be replaced with "~1"
    //filePath : "/emulated/Mardomsra Images/Img_1852$.jpg
    //DEPRECATED use: createNextName_INFINATE_LOOP(): its work better and dosn't have side effects of create empty files
    public static File createNextFile(String $filePath) {
        String _filePath = $filePath.replace("$","");
        File file = new File(_filePath);
        int count = 1;
        while (file.exists()){
            _filePath = $filePath.replace("$", "~"+count);
            file = file = new File(_filePath);
            count++;
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    //__saved for many saveWithRoom at same time or reducing IO
    static Map<String,Boolean> __saved = new HashMap<>();
    //improved version createNextFile(file) -- its work better and dosn't have side effects of create empty files
    public static String createNextName_INFINATE_LOOP(String $filePath) {
    	//othersise will hang for over
    	if(!$filePath.contains("$")){
    		return $filePath;
		}
        String _filePath = $filePath.replace("$","");
        int count = 1;
        while (__saved.containsKey(_filePath)){
            _filePath = $filePath.replace("$", "~"+count);
            count++;
        }

        //try with files also : just to be sure
        try {
            File file = new File(_filePath);
            while (file.exists()){
                _filePath = $filePath.replace("$", "~"+count);
                file = new File(_filePath);
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        __saved.put(_filePath ,true);
        return _filePath;
    }

}
