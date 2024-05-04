package grpc.lamp;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: lamp.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LampServiceGrpc {

  private LampServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "lamp.LampService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.lamp.LampRequest,
      grpc.lamp.LampResponse> getSetLampMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLamp",
      requestType = grpc.lamp.LampRequest.class,
      responseType = grpc.lamp.LampResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.lamp.LampRequest,
      grpc.lamp.LampResponse> getSetLampMethod() {
    io.grpc.MethodDescriptor<grpc.lamp.LampRequest, grpc.lamp.LampResponse> getSetLampMethod;
    if ((getSetLampMethod = LampServiceGrpc.getSetLampMethod) == null) {
      synchronized (LampServiceGrpc.class) {
        if ((getSetLampMethod = LampServiceGrpc.getSetLampMethod) == null) {
          LampServiceGrpc.getSetLampMethod = getSetLampMethod =
              io.grpc.MethodDescriptor.<grpc.lamp.LampRequest, grpc.lamp.LampResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetLamp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.lamp.LampRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.lamp.LampResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LampServiceMethodDescriptorSupplier("SetLamp"))
              .build();
        }
      }
    }
    return getSetLampMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.lamp.LampInfoRequest,
      grpc.lamp.LampInfoResponse> getGetInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInfo",
      requestType = grpc.lamp.LampInfoRequest.class,
      responseType = grpc.lamp.LampInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.lamp.LampInfoRequest,
      grpc.lamp.LampInfoResponse> getGetInfoMethod() {
    io.grpc.MethodDescriptor<grpc.lamp.LampInfoRequest, grpc.lamp.LampInfoResponse> getGetInfoMethod;
    if ((getGetInfoMethod = LampServiceGrpc.getGetInfoMethod) == null) {
      synchronized (LampServiceGrpc.class) {
        if ((getGetInfoMethod = LampServiceGrpc.getGetInfoMethod) == null) {
          LampServiceGrpc.getGetInfoMethod = getGetInfoMethod =
              io.grpc.MethodDescriptor.<grpc.lamp.LampInfoRequest, grpc.lamp.LampInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.lamp.LampInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.lamp.LampInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LampServiceMethodDescriptorSupplier("GetInfo"))
              .build();
        }
      }
    }
    return getGetInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LampServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LampServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LampServiceStub>() {
        @java.lang.Override
        public LampServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LampServiceStub(channel, callOptions);
        }
      };
    return LampServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LampServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LampServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LampServiceBlockingStub>() {
        @java.lang.Override
        public LampServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LampServiceBlockingStub(channel, callOptions);
        }
      };
    return LampServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LampServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LampServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LampServiceFutureStub>() {
        @java.lang.Override
        public LampServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LampServiceFutureStub(channel, callOptions);
        }
      };
    return LampServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void setLamp(grpc.lamp.LampRequest request,
        io.grpc.stub.StreamObserver<grpc.lamp.LampResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetLampMethod(), responseObserver);
    }

    /**
     */
    default void getInfo(grpc.lamp.LampInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.lamp.LampInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LampService.
   */
  public static abstract class LampServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LampServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LampService.
   */
  public static final class LampServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LampServiceStub> {
    private LampServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LampServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LampServiceStub(channel, callOptions);
    }

    /**
     */
    public void setLamp(grpc.lamp.LampRequest request,
        io.grpc.stub.StreamObserver<grpc.lamp.LampResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetLampMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getInfo(grpc.lamp.LampInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.lamp.LampInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LampService.
   */
  public static final class LampServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LampServiceBlockingStub> {
    private LampServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LampServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LampServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.lamp.LampResponse setLamp(grpc.lamp.LampRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetLampMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.lamp.LampInfoResponse getInfo(grpc.lamp.LampInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LampService.
   */
  public static final class LampServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LampServiceFutureStub> {
    private LampServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LampServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LampServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.lamp.LampResponse> setLamp(
        grpc.lamp.LampRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetLampMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.lamp.LampInfoResponse> getInfo(
        grpc.lamp.LampInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_LAMP = 0;
  private static final int METHODID_GET_INFO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_LAMP:
          serviceImpl.setLamp((grpc.lamp.LampRequest) request,
              (io.grpc.stub.StreamObserver<grpc.lamp.LampResponse>) responseObserver);
          break;
        case METHODID_GET_INFO:
          serviceImpl.getInfo((grpc.lamp.LampInfoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.lamp.LampInfoResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSetLampMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.lamp.LampRequest,
              grpc.lamp.LampResponse>(
                service, METHODID_SET_LAMP)))
        .addMethod(
          getGetInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.lamp.LampInfoRequest,
              grpc.lamp.LampInfoResponse>(
                service, METHODID_GET_INFO)))
        .build();
  }

  private static abstract class LampServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LampServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.lamp.LampProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LampService");
    }
  }

  private static final class LampServiceFileDescriptorSupplier
      extends LampServiceBaseDescriptorSupplier {
    LampServiceFileDescriptorSupplier() {}
  }

  private static final class LampServiceMethodDescriptorSupplier
      extends LampServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LampServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LampServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LampServiceFileDescriptorSupplier())
              .addMethod(getSetLampMethod())
              .addMethod(getGetInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
