package com.mardomsara.social.app;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by Hamid on 11/5/2017.
 */

public class ContextHolder {
	public ContextHolder(Context context) {
		setContext(context);
	}

	WeakReference<Context> contextWeakReference;

	public Context getContext() {
		return contextWeakReference.get();
	}

	public void setContext(Context context) {
		contextWeakReference = new WeakReference<Context>(context);
	}

}
