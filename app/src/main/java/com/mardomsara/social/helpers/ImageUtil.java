package com.mardomsara.social.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.util.Base64;
import android.util.Log;

import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Hamid on 5/9/2016.
 */
public class ImageUtil {
    public static String ImageToBase64(Uri uri, Context mContext) {
        String mBase64 = "";
        InputStream imageStream = null;
        try {
            imageStream = mContext.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        yourSelectedImage.compress(Bitmap.CompressFormat.JPEG, 90, bao);

        byte[] ba = bao.toByteArray();

        String ba1 = Base64.encodeToString(ba, 0);
        return mBase64;
    }

    /**
     * save your bitmap in your preference
     *
     * @param bitmap  which you have to store in preference
     * @param context
     * @param name    of preference for your image
     */
    public static void setBitmapToPreference(Bitmap bitmap, Context context, String name, String PREFS_FILE_NAME) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        PrefUtil.setStringPrefrences(context, name, temp, PREFS_FILE_NAME);
    }


    /**
     * get bitmap which you stored in preference
     *
     * @param mContext
     * @param name            of bitmap preference
     * @param PREFS_FILE_NAME
     * @return bitmap image
     */
    public static Bitmap getBitmapFromPreference(Context mContext, String name, String PREFS_FILE_NAME) {
        try {
            String imageString = PrefUtil.getStringPrefrences(mContext, name, PREFS_FILE_NAME);
            byte[] encodeByte = Base64.decode(imageString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * generate base64 from bitmap image
     *
     * @param mBitmap bitmap image
     * @return base64 string
     */
    public static String createBase64(Bitmap mBitmap) {
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos1);
        byte[] b1 = baos1.toByteArray();
        return Base64.encodeToString(b1, Base64.DEFAULT);
    }

    public static String createBase64(File file){
        Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
        return createBase64(bm);
    }

    public static String createBase64(String filePath){
        Bitmap bm = BitmapFactory.decodeFile(filePath);
        return createBase64(bm);
    }

    public static String createBase64(byte[] bytes){
        Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        return createBase64(bm);
    }

    public static Bitmap base64ToBitmap(String str64) {
        byte[] bts = Base64.decode(str64 ,Base64.DEFAULT);
        Bitmap bm = BitmapFactory.decodeByteArray(bts,0,bts.length);
        return bm;
    }

    public static Bitmap getBitmapFromDrawable(int id){
        return BitmapFactory.decodeResource(AppUtil.getContext().getResources(), id);
    }

    public static Bitmap compress(Bitmap mBitmap){
        return compress(mBitmap,80);
    }

    public static Bitmap compress(Bitmap mBitmap, int quality){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG,quality,out);
        Bitmap bm = BitmapFactory.decodeByteArray(out.toByteArray(),0,out.size());
        return bm;
    }

    public static byte[] compressToBytes(Bitmap mBitmap){
        return  compressToBytes(mBitmap,80);
    }

    public static byte[] compressToBytes(Bitmap mBitmap, int quality){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
        return  out.toByteArray();
    }

    public static byte[] compressAndResizeToBytes(Bitmap mBitmap,int width, int quality){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageUtil.getResizedBitmapRatio(mBitmap,width).compress(Bitmap.CompressFormat.JPEG, quality, out);
        return  out.toByteArray();
    }

    public static String compressAndResizeToBase64(Bitmap mBitmap,int width, int quality){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageUtil.getResizedBitmapRatio(mBitmap,width).compress(Bitmap.CompressFormat.JPEG, quality, out);
        return Base64.encodeToString(out.toByteArray(),Base64.DEFAULT);
    }

    public static byte[] blurThumbnail(Bitmap mBitmap){
        Bitmap bm = ImageUtil.fastblur(ImageUtil.getResizedBitmapRatio(mBitmap,360),1,10);
        return ImageUtil.compressToBytes(bm,30);
    }

    public static byte[] blurThumbnail(String filePath){
        Bitmap mBitmap = BitmapFactory.decodeFile(filePath);
        Bitmap bm = ImageUtil.fastblur(ImageUtil.getResizedBitmapRatio(mBitmap,360),1,10);
        return ImageUtil.compressToBytes(bm,30);
    }

    public static String blurThumbnailToBase64(String filePath){
        Bitmap mBitmap = BitmapFactory.decodeFile(filePath);
        return blurThumbnailToBase64(mBitmap);
    }

    public static String blurThumbnailToBase64(Bitmap mBitmap){
        Bitmap bm = ImageUtil.fastblur(ImageUtil.getResizedBitmapRatio(mBitmap,160),1,10);
        String base64 = createBase64(compressToBytes(bm,30));
//        mBitmap.recycle();
        bm.recycle();
        return base64;
    }

    public static Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    public static Bitmap getResizedBitmapRatio(Bitmap bm, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight =  scaleWidth; // * height;

        int newHeight = (int) (scaleHeight * height);
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        AppUtil.log("resized:" + width +" "+ height  +" "+ scaleWidth + " " + scaleHeight);
        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(
                bm, newWidth, newHeight, false);
//        bm.recycle();
        return resizedBitmap;
    }

    public static Bitmap getCropcedCenterdThumnil(Bitmap bm, int maxPx) {
        int size = Math.min(bm.getHeight(),bm.getWidth());
        size = Math.min(size,maxPx);
        return ThumbnailUtils.extractThumbnail(bm,size,size);
    }

    public static boolean resizeImage(String filePath ,String outFilePath, int maxWidthHeight ){
        if(filePath== null || filePath.equals("")) return false;
        if(outFilePath== null || outFilePath.equals("")) return false;

        File file = new File(filePath);
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        if(bitmap == null) return  false;

        int w,h;//out w,h
        int width,height;//real w,h
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        float ratio = ((float)height)/((float)width);// height/width
        w = width;
        h = height;

        //NOTIC: can arise bug if height is too much
        if(maxWidthHeight > width){// dontresize  resize --
            Log.d("IMAGE", "copying image: "+filePath+ " to: "+ outFilePath + " sizes:  width, height ,Ratio: "+w+ " "+ h+ " "+ratio);
            try {
                FileUtils.copyFile(new File(filePath), new File(outFilePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        if(width >= height) {//with is amx so height will be ratio
            if(width> maxWidthHeight){
                w = maxWidthHeight;
            }
            h = (int) (ratio * ((float) w));
        }else {//height is max so width will be ratio
            if(height> maxWidthHeight){
                h = maxWidthHeight;
            }
            w = (int) (((float) h) / ratio );
        }

        Log.d("IMAGE", "Resizing image: "+filePath+ " to: "+ outFilePath + " sizes:  width, height ,Ratio: "+w+ " "+ h+ " "+ratio);

        Bitmap bm = Bitmap.createScaledBitmap(bitmap,w,h,false);
        OutputStream outputStream=null;
        try {
            outputStream = new FileOutputStream(outFilePath);
            bm.compress(Bitmap.CompressFormat.JPEG,90,outputStream);
            outputStream.close();
//        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
        }
        bitmap.recycle();
        bm.recycle();

        return true;
    }

    public static void saveToFile(Bitmap bitmap, String outPath){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outPath);
            bitmap.compress(Bitmap.CompressFormat.JPEG,90,outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createVideoThump(String videoPath, String thumbOutPath){
        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, MediaStore.Video.Thumbnails.MINI_KIND);
        saveToFile(bitmap, thumbOutPath);
    }

    public static int getVideoLenght(String videoPath){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    //use one of overloaded setDataSource() functions to setOrReplace your data source
        retriever.setDataSource(AppUtil.getContext(), Uri.fromFile(new File(videoPath)));
        String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long timeInMillisec = Long.parseLong(time );
        return (int) timeInMillisec;
    }

    /**
     * ME: this is a modified copy of ThumbnailUtils.createVideoThumbnail() to suport
     * custom image size
     * Create a video thumbnail for a video. May return null if the video is
     * corrupt or the format is not supported.
     */
    public static Bitmap createVideoThumbnail(String filePath, int maxWidth, int minWidth) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath);
            bitmap = retriever.getFrameAtTime(-1);
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }

        if (bitmap == null) return null;

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth, newHeight;
//        newWidth = maxWidth;
        newWidth = Math.max(width,minWidth);
        newWidth = Math.min(newWidth,maxWidth);

        float ratio = (float)newWidth/(float)width;
        newHeight = (int)((float)height * ratio);
        int max = Math.max(width, maxWidth);
        max = Math.max(max, height);
        bitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);

        return bitmap;
    }

    /**
     * Stack Blur v1.0 from
     * http://www.quasimondo.com/StackBlurForCanvas/StackBlurDemo.html
     * Java Author: Mario Klingemann <mario at quasimondo.com>
     * http://incubator.quasimondo.com
     *
     * created Feburary 29, 2004
     * Android port : Yahel Bouaziz <yahel at kayenko.com>
     * http://www.kayenko.com
     * ported april 5th, 2012
     *
     * This is a compromise between Gaussian Blur and Box blur
     * It creates much better looking blurs than Box Blur, but is
     * 7x faster than my Gaussian Blur implementation.
     *
     * I called it Stack Blur because this describes best how this
     * filter works internally: it creates a kind of moving stack
     * of colors whilst scanning through the image. Thereby it
     * just has to addStart one new block of color to the right side
     * of the stack and remove the leftmost color. The remaining
     * colors on the topmost layer of the stack are either added on
     * or reduced by one, depending on if they are on the right or
     * on the left side of the stack.
     *
     * If you are using this algorithm in your code please addStart
     * the following line:
     * Stack Blur Algorithm by Mario Klingemann <mario@quasimondo.com>
     */

    public static Bitmap fastblur(Bitmap sentBitmap, float scale, int radius) {

        int width = Math.round(sentBitmap.getWidth() * scale);
        int height = Math.round(sentBitmap.getHeight() * scale);
        sentBitmap = Bitmap.createScaledBitmap(sentBitmap, width, height, false);

        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        if (radius < 1) {
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = ( 0xff000000 & pix[yi] ) | ( dv[rsum] << 16 ) | ( dv[gsum] << 8 ) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }

    /////////////// Bluering //////////////////
    //ME: below function dosn't work in armbd cpu -- don't use this

    //    @SuppressLint("NewApi")
    public static Bitmap blurRenderScript(Bitmap smallBitmap, int radius) {
        Context context = AppUtil.getContext();
        try {
            smallBitmap = RGB565toARGB888(smallBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bitmap bitmap = Bitmap.createBitmap(
                smallBitmap.getWidth(), smallBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);

        RenderScript renderScript = RenderScript.create(context);

        Allocation blurInput = Allocation.createFromBitmap(renderScript, smallBitmap);
        Allocation blurOutput = Allocation.createFromBitmap(renderScript, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript,
                Element.U8_4(renderScript));
        blur.setInput(blurInput);
        blur.setRadius(radius); // radius must be 0 < r <= 25
        blur.forEach(blurOutput);

        blurOutput.copyTo(bitmap);
        renderScript.destroy();

        return bitmap;

    }

    private static Bitmap RGB565toARGB888(Bitmap img) throws Exception {
        int numPixels = img.getWidth() * img.getHeight();
        int[] pixels = new int[numPixels];

        //Get JPEG pixels.  Each int is the color values for one pixel.
        img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

        //Create a Bitmap of the appropriate format.
        Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);

        //Set RGB pixels.
        result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
        return result;
    }

}
