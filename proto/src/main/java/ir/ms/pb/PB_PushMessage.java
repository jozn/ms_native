// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_PushMessage}
 */
public  final class PB_PushMessage extends
    com.google.protobuf.GeneratedMessageLite<
        PB_PushMessage, PB_PushMessage.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_PushMessage)
    PB_PushMessageOrBuilder {
  private PB_PushMessage() {
  }
  public static final int PUSHMESSAGEID_FIELD_NUMBER = 1;
  private long pushMessageId_;
  /**
   * <code>int64 PushMessageId = 1;</code>
   */
  public long getPushMessageId() {
    return pushMessageId_;
  }
  /**
   * <code>int64 PushMessageId = 1;</code>
   */
  private void setPushMessageId(long value) {
    
    pushMessageId_ = value;
  }
  /**
   * <code>int64 PushMessageId = 1;</code>
   */
  private void clearPushMessageId() {
    
    pushMessageId_ = 0L;
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

  public static final int TODEVICEID_FIELD_NUMBER = 5;
  private long toDeviceId_;
  /**
   * <code>int64 ToDeviceId = 5;</code>
   */
  public long getToDeviceId() {
    return toDeviceId_;
  }
  /**
   * <code>int64 ToDeviceId = 5;</code>
   */
  private void setToDeviceId(long value) {
    
    toDeviceId_ = value;
  }
  /**
   * <code>int64 ToDeviceId = 5;</code>
   */
  private void clearToDeviceId() {
    
    toDeviceId_ = 0L;
  }

  public static final int MESSAGEID_FIELD_NUMBER = 7;
  private long messageId_;
  /**
   * <code>int64 MessageId = 7;</code>
   */
  public long getMessageId() {
    return messageId_;
  }
  /**
   * <code>int64 MessageId = 7;</code>
   */
  private void setMessageId(long value) {
    
    messageId_ = value;
  }
  /**
   * <code>int64 MessageId = 7;</code>
   */
  private void clearMessageId() {
    
    messageId_ = 0L;
  }

  public static final int ROOMTYPEENUM_FIELD_NUMBER = 9;
  private int roomTypeEnum_;
  /**
   * <code>int32 RoomTypeEnum = 9;</code>
   */
  public int getRoomTypeEnum() {
    return roomTypeEnum_;
  }
  /**
   * <code>int32 RoomTypeEnum = 9;</code>
   */
  private void setRoomTypeEnum(int value) {
    
    roomTypeEnum_ = value;
  }
  /**
   * <code>int32 RoomTypeEnum = 9;</code>
   */
  private void clearRoomTypeEnum() {
    
    roomTypeEnum_ = 0;
  }

  public static final int CREATEDMS_FIELD_NUMBER = 11;
  private long createdMs_;
  /**
   * <code>int64 CreatedMs = 11;</code>
   */
  public long getCreatedMs() {
    return createdMs_;
  }
  /**
   * <code>int64 CreatedMs = 11;</code>
   */
  private void setCreatedMs(long value) {
    
    createdMs_ = value;
  }
  /**
   * <code>int64 CreatedMs = 11;</code>
   */
  private void clearCreatedMs() {
    
    createdMs_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (pushMessageId_ != 0L) {
      output.writeInt64(1, pushMessageId_);
    }
    if (toUserId_ != 0) {
      output.writeInt32(3, toUserId_);
    }
    if (toDeviceId_ != 0L) {
      output.writeInt64(5, toDeviceId_);
    }
    if (messageId_ != 0L) {
      output.writeInt64(7, messageId_);
    }
    if (roomTypeEnum_ != 0) {
      output.writeInt32(9, roomTypeEnum_);
    }
    if (createdMs_ != 0L) {
      output.writeInt64(11, createdMs_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (pushMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, pushMessageId_);
    }
    if (toUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, toUserId_);
    }
    if (toDeviceId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, toDeviceId_);
    }
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(7, messageId_);
    }
    if (roomTypeEnum_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, roomTypeEnum_);
    }
    if (createdMs_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(11, createdMs_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_PushMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_PushMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_PushMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_PushMessage, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_PushMessage)
      ir.ms.pb.PB_PushMessageOrBuilder {
    // Construct using ir.ms.pb.PB_PushMessage.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 PushMessageId = 1;</code>
     */
    public long getPushMessageId() {
      return instance.getPushMessageId();
    }
    /**
     * <code>int64 PushMessageId = 1;</code>
     */
    public Builder setPushMessageId(long value) {
      copyOnWrite();
      instance.setPushMessageId(value);
      return this;
    }
    /**
     * <code>int64 PushMessageId = 1;</code>
     */
    public Builder clearPushMessageId() {
      copyOnWrite();
      instance.clearPushMessageId();
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
     * <code>int64 ToDeviceId = 5;</code>
     */
    public long getToDeviceId() {
      return instance.getToDeviceId();
    }
    /**
     * <code>int64 ToDeviceId = 5;</code>
     */
    public Builder setToDeviceId(long value) {
      copyOnWrite();
      instance.setToDeviceId(value);
      return this;
    }
    /**
     * <code>int64 ToDeviceId = 5;</code>
     */
    public Builder clearToDeviceId() {
      copyOnWrite();
      instance.clearToDeviceId();
      return this;
    }

    /**
     * <code>int64 MessageId = 7;</code>
     */
    public long getMessageId() {
      return instance.getMessageId();
    }
    /**
     * <code>int64 MessageId = 7;</code>
     */
    public Builder setMessageId(long value) {
      copyOnWrite();
      instance.setMessageId(value);
      return this;
    }
    /**
     * <code>int64 MessageId = 7;</code>
     */
    public Builder clearMessageId() {
      copyOnWrite();
      instance.clearMessageId();
      return this;
    }

    /**
     * <code>int32 RoomTypeEnum = 9;</code>
     */
    public int getRoomTypeEnum() {
      return instance.getRoomTypeEnum();
    }
    /**
     * <code>int32 RoomTypeEnum = 9;</code>
     */
    public Builder setRoomTypeEnum(int value) {
      copyOnWrite();
      instance.setRoomTypeEnum(value);
      return this;
    }
    /**
     * <code>int32 RoomTypeEnum = 9;</code>
     */
    public Builder clearRoomTypeEnum() {
      copyOnWrite();
      instance.clearRoomTypeEnum();
      return this;
    }

    /**
     * <code>int64 CreatedMs = 11;</code>
     */
    public long getCreatedMs() {
      return instance.getCreatedMs();
    }
    /**
     * <code>int64 CreatedMs = 11;</code>
     */
    public Builder setCreatedMs(long value) {
      copyOnWrite();
      instance.setCreatedMs(value);
      return this;
    }
    /**
     * <code>int64 CreatedMs = 11;</code>
     */
    public Builder clearCreatedMs() {
      copyOnWrite();
      instance.clearCreatedMs();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_PushMessage)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_PushMessage();
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
        ir.ms.pb.PB_PushMessage other = (ir.ms.pb.PB_PushMessage) arg1;
        pushMessageId_ = visitor.visitLong(pushMessageId_ != 0L, pushMessageId_,
            other.pushMessageId_ != 0L, other.pushMessageId_);
        toUserId_ = visitor.visitInt(toUserId_ != 0, toUserId_,
            other.toUserId_ != 0, other.toUserId_);
        toDeviceId_ = visitor.visitLong(toDeviceId_ != 0L, toDeviceId_,
            other.toDeviceId_ != 0L, other.toDeviceId_);
        messageId_ = visitor.visitLong(messageId_ != 0L, messageId_,
            other.messageId_ != 0L, other.messageId_);
        roomTypeEnum_ = visitor.visitInt(roomTypeEnum_ != 0, roomTypeEnum_,
            other.roomTypeEnum_ != 0, other.roomTypeEnum_);
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

                pushMessageId_ = input.readInt64();
                break;
              }
              case 24: {

                toUserId_ = input.readInt32();
                break;
              }
              case 40: {

                toDeviceId_ = input.readInt64();
                break;
              }
              case 56: {

                messageId_ = input.readInt64();
                break;
              }
              case 72: {

                roomTypeEnum_ = input.readInt32();
                break;
              }
              case 88: {

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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_PushMessage.class) {
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


  // @@protoc_insertion_point(class_scope:PB_PushMessage)
  private static final ir.ms.pb.PB_PushMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_PushMessage();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_PushMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_PushMessage> PARSER;

  public static com.google.protobuf.Parser<PB_PushMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

