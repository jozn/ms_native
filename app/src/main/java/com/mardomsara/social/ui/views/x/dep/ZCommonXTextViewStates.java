package com.mardomsara.social.ui.views.x.dep;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 3/9/2017.
 */
@Deprecated
public class ZCommonXTextViewStates {

	boolean linkerEnabled;
	IranFonts iranFonts = IranFonts.IranLight;
	TextView textView;

	public ZCommonXTextViewStates(TextView textView, Context context, AttributeSet attrs) {
		TypedArray a = context.getTheme().obtainStyledAttributes(
			attrs,
			R.styleable.XIcon,
			0, 0);

		try {
			linkerEnabled = a.getBoolean(R.styleable.XLinkerTextView_xEnableLinker,false);
			int indx = a.getInteger(R.styleable.XLinkerTextView_xFont,0);
			iranFonts = IranFonts.values()[indx];

		} finally {
			a.recycle();
		}

		textView.setTypeface(FontCache.get(iranFonts.path));

	}

	void setFont(){
	}

	public static enum IranFonts {

		Iran("fonts/IRAN_Sans.ttf"),
		IranBold("fonts/IRAN_Sans_Bold.ttf"),
		IranLight("fonts/IRAN_Sans_Light.ttf"),
		IranMedium("fonts/IRAN_Sans_Medium.ttf"),
		IranUltraLight("fonts/IRAN_Sans_UltraLight.ttf");

		String path;
		IranFonts(String fontPath) {
			path=fontPath;
		}
	}
}
