// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_offlines.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Offline_ChangeMessageId}
 */
public  final class PB_Offline_ChangeMessageId extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Offline_ChangeMessageId, PB_Offline_ChangeMessageId.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Offline_ChangeMessageId)
    PB_Offline_ChangeMessageIdOrBuilder {
  private PB_Offline_ChangeMessageId() {
    messageKey_ = "";
  }
  public static final int MESSAGEKEY_FIELD_NUMBER = 1;
  private java.lang.String messageKey_;
  /**
   * <code>string MessageKey = 1;</code>
   */
  public java.lang.String getMessageKey() {
    return messageKey_;
  }
  /**
   * <code>string MessageKey = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMessageKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(messageKey_);
  }
  /**
   * <code>string MessageKey = 1;</code>
   */
  private void setMessageKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    messageKey_ = value;
  }
  /**
   * <code>string MessageKey = 1;</code>
   */
  private void clearMessageKey() {
    
    messageKey_ = getDefaultInstance().getMessageKey();
  }
  /**
   * <code>string MessageKey = 1;</code>
   */
  private void setMessageKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    messageKey_ = value.toStringUtf8();
  }

  public static final int NEWMESSAGEID_FIELD_NUMBER = 2;
  private long newMessageId_;
  /**
   * <code>int64 NewMessageId = 2;</code>
   */
  public long getNewMessageId() {
    return newMessageId_;
  }
  /**
   * <code>int64 NewMessageId = 2;</code>
   */
  private void setNewMessageId(long value) {
    
    newMessageId_ = value;
  }
  /**
   * <code>int64 NewMessageId = 2;</code>
   */
  private void clearNewMessageId() {
    
    newMessageId_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!messageKey_.isEmpty()) {
      output.writeString(1, getMessageKey());
    }
    if (newMessageId_ != 0L) {
      output.writeInt64(2, newMessageId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!messageKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getMessageKey());
    }
    if (newMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, newMessageId_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_ChangeMessageId parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Offline_ChangeMessageId prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Offline_ChangeMessageId}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Offline_ChangeMessageId, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Offline_ChangeMessageId)
      ir.ms.pb.PB_Offline_ChangeMessageIdOrBuilder {
    // Construct using ir.ms.pb.PB_Offline_ChangeMessageId.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>string MessageKey = 1;</code>
     */
    public java.lang.String getMessageKey() {
      return instance.getMessageKey();
    }
    /**
     * <code>string MessageKey = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMessageKeyBytes() {
      return instance.getMessageKeyBytes();
    }
    /**
     * <code>string MessageKey = 1;</code>
     */
    public Builder setMessageKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setMessageKey(value);
      return this;
    }
    /**
     * <code>string MessageKey = 1;</code>
     */
    public Builder clearMessageKey() {
      copyOnWrite();
      instance.clearMessageKey();
      return this;
    }
    /**
     * <code>string MessageKey = 1;</code>
     */
    public Builder setMessageKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMessageKeyBytes(value);
      return this;
    }

    /**
     * <code>int64 NewMessageId = 2;</code>
     */
    public long getNewMessageId() {
      return instance.getNewMessageId();
    }
    /**
     * <code>int64 NewMessageId = 2;</code>
     */
    public Builder setNewMessageId(long value) {
      copyOnWrite();
      instance.setNewMessageId(value);
      return this;
    }
    /**
     * <code>int64 NewMessageId = 2;</code>
     */
    public Builder clearNewMessageId() {
      copyOnWrite();
      instance.clearNewMessageId();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_Offline_ChangeMessageId)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Offline_ChangeMessageId();
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
        ir.ms.pb.PB_Offline_ChangeMessageId other = (ir.ms.pb.PB_Offline_ChangeMessageId) arg1;
        messageKey_ = visitor.visitString(!messageKey_.isEmpty(), messageKey_,
            !other.messageKey_.isEmpty(), other.messageKey_);
        newMessageId_ = visitor.visitLong(newMessageId_ != 0L, newMessageId_,
            other.newMessageId_ != 0L, other.newMessageId_);
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
              case 10: {
                String s = input.readStringRequireUtf8();

                messageKey_ = s;
                break;
              }
              case 16: {

                newMessageId_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Offline_ChangeMessageId.class) {
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


  // @@protoc_insertion_point(class_scope:PB_Offline_ChangeMessageId)
  private static final ir.ms.pb.PB_Offline_ChangeMessageId DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Offline_ChangeMessageId();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Offline_ChangeMessageId getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Offline_ChangeMessageId> PARSER;

  public static com.google.protobuf.Parser<PB_Offline_ChangeMessageId> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

