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
    comments = "Source: pb_rpc_auth2.proto")
public final class RPC_AuthGrpc {

  private RPC_AuthGrpc() {}

  public static final String SERVICE_NAME = "RPC_Auth";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_CHECK_PHONE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "CheckPhone"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_SEND_CODE =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "SendCode"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_SEND_CODE_TO_SMS =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "SendCodeToSms"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_SEND_CODE_TO_TELGRAM =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "SendCodeToTelgram"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_SING_UP =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "SingUp"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_SING_IN =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "SingIn"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ir.ms.pb.PB_UserParam_CheckUserName2,
      ir.ms.pb.PB_UserResponse_CheckUserName2> METHOD_LOG_OUT =
      io.grpc.MethodDescriptor.<ir.ms.pb.PB_UserParam_CheckUserName2, ir.ms.pb.PB_UserResponse_CheckUserName2>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "RPC_Auth", "LogOut"))
          .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserParam_CheckUserName2.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
              ir.ms.pb.PB_UserResponse_CheckUserName2.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPC_AuthStub newStub(io.grpc.Channel channel) {
    return new RPC_AuthStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPC_AuthBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPC_AuthBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPC_AuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPC_AuthFutureStub(channel);
  }

  /**
   */
  public static abstract class RPC_AuthImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkPhone(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECK_PHONE, responseObserver);
    }

    /**
     */
    public void sendCode(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_CODE, responseObserver);
    }

    /**
     */
    public void sendCodeToSms(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_CODE_TO_SMS, responseObserver);
    }

    /**
     */
    public void sendCodeToTelgram(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_CODE_TO_TELGRAM, responseObserver);
    }

    /**
     */
    public void singUp(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SING_UP, responseObserver);
    }

    /**
     */
    public void singIn(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SING_IN, responseObserver);
    }

    /**
     */
    public void logOut(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOG_OUT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CHECK_PHONE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_CHECK_PHONE)))
          .addMethod(
            METHOD_SEND_CODE,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_SEND_CODE)))
          .addMethod(
            METHOD_SEND_CODE_TO_SMS,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_SEND_CODE_TO_SMS)))
          .addMethod(
            METHOD_SEND_CODE_TO_TELGRAM,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_SEND_CODE_TO_TELGRAM)))
          .addMethod(
            METHOD_SING_UP,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_SING_UP)))
          .addMethod(
            METHOD_SING_IN,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_SING_IN)))
          .addMethod(
            METHOD_LOG_OUT,
            asyncUnaryCall(
              new MethodHandlers<
                ir.ms.pb.PB_UserParam_CheckUserName2,
                ir.ms.pb.PB_UserResponse_CheckUserName2>(
                  this, METHODID_LOG_OUT)))
          .build();
    }
  }

  /**
   */
  public static final class RPC_AuthStub extends io.grpc.stub.AbstractStub<RPC_AuthStub> {
    private RPC_AuthStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_AuthStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_AuthStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_AuthStub(channel, callOptions);
    }

    /**
     */
    public void checkPhone(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECK_PHONE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendCode(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_CODE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendCodeToSms(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_CODE_TO_SMS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendCodeToTelgram(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_CODE_TO_TELGRAM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void singUp(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SING_UP, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void singIn(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SING_IN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logOut(ir.ms.pb.PB_UserParam_CheckUserName2 request,
        io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOG_OUT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPC_AuthBlockingStub extends io.grpc.stub.AbstractStub<RPC_AuthBlockingStub> {
    private RPC_AuthBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_AuthBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_AuthBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_AuthBlockingStub(channel, callOptions);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 checkPhone(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECK_PHONE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 sendCode(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_CODE, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 sendCodeToSms(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_CODE_TO_SMS, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 sendCodeToTelgram(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_CODE_TO_TELGRAM, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 singUp(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SING_UP, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 singIn(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SING_IN, getCallOptions(), request);
    }

    /**
     */
    public ir.ms.pb.PB_UserResponse_CheckUserName2 logOut(ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOG_OUT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPC_AuthFutureStub extends io.grpc.stub.AbstractStub<RPC_AuthFutureStub> {
    private RPC_AuthFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPC_AuthFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPC_AuthFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPC_AuthFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> checkPhone(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECK_PHONE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> sendCode(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_CODE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> sendCodeToSms(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_CODE_TO_SMS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> sendCodeToTelgram(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_CODE_TO_TELGRAM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> singUp(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SING_UP, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> singIn(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SING_IN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ir.ms.pb.PB_UserResponse_CheckUserName2> logOut(
        ir.ms.pb.PB_UserParam_CheckUserName2 request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOG_OUT, getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_PHONE = 0;
  private static final int METHODID_SEND_CODE = 1;
  private static final int METHODID_SEND_CODE_TO_SMS = 2;
  private static final int METHODID_SEND_CODE_TO_TELGRAM = 3;
  private static final int METHODID_SING_UP = 4;
  private static final int METHODID_SING_IN = 5;
  private static final int METHODID_LOG_OUT = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPC_AuthImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPC_AuthImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_PHONE:
          serviceImpl.checkPhone((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
          break;
        case METHODID_SEND_CODE:
          serviceImpl.sendCode((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
          break;
        case METHODID_SEND_CODE_TO_SMS:
          serviceImpl.sendCodeToSms((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
          break;
        case METHODID_SEND_CODE_TO_TELGRAM:
          serviceImpl.sendCodeToTelgram((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
          break;
        case METHODID_SING_UP:
          serviceImpl.singUp((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
          break;
        case METHODID_SING_IN:
          serviceImpl.singIn((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
          break;
        case METHODID_LOG_OUT:
          serviceImpl.logOut((ir.ms.pb.PB_UserParam_CheckUserName2) request,
              (io.grpc.stub.StreamObserver<ir.ms.pb.PB_UserResponse_CheckUserName2>) responseObserver);
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
      synchronized (RPC_AuthGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_CHECK_PHONE)
              .addMethod(METHOD_SEND_CODE)
              .addMethod(METHOD_SEND_CODE_TO_SMS)
              .addMethod(METHOD_SEND_CODE_TO_TELGRAM)
              .addMethod(METHOD_SING_UP)
              .addMethod(METHOD_SING_IN)
              .addMethod(METHOD_LOG_OUT)
              .build();
        }
      }
    }
    return result;
  }
}
