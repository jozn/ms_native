package ir.ms.pb;

public class RPC_API {

  public static class RPC_Auth {

    public static final String CheckPhone = "RPC_Auth.CheckPhone";
    public static final String SendCode = "RPC_Auth.SendCode";
    public static final String SendCodeToSms = "RPC_Auth.SendCodeToSms";
    public static final String SendCodeToTelgram = "RPC_Auth.SendCodeToTelgram";
    public static final String SingUp = "RPC_Auth.SingUp";
    public static final String SingIn = "RPC_Auth.SingIn";
    public static final String LogOut = "RPC_Auth.LogOut";
  }

  public static class RPC_Chat {

    public static final String AddNewMessage = "RPC_Chat.AddNewMessage";
    public static final String SetRoomActionDoing = "RPC_Chat.SetRoomActionDoing";
    public static final String SetMessagesRangeAsSeen = "RPC_Chat.SetMessagesRangeAsSeen";
    public final static  String DeleteChatHistory = "RPC_Chat.DeleteChatHistory";
    public static final String DeleteMessagesByIds = "RPC_Chat.DeleteMessagesByIds";
    public static final String SetMessagesAsReceived = "RPC_Chat.SetMessagesAsReceived";
    public static final String EditMessage = "RPC_Chat.EditMessage";
    public static final String GetChatList = "RPC_Chat.GetChatList";
    public static final String GetChatHistoryToOlder = "RPC_Chat.GetChatHistoryToOlder";
    public static final String GetFreshAllDirectMessagesList =
        "RPC_Chat.GetFreshAllDirectMessagesList";
  }

  public static class RPC_Other {

    public static final String Echo = "RPC_Other.Echo";
  }

  public static class RPC_Sync {

    public static final String GetGeneralUpdates = "RPC_Sync.GetGeneralUpdates";
    public static final String GetNotifyUpdates = "RPC_Sync.GetNotifyUpdates";
    public static final String SetLastSyncDirectUpdateId = "RPC_Sync.SetLastSyncDirectUpdateId";
    public static final String SetLastSyncGeneralUpdateId = "RPC_Sync.SetLastSyncGeneralUpdateId";
    public static final String SetLastSyncNotifyUpdateId = "RPC_Sync.SetLastSyncNotifyUpdateId";
  }

  public static class RPC_UserOffline {

    public static final String BlockUser = "RPC_UserOffline.BlockUser";
    public static final String UnBlockUser = "RPC_UserOffline.UnBlockUser";
    public static final String UpdateAbout = "RPC_UserOffline.UpdateAbout";
    public static final String UpdateUserName = "RPC_UserOffline.UpdateUserName";
    public static final String ChangePrivacy = "RPC_UserOffline.ChangePrivacy";
    public static final String ChangeAvatar = "RPC_UserOffline.ChangeAvatar";
  }

  public static class RPC_User {

    public static final String CheckUserName = "RPC_User.CheckUserName";
    public static final String GetBlockedList = "RPC_User.GetBlockedList";
  }
}
