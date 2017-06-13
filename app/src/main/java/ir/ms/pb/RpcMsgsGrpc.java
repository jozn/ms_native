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
    comments = "Source: pb_rpc_msgs.proto")
public final class RpcMsgsGrpc {

  private RpcMsgsGrpc() {}

  public static final String SERVICE_NAME = "RpcMsgs";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_Message,
      ir.ms.pb.PB_ResRpcAddMsg> METHOD_UPLOAD_NEW_MSG =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_Message, ir.ms.pb.PB_ResRpcAddMsg>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RpcMsgs", "UploadNewMsg"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_Message.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_ResRpcAddMsg.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RpcMsgsStub newStub(io.grpc.Channel channel) {
    return new RpcMsgsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RpcMsgsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RpcMsgsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RpcMsgsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RpcMsgsFutureStub(channel);
  }

  /**
   */
  public static abstract class RpcMsgsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void uploadNewMsg(ir.ms.pb.PB_Message request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResRpcAddMsg> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPLOAD_NEW_MSG, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_UPLOAD_NEW_MSG,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_Message,
                ir.ms.pb.PB_ResRpcAddMsg>(
                  this, METHODID_UPLOAD_NEW_MSG)))
          .build();
    }
  }

  /**
   */
  public static final class RpcMsgsStub extends io.grpc.stub.AbstractStub<RpcMsgsStub> {
    private RpcMsgsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RpcMsgsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcMsgsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RpcMsgsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void uploadNewMsg(ir.ms.pb.PB_Message request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResRpcAddMsg> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPLOAD_NEW_MSG, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RpcMsgsBlockingStub extends io.grpc.stub.AbstractStub<RpcMsgsBlockingStub> {
    private RpcMsgsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RpcMsgsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcMsgsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RpcMsgsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public ir.ms.pb.PB_ResRpcAddMsg uploadNewMsg(ir.ms.pb.PB_Message request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPLOAD_NEW_MSG, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RpcMsgsFutureStub extends io.grpc.stub.AbstractStub<RpcMsgsFutureStub> {
    private RpcMsgsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RpcMsgsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcMsgsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RpcMsgsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_ResRpcAddMsg> uploadNewMsg(
        ir.ms.pb.PB_Message request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPLOAD_NEW_MSG, getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD_NEW_MSG = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RpcMsgsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RpcMsgsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_NEW_MSG:
          serviceImpl.uploadNewMsg((ir.ms.pb.PB_Message) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_ResRpcAddMsg>) responseObserver);
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
      synchronized (RpcMsgsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_UPLOAD_NEW_MSG)
              .build();
        }
      }
    }
    return result;
  }
}
