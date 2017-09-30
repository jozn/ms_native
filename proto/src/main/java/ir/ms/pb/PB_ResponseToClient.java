// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_global.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_ResponseToClient}
 */
public  final class PB_ResponseToClient extends
    com.google.protobuf.GeneratedMessageLite<
        PB_ResponseToClient, PB_ResponseToClient.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_ResponseToClient)
    PB_ResponseToClientOrBuilder {
  private PB_ResponseToClient() {
    pBClass_ = "";
    rpcFullName_ = "";
    data_ = com.google.protobuf.ByteString.EMPTY;
  }
  public static final int CLIENTCALLID_FIELD_NUMBER = 1;
  private long clientCallId_;
  /**
   * <code>int64 ClientCallId = 1;</code>
   */
  public long getClientCallId() {
    return clientCallId_;
  }
  /**
   * <code>int64 ClientCallId = 1;</code>
   */
  private void setClientCallId(long value) {
    
    clientCallId_ = value;
  }
  /**
   * <code>int64 ClientCallId = 1;</code>
   */
  private void clearClientCallId() {
    
    clientCallId_ = 0L;
  }

  public static final int PBCLASS_FIELD_NUMBER = 2;
  private java.lang.String pBClass_;
  /**
   * <code>string PBClass = 2;</code>
   */
  public java.lang.String getPBClass() {
    return pBClass_;
  }
  /**
   * <code>string PBClass = 2;</code>
   */
  public com.google.protobuf.ByteString
      getPBClassBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(pBClass_);
  }
  /**
   * <code>string PBClass = 2;</code>
   */
  private void setPBClass(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    pBClass_ = value;
  }
  /**
   * <code>string PBClass = 2;</code>
   */
  private void clearPBClass() {
    
    pBClass_ = getDefaultInstance().getPBClass();
  }
  /**
   * <code>string PBClass = 2;</code>
   */
  private void setPBClassBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    pBClass_ = value.toStringUtf8();
  }

  public static final int RPCFULLNAME_FIELD_NUMBER = 3;
  private java.lang.String rpcFullName_;
  /**
   * <code>string RpcFullName = 3;</code>
   */
  public java.lang.String getRpcFullName() {
    return rpcFullName_;
  }
  /**
   * <code>string RpcFullName = 3;</code>
   */
  public com.google.protobuf.ByteString
      getRpcFullNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(rpcFullName_);
  }
  /**
   * <code>string RpcFullName = 3;</code>
   */
  private void setRpcFullName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    rpcFullName_ = value;
  }
  /**
   * <code>string RpcFullName = 3;</code>
   */
  private void clearRpcFullName() {
    
    rpcFullName_ = getDefaultInstance().getRpcFullName();
  }
  /**
   * <code>string RpcFullName = 3;</code>
   */
  private void setRpcFullNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    rpcFullName_ = value.toStringUtf8();
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
    if (clientCallId_ != 0L) {
      output.writeInt64(1, clientCallId_);
    }
    if (!pBClass_.isEmpty()) {
      output.writeString(2, getPBClass());
    }
    if (!rpcFullName_.isEmpty()) {
      output.writeString(3, getRpcFullName());
    }
    if (!data_.isEmpty()) {
      output.writeBytes(4, data_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (clientCallId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, clientCallId_);
    }
    if (!pBClass_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getPBClass());
    }
    if (!rpcFullName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getRpcFullName());
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, data_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_ResponseToClient parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResponseToClient parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ResponseToClient parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ResponseToClient parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_ResponseToClient prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_ResponseToClient}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_ResponseToClient, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_ResponseToClient)
      ir.ms.pb.PB_ResponseToClientOrBuilder {
    // Construct using ir.ms.pb.PB_ResponseToClient.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 ClientCallId = 1;</code>
     */
    public long getClientCallId() {
      return instance.getClientCallId();
    }
    /**
     * <code>int64 ClientCallId = 1;</code>
     */
    public Builder setClientCallId(long value) {
      copyOnWrite();
      instance.setClientCallId(value);
      return this;
    }
    /**
     * <code>int64 ClientCallId = 1;</code>
     */
    public Builder clearClientCallId() {
      copyOnWrite();
      instance.clearClientCallId();
      return this;
    }

    /**
     * <code>string PBClass = 2;</code>
     */
    public java.lang.String getPBClass() {
      return instance.getPBClass();
    }
    /**
     * <code>string PBClass = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPBClassBytes() {
      return instance.getPBClassBytes();
    }
    /**
     * <code>string PBClass = 2;</code>
     */
    public Builder setPBClass(
        java.lang.String value) {
      copyOnWrite();
      instance.setPBClass(value);
      return this;
    }
    /**
     * <code>string PBClass = 2;</code>
     */
    public Builder clearPBClass() {
      copyOnWrite();
      instance.clearPBClass();
      return this;
    }
    /**
     * <code>string PBClass = 2;</code>
     */
    public Builder setPBClassBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setPBClassBytes(value);
      return this;
    }

    /**
     * <code>string RpcFullName = 3;</code>
     */
    public java.lang.String getRpcFullName() {
      return instance.getRpcFullName();
    }
    /**
     * <code>string RpcFullName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getRpcFullNameBytes() {
      return instance.getRpcFullNameBytes();
    }
    /**
     * <code>string RpcFullName = 3;</code>
     */
    public Builder setRpcFullName(
        java.lang.String value) {
      copyOnWrite();
      instance.setRpcFullName(value);
      return this;
    }
    /**
     * <code>string RpcFullName = 3;</code>
     */
    public Builder clearRpcFullName() {
      copyOnWrite();
      instance.clearRpcFullName();
      return this;
    }
    /**
     * <code>string RpcFullName = 3;</code>
     */
    public Builder setRpcFullNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRpcFullNameBytes(value);
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

    // @@protoc_insertion_point(builder_scope:PB_ResponseToClient)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_ResponseToClient();
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
        ir.ms.pb.PB_ResponseToClient other = (ir.ms.pb.PB_ResponseToClient) arg1;
        clientCallId_ = visitor.visitLong(clientCallId_ != 0L, clientCallId_,
            other.clientCallId_ != 0L, other.clientCallId_);
        pBClass_ = visitor.visitString(!pBClass_.isEmpty(), pBClass_,
            !other.pBClass_.isEmpty(), other.pBClass_);
        rpcFullName_ = visitor.visitString(!rpcFullName_.isEmpty(), rpcFullName_,
            !other.rpcFullName_.isEmpty(), other.rpcFullName_);
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

                clientCallId_ = input.readInt64();
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                pBClass_ = s;
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                rpcFullName_ = s;
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_ResponseToClient.class) {
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


  // @@protoc_insertion_point(class_scope:PB_ResponseToClient)
  private static final ir.ms.pb.PB_ResponseToClient DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_ResponseToClient();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_ResponseToClient getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_ResponseToClient> PARSER;

  public static com.google.protobuf.Parser<PB_ResponseToClient> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

