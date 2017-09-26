package com.mardomsara.social.models_realm.helpers;

import android.support.annotation.NonNull;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.AppRealm;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.Req;
import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.models_old.tables.Message;
import com.mardomsara.social.models_old.tables.MsgFile;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;

import java.io.File;

/**
 * Created by Hamid on 9/20/2017.
 */

public class HelperMessageFile {
	public static Req downloadForceMessageMediaFile(String serverSrc, String localSrc, DownloadProgressListener listener) {
//		AndroidUtil.runInBackgroundNoPanic(() -> {
			File file = new File(localSrc);
			if(file.exists()) return null;
			return Http.download(serverSrc, localSrc)
				.setDownloadProgress(listener)
				.doAsyncDownload((result -> {
					/*if(result.isOk()){
						msgFile.Status = Constants.Msg_Media_Downloaded;
						msgFile.Origin = Constants.Msg_Media_Origin_Server;
						msg.saveWithRoom();
					}
					msg.setNetWorkTransferring(false);*/
				}));

//		});
	}

	public static void setLocalPathInNecessary(RealmMessageFileView msgFile) {
		if (msgFile.LocalSrc == null || msgFile.LocalSrc.equals("")) {
//			String $fileName = AppFiles.PHOTO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() + "$" + msgFile.Extension;
			String $fileName = AppFiles.PHOTO_DIR_PATH + msgFile.MessageFileId + msgFile.Extension;
			String fileName = FileUtil.createNextName($fileName);
			AppRealm.getChatRealm().executeTransaction((r) -> {
				msgFile.LocalSrc = fileName;
			});
		}
	}

	public static void downloadForceMessageMediaFile(@NonNull Message msg) {
		AndroidUtil.runInBackgroundNoPanic(() -> {
			MsgFile msgFile = msg.getMsgFile();
			File file = new File(msgFile.LocalSrc);
			Http.download(msgFile.ServerSrc, msgFile.LocalSrc)
				.setDownloadProgress(msg)
				.doAsyncDownload((result -> {
					if (result.isOk()) {
						msgFile.Status = Constants.Msg_Media_Downloaded;
						msgFile.Origin = Constants.Msg_Media_Origin_Server;
						msg.saveWithRoom();
					}
					msg.setNetWorkTransferring(false);
				}));
		});
	}
}
