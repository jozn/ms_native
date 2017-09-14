// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_updates.proto

package ir.ms.pb;

/**
 * <pre>
 *&#47;/////////////////////////////////////////////
 * </pre>
 *
 * Protobuf type {@code PB_UpdateMessageMeta}
 */
public  final class PB_UpdateMessageMeta extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UpdateMessageMeta, PB_UpdateMessageMeta.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UpdateMessageMeta)
    PB_UpdateMessageMetaOrBuilder {
  private PB_UpdateMessageMeta() {
  }
  public static final int MESSAGEID_FIELD_NUMBER = 1;
  private long messageId_;
  /**
   * <code>int64 MessageId = 1;</code>
   */
  public long getMessageId() {
    return messageId_;
  }
  /**
   * <code>int64 MessageId = 1;</code>
   */
  private void setMessageId(long value) {
    
    messageId_ = value;
  }
  /**
   * <code>int64 MessageId = 1;</code>
   */
  private void clearMessageId() {
    
    messageId_ = 0L;
  }

  public static final int ATTIME_FIELD_NUMBER = 2;
  private long atTime_;
  /**
   * <code>int64 AtTime = 2;</code>
   */
  public long getAtTime() {
    return atTime_;
  }
  /**
   * <code>int64 AtTime = 2;</code>
   */
  private void setAtTime(long value) {
    
    atTime_ = value;
  }
  /**
   * <code>int64 AtTime = 2;</code>
   */
  private void clearAtTime() {
    
    atTime_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (messageId_ != 0L) {
      output.writeInt64(1, messageId_);
    }
    if (atTime_ != 0L) {
      output.writeInt64(2, atTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, messageId_);
    }
    if (atTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, atTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UpdateMessageMeta parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UpdateMessageMeta prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   *&#47;/////////////////////////////////////////////
   * </pre>
   *
   * Protobuf type {@code PB_UpdateMessageMeta}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UpdateMessageMeta, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UpdateMessageMeta)
      ir.ms.pb.PB_UpdateMessageMetaOrBuilder {
    // Construct using ir.ms.pb.PB_UpdateMessageMeta.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 MessageId = 1;</code>
     */
    public long getMessageId() {
      return instance.getMessageId();
    }
    /**
     * <code>int64 MessageId = 1;</code>
     */
    public Builder setMessageId(long value) {
      copyOnWrite();
      instance.setMessageId(value);
      return this;
    }
    /**
     * <code>int64 MessageId = 1;</code>
     */
    public Builder clearMessageId() {
      copyOnWrite();
      instance.clearMessageId();
      return this;
    }

    /**
     * <code>int64 AtTime = 2;</code>
     */
    public long getAtTime() {
      return instance.getAtTime();
    }
    /**
     * <code>int64 AtTime = 2;</code>
     */
    public Builder setAtTime(long value) {
      copyOnWrite();
      instance.setAtTime(value);
      return this;
    }
    /**
     * <code>int64 AtTime = 2;</code>
     */
    public Builder clearAtTime() {
      copyOnWrite();
      instance.clearAtTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UpdateMessageMeta)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UpdateMessageMeta();
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
        ir.ms.pb.PB_UpdateMessageMeta other = (ir.ms.pb.PB_UpdateMessageMeta) arg1;
        messageId_ = visitor.visitLong(messageId_ != 0L, messageId_,
            other.messageId_ != 0L, other.messageId_);
        atTime_ = visitor.visitLong(atTime_ != 0L, atTime_,
            other.atTime_ != 0L, other.atTime_);
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

                messageId_ = input.readInt64();
                break;
              }
              case 16: {

                atTime_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UpdateMessageMeta.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UpdateMessageMeta)
  private static final ir.ms.pb.PB_UpdateMessageMeta DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UpdateMessageMeta();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UpdateMessageMeta getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UpdateMessageMeta> PARSER;

  public static com.google.protobuf.Parser<PB_UpdateMessageMeta> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

