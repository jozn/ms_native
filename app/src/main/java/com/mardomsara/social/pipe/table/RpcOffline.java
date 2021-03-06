package com.mardomsara.social.pipe.table;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

@Table
public class RpcOffline {
	@PrimaryKey(auto = false, onConflict = OnConflict.REPLACE)
	public long ClientCallId;

	@Column(indexed = true, unique = true, uniqueOnConflict = OnConflict.REPLACE)
	public String CommandKey;

	@Column(indexed = true)
	public String RpcMethod;

	@Column()
	public byte[] Blob;

	@Column()
	public long CreatedMs;
}
