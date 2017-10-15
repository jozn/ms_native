// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Chat}
 */
public  final class PB_Chat extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Chat, PB_Chat.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Chat)
    PB_ChatOrBuilder {
  private PB_Chat() {
    chatKey_ = "";
    roomKey_ = "";
  }
  public static final int CHATKEY_FIELD_NUMBER = 1;
  private java.lang.String chatKey_;
  /**
   * <code>string ChatKey = 1;</code>
   */
  public java.lang.String getChatKey() {
    return chatKey_;
  }
  /**
   * <code>string ChatKey = 1;</code>
   */
  public com.google.protobuf.ByteString
      getChatKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(chatKey_);
  }
  /**
   * <code>string ChatKey = 1;</code>
   */
  private void setChatKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    chatKey_ = value;
  }
  /**
   * <code>string ChatKey = 1;</code>
   */
  private void clearChatKey() {
    
    chatKey_ = getDefaultInstance().getChatKey();
  }
  /**
   * <code>string ChatKey = 1;</code>
   */
  private void setChatKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    chatKey_ = value.toStringUtf8();
  }

  public static final int ROOMKEY_FIELD_NUMBER = 3;
  private java.lang.String roomKey_;
  /**
   * <code>string RoomKey = 3;</code>
   */
  public java.lang.String getRoomKey() {
    return roomKey_;
  }
  /**
   * <code>string RoomKey = 3;</code>
   */
  public com.google.protobuf.ByteString
      getRoomKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(roomKey_);
  }
  /**
   * <code>string RoomKey = 3;</code>
   */
  private void setRoomKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    roomKey_ = value;
  }
  /**
   * <code>string RoomKey = 3;</code>
   */
  private void clearRoomKey() {
    
    roomKey_ = getDefaultInstance().getRoomKey();
  }
  /**
   * <code>string RoomKey = 3;</code>
   */
  private void setRoomKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    roomKey_ = value.toStringUtf8();
  }

  public static final int ROOMTYPEENUMID_FIELD_NUMBER = 5;
  private int roomTypeEnumId_;
  /**
   * <code>int32 RoomTypeEnumId = 5;</code>
   */
  public int getRoomTypeEnumId() {
    return roomTypeEnumId_;
  }
  /**
   * <code>int32 RoomTypeEnumId = 5;</code>
   */
  private void setRoomTypeEnumId(int value) {
    
    roomTypeEnumId_ = value;
  }
  /**
   * <code>int32 RoomTypeEnumId = 5;</code>
   */
  private void clearRoomTypeEnumId() {
    
    roomTypeEnumId_ = 0;
  }

  public static final int USERID_FIELD_NUMBER = 7;
  private int userId_;
  /**
   * <code>int32 UserId = 7;</code>
   */
  public int getUserId() {
    return userId_;
  }
  /**
   * <code>int32 UserId = 7;</code>
   */
  private void setUserId(int value) {
    
    userId_ = value;
  }
  /**
   * <code>int32 UserId = 7;</code>
   */
  private void clearUserId() {
    
    userId_ = 0;
  }

  public static final int PEERUSERID_FIELD_NUMBER = 9;
  private int peerUserId_;
  /**
   * <code>int32 PeerUserId = 9;</code>
   */
  public int getPeerUserId() {
    return peerUserId_;
  }
  /**
   * <code>int32 PeerUserId = 9;</code>
   */
  private void setPeerUserId(int value) {
    
    peerUserId_ = value;
  }
  /**
   * <code>int32 PeerUserId = 9;</code>
   */
  private void clearPeerUserId() {
    
    peerUserId_ = 0;
  }

  public static final int GROUPID_FIELD_NUMBER = 11;
  private long groupId_;
  /**
   * <code>int64 GroupId = 11;</code>
   */
  public long getGroupId() {
    return groupId_;
  }
  /**
   * <code>int64 GroupId = 11;</code>
   */
  private void setGroupId(long value) {
    
    groupId_ = value;
  }
  /**
   * <code>int64 GroupId = 11;</code>
   */
  private void clearGroupId() {
    
    groupId_ = 0L;
  }

  public static final int CREATEDSE_FIELD_NUMBER = 13;
  private int createdSe_;
  /**
   * <code>int32 CreatedSe = 13;</code>
   */
  public int getCreatedSe() {
    return createdSe_;
  }
  /**
   * <code>int32 CreatedSe = 13;</code>
   */
  private void setCreatedSe(int value) {
    
    createdSe_ = value;
  }
  /**
   * <code>int32 CreatedSe = 13;</code>
   */
  private void clearCreatedSe() {
    
    createdSe_ = 0;
  }

  public static final int STARTMESSAGEIDFROM_FIELD_NUMBER = 15;
  private long startMessageIdFrom_;
  /**
   * <code>int64 StartMessageIdFrom = 15;</code>
   */
  public long getStartMessageIdFrom() {
    return startMessageIdFrom_;
  }
  /**
   * <code>int64 StartMessageIdFrom = 15;</code>
   */
  private void setStartMessageIdFrom(long value) {
    
    startMessageIdFrom_ = value;
  }
  /**
   * <code>int64 StartMessageIdFrom = 15;</code>
   */
  private void clearStartMessageIdFrom() {
    
    startMessageIdFrom_ = 0L;
  }

  public static final int LASTSEENMESSAGEID_FIELD_NUMBER = 17;
  private long lastSeenMessageId_;
  /**
   * <code>int64 LastSeenMessageId = 17;</code>
   */
  public long getLastSeenMessageId() {
    return lastSeenMessageId_;
  }
  /**
   * <code>int64 LastSeenMessageId = 17;</code>
   */
  private void setLastSeenMessageId(long value) {
    
    lastSeenMessageId_ = value;
  }
  /**
   * <code>int64 LastSeenMessageId = 17;</code>
   */
  private void clearLastSeenMessageId() {
    
    lastSeenMessageId_ = 0L;
  }

  public static final int UPDATEDMS_FIELD_NUMBER = 19;
  private long updatedMs_;
  /**
   * <code>int64 UpdatedMs = 19;</code>
   */
  public long getUpdatedMs() {
    return updatedMs_;
  }
  /**
   * <code>int64 UpdatedMs = 19;</code>
   */
  private void setUpdatedMs(long value) {
    
    updatedMs_ = value;
  }
  /**
   * <code>int64 UpdatedMs = 19;</code>
   */
  private void clearUpdatedMs() {
    
    updatedMs_ = 0L;
  }

  public static final int LASTMESSAGEID_FIELD_NUMBER = 21;
  private long lastMessageId_;
  /**
   * <code>int64 LastMessageId = 21;</code>
   */
  public long getLastMessageId() {
    return lastMessageId_;
  }
  /**
   * <code>int64 LastMessageId = 21;</code>
   */
  private void setLastMessageId(long value) {
    
    lastMessageId_ = value;
  }
  /**
   * <code>int64 LastMessageId = 21;</code>
   */
  private void clearLastMessageId() {
    
    lastMessageId_ = 0L;
  }

  public static final int LASTDELETEDMESSAGEID_FIELD_NUMBER = 23;
  private long lastDeletedMessageId_;
  /**
   * <code>int64 LastDeletedMessageId = 23;</code>
   */
  public long getLastDeletedMessageId() {
    return lastDeletedMessageId_;
  }
  /**
   * <code>int64 LastDeletedMessageId = 23;</code>
   */
  private void setLastDeletedMessageId(long value) {
    
    lastDeletedMessageId_ = value;
  }
  /**
   * <code>int64 LastDeletedMessageId = 23;</code>
   */
  private void clearLastDeletedMessageId() {
    
    lastDeletedMessageId_ = 0L;
  }

  public static final int LASTSEQSEEN_FIELD_NUMBER = 25;
  private int lastSeqSeen_;
  /**
   * <code>int32 LastSeqSeen = 25;</code>
   */
  public int getLastSeqSeen() {
    return lastSeqSeen_;
  }
  /**
   * <code>int32 LastSeqSeen = 25;</code>
   */
  private void setLastSeqSeen(int value) {
    
    lastSeqSeen_ = value;
  }
  /**
   * <code>int32 LastSeqSeen = 25;</code>
   */
  private void clearLastSeqSeen() {
    
    lastSeqSeen_ = 0;
  }

  public static final int LASTSEQDELETE_FIELD_NUMBER = 27;
  private int lastSeqDelete_;
  /**
   * <code>int32 LastSeqDelete = 27;</code>
   */
  public int getLastSeqDelete() {
    return lastSeqDelete_;
  }
  /**
   * <code>int32 LastSeqDelete = 27;</code>
   */
  private void setLastSeqDelete(int value) {
    
    lastSeqDelete_ = value;
  }
  /**
   * <code>int32 LastSeqDelete = 27;</code>
   */
  private void clearLastSeqDelete() {
    
    lastSeqDelete_ = 0;
  }

  public static final int CURRENTSEQ_FIELD_NUMBER = 29;
  private int currentSeq_;
  /**
   * <code>int32 CurrentSeq = 29;</code>
   */
  public int getCurrentSeq() {
    return currentSeq_;
  }
  /**
   * <code>int32 CurrentSeq = 29;</code>
   */
  private void setCurrentSeq(int value) {
    
    currentSeq_ = value;
  }
  /**
   * <code>int32 CurrentSeq = 29;</code>
   */
  private void clearCurrentSeq() {
    
    currentSeq_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!chatKey_.isEmpty()) {
      output.writeString(1, getChatKey());
    }
    if (!roomKey_.isEmpty()) {
      output.writeString(3, getRoomKey());
    }
    if (roomTypeEnumId_ != 0) {
      output.writeInt32(5, roomTypeEnumId_);
    }
    if (userId_ != 0) {
      output.writeInt32(7, userId_);
    }
    if (peerUserId_ != 0) {
      output.writeInt32(9, peerUserId_);
    }
    if (groupId_ != 0L) {
      output.writeInt64(11, groupId_);
    }
    if (createdSe_ != 0) {
      output.writeInt32(13, createdSe_);
    }
    if (startMessageIdFrom_ != 0L) {
      output.writeInt64(15, startMessageIdFrom_);
    }
    if (lastSeenMessageId_ != 0L) {
      output.writeInt64(17, lastSeenMessageId_);
    }
    if (updatedMs_ != 0L) {
      output.writeInt64(19, updatedMs_);
    }
    if (lastMessageId_ != 0L) {
      output.writeInt64(21, lastMessageId_);
    }
    if (lastDeletedMessageId_ != 0L) {
      output.writeInt64(23, lastDeletedMessageId_);
    }
    if (lastSeqSeen_ != 0) {
      output.writeInt32(25, lastSeqSeen_);
    }
    if (lastSeqDelete_ != 0) {
      output.writeInt32(27, lastSeqDelete_);
    }
    if (currentSeq_ != 0) {
      output.writeInt32(29, currentSeq_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!chatKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getChatKey());
    }
    if (!roomKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getRoomKey());
    }
    if (roomTypeEnumId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, roomTypeEnumId_);
    }
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, userId_);
    }
    if (peerUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, peerUserId_);
    }
    if (groupId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(11, groupId_);
    }
    if (createdSe_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, createdSe_);
    }
    if (startMessageIdFrom_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(15, startMessageIdFrom_);
    }
    if (lastSeenMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(17, lastSeenMessageId_);
    }
    if (updatedMs_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(19, updatedMs_);
    }
    if (lastMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(21, lastMessageId_);
    }
    if (lastDeletedMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(23, lastDeletedMessageId_);
    }
    if (lastSeqSeen_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(25, lastSeqSeen_);
    }
    if (lastSeqDelete_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(27, lastSeqDelete_);
    }
    if (currentSeq_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(29, currentSeq_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Chat parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Chat parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Chat parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Chat parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Chat parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Chat parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Chat parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Chat parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Chat parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Chat parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Chat prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Chat}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Chat, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Chat)
      ir.ms.pb.PB_ChatOrBuilder {
    // Construct using ir.ms.pb.PB_Chat.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>string ChatKey = 1;</code>
     */
    public java.lang.String getChatKey() {
      return instance.getChatKey();
    }
    /**
     * <code>string ChatKey = 1;</code>
     */
    public com.google.protobuf.ByteString
        getChatKeyBytes() {
      return instance.getChatKeyBytes();
    }
    /**
     * <code>string ChatKey = 1;</code>
     */
    public Builder setChatKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setChatKey(value);
      return this;
    }
    /**
     * <code>string ChatKey = 1;</code>
     */
    public Builder clearChatKey() {
      copyOnWrite();
      instance.clearChatKey();
      return this;
    }
    /**
     * <code>string ChatKey = 1;</code>
     */
    public Builder setChatKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setChatKeyBytes(value);
      return this;
    }

    /**
     * <code>string RoomKey = 3;</code>
     */
    public java.lang.String getRoomKey() {
      return instance.getRoomKey();
    }
    /**
     * <code>string RoomKey = 3;</code>
     */
    public com.google.protobuf.ByteString
        getRoomKeyBytes() {
      return instance.getRoomKeyBytes();
    }
    /**
     * <code>string RoomKey = 3;</code>
     */
    public Builder setRoomKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setRoomKey(value);
      return this;
    }
    /**
     * <code>string RoomKey = 3;</code>
     */
    public Builder clearRoomKey() {
      copyOnWrite();
      instance.clearRoomKey();
      return this;
    }
    /**
     * <code>string RoomKey = 3;</code>
     */
    public Builder setRoomKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRoomKeyBytes(value);
      return this;
    }

    /**
     * <code>int32 RoomTypeEnumId = 5;</code>
     */
    public int getRoomTypeEnumId() {
      return instance.getRoomTypeEnumId();
    }
    /**
     * <code>int32 RoomTypeEnumId = 5;</code>
     */
    public Builder setRoomTypeEnumId(int value) {
      copyOnWrite();
      instance.setRoomTypeEnumId(value);
      return this;
    }
    /**
     * <code>int32 RoomTypeEnumId = 5;</code>
     */
    public Builder clearRoomTypeEnumId() {
      copyOnWrite();
      instance.clearRoomTypeEnumId();
      return this;
    }

    /**
     * <code>int32 UserId = 7;</code>
     */
    public int getUserId() {
      return instance.getUserId();
    }
    /**
     * <code>int32 UserId = 7;</code>
     */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /**
     * <code>int32 UserId = 7;</code>
     */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /**
     * <code>int32 PeerUserId = 9;</code>
     */
    public int getPeerUserId() {
      return instance.getPeerUserId();
    }
    /**
     * <code>int32 PeerUserId = 9;</code>
     */
    public Builder setPeerUserId(int value) {
      copyOnWrite();
      instance.setPeerUserId(value);
      return this;
    }
    /**
     * <code>int32 PeerUserId = 9;</code>
     */
    public Builder clearPeerUserId() {
      copyOnWrite();
      instance.clearPeerUserId();
      return this;
    }

    /**
     * <code>int64 GroupId = 11;</code>
     */
    public long getGroupId() {
      return instance.getGroupId();
    }
    /**
     * <code>int64 GroupId = 11;</code>
     */
    public Builder setGroupId(long value) {
      copyOnWrite();
      instance.setGroupId(value);
      return this;
    }
    /**
     * <code>int64 GroupId = 11;</code>
     */
    public Builder clearGroupId() {
      copyOnWrite();
      instance.clearGroupId();
      return this;
    }

    /**
     * <code>int32 CreatedSe = 13;</code>
     */
    public int getCreatedSe() {
      return instance.getCreatedSe();
    }
    /**
     * <code>int32 CreatedSe = 13;</code>
     */
    public Builder setCreatedSe(int value) {
      copyOnWrite();
      instance.setCreatedSe(value);
      return this;
    }
    /**
     * <code>int32 CreatedSe = 13;</code>
     */
    public Builder clearCreatedSe() {
      copyOnWrite();
      instance.clearCreatedSe();
      return this;
    }

    /**
     * <code>int64 StartMessageIdFrom = 15;</code>
     */
    public long getStartMessageIdFrom() {
      return instance.getStartMessageIdFrom();
    }
    /**
     * <code>int64 StartMessageIdFrom = 15;</code>
     */
    public Builder setStartMessageIdFrom(long value) {
      copyOnWrite();
      instance.setStartMessageIdFrom(value);
      return this;
    }
    /**
     * <code>int64 StartMessageIdFrom = 15;</code>
     */
    public Builder clearStartMessageIdFrom() {
      copyOnWrite();
      instance.clearStartMessageIdFrom();
      return this;
    }

    /**
     * <code>int64 LastSeenMessageId = 17;</code>
     */
    public long getLastSeenMessageId() {
      return instance.getLastSeenMessageId();
    }
    /**
     * <code>int64 LastSeenMessageId = 17;</code>
     */
    public Builder setLastSeenMessageId(long value) {
      copyOnWrite();
      instance.setLastSeenMessageId(value);
      return this;
    }
    /**
     * <code>int64 LastSeenMessageId = 17;</code>
     */
    public Builder clearLastSeenMessageId() {
      copyOnWrite();
      instance.clearLastSeenMessageId();
      return this;
    }

    /**
     * <code>int64 UpdatedMs = 19;</code>
     */
    public long getUpdatedMs() {
      return instance.getUpdatedMs();
    }
    /**
     * <code>int64 UpdatedMs = 19;</code>
     */
    public Builder setUpdatedMs(long value) {
      copyOnWrite();
      instance.setUpdatedMs(value);
      return this;
    }
    /**
     * <code>int64 UpdatedMs = 19;</code>
     */
    public Builder clearUpdatedMs() {
      copyOnWrite();
      instance.clearUpdatedMs();
      return this;
    }

    /**
     * <code>int64 LastMessageId = 21;</code>
     */
    public long getLastMessageId() {
      return instance.getLastMessageId();
    }
    /**
     * <code>int64 LastMessageId = 21;</code>
     */
    public Builder setLastMessageId(long value) {
      copyOnWrite();
      instance.setLastMessageId(value);
      return this;
    }
    /**
     * <code>int64 LastMessageId = 21;</code>
     */
    public Builder clearLastMessageId() {
      copyOnWrite();
      instance.clearLastMessageId();
      return this;
    }

    /**
     * <code>int64 LastDeletedMessageId = 23;</code>
     */
    public long getLastDeletedMessageId() {
      return instance.getLastDeletedMessageId();
    }
    /**
     * <code>int64 LastDeletedMessageId = 23;</code>
     */
    public Builder setLastDeletedMessageId(long value) {
      copyOnWrite();
      instance.setLastDeletedMessageId(value);
      return this;
    }
    /**
     * <code>int64 LastDeletedMessageId = 23;</code>
     */
    public Builder clearLastDeletedMessageId() {
      copyOnWrite();
      instance.clearLastDeletedMessageId();
      return this;
    }

    /**
     * <code>int32 LastSeqSeen = 25;</code>
     */
    public int getLastSeqSeen() {
      return instance.getLastSeqSeen();
    }
    /**
     * <code>int32 LastSeqSeen = 25;</code>
     */
    public Builder setLastSeqSeen(int value) {
      copyOnWrite();
      instance.setLastSeqSeen(value);
      return this;
    }
    /**
     * <code>int32 LastSeqSeen = 25;</code>
     */
    public Builder clearLastSeqSeen() {
      copyOnWrite();
      instance.clearLastSeqSeen();
      return this;
    }

    /**
     * <code>int32 LastSeqDelete = 27;</code>
     */
    public int getLastSeqDelete() {
      return instance.getLastSeqDelete();
    }
    /**
     * <code>int32 LastSeqDelete = 27;</code>
     */
    public Builder setLastSeqDelete(int value) {
      copyOnWrite();
      instance.setLastSeqDelete(value);
      return this;
    }
    /**
     * <code>int32 LastSeqDelete = 27;</code>
     */
    public Builder clearLastSeqDelete() {
      copyOnWrite();
      instance.clearLastSeqDelete();
      return this;
    }

    /**
     * <code>int32 CurrentSeq = 29;</code>
     */
    public int getCurrentSeq() {
      return instance.getCurrentSeq();
    }
    /**
     * <code>int32 CurrentSeq = 29;</code>
     */
    public Builder setCurrentSeq(int value) {
      copyOnWrite();
      instance.setCurrentSeq(value);
      return this;
    }
    /**
     * <code>int32 CurrentSeq = 29;</code>
     */
    public Builder clearCurrentSeq() {
      copyOnWrite();
      instance.clearCurrentSeq();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_Chat)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Chat();
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
        ir.ms.pb.PB_Chat other = (ir.ms.pb.PB_Chat) arg1;
        chatKey_ = visitor.visitString(!chatKey_.isEmpty(), chatKey_,
            !other.chatKey_.isEmpty(), other.chatKey_);
        roomKey_ = visitor.visitString(!roomKey_.isEmpty(), roomKey_,
            !other.roomKey_.isEmpty(), other.roomKey_);
        roomTypeEnumId_ = visitor.visitInt(roomTypeEnumId_ != 0, roomTypeEnumId_,
            other.roomTypeEnumId_ != 0, other.roomTypeEnumId_);
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        peerUserId_ = visitor.visitInt(peerUserId_ != 0, peerUserId_,
            other.peerUserId_ != 0, other.peerUserId_);
        groupId_ = visitor.visitLong(groupId_ != 0L, groupId_,
            other.groupId_ != 0L, other.groupId_);
        createdSe_ = visitor.visitInt(createdSe_ != 0, createdSe_,
            other.createdSe_ != 0, other.createdSe_);
        startMessageIdFrom_ = visitor.visitLong(startMessageIdFrom_ != 0L, startMessageIdFrom_,
            other.startMessageIdFrom_ != 0L, other.startMessageIdFrom_);
        lastSeenMessageId_ = visitor.visitLong(lastSeenMessageId_ != 0L, lastSeenMessageId_,
            other.lastSeenMessageId_ != 0L, other.lastSeenMessageId_);
        updatedMs_ = visitor.visitLong(updatedMs_ != 0L, updatedMs_,
            other.updatedMs_ != 0L, other.updatedMs_);
        lastMessageId_ = visitor.visitLong(lastMessageId_ != 0L, lastMessageId_,
            other.lastMessageId_ != 0L, other.lastMessageId_);
        lastDeletedMessageId_ = visitor.visitLong(lastDeletedMessageId_ != 0L, lastDeletedMessageId_,
            other.lastDeletedMessageId_ != 0L, other.lastDeletedMessageId_);
        lastSeqSeen_ = visitor.visitInt(lastSeqSeen_ != 0, lastSeqSeen_,
            other.lastSeqSeen_ != 0, other.lastSeqSeen_);
        lastSeqDelete_ = visitor.visitInt(lastSeqDelete_ != 0, lastSeqDelete_,
            other.lastSeqDelete_ != 0, other.lastSeqDelete_);
        currentSeq_ = visitor.visitInt(currentSeq_ != 0, currentSeq_,
            other.currentSeq_ != 0, other.currentSeq_);
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

                chatKey_ = s;
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                roomKey_ = s;
                break;
              }
              case 40: {

                roomTypeEnumId_ = input.readInt32();
                break;
              }
              case 56: {

                userId_ = input.readInt32();
                break;
              }
              case 72: {

                peerUserId_ = input.readInt32();
                break;
              }
              case 88: {

                groupId_ = input.readInt64();
                break;
              }
              case 104: {

                createdSe_ = input.readInt32();
                break;
              }
              case 120: {

                startMessageIdFrom_ = input.readInt64();
                break;
              }
              case 136: {

                lastSeenMessageId_ = input.readInt64();
                break;
              }
              case 152: {

                updatedMs_ = input.readInt64();
                break;
              }
              case 168: {

                lastMessageId_ = input.readInt64();
                break;
              }
              case 184: {

                lastDeletedMessageId_ = input.readInt64();
                break;
              }
              case 200: {

                lastSeqSeen_ = input.readInt32();
                break;
              }
              case 216: {

                lastSeqDelete_ = input.readInt32();
                break;
              }
              case 232: {

                currentSeq_ = input.readInt32();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Chat.class) {
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


  // @@protoc_insertion_point(class_scope:PB_Chat)
  private static final ir.ms.pb.PB_Chat DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Chat();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Chat getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Chat> PARSER;

  public static com.google.protobuf.Parser<PB_Chat> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

