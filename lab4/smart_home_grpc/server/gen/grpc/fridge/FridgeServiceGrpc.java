package grpc.fridge;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: fridge.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FridgeServiceGrpc {

  private FridgeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "fridge.FridgeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.fridge.FridgeTemperatureRequest,
      grpc.fridge.FridgeResponse> getSetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetTemperature",
      requestType = grpc.fridge.FridgeTemperatureRequest.class,
      responseType = grpc.fridge.FridgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.fridge.FridgeTemperatureRequest,
      grpc.fridge.FridgeResponse> getSetTemperatureMethod() {
    io.grpc.MethodDescriptor<grpc.fridge.FridgeTemperatureRequest, grpc.fridge.FridgeResponse> getSetTemperatureMethod;
    if ((getSetTemperatureMethod = FridgeServiceGrpc.getSetTemperatureMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getSetTemperatureMethod = FridgeServiceGrpc.getSetTemperatureMethod) == null) {
          FridgeServiceGrpc.getSetTemperatureMethod = getSetTemperatureMethod =
              io.grpc.MethodDescriptor.<grpc.fridge.FridgeTemperatureRequest, grpc.fridge.FridgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.fridge.FridgeTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.fridge.FridgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("SetTemperature"))
              .build();
        }
      }
    }
    return getSetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.fridge.FridgeToggleRequest,
      grpc.fridge.FridgeResponse> getSetPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetPower",
      requestType = grpc.fridge.FridgeToggleRequest.class,
      responseType = grpc.fridge.FridgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.fridge.FridgeToggleRequest,
      grpc.fridge.FridgeResponse> getSetPowerMethod() {
    io.grpc.MethodDescriptor<grpc.fridge.FridgeToggleRequest, grpc.fridge.FridgeResponse> getSetPowerMethod;
    if ((getSetPowerMethod = FridgeServiceGrpc.getSetPowerMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getSetPowerMethod = FridgeServiceGrpc.getSetPowerMethod) == null) {
          FridgeServiceGrpc.getSetPowerMethod = getSetPowerMethod =
              io.grpc.MethodDescriptor.<grpc.fridge.FridgeToggleRequest, grpc.fridge.FridgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.fridge.FridgeToggleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.fridge.FridgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("SetPower"))
              .build();
        }
      }
    }
    return getSetPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.fridge.FridgeInfoRequest,
      grpc.fridge.FridgeInfoResponse> getGetInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInfo",
      requestType = grpc.fridge.FridgeInfoRequest.class,
      responseType = grpc.fridge.FridgeInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.fridge.FridgeInfoRequest,
      grpc.fridge.FridgeInfoResponse> getGetInfoMethod() {
    io.grpc.MethodDescriptor<grpc.fridge.FridgeInfoRequest, grpc.fridge.FridgeInfoResponse> getGetInfoMethod;
    if ((getGetInfoMethod = FridgeServiceGrpc.getGetInfoMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getGetInfoMethod = FridgeServiceGrpc.getGetInfoMethod) == null) {
          FridgeServiceGrpc.getGetInfoMethod = getGetInfoMethod =
              io.grpc.MethodDescriptor.<grpc.fridge.FridgeInfoRequest, grpc.fridge.FridgeInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.fridge.FridgeInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.fridge.FridgeInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("GetInfo"))
              .build();
        }
      }
    }
    return getGetInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FridgeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceStub>() {
        @java.lang.Override
        public FridgeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceStub(channel, callOptions);
        }
      };
    return FridgeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FridgeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceBlockingStub>() {
        @java.lang.Override
        public FridgeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceBlockingStub(channel, callOptions);
        }
      };
    return FridgeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FridgeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceFutureStub>() {
        @java.lang.Override
        public FridgeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceFutureStub(channel, callOptions);
        }
      };
    return FridgeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void setTemperature(grpc.fridge.FridgeTemperatureRequest request,
        io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTemperatureMethod(), responseObserver);
    }

    /**
     */
    default void setPower(grpc.fridge.FridgeToggleRequest request,
        io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetPowerMethod(), responseObserver);
    }

    /**
     */
    default void getInfo(grpc.fridge.FridgeInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.fridge.FridgeInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FridgeService.
   */
  public static abstract class FridgeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FridgeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FridgeService.
   */
  public static final class FridgeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FridgeServiceStub> {
    private FridgeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceStub(channel, callOptions);
    }

    /**
     */
    public void setTemperature(grpc.fridge.FridgeTemperatureRequest request,
        io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setPower(grpc.fridge.FridgeToggleRequest request,
        io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getInfo(grpc.fridge.FridgeInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.fridge.FridgeInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FridgeService.
   */
  public static final class FridgeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FridgeServiceBlockingStub> {
    private FridgeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.fridge.FridgeResponse setTemperature(grpc.fridge.FridgeTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.fridge.FridgeResponse setPower(grpc.fridge.FridgeToggleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetPowerMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.fridge.FridgeInfoResponse getInfo(grpc.fridge.FridgeInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FridgeService.
   */
  public static final class FridgeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FridgeServiceFutureStub> {
    private FridgeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fridge.FridgeResponse> setTemperature(
        grpc.fridge.FridgeTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fridge.FridgeResponse> setPower(
        grpc.fridge.FridgeToggleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetPowerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.fridge.FridgeInfoResponse> getInfo(
        grpc.fridge.FridgeInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TEMPERATURE = 0;
  private static final int METHODID_SET_POWER = 1;
  private static final int METHODID_GET_INFO = 2;

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
        case METHODID_SET_TEMPERATURE:
          serviceImpl.setTemperature((grpc.fridge.FridgeTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse>) responseObserver);
          break;
        case METHODID_SET_POWER:
          serviceImpl.setPower((grpc.fridge.FridgeToggleRequest) request,
              (io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse>) responseObserver);
          break;
        case METHODID_GET_INFO:
          serviceImpl.getInfo((grpc.fridge.FridgeInfoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.fridge.FridgeInfoResponse>) responseObserver);
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
          getSetTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.fridge.FridgeTemperatureRequest,
              grpc.fridge.FridgeResponse>(
                service, METHODID_SET_TEMPERATURE)))
        .addMethod(
          getSetPowerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.fridge.FridgeToggleRequest,
              grpc.fridge.FridgeResponse>(
                service, METHODID_SET_POWER)))
        .addMethod(
          getGetInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.fridge.FridgeInfoRequest,
              grpc.fridge.FridgeInfoResponse>(
                service, METHODID_GET_INFO)))
        .build();
  }

  private static abstract class FridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FridgeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.fridge.FridgeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FridgeService");
    }
  }

  private static final class FridgeServiceFileDescriptorSupplier
      extends FridgeServiceBaseDescriptorSupplier {
    FridgeServiceFileDescriptorSupplier() {}
  }

  private static final class FridgeServiceMethodDescriptorSupplier
      extends FridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FridgeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FridgeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FridgeServiceFileDescriptorSupplier())
              .addMethod(getSetTemperatureMethod())
              .addMethod(getSetPowerMethod())
              .addMethod(getGetInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
