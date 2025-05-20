package org.ebook;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * This defines the service and its methods
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.0)",
    comments = "Source: License.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LicenseServiceGrpc {

  private LicenseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "org.ebook.LicenseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.ebook.LicenseProto.CreateLicenseRequest,
      org.ebook.LicenseProto.CreateLicenseResponse> getCreateLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLicense",
      requestType = org.ebook.LicenseProto.CreateLicenseRequest.class,
      responseType = org.ebook.LicenseProto.CreateLicenseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.ebook.LicenseProto.CreateLicenseRequest,
      org.ebook.LicenseProto.CreateLicenseResponse> getCreateLicenseMethod() {
    io.grpc.MethodDescriptor<org.ebook.LicenseProto.CreateLicenseRequest, org.ebook.LicenseProto.CreateLicenseResponse> getCreateLicenseMethod;
    if ((getCreateLicenseMethod = LicenseServiceGrpc.getCreateLicenseMethod) == null) {
      synchronized (LicenseServiceGrpc.class) {
        if ((getCreateLicenseMethod = LicenseServiceGrpc.getCreateLicenseMethod) == null) {
          LicenseServiceGrpc.getCreateLicenseMethod = getCreateLicenseMethod =
              io.grpc.MethodDescriptor.<org.ebook.LicenseProto.CreateLicenseRequest, org.ebook.LicenseProto.CreateLicenseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLicense"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.ebook.LicenseProto.CreateLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.ebook.LicenseProto.CreateLicenseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LicenseServiceMethodDescriptorSupplier("CreateLicense"))
              .build();
        }
      }
    }
    return getCreateLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.ebook.LicenseProto.ReadLicenseRequest,
      org.ebook.LicenseProto.ReadLicenseResponse> getReadLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadLicense",
      requestType = org.ebook.LicenseProto.ReadLicenseRequest.class,
      responseType = org.ebook.LicenseProto.ReadLicenseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.ebook.LicenseProto.ReadLicenseRequest,
      org.ebook.LicenseProto.ReadLicenseResponse> getReadLicenseMethod() {
    io.grpc.MethodDescriptor<org.ebook.LicenseProto.ReadLicenseRequest, org.ebook.LicenseProto.ReadLicenseResponse> getReadLicenseMethod;
    if ((getReadLicenseMethod = LicenseServiceGrpc.getReadLicenseMethod) == null) {
      synchronized (LicenseServiceGrpc.class) {
        if ((getReadLicenseMethod = LicenseServiceGrpc.getReadLicenseMethod) == null) {
          LicenseServiceGrpc.getReadLicenseMethod = getReadLicenseMethod =
              io.grpc.MethodDescriptor.<org.ebook.LicenseProto.ReadLicenseRequest, org.ebook.LicenseProto.ReadLicenseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadLicense"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.ebook.LicenseProto.ReadLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.ebook.LicenseProto.ReadLicenseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LicenseServiceMethodDescriptorSupplier("ReadLicense"))
              .build();
        }
      }
    }
    return getReadLicenseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.ebook.LicenseProto.TransferLicenseRequest,
      org.ebook.LicenseProto.TransferLicenseResponse> getTransferLicenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferLicense",
      requestType = org.ebook.LicenseProto.TransferLicenseRequest.class,
      responseType = org.ebook.LicenseProto.TransferLicenseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.ebook.LicenseProto.TransferLicenseRequest,
      org.ebook.LicenseProto.TransferLicenseResponse> getTransferLicenseMethod() {
    io.grpc.MethodDescriptor<org.ebook.LicenseProto.TransferLicenseRequest, org.ebook.LicenseProto.TransferLicenseResponse> getTransferLicenseMethod;
    if ((getTransferLicenseMethod = LicenseServiceGrpc.getTransferLicenseMethod) == null) {
      synchronized (LicenseServiceGrpc.class) {
        if ((getTransferLicenseMethod = LicenseServiceGrpc.getTransferLicenseMethod) == null) {
          LicenseServiceGrpc.getTransferLicenseMethod = getTransferLicenseMethod =
              io.grpc.MethodDescriptor.<org.ebook.LicenseProto.TransferLicenseRequest, org.ebook.LicenseProto.TransferLicenseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TransferLicense"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.ebook.LicenseProto.TransferLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.ebook.LicenseProto.TransferLicenseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LicenseServiceMethodDescriptorSupplier("TransferLicense"))
              .build();
        }
      }
    }
    return getTransferLicenseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LicenseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LicenseServiceStub>() {
        @java.lang.Override
        public LicenseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LicenseServiceStub(channel, callOptions);
        }
      };
    return LicenseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LicenseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LicenseServiceBlockingStub>() {
        @java.lang.Override
        public LicenseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LicenseServiceBlockingStub(channel, callOptions);
        }
      };
    return LicenseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LicenseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LicenseServiceFutureStub>() {
        @java.lang.Override
        public LicenseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LicenseServiceFutureStub(channel, callOptions);
        }
      };
    return LicenseServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * This defines the service and its methods
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createLicense(org.ebook.LicenseProto.CreateLicenseRequest request,
        io.grpc.stub.StreamObserver<org.ebook.LicenseProto.CreateLicenseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLicenseMethod(), responseObserver);
    }

    /**
     */
    default void readLicense(org.ebook.LicenseProto.ReadLicenseRequest request,
        io.grpc.stub.StreamObserver<org.ebook.LicenseProto.ReadLicenseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadLicenseMethod(), responseObserver);
    }

    /**
     */
    default void transferLicense(org.ebook.LicenseProto.TransferLicenseRequest request,
        io.grpc.stub.StreamObserver<org.ebook.LicenseProto.TransferLicenseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransferLicenseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LicenseService.
   * <pre>
   * This defines the service and its methods
   * </pre>
   */
  public static abstract class LicenseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LicenseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LicenseService.
   * <pre>
   * This defines the service and its methods
   * </pre>
   */
  public static final class LicenseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LicenseServiceStub> {
    private LicenseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseServiceStub(channel, callOptions);
    }

    /**
     */
    public void createLicense(org.ebook.LicenseProto.CreateLicenseRequest request,
        io.grpc.stub.StreamObserver<org.ebook.LicenseProto.CreateLicenseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLicenseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readLicense(org.ebook.LicenseProto.ReadLicenseRequest request,
        io.grpc.stub.StreamObserver<org.ebook.LicenseProto.ReadLicenseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadLicenseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transferLicense(org.ebook.LicenseProto.TransferLicenseRequest request,
        io.grpc.stub.StreamObserver<org.ebook.LicenseProto.TransferLicenseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransferLicenseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LicenseService.
   * <pre>
   * This defines the service and its methods
   * </pre>
   */
  public static final class LicenseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LicenseServiceBlockingStub> {
    private LicenseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.ebook.LicenseProto.CreateLicenseResponse createLicense(org.ebook.LicenseProto.CreateLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLicenseMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.ebook.LicenseProto.ReadLicenseResponse readLicense(org.ebook.LicenseProto.ReadLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadLicenseMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.ebook.LicenseProto.TransferLicenseResponse transferLicense(org.ebook.LicenseProto.TransferLicenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransferLicenseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LicenseService.
   * <pre>
   * This defines the service and its methods
   * </pre>
   */
  public static final class LicenseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LicenseServiceFutureStub> {
    private LicenseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.ebook.LicenseProto.CreateLicenseResponse> createLicense(
        org.ebook.LicenseProto.CreateLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLicenseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.ebook.LicenseProto.ReadLicenseResponse> readLicense(
        org.ebook.LicenseProto.ReadLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadLicenseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.ebook.LicenseProto.TransferLicenseResponse> transferLicense(
        org.ebook.LicenseProto.TransferLicenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransferLicenseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_LICENSE = 0;
  private static final int METHODID_READ_LICENSE = 1;
  private static final int METHODID_TRANSFER_LICENSE = 2;

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
        case METHODID_CREATE_LICENSE:
          serviceImpl.createLicense((org.ebook.LicenseProto.CreateLicenseRequest) request,
              (io.grpc.stub.StreamObserver<org.ebook.LicenseProto.CreateLicenseResponse>) responseObserver);
          break;
        case METHODID_READ_LICENSE:
          serviceImpl.readLicense((org.ebook.LicenseProto.ReadLicenseRequest) request,
              (io.grpc.stub.StreamObserver<org.ebook.LicenseProto.ReadLicenseResponse>) responseObserver);
          break;
        case METHODID_TRANSFER_LICENSE:
          serviceImpl.transferLicense((org.ebook.LicenseProto.TransferLicenseRequest) request,
              (io.grpc.stub.StreamObserver<org.ebook.LicenseProto.TransferLicenseResponse>) responseObserver);
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
          getCreateLicenseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.ebook.LicenseProto.CreateLicenseRequest,
              org.ebook.LicenseProto.CreateLicenseResponse>(
                service, METHODID_CREATE_LICENSE)))
        .addMethod(
          getReadLicenseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.ebook.LicenseProto.ReadLicenseRequest,
              org.ebook.LicenseProto.ReadLicenseResponse>(
                service, METHODID_READ_LICENSE)))
        .addMethod(
          getTransferLicenseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.ebook.LicenseProto.TransferLicenseRequest,
              org.ebook.LicenseProto.TransferLicenseResponse>(
                service, METHODID_TRANSFER_LICENSE)))
        .build();
  }

  private static abstract class LicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LicenseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.ebook.LicenseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LicenseService");
    }
  }

  private static final class LicenseServiceFileDescriptorSupplier
      extends LicenseServiceBaseDescriptorSupplier {
    LicenseServiceFileDescriptorSupplier() {}
  }

  private static final class LicenseServiceMethodDescriptorSupplier
      extends LicenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LicenseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LicenseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LicenseServiceFileDescriptorSupplier())
              .addMethod(getCreateLicenseMethod())
              .addMethod(getReadLicenseMethod())
              .addMethod(getTransferLicenseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
