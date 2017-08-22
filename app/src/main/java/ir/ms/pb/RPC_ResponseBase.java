package ir.ms.pb;

import android.util.Log;

public class RPC_ResponseBase {

  public static class RpcMsgs_Base implements RPC_INTERFACES.RpcMsgs {
    public void UploadNewMsg(PB_ResRpcAddMsg pbOut) {
      Log.d("RPC:Response", "RpcMsgs_Base.RpcMsgs");
    }
  }

  public static class RPC_MessageReq_Base implements RPC_INTERFACES.RPC_MessageReq {
    public void GetLastChnagesForRoom(PB_ResponseLastChangesForTheRoom pbOut) {
      Log.d("RPC:Response", "RPC_MessageReq_Base.RPC_MessageReq");
    }
  }

  public static class RPC_MessageReqOffline_Base implements RPC_INTERFACES.RPC_MessageReqOffline {
    public void SetLastSeen(PB_ResponseSetLastSeenMessages pbOut) {
      Log.d("RPC:Response", "RPC_MessageReqOffline_Base.RPC_MessageReqOffline");
    }
  }

  public static class RPC_Auth_Base implements RPC_INTERFACES.RPC_Auth {
    public void CheckPhone(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }

    public void SendCode(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }

    public void SendCodeToSms(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }

    public void SendCodeToTelgram(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }

    public void SingUp(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }

    public void SingIn(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }

    public void LogOut(PB_UserResponse_CheckUserName2 pbOut) {
      Log.d("RPC:Response", "RPC_Auth_Base.RPC_Auth");
    }
  }

  public static class RPC_Msg_Base implements RPC_INTERFACES.RPC_Msg {
    public void AddNewTextMessage(PB_MsgResponse_AddNewTextMessage pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void SetRoomActionDoing(PB_MsgResponse_SetRoomActionDoing pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void GetMessagesByIds(PB_MsgResponse_GetMessagesByIds pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void GetMessagesHistory(PB_MsgResponse_GetMessagesHistory pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void SetMessagesRangeAsSeen(PB_MsgResponse_SetChatMessagesRangeAsSeen pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void DeleteChatHistory(PB_MsgResponse_DeleteChatHistory pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void DeleteMessagesByIds(PB_MsgResponse_DeleteMessagesByIds pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void SetMessagesAsReceived(PB_MsgResponse_SetMessagesAsReceived pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void ForwardMessages(PB_MsgResponse_ForwardMessages pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void EditMessage(PB_MsgResponse_EditMessage pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void BroadcastNewMessage(PB_MsgResponse_BroadcastNewMessage pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }

    public void Echo(PB_MsgResponse_PB_MsgParam_Echo pbOut) {
      Log.d("RPC:Response", "RPC_Msg_Base.RPC_Msg");
    }
  }

  public static class RPC_UserOffline_Base implements RPC_INTERFACES.RPC_UserOffline {
    public void BlockUser(PB_UserOfflineResponse_BlockUser pbOut) {
      Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
    }

    public void UnBlockUser(PB_UserOfflineResponse_UnBlockUser pbOut) {
      Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
    }

    public void UpdateAbout(PB_UserOfflineResponse_UpdateAbout pbOut) {
      Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
    }

    public void UpdateUserName(PB_UserOfflineResponse_UpdateUserName pbOut) {
      Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
    }

    public void ChangePrivacy(PB_UserResponseOffline_ChangePrivacy pbOut) {
      Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
    }

    public void ChangeAvatar(PB_UserOfflineResponse_ChangeAvatar pbOut) {
      Log.d("RPC:Response", "RPC_UserOffline_Base.RPC_UserOffline");
    }
  }

  public static class RPC_User_Base implements RPC_INTERFACES.RPC_User {
    public void CheckUserName(PB_UserResponse_CheckUserName pbOut) {
      Log.d("RPC:Response", "RPC_User_Base.RPC_User");
    }

    public void GetBlockedList(PB_UserResponse_BlockedList pbOut) {
      Log.d("RPC:Response", "RPC_User_Base.RPC_User");
    }
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
