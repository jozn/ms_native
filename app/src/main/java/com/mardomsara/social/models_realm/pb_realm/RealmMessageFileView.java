package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;


public class RealmMessageFileView extends RealmObject {
		 @PrimaryKey 
		public long MessageFileId;//0 				 PB 1
		public String MessageFileKey;//1 				 PB 32
		public int OriginalUserId;//2 				 PB 2
		public String Name;//3 				 PB 3
		public int Size;//4 				 PB 5
		public int FileTypeEnumId;//5 				 PB 7
		public int Width;//6 				 PB 9
		public int Height;//7 				 PB 11
		public int Duration;//8 				 PB 13
		public String Extension;//9 				 PB 15
		public String HashMd5;//10 				 PB 17
		public long HashAccess;//11 				 PB 19
		public int CreatedSe;//12 				 PB 21
		public String ServerSrc;//13 				 PB 23
		public String ServerPath;//14 				 PB 25
		public String ServerThumbPath;//15 				 PB 27
		public String BucketId;//16 				 PB 29
		public int ServerId;//17 				 PB 31
		public int CanDel;//18 				 PB 33
		public String ServerThumbLocalSrc;//19 				 PB 50
		public long RemoteMessageFileId;//20 				 PB 100
		public String LocalSrc;//21 				 PB 101
		public String ThumbLocalSrc;//22 				 PB 104
		public String MessageFileStatusId;//23 				 PB 106
	

	public static RealmMessageFileView fromPB(PB_MessageFileView pb){
		RealmMessageFileView r = new RealmMessageFileView();
		
		r.MessageFileId = pb.getMessageFileId();//0
		r.MessageFileKey = pb.getMessageFileKey();//1
		r.OriginalUserId = pb.getOriginalUserId();//2
		r.Name = pb.getName();//3
		r.Size = pb.getSize();//4
		r.FileTypeEnumId = pb.getFileTypeEnumId();//5
		r.Width = pb.getWidth();//6
		r.Height = pb.getHeight();//7
		r.Duration = pb.getDuration();//8
		r.Extension = pb.getExtension();//9
		r.HashMd5 = pb.getHashMd5();//10
		r.HashAccess = pb.getHashAccess();//11
		r.CreatedSe = pb.getCreatedSe();//12
		r.ServerSrc = pb.getServerSrc();//13
		r.ServerPath = pb.getServerPath();//14
		r.ServerThumbPath = pb.getServerThumbPath();//15
		r.BucketId = pb.getBucketId();//16
		r.ServerId = pb.getServerId();//17
		r.CanDel = pb.getCanDel();//18
		r.ServerThumbLocalSrc = pb.getServerThumbLocalSrc();//19
		r.RemoteMessageFileId = pb.getRemoteMessageFileId();//20
		r.LocalSrc = pb.getLocalSrc();//21
		r.ThumbLocalSrc = pb.getThumbLocalSrc();//22
		r.MessageFileStatusId = pb.getMessageFileStatusId();//23

	    return r;
	}

}
	/*
	folding

	//sett
	RealmMessageFileView r = new RealmMessageFileView();
	
	r.MessageFileId = ;//0
	r.MessageFileKey = ;//1
	r.OriginalUserId = ;//2
	r.Name = ;//3
	r.Size = ;//4
	r.FileTypeEnumId = ;//5
	r.Width = ;//6
	r.Height = ;//7
	r.Duration = ;//8
	r.Extension = ;//9
	r.HashMd5 = ;//10
	r.HashAccess = ;//11
	r.CreatedSe = ;//12
	r.ServerSrc = ;//13
	r.ServerPath = ;//14
	r.ServerThumbPath = ;//15
	r.BucketId = ;//16
	r.ServerId = ;//17
	r.CanDel = ;//18
	r.ServerThumbLocalSrc = ;//19
	r.RemoteMessageFileId = ;//20
	r.LocalSrc = ;//21
	r.ThumbLocalSrc = ;//22
	r.MessageFileStatusId = ;//23

	//sett - no tag number 
	RealmMessageFileView r = new RealmMessageFileView();
	
	r.MessageFileId = ;
	r.MessageFileKey = ;
	r.OriginalUserId = ;
	r.Name = ;
	r.Size = ;
	r.FileTypeEnumId = ;
	r.Width = ;
	r.Height = ;
	r.Duration = ;
	r.Extension = ;
	r.HashMd5 = ;
	r.HashAccess = ;
	r.CreatedSe = ;
	r.ServerSrc = ;
	r.ServerPath = ;
	r.ServerThumbPath = ;
	r.BucketId = ;
	r.ServerId = ;
	r.CanDel = ;
	r.ServerThumbLocalSrc = ;
	r.RemoteMessageFileId = ;
	r.LocalSrc = ;
	r.ThumbLocalSrc = ;
	r.MessageFileStatusId = ;

	//get
	
	m. = r.MessageFileId ;//0
	m. = r.MessageFileKey ;//1
	m. = r.OriginalUserId ;//2
	m. = r.Name ;//3
	m. = r.Size ;//4
	m. = r.FileTypeEnumId ;//5
	m. = r.Width ;//6
	m. = r.Height ;//7
	m. = r.Duration ;//8
	m. = r.Extension ;//9
	m. = r.HashMd5 ;//10
	m. = r.HashAccess ;//11
	m. = r.CreatedSe ;//12
	m. = r.ServerSrc ;//13
	m. = r.ServerPath ;//14
	m. = r.ServerThumbPath ;//15
	m. = r.BucketId ;//16
	m. = r.ServerId ;//17
	m. = r.CanDel ;//18
	m. = r.ServerThumbLocalSrc ;//19
	m. = r.RemoteMessageFileId ;//20
	m. = r.LocalSrc ;//21
	m. = r.ThumbLocalSrc ;//22
	m. = r.MessageFileStatusId ;//23

	//get - no tag number
	
	m. = r.MessageFileId ;
	m. = r.MessageFileKey ;
	m. = r.OriginalUserId ;
	m. = r.Name ;
	m. = r.Size ;
	m. = r.FileTypeEnumId ;
	m. = r.Width ;
	m. = r.Height ;
	m. = r.Duration ;
	m. = r.Extension ;
	m. = r.HashMd5 ;
	m. = r.HashAccess ;
	m. = r.CreatedSe ;
	m. = r.ServerSrc ;
	m. = r.ServerPath ;
	m. = r.ServerThumbPath ;
	m. = r.BucketId ;
	m. = r.ServerId ;
	m. = r.CanDel ;
	m. = r.ServerThumbLocalSrc ;
	m. = r.RemoteMessageFileId ;
	m. = r.LocalSrc ;
	m. = r.ThumbLocalSrc ;
	m. = r.MessageFileStatusId ;
	
*/
