// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_OldMsgPushEvent}
 */
public  final class PB_OldMsgPushEvent extends
    com.google.protobuf.GeneratedMessageLite<
        PB_OldMsgPushEvent, PB_OldMsgPushEvent.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_OldMsgPushEvent)
    PB_OldMsgPushEventOrBuilder {
  private PB_OldMsgPushEvent() {
    msgKey_ = "";
    roomKey_ = "";
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

  public static final int UID_FIELD_NUMBER = 3;
  private long uid_;
  /**
   * <code>int64 Uid = 3;</code>
   */
  public long getUid() {
    return uid_;
  }
  /**
   * <code>int64 Uid = 3;</code>
   */
  private void setUid(long value) {
    
    uid_ = value;
  }
  /**
   * <code>int64 Uid = 3;</code>
   */
  private void clearUid() {
    
    uid_ = 0L;
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

  public static final int MSGUID_FIELD_NUMBER = 7;
  private long msgUid_;
  /**
   * <code>int64 MsgUid = 7;</code>
   */
  public long getMsgUid() {
    return msgUid_;
  }
  /**
   * <code>int64 MsgUid = 7;</code>
   */
  private void setMsgUid(long value) {
    
    msgUid_ = value;
  }
  /**
   * <code>int64 MsgUid = 7;</code>
   */
  private void clearMsgUid() {
    
    msgUid_ = 0L;
  }

  public static final int MSGKEY_FIELD_NUMBER = 9;
  private java.lang.String msgKey_;
  /**
   * <code>string MsgKey = 9;</code>
   */
  public java.lang.String getMsgKey() {
    return msgKey_;
  }
  /**
   * <code>string MsgKey = 9;</code>
   */
  public com.google.protobuf.ByteString
      getMsgKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(msgKey_);
  }
  /**
   * <code>string MsgKey = 9;</code>
   */
  private void setMsgKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    msgKey_ = value;
  }
  /**
   * <code>string MsgKey = 9;</code>
   */
  private void clearMsgKey() {
    
    msgKey_ = getDefaultInstance().getMsgKey();
  }
  /**
   * <code>string MsgKey = 9;</code>
   */
  private void setMsgKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    msgKey_ = value.toStringUtf8();
  }

  public static final int ROOMKEY_FIELD_NUMBER = 11;
  private java.lang.String roomKey_;
  /**
   * <code>string RoomKey = 11;</code>
   */
  public java.lang.String getRoomKey() {
    return roomKey_;
  }
  /**
   * <code>string RoomKey = 11;</code>
   */
  public com.google.protobuf.ByteString
      getRoomKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(roomKey_);
  }
  /**
   * <code>string RoomKey = 11;</code>
   */
  private void setRoomKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    roomKey_ = value;
  }
  /**
   * <code>string RoomKey = 11;</code>
   */
  private void clearRoomKey() {
    
    roomKey_ = getDefaultInstance().getRoomKey();
  }
  /**
   * <code>string RoomKey = 11;</code>
   */
  private void setRoomKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    roomKey_ = value.toStringUtf8();
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

  public static final int ATTIME_FIELD_NUMBER = 17;
  private int atTime_;
  /**
   * <code>int32 AtTime = 17;</code>
   */
  public int getAtTime() {
    return atTime_;
  }
  /**
   * <code>int32 AtTime = 17;</code>
   */
  private void setAtTime(int value) {
    
    atTime_ = value;
  }
  /**
   * <code>int32 AtTime = 17;</code>
   */
  private void clearAtTime() {
    
    atTime_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (uid_ != 0L) {
      output.writeInt64(3, uid_);
    }
    if (toUserId_ != 0) {
      output.writeInt32(5, toUserId_);
    }
    if (msgUid_ != 0L) {
      output.writeInt64(7, msgUid_);
    }
    if (!msgKey_.isEmpty()) {
      output.writeString(9, getMsgKey());
    }
    if (!roomKey_.isEmpty()) {
      output.writeString(11, getRoomKey());
    }
    if (peerUserId_ != 0) {
      output.writeInt32(13, peerUserId_);
    }
    if (eventType_ != 0) {
      output.writeInt32(15, eventType_);
    }
    if (atTime_ != 0) {
      output.writeInt32(17, atTime_);
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
    if (uid_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, uid_);
    }
    if (toUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, toUserId_);
    }
    if (msgUid_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(7, msgUid_);
    }
    if (!msgKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(9, getMsgKey());
    }
    if (!roomKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(11, getRoomKey());
    }
    if (peerUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, peerUserId_);
    }
    if (eventType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(15, eventType_);
    }
    if (atTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(17, atTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_OldMsgPushEvent parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_OldMsgPushEvent prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_OldMsgPushEvent}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_OldMsgPushEvent, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_OldMsgPushEvent)
      ir.ms.pb.PB_OldMsgPushEventOrBuilder {
    // Construct using ir.ms.pb.PB_OldMsgPushEvent.newBuilder()
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
     * <code>int64 Uid = 3;</code>
     */
    public long getUid() {
      return instance.getUid();
    }
    /**
     * <code>int64 Uid = 3;</code>
     */
    public Builder setUid(long value) {
      copyOnWrite();
      instance.setUid(value);
      return this;
    }
    /**
     * <code>int64 Uid = 3;</code>
     */
    public Builder clearUid() {
      copyOnWrite();
      instance.clearUid();
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
     * <code>int64 MsgUid = 7;</code>
     */
    public long getMsgUid() {
      return instance.getMsgUid();
    }
    /**
     * <code>int64 MsgUid = 7;</code>
     */
    public Builder setMsgUid(long value) {
      copyOnWrite();
      instance.setMsgUid(value);
      return this;
    }
    /**
     * <code>int64 MsgUid = 7;</code>
     */
    public Builder clearMsgUid() {
      copyOnWrite();
      instance.clearMsgUid();
      return this;
    }

    /**
     * <code>string MsgKey = 9;</code>
     */
    public java.lang.String getMsgKey() {
      return instance.getMsgKey();
    }
    /**
     * <code>string MsgKey = 9;</code>
     */
    public com.google.protobuf.ByteString
        getMsgKeyBytes() {
      return instance.getMsgKeyBytes();
    }
    /**
     * <code>string MsgKey = 9;</code>
     */
    public Builder setMsgKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setMsgKey(value);
      return this;
    }
    /**
     * <code>string MsgKey = 9;</code>
     */
    public Builder clearMsgKey() {
      copyOnWrite();
      instance.clearMsgKey();
      return this;
    }
    /**
     * <code>string MsgKey = 9;</code>
     */
    public Builder setMsgKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMsgKeyBytes(value);
      return this;
    }

    /**
     * <code>string RoomKey = 11;</code>
     */
    public java.lang.String getRoomKey() {
      return instance.getRoomKey();
    }
    /**
     * <code>string RoomKey = 11;</code>
     */
    public com.google.protobuf.ByteString
        getRoomKeyBytes() {
      return instance.getRoomKeyBytes();
    }
    /**
     * <code>string RoomKey = 11;</code>
     */
    public Builder setRoomKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setRoomKey(value);
      return this;
    }
    /**
     * <code>string RoomKey = 11;</code>
     */
    public Builder clearRoomKey() {
      copyOnWrite();
      instance.clearRoomKey();
      return this;
    }
    /**
     * <code>string RoomKey = 11;</code>
     */
    public Builder setRoomKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRoomKeyBytes(value);
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
     * <code>int32 AtTime = 17;</code>
     */
    public int getAtTime() {
      return instance.getAtTime();
    }
    /**
     * <code>int32 AtTime = 17;</code>
     */
    public Builder setAtTime(int value) {
      copyOnWrite();
      instance.setAtTime(value);
      return this;
    }
    /**
     * <code>int32 AtTime = 17;</code>
     */
    public Builder clearAtTime() {
      copyOnWrite();
      instance.clearAtTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_OldMsgPushEvent)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_OldMsgPushEvent();
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
        ir.ms.pb.PB_OldMsgPushEvent other = (ir.ms.pb.PB_OldMsgPushEvent) arg1;
        id_ = visitor.visitLong(id_ != 0L, id_,
            other.id_ != 0L, other.id_);
        uid_ = visitor.visitLong(uid_ != 0L, uid_,
            other.uid_ != 0L, other.uid_);
        toUserId_ = visitor.visitInt(toUserId_ != 0, toUserId_,
            other.toUserId_ != 0, other.toUserId_);
        msgUid_ = visitor.visitLong(msgUid_ != 0L, msgUid_,
            other.msgUid_ != 0L, other.msgUid_);
        msgKey_ = visitor.visitString(!msgKey_.isEmpty(), msgKey_,
            !other.msgKey_.isEmpty(), other.msgKey_);
        roomKey_ = visitor.visitString(!roomKey_.isEmpty(), roomKey_,
            !other.roomKey_.isEmpty(), other.roomKey_);
        peerUserId_ = visitor.visitInt(peerUserId_ != 0, peerUserId_,
            other.peerUserId_ != 0, other.peerUserId_);
        eventType_ = visitor.visitInt(eventType_ != 0, eventType_,
            other.eventType_ != 0, other.eventType_);
        atTime_ = visitor.visitInt(atTime_ != 0, atTime_,
            other.atTime_ != 0, other.atTime_);
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

                uid_ = input.readInt64();
                break;
              }
              case 40: {

                toUserId_ = input.readInt32();
                break;
              }
              case 56: {

                msgUid_ = input.readInt64();
                break;
              }
              case 74: {
                String s = input.readStringRequireUtf8();

                msgKey_ = s;
                break;
              }
              case 90: {
                String s = input.readStringRequireUtf8();

                roomKey_ = s;
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

                atTime_ = input.readInt32();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_OldMsgPushEvent.class) {
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


  // @@protoc_insertion_point(class_scope:PB_OldMsgPushEvent)
  private static final ir.ms.pb.PB_OldMsgPushEvent DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_OldMsgPushEvent();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_OldMsgPushEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_OldMsgPushEvent> PARSER;

  public static com.google.protobuf.Parser<PB_OldMsgPushEvent> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

