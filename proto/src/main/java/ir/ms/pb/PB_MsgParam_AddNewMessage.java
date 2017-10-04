// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

/**
 * <pre>
 * AddNewMessage
 * </pre>
 *
 * Protobuf type {@code PB_MsgParam_AddNewMessage}
 */
public  final class PB_MsgParam_AddNewMessage extends
    com.google.protobuf.GeneratedMessageLite<
        PB_MsgParam_AddNewMessage, PB_MsgParam_AddNewMessage.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_MsgParam_AddNewMessage)
    PB_MsgParam_AddNewMessageOrBuilder {
  private PB_MsgParam_AddNewMessage() {
    text_ = "";
    messageKey_ = "";
    blob_ = com.google.protobuf.ByteString.EMPTY;
  }
  public static final int TEXT_FIELD_NUMBER = 1;
  private java.lang.String text_;
  /**
   * <code>string Text = 1;</code>
   */
  public java.lang.String getText() {
    return text_;
  }
  /**
   * <code>string Text = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTextBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(text_);
  }
  /**
   * <code>string Text = 1;</code>
   */
  private void setText(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    text_ = value;
  }
  /**
   * <code>string Text = 1;</code>
   */
  private void clearText() {
    
    text_ = getDefaultInstance().getText();
  }
  /**
   * <code>string Text = 1;</code>
   */
  private void setTextBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    text_ = value.toStringUtf8();
  }

  public static final int MESSAGEKEY_FIELD_NUMBER = 2;
  private java.lang.String messageKey_;
  /**
   * <code>string MessageKey = 2;</code>
   */
  public java.lang.String getMessageKey() {
    return messageKey_;
  }
  /**
   * <code>string MessageKey = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMessageKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(messageKey_);
  }
  /**
   * <code>string MessageKey = 2;</code>
   */
  private void setMessageKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    messageKey_ = value;
  }
  /**
   * <code>string MessageKey = 2;</code>
   */
  private void clearMessageKey() {
    
    messageKey_ = getDefaultInstance().getMessageKey();
  }
  /**
   * <code>string MessageKey = 2;</code>
   */
  private void setMessageKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    messageKey_ = value.toStringUtf8();
  }

  public static final int PEERID_FIELD_NUMBER = 5;
  private int peerId_;
  /**
   * <code>int32 PeerId = 5;</code>
   */
  public int getPeerId() {
    return peerId_;
  }
  /**
   * <code>int32 PeerId = 5;</code>
   */
  private void setPeerId(int value) {
    
    peerId_ = value;
  }
  /**
   * <code>int32 PeerId = 5;</code>
   */
  private void clearPeerId() {
    
    peerId_ = 0;
  }

  public static final int TIME_FIELD_NUMBER = 6;
  private int time_;
  /**
   * <code>int32 Time = 6;</code>
   */
  public int getTime() {
    return time_;
  }
  /**
   * <code>int32 Time = 6;</code>
   */
  private void setTime(int value) {
    
    time_ = value;
  }
  /**
   * <code>int32 Time = 6;</code>
   */
  private void clearTime() {
    
    time_ = 0;
  }

  public static final int REPLYTOMESSAGEID_FIELD_NUMBER = 10;
  private long replyToMessageId_;
  /**
   * <code>int64 ReplyToMessageId = 10;</code>
   */
  public long getReplyToMessageId() {
    return replyToMessageId_;
  }
  /**
   * <code>int64 ReplyToMessageId = 10;</code>
   */
  private void setReplyToMessageId(long value) {
    
    replyToMessageId_ = value;
  }
  /**
   * <code>int64 ReplyToMessageId = 10;</code>
   */
  private void clearReplyToMessageId() {
    
    replyToMessageId_ = 0L;
  }

  public static final int FORWARD_FIELD_NUMBER = 14;
  private ir.ms.pb.PB_MessageForwardedFrom forward_;
  /**
   * <code>.PB_MessageForwardedFrom Forward = 14;</code>
   */
  public boolean hasForward() {
    return forward_ != null;
  }
  /**
   * <code>.PB_MessageForwardedFrom Forward = 14;</code>
   */
  public ir.ms.pb.PB_MessageForwardedFrom getForward() {
    return forward_ == null ? ir.ms.pb.PB_MessageForwardedFrom.getDefaultInstance() : forward_;
  }
  /**
   * <code>.PB_MessageForwardedFrom Forward = 14;</code>
   */
  private void setForward(ir.ms.pb.PB_MessageForwardedFrom value) {
    if (value == null) {
      throw new NullPointerException();
    }
    forward_ = value;
    
    }
  /**
   * <code>.PB_MessageForwardedFrom Forward = 14;</code>
   */
  private void setForward(
      ir.ms.pb.PB_MessageForwardedFrom.Builder builderForValue) {
    forward_ = builderForValue.build();
    
  }
  /**
   * <code>.PB_MessageForwardedFrom Forward = 14;</code>
   */
  private void mergeForward(ir.ms.pb.PB_MessageForwardedFrom value) {
    if (forward_ != null &&
        forward_ != ir.ms.pb.PB_MessageForwardedFrom.getDefaultInstance()) {
      forward_ =
        ir.ms.pb.PB_MessageForwardedFrom.newBuilder(forward_).mergeFrom(value).buildPartial();
    } else {
      forward_ = value;
    }
    
  }
  /**
   * <code>.PB_MessageForwardedFrom Forward = 14;</code>
   */
  private void clearForward() {  forward_ = null;
    
  }

  public static final int ROOMMESSAGETYPE_FIELD_NUMBER = 15;
  private int roomMessageType_;
  /**
   * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
   */
  public int getRoomMessageTypeValue() {
    return roomMessageType_;
  }
  /**
   * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
   */
  public ir.ms.pb.RoomMessageTypeEnum getRoomMessageType() {
    ir.ms.pb.RoomMessageTypeEnum result = ir.ms.pb.RoomMessageTypeEnum.forNumber(roomMessageType_);
    return result == null ? ir.ms.pb.RoomMessageTypeEnum.UNRECOGNIZED : result;
  }
  /**
   * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
   */
  private void setRoomMessageTypeValue(int value) {
      roomMessageType_ = value;
  }
  /**
   * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
   */
  private void setRoomMessageType(ir.ms.pb.RoomMessageTypeEnum value) {
    if (value == null) {
      throw new NullPointerException();
    }
    
    roomMessageType_ = value.getNumber();
  }
  /**
   * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
   */
  private void clearRoomMessageType() {
    
    roomMessageType_ = 0;
  }

  public static final int BLOB_FIELD_NUMBER = 17;
  private com.google.protobuf.ByteString blob_;
  /**
   * <code>bytes Blob = 17;</code>
   */
  public com.google.protobuf.ByteString getBlob() {
    return blob_;
  }
  /**
   * <code>bytes Blob = 17;</code>
   */
  private void setBlob(com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    blob_ = value;
  }
  /**
   * <code>bytes Blob = 17;</code>
   */
  private void clearBlob() {
    
    blob_ = getDefaultInstance().getBlob();
  }

  public static final int MESSAGEVIEW_FIELD_NUMBER = 19;
  private ir.ms.pb.PB_MessageView messageView_;
  /**
   * <code>.PB_MessageView MessageView = 19;</code>
   */
  public boolean hasMessageView() {
    return messageView_ != null;
  }
  /**
   * <code>.PB_MessageView MessageView = 19;</code>
   */
  public ir.ms.pb.PB_MessageView getMessageView() {
    return messageView_ == null ? ir.ms.pb.PB_MessageView.getDefaultInstance() : messageView_;
  }
  /**
   * <code>.PB_MessageView MessageView = 19;</code>
   */
  private void setMessageView(ir.ms.pb.PB_MessageView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    messageView_ = value;
    
    }
  /**
   * <code>.PB_MessageView MessageView = 19;</code>
   */
  private void setMessageView(
      ir.ms.pb.PB_MessageView.Builder builderForValue) {
    messageView_ = builderForValue.build();
    
  }
  /**
   * <code>.PB_MessageView MessageView = 19;</code>
   */
  private void mergeMessageView(ir.ms.pb.PB_MessageView value) {
    if (messageView_ != null &&
        messageView_ != ir.ms.pb.PB_MessageView.getDefaultInstance()) {
      messageView_ =
        ir.ms.pb.PB_MessageView.newBuilder(messageView_).mergeFrom(value).buildPartial();
    } else {
      messageView_ = value;
    }
    
  }
  /**
   * <code>.PB_MessageView MessageView = 19;</code>
   */
  private void clearMessageView() {  messageView_ = null;
    
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!text_.isEmpty()) {
      output.writeString(1, getText());
    }
    if (!messageKey_.isEmpty()) {
      output.writeString(2, getMessageKey());
    }
    if (peerId_ != 0) {
      output.writeInt32(5, peerId_);
    }
    if (time_ != 0) {
      output.writeInt32(6, time_);
    }
    if (replyToMessageId_ != 0L) {
      output.writeInt64(10, replyToMessageId_);
    }
    if (forward_ != null) {
      output.writeMessage(14, getForward());
    }
    if (roomMessageType_ != ir.ms.pb.RoomMessageTypeEnum.UNKNOWN_MESSAGE_TYPE.getNumber()) {
      output.writeEnum(15, roomMessageType_);
    }
    if (!blob_.isEmpty()) {
      output.writeBytes(17, blob_);
    }
    if (messageView_ != null) {
      output.writeMessage(19, getMessageView());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!text_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getText());
    }
    if (!messageKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getMessageKey());
    }
    if (peerId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, peerId_);
    }
    if (time_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, time_);
    }
    if (replyToMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(10, replyToMessageId_);
    }
    if (forward_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(14, getForward());
    }
    if (roomMessageType_ != ir.ms.pb.RoomMessageTypeEnum.UNKNOWN_MESSAGE_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(15, roomMessageType_);
    }
    if (!blob_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(17, blob_);
    }
    if (messageView_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(19, getMessageView());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgParam_AddNewMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_MsgParam_AddNewMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * AddNewMessage
   * </pre>
   *
   * Protobuf type {@code PB_MsgParam_AddNewMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_MsgParam_AddNewMessage, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_MsgParam_AddNewMessage)
      ir.ms.pb.PB_MsgParam_AddNewMessageOrBuilder {
    // Construct using ir.ms.pb.PB_MsgParam_AddNewMessage.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>string Text = 1;</code>
     */
    public java.lang.String getText() {
      return instance.getText();
    }
    /**
     * <code>string Text = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      return instance.getTextBytes();
    }
    /**
     * <code>string Text = 1;</code>
     */
    public Builder setText(
        java.lang.String value) {
      copyOnWrite();
      instance.setText(value);
      return this;
    }
    /**
     * <code>string Text = 1;</code>
     */
    public Builder clearText() {
      copyOnWrite();
      instance.clearText();
      return this;
    }
    /**
     * <code>string Text = 1;</code>
     */
    public Builder setTextBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setTextBytes(value);
      return this;
    }

    /**
     * <code>string MessageKey = 2;</code>
     */
    public java.lang.String getMessageKey() {
      return instance.getMessageKey();
    }
    /**
     * <code>string MessageKey = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMessageKeyBytes() {
      return instance.getMessageKeyBytes();
    }
    /**
     * <code>string MessageKey = 2;</code>
     */
    public Builder setMessageKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setMessageKey(value);
      return this;
    }
    /**
     * <code>string MessageKey = 2;</code>
     */
    public Builder clearMessageKey() {
      copyOnWrite();
      instance.clearMessageKey();
      return this;
    }
    /**
     * <code>string MessageKey = 2;</code>
     */
    public Builder setMessageKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMessageKeyBytes(value);
      return this;
    }

    /**
     * <code>int32 PeerId = 5;</code>
     */
    public int getPeerId() {
      return instance.getPeerId();
    }
    /**
     * <code>int32 PeerId = 5;</code>
     */
    public Builder setPeerId(int value) {
      copyOnWrite();
      instance.setPeerId(value);
      return this;
    }
    /**
     * <code>int32 PeerId = 5;</code>
     */
    public Builder clearPeerId() {
      copyOnWrite();
      instance.clearPeerId();
      return this;
    }

    /**
     * <code>int32 Time = 6;</code>
     */
    public int getTime() {
      return instance.getTime();
    }
    /**
     * <code>int32 Time = 6;</code>
     */
    public Builder setTime(int value) {
      copyOnWrite();
      instance.setTime(value);
      return this;
    }
    /**
     * <code>int32 Time = 6;</code>
     */
    public Builder clearTime() {
      copyOnWrite();
      instance.clearTime();
      return this;
    }

    /**
     * <code>int64 ReplyToMessageId = 10;</code>
     */
    public long getReplyToMessageId() {
      return instance.getReplyToMessageId();
    }
    /**
     * <code>int64 ReplyToMessageId = 10;</code>
     */
    public Builder setReplyToMessageId(long value) {
      copyOnWrite();
      instance.setReplyToMessageId(value);
      return this;
    }
    /**
     * <code>int64 ReplyToMessageId = 10;</code>
     */
    public Builder clearReplyToMessageId() {
      copyOnWrite();
      instance.clearReplyToMessageId();
      return this;
    }

    /**
     * <code>.PB_MessageForwardedFrom Forward = 14;</code>
     */
    public boolean hasForward() {
      return instance.hasForward();
    }
    /**
     * <code>.PB_MessageForwardedFrom Forward = 14;</code>
     */
    public ir.ms.pb.PB_MessageForwardedFrom getForward() {
      return instance.getForward();
    }
    /**
     * <code>.PB_MessageForwardedFrom Forward = 14;</code>
     */
    public Builder setForward(ir.ms.pb.PB_MessageForwardedFrom value) {
      copyOnWrite();
      instance.setForward(value);
      return this;
      }
    /**
     * <code>.PB_MessageForwardedFrom Forward = 14;</code>
     */
    public Builder setForward(
        ir.ms.pb.PB_MessageForwardedFrom.Builder builderForValue) {
      copyOnWrite();
      instance.setForward(builderForValue);
      return this;
    }
    /**
     * <code>.PB_MessageForwardedFrom Forward = 14;</code>
     */
    public Builder mergeForward(ir.ms.pb.PB_MessageForwardedFrom value) {
      copyOnWrite();
      instance.mergeForward(value);
      return this;
    }
    /**
     * <code>.PB_MessageForwardedFrom Forward = 14;</code>
     */
    public Builder clearForward() {  copyOnWrite();
      instance.clearForward();
      return this;
    }

    /**
     * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
     */
    public int getRoomMessageTypeValue() {
      return instance.getRoomMessageTypeValue();
    }
    /**
     * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
     */
    public Builder setRoomMessageTypeValue(int value) {
      copyOnWrite();
      instance.setRoomMessageTypeValue(value);
      return this;
    }
    /**
     * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
     */
    public ir.ms.pb.RoomMessageTypeEnum getRoomMessageType() {
      return instance.getRoomMessageType();
    }
    /**
     * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
     */
    public Builder setRoomMessageType(ir.ms.pb.RoomMessageTypeEnum value) {
      copyOnWrite();
      instance.setRoomMessageType(value);
      return this;
    }
    /**
     * <code>.RoomMessageTypeEnum RoomMessageType = 15;</code>
     */
    public Builder clearRoomMessageType() {
      copyOnWrite();
      instance.clearRoomMessageType();
      return this;
    }

    /**
     * <code>bytes Blob = 17;</code>
     */
    public com.google.protobuf.ByteString getBlob() {
      return instance.getBlob();
    }
    /**
     * <code>bytes Blob = 17;</code>
     */
    public Builder setBlob(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setBlob(value);
      return this;
    }
    /**
     * <code>bytes Blob = 17;</code>
     */
    public Builder clearBlob() {
      copyOnWrite();
      instance.clearBlob();
      return this;
    }

    /**
     * <code>.PB_MessageView MessageView = 19;</code>
     */
    public boolean hasMessageView() {
      return instance.hasMessageView();
    }
    /**
     * <code>.PB_MessageView MessageView = 19;</code>
     */
    public ir.ms.pb.PB_MessageView getMessageView() {
      return instance.getMessageView();
    }
    /**
     * <code>.PB_MessageView MessageView = 19;</code>
     */
    public Builder setMessageView(ir.ms.pb.PB_MessageView value) {
      copyOnWrite();
      instance.setMessageView(value);
      return this;
      }
    /**
     * <code>.PB_MessageView MessageView = 19;</code>
     */
    public Builder setMessageView(
        ir.ms.pb.PB_MessageView.Builder builderForValue) {
      copyOnWrite();
      instance.setMessageView(builderForValue);
      return this;
    }
    /**
     * <code>.PB_MessageView MessageView = 19;</code>
     */
    public Builder mergeMessageView(ir.ms.pb.PB_MessageView value) {
      copyOnWrite();
      instance.mergeMessageView(value);
      return this;
    }
    /**
     * <code>.PB_MessageView MessageView = 19;</code>
     */
    public Builder clearMessageView() {  copyOnWrite();
      instance.clearMessageView();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MsgParam_AddNewMessage)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_MsgParam_AddNewMessage();
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
        ir.ms.pb.PB_MsgParam_AddNewMessage other = (ir.ms.pb.PB_MsgParam_AddNewMessage) arg1;
        text_ = visitor.visitString(!text_.isEmpty(), text_,
            !other.text_.isEmpty(), other.text_);
        messageKey_ = visitor.visitString(!messageKey_.isEmpty(), messageKey_,
            !other.messageKey_.isEmpty(), other.messageKey_);
        peerId_ = visitor.visitInt(peerId_ != 0, peerId_,
            other.peerId_ != 0, other.peerId_);
        time_ = visitor.visitInt(time_ != 0, time_,
            other.time_ != 0, other.time_);
        replyToMessageId_ = visitor.visitLong(replyToMessageId_ != 0L, replyToMessageId_,
            other.replyToMessageId_ != 0L, other.replyToMessageId_);
        forward_ = visitor.visitMessage(forward_, other.forward_);
        roomMessageType_ = visitor.visitInt(roomMessageType_ != 0, roomMessageType_,    other.roomMessageType_ != 0, other.roomMessageType_);
        blob_ = visitor.visitByteString(blob_ != com.google.protobuf.ByteString.EMPTY, blob_,
            other.blob_ != com.google.protobuf.ByteString.EMPTY, other.blob_);
        messageView_ = visitor.visitMessage(messageView_, other.messageView_);
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

                text_ = s;
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                messageKey_ = s;
                break;
              }
              case 40: {

                peerId_ = input.readInt32();
                break;
              }
              case 48: {

                time_ = input.readInt32();
                break;
              }
              case 80: {

                replyToMessageId_ = input.readInt64();
                break;
              }
              case 114: {
                ir.ms.pb.PB_MessageForwardedFrom.Builder subBuilder = null;
                if (forward_ != null) {
                  subBuilder = forward_.toBuilder();
                }
                forward_ = input.readMessage(ir.ms.pb.PB_MessageForwardedFrom.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(forward_);
                  forward_ = subBuilder.buildPartial();
                }

                break;
              }
              case 120: {
                int rawValue = input.readEnum();

                roomMessageType_ = rawValue;
                break;
              }
              case 138: {

                blob_ = input.readBytes();
                break;
              }
              case 154: {
                ir.ms.pb.PB_MessageView.Builder subBuilder = null;
                if (messageView_ != null) {
                  subBuilder = messageView_.toBuilder();
                }
                messageView_ = input.readMessage(ir.ms.pb.PB_MessageView.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(messageView_);
                  messageView_ = subBuilder.buildPartial();
                }

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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_MsgParam_AddNewMessage.class) {
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


  // @@protoc_insertion_point(class_scope:PB_MsgParam_AddNewMessage)
  private static final ir.ms.pb.PB_MsgParam_AddNewMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_MsgParam_AddNewMessage();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MsgParam_AddNewMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MsgParam_AddNewMessage> PARSER;

  public static com.google.protobuf.Parser<PB_MsgParam_AddNewMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

