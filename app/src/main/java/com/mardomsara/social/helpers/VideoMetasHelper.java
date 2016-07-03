package com.mardomsara.social.helpers;

import android.media.MediaMetadataRetriever;
import android.net.Uri;

import java.io.File;

/**
 * Created by Hamid on 6/22/2016.
 */
public class VideoMetasHelper {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();

    public VideoMetasHelper(String videoPath) {
        try {
            retriever.setDataSource(AppUtil.getContext(), Uri.fromFile(new File(videoPath)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getVideoLength(){
        try {
            String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            long timeInMillisec = Long.parseLong(time );
            return (int) timeInMillisec;
        }catch (Exception e ){
            return 0;
        }
    }

    public int getVideoHeight(){
        try {
            String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
            int val = Integer.parseInt(time );
            return val;
        }catch (Exception e ){
            return 0;
        }
    }

    public int getVideoWidth(){
        try {
            String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
            int val = Integer.parseInt(time );
            return val;
        }catch (Exception e ){
            return 0;
        }
    }

}
