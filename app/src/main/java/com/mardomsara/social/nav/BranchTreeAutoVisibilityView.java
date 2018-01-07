package com.mardomsara.social.nav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 1/6/2018.
 */

public class BranchTreeAutoVisibilityView extends FrameLayout {

	X.BranchHolder branchHolder;
	OnHierarchyChangeListener hierarchyChangeListener = new OnHierarchyChangeListener() {
		@Override
		public void onChildViewAdded(View parent, View child) {
			change("onChildViewAdded");
		}

		@Override
		public void onChildViewRemoved(View parent, View child) {
			change("onChildViewRemoved");
		}
	};

	public BranchTreeAutoVisibilityView(@NonNull Context context) {
		super(context);

		setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
			@Override
			public void onChildViewAdded(View parent, View child) {
				change("onChildViewAdded");
			}

			@Override
			public void onChildViewRemoved(View parent, View child) {
				change("onChildViewRemoved");
			}
		});

		init();
	}

	public BranchTreeAutoVisibilityView(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public BranchTreeAutoVisibilityView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	private void init() {
		branchHolder = new X.BranchHolder(getContext());
		addView(branchHolder.root);
		branchHolder.default_frame.setOnHierarchyChangeListener(hierarchyChangeListener);
		branchHolder.child_frame_deep.setOnHierarchyChangeListener(hierarchyChangeListener);
	}

	@Override
	public void onViewAdded(View child) {
		super.onViewAdded(child);
		change("onViewAdded");
	}

	@Override
	public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
		super.setOnHierarchyChangeListener(listener);
	}

	@Override
	public void onViewRemoved(View child) {
		super.onViewRemoved(child);
		change("onViewRemoved");
	}

	public void change(String s) {
		Log.d("BranchTreeAutoVisibilityView", "" + s);
		if (branchHolder != null) {
			Log.d("BranchTreeAutoVisibilityView", " child count: " + branchHolder.child_frame_deep.getChildCount());
			if (branchHolder.child_frame_deep.getChildCount() > 0) {
//				Log.d("HolderView"," 1 " );
				branchHolder.child_frame_deep.setVisibility(VISIBLE);
				branchHolder.default_frame.setVisibility(GONE);
			} else {
//				Log.d("HolderView"," 2 ");
				branchHolder.child_frame_deep.setVisibility(GONE);
				branchHolder.default_frame.setVisibility(VISIBLE);
			}
		}
	}
}
