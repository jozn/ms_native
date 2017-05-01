package com.mardomsara.social.ui.views.x;

import android.content.res.TypedArray;
import android.widget.TextView;

import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 3/21/2017.
 */
public enum IconFonts {

	IonIcons("iconify/android-iconify-ionicons.ttf"),
	Material("iconify/android-iconify-material.ttf"),
	SimpleLineIcons("iconify/android-iconify-simplelineicons.ttf"),
	Linear("fonts/linear.ttf");

	public String path;

	IconFonts(String fontPath) {
		path = fontPath;
	}

	public static IconFonts getIranFontFromAttrs(TypedArray a, TextView textView, int styleAbleIconId) {
		int indx = a.getInteger(styleAbleIconId,0);
		IconFonts iranFont = IconFonts.values()[indx];
		textView.setTypeface(FontCache.get(iranFont.path));
		return iranFont;
	}
}
