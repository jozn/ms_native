package com.mardomsara.social.models.tables;

import android.support.annotation.NonNull;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.app.DB;

/**
 * Created by Hamid on 9/4/2016.
 */
//TOdo; add: IsSeenByPeer() IsRe....
@Table
public class Message {

//    @PrimaryKey(autoincrement = true)
//    public int id;

//    @Column(unique = true, indexed = true)
    @PrimaryKey(auto = false)
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
    public long CreatedDeviceMs = 0;

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
    public int PeerSeenTime = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int ServerReceivedTime = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int PeerReceivedTime = 0;

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
    public int ServerDeletedTime = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.CONDITION_EQ)
    public int ToPush = 0;

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.CONDITION_EQ)
    public int MediaStatus=0;

    /// Media
    @Column(defaultExpr = "''")
    public String MediaThumb64 = "";

    @Column(defaultExpr = "''")
    public String MediaName = "";

    @Column(defaultExpr = "''" , helpers = Column.Helpers.CONDITION_EQ)
    public String MediaLocalSrc = "";

    @Column(defaultExpr = "''" , helpers = Column.Helpers.CONDITION_EQ)
    public String MediaServerSrc = "";

    @Column(defaultExpr = "0")
    public int MediaSize = 0;

    @Column(defaultExpr = "0")
    public int MediaDuration = 0;

    @Column(defaultExpr = "0")
    public int MediaHeight = 0;

    @Column(defaultExpr = "0")
    public int MediaWidth = 0;

    @Column(defaultExpr = "''")
    public String MediaExtension = "";


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

    public void save() {
        DB.db.prepareInsertIntoMessage(OnConflict.REPLACE,true).execute(this);
    }

    public void insert() {
        DB.db.prepareInsertIntoMessage(OnConflict.ABORT,true).execute(this);
    }
}
