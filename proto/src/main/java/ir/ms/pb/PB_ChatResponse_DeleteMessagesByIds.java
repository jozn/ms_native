// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_chat.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_ChatResponse_DeleteMessagesByIds}
 */
public  final class PB_ChatResponse_DeleteMessagesByIds extends
    com.google.protobuf.GeneratedMessageLite<
        PB_ChatResponse_DeleteMessagesByIds, PB_ChatResponse_DeleteMessagesByIds.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_ChatResponse_DeleteMessagesByIds)
    PB_ChatResponse_DeleteMessagesByIdsOrBuilder {
  private PB_ChatResponse_DeleteMessagesByIds() {
  }
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_ChatResponse_DeleteMessagesByIds}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_ChatResponse_DeleteMessagesByIds)
      ir.ms.pb.PB_ChatResponse_DeleteMessagesByIdsOrBuilder {
    // Construct using ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    // @@protoc_insertion_point(builder_scope:PB_ChatResponse_DeleteMessagesByIds)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds other = (ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds) arg1;
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:PB_ChatResponse_DeleteMessagesByIds)
  private static final ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_ChatResponse_DeleteMessagesByIds();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_ChatResponse_DeleteMessagesByIds getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_ChatResponse_DeleteMessagesByIds> PARSER;

  public static com.google.protobuf.Parser<PB_ChatResponse_DeleteMessagesByIds> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

