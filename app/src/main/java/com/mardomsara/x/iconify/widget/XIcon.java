package com.mardomsara.x.iconify.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.lib.Spanny;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.x.iconify.Icon;
import com.mardomsara.x.iconify.XIconify;
import com.mardomsara.x.iconify.internal.CustomTypefaceSpan;
import com.mardomsara.x.iconify.internal.HasOnViewAttachListener;
import com.mardomsara.x.iconify.internal.IconFontDescriptorWrapper;

//note left and right attrs are for RTL lang for LTR must channge the lib for space support and use  interchange
public class XIcon extends AppCompatTextView implements HasOnViewAttachListener {
	private final static int DEFULT_COLOR = Color.parseColor("#949494");
	IconViewType iconViewType = IconViewType.Legacy;
	String leftIconStr = null;
	Icon leftIcon = null;
	String rightIconStr = null;
	Icon rightIcon = null;

	String textStr = " ";
	int iconColor = AndroidUtil.getColor(R.color.gray);
	int iconSpacePx = AndroidUtil.dpToPx(2);

	int textSizePx = AndroidUtil.dpToPx(16) ;

	int iconSizePx = -1;

    private HasOnViewAttachListenerDelegate delegate;

    public XIcon(Context context) {
        super(context);
        init(context,null);
    }

    public XIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public XIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs);
    }

	@SuppressWarnings(" styleable ")
    private void init(Context context, AttributeSet attrs) {
        setTransformationMethod(null);
		TypedArray a = getContext().getTheme().obtainStyledAttributes(
			attrs,
			R.styleable.XIcon,
			0, 0);

		try {
			leftIconStr = a.getString(R.styleable.XIcon_xiconLeft);
			rightIconStr = a.getString(R.styleable.XIcon_xiconRight);
			iconSizePx = a.getDimensionPixelSize(R.styleable.XIcon_xiconSize, AndroidUtil.dpToPx(24));
			iconColor = a.getColor(R.styleable.XIcon_xiconColor, iconColor);
			textStr = a.getString(R.styleable.XIcon_xiconText);
			iconSpacePx = a.getDimensionPixelSize(R.styleable.XIcon_xiconSpace, iconSpacePx);
			//for text size
			textSizePx = a.getDimensionPixelSize(R.styleable.XIcon_android_textSize, textSizePx);

		} finally {
			a.recycle();
		}
		setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizePx);
		setText(getText());
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
		isIcony();
		if( isIcony() == false ){
			super.setText(XIconify.compute(getContext(), text, this), type);
		}else {
			try {
//				super.setText(XIconify.compute(getContext(), "%%%%%5+" +leftIconStr + " " + rightIconStr+ " "+isIcony(), this), type);
				setAllIcons(text,type);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
    }

    void setAllIcons(CharSequence text, BufferType type){

		/*leftIcon = XIconify.findIconForKey(leftIconStr);
		rightIcon = XIconify.findIconForKey(rightIconStr);*/

		// Loop through the descriptors to find a key match
		IconFontDescriptorWrapper leftIconFontDescriptor = null;
		IconFontDescriptorWrapper rightIconFontDescriptor = null;
		for (int i = 0; i < XIconify.iconFontDescriptors.size(); i++) {
			leftIconFontDescriptor = XIconify.iconFontDescriptors.get(i);
			leftIcon = leftIconFontDescriptor.getIcon(leftIconStr);
			if (leftIcon != null) break;
		}
		for (int i = 0; i < XIconify.iconFontDescriptors.size(); i++) {
			rightIconFontDescriptor = XIconify.iconFontDescriptors.get(i);
			rightIcon = rightIconFontDescriptor.getIcon(rightIconStr);
			if (rightIcon != null) break;
		}


		final SpannableStringBuilder spannableBuilder = new SpannableStringBuilder(text);
		Spanny spanny = new Spanny();

		//right
		if(rightIcon != null){
			CustomTypefaceSpan rightSpan=new CustomTypefaceSpan(rightIcon,
				rightIconFontDescriptor.getTypeface(getContext()),
				iconSizePx, -1, iconColor, false, false);
			spanny.append(rightIcon.key(),rightSpan);
		}

		//text
		if(textStr != null){
			setTypeface(FontCache.getIranMedium());
			spanny.append(" ", new AbsoluteSizeSpan(iconSizePx));
			spanny.append(textStr);
			spanny.append(" ", new AbsoluteSizeSpan(iconSizePx));
		}

		//left
		if(leftIcon!=null){
			CustomTypefaceSpan leftSpan=new CustomTypefaceSpan(leftIcon,
				leftIconFontDescriptor.getTypeface(getContext()),
				iconSizePx, -1, Color.RED, false, false);
			spanny.append(leftIcon.key(),leftSpan);
		}

		if (this instanceof HasOnViewAttachListener) {
			((HasOnViewAttachListener) this).setOnViewAttachListener(null);
		}

		setOnViewAttachListener(null);
		super.setText(spanny,type);
	}

	private CustomTypefaceSpan buildSpan(Icon icon, IconFontDescriptorWrapper iconFontDescriptorWrapper){
		return new CustomTypefaceSpan(icon,
			iconFontDescriptorWrapper.getTypeface(getContext()),
			iconSizePx, -1, iconColor, false, false);
	}


    public boolean isIcony(){
		if( isStrNotEmpt(leftIconStr) || isStrNotEmpt(rightIconStr) ){
			iconViewType = IconViewType.Icony;
			return true;
		}
		return false;
	}

	public boolean isStrNotEmpt(String str){
		if(str != null && (!str.equals(""))){
			return true;
		}
		return false;
	}

	public void setFullText(CharSequence text){
		if( (leftIconStr != null && !leftIconStr.equals("")) || (rightIconStr != null && !rightIconStr.equals("")) ){
			iconViewType = IconViewType.Icony;
		}

	}

    @Override
    public void setOnViewAttachListener(OnViewAttachListener listener) {
        if (delegate == null) delegate = new HasOnViewAttachListenerDelegate(this);
        delegate.setOnViewAttachListener(listener);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		if(delegate != null) delegate.onAttachedToWindow();
	}

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
		if(delegate != null) delegate.onDetachedFromWindow();
    }

    static enum IconViewType {
		Legacy,
		Icony
	}
}
