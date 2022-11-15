package com.grpccache.cacheapi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cacheapihandler.proto")
public final class CacheApiHandlerGrpc {

  private CacheApiHandlerGrpc() {}

  public static final String SERVICE_NAME = "cacheapi.CacheApiHandler";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpccache.cacheapi.KeyRequest,
      com.grpccache.cacheapi.ValueReply> getGetValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getValue",
      requestType = com.grpccache.cacheapi.KeyRequest.class,
      responseType = com.grpccache.cacheapi.ValueReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpccache.cacheapi.KeyRequest,
      com.grpccache.cacheapi.ValueReply> getGetValueMethod() {
    io.grpc.MethodDescriptor<com.grpccache.cacheapi.KeyRequest, com.grpccache.cacheapi.ValueReply> getGetValueMethod;
    if ((getGetValueMethod = CacheApiHandlerGrpc.getGetValueMethod) == null) {
      synchronized (CacheApiHandlerGrpc.class) {
        if ((getGetValueMethod = CacheApiHandlerGrpc.getGetValueMethod) == null) {
          CacheApiHandlerGrpc.getGetValueMethod = getGetValueMethod =
              io.grpc.MethodDescriptor.<com.grpccache.cacheapi.KeyRequest, com.grpccache.cacheapi.ValueReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpccache.cacheapi.KeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpccache.cacheapi.ValueReply.getDefaultInstance()))
              .setSchemaDescriptor(new CacheApiHandlerMethodDescriptorSupplier("getValue"))
              .build();
        }
      }
    }
    return getGetValueMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CacheApiHandlerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CacheApiHandlerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CacheApiHandlerStub>() {
        @java.lang.Override
        public CacheApiHandlerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CacheApiHandlerStub(channel, callOptions);
        }
      };
    return CacheApiHandlerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CacheApiHandlerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CacheApiHandlerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CacheApiHandlerBlockingStub>() {
        @java.lang.Override
        public CacheApiHandlerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CacheApiHandlerBlockingStub(channel, callOptions);
        }
      };
    return CacheApiHandlerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CacheApiHandlerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CacheApiHandlerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CacheApiHandlerFutureStub>() {
        @java.lang.Override
        public CacheApiHandlerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CacheApiHandlerFutureStub(channel, callOptions);
        }
      };
    return CacheApiHandlerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CacheApiHandlerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getValue(com.grpccache.cacheapi.KeyRequest request,
        io.grpc.stub.StreamObserver<com.grpccache.cacheapi.ValueReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetValueMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpccache.cacheapi.KeyRequest,
                com.grpccache.cacheapi.ValueReply>(
                  this, METHODID_GET_VALUE)))
          .build();
    }
  }

  /**
   */
  public static final class CacheApiHandlerStub extends io.grpc.stub.AbstractAsyncStub<CacheApiHandlerStub> {
    private CacheApiHandlerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CacheApiHandlerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CacheApiHandlerStub(channel, callOptions);
    }

    /**
     */
    public void getValue(com.grpccache.cacheapi.KeyRequest request,
        io.grpc.stub.StreamObserver<com.grpccache.cacheapi.ValueReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetValueMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CacheApiHandlerBlockingStub extends io.grpc.stub.AbstractBlockingStub<CacheApiHandlerBlockingStub> {
    private CacheApiHandlerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CacheApiHandlerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CacheApiHandlerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpccache.cacheapi.ValueReply getValue(com.grpccache.cacheapi.KeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetValueMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CacheApiHandlerFutureStub extends io.grpc.stub.AbstractFutureStub<CacheApiHandlerFutureStub> {
    private CacheApiHandlerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CacheApiHandlerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CacheApiHandlerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpccache.cacheapi.ValueReply> getValue(
        com.grpccache.cacheapi.KeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetValueMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_VALUE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CacheApiHandlerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CacheApiHandlerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_VALUE:
          serviceImpl.getValue((com.grpccache.cacheapi.KeyRequest) request,
              (io.grpc.stub.StreamObserver<com.grpccache.cacheapi.ValueReply>) responseObserver);
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

  private static abstract class CacheApiHandlerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CacheApiHandlerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpccache.cacheapi.CacheApiHandlerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CacheApiHandler");
    }
  }

  private static final class CacheApiHandlerFileDescriptorSupplier
      extends CacheApiHandlerBaseDescriptorSupplier {
    CacheApiHandlerFileDescriptorSupplier() {}
  }

  private static final class CacheApiHandlerMethodDescriptorSupplier
      extends CacheApiHandlerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CacheApiHandlerMethodDescriptorSupplier(String methodName) {
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
      synchronized (CacheApiHandlerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CacheApiHandlerFileDescriptorSupplier())
              .addMethod(getGetValueMethod())
              .build();
        }
      }
    }
    return result;
  }
}
