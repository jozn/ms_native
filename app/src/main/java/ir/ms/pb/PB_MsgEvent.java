// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_del.proto

package ir.ms.pb;

/** Protobuf type {@code PB_MsgEvent} */
public final class PB_MsgEvent
    extends com.google.protobuf.GeneratedMessageLite<PB_MsgEvent, PB_MsgEvent.Builder>
    implements
    // @@protoc_insertion_point(message_implements:PB_MsgEvent)
    PB_MsgEventOrBuilder {
  private PB_MsgEvent() {
    messageKey_ = "";
    roomKey_ = "";
  }

  public static final int MESSAGEKEY_FIELD_NUMBER = 1;
  private java.lang.String messageKey_;
  /** <code>string MessageKey = 1;</code> */
  public java.lang.String getMessageKey() {
    return messageKey_;
  }
  /** <code>string MessageKey = 1;</code> */
  public com.google.protobuf.ByteString getMessageKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(messageKey_);
  }
  /** <code>string MessageKey = 1;</code> */
  private void setMessageKey(java.lang.String value) {
    if (value == null) {
      throw new NullPointerException();
    }

    messageKey_ = value;
  }
  /** <code>string MessageKey = 1;</code> */
  private void clearMessageKey() {

    messageKey_ = getDefaultInstance().getMessageKey();
  }
  /** <code>string MessageKey = 1;</code> */
  private void setMessageKeyBytes(com.google.protobuf.ByteString value) {
    if (value == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(value);

    messageKey_ = value.toStringUtf8();
  }

  public static final int ROOMKEY_FIELD_NUMBER = 2;
  private java.lang.String roomKey_;
  /** <code>string RoomKey = 2;</code> */
  public java.lang.String getRoomKey() {
    return roomKey_;
  }
  /** <code>string RoomKey = 2;</code> */
  public com.google.protobuf.ByteString getRoomKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(roomKey_);
  }
  /** <code>string RoomKey = 2;</code> */
  private void setRoomKey(java.lang.String value) {
    if (value == null) {
      throw new NullPointerException();
    }

    roomKey_ = value;
  }
  /** <code>string RoomKey = 2;</code> */
  private void clearRoomKey() {

    roomKey_ = getDefaultInstance().getRoomKey();
  }
  /** <code>string RoomKey = 2;</code> */
  private void setRoomKeyBytes(com.google.protobuf.ByteString value) {
    if (value == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(value);

    roomKey_ = value.toStringUtf8();
  }

  public static final int PEERUSERID_FIELD_NUMBER = 3;
  private long peerUserId_;
  /** <code>int64 PeerUserId = 3;</code> */
  public long getPeerUserId() {
    return peerUserId_;
  }
  /** <code>int64 PeerUserId = 3;</code> */
  private void setPeerUserId(long value) {

    peerUserId_ = value;
  }
  /** <code>int64 PeerUserId = 3;</code> */
  private void clearPeerUserId() {

    peerUserId_ = 0L;
  }

  public static final int EVENTTYPE_FIELD_NUMBER = 4;
  private int eventType_;
  /** <code>int32 EventType = 4;</code> */
  public int getEventType() {
    return eventType_;
  }
  /** <code>int32 EventType = 4;</code> */
  private void setEventType(int value) {

    eventType_ = value;
  }
  /** <code>int32 EventType = 4;</code> */
  private void clearEventType() {

    eventType_ = 0;
  }

  public static final int ATTIME_FIELD_NUMBER = 10;
  private long atTime_;
  /** <code>int64 AtTime = 10;</code> */
  public long getAtTime() {
    return atTime_;
  }
  /** <code>int64 AtTime = 10;</code> */
  private void setAtTime(long value) {

    atTime_ = value;
  }
  /** <code>int64 AtTime = 10;</code> */
  private void clearAtTime() {

    atTime_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!messageKey_.isEmpty()) {
      output.writeString(1, getMessageKey());
    }
    if (!roomKey_.isEmpty()) {
      output.writeString(2, getRoomKey());
    }
    if (peerUserId_ != 0L) {
      output.writeInt64(3, peerUserId_);
    }
    if (eventType_ != 0) {
      output.writeInt32(4, eventType_);
    }
    if (atTime_ != 0L) {
      output.writeInt64(10, atTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!messageKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeStringSize(1, getMessageKey());
    }
    if (!roomKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeStringSize(2, getRoomKey());
    }
    if (peerUserId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, peerUserId_);
    }
    if (eventType_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, eventType_);
    }
    if (atTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(10, atTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgEvent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MsgEvent parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MsgEvent parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ir.ms.pb.PB_MsgEvent prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /** Protobuf type {@code PB_MsgEvent} */
  public static final class Builder
      extends com.google.protobuf.GeneratedMessageLite.Builder<ir.ms.pb.PB_MsgEvent, Builder>
      implements
      // @@protoc_insertion_point(builder_implements:PB_MsgEvent)
      ir.ms.pb.PB_MsgEventOrBuilder {
    // Construct using ir.ms.pb.PB_MsgEvent.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }

    /** <code>string MessageKey = 1;</code> */
    public java.lang.String getMessageKey() {
      return instance.getMessageKey();
    }
    /** <code>string MessageKey = 1;</code> */
    public com.google.protobuf.ByteString getMessageKeyBytes() {
      return instance.getMessageKeyBytes();
    }
    /** <code>string MessageKey = 1;</code> */
    public Builder setMessageKey(java.lang.String value) {
      copyOnWrite();
      instance.setMessageKey(value);
      return this;
    }
    /** <code>string MessageKey = 1;</code> */
    public Builder clearMessageKey() {
      copyOnWrite();
      instance.clearMessageKey();
      return this;
    }
    /** <code>string MessageKey = 1;</code> */
    public Builder setMessageKeyBytes(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMessageKeyBytes(value);
      return this;
    }

    /** <code>string RoomKey = 2;</code> */
    public java.lang.String getRoomKey() {
      return instance.getRoomKey();
    }
    /** <code>string RoomKey = 2;</code> */
    public com.google.protobuf.ByteString getRoomKeyBytes() {
      return instance.getRoomKeyBytes();
    }
    /** <code>string RoomKey = 2;</code> */
    public Builder setRoomKey(java.lang.String value) {
      copyOnWrite();
      instance.setRoomKey(value);
      return this;
    }
    /** <code>string RoomKey = 2;</code> */
    public Builder clearRoomKey() {
      copyOnWrite();
      instance.clearRoomKey();
      return this;
    }
    /** <code>string RoomKey = 2;</code> */
    public Builder setRoomKeyBytes(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRoomKeyBytes(value);
      return this;
    }

    /** <code>int64 PeerUserId = 3;</code> */
    public long getPeerUserId() {
      return instance.getPeerUserId();
    }
    /** <code>int64 PeerUserId = 3;</code> */
    public Builder setPeerUserId(long value) {
      copyOnWrite();
      instance.setPeerUserId(value);
      return this;
    }
    /** <code>int64 PeerUserId = 3;</code> */
    public Builder clearPeerUserId() {
      copyOnWrite();
      instance.clearPeerUserId();
      return this;
    }

    /** <code>int32 EventType = 4;</code> */
    public int getEventType() {
      return instance.getEventType();
    }
    /** <code>int32 EventType = 4;</code> */
    public Builder setEventType(int value) {
      copyOnWrite();
      instance.setEventType(value);
      return this;
    }
    /** <code>int32 EventType = 4;</code> */
    public Builder clearEventType() {
      copyOnWrite();
      instance.clearEventType();
      return this;
    }

    /** <code>int64 AtTime = 10;</code> */
    public long getAtTime() {
      return instance.getAtTime();
    }
    /** <code>int64 AtTime = 10;</code> */
    public Builder setAtTime(long value) {
      copyOnWrite();
      instance.setAtTime(value);
      return this;
    }
    /** <code>int64 AtTime = 10;</code> */
    public Builder clearAtTime() {
      copyOnWrite();
      instance.clearAtTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MsgEvent)
  }

  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE:
        {
          return new ir.ms.pb.PB_MsgEvent();
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
          ir.ms.pb.PB_MsgEvent other = (ir.ms.pb.PB_MsgEvent) arg1;
          messageKey_ =
              visitor.visitString(
                  !messageKey_.isEmpty(),
                  messageKey_,
                  !other.messageKey_.isEmpty(),
                  other.messageKey_);
          roomKey_ =
              visitor.visitString(
                  !roomKey_.isEmpty(), roomKey_, !other.roomKey_.isEmpty(), other.roomKey_);
          peerUserId_ =
              visitor.visitLong(
                  peerUserId_ != 0L, peerUserId_, other.peerUserId_ != 0L, other.peerUserId_);
          eventType_ =
              visitor.visitInt(
                  eventType_ != 0, eventType_, other.eventType_ != 0, other.eventType_);
          atTime_ = visitor.visitLong(atTime_ != 0L, atTime_, other.atTime_ != 0L, other.atTime_);
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
                case 10:
                  {
                    String s = input.readStringRequireUtf8();

                    messageKey_ = s;
                    break;
                  }
                case 18:
                  {
                    String s = input.readStringRequireUtf8();

                    roomKey_ = s;
                    break;
                  }
                case 24:
                  {
                    peerUserId_ = input.readInt64();
                    break;
                  }
                case 32:
                  {
                    eventType_ = input.readInt32();
                    break;
                  }
                case 80:
                  {
                    atTime_ = input.readInt64();
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
            synchronized (ir.ms.pb.PB_MsgEvent.class) {
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

  // @@protoc_insertion_point(class_scope:PB_MsgEvent)
  private static final ir.ms.pb.PB_MsgEvent DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PB_MsgEvent();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MsgEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MsgEvent> PARSER;

  public static com.google.protobuf.Parser<PB_MsgEvent> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
