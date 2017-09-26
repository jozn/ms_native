package com.mardomsara.social.models_old.realm_old_no_cloud;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RowRoom extends RealmObject implements Comparable<RowRoom> {

	@PrimaryKey
	@NonNull
	public String RoomKey;

	public int RoomTypeId = 1;

	public String RoomName = "";//???????

	public int UseCustomRoomSettings = 0;

	public long LastRoomOpenedTimeMs = 0;

	public long LastSeenTimeMs = 0;

	public int UnseenMessageCount = 0;

	public String LastSeenMessageKey = "";

	public String MessageDraftText = "";

	public long UpdatedMs = 0;

	public long CreatedMs = 0;

	public long SortTimeMs = 0;

	@Override
	public int compareTo(RowRoom room) {
		if (room == null) return 1;

		if (SortTimeMs == room.SortTimeMs) return 0;

		return (SortTimeMs > room.SortTimeMs) ? 1 : -1;
	}
}
