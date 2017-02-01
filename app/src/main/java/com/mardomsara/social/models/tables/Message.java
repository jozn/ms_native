package com.mardomsara.social.models.tables;

import android.support.annotation.NonNull;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.memory_store.MemoryStore_LastMsgs;
import com.mardomsara.social.models.memory_store.MemoryStore_Rooms;

/**
 * Created by Hamid on 9/4/2016.
 */
//TOdo; addStart: IsSeenByPeer() IsRe....
@Table
public class Message  implements Comparable<Message> {

	@PrimaryKey(auto = false,autoincrement = false)
	public long NanoId = 0;

    @Column(unique = true, indexed = true)
    @NonNull
    public String MessageKey;

    @Column(indexed = true)
    @NonNull
    public String RoomKey;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int UserId =0 ;//-1: system

    @Column(defaultExpr = "1")
    public int RoomTypeId = 1;//1: peer-to-peer 2:private-group

    @Column(defaultExpr = "1",helpers = Column.Helpers.CONDITION_EQ)
    public int MessageTypeId = 1;//1: text,...

    @Column(defaultExpr = "''")
    public String Text = "";

    @Column(defaultExpr = "''")
    public String ExtraJson = "";

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int IsByMe =0 ;

    @Column(defaultExpr = "0")
    public int IsStared =0;//REMOVE??????? its table????

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITIONS)
    public int DeliveryStatus = 0;//0:not-me  1: need-push 2: resic=ved-server 3:rc-clint; 4:seen-client 5: removed-server

    @Column(defaultExpr = "0", helpers = Column.Helpers.ALL)
    public long CreatedMs = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.ALL)
    public long CreatedDeviceMs = TimeUtil.getTimeMs();

    @Column(defaultExpr = "0", indexed = true)
    public long SortId = TimeUtil.getTimeNano();

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
    public long PeerSeenTime = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public long ServerReceivedTime = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public long PeerReceivedTime = 0;

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
    public long ServerDeletedTime = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int ToPush = 0;

	@Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
	public long ISeenTime = 0;

	@Column(defaultExpr = "0" ,indexed = true)
	public String MsgFile_LocalSrc= "";

	public MsgFile msgFile;

	@Deprecated
    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
    public int MediaStatus=0;

	@Deprecated
    /// Media
    @Column(defaultExpr = "''")
    public String MediaThumb64 = "";

	@Deprecated
    @Column(defaultExpr = "''")
    public String MediaName = "";

	@Deprecated
    @Column(defaultExpr = "''" , helpers = Column.Helpers.CONDITION_EQ)
    public String MediaLocalSrc = "";

	@Deprecated
    @Column(defaultExpr = "''" , helpers = Column.Helpers.CONDITION_EQ)
    public String MediaServerSrc = "";

	@Deprecated
    @Column(defaultExpr = "0")
    public int MediaSize = 0;

	@Deprecated
    @Column(defaultExpr = "0")
    public int MediaDuration = 0;

	@Deprecated
    @Column(defaultExpr = "0")
    public int MediaHeight = 0;

	@Deprecated
    @Column(defaultExpr = "0")
    public int MediaWidth = 0;

	@Deprecated
    @Column(defaultExpr = "''")
    public String MediaExtension = "";

    public Message() {
        AppUtil.log("time: "+ TimeUtil.getTimeNano());
    }


    /////////////////////////////////////////
    ///////////////// Helpers? //////////////

    public boolean isReceivedToPeer() {
        return (PeerReceivedTime > 0 );
    }

    public boolean issSeenByPeer() {
        return (PeerSeenTime > 0 );
    }

    public boolean isReceivedToServer() {
        return (ServerReceivedTime > 0 );
    }

    public boolean isDeletedFromServer() {
        return (ServerDeletedTime > 0 );
    }

	private void onBeforeSave(){
		if(NanoId == 0){
			NanoId = TimeUtil.getTimeNano();// * 10000+( (long)(Math.random()*10000));
		}

		MemoryStore_LastMsgs.set(this);
	}

	private void onAfterSave(){
		Room room = MemoryStore_Rooms.getOrNull(RoomKey);
		room = RoomModel.onReceivedNewMsg3_NotSave(this,room);
		if(room.SortTimeMs < CreatedDeviceMs){
			room.SortTimeMs = CreatedDeviceMs;
		}
		room.saveAndEmit();
	}
    public void saveWithRoom() {
		onBeforeSave();
        DB.db.prepareInsertIntoMessage(OnConflict.REPLACE,true).execute(this);
		onAfterSave();
    }

	public void save() {
		onBeforeSave();
		DB.db.prepareInsertIntoMessage(OnConflict.REPLACE,true).execute(this);
//		onAfterSave();
	}

    public void insertInBackground() {
		onBeforeSave();
        AndroidUtil.runInBackgroundNoPanic(()->DB.db.prepareInsertIntoMessage(OnConflict.ABORT,true).execute(this));
    }


	/// all instances are equal based on MessageKey
	@Override
	public int hashCode() {
		if(MessageKey != null){
			return MessageKey.hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(MessageKey != null){
			return MessageKey.equals(obj);
		}
		return super.equals(obj);
	}

	@Override
	public int compareTo(Message msg) {
		if(msg == null) return 1;

		if(NanoId == msg.NanoId) return 0;

		return (NanoId > msg.NanoId) ? 1 : -1;
	}
}
