// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_offlines.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Offline_MessagesReachedServer}
 */
public  final class PB_Offline_MessagesReachedServer extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Offline_MessagesReachedServer, PB_Offline_MessagesReachedServer.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Offline_MessagesReachedServer)
    PB_Offline_MessagesReachedServerOrBuilder {
  private PB_Offline_MessagesReachedServer() {
    messageKeys_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
  }
  private int bitField0_;
  public static final int MESSAGEKEYS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<String> messageKeys_;
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  public java.util.List<String> getMessageKeysList() {
    return messageKeys_;
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  public int getMessageKeysCount() {
    return messageKeys_.size();
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  public java.lang.String getMessageKeys(int index) {
    return messageKeys_.get(index);
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMessageKeysBytes(int index) {
    return com.google.protobuf.ByteString.copyFromUtf8(
        messageKeys_.get(index));
  }
  private void ensureMessageKeysIsMutable() {
    if (!messageKeys_.isModifiable()) {
      messageKeys_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(messageKeys_);
     }
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  private void setMessageKeys(
      int index, java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  ensureMessageKeysIsMutable();
    messageKeys_.set(index, value);
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  private void addMessageKeys(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  ensureMessageKeysIsMutable();
    messageKeys_.add(value);
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  private void addAllMessageKeys(
      java.lang.Iterable<java.lang.String> values) {
    ensureMessageKeysIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, messageKeys_);
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  private void clearMessageKeys() {
    messageKeys_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
  }
  /**
   * <code>repeated string MessageKeys = 1;</code>
   */
  private void addMessageKeysBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    ensureMessageKeysIsMutable();
    messageKeys_.add(value.toStringUtf8());
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
    for (int i = 0; i < messageKeys_.size(); i++) {
      output.writeString(1, messageKeys_.get(i));
    }
    if (atTime_ != 0L) {
      output.writeInt64(2, atTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < messageKeys_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeStringSizeNoTag(messageKeys_.get(i));
      }
      size += dataSize;
      size += 1 * getMessageKeysList().size();
    }
    if (atTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, atTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline_MessagesReachedServer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Offline_MessagesReachedServer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Offline_MessagesReachedServer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Offline_MessagesReachedServer, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Offline_MessagesReachedServer)
      ir.ms.pb.PB_Offline_MessagesReachedServerOrBuilder {
    // Construct using ir.ms.pb.PB_Offline_MessagesReachedServer.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public java.util.List<String>
        getMessageKeysList() {
      return java.util.Collections.unmodifiableList(
          instance.getMessageKeysList());
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public int getMessageKeysCount() {
      return instance.getMessageKeysCount();
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public java.lang.String getMessageKeys(int index) {
      return instance.getMessageKeys(index);
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMessageKeysBytes(int index) {
      return instance.getMessageKeysBytes(index);
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public Builder setMessageKeys(
        int index, java.lang.String value) {
      copyOnWrite();
      instance.setMessageKeys(index, value);
      return this;
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public Builder addMessageKeys(
        java.lang.String value) {
      copyOnWrite();
      instance.addMessageKeys(value);
      return this;
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public Builder addAllMessageKeys(
        java.lang.Iterable<java.lang.String> values) {
      copyOnWrite();
      instance.addAllMessageKeys(values);
      return this;
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public Builder clearMessageKeys() {
      copyOnWrite();
      instance.clearMessageKeys();
      return this;
    }
    /**
     * <code>repeated string MessageKeys = 1;</code>
     */
    public Builder addMessageKeysBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.addMessageKeysBytes(value);
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

    // @@protoc_insertion_point(builder_scope:PB_Offline_MessagesReachedServer)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Offline_MessagesReachedServer();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        messageKeys_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_Offline_MessagesReachedServer other = (ir.ms.pb.PB_Offline_MessagesReachedServer) arg1;
        messageKeys_= visitor.visitList(messageKeys_, other.messageKeys_);
        atTime_ = visitor.visitLong(atTime_ != 0L, atTime_,
            other.atTime_ != 0L, other.atTime_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
          bitField0_ |= other.bitField0_;
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
                if (!messageKeys_.isModifiable()) {
                  messageKeys_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(messageKeys_);
                }
                messageKeys_.add(s);
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Offline_MessagesReachedServer.class) {
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


  // @@protoc_insertion_point(class_scope:PB_Offline_MessagesReachedServer)
  private static final ir.ms.pb.PB_Offline_MessagesReachedServer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Offline_MessagesReachedServer();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Offline_MessagesReachedServer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Offline_MessagesReachedServer> PARSER;

  public static com.google.protobuf.Parser<PB_Offline_MessagesReachedServer> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

