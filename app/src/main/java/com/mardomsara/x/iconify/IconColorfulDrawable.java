package com.mardomsara.x.iconify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;

import com.mardomsara.social.ui.views.wigets.text_drawable.ColorGenerator;
import com.mardomsara.x.iconify.internal.IconFontDescriptorWrapper;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

/**
 * Embed an icon into a Drawable that can be used as TextView icons, or ActionBar icons.
 * <pre>
 *     new IconDrawable(context, IconValue.icon_star)
 *           .colorRes(R.color.white)
 *           .actionBarSize();
 * </pre>
 * If you don't set the size of the drawable, it will use the size
 * that is given to him. Note that in an ActionBar, if you don't
 * set the size explicitly it uses 0, so please use actionBarSize().
 */
public class IconColorfulDrawable extends Drawable {

    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;

    private Context context;

    private Icon icon;

    private TextPaint paint;

    private int size = -1;

    private int alpha = 255;

	private int backgroungColor;
	private Paint bPaint;
	private float borderRadios;
	RectF rectF = new RectF();
	int bgColorId = Integer.MAX_VALUE;

    /**
     * Create an IconDrawable.
     * @param context Your activity or application context.
     * @param iconKey The icon key you want this drawable to display.
     * @throws IllegalArgumentException if the key doesn't match any icon.
     */
    public IconColorfulDrawable(Context context, String iconKey) {
        Icon icon = XIconify.findIconForKey(iconKey);
        if (icon == null) {
            throw new IllegalArgumentException("No icon with that key \"" + iconKey + "\".");
        }
        init(context, icon);
    }

    /**
     * Create an IconDrawable.
     * @param context Your activity or application context.
     * @param icon    The icon you want this drawable to display.
     */
    public IconColorfulDrawable(Context context, Icon icon) {
        init(context, icon);
    }

    private void init(Context context, Icon icon) {
        this.context = context;
        this.icon = icon;
        paint = new TextPaint();
        IconFontDescriptorWrapper descriptor = XIconify.findTypefaceOf(icon);
        if (descriptor == null) {
            throw new IllegalStateException("Unable to find the module associated " +
                    "with icon " + icon.key() + ", have you registered the module " +
                    "you are trying to use with Iconify.with(...) in your Application?");
        }
        paint.setTypeface(descriptor.getTypeface(context));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setUnderlineText(false);
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);

		if(bgColorId == Integer.MAX_VALUE){
			backgroungColor = Color.parseColor("#CFD8DC");
		}else {
			backgroungColor = ColorGenerator.MATERIAL.getColor(1);
		}
		backgroungColor = Color.parseColor("#CFD8DC");
		bPaint = new Paint();
		bPaint.setColor(backgroungColor);
    }

    /**
     * Set the size of this icon to the standard Android ActionBar.
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable actionBarSize() {
        return sizeDp(ANDROID_ACTIONBAR_ICON_SIZE_DP);
    }

    /**
     * Set the size of the drawable.
     * @param dimenRes The dimension resource.
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable sizeRes(int dimenRes) {
        return sizePx(context.getResources().getDimensionPixelSize(dimenRes));
    }

    /**
     * Set the size of the drawable.
     * @param size The size in density-independent pixels (dp).
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable sizeDp(int size) {
        return sizePx(convertDpToPx(context, size));
    }

    /**
     * Set the size of the drawable.
     * @param size The size in pixels (px).
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable sizePx(int size) {
        this.size = size;
        setBounds(0, 0, size, size);
        invalidateSelf();
        return this;
    }

	public IconColorfulDrawable backgroundColor(int color) {
		bPaint.setColor(color);
		invalidateSelf();
		return this;
	}

	public IconColorfulDrawable borderRadios(float sizePx) {
		borderRadios = sizePx;
		invalidateSelf();
		return this;
	}

    /**
     * Set the color of the drawable.
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable color(int color) {
        paint.setColor(color);
        invalidateSelf();
        return this;
    }

    /**
     * Set the color of the drawable.
     * @param colorRes The color resource, from your R file.
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable colorRes(int colorRes) {
        paint.setColor(context.getResources().getColor(colorRes));
        invalidateSelf();
        return this;
    }

    /**
     * Set the alpha of this drawable.
     * @param alpha The alpha, between 0 (transparent) and 255 (opaque).
     * @return The current IconDrawable for chaining.
     */
    public IconColorfulDrawable alpha(int alpha) {
        setAlpha(alpha);
        invalidateSelf();
        return this;
    }

    @Override
    public int getIntrinsicHeight() {
        return size;
    }

    @Override
    public int getIntrinsicWidth() {
        return size;
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();

		canvas.drawRoundRect(new RectF(bounds), (float) borderRadios,(float) borderRadios, bPaint);

        int height = bounds.height();
        paint.setTextSize(height);
        Rect textBounds = new Rect();
        String textValue = String.valueOf(icon.character());
        paint.getTextBounds(textValue, 0, 1, textBounds);
        int textHeight = textBounds.height();
        float textBottom = bounds.top + (height - textHeight) / 2f + textHeight - textBounds.bottom;
        canvas.drawText(textValue, bounds.exactCenterX(), textBottom, paint);
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public boolean setState(int[] stateSet) {
        int oldValue = paint.getAlpha();
        int newValue = isEnabled(stateSet) ? alpha : alpha / 2;
        paint.setAlpha(newValue);
        return oldValue != newValue;
    }

    @Override
    public void setAlpha(int alpha) {
        this.alpha = alpha;
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public void clearColorFilter() {
        paint.setColorFilter(null);
    }

    @Override
    public int getOpacity() {
//        return this.alpha;
		return PixelFormat.OPAQUE;
    }

    /**
     * Sets paint style.
     * @param style to be applied
     */
    public void setStyle(Paint.Style style) {
        paint.setStyle(style);
    }

    // Util
    private boolean isEnabled(int[] stateSet) {
        for (int state : stateSet)
            if (state == android.R.attr.state_enabled)
                return true;
        return false;
    }

    // Util
    private int convertDpToPx(Context context, float dp) {
        return (int) TypedValue.applyDimension(
                COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}