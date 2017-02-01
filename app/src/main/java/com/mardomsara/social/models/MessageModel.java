package com.mardomsara.social.models;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

import com.mardomsara.social.App;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.ImageUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.helpers.VideoMetasHelper;
import com.mardomsara.social.models.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.MsgFile;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.pipe.from_net_calls.MsgsCallToServer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 9/5/2016.
 */
public class MessageModel {
     public final static int MSGS_PER_PAGE = 30;

    public static @NonNull List<Message> getRoomMessagesTimeOffset(String roomKey, long deviceCreatedTimeOffset){
        /*AndroidUtil.runInBackgroundNoPanic(()->{
            DB.db.getConnection().execSQL("update Message setOrReplace SortId = CreatedDeviceMs * 1000000");
        });*/
        if(deviceCreatedTimeOffset <= 0){
            return DB.db.selectFromMessage().RoomKeyEq(roomKey).orderBySortIdDesc().limit(MSGS_PER_PAGE).toList();
        }
        return DB.db.selectFromMessage().RoomKeyEq(roomKey).SortIdLt(deviceCreatedTimeOffset).orderBySortIdDesc().limit(MSGS_PER_PAGE).toList();
    }

    private static List<Message> getAllRoomsMessages(String roomKey) {
        return DB.db.selectFromMessage().RoomKeyEq(roomKey).orderByCreatedDeviceMsDesc().toList();
    }

    public static Message getMessageByKey(String msgKey) {
        return DB.db.selectFromMessage().MessageKeyEq(msgKey).getOrNull(0);
    }

    public static Message newTextMsgForRoom_ByMe(@NonNull Room room) {
        Message msg = new Message();
        msg.RoomKey = room.RoomKey;
        msg.DeliveryStatus = 0;
        msg.IsByMe = 1;
        msg.RoomTypeId = room.RoomTypeId;
        msg.CreatedMs = AppUtil.getTimeMs();
        msg.CreatedDeviceMs = AppUtil.getTimeMs();
        msg.MessageTypeId = Constants.MESSAGE_TEXT;
        msg.UserId = Session.getUserId();
        msg.MessageKey = generateMessageKey();
        msg.ToPush = 1;
        return msg;
    }

    public static String generateMessageKey(){
        return ""+Session.getUserId()+"@:"+LangUtil.getRandomString(10);
    }

    public static  void setParamsForNewMsgRecivedFromNet(Message msg){
        msg.CreatedDeviceMs = TimeUtil.getTimeMs();
        msg.IsByMe = 0;
        msg.ToPush = 0;
        msg.MsgFile_Status =0 ;
    }

    public static void syncToServer(@NonNull Message msg ) {
		MsgsCallToServer.addNewMsg(msg);
    }

    public static void clearAllMessagesOfRoom_BG(String roomKey){
        AndroidUtil.runInBackgroundNoPanic(()->{
            List<Message> msgs = getAllRoomsMessages(roomKey);
            for(Message msg : msgs){
                if(msg.getMsgFile() != null){
					FileUtil.tryDelete(msg.getMsgFile().LocalSrc);
				}
            }
            List<String> listMsgs = new ArrayList<String>();
            for(Message msg : msgs){
                listMsgs.add(msg.MessageKey);
            }
            DB.db.deleteFromMessage().MessageKeyIn(listMsgs).execute();
			MemoryStore_LastMsgs.removeForRoom(roomKey);
        });
    }

    //FIXME : after updates of events
    public static void publishMsgGeneralChangeEvent(Message msg) {
/*        MsgGeneralChangeChangeEvent meta = new MsgGeneralChangeChangeEvent(msg);
        EventBus.getDefault().post(meta);*/
    }

	public static void setPhotoParams(Message msg, String filePath) {
		try {
			MsgFile msgFile = msg.getOrCreateMsgFile();
			File file = new File(filePath);
			msg.MsgFile_LocalSrc = filePath;
			Bitmap mBitmap = BitmapFactory.decodeFile(filePath);
			msgFile.Thumb64 = ImageUtil.blurThumbnailToBase64(mBitmap);
			msgFile.Height = mBitmap.getHeight();
			msgFile.Width = mBitmap.getWidth();
			msgFile.LocalSrc = filePath;
			msgFile.Size = (int)file.length();
			msgFile.Name = file.getName();
			msgFile.Duration = 0;
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void setVideoParams(Message msg1, String thumbPath, String videoPath) {
		try {
			MsgFile msgFile = msg1.getOrCreateMsgFile();
			File fileVideo = new File(videoPath);

			VideoMetasHelper meta = new VideoMetasHelper(videoPath);

			msgFile.Height = meta.getVideoHeight();
			msgFile.Width = meta.getVideoWidth();
			msgFile.LocalSrc = videoPath;
			msgFile.Size = (int)fileVideo.length();
			msgFile.Name = fileVideo.getName();
			msgFile.Extension = FileUtil.getFileExtensionWithDot(videoPath);
			msgFile.Duration = meta.getVideoLength();

			//Extra
			setVideoExtraParams(msgFile,videoPath);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void setVideoExtraParams(MsgFile msgFile, String videoPath) {
		String $thumbPath = AppFiles.VIDEO_THUMB_DIR_PATH + FormaterUtil.getFullyYearToSecondsSolarName() +"$" + msgFile.Extension;
		String thumbPath = FileUtil.createNextName($thumbPath);

		File fileThumb = new File(thumbPath);
		Bitmap bitmap = ImageUtil.createVideoThumbnail(videoPath, 1024,360);
		if(bitmap != null){
			ImageUtil.saveToFile(bitmap,thumbPath);
		}
		Bitmap thumbBitmap = bitmap;//BitmapFactory.decodeFile(thumbPath);
		if(thumbBitmap != null){
			msgFile.ThumbLocalSrc = thumbPath;
			msgFile.ThumbHeight = thumbBitmap.getHeight();
			msgFile.ThumbWidth = thumbBitmap.getWidth();
			msgFile.ThumbSize = (int) fileThumb.length();
//			msgFile.ExtraJson = JsonUtil.toJson(extr);
			msgFile.Thumb64 = ImageUtil.blurThumbnailToBase64(thumbBitmap);
		}
	}

    public static void didMsgAddedByMe(@NonNull Message msg) {
        RoomModel.onByMeNewMsg(msg);
        App.getBus().post(msg);
    }
}