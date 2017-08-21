package ir.ms.pb

public class RPC_INTERFACES {

public interface RPC_MessageReq {
    GetLastChnagesForRoom( PB_ResponseLastChangesForTheRoom );}
public interface RPC_MessageReqOffline {
    SetLastSeen( PB_ResponseSetLastSeenMessages );}
public interface RPC_Auth {
    CheckPhone( PB_UserResponse_CheckUserName2 );
    SendCode( PB_UserResponse_CheckUserName2 );
    SendCodeToSms( PB_UserResponse_CheckUserName2 );
    SendCodeToTelgram( PB_UserResponse_CheckUserName2 );
    SingUp( PB_UserResponse_CheckUserName2 );
    SingIn( PB_UserResponse_CheckUserName2 );
    LogOut( PB_UserResponse_CheckUserName2 );}
public interface RPC_Msg {
    AddNewTextMessage( PB_MsgResponse_AddNewTextMessage );
    SetRoomActionDoing( PB_MsgResponse_SetRoomActionDoing );
    GetMessagesByIds( PB_MsgResponse_GetMessagesByIds );
    GetMessagesHistory( PB_MsgResponse_GetMessagesHistory );
    SetMessagesRangeAsSeen( PB_MsgResponse_SetChatMessagesRangeAsSeen );
    DeleteChatHistory( PB_MsgResponse_DeleteChatHistory );
    DeleteMessagesByIds( PB_MsgResponse_DeleteMessagesByIds );
    SetMessagesAsReceived( PB_MsgResponse_SetMessagesAsReceived );
    ForwardMessages( PB_MsgResponse_ForwardMessages );
    EditMessage( PB_MsgResponse_EditMessage );
    BroadcastNewMessage( PB_MsgResponse_BroadcastNewMessage );
    Echo( PB_MsgResponse_PB_MsgParam_Echo );}
public interface RPC_UserOffline {
    BlockUser( PB_UserOfflineResponse_BlockUser );
    UnBlockUser( PB_UserOfflineResponse_UnBlockUser );
    UpdateAbout( PB_UserOfflineResponse_UpdateAbout );
    UpdateUserName( PB_UserOfflineResponse_UpdateUserName );
    ChangePrivacy( PB_UserResponseOffline_ChangePrivacy );
    ChangeAvatar( PB_UserOfflineResponse_ChangeAvatar );}
public interface RPC_User {
    CheckUserName( PB_UserResponse_CheckUserName );
    GetBlockedList( PB_UserResponse_BlockedList );}
	
}
/*

RPC_INTERFACES.RPC_MessageReq RPC_MessageReq_Handeler = null;
RPC_INTERFACES.RPC_MessageReqOffline RPC_MessageReqOffline_Handeler = null;
RPC_INTERFACES.RPC_Auth RPC_Auth_Handeler = null;
RPC_INTERFACES.RPC_Msg RPC_Msg_Handeler = null;
RPC_INTERFACES.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_INTERFACES.RPC_User RPC_User_Handeler = null;
	
*/