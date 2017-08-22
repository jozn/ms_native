package ir.ms.pb;

public class RPC_INTERFACES {

  public interface RpcMsgs {
    void UploadNewMsg(PB_ResRpcAddMsg pbOut);
  }

  public interface RPC_MessageReq {
    void GetLastChnagesForRoom(PB_ResponseLastChangesForTheRoom pbOut);
  }

  public interface RPC_MessageReqOffline {
    void SetLastSeen(PB_ResponseSetLastSeenMessages pbOut);
  }

  public interface RPC_Auth {
    void CheckPhone(PB_UserResponse_CheckUserName2 pbOut);

    void SendCode(PB_UserResponse_CheckUserName2 pbOut);

    void SendCodeToSms(PB_UserResponse_CheckUserName2 pbOut);

    void SendCodeToTelgram(PB_UserResponse_CheckUserName2 pbOut);

    void SingUp(PB_UserResponse_CheckUserName2 pbOut);

    void SingIn(PB_UserResponse_CheckUserName2 pbOut);

    void LogOut(PB_UserResponse_CheckUserName2 pbOut);
  }

  public interface RPC_Msg {
    void AddNewTextMessage(PB_MsgResponse_AddNewTextMessage pbOut);

    void SetRoomActionDoing(PB_MsgResponse_SetRoomActionDoing pbOut);

    void GetMessagesByIds(PB_MsgResponse_GetMessagesByIds pbOut);

    void GetMessagesHistory(PB_MsgResponse_GetMessagesHistory pbOut);

    void SetMessagesRangeAsSeen(PB_MsgResponse_SetChatMessagesRangeAsSeen pbOut);

    void DeleteChatHistory(PB_MsgResponse_DeleteChatHistory pbOut);

    void DeleteMessagesByIds(PB_MsgResponse_DeleteMessagesByIds pbOut);

    void SetMessagesAsReceived(PB_MsgResponse_SetMessagesAsReceived pbOut);

    void ForwardMessages(PB_MsgResponse_ForwardMessages pbOut);

    void EditMessage(PB_MsgResponse_EditMessage pbOut);

    void BroadcastNewMessage(PB_MsgResponse_BroadcastNewMessage pbOut);

    void Echo(PB_MsgResponse_PB_MsgParam_Echo pbOut);
  }

  public interface RPC_UserOffline {
    void BlockUser(PB_UserOfflineResponse_BlockUser pbOut);

    void UnBlockUser(PB_UserOfflineResponse_UnBlockUser pbOut);

    void UpdateAbout(PB_UserOfflineResponse_UpdateAbout pbOut);

    void UpdateUserName(PB_UserOfflineResponse_UpdateUserName pbOut);

    void ChangePrivacy(PB_UserResponseOffline_ChangePrivacy pbOut);

    void ChangeAvatar(PB_UserOfflineResponse_ChangeAvatar pbOut);
  }

  public interface RPC_User {
    void CheckUserName(PB_UserResponse_CheckUserName pbOut);

    void GetBlockedList(PB_UserResponse_BlockedList pbOut);
  }
}
/*

RPC_INTERFACES.RpcMsgs RpcMsgs_Handeler = null;
RPC_INTERFACES.RPC_MessageReq RPC_MessageReq_Handeler = null;
RPC_INTERFACES.RPC_MessageReqOffline RPC_MessageReqOffline_Handeler = null;
RPC_INTERFACES.RPC_Auth RPC_Auth_Handeler = null;
RPC_INTERFACES.RPC_Msg RPC_Msg_Handeler = null;
RPC_INTERFACES.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_INTERFACES.RPC_User RPC_User_Handeler = null;

*/
