package grpc.camera;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: camera.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CameraServiceGrpc {

  private CameraServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "camera.CameraService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.camera.SwitchRequest,
      grpc.camera.CameraResponse> getCameraSwitchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CameraSwitch",
      requestType = grpc.camera.SwitchRequest.class,
      responseType = grpc.camera.CameraResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.camera.SwitchRequest,
      grpc.camera.CameraResponse> getCameraSwitchMethod() {
    io.grpc.MethodDescriptor<grpc.camera.SwitchRequest, grpc.camera.CameraResponse> getCameraSwitchMethod;
    if ((getCameraSwitchMethod = CameraServiceGrpc.getCameraSwitchMethod) == null) {
      synchronized (CameraServiceGrpc.class) {
        if ((getCameraSwitchMethod = CameraServiceGrpc.getCameraSwitchMethod) == null) {
          CameraServiceGrpc.getCameraSwitchMethod = getCameraSwitchMethod =
              io.grpc.MethodDescriptor.<grpc.camera.SwitchRequest, grpc.camera.CameraResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CameraSwitch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.SwitchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CameraServiceMethodDescriptorSupplier("CameraSwitch"))
              .build();
        }
      }
    }
    return getCameraSwitchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.camera.CameraResolutionRequest,
      grpc.camera.CameraResponse> getSetResolutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetResolution",
      requestType = grpc.camera.CameraResolutionRequest.class,
      responseType = grpc.camera.CameraResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.camera.CameraResolutionRequest,
      grpc.camera.CameraResponse> getSetResolutionMethod() {
    io.grpc.MethodDescriptor<grpc.camera.CameraResolutionRequest, grpc.camera.CameraResponse> getSetResolutionMethod;
    if ((getSetResolutionMethod = CameraServiceGrpc.getSetResolutionMethod) == null) {
      synchronized (CameraServiceGrpc.class) {
        if ((getSetResolutionMethod = CameraServiceGrpc.getSetResolutionMethod) == null) {
          CameraServiceGrpc.getSetResolutionMethod = getSetResolutionMethod =
              io.grpc.MethodDescriptor.<grpc.camera.CameraResolutionRequest, grpc.camera.CameraResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetResolution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraResolutionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CameraServiceMethodDescriptorSupplier("SetResolution"))
              .build();
        }
      }
    }
    return getSetResolutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.camera.CameraRotateRequest,
      grpc.camera.CameraResponse> getRotateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rotate",
      requestType = grpc.camera.CameraRotateRequest.class,
      responseType = grpc.camera.CameraResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.camera.CameraRotateRequest,
      grpc.camera.CameraResponse> getRotateMethod() {
    io.grpc.MethodDescriptor<grpc.camera.CameraRotateRequest, grpc.camera.CameraResponse> getRotateMethod;
    if ((getRotateMethod = CameraServiceGrpc.getRotateMethod) == null) {
      synchronized (CameraServiceGrpc.class) {
        if ((getRotateMethod = CameraServiceGrpc.getRotateMethod) == null) {
          CameraServiceGrpc.getRotateMethod = getRotateMethod =
              io.grpc.MethodDescriptor.<grpc.camera.CameraRotateRequest, grpc.camera.CameraResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Rotate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraRotateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CameraServiceMethodDescriptorSupplier("Rotate"))
              .build();
        }
      }
    }
    return getRotateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.camera.CameraZoomRequest,
      grpc.camera.CameraResponse> getZoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Zoom",
      requestType = grpc.camera.CameraZoomRequest.class,
      responseType = grpc.camera.CameraResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.camera.CameraZoomRequest,
      grpc.camera.CameraResponse> getZoomMethod() {
    io.grpc.MethodDescriptor<grpc.camera.CameraZoomRequest, grpc.camera.CameraResponse> getZoomMethod;
    if ((getZoomMethod = CameraServiceGrpc.getZoomMethod) == null) {
      synchronized (CameraServiceGrpc.class) {
        if ((getZoomMethod = CameraServiceGrpc.getZoomMethod) == null) {
          CameraServiceGrpc.getZoomMethod = getZoomMethod =
              io.grpc.MethodDescriptor.<grpc.camera.CameraZoomRequest, grpc.camera.CameraResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Zoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraZoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CameraServiceMethodDescriptorSupplier("Zoom"))
              .build();
        }
      }
    }
    return getZoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.camera.CameraInfoRequest,
      grpc.camera.CameraInfoResponse> getGetInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInfo",
      requestType = grpc.camera.CameraInfoRequest.class,
      responseType = grpc.camera.CameraInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.camera.CameraInfoRequest,
      grpc.camera.CameraInfoResponse> getGetInfoMethod() {
    io.grpc.MethodDescriptor<grpc.camera.CameraInfoRequest, grpc.camera.CameraInfoResponse> getGetInfoMethod;
    if ((getGetInfoMethod = CameraServiceGrpc.getGetInfoMethod) == null) {
      synchronized (CameraServiceGrpc.class) {
        if ((getGetInfoMethod = CameraServiceGrpc.getGetInfoMethod) == null) {
          CameraServiceGrpc.getGetInfoMethod = getGetInfoMethod =
              io.grpc.MethodDescriptor.<grpc.camera.CameraInfoRequest, grpc.camera.CameraInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.camera.CameraInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CameraServiceMethodDescriptorSupplier("GetInfo"))
              .build();
        }
      }
    }
    return getGetInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CameraServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CameraServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CameraServiceStub>() {
        @java.lang.Override
        public CameraServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CameraServiceStub(channel, callOptions);
        }
      };
    return CameraServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CameraServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CameraServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CameraServiceBlockingStub>() {
        @java.lang.Override
        public CameraServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CameraServiceBlockingStub(channel, callOptions);
        }
      };
    return CameraServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CameraServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CameraServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CameraServiceFutureStub>() {
        @java.lang.Override
        public CameraServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CameraServiceFutureStub(channel, callOptions);
        }
      };
    return CameraServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void cameraSwitch(grpc.camera.SwitchRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCameraSwitchMethod(), responseObserver);
    }

    /**
     */
    default void setResolution(grpc.camera.CameraResolutionRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetResolutionMethod(), responseObserver);
    }

    /**
     */
    default void rotate(grpc.camera.CameraRotateRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRotateMethod(), responseObserver);
    }

    /**
     */
    default void zoom(grpc.camera.CameraZoomRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getZoomMethod(), responseObserver);
    }

    /**
     */
    default void getInfo(grpc.camera.CameraInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CameraService.
   */
  public static abstract class CameraServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CameraServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CameraService.
   */
  public static final class CameraServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CameraServiceStub> {
    private CameraServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CameraServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CameraServiceStub(channel, callOptions);
    }

    /**
     */
    public void cameraSwitch(grpc.camera.SwitchRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCameraSwitchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setResolution(grpc.camera.CameraResolutionRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetResolutionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rotate(grpc.camera.CameraRotateRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRotateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void zoom(grpc.camera.CameraZoomRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getZoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getInfo(grpc.camera.CameraInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.camera.CameraInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CameraService.
   */
  public static final class CameraServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CameraServiceBlockingStub> {
    private CameraServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CameraServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CameraServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.camera.CameraResponse cameraSwitch(grpc.camera.SwitchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCameraSwitchMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.camera.CameraResponse setResolution(grpc.camera.CameraResolutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetResolutionMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.camera.CameraResponse rotate(grpc.camera.CameraRotateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRotateMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.camera.CameraResponse zoom(grpc.camera.CameraZoomRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getZoomMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.camera.CameraInfoResponse getInfo(grpc.camera.CameraInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CameraService.
   */
  public static final class CameraServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CameraServiceFutureStub> {
    private CameraServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CameraServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CameraServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.camera.CameraResponse> cameraSwitch(
        grpc.camera.SwitchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCameraSwitchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.camera.CameraResponse> setResolution(
        grpc.camera.CameraResolutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetResolutionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.camera.CameraResponse> rotate(
        grpc.camera.CameraRotateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRotateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.camera.CameraResponse> zoom(
        grpc.camera.CameraZoomRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getZoomMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.camera.CameraInfoResponse> getInfo(
        grpc.camera.CameraInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CAMERA_SWITCH = 0;
  private static final int METHODID_SET_RESOLUTION = 1;
  private static final int METHODID_ROTATE = 2;
  private static final int METHODID_ZOOM = 3;
  private static final int METHODID_GET_INFO = 4;

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
        case METHODID_CAMERA_SWITCH:
          serviceImpl.cameraSwitch((grpc.camera.SwitchRequest) request,
              (io.grpc.stub.StreamObserver<grpc.camera.CameraResponse>) responseObserver);
          break;
        case METHODID_SET_RESOLUTION:
          serviceImpl.setResolution((grpc.camera.CameraResolutionRequest) request,
              (io.grpc.stub.StreamObserver<grpc.camera.CameraResponse>) responseObserver);
          break;
        case METHODID_ROTATE:
          serviceImpl.rotate((grpc.camera.CameraRotateRequest) request,
              (io.grpc.stub.StreamObserver<grpc.camera.CameraResponse>) responseObserver);
          break;
        case METHODID_ZOOM:
          serviceImpl.zoom((grpc.camera.CameraZoomRequest) request,
              (io.grpc.stub.StreamObserver<grpc.camera.CameraResponse>) responseObserver);
          break;
        case METHODID_GET_INFO:
          serviceImpl.getInfo((grpc.camera.CameraInfoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.camera.CameraInfoResponse>) responseObserver);
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
          getCameraSwitchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.camera.SwitchRequest,
              grpc.camera.CameraResponse>(
                service, METHODID_CAMERA_SWITCH)))
        .addMethod(
          getSetResolutionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.camera.CameraResolutionRequest,
              grpc.camera.CameraResponse>(
                service, METHODID_SET_RESOLUTION)))
        .addMethod(
          getRotateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.camera.CameraRotateRequest,
              grpc.camera.CameraResponse>(
                service, METHODID_ROTATE)))
        .addMethod(
          getZoomMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.camera.CameraZoomRequest,
              grpc.camera.CameraResponse>(
                service, METHODID_ZOOM)))
        .addMethod(
          getGetInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.camera.CameraInfoRequest,
              grpc.camera.CameraInfoResponse>(
                service, METHODID_GET_INFO)))
        .build();
  }

  private static abstract class CameraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CameraServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.camera.CameraProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CameraService");
    }
  }

  private static final class CameraServiceFileDescriptorSupplier
      extends CameraServiceBaseDescriptorSupplier {
    CameraServiceFileDescriptorSupplier() {}
  }

  private static final class CameraServiceMethodDescriptorSupplier
      extends CameraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CameraServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CameraServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CameraServiceFileDescriptorSupplier())
              .addMethod(getCameraSwitchMethod())
              .addMethod(getSetResolutionMethod())
              .addMethod(getRotateMethod())
              .addMethod(getZoomMethod())
              .addMethod(getGetInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
