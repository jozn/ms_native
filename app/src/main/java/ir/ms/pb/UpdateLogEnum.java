// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_updates.proto

package ir.ms.pb;

/**
 * <pre>
 *&#47;//////////////////////////////////////////
 * </pre>
 *
 * Protobuf enum {@code UpdateLogEnum}
 */
public enum UpdateLogEnum
    implements com.google.protobuf.Internal.EnumLite {
  /**
   * <code>UNKNOWN_UPDATE_LOG = 0;</code>
   */
  UNKNOWN_UPDATE_LOG(0),
  /**
   * <code>UPDATE_NEWMESSAGE = 1;</code>
   */
  UPDATE_NEWMESSAGE(1),
  /**
   * <code>UPDATE_MESSAGE_ID = 2;</code>
   */
  UPDATE_MESSAGE_ID(2),
  /**
   * <code>UPDATE_SEENMESSAGES = 3;</code>
   */
  UPDATE_SEENMESSAGES(3),
  /**
   * <code>UPDATE_DELIVIERD_MESSAGES = 4;</code>
   */
  UPDATE_DELIVIERD_MESSAGES(4),
  /**
   * <code>UPDATE_DELETED_FROM_SERVERM_ESSAGES = 5;</code>
   */
  UPDATE_DELETED_FROM_SERVERM_ESSAGES(5),
  /**
   * <code>UPDATE_DELETE_MESSAGES = 6;</code>
   */
  UPDATE_DELETE_MESSAGES(6),
  /**
   * <code>UPDATE_ROOM_ACTIONDOING = 10;</code>
   */
  UPDATE_ROOM_ACTIONDOING(10),
  /**
   * <code>UPDATE_USER_BLOCKED = 11;</code>
   */
  UPDATE_USER_BLOCKED(11),
  /**
   * <code>UPDATE_NOTIF_YSETTINGS = 12;</code>
   */
  UPDATE_NOTIF_YSETTINGS(12),
  /**
   * <code>UPDATE_SERVICE_NOTIFICATION = 15;</code>
   */
  UPDATE_SERVICE_NOTIFICATION(15),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_UPDATE_LOG = 0;</code>
   */
  public static final int UNKNOWN_UPDATE_LOG_VALUE = 0;
  /**
   * <code>UPDATE_NEWMESSAGE = 1;</code>
   */
  public static final int UPDATE_NEWMESSAGE_VALUE = 1;
  /**
   * <code>UPDATE_MESSAGE_ID = 2;</code>
   */
  public static final int UPDATE_MESSAGE_ID_VALUE = 2;
  /**
   * <code>UPDATE_SEENMESSAGES = 3;</code>
   */
  public static final int UPDATE_SEENMESSAGES_VALUE = 3;
  /**
   * <code>UPDATE_DELIVIERD_MESSAGES = 4;</code>
   */
  public static final int UPDATE_DELIVIERD_MESSAGES_VALUE = 4;
  /**
   * <code>UPDATE_DELETED_FROM_SERVERM_ESSAGES = 5;</code>
   */
  public static final int UPDATE_DELETED_FROM_SERVERM_ESSAGES_VALUE = 5;
  /**
   * <code>UPDATE_DELETE_MESSAGES = 6;</code>
   */
  public static final int UPDATE_DELETE_MESSAGES_VALUE = 6;
  /**
   * <code>UPDATE_ROOM_ACTIONDOING = 10;</code>
   */
  public static final int UPDATE_ROOM_ACTIONDOING_VALUE = 10;
  /**
   * <code>UPDATE_USER_BLOCKED = 11;</code>
   */
  public static final int UPDATE_USER_BLOCKED_VALUE = 11;
  /**
   * <code>UPDATE_NOTIF_YSETTINGS = 12;</code>
   */
  public static final int UPDATE_NOTIF_YSETTINGS_VALUE = 12;
  /**
   * <code>UPDATE_SERVICE_NOTIFICATION = 15;</code>
   */
  public static final int UPDATE_SERVICE_NOTIFICATION_VALUE = 15;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static UpdateLogEnum valueOf(int value) {
    return forNumber(value);
  }

  public static UpdateLogEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_UPDATE_LOG;
      case 1: return UPDATE_NEWMESSAGE;
      case 2: return UPDATE_MESSAGE_ID;
      case 3: return UPDATE_SEENMESSAGES;
      case 4: return UPDATE_DELIVIERD_MESSAGES;
      case 5: return UPDATE_DELETED_FROM_SERVERM_ESSAGES;
      case 6: return UPDATE_DELETE_MESSAGES;
      case 10: return UPDATE_ROOM_ACTIONDOING;
      case 11: return UPDATE_USER_BLOCKED;
      case 12: return UPDATE_NOTIF_YSETTINGS;
      case 15: return UPDATE_SERVICE_NOTIFICATION;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<UpdateLogEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      UpdateLogEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<UpdateLogEnum>() {
          public UpdateLogEnum findValueByNumber(int number) {
            return UpdateLogEnum.forNumber(number);
          }
        };

  private final int value;

  private UpdateLogEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:UpdateLogEnum)
}

