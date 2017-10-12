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

    // Service RPC_MessageReq

    mp.put(
        "RPC_MessageReq.GetLastChnagesForRoom",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ResponseLastChangesForTheRoom.parseFrom(byteString);
          }
        });

    // Service RPC_MessageReqOffline

    mp.put(
        "RPC_MessageReqOffline.SetLastSeen",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_ResponseSetLastSeenMessages.parseFrom(byteString);
          }
        });

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

    // Service RPC_Msg

    mp.put(
        "RPC_Msg.AddNewTextMessage",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_AddNewTextMessage.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.AddNewMessage",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_AddNewMessage.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.SetRoomActionDoing",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_SetRoomActionDoing.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.GetMessagesByIds",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_GetMessagesByIds.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.GetMessagesHistory",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_GetMessagesHistory.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.SetMessagesRangeAsSeen",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_SetChatMessagesRangeAsSeen.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.DeleteChatHistory",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_DeleteChatHistory.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.DeleteMessagesByIds",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_DeleteMessagesByIds.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.SetMessagesAsReceived",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_SetMessagesAsReceived.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.ForwardMessages",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_ForwardMessages.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.EditMessage",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_EditMessage.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.BroadcastNewMessage",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_BroadcastNewMessage.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.GetFreshChatList",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_GetFreshChatList.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.GetFreshRoomMessagesList",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_GetFreshRoomMessagesList.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.GetFreshAllDirectMessagesList",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_GetFreshAllDirectMessagesList.parseFrom(byteString);
          }
        });
    mp.put(
        "RPC_Msg.Echo",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_MsgResponse_PB_MsgParam_Echo.parseFrom(byteString);
          }
        });

    // Service RPC_Sync

    mp.put(
        "RPC_Sync.GetDirectUpdates",
        new RpcHelper2() {
          @Override
          public com.google.protobuf.GeneratedMessageLite parseData(ByteString byteString)
              throws com.google.protobuf.InvalidProtocolBufferException {
            return PB_SyncResponse_GetDirectUpdates.parseFrom(byteString);
          }
        });
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
