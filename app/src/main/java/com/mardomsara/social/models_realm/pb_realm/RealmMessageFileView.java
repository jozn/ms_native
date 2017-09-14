package com.mardomsara.social.models_realm.pb_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ir.ms.pb.*;


public class RealmMessageFileView extends RealmObject {
		 @PrimaryKey 
		public long MessageFileId;//0 				 PB 1
		public int OriginalUserId;//1 				 PB 2
		public String Name;//2 				 PB 3
		public int Size;//3 				 PB 5
		public int FileTypeEnumId;//4 				 PB 7
		public int Width;//5 				 PB 9
		public int Height;//6 				 PB 11
		public int Duration;//7 				 PB 13
		public String Extension;//8 				 PB 15
		public String HashMd5;//9 				 PB 17
		public long HashAccess;//10 				 PB 19
		public int CreatedSe;//11 				 PB 21
		public String ServerSrc;//12 				 PB 23
		public String ServerPath;//13 				 PB 25
		public String ServerThumbPath;//14 				 PB 27
		public String BucketId;//15 				 PB 29
		public int ServerId;//16 				 PB 31
		public int CanDel;//17 				 PB 33
		public String ServerThumbLocalSrc;//18 				 PB 50
		public long RemoteMessageFileId;//19 				 PB 100
		public String LocalSrc;//20 				 PB 101
		public String ThumbLocalSrc;//21 				 PB 104
		public String MessageFileStatusId;//22 				 PB 106
	

	public static RealmMessageFileView fromPB(PB_MessageFileView pb){
		RealmMessageFileView r = new RealmMessageFileView();
		
		r.MessageFileId = pb.getMessageFileId();//0
		r.OriginalUserId = pb.getOriginalUserId();//1
		r.Name = pb.getName();//2
		r.Size = pb.getSize();//3
		r.FileTypeEnumId = pb.getFileTypeEnumId();//4
		r.Width = pb.getWidth();//5
		r.Height = pb.getHeight();//6
		r.Duration = pb.getDuration();//7
		r.Extension = pb.getExtension();//8
		r.HashMd5 = pb.getHashMd5();//9
		r.HashAccess = pb.getHashAccess();//10
		r.CreatedSe = pb.getCreatedSe();//11
		r.ServerSrc = pb.getServerSrc();//12
		r.ServerPath = pb.getServerPath();//13
		r.ServerThumbPath = pb.getServerThumbPath();//14
		r.BucketId = pb.getBucketId();//15
		r.ServerId = pb.getServerId();//16
		r.CanDel = pb.getCanDel();//17
		r.ServerThumbLocalSrc = pb.getServerThumbLocalSrc();//18
		r.RemoteMessageFileId = pb.getRemoteMessageFileId();//19
		r.LocalSrc = pb.getLocalSrc();//20
		r.ThumbLocalSrc = pb.getThumbLocalSrc();//21
		r.MessageFileStatusId = pb.getMessageFileStatusId();//22

	    return r;
	}

}
	/*
	folding

	//sett
	RealmMessageFileView r = new RealmMessageFileView();
	
	r.MessageFileId = ;//0
	r.OriginalUserId = ;//1
	r.Name = ;//2
	r.Size = ;//3
	r.FileTypeEnumId = ;//4
	r.Width = ;//5
	r.Height = ;//6
	r.Duration = ;//7
	r.Extension = ;//8
	r.HashMd5 = ;//9
	r.HashAccess = ;//10
	r.CreatedSe = ;//11
	r.ServerSrc = ;//12
	r.ServerPath = ;//13
	r.ServerThumbPath = ;//14
	r.BucketId = ;//15
	r.ServerId = ;//16
	r.CanDel = ;//17
	r.ServerThumbLocalSrc = ;//18
	r.RemoteMessageFileId = ;//19
	r.LocalSrc = ;//20
	r.ThumbLocalSrc = ;//21
	r.MessageFileStatusId = ;//22

	//sett - no tag number 
	RealmMessageFileView r = new RealmMessageFileView();
	
	r.MessageFileId = ;
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
	m. = r.OriginalUserId ;//1
	m. = r.Name ;//2
	m. = r.Size ;//3
	m. = r.FileTypeEnumId ;//4
	m. = r.Width ;//5
	m. = r.Height ;//6
	m. = r.Duration ;//7
	m. = r.Extension ;//8
	m. = r.HashMd5 ;//9
	m. = r.HashAccess ;//10
	m. = r.CreatedSe ;//11
	m. = r.ServerSrc ;//12
	m. = r.ServerPath ;//13
	m. = r.ServerThumbPath ;//14
	m. = r.BucketId ;//15
	m. = r.ServerId ;//16
	m. = r.CanDel ;//17
	m. = r.ServerThumbLocalSrc ;//18
	m. = r.RemoteMessageFileId ;//19
	m. = r.LocalSrc ;//20
	m. = r.ThumbLocalSrc ;//21
	m. = r.MessageFileStatusId ;//22

	//get - no tag number
	
	m. = r.MessageFileId ;
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
