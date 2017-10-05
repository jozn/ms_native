package ir.ms.pb;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: pb_rpc_msg.proto")
public final class RPC_MsgGrpc {

  private RPC_MsgGrpc() {}

  public static final String SERVICE_NAME = "RPC_Msg";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_AddNewTextMessage,
      ir.ms.pb.PB_MsgResponse_AddNewTextMessage> METHOD_ADD_NEW_TEXT_MESSAGE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_AddNewTextMessage, ir.ms.pb.PB_MsgResponse_AddNewTextMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "AddNewTextMessage"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_AddNewTextMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_AddNewTextMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_AddNewMessage,
      ir.ms.pb.PB_MsgResponse_AddNewMessage> METHOD_ADD_NEW_MESSAGE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_AddNewMessage, ir.ms.pb.PB_MsgResponse_AddNewMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "AddNewMessage"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_AddNewMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_AddNewMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_SetRoomActionDoing,
      ir.ms.pb.PB_MsgResponse_SetRoomActionDoing> METHOD_SET_ROOM_ACTION_DOING =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_SetRoomActionDoing, ir.ms.pb.PB_MsgResponse_SetRoomActionDoing>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "SetRoomActionDoing"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_SetRoomActionDoing.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_SetRoomActionDoing.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_GetMessagesByIds,
      ir.ms.pb.PB_MsgResponse_GetMessagesByIds> METHOD_GET_MESSAGES_BY_IDS =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_GetMessagesByIds, ir.ms.pb.PB_MsgResponse_GetMessagesByIds>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "GetMessagesByIds"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_GetMessagesByIds.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_GetMessagesByIds.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_GetMessagesHistory,
      ir.ms.pb.PB_MsgResponse_GetMessagesHistory> METHOD_GET_MESSAGES_HISTORY =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_GetMessagesHistory, ir.ms.pb.PB_MsgResponse_GetMessagesHistory>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "GetMessagesHistory"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_GetMessagesHistory.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_GetMessagesHistory.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen,
      ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen> METHOD_SET_MESSAGES_RANGE_AS_SEEN =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen, ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "SetMessagesRangeAsSeen"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_DeleteChatHistory,
      ir.ms.pb.PB_MsgResponse_DeleteChatHistory> METHOD_DELETE_CHAT_HISTORY =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_DeleteChatHistory, ir.ms.pb.PB_MsgResponse_DeleteChatHistory>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "DeleteChatHistory"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_DeleteChatHistory.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_DeleteChatHistory.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_DeleteMessagesByIds,
      ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds> METHOD_DELETE_MESSAGES_BY_IDS =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_DeleteMessagesByIds, ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "DeleteMessagesByIds"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_DeleteMessagesByIds.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_SetMessagesAsReceived,
      ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived> METHOD_SET_MESSAGES_AS_RECEIVED =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_SetMessagesAsReceived, ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "SetMessagesAsReceived"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_SetMessagesAsReceived.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_ForwardMessages,
      ir.ms.pb.PB_MsgResponse_ForwardMessages> METHOD_FORWARD_MESSAGES =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_ForwardMessages, ir.ms.pb.PB_MsgResponse_ForwardMessages>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "ForwardMessages"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_ForwardMessages.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_ForwardMessages.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_EditMessage,
      ir.ms.pb.PB_MsgResponse_EditMessage> METHOD_EDIT_MESSAGE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_EditMessage, ir.ms.pb.PB_MsgResponse_EditMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "EditMessage"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_EditMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_EditMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_BroadcastNewMessage,
      ir.ms.pb.PB_MsgResponse_BroadcastNewMessage> METHOD_BROADCAST_NEW_MESSAGE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_BroadcastNewMessage, ir.ms.pb.PB_MsgResponse_BroadcastNewMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "BroadcastNewMessage"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_BroadcastNewMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_BroadcastNewMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_GetFreshChatList,
      ir.ms.pb.PB_MsgResponse_GetFreshChatList> METHOD_GET_FRESH_CHAT_LIST =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_GetFreshChatList, ir.ms.pb.PB_MsgResponse_GetFreshChatList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "GetFreshChatList"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_GetFreshChatList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_GetFreshChatList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList,
      ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList> METHOD_GET_FRESH_ROOM_MESSAGES_LIST =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList, ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "GetFreshRoomMessagesList"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList,
      ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList> METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList, ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "GetFreshAllDirectMessagesList"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_MsgParam_Echo,
      ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo> METHOD_ECHO =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_MsgParam_Echo, ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Msg", "Echo"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgParam_Echo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_MsgStub newStub(io.grpc.Channel channel) {
    return new RPC_MsgStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_MsgBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_MsgBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_MsgFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_MsgFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_MsgImplBase implements io.grpc.BindableService {

    /**
     */
    public void addNewTextMessage(ir.ms.pb.PB_MsgParam_AddNewTextMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_AddNewTextMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_NEW_TEXT_MESSAGE, responseObserver);
    }

    /**
     */
    public void addNewMessage(ir.ms.pb.PB_MsgParam_AddNewMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_AddNewMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_NEW_MESSAGE, responseObserver);
    }

    /**
     */
    public void setRoomActionDoing(ir.ms.pb.PB_MsgParam_SetRoomActionDoing request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetRoomActionDoing> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_ROOM_ACTION_DOING, responseObserver);
    }

    /**
     */
    public void getMessagesByIds(ir.ms.pb.PB_MsgParam_GetMessagesByIds request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetMessagesByIds> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_MESSAGES_BY_IDS, responseObserver);
    }

    /**
     */
    public void getMessagesHistory(ir.ms.pb.PB_MsgParam_GetMessagesHistory request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetMessagesHistory> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_MESSAGES_HISTORY, responseObserver);
    }

    /**
     */
    public void setMessagesRangeAsSeen(ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_MESSAGES_RANGE_AS_SEEN, responseObserver);
    }

    /**
     */
    public void deleteChatHistory(ir.ms.pb.PB_MsgParam_DeleteChatHistory request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_DeleteChatHistory> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CHAT_HISTORY, responseObserver);
    }

    /**
     */
    public void deleteMessagesByIds(ir.ms.pb.PB_MsgParam_DeleteMessagesByIds request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_MESSAGES_BY_IDS, responseObserver);
    }

    /**
     */
    public void setMessagesAsReceived(ir.ms.pb.PB_MsgParam_SetMessagesAsReceived request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_MESSAGES_AS_RECEIVED, responseObserver);
    }

    /**
     */
    public void forwardMessages(ir.ms.pb.PB_MsgParam_ForwardMessages request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_ForwardMessages> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FORWARD_MESSAGES, responseObserver);
    }

    /**
     */
    public void editMessage(ir.ms.pb.PB_MsgParam_EditMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_EditMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_MESSAGE, responseObserver);
    }

    /**
     */
    public void broadcastNewMessage(ir.ms.pb.PB_MsgParam_BroadcastNewMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_BroadcastNewMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_BROADCAST_NEW_MESSAGE, responseObserver);
    }

    /**
     */
    public void getFreshChatList(ir.ms.pb.PB_MsgParam_GetFreshChatList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshChatList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FRESH_CHAT_LIST, responseObserver);
    }

    /**
     */
    public void getFreshRoomMessagesList(ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FRESH_ROOM_MESSAGES_LIST, responseObserver);
    }

    /**
     */
    public void getFreshAllDirectMessagesList(ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, responseObserver);
    }

    /**
     */
    public void echo(ir.ms.pb.PB_MsgParam_Echo request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ECHO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_NEW_TEXT_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_AddNewTextMessage,
                ir.ms.pb.PB_MsgResponse_AddNewTextMessage>(
                  this, METHODID_ADD_NEW_TEXT_MESSAGE)))
          .addMethod(
            METHOD_ADD_NEW_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_AddNewMessage,
                ir.ms.pb.PB_MsgResponse_AddNewMessage>(
                  this, METHODID_ADD_NEW_MESSAGE)))
          .addMethod(
            METHOD_SET_ROOM_ACTION_DOING,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_SetRoomActionDoing,
                ir.ms.pb.PB_MsgResponse_SetRoomActionDoing>(
                  this, METHODID_SET_ROOM_ACTION_DOING)))
          .addMethod(
            METHOD_GET_MESSAGES_BY_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_GetMessagesByIds,
                ir.ms.pb.PB_MsgResponse_GetMessagesByIds>(
                  this, METHODID_GET_MESSAGES_BY_IDS)))
          .addMethod(
            METHOD_GET_MESSAGES_HISTORY,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_GetMessagesHistory,
                ir.ms.pb.PB_MsgResponse_GetMessagesHistory>(
                  this, METHODID_GET_MESSAGES_HISTORY)))
          .addMethod(
            METHOD_SET_MESSAGES_RANGE_AS_SEEN,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen,
                ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen>(
                  this, METHODID_SET_MESSAGES_RANGE_AS_SEEN)))
          .addMethod(
            METHOD_DELETE_CHAT_HISTORY,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_DeleteChatHistory,
                ir.ms.pb.PB_MsgResponse_DeleteChatHistory>(
                  this, METHODID_DELETE_CHAT_HISTORY)))
          .addMethod(
            METHOD_DELETE_MESSAGES_BY_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_DeleteMessagesByIds,
                ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds>(
                  this, METHODID_DELETE_MESSAGES_BY_IDS)))
          .addMethod(
            METHOD_SET_MESSAGES_AS_RECEIVED,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_SetMessagesAsReceived,
                ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived>(
                  this, METHODID_SET_MESSAGES_AS_RECEIVED)))
          .addMethod(
            METHOD_FORWARD_MESSAGES,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_ForwardMessages,
                ir.ms.pb.PB_MsgResponse_ForwardMessages>(
                  this, METHODID_FORWARD_MESSAGES)))
          .addMethod(
            METHOD_EDIT_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_EditMessage,
                ir.ms.pb.PB_MsgResponse_EditMessage>(
                  this, METHODID_EDIT_MESSAGE)))
          .addMethod(
            METHOD_BROADCAST_NEW_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_BroadcastNewMessage,
                ir.ms.pb.PB_MsgResponse_BroadcastNewMessage>(
                  this, METHODID_BROADCAST_NEW_MESSAGE)))
          .addMethod(
            METHOD_GET_FRESH_CHAT_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_GetFreshChatList,
                ir.ms.pb.PB_MsgResponse_GetFreshChatList>(
                  this, METHODID_GET_FRESH_CHAT_LIST)))
          .addMethod(
            METHOD_GET_FRESH_ROOM_MESSAGES_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList,
                ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList>(
                  this, METHODID_GET_FRESH_ROOM_MESSAGES_LIST)))
          .addMethod(
            METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList,
                ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList>(
                  this, METHODID_GET_FRESH_ALL_DIRECT_MESSAGES_LIST)))
          .addMethod(
            METHOD_ECHO,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_MsgParam_Echo,
                ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo>(
                  this, METHODID_ECHO)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_MsgStub extends io.grpc.stub.AbstractStub<RPC_MsgStub> {
    private RPC_MsgStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MsgStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MsgStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MsgStub(channel, callOptions);
    }

    /**
     */
    public void addNewTextMessage(ir.ms.pb.PB_MsgParam_AddNewTextMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_AddNewTextMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_TEXT_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addNewMessage(ir.ms.pb.PB_MsgParam_AddNewMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_AddNewMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setRoomActionDoing(ir.ms.pb.PB_MsgParam_SetRoomActionDoing request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetRoomActionDoing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_ROOM_ACTION_DOING, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMessagesByIds(ir.ms.pb.PB_MsgParam_GetMessagesByIds request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetMessagesByIds> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES_BY_IDS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMessagesHistory(ir.ms.pb.PB_MsgParam_GetMessagesHistory request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetMessagesHistory> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES_HISTORY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMessagesRangeAsSeen(ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_RANGE_AS_SEEN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteChatHistory(ir.ms.pb.PB_MsgParam_DeleteChatHistory request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_DeleteChatHistory> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CHAT_HISTORY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMessagesByIds(ir.ms.pb.PB_MsgParam_DeleteMessagesByIds request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_MESSAGES_BY_IDS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMessagesAsReceived(ir.ms.pb.PB_MsgParam_SetMessagesAsReceived request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_AS_RECEIVED, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void forwardMessages(ir.ms.pb.PB_MsgParam_ForwardMessages request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_ForwardMessages> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FORWARD_MESSAGES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editMessage(ir.ms.pb.PB_MsgParam_EditMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_EditMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void broadcastNewMessage(ir.ms.pb.PB_MsgParam_BroadcastNewMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_BroadcastNewMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_BROADCAST_NEW_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFreshChatList(ir.ms.pb.PB_MsgParam_GetFreshChatList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshChatList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_CHAT_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFreshRoomMessagesList(ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_ROOM_MESSAGES_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFreshAllDirectMessagesList(ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echo(ir.ms.pb.PB_MsgParam_Echo request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_MsgBlockingStub extends io.grpc.stub.AbstractStub<RPC_MsgBlockingStub> {
    private RPC_MsgBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MsgBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MsgBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MsgBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_AddNewTextMessage addNewTextMessage(ir.ms.pb.PB_MsgParam_AddNewTextMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_NEW_TEXT_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_AddNewMessage addNewMessage(ir.ms.pb.PB_MsgParam_AddNewMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_NEW_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_SetRoomActionDoing setRoomActionDoing(ir.ms.pb.PB_MsgParam_SetRoomActionDoing request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_ROOM_ACTION_DOING, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_GetMessagesByIds getMessagesByIds(ir.ms.pb.PB_MsgParam_GetMessagesByIds request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_MESSAGES_BY_IDS, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_GetMessagesHistory getMessagesHistory(ir.ms.pb.PB_MsgParam_GetMessagesHistory request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_MESSAGES_HISTORY, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen setMessagesRangeAsSeen(ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_MESSAGES_RANGE_AS_SEEN, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_DeleteChatHistory deleteChatHistory(ir.ms.pb.PB_MsgParam_DeleteChatHistory request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CHAT_HISTORY, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds deleteMessagesByIds(ir.ms.pb.PB_MsgParam_DeleteMessagesByIds request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_MESSAGES_BY_IDS, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived setMessagesAsReceived(ir.ms.pb.PB_MsgParam_SetMessagesAsReceived request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_MESSAGES_AS_RECEIVED, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_ForwardMessages forwardMessages(ir.ms.pb.PB_MsgParam_ForwardMessages request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FORWARD_MESSAGES, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_EditMessage editMessage(ir.ms.pb.PB_MsgParam_EditMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_BroadcastNewMessage broadcastNewMessage(ir.ms.pb.PB_MsgParam_BroadcastNewMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_BROADCAST_NEW_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_GetFreshChatList getFreshChatList(ir.ms.pb.PB_MsgParam_GetFreshChatList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FRESH_CHAT_LIST, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList getFreshRoomMessagesList(ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FRESH_ROOM_MESSAGES_LIST, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList getFreshAllDirectMessagesList(ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo echo(ir.ms.pb.PB_MsgParam_Echo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ECHO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_MsgFutureStub extends io.grpc.stub.AbstractStub<RPC_MsgFutureStub> {
    private RPC_MsgFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MsgFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MsgFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MsgFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_AddNewTextMessage> addNewTextMessage(
        ir.ms.pb.PB_MsgParam_AddNewTextMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_TEXT_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_AddNewMessage> addNewMessage(
        ir.ms.pb.PB_MsgParam_AddNewMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_SetRoomActionDoing> setRoomActionDoing(
        ir.ms.pb.PB_MsgParam_SetRoomActionDoing request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_ROOM_ACTION_DOING, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_GetMessagesByIds> getMessagesByIds(
        ir.ms.pb.PB_MsgParam_GetMessagesByIds request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES_BY_IDS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_GetMessagesHistory> getMessagesHistory(
        ir.ms.pb.PB_MsgParam_GetMessagesHistory request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_MESSAGES_HISTORY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen> setMessagesRangeAsSeen(
        ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_RANGE_AS_SEEN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_DeleteChatHistory> deleteChatHistory(
        ir.ms.pb.PB_MsgParam_DeleteChatHistory request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CHAT_HISTORY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds> deleteMessagesByIds(
        ir.ms.pb.PB_MsgParam_DeleteMessagesByIds request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_MESSAGES_BY_IDS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived> setMessagesAsReceived(
        ir.ms.pb.PB_MsgParam_SetMessagesAsReceived request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_AS_RECEIVED, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_ForwardMessages> forwardMessages(
        ir.ms.pb.PB_MsgParam_ForwardMessages request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FORWARD_MESSAGES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_EditMessage> editMessage(
        ir.ms.pb.PB_MsgParam_EditMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_BroadcastNewMessage> broadcastNewMessage(
        ir.ms.pb.PB_MsgParam_BroadcastNewMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_BROADCAST_NEW_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_GetFreshChatList> getFreshChatList(
        ir.ms.pb.PB_MsgParam_GetFreshChatList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_CHAT_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList> getFreshRoomMessagesList(
        ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_ROOM_MESSAGES_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList> getFreshAllDirectMessagesList(
        ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo> echo(
        ir.ms.pb.PB_MsgParam_Echo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_NEW_TEXT_MESSAGE = 0;
  private static final int METHODID_ADD_NEW_MESSAGE = 1;
  private static final int METHODID_SET_ROOM_ACTION_DOING = 2;
  private static final int METHODID_GET_MESSAGES_BY_IDS = 3;
  private static final int METHODID_GET_MESSAGES_HISTORY = 4;
  private static final int METHODID_SET_MESSAGES_RANGE_AS_SEEN = 5;
  private static final int METHODID_DELETE_CHAT_HISTORY = 6;
  private static final int METHODID_DELETE_MESSAGES_BY_IDS = 7;
  private static final int METHODID_SET_MESSAGES_AS_RECEIVED = 8;
  private static final int METHODID_FORWARD_MESSAGES = 9;
  private static final int METHODID_EDIT_MESSAGE = 10;
  private static final int METHODID_BROADCAST_NEW_MESSAGE = 11;
  private static final int METHODID_GET_FRESH_CHAT_LIST = 12;
  private static final int METHODID_GET_FRESH_ROOM_MESSAGES_LIST = 13;
  private static final int METHODID_GET_FRESH_ALL_DIRECT_MESSAGES_LIST = 14;
  private static final int METHODID_ECHO = 15;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_MsgImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_MsgImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_NEW_TEXT_MESSAGE:
          serviceImpl.addNewTextMessage((ir.ms.pb.PB_MsgParam_AddNewTextMessage) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_AddNewTextMessage>) responseObserver);
          break;
        case METHODID_ADD_NEW_MESSAGE:
          serviceImpl.addNewMessage((ir.ms.pb.PB_MsgParam_AddNewMessage) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_AddNewMessage>) responseObserver);
          break;
        case METHODID_SET_ROOM_ACTION_DOING:
          serviceImpl.setRoomActionDoing((ir.ms.pb.PB_MsgParam_SetRoomActionDoing) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetRoomActionDoing>) responseObserver);
          break;
        case METHODID_GET_MESSAGES_BY_IDS:
          serviceImpl.getMessagesByIds((ir.ms.pb.PB_MsgParam_GetMessagesByIds) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetMessagesByIds>) responseObserver);
          break;
        case METHODID_GET_MESSAGES_HISTORY:
          serviceImpl.getMessagesHistory((ir.ms.pb.PB_MsgParam_GetMessagesHistory) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetMessagesHistory>) responseObserver);
          break;
        case METHODID_SET_MESSAGES_RANGE_AS_SEEN:
          serviceImpl.setMessagesRangeAsSeen((ir.ms.pb.PB_MsgParam_SetChatMessagesRangeAsSeen) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetChatMessagesRangeAsSeen>) responseObserver);
          break;
        case METHODID_DELETE_CHAT_HISTORY:
          serviceImpl.deleteChatHistory((ir.ms.pb.PB_MsgParam_DeleteChatHistory) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_DeleteChatHistory>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGES_BY_IDS:
          serviceImpl.deleteMessagesByIds((ir.ms.pb.PB_MsgParam_DeleteMessagesByIds) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_DeleteMessagesByIds>) responseObserver);
          break;
        case METHODID_SET_MESSAGES_AS_RECEIVED:
          serviceImpl.setMessagesAsReceived((ir.ms.pb.PB_MsgParam_SetMessagesAsReceived) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_SetMessagesAsReceived>) responseObserver);
          break;
        case METHODID_FORWARD_MESSAGES:
          serviceImpl.forwardMessages((ir.ms.pb.PB_MsgParam_ForwardMessages) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_ForwardMessages>) responseObserver);
          break;
        case METHODID_EDIT_MESSAGE:
          serviceImpl.editMessage((ir.ms.pb.PB_MsgParam_EditMessage) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_EditMessage>) responseObserver);
          break;
        case METHODID_BROADCAST_NEW_MESSAGE:
          serviceImpl.broadcastNewMessage((ir.ms.pb.PB_MsgParam_BroadcastNewMessage) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_BroadcastNewMessage>) responseObserver);
          break;
        case METHODID_GET_FRESH_CHAT_LIST:
          serviceImpl.getFreshChatList((ir.ms.pb.PB_MsgParam_GetFreshChatList) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshChatList>) responseObserver);
          break;
        case METHODID_GET_FRESH_ROOM_MESSAGES_LIST:
          serviceImpl.getFreshRoomMessagesList((ir.ms.pb.PB_MsgParam_GetFreshRoomMessagesList) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshRoomMessagesList>) responseObserver);
          break;
        case METHODID_GET_FRESH_ALL_DIRECT_MESSAGES_LIST:
          serviceImpl.getFreshAllDirectMessagesList((ir.ms.pb.PB_MsgParam_GetFreshAllDirectMessagesList) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_GetFreshAllDirectMessagesList>) responseObserver);
          break;
        case METHODID_ECHO:
          serviceImpl.echo((ir.ms.pb.PB_MsgParam_Echo) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_MsgResponse_PB_MsgParam_Echo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RPC_MsgGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_ADD_NEW_TEXT_MESSAGE)
              .addMethod(METHOD_ADD_NEW_MESSAGE)
              .addMethod(METHOD_SET_ROOM_ACTION_DOING)
              .addMethod(METHOD_GET_MESSAGES_BY_IDS)
              .addMethod(METHOD_GET_MESSAGES_HISTORY)
              .addMethod(METHOD_SET_MESSAGES_RANGE_AS_SEEN)
              .addMethod(METHOD_DELETE_CHAT_HISTORY)
              .addMethod(METHOD_DELETE_MESSAGES_BY_IDS)
              .addMethod(METHOD_SET_MESSAGES_AS_RECEIVED)
              .addMethod(METHOD_FORWARD_MESSAGES)
              .addMethod(METHOD_EDIT_MESSAGE)
              .addMethod(METHOD_BROADCAST_NEW_MESSAGE)
              .addMethod(METHOD_GET_FRESH_CHAT_LIST)
              .addMethod(METHOD_GET_FRESH_ROOM_MESSAGES_LIST)
              .addMethod(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST)
              .addMethod(METHOD_ECHO)
              .build();
        }
      }
    }
    return result;
  }
}
