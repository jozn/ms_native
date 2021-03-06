// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_global.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_CommandToClient}
 */
public  final class PB_CommandToClient extends
    com.google.protobuf.GeneratedMessageLite<
        PB_CommandToClient, PB_CommandToClient.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_CommandToClient)
    PB_CommandToClientOrBuilder {
  private PB_CommandToClient() {
    command_ = "";
    data_ = com.google.protobuf.ByteString.EMPTY;
  }
  public static final int SERVERCALLID_FIELD_NUMBER = 1;
  private long serverCallId_;
  /**
   * <code>int64 ServerCallId = 1;</code>
   */
  public long getServerCallId() {
    return serverCallId_;
  }
  /**
   * <code>int64 ServerCallId = 1;</code>
   */
  private void setServerCallId(long value) {
    
    serverCallId_ = value;
  }
  /**
   * <code>int64 ServerCallId = 1;</code>
   */
  private void clearServerCallId() {
    
    serverCallId_ = 0L;
  }

  public static final int COMMAND_FIELD_NUMBER = 2;
  private java.lang.String command_;
  /**
   * <code>string Command = 2;</code>
   */
  public java.lang.String getCommand() {
    return command_;
  }
  /**
   * <code>string Command = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCommandBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(command_);
  }
  /**
   * <code>string Command = 2;</code>
   */
  private void setCommand(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    command_ = value;
  }
  /**
   * <code>string Command = 2;</code>
   */
  private void clearCommand() {
    
    command_ = getDefaultInstance().getCommand();
  }
  /**
   * <code>string Command = 2;</code>
   */
  private void setCommandBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    command_ = value.toStringUtf8();
  }

  public static final int RESPONDREACHED_FIELD_NUMBER = 3;
  private boolean respondReached_;
  /**
   * <code>bool RespondReached = 3;</code>
   */
  public boolean getRespondReached() {
    return respondReached_;
  }
  /**
   * <code>bool RespondReached = 3;</code>
   */
  private void setRespondReached(boolean value) {
    
    respondReached_ = value;
  }
  /**
   * <code>bool RespondReached = 3;</code>
   */
  private void clearRespondReached() {
    
    respondReached_ = false;
  }

  public static final int DATA_FIELD_NUMBER = 4;
  private com.google.protobuf.ByteString data_;
  /**
   * <code>bytes Data = 4;</code>
   */
  public com.google.protobuf.ByteString getData() {
    return data_;
  }
  /**
   * <code>bytes Data = 4;</code>
   */
  private void setData(com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    data_ = value;
  }
  /**
   * <code>bytes Data = 4;</code>
   */
  private void clearData() {
    
    data_ = getDefaultInstance().getData();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (serverCallId_ != 0L) {
      output.writeInt64(1, serverCallId_);
    }
    if (!command_.isEmpty()) {
      output.writeString(2, getCommand());
    }
    if (respondReached_ != false) {
      output.writeBool(3, respondReached_);
    }
    if (!data_.isEmpty()) {
      output.writeBytes(4, data_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (serverCallId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, serverCallId_);
    }
    if (!command_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getCommand());
    }
    if (respondReached_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, respondReached_);
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, data_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_CommandToClient parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToClient parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_CommandToClient parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_CommandToClient parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_CommandToClient prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_CommandToClient}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_CommandToClient, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_CommandToClient)
      ir.ms.pb.PB_CommandToClientOrBuilder {
    // Construct using ir.ms.pb.PB_CommandToClient.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 ServerCallId = 1;</code>
     */
    public long getServerCallId() {
      return instance.getServerCallId();
    }
    /**
     * <code>int64 ServerCallId = 1;</code>
     */
    public Builder setServerCallId(long value) {
      copyOnWrite();
      instance.setServerCallId(value);
      return this;
    }
    /**
     * <code>int64 ServerCallId = 1;</code>
     */
    public Builder clearServerCallId() {
      copyOnWrite();
      instance.clearServerCallId();
      return this;
    }

    /**
     * <code>string Command = 2;</code>
     */
    public java.lang.String getCommand() {
      return instance.getCommand();
    }
    /**
     * <code>string Command = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCommandBytes() {
      return instance.getCommandBytes();
    }
    /**
     * <code>string Command = 2;</code>
     */
    public Builder setCommand(
        java.lang.String value) {
      copyOnWrite();
      instance.setCommand(value);
      return this;
    }
    /**
     * <code>string Command = 2;</code>
     */
    public Builder clearCommand() {
      copyOnWrite();
      instance.clearCommand();
      return this;
    }
    /**
     * <code>string Command = 2;</code>
     */
    public Builder setCommandBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setCommandBytes(value);
      return this;
    }

    /**
     * <code>bool RespondReached = 3;</code>
     */
    public boolean getRespondReached() {
      return instance.getRespondReached();
    }
    /**
     * <code>bool RespondReached = 3;</code>
     */
    public Builder setRespondReached(boolean value) {
      copyOnWrite();
      instance.setRespondReached(value);
      return this;
    }
    /**
     * <code>bool RespondReached = 3;</code>
     */
    public Builder clearRespondReached() {
      copyOnWrite();
      instance.clearRespondReached();
      return this;
    }

    /**
     * <code>bytes Data = 4;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return instance.getData();
    }
    /**
     * <code>bytes Data = 4;</code>
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setData(value);
      return this;
    }
    /**
     * <code>bytes Data = 4;</code>
     */
    public Builder clearData() {
      copyOnWrite();
      instance.clearData();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_CommandToClient)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_CommandToClient();
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
        ir.ms.pb.PB_CommandToClient other = (ir.ms.pb.PB_CommandToClient) arg1;
        serverCallId_ = visitor.visitLong(serverCallId_ != 0L, serverCallId_,
            other.serverCallId_ != 0L, other.serverCallId_);
        command_ = visitor.visitString(!command_.isEmpty(), command_,
            !other.command_.isEmpty(), other.command_);
        respondReached_ = visitor.visitBoolean(respondReached_ != false, respondReached_,
            other.respondReached_ != false, other.respondReached_);
        data_ = visitor.visitByteString(data_ != com.google.protobuf.ByteString.EMPTY, data_,
            other.data_ != com.google.protobuf.ByteString.EMPTY, other.data_);
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

                serverCallId_ = input.readInt64();
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                command_ = s;
                break;
              }
              case 24: {

                respondReached_ = input.readBool();
                break;
              }
              case 34: {

                data_ = input.readBytes();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_CommandToClient.class) {
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


  // @@protoc_insertion_point(class_scope:PB_CommandToClient)
  private static final ir.ms.pb.PB_CommandToClient DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_CommandToClient();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_CommandToClient getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_CommandToClient> PARSER;

  public static com.google.protobuf.Parser<PB_CommandToClient> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

