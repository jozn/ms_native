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

	//sett
	RealmMessageFileView r = new RealmMessageFileView();
	
	r.MessageFileId = ;//0
	r.Name = ;//1
	r.Size = ;//2
	r.FileTypeEnum = ;//3
	r.MimeType = ;//4
	r.Width = ;//5
	r.Height = ;//6
	r.Duration = ;//7
	r.Extension = ;//8
	r.ThumbData64 = ;//9
	r.ServerSrc = ;//10
	r.ServerPath = ;//11
	r.ServerThumbPath = ;//12
	r.BucketId = ;//13
	r.ServerId = ;//14
	r.CanDel = ;//15
	r.CreatedTime = ;//16

	//sett - no tag number 
	RealmMessageFileView r = new RealmMessageFileView();
	
	r.MessageFileId = ;
	r.Name = ;
	r.Size = ;
	r.FileTypeEnum = ;
	r.MimeType = ;
	r.Width = ;
	r.Height = ;
	r.Duration = ;
	r.Extension = ;
	r.ThumbData64 = ;
	r.ServerSrc = ;
	r.ServerPath = ;
	r.ServerThumbPath = ;
	r.BucketId = ;
	r.ServerId = ;
	r.CanDel = ;
	r.CreatedTime = ;

	//get
	
	m. = r.MessageFileId ;//0
	m. = r.Name ;//1
	m. = r.Size ;//2
	m. = r.FileTypeEnum ;//3
	m. = r.MimeType ;//4
	m. = r.Width ;//5
	m. = r.Height ;//6
	m. = r.Duration ;//7
	m. = r.Extension ;//8
	m. = r.ThumbData64 ;//9
	m. = r.ServerSrc ;//10
	m. = r.ServerPath ;//11
	m. = r.ServerThumbPath ;//12
	m. = r.BucketId ;//13
	m. = r.ServerId ;//14
	m. = r.CanDel ;//15
	m. = r.CreatedTime ;//16

	//get - no tag number
	
	m. = r.MessageFileId ;
	m. = r.Name ;
	m. = r.Size ;
	m. = r.FileTypeEnum ;
	m. = r.MimeType ;
	m. = r.Width ;
	m. = r.Height ;
	m. = r.Duration ;
	m. = r.Extension ;
	m. = r.ThumbData64 ;
	m. = r.ServerSrc ;
	m. = r.ServerPath ;
	m. = r.ServerThumbPath ;
	m. = r.BucketId ;
	m. = r.ServerId ;
	m. = r.CanDel ;
	m. = r.CreatedTime ;
	
*/
