package com.mardomsara.social.models.tables;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Http.Req;
import com.mardomsara.social.base.Http.listener.DownloadProgressListener;
import com.mardomsara.social.base.Http.listener.UploadProgressListener;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.CacheBank;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.interfaces.MessageProgressListener;
import com.mardomsara.social.models.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models.memory_store.MemoryStore_Rooms;
import com.mardomsara.social.pipe_pb.from_net_calls.MsgsCallToServer;

import java.io.File;

/**
 * Created by Hamid on 9/4/2016.
 */
//TOdo; addStart: IsSeenByPeer() IsRe....
@Table
public class Message implements Comparable<Message>, UploadProgressListener, DownloadProgressListener {

	@PrimaryKey(auto = false, autoincrement = false)
	public long NanoId = 0;

	@Column(unique = true, indexed = true)
	@NonNull
	public String MessageKey;

	@Column(indexed = true)
	@NonNull
	public String RoomKey;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long UserId = 0;//-1: system

	@Column(defaultExpr = "1")
	public int RoomTypeId = 1;//1: peer-to-peer 2:private-group

	@Column(defaultExpr = "1", helpers = Column.Helpers.CONDITION_EQ)
	public int MessageTypeId = 1;//1: text,...

	@Column(defaultExpr = "''")
	public String Text = "";

	@Column(defaultExpr = "''")
	public String ExtraJson = "";

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public int IsByMe = 0;

	@Column(defaultExpr = "0")
	public int IsStared = 0;//REMOVE??????? its table????

	//// TODO: 2/6/2017 remove
	/*@Deprecated //use ToPush and other stuffs ServerReceivedTime ,...
	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITIONS)
    public int DeliveryStatus = 0;*///0:not-me  1: need-push 2: resic=ved-server 3:rc-clint; 4:seen-client 5: removed-server

	@Column(defaultExpr = "0", helpers = Column.Helpers.ALL)
	public long CreatedMs = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.ALL)
	public long CreatedDeviceMs = TimeUtil.getTimeMs();

	@Column(defaultExpr = "0", indexed = true)
	public long SortId = TimeUtil.getTimeNano();

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long PeerSeenTime = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long ServerReceivedTime = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long PeerReceivedTime = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long ServerDeletedTime = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long ISeenTime = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public int ToPush = 0;

	@Column(defaultExpr = "0", indexed = true)
	public String MsgFile_LocalSrc = "";

	@Deprecated //do we need this? reflect on it
	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public int MsgFile_Status = 0;

	//////////////////// End of sqilte columns ///////////////////
	public MsgFile MsgFile;//for json
	public transient Req req;
	//remember to unbind this when ViewRows is not attached to this
	public transient MessageProgressListener messageProgressListener;
	private boolean isNetWorkTransferring = false;

	public Message() {
		AppUtil.log("time: " + TimeUtil.getTimeNano());
	}

	public boolean needPush() {
		return ToPush == 1;//msg.MsgFile_Status == Constants.Msg_Media_To_Push_And_Upload
	}

	public void setToPush(int toPush) {
		ToPush = toPush;
		if (ToPush == 0) {
			setNetWorkTransferring(false);
		} else {

		}
	}

	public
	@Nullable
	MsgFile getMsgFile() {
		if (MsgFile == null) {
			MsgFile = DB.db.selectFromMsgFile().LocalSrcEq(MsgFile_LocalSrc).getOrNull(0);
		}
		return MsgFile;
	}

	public
	@NonNull
	MsgFile getOrCreateMsgFile() {
		MsgFile = getMsgFile();
		if (MsgFile == null) {
			MsgFile = new MsgFile();
		}
		return MsgFile;
	}

	public boolean isMsgByMe() {
		return IsByMe == 1;
	}

	public boolean isNetWorkTransferring() {
		return isNetWorkTransferring;
	}

	public void setNetWorkTransferring(boolean netWorkTransferring) {
		isNetWorkTransferring = netWorkTransferring;
		if (messageProgressListener != null) {
			messageProgressListener.onStatusChanged();
		}
	}

	;

	public void cancelUploading() {
		Helper.showDebugMessage("cancelUploading ");
		setNetWorkTransferring(false);
		if (req != null) {
			req.cancel();
		}
	}

	;

	public void retryUploading() {
		Helper.showDebugMessage("upload ");
		setNetWorkTransferring(true);
		AndroidUtil.runInBackgroundNoPanic(() -> {
//			if(MessageTypeId == Constants.MESSAGE_IMAGE){
			File file = new File(MsgFile_LocalSrc);
			MsgsCallToServer.sendNewPhoto(this, file, null, false);
//			}
		});
	}

	;

	public void cancelDownloading() {
		setNetWorkTransferring(false);
		if (req != null) {
			req.cancel();
		}
	}


	/////////////////////////////////////////
	///////////////// Helpers? //////////////

	public void retryDownloading() {
		Helper.showDebugMessage("retryDownloading");
		setNetWorkTransferring(true);
		MessageModel.downloadForceMessageMediaFile(this);
	}

	public boolean isReceivedToPeer() {
		return (PeerReceivedTime > 0);
	}

	public boolean issSeenByPeer() {
		return (PeerSeenTime > 0);
	}

	public boolean isReceivedToServer() {
		return (ServerReceivedTime > 0);
	}

	public boolean isDeletedFromServer() {
		return (ServerDeletedTime > 0);
	}

	private void onBeforeSave() {
		if (NanoId == 0) {
			NanoId = TimeUtil.getTimeNano();// * 10000+( (long)(Math.random()*10000));
		}

		if (SortId <1) {
			SortId = TimeUtil.getTimeNano();// * 10000+( (long)(Math.random()*10000));
		}

		MemoryStore_LastMsgs.set(this);
		CacheBank.getMessage().put(MessageKey,this);

	}

	private void onAfterSave() {
		Room room = MemoryStore_Rooms.getOrNull(RoomKey);
		room = RoomModel.onReceivedNewMsg_NotSave(this, room);
		if (room.SortTimeMs < CreatedDeviceMs) {
			room.SortTimeMs = CreatedDeviceMs;
		}
		room.saveAndEmit();
	}

	/////////// Saves funcs ///////////
	public void saveWithRoom() {
		onBeforeSave();
		trySaveMsgFile();
		DB.db.prepareInsertIntoMessage(OnConflict.REPLACE, true).execute(this);
		onAfterSave();
	}

	public void save() {
		onBeforeSave();
		trySaveMsgFile();
		DB.db.prepareInsertIntoMessage(OnConflict.REPLACE, true).execute(this);
//		onAfterSave();
	}

	public void insertInBackground() {
		onBeforeSave();
		trySaveMsgFile();
		AndroidUtil.runInBackgroundNoPanic(() -> DB.db.prepareInsertIntoMessage(OnConflict.ABORT, true).execute(this));
	}

	private void trySaveMsgFile() {
		if (MsgFile != null) {
			MsgFile_LocalSrc = MsgFile.LocalSrc;
			MsgFile_Status = MsgFile.Status;
			MsgFile.save();
		}
	}

	/// all instances are equal based on MessageKey
	@Override
	public int hashCode() {
		if (MessageKey != null) {
			return MessageKey.hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (MessageKey != null) {
			return MessageKey.equals(obj);
		}
		return super.equals(obj);
	}

	@Override
	public int compareTo(Message msg) {
		if (msg == null) return 1;

		if (NanoId == msg.NanoId) return 0;

		return (NanoId > msg.NanoId) ? 1 : -1;
	}

	public void setMsgFile_Status(int msgFile_Status) {
		MsgFile_Status = msgFile_Status;
		if (getMsgFile() != null) {
			MsgFile.Status = msgFile_Status;
		}
	}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
		if (messageProgressListener != null) {
			messageProgressListener.onProgress(bytesRead, contentLength, done);
		}
	}

	@Override
	public void onUploadProgress(long bytesRead, long contentLength, boolean done) {
		if (messageProgressListener != null) {
			messageProgressListener.onProgress(bytesRead, contentLength, done);
		}
	}
}
