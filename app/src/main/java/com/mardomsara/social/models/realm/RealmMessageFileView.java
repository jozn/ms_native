package com.mardomsara.social.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hamid on 8/21/2017.
 */

public class RealmMessageFileView  extends RealmObject{
	@PrimaryKey
	public long MessageFileId;
	public String Name;
	public int Size;
	public int FileTypeEnum;
	public String MimeType;
	public int Width;
	public int Height;
	public int Duration;
	public String Extension;
	public String ThumbData64;
	public String ServerSrc;
	public String ServerPath;
	public String ServerThumbPath;
	public String BucketId;
	public int ServerId;
	public int CanDel;
	public int CreatedTime;
}
