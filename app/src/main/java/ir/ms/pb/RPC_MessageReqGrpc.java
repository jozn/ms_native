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
public final class RPC_MessageReqGrpc {

  private RPC_MessageReqGrpc() {}

  public static final String SERVICE_NAME = "RPC_MessageReq";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_ReqLastChangesForTheRoom,
      ir.ms.pb.PB_ResponseLastChangesForTheRoom> METHOD_GET_LAST_CHNAGES_FOR_ROOM =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_ReqLastChangesForTheRoom, ir.ms.pb.PB_ResponseLastChangesForTheRoom>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_MessageReq", "GetLastChnagesForRoom"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ReqLastChangesForTheRoom.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ResponseLastChangesForTheRoom.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_MessageReqStub newStub(io.grpc.Channel channel) {
    return new RPC_MessageReqStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_MessageReqBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_MessageReqBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_MessageReqFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_MessageReqFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_MessageReqImplBase implements io.grpc.BindableService {

    /**
     */
    public void getLastChnagesForRoom(ir.ms.pb.PB_ReqLastChangesForTheRoom request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResponseLastChangesForTheRoom> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LAST_CHNAGES_FOR_ROOM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_LAST_CHNAGES_FOR_ROOM,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_ReqLastChangesForTheRoom,
                ir.ms.pb.PB_ResponseLastChangesForTheRoom>(
                  this, METHODID_GET_LAST_CHNAGES_FOR_ROOM)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_MessageReqStub extends io.grpc.stub.AbstractStub<RPC_MessageReqStub> {
    private RPC_MessageReqStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MessageReqStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MessageReqStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MessageReqStub(channel, callOptions);
    }

    /**
     */
    public void getLastChnagesForRoom(ir.ms.pb.PB_ReqLastChangesForTheRoom request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResponseLastChangesForTheRoom> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_CHNAGES_FOR_ROOM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_MessageReqBlockingStub extends io.grpc.stub.AbstractStub<RPC_MessageReqBlockingStub> {
    private RPC_MessageReqBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MessageReqBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MessageReqBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MessageReqBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_ResponseLastChangesForTheRoom getLastChnagesForRoom(ir.ms.pb.PB_ReqLastChangesForTheRoom request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LAST_CHNAGES_FOR_ROOM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_MessageReqFutureStub extends io.grpc.stub.AbstractStub<RPC_MessageReqFutureStub> {
    private RPC_MessageReqFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_MessageReqFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_MessageReqFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_MessageReqFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ResponseLastChangesForTheRoom> getLastChnagesForRoom(
        ir.ms.pb.PB_ReqLastChangesForTheRoom request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_CHNAGES_FOR_ROOM, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LAST_CHNAGES_FOR_ROOM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_MessageReqImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_MessageReqImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LAST_CHNAGES_FOR_ROOM:
          serviceImpl.getLastChnagesForRoom((ir.ms.pb.PB_ReqLastChangesForTheRoom) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResponseLastChangesForTheRoom>) responseObserver);
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
      synchronized (RPC_MessageReqGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_GET_LAST_CHNAGES_FOR_ROOM)
              .build();
        }
      }
    }
    return result;
  }
}
