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
    comments = "Source: pb_chat.proto")
public final class RPC_MessageReqOfflineGrpc {

  private RPC_MessageReqOfflineGrpc() {}

  public static final String SERVICE_NAME = "RPC_MessageReqOffline";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_RequestSetLastSeenMessages,
      ir.ms.pb.PB_ResponseSetLastSeenMessages> METHOD_SET_LAST_SEEN =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_RequestSetLastSeenMessages, ir.ms.pb.PB_ResponseSetLastSeenMessages>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_MessageReqOffline", "SetLastSeen"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_RequestSetLastSeenMessages.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ResponseSetLastSeenMessages.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_MessageReqOfflineStub newStub(io.grpc.Channel channel) {
    return new RPC_MessageReqOfflineStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_MessageReqOfflineBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_MessageReqOfflineBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_MessageReqOfflineFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_MessageReqOfflineFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_MessageReqOfflineImplBase implements io.grpc.BindableService {

    /**
     */
    public void setLastSeen(ir.ms.pb.PB_RequestSetLastSeenMessages request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResponseSetLastSeenMessages> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_LAST_SEEN, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SET_LAST_SEEN,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_RequestSetLastSeenMessages,
                ir.ms.pb.PB_ResponseSetLastSeenMessages>(
                  this, METHODID_SET_LAST_SEEN)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_MessageReqOfflineStub extends io.grpc.stub.AbstractStub<RPC_MessageReqOfflineStub> {
    private RPC_MessageReqOfflineStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MessageReqOfflineStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MessageReqOfflineStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MessageReqOfflineStub(channel, callOptions);
    }

    /**
     */
    public void setLastSeen(ir.ms.pb.PB_RequestSetLastSeenMessages request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResponseSetLastSeenMessages> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SEEN, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_MessageReqOfflineBlockingStub extends io.grpc.stub.AbstractStub<RPC_MessageReqOfflineBlockingStub> {
    private RPC_MessageReqOfflineBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MessageReqOfflineBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MessageReqOfflineBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MessageReqOfflineBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_ResponseSetLastSeenMessages setLastSeen(ir.ms.pb.PB_RequestSetLastSeenMessages request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_LAST_SEEN, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_MessageReqOfflineFutureStub extends io.grpc.stub.AbstractStub<RPC_MessageReqOfflineFutureStub> {
    private RPC_MessageReqOfflineFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MessageReqOfflineFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MessageReqOfflineFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MessageReqOfflineFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ResponseSetLastSeenMessages> setLastSeen(
        ir.ms.pb.PB_RequestSetLastSeenMessages request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_LAST_SEEN, getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_LAST_SEEN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_MessageReqOfflineImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_MessageReqOfflineImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_LAST_SEEN:
          serviceImpl.setLastSeen((ir.ms.pb.PB_RequestSetLastSeenMessages) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResponseSetLastSeenMessages>) responseObserver);
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
      synchronized (RPC_MessageReqOfflineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_SET_LAST_SEEN)
              .build();
        }
      }
    }
    return result;
  }
}
