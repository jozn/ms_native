// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Offline}
 */
public  final class PB_Offline extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Offline, PB_Offline.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Offline)
    PB_OfflineOrBuilder {
  private PB_Offline() {
    rpcName_ = "";
    pBClassName_ = "";
    key_ = "";
    dataJson_ = "";
    dataBlob_ = com.google.protobuf.ByteString.EMPTY;
  }
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 Id = 1;</code>
   */
  public long getId() {
    return id_;
  }
  /**
   * <code>int64 Id = 1;</code>
   */
  private void setId(long value) {
    
    id_ = value;
  }
  /**
   * <code>int64 Id = 1;</code>
   */
  private void clearId() {
    
    id_ = 0L;
  }

  public static final int FROMUSERID_FIELD_NUMBER = 3;
  private int fromUserId_;
  /**
   * <code>int32 FromUserId = 3;</code>
   */
  public int getFromUserId() {
    return fromUserId_;
  }
  /**
   * <code>int32 FromUserId = 3;</code>
   */
  private void setFromUserId(int value) {
    
    fromUserId_ = value;
  }
  /**
   * <code>int32 FromUserId = 3;</code>
   */
  private void clearFromUserId() {
    
    fromUserId_ = 0;
  }

  public static final int TOUSERID_FIELD_NUMBER = 5;
  private int toUserId_;
  /**
   * <code>int32 ToUserId = 5;</code>
   */
  public int getToUserId() {
    return toUserId_;
  }
  /**
   * <code>int32 ToUserId = 5;</code>
   */
  private void setToUserId(int value) {
    
    toUserId_ = value;
  }
  /**
   * <code>int32 ToUserId = 5;</code>
   */
  private void clearToUserId() {
    
    toUserId_ = 0;
  }

  public static final int RPCNAME_FIELD_NUMBER = 7;
  private java.lang.String rpcName_;
  /**
   * <code>string RpcName = 7;</code>
   */
  public java.lang.String getRpcName() {
    return rpcName_;
  }
  /**
   * <code>string RpcName = 7;</code>
   */
  public com.google.protobuf.ByteString
      getRpcNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(rpcName_);
  }
  /**
   * <code>string RpcName = 7;</code>
   */
  private void setRpcName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    rpcName_ = value;
  }
  /**
   * <code>string RpcName = 7;</code>
   */
  private void clearRpcName() {
    
    rpcName_ = getDefaultInstance().getRpcName();
  }
  /**
   * <code>string RpcName = 7;</code>
   */
  private void setRpcNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    rpcName_ = value.toStringUtf8();
  }

  public static final int PBCLASSNAME_FIELD_NUMBER = 9;
  private java.lang.String pBClassName_;
  /**
   * <code>string PBClassName = 9;</code>
   */
  public java.lang.String getPBClassName() {
    return pBClassName_;
  }
  /**
   * <code>string PBClassName = 9;</code>
   */
  public com.google.protobuf.ByteString
      getPBClassNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(pBClassName_);
  }
  /**
   * <code>string PBClassName = 9;</code>
   */
  private void setPBClassName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    pBClassName_ = value;
  }
  /**
   * <code>string PBClassName = 9;</code>
   */
  private void clearPBClassName() {
    
    pBClassName_ = getDefaultInstance().getPBClassName();
  }
  /**
   * <code>string PBClassName = 9;</code>
   */
  private void setPBClassNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    pBClassName_ = value.toStringUtf8();
  }

  public static final int KEY_FIELD_NUMBER = 11;
  private java.lang.String key_;
  /**
   * <code>string Key = 11;</code>
   */
  public java.lang.String getKey() {
    return key_;
  }
  /**
   * <code>string Key = 11;</code>
   */
  public com.google.protobuf.ByteString
      getKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(key_);
  }
  /**
   * <code>string Key = 11;</code>
   */
  private void setKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    key_ = value;
  }
  /**
   * <code>string Key = 11;</code>
   */
  private void clearKey() {
    
    key_ = getDefaultInstance().getKey();
  }
  /**
   * <code>string Key = 11;</code>
   */
  private void setKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    key_ = value.toStringUtf8();
  }

  public static final int DATAJSON_FIELD_NUMBER = 13;
  private java.lang.String dataJson_;
  /**
   * <code>string DataJson = 13;</code>
   */
  public java.lang.String getDataJson() {
    return dataJson_;
  }
  /**
   * <code>string DataJson = 13;</code>
   */
  public com.google.protobuf.ByteString
      getDataJsonBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(dataJson_);
  }
  /**
   * <code>string DataJson = 13;</code>
   */
  private void setDataJson(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    dataJson_ = value;
  }
  /**
   * <code>string DataJson = 13;</code>
   */
  private void clearDataJson() {
    
    dataJson_ = getDefaultInstance().getDataJson();
  }
  /**
   * <code>string DataJson = 13;</code>
   */
  private void setDataJsonBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    dataJson_ = value.toStringUtf8();
  }

  public static final int DATABLOB_FIELD_NUMBER = 15;
  private com.google.protobuf.ByteString dataBlob_;
  /**
   * <code>bytes DataBlob = 15;</code>
   */
  public com.google.protobuf.ByteString getDataBlob() {
    return dataBlob_;
  }
  /**
   * <code>bytes DataBlob = 15;</code>
   */
  private void setDataBlob(com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    dataBlob_ = value;
  }
  /**
   * <code>bytes DataBlob = 15;</code>
   */
  private void clearDataBlob() {
    
    dataBlob_ = getDefaultInstance().getDataBlob();
  }

  public static final int DATALENGTH_FIELD_NUMBER = 17;
  private int dataLength_;
  /**
   * <code>int32 DataLength = 17;</code>
   */
  public int getDataLength() {
    return dataLength_;
  }
  /**
   * <code>int32 DataLength = 17;</code>
   */
  private void setDataLength(int value) {
    
    dataLength_ = value;
  }
  /**
   * <code>int32 DataLength = 17;</code>
   */
  private void clearDataLength() {
    
    dataLength_ = 0;
  }

  public static final int CREATEDMS_FIELD_NUMBER = 19;
  private long createdMs_;
  /**
   * <code>int64 CreatedMs = 19;</code>
   */
  public long getCreatedMs() {
    return createdMs_;
  }
  /**
   * <code>int64 CreatedMs = 19;</code>
   */
  private void setCreatedMs(long value) {
    
    createdMs_ = value;
  }
  /**
   * <code>int64 CreatedMs = 19;</code>
   */
  private void clearCreatedMs() {
    
    createdMs_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (fromUserId_ != 0) {
      output.writeInt32(3, fromUserId_);
    }
    if (toUserId_ != 0) {
      output.writeInt32(5, toUserId_);
    }
    if (!rpcName_.isEmpty()) {
      output.writeString(7, getRpcName());
    }
    if (!pBClassName_.isEmpty()) {
      output.writeString(9, getPBClassName());
    }
    if (!key_.isEmpty()) {
      output.writeString(11, getKey());
    }
    if (!dataJson_.isEmpty()) {
      output.writeString(13, getDataJson());
    }
    if (!dataBlob_.isEmpty()) {
      output.writeBytes(15, dataBlob_);
    }
    if (dataLength_ != 0) {
      output.writeInt32(17, dataLength_);
    }
    if (createdMs_ != 0L) {
      output.writeInt64(19, createdMs_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (fromUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, fromUserId_);
    }
    if (toUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, toUserId_);
    }
    if (!rpcName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(7, getRpcName());
    }
    if (!pBClassName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(9, getPBClassName());
    }
    if (!key_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(11, getKey());
    }
    if (!dataJson_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(13, getDataJson());
    }
    if (!dataBlob_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(15, dataBlob_);
    }
    if (dataLength_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(17, dataLength_);
    }
    if (createdMs_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(19, createdMs_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Offline parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Offline parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Offline parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Offline parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Offline prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Offline}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Offline, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Offline)
      ir.ms.pb.PB_OfflineOrBuilder {
    // Construct using ir.ms.pb.PB_Offline.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 Id = 1;</code>
     */
    public long getId() {
      return instance.getId();
    }
    /**
     * <code>int64 Id = 1;</code>
     */
    public Builder setId(long value) {
      copyOnWrite();
      instance.setId(value);
      return this;
    }
    /**
     * <code>int64 Id = 1;</code>
     */
    public Builder clearId() {
      copyOnWrite();
      instance.clearId();
      return this;
    }

    /**
     * <code>int32 FromUserId = 3;</code>
     */
    public int getFromUserId() {
      return instance.getFromUserId();
    }
    /**
     * <code>int32 FromUserId = 3;</code>
     */
    public Builder setFromUserId(int value) {
      copyOnWrite();
      instance.setFromUserId(value);
      return this;
    }
    /**
     * <code>int32 FromUserId = 3;</code>
     */
    public Builder clearFromUserId() {
      copyOnWrite();
      instance.clearFromUserId();
      return this;
    }

    /**
     * <code>int32 ToUserId = 5;</code>
     */
    public int getToUserId() {
      return instance.getToUserId();
    }
    /**
     * <code>int32 ToUserId = 5;</code>
     */
    public Builder setToUserId(int value) {
      copyOnWrite();
      instance.setToUserId(value);
      return this;
    }
    /**
     * <code>int32 ToUserId = 5;</code>
     */
    public Builder clearToUserId() {
      copyOnWrite();
      instance.clearToUserId();
      return this;
    }

    /**
     * <code>string RpcName = 7;</code>
     */
    public java.lang.String getRpcName() {
      return instance.getRpcName();
    }
    /**
     * <code>string RpcName = 7;</code>
     */
    public com.google.protobuf.ByteString
        getRpcNameBytes() {
      return instance.getRpcNameBytes();
    }
    /**
     * <code>string RpcName = 7;</code>
     */
    public Builder setRpcName(
        java.lang.String value) {
      copyOnWrite();
      instance.setRpcName(value);
      return this;
    }
    /**
     * <code>string RpcName = 7;</code>
     */
    public Builder clearRpcName() {
      copyOnWrite();
      instance.clearRpcName();
      return this;
    }
    /**
     * <code>string RpcName = 7;</code>
     */
    public Builder setRpcNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRpcNameBytes(value);
      return this;
    }

    /**
     * <code>string PBClassName = 9;</code>
     */
    public java.lang.String getPBClassName() {
      return instance.getPBClassName();
    }
    /**
     * <code>string PBClassName = 9;</code>
     */
    public com.google.protobuf.ByteString
        getPBClassNameBytes() {
      return instance.getPBClassNameBytes();
    }
    /**
     * <code>string PBClassName = 9;</code>
     */
    public Builder setPBClassName(
        java.lang.String value) {
      copyOnWrite();
      instance.setPBClassName(value);
      return this;
    }
    /**
     * <code>string PBClassName = 9;</code>
     */
    public Builder clearPBClassName() {
      copyOnWrite();
      instance.clearPBClassName();
      return this;
    }
    /**
     * <code>string PBClassName = 9;</code>
     */
    public Builder setPBClassNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setPBClassNameBytes(value);
      return this;
    }

    /**
     * <code>string Key = 11;</code>
     */
    public java.lang.String getKey() {
      return instance.getKey();
    }
    /**
     * <code>string Key = 11;</code>
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      return instance.getKeyBytes();
    }
    /**
     * <code>string Key = 11;</code>
     */
    public Builder setKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setKey(value);
      return this;
    }
    /**
     * <code>string Key = 11;</code>
     */
    public Builder clearKey() {
      copyOnWrite();
      instance.clearKey();
      return this;
    }
    /**
     * <code>string Key = 11;</code>
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setKeyBytes(value);
      return this;
    }

    /**
     * <code>string DataJson = 13;</code>
     */
    public java.lang.String getDataJson() {
      return instance.getDataJson();
    }
    /**
     * <code>string DataJson = 13;</code>
     */
    public com.google.protobuf.ByteString
        getDataJsonBytes() {
      return instance.getDataJsonBytes();
    }
    /**
     * <code>string DataJson = 13;</code>
     */
    public Builder setDataJson(
        java.lang.String value) {
      copyOnWrite();
      instance.setDataJson(value);
      return this;
    }
    /**
     * <code>string DataJson = 13;</code>
     */
    public Builder clearDataJson() {
      copyOnWrite();
      instance.clearDataJson();
      return this;
    }
    /**
     * <code>string DataJson = 13;</code>
     */
    public Builder setDataJsonBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setDataJsonBytes(value);
      return this;
    }

    /**
     * <code>bytes DataBlob = 15;</code>
     */
    public com.google.protobuf.ByteString getDataBlob() {
      return instance.getDataBlob();
    }
    /**
     * <code>bytes DataBlob = 15;</code>
     */
    public Builder setDataBlob(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setDataBlob(value);
      return this;
    }
    /**
     * <code>bytes DataBlob = 15;</code>
     */
    public Builder clearDataBlob() {
      copyOnWrite();
      instance.clearDataBlob();
      return this;
    }

    /**
     * <code>int32 DataLength = 17;</code>
     */
    public int getDataLength() {
      return instance.getDataLength();
    }
    /**
     * <code>int32 DataLength = 17;</code>
     */
    public Builder setDataLength(int value) {
      copyOnWrite();
      instance.setDataLength(value);
      return this;
    }
    /**
     * <code>int32 DataLength = 17;</code>
     */
    public Builder clearDataLength() {
      copyOnWrite();
      instance.clearDataLength();
      return this;
    }

    /**
     * <code>int64 CreatedMs = 19;</code>
     */
    public long getCreatedMs() {
      return instance.getCreatedMs();
    }
    /**
     * <code>int64 CreatedMs = 19;</code>
     */
    public Builder setCreatedMs(long value) {
      copyOnWrite();
      instance.setCreatedMs(value);
      return this;
    }
    /**
     * <code>int64 CreatedMs = 19;</code>
     */
    public Builder clearCreatedMs() {
      copyOnWrite();
      instance.clearCreatedMs();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_Offline)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Offline();
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
        ir.ms.pb.PB_Offline other = (ir.ms.pb.PB_Offline) arg1;
        id_ = visitor.visitLong(id_ != 0L, id_,
            other.id_ != 0L, other.id_);
        fromUserId_ = visitor.visitInt(fromUserId_ != 0, fromUserId_,
            other.fromUserId_ != 0, other.fromUserId_);
        toUserId_ = visitor.visitInt(toUserId_ != 0, toUserId_,
            other.toUserId_ != 0, other.toUserId_);
        rpcName_ = visitor.visitString(!rpcName_.isEmpty(), rpcName_,
            !other.rpcName_.isEmpty(), other.rpcName_);
        pBClassName_ = visitor.visitString(!pBClassName_.isEmpty(), pBClassName_,
            !other.pBClassName_.isEmpty(), other.pBClassName_);
        key_ = visitor.visitString(!key_.isEmpty(), key_,
            !other.key_.isEmpty(), other.key_);
        dataJson_ = visitor.visitString(!dataJson_.isEmpty(), dataJson_,
            !other.dataJson_.isEmpty(), other.dataJson_);
        dataBlob_ = visitor.visitByteString(dataBlob_ != com.google.protobuf.ByteString.EMPTY, dataBlob_,
            other.dataBlob_ != com.google.protobuf.ByteString.EMPTY, other.dataBlob_);
        dataLength_ = visitor.visitInt(dataLength_ != 0, dataLength_,
            other.dataLength_ != 0, other.dataLength_);
        createdMs_ = visitor.visitLong(createdMs_ != 0L, createdMs_,
            other.createdMs_ != 0L, other.createdMs_);
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

                id_ = input.readInt64();
                break;
              }
              case 24: {

                fromUserId_ = input.readInt32();
                break;
              }
              case 40: {

                toUserId_ = input.readInt32();
                break;
              }
              case 58: {
                String s = input.readStringRequireUtf8();

                rpcName_ = s;
                break;
              }
              case 74: {
                String s = input.readStringRequireUtf8();

                pBClassName_ = s;
                break;
              }
              case 90: {
                String s = input.readStringRequireUtf8();

                key_ = s;
                break;
              }
              case 106: {
                String s = input.readStringRequireUtf8();

                dataJson_ = s;
                break;
              }
              case 122: {

                dataBlob_ = input.readBytes();
                break;
              }
              case 136: {

                dataLength_ = input.readInt32();
                break;
              }
              case 152: {

                createdMs_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Offline.class) {
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


  // @@protoc_insertion_point(class_scope:PB_Offline)
  private static final ir.ms.pb.PB_Offline DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Offline();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Offline getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Offline> PARSER;

  public static com.google.protobuf.Parser<PB_Offline> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

