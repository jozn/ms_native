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
    comments = "Source: pb_rpc_chat.proto")
public final class RPC_ChatGrpc {

  private RPC_ChatGrpc() {}

  public static final String SERVICE_NAME = "RPC_Chat";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_AddNewMessage,
      ir.ms.pb.PB_ChatResponse_AddNewMessage> METHOD_ADD_NEW_MESSAGE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_AddNewMessage, ir.ms.pb.PB_ChatResponse_AddNewMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "AddNewMessage"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_AddNewMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_AddNewMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_SetRoomActionDoing,
      ir.ms.pb.PB_ChatResponse_SetRoomActionDoing> METHOD_SET_ROOM_ACTION_DOING =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_SetRoomActionDoing, ir.ms.pb.PB_ChatResponse_SetRoomActionDoing>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "SetRoomActionDoing"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_SetRoomActionDoing.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_SetRoomActionDoing.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen,
      ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen> METHOD_SET_MESSAGES_RANGE_AS_SEEN =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen, ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "SetMessagesRangeAsSeen"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_DeleteChatHistory,
      ir.ms.pb.PB_ChatResponse_DeleteChatHistory> METHOD_DELETE_CHAT_HISTORY =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_DeleteChatHistory, ir.ms.pb.PB_ChatResponse_DeleteChatHistory>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "DeleteChatHistory"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_DeleteChatHistory.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_DeleteChatHistory.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_DeleteMessagesByIds,
      ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds> METHOD_DELETE_MESSAGES_BY_IDS =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_DeleteMessagesByIds, ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "DeleteMessagesByIds"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_DeleteMessagesByIds.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_SetMessagesAsReceived,
      ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived> METHOD_SET_MESSAGES_AS_RECEIVED =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_SetMessagesAsReceived, ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "SetMessagesAsReceived"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_SetMessagesAsReceived.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_EditMessage,
      ir.ms.pb.PB_ChatResponse_EditMessage> METHOD_EDIT_MESSAGE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_EditMessage, ir.ms.pb.PB_ChatResponse_EditMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "EditMessage"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_EditMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_EditMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_GetChatList,
      ir.ms.pb.PB_ChatResponse_GetChatList> METHOD_GET_CHAT_LIST =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_GetChatList, ir.ms.pb.PB_ChatResponse_GetChatList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "GetChatList"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_GetChatList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_GetChatList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder,
      ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder> METHOD_GET_CHAT_HISTORY_TO_OLDER =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder, ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "GetChatHistoryToOlder"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList,
      ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList> METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList, ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Chat", "GetFreshAllDirectMessagesList"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_ChatStub newStub(io.grpc.Channel channel) {
    return new RPC_ChatStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_ChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_ChatBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_ChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_ChatFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_ChatImplBase implements io.grpc.BindableService {

    /**
     */
    public void addNewMessage(ir.ms.pb.PB_ChatParam_AddNewMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_AddNewMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_NEW_MESSAGE, responseObserver);
    }

    /**
     */
    public void setRoomActionDoing(ir.ms.pb.PB_ChatParam_SetRoomActionDoing request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetRoomActionDoing> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_ROOM_ACTION_DOING, responseObserver);
    }

    /**
     */
    public void setMessagesRangeAsSeen(ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_MESSAGES_RANGE_AS_SEEN, responseObserver);
    }

    /**
     */
    public void deleteChatHistory(ir.ms.pb.PB_ChatParam_DeleteChatHistory request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_DeleteChatHistory> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CHAT_HISTORY, responseObserver);
    }

    /**
     */
    public void deleteMessagesByIds(ir.ms.pb.PB_ChatParam_DeleteMessagesByIds request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_MESSAGES_BY_IDS, responseObserver);
    }

    /**
     */
    public void setMessagesAsReceived(ir.ms.pb.PB_ChatParam_SetMessagesAsReceived request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_MESSAGES_AS_RECEIVED, responseObserver);
    }

    /**
     */
    public void editMessage(ir.ms.pb.PB_ChatParam_EditMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_EditMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_MESSAGE, responseObserver);
    }

    /**
     */
    public void getChatList(ir.ms.pb.PB_ChatParam_GetChatList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetChatList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAT_LIST, responseObserver);
    }

    /**
     */
    public void getChatHistoryToOlder(ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAT_HISTORY_TO_OLDER, responseObserver);
    }

    /**
     */
    public void getFreshAllDirectMessagesList(ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_NEW_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_AddNewMessage,
                ir.ms.pb.PB_ChatResponse_AddNewMessage>(
                  this, METHODID_ADD_NEW_MESSAGE)))
          .addMethod(
            METHOD_SET_ROOM_ACTION_DOING,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_SetRoomActionDoing,
                ir.ms.pb.PB_ChatResponse_SetRoomActionDoing>(
                  this, METHODID_SET_ROOM_ACTION_DOING)))
          .addMethod(
            METHOD_SET_MESSAGES_RANGE_AS_SEEN,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen,
                ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen>(
                  this, METHODID_SET_MESSAGES_RANGE_AS_SEEN)))
          .addMethod(
            METHOD_DELETE_CHAT_HISTORY,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_DeleteChatHistory,
                ir.ms.pb.PB_ChatResponse_DeleteChatHistory>(
                  this, METHODID_DELETE_CHAT_HISTORY)))
          .addMethod(
            METHOD_DELETE_MESSAGES_BY_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_DeleteMessagesByIds,
                ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds>(
                  this, METHODID_DELETE_MESSAGES_BY_IDS)))
          .addMethod(
            METHOD_SET_MESSAGES_AS_RECEIVED,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_SetMessagesAsReceived,
                ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived>(
                  this, METHODID_SET_MESSAGES_AS_RECEIVED)))
          .addMethod(
            METHOD_EDIT_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_EditMessage,
                ir.ms.pb.PB_ChatResponse_EditMessage>(
                  this, METHODID_EDIT_MESSAGE)))
          .addMethod(
            METHOD_GET_CHAT_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_GetChatList,
                ir.ms.pb.PB_ChatResponse_GetChatList>(
                  this, METHODID_GET_CHAT_LIST)))
          .addMethod(
            METHOD_GET_CHAT_HISTORY_TO_OLDER,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder,
                ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder>(
                  this, METHODID_GET_CHAT_HISTORY_TO_OLDER)))
          .addMethod(
            METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList,
                ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList>(
                  this, METHODID_GET_FRESH_ALL_DIRECT_MESSAGES_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_ChatStub extends io.grpc.stub.AbstractStub<RPC_ChatStub> {
    private RPC_ChatStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_ChatStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_ChatStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_ChatStub(channel, callOptions);
    }

    /**
     */
    public void addNewMessage(ir.ms.pb.PB_ChatParam_AddNewMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_AddNewMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setRoomActionDoing(ir.ms.pb.PB_ChatParam_SetRoomActionDoing request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetRoomActionDoing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_ROOM_ACTION_DOING, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMessagesRangeAsSeen(ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_RANGE_AS_SEEN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteChatHistory(ir.ms.pb.PB_ChatParam_DeleteChatHistory request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_DeleteChatHistory> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CHAT_HISTORY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMessagesByIds(ir.ms.pb.PB_ChatParam_DeleteMessagesByIds request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_MESSAGES_BY_IDS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMessagesAsReceived(ir.ms.pb.PB_ChatParam_SetMessagesAsReceived request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_AS_RECEIVED, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editMessage(ir.ms.pb.PB_ChatParam_EditMessage request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_EditMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChatList(ir.ms.pb.PB_ChatParam_GetChatList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetChatList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChatHistoryToOlder(ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_HISTORY_TO_OLDER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFreshAllDirectMessagesList(ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_ChatBlockingStub extends io.grpc.stub.AbstractStub<RPC_ChatBlockingStub> {
    private RPC_ChatBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_ChatBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_ChatBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_ChatBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_AddNewMessage addNewMessage(ir.ms.pb.PB_ChatParam_AddNewMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_NEW_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_SetRoomActionDoing setRoomActionDoing(ir.ms.pb.PB_ChatParam_SetRoomActionDoing request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_ROOM_ACTION_DOING, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen setMessagesRangeAsSeen(ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_MESSAGES_RANGE_AS_SEEN, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_DeleteChatHistory deleteChatHistory(ir.ms.pb.PB_ChatParam_DeleteChatHistory request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CHAT_HISTORY, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds deleteMessagesByIds(ir.ms.pb.PB_ChatParam_DeleteMessagesByIds request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_MESSAGES_BY_IDS, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived setMessagesAsReceived(ir.ms.pb.PB_ChatParam_SetMessagesAsReceived request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_MESSAGES_AS_RECEIVED, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_EditMessage editMessage(ir.ms.pb.PB_ChatParam_EditMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_GetChatList getChatList(ir.ms.pb.PB_ChatParam_GetChatList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAT_LIST, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder getChatHistoryToOlder(ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAT_HISTORY_TO_OLDER, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList getFreshAllDirectMessagesList(ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_ChatFutureStub extends io.grpc.stub.AbstractStub<RPC_ChatFutureStub> {
    private RPC_ChatFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_ChatFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_ChatFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_ChatFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_AddNewMessage> addNewMessage(
        ir.ms.pb.PB_ChatParam_AddNewMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_SetRoomActionDoing> setRoomActionDoing(
        ir.ms.pb.PB_ChatParam_SetRoomActionDoing request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_ROOM_ACTION_DOING, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen> setMessagesRangeAsSeen(
        ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_RANGE_AS_SEEN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_DeleteChatHistory> deleteChatHistory(
        ir.ms.pb.PB_ChatParam_DeleteChatHistory request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CHAT_HISTORY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds> deleteMessagesByIds(
        ir.ms.pb.PB_ChatParam_DeleteMessagesByIds request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_MESSAGES_BY_IDS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived> setMessagesAsReceived(
        ir.ms.pb.PB_ChatParam_SetMessagesAsReceived request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_MESSAGES_AS_RECEIVED, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_EditMessage> editMessage(
        ir.ms.pb.PB_ChatParam_EditMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_GetChatList> getChatList(
        ir.ms.pb.PB_ChatParam_GetChatList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder> getChatHistoryToOlder(
        ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_HISTORY_TO_OLDER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList> getFreshAllDirectMessagesList(
        ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_NEW_MESSAGE = 0;
  private static final int METHODID_SET_ROOM_ACTION_DOING = 1;
  private static final int METHODID_SET_MESSAGES_RANGE_AS_SEEN = 2;
  private static final int METHODID_DELETE_CHAT_HISTORY = 3;
  private static final int METHODID_DELETE_MESSAGES_BY_IDS = 4;
  private static final int METHODID_SET_MESSAGES_AS_RECEIVED = 5;
  private static final int METHODID_EDIT_MESSAGE = 6;
  private static final int METHODID_GET_CHAT_LIST = 7;
  private static final int METHODID_GET_CHAT_HISTORY_TO_OLDER = 8;
  private static final int METHODID_GET_FRESH_ALL_DIRECT_MESSAGES_LIST = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_ChatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_ChatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_NEW_MESSAGE:
          serviceImpl.addNewMessage((ir.ms.pb.PB_ChatParam_AddNewMessage) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_AddNewMessage>) responseObserver);
          break;
        case METHODID_SET_ROOM_ACTION_DOING:
          serviceImpl.setRoomActionDoing((ir.ms.pb.PB_ChatParam_SetRoomActionDoing) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetRoomActionDoing>) responseObserver);
          break;
        case METHODID_SET_MESSAGES_RANGE_AS_SEEN:
          serviceImpl.setMessagesRangeAsSeen((ir.ms.pb.PB_ChatParam_SetChatMessagesRangeAsSeen) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetChatMessagesRangeAsSeen>) responseObserver);
          break;
        case METHODID_DELETE_CHAT_HISTORY:
          serviceImpl.deleteChatHistory((ir.ms.pb.PB_ChatParam_DeleteChatHistory) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_DeleteChatHistory>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGES_BY_IDS:
          serviceImpl.deleteMessagesByIds((ir.ms.pb.PB_ChatParam_DeleteMessagesByIds) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds>) responseObserver);
          break;
        case METHODID_SET_MESSAGES_AS_RECEIVED:
          serviceImpl.setMessagesAsReceived((ir.ms.pb.PB_ChatParam_SetMessagesAsReceived) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_SetMessagesAsReceived>) responseObserver);
          break;
        case METHODID_EDIT_MESSAGE:
          serviceImpl.editMessage((ir.ms.pb.PB_ChatParam_EditMessage) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_EditMessage>) responseObserver);
          break;
        case METHODID_GET_CHAT_LIST:
          serviceImpl.getChatList((ir.ms.pb.PB_ChatParam_GetChatList) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetChatList>) responseObserver);
          break;
        case METHODID_GET_CHAT_HISTORY_TO_OLDER:
          serviceImpl.getChatHistoryToOlder((ir.ms.pb.PB_ChatParam_GetChatHistoryToOlder) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetChatHistoryToOlder>) responseObserver);
          break;
        case METHODID_GET_FRESH_ALL_DIRECT_MESSAGES_LIST:
          serviceImpl.getFreshAllDirectMessagesList((ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ChatResponse_GetFreshAllDirectMessagesList>) responseObserver);
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
      synchronized (RPC_ChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_ADD_NEW_MESSAGE)
              .addMethod(METHOD_SET_ROOM_ACTION_DOING)
              .addMethod(METHOD_SET_MESSAGES_RANGE_AS_SEEN)
              .addMethod(METHOD_DELETE_CHAT_HISTORY)
              .addMethod(METHOD_DELETE_MESSAGES_BY_IDS)
              .addMethod(METHOD_SET_MESSAGES_AS_RECEIVED)
              .addMethod(METHOD_EDIT_MESSAGE)
              .addMethod(METHOD_GET_CHAT_LIST)
              .addMethod(METHOD_GET_CHAT_HISTORY_TO_OLDER)
              .addMethod(METHOD_GET_FRESH_ALL_DIRECT_MESSAGES_LIST)
              .build();
        }
      }
    }
    return result;
  }
}
