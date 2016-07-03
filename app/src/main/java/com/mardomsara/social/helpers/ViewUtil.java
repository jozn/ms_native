package com.mardomsara.social.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.common.utils.BlurEffect;

import eu.janmuller.android.simplecropimage.CropImage;

/**
 * Created by Hamid on 5/9/2016.
 */
public class ViewUtil {

    public static boolean isEmptyEditText(EditText edText) {
        if (edText.getText().toString().trim().length() > 0)
            return false;
        else
            return true;
    }

    /**
     * use for getting device height
     *
     * @param mContext
     * @return height of your device
     */
    public static int getDeviceHeight(Context mContext) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    /**
     * use for getting device width
     *
     * @param mContext
     * @return width of your device
     */
    public static int getDeviceWidth(Context mContext) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    /**
     * apply blur effect on bitmap
     *
     * @param mContext
     * @param bitmap   on which you have to apply effect
     * @return bitmap with effect
     */
    public static Bitmap blurEffectsOnBitmap(Context mContext, Bitmap bitmap) {
        return BlurEffect.fastblur(mContext, bitmap, 12);
    }

    /**
     * apply blue effect on darawable.
     *
     * @param mContext
     * @param drawable for applying effect
     * @param radius   for blur effect 0 to 25
     * @return drawable
     */
    public static Drawable blurEffectsOnDrawable(Context mContext, int drawable, int radius) {

        if (radius == 0)
            radius = 20;
        Bitmap blurBitmap;
        Bitmap bitmap = drawableTobitmap(mContext, drawable);
        blurBitmap = BlurEffect.fastblur(mContext, bitmap, radius);
        return new BitmapDrawable(blurBitmap);
    }

    /**
     * convert drawable to bitmap
     *
     * @param mContext
     * @param drawable for convert to bitmap
     * @return bitmap image
     */
    public static Bitmap drawableTobitmap(Context mContext, int drawable) {
        // TODO Auto-generated method stub
        Drawable myDrawable = mContext.getResources().getDrawable(drawable);
        return ((BitmapDrawable) myDrawable).getBitmap();
    }

    /**
     * convert bitmap to drawable
     *
     * @param mContext
     * @param bitmap   for convert to drawable
     * @return drawable image
     */
    public static Drawable bitmapToDrawable(Context mContext, Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    /**
     * Get Rounded cornered bitmap
     *
     * @param bitmap
     * @param roundPixels
     * @return
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int roundPixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = roundPixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /**
     * Preventing any view from getting clicked for particular time
     *
     * @param view
     */
    private static final long MIN_CLICK_INTERVAL = 2 * 1000;
    public static void preventDoubleClick(final View view) {
        view.setEnabled(false);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                view.setEnabled(true);
            }
        }, MIN_CLICK_INTERVAL);
    }

    /**
     * Function to display simple Alert DialogHelper or Toast
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param toast   - show as toast or dialog
     */
    public static void showAlertDialog(Context context, String title, String message, boolean toast) {
        if (toast) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        } else {

            AlertDialog alertDialog = null;
            if (!((Activity) context).isFinishing()) {
                if (alertDialog == null)
                    alertDialog = new AlertDialog.Builder(context).create();
                // Setting DialogHelper Title
                alertDialog.setTitle(title);
                // Setting DialogHelper Message
                alertDialog.setMessage(message);
                // Setting OK Button
                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
//                alertDialog.setView();
            }
        }
    }

    /**
     * Captures the view and returns bitmap
     *
     * @param v
     * @return bitmap of view captured
     */
    public static Bitmap captureView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
//        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    public static int pickColor(View view, int x, int y)
            throws NullPointerException {

        int red = 0;
        int green = 0;
        int blue = 0;
        int color = 0;

        int offset = 1; // 3x3 Matrix
        int pixelsNumber = 0;

        int xImage = 0;
        int yImage = 0;


        ImageView imageView = (ImageView) view;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap imageBitmap = bitmapDrawable.getBitmap();


        xImage = (int) (x * ((double) imageBitmap.getWidth() / (double) imageView.getWidth()));
        yImage = (int) (y * ((double) imageBitmap.getHeight() / (double) imageView.getHeight()));


        for (int i = xImage - offset; i <= xImage + offset; i++) {
            for (int j = yImage - offset; j <= yImage + offset; j++) {
                try {
                    color = imageBitmap.getPixel(i, j);
                    red += Color.red(color);
                    green += Color.green(color);
                    blue += Color.blue(color);
                    pixelsNumber += 1;
                } catch (Exception e) {
                    //Log.w(TAG, "Error picking color!");
                }
            }
        }
        red = red / pixelsNumber;
        green = green / pixelsNumber;
        blue = blue / pixelsNumber;

        return Color.rgb(red, green, blue);
    }


    public static void startCropImage(Context context, String path, int requestCode, int aspectX, int aspectY) {

        Intent intent = new Intent(context, CropImage.class);
        intent.putExtra(CropImage.IMAGE_PATH, path);
        intent.putExtra(CropImage.SCALE, true);

        intent.putExtra(CropImage.ASPECT_X, aspectX);
        intent.putExtra(CropImage.ASPECT_Y, aspectY);

        ((Activity)context).startActivityForResult(intent, requestCode);
    }


}
