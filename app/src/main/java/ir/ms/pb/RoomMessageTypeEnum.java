// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_enums.proto

package ir.ms.pb;

/**
 * Protobuf enum {@code RoomMessageTypeEnum}
 */
public enum RoomMessageTypeEnum
    implements com.google.protobuf.Internal.EnumLite {
  /**
   * <pre>
   *UNKNOWN = 0;
   * </pre>
   *
   * <code>TEXT = 0;</code>
   */
  TEXT(0),
  /**
   * <code>IMAGE = 1;</code>
   */
  IMAGE(1),
  /**
   * <code>IMAGE_TEXT = 2;</code>
   */
  IMAGE_TEXT(2),
  /**
   * <code>VIDEO = 3;</code>
   */
  VIDEO(3),
  /**
   * <code>VIDEO_TEXT = 4;</code>
   */
  VIDEO_TEXT(4),
  /**
   * <code>AUDIO = 5;</code>
   */
  AUDIO(5),
  /**
   * <code>AUDIO_TEXT = 6;</code>
   */
  AUDIO_TEXT(6),
  /**
   * <code>VOICE = 7;</code>
   */
  VOICE(7),
  /**
   * <code>GIF = 8;</code>
   */
  GIF(8),
  /**
   * <code>GIF_TEXT = 14;</code>
   */
  GIF_TEXT(14),
  /**
   * <code>FILE = 9;</code>
   */
  FILE(9),
  /**
   * <code>FILE_TEXT = 10;</code>
   */
  FILE_TEXT(10),
  /**
   * <code>LOCATION = 11;</code>
   */
  LOCATION(11),
  /**
   * <code>CONTACT = 12;</code>
   */
  CONTACT(12),
  /**
   * <pre>
   *from 100 to 200 all are log types
   * </pre>
   *
   * <code>LOG = 100;</code>
   */
  LOG(100),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   *UNKNOWN = 0;
   * </pre>
   *
   * <code>TEXT = 0;</code>
   */
  public static final int TEXT_VALUE = 0;
  /**
   * <code>IMAGE = 1;</code>
   */
  public static final int IMAGE_VALUE = 1;
  /**
   * <code>IMAGE_TEXT = 2;</code>
   */
  public static final int IMAGE_TEXT_VALUE = 2;
  /**
   * <code>VIDEO = 3;</code>
   */
  public static final int VIDEO_VALUE = 3;
  /**
   * <code>VIDEO_TEXT = 4;</code>
   */
  public static final int VIDEO_TEXT_VALUE = 4;
  /**
   * <code>AUDIO = 5;</code>
   */
  public static final int AUDIO_VALUE = 5;
  /**
   * <code>AUDIO_TEXT = 6;</code>
   */
  public static final int AUDIO_TEXT_VALUE = 6;
  /**
   * <code>VOICE = 7;</code>
   */
  public static final int VOICE_VALUE = 7;
  /**
   * <code>GIF = 8;</code>
   */
  public static final int GIF_VALUE = 8;
  /**
   * <code>GIF_TEXT = 14;</code>
   */
  public static final int GIF_TEXT_VALUE = 14;
  /**
   * <code>FILE = 9;</code>
   */
  public static final int FILE_VALUE = 9;
  /**
   * <code>FILE_TEXT = 10;</code>
   */
  public static final int FILE_TEXT_VALUE = 10;
  /**
   * <code>LOCATION = 11;</code>
   */
  public static final int LOCATION_VALUE = 11;
  /**
   * <code>CONTACT = 12;</code>
   */
  public static final int CONTACT_VALUE = 12;
  /**
   * <pre>
   *from 100 to 200 all are log types
   * </pre>
   *
   * <code>LOG = 100;</code>
   */
  public static final int LOG_VALUE = 100;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static RoomMessageTypeEnum valueOf(int value) {
    return forNumber(value);
  }

  public static RoomMessageTypeEnum forNumber(int value) {
    switch (value) {
      case 0: return TEXT;
      case 1: return IMAGE;
      case 2: return IMAGE_TEXT;
      case 3: return VIDEO;
      case 4: return VIDEO_TEXT;
      case 5: return AUDIO;
      case 6: return AUDIO_TEXT;
      case 7: return VOICE;
      case 8: return GIF;
      case 14: return GIF_TEXT;
      case 9: return FILE;
      case 10: return FILE_TEXT;
      case 11: return LOCATION;
      case 12: return CONTACT;
      case 100: return LOG;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<RoomMessageTypeEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      RoomMessageTypeEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<RoomMessageTypeEnum>() {
          public RoomMessageTypeEnum findValueByNumber(int number) {
            return RoomMessageTypeEnum.forNumber(number);
          }
        };

  private final int value;

  private RoomMessageTypeEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:RoomMessageTypeEnum)
}

