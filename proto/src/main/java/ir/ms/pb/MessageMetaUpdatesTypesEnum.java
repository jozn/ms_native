// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_enums.proto

package ir.ms.pb;

/**
 * Protobuf enum {@code MessageMetaUpdatesTypesEnum}
 */
public enum MessageMetaUpdatesTypesEnum
    implements com.google.protobuf.Internal.EnumLite {
  /**
   * <code>UNKNOWN_MESSAGE_META_UPDATE = 0;</code>
   */
  UNKNOWN_MESSAGE_META_UPDATE(0),
  /**
   * <code>DELIVIERD_SERVER = 1;</code>
   */
  DELIVIERD_SERVER(1),
  /**
   * <code>DELIVIERD_PEER = 2;</code>
   */
  DELIVIERD_PEER(2),
  /**
   * <code>SEEN_MESSAGE = 3;</code>
   */
  SEEN_MESSAGE(3),
  /**
   * <code>DELETE_SERVER = 4;</code>
   */
  DELETE_SERVER(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_MESSAGE_META_UPDATE = 0;</code>
   */
  public static final int UNKNOWN_MESSAGE_META_UPDATE_VALUE = 0;
  /**
   * <code>DELIVIERD_SERVER = 1;</code>
   */
  public static final int DELIVIERD_SERVER_VALUE = 1;
  /**
   * <code>DELIVIERD_PEER = 2;</code>
   */
  public static final int DELIVIERD_PEER_VALUE = 2;
  /**
   * <code>SEEN_MESSAGE = 3;</code>
   */
  public static final int SEEN_MESSAGE_VALUE = 3;
  /**
   * <code>DELETE_SERVER = 4;</code>
   */
  public static final int DELETE_SERVER_VALUE = 4;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MessageMetaUpdatesTypesEnum valueOf(int value) {
    return forNumber(value);
  }

  public static MessageMetaUpdatesTypesEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_MESSAGE_META_UPDATE;
      case 1: return DELIVIERD_SERVER;
      case 2: return DELIVIERD_PEER;
      case 3: return SEEN_MESSAGE;
      case 4: return DELETE_SERVER;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MessageMetaUpdatesTypesEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MessageMetaUpdatesTypesEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MessageMetaUpdatesTypesEnum>() {
          public MessageMetaUpdatesTypesEnum findValueByNumber(int number) {
            return MessageMetaUpdatesTypesEnum.forNumber(number);
          }
        };

  private final int value;

  private MessageMetaUpdatesTypesEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:MessageMetaUpdatesTypesEnum)
}

