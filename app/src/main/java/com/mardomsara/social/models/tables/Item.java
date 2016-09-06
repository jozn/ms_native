package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

@Table
public class Item {

    @PrimaryKey
    public int id;

    @Column
    public String name;

    @Column
    public int time;

    @Column
    public int userId;

}