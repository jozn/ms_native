package com.mardomsara.social.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Hamid on 2/13/2016.
 */
//@TableModelSpec(className = "ImageBinary",tableName = "image_binary")
@Table(name = "messages_thumbs",database = AppDB.class)
public class MessagesThumbsTable extends BaseModel {
    @PrimaryKey
    @NotNull
    public String MessageKey;

//    @Column
//    public byte[] ImageData;

    @Column(defaultValue = "\"\"")
    public String MediaThumb64;

}
