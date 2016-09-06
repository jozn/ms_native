package com.mardomsara.social.models.tables;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

/**
 * Created by Hamid on 9/4/2016.
 */
@Table
public class Room {
    
    @PrimaryKey(autoincrement = true)
    public int id;
    
    @Column(indexed = true)
    @NonNull
    public String RoomKey;

    @Column(defaultExpr = "1")
    public int RoomTypeId = 1;

    @Column(defaultExpr = "''")
    public String RoomName = "";//???????

    @Column(defaultExpr = "0")
    public int UseCustomRoomSettings = 0;

    @Column(defaultExpr = "0" , helpers = Column.Helpers.ALL)
    public long LastRoomOpenedTimeMs = 0;

    @Column(defaultExpr = "0", helpers = Column.Helpers.ALL)
    public int UnseenMessageCount = 0;

    @Column(defaultExpr = "''", helpers = Column.Helpers.CONDITION_EQ)
    public String LastSeenMessageKey = "";

    @Column(defaultExpr = "''")
    public String MessageDraftText = "";

    @Column(defaultExpr = "0" ,helpers = Column.Helpers.ALL)
    public long UpdatedMs = 0;

    @Column(defaultExpr = "0" , helpers = Column.Helpers.ALL)
    public long CreatedMs = 0;

    @Column(defaultExpr = "0" , indexed = true)
    public long SortTimeMs = 0;

    @Column(defaultExpr = "sssss")
    @NonNull
    public String HHHHH;

    @Column(defaultExpr = "Oh_Yeah_lo")
    @Nullable
    public String GGGG;
    
}
