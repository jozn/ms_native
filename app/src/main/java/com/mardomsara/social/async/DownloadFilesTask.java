package com.mardomsara.social.async;

import android.app.Service;
import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by Hamid on 1/29/2016.
 */
public class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 1110;
        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }

        return totalSize;
    }

    protected void onProgressUpdate(Integer... progress) {
//        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
//        showDialog("Downloaded " + result + " bytes");
    }
}