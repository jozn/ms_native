package com.mardomsara.social.models.tables;

import android.support.annotation.NonNull;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.Session;

@Table
public class MsgSeen {

	@PrimaryKey(auto = false)
	public long NanoId = 0;

	@Column(defaultExpr = "0")
	public int ByUserId = Session.getUserId();

	@Column(defaultExpr = "")
	@NonNull
	public String MsgKey="";

	@NonNull
	@Column(defaultExpr = "0")
	public String RoomKey="";

	@Column(defaultExpr = "0")
	public long AtTime = TimeUtil.getTime();
}