package com.mardomsara.social.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.x.IconFonts;

// this class is the master of all Emoji, linker, limiter
public class XRawIcon extends android.support.v7.widget.AppCompatTextView {
	IconFonts iconFonts = IconFonts.IonIcons;

	public XRawIcon(Context context) {
		super(context);
		init(context,null);
	}

	public XRawIcon(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context,attrs);
	}

	public XRawIcon(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context,attrs);
	}

	void init(Context c,  AttributeSet attrs){
		if (attrs == null) {

		} else {
			TypedArray a = null;
			try {
				a = getContext().obtainStyledAttributes(attrs, R.styleable.XRawIcon);
				int indx = a.getInteger(R.styleable.XRawIcon_xIconFont,0);
				iconFonts = IconFonts.values()[indx];
				setTypeface(FontCache.get(iconFonts.path));

			}finally {
				if (a != null){
					a.recycle();
				}
			}
		}

		setText(getText());

	}


}
