package com.mardomsara.social.models_realm.helpers;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.ImageUtil;

/**
 * Created by Hamid on 9/26/2017.
 */

public class HelperMessageFilePather {
	public static String getMessageFileOutputNameForNewSentImage(long messageFileId, String extiontion){
		return AppFiles.PHOTO_SENT_DIR_PATH + "IMG_" + FormaterUtil.getFullyYearToSecondsSolarNameFrom(messageFileId/1000_000) +"("+ messageFileId +")"+ extiontion ;//"$.jpg";
	}
}
