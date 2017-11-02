// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_offlines.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Offline_MessageToDelete}
 */
public  final class PB_Offline_MessageToDelete extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Offline_MessageToDelete, PB_Offline_MessageToDelete.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Offline_MessageToDelete)
    PB_Offline_MessageToDeleteOrBuilder {
  private PB_Offline_MessageToDelete() {
  }
  public static final int MESSAGEKEY_FIELD_NUMBER = 1;
  private long messageKey_;
  /**
   * <code>int64 MessageKey = 1;</code>
   */
  public long getMessageKey() {
    return messageKey_;
  }
  /**
   * <code>int64 MessageKey = 1;</code>
   */
  private void setMessageKey(long value) {
    
    messageKey_ = value;
  }
  /**
   * <code>int64 MessageKey = 1;</code>
   */
  private void clearMessageKey() {
    
    messageKey_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (messageKey_ != 0L) {
      output.writeInt64(1, messageKey_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (messageKey_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, messageKey_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_MessageToDelete parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Offline_MessageToDelete prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Offline_MessageToDelete}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Offline_MessageToDelete, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Offline_MessageToDelete)
      ir.ms.pb.PB_Offline_MessageToDeleteOrBuilder {
    // Construct using ir.ms.pb.PB_Offline_MessageToDelete.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 MessageKey = 1;</code>
     */
    public long getMessageKey() {
      return instance.getMessageKey();
    }
    /**
     * <code>int64 MessageKey = 1;</code>
     */
    public Builder setMessageKey(long value) {
      copyOnWrite();
      instance.setMessageKey(value);
      return this;
    }
    /**
     * <code>int64 MessageKey = 1;</code>
     */
    public Builder clearMessageKey() {
      copyOnWrite();
      instance.clearMessageKey();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_Offline_MessageToDelete)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Offline_MessageToDelete();
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
        ir.ms.pb.PB_Offline_MessageToDelete other = (ir.ms.pb.PB_Offline_MessageToDelete) arg1;
        messageKey_ = visitor.visitLong(messageKey_ != 0L, messageKey_,
            other.messageKey_ != 0L, other.messageKey_);
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
              case 8: {

                messageKey_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Offline_MessageToDelete.class) {
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


  // @@protoc_insertion_point(class_scope:PB_Offline_MessageToDelete)
  private static final ir.ms.pb.PB_Offline_MessageToDelete DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Offline_MessageToDelete();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Offline_MessageToDelete getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Offline_MessageToDelete> PARSER;

  public static com.google.protobuf.Parser<PB_Offline_MessageToDelete> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

