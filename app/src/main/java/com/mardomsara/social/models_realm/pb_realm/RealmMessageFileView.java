package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;



public class RealmMessageFileView extends RealmObject {
		 @PrimaryKey 
		public long MessageFileId;//0 				 PB 1
		public String Name;//1 				 PB 3
		public int Size;//2 				 PB 5
		public int FileTypeEnum;//3 				 PB 7
		public String MimeType;//4 				 PB 9
		public int Width;//5 				 PB 11
		public int Height;//6 				 PB 13
		public int Duration;//7 				 PB 15
		public String Extension;//8 				 PB 17
		public String ThumbData64;//9 				 PB 21
		public String ServerSrc;//10 				 PB 23
		public String ServerPath;//11 				 PB 25
		public String ServerThumbPath;//12 				 PB 27
		public String BucketId;//13 				 PB 29
		public int ServerId;//14 				 PB 31
		public int CanDel;//15 				 PB 33
		public int CreatedTime;//16 				 PB 35
	

	public static RealmMessageFileView fromPB(PB_MessageFileView pb){
		RealmMessageFileView r = new RealmMessageFileView();
		
	    r.MessageFileId = pb.getMessageFileId();//0
	    r.Name = pb.getName();//1
	    r.Size = pb.getSize();//2
	    r.FileTypeEnum = pb.getFileTypeEnum();//3
	    r.MimeType = pb.getMimeType();//4
	    r.Width = pb.getWidth();//5
	    r.Height = pb.getHeight();//6
	    r.Duration = pb.getDuration();//7
	    r.Extension = pb.getExtension();//8
	    r.ThumbData64 = pb.getThumbData64();//9
	    r.ServerSrc = pb.getServerSrc();//10
	    r.ServerPath = pb.getServerPath();//11
	    r.ServerThumbPath = pb.getServerThumbPath();//12
	    r.BucketId = pb.getBucketId();//13
	    r.ServerId = pb.getServerId();//14
	    r.CanDel = pb.getCanDel();//15
	    r.CreatedTime = pb.getCreatedTime();//16

	    return r;
	}

}
	/*
	folding

	PBFlatTypes.PB_MessageFileView t = new PBFlatTypes.PB_MessageFileView();
    t.MessageFileId = pb.getMessageFileId();
    t.Name = pb.getName();
    t.Size = pb.getSize();
    t.FileTypeEnum = pb.getFileTypeEnum();
    t.MimeType = pb.getMimeType();
    t.Width = pb.getWidth();
    t.Height = pb.getHeight();
    t.Duration = pb.getDuration();
    t.Extension = pb.getExtension();
    t.ThumbData64 = pb.getThumbData64();
    t.ServerSrc = pb.getServerSrc();
    t.ServerPath = pb.getServerPath();
    t.ServerThumbPath = pb.getServerThumbPath();
    t.BucketId = pb.getBucketId();
    t.ServerId = pb.getServerId();
    t.CanDel = pb.getCanDel();
    t.CreatedTime = pb.getCreatedTime();
	*/

	/*
	PBFlatTypes.PB_MessageFileView t = new PBFlatTypes.PB_MessageFileView();
	t.MessageFileId = ;
	t.Name = ;
	t.Size = ;
	t.FileTypeEnum = ;
	t.MimeType = ;
	t.Width = ;
	t.Height = ;
	t.Duration = ;
	t.Extension = ;
	t.ThumbData64 = ;
	t.ServerSrc = ;
	t.ServerPath = ;
	t.ServerThumbPath = ;
	t.BucketId = ;
	t.ServerId = ;
	t.CanDel = ;
	t.CreatedTime = ;
	*/

	/*
	PB_MessageFileView t = new PB_MessageFileView();
	t.MessageFileId = m.getMessageFileId() ;
	t.Name = m.getName() ;
	t.Size = m.getSize() ;
	t.FileTypeEnum = m.getFileTypeEnum() ;
	t.MimeType = m.getMimeType() ;
	t.Width = m.getWidth() ;
	t.Height = m.getHeight() ;
	t.Duration = m.getDuration() ;
	t.Extension = m.getExtension() ;
	t.ThumbData64 = m.getThumbData64() ;
	t.ServerSrc = m.getServerSrc() ;
	t.ServerPath = m.getServerPath() ;
	t.ServerThumbPath = m.getServerThumbPath() ;
	t.BucketId = m.getBucketId() ;
	t.ServerId = m.getServerId() ;
	t.CanDel = m.getCanDel() ;
	t.CreatedTime = m.getCreatedTime() ;
	
*/
