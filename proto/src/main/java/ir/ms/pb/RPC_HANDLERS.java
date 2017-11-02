package ir.ms.pb;

import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class RPC_HANDLERS {

public interface RPC_Auth {
    void CheckPhone( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SendCode( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SendCodeToSms( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SendCodeToTelgram( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SingUp( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void SingIn( PB_UserResponse_CheckUserName2 pb, boolean handled);
    void LogOut( PB_UserResponse_CheckUserName2 pb, boolean handled);
}
public interface RPC_Chat {
    void AddNewMessage( PB_ChatResponse_AddNewMessage pb, boolean handled);
    void SetRoomActionDoing( PB_ChatResponse_SetRoomActionDoing pb, boolean handled);
    void SetMessagesRangeAsSeen( PB_ChatResponse_SetChatMessagesRangeAsSeen pb, boolean handled);
    void DeleteChatHistory( PB_ChatResponse_DeleteChatHistory pb, boolean handled);
    void DeleteMessagesByIds( PB_ChatResponse_DeleteMessagesByIds pb, boolean handled);
    void SetMessagesAsReceived( PB_ChatResponse_SetMessagesAsReceived pb, boolean handled);
    void EditMessage( PB_ChatResponse_EditMessage pb, boolean handled);
    void GetChatList( PB_ChatResponse_GetChatList pb, boolean handled);
    void GetChatHistoryToOlder( PB_ChatResponse_GetChatHistoryToOlder pb, boolean handled);
    void GetFreshAllDirectMessagesList( PB_ChatResponse_GetFreshAllDirectMessagesList pb, boolean handled);
}
public interface RPC_Other {
    void Echo( PB_OtherResponse_Echo pb, boolean handled);
}
public interface RPC_Sync {
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
  public static class RPC_Chat_Empty implements RPC_Chat{
  
  	@Override
    public void AddNewMessage( PB_ChatResponse_AddNewMessage pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.AddNewMessage' ");
    }
  	@Override
    public void SetRoomActionDoing( PB_ChatResponse_SetRoomActionDoing pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.SetRoomActionDoing' ");
    }
  	@Override
    public void SetMessagesRangeAsSeen( PB_ChatResponse_SetChatMessagesRangeAsSeen pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.SetMessagesRangeAsSeen' ");
    }
  	@Override
    public void DeleteChatHistory( PB_ChatResponse_DeleteChatHistory pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.DeleteChatHistory' ");
    }
  	@Override
    public void DeleteMessagesByIds( PB_ChatResponse_DeleteMessagesByIds pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.DeleteMessagesByIds' ");
    }
  	@Override
    public void SetMessagesAsReceived( PB_ChatResponse_SetMessagesAsReceived pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.SetMessagesAsReceived' ");
    }
  	@Override
    public void EditMessage( PB_ChatResponse_EditMessage pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.EditMessage' ");
    }
  	@Override
    public void GetChatList( PB_ChatResponse_GetChatList pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.GetChatList' ");
    }
  	@Override
    public void GetChatHistoryToOlder( PB_ChatResponse_GetChatHistoryToOlder pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.GetChatHistoryToOlder' ");
    }
  	@Override
    public void GetFreshAllDirectMessagesList( PB_ChatResponse_GetFreshAllDirectMessagesList pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Chat.GetFreshAllDirectMessagesList' ");
    }
  }
  public static class RPC_Other_Empty implements RPC_Other{
  
  	@Override
    public void Echo( PB_OtherResponse_Echo pb, boolean handled){
    	Log.d("RPC", " default empty handler for RPC 'RPC_Other.Echo' ");
    }
  }
  public static class RPC_Sync_Empty implements RPC_Sync{
  
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


	
	public static RPC_HANDLERS.RPC_Auth RPC_Auth_Default_Handler = new RPC_HANDLERS.RPC_Auth_Empty();
	public static RPC_HANDLERS.RPC_Chat RPC_Chat_Default_Handler = new RPC_HANDLERS.RPC_Chat_Empty();
	public static RPC_HANDLERS.RPC_Other RPC_Other_Default_Handler = new RPC_HANDLERS.RPC_Other_Empty();
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
	
	  
			router.put("RPC_Auth.CheckPhone", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.CheckPhone((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .CheckPhone -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Auth.SendCode", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SendCode((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SendCode -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Auth.SendCodeToSms", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SendCodeToSms((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SendCodeToSms -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Auth.SendCodeToTelgram", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SendCodeToTelgram((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SendCodeToTelgram -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Auth.SingUp", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SingUp((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SingUp -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Auth.SingIn", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.SingIn((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .SingIn -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Auth.LogOut", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName2){
					RPC_Auth_Default_Handler.LogOut((PB_UserResponse_CheckUserName2) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName2 in rpc: .LogOut -- class: " + pb );//.getClass().getName());
				}
			});
	  
	  
			router.put("RPC_Chat.AddNewMessage", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_AddNewMessage){
					RPC_Chat_Default_Handler.AddNewMessage((PB_ChatResponse_AddNewMessage) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_AddNewMessage in rpc: .AddNewMessage -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.SetRoomActionDoing", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_SetRoomActionDoing){
					RPC_Chat_Default_Handler.SetRoomActionDoing((PB_ChatResponse_SetRoomActionDoing) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_SetRoomActionDoing in rpc: .SetRoomActionDoing -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.SetMessagesRangeAsSeen", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_SetChatMessagesRangeAsSeen){
					RPC_Chat_Default_Handler.SetMessagesRangeAsSeen((PB_ChatResponse_SetChatMessagesRangeAsSeen) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_SetChatMessagesRangeAsSeen in rpc: .SetMessagesRangeAsSeen -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.DeleteChatHistory", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_DeleteChatHistory){
					RPC_Chat_Default_Handler.DeleteChatHistory((PB_ChatResponse_DeleteChatHistory) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_DeleteChatHistory in rpc: .DeleteChatHistory -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.DeleteMessagesByIds", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_DeleteMessagesByIds){
					RPC_Chat_Default_Handler.DeleteMessagesByIds((PB_ChatResponse_DeleteMessagesByIds) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_DeleteMessagesByIds in rpc: .DeleteMessagesByIds -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.SetMessagesAsReceived", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_SetMessagesAsReceived){
					RPC_Chat_Default_Handler.SetMessagesAsReceived((PB_ChatResponse_SetMessagesAsReceived) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_SetMessagesAsReceived in rpc: .SetMessagesAsReceived -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.EditMessage", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_EditMessage){
					RPC_Chat_Default_Handler.EditMessage((PB_ChatResponse_EditMessage) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_EditMessage in rpc: .EditMessage -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.GetChatList", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_GetChatList){
					RPC_Chat_Default_Handler.GetChatList((PB_ChatResponse_GetChatList) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_GetChatList in rpc: .GetChatList -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.GetChatHistoryToOlder", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_GetChatHistoryToOlder){
					RPC_Chat_Default_Handler.GetChatHistoryToOlder((PB_ChatResponse_GetChatHistoryToOlder) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_GetChatHistoryToOlder in rpc: .GetChatHistoryToOlder -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Chat.GetFreshAllDirectMessagesList", (pb, handled)->{
				if(pb instanceof PB_ChatResponse_GetFreshAllDirectMessagesList){
					RPC_Chat_Default_Handler.GetFreshAllDirectMessagesList((PB_ChatResponse_GetFreshAllDirectMessagesList) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_ChatResponse_GetFreshAllDirectMessagesList in rpc: .GetFreshAllDirectMessagesList -- class: " + pb );//.getClass().getName());
				}
			});
	  
	  
			router.put("RPC_Other.Echo", (pb, handled)->{
				if(pb instanceof PB_OtherResponse_Echo){
					RPC_Other_Default_Handler.Echo((PB_OtherResponse_Echo) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_OtherResponse_Echo in rpc: .Echo -- class: " + pb );//.getClass().getName());
				}
			});
	  
	  
			router.put("RPC_Sync.GetGeneralUpdates", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_GetGeneralUpdates){
					RPC_Sync_Default_Handler.GetGeneralUpdates((PB_SyncResponse_GetGeneralUpdates) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_GetGeneralUpdates in rpc: .GetGeneralUpdates -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Sync.GetNotifyUpdates", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_GetNotifyUpdates){
					RPC_Sync_Default_Handler.GetNotifyUpdates((PB_SyncResponse_GetNotifyUpdates) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_GetNotifyUpdates in rpc: .GetNotifyUpdates -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Sync.SetLastSyncDirectUpdateId", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_SetLastSyncDirectUpdateId){
					RPC_Sync_Default_Handler.SetLastSyncDirectUpdateId((PB_SyncResponse_SetLastSyncDirectUpdateId) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_SetLastSyncDirectUpdateId in rpc: .SetLastSyncDirectUpdateId -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Sync.SetLastSyncGeneralUpdateId", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_SetLastSyncGeneralUpdateId){
					RPC_Sync_Default_Handler.SetLastSyncGeneralUpdateId((PB_SyncResponse_SetLastSyncGeneralUpdateId) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_SetLastSyncGeneralUpdateId in rpc: .SetLastSyncGeneralUpdateId -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_Sync.SetLastSyncNotifyUpdateId", (pb, handled)->{
				if(pb instanceof PB_SyncResponse_SetLastSyncNotifyUpdateId){
					RPC_Sync_Default_Handler.SetLastSyncNotifyUpdateId((PB_SyncResponse_SetLastSyncNotifyUpdateId) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_SyncResponse_SetLastSyncNotifyUpdateId in rpc: .SetLastSyncNotifyUpdateId -- class: " + pb );//.getClass().getName());
				}
			});
	  
	  
			router.put("RPC_UserOffline.BlockUser", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_BlockUser){
					RPC_UserOffline_Default_Handler.BlockUser((PB_UserOfflineResponse_BlockUser) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_BlockUser in rpc: .BlockUser -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_UserOffline.UnBlockUser", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_UnBlockUser){
					RPC_UserOffline_Default_Handler.UnBlockUser((PB_UserOfflineResponse_UnBlockUser) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_UnBlockUser in rpc: .UnBlockUser -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_UserOffline.UpdateAbout", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_UpdateAbout){
					RPC_UserOffline_Default_Handler.UpdateAbout((PB_UserOfflineResponse_UpdateAbout) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_UpdateAbout in rpc: .UpdateAbout -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_UserOffline.UpdateUserName", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_UpdateUserName){
					RPC_UserOffline_Default_Handler.UpdateUserName((PB_UserOfflineResponse_UpdateUserName) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_UpdateUserName in rpc: .UpdateUserName -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_UserOffline.ChangePrivacy", (pb, handled)->{
				if(pb instanceof PB_UserResponseOffline_ChangePrivacy){
					RPC_UserOffline_Default_Handler.ChangePrivacy((PB_UserResponseOffline_ChangePrivacy) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponseOffline_ChangePrivacy in rpc: .ChangePrivacy -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_UserOffline.ChangeAvatar", (pb, handled)->{
				if(pb instanceof PB_UserOfflineResponse_ChangeAvatar){
					RPC_UserOffline_Default_Handler.ChangeAvatar((PB_UserOfflineResponse_ChangeAvatar) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserOfflineResponse_ChangeAvatar in rpc: .ChangeAvatar -- class: " + pb );//.getClass().getName());
				}
			});
	  
	  
			router.put("RPC_User.CheckUserName", (pb, handled)->{
				if(pb instanceof PB_UserResponse_CheckUserName){
					RPC_User_Default_Handler.CheckUserName((PB_UserResponse_CheckUserName) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_CheckUserName in rpc: .CheckUserName -- class: " + pb );//.getClass().getName());
				}
			});
	  
			router.put("RPC_User.GetBlockedList", (pb, handled)->{
				if(pb instanceof PB_UserResponse_BlockedList){
					RPC_User_Default_Handler.GetBlockedList((PB_UserResponse_BlockedList) pb, handled);
				}else{
					Log.d("RPC", " can not convert response object to PB_UserResponse_BlockedList in rpc: .GetBlockedList -- class: " + pb );//.getClass().getName());
				}
			});
	  
	}
	
}
/*

RPC_HANDLERS.RPC_Auth RPC_Auth_Default_Handler = new RPC_HANDLERS.RPC_Auth RPC_Auth_Empty();
RPC_HANDLERS.RPC_Chat RPC_Chat_Default_Handler = new RPC_HANDLERS.RPC_Chat RPC_Chat_Empty();
RPC_HANDLERS.RPC_Other RPC_Other_Default_Handler = new RPC_HANDLERS.RPC_Other RPC_Other_Empty();
RPC_HANDLERS.RPC_Sync RPC_Sync_Default_Handler = new RPC_HANDLERS.RPC_Sync RPC_Sync_Empty();
RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Default_Handler = new RPC_HANDLERS.RPC_UserOffline RPC_UserOffline_Empty();
RPC_HANDLERS.RPC_User RPC_User_Default_Handler = new RPC_HANDLERS.RPC_User RPC_User_Empty();
	
*/