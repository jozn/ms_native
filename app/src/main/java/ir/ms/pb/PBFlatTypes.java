package ir.ms.pb

public class PBFlatTypes {

	public class GeoLocation {
	   public double Lat;
	   public double Lon;
	}

	public class RoomMessageLog {
	   public RoomMessageLogEnum typ;
	   public long TargetUserId;
	   public long ByUserId;
	}

	public class RoomMessageForwardFrom {
	   public long RoomId;
	   public long MessageId;
	   public int RoomTypeEnum;
	}

	public class RoomDraft {
	   public String Message;
	   public long ReplyTo;
	}

	public class ChatRoom {
	}

	public class Pagination {
	   public int Offset;
	   public int Limit;
	}

	public class PB_RoomInlineView {
	   public long RoomId;
	   public RoomTypeEnum RoomTypeEnum;
	}

	public class PB_MessageForwardedFrom {
	   public long RoomId;
	   public RoomTypeEnum RoomTypeEnum;
	   public long MessageId;
	   public int MessageSeq;
	}

	public class PB_MessageView {
	   public long MessageId;
	   public String RoomKey;
	   public int UserId;
	   public long MessageFileId;
	   public int MessageTypeEnum;
	   public String Text;
	   public long CreatedMs;
	   public int PeerReceivedTime;
	   public int PeerSeenTime;
	   public int DeliviryStatusEnum;
	   public int PeerUserId;
	}

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

	public class PB_GroupMemberView {
	   public long Id;
	   public long GroupId;
	   public int UserId;
	   public int ByUserId;
	   public int GroupRoleEnum;
	   public int CreatedTime;
	}

	public class PB_MessageFileView {
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

	public class PB_ReqLastChangesForTheRoom {
	   public long RoomId;
	   public long LastLogId;
	   public int LastHaveSeq;
	}

	public class PB_ResponseLastChangesForTheRoom {
	   public PB_MessageView Messages;
	}

	public class PB_RequestSetLastSeenMessages {
	   public long RoomId;
	   public long FromMessageId;
	   public int ToMessageId;
	   public long AtTimeMs;
	}

	public class PB_ResponseSetLastSeenMessages {
	   public PB_MessageView Messages;
	}

	public class PB_MessagesCollections {
	   public long DirectMessagesIds;
	   public long GroupMessagesIds;
	   public long BroadCatMessagesIds;
	}

	public class PB_DirectLogView {
	   public PB_DirectLog Row;
	   public PB_MessageView NewMessage;
	}

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

	public class PB_PushDirectLogsMany {
	   public PB_DirectLogView Rows;
	}

	public class PB_CommandToServer {
	   public long ClientCallId;
	   public String Command;
	   public byte[] Data;
	}

	public class PB_CommandToClient {
	   public long ServerCallId;
	   public String Command;
	   public byte[] Data;
	}

	public class PB_CommandReceivedToServer {
	   public long ClientCallId;
	}

	public class PB_CommandReceivedToClient {
	   public long ServerCallId;
	}

	public class PB_ResToClient {
	   public long ClientCallId;
	   public String PBClass;
	   public byte[] Data;
	}

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

	public class PB_Response {
	   public int Status;
	}

	public class PB_Request {
	   public int Status;
	}

	public class PB_RequestMsgAddMany {
	   public PB_Request Request;
	   public PB_Message Messages;
	}

	public class PB_ResponseMsgAddMany {
	   public PB_Response Response;
	}

	public class PB_Push {
	   public int Status;
	}

	public class PB_Result {
	   public int Status;
	}

	public class PB_PushMsgAddMany {
	   public PB_Push Push;
	   public PB_Message Messages;
	   public PB_UserWithMe Users;
	}

	public class PB_ResultMsgAddMany {
	   public PB_Result Result;
	}

	public class PB_MsgEvent {
	   public String MessageKey;
	   public String RoomKey;
	   public long PeerUserId;
	   public int EventType;
	   public long AtTime;
	}

	public class PB_PushMsgEvents {
	   public PB_Push Push;
	   public PB_MsgEvent Events;
	}

	public class PB_ResultMsgEvents {
	   public PB_Result Result;
	}

	public class PB_UserParam_CheckUserName2 {
	}

	public class PB_UserResponse_CheckUserName2 {
	}

	public class PB_MsgParam_AddNewTextMessage {
	   public String Text;
	   public int PeerId;
	   public int Time;
	   public long ReplyToMessageId;
	   public PB_MessageForwardedFrom Forward;
	}

	public class PB_MsgResponse_AddNewTextMessage {
	}

	public class PB_MsgParam_SetRoomActionDoing {
	   public long GroupId;
	   public String DirectRoomKey;
	   public RoomActionDoingEnum ActionType;
	}

	public class PB_MsgResponse_SetRoomActionDoing {
	}

	public class PB_MsgParam_GetMessagesByIds {
	   public PB_MessagesCollections MessagesCollections;
	}

	public class PB_MsgResponse_GetMessagesByIds {
	   public PB_MessageView MessagesViews;
	}

	public class PB_MsgParam_GetMessagesHistory {
	   public long ChatId;
	   public int FromSeq;
	   public int EndSeq;
	}

	public class PB_MsgResponse_GetMessagesHistory {
	   public PB_MessageView MessagesViews;
	}

	public class PB_MsgParam_SetChatMessagesRangeAsSeen {
	   public long ChatId;
	   public int FromSeq;
	   public int EndSeq;
	   public long SeenTimeMs;
	}

	public class PB_MsgResponse_SetChatMessagesRangeAsSeen {
	}

	public class PB_MsgParam_DeleteChatHistory {
	   public long ChatId;
	   public int ToSeq;
	}

	public class PB_MsgResponse_DeleteChatHistory {
	}

	public class PB_MsgParam_DeleteMessagesByIds {
	   public PB_MessagesCollections MessagesCollections;
	}

	public class PB_MsgResponse_DeleteMessagesByIds {
	}

	public class PB_MsgParam_SetMessagesAsReceived {
	   public PB_MessagesCollections MessagesCollections;
	}

	public class PB_MsgResponse_SetMessagesAsReceived {
	}

	public class PB_MsgParam_ForwardMessages {
	   public PB_MessagesCollections MessagesCollections;
	   public long ToDirectChatIds;
	   public long ToGroupChatIds;
	}

	public class PB_MsgResponse_ForwardMessages {
	}

	public class PB_MsgParam_EditMessage {
	   public long ChatId;
	   public RoomTypeEnum RoomType;
	   public long MessageId;
	   public String NewText;
	}

	public class PB_MsgResponse_EditMessage {
	}

	public class PB_MsgParam_BroadcastNewMessage {
	   public String Text;
	   public int PeerId;
	   public int Time;
	   public PB_MessageForwardedFrom Forward;
	}

	public class PB_MsgResponse_BroadcastNewMessage {
	}

	public class PB_MsgParam_Echo {
	   public String Text;
	}

	public class PB_MsgResponse_PB_MsgParam_Echo {
	   public String Text;
	}

	public class PB_UserParam_BlockUser {
	   public int UserId;
	   public String UserName;
	}

	public class PB_UserOfflineResponse_BlockUser {
	   public int ByUserId;
	   public int TargetUserId;
	   public String TargetUserName;
	}

	public class PB_UserParam_UnBlockUser {
	   public int Offset;
	   public int Limit;
	}

	public class PB_UserOfflineResponse_UnBlockUser {
	   public UserView Users;
	}

	public class PB_UserParam_BlockedList {
	   public int UserId;
	   public String UserName;
	}

	public class PB_UserResponse_BlockedList {
	   public int ByUserId;
	   public int TargetUserId;
	   public String TargetUserName;
	}

	public class PB_UserParam_UpdateAbout {
	   public String NewAbout;
	}

	public class PB_UserOfflineResponse_UpdateAbout {
	   public int UserId;
	   public String NewAbout;
	}

	public class PB_UserParam_UpdateUserName {
	   public String NewUserName;
	}

	public class PB_UserOfflineResponse_UpdateUserName {
	   public int UserId;
	   public String NewUserName;
	}

	public class PB_UserParam_ChangeAvatar {
	   public boolean None;
	   public byte[] ImageData2;
	}

	public class PB_UserOfflineResponse_ChangeAvatar {
	}

	public class PB_UserParam_ChangePrivacy {
	   public ProfilePrivacyLevelEnum Level;
	}

	public class PB_UserResponseOffline_ChangePrivacy {
	}

	public class PB_UserParam_CheckUserName {
	   public ProfilePrivacyLevelEnum Level;
	}

	public class PB_UserResponse_CheckUserName {
	}

	public class UserView {
	}

	public class PB_UpdateNewMessage {
	   public PB_MessageView Message;
	}

	public class PB_UpdateMessageId {
	   public long OldMessageId;
	   public long NewMessageId;
	}

	public class PB_UpdateSeenMessages {
	   public long MessageIds;
	   public long AtTime;
	}

	public class PB_UpdateDelivierdMessages {
	   public long MessageIds;
	   public long AtTime;
	}

	public class PB_UpdateDeletedFromServerMessages {
	   public long MessageIds;
	   public long AtTime;
	}

	public class PB_UpdateDeleteMessages {
	   public long MessageIds;
	}

	public class PB_UpdateRestoreMessage {
	   public long MessageIds;
	}

	public class PB_UpdateRoomActionDoing {
	   public String RoomKey;
	   public RoomActionDoingEnum ActionType;
	}

	public class PB_UpdateGroupParticipants {
	}

	public class PB_UpdateUserBlocked {
	   public int UserId;
	   public boolean Blocked;
	}

	public class PB_UpdateNotifySettings {
	}

	public class PB_UpdateServiceNotification {
	}

	public class PB_UpdateEditMessage {
	   public long MessageId;
	   public String NewText;
	}

	
}
/*

RPC_INTERFACES.RPC_MessageReq RPC_MessageReq_Handeler = null;
RPC_INTERFACES.RPC_MessageReqOffline RPC_MessageReqOffline_Handeler = null;
RPC_INTERFACES.RPC_Auth RPC_Auth_Handeler = null;
RPC_INTERFACES.RPC_Msg RPC_Msg_Handeler = null;
RPC_INTERFACES.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_INTERFACES.RPC_User RPC_User_Handeler = null;
	
*/