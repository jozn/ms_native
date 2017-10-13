package ir.ms.pb;

import android.util.Log;

public class RPC_ResponseBase {/*

	public static class RPC_Auth_Base implements RPC_HANDLERS.RPC_Auth  {
		public void CheckPhone( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}
		public void SendCode( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}
		public void SendCodeToSms( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}
		public void SendCodeToTelgram( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}
		public void SingUp( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}
		public void SingIn( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}
		public void LogOut( PB_UserResponse_CheckUserName2 pbOut){
			Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
		}}
	public static class RPC_Msg_Base implements RPC_HANDLERS.RPC_Msg  {
		public void AddNewTextMessage( PB_MsgResponse_AddNewTextMessage pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void AddNewMessage( PB_MsgResponse_AddNewMessage pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void SetRoomActionDoing( PB_MsgResponse_SetRoomActionDoing pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void GetMessagesByIds( PB_MsgResponse_GetMessagesByIds pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void GetMessagesHistory( PB_MsgResponse_GetMessagesHistory pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void SetMessagesRangeAsSeen( PB_MsgResponse_SetChatMessagesRangeAsSeen pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void DeleteChatHistory( PB_MsgResponse_DeleteChatHistory pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void DeleteMessagesByIds( PB_MsgResponse_DeleteMessagesByIds pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void SetMessagesAsReceived( PB_MsgResponse_SetMessagesAsReceived pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void ForwardMessages( PB_MsgResponse_ForwardMessages pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void EditMessage( PB_MsgResponse_EditMessage pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void BroadcastNewMessage( PB_MsgResponse_BroadcastNewMessage pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void GetFreshChatList( PB_MsgResponse_GetFreshChatList pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void GetFreshRoomMessagesList( PB_MsgResponse_GetFreshRoomMessagesList pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void GetFreshAllDirectMessagesList( PB_MsgResponse_GetFreshAllDirectMessagesList pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}
		public void Echo( PB_MsgResponse_PB_MsgParam_Echo pbOut){
			Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
		}}
	public static class RPC_Sync_Base implements RPC_HANDLERS.RPC_Sync  {
		public void GetDirectUpdates( PB_SyncResponse_GetDirectUpdates pbOut){
			Log.d("RPC:Response", "RPC_Sync_Base.RPC_Sync");
		}
		public void GetGeneralUpdates( PB_SyncResponse_GetGeneralUpdates pbOut){
			Log.d("RPC:Response", "RPC_Sync_Base.RPC_Sync");
		}
		public void GetNotifyUpdates( PB_SyncResponse_GetNotifyUpdates pbOut){
			Log.d("RPC:Response", "RPC_Sync_Base.RPC_Sync");
		}
		public void SetLastSyncDirectUpdateId( PB_SyncResponse_SetLastSyncDirectUpdateId pbOut){
			Log.d("RPC:Response", "RPC_Sync_Base.RPC_Sync");
		}
		public void SetLastSyncGeneralUpdateId( PB_SyncResponse_SetLastSyncGeneralUpdateId pbOut){
			Log.d("RPC:Response", "RPC_Sync_Base.RPC_Sync");
		}
		public void SetLastSyncNotifyUpdateId( PB_SyncResponse_SetLastSyncNotifyUpdateId pbOut){
			Log.d("RPC:Response", "RPC_Sync_Base.RPC_Sync");
		}}
	public static class RPC_UserOffline_Base implements RPC_HANDLERS.RPC_UserOffline  {
		public void BlockUser( PB_UserOfflineResponse_BlockUser pbOut){
			Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
		}
		public void UnBlockUser( PB_UserOfflineResponse_UnBlockUser pbOut){
			Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
		}
		public void UpdateAbout( PB_UserOfflineResponse_UpdateAbout pbOut){
			Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
		}
		public void UpdateUserName( PB_UserOfflineResponse_UpdateUserName pbOut){
			Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
		}
		public void ChangePrivacy( PB_UserResponseOffline_ChangePrivacy pbOut){
			Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
		}
		public void ChangeAvatar( PB_UserOfflineResponse_ChangeAvatar pbOut){
			Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
		}}
	public static class RPC_User_Base implements RPC_HANDLERS.RPC_User  {
		public void CheckUserName( PB_UserResponse_CheckUserName pbOut){
			Log.d("RPC:Response", "RPC_User_Base.RPC_User");
		}
		public void GetBlockedList( PB_UserResponse_BlockedList pbOut){
			Log.d("RPC:Response", "RPC_User_Base.RPC_User");
		}}
*/
}
/*

RPC_HANDLERS.RPC_Auth RPC_Auth_Handeler = null;
RPC_HANDLERS.RPC_Msg RPC_Msg_Handeler = null;
RPC_HANDLERS.RPC_Sync RPC_Sync_Handeler = null;
RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_HANDLERS.RPC_User RPC_User_Handeler = null;
	
*/