package ir.ms.pb;

import com.google.protobuf.ByteString;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/** Created by Hamid on 9/30/2017. */
public class RpcNameToResponseMapper {
  public abstract static class RpcHelper2 {
    public Class<? extends com.google.protobuf.GeneratedMessageLite> clazz;
    //public Parser parser;

    public abstract com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
        throws com.google.protobuf.InvalidProtocolBufferException;
  }

  private static Map<String, RpcHelper2> mp = new ConcurrentHashMap<>();

  public static Map<String, RpcHelper2> getMap() {
    if (mp.size() < 1) {
      fill();
    }
    return mp;
  }

  private static synchronized void fill() {

    // Service RPC_Auth

    mp.put(
        "RPC_Auth.CheckPhone",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Auth.SendCode",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Auth.SendCodeToSms",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Auth.SendCodeToTelgram",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Auth.SingUp",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Auth.SingIn",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Auth.LogOut",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName2.parseFrom(byteString);
          }
        });

    // Service RPC_Chat

    mp.put(
        "RPC_Chat.AddNewMessage",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_AddNewMessage.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.SetRoomActionDoing",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_SetRoomActionDoing.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.SetMessagesRangeAsSeen",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_SetChatMessagesRangeAsSeen.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.DeleteChatHistory",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_DeleteChatHistory.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.DeleteMessagesByIds",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_DeleteMessagesByIds.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.SetMessagesAsReceived",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_SetMessagesAsReceived.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.EditMessage",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_EditMessage.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.GetChatList",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_GetChatList.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.GetChatHistoryToOlder",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_GetChatHistoryToOlder.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Chat.GetFreshAllDirectMessagesList",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ChatResponse_GetFreshAllDirectMessagesList.parseFrom(byteString);
          }
        });

    // Service RPC_Other

    mp.put(
        "RPC_Other.Echo",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_OtherResponse_Echo.parseFrom(byteString);
          }
        });

    // Service RPC_Sync

    mp.put(
        "RPC_Sync.GetGeneralUpdates",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_SyncResponse_GetGeneralUpdates.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Sync.GetNotifyUpdates",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_SyncResponse_GetNotifyUpdates.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Sync.SetLastSyncDirectUpdateId",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_SyncResponse_SetLastSyncDirectUpdateId.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Sync.SetLastSyncGeneralUpdateId",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_SyncResponse_SetLastSyncGeneralUpdateId.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Sync.SetLastSyncNotifyUpdateId",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_SyncResponse_SetLastSyncNotifyUpdateId.parseFrom(byteString);
          }
        });

    // Service RPC_UserOffline

    mp.put(
        "RPC_UserOffline.BlockUser",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserOfflineResponse_BlockUser.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_UserOffline.UnBlockUser",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserOfflineResponse_UnBlockUser.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_UserOffline.UpdateAbout",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserOfflineResponse_UpdateAbout.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_UserOffline.UpdateUserName",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserOfflineResponse_UpdateUserName.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_UserOffline.ChangePrivacy",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponseOffline_ChangePrivacy.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_UserOffline.ChangeAvatar",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserOfflineResponse_ChangeAvatar.parseFrom(byteString);
          }
        });

    // Service RPC_User

    mp.put(
        "RPC_User.CheckUserName",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_CheckUserName.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_User.GetBlockedList",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_UserResponse_BlockedList.parseFrom(byteString);
          }
        });

    //mp.put("Rpc_Msg.GetFull", PB_SyncParam_GetGeneralUpdates.class.getName());
  }
}
