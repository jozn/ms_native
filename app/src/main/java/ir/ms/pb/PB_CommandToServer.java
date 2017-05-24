// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: global.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_CommandToServer}
 */
public  final class PB_CommandToServer extends
    com.google.protobuf.GeneratedMessageLite<
        PB_CommandToServer, PB_CommandToServer.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_CommandToServer)
    PB_CommandToServerOrBuilder {
  private PB_CommandToServer() {
    command_ = "";
    data_ = com.google.protobuf.ByteString.EMPTY;
  }
  public static final int CALLID_FIELD_NUMBER = 1;
  private long callId_;
  /**
   * <code>int64 CallId = 1;</code>
   */
  public long getCallId() {
    return callId_;
  }
  /**
   * <code>int64 CallId = 1;</code>
   */
  private void setCallId(long value) {
    
    callId_ = value;
  }
  /**
   * <code>int64 CallId = 1;</code>
   */
  private void clearCallId() {
    
    callId_ = 0L;
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

  public static final int DATA_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString data_;
  /**
   * <code>bytes Data = 3;</code>
   */
  public com.google.protobuf.ByteString getData() {
    return data_;
  }
  /**
   * <code>bytes Data = 3;</code>
   */
  private void setData(com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    data_ = value;
  }
  /**
   * <code>bytes Data = 3;</code>
   */
  private void clearData() {
    
    data_ = getDefaultInstance().getData();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (callId_ != 0L) {
      output.writeInt64(1, callId_);
    }
    if (!command_.isEmpty()) {
      output.writeString(2, getCommand());
    }
    if (!data_.isEmpty()) {
      output.writeBytes(3, data_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (callId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, callId_);
    }
    if (!command_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getCommand());
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, data_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_CommandToServer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToServer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_CommandToServer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_CommandToServer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_CommandToServer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_CommandToServer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_CommandToServer, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_CommandToServer)
      ir.ms.pb.PB_CommandToServerOrBuilder {
    // Construct using ir.ms.pb.PB_CommandToServer.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 CallId = 1;</code>
     */
    public long getCallId() {
      return instance.getCallId();
    }
    /**
     * <code>int64 CallId = 1;</code>
     */
    public Builder setCallId(long value) {
      copyOnWrite();
      instance.setCallId(value);
      return this;
    }
    /**
     * <code>int64 CallId = 1;</code>
     */
    public Builder clearCallId() {
      copyOnWrite();
      instance.clearCallId();
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
     * <code>bytes Data = 3;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return instance.getData();
    }
    /**
     * <code>bytes Data = 3;</code>
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setData(value);
      return this;
    }
    /**
     * <code>bytes Data = 3;</code>
     */
    public Builder clearData() {
      copyOnWrite();
      instance.clearData();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_CommandToServer)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_CommandToServer();
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
        ir.ms.pb.PB_CommandToServer other = (ir.ms.pb.PB_CommandToServer) arg1;
        callId_ = visitor.visitLong(callId_ != 0L, callId_,
            other.callId_ != 0L, other.callId_);
        command_ = visitor.visitString(!command_.isEmpty(), command_,
            !other.command_.isEmpty(), other.command_);
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

                callId_ = input.readInt64();
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                command_ = s;
                break;
              }
              case 26: {

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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_CommandToServer.class) {
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


  // @@protoc_insertion_point(class_scope:PB_CommandToServer)
  private static final ir.ms.pb.PB_CommandToServer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_CommandToServer();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_CommandToServer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_CommandToServer> PARSER;

  public static com.google.protobuf.Parser<PB_CommandToServer> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

