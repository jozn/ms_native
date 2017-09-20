package com.mardomsara.social.models_realm.helpers;

import android.support.annotation.NonNull;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.MSRealm;
import com.mardomsara.social.base.Http.Http;
import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.models_realm.pb_realm.RealmMessageFileView;

import java.io.File;

/**
 * Created by Hamid on 9/20/2017.
 */

public class HelperMessageFile {
	public static void downloadForceMessageMediaFile(String serverSrc, String localSrc, DownloadProgressListener listener){
		AndroidUtil.runInBackgroundNoPanic(()->{
			File file = new File(localSrc);
			Http.download(serverSrc,localSrc)
				.setDownloadProgress(listener)
				.doAsyncDownload((result -> {
					/*if(result.isOk()){
						msgFile.Status = Constants.Msg_Media_Downloaded;
						msgFile.Origin = Constants.Msg_Media_Origin_Server;
						msg.saveWithRoom();
					}
					msg.setNetWorkTransferring(false);*/
				}));
		});
	}

	public static void setLoacPathInNeccocery(RealmMessageFileView msgFile){
		String $fileName = AppFiles.PHOTO_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() + "$" + msgFile.Extension;
		String fileName = FileUtil.createNextName($fileName);
		MSRealm.getChatRealm().executeTransaction((r)->{
			msgFile.LocalSrc = fileName;
		});
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
