package com.mardomsara.social.ui.views.x;

import android.content.res.TypedArray;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 3/21/2017.
 */
public enum IranFonts {

	Iran("fonts/IRAN_Sans.ttf"),
	IranBold("fonts/IRAN_Sans_Bold.ttf"),
	IranLight("fonts/IRAN_Sans_Light.ttf"),
	IranMedium("fonts/IRAN_Sans_Medium.ttf"),
	IranUltraLight("fonts/IRAN_Sans_UltraLight.ttf");

	public String path;

	IranFonts(String fontPath) {
		path = fontPath;
	}

	public static IranFonts getIranFontFromAttrs(TypedArray a, TextView textView, int styleAbleIconId) {
		int indx = a.getInteger(styleAbleIconId,0);
		IranFonts iranFont = IranFonts.values()[indx];
		textView.setTypeface(FontCache.get(iranFont.path));
		return iranFont;
	}
}
