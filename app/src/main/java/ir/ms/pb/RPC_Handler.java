package ir.ms.pb;

import com.mardomsara.social.pipe.*;
import android.util.Log;

public class RPC_Handler {

public static class RpcMsgs {
	
        public static interface UploadNewMsg_ResultHandler{
    		void onResult(PB_ResRpcAddMsg res);
        }
    public static void UploadNewMsg( PB_Message param ,UploadNewMsg_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_ResRpcAddMsg d =PB_ResRpcAddMsg.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_ResRpcAddMsg");
					}
				}
			};
		}

		Pipe.send("RpcMsgs.UploadNewMsg", param, callback ,errorCallback);
    }}
public static class RPC_MessageReq {
	
        public static interface GetLastChnagesForRoom_ResultHandler{
    		void onResult(PB_ResponseLastChangesForTheRoom res);
        }
    public static void GetLastChnagesForRoom( PB_ReqLastChangesForTheRoom param ,GetLastChnagesForRoom_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_ResponseLastChangesForTheRoom d =PB_ResponseLastChangesForTheRoom.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_ResponseLastChangesForTheRoom");
					}
				}
			};
		}

		Pipe.send("RPC_MessageReq.GetLastChnagesForRoom", param, callback ,errorCallback);
    }}
public static class RPC_MessageReqOffline {
	
        public static interface SetLastSeen_ResultHandler{
    		void onResult(PB_ResponseSetLastSeenMessages res);
        }
    public static void SetLastSeen( PB_RequestSetLastSeenMessages param ,SetLastSeen_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_ResponseSetLastSeenMessages d =PB_ResponseSetLastSeenMessages.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_ResponseSetLastSeenMessages");
					}
				}
			};
		}

		Pipe.send("RPC_MessageReqOffline.SetLastSeen", param, callback ,errorCallback);
    }}
public static class RPC_Auth {
	
        public static interface CheckPhone_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
        public static interface SendCode_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
        public static interface SendCodeToSms_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
        public static interface SendCodeToTelgram_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
        public static interface SingUp_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
        public static interface SingIn_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
        public static interface LogOut_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName2 res);
        }
    public static void CheckPhone( PB_UserParam_CheckUserName2 param ,CheckPhone_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.CheckPhone", param, callback ,errorCallback);
    }
    public static void SendCode( PB_UserParam_CheckUserName2 param ,SendCode_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.SendCode", param, callback ,errorCallback);
    }
    public static void SendCodeToSms( PB_UserParam_CheckUserName2 param ,SendCodeToSms_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.SendCodeToSms", param, callback ,errorCallback);
    }
    public static void SendCodeToTelgram( PB_UserParam_CheckUserName2 param ,SendCodeToTelgram_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.SendCodeToTelgram", param, callback ,errorCallback);
    }
    public static void SingUp( PB_UserParam_CheckUserName2 param ,SingUp_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.SingUp", param, callback ,errorCallback);
    }
    public static void SingIn( PB_UserParam_CheckUserName2 param ,SingIn_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.SingIn", param, callback ,errorCallback);
    }
    public static void LogOut( PB_UserParam_CheckUserName2 param ,LogOut_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName2 d =PB_UserResponse_CheckUserName2.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName2");
					}
				}
			};
		}

		Pipe.send("RPC_Auth.LogOut", param, callback ,errorCallback);
    }}
public static class RPC_Msg {
	
        public static interface AddNewTextMessage_ResultHandler{
    		void onResult(PB_MsgResponse_AddNewTextMessage res);
        }
        public static interface SetRoomActionDoing_ResultHandler{
    		void onResult(PB_MsgResponse_SetRoomActionDoing res);
        }
        public static interface GetMessagesByIds_ResultHandler{
    		void onResult(PB_MsgResponse_GetMessagesByIds res);
        }
        public static interface GetMessagesHistory_ResultHandler{
    		void onResult(PB_MsgResponse_GetMessagesHistory res);
        }
        public static interface SetMessagesRangeAsSeen_ResultHandler{
    		void onResult(PB_MsgResponse_SetChatMessagesRangeAsSeen res);
        }
        public static interface DeleteChatHistory_ResultHandler{
    		void onResult(PB_MsgResponse_DeleteChatHistory res);
        }
        public static interface DeleteMessagesByIds_ResultHandler{
    		void onResult(PB_MsgResponse_DeleteMessagesByIds res);
        }
        public static interface SetMessagesAsReceived_ResultHandler{
    		void onResult(PB_MsgResponse_SetMessagesAsReceived res);
        }
        public static interface ForwardMessages_ResultHandler{
    		void onResult(PB_MsgResponse_ForwardMessages res);
        }
        public static interface EditMessage_ResultHandler{
    		void onResult(PB_MsgResponse_EditMessage res);
        }
        public static interface BroadcastNewMessage_ResultHandler{
    		void onResult(PB_MsgResponse_BroadcastNewMessage res);
        }
        public static interface Echo_ResultHandler{
    		void onResult(PB_MsgResponse_PB_MsgParam_Echo res);
        }
    public static void AddNewTextMessage( PB_MsgParam_AddNewTextMessage param ,AddNewTextMessage_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_AddNewTextMessage d =PB_MsgResponse_AddNewTextMessage.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_AddNewTextMessage");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.AddNewTextMessage", param, callback ,errorCallback);
    }
    public static void SetRoomActionDoing( PB_MsgParam_SetRoomActionDoing param ,SetRoomActionDoing_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_SetRoomActionDoing d =PB_MsgResponse_SetRoomActionDoing.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_SetRoomActionDoing");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.SetRoomActionDoing", param, callback ,errorCallback);
    }
    public static void GetMessagesByIds( PB_MsgParam_GetMessagesByIds param ,GetMessagesByIds_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_GetMessagesByIds d =PB_MsgResponse_GetMessagesByIds.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_GetMessagesByIds");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.GetMessagesByIds", param, callback ,errorCallback);
    }
    public static void GetMessagesHistory( PB_MsgParam_GetMessagesHistory param ,GetMessagesHistory_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_GetMessagesHistory d =PB_MsgResponse_GetMessagesHistory.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_GetMessagesHistory");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.GetMessagesHistory", param, callback ,errorCallback);
    }
    public static void SetMessagesRangeAsSeen( PB_MsgParam_SetChatMessagesRangeAsSeen param ,SetMessagesRangeAsSeen_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_SetChatMessagesRangeAsSeen d =PB_MsgResponse_SetChatMessagesRangeAsSeen.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_SetChatMessagesRangeAsSeen");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.SetMessagesRangeAsSeen", param, callback ,errorCallback);
    }
    public static void DeleteChatHistory( PB_MsgParam_DeleteChatHistory param ,DeleteChatHistory_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_DeleteChatHistory d =PB_MsgResponse_DeleteChatHistory.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_DeleteChatHistory");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.DeleteChatHistory", param, callback ,errorCallback);
    }
    public static void DeleteMessagesByIds( PB_MsgParam_DeleteMessagesByIds param ,DeleteMessagesByIds_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_DeleteMessagesByIds d =PB_MsgResponse_DeleteMessagesByIds.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_DeleteMessagesByIds");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.DeleteMessagesByIds", param, callback ,errorCallback);
    }
    public static void SetMessagesAsReceived( PB_MsgParam_SetMessagesAsReceived param ,SetMessagesAsReceived_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_SetMessagesAsReceived d =PB_MsgResponse_SetMessagesAsReceived.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_SetMessagesAsReceived");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.SetMessagesAsReceived", param, callback ,errorCallback);
    }
    public static void ForwardMessages( PB_MsgParam_ForwardMessages param ,ForwardMessages_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_ForwardMessages d =PB_MsgResponse_ForwardMessages.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_ForwardMessages");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.ForwardMessages", param, callback ,errorCallback);
    }
    public static void EditMessage( PB_MsgParam_EditMessage param ,EditMessage_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_EditMessage d =PB_MsgResponse_EditMessage.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_EditMessage");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.EditMessage", param, callback ,errorCallback);
    }
    public static void BroadcastNewMessage( PB_MsgParam_BroadcastNewMessage param ,BroadcastNewMessage_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_BroadcastNewMessage d =PB_MsgResponse_BroadcastNewMessage.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_BroadcastNewMessage");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.BroadcastNewMessage", param, callback ,errorCallback);
    }
    public static void Echo( PB_MsgParam_Echo param ,Echo_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_MsgResponse_PB_MsgParam_Echo d =PB_MsgResponse_PB_MsgParam_Echo.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_MsgResponse_PB_MsgParam_Echo");
					}
				}
			};
		}

		Pipe.send("RPC_Msg.Echo", param, callback ,errorCallback);
    }}
public static class RPC_UserOffline {
	
        public static interface BlockUser_ResultHandler{
    		void onResult(PB_UserOfflineResponse_BlockUser res);
        }
        public static interface UnBlockUser_ResultHandler{
    		void onResult(PB_UserOfflineResponse_UnBlockUser res);
        }
        public static interface UpdateAbout_ResultHandler{
    		void onResult(PB_UserOfflineResponse_UpdateAbout res);
        }
        public static interface UpdateUserName_ResultHandler{
    		void onResult(PB_UserOfflineResponse_UpdateUserName res);
        }
        public static interface ChangePrivacy_ResultHandler{
    		void onResult(PB_UserResponseOffline_ChangePrivacy res);
        }
        public static interface ChangeAvatar_ResultHandler{
    		void onResult(PB_UserOfflineResponse_ChangeAvatar res);
        }
    public static void BlockUser( PB_UserParam_BlockUser param ,BlockUser_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserOfflineResponse_BlockUser d =PB_UserOfflineResponse_BlockUser.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserOfflineResponse_BlockUser");
					}
				}
			};
		}

		Pipe.send("RPC_UserOffline.BlockUser", param, callback ,errorCallback);
    }
    public static void UnBlockUser( PB_UserParam_UnBlockUser param ,UnBlockUser_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserOfflineResponse_UnBlockUser d =PB_UserOfflineResponse_UnBlockUser.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserOfflineResponse_UnBlockUser");
					}
				}
			};
		}

		Pipe.send("RPC_UserOffline.UnBlockUser", param, callback ,errorCallback);
    }
    public static void UpdateAbout( PB_UserParam_UpdateAbout param ,UpdateAbout_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserOfflineResponse_UpdateAbout d =PB_UserOfflineResponse_UpdateAbout.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserOfflineResponse_UpdateAbout");
					}
				}
			};
		}

		Pipe.send("RPC_UserOffline.UpdateAbout", param, callback ,errorCallback);
    }
    public static void UpdateUserName( PB_UserParam_UpdateUserName param ,UpdateUserName_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserOfflineResponse_UpdateUserName d =PB_UserOfflineResponse_UpdateUserName.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserOfflineResponse_UpdateUserName");
					}
				}
			};
		}

		Pipe.send("RPC_UserOffline.UpdateUserName", param, callback ,errorCallback);
    }
    public static void ChangePrivacy( PB_UserParam_ChangePrivacy param ,ChangePrivacy_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponseOffline_ChangePrivacy d =PB_UserResponseOffline_ChangePrivacy.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponseOffline_ChangePrivacy");
					}
				}
			};
		}

		Pipe.send("RPC_UserOffline.ChangePrivacy", param, callback ,errorCallback);
    }
    public static void ChangeAvatar( PB_UserParam_ChangeAvatar param ,ChangeAvatar_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserOfflineResponse_ChangeAvatar d =PB_UserOfflineResponse_ChangeAvatar.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserOfflineResponse_ChangeAvatar");
					}
				}
			};
		}

		Pipe.send("RPC_UserOffline.ChangeAvatar", param, callback ,errorCallback);
    }}
public static class RPC_User {
	
        public static interface CheckUserName_ResultHandler{
    		void onResult(PB_UserResponse_CheckUserName res);
        }
        public static interface GetBlockedList_ResultHandler{
    		void onResult(PB_UserResponse_BlockedList res);
        }
    public static void CheckUserName( PB_UserParam_CheckUserName param ,CheckUserName_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_CheckUserName d =PB_UserResponse_CheckUserName.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_CheckUserName");
					}
				}
			};
		}

		Pipe.send("RPC_User.CheckUserName", param, callback ,errorCallback);
    }
    public static void GetBlockedList( PB_UserParam_BlockedList param ,GetBlockedList_ResultHandler resultHandler, ErrorCallback errorCallback){
		SuccessCallback callback = null;
		if(resultHandler != null){
			callback = new SuccessCallback() {
				@Override
				public void handle(byte[] data) {
					try {
						PB_UserResponse_BlockedList d =PB_UserResponse_BlockedList.parseFrom(data);
						resultHandler.onResult(d);
					}catch (com.google.protobuf.InvalidProtocolBufferException e){
						Log.d("RPC", "parsing protcol buffer is faild: PB_UserResponse_BlockedList");
					}
				}
			};
		}

		Pipe.send("RPC_User.GetBlockedList", param, callback ,errorCallback);
    }}
	
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