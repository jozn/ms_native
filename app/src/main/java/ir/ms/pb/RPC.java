package ir.ms.pb;

import android.util.Log;
import com.mardomsara.social.pipe.*;

public class RPC {

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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: CheckPhone with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SendCode with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SendCodeToSms with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SendCodeToTelgram with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SingUp with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SingIn with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: LogOut with respose class PB_UserResponse_CheckUserName2");
                PB_UserResponse_CheckUserName2 d = null;
                try {
                  d = PB_UserResponse_CheckUserName2.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName2");
                }
                return d;
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

    public static interface GetFreshChatList_ResultHandler {
      void onResult(PB_MsgResponse_GetFreshChatList res);
    }

    public static interface GetFreshRoomMessagesList_ResultHandler {
      void onResult(PB_MsgResponse_GetFreshRoomMessagesList res);
    }

    public static interface GetFreshAllDirectMessagesList_ResultHandler {
      void onResult(PB_MsgResponse_GetFreshAllDirectMessagesList res);
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: AddNewTextMessage with respose class PB_MsgResponse_AddNewTextMessage");
                PB_MsgResponse_AddNewTextMessage d = null;
                try {
                  d = PB_MsgResponse_AddNewTextMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_AddNewTextMessage");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: AddNewMessage with respose class PB_MsgResponse_AddNewMessage");
                PB_MsgResponse_AddNewMessage d = null;
                try {
                  d = PB_MsgResponse_AddNewMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_MsgResponse_AddNewMessage");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetRoomActionDoing with respose class PB_MsgResponse_SetRoomActionDoing");
                PB_MsgResponse_SetRoomActionDoing d = null;
                try {
                  d = PB_MsgResponse_SetRoomActionDoing.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_SetRoomActionDoing");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetMessagesByIds with respose class PB_MsgResponse_GetMessagesByIds");
                PB_MsgResponse_GetMessagesByIds d = null;
                try {
                  d = PB_MsgResponse_GetMessagesByIds.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetMessagesByIds");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetMessagesHistory with respose class PB_MsgResponse_GetMessagesHistory");
                PB_MsgResponse_GetMessagesHistory d = null;
                try {
                  d = PB_MsgResponse_GetMessagesHistory.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetMessagesHistory");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetMessagesRangeAsSeen with respose class PB_MsgResponse_SetChatMessagesRangeAsSeen");
                PB_MsgResponse_SetChatMessagesRangeAsSeen d = null;
                try {
                  d = PB_MsgResponse_SetChatMessagesRangeAsSeen.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_SetChatMessagesRangeAsSeen");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: DeleteChatHistory with respose class PB_MsgResponse_DeleteChatHistory");
                PB_MsgResponse_DeleteChatHistory d = null;
                try {
                  d = PB_MsgResponse_DeleteChatHistory.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_DeleteChatHistory");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: DeleteMessagesByIds with respose class PB_MsgResponse_DeleteMessagesByIds");
                PB_MsgResponse_DeleteMessagesByIds d = null;
                try {
                  d = PB_MsgResponse_DeleteMessagesByIds.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_DeleteMessagesByIds");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetMessagesAsReceived with respose class PB_MsgResponse_SetMessagesAsReceived");
                PB_MsgResponse_SetMessagesAsReceived d = null;
                try {
                  d = PB_MsgResponse_SetMessagesAsReceived.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_SetMessagesAsReceived");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: ForwardMessages with respose class PB_MsgResponse_ForwardMessages");
                PB_MsgResponse_ForwardMessages d = null;
                try {
                  d = PB_MsgResponse_ForwardMessages.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_MsgResponse_ForwardMessages");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: EditMessage with respose class PB_MsgResponse_EditMessage");
                PB_MsgResponse_EditMessage d = null;
                try {
                  d = PB_MsgResponse_EditMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_MsgResponse_EditMessage");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: BroadcastNewMessage with respose class PB_MsgResponse_BroadcastNewMessage");
                PB_MsgResponse_BroadcastNewMessage d = null;
                try {
                  d = PB_MsgResponse_BroadcastNewMessage.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_BroadcastNewMessage");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.BroadcastNewMessage", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.BroadcastNewMessage", param, callback, errorCallback);
      }
    }

    public static void GetFreshChatList(
        PB_MsgParam_GetFreshChatList param,
        GetFreshChatList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetFreshChatListImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetFreshChatList_Offline(
        String offlineKey,
        PB_MsgParam_GetFreshChatList param,
        GetFreshChatList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetFreshChatListImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetFreshChatListImpl(
        PB_MsgParam_GetFreshChatList param,
        GetFreshChatList_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetFreshChatList with respose class PB_MsgResponse_GetFreshChatList");
                PB_MsgResponse_GetFreshChatList d = null;
                try {
                  d = PB_MsgResponse_GetFreshChatList.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetFreshChatList");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Msg.GetFreshChatList", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.GetFreshChatList", param, callback, errorCallback);
      }
    }

    public static void GetFreshRoomMessagesList(
        PB_MsgParam_GetFreshRoomMessagesList param,
        GetFreshRoomMessagesList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetFreshRoomMessagesListImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetFreshRoomMessagesList_Offline(
        String offlineKey,
        PB_MsgParam_GetFreshRoomMessagesList param,
        GetFreshRoomMessagesList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetFreshRoomMessagesListImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetFreshRoomMessagesListImpl(
        PB_MsgParam_GetFreshRoomMessagesList param,
        GetFreshRoomMessagesList_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetFreshRoomMessagesList with respose class PB_MsgResponse_GetFreshRoomMessagesList");
                PB_MsgResponse_GetFreshRoomMessagesList d = null;
                try {
                  d = PB_MsgResponse_GetFreshRoomMessagesList.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetFreshRoomMessagesList");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Msg.GetFreshRoomMessagesList", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.GetFreshRoomMessagesList", param, callback, errorCallback);
      }
    }

    public static void GetFreshAllDirectMessagesList(
        PB_MsgParam_GetFreshAllDirectMessagesList param,
        GetFreshAllDirectMessagesList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetFreshAllDirectMessagesListImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetFreshAllDirectMessagesList_Offline(
        String offlineKey,
        PB_MsgParam_GetFreshAllDirectMessagesList param,
        GetFreshAllDirectMessagesList_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetFreshAllDirectMessagesListImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetFreshAllDirectMessagesListImpl(
        PB_MsgParam_GetFreshAllDirectMessagesList param,
        GetFreshAllDirectMessagesList_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetFreshAllDirectMessagesList with respose class PB_MsgResponse_GetFreshAllDirectMessagesList");
                PB_MsgResponse_GetFreshAllDirectMessagesList d = null;
                try {
                  d = PB_MsgResponse_GetFreshAllDirectMessagesList.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_GetFreshAllDirectMessagesList");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Msg.GetFreshAllDirectMessagesList", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Msg.GetFreshAllDirectMessagesList", param, callback, errorCallback);
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: Echo with respose class PB_MsgResponse_PB_MsgParam_Echo");
                PB_MsgResponse_PB_MsgParam_Echo d = null;
                try {
                  d = PB_MsgResponse_PB_MsgParam_Echo.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_MsgResponse_PB_MsgParam_Echo");
                }
                return d;
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

  public static class RPC_Sync {

    public static interface GetDirectUpdates_ResultHandler {
      void onResult(PB_SyncResponse_GetDirectUpdates res);
    }

    public static interface GetGeneralUpdates_ResultHandler {
      void onResult(PB_SyncResponse_GetGeneralUpdates res);
    }

    public static interface GetNotifyUpdates_ResultHandler {
      void onResult(PB_SyncResponse_GetNotifyUpdates res);
    }

    public static interface SetLastSyncDirectUpdateId_ResultHandler {
      void onResult(PB_SyncResponse_SetLastSyncDirectUpdateId res);
    }

    public static interface SetLastSyncGeneralUpdateId_ResultHandler {
      void onResult(PB_SyncResponse_SetLastSyncGeneralUpdateId res);
    }

    public static interface SetLastSyncNotifyUpdateId_ResultHandler {
      void onResult(PB_SyncResponse_SetLastSyncNotifyUpdateId res);
    }

    public static void GetDirectUpdates(
        PB_SyncParam_GetDirectUpdates param,
        GetDirectUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetDirectUpdatesImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetDirectUpdates_Offline(
        String offlineKey,
        PB_SyncParam_GetDirectUpdates param,
        GetDirectUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetDirectUpdatesImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetDirectUpdatesImpl(
        PB_SyncParam_GetDirectUpdates param,
        GetDirectUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetDirectUpdates with respose class PB_SyncResponse_GetDirectUpdates");
                PB_SyncResponse_GetDirectUpdates d = null;
                try {
                  d = PB_SyncResponse_GetDirectUpdates.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_SyncResponse_GetDirectUpdates");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Sync.GetDirectUpdates", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Sync.GetDirectUpdates", param, callback, errorCallback);
      }
    }

    public static void GetGeneralUpdates(
        PB_SyncParam_GetGeneralUpdates param,
        GetGeneralUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetGeneralUpdatesImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetGeneralUpdates_Offline(
        String offlineKey,
        PB_SyncParam_GetGeneralUpdates param,
        GetGeneralUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetGeneralUpdatesImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetGeneralUpdatesImpl(
        PB_SyncParam_GetGeneralUpdates param,
        GetGeneralUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetGeneralUpdates with respose class PB_SyncResponse_GetGeneralUpdates");
                PB_SyncResponse_GetGeneralUpdates d = null;
                try {
                  d = PB_SyncResponse_GetGeneralUpdates.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_SyncResponse_GetGeneralUpdates");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Sync.GetGeneralUpdates", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Sync.GetGeneralUpdates", param, callback, errorCallback);
      }
    }

    public static void GetNotifyUpdates(
        PB_SyncParam_GetNotifyUpdates param,
        GetNotifyUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetNotifyUpdatesImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void GetNotifyUpdates_Offline(
        String offlineKey,
        PB_SyncParam_GetNotifyUpdates param,
        GetNotifyUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      GetNotifyUpdatesImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void GetNotifyUpdatesImpl(
        PB_SyncParam_GetNotifyUpdates param,
        GetNotifyUpdates_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetNotifyUpdates with respose class PB_SyncResponse_GetNotifyUpdates");
                PB_SyncResponse_GetNotifyUpdates d = null;
                try {
                  d = PB_SyncResponse_GetNotifyUpdates.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_SyncResponse_GetNotifyUpdates");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(offlineKey, "RPC_Sync.GetNotifyUpdates", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Sync.GetNotifyUpdates", param, callback, errorCallback);
      }
    }

    public static void SetLastSyncDirectUpdateId(
        PB_SyncParam_SetLastSyncDirectUpdateId param,
        SetLastSyncDirectUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSyncDirectUpdateIdImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetLastSyncDirectUpdateId_Offline(
        String offlineKey,
        PB_SyncParam_SetLastSyncDirectUpdateId param,
        SetLastSyncDirectUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSyncDirectUpdateIdImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetLastSyncDirectUpdateIdImpl(
        PB_SyncParam_SetLastSyncDirectUpdateId param,
        SetLastSyncDirectUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetLastSyncDirectUpdateId with respose class PB_SyncResponse_SetLastSyncDirectUpdateId");
                PB_SyncResponse_SetLastSyncDirectUpdateId d = null;
                try {
                  d = PB_SyncResponse_SetLastSyncDirectUpdateId.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_SyncResponse_SetLastSyncDirectUpdateId");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Sync.SetLastSyncDirectUpdateId", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Sync.SetLastSyncDirectUpdateId", param, callback, errorCallback);
      }
    }

    public static void SetLastSyncGeneralUpdateId(
        PB_SyncParam_SetLastSyncGeneralUpdateId param,
        SetLastSyncGeneralUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSyncGeneralUpdateIdImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetLastSyncGeneralUpdateId_Offline(
        String offlineKey,
        PB_SyncParam_SetLastSyncGeneralUpdateId param,
        SetLastSyncGeneralUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSyncGeneralUpdateIdImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetLastSyncGeneralUpdateIdImpl(
        PB_SyncParam_SetLastSyncGeneralUpdateId param,
        SetLastSyncGeneralUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetLastSyncGeneralUpdateId with respose class PB_SyncResponse_SetLastSyncGeneralUpdateId");
                PB_SyncResponse_SetLastSyncGeneralUpdateId d = null;
                try {
                  d = PB_SyncResponse_SetLastSyncGeneralUpdateId.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_SyncResponse_SetLastSyncGeneralUpdateId");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Sync.SetLastSyncGeneralUpdateId", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Sync.SetLastSyncGeneralUpdateId", param, callback, errorCallback);
      }
    }

    public static void SetLastSyncNotifyUpdateId(
        PB_SyncParam_SetLastSyncNotifyUpdateId param,
        SetLastSyncNotifyUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSyncNotifyUpdateIdImpl(param, resultHandler, errorCallback, false, "");
    }

    public static void SetLastSyncNotifyUpdateId_Offline(
        String offlineKey,
        PB_SyncParam_SetLastSyncNotifyUpdateId param,
        SetLastSyncNotifyUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback) {
      SetLastSyncNotifyUpdateIdImpl(param, resultHandler, errorCallback, true, offlineKey);
    }

    private static void SetLastSyncNotifyUpdateIdImpl(
        PB_SyncParam_SetLastSyncNotifyUpdateId param,
        SetLastSyncNotifyUpdateId_ResultHandler resultHandler,
        ErrorCallback errorCallback,
        Boolean offline,
        String offlineKey) {
      SuccessCallback callback = null;
      if (resultHandler != null) {
        callback =
            new SuccessCallback() {
              @Override
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: SetLastSyncNotifyUpdateId with respose class PB_SyncResponse_SetLastSyncNotifyUpdateId");
                PB_SyncResponse_SetLastSyncNotifyUpdateId d = null;
                try {
                  d = PB_SyncResponse_SetLastSyncNotifyUpdateId.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_SyncResponse_SetLastSyncNotifyUpdateId");
                }
                return d;
              }
            };
      }

      if (offline) {
        Pipe.sendOffline(
            offlineKey, "RPC_Sync.SetLastSyncNotifyUpdateId", param, callback, errorCallback);
      } else {
        Pipe.send("RPC_Sync.SetLastSyncNotifyUpdateId", param, callback, errorCallback);
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: BlockUser with respose class PB_UserOfflineResponse_BlockUser");
                PB_UserOfflineResponse_BlockUser d = null;
                try {
                  d = PB_UserOfflineResponse_BlockUser.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_BlockUser");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UnBlockUser with respose class PB_UserOfflineResponse_UnBlockUser");
                PB_UserOfflineResponse_UnBlockUser d = null;
                try {
                  d = PB_UserOfflineResponse_UnBlockUser.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_UnBlockUser");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UpdateAbout with respose class PB_UserOfflineResponse_UpdateAbout");
                PB_UserOfflineResponse_UpdateAbout d = null;
                try {
                  d = PB_UserOfflineResponse_UpdateAbout.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_UpdateAbout");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: UpdateUserName with respose class PB_UserOfflineResponse_UpdateUserName");
                PB_UserOfflineResponse_UpdateUserName d = null;
                try {
                  d = PB_UserOfflineResponse_UpdateUserName.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_UpdateUserName");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: ChangePrivacy with respose class PB_UserResponseOffline_ChangePrivacy");
                PB_UserResponseOffline_ChangePrivacy d = null;
                try {
                  d = PB_UserResponseOffline_ChangePrivacy.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserResponseOffline_ChangePrivacy");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: ChangeAvatar with respose class PB_UserOfflineResponse_ChangeAvatar");
                PB_UserOfflineResponse_ChangeAvatar d = null;
                try {
                  d = PB_UserOfflineResponse_ChangeAvatar.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws",
                      "parsing protocol buffer is faild: PB_UserOfflineResponse_ChangeAvatar");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: CheckUserName with respose class PB_UserResponse_CheckUserName");
                PB_UserResponse_CheckUserName d = null;
                try {
                  d = PB_UserResponse_CheckUserName.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d(
                      "RPC ws", "parsing protocol buffer is faild: PB_UserResponse_CheckUserName");
                }
                return d;
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
              public Object handle(byte[] data) {
                Log.i(
                    "RPC ws",
                    "handling rpc respnse for: GetBlockedList with respose class PB_UserResponse_BlockedList");
                PB_UserResponse_BlockedList d = null;
                try {
                  d = PB_UserResponse_BlockedList.parseFrom(data);
                  resultHandler.onResult(d);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                  Log.d("RPC ws", "parsing protocol buffer is faild: PB_UserResponse_BlockedList");
                }
                return d;
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

RPC_INTERFACES.RPC_Auth RPC_Auth_Handeler = null;
RPC_INTERFACES.RPC_Msg RPC_Msg_Handeler = null;
RPC_INTERFACES.RPC_Sync RPC_Sync_Handeler = null;
RPC_INTERFACES.RPC_UserOffline RPC_UserOffline_Handeler = null;
RPC_INTERFACES.RPC_User RPC_User_Handeler = null;

*/
