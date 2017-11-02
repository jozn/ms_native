package ir.ms.pb;

public class PBFlatTypes {

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

	public class PB_Offline_NewDirectMessage {
	   public String ChatKey;
	   public long FromMessageId;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_NewDirectMessage t = new PBFlatTypes.PB_Offline_NewDirectMessage();
    t.setChatKey();
    t.setFromMessageId();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_Offline_NewDirectMessage t = new PBFlatTypes.PB_Offline_NewDirectMessage();
	t.ChatKey = ;
	t.FromMessageId = ;
	t.AtTime = ;
	*/

	/*
	PB_Offline_NewDirectMessage t = new PB_Offline_NewDirectMessage();
	t.ChatKey = m.getChatKey() ;
	t.FromMessageId = m.getFromMessageId() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_Offline_MessagesReachedServer {
	   public String MessageKeys;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_MessagesReachedServer t = new PBFlatTypes.PB_Offline_MessagesReachedServer();
    t.setMessageKeys();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_Offline_MessagesReachedServer t = new PBFlatTypes.PB_Offline_MessagesReachedServer();
	t.MessageKeys = ;
	t.AtTime = ;
	*/

	/*
	PB_Offline_MessagesReachedServer t = new PB_Offline_MessagesReachedServer();
	t.MessageKeys = m.getMessageKeys() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_Offline_MessagesDeliveredToUser {
	   public String MessageKeys;
	   public long MessageIds;
	   public String RoomKey;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_MessagesDeliveredToUser t = new PBFlatTypes.PB_Offline_MessagesDeliveredToUser();
    t.setMessageKeys();
    t.setMessageIds();
    t.setRoomKey();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_Offline_MessagesDeliveredToUser t = new PBFlatTypes.PB_Offline_MessagesDeliveredToUser();
	t.MessageKeys = ;
	t.MessageIds = ;
	t.RoomKey = ;
	t.AtTime = ;
	*/

	/*
	PB_Offline_MessagesDeliveredToUser t = new PB_Offline_MessagesDeliveredToUser();
	t.MessageKeys = m.getMessageKeys() ;
	t.MessageIds = m.getMessageIds() ;
	t.RoomKey = m.getRoomKey() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_Offline_MessagesSeenByPeer {
	   public String MessageKeys;
	   public long MessageIds;
	   public String RoomKey;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_MessagesSeenByPeer t = new PBFlatTypes.PB_Offline_MessagesSeenByPeer();
    t.setMessageKeys();
    t.setMessageIds();
    t.setRoomKey();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_Offline_MessagesSeenByPeer t = new PBFlatTypes.PB_Offline_MessagesSeenByPeer();
	t.MessageKeys = ;
	t.MessageIds = ;
	t.RoomKey = ;
	t.AtTime = ;
	*/

	/*
	PB_Offline_MessagesSeenByPeer t = new PB_Offline_MessagesSeenByPeer();
	t.MessageKeys = m.getMessageKeys() ;
	t.MessageIds = m.getMessageIds() ;
	t.RoomKey = m.getRoomKey() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_Offline_MessagesDeletedFromServer {
	   public String MessageKeys;
	   public long MessageIds;
	   public long AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_MessagesDeletedFromServer t = new PBFlatTypes.PB_Offline_MessagesDeletedFromServer();
    t.setMessageKeys();
    t.setMessageIds();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_Offline_MessagesDeletedFromServer t = new PBFlatTypes.PB_Offline_MessagesDeletedFromServer();
	t.MessageKeys = ;
	t.MessageIds = ;
	t.AtTime = ;
	*/

	/*
	PB_Offline_MessagesDeletedFromServer t = new PB_Offline_MessagesDeletedFromServer();
	t.MessageKeys = m.getMessageKeys() ;
	t.MessageIds = m.getMessageIds() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_Offline_ChangeMessageId {
	   public String MessageKey;
	   public long NewMessageId;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_ChangeMessageId t = new PBFlatTypes.PB_Offline_ChangeMessageId();
    t.setMessageKey();
    t.setNewMessageId();
	*/

	/*
	PBFlatTypes.PB_Offline_ChangeMessageId t = new PBFlatTypes.PB_Offline_ChangeMessageId();
	t.MessageKey = ;
	t.NewMessageId = ;
	*/

	/*
	PB_Offline_ChangeMessageId t = new PB_Offline_ChangeMessageId();
	t.MessageKey = m.getMessageKey() ;
	t.NewMessageId = m.getNewMessageId() ;
	*/

	public class PB_Offline_ChangeMessageFileId {
	   public String MessageFileKey;
	   public long NewMessageFileId;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_ChangeMessageFileId t = new PBFlatTypes.PB_Offline_ChangeMessageFileId();
    t.setMessageFileKey();
    t.setNewMessageFileId();
	*/

	/*
	PBFlatTypes.PB_Offline_ChangeMessageFileId t = new PBFlatTypes.PB_Offline_ChangeMessageFileId();
	t.MessageFileKey = ;
	t.NewMessageFileId = ;
	*/

	/*
	PB_Offline_ChangeMessageFileId t = new PB_Offline_ChangeMessageFileId();
	t.MessageFileKey = m.getMessageFileKey() ;
	t.NewMessageFileId = m.getNewMessageFileId() ;
	*/

	public class PB_Offline_MessageToEdit {
	   public long MessageKey;
	   public String NewText;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_MessageToEdit t = new PBFlatTypes.PB_Offline_MessageToEdit();
    t.setMessageKey();
    t.setNewText();
	*/

	/*
	PBFlatTypes.PB_Offline_MessageToEdit t = new PBFlatTypes.PB_Offline_MessageToEdit();
	t.MessageKey = ;
	t.NewText = ;
	*/

	/*
	PB_Offline_MessageToEdit t = new PB_Offline_MessageToEdit();
	t.MessageKey = m.getMessageKey() ;
	t.NewText = m.getNewText() ;
	*/

	public class PB_Offline_MessageToDelete {
	   public long MessageKey;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_MessageToDelete t = new PBFlatTypes.PB_Offline_MessageToDelete();
    t.setMessageKey();
	*/

	/*
	PBFlatTypes.PB_Offline_MessageToDelete t = new PBFlatTypes.PB_Offline_MessageToDelete();
	t.MessageKey = ;
	*/

	/*
	PB_Offline_MessageToDelete t = new PB_Offline_MessageToDelete();
	t.MessageKey = m.getMessageKey() ;
	*/

	public class PB_Online_RoomActionDoing {
	   public String RoomKey;
	   public RoomActionDoingEnum ActionType;
	}
	/*
	folding
	PBFlatTypes.PB_Online_RoomActionDoing t = new PBFlatTypes.PB_Online_RoomActionDoing();
    t.setRoomKey();
    t.setActionType();
	*/

	/*
	PBFlatTypes.PB_Online_RoomActionDoing t = new PBFlatTypes.PB_Online_RoomActionDoing();
	t.RoomKey = ;
	t.ActionType = ;
	*/

	/*
	PB_Online_RoomActionDoing t = new PB_Online_RoomActionDoing();
	t.RoomKey = m.getRoomKey() ;
	t.ActionType = m.getActionType() ;
	*/

	public class PB_Offline_Messagings {
	   public PB_MessageView NewMessages;
	   public PB_MessageFileView ChatFiles;
	   public PB_ChatView Chats;
	   public PB_UserView Users;
	   public PB_Offline_ChangeMessageId ChangeMessageIds;
	   public PB_Offline_ChangeMessageFileId ChangeMessageFileIds;
	   public PB_Offline_MessageToEdit MessagesToEdit;
	   public PB_Offline_MessageToDelete MessagesToDelete;
	   public PB_Offline_MessagesReachedServer MessagesReachedServer;
	   public PB_Offline_MessagesDeliveredToUser MessagesDeliveredToUser;
	   public PB_Offline_MessagesSeenByPeer MessagesSeenByPeer;
	   public PB_Offline_MessagesDeletedFromServer MessagesDeletedFromServer;
	   public PB_Online_RoomActionDoing RoomActionDoing;
	   public long LastId;
	}
	/*
	folding
	PBFlatTypes.PB_Offline_Messagings t = new PBFlatTypes.PB_Offline_Messagings();
    t.setNewMessages();
    t.setChatFiles();
    t.setChats();
    t.setUsers();
    t.setChangeMessageIds();
    t.setChangeMessageFileIds();
    t.setMessagesToEdit();
    t.setMessagesToDelete();
    t.setMessagesReachedServer();
    t.setMessagesDeliveredToUser();
    t.setMessagesSeenByPeer();
    t.setMessagesDeletedFromServer();
    t.setRoomActionDoing();
    t.setLastId();
	*/

	/*
	PBFlatTypes.PB_Offline_Messagings t = new PBFlatTypes.PB_Offline_Messagings();
	t.NewMessages = ;
	t.ChatFiles = ;
	t.Chats = ;
	t.Users = ;
	t.ChangeMessageIds = ;
	t.ChangeMessageFileIds = ;
	t.MessagesToEdit = ;
	t.MessagesToDelete = ;
	t.MessagesReachedServer = ;
	t.MessagesDeliveredToUser = ;
	t.MessagesSeenByPeer = ;
	t.MessagesDeletedFromServer = ;
	t.RoomActionDoing = ;
	t.LastId = ;
	*/

	/*
	PB_Offline_Messagings t = new PB_Offline_Messagings();
	t.NewMessages = m.getNewMessages() ;
	t.ChatFiles = m.getChatFiles() ;
	t.Chats = m.getChats() ;
	t.Users = m.getUsers() ;
	t.ChangeMessageIds = m.getChangeMessageIds() ;
	t.ChangeMessageFileIds = m.getChangeMessageFileIds() ;
	t.MessagesToEdit = m.getMessagesToEdit() ;
	t.MessagesToDelete = m.getMessagesToDelete() ;
	t.MessagesReachedServer = m.getMessagesReachedServer() ;
	t.MessagesDeliveredToUser = m.getMessagesDeliveredToUser() ;
	t.MessagesSeenByPeer = m.getMessagesSeenByPeer() ;
	t.MessagesDeletedFromServer = m.getMessagesDeletedFromServer() ;
	t.RoomActionDoing = m.getRoomActionDoing() ;
	t.LastId = m.getLastId() ;
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

	public class PB_ChatParam_AddNewMessage {
	   public long ReplyToMessageId;
	   public byte[] Blob;
	   public PB_MessageView MessageView;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_AddNewMessage t = new PBFlatTypes.PB_ChatParam_AddNewMessage();
    t.setReplyToMessageId();
    t.setBlob();
    t.setMessageView();
	*/

	/*
	PBFlatTypes.PB_ChatParam_AddNewMessage t = new PBFlatTypes.PB_ChatParam_AddNewMessage();
	t.ReplyToMessageId = ;
	t.Blob = ;
	t.MessageView = ;
	*/

	/*
	PB_ChatParam_AddNewMessage t = new PB_ChatParam_AddNewMessage();
	t.ReplyToMessageId = m.getReplyToMessageId() ;
	t.Blob = m.getBlob() ;
	t.MessageView = m.getMessageView() ;
	*/

	public class PB_ChatResponse_AddNewMessage {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_AddNewMessage t = new PBFlatTypes.PB_ChatResponse_AddNewMessage();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_AddNewMessage t = new PBFlatTypes.PB_ChatResponse_AddNewMessage();
	*/

	/*
	PB_ChatResponse_AddNewMessage t = new PB_ChatResponse_AddNewMessage();
	*/

	public class PB_ChatParam_SetRoomActionDoing {
	   public long GroupId;
	   public String DirectRoomKey;
	   public RoomActionDoingEnum ActionType;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_SetRoomActionDoing t = new PBFlatTypes.PB_ChatParam_SetRoomActionDoing();
    t.setGroupId();
    t.setDirectRoomKey();
    t.setActionType();
	*/

	/*
	PBFlatTypes.PB_ChatParam_SetRoomActionDoing t = new PBFlatTypes.PB_ChatParam_SetRoomActionDoing();
	t.GroupId = ;
	t.DirectRoomKey = ;
	t.ActionType = ;
	*/

	/*
	PB_ChatParam_SetRoomActionDoing t = new PB_ChatParam_SetRoomActionDoing();
	t.GroupId = m.getGroupId() ;
	t.DirectRoomKey = m.getDirectRoomKey() ;
	t.ActionType = m.getActionType() ;
	*/

	public class PB_ChatResponse_SetRoomActionDoing {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_SetRoomActionDoing t = new PBFlatTypes.PB_ChatResponse_SetRoomActionDoing();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_SetRoomActionDoing t = new PBFlatTypes.PB_ChatResponse_SetRoomActionDoing();
	*/

	/*
	PB_ChatResponse_SetRoomActionDoing t = new PB_ChatResponse_SetRoomActionDoing();
	*/

	public class PB_ChatParam_SetChatMessagesRangeAsSeen {
	   public String ChatKey;
	   public long BottomMessageId;
	   public long TopMessageId;
	   public long SeenTimeMs;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_ChatParam_SetChatMessagesRangeAsSeen();
    t.setChatKey();
    t.setBottomMessageId();
    t.setTopMessageId();
    t.setSeenTimeMs();
	*/

	/*
	PBFlatTypes.PB_ChatParam_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_ChatParam_SetChatMessagesRangeAsSeen();
	t.ChatKey = ;
	t.BottomMessageId = ;
	t.TopMessageId = ;
	t.SeenTimeMs = ;
	*/

	/*
	PB_ChatParam_SetChatMessagesRangeAsSeen t = new PB_ChatParam_SetChatMessagesRangeAsSeen();
	t.ChatKey = m.getChatKey() ;
	t.BottomMessageId = m.getBottomMessageId() ;
	t.TopMessageId = m.getTopMessageId() ;
	t.SeenTimeMs = m.getSeenTimeMs() ;
	*/

	public class PB_ChatResponse_SetChatMessagesRangeAsSeen {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_ChatResponse_SetChatMessagesRangeAsSeen();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_SetChatMessagesRangeAsSeen t = new PBFlatTypes.PB_ChatResponse_SetChatMessagesRangeAsSeen();
	*/

	/*
	PB_ChatResponse_SetChatMessagesRangeAsSeen t = new PB_ChatResponse_SetChatMessagesRangeAsSeen();
	*/

	public class PB_ChatParam_DeleteChatHistory {
	   public String ChatKey;
	   public long FromMessageId;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_DeleteChatHistory t = new PBFlatTypes.PB_ChatParam_DeleteChatHistory();
    t.setChatKey();
    t.setFromMessageId();
	*/

	/*
	PBFlatTypes.PB_ChatParam_DeleteChatHistory t = new PBFlatTypes.PB_ChatParam_DeleteChatHistory();
	t.ChatKey = ;
	t.FromMessageId = ;
	*/

	/*
	PB_ChatParam_DeleteChatHistory t = new PB_ChatParam_DeleteChatHistory();
	t.ChatKey = m.getChatKey() ;
	t.FromMessageId = m.getFromMessageId() ;
	*/

	public class PB_ChatResponse_DeleteChatHistory {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_DeleteChatHistory t = new PBFlatTypes.PB_ChatResponse_DeleteChatHistory();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_DeleteChatHistory t = new PBFlatTypes.PB_ChatResponse_DeleteChatHistory();
	*/

	/*
	PB_ChatResponse_DeleteChatHistory t = new PB_ChatResponse_DeleteChatHistory();
	*/

	public class PB_ChatParam_DeleteMessagesByIds {
	   public String ChatKey;
	   public boolean Both;
	   public long MessagesIds;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_DeleteMessagesByIds t = new PBFlatTypes.PB_ChatParam_DeleteMessagesByIds();
    t.setChatKey();
    t.setBoth();
    t.setMessagesIds();
	*/

	/*
	PBFlatTypes.PB_ChatParam_DeleteMessagesByIds t = new PBFlatTypes.PB_ChatParam_DeleteMessagesByIds();
	t.ChatKey = ;
	t.Both = ;
	t.MessagesIds = ;
	*/

	/*
	PB_ChatParam_DeleteMessagesByIds t = new PB_ChatParam_DeleteMessagesByIds();
	t.ChatKey = m.getChatKey() ;
	t.Both = m.getBoth() ;
	t.MessagesIds = m.getMessagesIds() ;
	*/

	public class PB_ChatResponse_DeleteMessagesByIds {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_DeleteMessagesByIds t = new PBFlatTypes.PB_ChatResponse_DeleteMessagesByIds();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_DeleteMessagesByIds t = new PBFlatTypes.PB_ChatResponse_DeleteMessagesByIds();
	*/

	/*
	PB_ChatResponse_DeleteMessagesByIds t = new PB_ChatResponse_DeleteMessagesByIds();
	*/

	public class PB_ChatParam_SetMessagesAsReceived {
	   public String ChatRoom;
	   public long MessageIds;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_SetMessagesAsReceived t = new PBFlatTypes.PB_ChatParam_SetMessagesAsReceived();
    t.setChatRoom();
    t.setMessageIds();
	*/

	/*
	PBFlatTypes.PB_ChatParam_SetMessagesAsReceived t = new PBFlatTypes.PB_ChatParam_SetMessagesAsReceived();
	t.ChatRoom = ;
	t.MessageIds = ;
	*/

	/*
	PB_ChatParam_SetMessagesAsReceived t = new PB_ChatParam_SetMessagesAsReceived();
	t.ChatRoom = m.getChatRoom() ;
	t.MessageIds = m.getMessageIds() ;
	*/

	public class PB_ChatResponse_SetMessagesAsReceived {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_SetMessagesAsReceived t = new PBFlatTypes.PB_ChatResponse_SetMessagesAsReceived();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_SetMessagesAsReceived t = new PBFlatTypes.PB_ChatResponse_SetMessagesAsReceived();
	*/

	/*
	PB_ChatResponse_SetMessagesAsReceived t = new PB_ChatResponse_SetMessagesAsReceived();
	*/

	public class PB_ChatParam_EditMessage {
	   public String RoomKey;
	   public long MessageId;
	   public String NewText;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_EditMessage t = new PBFlatTypes.PB_ChatParam_EditMessage();
    t.setRoomKey();
    t.setMessageId();
    t.setNewText();
	*/

	/*
	PBFlatTypes.PB_ChatParam_EditMessage t = new PBFlatTypes.PB_ChatParam_EditMessage();
	t.RoomKey = ;
	t.MessageId = ;
	t.NewText = ;
	*/

	/*
	PB_ChatParam_EditMessage t = new PB_ChatParam_EditMessage();
	t.RoomKey = m.getRoomKey() ;
	t.MessageId = m.getMessageId() ;
	t.NewText = m.getNewText() ;
	*/

	public class PB_ChatResponse_EditMessage {
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_EditMessage t = new PBFlatTypes.PB_ChatResponse_EditMessage();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_EditMessage t = new PBFlatTypes.PB_ChatResponse_EditMessage();
	*/

	/*
	PB_ChatResponse_EditMessage t = new PB_ChatResponse_EditMessage();
	*/

	public class PB_ChatParam_GetChatList {
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_GetChatList t = new PBFlatTypes.PB_ChatParam_GetChatList();
	*/

	/*
	PBFlatTypes.PB_ChatParam_GetChatList t = new PBFlatTypes.PB_ChatParam_GetChatList();
	*/

	/*
	PB_ChatParam_GetChatList t = new PB_ChatParam_GetChatList();
	*/

	public class PB_ChatResponse_GetChatList {
	   public PB_ChatView Chats;
	   public PB_UserView Users;
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_GetChatList t = new PBFlatTypes.PB_ChatResponse_GetChatList();
    t.setChats();
    t.setUsers();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_GetChatList t = new PBFlatTypes.PB_ChatResponse_GetChatList();
	t.Chats = ;
	t.Users = ;
	*/

	/*
	PB_ChatResponse_GetChatList t = new PB_ChatResponse_GetChatList();
	t.Chats = m.getChats() ;
	t.Users = m.getUsers() ;
	*/

	public class PB_ChatParam_GetChatHistoryToOlder {
	   public String ChatKey;
	   public int Limit;
	   public long FromTopMessageId;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_GetChatHistoryToOlder t = new PBFlatTypes.PB_ChatParam_GetChatHistoryToOlder();
    t.setChatKey();
    t.setLimit();
    t.setFromTopMessageId();
	*/

	/*
	PBFlatTypes.PB_ChatParam_GetChatHistoryToOlder t = new PBFlatTypes.PB_ChatParam_GetChatHistoryToOlder();
	t.ChatKey = ;
	t.Limit = ;
	t.FromTopMessageId = ;
	*/

	/*
	PB_ChatParam_GetChatHistoryToOlder t = new PB_ChatParam_GetChatHistoryToOlder();
	t.ChatKey = m.getChatKey() ;
	t.Limit = m.getLimit() ;
	t.FromTopMessageId = m.getFromTopMessageId() ;
	*/

	public class PB_ChatResponse_GetChatHistoryToOlder {
	   public PB_MessageView MessagesViews;
	   public boolean HasMore;
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_GetChatHistoryToOlder t = new PBFlatTypes.PB_ChatResponse_GetChatHistoryToOlder();
    t.setMessagesViews();
    t.setHasMore();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_GetChatHistoryToOlder t = new PBFlatTypes.PB_ChatResponse_GetChatHistoryToOlder();
	t.MessagesViews = ;
	t.HasMore = ;
	*/

	/*
	PB_ChatResponse_GetChatHistoryToOlder t = new PB_ChatResponse_GetChatHistoryToOlder();
	t.MessagesViews = m.getMessagesViews() ;
	t.HasMore = m.getHasMore() ;
	*/

	public class PB_ChatParam_GetFreshAllDirectMessagesList {
	   public long LowMessageId;
	   public long HighMessageId;
	}
	/*
	folding
	PBFlatTypes.PB_ChatParam_GetFreshAllDirectMessagesList t = new PBFlatTypes.PB_ChatParam_GetFreshAllDirectMessagesList();
    t.setLowMessageId();
    t.setHighMessageId();
	*/

	/*
	PBFlatTypes.PB_ChatParam_GetFreshAllDirectMessagesList t = new PBFlatTypes.PB_ChatParam_GetFreshAllDirectMessagesList();
	t.LowMessageId = ;
	t.HighMessageId = ;
	*/

	/*
	PB_ChatParam_GetFreshAllDirectMessagesList t = new PB_ChatParam_GetFreshAllDirectMessagesList();
	t.LowMessageId = m.getLowMessageId() ;
	t.HighMessageId = m.getHighMessageId() ;
	*/

	public class PB_ChatResponse_GetFreshAllDirectMessagesList {
	   public PB_MessageView Messages;
	   public boolean HasMore;
	}
	/*
	folding
	PBFlatTypes.PB_ChatResponse_GetFreshAllDirectMessagesList t = new PBFlatTypes.PB_ChatResponse_GetFreshAllDirectMessagesList();
    t.setMessages();
    t.setHasMore();
	*/

	/*
	PBFlatTypes.PB_ChatResponse_GetFreshAllDirectMessagesList t = new PBFlatTypes.PB_ChatResponse_GetFreshAllDirectMessagesList();
	t.Messages = ;
	t.HasMore = ;
	*/

	/*
	PB_ChatResponse_GetFreshAllDirectMessagesList t = new PB_ChatResponse_GetFreshAllDirectMessagesList();
	t.Messages = m.getMessages() ;
	t.HasMore = m.getHasMore() ;
	*/

	public class PB_OtherParam_Echo {
	   public String Text;
	}
	/*
	folding
	PBFlatTypes.PB_OtherParam_Echo t = new PBFlatTypes.PB_OtherParam_Echo();
    t.setText();
	*/

	/*
	PBFlatTypes.PB_OtherParam_Echo t = new PBFlatTypes.PB_OtherParam_Echo();
	t.Text = ;
	*/

	/*
	PB_OtherParam_Echo t = new PB_OtherParam_Echo();
	t.Text = m.getText() ;
	*/

	public class PB_OtherResponse_Echo {
	   public String Text;
	}
	/*
	folding
	PBFlatTypes.PB_OtherResponse_Echo t = new PBFlatTypes.PB_OtherResponse_Echo();
    t.setText();
	*/

	/*
	PBFlatTypes.PB_OtherResponse_Echo t = new PBFlatTypes.PB_OtherResponse_Echo();
	t.Text = ;
	*/

	/*
	PB_OtherResponse_Echo t = new PB_OtherResponse_Echo();
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

	public class PB_AllLivePushes {
	   public PB_SyncResponse_GetGeneralUpdates GeneralUpdates;
	   public PB_Offline_Messagings Offline_Messagings;
	}
	/*
	folding
	PBFlatTypes.PB_AllLivePushes t = new PBFlatTypes.PB_AllLivePushes();
    t.setGeneralUpdates();
    t.setOffline_Messagings();
	*/

	/*
	PBFlatTypes.PB_AllLivePushes t = new PBFlatTypes.PB_AllLivePushes();
	t.GeneralUpdates = ;
	t.Offline_Messagings = ;
	*/

	/*
	PB_AllLivePushes t = new PB_AllLivePushes();
	t.GeneralUpdates = m.getGeneralUpdates() ;
	t.Offline_Messagings = m.getOffline_Messagings() ;
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

	public class PB_Activity {
	   public long Id;
	   public int ActorUserId;
	   public int ActionTypeId;
	   public int RowId;
	   public int RootId;
	   public long RefId;
	   public int CreatedAt;
	}
	/*
	folding
	PBFlatTypes.PB_Activity t = new PBFlatTypes.PB_Activity();
    t.setId();
    t.setActorUserId();
    t.setActionTypeId();
    t.setRowId();
    t.setRootId();
    t.setRefId();
    t.setCreatedAt();
	*/

	/*
	PBFlatTypes.PB_Activity t = new PBFlatTypes.PB_Activity();
	t.Id = ;
	t.ActorUserId = ;
	t.ActionTypeId = ;
	t.RowId = ;
	t.RootId = ;
	t.RefId = ;
	t.CreatedAt = ;
	*/

	/*
	PB_Activity t = new PB_Activity();
	t.Id = m.getId() ;
	t.ActorUserId = m.getActorUserId() ;
	t.ActionTypeId = m.getActionTypeId() ;
	t.RowId = m.getRowId() ;
	t.RootId = m.getRootId() ;
	t.RefId = m.getRefId() ;
	t.CreatedAt = m.getCreatedAt() ;
	*/

	public class PB_Bucket {
	   public int BucketId;
	   public String BucketName;
	   public int Server1Id;
	   public int Server2Id;
	   public int BackupServerId;
	   public int ContentObjectTypeId;
	   public int ContentObjectCount;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_Bucket t = new PBFlatTypes.PB_Bucket();
    t.setBucketId();
    t.setBucketName();
    t.setServer1Id();
    t.setServer2Id();
    t.setBackupServerId();
    t.setContentObjectTypeId();
    t.setContentObjectCount();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_Bucket t = new PBFlatTypes.PB_Bucket();
	t.BucketId = ;
	t.BucketName = ;
	t.Server1Id = ;
	t.Server2Id = ;
	t.BackupServerId = ;
	t.ContentObjectTypeId = ;
	t.ContentObjectCount = ;
	t.CreatedTime = ;
	*/

	/*
	PB_Bucket t = new PB_Bucket();
	t.BucketId = m.getBucketId() ;
	t.BucketName = m.getBucketName() ;
	t.Server1Id = m.getServer1Id() ;
	t.Server2Id = m.getServer2Id() ;
	t.BackupServerId = m.getBackupServerId() ;
	t.ContentObjectTypeId = m.getContentObjectTypeId() ;
	t.ContentObjectCount = m.getContentObjectCount() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_Chat {
	   public String ChatKey;
	   public String RoomKey;
	   public int RoomTypeEnumId;
	   public int UserId;
	   public int PeerUserId;
	   public long GroupId;
	   public int CreatedSe;
	   public long StartMessageIdFrom;
	   public long LastDeletedMessageId;
	   public long LastSeenMessageId;
	   public long LastMessageId;
	   public long UpdatedMs;
	}
	/*
	folding
	PBFlatTypes.PB_Chat t = new PBFlatTypes.PB_Chat();
    t.setChatKey();
    t.setRoomKey();
    t.setRoomTypeEnumId();
    t.setUserId();
    t.setPeerUserId();
    t.setGroupId();
    t.setCreatedSe();
    t.setStartMessageIdFrom();
    t.setLastDeletedMessageId();
    t.setLastSeenMessageId();
    t.setLastMessageId();
    t.setUpdatedMs();
	*/

	/*
	PBFlatTypes.PB_Chat t = new PBFlatTypes.PB_Chat();
	t.ChatKey = ;
	t.RoomKey = ;
	t.RoomTypeEnumId = ;
	t.UserId = ;
	t.PeerUserId = ;
	t.GroupId = ;
	t.CreatedSe = ;
	t.StartMessageIdFrom = ;
	t.LastDeletedMessageId = ;
	t.LastSeenMessageId = ;
	t.LastMessageId = ;
	t.UpdatedMs = ;
	*/

	/*
	PB_Chat t = new PB_Chat();
	t.ChatKey = m.getChatKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.UserId = m.getUserId() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.GroupId = m.getGroupId() ;
	t.CreatedSe = m.getCreatedSe() ;
	t.StartMessageIdFrom = m.getStartMessageIdFrom() ;
	t.LastDeletedMessageId = m.getLastDeletedMessageId() ;
	t.LastSeenMessageId = m.getLastSeenMessageId() ;
	t.LastMessageId = m.getLastMessageId() ;
	t.UpdatedMs = m.getUpdatedMs() ;
	*/

	public class PB_Comment {
	   public int Id;
	   public int UserId;
	   public int PostId;
	   public String Text;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_Comment t = new PBFlatTypes.PB_Comment();
    t.setId();
    t.setUserId();
    t.setPostId();
    t.setText();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_Comment t = new PBFlatTypes.PB_Comment();
	t.Id = ;
	t.UserId = ;
	t.PostId = ;
	t.Text = ;
	t.CreatedTime = ;
	*/

	/*
	PB_Comment t = new PB_Comment();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.PostId = m.getPostId() ;
	t.Text = m.getText() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_DirectMessage {
	   public long MessageId;
	   public String MessageKey;
	   public String RoomKey;
	   public int UserId;
	   public long MessageFileId;
	   public int MessageTypeEnumId;
	   public String Text;
	   public int CreatedSe;
	   public int PeerReceivedTime;
	   public int PeerSeenTime;
	   public int DeliviryStatusEnumId;
	}
	/*
	folding
	PBFlatTypes.PB_DirectMessage t = new PBFlatTypes.PB_DirectMessage();
    t.setMessageId();
    t.setMessageKey();
    t.setRoomKey();
    t.setUserId();
    t.setMessageFileId();
    t.setMessageTypeEnumId();
    t.setText();
    t.setCreatedSe();
    t.setPeerReceivedTime();
    t.setPeerSeenTime();
    t.setDeliviryStatusEnumId();
	*/

	/*
	PBFlatTypes.PB_DirectMessage t = new PBFlatTypes.PB_DirectMessage();
	t.MessageId = ;
	t.MessageKey = ;
	t.RoomKey = ;
	t.UserId = ;
	t.MessageFileId = ;
	t.MessageTypeEnumId = ;
	t.Text = ;
	t.CreatedSe = ;
	t.PeerReceivedTime = ;
	t.PeerSeenTime = ;
	t.DeliviryStatusEnumId = ;
	*/

	/*
	PB_DirectMessage t = new PB_DirectMessage();
	t.MessageId = m.getMessageId() ;
	t.MessageKey = m.getMessageKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageTypeEnumId = m.getMessageTypeEnumId() ;
	t.Text = m.getText() ;
	t.CreatedSe = m.getCreatedSe() ;
	t.PeerReceivedTime = m.getPeerReceivedTime() ;
	t.PeerSeenTime = m.getPeerSeenTime() ;
	t.DeliviryStatusEnumId = m.getDeliviryStatusEnumId() ;
	*/

	public class PB_DirectOffline {
	   public long DirectOfflineId;
	   public int ToUserId;
	   public String ChatKey;
	   public long MessageId;
	   public long MessageFileId;
	   public String PBClass;
	   public byte[] DataPB;
	   public String DataJson;
	   public String DataTemp;
	   public long AtTimeMs;
	}
	/*
	folding
	PBFlatTypes.PB_DirectOffline t = new PBFlatTypes.PB_DirectOffline();
    t.setDirectOfflineId();
    t.setToUserId();
    t.setChatKey();
    t.setMessageId();
    t.setMessageFileId();
    t.setPBClass();
    t.setDataPB();
    t.setDataJson();
    t.setDataTemp();
    t.setAtTimeMs();
	*/

	/*
	PBFlatTypes.PB_DirectOffline t = new PBFlatTypes.PB_DirectOffline();
	t.DirectOfflineId = ;
	t.ToUserId = ;
	t.ChatKey = ;
	t.MessageId = ;
	t.MessageFileId = ;
	t.PBClass = ;
	t.DataPB = ;
	t.DataJson = ;
	t.DataTemp = ;
	t.AtTimeMs = ;
	*/

	/*
	PB_DirectOffline t = new PB_DirectOffline();
	t.DirectOfflineId = m.getDirectOfflineId() ;
	t.ToUserId = m.getToUserId() ;
	t.ChatKey = m.getChatKey() ;
	t.MessageId = m.getMessageId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.PBClass = m.getPBClass() ;
	t.DataPB = m.getDataPB() ;
	t.DataJson = m.getDataJson() ;
	t.DataTemp = m.getDataTemp() ;
	t.AtTimeMs = m.getAtTimeMs() ;
	*/

	public class PB_DirectToMessage {
	   public long Id;
	   public String ChatKey;
	   public long MessageId;
	   public int SourceEnumId;
	}
	/*
	folding
	PBFlatTypes.PB_DirectToMessage t = new PBFlatTypes.PB_DirectToMessage();
    t.setId();
    t.setChatKey();
    t.setMessageId();
    t.setSourceEnumId();
	*/

	/*
	PBFlatTypes.PB_DirectToMessage t = new PBFlatTypes.PB_DirectToMessage();
	t.Id = ;
	t.ChatKey = ;
	t.MessageId = ;
	t.SourceEnumId = ;
	*/

	/*
	PB_DirectToMessage t = new PB_DirectToMessage();
	t.Id = m.getId() ;
	t.ChatKey = m.getChatKey() ;
	t.MessageId = m.getMessageId() ;
	t.SourceEnumId = m.getSourceEnumId() ;
	*/

	public class PB_FollowingList {
	   public int Id;
	   public int UserId;
	   public int ListType;
	   public String Name;
	   public int Count;
	   public int IsAuto;
	   public int IsPimiry;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_FollowingList t = new PBFlatTypes.PB_FollowingList();
    t.setId();
    t.setUserId();
    t.setListType();
    t.setName();
    t.setCount();
    t.setIsAuto();
    t.setIsPimiry();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_FollowingList t = new PBFlatTypes.PB_FollowingList();
	t.Id = ;
	t.UserId = ;
	t.ListType = ;
	t.Name = ;
	t.Count = ;
	t.IsAuto = ;
	t.IsPimiry = ;
	t.CreatedTime = ;
	*/

	/*
	PB_FollowingList t = new PB_FollowingList();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.ListType = m.getListType() ;
	t.Name = m.getName() ;
	t.Count = m.getCount() ;
	t.IsAuto = m.getIsAuto() ;
	t.IsPimiry = m.getIsPimiry() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_FollowingListMember {
	   public long Id;
	   public int ListId;
	   public int UserId;
	   public int FollowedUserId;
	   public int FollowType;
	   public long UpdatedTimeMs;
	}
	/*
	folding
	PBFlatTypes.PB_FollowingListMember t = new PBFlatTypes.PB_FollowingListMember();
    t.setId();
    t.setListId();
    t.setUserId();
    t.setFollowedUserId();
    t.setFollowType();
    t.setUpdatedTimeMs();
	*/

	/*
	PBFlatTypes.PB_FollowingListMember t = new PBFlatTypes.PB_FollowingListMember();
	t.Id = ;
	t.ListId = ;
	t.UserId = ;
	t.FollowedUserId = ;
	t.FollowType = ;
	t.UpdatedTimeMs = ;
	*/

	/*
	PB_FollowingListMember t = new PB_FollowingListMember();
	t.Id = m.getId() ;
	t.ListId = m.getListId() ;
	t.UserId = m.getUserId() ;
	t.FollowedUserId = m.getFollowedUserId() ;
	t.FollowType = m.getFollowType() ;
	t.UpdatedTimeMs = m.getUpdatedTimeMs() ;
	*/

	public class PB_FollowingListMemberHistory {
	   public long Id;
	   public int ListId;
	   public int UserId;
	   public int FollowedUserId;
	   public int FollowType;
	   public long UpdatedTimeMs;
	   public int FollowId;
	}
	/*
	folding
	PBFlatTypes.PB_FollowingListMemberHistory t = new PBFlatTypes.PB_FollowingListMemberHistory();
    t.setId();
    t.setListId();
    t.setUserId();
    t.setFollowedUserId();
    t.setFollowType();
    t.setUpdatedTimeMs();
    t.setFollowId();
	*/

	/*
	PBFlatTypes.PB_FollowingListMemberHistory t = new PBFlatTypes.PB_FollowingListMemberHistory();
	t.Id = ;
	t.ListId = ;
	t.UserId = ;
	t.FollowedUserId = ;
	t.FollowType = ;
	t.UpdatedTimeMs = ;
	t.FollowId = ;
	*/

	/*
	PB_FollowingListMemberHistory t = new PB_FollowingListMemberHistory();
	t.Id = m.getId() ;
	t.ListId = m.getListId() ;
	t.UserId = m.getUserId() ;
	t.FollowedUserId = m.getFollowedUserId() ;
	t.FollowType = m.getFollowType() ;
	t.UpdatedTimeMs = m.getUpdatedTimeMs() ;
	t.FollowId = m.getFollowId() ;
	*/

	public class PB_GeneralLog {
	   public long Id;
	   public int ToUserId;
	   public int TargetId;
	   public int LogTypeId;
	   public byte[] ExtraPB;
	   public String ExtraJson;
	   public long CreatedMs;
	}
	/*
	folding
	PBFlatTypes.PB_GeneralLog t = new PBFlatTypes.PB_GeneralLog();
    t.setId();
    t.setToUserId();
    t.setTargetId();
    t.setLogTypeId();
    t.setExtraPB();
    t.setExtraJson();
    t.setCreatedMs();
	*/

	/*
	PBFlatTypes.PB_GeneralLog t = new PBFlatTypes.PB_GeneralLog();
	t.Id = ;
	t.ToUserId = ;
	t.TargetId = ;
	t.LogTypeId = ;
	t.ExtraPB = ;
	t.ExtraJson = ;
	t.CreatedMs = ;
	*/

	/*
	PB_GeneralLog t = new PB_GeneralLog();
	t.Id = m.getId() ;
	t.ToUserId = m.getToUserId() ;
	t.TargetId = m.getTargetId() ;
	t.LogTypeId = m.getLogTypeId() ;
	t.ExtraPB = m.getExtraPB() ;
	t.ExtraJson = m.getExtraJson() ;
	t.CreatedMs = m.getCreatedMs() ;
	*/

	public class PB_Group {
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
	PBFlatTypes.PB_Group t = new PBFlatTypes.PB_Group();
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
	PBFlatTypes.PB_Group t = new PBFlatTypes.PB_Group();
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
	PB_Group t = new PB_Group();
	t.GroupId = m.getGroupId() ;
	t.GroupName = m.getGroupName() ;
	t.MembersCount = m.getMembersCount() ;
	t.GroupPrivacyEnum = m.getGroupPrivacyEnum() ;
	t.CreatorUserId = m.getCreatorUserId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.UpdatedMs = m.getUpdatedMs() ;
	t.CurrentSeq = m.getCurrentSeq() ;
	*/

	public class PB_GroupMember {
	   public long Id;
	   public long GroupId;
	   public String GroupKey;
	   public int UserId;
	   public int ByUserId;
	   public int GroupRoleEnumId;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_GroupMember t = new PBFlatTypes.PB_GroupMember();
    t.setId();
    t.setGroupId();
    t.setGroupKey();
    t.setUserId();
    t.setByUserId();
    t.setGroupRoleEnumId();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_GroupMember t = new PBFlatTypes.PB_GroupMember();
	t.Id = ;
	t.GroupId = ;
	t.GroupKey = ;
	t.UserId = ;
	t.ByUserId = ;
	t.GroupRoleEnumId = ;
	t.CreatedTime = ;
	*/

	/*
	PB_GroupMember t = new PB_GroupMember();
	t.Id = m.getId() ;
	t.GroupId = m.getGroupId() ;
	t.GroupKey = m.getGroupKey() ;
	t.UserId = m.getUserId() ;
	t.ByUserId = m.getByUserId() ;
	t.GroupRoleEnumId = m.getGroupRoleEnumId() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_GroupMessage {
	   public long MessageId;
	   public String RoomKey;
	   public int UserId;
	   public long MessageFileId;
	   public int MessageTypeEnum;
	   public String Text;
	   public long CreatedMs;
	   public int DeliveryStatusEnum;
	}
	/*
	folding
	PBFlatTypes.PB_GroupMessage t = new PBFlatTypes.PB_GroupMessage();
    t.setMessageId();
    t.setRoomKey();
    t.setUserId();
    t.setMessageFileId();
    t.setMessageTypeEnum();
    t.setText();
    t.setCreatedMs();
    t.setDeliveryStatusEnum();
	*/

	/*
	PBFlatTypes.PB_GroupMessage t = new PBFlatTypes.PB_GroupMessage();
	t.MessageId = ;
	t.RoomKey = ;
	t.UserId = ;
	t.MessageFileId = ;
	t.MessageTypeEnum = ;
	t.Text = ;
	t.CreatedMs = ;
	t.DeliveryStatusEnum = ;
	*/

	/*
	PB_GroupMessage t = new PB_GroupMessage();
	t.MessageId = m.getMessageId() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageTypeEnum = m.getMessageTypeEnum() ;
	t.Text = m.getText() ;
	t.CreatedMs = m.getCreatedMs() ;
	t.DeliveryStatusEnum = m.getDeliveryStatusEnum() ;
	*/

	public class PB_GroupToMessage {
	   public long Id;
	   public long GroupId;
	   public long MessageId;
	   public long CreatedMs;
	   public int StatusEnum;
	}
	/*
	folding
	PBFlatTypes.PB_GroupToMessage t = new PBFlatTypes.PB_GroupToMessage();
    t.setId();
    t.setGroupId();
    t.setMessageId();
    t.setCreatedMs();
    t.setStatusEnum();
	*/

	/*
	PBFlatTypes.PB_GroupToMessage t = new PBFlatTypes.PB_GroupToMessage();
	t.Id = ;
	t.GroupId = ;
	t.MessageId = ;
	t.CreatedMs = ;
	t.StatusEnum = ;
	*/

	/*
	PB_GroupToMessage t = new PB_GroupToMessage();
	t.Id = m.getId() ;
	t.GroupId = m.getGroupId() ;
	t.MessageId = m.getMessageId() ;
	t.CreatedMs = m.getCreatedMs() ;
	t.StatusEnum = m.getStatusEnum() ;
	*/

	public class PB_Like {
	   public int Id;
	   public int PostId;
	   public int PostTypeId;
	   public int UserId;
	   public int TypeId;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_Like t = new PBFlatTypes.PB_Like();
    t.setId();
    t.setPostId();
    t.setPostTypeId();
    t.setUserId();
    t.setTypeId();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_Like t = new PBFlatTypes.PB_Like();
	t.Id = ;
	t.PostId = ;
	t.PostTypeId = ;
	t.UserId = ;
	t.TypeId = ;
	t.CreatedTime = ;
	*/

	/*
	PB_Like t = new PB_Like();
	t.Id = m.getId() ;
	t.PostId = m.getPostId() ;
	t.PostTypeId = m.getPostTypeId() ;
	t.UserId = m.getUserId() ;
	t.TypeId = m.getTypeId() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_LogChange {
	   public int Id;
	   public String T;
	}
	/*
	folding
	PBFlatTypes.PB_LogChange t = new PBFlatTypes.PB_LogChange();
    t.setId();
    t.setT();
	*/

	/*
	PBFlatTypes.PB_LogChange t = new PBFlatTypes.PB_LogChange();
	t.Id = ;
	t.T = ;
	*/

	/*
	PB_LogChange t = new PB_LogChange();
	t.Id = m.getId() ;
	t.T = m.getT() ;
	*/

	public class PB_Media {
	   public int Id;
	   public int UserId;
	   public int PostId;
	   public int AlbumId;
	   public int TypeId;
	   public int CreatedTime;
	   public String Src;
	}
	/*
	folding
	PBFlatTypes.PB_Media t = new PBFlatTypes.PB_Media();
    t.setId();
    t.setUserId();
    t.setPostId();
    t.setAlbumId();
    t.setTypeId();
    t.setCreatedTime();
    t.setSrc();
	*/

	/*
	PBFlatTypes.PB_Media t = new PBFlatTypes.PB_Media();
	t.Id = ;
	t.UserId = ;
	t.PostId = ;
	t.AlbumId = ;
	t.TypeId = ;
	t.CreatedTime = ;
	t.Src = ;
	*/

	/*
	PB_Media t = new PB_Media();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.PostId = m.getPostId() ;
	t.AlbumId = m.getAlbumId() ;
	t.TypeId = m.getTypeId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.Src = m.getSrc() ;
	*/

	public class PB_MessageFile {
	   public long MessageFileId;
	   public String MessageFileKey;
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
	}
	/*
	folding
	PBFlatTypes.PB_MessageFile t = new PBFlatTypes.PB_MessageFile();
    t.setMessageFileId();
    t.setMessageFileKey();
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
	*/

	/*
	PBFlatTypes.PB_MessageFile t = new PBFlatTypes.PB_MessageFile();
	t.MessageFileId = ;
	t.MessageFileKey = ;
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
	*/

	/*
	PB_MessageFile t = new PB_MessageFile();
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageFileKey = m.getMessageFileKey() ;
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
	*/

	public class PB_Notification {
	   public long Id;
	   public int ForUserId;
	   public int ActorUserId;
	   public int ActionTypeId;
	   public int ObjectTypeId;
	   public int RowId;
	   public int RootId;
	   public int RefId;
	   public int SeenStatus;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_Notification t = new PBFlatTypes.PB_Notification();
    t.setId();
    t.setForUserId();
    t.setActorUserId();
    t.setActionTypeId();
    t.setObjectTypeId();
    t.setRowId();
    t.setRootId();
    t.setRefId();
    t.setSeenStatus();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_Notification t = new PBFlatTypes.PB_Notification();
	t.Id = ;
	t.ForUserId = ;
	t.ActorUserId = ;
	t.ActionTypeId = ;
	t.ObjectTypeId = ;
	t.RowId = ;
	t.RootId = ;
	t.RefId = ;
	t.SeenStatus = ;
	t.CreatedTime = ;
	*/

	/*
	PB_Notification t = new PB_Notification();
	t.Id = m.getId() ;
	t.ForUserId = m.getForUserId() ;
	t.ActorUserId = m.getActorUserId() ;
	t.ActionTypeId = m.getActionTypeId() ;
	t.ObjectTypeId = m.getObjectTypeId() ;
	t.RowId = m.getRowId() ;
	t.RootId = m.getRootId() ;
	t.RefId = m.getRefId() ;
	t.SeenStatus = m.getSeenStatus() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_NotificationRemoved {
	   public int NotificationId;
	   public int ForUserId;
	}
	/*
	folding
	PBFlatTypes.PB_NotificationRemoved t = new PBFlatTypes.PB_NotificationRemoved();
    t.setNotificationId();
    t.setForUserId();
	*/

	/*
	PBFlatTypes.PB_NotificationRemoved t = new PBFlatTypes.PB_NotificationRemoved();
	t.NotificationId = ;
	t.ForUserId = ;
	*/

	/*
	PB_NotificationRemoved t = new PB_NotificationRemoved();
	t.NotificationId = m.getNotificationId() ;
	t.ForUserId = m.getForUserId() ;
	*/

	public class PB_Offline {
	   public long Id;
	   public int FromUserId;
	   public int ToUserId;
	   public String RpcName;
	   public String PBClassName;
	   public String Key;
	   public String DataJson;
	   public byte[] DataBlob;
	   public int DataLength;
	   public long CreatedMs;
	}
	/*
	folding
	PBFlatTypes.PB_Offline t = new PBFlatTypes.PB_Offline();
    t.setId();
    t.setFromUserId();
    t.setToUserId();
    t.setRpcName();
    t.setPBClassName();
    t.setKey();
    t.setDataJson();
    t.setDataBlob();
    t.setDataLength();
    t.setCreatedMs();
	*/

	/*
	PBFlatTypes.PB_Offline t = new PBFlatTypes.PB_Offline();
	t.Id = ;
	t.FromUserId = ;
	t.ToUserId = ;
	t.RpcName = ;
	t.PBClassName = ;
	t.Key = ;
	t.DataJson = ;
	t.DataBlob = ;
	t.DataLength = ;
	t.CreatedMs = ;
	*/

	/*
	PB_Offline t = new PB_Offline();
	t.Id = m.getId() ;
	t.FromUserId = m.getFromUserId() ;
	t.ToUserId = m.getToUserId() ;
	t.RpcName = m.getRpcName() ;
	t.PBClassName = m.getPBClassName() ;
	t.Key = m.getKey() ;
	t.DataJson = m.getDataJson() ;
	t.DataBlob = m.getDataBlob() ;
	t.DataLength = m.getDataLength() ;
	t.CreatedMs = m.getCreatedMs() ;
	*/

	public class PB_PhoneContact {
	   public int Id;
	   public String PhoneDisplayName;
	   public String PhoneFamilyName;
	   public String PhoneNumber;
	   public String PhoneNormalizedNumber;
	   public int PhoneContactRowId;
	   public int UserId;
	   public int DeviceUuidId;
	   public int CreatedTime;
	   public int UpdatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_PhoneContact t = new PBFlatTypes.PB_PhoneContact();
    t.setId();
    t.setPhoneDisplayName();
    t.setPhoneFamilyName();
    t.setPhoneNumber();
    t.setPhoneNormalizedNumber();
    t.setPhoneContactRowId();
    t.setUserId();
    t.setDeviceUuidId();
    t.setCreatedTime();
    t.setUpdatedTime();
	*/

	/*
	PBFlatTypes.PB_PhoneContact t = new PBFlatTypes.PB_PhoneContact();
	t.Id = ;
	t.PhoneDisplayName = ;
	t.PhoneFamilyName = ;
	t.PhoneNumber = ;
	t.PhoneNormalizedNumber = ;
	t.PhoneContactRowId = ;
	t.UserId = ;
	t.DeviceUuidId = ;
	t.CreatedTime = ;
	t.UpdatedTime = ;
	*/

	/*
	PB_PhoneContact t = new PB_PhoneContact();
	t.Id = m.getId() ;
	t.PhoneDisplayName = m.getPhoneDisplayName() ;
	t.PhoneFamilyName = m.getPhoneFamilyName() ;
	t.PhoneNumber = m.getPhoneNumber() ;
	t.PhoneNormalizedNumber = m.getPhoneNormalizedNumber() ;
	t.PhoneContactRowId = m.getPhoneContactRowId() ;
	t.UserId = m.getUserId() ;
	t.DeviceUuidId = m.getDeviceUuidId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.UpdatedTime = m.getUpdatedTime() ;
	*/

	public class PB_Photo {
	   public int PhotoId;
	   public int UserId;
	   public int PostId;
	   public int AlbumId;
	   public int ImageTypeId;
	   public String Title;
	   public String Src;
	   public String PathSrc;
	   public int BucketId;
	   public int Width;
	   public int Height;
	   public float Ratio;
	   public String HashMd5;
	   public String Color;
	   public int CreatedTime;
	   public int W1080;
	   public int W720;
	   public int W480;
	   public int W320;
	   public int W160;
	   public int W80;
	}
	/*
	folding
	PBFlatTypes.PB_Photo t = new PBFlatTypes.PB_Photo();
    t.setPhotoId();
    t.setUserId();
    t.setPostId();
    t.setAlbumId();
    t.setImageTypeId();
    t.setTitle();
    t.setSrc();
    t.setPathSrc();
    t.setBucketId();
    t.setWidth();
    t.setHeight();
    t.setRatio();
    t.setHashMd5();
    t.setColor();
    t.setCreatedTime();
    t.setW1080();
    t.setW720();
    t.setW480();
    t.setW320();
    t.setW160();
    t.setW80();
	*/

	/*
	PBFlatTypes.PB_Photo t = new PBFlatTypes.PB_Photo();
	t.PhotoId = ;
	t.UserId = ;
	t.PostId = ;
	t.AlbumId = ;
	t.ImageTypeId = ;
	t.Title = ;
	t.Src = ;
	t.PathSrc = ;
	t.BucketId = ;
	t.Width = ;
	t.Height = ;
	t.Ratio = ;
	t.HashMd5 = ;
	t.Color = ;
	t.CreatedTime = ;
	t.W1080 = ;
	t.W720 = ;
	t.W480 = ;
	t.W320 = ;
	t.W160 = ;
	t.W80 = ;
	*/

	/*
	PB_Photo t = new PB_Photo();
	t.PhotoId = m.getPhotoId() ;
	t.UserId = m.getUserId() ;
	t.PostId = m.getPostId() ;
	t.AlbumId = m.getAlbumId() ;
	t.ImageTypeId = m.getImageTypeId() ;
	t.Title = m.getTitle() ;
	t.Src = m.getSrc() ;
	t.PathSrc = m.getPathSrc() ;
	t.BucketId = m.getBucketId() ;
	t.Width = m.getWidth() ;
	t.Height = m.getHeight() ;
	t.Ratio = m.getRatio() ;
	t.HashMd5 = m.getHashMd5() ;
	t.Color = m.getColor() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.W1080 = m.getW1080() ;
	t.W720 = m.getW720() ;
	t.W480 = m.getW480() ;
	t.W320 = m.getW320() ;
	t.W160 = m.getW160() ;
	t.W80 = m.getW80() ;
	*/

	public class PB_Post {
	   public int Id;
	   public int UserId;
	   public int TypeId;
	   public String Text;
	   public String FormatedText;
	   public int MediaCount;
	   public int SharedTo;
	   public int DisableComment;
	   public int HasTag;
	   public int LikesCount;
	   public int CommentsCount;
	   public int EditedTime;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_Post t = new PBFlatTypes.PB_Post();
    t.setId();
    t.setUserId();
    t.setTypeId();
    t.setText();
    t.setFormatedText();
    t.setMediaCount();
    t.setSharedTo();
    t.setDisableComment();
    t.setHasTag();
    t.setLikesCount();
    t.setCommentsCount();
    t.setEditedTime();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_Post t = new PBFlatTypes.PB_Post();
	t.Id = ;
	t.UserId = ;
	t.TypeId = ;
	t.Text = ;
	t.FormatedText = ;
	t.MediaCount = ;
	t.SharedTo = ;
	t.DisableComment = ;
	t.HasTag = ;
	t.LikesCount = ;
	t.CommentsCount = ;
	t.EditedTime = ;
	t.CreatedTime = ;
	*/

	/*
	PB_Post t = new PB_Post();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.TypeId = m.getTypeId() ;
	t.Text = m.getText() ;
	t.FormatedText = m.getFormatedText() ;
	t.MediaCount = m.getMediaCount() ;
	t.SharedTo = m.getSharedTo() ;
	t.DisableComment = m.getDisableComment() ;
	t.HasTag = m.getHasTag() ;
	t.LikesCount = m.getLikesCount() ;
	t.CommentsCount = m.getCommentsCount() ;
	t.EditedTime = m.getEditedTime() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_PushEvent {
	   public long PushEventId;
	   public int ToUserId;
	   public long ToDeviceId;
	   public long MessageId;
	   public int RoomTypeEnum;
	   public long RoomId;
	   public int PeerUserId;
	   public int PushEventTypeEnum;
	   public int AtTime;
	}
	/*
	folding
	PBFlatTypes.PB_PushEvent t = new PBFlatTypes.PB_PushEvent();
    t.setPushEventId();
    t.setToUserId();
    t.setToDeviceId();
    t.setMessageId();
    t.setRoomTypeEnum();
    t.setRoomId();
    t.setPeerUserId();
    t.setPushEventTypeEnum();
    t.setAtTime();
	*/

	/*
	PBFlatTypes.PB_PushEvent t = new PBFlatTypes.PB_PushEvent();
	t.PushEventId = ;
	t.ToUserId = ;
	t.ToDeviceId = ;
	t.MessageId = ;
	t.RoomTypeEnum = ;
	t.RoomId = ;
	t.PeerUserId = ;
	t.PushEventTypeEnum = ;
	t.AtTime = ;
	*/

	/*
	PB_PushEvent t = new PB_PushEvent();
	t.PushEventId = m.getPushEventId() ;
	t.ToUserId = m.getToUserId() ;
	t.ToDeviceId = m.getToDeviceId() ;
	t.MessageId = m.getMessageId() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	t.RoomId = m.getRoomId() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.PushEventTypeEnum = m.getPushEventTypeEnum() ;
	t.AtTime = m.getAtTime() ;
	*/

	public class PB_PushMessage {
	   public long PushMessageId;
	   public int ToUserId;
	   public long ToDeviceId;
	   public long MessageId;
	   public int RoomTypeEnum;
	   public long CreatedMs;
	}
	/*
	folding
	PBFlatTypes.PB_PushMessage t = new PBFlatTypes.PB_PushMessage();
    t.setPushMessageId();
    t.setToUserId();
    t.setToDeviceId();
    t.setMessageId();
    t.setRoomTypeEnum();
    t.setCreatedMs();
	*/

	/*
	PBFlatTypes.PB_PushMessage t = new PBFlatTypes.PB_PushMessage();
	t.PushMessageId = ;
	t.ToUserId = ;
	t.ToDeviceId = ;
	t.MessageId = ;
	t.RoomTypeEnum = ;
	t.CreatedMs = ;
	*/

	/*
	PB_PushMessage t = new PB_PushMessage();
	t.PushMessageId = m.getPushMessageId() ;
	t.ToUserId = m.getToUserId() ;
	t.ToDeviceId = m.getToDeviceId() ;
	t.MessageId = m.getMessageId() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	t.CreatedMs = m.getCreatedMs() ;
	*/

	public class PB_RecommendUser {
	   public int Id;
	   public int UserId;
	   public int TargetId;
	   public float Weight;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_RecommendUser t = new PBFlatTypes.PB_RecommendUser();
    t.setId();
    t.setUserId();
    t.setTargetId();
    t.setWeight();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_RecommendUser t = new PBFlatTypes.PB_RecommendUser();
	t.Id = ;
	t.UserId = ;
	t.TargetId = ;
	t.Weight = ;
	t.CreatedTime = ;
	*/

	/*
	PB_RecommendUser t = new PB_RecommendUser();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.TargetId = m.getTargetId() ;
	t.Weight = m.getWeight() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_Room {
	   public long RoomId;
	   public String RoomKey;
	   public int RoomTypeEnum;
	   public int UserId;
	   public int LastSeqSeen;
	   public int LastSeqDelete;
	   public int PeerUserId;
	   public long GroupId;
	   public int CreatedTime;
	   public int CurrentSeq;
	}
	/*
	folding
	PBFlatTypes.PB_Room t = new PBFlatTypes.PB_Room();
    t.setRoomId();
    t.setRoomKey();
    t.setRoomTypeEnum();
    t.setUserId();
    t.setLastSeqSeen();
    t.setLastSeqDelete();
    t.setPeerUserId();
    t.setGroupId();
    t.setCreatedTime();
    t.setCurrentSeq();
	*/

	/*
	PBFlatTypes.PB_Room t = new PBFlatTypes.PB_Room();
	t.RoomId = ;
	t.RoomKey = ;
	t.RoomTypeEnum = ;
	t.UserId = ;
	t.LastSeqSeen = ;
	t.LastSeqDelete = ;
	t.PeerUserId = ;
	t.GroupId = ;
	t.CreatedTime = ;
	t.CurrentSeq = ;
	*/

	/*
	PB_Room t = new PB_Room();
	t.RoomId = m.getRoomId() ;
	t.RoomKey = m.getRoomKey() ;
	t.RoomTypeEnum = m.getRoomTypeEnum() ;
	t.UserId = m.getUserId() ;
	t.LastSeqSeen = m.getLastSeqSeen() ;
	t.LastSeqDelete = m.getLastSeqDelete() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.GroupId = m.getGroupId() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.CurrentSeq = m.getCurrentSeq() ;
	*/

	public class PB_SearchClicked {
	   public long Id;
	   public String Query;
	   public int ClickType;
	   public int TargetId;
	   public int UserId;
	   public int CreatedAt;
	}
	/*
	folding
	PBFlatTypes.PB_SearchClicked t = new PBFlatTypes.PB_SearchClicked();
    t.setId();
    t.setQuery();
    t.setClickType();
    t.setTargetId();
    t.setUserId();
    t.setCreatedAt();
	*/

	/*
	PBFlatTypes.PB_SearchClicked t = new PBFlatTypes.PB_SearchClicked();
	t.Id = ;
	t.Query = ;
	t.ClickType = ;
	t.TargetId = ;
	t.UserId = ;
	t.CreatedAt = ;
	*/

	/*
	PB_SearchClicked t = new PB_SearchClicked();
	t.Id = m.getId() ;
	t.Query = m.getQuery() ;
	t.ClickType = m.getClickType() ;
	t.TargetId = m.getTargetId() ;
	t.UserId = m.getUserId() ;
	t.CreatedAt = m.getCreatedAt() ;
	*/

	public class PB_Session {
	   public int Id;
	   public int UserId;
	   public String SessionUuid;
	   public String ClientUuid;
	   public String DeviceUuid;
	   public int LastActivityTime;
	   public String LastIpAddress;
	   public String LastWifiMacAddress;
	   public String LastNetworkType;
	   public int LastNetworkTypeId;
	   public int AppVersion;
	   public int UpdatedTime;
	   public int CreatedTime;
	   public long LastSyncDirectUpdateId;
	   public long LastSyncGeneralUpdateId;
	   public long LastSyncNotifyUpdateId;
	}
	/*
	folding
	PBFlatTypes.PB_Session t = new PBFlatTypes.PB_Session();
    t.setId();
    t.setUserId();
    t.setSessionUuid();
    t.setClientUuid();
    t.setDeviceUuid();
    t.setLastActivityTime();
    t.setLastIpAddress();
    t.setLastWifiMacAddress();
    t.setLastNetworkType();
    t.setLastNetworkTypeId();
    t.setAppVersion();
    t.setUpdatedTime();
    t.setCreatedTime();
    t.setLastSyncDirectUpdateId();
    t.setLastSyncGeneralUpdateId();
    t.setLastSyncNotifyUpdateId();
	*/

	/*
	PBFlatTypes.PB_Session t = new PBFlatTypes.PB_Session();
	t.Id = ;
	t.UserId = ;
	t.SessionUuid = ;
	t.ClientUuid = ;
	t.DeviceUuid = ;
	t.LastActivityTime = ;
	t.LastIpAddress = ;
	t.LastWifiMacAddress = ;
	t.LastNetworkType = ;
	t.LastNetworkTypeId = ;
	t.AppVersion = ;
	t.UpdatedTime = ;
	t.CreatedTime = ;
	t.LastSyncDirectUpdateId = ;
	t.LastSyncGeneralUpdateId = ;
	t.LastSyncNotifyUpdateId = ;
	*/

	/*
	PB_Session t = new PB_Session();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.SessionUuid = m.getSessionUuid() ;
	t.ClientUuid = m.getClientUuid() ;
	t.DeviceUuid = m.getDeviceUuid() ;
	t.LastActivityTime = m.getLastActivityTime() ;
	t.LastIpAddress = m.getLastIpAddress() ;
	t.LastWifiMacAddress = m.getLastWifiMacAddress() ;
	t.LastNetworkType = m.getLastNetworkType() ;
	t.LastNetworkTypeId = m.getLastNetworkTypeId() ;
	t.AppVersion = m.getAppVersion() ;
	t.UpdatedTime = m.getUpdatedTime() ;
	t.CreatedTime = m.getCreatedTime() ;
	t.LastSyncDirectUpdateId = m.getLastSyncDirectUpdateId() ;
	t.LastSyncGeneralUpdateId = m.getLastSyncGeneralUpdateId() ;
	t.LastSyncNotifyUpdateId = m.getLastSyncNotifyUpdateId() ;
	*/

	public class PB_SettingClient {
	   public int UserId;
	   public int AutoDownloadWifiVoice;
	   public int AutoDownloadWifiImage;
	   public int AutoDownloadWifiVideo;
	   public int AutoDownloadWifiFile;
	   public int AutoDownloadWifiMusic;
	   public int AutoDownloadWifiGif;
	   public int AutoDownloadCellularVoice;
	   public int AutoDownloadCellularImage;
	   public int AutoDownloadCellularVideo;
	   public int AutoDownloadCellularFile;
	   public int AutoDownloadCellularMusic;
	   public int AutoDownloadCellularGif;
	   public int AutoDownloadRoamingVoice;
	   public int AutoDownloadRoamingImage;
	   public int AutoDownloadRoamingVideo;
	   public int AutoDownloadRoamingFile;
	   public int AutoDownloadRoamingMusic;
	   public int AutoDownloadRoamingGif;
	   public int SaveToGallery;
	}
	/*
	folding
	PBFlatTypes.PB_SettingClient t = new PBFlatTypes.PB_SettingClient();
    t.setUserId();
    t.setAutoDownloadWifiVoice();
    t.setAutoDownloadWifiImage();
    t.setAutoDownloadWifiVideo();
    t.setAutoDownloadWifiFile();
    t.setAutoDownloadWifiMusic();
    t.setAutoDownloadWifiGif();
    t.setAutoDownloadCellularVoice();
    t.setAutoDownloadCellularImage();
    t.setAutoDownloadCellularVideo();
    t.setAutoDownloadCellularFile();
    t.setAutoDownloadCellularMusic();
    t.setAutoDownloadCellularGif();
    t.setAutoDownloadRoamingVoice();
    t.setAutoDownloadRoamingImage();
    t.setAutoDownloadRoamingVideo();
    t.setAutoDownloadRoamingFile();
    t.setAutoDownloadRoamingMusic();
    t.setAutoDownloadRoamingGif();
    t.setSaveToGallery();
	*/

	/*
	PBFlatTypes.PB_SettingClient t = new PBFlatTypes.PB_SettingClient();
	t.UserId = ;
	t.AutoDownloadWifiVoice = ;
	t.AutoDownloadWifiImage = ;
	t.AutoDownloadWifiVideo = ;
	t.AutoDownloadWifiFile = ;
	t.AutoDownloadWifiMusic = ;
	t.AutoDownloadWifiGif = ;
	t.AutoDownloadCellularVoice = ;
	t.AutoDownloadCellularImage = ;
	t.AutoDownloadCellularVideo = ;
	t.AutoDownloadCellularFile = ;
	t.AutoDownloadCellularMusic = ;
	t.AutoDownloadCellularGif = ;
	t.AutoDownloadRoamingVoice = ;
	t.AutoDownloadRoamingImage = ;
	t.AutoDownloadRoamingVideo = ;
	t.AutoDownloadRoamingFile = ;
	t.AutoDownloadRoamingMusic = ;
	t.AutoDownloadRoamingGif = ;
	t.SaveToGallery = ;
	*/

	/*
	PB_SettingClient t = new PB_SettingClient();
	t.UserId = m.getUserId() ;
	t.AutoDownloadWifiVoice = m.getAutoDownloadWifiVoice() ;
	t.AutoDownloadWifiImage = m.getAutoDownloadWifiImage() ;
	t.AutoDownloadWifiVideo = m.getAutoDownloadWifiVideo() ;
	t.AutoDownloadWifiFile = m.getAutoDownloadWifiFile() ;
	t.AutoDownloadWifiMusic = m.getAutoDownloadWifiMusic() ;
	t.AutoDownloadWifiGif = m.getAutoDownloadWifiGif() ;
	t.AutoDownloadCellularVoice = m.getAutoDownloadCellularVoice() ;
	t.AutoDownloadCellularImage = m.getAutoDownloadCellularImage() ;
	t.AutoDownloadCellularVideo = m.getAutoDownloadCellularVideo() ;
	t.AutoDownloadCellularFile = m.getAutoDownloadCellularFile() ;
	t.AutoDownloadCellularMusic = m.getAutoDownloadCellularMusic() ;
	t.AutoDownloadCellularGif = m.getAutoDownloadCellularGif() ;
	t.AutoDownloadRoamingVoice = m.getAutoDownloadRoamingVoice() ;
	t.AutoDownloadRoamingImage = m.getAutoDownloadRoamingImage() ;
	t.AutoDownloadRoamingVideo = m.getAutoDownloadRoamingVideo() ;
	t.AutoDownloadRoamingFile = m.getAutoDownloadRoamingFile() ;
	t.AutoDownloadRoamingMusic = m.getAutoDownloadRoamingMusic() ;
	t.AutoDownloadRoamingGif = m.getAutoDownloadRoamingGif() ;
	t.SaveToGallery = m.getSaveToGallery() ;
	*/

	public class PB_SettingNotification {
	   public int UserId;
	   public int SocialLedOn;
	   public String SocialLedColor;
	   public int ReqestToFollowYou;
	   public int FollowedYou;
	   public int AccptedYourFollowRequest;
	   public int YourPostLiked;
	   public int YourPostCommented;
	   public int MenthenedYouInPost;
	   public int MenthenedYouInComment;
	   public int YourContactsJoined;
	   public int DirectMessage;
	   public int DirectAlert;
	   public int DirectPerview;
	   public int DirectLedOn;
	   public int DirectLedColor;
	   public int DirectVibrate;
	   public int DirectPopup;
	   public int DirectSound;
	   public int DirectPriority;
	}
	/*
	folding
	PBFlatTypes.PB_SettingNotification t = new PBFlatTypes.PB_SettingNotification();
    t.setUserId();
    t.setSocialLedOn();
    t.setSocialLedColor();
    t.setReqestToFollowYou();
    t.setFollowedYou();
    t.setAccptedYourFollowRequest();
    t.setYourPostLiked();
    t.setYourPostCommented();
    t.setMenthenedYouInPost();
    t.setMenthenedYouInComment();
    t.setYourContactsJoined();
    t.setDirectMessage();
    t.setDirectAlert();
    t.setDirectPerview();
    t.setDirectLedOn();
    t.setDirectLedColor();
    t.setDirectVibrate();
    t.setDirectPopup();
    t.setDirectSound();
    t.setDirectPriority();
	*/

	/*
	PBFlatTypes.PB_SettingNotification t = new PBFlatTypes.PB_SettingNotification();
	t.UserId = ;
	t.SocialLedOn = ;
	t.SocialLedColor = ;
	t.ReqestToFollowYou = ;
	t.FollowedYou = ;
	t.AccptedYourFollowRequest = ;
	t.YourPostLiked = ;
	t.YourPostCommented = ;
	t.MenthenedYouInPost = ;
	t.MenthenedYouInComment = ;
	t.YourContactsJoined = ;
	t.DirectMessage = ;
	t.DirectAlert = ;
	t.DirectPerview = ;
	t.DirectLedOn = ;
	t.DirectLedColor = ;
	t.DirectVibrate = ;
	t.DirectPopup = ;
	t.DirectSound = ;
	t.DirectPriority = ;
	*/

	/*
	PB_SettingNotification t = new PB_SettingNotification();
	t.UserId = m.getUserId() ;
	t.SocialLedOn = m.getSocialLedOn() ;
	t.SocialLedColor = m.getSocialLedColor() ;
	t.ReqestToFollowYou = m.getReqestToFollowYou() ;
	t.FollowedYou = m.getFollowedYou() ;
	t.AccptedYourFollowRequest = m.getAccptedYourFollowRequest() ;
	t.YourPostLiked = m.getYourPostLiked() ;
	t.YourPostCommented = m.getYourPostCommented() ;
	t.MenthenedYouInPost = m.getMenthenedYouInPost() ;
	t.MenthenedYouInComment = m.getMenthenedYouInComment() ;
	t.YourContactsJoined = m.getYourContactsJoined() ;
	t.DirectMessage = m.getDirectMessage() ;
	t.DirectAlert = m.getDirectAlert() ;
	t.DirectPerview = m.getDirectPerview() ;
	t.DirectLedOn = m.getDirectLedOn() ;
	t.DirectLedColor = m.getDirectLedColor() ;
	t.DirectVibrate = m.getDirectVibrate() ;
	t.DirectPopup = m.getDirectPopup() ;
	t.DirectSound = m.getDirectSound() ;
	t.DirectPriority = m.getDirectPriority() ;
	*/

	public class PB_Tag {
	   public int Id;
	   public String Name;
	   public int Count;
	   public int IsBlocked;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_Tag t = new PBFlatTypes.PB_Tag();
    t.setId();
    t.setName();
    t.setCount();
    t.setIsBlocked();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_Tag t = new PBFlatTypes.PB_Tag();
	t.Id = ;
	t.Name = ;
	t.Count = ;
	t.IsBlocked = ;
	t.CreatedTime = ;
	*/

	/*
	PB_Tag t = new PB_Tag();
	t.Id = m.getId() ;
	t.Name = m.getName() ;
	t.Count = m.getCount() ;
	t.IsBlocked = m.getIsBlocked() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_TagsPost {
	   public int Id;
	   public int TagId;
	   public int PostId;
	   public int TypeId;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_TagsPost t = new PBFlatTypes.PB_TagsPost();
    t.setId();
    t.setTagId();
    t.setPostId();
    t.setTypeId();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_TagsPost t = new PBFlatTypes.PB_TagsPost();
	t.Id = ;
	t.TagId = ;
	t.PostId = ;
	t.TypeId = ;
	t.CreatedTime = ;
	*/

	/*
	PB_TagsPost t = new PB_TagsPost();
	t.Id = m.getId() ;
	t.TagId = m.getTagId() ;
	t.PostId = m.getPostId() ;
	t.TypeId = m.getTypeId() ;
	t.CreatedTime = m.getCreatedTime() ;
	*/

	public class PB_TestChat {
	   public long Id;
	   public long Id4;
	   public long TimeMs;
	   public String Text;
	   public String Name;
	   public long UserId;
	   public int C2;
	   public int C3;
	   public int C4;
	   public int C5;
	}
	/*
	folding
	PBFlatTypes.PB_TestChat t = new PBFlatTypes.PB_TestChat();
    t.setId();
    t.setId4();
    t.setTimeMs();
    t.setText();
    t.setName();
    t.setUserId();
    t.setC2();
    t.setC3();
    t.setC4();
    t.setC5();
	*/

	/*
	PBFlatTypes.PB_TestChat t = new PBFlatTypes.PB_TestChat();
	t.Id = ;
	t.Id4 = ;
	t.TimeMs = ;
	t.Text = ;
	t.Name = ;
	t.UserId = ;
	t.C2 = ;
	t.C3 = ;
	t.C4 = ;
	t.C5 = ;
	*/

	/*
	PB_TestChat t = new PB_TestChat();
	t.Id = m.getId() ;
	t.Id4 = m.getId4() ;
	t.TimeMs = m.getTimeMs() ;
	t.Text = m.getText() ;
	t.Name = m.getName() ;
	t.UserId = m.getUserId() ;
	t.C2 = m.getC2() ;
	t.C3 = m.getC3() ;
	t.C4 = m.getC4() ;
	t.C5 = m.getC5() ;
	*/

	public class PB_TriggerLog {
	   public long Id;
	   public String ModelName;
	   public String ChangeType;
	   public long TargetId;
	   public String TargetStr;
	   public int CreatedSe;
	}
	/*
	folding
	PBFlatTypes.PB_TriggerLog t = new PBFlatTypes.PB_TriggerLog();
    t.setId();
    t.setModelName();
    t.setChangeType();
    t.setTargetId();
    t.setTargetStr();
    t.setCreatedSe();
	*/

	/*
	PBFlatTypes.PB_TriggerLog t = new PBFlatTypes.PB_TriggerLog();
	t.Id = ;
	t.ModelName = ;
	t.ChangeType = ;
	t.TargetId = ;
	t.TargetStr = ;
	t.CreatedSe = ;
	*/

	/*
	PB_TriggerLog t = new PB_TriggerLog();
	t.Id = m.getId() ;
	t.ModelName = m.getModelName() ;
	t.ChangeType = m.getChangeType() ;
	t.TargetId = m.getTargetId() ;
	t.TargetStr = m.getTargetStr() ;
	t.CreatedSe = m.getCreatedSe() ;
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

	public class PB_UserMetaInfo {
	   public int Id;
	   public int UserId;
	   public int IsNotificationDirty;
	   public int LastUserRecGen;
	}
	/*
	folding
	PBFlatTypes.PB_UserMetaInfo t = new PBFlatTypes.PB_UserMetaInfo();
    t.setId();
    t.setUserId();
    t.setIsNotificationDirty();
    t.setLastUserRecGen();
	*/

	/*
	PBFlatTypes.PB_UserMetaInfo t = new PBFlatTypes.PB_UserMetaInfo();
	t.Id = ;
	t.UserId = ;
	t.IsNotificationDirty = ;
	t.LastUserRecGen = ;
	*/

	/*
	PB_UserMetaInfo t = new PB_UserMetaInfo();
	t.Id = m.getId() ;
	t.UserId = m.getUserId() ;
	t.IsNotificationDirty = m.getIsNotificationDirty() ;
	t.LastUserRecGen = m.getLastUserRecGen() ;
	*/

	public class PB_UserPassword {
	   public int UserId;
	   public String Password;
	   public int CreatedTime;
	}
	/*
	folding
	PBFlatTypes.PB_UserPassword t = new PBFlatTypes.PB_UserPassword();
    t.setUserId();
    t.setPassword();
    t.setCreatedTime();
	*/

	/*
	PBFlatTypes.PB_UserPassword t = new PBFlatTypes.PB_UserPassword();
	t.UserId = ;
	t.Password = ;
	t.CreatedTime = ;
	*/

	/*
	PB_UserPassword t = new PB_UserPassword();
	t.UserId = m.getUserId() ;
	t.Password = m.getPassword() ;
	t.CreatedTime = m.getCreatedTime() ;
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

	public class PB_ChatView {
	   public String ChatKey;
	   public String RoomKey;
	   public int RoomTypeEnumId;
	   public int UserId;
	   public int PeerUserId;
	   public long GroupId;
	   public int CreatedSe;
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
    t.setRoomKey();
    t.setRoomTypeEnumId();
    t.setUserId();
    t.setPeerUserId();
    t.setGroupId();
    t.setCreatedSe();
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
	t.RoomKey = ;
	t.RoomTypeEnumId = ;
	t.UserId = ;
	t.PeerUserId = ;
	t.GroupId = ;
	t.CreatedSe = ;
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
	t.RoomKey = m.getRoomKey() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.UserId = m.getUserId() ;
	t.PeerUserId = m.getPeerUserId() ;
	t.GroupId = m.getGroupId() ;
	t.CreatedSe = m.getCreatedSe() ;
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
	   public String MessageKey;
	   public String RoomKey;
	   public int UserId;
	   public long MessageFileId;
	   public int MessageTypeEnumId;
	   public String Text;
	   public int CreatedSe;
	   public int PeerReceivedTime;
	   public int PeerSeenTime;
	   public int DeliviryStatusEnumId;
	   public String ChatKey;
	   public int RoomTypeEnumId;
	   public boolean IsByMe;
	   public long RemoteId;
	   public PB_MessageFileView MessageFileView;
	}
	/*
	folding
	PBFlatTypes.PB_MessageView t = new PBFlatTypes.PB_MessageView();
    t.setMessageId();
    t.setMessageKey();
    t.setRoomKey();
    t.setUserId();
    t.setMessageFileId();
    t.setMessageTypeEnumId();
    t.setText();
    t.setCreatedSe();
    t.setPeerReceivedTime();
    t.setPeerSeenTime();
    t.setDeliviryStatusEnumId();
    t.setChatKey();
    t.setRoomTypeEnumId();
    t.setIsByMe();
    t.setRemoteId();
    t.setMessageFileView();
	*/

	/*
	PBFlatTypes.PB_MessageView t = new PBFlatTypes.PB_MessageView();
	t.MessageId = ;
	t.MessageKey = ;
	t.RoomKey = ;
	t.UserId = ;
	t.MessageFileId = ;
	t.MessageTypeEnumId = ;
	t.Text = ;
	t.CreatedSe = ;
	t.PeerReceivedTime = ;
	t.PeerSeenTime = ;
	t.DeliviryStatusEnumId = ;
	t.ChatKey = ;
	t.RoomTypeEnumId = ;
	t.IsByMe = ;
	t.RemoteId = ;
	t.MessageFileView = ;
	*/

	/*
	PB_MessageView t = new PB_MessageView();
	t.MessageId = m.getMessageId() ;
	t.MessageKey = m.getMessageKey() ;
	t.RoomKey = m.getRoomKey() ;
	t.UserId = m.getUserId() ;
	t.MessageFileId = m.getMessageFileId() ;
	t.MessageTypeEnumId = m.getMessageTypeEnumId() ;
	t.Text = m.getText() ;
	t.CreatedSe = m.getCreatedSe() ;
	t.PeerReceivedTime = m.getPeerReceivedTime() ;
	t.PeerSeenTime = m.getPeerSeenTime() ;
	t.DeliviryStatusEnumId = m.getDeliviryStatusEnumId() ;
	t.ChatKey = m.getChatKey() ;
	t.RoomTypeEnumId = m.getRoomTypeEnumId() ;
	t.IsByMe = m.getIsByMe() ;
	t.RemoteId = m.getRemoteId() ;
	t.MessageFileView = m.getMessageFileView() ;
	*/

	public class PB_MessageFileView {
	   public long MessageFileId;
	   public String MessageFileKey;
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
    t.setMessageFileKey();
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
	t.MessageFileKey = ;
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
	t.MessageFileKey = m.getMessageFileKey() ;
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

RPC_HANDLERS.RPC_Auth RPC_Auth_Handeler = null;
RPC_HANDLERS.RPC_Chat RPC_Chat_Handeler = null;
RPC_HANDLERS.RPC_Other RPC_Other_Handeler = null;
RPC_HANDLERS.RPC_Sync RPC_Sync_Handeler = null;
RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_HANDLERS.RPC_User RPC_User_Handeler = null;
	
*/