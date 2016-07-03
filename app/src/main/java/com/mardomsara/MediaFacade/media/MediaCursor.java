package com.mardomsara.MediaFacade.media;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.Build;

/**
 * Created by Hamid on 6/17/2016.
 */
public interface MediaCursor extends Cursor {
	long id();

	String displayName();

	String data();

	long size();

	String mimeType();

	long duration();

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	long width();

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	long height();

	long createdAt();

	long updatedAt();
	public String bucketName();
	String bucketId();
}
