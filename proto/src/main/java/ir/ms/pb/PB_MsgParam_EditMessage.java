// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

/**
 * <pre>
 *&#47;//////////////////////////////////
 * </pre>
 *
 * Protobuf type {@code PB_MsgParam_EditMessage}
 */
public  final class PB_MsgParam_EditMessage extends
    com.google.protobuf.GeneratedMessageLite<
        PB_MsgParam_EditMessage, PB_MsgParam_EditMessage.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_MsgParam_EditMessage)
    PB_MsgParam_EditMessageOrBuilder {
  private PB_MsgParam_EditMessage() {
    chatKey_ = "";
    newText_ = "";
  }
  public static final int CHATKEY_FIELD_NUMBER = 1;
  private java.lang.String chatKey_;
  /**
   * <pre>
   *int64 ChatId = 1;
   * </pre>
   *
   * <code>string ChatKey = 1;</code>
   */
  public java.lang.String getChatKey() {
    return chatKey_;
  }
  /**
   * <pre>
   *int64 ChatId = 1;
   * </pre>
   *
   * <code>string ChatKey = 1;</code>
   */
  public com.google.protobuf.ByteString
      getChatKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(chatKey_);
  }
  /**
   * <pre>
   *int64 ChatId = 1;
   * </pre>
   *
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
   * <pre>
   *int64 ChatId = 1;
   * </pre>
   *
   * <code>string ChatKey = 1;</code>
   */
  private void clearChatKey() {
    
    chatKey_ = getDefaultInstance().getChatKey();
  }
  /**
   * <pre>
   *int64 ChatId = 1;
   * </pre>
   *
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

  public static final int ROOMTYPE_FIELD_NUMBER = 2;
  private int roomType_;
  /**
   * <code>.RoomTypeEnum RoomType = 2;</code>
   */
  public int getRoomTypeValue() {
    return roomType_;
  }
  /**
   * <code>.RoomTypeEnum RoomType = 2;</code>
   */
  public ir.ms.pb.RoomTypeEnum getRoomType() {
    ir.ms.pb.RoomTypeEnum result = ir.ms.pb.RoomTypeEnum.forNumber(roomType_);
    return result == null ? ir.ms.pb.RoomTypeEnum.UNRECOGNIZED : result;
  }
  /**
   * <code>.RoomTypeEnum RoomType = 2;</code>
   */
  private void setRoomTypeValue(int value) {
      roomType_ = value;
  }
  /**
   * <code>.RoomTypeEnum RoomType = 2;</code>
   */
  private void setRoomType(ir.ms.pb.RoomTypeEnum value) {
    if (value == null) {
      throw new NullPointerException();
    }
    
    roomType_ = value.getNumber();
  }
  /**
   * <code>.RoomTypeEnum RoomType = 2;</code>
   */
  private void clearRoomType() {
    
    roomType_ = 0;
  }

  public static final int MESSAGEID_FIELD_NUMBER = 3;
  private long messageId_;
  /**
   * <code>int64 MessageId = 3;</code>
   */
  public long getMessageId() {
    return messageId_;
  }
  /**
   * <code>int64 MessageId = 3;</code>
   */
  private void setMessageId(long value) {
    
    messageId_ = value;
  }
  /**
   * <code>int64 MessageId = 3;</code>
   */
  private void clearMessageId() {
    
    messageId_ = 0L;
  }

  public static final int NEWTEXT_FIELD_NUMBER = 4;
  private java.lang.String newText_;
  /**
   * <code>string NewText = 4;</code>
   */
  public java.lang.String getNewText() {
    return newText_;
  }
  /**
   * <code>string NewText = 4;</code>
   */
  public com.google.protobuf.ByteString
      getNewTextBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(newText_);
  }
  /**
   * <code>string NewText = 4;</code>
   */
  private void setNewText(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    newText_ = value;
  }
  /**
   * <code>string NewText = 4;</code>
   */
  private void clearNewText() {
    
    newText_ = getDefaultInstance().getNewText();
  }
  /**
   * <code>string NewText = 4;</code>
   */
  private void setNewTextBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    newText_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!chatKey_.isEmpty()) {
      output.writeString(1, getChatKey());
    }
    if (roomType_ != ir.ms.pb.RoomTypeEnum.UNKNOWN_ROOM_TYPE.getNumber()) {
      output.writeEnum(2, roomType_);
    }
    if (messageId_ != 0L) {
      output.writeInt64(3, messageId_);
    }
    if (!newText_.isEmpty()) {
      output.writeString(4, getNewText());
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
    if (roomType_ != ir.ms.pb.RoomTypeEnum.UNKNOWN_ROOM_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, roomType_);
    }
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, messageId_);
    }
    if (!newText_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(4, getNewText());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgParam_EditMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_MsgParam_EditMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   *&#47;//////////////////////////////////
   * </pre>
   *
   * Protobuf type {@code PB_MsgParam_EditMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_MsgParam_EditMessage, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_MsgParam_EditMessage)
      ir.ms.pb.PB_MsgParam_EditMessageOrBuilder {
    // Construct using ir.ms.pb.PB_MsgParam_EditMessage.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     *int64 ChatId = 1;
     * </pre>
     *
     * <code>string ChatKey = 1;</code>
     */
    public java.lang.String getChatKey() {
      return instance.getChatKey();
    }
    /**
     * <pre>
     *int64 ChatId = 1;
     * </pre>
     *
     * <code>string ChatKey = 1;</code>
     */
    public com.google.protobuf.ByteString
        getChatKeyBytes() {
      return instance.getChatKeyBytes();
    }
    /**
     * <pre>
     *int64 ChatId = 1;
     * </pre>
     *
     * <code>string ChatKey = 1;</code>
     */
    public Builder setChatKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setChatKey(value);
      return this;
    }
    /**
     * <pre>
     *int64 ChatId = 1;
     * </pre>
     *
     * <code>string ChatKey = 1;</code>
     */
    public Builder clearChatKey() {
      copyOnWrite();
      instance.clearChatKey();
      return this;
    }
    /**
     * <pre>
     *int64 ChatId = 1;
     * </pre>
     *
     * <code>string ChatKey = 1;</code>
     */
    public Builder setChatKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setChatKeyBytes(value);
      return this;
    }

    /**
     * <code>.RoomTypeEnum RoomType = 2;</code>
     */
    public int getRoomTypeValue() {
      return instance.getRoomTypeValue();
    }
    /**
     * <code>.RoomTypeEnum RoomType = 2;</code>
     */
    public Builder setRoomTypeValue(int value) {
      copyOnWrite();
      instance.setRoomTypeValue(value);
      return this;
    }
    /**
     * <code>.RoomTypeEnum RoomType = 2;</code>
     */
    public ir.ms.pb.RoomTypeEnum getRoomType() {
      return instance.getRoomType();
    }
    /**
     * <code>.RoomTypeEnum RoomType = 2;</code>
     */
    public Builder setRoomType(ir.ms.pb.RoomTypeEnum value) {
      copyOnWrite();
      instance.setRoomType(value);
      return this;
    }
    /**
     * <code>.RoomTypeEnum RoomType = 2;</code>
     */
    public Builder clearRoomType() {
      copyOnWrite();
      instance.clearRoomType();
      return this;
    }

    /**
     * <code>int64 MessageId = 3;</code>
     */
    public long getMessageId() {
      return instance.getMessageId();
    }
    /**
     * <code>int64 MessageId = 3;</code>
     */
    public Builder setMessageId(long value) {
      copyOnWrite();
      instance.setMessageId(value);
      return this;
    }
    /**
     * <code>int64 MessageId = 3;</code>
     */
    public Builder clearMessageId() {
      copyOnWrite();
      instance.clearMessageId();
      return this;
    }

    /**
     * <code>string NewText = 4;</code>
     */
    public java.lang.String getNewText() {
      return instance.getNewText();
    }
    /**
     * <code>string NewText = 4;</code>
     */
    public com.google.protobuf.ByteString
        getNewTextBytes() {
      return instance.getNewTextBytes();
    }
    /**
     * <code>string NewText = 4;</code>
     */
    public Builder setNewText(
        java.lang.String value) {
      copyOnWrite();
      instance.setNewText(value);
      return this;
    }
    /**
     * <code>string NewText = 4;</code>
     */
    public Builder clearNewText() {
      copyOnWrite();
      instance.clearNewText();
      return this;
    }
    /**
     * <code>string NewText = 4;</code>
     */
    public Builder setNewTextBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setNewTextBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MsgParam_EditMessage)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_MsgParam_EditMessage();
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
        ir.ms.pb.PB_MsgParam_EditMessage other = (ir.ms.pb.PB_MsgParam_EditMessage) arg1;
        chatKey_ = visitor.visitString(!chatKey_.isEmpty(), chatKey_,
            !other.chatKey_.isEmpty(), other.chatKey_);
        roomType_ = visitor.visitInt(roomType_ != 0, roomType_,    other.roomType_ != 0, other.roomType_);
        messageId_ = visitor.visitLong(messageId_ != 0L, messageId_,
            other.messageId_ != 0L, other.messageId_);
        newText_ = visitor.visitString(!newText_.isEmpty(), newText_,
            !other.newText_.isEmpty(), other.newText_);
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
              case 16: {
                int rawValue = input.readEnum();

                roomType_ = rawValue;
                break;
              }
              case 24: {

                messageId_ = input.readInt64();
                break;
              }
              case 34: {
                String s = input.readStringRequireUtf8();

                newText_ = s;
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_MsgParam_EditMessage.class) {
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


  // @@protoc_insertion_point(class_scope:PB_MsgParam_EditMessage)
  private static final ir.ms.pb.PB_MsgParam_EditMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_MsgParam_EditMessage();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MsgParam_EditMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MsgParam_EditMessage> PARSER;

  public static com.google.protobuf.Parser<PB_MsgParam_EditMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

