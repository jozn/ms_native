// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_seen_msgs.proto

package ir.ms.pb;

public interface PB_MsgSeenOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_MsgSeen)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>string MessageKey = 1;</code>
   */
  java.lang.String getMessageKey();
  /**
   * <code>string MessageKey = 1;</code>
   */
  com.google.protobuf.ByteString
      getMessageKeyBytes();

  /**
   * <code>string RoomKey = 2;</code>
   */
  java.lang.String getRoomKey();
  /**
   * <code>string RoomKey = 2;</code>
   */
  com.google.protobuf.ByteString
      getRoomKeyBytes();

  /**
   * <code>int64 UserId = 3;</code>
   */
  long getUserId();

  /**
   * <code>int64 AtTime = 10;</code>
   */
  long getAtTime();
}
