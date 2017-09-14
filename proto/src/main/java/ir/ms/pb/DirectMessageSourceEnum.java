// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_enums.proto

package ir.ms.pb;

/**
 * Protobuf enum {@code DirectMessageSourceEnum}
 */
public enum DirectMessageSourceEnum
    implements com.google.protobuf.Internal.EnumLite {
  /**
   * <code>UNKNOWN_DIRECT_SOURCE = 0;</code>
   */
  UNKNOWN_DIRECT_SOURCE(0),
  /**
   * <code>COMPOSE_SOURCE = 1;</code>
   */
  COMPOSE_SOURCE(1),
  /**
   * <code>FORWARD_SOURCE = 2;</code>
   */
  FORWARD_SOURCE(2),
  /**
   * <pre>
   * FEMALE = 12;
   * </pre>
   *
   * <code>BROADCAST_SOURCE = 3;</code>
   */
  BROADCAST_SOURCE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_DIRECT_SOURCE = 0;</code>
   */
  public static final int UNKNOWN_DIRECT_SOURCE_VALUE = 0;
  /**
   * <code>COMPOSE_SOURCE = 1;</code>
   */
  public static final int COMPOSE_SOURCE_VALUE = 1;
  /**
   * <code>FORWARD_SOURCE = 2;</code>
   */
  public static final int FORWARD_SOURCE_VALUE = 2;
  /**
   * <pre>
   * FEMALE = 12;
   * </pre>
   *
   * <code>BROADCAST_SOURCE = 3;</code>
   */
  public static final int BROADCAST_SOURCE_VALUE = 3;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static DirectMessageSourceEnum valueOf(int value) {
    return forNumber(value);
  }

  public static DirectMessageSourceEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_DIRECT_SOURCE;
      case 1: return COMPOSE_SOURCE;
      case 2: return FORWARD_SOURCE;
      case 3: return BROADCAST_SOURCE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DirectMessageSourceEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      DirectMessageSourceEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<DirectMessageSourceEnum>() {
          public DirectMessageSourceEnum findValueByNumber(int number) {
            return DirectMessageSourceEnum.forNumber(number);
          }
        };

  private final int value;

  private DirectMessageSourceEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:DirectMessageSourceEnum)
}

