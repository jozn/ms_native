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
    comments = "Source: pb_rpc_sync.proto")
public final class RPC_SyncGrpc {

  private RPC_SyncGrpc() {}

  public static final String SERVICE_NAME = "RPC_Sync";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_SyncParam_GetDirectUpdates,
      ir.ms.pb.PB_SyncResponse_GetDirectUpdates> METHOD_GET_DIRECT_UPDATES =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_SyncParam_GetDirectUpdates, ir.ms.pb.PB_SyncResponse_GetDirectUpdates>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Sync", "GetDirectUpdates"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncParam_GetDirectUpdates.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncResponse_GetDirectUpdates.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_SyncParam_GetGeneralUpdates,
      ir.ms.pb.PB_SyncResponse_GetGeneralUpdates> METHOD_GET_GENERAL_UPDATES =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_SyncParam_GetGeneralUpdates, ir.ms.pb.PB_SyncResponse_GetGeneralUpdates>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Sync", "GetGeneralUpdates"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncParam_GetGeneralUpdates.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_SyncParam_GetNotifyUpdates,
      ir.ms.pb.PB_SyncResponse_GetNotifyUpdates> METHOD_GET_NOTIFY_UPDATES =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_SyncParam_GetNotifyUpdates, ir.ms.pb.PB_SyncResponse_GetNotifyUpdates>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Sync", "GetNotifyUpdates"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncParam_GetNotifyUpdates.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncResponse_GetNotifyUpdates.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId,
      ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId> METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId, ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Sync", "SetLastSyncDirectUpdateId"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId,
      ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId> METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId, ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Sync", "SetLastSyncGeneralUpdateId"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId,
      ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId> METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId, ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Sync", "SetLastSyncNotifyUpdateId"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_SyncStub newStub(io.grpc.Channel channel) {
    return new RPC_SyncStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_SyncBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_SyncBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_SyncFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_SyncFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_SyncImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDirectUpdates(ir.ms.pb.PB_SyncParam_GetDirectUpdates request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetDirectUpdates> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DIRECT_UPDATES, responseObserver);
    }

    /**
     */
    public void getGeneralUpdates(ir.ms.pb.PB_SyncParam_GetGeneralUpdates request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetGeneralUpdates> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_GENERAL_UPDATES, responseObserver);
    }

    /**
     */
    public void getNotifyUpdates(ir.ms.pb.PB_SyncParam_GetNotifyUpdates request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetNotifyUpdates> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_NOTIFY_UPDATES, responseObserver);
    }

    /**
     */
    public void setLastSyncDirectUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID, responseObserver);
    }

    /**
     */
    public void setLastSyncGeneralUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID, responseObserver);
    }

    /**
     */
    public void setLastSyncNotifyUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DIRECT_UPDATES,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_SyncParam_GetDirectUpdates,
                ir.ms.pb.PB_SyncResponse_GetDirectUpdates>(
                  this, METHODID_GET_DIRECT_UPDATES)))
          .addMethod(
            METHOD_GET_GENERAL_UPDATES,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_SyncParam_GetGeneralUpdates,
                ir.ms.pb.PB_SyncResponse_GetGeneralUpdates>(
                  this, METHODID_GET_GENERAL_UPDATES)))
          .addMethod(
            METHOD_GET_NOTIFY_UPDATES,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_SyncParam_GetNotifyUpdates,
                ir.ms.pb.PB_SyncResponse_GetNotifyUpdates>(
                  this, METHODID_GET_NOTIFY_UPDATES)))
          .addMethod(
            METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId,
                ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId>(
                  this, METHODID_SET_LAST_SYNC_DIRECT_UPDATE_ID)))
          .addMethod(
            METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId,
                ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId>(
                  this, METHODID_SET_LAST_SYNC_GENERAL_UPDATE_ID)))
          .addMethod(
            METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId,
                ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId>(
                  this, METHODID_SET_LAST_SYNC_NOTIFY_UPDATE_ID)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_SyncStub extends io.grpc.stub.AbstractStub<RPC_SyncStub> {
    private RPC_SyncStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_SyncStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_SyncStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_SyncStub(channel, callOptions);
    }

    /**
     */
    public void getDirectUpdates(ir.ms.pb.PB_SyncParam_GetDirectUpdates request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetDirectUpdates> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DIRECT_UPDATES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGeneralUpdates(ir.ms.pb.PB_SyncParam_GetGeneralUpdates request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetGeneralUpdates> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_GENERAL_UPDATES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNotifyUpdates(ir.ms.pb.PB_SyncParam_GetNotifyUpdates request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetNotifyUpdates> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_NOTIFY_UPDATES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setLastSyncDirectUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setLastSyncGeneralUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setLastSyncNotifyUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_SyncBlockingStub extends io.grpc.stub.AbstractStub<RPC_SyncBlockingStub> {
    private RPC_SyncBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_SyncBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_SyncBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_SyncBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_SyncResponse_GetDirectUpdates getDirectUpdates(ir.ms.pb.PB_SyncParam_GetDirectUpdates request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DIRECT_UPDATES, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_SyncResponse_GetGeneralUpdates getGeneralUpdates(ir.ms.pb.PB_SyncParam_GetGeneralUpdates request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_GENERAL_UPDATES, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_SyncResponse_GetNotifyUpdates getNotifyUpdates(ir.ms.pb.PB_SyncParam_GetNotifyUpdates request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_NOTIFY_UPDATES, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId setLastSyncDirectUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId setLastSyncGeneralUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId setLastSyncNotifyUpdateId(ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_SyncFutureStub extends io.grpc.stub.AbstractStub<RPC_SyncFutureStub> {
    private RPC_SyncFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_SyncFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_SyncFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_SyncFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_SyncResponse_GetDirectUpdates> getDirectUpdates(
        ir.ms.pb.PB_SyncParam_GetDirectUpdates request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DIRECT_UPDATES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_SyncResponse_GetGeneralUpdates> getGeneralUpdates(
        ir.ms.pb.PB_SyncParam_GetGeneralUpdates request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_GENERAL_UPDATES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_SyncResponse_GetNotifyUpdates> getNotifyUpdates(
        ir.ms.pb.PB_SyncParam_GetNotifyUpdates request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_NOTIFY_UPDATES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId> setLastSyncDirectUpdateId(
        ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId> setLastSyncGeneralUpdateId(
        ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId> setLastSyncNotifyUpdateId(
        ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DIRECT_UPDATES = 0;
  private static final int METHODID_GET_GENERAL_UPDATES = 1;
  private static final int METHODID_GET_NOTIFY_UPDATES = 2;
  private static final int METHODID_SET_LAST_SYNC_DIRECT_UPDATE_ID = 3;
  private static final int METHODID_SET_LAST_SYNC_GENERAL_UPDATE_ID = 4;
  private static final int METHODID_SET_LAST_SYNC_NOTIFY_UPDATE_ID = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_SyncImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_SyncImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DIRECT_UPDATES:
          serviceImpl.getDirectUpdates((ir.ms.pb.PB_SyncParam_GetDirectUpdates) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetDirectUpdates>) responseObserver);
          break;
        case METHODID_GET_GENERAL_UPDATES:
          serviceImpl.getGeneralUpdates((ir.ms.pb.PB_SyncParam_GetGeneralUpdates) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetGeneralUpdates>) responseObserver);
          break;
        case METHODID_GET_NOTIFY_UPDATES:
          serviceImpl.getNotifyUpdates((ir.ms.pb.PB_SyncParam_GetNotifyUpdates) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_GetNotifyUpdates>) responseObserver);
          break;
        case METHODID_SET_LAST_SYNC_DIRECT_UPDATE_ID:
          serviceImpl.setLastSyncDirectUpdateId((ir.ms.pb.PB_SyncParam_SetLastSyncDirectUpdateId) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncDirectUpdateId>) responseObserver);
          break;
        case METHODID_SET_LAST_SYNC_GENERAL_UPDATE_ID:
          serviceImpl.setLastSyncGeneralUpdateId((ir.ms.pb.PB_SyncParam_SetLastSyncGeneralUpdateId) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncGeneralUpdateId>) responseObserver);
          break;
        case METHODID_SET_LAST_SYNC_NOTIFY_UPDATE_ID:
          serviceImpl.setLastSyncNotifyUpdateId((ir.ms.pb.PB_SyncParam_SetLastSyncNotifyUpdateId) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_SyncResponse_SetLastSyncNotifyUpdateId>) responseObserver);
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
      synchronized (RPC_SyncGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_GET_DIRECT_UPDATES)
              .addMethod(METHOD_GET_GENERAL_UPDATES)
              .addMethod(METHOD_GET_NOTIFY_UPDATES)
              .addMethod(METHOD_SET_LAST_SYNC_DIRECT_UPDATE_ID)
              .addMethod(METHOD_SET_LAST_SYNC_GENERAL_UPDATE_ID)
              .addMethod(METHOD_SET_LAST_SYNC_NOTIFY_UPDATE_ID)
              .build();
        }
      }
    }
    return result;
  }
}
