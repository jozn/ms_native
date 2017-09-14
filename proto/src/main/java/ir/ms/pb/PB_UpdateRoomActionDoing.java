// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_updates.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_UpdateRoomActionDoing}
 */
public  final class PB_UpdateRoomActionDoing extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UpdateRoomActionDoing, PB_UpdateRoomActionDoing.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UpdateRoomActionDoing)
    PB_UpdateRoomActionDoingOrBuilder {
  private PB_UpdateRoomActionDoing() {
    roomKey_ = "";
  }
  public static final int ROOMKEY_FIELD_NUMBER = 2;
  private java.lang.String roomKey_;
  /**
   * <pre>
   *    int64 ChatId = 1;
   * </pre>
   *
   * <code>string RoomKey = 2;</code>
   */
  public java.lang.String getRoomKey() {
    return roomKey_;
  }
  /**
   * <pre>
   *    int64 ChatId = 1;
   * </pre>
   *
   * <code>string RoomKey = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRoomKeyBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(roomKey_);
  }
  /**
   * <pre>
   *    int64 ChatId = 1;
   * </pre>
   *
   * <code>string RoomKey = 2;</code>
   */
  private void setRoomKey(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    roomKey_ = value;
  }
  /**
   * <pre>
   *    int64 ChatId = 1;
   * </pre>
   *
   * <code>string RoomKey = 2;</code>
   */
  private void clearRoomKey() {
    
    roomKey_ = getDefaultInstance().getRoomKey();
  }
  /**
   * <pre>
   *    int64 ChatId = 1;
   * </pre>
   *
   * <code>string RoomKey = 2;</code>
   */
  private void setRoomKeyBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    roomKey_ = value.toStringUtf8();
  }

  public static final int ACTIONTYPE_FIELD_NUMBER = 3;
  private int actionType_;
  /**
   * <code>.RoomActionDoingEnum ActionType = 3;</code>
   */
  public int getActionTypeValue() {
    return actionType_;
  }
  /**
   * <code>.RoomActionDoingEnum ActionType = 3;</code>
   */
  public ir.ms.pb.RoomActionDoingEnum getActionType() {
    ir.ms.pb.RoomActionDoingEnum result = ir.ms.pb.RoomActionDoingEnum.forNumber(actionType_);
    return result == null ? ir.ms.pb.RoomActionDoingEnum.UNRECOGNIZED : result;
  }
  /**
   * <code>.RoomActionDoingEnum ActionType = 3;</code>
   */
  private void setActionTypeValue(int value) {
      actionType_ = value;
  }
  /**
   * <code>.RoomActionDoingEnum ActionType = 3;</code>
   */
  private void setActionType(ir.ms.pb.RoomActionDoingEnum value) {
    if (value == null) {
      throw new NullPointerException();
    }
    
    actionType_ = value.getNumber();
  }
  /**
   * <code>.RoomActionDoingEnum ActionType = 3;</code>
   */
  private void clearActionType() {
    
    actionType_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!roomKey_.isEmpty()) {
      output.writeString(2, getRoomKey());
    }
    if (actionType_ != ir.ms.pb.RoomActionDoingEnum.UNKNOWN_ROOM_ACTION_DOING.getNumber()) {
      output.writeEnum(3, actionType_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!roomKey_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getRoomKey());
    }
    if (actionType_ != ir.ms.pb.RoomActionDoingEnum.UNKNOWN_ROOM_ACTION_DOING.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, actionType_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UpdateRoomActionDoing parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UpdateRoomActionDoing prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_UpdateRoomActionDoing}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UpdateRoomActionDoing, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UpdateRoomActionDoing)
      ir.ms.pb.PB_UpdateRoomActionDoingOrBuilder {
    // Construct using ir.ms.pb.PB_UpdateRoomActionDoing.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     *    int64 ChatId = 1;
     * </pre>
     *
     * <code>string RoomKey = 2;</code>
     */
    public java.lang.String getRoomKey() {
      return instance.getRoomKey();
    }
    /**
     * <pre>
     *    int64 ChatId = 1;
     * </pre>
     *
     * <code>string RoomKey = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRoomKeyBytes() {
      return instance.getRoomKeyBytes();
    }
    /**
     * <pre>
     *    int64 ChatId = 1;
     * </pre>
     *
     * <code>string RoomKey = 2;</code>
     */
    public Builder setRoomKey(
        java.lang.String value) {
      copyOnWrite();
      instance.setRoomKey(value);
      return this;
    }
    /**
     * <pre>
     *    int64 ChatId = 1;
     * </pre>
     *
     * <code>string RoomKey = 2;</code>
     */
    public Builder clearRoomKey() {
      copyOnWrite();
      instance.clearRoomKey();
      return this;
    }
    /**
     * <pre>
     *    int64 ChatId = 1;
     * </pre>
     *
     * <code>string RoomKey = 2;</code>
     */
    public Builder setRoomKeyBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setRoomKeyBytes(value);
      return this;
    }

    /**
     * <code>.RoomActionDoingEnum ActionType = 3;</code>
     */
    public int getActionTypeValue() {
      return instance.getActionTypeValue();
    }
    /**
     * <code>.RoomActionDoingEnum ActionType = 3;</code>
     */
    public Builder setActionTypeValue(int value) {
      copyOnWrite();
      instance.setActionTypeValue(value);
      return this;
    }
    /**
     * <code>.RoomActionDoingEnum ActionType = 3;</code>
     */
    public ir.ms.pb.RoomActionDoingEnum getActionType() {
      return instance.getActionType();
    }
    /**
     * <code>.RoomActionDoingEnum ActionType = 3;</code>
     */
    public Builder setActionType(ir.ms.pb.RoomActionDoingEnum value) {
      copyOnWrite();
      instance.setActionType(value);
      return this;
    }
    /**
     * <code>.RoomActionDoingEnum ActionType = 3;</code>
     */
    public Builder clearActionType() {
      copyOnWrite();
      instance.clearActionType();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UpdateRoomActionDoing)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UpdateRoomActionDoing();
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
        ir.ms.pb.PB_UpdateRoomActionDoing other = (ir.ms.pb.PB_UpdateRoomActionDoing) arg1;
        roomKey_ = visitor.visitString(!roomKey_.isEmpty(), roomKey_,
            !other.roomKey_.isEmpty(), other.roomKey_);
        actionType_ = visitor.visitInt(actionType_ != 0, actionType_,    other.actionType_ != 0, other.actionType_);
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
              case 18: {
                String s = input.readStringRequireUtf8();

                roomKey_ = s;
                break;
              }
              case 24: {
                int rawValue = input.readEnum();

                actionType_ = rawValue;
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UpdateRoomActionDoing.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UpdateRoomActionDoing)
  private static final ir.ms.pb.PB_UpdateRoomActionDoing DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UpdateRoomActionDoing();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UpdateRoomActionDoing getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UpdateRoomActionDoing> PARSER;

  public static com.google.protobuf.Parser<PB_UpdateRoomActionDoing> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

