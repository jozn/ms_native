// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_views.proto

package ir.ms.pb;

/** Protobuf type {@code PB_MessageView} */
public final class PB_MessageView
    extends com.google.protobuf.GeneratedMessageLite<PB_MessageView, PB_MessageView.Builder>
    implements
    // @@protoc_insertion_point(message_implements:PB_MessageView)
    PB_MessageViewOrBuilder {
  private PB_MessageView() {
    roomKey_ = "";
    text_ = "";
  }

  public static final int MESSAGEID_FIELD_NUMBER = 1;
  private long messageId_;
  /** <code>uint64 MessageId = 1;</code> */
  public long getMessageId() {
    return messageId_;
  }
  /** <code>uint64 MessageId = 1;</code> */
  private void setMessageId(long value) {

    messageId_ = value;
  }
  /** <code>uint64 MessageId = 1;</code> */
  private void clearMessageId() {

    messageId_ = 0L;
  }

  public static final int ROOMKEY_FIELD_NUMBER = 3;
  private java.lang.String roomKey_;
  /** <code>string RoomKey = 3;</code> */
  public java.lang.String getRoomKey() {
    return roomKey_;
  }
  /** <code>string RoomKey = 3;</code> */
  public com.google.protobuf.ByteString getRoomKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(roomKey_);
  }
  /** <code>string RoomKey = 3;</code> */
  private void setRoomKey(java.lang.String value) {
    if (value == null) {
      throw new NullPointerException();
    }

    roomKey_ = value;
  }
  /** <code>string RoomKey = 3;</code> */
  private void clearRoomKey() {

    roomKey_ = getDefaultInstance().getRoomKey();
  }
  /** <code>string RoomKey = 3;</code> */
  private void setRoomKeyBytes(com.google.protobuf.ByteString value) {
    if (value == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(value);

    roomKey_ = value.toStringUtf8();
  }

  public static final int USERID_FIELD_NUMBER = 5;
  private int userId_;
  /** <code>int32 UserId = 5;</code> */
  public int getUserId() {
    return userId_;
  }
  /** <code>int32 UserId = 5;</code> */
  private void setUserId(int value) {

    userId_ = value;
  }
  /** <code>int32 UserId = 5;</code> */
  private void clearUserId() {

    userId_ = 0;
  }

  public static final int MESSAGEFILEID_FIELD_NUMBER = 7;
  private long messageFileId_;
  /** <code>int64 MessageFileId = 7;</code> */
  public long getMessageFileId() {
    return messageFileId_;
  }
  /** <code>int64 MessageFileId = 7;</code> */
  private void setMessageFileId(long value) {

    messageFileId_ = value;
  }
  /** <code>int64 MessageFileId = 7;</code> */
  private void clearMessageFileId() {

    messageFileId_ = 0L;
  }

  public static final int MESSAGETYPEENUMID_FIELD_NUMBER = 9;
  private int messageTypeEnumId_;
  /** <code>int32 MessageTypeEnumId = 9;</code> */
  public int getMessageTypeEnumId() {
    return messageTypeEnumId_;
  }
  /** <code>int32 MessageTypeEnumId = 9;</code> */
  private void setMessageTypeEnumId(int value) {

    messageTypeEnumId_ = value;
  }
  /** <code>int32 MessageTypeEnumId = 9;</code> */
  private void clearMessageTypeEnumId() {

    messageTypeEnumId_ = 0;
  }

  public static final int TEXT_FIELD_NUMBER = 11;
  private java.lang.String text_;
  /** <code>string Text = 11;</code> */
  public java.lang.String getText() {
    return text_;
  }
  /** <code>string Text = 11;</code> */
  public com.google.protobuf.ByteString getTextBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(text_);
  }
  /** <code>string Text = 11;</code> */
  private void setText(java.lang.String value) {
    if (value == null) {
      throw new NullPointerException();
    }

    text_ = value;
  }
  /** <code>string Text = 11;</code> */
  private void clearText() {

    text_ = getDefaultInstance().getText();
  }
  /** <code>string Text = 11;</code> */
  private void setTextBytes(com.google.protobuf.ByteString value) {
    if (value == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(value);

    text_ = value.toStringUtf8();
  }

  public static final int TIME_FIELD_NUMBER = 13;
  private int time_;
  /** <code>int32 Time = 13;</code> */
  public int getTime() {
    return time_;
  }
  /** <code>int32 Time = 13;</code> */
  private void setTime(int value) {

    time_ = value;
  }
  /** <code>int32 Time = 13;</code> */
  private void clearTime() {

    time_ = 0;
  }

  public static final int PEERRECEIVEDTIME_FIELD_NUMBER = 15;
  private int peerReceivedTime_;
  /** <code>int32 PeerReceivedTime = 15;</code> */
  public int getPeerReceivedTime() {
    return peerReceivedTime_;
  }
  /** <code>int32 PeerReceivedTime = 15;</code> */
  private void setPeerReceivedTime(int value) {

    peerReceivedTime_ = value;
  }
  /** <code>int32 PeerReceivedTime = 15;</code> */
  private void clearPeerReceivedTime() {

    peerReceivedTime_ = 0;
  }

  public static final int PEERSEENTIME_FIELD_NUMBER = 17;
  private int peerSeenTime_;
  /** <code>int32 PeerSeenTime = 17;</code> */
  public int getPeerSeenTime() {
    return peerSeenTime_;
  }
  /** <code>int32 PeerSeenTime = 17;</code> */
  private void setPeerSeenTime(int value) {

    peerSeenTime_ = value;
  }
  /** <code>int32 PeerSeenTime = 17;</code> */
  private void clearPeerSeenTime() {

    peerSeenTime_ = 0;
  }

  public static final int DELIVIRYSTATUSENUMID_FIELD_NUMBER = 19;
  private int deliviryStatusEnumId_;
  /** <code>int32 DeliviryStatusEnumId = 19;</code> */
  public int getDeliviryStatusEnumId() {
    return deliviryStatusEnumId_;
  }
  /** <code>int32 DeliviryStatusEnumId = 19;</code> */
  private void setDeliviryStatusEnumId(int value) {

    deliviryStatusEnumId_ = value;
  }
  /** <code>int32 DeliviryStatusEnumId = 19;</code> */
  private void clearDeliviryStatusEnumId() {

    deliviryStatusEnumId_ = 0;
  }

  public static final int CHATID_FIELD_NUMBER = 30;
  private long chatId_;
  /** <code>int64 ChatId = 30;</code> */
  public long getChatId() {
    return chatId_;
  }
  /** <code>int64 ChatId = 30;</code> */
  private void setChatId(long value) {

    chatId_ = value;
  }
  /** <code>int64 ChatId = 30;</code> */
  private void clearChatId() {

    chatId_ = 0L;
  }

  public static final int ROOMTYPEENUM_FIELD_NUMBER = 31;
  private int roomTypeEnum_;
  /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
  public int getRoomTypeEnumValue() {
    return roomTypeEnum_;
  }
  /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
  public ir.ms.pb.RoomTypeEnum getRoomTypeEnum() {
    ir.ms.pb.RoomTypeEnum result = ir.ms.pb.RoomTypeEnum.forNumber(roomTypeEnum_);
    return result == null ? ir.ms.pb.RoomTypeEnum.UNRECOGNIZED : result;
  }
  /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
  private void setRoomTypeEnumValue(int value) {
    roomTypeEnum_ = value;
  }
  /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
  private void setRoomTypeEnum(ir.ms.pb.RoomTypeEnum value) {
    if (value == null) {
      throw new NullPointerException();
    }

    roomTypeEnum_ = value.getNumber();
  }
  /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
  private void clearRoomTypeEnum() {

    roomTypeEnum_ = 0;
  }

  public static final int ISBYME_FIELD_NUMBER = 33;
  private boolean isByMe_;
  /** <code>bool IsByMe = 33;</code> */
  public boolean getIsByMe() {
    return isByMe_;
  }
  /** <code>bool IsByMe = 33;</code> */
  private void setIsByMe(boolean value) {

    isByMe_ = value;
  }
  /** <code>bool IsByMe = 33;</code> */
  private void clearIsByMe() {

    isByMe_ = false;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (messageId_ != 0L) {
      output.writeUInt64(1, messageId_);
    }
    if (!roomKey_.isEmpty()) {
      output.writeString(3, getRoomKey());
    }
    if (userId_ != 0) {
      output.writeInt32(5, userId_);
    }
    if (messageFileId_ != 0L) {
      output.writeInt64(7, messageFileId_);
    }
    if (messageTypeEnumId_ != 0) {
      output.writeInt32(9, messageTypeEnumId_);
    }
    if (!text_.isEmpty()) {
      output.writeString(11, getText());
    }
    if (time_ != 0) {
      output.writeInt32(13, time_);
    }
    if (peerReceivedTime_ != 0) {
      output.writeInt32(15, peerReceivedTime_);
    }
    if (peerSeenTime_ != 0) {
      output.writeInt32(17, peerSeenTime_);
    }
    if (deliviryStatusEnumId_ != 0) {
      output.writeInt32(19, deliviryStatusEnumId_);
    }
    if (chatId_ != 0L) {
      output.writeInt64(30, chatId_);
    }
    if (roomTypeEnum_ != ir.ms.pb.RoomTypeEnum.UNKNOWN_ROOM_TYPE.getNumber()) {
      output.writeEnum(31, roomTypeEnum_);
    }
    if (isByMe_ != false) {
      output.writeBool(33, isByMe_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeUInt64Size(1, messageId_);
    }
    if (!roomKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeStringSize(3, getRoomKey());
    }
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, userId_);
    }
    if (messageFileId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(7, messageFileId_);
    }
    if (messageTypeEnumId_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(9, messageTypeEnumId_);
    }
    if (!text_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeStringSize(11, getText());
    }
    if (time_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(13, time_);
    }
    if (peerReceivedTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(15, peerReceivedTime_);
    }
    if (peerSeenTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(17, peerSeenTime_);
    }
    if (deliviryStatusEnumId_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(19, deliviryStatusEnumId_);
    }
    if (chatId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(30, chatId_);
    }
    if (roomTypeEnum_ != ir.ms.pb.RoomTypeEnum.UNKNOWN_ROOM_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(31, roomTypeEnum_);
    }
    if (isByMe_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(33, isByMe_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MessageView parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_MessageView parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MessageView parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MessageView parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ir.ms.pb.PB_MessageView prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /** Protobuf type {@code PB_MessageView} */
  public static final class Builder
      extends com.google.protobuf.GeneratedMessageLite.Builder<ir.ms.pb.PB_MessageView, Builder>
      implements
      // @@protoc_insertion_point(builder_implements:PB_MessageView)
      ir.ms.pb.PB_MessageViewOrBuilder {
    // Construct using ir.ms.pb.PB_MessageView.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }

    /** <code>uint64 MessageId = 1;</code> */
    public long getMessageId() {
      return instance.getMessageId();
    }
    /** <code>uint64 MessageId = 1;</code> */
    public Builder setMessageId(long value) {
      copyOnWrite();
      instance.setMessageId(value);
      return this;
    }
    /** <code>uint64 MessageId = 1;</code> */
    public Builder clearMessageId() {
      copyOnWrite();
      instance.clearMessageId();
      return this;
    }

    /** <code>string RoomKey = 3;</code> */
    public java.lang.String getRoomKey() {
      return instance.getRoomKey();
    }
    /** <code>string RoomKey = 3;</code> */
    public com.google.protobuf.ByteString getRoomKeyBytes() {
      return instance.getRoomKeyBytes();
    }
    /** <code>string RoomKey = 3;</code> */
    public Builder setRoomKey(java.lang.String value) {
      copyOnWrite();
      instance.setRoomKey(value);
      return this;
    }
    /** <code>string RoomKey = 3;</code> */
    public Builder clearRoomKey() {
      copyOnWrite();
      instance.clearRoomKey();
      return this;
    }
    /** <code>string RoomKey = 3;</code> */
    public Builder setRoomKeyBytes(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRoomKeyBytes(value);
      return this;
    }

    /** <code>int32 UserId = 5;</code> */
    public int getUserId() {
      return instance.getUserId();
    }
    /** <code>int32 UserId = 5;</code> */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /** <code>int32 UserId = 5;</code> */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /** <code>int64 MessageFileId = 7;</code> */
    public long getMessageFileId() {
      return instance.getMessageFileId();
    }
    /** <code>int64 MessageFileId = 7;</code> */
    public Builder setMessageFileId(long value) {
      copyOnWrite();
      instance.setMessageFileId(value);
      return this;
    }
    /** <code>int64 MessageFileId = 7;</code> */
    public Builder clearMessageFileId() {
      copyOnWrite();
      instance.clearMessageFileId();
      return this;
    }

    /** <code>int32 MessageTypeEnumId = 9;</code> */
    public int getMessageTypeEnumId() {
      return instance.getMessageTypeEnumId();
    }
    /** <code>int32 MessageTypeEnumId = 9;</code> */
    public Builder setMessageTypeEnumId(int value) {
      copyOnWrite();
      instance.setMessageTypeEnumId(value);
      return this;
    }
    /** <code>int32 MessageTypeEnumId = 9;</code> */
    public Builder clearMessageTypeEnumId() {
      copyOnWrite();
      instance.clearMessageTypeEnumId();
      return this;
    }

    /** <code>string Text = 11;</code> */
    public java.lang.String getText() {
      return instance.getText();
    }
    /** <code>string Text = 11;</code> */
    public com.google.protobuf.ByteString getTextBytes() {
      return instance.getTextBytes();
    }
    /** <code>string Text = 11;</code> */
    public Builder setText(java.lang.String value) {
      copyOnWrite();
      instance.setText(value);
      return this;
    }
    /** <code>string Text = 11;</code> */
    public Builder clearText() {
      copyOnWrite();
      instance.clearText();
      return this;
    }
    /** <code>string Text = 11;</code> */
    public Builder setTextBytes(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setTextBytes(value);
      return this;
    }

    /** <code>int32 Time = 13;</code> */
    public int getTime() {
      return instance.getTime();
    }
    /** <code>int32 Time = 13;</code> */
    public Builder setTime(int value) {
      copyOnWrite();
      instance.setTime(value);
      return this;
    }
    /** <code>int32 Time = 13;</code> */
    public Builder clearTime() {
      copyOnWrite();
      instance.clearTime();
      return this;
    }

    /** <code>int32 PeerReceivedTime = 15;</code> */
    public int getPeerReceivedTime() {
      return instance.getPeerReceivedTime();
    }
    /** <code>int32 PeerReceivedTime = 15;</code> */
    public Builder setPeerReceivedTime(int value) {
      copyOnWrite();
      instance.setPeerReceivedTime(value);
      return this;
    }
    /** <code>int32 PeerReceivedTime = 15;</code> */
    public Builder clearPeerReceivedTime() {
      copyOnWrite();
      instance.clearPeerReceivedTime();
      return this;
    }

    /** <code>int32 PeerSeenTime = 17;</code> */
    public int getPeerSeenTime() {
      return instance.getPeerSeenTime();
    }
    /** <code>int32 PeerSeenTime = 17;</code> */
    public Builder setPeerSeenTime(int value) {
      copyOnWrite();
      instance.setPeerSeenTime(value);
      return this;
    }
    /** <code>int32 PeerSeenTime = 17;</code> */
    public Builder clearPeerSeenTime() {
      copyOnWrite();
      instance.clearPeerSeenTime();
      return this;
    }

    /** <code>int32 DeliviryStatusEnumId = 19;</code> */
    public int getDeliviryStatusEnumId() {
      return instance.getDeliviryStatusEnumId();
    }
    /** <code>int32 DeliviryStatusEnumId = 19;</code> */
    public Builder setDeliviryStatusEnumId(int value) {
      copyOnWrite();
      instance.setDeliviryStatusEnumId(value);
      return this;
    }
    /** <code>int32 DeliviryStatusEnumId = 19;</code> */
    public Builder clearDeliviryStatusEnumId() {
      copyOnWrite();
      instance.clearDeliviryStatusEnumId();
      return this;
    }

    /** <code>int64 ChatId = 30;</code> */
    public long getChatId() {
      return instance.getChatId();
    }
    /** <code>int64 ChatId = 30;</code> */
    public Builder setChatId(long value) {
      copyOnWrite();
      instance.setChatId(value);
      return this;
    }
    /** <code>int64 ChatId = 30;</code> */
    public Builder clearChatId() {
      copyOnWrite();
      instance.clearChatId();
      return this;
    }

    /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
    public int getRoomTypeEnumValue() {
      return instance.getRoomTypeEnumValue();
    }
    /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
    public Builder setRoomTypeEnumValue(int value) {
      copyOnWrite();
      instance.setRoomTypeEnumValue(value);
      return this;
    }
    /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
    public ir.ms.pb.RoomTypeEnum getRoomTypeEnum() {
      return instance.getRoomTypeEnum();
    }
    /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
    public Builder setRoomTypeEnum(ir.ms.pb.RoomTypeEnum value) {
      copyOnWrite();
      instance.setRoomTypeEnum(value);
      return this;
    }
    /** <code>.RoomTypeEnum RoomTypeEnum = 31;</code> */
    public Builder clearRoomTypeEnum() {
      copyOnWrite();
      instance.clearRoomTypeEnum();
      return this;
    }

    /** <code>bool IsByMe = 33;</code> */
    public boolean getIsByMe() {
      return instance.getIsByMe();
    }
    /** <code>bool IsByMe = 33;</code> */
    public Builder setIsByMe(boolean value) {
      copyOnWrite();
      instance.setIsByMe(value);
      return this;
    }
    /** <code>bool IsByMe = 33;</code> */
    public Builder clearIsByMe() {
      copyOnWrite();
      instance.clearIsByMe();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MessageView)
  }

  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE:
        {
          return new ir.ms.pb.PB_MessageView();
        }
      case IS_INITIALIZED:
        {
          return DEFAULT_INSTANCE;
        }
      case MAKE_IMMUTABLE:
        {
          return null;
        }
      case NEW_BUILDER:
        {
          return new Builder();
        }
      case VISIT:
        {
          Visitor visitor = (Visitor) arg0;
          ir.ms.pb.PB_MessageView other = (ir.ms.pb.PB_MessageView) arg1;
          messageId_ =
              visitor.visitLong(
                  messageId_ != 0L, messageId_, other.messageId_ != 0L, other.messageId_);
          roomKey_ =
              visitor.visitString(
                  !roomKey_.isEmpty(), roomKey_, !other.roomKey_.isEmpty(), other.roomKey_);
          userId_ = visitor.visitInt(userId_ != 0, userId_, other.userId_ != 0, other.userId_);
          messageFileId_ =
              visitor.visitLong(
                  messageFileId_ != 0L,
                  messageFileId_,
                  other.messageFileId_ != 0L,
                  other.messageFileId_);
          messageTypeEnumId_ =
              visitor.visitInt(
                  messageTypeEnumId_ != 0,
                  messageTypeEnumId_,
                  other.messageTypeEnumId_ != 0,
                  other.messageTypeEnumId_);
          text_ = visitor.visitString(!text_.isEmpty(), text_, !other.text_.isEmpty(), other.text_);
          time_ = visitor.visitInt(time_ != 0, time_, other.time_ != 0, other.time_);
          peerReceivedTime_ =
              visitor.visitInt(
                  peerReceivedTime_ != 0,
                  peerReceivedTime_,
                  other.peerReceivedTime_ != 0,
                  other.peerReceivedTime_);
          peerSeenTime_ =
              visitor.visitInt(
                  peerSeenTime_ != 0, peerSeenTime_, other.peerSeenTime_ != 0, other.peerSeenTime_);
          deliviryStatusEnumId_ =
              visitor.visitInt(
                  deliviryStatusEnumId_ != 0,
                  deliviryStatusEnumId_,
                  other.deliviryStatusEnumId_ != 0,
                  other.deliviryStatusEnumId_);
          chatId_ = visitor.visitLong(chatId_ != 0L, chatId_, other.chatId_ != 0L, other.chatId_);
          roomTypeEnum_ =
              visitor.visitInt(
                  roomTypeEnum_ != 0, roomTypeEnum_, other.roomTypeEnum_ != 0, other.roomTypeEnum_);
          isByMe_ =
              visitor.visitBoolean(
                  isByMe_ != false, isByMe_, other.isByMe_ != false, other.isByMe_);
          if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {}
          return this;
        }
      case MERGE_FROM_STREAM:
        {
          com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
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
                default:
                  {
                    if (!input.skipField(tag)) {
                      done = true;
                    }
                    break;
                  }
                case 8:
                  {
                    messageId_ = input.readUInt64();
                    break;
                  }
                case 26:
                  {
                    String s = input.readStringRequireUtf8();

                    roomKey_ = s;
                    break;
                  }
                case 40:
                  {
                    userId_ = input.readInt32();
                    break;
                  }
                case 56:
                  {
                    messageFileId_ = input.readInt64();
                    break;
                  }
                case 72:
                  {
                    messageTypeEnumId_ = input.readInt32();
                    break;
                  }
                case 90:
                  {
                    String s = input.readStringRequireUtf8();

                    text_ = s;
                    break;
                  }
                case 104:
                  {
                    time_ = input.readInt32();
                    break;
                  }
                case 120:
                  {
                    peerReceivedTime_ = input.readInt32();
                    break;
                  }
                case 136:
                  {
                    peerSeenTime_ = input.readInt32();
                    break;
                  }
                case 152:
                  {
                    deliviryStatusEnumId_ = input.readInt32();
                    break;
                  }
                case 240:
                  {
                    chatId_ = input.readInt64();
                    break;
                  }
                case 248:
                  {
                    int rawValue = input.readEnum();

                    roomTypeEnum_ = rawValue;
                    break;
                  }
                case 264:
                  {
                    isByMe_ = input.readBool();
                    break;
                  }
              }
            }
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException(e.setUnfinishedMessage(this));
          } catch (java.io.IOException e) {
            throw new RuntimeException(
                new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
                    .setUnfinishedMessage(this));
          } finally {
          }
        }
      case GET_DEFAULT_INSTANCE:
        {
          return DEFAULT_INSTANCE;
        }
      case GET_PARSER:
        {
          if (PARSER == null) {
            synchronized (ir.ms.pb.PB_MessageView.class) {
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

  // @@protoc_insertion_point(class_scope:PB_MessageView)
  private static final ir.ms.pb.PB_MessageView DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PB_MessageView();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MessageView getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MessageView> PARSER;

  public static com.google.protobuf.Parser<PB_MessageView> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
