/*
 * Copyright 2014 Ankush Sachdeva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mardomsara.emojicon;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.models.stores.Store;
import com.mardomsara.social.models.stores.StoreConstants;


/**
 * @author Ankush Sachdeva (sankush@yahoo.co.in).
 */

public class EmojiconsPopup extends PopupWindow {
	private int mEmojiTabLastSelectedIndex = -1;
	private View[] mEmojiTabs;
	private PagerAdapter mEmojisAdapter;
	private EmojiconRecentsManager mRecentsManager;
	private int keyBoardHeight = Store.getInt(StoreConstants.KEYBOARD_SIZE, (int) (AndroidUtil.getScreenHeight()/2.5) );//40percent
	private Boolean pendingOpen = false;
	private Boolean isOpened = false;
	OnEmojiconClickedListener onEmojiconClickedListener;
	OnEmojiconBackspaceClickedListener onEmojiconBackspaceClickedListener;
	OnSoftKeyboardOpenCloseListener onSoftKeyboardOpenCloseListener;
	View rootView;
	Context mContext;

	private ViewPager emojisPager;
	/**
	 * Constructor
	 * @param rootView	The top most layout in your view hierarchy. The difference of this view and the screen height will be used to calculate the keyboard height.
	 * @param mContext The context of current activity.
	 */
	Emojicons emojicons;
	public EmojiconsPopup(View rootView, Context mContext){
		super(mContext);
		this.mContext = mContext;
		this.rootView = rootView;
		emojicons = new Emojicons();
		View customView = emojicons.createView(null);
		setContentView(customView);
		setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		//default size
		setBackgroundDrawable(new BitmapDrawable());

//		setSize((int) mContext.getResources().getDimension(R.dimen.keyboard_height), LayoutParams.MATCH_PARENT);
		setSize(LayoutParams.MATCH_PARENT,keyBoardHeight);
		currentListner = this;
	}
	/**
	 * Set the listener for the event of keyboard opening or closing.
	 */
	public void setOnSoftKeyboardOpenCloseListener(OnSoftKeyboardOpenCloseListener listener){
		this.onSoftKeyboardOpenCloseListener = listener;
	}

	/**
	 * Set the listener for the event when any of the emojicon is clicked
	 */
	public void setOnEmojiconClickedListener(OnEmojiconClickedListener listener){
		this.onEmojiconClickedListener = listener;
		emojicons.setmOnEmojiconClickedListener(listener);
	}

	/**
	 * Set the listener for the event when backspace on emojicon popup is clicked
	 */
	public void setOnEmojiconBackspaceClickedListener(OnEmojiconBackspaceClickedListener listener){
		this.onEmojiconBackspaceClickedListener = listener;
		emojicons.setEmojiBackListener(listener);
	}

	/**
	 * Use this function to show the emoji popup.
	 * NOTE: Since, the soft keyboard sizes are variable on different android devices, the
	 * library needs you to open the soft keyboard atleast once before calling this function.
	 * If that is not possible see showAtBottomPending() function.
	 *
	 */
	public void showAtBottom(){
		showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
	}

	public void showAtBottom2(){
		showAtLocation(rootView, Gravity.TOP, 100, 1000);
	}
	/**
	 * Use this function when the soft keyboard has not been opened yet. This
	 * will show the emoji popup after the keyboard is up next time.
	 * Generally, you will be calling InputMethodManager.showSoftInput function after
	 * calling this function.
	 */
	public void showAtBottomPending(){
		if(isKeyBoardOpen())
			showAtBottom();
		else
			pendingOpen = true;
	}

	/**
	 *
	 * @return Returns true if the soft keyboard is open, false otherwise.
	 */
	public Boolean isKeyBoardOpen(){
		return isOpened;
	}

	/**
	 * Dismiss the popup
	 */
	@Override
	public void dismiss() {
		super.dismiss();
		EmojiconRecentsManager
		.getInstance(mContext).saveRecents();
//		currentListner = null;
//		rootView.getViewTreeObserver().removeOnGlobalLayoutListener(layoutListener);
	}

	//for avoid memory leaks
	public void destroy() {
		currentListner = null;
	}

	public void setCurrentListnerToMe() {
		currentListner = this;
	}

	/**
	 * Call this function to resize the emoji popup according to your soft keyboard size
	 */
	public void setSizeForSoftKeyboard_dep(){
		_getOserverObject();
		rootView.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
	}

	OnGlobalLayoutListener layoutListener;

	OnGlobalLayoutListener _getOserverObject(){
		return layoutListener = new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				Rect r = new Rect();
				rootView.getWindowVisibleDisplayFrame(r);

				int screenHeight = getUsableScreenHeight();
				int heightDifference = screenHeight
						- (r.bottom - r.top);
				int resourceId = mContext.getResources()
						.getIdentifier("status_bar_height",
								"dimen", "android");
				if (resourceId > 0) {
					heightDifference -= mContext.getResources()
							.getDimensionPixelSize(resourceId);
				}
				if (heightDifference > 100) {
					keyBoardHeight = heightDifference;
//					Store.putInt(StoreConstants.KEYBOARD_SIZE,keyBoardHeight);
//					Helper.showMessage("KEYBOARD_SIZE "+keyBoardHeight);
					setSize(LayoutParams.MATCH_PARENT, keyBoardHeight);
					if(isOpened == false){
						if(onSoftKeyboardOpenCloseListener!=null)
							onSoftKeyboardOpenCloseListener.onKeyboardOpen(keyBoardHeight);
					}
					isOpened = true;
					if(pendingOpen){
						showAtBottom();
						pendingOpen = false;
					}
				}
				else{
					isOpened = false;
					if(onSoftKeyboardOpenCloseListener!=null)
						onSoftKeyboardOpenCloseListener.onKeyboardClose();
				}
			}
		};
	}

	public void setSiz(){
		setSize(LayoutParams.MATCH_PARENT, keyBoardHeight);
		if(isOpened == false){
			if(onSoftKeyboardOpenCloseListener!=null)
				onSoftKeyboardOpenCloseListener.onKeyboardOpen(keyBoardHeight);
		}
		isOpened = true;
		if(pendingOpen){
			showAtBottom();
			pendingOpen = false;
		}
	}

	private int getUsableScreenHeight() {
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
	    	DisplayMetrics metrics = new DisplayMetrics();

	    	WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
	        windowManager.getDefaultDisplay().getMetrics(metrics);

	        return metrics.heightPixels;

	    } else {
	    	return rootView.getRootView().getHeight();
	    }
	}

	/**
	 * Manually setOrReplace the popup window size
	 * @param width Width of the popup
	 * @param height Height of the popup
	 */
	public void setSize(int width, int height){
		height = height < 100 ? 500 :height;
		Store.putInt(StoreConstants.KEYBOARD_SIZE,height);
		Helper.showMessage("KEYBOARD_SIZE "+height);
		setWidth(AndroidUtil.getScreenWidth());
		setHeight(height);
	}


//	public interface OnEmojiconBackspaceClickedListener {
//		void onEmojiconBackspaceClicked(View v);
//	}

	public interface OnSoftKeyboardOpenCloseListener{
		void onKeyboardOpen(int keyBoardHeight);
		void onKeyboardClose();
	}


	///////////////////////////////////////////////////////////
	/// statics for avoid memeory leak

	private static int getUsableScreenHeight2(View rootView) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			DisplayMetrics metrics = new DisplayMetrics();

			WindowManager windowManager = (WindowManager) AppUtil.getContext().getSystemService(Context.WINDOW_SERVICE);
			windowManager.getDefaultDisplay().getMetrics(metrics);

			return metrics.heightPixels;

		} else {
			return rootView.getRootView().getHeight();
		}
	}
	public static void setUpLayoutListnr(View rootView){
		OnGlobalLayoutListener layoutListener = new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				Context mContext = AppUtil.getContext();
				Rect r = new Rect();
				rootView.getWindowVisibleDisplayFrame(r);

				int screenHeight = getUsableScreenHeight2(rootView);
				int heightDifference = screenHeight
						- (r.bottom - r.top);
				int resourceId = mContext.getResources()
						.getIdentifier("status_bar_height",
								"dimen", "android");
				if (resourceId > 0) {
					heightDifference -= mContext.getResources()
							.getDimensionPixelSize(resourceId);
				}

				if(currentListner != null){
					if (heightDifference > 100) {
						currentListner.keyBoardHeight = heightDifference;
						currentListner.setSize(LayoutParams.MATCH_PARENT, currentListner.keyBoardHeight);
						if(currentListner.isOpened == false){
							if(currentListner.onSoftKeyboardOpenCloseListener!=null)
								currentListner.onSoftKeyboardOpenCloseListener.onKeyboardOpen(currentListner.keyBoardHeight);
						}
						currentListner.isOpened = true;
						if(currentListner.pendingOpen){
							currentListner.showAtBottom();
							currentListner.pendingOpen = false;
						}
					}
					else{
						currentListner.isOpened = false;
						if(currentListner.onSoftKeyboardOpenCloseListener!=null)
							currentListner.onSoftKeyboardOpenCloseListener.onKeyboardClose();
					}
				}


				/*if (heightDifference > 100) {
					keyBoardHeight = heightDifference;
					setSize(LayoutParams.MATCH_PARENT, keyBoardHeight);
					if(isOpened == false){
						if(onSoftKeyboardOpenCloseListener!=null)
							onSoftKeyboardOpenCloseListener.onKeyboardOpen(keyBoardHeight);
					}
					isOpened = true;
					if(pendingOpen){
						showAtBottom();
						pendingOpen = false;
					}
				}
				else{
					isOpened = false;
					if(onSoftKeyboardOpenCloseListener!=null)
						onSoftKeyboardOpenCloseListener.onKeyboardClose();
				}*/
			}
		};
		rootView.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
	}

	public static EmojiconsPopup currentListner;
}
