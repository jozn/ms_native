/*
 * Copyright 2015, Yahoo Inc.
 * Copyrights licensed under the Apache 2.0 License.
 * See the accompanying LICENSE file for terms.
 */
package com.mardomsara.social.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDB.class,name = "tasks")
public class Task extends BaseModel{
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @PrimaryKey(autoincrement = true)
    public int tid;

    @Column(defaultValue = "\"\"")
    public String title;

    @Column(defaultValue = "\"foo\"")
    public String title2;

    @Column(defaultValue = "18")
   public int time;

    @Column(defaultValue = "\"11\"")
    public long timeLong;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column()
    public long userId;

    public long getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(long timeLong) {
        this.timeLong = timeLong;
    }
}
