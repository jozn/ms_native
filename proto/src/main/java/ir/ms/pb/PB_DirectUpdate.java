// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_DirectUpdate}
 */
public  final class PB_DirectUpdate extends
    com.google.protobuf.GeneratedMessageLite<
        PB_DirectUpdate, PB_DirectUpdate.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_DirectUpdate)
    PB_DirectUpdateOrBuilder {
  private PB_DirectUpdate() {
    chatKey_ = "";
    extraPB_ = com.google.protobuf.ByteString.EMPTY;
    extraJson_ = "";
  }
  public static final int DIRECTUPDATEID_FIELD_NUMBER = 1;
  private long directUpdateId_;
  /**
   * <code>int64 DirectUpdateId = 1;</code>
   */
  public long getDirectUpdateId() {
    return directUpdateId_;
  }
  /**
   * <code>int64 DirectUpdateId = 1;</code>
   */
  private void setDirectUpdateId(long value) {
    
    directUpdateId_ = value;
  }
  /**
   * <code>int64 DirectUpdateId = 1;</code>
   */
  private void clearDirectUpdateId() {
    
    directUpdateId_ = 0L;
  }

  public static final int TOUSERID_FIELD_NUMBER = 3;
  private int toUserId_;
  /**
   * <code>int32 ToUserId = 3;</code>
   */
  public int getToUserId() {
    return toUserId_;
  }
  /**
   * <code>int32 ToUserId = 3;</code>
   */
  private void setToUserId(int value) {
    
    toUserId_ = value;
  }
  /**
   * <code>int32 ToUserId = 3;</code>
   */
  private void clearToUserId() {
    
    toUserId_ = 0;
  }

  public static final int MESSAGEID_FIELD_NUMBER = 5;
  private long messageId_;
  /**
   * <code>int64 MessageId = 5;</code>
   */
  public long getMessageId() {
    return messageId_;
  }
  /**
   * <code>int64 MessageId = 5;</code>
   */
  private void setMessageId(long value) {
    
    messageId_ = value;
  }
  /**
   * <code>int64 MessageId = 5;</code>
   */
  private void clearMessageId() {
    
    messageId_ = 0L;
  }

  public static final int MESSAGEFILEID_FIELD_NUMBER = 7;
  private long messageFileId_;
  /**
   * <code>int64 MessageFileId = 7;</code>
   */
  public long getMessageFileId() {
    return messageFileId_;
  }
  /**
   * <code>int64 MessageFileId = 7;</code>
   */
  private void setMessageFileId(long value) {
    
    messageFileId_ = value;
  }
  /**
   * <code>int64 MessageFileId = 7;</code>
   */
  private void clearMessageFileId() {
    
    messageFileId_ = 0L;
  }

  public static final int OTHERID_FIELD_NUMBER = 9;
  private long otherId_;
  /**
   * <code>int64 OtherId = 9;</code>
   */
  public long getOtherId() {
    return otherId_;
  }
  /**
   * <code>int64 OtherId = 9;</code>
   */
  private void setOtherId(long value) {
    
    otherId_ = value;
  }
  /**
   * <code>int64 OtherId = 9;</code>
   */
  private void clearOtherId() {
    
    otherId_ = 0L;
  }

  public static final int CHATKEY_FIELD_NUMBER = 11;
  private java.lang.String chatKey_;
  /**
   * <code>string ChatKey = 11;</code>
   */
  public java.lang.String getChatKey() {
    return chatKey_;
  }
  /**
   * <code>string ChatKey = 11;</code>
   */
  public com.google.protobuf.ByteString
      getChatKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(chatKey_);
  }
  /**
   * <code>string ChatKey = 11;</code>
   */
  private void setChatKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    chatKey_ = value;
  }
  /**
   * <code>string ChatKey = 11;</code>
   */
  private void clearChatKey() {
    
    chatKey_ = getDefaultInstance().getChatKey();
  }
  /**
   * <code>string ChatKey = 11;</code>
   */
  private void setChatKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    chatKey_ = value.toStringUtf8();
  }

  public static final int PEERUSERID_FIELD_NUMBER = 13;
  private int peerUserId_;
  /**
   * <code>int32 PeerUserId = 13;</code>
   */
  public int getPeerUserId() {
    return peerUserId_;
  }
  /**
   * <code>int32 PeerUserId = 13;</code>
   */
  private void setPeerUserId(int value) {
    
    peerUserId_ = value;
  }
  /**
   * <code>int32 PeerUserId = 13;</code>
   */
  private void clearPeerUserId() {
    
    peerUserId_ = 0;
  }

  public static final int EVENTTYPE_FIELD_NUMBER = 15;
  private int eventType_;
  /**
   * <code>int32 EventType = 15;</code>
   */
  public int getEventType() {
    return eventType_;
  }
  /**
   * <code>int32 EventType = 15;</code>
   */
  private void setEventType(int value) {
    
    eventType_ = value;
  }
  /**
   * <code>int32 EventType = 15;</code>
   */
  private void clearEventType() {
    
    eventType_ = 0;
  }

  public static final int ROOMLOGTYPEID_FIELD_NUMBER = 17;
  private int roomLogTypeId_;
  /**
   * <code>int32 RoomLogTypeId = 17;</code>
   */
  public int getRoomLogTypeId() {
    return roomLogTypeId_;
  }
  /**
   * <code>int32 RoomLogTypeId = 17;</code>
   */
  private void setRoomLogTypeId(int value) {
    
    roomLogTypeId_ = value;
  }
  /**
   * <code>int32 RoomLogTypeId = 17;</code>
   */
  private void clearRoomLogTypeId() {
    
    roomLogTypeId_ = 0;
  }

  public static final int FROMSEQ_FIELD_NUMBER = 19;
  private int fromSeq_;
  /**
   * <code>int32 FromSeq = 19;</code>
   */
  public int getFromSeq() {
    return fromSeq_;
  }
  /**
   * <code>int32 FromSeq = 19;</code>
   */
  private void setFromSeq(int value) {
    
    fromSeq_ = value;
  }
  /**
   * <code>int32 FromSeq = 19;</code>
   */
  private void clearFromSeq() {
    
    fromSeq_ = 0;
  }

  public static final int TOSEQ_FIELD_NUMBER = 21;
  private int toSeq_;
  /**
   * <code>int32 ToSeq = 21;</code>
   */
  public int getToSeq() {
    return toSeq_;
  }
  /**
   * <code>int32 ToSeq = 21;</code>
   */
  private void setToSeq(int value) {
    
    toSeq_ = value;
  }
  /**
   * <code>int32 ToSeq = 21;</code>
   */
  private void clearToSeq() {
    
    toSeq_ = 0;
  }

  public static final int EXTRAPB_FIELD_NUMBER = 23;
  private com.google.protobuf.ByteString extraPB_;
  /**
   * <code>bytes ExtraPB = 23;</code>
   */
  public com.google.protobuf.ByteString getExtraPB() {
    return extraPB_;
  }
  /**
   * <code>bytes ExtraPB = 23;</code>
   */
  private void setExtraPB(com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    extraPB_ = value;
  }
  /**
   * <code>bytes ExtraPB = 23;</code>
   */
  private void clearExtraPB() {
    
    extraPB_ = getDefaultInstance().getExtraPB();
  }

  public static final int EXTRAJSON_FIELD_NUMBER = 25;
  private java.lang.String extraJson_;
  /**
   * <code>string ExtraJson = 25;</code>
   */
  public java.lang.String getExtraJson() {
    return extraJson_;
  }
  /**
   * <code>string ExtraJson = 25;</code>
   */
  public com.google.protobuf.ByteString
      getExtraJsonBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(extraJson_);
  }
  /**
   * <code>string ExtraJson = 25;</code>
   */
  private void setExtraJson(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    extraJson_ = value;
  }
  /**
   * <code>string ExtraJson = 25;</code>
   */
  private void clearExtraJson() {
    
    extraJson_ = getDefaultInstance().getExtraJson();
  }
  /**
   * <code>string ExtraJson = 25;</code>
   */
  private void setExtraJsonBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    extraJson_ = value.toStringUtf8();
  }

  public static final int ATTIMEMS_FIELD_NUMBER = 27;
  private long atTimeMs_;
  /**
   * <code>int64 AtTimeMs = 27;</code>
   */
  public long getAtTimeMs() {
    return atTimeMs_;
  }
  /**
   * <code>int64 AtTimeMs = 27;</code>
   */
  private void setAtTimeMs(long value) {
    
    atTimeMs_ = value;
  }
  /**
   * <code>int64 AtTimeMs = 27;</code>
   */
  private void clearAtTimeMs() {
    
    atTimeMs_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (directUpdateId_ != 0L) {
      output.writeInt64(1, directUpdateId_);
    }
    if (toUserId_ != 0) {
      output.writeInt32(3, toUserId_);
    }
    if (messageId_ != 0L) {
      output.writeInt64(5, messageId_);
    }
    if (messageFileId_ != 0L) {
      output.writeInt64(7, messageFileId_);
    }
    if (otherId_ != 0L) {
      output.writeInt64(9, otherId_);
    }
    if (!chatKey_.isEmpty()) {
      output.writeString(11, getChatKey());
    }
    if (peerUserId_ != 0) {
      output.writeInt32(13, peerUserId_);
    }
    if (eventType_ != 0) {
      output.writeInt32(15, eventType_);
    }
    if (roomLogTypeId_ != 0) {
      output.writeInt32(17, roomLogTypeId_);
    }
    if (fromSeq_ != 0) {
      output.writeInt32(19, fromSeq_);
    }
    if (toSeq_ != 0) {
      output.writeInt32(21, toSeq_);
    }
    if (!extraPB_.isEmpty()) {
      output.writeBytes(23, extraPB_);
    }
    if (!extraJson_.isEmpty()) {
      output.writeString(25, getExtraJson());
    }
    if (atTimeMs_ != 0L) {
      output.writeInt64(27, atTimeMs_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (directUpdateId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, directUpdateId_);
    }
    if (toUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, toUserId_);
    }
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, messageId_);
    }
    if (messageFileId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(7, messageFileId_);
    }
    if (otherId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(9, otherId_);
    }
    if (!chatKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(11, getChatKey());
    }
    if (peerUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, peerUserId_);
    }
    if (eventType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(15, eventType_);
    }
    if (roomLogTypeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(17, roomLogTypeId_);
    }
    if (fromSeq_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(19, fromSeq_);
    }
    if (toSeq_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(21, toSeq_);
    }
    if (!extraPB_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(23, extraPB_);
    }
    if (!extraJson_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(25, getExtraJson());
    }
    if (atTimeMs_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(27, atTimeMs_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_DirectUpdate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_DirectUpdate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_DirectUpdate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_DirectUpdate parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_DirectUpdate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_DirectUpdate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_DirectUpdate, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_DirectUpdate)
      ir.ms.pb.PB_DirectUpdateOrBuilder {
    // Construct using ir.ms.pb.PB_DirectUpdate.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 DirectUpdateId = 1;</code>
     */
    public long getDirectUpdateId() {
      return instance.getDirectUpdateId();
    }
    /**
     * <code>int64 DirectUpdateId = 1;</code>
     */
    public Builder setDirectUpdateId(long value) {
      copyOnWrite();
      instance.setDirectUpdateId(value);
      return this;
    }
    /**
     * <code>int64 DirectUpdateId = 1;</code>
     */
    public Builder clearDirectUpdateId() {
      copyOnWrite();
      instance.clearDirectUpdateId();
      return this;
    }

    /**
     * <code>int32 ToUserId = 3;</code>
     */
    public int getToUserId() {
      return instance.getToUserId();
    }
    /**
     * <code>int32 ToUserId = 3;</code>
     */
    public Builder setToUserId(int value) {
      copyOnWrite();
      instance.setToUserId(value);
      return this;
    }
    /**
     * <code>int32 ToUserId = 3;</code>
     */
    public Builder clearToUserId() {
      copyOnWrite();
      instance.clearToUserId();
      return this;
    }

    /**
     * <code>int64 MessageId = 5;</code>
     */
    public long getMessageId() {
      return instance.getMessageId();
    }
    /**
     * <code>int64 MessageId = 5;</code>
     */
    public Builder setMessageId(long value) {
      copyOnWrite();
      instance.setMessageId(value);
      return this;
    }
    /**
     * <code>int64 MessageId = 5;</code>
     */
    public Builder clearMessageId() {
      copyOnWrite();
      instance.clearMessageId();
      return this;
    }

    /**
     * <code>int64 MessageFileId = 7;</code>
     */
    public long getMessageFileId() {
      return instance.getMessageFileId();
    }
    /**
     * <code>int64 MessageFileId = 7;</code>
     */
    public Builder setMessageFileId(long value) {
      copyOnWrite();
      instance.setMessageFileId(value);
      return this;
    }
    /**
     * <code>int64 MessageFileId = 7;</code>
     */
    public Builder clearMessageFileId() {
      copyOnWrite();
      instance.clearMessageFileId();
      return this;
    }

    /**
     * <code>int64 OtherId = 9;</code>
     */
    public long getOtherId() {
      return instance.getOtherId();
    }
    /**
     * <code>int64 OtherId = 9;</code>
     */
    public Builder setOtherId(long value) {
      copyOnWrite();
      instance.setOtherId(value);
      return this;
    }
    /**
     * <code>int64 OtherId = 9;</code>
     */
    public Builder clearOtherId() {
      copyOnWrite();
      instance.clearOtherId();
      return this;
    }

    /**
     * <code>string ChatKey = 11;</code>
     */
    public java.lang.String getChatKey() {
      return instance.getChatKey();
    }
    /**
     * <code>string ChatKey = 11;</code>
     */
    public com.google.protobuf.ByteString
        getChatKeyBytes() {
      return instance.getChatKeyBytes();
    }
    /**
     * <code>string ChatKey = 11;</code>
     */
    public Builder setChatKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setChatKey(value);
      return this;
    }
    /**
     * <code>string ChatKey = 11;</code>
     */
    public Builder clearChatKey() {
      copyOnWrite();
      instance.clearChatKey();
      return this;
    }
    /**
     * <code>string ChatKey = 11;</code>
     */
    public Builder setChatKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setChatKeyBytes(value);
      return this;
    }

    /**
     * <code>int32 PeerUserId = 13;</code>
     */
    public int getPeerUserId() {
      return instance.getPeerUserId();
    }
    /**
     * <code>int32 PeerUserId = 13;</code>
     */
    public Builder setPeerUserId(int value) {
      copyOnWrite();
      instance.setPeerUserId(value);
      return this;
    }
    /**
     * <code>int32 PeerUserId = 13;</code>
     */
    public Builder clearPeerUserId() {
      copyOnWrite();
      instance.clearPeerUserId();
      return this;
    }

    /**
     * <code>int32 EventType = 15;</code>
     */
    public int getEventType() {
      return instance.getEventType();
    }
    /**
     * <code>int32 EventType = 15;</code>
     */
    public Builder setEventType(int value) {
      copyOnWrite();
      instance.setEventType(value);
      return this;
    }
    /**
     * <code>int32 EventType = 15;</code>
     */
    public Builder clearEventType() {
      copyOnWrite();
      instance.clearEventType();
      return this;
    }

    /**
     * <code>int32 RoomLogTypeId = 17;</code>
     */
    public int getRoomLogTypeId() {
      return instance.getRoomLogTypeId();
    }
    /**
     * <code>int32 RoomLogTypeId = 17;</code>
     */
    public Builder setRoomLogTypeId(int value) {
      copyOnWrite();
      instance.setRoomLogTypeId(value);
      return this;
    }
    /**
     * <code>int32 RoomLogTypeId = 17;</code>
     */
    public Builder clearRoomLogTypeId() {
      copyOnWrite();
      instance.clearRoomLogTypeId();
      return this;
    }

    /**
     * <code>int32 FromSeq = 19;</code>
     */
    public int getFromSeq() {
      return instance.getFromSeq();
    }
    /**
     * <code>int32 FromSeq = 19;</code>
     */
    public Builder setFromSeq(int value) {
      copyOnWrite();
      instance.setFromSeq(value);
      return this;
    }
    /**
     * <code>int32 FromSeq = 19;</code>
     */
    public Builder clearFromSeq() {
      copyOnWrite();
      instance.clearFromSeq();
      return this;
    }

    /**
     * <code>int32 ToSeq = 21;</code>
     */
    public int getToSeq() {
      return instance.getToSeq();
    }
    /**
     * <code>int32 ToSeq = 21;</code>
     */
    public Builder setToSeq(int value) {
      copyOnWrite();
      instance.setToSeq(value);
      return this;
    }
    /**
     * <code>int32 ToSeq = 21;</code>
     */
    public Builder clearToSeq() {
      copyOnWrite();
      instance.clearToSeq();
      return this;
    }

    /**
     * <code>bytes ExtraPB = 23;</code>
     */
    public com.google.protobuf.ByteString getExtraPB() {
      return instance.getExtraPB();
    }
    /**
     * <code>bytes ExtraPB = 23;</code>
     */
    public Builder setExtraPB(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setExtraPB(value);
      return this;
    }
    /**
     * <code>bytes ExtraPB = 23;</code>
     */
    public Builder clearExtraPB() {
      copyOnWrite();
      instance.clearExtraPB();
      return this;
    }

    /**
     * <code>string ExtraJson = 25;</code>
     */
    public java.lang.String getExtraJson() {
      return instance.getExtraJson();
    }
    /**
     * <code>string ExtraJson = 25;</code>
     */
    public com.google.protobuf.ByteString
        getExtraJsonBytes() {
      return instance.getExtraJsonBytes();
    }
    /**
     * <code>string ExtraJson = 25;</code>
     */
    public Builder setExtraJson(
        java.lang.String value) {
      copyOnWrite();
      instance.setExtraJson(value);
      return this;
    }
    /**
     * <code>string ExtraJson = 25;</code>
     */
    public Builder clearExtraJson() {
      copyOnWrite();
      instance.clearExtraJson();
      return this;
    }
    /**
     * <code>string ExtraJson = 25;</code>
     */
    public Builder setExtraJsonBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setExtraJsonBytes(value);
      return this;
    }

    /**
     * <code>int64 AtTimeMs = 27;</code>
     */
    public long getAtTimeMs() {
      return instance.getAtTimeMs();
    }
    /**
     * <code>int64 AtTimeMs = 27;</code>
     */
    public Builder setAtTimeMs(long value) {
      copyOnWrite();
      instance.setAtTimeMs(value);
      return this;
    }
    /**
     * <code>int64 AtTimeMs = 27;</code>
     */
    public Builder clearAtTimeMs() {
      copyOnWrite();
      instance.clearAtTimeMs();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_DirectUpdate)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_DirectUpdate();
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
        ir.ms.pb.PB_DirectUpdate other = (ir.ms.pb.PB_DirectUpdate) arg1;
        directUpdateId_ = visitor.visitLong(directUpdateId_ != 0L, directUpdateId_,
            other.directUpdateId_ != 0L, other.directUpdateId_);
        toUserId_ = visitor.visitInt(toUserId_ != 0, toUserId_,
            other.toUserId_ != 0, other.toUserId_);
        messageId_ = visitor.visitLong(messageId_ != 0L, messageId_,
            other.messageId_ != 0L, other.messageId_);
        messageFileId_ = visitor.visitLong(messageFileId_ != 0L, messageFileId_,
            other.messageFileId_ != 0L, other.messageFileId_);
        otherId_ = visitor.visitLong(otherId_ != 0L, otherId_,
            other.otherId_ != 0L, other.otherId_);
        chatKey_ = visitor.visitString(!chatKey_.isEmpty(), chatKey_,
            !other.chatKey_.isEmpty(), other.chatKey_);
        peerUserId_ = visitor.visitInt(peerUserId_ != 0, peerUserId_,
            other.peerUserId_ != 0, other.peerUserId_);
        eventType_ = visitor.visitInt(eventType_ != 0, eventType_,
            other.eventType_ != 0, other.eventType_);
        roomLogTypeId_ = visitor.visitInt(roomLogTypeId_ != 0, roomLogTypeId_,
            other.roomLogTypeId_ != 0, other.roomLogTypeId_);
        fromSeq_ = visitor.visitInt(fromSeq_ != 0, fromSeq_,
            other.fromSeq_ != 0, other.fromSeq_);
        toSeq_ = visitor.visitInt(toSeq_ != 0, toSeq_,
            other.toSeq_ != 0, other.toSeq_);
        extraPB_ = visitor.visitByteString(extraPB_ != com.google.protobuf.ByteString.EMPTY, extraPB_,
            other.extraPB_ != com.google.protobuf.ByteString.EMPTY, other.extraPB_);
        extraJson_ = visitor.visitString(!extraJson_.isEmpty(), extraJson_,
            !other.extraJson_.isEmpty(), other.extraJson_);
        atTimeMs_ = visitor.visitLong(atTimeMs_ != 0L, atTimeMs_,
            other.atTimeMs_ != 0L, other.atTimeMs_);
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

                directUpdateId_ = input.readInt64();
                break;
              }
              case 24: {

                toUserId_ = input.readInt32();
                break;
              }
              case 40: {

                messageId_ = input.readInt64();
                break;
              }
              case 56: {

                messageFileId_ = input.readInt64();
                break;
              }
              case 72: {

                otherId_ = input.readInt64();
                break;
              }
              case 90: {
                String s = input.readStringRequireUtf8();

                chatKey_ = s;
                break;
              }
              case 104: {

                peerUserId_ = input.readInt32();
                break;
              }
              case 120: {

                eventType_ = input.readInt32();
                break;
              }
              case 136: {

                roomLogTypeId_ = input.readInt32();
                break;
              }
              case 152: {

                fromSeq_ = input.readInt32();
                break;
              }
              case 168: {

                toSeq_ = input.readInt32();
                break;
              }
              case 186: {

                extraPB_ = input.readBytes();
                break;
              }
              case 202: {
                String s = input.readStringRequireUtf8();

                extraJson_ = s;
                break;
              }
              case 216: {

                atTimeMs_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_DirectUpdate.class) {
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


  // @@protoc_insertion_point(class_scope:PB_DirectUpdate)
  private static final ir.ms.pb.PB_DirectUpdate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_DirectUpdate();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_DirectUpdate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_DirectUpdate> PARSER;

  public static com.google.protobuf.Parser<PB_DirectUpdate> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

