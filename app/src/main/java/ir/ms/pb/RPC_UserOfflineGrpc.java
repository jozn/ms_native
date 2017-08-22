package ir.ms.pb;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/** */
@javax.annotation.Generated(
  value = "by gRPC proto compiler (version 1.4.0)",
  comments = "Source: pb_rpc_user.proto"
)
public final class RPC_UserOfflineGrpc {

  private RPC_UserOfflineGrpc() {}

  public static final String SERVICE_NAME = "RPC_UserOffline";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<
          ir.ms.pb.PB_UserParam_BlockUser, ir.ms.pb.PB_UserOfflineResponse_BlockUser>
      METHOD_BLOCK_USER =
          io.grpc.MethodDescriptor
              .<ir.ms.pb.PB_UserParam_BlockUser, ir.ms.pb.PB_UserOfflineResponse_BlockUser>
                  newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("RPC_UserOffline", "BlockUser"))
              .setRequestMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserParam_BlockUser.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserOfflineResponse_BlockUser.getDefaultInstance()))
              .build();

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<
          ir.ms.pb.PB_UserParam_UnBlockUser, ir.ms.pb.PB_UserOfflineResponse_UnBlockUser>
      METHOD_UN_BLOCK_USER =
          io.grpc.MethodDescriptor
              .<ir.ms.pb.PB_UserParam_UnBlockUser, ir.ms.pb.PB_UserOfflineResponse_UnBlockUser>
                  newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("RPC_UserOffline", "UnBlockUser"))
              .setRequestMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserParam_UnBlockUser.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserOfflineResponse_UnBlockUser.getDefaultInstance()))
              .build();

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<
          ir.ms.pb.PB_UserParam_UpdateAbout, ir.ms.pb.PB_UserOfflineResponse_UpdateAbout>
      METHOD_UPDATE_ABOUT =
          io.grpc.MethodDescriptor
              .<ir.ms.pb.PB_UserParam_UpdateAbout, ir.ms.pb.PB_UserOfflineResponse_UpdateAbout>
                  newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("RPC_UserOffline", "UpdateAbout"))
              .setRequestMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserParam_UpdateAbout.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserOfflineResponse_UpdateAbout.getDefaultInstance()))
              .build();

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<
          ir.ms.pb.PB_UserParam_UpdateUserName, ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>
      METHOD_UPDATE_USER_NAME =
          io.grpc.MethodDescriptor
              .<ir.ms.pb.PB_UserParam_UpdateUserName,
                  ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>
                  newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("RPC_UserOffline", "UpdateUserName"))
              .setRequestMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserParam_UpdateUserName.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserOfflineResponse_UpdateUserName.getDefaultInstance()))
              .build();

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<
          ir.ms.pb.PB_UserParam_ChangePrivacy, ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>
      METHOD_CHANGE_PRIVACY =
          io.grpc.MethodDescriptor
              .<ir.ms.pb.PB_UserParam_ChangePrivacy, ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>
                  newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("RPC_UserOffline", "ChangePrivacy"))
              .setRequestMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserParam_ChangePrivacy.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserResponseOffline_ChangePrivacy.getDefaultInstance()))
              .build();

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<
          ir.ms.pb.PB_UserParam_ChangeAvatar, ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>
      METHOD_CHANGE_AVATAR =
          io.grpc.MethodDescriptor
              .<ir.ms.pb.PB_UserParam_ChangeAvatar, ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>
                  newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("RPC_UserOffline", "ChangeAvatar"))
              .setRequestMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserParam_ChangeAvatar.getDefaultInstance()))
              .setResponseMarshaller(
                  io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                      ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar.getDefaultInstance()))
              .build();

  /** Creates a new async stub that supports all call types for the service */
  public static RPC_UserOfflineStub newStub(io.grpc.Channel channel) {
    return new RPC_UserOfflineStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_UserOfflineBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new RPC_UserOfflineBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RPC_UserOfflineFutureStub newFutureStub(io.grpc.Channel channel) {
    return new RPC_UserOfflineFutureStub(channel);
  }

  /** */
  public abstract static class RPC_UserOfflineImplBase implements io.grpc.BindableService {

    /** */
    public void blockUser(
        ir.ms.pb.PB_UserParam_BlockUser request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_BlockUser> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_BLOCK_USER, responseObserver);
    }

    /** */
    public void unBlockUser(
        ir.ms.pb.PB_UserParam_UnBlockUser request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UnBlockUser> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UN_BLOCK_USER, responseObserver);
    }

    /** */
    public void updateAbout(
        ir.ms.pb.PB_UserParam_UpdateAbout request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UpdateAbout> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_ABOUT, responseObserver);
    }

    /** */
    public void updateUserName(
        ir.ms.pb.PB_UserParam_UpdateUserName request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>
            responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_USER_NAME, responseObserver);
    }

    /** */
    public void changePrivacy(
        ir.ms.pb.PB_UserParam_ChangePrivacy request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>
            responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_PRIVACY, responseObserver);
    }

    /** */
    public void changeAvatar(
        ir.ms.pb.PB_UserParam_ChangeAvatar request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>
            responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_AVATAR, responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              METHOD_BLOCK_USER,
              asyncUnaryCall(
                  new MethodHandlers<
                      ir.ms.pb.PB_UserParam_BlockUser, ir.ms.pb.PB_UserOfflineResponse_BlockUser>(
                      this, METHODID_BLOCK_USER)))
          .addMethod(
              METHOD_UN_BLOCK_USER,
              asyncUnaryCall(
                  new MethodHandlers<
                      ir.ms.pb.PB_UserParam_UnBlockUser,
                      ir.ms.pb.PB_UserOfflineResponse_UnBlockUser>(this, METHODID_UN_BLOCK_USER)))
          .addMethod(
              METHOD_UPDATE_ABOUT,
              asyncUnaryCall(
                  new MethodHandlers<
                      ir.ms.pb.PB_UserParam_UpdateAbout,
                      ir.ms.pb.PB_UserOfflineResponse_UpdateAbout>(this, METHODID_UPDATE_ABOUT)))
          .addMethod(
              METHOD_UPDATE_USER_NAME,
              asyncUnaryCall(
                  new MethodHandlers<
                      ir.ms.pb.PB_UserParam_UpdateUserName,
                      ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>(
                      this, METHODID_UPDATE_USER_NAME)))
          .addMethod(
              METHOD_CHANGE_PRIVACY,
              asyncUnaryCall(
                  new MethodHandlers<
                      ir.ms.pb.PB_UserParam_ChangePrivacy,
                      ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>(
                      this, METHODID_CHANGE_PRIVACY)))
          .addMethod(
              METHOD_CHANGE_AVATAR,
              asyncUnaryCall(
                  new MethodHandlers<
                      ir.ms.pb.PB_UserParam_ChangeAvatar,
                      ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>(this, METHODID_CHANGE_AVATAR)))
          .build();
    }
  }

  /** */
  public static final class RPC_UserOfflineStub
      extends io.grpc.stub.AbstractStub<RPC_UserOfflineStub> {
    private RPC_UserOfflineStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_UserOfflineStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_UserOfflineStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPC_UserOfflineStub(channel, callOptions);
    }

    /** */
    public void blockUser(
        ir.ms.pb.PB_UserParam_BlockUser request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_BlockUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_BLOCK_USER, getCallOptions()), request, responseObserver);
    }

    /** */
    public void unBlockUser(
        ir.ms.pb.PB_UserParam_UnBlockUser request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UnBlockUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UN_BLOCK_USER, getCallOptions()), request, responseObserver);
    }

    /** */
    public void updateAbout(
        ir.ms.pb.PB_UserParam_UpdateAbout request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UpdateAbout> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_ABOUT, getCallOptions()), request, responseObserver);
    }

    /** */
    public void updateUserName(
        ir.ms.pb.PB_UserParam_UpdateUserName request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER_NAME, getCallOptions()),
          request,
          responseObserver);
    }

    /** */
    public void changePrivacy(
        ir.ms.pb.PB_UserParam_ChangePrivacy request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PRIVACY, getCallOptions()), request, responseObserver);
    }

    /** */
    public void changeAvatar(
        ir.ms.pb.PB_UserParam_ChangeAvatar request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_AVATAR, getCallOptions()), request, responseObserver);
    }
  }

  /** */
  public static final class RPC_UserOfflineBlockingStub
      extends io.grpc.stub.AbstractStub<RPC_UserOfflineBlockingStub> {
    private RPC_UserOfflineBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_UserOfflineBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_UserOfflineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPC_UserOfflineBlockingStub(channel, callOptions);
    }

    /** */
    public ir.ms.pb.PB_UserOfflineResponse_BlockUser blockUser(
        ir.ms.pb.PB_UserParam_BlockUser request) {
      return blockingUnaryCall(getChannel(), METHOD_BLOCK_USER, getCallOptions(), request);
    }

    /** */
    public ir.ms.pb.PB_UserOfflineResponse_UnBlockUser unBlockUser(
        ir.ms.pb.PB_UserParam_UnBlockUser request) {
      return blockingUnaryCall(getChannel(), METHOD_UN_BLOCK_USER, getCallOptions(), request);
    }

    /** */
    public ir.ms.pb.PB_UserOfflineResponse_UpdateAbout updateAbout(
        ir.ms.pb.PB_UserParam_UpdateAbout request) {
      return blockingUnaryCall(getChannel(), METHOD_UPDATE_ABOUT, getCallOptions(), request);
    }

    /** */
    public ir.ms.pb.PB_UserOfflineResponse_UpdateUserName updateUserName(
        ir.ms.pb.PB_UserParam_UpdateUserName request) {
      return blockingUnaryCall(getChannel(), METHOD_UPDATE_USER_NAME, getCallOptions(), request);
    }

    /** */
    public ir.ms.pb.PB_UserResponseOffline_ChangePrivacy changePrivacy(
        ir.ms.pb.PB_UserParam_ChangePrivacy request) {
      return blockingUnaryCall(getChannel(), METHOD_CHANGE_PRIVACY, getCallOptions(), request);
    }

    /** */
    public ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar changeAvatar(
        ir.ms.pb.PB_UserParam_ChangeAvatar request) {
      return blockingUnaryCall(getChannel(), METHOD_CHANGE_AVATAR, getCallOptions(), request);
    }
  }

  /** */
  public static final class RPC_UserOfflineFutureStub
      extends io.grpc.stub.AbstractStub<RPC_UserOfflineFutureStub> {
    private RPC_UserOfflineFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_UserOfflineFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_UserOfflineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPC_UserOfflineFutureStub(channel, callOptions);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            ir.ms.pb.PB_UserOfflineResponse_BlockUser>
        blockUser(ir.ms.pb.PB_UserParam_BlockUser request) {
      return futureUnaryCall(getChannel().newCall(METHOD_BLOCK_USER, getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            ir.ms.pb.PB_UserOfflineResponse_UnBlockUser>
        unBlockUser(ir.ms.pb.PB_UserParam_UnBlockUser request) {
      return futureUnaryCall(getChannel().newCall(METHOD_UN_BLOCK_USER, getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            ir.ms.pb.PB_UserOfflineResponse_UpdateAbout>
        updateAbout(ir.ms.pb.PB_UserParam_UpdateAbout request) {
      return futureUnaryCall(getChannel().newCall(METHOD_UPDATE_ABOUT, getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>
        updateUserName(ir.ms.pb.PB_UserParam_UpdateUserName request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_USER_NAME, getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>
        changePrivacy(ir.ms.pb.PB_UserParam_ChangePrivacy request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PRIVACY, getCallOptions()), request);
    }

    /** */
    public com.google.common.util.concurrent.ListenableFuture<
            ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>
        changeAvatar(ir.ms.pb.PB_UserParam_ChangeAvatar request) {
      return futureUnaryCall(getChannel().newCall(METHOD_CHANGE_AVATAR, getCallOptions()), request);
    }
  }

  private static final int METHODID_BLOCK_USER = 0;
  private static final int METHODID_UN_BLOCK_USER = 1;
  private static final int METHODID_UPDATE_ABOUT = 2;
  private static final int METHODID_UPDATE_USER_NAME = 3;
  private static final int METHODID_CHANGE_PRIVACY = 4;
  private static final int METHODID_CHANGE_AVATAR = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_UserOfflineImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_UserOfflineImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BLOCK_USER:
          serviceImpl.blockUser(
              (ir.ms.pb.PB_UserParam_BlockUser) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_BlockUser>)
                  responseObserver);
          break;
        case METHODID_UN_BLOCK_USER:
          serviceImpl.unBlockUser(
              (ir.ms.pb.PB_UserParam_UnBlockUser) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UnBlockUser>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ABOUT:
          serviceImpl.updateAbout(
              (ir.ms.pb.PB_UserParam_UpdateAbout) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UpdateAbout>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_NAME:
          serviceImpl.updateUserName(
              (ir.ms.pb.PB_UserParam_UpdateUserName) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_UpdateUserName>)
                  responseObserver);
          break;
        case METHODID_CHANGE_PRIVACY:
          serviceImpl.changePrivacy(
              (ir.ms.pb.PB_UserParam_ChangePrivacy) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponseOffline_ChangePrivacy>)
                  responseObserver);
          break;
        case METHODID_CHANGE_AVATAR:
          serviceImpl.changeAvatar(
              (ir.ms.pb.PB_UserParam_ChangeAvatar) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserOfflineResponse_ChangeAvatar>)
                  responseObserver);
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
      synchronized (RPC_UserOfflineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .addMethod(METHOD_BLOCK_USER)
                      .addMethod(METHOD_UN_BLOCK_USER)
                      .addMethod(METHOD_UPDATE_ABOUT)
                      .addMethod(METHOD_UPDATE_USER_NAME)
                      .addMethod(METHOD_CHANGE_PRIVACY)
                      .addMethod(METHOD_CHANGE_AVATAR)
                      .build();
        }
      }
    }
    return result;
  }
}
