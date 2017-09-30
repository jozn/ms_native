package ir.ms.pb;

import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class RPC_HANDLERS {

public interface RPC_MessageReq {
    void GetLastChnagesForRoom( PB_ResponseLastChangesForTheRoom pb, boolean handled);
}
public interface RPC_MessageReqOffline {
    void SetLastSeen( PB_ResponseSetLastSeenMessages pb, boolean handled);
}
public interface RPC_Auth {
    void CheckPhone( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SendCode( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SendCodeToSms( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SendCodeToTelgram( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SingUp( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SingIn( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void LogOut( PB_UserResponse_CheckUserName2 pb, boolean handled);
}
public interface RPC_Msg {
    void AddNewTextMessage( PB_MsgResponse_AddNewTextMessage pb, boolean handled);
    void AddNewMessage( PB_MsgResponse_AddNewMessage pb, boolean handled);
    void SetRoomActionDoing( PB_MsgResponse_SetRoomActionDoing pb, boolean handled);
    void GetMessagesByIds( PB_MsgResponse_GetMessagesByIds pb, boolean handled);
    void GetMessagesHistory( PB_MsgResponse_GetMessagesHistory pb, boolean handled);
    void SetMessagesRangeAsSeen( PB_MsgResponse_SetChatMessagesRangeAsSeen pb, boolean handled);
    void DeleteChatHistory( PB_MsgResponse_DeleteChatHistory pb, boolean handled);
    void DeleteMessagesByIds( PB_MsgResponse_DeleteMessagesByIds pb, boolean handled);
    void SetMessagesAsReceived( PB_MsgResponse_SetMessagesAsReceived pb, boolean handled);
    void ForwardMessages( PB_MsgResponse_ForwardMessages pb, boolean handled);
    void EditMessage( PB_MsgResponse_EditMessage pb, boolean handled);
    void BroadcastNewMessage( PB_MsgResponse_BroadcastNewMessage pb, boolean handled);
    void GetFreshChatList( PB_MsgResponse_GetFreshChatList pb, boolean handled);
    void GetFreshRoomMessagesList( PB_MsgResponse_GetFreshRoomMessagesList pb, boolean handled);
    void Echo( PB_MsgResponse_PB_MsgParam_Echo pb, boolean handled);
}
public interface RPC_Sync {
    void GetDirectUpdates( PB_SyncResponse_GetDirectUpdates pb, boolean handled);
    void GetGeneralUpdates( PB_SyncResponse_GetGeneralUpdates pb, boolean handled);
    void GetNotifyUpdates( PB_SyncResponse_GetNotifyUpdates pb, boolean handled);
    void SetLastSyncDirectUpdateId( PB_SyncResponse_SetLastSyncDirectUpdateId pb, boolean handled);
    void SetLastSyncGeneralUpdateId( PB_SyncResponse_SetLastSyncGeneralUpdateId pb, boolean handled);
    void SetLastSyncNotifyUpdateId( PB_SyncResponse_SetLastSyncNotifyUpdateId pb, boolean handled);
}
public interface RPC_UserOffline {
    void BlockUser( PB_UserOfflineResponse_BlockUser pb, boolean handled);
    void UnBlockUser( PB_UserOfflineResponse_UnBlockUser pb, boolean handled);
    void UpdateAbout( PB_UserOfflineResponse_UpdateAbout pb, boolean handled);
    void UpdateUserName( PB_UserOfflineResponse_UpdateUserName pb, boolean handled);
    void ChangePrivacy( PB_UserResponseOffline_ChangePrivacy pb, boolean handled);
    void ChangeAvatar( PB_UserOfflineResponse_ChangeAvatar pb, boolean handled);
}
public interface RPC_User {
    void CheckUserName( PB_UserResponse_CheckUserName pb, boolean handled);
    void GetBlockedList( PB_UserResponse_BlockedList pb, boolean handled);
}


  public static class RPC_MessageReq_Empty implements RPC_MessageReq{
  
  	@Override
    public void GetLastChnagesForRoom( PB_ResponseLastChangesForTheRoom pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_MessageReq.GetLastChnagesForRoom' ");
    }
  }
  public static class RPC_MessageReqOffline_Empty implements RPC_MessageReqOffline{
  
  	@Override
    public void SetLastSeen( PB_ResponseSetLastSeenMessages pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_MessageReqOffline.SetLastSeen' ");
    }
  }
  public static class RPC_Auth_Empty implements RPC_Auth{
  
  	@Override
    public void CheckPhone( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.CheckPhone' ");
    }
  	@Override
    public void SendCode( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.SendCode' ");
    }
  	@Override
    public void SendCodeToSms( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.SendCodeToSms' ");
    }
  	@Override
    public void SendCodeToTelgram( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.SendCodeToTelgram' ");
    }
  	@Override
    public void SingUp( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.SingUp' ");
    }
  	@Override
    public void SingIn( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.SingIn' ");
    }
  	@Override
    public void LogOut( PB_UserResponse_CheckUserName2 pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Auth.LogOut' ");
    }
  }
  public static class RPC_Msg_Empty implements RPC_Msg{
  
  	@Override
    public void AddNewTextMessage( PB_MsgResponse_AddNewTextMessage pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.AddNewTextMessage' ");
    }
  	@Override
    public void AddNewMessage( PB_MsgResponse_AddNewMessage pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.AddNewMessage' ");
    }
  	@Override
    public void SetRoomActionDoing( PB_MsgResponse_SetRoomActionDoing pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.SetRoomActionDoing' ");
    }
  	@Override
    public void GetMessagesByIds( PB_MsgResponse_GetMessagesByIds pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.GetMessagesByIds' ");
    }
  	@Override
    public void GetMessagesHistory( PB_MsgResponse_GetMessagesHistory pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.GetMessagesHistory' ");
    }
  	@Override
    public void SetMessagesRangeAsSeen( PB_MsgResponse_SetChatMessagesRangeAsSeen pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.SetMessagesRangeAsSeen' ");
    }
  	@Override
    public void DeleteChatHistory( PB_MsgResponse_DeleteChatHistory pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.DeleteChatHistory' ");
    }
  	@Override
    public void DeleteMessagesByIds( PB_MsgResponse_DeleteMessagesByIds pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.DeleteMessagesByIds' ");
    }
  	@Override
    public void SetMessagesAsReceived( PB_MsgResponse_SetMessagesAsReceived pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.SetMessagesAsReceived' ");
    }
  	@Override
    public void ForwardMessages( PB_MsgResponse_ForwardMessages pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.ForwardMessages' ");
    }
  	@Override
    public void EditMessage( PB_MsgResponse_EditMessage pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.EditMessage' ");
    }
  	@Override
    public void BroadcastNewMessage( PB_MsgResponse_BroadcastNewMessage pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.BroadcastNewMessage' ");
    }
  	@Override
    public void GetFreshChatList( PB_MsgResponse_GetFreshChatList pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.GetFreshChatList' ");
    }
  	@Override
    public void GetFreshRoomMessagesList( PB_MsgResponse_GetFreshRoomMessagesList pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.GetFreshRoomMessagesList' ");
    }
  	@Override
    public void Echo( PB_MsgResponse_PB_MsgParam_Echo pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Msg.Echo' ");
    }
  }
  public static class RPC_Sync_Empty implements RPC_Sync{
  
  	@Override
    public void GetDirectUpdates( PB_SyncResponse_GetDirectUpdates pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Sync.GetDirectUpdates' ");
    }
  	@Override
    public void GetGeneralUpdates( PB_SyncResponse_GetGeneralUpdates pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Sync.GetGeneralUpdates' ");
    }
  	@Override
    public void GetNotifyUpdates( PB_SyncResponse_GetNotifyUpdates pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Sync.GetNotifyUpdates' ");
    }
  	@Override
    public void SetLastSyncDirectUpdateId( PB_SyncResponse_SetLastSyncDirectUpdateId pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Sync.SetLastSyncDirectUpdateId' ");
    }
  	@Override
    public void SetLastSyncGeneralUpdateId( PB_SyncResponse_SetLastSyncGeneralUpdateId pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Sync.SetLastSyncGeneralUpdateId' ");
    }
  	@Override
    public void SetLastSyncNotifyUpdateId( PB_SyncResponse_SetLastSyncNotifyUpdateId pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Sync.SetLastSyncNotifyUpdateId' ");
    }
  }
  public static class RPC_UserOffline_Empty implements RPC_UserOffline{
  
  	@Override
    public void BlockUser( PB_UserOfflineResponse_BlockUser pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_UserOffline.BlockUser' ");
    }
  	@Override
    public void UnBlockUser( PB_UserOfflineResponse_UnBlockUser pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_UserOffline.UnBlockUser' ");
    }
  	@Override
    public void UpdateAbout( PB_UserOfflineResponse_UpdateAbout pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_UserOffline.UpdateAbout' ");
    }
  	@Override
    public void UpdateUserName( PB_UserOfflineResponse_UpdateUserName pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_UserOffline.UpdateUserName' ");
    }
  	@Override
    public void ChangePrivacy( PB_UserResponseOffline_ChangePrivacy pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_UserOffline.ChangePrivacy' ");
    }
  	@Override
    public void ChangeAvatar( PB_UserOfflineResponse_ChangeAvatar pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_UserOffline.ChangeAvatar' ");
    }
  }
  public static class RPC_User_Empty implements RPC_User{
  
  	@Override
    public void CheckUserName( PB_UserResponse_CheckUserName pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_User.CheckUserName' ");
    }
  	@Override
    public void GetBlockedList( PB_UserResponse_BlockedList pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_User.GetBlockedList' ");
    }
  }

	/////////////////////////////////// Maper of Handling methods /////////////////////////////////
	public static interface HandleRowRpcResponse {
		void handle(Object pb,boolean handled);
	}


	
	public static RPC_HANDLERS.RPC_MessageReq RPC_MessageReq_Default_Handler = new RPC_HANDLERS.RPC_MessageReq_Empty();
	public static RPC_HANDLERS.RPC_MessageReqOffline RPC_MessageReqOffline_Default_Handler = new RPC_HANDLERS.RPC_MessageReqOffline_Empty();
	public static RPC_HANDLERS.RPC_Auth RPC_Auth_Default_Handler = new RPC_HANDLERS.RPC_Auth_Empty();
	public static RPC_HANDLERS.RPC_Msg RPC_Msg_Default_Handler = new RPC_HANDLERS.RPC_Msg_Empty();
	public static RPC_HANDLERS.RPC_Sync RPC_Sync_Default_Handler = new RPC_HANDLERS.RPC_Sync_Empty();
	public static RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Default_Handler = new RPC_HANDLERS.RPC_UserOffline_Empty();
	public static RPC_HANDLERS.RPC_User RPC_User_Default_Handler = new RPC_HANDLERS.RPC_User_Empty();


	public static Map<String,HandleRowRpcResponse > router = new HashMap<>();

	public static Map<String,HandleRowRpcResponse > getRouter(){
		if(router.size() ==0 ){
			initMap();
		}
		return router;
	}

	private synchronized static void initMap(){
	
	  
			router.put("RPC_MessageReq.GetLastChnagesForRoom", (pb, handled)->{
				if(pb instanceof PB_ResponseLastChangesForTheRoom){
					RPC_MessageReq_Default_Handler.GetLastChnagesForRoom((PB_ResponseLastChangesForTheRoom) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ResponseLastChangesForTheRoom in rpc: .GetLastChnagesForRoom ");
				}
			});
	  
	  
			router.put("RPC_MessageReqOffline.SetLastSeen", (pb, handled)->{
				if(pb instanceof PB_ResponseSetLastSeenMessages){
					RPC_MessageReqOffline_Default_Handler.SetLastSeen((PB_ResponseSetLastSeenMessages) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ResponseSetLastSeenMessages in rpc: .SetLastSeen ");
				}
			});
	  
	  
			router.put("RPC_Auth.CheckPhone", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.CheckPhone((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .CheckPhone ");
				}
			});
	  
			router.put("RPC_Auth.SendCode", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SendCode((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SendCode ");
				}
			});
	  
			router.put("RPC_Auth.SendCodeToSms", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SendCodeToSms((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SendCodeToSms ");
				}
			});
	  
			router.put("RPC_Auth.SendCodeToTelgram", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SendCodeToTelgram((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SendCodeToTelgram ");
				}
			});
	  
			router.put("RPC_Auth.SingUp", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SingUp((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SingUp ");
				}
			});
	  
			router.put("RPC_Auth.SingIn", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SingIn((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SingIn ");
				}
			});
	  
			router.put("RPC_Auth.LogOut", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.LogOut((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .LogOut ");
				}
			});
	  
	  
			router.put("RPC_Msg.AddNewTextMessage", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_AddNewTextMessage){
					RPC_Msg_Default_Handler.AddNewTextMessage((PB_MsgResponse_AddNewTextMessage) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_AddNewTextMessage in rpc: .AddNewTextMessage ");
				}
			});
	  
			router.put("RPC_Msg.AddNewMessage", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_AddNewMessage){
					RPC_Msg_Default_Handler.AddNewMessage((PB_MsgResponse_AddNewMessage) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_AddNewMessage in rpc: .AddNewMessage ");
				}
			});
	  
			router.put("RPC_Msg.SetRoomActionDoing", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_SetRoomActionDoing){
					RPC_Msg_Default_Handler.SetRoomActionDoing((PB_MsgResponse_SetRoomActionDoing) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_SetRoomActionDoing in rpc: .SetRoomActionDoing ");
				}
			});
	  
			router.put("RPC_Msg.GetMessagesByIds", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_GetMessagesByIds){
					RPC_Msg_Default_Handler.GetMessagesByIds((PB_MsgResponse_GetMessagesByIds) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_GetMessagesByIds in rpc: .GetMessagesByIds ");
				}
			});
	  
			router.put("RPC_Msg.GetMessagesHistory", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_GetMessagesHistory){
					RPC_Msg_Default_Handler.GetMessagesHistory((PB_MsgResponse_GetMessagesHistory) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_GetMessagesHistory in rpc: .GetMessagesHistory ");
				}
			});
	  
			router.put("RPC_Msg.SetMessagesRangeAsSeen", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_SetChatMessagesRangeAsSeen){
					RPC_Msg_Default_Handler.SetMessagesRangeAsSeen((PB_MsgResponse_SetChatMessagesRangeAsSeen) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_SetChatMessagesRangeAsSeen in rpc: .SetMessagesRangeAsSeen ");
				}
			});
	  
			router.put("RPC_Msg.DeleteChatHistory", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_DeleteChatHistory){
					RPC_Msg_Default_Handler.DeleteChatHistory((PB_MsgResponse_DeleteChatHistory) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_DeleteChatHistory in rpc: .DeleteChatHistory ");
				}
			});
	  
			router.put("RPC_Msg.DeleteMessagesByIds", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_DeleteMessagesByIds){
					RPC_Msg_Default_Handler.DeleteMessagesByIds((PB_MsgResponse_DeleteMessagesByIds) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_DeleteMessagesByIds in rpc: .DeleteMessagesByIds ");
				}
			});
	  
			router.put("RPC_Msg.SetMessagesAsReceived", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_SetMessagesAsReceived){
					RPC_Msg_Default_Handler.SetMessagesAsReceived((PB_MsgResponse_SetMessagesAsReceived) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_SetMessagesAsReceived in rpc: .SetMessagesAsReceived ");
				}
			});
	  
			router.put("RPC_Msg.ForwardMessages", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_ForwardMessages){
					RPC_Msg_Default_Handler.ForwardMessages((PB_MsgResponse_ForwardMessages) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_ForwardMessages in rpc: .ForwardMessages ");
				}
			});
	  
			router.put("RPC_Msg.EditMessage", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_EditMessage){
					RPC_Msg_Default_Handler.EditMessage((PB_MsgResponse_EditMessage) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_EditMessage in rpc: .EditMessage ");
				}
			});
	  
			router.put("RPC_Msg.BroadcastNewMessage", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_BroadcastNewMessage){
					RPC_Msg_Default_Handler.BroadcastNewMessage((PB_MsgResponse_BroadcastNewMessage) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_BroadcastNewMessage in rpc: .BroadcastNewMessage ");
				}
			});
	  
			router.put("RPC_Msg.GetFreshChatList", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_GetFreshChatList){
					RPC_Msg_Default_Handler.GetFreshChatList((PB_MsgResponse_GetFreshChatList) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_GetFreshChatList in rpc: .GetFreshChatList ");
				}
			});
	  
			router.put("RPC_Msg.GetFreshRoomMessagesList", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_GetFreshRoomMessagesList){
					RPC_Msg_Default_Handler.GetFreshRoomMessagesList((PB_MsgResponse_GetFreshRoomMessagesList) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_GetFreshRoomMessagesList in rpc: .GetFreshRoomMessagesList ");
				}
			});
	  
			router.put("RPC_Msg.Echo", (pb, handled)->{
				if(pb instanceof PB_MsgResponse_PB_MsgParam_Echo){
					RPC_Msg_Default_Handler.Echo((PB_MsgResponse_PB_MsgParam_Echo) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_MsgResponse_PB_MsgParam_Echo in rpc: .Echo ");
				}
			});
	  
	  
			router.put("RPC_Sync.GetDirectUpdates", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_GetDirectUpdates){
					RPC_Sync_Default_Handler.GetDirectUpdates((PB_SyncResponse_GetDirectUpdates) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_GetDirectUpdates in rpc: .GetDirectUpdates ");
				}
			});
	  
			router.put("RPC_Sync.GetGeneralUpdates", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_GetGeneralUpdates){
					RPC_Sync_Default_Handler.GetGeneralUpdates((PB_SyncResponse_GetGeneralUpdates) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_GetGeneralUpdates in rpc: .GetGeneralUpdates ");
				}
			});
	  
			router.put("RPC_Sync.GetNotifyUpdates", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_GetNotifyUpdates){
					RPC_Sync_Default_Handler.GetNotifyUpdates((PB_SyncResponse_GetNotifyUpdates) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_GetNotifyUpdates in rpc: .GetNotifyUpdates ");
				}
			});
	  
			router.put("RPC_Sync.SetLastSyncDirectUpdateId", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_SetLastSyncDirectUpdateId){
					RPC_Sync_Default_Handler.SetLastSyncDirectUpdateId((PB_SyncResponse_SetLastSyncDirectUpdateId) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_SetLastSyncDirectUpdateId in rpc: .SetLastSyncDirectUpdateId ");
				}
			});
	  
			router.put("RPC_Sync.SetLastSyncGeneralUpdateId", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_SetLastSyncGeneralUpdateId){
					RPC_Sync_Default_Handler.SetLastSyncGeneralUpdateId((PB_SyncResponse_SetLastSyncGeneralUpdateId) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_SetLastSyncGeneralUpdateId in rpc: .SetLastSyncGeneralUpdateId ");
				}
			});
	  
			router.put("RPC_Sync.SetLastSyncNotifyUpdateId", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_SetLastSyncNotifyUpdateId){
					RPC_Sync_Default_Handler.SetLastSyncNotifyUpdateId((PB_SyncResponse_SetLastSyncNotifyUpdateId) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_SetLastSyncNotifyUpdateId in rpc: .SetLastSyncNotifyUpdateId ");
				}
			});
	  
	  
			router.put("RPC_UserOffline.BlockUser", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_BlockUser){
					RPC_UserOffline_Default_Handler.BlockUser((PB_UserOfflineResponse_BlockUser) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_BlockUser in rpc: .BlockUser ");
				}
			});
	  
			router.put("RPC_UserOffline.UnBlockUser", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_UnBlockUser){
					RPC_UserOffline_Default_Handler.UnBlockUser((PB_UserOfflineResponse_UnBlockUser) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_UnBlockUser in rpc: .UnBlockUser ");
				}
			});
	  
			router.put("RPC_UserOffline.UpdateAbout", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_UpdateAbout){
					RPC_UserOffline_Default_Handler.UpdateAbout((PB_UserOfflineResponse_UpdateAbout) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_UpdateAbout in rpc: .UpdateAbout ");
				}
			});
	  
			router.put("RPC_UserOffline.UpdateUserName", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_UpdateUserName){
					RPC_UserOffline_Default_Handler.UpdateUserName((PB_UserOfflineResponse_UpdateUserName) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_UpdateUserName in rpc: .UpdateUserName ");
				}
			});
	  
			router.put("RPC_UserOffline.ChangePrivacy", (pb, handled)->{
				if(pb instanceof PB_UserResponseOffline_ChangePrivacy){
					RPC_UserOffline_Default_Handler.ChangePrivacy((PB_UserResponseOffline_ChangePrivacy) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponseOffline_ChangePrivacy in rpc: .ChangePrivacy ");
				}
			});
	  
			router.put("RPC_UserOffline.ChangeAvatar", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_ChangeAvatar){
					RPC_UserOffline_Default_Handler.ChangeAvatar((PB_UserOfflineResponse_ChangeAvatar) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_ChangeAvatar in rpc: .ChangeAvatar ");
				}
			});
	  
	  
			router.put("RPC_User.CheckUserName", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName){
					RPC_User_Default_Handler.CheckUserName((PB_UserResponse_CheckUserName) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName in rpc: .CheckUserName ");
				}
			});
	  
			router.put("RPC_User.GetBlockedList", (pb, handled)->{
				if(pb instanceof PB_UserResponse_BlockedList){
					RPC_User_Default_Handler.GetBlockedList((PB_UserResponse_BlockedList) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_BlockedList in rpc: .GetBlockedList ");
				}
			});
	  
	}
	
}
/*

RPC_HANDLERS.RPC_MessageReq RPC_MessageReq_Default_Handler = new RPC_HANDLERS.RPC_MessageReq RPC_MessageReq_Empty();
RPC_HANDLERS.RPC_MessageReqOffline RPC_MessageReqOffline_Default_Handler = new RPC_HANDLERS.RPC_MessageReqOffline RPC_MessageReqOffline_Empty();
RPC_HANDLERS.RPC_Auth RPC_Auth_Default_Handler = new RPC_HANDLERS.RPC_Auth RPC_Auth_Empty();
RPC_HANDLERS.RPC_Msg RPC_Msg_Default_Handler = new RPC_HANDLERS.RPC_Msg RPC_Msg_Empty();
RPC_HANDLERS.RPC_Sync RPC_Sync_Default_Handler = new RPC_HANDLERS.RPC_Sync RPC_Sync_Empty();
RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Default_Handler = new RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Empty();
RPC_HANDLERS.RPC_User RPC_User_Default_Handler = new RPC_HANDLERS.RPC_User RPC_User_Empty();
	
*/