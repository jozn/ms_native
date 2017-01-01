package com.mardomsara.social.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.common.utils.BackgroundMusicService;
import com.mardomsara.social.App;
import com.mardomsara.social.app.Singletons;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Hamid on 5/9/2016.
 */
public class AndroidUtil {

    public static Context getContext(){
        return App.getContext();
    }

    public static void runInUi(Runnable r)
    {
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                r.run();
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }
    public static void runInUiNoPanic(Runnable r) {
        try {
            runInUi(r);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void runInUiWithSleep(Runnable r, int sleep)
    {
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(sleep);
                }catch (Exception e){
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                r.run();
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }

    public static void runInBackground(Runnable r){
        Singletons.getThreadPool().execute(r);
    }

    public static void runInBackgroundNoPanic(Runnable r){
		Runnable runner = ()->{
			try {
				r.run();
			}catch (Exception e){
				e.printStackTrace();
			}
		};
		Singletons.getThreadPool().execute(runner);
    }

    public static void runInSingleBackground(Runnable r){
        Singletons.getSingleThread().execute(r);
    }

    public static int getAndroidSdkVersion(){
        return Build.VERSION.SDK_INT;
    }
    public static int getAppVersion(){
        try {
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static View inflate(int id){
        return LayoutInflater.from(getContext()).inflate(id,null);
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static void copyTextToClipboard(String text){
        copyTextToClipboard(text,false);
    }

    public static void copyTextToClipboard(String text, boolean alert){
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Activity.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("MS", text);
        clipboard.setPrimaryClip(clip);
        if(alert){
            Helper.showMessage("متن کپی شد.");
        }
    }

	public static Icon getIconFromDrawable(int id){
		return Icon.createWithResource(AppUtil.getContext(),id);
//		return App.getContext().getResources().getString(id);
	}


	public static String getString(int id){
        return App.getContext().getResources().getString(id);
    }

    public static Drawable getDrawable(int id){
        return App.getContext().getResources().getDrawable(id);
    }

    public static Resources getResources(){
        return App.getContext().getResources();//
    }

    public static int getColor(int id){
        return App.getContext().getResources().getColor(id);//
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getScreenWidth() {
        Context context = getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        return  width;
    }

    public static int getScreenHeight() {
        Context context = getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        return  height;
    }

    public static String getScreenResolution() {
        Context context= getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        return "{" + width + "," + height + "}";
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getScreenWidthPercentToPx(float percent) {
        return (int) ((float)getScreenWidth() * percent);
    }

    public static int getScreenHeightPercentToPx(float percent) {
        return (int) ((float)getScreenHeight() * percent);
    }

    public static float getDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static void showKeyboard(EditText edit_filed){
        if(edit_filed.requestFocus()){
            InputMethodManager imm =(InputMethodManager) App.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edit_filed, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public static void hideKeyboard(EditText edit_filed){
        InputMethodManager imm =(InputMethodManager) App.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit_filed.getWindowToken(), 0);
    }

    /**
     * use for getting application Icon.
     * @return Icon as drawable from the application
     */
    public static Drawable getAppIcon() {
        Context mContext = getContext();
        Drawable icon = null;
        final PackageManager pm = mContext.getPackageManager();
        String packageName = mContext.getPackageName();
        try {
            icon = pm.getApplicationIcon(packageName);
            return icon;
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * use for sending mail to any id
     * @param mailID   email id of whom to send mail
     */
    public static void sendMail(String mailID) {
        Context mContext = getContext();
        Uri uri = Uri.parse("mailto:" + mailID);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        mContext.startActivity(intent);
    }

    // ------------------------------

    /**
     * use for make disable sleep screen lock while application in use.
     */
    @SuppressWarnings({"static-access"})
    public static void disableSleepMode() {
        Context mContext = getContext();
        System.out.println("disable");
        ((Activity) mContext).getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        KeyguardManager keyguardManager = (KeyguardManager) mContext
                .getSystemService(Activity.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(mContext.KEYGUARD_SERVICE);
        lock.disableKeyguard();
    }

    /**
     * use for open image from SDcard
     * @param imagePath location of the image from your sdcard to open
     */
    public static void openImage(String imagePath) {
        Context mContext = getContext();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(imagePath));
        intent.setDataAndType(uri, "image/*");
        mContext.startActivity(intent);
    }

    /**
     * use for open video fromSDcard
     * @param videoPath location of video from SDcard to open
     */
    public static void openVideo( String videoPath) {
        Context mContext = getContext();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(videoPath));
        intent.setDataAndType(uri, "video/*");
        mContext.startActivity(intent);
    }

    /**
     * use for oepn any _finalUrl in browser.
     *
     * @param url      to open in your mobile browser
     */
    public static void openURL(String url) {
        Context mContext = getContext();
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        mContext.startActivity(intent);
    }

    // -----------------------------------

    /**
     * use to show address location pin on map.
     * @param address  to show on map.
     */
    public static void showAddressOnMap( String address) {
        Context mContext = getContext();
        address = address.replace(' ', '+');
        Intent geoIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + address));
        mContext.startActivity(geoIntent);
    }

    /**
     * start background music
     *
     * @param mContext
     */
    public static void backgroundMusicStart(Context mContext) {
        mContext.startService(new Intent(mContext, BackgroundMusicService.class));
    }

    /**
     * stop background music
     *
     * @param mContext
     */
    public static void backgroundMusicStop(Context mContext) {
        mContext.stopService(new Intent(mContext, BackgroundMusicService.class));
    }

    /**???????????????????????????????
     * Use current volume in application
     *
     * @param mContext
     */
    public static void setCurrentDeviceVolume(Context mContext) {
        AudioManager audioManager = (AudioManager) mContext
                .getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume,
                0);
    }

    public static int getAppVersionCode(Context mContext) {
        PackageInfo pInfo = null;
        try {
            pInfo = mContext.getPackageManager().getPackageInfo(
                    mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pInfo.versionCode;
    }

    public static boolean isSDCardAvailable(Context mContext) {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }

    public static void onWifi(Context mContext, String action) {
        WifiManager wm = ((WifiManager) mContext
                .getSystemService(Context.WIFI_SERVICE));
        if (action.toLowerCase().equalsIgnoreCase("on")) {
            if (!wm.isWifiEnabled()) {
//                wm.setWifiEnabled(true);
            }
        }

        if (action.toLowerCase().equalsIgnoreCase("off")) {
            if (wm.isWifiEnabled()) {
//                wm.setWifiEnabled(false);
            }
        }
    }

    public static void hideKeyboard(Context mContext, View v) {
        // TODO Auto-generated method stub
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * Opens android share dialog pass one of uri or shareText
     *
     * @param context
     * @param title
     * @param uri
     * @param shareText
     */
    public static void openShareDialog(Context context, String title, String uri, String shareText, String shareSubject) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, shareText);
        share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);

        if (!TextUtils.isEmpty(uri)) {
            share.setType("image/*");
            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(uri));
        }
        context.startActivity(Intent.createChooser(share, title));
    }

    /**
     * Changes mobile profile to "Silent" or "Vibrate" or "Normal" mode
     *
     * @param context
     * @param mode    types of mode  - "0- Silent"
     *                - "1 - Vibrate"
     *                - "2 - Normal"
     */
    public static void chooseProfile(Context context, int mode) {
        AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (mode == 0)
            audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        else if (mode == 1)
            audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        else if (mode == 2)
            audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }

    public static ArrayList<String> getNameEmailDetails(Context context) {
        ArrayList<String> emlRecs = new ArrayList<String>();
        HashSet<String> emlRecsHS = new HashSet<String>();
        ContentResolver cr = context.getContentResolver();
        String[] PROJECTION = new String[]{ContactsContract.RawContacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_ID,
                ContactsContract.CommonDataKinds.Email.DATA,
                ContactsContract.CommonDataKinds.Photo.CONTACT_ID};
        String order = "CASE WHEN "
                + ContactsContract.Contacts.DISPLAY_NAME
                + " NOT LIKE '%@%' THEN 1 ELSE 2 END, "
                + ContactsContract.Contacts.DISPLAY_NAME
                + ", "
                + ContactsContract.CommonDataKinds.Email.DATA
                + " COLLATE NOCASE";
        String filter = ContactsContract.CommonDataKinds.Email.DATA + " NOT LIKE ''";
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, PROJECTION, filter, null, order);
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    // names comes in hand sometimes
                    String name = cur.getString(1);
                    String emlAddr = cur.getString(3);

                    // keep unique only
                    if (emlRecsHS.add(emlAddr.toLowerCase())) {
                        emlRecs.add(name + ", " + emlAddr);
                    }
                } while (cur.moveToNext());
            }
            cur.close();
        }
        return emlRecs;
    }


    public static void showNETWORDDisabledAlert(final Context ctx) {
        AlertDialog alert;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
        alertDialogBuilder.setMessage("Let the app use data connectivity.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(
                                android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
                        ctx.startActivity(callGPSSettingIntent);
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert = alertDialogBuilder.create();
        alert.show();
    }

    public static void showGPSDisabledAlert(String msg, final Context ctx) {
        AlertDialog alert;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
        alertDialogBuilder.setMessage(msg).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(
                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        ctx.startActivity(callGPSSettingIntent);
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert = alertDialogBuilder.create();
        alert.show();
    }

    @SuppressWarnings("static-access")
    public static boolean getGpsStatus(Context context) {
        LocationManager locationManager = (LocationManager) context
                .getSystemService(context.LOCATION_SERVICE);

        // getting GPS status
        boolean isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        System.out.println("gps band chhe" + isGPSEnabled);
        return isGPSEnabled;
    }

    public static void downloadRemoteFile(Context context, String url, String filename) {
        //new DownloadFile(context, url, filename, true).execute();
    }


    // -------------------------------------
    private String getRealPathFromURI(Uri targetUri, Context mContext) {
        // TODO Auto-generated method stub
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = mContext.getContentResolver().query(targetUri, proj,
                null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    private void showNETWORDDisabledAlertToUser(final Context ctx) {
        AlertDialog alert;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
        alertDialogBuilder.setMessage("Let the app use data connectivity.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(
                                android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
                        ctx.startActivity(callGPSSettingIntent);
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert = alertDialogBuilder.create();
        alert.show();
    }

    private void showGPSDisabledAlertToUser(String msg, final Context ctx) {
        AlertDialog alert;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
        alertDialogBuilder.setMessage(msg).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(
                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        ctx.startActivity(callGPSSettingIntent);
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alert = alertDialogBuilder.create();
        alert.show();
    }


}
