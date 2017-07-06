package com.mardomsara.social.ui.views.x;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.views.wigets.text_drawable.ColorGenerator;
import com.mardomsara.x.iconify.IconColorfulDrawable;

/**
 * Created by Hamid on 7/2/2017.
 */

public class MAvatarView extends SimpleDraweeView {
	IconColorfulDrawable colorfulDrawable;
	GenericDraweeHierarchy hierarchy;

	public MAvatarView(Context context) {
		super(context);
		init(context);
	}

	public MAvatarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MAvatarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	void init(Context context) {
		colorfulDrawable = new IconColorfulDrawable(context, "ion-ios-person-outline");
		colorfulDrawable.borderRadios(calBorderRadius());
		colorfulDrawable.backgroundColor(ColorGenerator.MATERIAL.getColor(this));

		hierarchy = new GenericDraweeHierarchyBuilder(getResources())
			.setFadeDuration(300)
			.setPlaceholderImage(colorfulDrawable)
			.setRoundingParams(RoundingParams.fromCornersRadius(calBorderRadius()))
			.build();

		setHierarchy(hierarchy);

	}

	float calBorderRadius() {
		int w = getWidth();
		AppUtil.log("getWidth:" + w + getMeasuredWidth());
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
		colorfulDrawable.borderRadios(calBorderRadius());
		hierarchy.setRoundingParams(RoundingParams.fromCornersRadius(calBorderRadius()));

	}

	public void setColorId(int colorId) {
		colorfulDrawable.backgroundColor(ColorGenerator.MATERIAL.getColor(colorId));
		invalidate();
	}

	public void setImageURIAndId(Uri uri, int colorId) {
		setColorId(colorId);
		setImageURI(uri);
	}


	private void setImageURI2(Uri uri) {
		ImageRequestBuilder.newBuilderWithSource(uri)
			.setCacheChoice(ImageRequest.CacheChoice.SMALL)
			.build();

		Fresco.getImagePipeline();

	}

}
