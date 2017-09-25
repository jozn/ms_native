package ir.ms.pb;

import android.util.Log;
import com.mardomsara.social.pipe.*;

public class RPC {

  public static class RPC_MessageReq {

    public static interface GetLastChnagesForRoom_ResultHandler {
      void onResult(PB_ResponseLastChangesForTheRoom res);
    }

    public static void GetLastChnagesForRoom(
        PB_ReqLastChangesForTheRoom param,
        GetLastChnagesForRoom_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetLastChnagesForRoomImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetLastChnagesForRoom_Offline(
        String offlineKey,
        PB_ReqLastChangesForTheRoom param,
        GetLastChnagesForRoom_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetLastChnagesForRoomImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetLastChnagesForRoomImpl(
        PB_ReqLastChangesForTheRoom param,
        GetLastChnagesForRoom_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetLastChnagesForRoom with respose class PB_ResponseLastChangesForTheRoom");
                try {
                  PB_ResponseLastChangesForTheRoom d =
                      PB_ResponseLastChangesForTheRoom.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_ResponseLastChangesForTheRoom");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_MessageReq.GetLastChnagesForRoom", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_MessageReq.GetLastChnagesForRoom", param, callback, errorCallback);
      }
    }
  }

  public static class RPC_MessageReqOffline {

    public static interface SetLastSeen_ResultHandler {
      void onResult(PB_ResponseSetLastSeenMessages res);
    }

    public static void SetLastSeen(
        PB_RequestSetLastSeenMessages param,
        SetLastSeen_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSeenImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetLastSeen_Offline(
        String offlineKey,
        PB_RequestSetLastSeenMessages param,
        SetLastSeen_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSeenImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetLastSeenImpl(
        PB_RequestSetLastSeenMessages param,
        SetLastSeen_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetLastSeen with respose class PB_ResponseSetLastSeenMessages");
                try {
                  PB_ResponseSetLastSeenMessages d = PB_ResponseSetLastSeenMessages.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_ResponseSetLastSeenMessages");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_MessageReqOffline.SetLastSeen", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_MessageReqOffline.SetLastSeen", param, callback, errorCallback);
      }
    }
  }

  public static class RpcMsgs {

    public static interface UploadNewMsg_ResultHandler {
      void onResult(PB_ResRpcAddMsg res);
    }

    public static void UploadNewMsg(
        PB_Message param, UploadNewMsg_ResultHandler resultHandler, ErrorCallback errorCallback) {
      UploadNewMsgImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void UploadNewMsg_Offline(
        String offlineKey,
        PB_Message param,
        UploadNewMsg_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UploadNewMsgImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void UploadNewMsgImpl(
        PB_Message param,
        UploadNewMsg_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UploadNewMsg with respose class PB_ResRpcAddMsg");
                try {
                  PB_ResRpcAddMsg d = PB_ResRpcAddMsg.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_ResRpcAddMsg");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RpcMsgs.UploadNewMsg", param, callback, errorCallback);
      } else {
        Pipe.send("RpcMsgs.UploadNewMsg", param, callback, errorCallback);
      }
    }
  }

  public static class RPC_Auth {

    public static interface CheckPhone_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static interface SendCode_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static interface SendCodeToSms_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static interface SendCodeToTelgram_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static interface SingUp_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static interface SingIn_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static interface LogOut_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName2 res);
    }

    public static void CheckPhone(
        PB_UserParam_CheckUserName2 param,
        CheckPhone_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      CheckPhoneImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void CheckPhone_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        CheckPhone_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      CheckPhoneImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void CheckPhoneImpl(
        PB_UserParam_CheckUserName2 param,
        CheckPhone_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: CheckPhone with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.CheckPhone", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.CheckPhone", param, callback, errorCallback);
      }
    }

    public static void SendCode(
        PB_UserParam_CheckUserName2 param,
        SendCode_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SendCodeImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SendCode_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        SendCode_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SendCodeImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SendCodeImpl(
        PB_UserParam_CheckUserName2 param,
        SendCode_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SendCode with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.SendCode", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.SendCode", param, callback, errorCallback);
      }
    }

    public static void SendCodeToSms(
        PB_UserParam_CheckUserName2 param,
        SendCodeToSms_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SendCodeToSmsImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SendCodeToSms_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        SendCodeToSms_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SendCodeToSmsImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SendCodeToSmsImpl(
        PB_UserParam_CheckUserName2 param,
        SendCodeToSms_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SendCodeToSms with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.SendCodeToSms", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.SendCodeToSms", param, callback, errorCallback);
      }
    }

    public static void SendCodeToTelgram(
        PB_UserParam_CheckUserName2 param,
        SendCodeToTelgram_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SendCodeToTelgramImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SendCodeToTelgram_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        SendCodeToTelgram_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SendCodeToTelgramImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SendCodeToTelgramImpl(
        PB_UserParam_CheckUserName2 param,
        SendCodeToTelgram_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SendCodeToTelgram with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.SendCodeToTelgram", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.SendCodeToTelgram", param, callback, errorCallback);
      }
    }

    public static void SingUp(
        PB_UserParam_CheckUserName2 param,
        SingUp_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SingUpImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SingUp_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        SingUp_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SingUpImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SingUpImpl(
        PB_UserParam_CheckUserName2 param,
        SingUp_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SingUp with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.SingUp", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.SingUp", param, callback, errorCallback);
      }
    }

    public static void SingIn(
        PB_UserParam_CheckUserName2 param,
        SingIn_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SingInImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SingIn_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        SingIn_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SingInImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SingInImpl(
        PB_UserParam_CheckUserName2 param,
        SingIn_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SingIn with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.SingIn", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.SingIn", param, callback, errorCallback);
      }
    }

    public static void LogOut(
        PB_UserParam_CheckUserName2 param,
        LogOut_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      LogOutImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void LogOut_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName2 param,
        LogOut_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      LogOutImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void LogOutImpl(
        PB_UserParam_CheckUserName2 param,
        LogOut_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: LogOut with respose class PB_UserResponse_CheckUserName2");
                try {
                  PB_UserResponse_CheckUserName2 d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Auth.LogOut", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Auth.LogOut", param, callback, errorCallback);
      }
    }
  }

  public static class RPC_Msg {

    public static interface AddNewTextMessage_ResultHandler {
      void onResult(PB_MsgResponse_AddNewTextMessage res);
    }

    public static interface AddNewMessage_ResultHandler {
      void onResult(PB_MsgResponse_AddNewMessage res);
    }

    public static interface SetRoomActionDoing_ResultHandler {
      void onResult(PB_MsgResponse_SetRoomActionDoing res);
    }

    public static interface GetMessagesByIds_ResultHandler {
      void onResult(PB_MsgResponse_GetMessagesByIds res);
    }

    public static interface GetMessagesHistory_ResultHandler {
      void onResult(PB_MsgResponse_GetMessagesHistory res);
    }

    public static interface SetMessagesRangeAsSeen_ResultHandler {
      void onResult(PB_MsgResponse_SetChatMessagesRangeAsSeen res);
    }

    public static interface DeleteChatHistory_ResultHandler {
      void onResult(PB_MsgResponse_DeleteChatHistory res);
    }

    public static interface DeleteMessagesByIds_ResultHandler {
      void onResult(PB_MsgResponse_DeleteMessagesByIds res);
    }

    public static interface SetMessagesAsReceived_ResultHandler {
      void onResult(PB_MsgResponse_SetMessagesAsReceived res);
    }

    public static interface ForwardMessages_ResultHandler {
      void onResult(PB_MsgResponse_ForwardMessages res);
    }

    public static interface EditMessage_ResultHandler {
      void onResult(PB_MsgResponse_EditMessage res);
    }

    public static interface BroadcastNewMessage_ResultHandler {
      void onResult(PB_MsgResponse_BroadcastNewMessage res);
    }

    public static interface Echo_ResultHandler {
      void onResult(PB_MsgResponse_PB_MsgParam_Echo res);
    }

    public static void AddNewTextMessage(
        PB_MsgParam_AddNewTextMessage param,
        AddNewTextMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      AddNewTextMessageImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void AddNewTextMessage_Offline(
        String offlineKey,
        PB_MsgParam_AddNewTextMessage param,
        AddNewTextMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      AddNewTextMessageImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void AddNewTextMessageImpl(
        PB_MsgParam_AddNewTextMessage param,
        AddNewTextMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: AddNewTextMessage with respose class PB_MsgResponse_AddNewTextMessage");
                try {
                  PB_MsgResponse_AddNewTextMessage d =
                      PB_MsgResponse_AddNewTextMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_AddNewTextMessage");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.AddNewTextMessage", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.AddNewTextMessage", param, callback, errorCallback);
      }
    }

    public static void AddNewMessage(
        PB_MsgParam_AddNewMessage param,
        AddNewMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      AddNewMessageImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void AddNewMessage_Offline(
        String offlineKey,
        PB_MsgParam_AddNewMessage param,
        AddNewMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      AddNewMessageImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void AddNewMessageImpl(
        PB_MsgParam_AddNewMessage param,
        AddNewMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: AddNewMessage with respose class PB_MsgResponse_AddNewMessage");
                try {
                  PB_MsgResponse_AddNewMessage d = PB_MsgResponse_AddNewMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_MsgResponse_AddNewMessage");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.AddNewMessage", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.AddNewMessage", param, callback, errorCallback);
      }
    }

    public static void SetRoomActionDoing(
        PB_MsgParam_SetRoomActionDoing param,
        SetRoomActionDoing_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetRoomActionDoingImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetRoomActionDoing_Offline(
        String offlineKey,
        PB_MsgParam_SetRoomActionDoing param,
        SetRoomActionDoing_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetRoomActionDoingImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetRoomActionDoingImpl(
        PB_MsgParam_SetRoomActionDoing param,
        SetRoomActionDoing_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetRoomActionDoing with respose class PB_MsgResponse_SetRoomActionDoing");
                try {
                  PB_MsgResponse_SetRoomActionDoing d =
                      PB_MsgResponse_SetRoomActionDoing.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_SetRoomActionDoing");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.SetRoomActionDoing", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.SetRoomActionDoing", param, callback, errorCallback);
      }
    }

    public static void GetMessagesByIds(
        PB_MsgParam_GetMessagesByIds param,
        GetMessagesByIds_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetMessagesByIdsImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetMessagesByIds_Offline(
        String offlineKey,
        PB_MsgParam_GetMessagesByIds param,
        GetMessagesByIds_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetMessagesByIdsImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetMessagesByIdsImpl(
        PB_MsgParam_GetMessagesByIds param,
        GetMessagesByIds_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetMessagesByIds with respose class PB_MsgResponse_GetMessagesByIds");
                try {
                  PB_MsgResponse_GetMessagesByIds d =
                      PB_MsgResponse_GetMessagesByIds.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetMessagesByIds");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.GetMessagesByIds", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.GetMessagesByIds", param, callback, errorCallback);
      }
    }

    public static void GetMessagesHistory(
        PB_MsgParam_GetMessagesHistory param,
        GetMessagesHistory_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetMessagesHistoryImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetMessagesHistory_Offline(
        String offlineKey,
        PB_MsgParam_GetMessagesHistory param,
        GetMessagesHistory_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetMessagesHistoryImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetMessagesHistoryImpl(
        PB_MsgParam_GetMessagesHistory param,
        GetMessagesHistory_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetMessagesHistory with respose class PB_MsgResponse_GetMessagesHistory");
                try {
                  PB_MsgResponse_GetMessagesHistory d =
                      PB_MsgResponse_GetMessagesHistory.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetMessagesHistory");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.GetMessagesHistory", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.GetMessagesHistory", param, callback, errorCallback);
      }
    }

    public static void SetMessagesRangeAsSeen(
        PB_MsgParam_SetChatMessagesRangeAsSeen param,
        SetMessagesRangeAsSeen_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetMessagesRangeAsSeenImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetMessagesRangeAsSeen_Offline(
        String offlineKey,
        PB_MsgParam_SetChatMessagesRangeAsSeen param,
        SetMessagesRangeAsSeen_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetMessagesRangeAsSeenImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetMessagesRangeAsSeenImpl(
        PB_MsgParam_SetChatMessagesRangeAsSeen param,
        SetMessagesRangeAsSeen_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetMessagesRangeAsSeen with respose class PB_MsgResponse_SetChatMessagesRangeAsSeen");
                try {
                  PB_MsgResponse_SetChatMessagesRangeAsSeen d =
                      PB_MsgResponse_SetChatMessagesRangeAsSeen.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_SetChatMessagesRangeAsSeen");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Msg.SetMessagesRangeAsSeen", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.SetMessagesRangeAsSeen", param, callback, errorCallback);
      }
    }

    public static void DeleteChatHistory(
        PB_MsgParam_DeleteChatHistory param,
        DeleteChatHistory_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      DeleteChatHistoryImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void DeleteChatHistory_Offline(
        String offlineKey,
        PB_MsgParam_DeleteChatHistory param,
        DeleteChatHistory_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      DeleteChatHistoryImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void DeleteChatHistoryImpl(
        PB_MsgParam_DeleteChatHistory param,
        DeleteChatHistory_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: DeleteChatHistory with respose class PB_MsgResponse_DeleteChatHistory");
                try {
                  PB_MsgResponse_DeleteChatHistory d =
                      PB_MsgResponse_DeleteChatHistory.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_DeleteChatHistory");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.DeleteChatHistory", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.DeleteChatHistory", param, callback, errorCallback);
      }
    }

    public static void DeleteMessagesByIds(
        PB_MsgParam_DeleteMessagesByIds param,
        DeleteMessagesByIds_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      DeleteMessagesByIdsImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void DeleteMessagesByIds_Offline(
        String offlineKey,
        PB_MsgParam_DeleteMessagesByIds param,
        DeleteMessagesByIds_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      DeleteMessagesByIdsImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void DeleteMessagesByIdsImpl(
        PB_MsgParam_DeleteMessagesByIds param,
        DeleteMessagesByIds_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: DeleteMessagesByIds with respose class PB_MsgResponse_DeleteMessagesByIds");
                try {
                  PB_MsgResponse_DeleteMessagesByIds d =
                      PB_MsgResponse_DeleteMessagesByIds.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_DeleteMessagesByIds");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.DeleteMessagesByIds", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.DeleteMessagesByIds", param, callback, errorCallback);
      }
    }

    public static void SetMessagesAsReceived(
        PB_MsgParam_SetMessagesAsReceived param,
        SetMessagesAsReceived_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetMessagesAsReceivedImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetMessagesAsReceived_Offline(
        String offlineKey,
        PB_MsgParam_SetMessagesAsReceived param,
        SetMessagesAsReceived_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetMessagesAsReceivedImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetMessagesAsReceivedImpl(
        PB_MsgParam_SetMessagesAsReceived param,
        SetMessagesAsReceived_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetMessagesAsReceived with respose class PB_MsgResponse_SetMessagesAsReceived");
                try {
                  PB_MsgResponse_SetMessagesAsReceived d =
                      PB_MsgResponse_SetMessagesAsReceived.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_SetMessagesAsReceived");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Msg.SetMessagesAsReceived", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.SetMessagesAsReceived", param, callback, errorCallback);
      }
    }

    public static void ForwardMessages(
        PB_MsgParam_ForwardMessages param,
        ForwardMessages_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      ForwardMessagesImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void ForwardMessages_Offline(
        String offlineKey,
        PB_MsgParam_ForwardMessages param,
        ForwardMessages_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      ForwardMessagesImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void ForwardMessagesImpl(
        PB_MsgParam_ForwardMessages param,
        ForwardMessages_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: ForwardMessages with respose class PB_MsgResponse_ForwardMessages");
                try {
                  PB_MsgResponse_ForwardMessages d = PB_MsgResponse_ForwardMessages.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_MsgResponse_ForwardMessages");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.ForwardMessages", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.ForwardMessages", param, callback, errorCallback);
      }
    }

    public static void EditMessage(
        PB_MsgParam_EditMessage param,
        EditMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      EditMessageImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void EditMessage_Offline(
        String offlineKey,
        PB_MsgParam_EditMessage param,
        EditMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      EditMessageImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void EditMessageImpl(
        PB_MsgParam_EditMessage param,
        EditMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: EditMessage with respose class PB_MsgResponse_EditMessage");
                try {
                  PB_MsgResponse_EditMessage d = PB_MsgResponse_EditMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_MsgResponse_EditMessage");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.EditMessage", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.EditMessage", param, callback, errorCallback);
      }
    }

    public static void BroadcastNewMessage(
        PB_MsgParam_BroadcastNewMessage param,
        BroadcastNewMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      BroadcastNewMessageImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void BroadcastNewMessage_Offline(
        String offlineKey,
        PB_MsgParam_BroadcastNewMessage param,
        BroadcastNewMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      BroadcastNewMessageImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void BroadcastNewMessageImpl(
        PB_MsgParam_BroadcastNewMessage param,
        BroadcastNewMessage_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: BroadcastNewMessage with respose class PB_MsgResponse_BroadcastNewMessage");
                try {
                  PB_MsgResponse_BroadcastNewMessage d =
                      PB_MsgResponse_BroadcastNewMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_BroadcastNewMessage");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.BroadcastNewMessage", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.BroadcastNewMessage", param, callback, errorCallback);
      }
    }

    public static void Echo(
        PB_MsgParam_Echo param, Echo_ResultHandler resultHandler, ErrorCallback errorCallback) {
      EchoImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void Echo_Offline(
        String offlineKey,
        PB_MsgParam_Echo param,
        Echo_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      EchoImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void EchoImpl(
        PB_MsgParam_Echo param,
        Echo_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: Echo with respose class PB_MsgResponse_PB_MsgParam_Echo");
                try {
                  PB_MsgResponse_PB_MsgParam_Echo d =
                      PB_MsgResponse_PB_MsgParam_Echo.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_PB_MsgParam_Echo");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.Echo", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.Echo", param, callback, errorCallback);
      }
    }
  }

  public static class RPC_UserOffline {

    public static interface BlockUser_ResultHandler {
      void onResult(PB_UserOfflineResponse_BlockUser res);
    }

    public static interface UnBlockUser_ResultHandler {
      void onResult(PB_UserOfflineResponse_UnBlockUser res);
    }

    public static interface UpdateAbout_ResultHandler {
      void onResult(PB_UserOfflineResponse_UpdateAbout res);
    }

    public static interface UpdateUserName_ResultHandler {
      void onResult(PB_UserOfflineResponse_UpdateUserName res);
    }

    public static interface ChangePrivacy_ResultHandler {
      void onResult(PB_UserResponseOffline_ChangePrivacy res);
    }

    public static interface ChangeAvatar_ResultHandler {
      void onResult(PB_UserOfflineResponse_ChangeAvatar res);
    }

    public static void BlockUser(
        PB_UserParam_BlockUser param,
        BlockUser_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      BlockUserImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void BlockUser_Offline(
        String offlineKey,
        PB_UserParam_BlockUser param,
        BlockUser_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      BlockUserImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void BlockUserImpl(
        PB_UserParam_BlockUser param,
        BlockUser_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: BlockUser with respose class PB_UserOfflineResponse_BlockUser");
                try {
                  PB_UserOfflineResponse_BlockUser d =
                      PB_UserOfflineResponse_BlockUser.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_BlockUser");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_UserOffline.BlockUser", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_UserOffline.BlockUser", param, callback, errorCallback);
      }
    }

    public static void UnBlockUser(
        PB_UserParam_UnBlockUser param,
        UnBlockUser_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UnBlockUserImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void UnBlockUser_Offline(
        String offlineKey,
        PB_UserParam_UnBlockUser param,
        UnBlockUser_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UnBlockUserImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void UnBlockUserImpl(
        PB_UserParam_UnBlockUser param,
        UnBlockUser_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UnBlockUser with respose class PB_UserOfflineResponse_UnBlockUser");
                try {
                  PB_UserOfflineResponse_UnBlockUser d =
                      PB_UserOfflineResponse_UnBlockUser.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_UnBlockUser");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_UserOffline.UnBlockUser", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_UserOffline.UnBlockUser", param, callback, errorCallback);
      }
    }

    public static void UpdateAbout(
        PB_UserParam_UpdateAbout param,
        UpdateAbout_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UpdateAboutImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void UpdateAbout_Offline(
        String offlineKey,
        PB_UserParam_UpdateAbout param,
        UpdateAbout_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UpdateAboutImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void UpdateAboutImpl(
        PB_UserParam_UpdateAbout param,
        UpdateAbout_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UpdateAbout with respose class PB_UserOfflineResponse_UpdateAbout");
                try {
                  PB_UserOfflineResponse_UpdateAbout d =
                      PB_UserOfflineResponse_UpdateAbout.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_UpdateAbout");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_UserOffline.UpdateAbout", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_UserOffline.UpdateAbout", param, callback, errorCallback);
      }
    }

    public static void UpdateUserName(
        PB_UserParam_UpdateUserName param,
        UpdateUserName_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UpdateUserNameImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void UpdateUserName_Offline(
        String offlineKey,
        PB_UserParam_UpdateUserName param,
        UpdateUserName_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      UpdateUserNameImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void UpdateUserNameImpl(
        PB_UserParam_UpdateUserName param,
        UpdateUserName_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UpdateUserName with respose class PB_UserOfflineResponse_UpdateUserName");
                try {
                  PB_UserOfflineResponse_UpdateUserName d =
                      PB_UserOfflineResponse_UpdateUserName.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_UpdateUserName");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_UserOffline.UpdateUserName", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_UserOffline.UpdateUserName", param, callback, errorCallback);
      }
    }

    public static void ChangePrivacy(
        PB_UserParam_ChangePrivacy param,
        ChangePrivacy_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      ChangePrivacyImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void ChangePrivacy_Offline(
        String offlineKey,
        PB_UserParam_ChangePrivacy param,
        ChangePrivacy_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      ChangePrivacyImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void ChangePrivacyImpl(
        PB_UserParam_ChangePrivacy param,
        ChangePrivacy_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: ChangePrivacy with respose class PB_UserResponseOffline_ChangePrivacy");
                try {
                  PB_UserResponseOffline_ChangePrivacy d =
                      PB_UserResponseOffline_ChangePrivacy.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserResponseOffline_ChangePrivacy");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_UserOffline.ChangePrivacy", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_UserOffline.ChangePrivacy", param, callback, errorCallback);
      }
    }

    public static void ChangeAvatar(
        PB_UserParam_ChangeAvatar param,
        ChangeAvatar_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      ChangeAvatarImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void ChangeAvatar_Offline(
        String offlineKey,
        PB_UserParam_ChangeAvatar param,
        ChangeAvatar_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      ChangeAvatarImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void ChangeAvatarImpl(
        PB_UserParam_ChangeAvatar param,
        ChangeAvatar_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: ChangeAvatar with respose class PB_UserOfflineResponse_ChangeAvatar");
                try {
                  PB_UserOfflineResponse_ChangeAvatar d =
                      PB_UserOfflineResponse_ChangeAvatar.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_ChangeAvatar");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_UserOffline.ChangeAvatar", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_UserOffline.ChangeAvatar", param, callback, errorCallback);
      }
    }
  }

  public static class RPC_User {

    public static interface CheckUserName_ResultHandler {
      void onResult(PB_UserResponse_CheckUserName res);
    }

    public static interface GetBlockedList_ResultHandler {
      void onResult(PB_UserResponse_BlockedList res);
    }

    public static void CheckUserName(
        PB_UserParam_CheckUserName param,
        CheckUserName_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      CheckUserNameImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void CheckUserName_Offline(
        String offlineKey,
        PB_UserParam_CheckUserName param,
        CheckUserName_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      CheckUserNameImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void CheckUserNameImpl(
        PB_UserParam_CheckUserName param,
        CheckUserName_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: CheckUserName with respose class PB_UserResponse_CheckUserName");
                try {
                  PB_UserResponse_CheckUserName d = PB_UserResponse_CheckUserName.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_User.CheckUserName", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_User.CheckUserName", param, callback, errorCallback);
      }
    }

    public static void GetBlockedList(
        PB_UserParam_BlockedList param,
        GetBlockedList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetBlockedListImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetBlockedList_Offline(
        String offlineKey,
        PB_UserParam_BlockedList param,
        GetBlockedList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetBlockedListImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetBlockedListImpl(
        PB_UserParam_BlockedList param,
        GetBlockedList_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public void handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetBlockedList with respose class PB_UserResponse_BlockedList");
                try {
                  PB_UserResponse_BlockedList d = PB_UserResponse_BlockedList.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_UserResponse_BlockedList");
                }
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_User.GetBlockedList", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_User.GetBlockedList", param, callback, errorCallback);
      }
    }
  }
}
/*

RPC_INTERFACES.RPC_MessageReq RPC_MessageReq_Handeler = null;
RPC_INTERFACES.RPC_MessageReqOffline RPC_MessageReqOffline_Handeler = null;
RPC_INTERFACES.RpcMsgs RpcMsgs_Handeler = null;
RPC_INTERFACES.RPC_Auth RPC_Auth_Handeler = null;
RPC_INTERFACES.RPC_Msg RPC_Msg_Handeler = null;
RPC_INTERFACES.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_INTERFACES.RPC_User RPC_User_Handeler = null;

*/
