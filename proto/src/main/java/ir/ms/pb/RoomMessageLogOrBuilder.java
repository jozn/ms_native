// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_enums.proto

package ir.ms.pb;

public interface RoomMessageLogOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RoomMessageLog)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>.RoomMessageLogEnum typ = 1;</code>
   */
  int getTypValue();
  /**
   * <code>.RoomMessageLogEnum typ = 1;</code>
   */
  ir.ms.pb.RoomMessageLogEnum getTyp();

  /**
   * <code>uint64 TargetUserId = 2;</code>
   */
  long getTargetUserId();

  /**
   * <pre>
   *    /&#42;
   *    enum ExtraType {
   *        NO_EXTRA = 0;
   *        TARGET_USER = 1;
   *    }
   *    ExtraType extra_type = 2;
   *    message TargetUser {
   *    }
   *    TargetUser target_user = 3;*&#47;
   * </pre>
   *
   * <code>uint64 ByUserId = 3;</code>
   */
  long getByUserId();
}
