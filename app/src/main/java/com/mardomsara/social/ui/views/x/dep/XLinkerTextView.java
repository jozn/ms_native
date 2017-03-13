package com.mardomsara.social.ui.views.x.dep;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.utils.XTextViewUtils;

/**
 * Created by Hamid on 2/4/2016.
 */
//// TODO: 3/13/2017 add
@Deprecated //delete this
public class XLinkerTextView extends android.support.v7.widget.AppCompatTextView {
    static String TAG ="LinkerText";
	ZCommonXTextViewStates zCommonXTextViewStates;

    public XLinkerTextView(Context context) {
        super(context);
        init(context,null);
    }

    public XLinkerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public XLinkerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    int i = 0;
    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(XTextViewUtils.linkerText(text,this),type);
    }


	boolean linkerEnabled;
	IranFonts iranFonts = IranFonts.IranUltraLight;

    void init(Context context, AttributeSet attrs){
//		zCommonXTextViewStates = new ZCommonXTextViewStates(this,context, attrs);
		TypedArray a = context.getTheme().obtainStyledAttributes(
			attrs,
			R.styleable.XLinkerTextView,
			0, 0);
		int indx;
		try {
			linkerEnabled = a.getBoolean(R.styleable.XLinkerTextView_xEnableLinker,false);
			indx = a.getInteger(R.styleable.XLinkerTextView_xFont,0);
			iranFonts = IranFonts.values()[indx];

		} finally {
			a.recycle();
		}

		Typeface t =FontCache.get(iranFonts.path);
//		Helper.showMessage(""+t + " "+iranFonts.path + " "+indx);
		setTypeface(FontCache.get(iranFonts.path));
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
