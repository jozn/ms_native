// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_chat.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_ChatResponse_AddNewMessage}
 */
public  final class PB_ChatResponse_AddNewMessage extends
    com.google.protobuf.GeneratedMessageLite<
        PB_ChatResponse_AddNewMessage, PB_ChatResponse_AddNewMessage.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_ChatResponse_AddNewMessage)
    PB_ChatResponse_AddNewMessageOrBuilder {
  private PB_ChatResponse_AddNewMessage() {
    messageKey_ = "";
    messageFileKey_ = "";
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

  public static final int MESSAGEFILEKEY_FIELD_NUMBER = 3;
  private java.lang.String messageFileKey_;
  /**
   * <code>string MessageFileKey = 3;</code>
   */
  public java.lang.String getMessageFileKey() {
    return messageFileKey_;
  }
  /**
   * <code>string MessageFileKey = 3;</code>
   */
  public com.google.protobuf.ByteString
      getMessageFileKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(messageFileKey_);
  }
  /**
   * <code>string MessageFileKey = 3;</code>
   */
  private void setMessageFileKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    messageFileKey_ = value;
  }
  /**
   * <code>string MessageFileKey = 3;</code>
   */
  private void clearMessageFileKey() {
    
    messageFileKey_ = getDefaultInstance().getMessageFileKey();
  }
  /**
   * <code>string MessageFileKey = 3;</code>
   */
  private void setMessageFileKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    messageFileKey_ = value.toStringUtf8();
  }

  public static final int NEWMESSAGEFILEID_FIELD_NUMBER = 4;
  private long newMessageFileId_;
  /**
   * <code>int64 NewMessageFileId = 4;</code>
   */
  public long getNewMessageFileId() {
    return newMessageFileId_;
  }
  /**
   * <code>int64 NewMessageFileId = 4;</code>
   */
  private void setNewMessageFileId(long value) {
    
    newMessageFileId_ = value;
  }
  /**
   * <code>int64 NewMessageFileId = 4;</code>
   */
  private void clearNewMessageFileId() {
    
    newMessageFileId_ = 0L;
  }

  public static final int ATTIME_FIELD_NUMBER = 5;
  private long atTime_;
  /**
   * <code>int64 AtTime = 5;</code>
   */
  public long getAtTime() {
    return atTime_;
  }
  /**
   * <code>int64 AtTime = 5;</code>
   */
  private void setAtTime(long value) {
    
    atTime_ = value;
  }
  /**
   * <code>int64 AtTime = 5;</code>
   */
  private void clearAtTime() {
    
    atTime_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!messageKey_.isEmpty()) {
      output.writeString(1, getMessageKey());
    }
    if (newMessageId_ != 0L) {
      output.writeInt64(2, newMessageId_);
    }
    if (!messageFileKey_.isEmpty()) {
      output.writeString(3, getMessageFileKey());
    }
    if (newMessageFileId_ != 0L) {
      output.writeInt64(4, newMessageFileId_);
    }
    if (atTime_ != 0L) {
      output.writeInt64(5, atTime_);
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
    if (!messageFileKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getMessageFileKey());
    }
    if (newMessageFileId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, newMessageFileId_);
    }
    if (atTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, atTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ChatResponse_AddNewMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_ChatResponse_AddNewMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_ChatResponse_AddNewMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_ChatResponse_AddNewMessage, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_ChatResponse_AddNewMessage)
      ir.ms.pb.PB_ChatResponse_AddNewMessageOrBuilder {
    // Construct using ir.ms.pb.PB_ChatResponse_AddNewMessage.newBuilder()
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

    /**
     * <code>string MessageFileKey = 3;</code>
     */
    public java.lang.String getMessageFileKey() {
      return instance.getMessageFileKey();
    }
    /**
     * <code>string MessageFileKey = 3;</code>
     */
    public com.google.protobuf.ByteString
        getMessageFileKeyBytes() {
      return instance.getMessageFileKeyBytes();
    }
    /**
     * <code>string MessageFileKey = 3;</code>
     */
    public Builder setMessageFileKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setMessageFileKey(value);
      return this;
    }
    /**
     * <code>string MessageFileKey = 3;</code>
     */
    public Builder clearMessageFileKey() {
      copyOnWrite();
      instance.clearMessageFileKey();
      return this;
    }
    /**
     * <code>string MessageFileKey = 3;</code>
     */
    public Builder setMessageFileKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMessageFileKeyBytes(value);
      return this;
    }

    /**
     * <code>int64 NewMessageFileId = 4;</code>
     */
    public long getNewMessageFileId() {
      return instance.getNewMessageFileId();
    }
    /**
     * <code>int64 NewMessageFileId = 4;</code>
     */
    public Builder setNewMessageFileId(long value) {
      copyOnWrite();
      instance.setNewMessageFileId(value);
      return this;
    }
    /**
     * <code>int64 NewMessageFileId = 4;</code>
     */
    public Builder clearNewMessageFileId() {
      copyOnWrite();
      instance.clearNewMessageFileId();
      return this;
    }

    /**
     * <code>int64 AtTime = 5;</code>
     */
    public long getAtTime() {
      return instance.getAtTime();
    }
    /**
     * <code>int64 AtTime = 5;</code>
     */
    public Builder setAtTime(long value) {
      copyOnWrite();
      instance.setAtTime(value);
      return this;
    }
    /**
     * <code>int64 AtTime = 5;</code>
     */
    public Builder clearAtTime() {
      copyOnWrite();
      instance.clearAtTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_ChatResponse_AddNewMessage)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_ChatResponse_AddNewMessage();
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
        ir.ms.pb.PB_ChatResponse_AddNewMessage other = (ir.ms.pb.PB_ChatResponse_AddNewMessage) arg1;
        messageKey_ = visitor.visitString(!messageKey_.isEmpty(), messageKey_,
            !other.messageKey_.isEmpty(), other.messageKey_);
        newMessageId_ = visitor.visitLong(newMessageId_ != 0L, newMessageId_,
            other.newMessageId_ != 0L, other.newMessageId_);
        messageFileKey_ = visitor.visitString(!messageFileKey_.isEmpty(), messageFileKey_,
            !other.messageFileKey_.isEmpty(), other.messageFileKey_);
        newMessageFileId_ = visitor.visitLong(newMessageFileId_ != 0L, newMessageFileId_,
            other.newMessageFileId_ != 0L, other.newMessageFileId_);
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
              case 10: {
                String s = input.readStringRequireUtf8();

                messageKey_ = s;
                break;
              }
              case 16: {

                newMessageId_ = input.readInt64();
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                messageFileKey_ = s;
                break;
              }
              case 32: {

                newMessageFileId_ = input.readInt64();
                break;
              }
              case 40: {

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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_ChatResponse_AddNewMessage.class) {
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


  // @@protoc_insertion_point(class_scope:PB_ChatResponse_AddNewMessage)
  private static final ir.ms.pb.PB_ChatResponse_AddNewMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_ChatResponse_AddNewMessage();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_ChatResponse_AddNewMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_ChatResponse_AddNewMessage> PARSER;

  public static com.google.protobuf.Parser<PB_ChatResponse_AddNewMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

