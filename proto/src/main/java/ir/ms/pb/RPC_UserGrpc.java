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
    comments = "Source: pb_rpc_user.proto")
public final class RPC_UserGrpc {

  private RPC_UserGrpc() {}

  public static final String SERVICE_NAME = "RPC_User";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName,
      ir.ms.pb.PB_UserResponse_CheckUserName> METHOD_CHECK_USER_NAME =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName, ir.ms.pb.PB_UserResponse_CheckUserName>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_User", "CheckUserName"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_BlockedList,
      ir.ms.pb.PB_UserResponse_BlockedList> METHOD_GET_BLOCKED_LIST =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_BlockedList, ir.ms.pb.PB_UserResponse_BlockedList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_User", "GetBlockedList"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_BlockedList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_BlockedList.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_UserStub newStub(io.grpc.Channel channel) {
    return new RPC_UserStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_UserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_UserBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_UserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_UserFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_UserImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkUserName(ir.ms.pb.PB_UserParam_CheckUserName request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECK_USER_NAME, responseObserver);
    }

    /**
     */
    public void getBlockedList(ir.ms.pb.PB_UserParam_BlockedList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_BlockedList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BLOCKED_LIST, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CHECK_USER_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName,
                ir.ms.pb.PB_UserResponse_CheckUserName>(
                  this, METHODID_CHECK_USER_NAME)))
          .addMethod(
            METHOD_GET_BLOCKED_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_BlockedList,
                ir.ms.pb.PB_UserResponse_BlockedList>(
                  this, METHODID_GET_BLOCKED_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_UserStub extends io.grpc.stub.AbstractStub<RPC_UserStub> {
    private RPC_UserStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_UserStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_UserStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_UserStub(channel, callOptions);
    }

    /**
     */
    public void checkUserName(ir.ms.pb.PB_UserParam_CheckUserName request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECK_USER_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBlockedList(ir.ms.pb.PB_UserParam_BlockedList request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_BlockedList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BLOCKED_LIST, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_UserBlockingStub extends io.grpc.stub.AbstractStub<RPC_UserBlockingStub> {
    private RPC_UserBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_UserBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_UserBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_UserBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName checkUserName(ir.ms.pb.PB_UserParam_CheckUserName request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECK_USER_NAME, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_BlockedList getBlockedList(ir.ms.pb.PB_UserParam_BlockedList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BLOCKED_LIST, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_UserFutureStub extends io.grpc.stub.AbstractStub<RPC_UserFutureStub> {
    private RPC_UserFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_UserFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_UserFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_UserFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName> checkUserName(
        ir.ms.pb.PB_UserParam_CheckUserName request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECK_USER_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_BlockedList> getBlockedList(
        ir.ms.pb.PB_UserParam_BlockedList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BLOCKED_LIST, getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_USER_NAME = 0;
  private static final int METHODID_GET_BLOCKED_LIST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_UserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_UserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_USER_NAME:
          serviceImpl.checkUserName((ir.ms.pb.PB_UserParam_CheckUserName) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName>) responseObserver);
          break;
        case METHODID_GET_BLOCKED_LIST:
          serviceImpl.getBlockedList((ir.ms.pb.PB_UserParam_BlockedList) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_BlockedList>) responseObserver);
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
      synchronized (RPC_UserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_CHECK_USER_NAME)
              .addMethod(METHOD_GET_BLOCKED_LIST)
              .build();
        }
      }
    }
    return result;
  }
}
