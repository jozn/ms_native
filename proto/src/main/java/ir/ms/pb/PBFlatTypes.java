package ir.ms.pb;

public class PBFlatTypes {

	public class PB_RoomInlineView {
	   public long RoomId;
	   public RoomTypeEnum RoomTypeEnum;
	}
	/*
	folding
	PBFlatTypes.PB_RoomInlineView t = new PBFlatTypes.PB_RoomInlineView();
    t.setRoomId();
    t.setRoomTypeEnum();
	*/

	/*
	PBFlatTypes.PB_RoomInlineView t = new PBFlatTypes.PB_RoomInlineView();
	t.RoomId = ;
	t.RoomTypeEnum = ;
	*/

	/*
	PB_RoomInlineView t = new PB_RoomInlineView();
	t.RoomId = m.getRoomId() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	*/

	public class PB_MessageForwardedFrom {
	   public long RoomId;
	   public RoomTypeEnum RoomTypeEnum;
	   public long MessageId;
	   public int MessageSeq;
	}
	/*
	folding
	PBFlatTypes.PB_MessageForwardedFrom t = new PBFlatTypes.PB_MessageForwardedFrom();
    t.setRoomId();
    t.setRoomTypeEnum();
    t.setMessageId();
    t.setMessageSeq();
	*/

	/*
	PBFlatTypes.PB_MessageForwardedFrom t = new PBFlatTypes.PB_MessageForwardedFrom();
	t.RoomId = ;
	t.RoomTypeEnum = ;
	t.MessageId = ;
	t.MessageSeq = ;
	*/

	/*
	PB_MessageForwardedFrom t = new PB_MessageForwardedFrom();
	t.RoomId = m.getRoomId() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	t.MessageId = m.getMessageId() ;
	t.MessageSeq = m.getMessageSeq() ;
	*/

	public class PB_GroupView {
	   public long GroupId;
	   public String GroupName;
	   public int MembersCount;
	   public int GroupPrivacyEnum;
	   public int CreatorUserId;
	   public int CreatedTime;
	   public long UpdatedMs;
	   public int CurrentSeq;
	}
	/*
	folding
	PBFlatTypes.PB_GroupView t = new PBFlatTypes.PB_GroupView();
    t.setGroupId();
    t.setGroupName();
    t.setMembersCount();
    t.setGroupPrivacyEnum();
    t.setCreatorUserId();
    t.setCreatedTime();
    t.setUpdatedMs();
    t.setCurrentSeq();
	*/

	/*
	PBFlatTypes.PB_GroupView t = new PBFlatTypes.PB_GroupView();
	t.GroupId = ;
	t.GroupName = ;
	t.MembersCount = ;
	t.GroupPrivacyEnum = ;
	t.CreatorUserId = ;
	t.CreatedTime = ;
	t.UpdatedMs = ;
	t.CurrentSeq = ;
	*/

	/*
	PB_GroupView t = new PB_GroupView();
	t.GroupId = m.getGroupId() ;
	t.GroupName = m.getGroupName() ;
	t.MembersCount = m.getMembersCount() ;
	t.GroupPrivacyEnum = m.getGroupPrivacyEnum() ;
	t.CreatorUserId = m.getCreatorUserId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.UpdatedMs = m.getUpdatedMs() ;
	t.CurrentSeq = m.getCurrentSeq() ;
	*/

	public class PB_GroupMemberView {
	   public long Id;
	   public long GroupId;
	   public int UserId;
	   public int ByUserId;
	   public int GroupRoleEnum;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_GroupMemberView t = new PBFlatTypes.PB_GroupMemberView();
    t.setId();
    t.setGroupId();
    t.setUserId();
    t.setByUserId();
    t.setGroupRoleEnum();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_GroupMemberView t = new PBFlatTypes.PB_GroupMemberView();
	t.Id = ;
	t.GroupId = ;
	t.UserId = ;
	t.ByUserId = ;
	t.GroupRoleEnum = ;
	t.CreatedTime = ;
	*/

	/*
	PB_GroupMemberView t = new PB_GroupMemberView();
	t.Id = m.getId() ;
	t.GroupId = m.getGroupId() ;
	t.UserId = m.getUserId() ;
	t.ByUserId = m.getByUserId() ;
	t.GroupRoleEnum = m.getGroupRoleEnum() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_MessageFileView__DEp {
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
	/*
	folding
	PBFlatTypes.PB_MessageFileView__DEp t = new PBFlatTypes.PB_MessageFileView__DEp();
    t.setMessageFileId();
    t.setName();
    t.setSize();
    t.setFileTypeEnum();
    t.setMimeType();
    t.setWidth();
    t.setHeight();
    t.setDuration();
    t.setExtension();
    t.setThumbData64();
    t.setServerSrc();
    t.setServerPath();
    t.setServerThumbPath();
    t.setBucketId();
    t.setServerId();
    t.setCanDel();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_MessageFileView__DEp t = new PBFlatTypes.PB_MessageFileView__DEp();
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
	PB_MessageFileView__DEp t = new PB_MessageFileView__DEp();
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

	public class PB_ReqLastChangesForTheRoom {
	   public long RoomId;
	   public long LastLogId;
	   public int LastHaveSeq;
	}
	/*
	folding
	PBFlatTypes.PB_ReqLastChangesForTheRoom t = new PBFlatTypes.PB_ReqLastChangesForTheRoom();
    t.setRoomId();
    t.setLastLogId();
    t.setLastHaveSeq();
	*/

	/*
	PBFlatTypes.PB_ReqLastChangesForTheRoom t = new PBFlatTypes.PB_ReqLastChangesForTheRoom();
	t.RoomId = ;
	t.LastLogId = ;
	t.LastHaveSeq = ;
	*/

	/*
	PB_ReqLastChangesForTheRoom t = new PB_ReqLastChangesForTheRoom();
	t.RoomId = m.getRoomId() ;
	t.LastLogId = m.getLastLogId() ;
	t.LastHaveSeq = m.getLastHaveSeq() ;
	*/

	public class PB_ResponseLastChangesForTheRoom {
	   public PB_MessageView Messages;
	}
	/*
	folding
	PBFlatTypes.PB_ResponseLastChangesForTheRoom t = new PBFlatTypes.PB_ResponseLastChangesForTheRoom();
    t.setMessages();
	*/

	/*
	PBFlatTypes.PB_ResponseLastChangesForTheRoom t = new PBFlatTypes.PB_ResponseLastChangesForTheRoom();
	t.Messages = ;
	*/

	/*
	PB_ResponseLastChangesForTheRoom t = new PB_ResponseLastChangesForTheRoom();
	t.Messages = m.getMessages() ;
	*/

	public class PB_RequestSetLastSeenMessages {
	   public long RoomId;
	   public long FromMessageId;
	   public int ToMessageId;
	   public long AtTimeMs;
	}
	/*
	folding
	PBFlatTypes.PB_RequestSetLastSeenMessages t = new PBFlatTypes.PB_RequestSetLastSeenMessages();
    t.setRoomId();
    t.setFromMessageId();
    t.setToMessageId();
    t.setAtTimeMs();
	*/

	/*
	PBFlatTypes.PB_RequestSetLastSeenMessages t = new PBFlatTypes.PB_RequestSetLastSeenMessages();
	t.RoomId = ;
	t.FromMessageId = ;
	t.ToMessageId = ;
	t.AtTimeMs = ;
	*/

	/*
	PB_RequestSetLastSeenMessages t = new PB_RequestSetLastSeenMessages();
	t.RoomId = m.getRoomId() ;
	t.FromMessageId = m.getFromMessageId() ;
	t.ToMessageId = m.getToMessageId() ;
	t.AtTimeMs = m.getAtTimeMs() ;
	*/

	public class PB_ResponseSetLastSeenMessages {
	   public PB_MessageView Messages;
	}
	/*
	folding
	PBFlatTypes.PB_ResponseSetLastSeenMessages t = new PBFlatTypes.PB_ResponseSetLastSeenMessages();
    t.setMessages();
	*/

	/*
	PBFlatTypes.PB_ResponseSetLastSeenMessages t = new PBFlatTypes.PB_ResponseSetLastSeenMessages();
	t.Messages = ;
	*/

	/*
	PB_ResponseSetLastSeenMessages t = new PB_ResponseSetLastSeenMessages();
	t.Messages = m.getMessages() ;
	*/

	public class PB_MessagesCollections {
	   public long DirectMessagesIds;
	   public long GroupMessagesIds;
	   public long BroadCatMessagesIds;
	}
	/*
	folding
	PBFlatTypes.PB_MessagesCollections t = new PBFlatTypes.PB_MessagesCollections();
    t.setDirectMessagesIds();
    t.setGroupMessagesIds();
    t.setBroadCatMessagesIds();
	*/

	/*
	PBFlatTypes.PB_MessagesCollections t = new PBFlatTypes.PB_MessagesCollections();
	t.DirectMessagesIds = ;
	t.GroupMessagesIds = ;
	t.BroadCatMessagesIds = ;
	*/

	/*
	PB_MessagesCollections t = new PB_MessagesCollections();
	t.DirectMessagesIds = m.getDirectMessagesIds() ;
	t.GroupMessagesIds = m.getGroupMessagesIds() ;
	t.BroadCatMessagesIds = m.getBroadCatMessagesIds() ;
	*/

	public class PB_DirectLogView {
	   public PB_DirectLog Row;
	   public PB_MessageView NewMessage;
	}
	/*
	folding
	PBFlatTypes.PB_DirectLogView t = new PBFlatTypes.PB_DirectLogView();
    t.setRow();
    t.setNewMessage();
	*/

	/*
	PBFlatTypes.PB_DirectLogView t = new PBFlatTypes.PB_DirectLogView();
	t.Row = ;
	t.NewMessage = ;
	*/

	/*
	PB_DirectLogView t = new PB_DirectLogView();
	t.Row = m.getRow() ;
	t.NewMessage = m.getNewMessage() ;
	*/

	public class PB_DirectLog {
	   public long Id;
	   public int ToUserId;
	   public long MessageId;
	   public long ChatId;
	   public int PeerUserId;
	   public int EventType;
	   public int RoomLogTypeId;
	   public int FromSeq;
	   public int ToSeq;
	   public byte[] ExtraPB;
	   public String ExtraJson;
	   public long AtTimeMs;
	}
	/*
	folding
	PBFlatTypes.PB_DirectLog t = new PBFlatTypes.PB_DirectLog();
    t.setId();
    t.setToUserId();
    t.setMessageId();
    t.setChatId();
    t.setPeerUserId();
    t.setEventType();
    t.setRoomLogTypeId();
    t.setFromSeq();
    t.setToSeq();
    t.setExtraPB();
    t.setExtraJson();
    t.setAtTimeMs();
	*/

	/*
	PBFlatTypes.PB_DirectLog t = new PBFlatTypes.PB_DirectLog();
	t.Id = ;
	t.ToUserId = ;
	t.MessageId = ;
	t.ChatId = ;
	t.PeerUserId = ;
	t.EventType = ;
	t.RoomLogTypeId = ;
	t.FromSeq = ;
	t.ToSeq = ;
	t.ExtraPB = ;
	t.ExtraJson = ;
	t.AtTimeMs = ;
	*/

	/*
	PB_DirectLog t = new PB_DirectLog();
	t.Id = m.getId() ;
	t.ToUserId = m.getToUserId() ;
	t.MessageId = m.getMessageId() ;
	t.ChatId = m.getChatId() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.EventType = m.getEventType() ;
	t.RoomLogTypeId = m.getRoomLogTypeId() ;
	t.FromSeq = m.getFromSeq() ;
	t.ToSeq = m.getToSeq() ;
	t.ExtraPB = m.getExtraPB() ;
	t.ExtraJson = m.getExtraJson() ;
	t.AtTimeMs = m.getAtTimeMs() ;
	*/

	public class PB_PushDirectLogViewsMany {
	   public PB_DirectLogView Rows;
	}
	/*
	folding
	PBFlatTypes.PB_PushDirectLogViewsMany t = new PBFlatTypes.PB_PushDirectLogViewsMany();
    t.setRows();
	*/

	/*
	PBFlatTypes.PB_PushDirectLogViewsMany t = new PBFlatTypes.PB_PushDirectLogViewsMany();
	t.Rows = ;
	*/

	/*
	PB_PushDirectLogViewsMany t = new PB_PushDirectLogViewsMany();
	t.Rows = m.getRows() ;
	*/

	public class PB_UserWithMe {
	   public int UserId;
	   public String UserName;
	   public String FirstName;
	   public String LastName;
	   public String About;
	   public String FullName;
	   public String AvatarUrl;
	   public int PrivacyProfile;
	   public String Phone;
	   public int UpdatedTime;
	   public int AppVersion;
	   public int FollowingType;
	}
	/*
	folding
	PBFlatTypes.PB_UserWithMe t = new PBFlatTypes.PB_UserWithMe();
    t.setUserId();
    t.setUserName();
    t.setFirstName();
    t.setLastName();
    t.setAbout();
    t.setFullName();
    t.setAvatarUrl();
    t.setPrivacyProfile();
    t.setPhone();
    t.setUpdatedTime();
    t.setAppVersion();
    t.setFollowingType();
	*/

	/*
	PBFlatTypes.PB_UserWithMe t = new PBFlatTypes.PB_UserWithMe();
	t.UserId = ;
	t.UserName = ;
	t.FirstName = ;
	t.LastName = ;
	t.About = ;
	t.FullName = ;
	t.AvatarUrl = ;
	t.PrivacyProfile = ;
	t.Phone = ;
	t.UpdatedTime = ;
	t.AppVersion = ;
	t.FollowingType = ;
	*/

	/*
	PB_UserWithMe t = new PB_UserWithMe();
	t.UserId = m.getUserId() ;
	t.UserName = m.getUserName() ;
	t.FirstName = m.getFirstName() ;
	t.LastName = m.getLastName() ;
	t.About = m.getAbout() ;
	t.FullName = m.getFullName() ;
	t.AvatarUrl = m.getAvatarUrl() ;
	t.PrivacyProfile = m.getPrivacyProfile() ;
	t.Phone = m.getPhone() ;
	t.UpdatedTime = m.getUpdatedTime() ;
	t.AppVersion = m.getAppVersion() ;
	t.FollowingType = m.getFollowingType() ;
	*/

	public class PB_Message {
	   public String MessageKey;
	   public String RoomKey;
	   public long UserId;
	   public long PeerId;
	   public int RoomTypeId;
	   public int MessageTypeId;
	   public String Text;
	   public String ExtraJson;
	   public int IsByMe;
	   public int IsStared;
	   public long CreatedMs;
	   public long CreatedDeviceMs;
	   public long SortId;
	   public long PeerSeenTime;
	   public long ServerReceivedTime;
	   public long ServerDeletedTime;
	   public long ISeenTime;
	   public int ToPush;
	   public String MsgFile_LocalSrc;
	   public int MsgFile_Status;
	   public PB_MsgFile File;
	}
	/*
	folding
	PBFlatTypes.PB_Message t = new PBFlatTypes.PB_Message();
    t.setMessageKey();
    t.setRoomKey();
    t.setUserId();
    t.setPeerId();
    t.setRoomTypeId();
    t.setMessageTypeId();
    t.setText();
    t.setExtraJson();
    t.setIsByMe();
    t.setIsStared();
    t.setCreatedMs();
    t.setCreatedDeviceMs();
    t.setSortId();
    t.setPeerSeenTime();
    t.setServerReceivedTime();
    t.setServerDeletedTime();
    t.setISeenTime();
    t.setToPush();
    t.setMsgFile_LocalSrc();
    t.setMsgFile_Status();
    t.setFile();
	*/

	/*
	PBFlatTypes.PB_Message t = new PBFlatTypes.PB_Message();
	t.MessageKey = ;
	t.RoomKey = ;
	t.UserId = ;
	t.PeerId = ;
	t.RoomTypeId = ;
	t.MessageTypeId = ;
	t.Text = ;
	t.ExtraJson = ;
	t.IsByMe = ;
	t.IsStared = ;
	t.CreatedMs = ;
	t.CreatedDeviceMs = ;
	t.SortId = ;
	t.PeerSeenTime = ;
	t.ServerReceivedTime = ;
	t.ServerDeletedTime = ;
	t.ISeenTime = ;
	t.ToPush = ;
	t.MsgFile_LocalSrc = ;
	t.MsgFile_Status = ;
	t.File = ;
	*/

	/*
	PB_Message t = new PB_Message();
	t.MessageKey = m.getMessageKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.PeerId = m.getPeerId() ;
	t.RoomTypeId = m.getRoomTypeId() ;
	t.MessageTypeId = m.getMessageTypeId() ;
	t.Text = m.getText() ;
	t.ExtraJson = m.getExtraJson() ;
	t.IsByMe = m.getIsByMe() ;
	t.IsStared = m.getIsStared() ;
	t.CreatedMs = m.getCreatedMs() ;
	t.CreatedDeviceMs = m.getCreatedDeviceMs() ;
	t.SortId = m.getSortId() ;
	t.PeerSeenTime = m.getPeerSeenTime() ;
	t.ServerReceivedTime = m.getServerReceivedTime() ;
	t.ServerDeletedTime = m.getServerDeletedTime() ;
	t.ISeenTime = m.getISeenTime() ;
	t.ToPush = m.getToPush() ;
	t.MsgFile_LocalSrc = m.getMsgFile_LocalSrc() ;
	t.MsgFile_Status = m.getMsgFile_Status() ;
	t.File = m.getFile() ;
	*/

	public class PB_MsgFile {
	   public String Name;
	   public long Size;
	   public int FileType;
	   public String MimeType;
	   public int Width;
	   public int Height;
	   public int Duration;
	   public String Extension;
	   public byte[] ThumbData;
	   public byte[] Data;
	   public String ServerSrc;
	}
	/*
	folding
	PBFlatTypes.PB_MsgFile t = new PBFlatTypes.PB_MsgFile();
    t.setName();
    t.setSize();
    t.setFileType();
    t.setMimeType();
    t.setWidth();
    t.setHeight();
    t.setDuration();
    t.setExtension();
    t.setThumbData();
    t.setData();
    t.setServerSrc();
	*/

	/*
	PBFlatTypes.PB_MsgFile t = new PBFlatTypes.PB_MsgFile();
	t.Name = ;
	t.Size = ;
	t.FileType = ;
	t.MimeType = ;
	t.Width = ;
	t.Height = ;
	t.Duration = ;
	t.Extension = ;
	t.ThumbData = ;
	t.Data = ;
	t.ServerSrc = ;
	*/

	/*
	PB_MsgFile t = new PB_MsgFile();
	t.Name = m.getName() ;
	t.Size = m.getSize() ;
	t.FileType = m.getFileType() ;
	t.MimeType = m.getMimeType() ;
	t.Width = m.getWidth() ;
	t.Height = m.getHeight() ;
	t.Duration = m.getDuration() ;
	t.Extension = m.getExtension() ;
	t.ThumbData = m.getThumbData() ;
	t.Data = m.getData() ;
	t.ServerSrc = m.getServerSrc() ;
	*/

	public class PB_Response {
	   public int Status;
	}
	/*
	folding
	PBFlatTypes.PB_Response t = new PBFlatTypes.PB_Response();
    t.setStatus();
	*/

	/*
	PBFlatTypes.PB_Response t = new PBFlatTypes.PB_Response();
	t.Status = ;
	*/

	/*
	PB_Response t = new PB_Response();
	t.Status = m.getStatus() ;
	*/

	public class PB_Request {
	   public int Status;
	}
	/*
	folding
	PBFlatTypes.PB_Request t = new PBFlatTypes.PB_Request();
    t.setStatus();
	*/

	/*
	PBFlatTypes.PB_Request t = new PBFlatTypes.PB_Request();
	t.Status = ;
	*/

	/*
	PB_Request t = new PB_Request();
	t.Status = m.getStatus() ;
	*/

	public class PB_RequestMsgAddMany {
	   public PB_Request Request;
	   public PB_Message Messages;
	}
	/*
	folding
	PBFlatTypes.PB_RequestMsgAddMany t = new PBFlatTypes.PB_RequestMsgAddMany();
    t.setRequest();
    t.setMessages();
	*/

	/*
	PBFlatTypes.PB_RequestMsgAddMany t = new PBFlatTypes.PB_RequestMsgAddMany();
	t.Request = ;
	t.Messages = ;
	*/

	/*
	PB_RequestMsgAddMany t = new PB_RequestMsgAddMany();
	t.Request = m.getRequest() ;
	t.Messages = m.getMessages() ;
	*/

	public class PB_ResponseMsgAddMany {
	   public PB_Response Response;
	}
	/*
	folding
	PBFlatTypes.PB_ResponseMsgAddMany t = new PBFlatTypes.PB_ResponseMsgAddMany();
    t.setResponse();
	*/

	/*
	PBFlatTypes.PB_ResponseMsgAddMany t = new PBFlatTypes.PB_ResponseMsgAddMany();
	t.Response = ;
	*/

	/*
	PB_ResponseMsgAddMany t = new PB_ResponseMsgAddMany();
	t.Response = m.getResponse() ;
	*/

	public class PB_Push {
	   public int Status;
	}
	/*
	folding
	PBFlatTypes.PB_Push t = new PBFlatTypes.PB_Push();
    t.setStatus();
	*/

	/*
	PBFlatTypes.PB_Push t = new PBFlatTypes.PB_Push();
	t.Status = ;
	*/

	/*
	PB_Push t = new PB_Push();
	t.Status = m.getStatus() ;
	*/

	public class PB_Result {
	   public int Status;
	}
	/*
	folding
	PBFlatTypes.PB_Result t = new PBFlatTypes.PB_Result();
    t.setStatus();
	*/

	/*
	PBFlatTypes.PB_Result t = new PBFlatTypes.PB_Result();
	t.Status = ;
	*/

	/*
	PB_Result t = new PB_Result();
	t.Status = m.getStatus() ;
	*/

	public class PB_PushMsgAddMany {
	   public PB_Push Push;
	   public PB_Message Messages;
	   public PB_UserWithMe Users;
	}
	/*
	folding
	PBFlatTypes.PB_PushMsgAddMany t = new PBFlatTypes.PB_PushMsgAddMany();
    t.setPush();
    t.setMessages();
    t.setUsers();
	*/

	/*
	PBFlatTypes.PB_PushMsgAddMany t = new PBFlatTypes.PB_PushMsgAddMany();
	t.Push = ;
	t.Messages = ;
	t.Users = ;
	*/

	/*
	PB_PushMsgAddMany t = new PB_PushMsgAddMany();
	t.Push = m.getPush() ;
	t.Messages = m.getMessages() ;
	t.Users = m.getUsers() ;
	*/

	public class PB_ResultMsgAddMany {
	   public PB_Result Result;
	}
	/*
	folding
	PBFlatTypes.PB_ResultMsgAddMany t = new PBFlatTypes.PB_ResultMsgAddMany();
    t.setResult();
	*/

	/*
	PBFlatTypes.PB_ResultMsgAddMany t = new PBFlatTypes.PB_ResultMsgAddMany();
	t.Result = ;
	*/

	/*
	PB_ResultMsgAddMany t = new PB_ResultMsgAddMany();
	t.Result = m.getResult() ;
	*/

	public class PB_MsgEvent {
	   public String MessageKey;
	   public String RoomKey;
	   public long PeerUserId;
	   public int EventType;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_MsgEvent t = new PBFlatTypes.PB_MsgEvent();
    t.setMessageKey();
    t.setRoomKey();
    t.setPeerUserId();
    t.setEventType();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_MsgEvent t = new PBFlatTypes.PB_MsgEvent();
	t.MessageKey = ;
	t.RoomKey = ;
	t.PeerUserId = ;
	t.EventType = ;
	t.AtTime = ;
	*/

	/*
	PB_MsgEvent t = new PB_MsgEvent();
	t.MessageKey = m.getMessageKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.EventType = m.getEventType() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_PushMsgEvents {
	   public PB_Push Push;
	   public PB_MsgEvent Events;
	}
	/*
	folding
	PBFlatTypes.PB_PushMsgEvents t = new PBFlatTypes.PB_PushMsgEvents();
    t.setPush();
    t.setEvents();
	*/

	/*
	PBFlatTypes.PB_PushMsgEvents t = new PBFlatTypes.PB_PushMsgEvents();
	t.Push = ;
	t.Events = ;
	*/

	/*
	PB_PushMsgEvents t = new PB_PushMsgEvents();
	t.Push = m.getPush() ;
	t.Events = m.getEvents() ;
	*/

	public class PB_ResultMsgEvents {
	   public PB_Result Result;
	}
	/*
	folding
	PBFlatTypes.PB_ResultMsgEvents t = new PBFlatTypes.PB_ResultMsgEvents();
    t.setResult();
	*/

	/*
	PBFlatTypes.PB_ResultMsgEvents t = new PBFlatTypes.PB_ResultMsgEvents();
	t.Result = ;
	*/

	/*
	PB_ResultMsgEvents t = new PB_ResultMsgEvents();
	t.Result = m.getResult() ;
	*/

	public class PB_MsgsSeenFromClient {
	   public String MessageKey;
	   public String RoomKey;
	   public long UserId;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_MsgsSeenFromClient t = new PBFlatTypes.PB_MsgsSeenFromClient();
    t.setMessageKey();
    t.setRoomKey();
    t.setUserId();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_MsgsSeenFromClient t = new PBFlatTypes.PB_MsgsSeenFromClient();
	t.MessageKey = ;
	t.RoomKey = ;
	t.UserId = ;
	t.AtTime = ;
	*/

	/*
	PB_MsgsSeenFromClient t = new PB_MsgsSeenFromClient();
	t.MessageKey = m.getMessageKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_MsgSeen {
	   public String MessageKey;
	   public String RoomKey;
	   public long UserId;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_MsgSeen t = new PBFlatTypes.PB_MsgSeen();
    t.setMessageKey();
    t.setRoomKey();
    t.setUserId();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_MsgSeen t = new PBFlatTypes.PB_MsgSeen();
	t.MessageKey = ;
	t.RoomKey = ;
	t.UserId = ;
	t.AtTime = ;
	*/

	/*
	PB_MsgSeen t = new PB_MsgSeen();
	t.MessageKey = m.getMessageKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_RequestMsgsSeen {
	   public PB_Request Request;
	   public PB_MsgSeen Seen;
	}
	/*
	folding
	PBFlatTypes.PB_RequestMsgsSeen t = new PBFlatTypes.PB_RequestMsgsSeen();
    t.setRequest();
    t.setSeen();
	*/

	/*
	PBFlatTypes.PB_RequestMsgsSeen t = new PBFlatTypes.PB_RequestMsgsSeen();
	t.Request = ;
	t.Seen = ;
	*/

	/*
	PB_RequestMsgsSeen t = new PB_RequestMsgsSeen();
	t.Request = m.getRequest() ;
	t.Seen = m.getSeen() ;
	*/

	public class PB_ResponseMsgsSeen {
	   public PB_Response Response;
	}
	/*
	folding
	PBFlatTypes.PB_ResponseMsgsSeen t = new PBFlatTypes.PB_ResponseMsgsSeen();
    t.setResponse();
	*/

	/*
	PBFlatTypes.PB_ResponseMsgsSeen t = new PBFlatTypes.PB_ResponseMsgsSeen();
	t.Response = ;
	*/

	/*
	PB_ResponseMsgsSeen t = new PB_ResponseMsgsSeen();
	t.Response = m.getResponse() ;
	*/

	public class PB_ReqRpcAddMsg {
	   public PB_Request Request;
	   public PB_Message Message;
	}
	/*
	folding
	PBFlatTypes.PB_ReqRpcAddMsg t = new PBFlatTypes.PB_ReqRpcAddMsg();
    t.setRequest();
    t.setMessage();
	*/

	/*
	PBFlatTypes.PB_ReqRpcAddMsg t = new PBFlatTypes.PB_ReqRpcAddMsg();
	t.Request = ;
	t.Message = ;
	*/

	/*
	PB_ReqRpcAddMsg t = new PB_ReqRpcAddMsg();
	t.Request = m.getRequest() ;
	t.Message = m.getMessage() ;
	*/

	public class PB_ResRpcAddMsg {
	   public PB_Response Response;
	   public String ServerSrc;
	}
	/*
	folding
	PBFlatTypes.PB_ResRpcAddMsg t = new PBFlatTypes.PB_ResRpcAddMsg();
    t.setResponse();
    t.setServerSrc();
	*/

	/*
	PBFlatTypes.PB_ResRpcAddMsg t = new PBFlatTypes.PB_ResRpcAddMsg();
	t.Response = ;
	t.ServerSrc = ;
	*/

	/*
	PB_ResRpcAddMsg t = new PB_ResRpcAddMsg();
	t.Response = m.getResponse() ;
	t.ServerSrc = m.getServerSrc() ;
	*/

	public class GeoLocation {
	   public double Lat;
	   public double Lon;
	}
	/*
	folding
	PBFlatTypes.GeoLocation t = new PBFlatTypes.GeoLocation();
    t.setLat();
    t.setLon();
	*/

	/*
	PBFlatTypes.GeoLocation t = new PBFlatTypes.GeoLocation();
	t.Lat = ;
	t.Lon = ;
	*/

	/*
	GeoLocation t = new GeoLocation();
	t.Lat = m.getLat() ;
	t.Lon = m.getLon() ;
	*/

	public class RoomMessageLog {
	   public RoomMessageLogEnum typ;
	   public long TargetUserId;
	   public long ByUserId;
	}
	/*
	folding
	PBFlatTypes.RoomMessageLog t = new PBFlatTypes.RoomMessageLog();
    t.settyp();
    t.setTargetUserId();
    t.setByUserId();
	*/

	/*
	PBFlatTypes.RoomMessageLog t = new PBFlatTypes.RoomMessageLog();
	t.typ = ;
	t.TargetUserId = ;
	t.ByUserId = ;
	*/

	/*
	RoomMessageLog t = new RoomMessageLog();
	t.typ = m.gettyp() ;
	t.TargetUserId = m.getTargetUserId() ;
	t.ByUserId = m.getByUserId() ;
	*/

	public class RoomMessageForwardFrom {
	   public long RoomId;
	   public long MessageId;
	   public int RoomTypeEnum;
	}
	/*
	folding
	PBFlatTypes.RoomMessageForwardFrom t = new PBFlatTypes.RoomMessageForwardFrom();
    t.setRoomId();
    t.setMessageId();
    t.setRoomTypeEnum();
	*/

	/*
	PBFlatTypes.RoomMessageForwardFrom t = new PBFlatTypes.RoomMessageForwardFrom();
	t.RoomId = ;
	t.MessageId = ;
	t.RoomTypeEnum = ;
	*/

	/*
	RoomMessageForwardFrom t = new RoomMessageForwardFrom();
	t.RoomId = m.getRoomId() ;
	t.MessageId = m.getMessageId() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	*/

	public class RoomDraft {
	   public String Message;
	   public long ReplyTo;
	}
	/*
	folding
	PBFlatTypes.RoomDraft t = new PBFlatTypes.RoomDraft();
    t.setMessage();
    t.setReplyTo();
	*/

	/*
	PBFlatTypes.RoomDraft t = new PBFlatTypes.RoomDraft();
	t.Message = ;
	t.ReplyTo = ;
	*/

	/*
	RoomDraft t = new RoomDraft();
	t.Message = m.getMessage() ;
	t.ReplyTo = m.getReplyTo() ;
	*/

	public class ChatRoom {
	}
	/*
	folding
	PBFlatTypes.ChatRoom t = new PBFlatTypes.ChatRoom();
	*/

	/*
	PBFlatTypes.ChatRoom t = new PBFlatTypes.ChatRoom();
	*/

	/*
	ChatRoom t = new ChatRoom();
	*/

	public class Pagination {
	   public int Offset;
	   public int Limit;
	}
	/*
	folding
	PBFlatTypes.Pagination t = new PBFlatTypes.Pagination();
    t.setOffset();
    t.setLimit();
	*/

	/*
	PBFlatTypes.Pagination t = new PBFlatTypes.Pagination();
	t.Offset = ;
	t.Limit = ;
	*/

	/*
	Pagination t = new Pagination();
	t.Offset = m.getOffset() ;
	t.Limit = m.getLimit() ;
	*/

	public class PB_CommandToServer {
	   public long ClientCallId;
	   public String Command;
	   public boolean RespondReached;
	   public byte[] Data;
	}
	/*
	folding
	PBFlatTypes.PB_CommandToServer t = new PBFlatTypes.PB_CommandToServer();
    t.setClientCallId();
    t.setCommand();
    t.setRespondReached();
    t.setData();
	*/

	/*
	PBFlatTypes.PB_CommandToServer t = new PBFlatTypes.PB_CommandToServer();
	t.ClientCallId = ;
	t.Command = ;
	t.RespondReached = ;
	t.Data = ;
	*/

	/*
	PB_CommandToServer t = new PB_CommandToServer();
	t.ClientCallId = m.getClientCallId() ;
	t.Command = m.getCommand() ;
	t.RespondReached = m.getRespondReached() ;
	t.Data = m.getData() ;
	*/

	public class PB_CommandToClient {
	   public long ServerCallId;
	   public String Command;
	   public boolean RespondReached;
	   public byte[] Data;
	}
	/*
	folding
	PBFlatTypes.PB_CommandToClient t = new PBFlatTypes.PB_CommandToClient();
    t.setServerCallId();
    t.setCommand();
    t.setRespondReached();
    t.setData();
	*/

	/*
	PBFlatTypes.PB_CommandToClient t = new PBFlatTypes.PB_CommandToClient();
	t.ServerCallId = ;
	t.Command = ;
	t.RespondReached = ;
	t.Data = ;
	*/

	/*
	PB_CommandToClient t = new PB_CommandToClient();
	t.ServerCallId = m.getServerCallId() ;
	t.Command = m.getCommand() ;
	t.RespondReached = m.getRespondReached() ;
	t.Data = m.getData() ;
	*/

	public class PB_CommandReachedToServer {
	   public long ClientCallId;
	}
	/*
	folding
	PBFlatTypes.PB_CommandReachedToServer t = new PBFlatTypes.PB_CommandReachedToServer();
    t.setClientCallId();
	*/

	/*
	PBFlatTypes.PB_CommandReachedToServer t = new PBFlatTypes.PB_CommandReachedToServer();
	t.ClientCallId = ;
	*/

	/*
	PB_CommandReachedToServer t = new PB_CommandReachedToServer();
	t.ClientCallId = m.getClientCallId() ;
	*/

	public class PB_CommandReachedToClient {
	   public long ServerCallId;
	}
	/*
	folding
	PBFlatTypes.PB_CommandReachedToClient t = new PBFlatTypes.PB_CommandReachedToClient();
    t.setServerCallId();
	*/

	/*
	PBFlatTypes.PB_CommandReachedToClient t = new PBFlatTypes.PB_CommandReachedToClient();
	t.ServerCallId = ;
	*/

	/*
	PB_CommandReachedToClient t = new PB_CommandReachedToClient();
	t.ServerCallId = m.getServerCallId() ;
	*/

	public class PB_ResponseToClient {
	   public long ClientCallId;
	   public String PBClass;
	   public String RpcFullName;
	   public byte[] Data;
	}
	/*
	folding
	PBFlatTypes.PB_ResponseToClient t = new PBFlatTypes.PB_ResponseToClient();
    t.setClientCallId();
    t.setPBClass();
    t.setRpcFullName();
    t.setData();
	*/

	/*
	PBFlatTypes.PB_ResponseToClient t = new PBFlatTypes.PB_ResponseToClient();
	t.ClientCallId = ;
	t.PBClass = ;
	t.RpcFullName = ;
	t.Data = ;
	*/

	/*
	PB_ResponseToClient t = new PB_ResponseToClient();
	t.ClientCallId = m.getClientCallId() ;
	t.PBClass = m.getPBClass() ;
	t.RpcFullName = m.getRpcFullName() ;
	t.Data = m.getData() ;
	*/

	public class PB_UserParam_CheckUserName2 {
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_CheckUserName2 t = new PBFlatTypes.PB_UserParam_CheckUserName2();
	*/

	/*
	PBFlatTypes.PB_UserParam_CheckUserName2 t = new PBFlatTypes.PB_UserParam_CheckUserName2();
	*/

	/*
	PB_UserParam_CheckUserName2 t = new PB_UserParam_CheckUserName2();
	*/

	public class PB_UserResponse_CheckUserName2 {
	}
	/*
	folding
	PBFlatTypes.PB_UserResponse_CheckUserName2 t = new PBFlatTypes.PB_UserResponse_CheckUserName2();
	*/

	/*
	PBFlatTypes.PB_UserResponse_CheckUserName2 t = new PBFlatTypes.PB_UserResponse_CheckUserName2();
	*/

	/*
	PB_UserResponse_CheckUserName2 t = new PB_UserResponse_CheckUserName2();
	*/

	public class PB_MsgParam_AddNewTextMessage {
	   public String Text;
	   public int PeerId;
	   public int Time;
	   public long ReplyToMessageId;
	   public PB_MessageForwardedFrom Forward;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_AddNewTextMessage t = new PBFlatTypes.PB_MsgParam_AddNewTextMessage();
    t.setText();
    t.setPeerId();
    t.setTime();
    t.setReplyToMessageId();
    t.setForward();
	*/

	/*
	PBFlatTypes.PB_MsgParam_AddNewTextMessage t = new PBFlatTypes.PB_MsgParam_AddNewTextMessage();
	t.Text = ;
	t.PeerId = ;
	t.Time = ;
	t.ReplyToMessageId = ;
	t.Forward = ;
	*/

	/*
	PB_MsgParam_AddNewTextMessage t = new PB_MsgParam_AddNewTextMessage();
	t.Text = m.getText() ;
	t.PeerId = m.getPeerId() ;
	t.Time = m.getTime() ;
	t.ReplyToMessageId = m.getReplyToMessageId() ;
	t.Forward = m.getForward() ;
	*/

	public class PB_MsgResponse_AddNewTextMessage {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_AddNewTextMessage t = new PBFlatTypes.PB_MsgResponse_AddNewTextMessage();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_AddNewTextMessage t = new PBFlatTypes.PB_MsgResponse_AddNewTextMessage();
	*/

	/*
	PB_MsgResponse_AddNewTextMessage t = new PB_MsgResponse_AddNewTextMessage();
	*/

	public class PB_MsgParam_AddNewMessage {
	   public String Text;
	   public int PeerId;
	   public int Time;
	   public long ReplyToMessageId;
	   public PB_MessageForwardedFrom Forward;
	   public RoomMessageTypeEnum RoomMessageType;
	   public byte[] Blob;
	   public PB_MessageView MessageView;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_AddNewMessage t = new PBFlatTypes.PB_MsgParam_AddNewMessage();
    t.setText();
    t.setPeerId();
    t.setTime();
    t.setReplyToMessageId();
    t.setForward();
    t.setRoomMessageType();
    t.setBlob();
    t.setMessageView();
	*/

	/*
	PBFlatTypes.PB_MsgParam_AddNewMessage t = new PBFlatTypes.PB_MsgParam_AddNewMessage();
	t.Text = ;
	t.PeerId = ;
	t.Time = ;
	t.ReplyToMessageId = ;
	t.Forward = ;
	t.RoomMessageType = ;
	t.Blob = ;
	t.MessageView = ;
	*/

	/*
	PB_MsgParam_AddNewMessage t = new PB_MsgParam_AddNewMessage();
	t.Text = m.getText() ;
	t.PeerId = m.getPeerId() ;
	t.Time = m.getTime() ;
	t.ReplyToMessageId = m.getReplyToMessageId() ;
	t.Forward = m.getForward() ;
	t.RoomMessageType = m.getRoomMessageType() ;
	t.Blob = m.getBlob() ;
	t.MessageView = m.getMessageView() ;
	*/

	public class PB_MsgResponse_AddNewMessage {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_AddNewMessage t = new PBFlatTypes.PB_MsgResponse_AddNewMessage();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_AddNewMessage t = new PBFlatTypes.PB_MsgResponse_AddNewMessage();
	*/

	/*
	PB_MsgResponse_AddNewMessage t = new PB_MsgResponse_AddNewMessage();
	*/

	public class PB_MsgParam_SetRoomActionDoing {
	   public long GroupId;
	   public String DirectRoomKey;
	   public RoomActionDoingEnum ActionType;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_SetRoomActionDoing t = new PBFlatTypes.PB_MsgParam_SetRoomActionDoing();
    t.setGroupId();
    t.setDirectRoomKey();
    t.setActionType();
	*/

	/*
	PBFlatTypes.PB_MsgParam_SetRoomActionDoing t = new PBFlatTypes.PB_MsgParam_SetRoomActionDoing();
	t.GroupId = ;
	t.DirectRoomKey = ;
	t.ActionType = ;
	*/

	/*
	PB_MsgParam_SetRoomActionDoing t = new PB_MsgParam_SetRoomActionDoing();
	t.GroupId = m.getGroupId() ;
	t.DirectRoomKey = m.getDirectRoomKey() ;
	t.ActionType = m.getActionType() ;
	*/

	public class PB_MsgResponse_SetRoomActionDoing {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_SetRoomActionDoing t = new PBFlatTypes.PB_MsgResponse_SetRoomActionDoing();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_SetRoomActionDoing t = new PBFlatTypes.PB_MsgResponse_SetRoomActionDoing();
	*/

	/*
	PB_MsgResponse_SetRoomActionDoing t = new PB_MsgResponse_SetRoomActionDoing();
	*/

	public class PB_MsgParam_GetMessagesByIds {
	   public PB_MessagesCollections MessagesCollections;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_GetMessagesByIds t = new PBFlatTypes.PB_MsgParam_GetMessagesByIds();
    t.setMessagesCollections();
	*/

	/*
	PBFlatTypes.PB_MsgParam_GetMessagesByIds t = new PBFlatTypes.PB_MsgParam_GetMessagesByIds();
	t.MessagesCollections = ;
	*/

	/*
	PB_MsgParam_GetMessagesByIds t = new PB_MsgParam_GetMessagesByIds();
	t.MessagesCollections = m.getMessagesCollections() ;
	*/

	public class PB_MsgResponse_GetMessagesByIds {
	   public PB_MessageView MessagesViews;
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_GetMessagesByIds t = new PBFlatTypes.PB_MsgResponse_GetMessagesByIds();
    t.setMessagesViews();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_GetMessagesByIds t = new PBFlatTypes.PB_MsgResponse_GetMessagesByIds();
	t.MessagesViews = ;
	*/

	/*
	PB_MsgResponse_GetMessagesByIds t = new PB_MsgResponse_GetMessagesByIds();
	t.MessagesViews = m.getMessagesViews() ;
	*/

	public class PB_MsgParam_GetMessagesHistory {
	   public long ChatId;
	   public int FromSeq;
	   public int EndSeq;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_GetMessagesHistory t = new PBFlatTypes.PB_MsgParam_GetMessagesHistory();
    t.setChatId();
    t.setFromSeq();
    t.setEndSeq();
	*/

	/*
	PBFlatTypes.PB_MsgParam_GetMessagesHistory t = new PBFlatTypes.PB_MsgParam_GetMessagesHistory();
	t.ChatId = ;
	t.FromSeq = ;
	t.EndSeq = ;
	*/

	/*
	PB_MsgParam_GetMessagesHistory t = new PB_MsgParam_GetMessagesHistory();
	t.ChatId = m.getChatId() ;
	t.FromSeq = m.getFromSeq() ;
	t.EndSeq = m.getEndSeq() ;
	*/

	public class PB_MsgResponse_GetMessagesHistory {
	   public PB_MessageView MessagesViews;
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_GetMessagesHistory t = new PBFlatTypes.PB_MsgResponse_GetMessagesHistory();
    t.setMessagesViews();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_GetMessagesHistory t = new PBFlatTypes.PB_MsgResponse_GetMessagesHistory();
	t.MessagesViews = ;
	*/

	/*
	PB_MsgResponse_GetMessagesHistory t = new PB_MsgResponse_GetMessagesHistory();
	t.MessagesViews = m.getMessagesViews() ;
	*/

	public class PB_MsgParam_SetChatMessagesRangeAsSeen {
	   public long ChatId;
	   public int FromSeq;
	   public int EndSeq;
	   public long SeenTimeMs;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_MsgParam_SetChatMessagesRangeAsSeen();
    t.setChatId();
    t.setFromSeq();
    t.setEndSeq();
    t.setSeenTimeMs();
	*/

	/*
	PBFlatTypes.PB_MsgParam_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_MsgParam_SetChatMessagesRangeAsSeen();
	t.ChatId = ;
	t.FromSeq = ;
	t.EndSeq = ;
	t.SeenTimeMs = ;
	*/

	/*
	PB_MsgParam_SetChatMessagesRangeAsSeen t = new PB_MsgParam_SetChatMessagesRangeAsSeen();
	t.ChatId = m.getChatId() ;
	t.FromSeq = m.getFromSeq() ;
	t.EndSeq = m.getEndSeq() ;
	t.SeenTimeMs = m.getSeenTimeMs() ;
	*/

	public class PB_MsgResponse_SetChatMessagesRangeAsSeen {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_MsgResponse_SetChatMessagesRangeAsSeen();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_MsgResponse_SetChatMessagesRangeAsSeen();
	*/

	/*
	PB_MsgResponse_SetChatMessagesRangeAsSeen t = new PB_MsgResponse_SetChatMessagesRangeAsSeen();
	*/

	public class PB_MsgParam_DeleteChatHistory {
	   public long ChatId;
	   public int ToSeq;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_DeleteChatHistory t = new PBFlatTypes.PB_MsgParam_DeleteChatHistory();
    t.setChatId();
    t.setToSeq();
	*/

	/*
	PBFlatTypes.PB_MsgParam_DeleteChatHistory t = new PBFlatTypes.PB_MsgParam_DeleteChatHistory();
	t.ChatId = ;
	t.ToSeq = ;
	*/

	/*
	PB_MsgParam_DeleteChatHistory t = new PB_MsgParam_DeleteChatHistory();
	t.ChatId = m.getChatId() ;
	t.ToSeq = m.getToSeq() ;
	*/

	public class PB_MsgResponse_DeleteChatHistory {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_DeleteChatHistory t = new PBFlatTypes.PB_MsgResponse_DeleteChatHistory();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_DeleteChatHistory t = new PBFlatTypes.PB_MsgResponse_DeleteChatHistory();
	*/

	/*
	PB_MsgResponse_DeleteChatHistory t = new PB_MsgResponse_DeleteChatHistory();
	*/

	public class PB_MsgParam_DeleteMessagesByIds {
	   public PB_MessagesCollections MessagesCollections;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_DeleteMessagesByIds t = new PBFlatTypes.PB_MsgParam_DeleteMessagesByIds();
    t.setMessagesCollections();
	*/

	/*
	PBFlatTypes.PB_MsgParam_DeleteMessagesByIds t = new PBFlatTypes.PB_MsgParam_DeleteMessagesByIds();
	t.MessagesCollections = ;
	*/

	/*
	PB_MsgParam_DeleteMessagesByIds t = new PB_MsgParam_DeleteMessagesByIds();
	t.MessagesCollections = m.getMessagesCollections() ;
	*/

	public class PB_MsgResponse_DeleteMessagesByIds {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_DeleteMessagesByIds t = new PBFlatTypes.PB_MsgResponse_DeleteMessagesByIds();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_DeleteMessagesByIds t = new PBFlatTypes.PB_MsgResponse_DeleteMessagesByIds();
	*/

	/*
	PB_MsgResponse_DeleteMessagesByIds t = new PB_MsgResponse_DeleteMessagesByIds();
	*/

	public class PB_MsgParam_SetMessagesAsReceived {
	   public PB_MessagesCollections MessagesCollections;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_SetMessagesAsReceived t = new PBFlatTypes.PB_MsgParam_SetMessagesAsReceived();
    t.setMessagesCollections();
	*/

	/*
	PBFlatTypes.PB_MsgParam_SetMessagesAsReceived t = new PBFlatTypes.PB_MsgParam_SetMessagesAsReceived();
	t.MessagesCollections = ;
	*/

	/*
	PB_MsgParam_SetMessagesAsReceived t = new PB_MsgParam_SetMessagesAsReceived();
	t.MessagesCollections = m.getMessagesCollections() ;
	*/

	public class PB_MsgResponse_SetMessagesAsReceived {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_SetMessagesAsReceived t = new PBFlatTypes.PB_MsgResponse_SetMessagesAsReceived();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_SetMessagesAsReceived t = new PBFlatTypes.PB_MsgResponse_SetMessagesAsReceived();
	*/

	/*
	PB_MsgResponse_SetMessagesAsReceived t = new PB_MsgResponse_SetMessagesAsReceived();
	*/

	public class PB_MsgParam_ForwardMessages {
	   public PB_MessagesCollections MessagesCollections;
	   public long ToDirectChatIds;
	   public long ToGroupChatIds;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_ForwardMessages t = new PBFlatTypes.PB_MsgParam_ForwardMessages();
    t.setMessagesCollections();
    t.setToDirectChatIds();
    t.setToGroupChatIds();
	*/

	/*
	PBFlatTypes.PB_MsgParam_ForwardMessages t = new PBFlatTypes.PB_MsgParam_ForwardMessages();
	t.MessagesCollections = ;
	t.ToDirectChatIds = ;
	t.ToGroupChatIds = ;
	*/

	/*
	PB_MsgParam_ForwardMessages t = new PB_MsgParam_ForwardMessages();
	t.MessagesCollections = m.getMessagesCollections() ;
	t.ToDirectChatIds = m.getToDirectChatIds() ;
	t.ToGroupChatIds = m.getToGroupChatIds() ;
	*/

	public class PB_MsgResponse_ForwardMessages {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_ForwardMessages t = new PBFlatTypes.PB_MsgResponse_ForwardMessages();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_ForwardMessages t = new PBFlatTypes.PB_MsgResponse_ForwardMessages();
	*/

	/*
	PB_MsgResponse_ForwardMessages t = new PB_MsgResponse_ForwardMessages();
	*/

	public class PB_MsgParam_EditMessage {
	   public long ChatId;
	   public RoomTypeEnum RoomType;
	   public long MessageId;
	   public String NewText;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_EditMessage t = new PBFlatTypes.PB_MsgParam_EditMessage();
    t.setChatId();
    t.setRoomType();
    t.setMessageId();
    t.setNewText();
	*/

	/*
	PBFlatTypes.PB_MsgParam_EditMessage t = new PBFlatTypes.PB_MsgParam_EditMessage();
	t.ChatId = ;
	t.RoomType = ;
	t.MessageId = ;
	t.NewText = ;
	*/

	/*
	PB_MsgParam_EditMessage t = new PB_MsgParam_EditMessage();
	t.ChatId = m.getChatId() ;
	t.RoomType = m.getRoomType() ;
	t.MessageId = m.getMessageId() ;
	t.NewText = m.getNewText() ;
	*/

	public class PB_MsgResponse_EditMessage {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_EditMessage t = new PBFlatTypes.PB_MsgResponse_EditMessage();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_EditMessage t = new PBFlatTypes.PB_MsgResponse_EditMessage();
	*/

	/*
	PB_MsgResponse_EditMessage t = new PB_MsgResponse_EditMessage();
	*/

	public class PB_MsgParam_BroadcastNewMessage {
	   public String Text;
	   public int PeerId;
	   public int Time;
	   public PB_MessageForwardedFrom Forward;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_BroadcastNewMessage t = new PBFlatTypes.PB_MsgParam_BroadcastNewMessage();
    t.setText();
    t.setPeerId();
    t.setTime();
    t.setForward();
	*/

	/*
	PBFlatTypes.PB_MsgParam_BroadcastNewMessage t = new PBFlatTypes.PB_MsgParam_BroadcastNewMessage();
	t.Text = ;
	t.PeerId = ;
	t.Time = ;
	t.Forward = ;
	*/

	/*
	PB_MsgParam_BroadcastNewMessage t = new PB_MsgParam_BroadcastNewMessage();
	t.Text = m.getText() ;
	t.PeerId = m.getPeerId() ;
	t.Time = m.getTime() ;
	t.Forward = m.getForward() ;
	*/

	public class PB_MsgResponse_BroadcastNewMessage {
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_BroadcastNewMessage t = new PBFlatTypes.PB_MsgResponse_BroadcastNewMessage();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_BroadcastNewMessage t = new PBFlatTypes.PB_MsgResponse_BroadcastNewMessage();
	*/

	/*
	PB_MsgResponse_BroadcastNewMessage t = new PB_MsgResponse_BroadcastNewMessage();
	*/

	public class PB_MsgParam_GetFreshChatList {
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_GetFreshChatList t = new PBFlatTypes.PB_MsgParam_GetFreshChatList();
	*/

	/*
	PBFlatTypes.PB_MsgParam_GetFreshChatList t = new PBFlatTypes.PB_MsgParam_GetFreshChatList();
	*/

	/*
	PB_MsgParam_GetFreshChatList t = new PB_MsgParam_GetFreshChatList();
	*/

	public class PB_MsgResponse_GetFreshChatList {
	   public PB_ChatView Chats;
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_GetFreshChatList t = new PBFlatTypes.PB_MsgResponse_GetFreshChatList();
    t.setChats();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_GetFreshChatList t = new PBFlatTypes.PB_MsgResponse_GetFreshChatList();
	t.Chats = ;
	*/

	/*
	PB_MsgResponse_GetFreshChatList t = new PB_MsgResponse_GetFreshChatList();
	t.Chats = m.getChats() ;
	*/

	public class PB_MsgParam_GetFreshRoomMessagesList {
	   public long ChatId;
	   public String RoomKey;
	   public long Last;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_GetFreshRoomMessagesList t = new PBFlatTypes.PB_MsgParam_GetFreshRoomMessagesList();
    t.setChatId();
    t.setRoomKey();
    t.setLast();
	*/

	/*
	PBFlatTypes.PB_MsgParam_GetFreshRoomMessagesList t = new PBFlatTypes.PB_MsgParam_GetFreshRoomMessagesList();
	t.ChatId = ;
	t.RoomKey = ;
	t.Last = ;
	*/

	/*
	PB_MsgParam_GetFreshRoomMessagesList t = new PB_MsgParam_GetFreshRoomMessagesList();
	t.ChatId = m.getChatId() ;
	t.RoomKey = m.getRoomKey() ;
	t.Last = m.getLast() ;
	*/

	public class PB_MsgResponse_GetFreshRoomMessagesList {
	   public PB_MessageView Messages;
	   public boolean HasMore;
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_GetFreshRoomMessagesList t = new PBFlatTypes.PB_MsgResponse_GetFreshRoomMessagesList();
    t.setMessages();
    t.setHasMore();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_GetFreshRoomMessagesList t = new PBFlatTypes.PB_MsgResponse_GetFreshRoomMessagesList();
	t.Messages = ;
	t.HasMore = ;
	*/

	/*
	PB_MsgResponse_GetFreshRoomMessagesList t = new PB_MsgResponse_GetFreshRoomMessagesList();
	t.Messages = m.getMessages() ;
	t.HasMore = m.getHasMore() ;
	*/

	public class PB_MsgParam_Echo {
	   public String Text;
	}
	/*
	folding
	PBFlatTypes.PB_MsgParam_Echo t = new PBFlatTypes.PB_MsgParam_Echo();
    t.setText();
	*/

	/*
	PBFlatTypes.PB_MsgParam_Echo t = new PBFlatTypes.PB_MsgParam_Echo();
	t.Text = ;
	*/

	/*
	PB_MsgParam_Echo t = new PB_MsgParam_Echo();
	t.Text = m.getText() ;
	*/

	public class PB_MsgResponse_PB_MsgParam_Echo {
	   public String Text;
	}
	/*
	folding
	PBFlatTypes.PB_MsgResponse_PB_MsgParam_Echo t = new PBFlatTypes.PB_MsgResponse_PB_MsgParam_Echo();
    t.setText();
	*/

	/*
	PBFlatTypes.PB_MsgResponse_PB_MsgParam_Echo t = new PBFlatTypes.PB_MsgResponse_PB_MsgParam_Echo();
	t.Text = ;
	*/

	/*
	PB_MsgResponse_PB_MsgParam_Echo t = new PB_MsgResponse_PB_MsgParam_Echo();
	t.Text = m.getText() ;
	*/

	public class PB_SyncParam_GetDirectUpdates {
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncParam_GetDirectUpdates t = new PBFlatTypes.PB_SyncParam_GetDirectUpdates();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncParam_GetDirectUpdates t = new PBFlatTypes.PB_SyncParam_GetDirectUpdates();
	t.LastId = ;
	*/

	/*
	PB_SyncParam_GetDirectUpdates t = new PB_SyncParam_GetDirectUpdates();
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncResponse_GetDirectUpdates {
	   public PB_MessageView NewMessages;
	   public PB_MessageFileView ChatFiles;
	   public PB_ChatView Chats;
	   public PB_UserView Users;
	   public PB_UpdateMessageId MessagesChangeIds;
	   public PB_UpdateMessageToEdit MessagesToUpdate;
	   public PB_UpdateMessageToDelete MessagesToDelete;
	   public PB_UpdateMessageMeta MessagesDelivierdToServer;
	   public PB_UpdateMessageMeta MessagesDelivierdToPeer;
	   public PB_UpdateMessageMeta MessagesSeenByPeer;
	   public PB_UpdateMessageMeta MessagesDeletedFromServer;
	   public PB_UpdateRoomActionDoing RoomActionDoing;
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncResponse_GetDirectUpdates t = new PBFlatTypes.PB_SyncResponse_GetDirectUpdates();
    t.setNewMessages();
    t.setChatFiles();
    t.setChats();
    t.setUsers();
    t.setMessagesChangeIds();
    t.setMessagesToUpdate();
    t.setMessagesToDelete();
    t.setMessagesDelivierdToServer();
    t.setMessagesDelivierdToPeer();
    t.setMessagesSeenByPeer();
    t.setMessagesDeletedFromServer();
    t.setRoomActionDoing();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncResponse_GetDirectUpdates t = new PBFlatTypes.PB_SyncResponse_GetDirectUpdates();
	t.NewMessages = ;
	t.ChatFiles = ;
	t.Chats = ;
	t.Users = ;
	t.MessagesChangeIds = ;
	t.MessagesToUpdate = ;
	t.MessagesToDelete = ;
	t.MessagesDelivierdToServer = ;
	t.MessagesDelivierdToPeer = ;
	t.MessagesSeenByPeer = ;
	t.MessagesDeletedFromServer = ;
	t.RoomActionDoing = ;
	t.LastId = ;
	*/

	/*
	PB_SyncResponse_GetDirectUpdates t = new PB_SyncResponse_GetDirectUpdates();
	t.NewMessages = m.getNewMessages() ;
	t.ChatFiles = m.getChatFiles() ;
	t.Chats = m.getChats() ;
	t.Users = m.getUsers() ;
	t.MessagesChangeIds = m.getMessagesChangeIds() ;
	t.MessagesToUpdate = m.getMessagesToUpdate() ;
	t.MessagesToDelete = m.getMessagesToDelete() ;
	t.MessagesDelivierdToServer = m.getMessagesDelivierdToServer() ;
	t.MessagesDelivierdToPeer = m.getMessagesDelivierdToPeer() ;
	t.MessagesSeenByPeer = m.getMessagesSeenByPeer() ;
	t.MessagesDeletedFromServer = m.getMessagesDeletedFromServer() ;
	t.RoomActionDoing = m.getRoomActionDoing() ;
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncParam_GetGeneralUpdates {
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncParam_GetGeneralUpdates t = new PBFlatTypes.PB_SyncParam_GetGeneralUpdates();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncParam_GetGeneralUpdates t = new PBFlatTypes.PB_SyncParam_GetGeneralUpdates();
	t.LastId = ;
	*/

	/*
	PB_SyncParam_GetGeneralUpdates t = new PB_SyncParam_GetGeneralUpdates();
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncResponse_GetGeneralUpdates {
	   public PB_UpdateUserBlocked UserBlockedByMe;
	   public PB_UpdateUserBlocked UserBlockedMe;
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncResponse_GetGeneralUpdates t = new PBFlatTypes.PB_SyncResponse_GetGeneralUpdates();
    t.setUserBlockedByMe();
    t.setUserBlockedMe();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncResponse_GetGeneralUpdates t = new PBFlatTypes.PB_SyncResponse_GetGeneralUpdates();
	t.UserBlockedByMe = ;
	t.UserBlockedMe = ;
	t.LastId = ;
	*/

	/*
	PB_SyncResponse_GetGeneralUpdates t = new PB_SyncResponse_GetGeneralUpdates();
	t.UserBlockedByMe = m.getUserBlockedByMe() ;
	t.UserBlockedMe = m.getUserBlockedMe() ;
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncParam_GetNotifyUpdates {
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncParam_GetNotifyUpdates t = new PBFlatTypes.PB_SyncParam_GetNotifyUpdates();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncParam_GetNotifyUpdates t = new PBFlatTypes.PB_SyncParam_GetNotifyUpdates();
	t.LastId = ;
	*/

	/*
	PB_SyncParam_GetNotifyUpdates t = new PB_SyncParam_GetNotifyUpdates();
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncResponse_GetNotifyUpdates {
	   public PB_NotifyUpdatesView Updates;
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncResponse_GetNotifyUpdates t = new PBFlatTypes.PB_SyncResponse_GetNotifyUpdates();
    t.setUpdates();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncResponse_GetNotifyUpdates t = new PBFlatTypes.PB_SyncResponse_GetNotifyUpdates();
	t.Updates = ;
	t.LastId = ;
	*/

	/*
	PB_SyncResponse_GetNotifyUpdates t = new PB_SyncResponse_GetNotifyUpdates();
	t.Updates = m.getUpdates() ;
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncParam_SetLastSyncDirectUpdateId {
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncParam_SetLastSyncDirectUpdateId t = new PBFlatTypes.PB_SyncParam_SetLastSyncDirectUpdateId();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncParam_SetLastSyncDirectUpdateId t = new PBFlatTypes.PB_SyncParam_SetLastSyncDirectUpdateId();
	t.LastId = ;
	*/

	/*
	PB_SyncParam_SetLastSyncDirectUpdateId t = new PB_SyncParam_SetLastSyncDirectUpdateId();
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncResponse_SetLastSyncDirectUpdateId {
	}
	/*
	folding
	PBFlatTypes.PB_SyncResponse_SetLastSyncDirectUpdateId t = new PBFlatTypes.PB_SyncResponse_SetLastSyncDirectUpdateId();
	*/

	/*
	PBFlatTypes.PB_SyncResponse_SetLastSyncDirectUpdateId t = new PBFlatTypes.PB_SyncResponse_SetLastSyncDirectUpdateId();
	*/

	/*
	PB_SyncResponse_SetLastSyncDirectUpdateId t = new PB_SyncResponse_SetLastSyncDirectUpdateId();
	*/

	public class PB_SyncParam_SetLastSyncGeneralUpdateId {
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncParam_SetLastSyncGeneralUpdateId t = new PBFlatTypes.PB_SyncParam_SetLastSyncGeneralUpdateId();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncParam_SetLastSyncGeneralUpdateId t = new PBFlatTypes.PB_SyncParam_SetLastSyncGeneralUpdateId();
	t.LastId = ;
	*/

	/*
	PB_SyncParam_SetLastSyncGeneralUpdateId t = new PB_SyncParam_SetLastSyncGeneralUpdateId();
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncResponse_SetLastSyncGeneralUpdateId {
	}
	/*
	folding
	PBFlatTypes.PB_SyncResponse_SetLastSyncGeneralUpdateId t = new PBFlatTypes.PB_SyncResponse_SetLastSyncGeneralUpdateId();
	*/

	/*
	PBFlatTypes.PB_SyncResponse_SetLastSyncGeneralUpdateId t = new PBFlatTypes.PB_SyncResponse_SetLastSyncGeneralUpdateId();
	*/

	/*
	PB_SyncResponse_SetLastSyncGeneralUpdateId t = new PB_SyncResponse_SetLastSyncGeneralUpdateId();
	*/

	public class PB_SyncParam_SetLastSyncNotifyUpdateId {
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_SyncParam_SetLastSyncNotifyUpdateId t = new PBFlatTypes.PB_SyncParam_SetLastSyncNotifyUpdateId();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_SyncParam_SetLastSyncNotifyUpdateId t = new PBFlatTypes.PB_SyncParam_SetLastSyncNotifyUpdateId();
	t.LastId = ;
	*/

	/*
	PB_SyncParam_SetLastSyncNotifyUpdateId t = new PB_SyncParam_SetLastSyncNotifyUpdateId();
	t.LastId = m.getLastId() ;
	*/

	public class PB_SyncResponse_SetLastSyncNotifyUpdateId {
	}
	/*
	folding
	PBFlatTypes.PB_SyncResponse_SetLastSyncNotifyUpdateId t = new PBFlatTypes.PB_SyncResponse_SetLastSyncNotifyUpdateId();
	*/

	/*
	PBFlatTypes.PB_SyncResponse_SetLastSyncNotifyUpdateId t = new PBFlatTypes.PB_SyncResponse_SetLastSyncNotifyUpdateId();
	*/

	/*
	PB_SyncResponse_SetLastSyncNotifyUpdateId t = new PB_SyncResponse_SetLastSyncNotifyUpdateId();
	*/

	public class PB_UserParam_BlockUser {
	   public int UserId;
	   public String UserName;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_BlockUser t = new PBFlatTypes.PB_UserParam_BlockUser();
    t.setUserId();
    t.setUserName();
	*/

	/*
	PBFlatTypes.PB_UserParam_BlockUser t = new PBFlatTypes.PB_UserParam_BlockUser();
	t.UserId = ;
	t.UserName = ;
	*/

	/*
	PB_UserParam_BlockUser t = new PB_UserParam_BlockUser();
	t.UserId = m.getUserId() ;
	t.UserName = m.getUserName() ;
	*/

	public class PB_UserOfflineResponse_BlockUser {
	   public int ByUserId;
	   public int TargetUserId;
	   public String TargetUserName;
	}
	/*
	folding
	PBFlatTypes.PB_UserOfflineResponse_BlockUser t = new PBFlatTypes.PB_UserOfflineResponse_BlockUser();
    t.setByUserId();
    t.setTargetUserId();
    t.setTargetUserName();
	*/

	/*
	PBFlatTypes.PB_UserOfflineResponse_BlockUser t = new PBFlatTypes.PB_UserOfflineResponse_BlockUser();
	t.ByUserId = ;
	t.TargetUserId = ;
	t.TargetUserName = ;
	*/

	/*
	PB_UserOfflineResponse_BlockUser t = new PB_UserOfflineResponse_BlockUser();
	t.ByUserId = m.getByUserId() ;
	t.TargetUserId = m.getTargetUserId() ;
	t.TargetUserName = m.getTargetUserName() ;
	*/

	public class PB_UserParam_UnBlockUser {
	   public int Offset;
	   public int Limit;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_UnBlockUser t = new PBFlatTypes.PB_UserParam_UnBlockUser();
    t.setOffset();
    t.setLimit();
	*/

	/*
	PBFlatTypes.PB_UserParam_UnBlockUser t = new PBFlatTypes.PB_UserParam_UnBlockUser();
	t.Offset = ;
	t.Limit = ;
	*/

	/*
	PB_UserParam_UnBlockUser t = new PB_UserParam_UnBlockUser();
	t.Offset = m.getOffset() ;
	t.Limit = m.getLimit() ;
	*/

	public class PB_UserOfflineResponse_UnBlockUser {
	   public UserView Users;
	}
	/*
	folding
	PBFlatTypes.PB_UserOfflineResponse_UnBlockUser t = new PBFlatTypes.PB_UserOfflineResponse_UnBlockUser();
    t.setUsers();
	*/

	/*
	PBFlatTypes.PB_UserOfflineResponse_UnBlockUser t = new PBFlatTypes.PB_UserOfflineResponse_UnBlockUser();
	t.Users = ;
	*/

	/*
	PB_UserOfflineResponse_UnBlockUser t = new PB_UserOfflineResponse_UnBlockUser();
	t.Users = m.getUsers() ;
	*/

	public class PB_UserParam_BlockedList {
	   public int UserId;
	   public String UserName;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_BlockedList t = new PBFlatTypes.PB_UserParam_BlockedList();
    t.setUserId();
    t.setUserName();
	*/

	/*
	PBFlatTypes.PB_UserParam_BlockedList t = new PBFlatTypes.PB_UserParam_BlockedList();
	t.UserId = ;
	t.UserName = ;
	*/

	/*
	PB_UserParam_BlockedList t = new PB_UserParam_BlockedList();
	t.UserId = m.getUserId() ;
	t.UserName = m.getUserName() ;
	*/

	public class PB_UserResponse_BlockedList {
	   public int ByUserId;
	   public int TargetUserId;
	   public String TargetUserName;
	}
	/*
	folding
	PBFlatTypes.PB_UserResponse_BlockedList t = new PBFlatTypes.PB_UserResponse_BlockedList();
    t.setByUserId();
    t.setTargetUserId();
    t.setTargetUserName();
	*/

	/*
	PBFlatTypes.PB_UserResponse_BlockedList t = new PBFlatTypes.PB_UserResponse_BlockedList();
	t.ByUserId = ;
	t.TargetUserId = ;
	t.TargetUserName = ;
	*/

	/*
	PB_UserResponse_BlockedList t = new PB_UserResponse_BlockedList();
	t.ByUserId = m.getByUserId() ;
	t.TargetUserId = m.getTargetUserId() ;
	t.TargetUserName = m.getTargetUserName() ;
	*/

	public class PB_UserParam_UpdateAbout {
	   public String NewAbout;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_UpdateAbout t = new PBFlatTypes.PB_UserParam_UpdateAbout();
    t.setNewAbout();
	*/

	/*
	PBFlatTypes.PB_UserParam_UpdateAbout t = new PBFlatTypes.PB_UserParam_UpdateAbout();
	t.NewAbout = ;
	*/

	/*
	PB_UserParam_UpdateAbout t = new PB_UserParam_UpdateAbout();
	t.NewAbout = m.getNewAbout() ;
	*/

	public class PB_UserOfflineResponse_UpdateAbout {
	   public int UserId;
	   public String NewAbout;
	}
	/*
	folding
	PBFlatTypes.PB_UserOfflineResponse_UpdateAbout t = new PBFlatTypes.PB_UserOfflineResponse_UpdateAbout();
    t.setUserId();
    t.setNewAbout();
	*/

	/*
	PBFlatTypes.PB_UserOfflineResponse_UpdateAbout t = new PBFlatTypes.PB_UserOfflineResponse_UpdateAbout();
	t.UserId = ;
	t.NewAbout = ;
	*/

	/*
	PB_UserOfflineResponse_UpdateAbout t = new PB_UserOfflineResponse_UpdateAbout();
	t.UserId = m.getUserId() ;
	t.NewAbout = m.getNewAbout() ;
	*/

	public class PB_UserParam_UpdateUserName {
	   public String NewUserName;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_UpdateUserName t = new PBFlatTypes.PB_UserParam_UpdateUserName();
    t.setNewUserName();
	*/

	/*
	PBFlatTypes.PB_UserParam_UpdateUserName t = new PBFlatTypes.PB_UserParam_UpdateUserName();
	t.NewUserName = ;
	*/

	/*
	PB_UserParam_UpdateUserName t = new PB_UserParam_UpdateUserName();
	t.NewUserName = m.getNewUserName() ;
	*/

	public class PB_UserOfflineResponse_UpdateUserName {
	   public int UserId;
	   public String NewUserName;
	}
	/*
	folding
	PBFlatTypes.PB_UserOfflineResponse_UpdateUserName t = new PBFlatTypes.PB_UserOfflineResponse_UpdateUserName();
    t.setUserId();
    t.setNewUserName();
	*/

	/*
	PBFlatTypes.PB_UserOfflineResponse_UpdateUserName t = new PBFlatTypes.PB_UserOfflineResponse_UpdateUserName();
	t.UserId = ;
	t.NewUserName = ;
	*/

	/*
	PB_UserOfflineResponse_UpdateUserName t = new PB_UserOfflineResponse_UpdateUserName();
	t.UserId = m.getUserId() ;
	t.NewUserName = m.getNewUserName() ;
	*/

	public class PB_UserParam_ChangeAvatar {
	   public boolean None;
	   public byte[] ImageData2;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_ChangeAvatar t = new PBFlatTypes.PB_UserParam_ChangeAvatar();
    t.setNone();
    t.setImageData2();
	*/

	/*
	PBFlatTypes.PB_UserParam_ChangeAvatar t = new PBFlatTypes.PB_UserParam_ChangeAvatar();
	t.None = ;
	t.ImageData2 = ;
	*/

	/*
	PB_UserParam_ChangeAvatar t = new PB_UserParam_ChangeAvatar();
	t.None = m.getNone() ;
	t.ImageData2 = m.getImageData2() ;
	*/

	public class PB_UserOfflineResponse_ChangeAvatar {
	}
	/*
	folding
	PBFlatTypes.PB_UserOfflineResponse_ChangeAvatar t = new PBFlatTypes.PB_UserOfflineResponse_ChangeAvatar();
	*/

	/*
	PBFlatTypes.PB_UserOfflineResponse_ChangeAvatar t = new PBFlatTypes.PB_UserOfflineResponse_ChangeAvatar();
	*/

	/*
	PB_UserOfflineResponse_ChangeAvatar t = new PB_UserOfflineResponse_ChangeAvatar();
	*/

	public class PB_UserParam_ChangePrivacy {
	   public ProfilePrivacyLevelEnum Level;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_ChangePrivacy t = new PBFlatTypes.PB_UserParam_ChangePrivacy();
    t.setLevel();
	*/

	/*
	PBFlatTypes.PB_UserParam_ChangePrivacy t = new PBFlatTypes.PB_UserParam_ChangePrivacy();
	t.Level = ;
	*/

	/*
	PB_UserParam_ChangePrivacy t = new PB_UserParam_ChangePrivacy();
	t.Level = m.getLevel() ;
	*/

	public class PB_UserResponseOffline_ChangePrivacy {
	}
	/*
	folding
	PBFlatTypes.PB_UserResponseOffline_ChangePrivacy t = new PBFlatTypes.PB_UserResponseOffline_ChangePrivacy();
	*/

	/*
	PBFlatTypes.PB_UserResponseOffline_ChangePrivacy t = new PBFlatTypes.PB_UserResponseOffline_ChangePrivacy();
	*/

	/*
	PB_UserResponseOffline_ChangePrivacy t = new PB_UserResponseOffline_ChangePrivacy();
	*/

	public class PB_UserParam_CheckUserName {
	   public ProfilePrivacyLevelEnum Level;
	}
	/*
	folding
	PBFlatTypes.PB_UserParam_CheckUserName t = new PBFlatTypes.PB_UserParam_CheckUserName();
    t.setLevel();
	*/

	/*
	PBFlatTypes.PB_UserParam_CheckUserName t = new PBFlatTypes.PB_UserParam_CheckUserName();
	t.Level = ;
	*/

	/*
	PB_UserParam_CheckUserName t = new PB_UserParam_CheckUserName();
	t.Level = m.getLevel() ;
	*/

	public class PB_UserResponse_CheckUserName {
	}
	/*
	folding
	PBFlatTypes.PB_UserResponse_CheckUserName t = new PBFlatTypes.PB_UserResponse_CheckUserName();
	*/

	/*
	PBFlatTypes.PB_UserResponse_CheckUserName t = new PBFlatTypes.PB_UserResponse_CheckUserName();
	*/

	/*
	PB_UserResponse_CheckUserName t = new PB_UserResponse_CheckUserName();
	*/

	public class UserView {
	}
	/*
	folding
	PBFlatTypes.UserView t = new PBFlatTypes.UserView();
	*/

	/*
	PBFlatTypes.UserView t = new PBFlatTypes.UserView();
	*/

	/*
	UserView t = new UserView();
	*/

	public class PB_Chat {
	   public long ChatId;
	   public String ChatKey;
	   public int RoomTypeEnumId;
	   public int UserId;
	   public int LastSeqSeen;
	   public int LastSeqDelete;
	   public int PeerUserId;
	   public long GroupId;
	   public int CreatedTime;
	   public int CurrentSeq;
	   public long UpdatedMs;
	}
	/*
	folding
	PBFlatTypes.PB_Chat t = new PBFlatTypes.PB_Chat();
    t.setChatId();
    t.setChatKey();
    t.setRoomTypeEnumId();
    t.setUserId();
    t.setLastSeqSeen();
    t.setLastSeqDelete();
    t.setPeerUserId();
    t.setGroupId();
    t.setCreatedTime();
    t.setCurrentSeq();
    t.setUpdatedMs();
	*/

	/*
	PBFlatTypes.PB_Chat t = new PBFlatTypes.PB_Chat();
	t.ChatId = ;
	t.ChatKey = ;
	t.RoomTypeEnumId = ;
	t.UserId = ;
	t.LastSeqSeen = ;
	t.LastSeqDelete = ;
	t.PeerUserId = ;
	t.GroupId = ;
	t.CreatedTime = ;
	t.CurrentSeq = ;
	t.UpdatedMs = ;
	*/

	/*
	PB_Chat t = new PB_Chat();
	t.ChatId = m.getChatId() ;
	t.ChatKey = m.getChatKey() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.UserId = m.getUserId() ;
	t.LastSeqSeen = m.getLastSeqSeen() ;
	t.LastSeqDelete = m.getLastSeqDelete() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.GroupId = m.getGroupId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.CurrentSeq = m.getCurrentSeq() ;
	t.UpdatedMs = m.getUpdatedMs() ;
	*/

	public class PB_DirectMessage {
	   public long MessageId;
	   public String RoomKey;
	   public int UserId;
	   public long MessageFileId;
	   public int MessageTypeEnum;
	   public String Text;
	   public int Time;
	   public int PeerReceivedTime;
	   public int PeerSeenTime;
	   public int DeliviryStatusEnum;
	}
	/*
	folding
	PBFlatTypes.PB_DirectMessage t = new PBFlatTypes.PB_DirectMessage();
    t.setMessageId();
    t.setRoomKey();
    t.setUserId();
    t.setMessageFileId();
    t.setMessageTypeEnum();
    t.setText();
    t.setTime();
    t.setPeerReceivedTime();
    t.setPeerSeenTime();
    t.setDeliviryStatusEnum();
	*/

	/*
	PBFlatTypes.PB_DirectMessage t = new PBFlatTypes.PB_DirectMessage();
	t.MessageId = ;
	t.RoomKey = ;
	t.UserId = ;
	t.MessageFileId = ;
	t.MessageTypeEnum = ;
	t.Text = ;
	t.Time = ;
	t.PeerReceivedTime = ;
	t.PeerSeenTime = ;
	t.DeliviryStatusEnum = ;
	*/

	/*
	PB_DirectMessage t = new PB_DirectMessage();
	t.MessageId = m.getMessageId() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageTypeEnum = m.getMessageTypeEnum() ;
	t.Text = m.getText() ;
	t.Time = m.getTime() ;
	t.PeerReceivedTime = m.getPeerReceivedTime() ;
	t.PeerSeenTime = m.getPeerSeenTime() ;
	t.DeliviryStatusEnum = m.getDeliviryStatusEnum() ;
	*/

	public class PB_MessageFile {
	   public long MessageFileId;
	   public String Name;
	   public int Size;
	   public int FileTypeEnumId;
	   public int Width;
	   public int Height;
	   public int Duration;
	   public String Extension;
	   public String HashMd5;
	   public long HashAccess;
	   public int CreatedSe;
	   public String ServerSrc;
	   public String ServerPath;
	   public String ServerThumbPath;
	   public String BucketId;
	   public int ServerId;
	   public int CanDel;
	}
	/*
	folding
	PBFlatTypes.PB_MessageFile t = new PBFlatTypes.PB_MessageFile();
    t.setMessageFileId();
    t.setName();
    t.setSize();
    t.setFileTypeEnumId();
    t.setWidth();
    t.setHeight();
    t.setDuration();
    t.setExtension();
    t.setHashMd5();
    t.setHashAccess();
    t.setCreatedSe();
    t.setServerSrc();
    t.setServerPath();
    t.setServerThumbPath();
    t.setBucketId();
    t.setServerId();
    t.setCanDel();
	*/

	/*
	PBFlatTypes.PB_MessageFile t = new PBFlatTypes.PB_MessageFile();
	t.MessageFileId = ;
	t.Name = ;
	t.Size = ;
	t.FileTypeEnumId = ;
	t.Width = ;
	t.Height = ;
	t.Duration = ;
	t.Extension = ;
	t.HashMd5 = ;
	t.HashAccess = ;
	t.CreatedSe = ;
	t.ServerSrc = ;
	t.ServerPath = ;
	t.ServerThumbPath = ;
	t.BucketId = ;
	t.ServerId = ;
	t.CanDel = ;
	*/

	/*
	PB_MessageFile t = new PB_MessageFile();
	t.MessageFileId = m.getMessageFileId() ;
	t.Name = m.getName() ;
	t.Size = m.getSize() ;
	t.FileTypeEnumId = m.getFileTypeEnumId() ;
	t.Width = m.getWidth() ;
	t.Height = m.getHeight() ;
	t.Duration = m.getDuration() ;
	t.Extension = m.getExtension() ;
	t.HashMd5 = m.getHashMd5() ;
	t.HashAccess = m.getHashAccess() ;
	t.CreatedSe = m.getCreatedSe() ;
	t.ServerSrc = m.getServerSrc() ;
	t.ServerPath = m.getServerPath() ;
	t.ServerThumbPath = m.getServerThumbPath() ;
	t.BucketId = m.getBucketId() ;
	t.ServerId = m.getServerId() ;
	t.CanDel = m.getCanDel() ;
	*/

	public class PB_User {
	   public int Id;
	   public String UserName;
	   public String UserNameLower;
	   public String FirstName;
	   public String LastName;
	   public String About;
	   public String FullName;
	   public String AvatarUrl;
	   public int PrivacyProfile;
	   public String Phone;
	   public String Email;
	   public int IsDeleted;
	   public String PasswordHash;
	   public String PasswordSalt;
	   public int FollowersCount;
	   public int FollowingCount;
	   public int PostsCount;
	   public int MediaCount;
	   public int LikesCount;
	   public int ResharedCount;
	   public int LastActionTime;
	   public int LastPostTime;
	   public int PrimaryFollowingList;
	   public int CreatedTime;
	   public int UpdatedTime;
	   public String SessionUuid;
	   public String DeviceUuid;
	   public String LastWifiMacAddress;
	   public String LastNetworkType;
	   public int AppVersion;
	   public int LastActivityTime;
	   public int LastLoginTime;
	   public String LastIpAddress;
	}
	/*
	folding
	PBFlatTypes.PB_User t = new PBFlatTypes.PB_User();
    t.setId();
    t.setUserName();
    t.setUserNameLower();
    t.setFirstName();
    t.setLastName();
    t.setAbout();
    t.setFullName();
    t.setAvatarUrl();
    t.setPrivacyProfile();
    t.setPhone();
    t.setEmail();
    t.setIsDeleted();
    t.setPasswordHash();
    t.setPasswordSalt();
    t.setFollowersCount();
    t.setFollowingCount();
    t.setPostsCount();
    t.setMediaCount();
    t.setLikesCount();
    t.setResharedCount();
    t.setLastActionTime();
    t.setLastPostTime();
    t.setPrimaryFollowingList();
    t.setCreatedTime();
    t.setUpdatedTime();
    t.setSessionUuid();
    t.setDeviceUuid();
    t.setLastWifiMacAddress();
    t.setLastNetworkType();
    t.setAppVersion();
    t.setLastActivityTime();
    t.setLastLoginTime();
    t.setLastIpAddress();
	*/

	/*
	PBFlatTypes.PB_User t = new PBFlatTypes.PB_User();
	t.Id = ;
	t.UserName = ;
	t.UserNameLower = ;
	t.FirstName = ;
	t.LastName = ;
	t.About = ;
	t.FullName = ;
	t.AvatarUrl = ;
	t.PrivacyProfile = ;
	t.Phone = ;
	t.Email = ;
	t.IsDeleted = ;
	t.PasswordHash = ;
	t.PasswordSalt = ;
	t.FollowersCount = ;
	t.FollowingCount = ;
	t.PostsCount = ;
	t.MediaCount = ;
	t.LikesCount = ;
	t.ResharedCount = ;
	t.LastActionTime = ;
	t.LastPostTime = ;
	t.PrimaryFollowingList = ;
	t.CreatedTime = ;
	t.UpdatedTime = ;
	t.SessionUuid = ;
	t.DeviceUuid = ;
	t.LastWifiMacAddress = ;
	t.LastNetworkType = ;
	t.AppVersion = ;
	t.LastActivityTime = ;
	t.LastLoginTime = ;
	t.LastIpAddress = ;
	*/

	/*
	PB_User t = new PB_User();
	t.Id = m.getId() ;
	t.UserName = m.getUserName() ;
	t.UserNameLower = m.getUserNameLower() ;
	t.FirstName = m.getFirstName() ;
	t.LastName = m.getLastName() ;
	t.About = m.getAbout() ;
	t.FullName = m.getFullName() ;
	t.AvatarUrl = m.getAvatarUrl() ;
	t.PrivacyProfile = m.getPrivacyProfile() ;
	t.Phone = m.getPhone() ;
	t.Email = m.getEmail() ;
	t.IsDeleted = m.getIsDeleted() ;
	t.PasswordHash = m.getPasswordHash() ;
	t.PasswordSalt = m.getPasswordSalt() ;
	t.FollowersCount = m.getFollowersCount() ;
	t.FollowingCount = m.getFollowingCount() ;
	t.PostsCount = m.getPostsCount() ;
	t.MediaCount = m.getMediaCount() ;
	t.LikesCount = m.getLikesCount() ;
	t.ResharedCount = m.getResharedCount() ;
	t.LastActionTime = m.getLastActionTime() ;
	t.LastPostTime = m.getLastPostTime() ;
	t.PrimaryFollowingList = m.getPrimaryFollowingList() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.UpdatedTime = m.getUpdatedTime() ;
	t.SessionUuid = m.getSessionUuid() ;
	t.DeviceUuid = m.getDeviceUuid() ;
	t.LastWifiMacAddress = m.getLastWifiMacAddress() ;
	t.LastNetworkType = m.getLastNetworkType() ;
	t.AppVersion = m.getAppVersion() ;
	t.LastActivityTime = m.getLastActivityTime() ;
	t.LastLoginTime = m.getLastLoginTime() ;
	t.LastIpAddress = m.getLastIpAddress() ;
	*/

	public class PB_UpdateGroupParticipants {
	}
	/*
	folding
	PBFlatTypes.PB_UpdateGroupParticipants t = new PBFlatTypes.PB_UpdateGroupParticipants();
	*/

	/*
	PBFlatTypes.PB_UpdateGroupParticipants t = new PBFlatTypes.PB_UpdateGroupParticipants();
	*/

	/*
	PB_UpdateGroupParticipants t = new PB_UpdateGroupParticipants();
	*/

	public class PB_UpdateNotifySettings {
	}
	/*
	folding
	PBFlatTypes.PB_UpdateNotifySettings t = new PBFlatTypes.PB_UpdateNotifySettings();
	*/

	/*
	PBFlatTypes.PB_UpdateNotifySettings t = new PBFlatTypes.PB_UpdateNotifySettings();
	*/

	/*
	PB_UpdateNotifySettings t = new PB_UpdateNotifySettings();
	*/

	public class PB_UpdateServiceNotification {
	}
	/*
	folding
	PBFlatTypes.PB_UpdateServiceNotification t = new PBFlatTypes.PB_UpdateServiceNotification();
	*/

	/*
	PBFlatTypes.PB_UpdateServiceNotification t = new PBFlatTypes.PB_UpdateServiceNotification();
	*/

	/*
	PB_UpdateServiceNotification t = new PB_UpdateServiceNotification();
	*/

	public class PB_UpdateMessageMeta {
	   public long MessageId;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_UpdateMessageMeta t = new PBFlatTypes.PB_UpdateMessageMeta();
    t.setMessageId();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_UpdateMessageMeta t = new PBFlatTypes.PB_UpdateMessageMeta();
	t.MessageId = ;
	t.AtTime = ;
	*/

	/*
	PB_UpdateMessageMeta t = new PB_UpdateMessageMeta();
	t.MessageId = m.getMessageId() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_UpdateMessageId {
	   public long OldMessageId;
	   public long NewMessageId;
	}
	/*
	folding
	PBFlatTypes.PB_UpdateMessageId t = new PBFlatTypes.PB_UpdateMessageId();
    t.setOldMessageId();
    t.setNewMessageId();
	*/

	/*
	PBFlatTypes.PB_UpdateMessageId t = new PBFlatTypes.PB_UpdateMessageId();
	t.OldMessageId = ;
	t.NewMessageId = ;
	*/

	/*
	PB_UpdateMessageId t = new PB_UpdateMessageId();
	t.OldMessageId = m.getOldMessageId() ;
	t.NewMessageId = m.getNewMessageId() ;
	*/

	public class PB_UpdateMessageToEdit {
	   public long MessageId;
	   public String NewText;
	}
	/*
	folding
	PBFlatTypes.PB_UpdateMessageToEdit t = new PBFlatTypes.PB_UpdateMessageToEdit();
    t.setMessageId();
    t.setNewText();
	*/

	/*
	PBFlatTypes.PB_UpdateMessageToEdit t = new PBFlatTypes.PB_UpdateMessageToEdit();
	t.MessageId = ;
	t.NewText = ;
	*/

	/*
	PB_UpdateMessageToEdit t = new PB_UpdateMessageToEdit();
	t.MessageId = m.getMessageId() ;
	t.NewText = m.getNewText() ;
	*/

	public class PB_UpdateMessageToDelete {
	   public long MessageId;
	}
	/*
	folding
	PBFlatTypes.PB_UpdateMessageToDelete t = new PBFlatTypes.PB_UpdateMessageToDelete();
    t.setMessageId();
	*/

	/*
	PBFlatTypes.PB_UpdateMessageToDelete t = new PBFlatTypes.PB_UpdateMessageToDelete();
	t.MessageId = ;
	*/

	/*
	PB_UpdateMessageToDelete t = new PB_UpdateMessageToDelete();
	t.MessageId = m.getMessageId() ;
	*/

	public class PB_UpdateRoomActionDoing {
	   public String RoomKey;
	   public RoomActionDoingEnum ActionType;
	}
	/*
	folding
	PBFlatTypes.PB_UpdateRoomActionDoing t = new PBFlatTypes.PB_UpdateRoomActionDoing();
    t.setRoomKey();
    t.setActionType();
	*/

	/*
	PBFlatTypes.PB_UpdateRoomActionDoing t = new PBFlatTypes.PB_UpdateRoomActionDoing();
	t.RoomKey = ;
	t.ActionType = ;
	*/

	/*
	PB_UpdateRoomActionDoing t = new PB_UpdateRoomActionDoing();
	t.RoomKey = m.getRoomKey() ;
	t.ActionType = m.getActionType() ;
	*/

	public class PB_UpdateUserBlocked {
	   public int UserId;
	   public boolean Blocked;
	}
	/*
	folding
	PBFlatTypes.PB_UpdateUserBlocked t = new PBFlatTypes.PB_UpdateUserBlocked();
    t.setUserId();
    t.setBlocked();
	*/

	/*
	PBFlatTypes.PB_UpdateUserBlocked t = new PBFlatTypes.PB_UpdateUserBlocked();
	t.UserId = ;
	t.Blocked = ;
	*/

	/*
	PB_UpdateUserBlocked t = new PB_UpdateUserBlocked();
	t.UserId = m.getUserId() ;
	t.Blocked = m.getBlocked() ;
	*/

	public class PB_PushHolderView {
	   public PB_MessageView NewMessages;
	   public PB_MessageFileView ChatFiles;
	   public PB_ChatView Chats;
	   public PB_UserView Users;
	   public PB_UpdateMessageId MessagesChangeIds;
	   public PB_UpdateMessageToEdit MessagesToUpdate;
	   public PB_UpdateMessageToDelete MessagesToDelete;
	   public PB_UpdateMessageMeta MessagesDelivierdToServer;
	   public PB_UpdateMessageMeta MessagesDelivierdToPeer;
	   public PB_UpdateMessageMeta MessagesSeenByPeer;
	   public PB_UpdateMessageMeta MessagesDeletedFromServer;
	   public PB_UpdateRoomActionDoing RoomActionDoing;
	   public PB_UpdateUserBlocked UserBlockedByMe;
	   public PB_UpdateUserBlocked UserBlockedMe;
	}
	/*
	folding
	PBFlatTypes.PB_PushHolderView t = new PBFlatTypes.PB_PushHolderView();
    t.setNewMessages();
    t.setChatFiles();
    t.setChats();
    t.setUsers();
    t.setMessagesChangeIds();
    t.setMessagesToUpdate();
    t.setMessagesToDelete();
    t.setMessagesDelivierdToServer();
    t.setMessagesDelivierdToPeer();
    t.setMessagesSeenByPeer();
    t.setMessagesDeletedFromServer();
    t.setRoomActionDoing();
    t.setUserBlockedByMe();
    t.setUserBlockedMe();
	*/

	/*
	PBFlatTypes.PB_PushHolderView t = new PBFlatTypes.PB_PushHolderView();
	t.NewMessages = ;
	t.ChatFiles = ;
	t.Chats = ;
	t.Users = ;
	t.MessagesChangeIds = ;
	t.MessagesToUpdate = ;
	t.MessagesToDelete = ;
	t.MessagesDelivierdToServer = ;
	t.MessagesDelivierdToPeer = ;
	t.MessagesSeenByPeer = ;
	t.MessagesDeletedFromServer = ;
	t.RoomActionDoing = ;
	t.UserBlockedByMe = ;
	t.UserBlockedMe = ;
	*/

	/*
	PB_PushHolderView t = new PB_PushHolderView();
	t.NewMessages = m.getNewMessages() ;
	t.ChatFiles = m.getChatFiles() ;
	t.Chats = m.getChats() ;
	t.Users = m.getUsers() ;
	t.MessagesChangeIds = m.getMessagesChangeIds() ;
	t.MessagesToUpdate = m.getMessagesToUpdate() ;
	t.MessagesToDelete = m.getMessagesToDelete() ;
	t.MessagesDelivierdToServer = m.getMessagesDelivierdToServer() ;
	t.MessagesDelivierdToPeer = m.getMessagesDelivierdToPeer() ;
	t.MessagesSeenByPeer = m.getMessagesSeenByPeer() ;
	t.MessagesDeletedFromServer = m.getMessagesDeletedFromServer() ;
	t.RoomActionDoing = m.getRoomActionDoing() ;
	t.UserBlockedByMe = m.getUserBlockedByMe() ;
	t.UserBlockedMe = m.getUserBlockedMe() ;
	*/

	public class PB_DirectUpdatesView {
	   public PB_MessageView NewMessages;
	   public PB_MessageFileView ChatFiles;
	   public PB_ChatView Chats;
	   public PB_UserView Users;
	   public PB_UpdateMessageId MessagesChangeIds;
	   public PB_UpdateMessageToEdit MessagesToUpdate;
	   public PB_UpdateMessageToDelete MessagesToDelete;
	   public PB_UpdateMessageMeta MessagesDelivierdToServer;
	   public PB_UpdateMessageMeta MessagesDelivierdToPeer;
	   public PB_UpdateMessageMeta MessagesSeenByPeer;
	   public PB_UpdateMessageMeta MessagesDeletedFromServer;
	   public PB_UpdateRoomActionDoing RoomActionDoing;
	}
	/*
	folding
	PBFlatTypes.PB_DirectUpdatesView t = new PBFlatTypes.PB_DirectUpdatesView();
    t.setNewMessages();
    t.setChatFiles();
    t.setChats();
    t.setUsers();
    t.setMessagesChangeIds();
    t.setMessagesToUpdate();
    t.setMessagesToDelete();
    t.setMessagesDelivierdToServer();
    t.setMessagesDelivierdToPeer();
    t.setMessagesSeenByPeer();
    t.setMessagesDeletedFromServer();
    t.setRoomActionDoing();
	*/

	/*
	PBFlatTypes.PB_DirectUpdatesView t = new PBFlatTypes.PB_DirectUpdatesView();
	t.NewMessages = ;
	t.ChatFiles = ;
	t.Chats = ;
	t.Users = ;
	t.MessagesChangeIds = ;
	t.MessagesToUpdate = ;
	t.MessagesToDelete = ;
	t.MessagesDelivierdToServer = ;
	t.MessagesDelivierdToPeer = ;
	t.MessagesSeenByPeer = ;
	t.MessagesDeletedFromServer = ;
	t.RoomActionDoing = ;
	*/

	/*
	PB_DirectUpdatesView t = new PB_DirectUpdatesView();
	t.NewMessages = m.getNewMessages() ;
	t.ChatFiles = m.getChatFiles() ;
	t.Chats = m.getChats() ;
	t.Users = m.getUsers() ;
	t.MessagesChangeIds = m.getMessagesChangeIds() ;
	t.MessagesToUpdate = m.getMessagesToUpdate() ;
	t.MessagesToDelete = m.getMessagesToDelete() ;
	t.MessagesDelivierdToServer = m.getMessagesDelivierdToServer() ;
	t.MessagesDelivierdToPeer = m.getMessagesDelivierdToPeer() ;
	t.MessagesSeenByPeer = m.getMessagesSeenByPeer() ;
	t.MessagesDeletedFromServer = m.getMessagesDeletedFromServer() ;
	t.RoomActionDoing = m.getRoomActionDoing() ;
	*/

	public class PB_GeneralUpdatesView {
	   public PB_UpdateUserBlocked UserBlockedByMe;
	   public PB_UpdateUserBlocked UserBlockedMe;
	}
	/*
	folding
	PBFlatTypes.PB_GeneralUpdatesView t = new PBFlatTypes.PB_GeneralUpdatesView();
    t.setUserBlockedByMe();
    t.setUserBlockedMe();
	*/

	/*
	PBFlatTypes.PB_GeneralUpdatesView t = new PBFlatTypes.PB_GeneralUpdatesView();
	t.UserBlockedByMe = ;
	t.UserBlockedMe = ;
	*/

	/*
	PB_GeneralUpdatesView t = new PB_GeneralUpdatesView();
	t.UserBlockedByMe = m.getUserBlockedByMe() ;
	t.UserBlockedMe = m.getUserBlockedMe() ;
	*/

	public class PB_NotifyUpdatesView {
	   public PB_UpdateUserBlocked UserBlockedByMe;
	   public PB_UpdateUserBlocked UserBlockedMe;
	}
	/*
	folding
	PBFlatTypes.PB_NotifyUpdatesView t = new PBFlatTypes.PB_NotifyUpdatesView();
    t.setUserBlockedByMe();
    t.setUserBlockedMe();
	*/

	/*
	PBFlatTypes.PB_NotifyUpdatesView t = new PBFlatTypes.PB_NotifyUpdatesView();
	t.UserBlockedByMe = ;
	t.UserBlockedMe = ;
	*/

	/*
	PB_NotifyUpdatesView t = new PB_NotifyUpdatesView();
	t.UserBlockedByMe = m.getUserBlockedByMe() ;
	t.UserBlockedMe = m.getUserBlockedMe() ;
	*/

	public class PB_ChatView {
	   public String ChatKey;
	   public long ChatId;
	   public int RoomTypeEnumId;
	   public int UserId;
	   public int PeerUserId;
	   public long GroupId;
	   public int CreatedTime;
	   public long UpdatedMs;
	   public long LastMessageId;
	   public long LastDeletedMessageId;
	   public long LastSeenMessageId;
	   public int LastSeqSeen;
	   public int LastSeqDelete;
	   public int CurrentSeq;
	   public PB_UserView UserView;
	   public int SharedMediaCount;
	   public int UnseenCount;
	   public PB_MessageView FirstUnreadMessage;
	   public PB_MessageView LastMessage;
	}
	/*
	folding
	PBFlatTypes.PB_ChatView t = new PBFlatTypes.PB_ChatView();
    t.setChatKey();
    t.setChatId();
    t.setRoomTypeEnumId();
    t.setUserId();
    t.setPeerUserId();
    t.setGroupId();
    t.setCreatedTime();
    t.setUpdatedMs();
    t.setLastMessageId();
    t.setLastDeletedMessageId();
    t.setLastSeenMessageId();
    t.setLastSeqSeen();
    t.setLastSeqDelete();
    t.setCurrentSeq();
    t.setUserView();
    t.setSharedMediaCount();
    t.setUnseenCount();
    t.setFirstUnreadMessage();
    t.setLastMessage();
	*/

	/*
	PBFlatTypes.PB_ChatView t = new PBFlatTypes.PB_ChatView();
	t.ChatKey = ;
	t.ChatId = ;
	t.RoomTypeEnumId = ;
	t.UserId = ;
	t.PeerUserId = ;
	t.GroupId = ;
	t.CreatedTime = ;
	t.UpdatedMs = ;
	t.LastMessageId = ;
	t.LastDeletedMessageId = ;
	t.LastSeenMessageId = ;
	t.LastSeqSeen = ;
	t.LastSeqDelete = ;
	t.CurrentSeq = ;
	t.UserView = ;
	t.SharedMediaCount = ;
	t.UnseenCount = ;
	t.FirstUnreadMessage = ;
	t.LastMessage = ;
	*/

	/*
	PB_ChatView t = new PB_ChatView();
	t.ChatKey = m.getChatKey() ;
	t.ChatId = m.getChatId() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.UserId = m.getUserId() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.GroupId = m.getGroupId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.UpdatedMs = m.getUpdatedMs() ;
	t.LastMessageId = m.getLastMessageId() ;
	t.LastDeletedMessageId = m.getLastDeletedMessageId() ;
	t.LastSeenMessageId = m.getLastSeenMessageId() ;
	t.LastSeqSeen = m.getLastSeqSeen() ;
	t.LastSeqDelete = m.getLastSeqDelete() ;
	t.CurrentSeq = m.getCurrentSeq() ;
	t.UserView = m.getUserView() ;
	t.SharedMediaCount = m.getSharedMediaCount() ;
	t.UnseenCount = m.getUnseenCount() ;
	t.FirstUnreadMessage = m.getFirstUnreadMessage() ;
	t.LastMessage = m.getLastMessage() ;
	*/

	public class PB_MessageView {
	   public long MessageId;
	   public String RoomKey;
	   public int UserId;
	   public long MessageFileId;
	   public int MessageTypeEnumId;
	   public String Text;
	   public int Time;
	   public int PeerReceivedTime;
	   public int PeerSeenTime;
	   public int DeliviryStatusEnumId;
	   public long ChatId;
	   public int RoomTypeEnumId;
	   public boolean IsByMe;
	   public long RemoteId;
	   public PB_MessageFileView MessageFileView;
	}
	/*
	folding
	PBFlatTypes.PB_MessageView t = new PBFlatTypes.PB_MessageView();
    t.setMessageId();
    t.setRoomKey();
    t.setUserId();
    t.setMessageFileId();
    t.setMessageTypeEnumId();
    t.setText();
    t.setTime();
    t.setPeerReceivedTime();
    t.setPeerSeenTime();
    t.setDeliviryStatusEnumId();
    t.setChatId();
    t.setRoomTypeEnumId();
    t.setIsByMe();
    t.setRemoteId();
    t.setMessageFileView();
	*/

	/*
	PBFlatTypes.PB_MessageView t = new PBFlatTypes.PB_MessageView();
	t.MessageId = ;
	t.RoomKey = ;
	t.UserId = ;
	t.MessageFileId = ;
	t.MessageTypeEnumId = ;
	t.Text = ;
	t.Time = ;
	t.PeerReceivedTime = ;
	t.PeerSeenTime = ;
	t.DeliviryStatusEnumId = ;
	t.ChatId = ;
	t.RoomTypeEnumId = ;
	t.IsByMe = ;
	t.RemoteId = ;
	t.MessageFileView = ;
	*/

	/*
	PB_MessageView t = new PB_MessageView();
	t.MessageId = m.getMessageId() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageTypeEnumId = m.getMessageTypeEnumId() ;
	t.Text = m.getText() ;
	t.Time = m.getTime() ;
	t.PeerReceivedTime = m.getPeerReceivedTime() ;
	t.PeerSeenTime = m.getPeerSeenTime() ;
	t.DeliviryStatusEnumId = m.getDeliviryStatusEnumId() ;
	t.ChatId = m.getChatId() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.IsByMe = m.getIsByMe() ;
	t.RemoteId = m.getRemoteId() ;
	t.MessageFileView = m.getMessageFileView() ;
	*/

	public class PB_MessageFileView {
	   public long MessageFileId;
	   public int OriginalUserId;
	   public String Name;
	   public int Size;
	   public int FileTypeEnumId;
	   public int Width;
	   public int Height;
	   public int Duration;
	   public String Extension;
	   public String HashMd5;
	   public long HashAccess;
	   public int CreatedSe;
	   public String ServerSrc;
	   public String ServerPath;
	   public String ServerThumbPath;
	   public String BucketId;
	   public int ServerId;
	   public int CanDel;
	   public String ServerThumbLocalSrc;
	   public long RemoteMessageFileId;
	   public String LocalSrc;
	   public String ThumbLocalSrc;
	   public String MessageFileStatusId;
	}
	/*
	folding
	PBFlatTypes.PB_MessageFileView t = new PBFlatTypes.PB_MessageFileView();
    t.setMessageFileId();
    t.setOriginalUserId();
    t.setName();
    t.setSize();
    t.setFileTypeEnumId();
    t.setWidth();
    t.setHeight();
    t.setDuration();
    t.setExtension();
    t.setHashMd5();
    t.setHashAccess();
    t.setCreatedSe();
    t.setServerSrc();
    t.setServerPath();
    t.setServerThumbPath();
    t.setBucketId();
    t.setServerId();
    t.setCanDel();
    t.setServerThumbLocalSrc();
    t.setRemoteMessageFileId();
    t.setLocalSrc();
    t.setThumbLocalSrc();
    t.setMessageFileStatusId();
	*/

	/*
	PBFlatTypes.PB_MessageFileView t = new PBFlatTypes.PB_MessageFileView();
	t.MessageFileId = ;
	t.OriginalUserId = ;
	t.Name = ;
	t.Size = ;
	t.FileTypeEnumId = ;
	t.Width = ;
	t.Height = ;
	t.Duration = ;
	t.Extension = ;
	t.HashMd5 = ;
	t.HashAccess = ;
	t.CreatedSe = ;
	t.ServerSrc = ;
	t.ServerPath = ;
	t.ServerThumbPath = ;
	t.BucketId = ;
	t.ServerId = ;
	t.CanDel = ;
	t.ServerThumbLocalSrc = ;
	t.RemoteMessageFileId = ;
	t.LocalSrc = ;
	t.ThumbLocalSrc = ;
	t.MessageFileStatusId = ;
	*/

	/*
	PB_MessageFileView t = new PB_MessageFileView();
	t.MessageFileId = m.getMessageFileId() ;
	t.OriginalUserId = m.getOriginalUserId() ;
	t.Name = m.getName() ;
	t.Size = m.getSize() ;
	t.FileTypeEnumId = m.getFileTypeEnumId() ;
	t.Width = m.getWidth() ;
	t.Height = m.getHeight() ;
	t.Duration = m.getDuration() ;
	t.Extension = m.getExtension() ;
	t.HashMd5 = m.getHashMd5() ;
	t.HashAccess = m.getHashAccess() ;
	t.CreatedSe = m.getCreatedSe() ;
	t.ServerSrc = m.getServerSrc() ;
	t.ServerPath = m.getServerPath() ;
	t.ServerThumbPath = m.getServerThumbPath() ;
	t.BucketId = m.getBucketId() ;
	t.ServerId = m.getServerId() ;
	t.CanDel = m.getCanDel() ;
	t.ServerThumbLocalSrc = m.getServerThumbLocalSrc() ;
	t.RemoteMessageFileId = m.getRemoteMessageFileId() ;
	t.LocalSrc = m.getLocalSrc() ;
	t.ThumbLocalSrc = m.getThumbLocalSrc() ;
	t.MessageFileStatusId = m.getMessageFileStatusId() ;
	*/

	public class PB_UserView {
	   public int UserId;
	   public String UserName;
	   public String FirstName;
	   public String LastName;
	   public String About;
	   public String FullName;
	   public String AvatarUrl;
	   public int PrivacyProfile;
	   public int IsDeleted;
	   public int FollowersCount;
	   public int FollowingCount;
	   public int PostsCount;
	   public int UpdatedTime;
	   public int AppVersion;
	   public int LastActivityTime;
	   public int FollowingType;
	}
	/*
	folding
	PBFlatTypes.PB_UserView t = new PBFlatTypes.PB_UserView();
    t.setUserId();
    t.setUserName();
    t.setFirstName();
    t.setLastName();
    t.setAbout();
    t.setFullName();
    t.setAvatarUrl();
    t.setPrivacyProfile();
    t.setIsDeleted();
    t.setFollowersCount();
    t.setFollowingCount();
    t.setPostsCount();
    t.setUpdatedTime();
    t.setAppVersion();
    t.setLastActivityTime();
    t.setFollowingType();
	*/

	/*
	PBFlatTypes.PB_UserView t = new PBFlatTypes.PB_UserView();
	t.UserId = ;
	t.UserName = ;
	t.FirstName = ;
	t.LastName = ;
	t.About = ;
	t.FullName = ;
	t.AvatarUrl = ;
	t.PrivacyProfile = ;
	t.IsDeleted = ;
	t.FollowersCount = ;
	t.FollowingCount = ;
	t.PostsCount = ;
	t.UpdatedTime = ;
	t.AppVersion = ;
	t.LastActivityTime = ;
	t.FollowingType = ;
	*/

	/*
	PB_UserView t = new PB_UserView();
	t.UserId = m.getUserId() ;
	t.UserName = m.getUserName() ;
	t.FirstName = m.getFirstName() ;
	t.LastName = m.getLastName() ;
	t.About = m.getAbout() ;
	t.FullName = m.getFullName() ;
	t.AvatarUrl = m.getAvatarUrl() ;
	t.PrivacyProfile = m.getPrivacyProfile() ;
	t.IsDeleted = m.getIsDeleted() ;
	t.FollowersCount = m.getFollowersCount() ;
	t.FollowingCount = m.getFollowingCount() ;
	t.PostsCount = m.getPostsCount() ;
	t.UpdatedTime = m.getUpdatedTime() ;
	t.AppVersion = m.getAppVersion() ;
	t.LastActivityTime = m.getLastActivityTime() ;
	t.FollowingType = m.getFollowingType() ;
	*/

	
}

/*

RPC_HANDLERS.RPC_MessageReq RPC_MessageReq_Handeler = null;
RPC_HANDLERS.RPC_MessageReqOffline RPC_MessageReqOffline_Handeler = null;
RPC_HANDLERS.RPC_Auth RPC_Auth_Handeler = null;
RPC_HANDLERS.RPC_Msg RPC_Msg_Handeler = null;
RPC_HANDLERS.RPC_Sync RPC_Sync_Handeler = null;
RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_HANDLERS.RPC_User RPC_User_Handeler = null;
	
*/