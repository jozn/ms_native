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
    comments = "Source: pb_rpc_other.proto")
public final class RPC_OtherGrpc {

  private RPC_OtherGrpc() {}

  public static final String SERVICE_NAME = "RPC_Other";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_OtherParam_Echo,
      ir.ms.pb.PB_OtherResponse_Echo> METHOD_ECHO =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_OtherParam_Echo, ir.ms.pb.PB_OtherResponse_Echo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Other", "Echo"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_OtherParam_Echo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_OtherResponse_Echo.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_OtherStub newStub(io.grpc.Channel channel) {
    return new RPC_OtherStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_OtherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_OtherBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_OtherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_OtherFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_OtherImplBase implements io.grpc.BindableService {

    /**
     */
    public void echo(ir.ms.pb.PB_OtherParam_Echo request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_OtherResponse_Echo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ECHO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ECHO,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_OtherParam_Echo,
                ir.ms.pb.PB_OtherResponse_Echo>(
                  this, METHODID_ECHO)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_OtherStub extends io.grpc.stub.AbstractStub<RPC_OtherStub> {
    private RPC_OtherStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_OtherStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_OtherStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_OtherStub(channel, callOptions);
    }

    /**
     */
    public void echo(ir.ms.pb.PB_OtherParam_Echo request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_OtherResponse_Echo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_OtherBlockingStub extends io.grpc.stub.AbstractStub<RPC_OtherBlockingStub> {
    private RPC_OtherBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_OtherBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_OtherBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_OtherBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_OtherResponse_Echo echo(ir.ms.pb.PB_OtherParam_Echo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ECHO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_OtherFutureStub extends io.grpc.stub.AbstractStub<RPC_OtherFutureStub> {
    private RPC_OtherFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_OtherFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_OtherFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_OtherFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_OtherResponse_Echo> echo(
        ir.ms.pb.PB_OtherParam_Echo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_OtherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_OtherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ECHO:
          serviceImpl.echo((ir.ms.pb.PB_OtherParam_Echo) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_OtherResponse_Echo>) responseObserver);
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
      synchronized (RPC_OtherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_ECHO)
              .build();
        }
      }
    }
    return result;
  }
}
