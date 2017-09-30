package ir.ms.pb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/** Created by Hamid on 9/30/2017. */
public class RpcNameToResponseMapper {
  private static Map<String, String> mp = new ConcurrentHashMap<>();

  public static Map<String, String> getMap() {
    if (mp.size() < 1) {
      fill();
    }
    return mp;
  }

  private static synchronized void fill() {

    // Service RPC_MessageReq

    mp.put(
        "RPC_MessageReq.GetLastChnagesForRoom", PB_ResponseLastChangesForTheRoom.class.getName());

    // Service RPC_MessageReqOffline

    mp.put("RPC_MessageReqOffline.SetLastSeen", PB_ResponseSetLastSeenMessages.class.getName());

    // Service RPC_Auth

    mp.put("RPC_Auth.CheckPhone", PB_UserResponse_CheckUserName2.class.getName());
    mp.put("RPC_Auth.SendCode", PB_UserResponse_CheckUserName2.class.getName());
    mp.put("RPC_Auth.SendCodeToSms", PB_UserResponse_CheckUserName2.class.getName());
    mp.put("RPC_Auth.SendCodeToTelgram", PB_UserResponse_CheckUserName2.class.getName());
    mp.put("RPC_Auth.SingUp", PB_UserResponse_CheckUserName2.class.getName());
    mp.put("RPC_Auth.SingIn", PB_UserResponse_CheckUserName2.class.getName());
    mp.put("RPC_Auth.LogOut", PB_UserResponse_CheckUserName2.class.getName());

    // Service RPC_Msg

    mp.put("RPC_Msg.AddNewTextMessage", PB_MsgResponse_AddNewTextMessage.class.getName());
    mp.put("RPC_Msg.AddNewMessage", PB_MsgResponse_AddNewMessage.class.getName());
    mp.put("RPC_Msg.SetRoomActionDoing", PB_MsgResponse_SetRoomActionDoing.class.getName());
    mp.put("RPC_Msg.GetMessagesByIds", PB_MsgResponse_GetMessagesByIds.class.getName());
    mp.put("RPC_Msg.GetMessagesHistory", PB_MsgResponse_GetMessagesHistory.class.getName());
    mp.put(
        "RPC_Msg.SetMessagesRangeAsSeen",
        PB_MsgResponse_SetChatMessagesRangeAsSeen.class.getName());
    mp.put("RPC_Msg.DeleteChatHistory", PB_MsgResponse_DeleteChatHistory.class.getName());
    mp.put("RPC_Msg.DeleteMessagesByIds", PB_MsgResponse_DeleteMessagesByIds.class.getName());
    mp.put("RPC_Msg.SetMessagesAsReceived", PB_MsgResponse_SetMessagesAsReceived.class.getName());
    mp.put("RPC_Msg.ForwardMessages", PB_MsgResponse_ForwardMessages.class.getName());
    mp.put("RPC_Msg.EditMessage", PB_MsgResponse_EditMessage.class.getName());
    mp.put("RPC_Msg.BroadcastNewMessage", PB_MsgResponse_BroadcastNewMessage.class.getName());
    mp.put("RPC_Msg.GetFreshChatList", PB_MsgResponse_GetFreshChatList.class.getName());
    mp.put(
        "RPC_Msg.GetFreshRoomMessagesList",
        PB_MsgResponse_GetFreshRoomMessagesList.class.getName());
    mp.put("RPC_Msg.Echo", PB_MsgResponse_PB_MsgParam_Echo.class.getName());

    // Service RPC_Sync

    mp.put("RPC_Sync.GetDirectUpdates", PB_SyncResponse_GetDirectUpdates.class.getName());
    mp.put("RPC_Sync.GetGeneralUpdates", PB_SyncResponse_GetGeneralUpdates.class.getName());
    mp.put("RPC_Sync.GetNotifyUpdates", PB_SyncResponse_GetNotifyUpdates.class.getName());
    mp.put(
        "RPC_Sync.SetLastSyncDirectUpdateId",
        PB_SyncResponse_SetLastSyncDirectUpdateId.class.getName());
    mp.put(
        "RPC_Sync.SetLastSyncGeneralUpdateId",
        PB_SyncResponse_SetLastSyncGeneralUpdateId.class.getName());
    mp.put(
        "RPC_Sync.SetLastSyncNotifyUpdateId",
        PB_SyncResponse_SetLastSyncNotifyUpdateId.class.getName());

    // Service RPC_UserOffline

    mp.put("RPC_UserOffline.BlockUser", PB_UserOfflineResponse_BlockUser.class.getName());
    mp.put("RPC_UserOffline.UnBlockUser", PB_UserOfflineResponse_UnBlockUser.class.getName());
    mp.put("RPC_UserOffline.UpdateAbout", PB_UserOfflineResponse_UpdateAbout.class.getName());
    mp.put("RPC_UserOffline.UpdateUserName", PB_UserOfflineResponse_UpdateUserName.class.getName());
    mp.put("RPC_UserOffline.ChangePrivacy", PB_UserResponseOffline_ChangePrivacy.class.getName());
    mp.put("RPC_UserOffline.ChangeAvatar", PB_UserOfflineResponse_ChangeAvatar.class.getName());

    // Service RPC_User

    mp.put("RPC_User.CheckUserName", PB_UserResponse_CheckUserName.class.getName());
    mp.put("RPC_User.GetBlockedList", PB_UserResponse_BlockedList.class.getName());

    //mp.put("Rpc_Msg.GetFull", PB_SyncParam_GetGeneralUpdates.class.getName());
  }
}
