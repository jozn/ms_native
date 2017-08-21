package com.mardomsara.social.ui.views.x;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.ui.views.wigets.text_drawable.ColorGenerator;
import com.mardomsara.x.iconify.IconColorfulDrawable;

/**
 * Created by Hamid on 7/2/2017.
 */

public class VPostImageView extends SimpleDraweeView {
	GenericDraweeHierarchy hierarchy;
	ColorDrawable colorDrawable;

	public VPostImageView(Context context) {
		super(context);
		init(context);
	}

	public VPostImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public VPostImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	void init(Context context) {

		colorDrawable = new ColorDrawable(AndroidUtil.getColor(R.color.btn_send));

		hierarchy = new GenericDraweeHierarchyBuilder(getResources())
			.setFadeDuration(300)
			.setPlaceholderImage(colorDrawable)
//			.setRoundingParams(RoundingParams.fromCornersRadius(calBorderRadius()))
			.build();

		setHierarchy(hierarchy);
	}

	float calBorderRadius() {
		int w = getWidth();
//		AppUtil.log("getWidth:" + w + getMeasuredWidth());
		if (w <= 0) {
			return (float) AndroidUtil.dpToPx(6);
		}
		return (w / 8f); //12.5%
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		/*colorfulDrawable.borderRadios(calBorderRadius());
		hierarchy.setRoundingParams(RoundingParams.fromCornersRadius(calBorderRadius()));*/

	}

	public void setColorRGB(String color) {
		AppUtil.log("color: " + color);
		if (LangUtil.stringEmpty(color)) return;
		try {
			colorDrawable.setColor(Color.parseColor(color));
			hierarchy.setPlaceholderImage(colorDrawable);
//			invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImageURIAndColorRGB(Uri uri, String color) {
		setColorRGB(color);
		setImageURI(uri);
	}

}
