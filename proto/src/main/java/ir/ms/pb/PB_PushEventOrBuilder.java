// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

public interface PB_PushEventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_PushEvent)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int64 PushEventId = 1;</code>
   */
  long getPushEventId();

  /**
   * <code>int32 ToUserId = 3;</code>
   */
  int getToUserId();

  /**
   * <code>int64 ToDeviceId = 5;</code>
   */
  long getToDeviceId();

  /**
   * <code>int64 MessageId = 7;</code>
   */
  long getMessageId();

  /**
   * <code>int32 RoomTypeEnum = 9;</code>
   */
  int getRoomTypeEnum();

  /**
   * <code>int64 RoomId = 11;</code>
   */
  long getRoomId();

  /**
   * <code>int32 PeerUserId = 13;</code>
   */
  int getPeerUserId();

  /**
   * <code>int32 PushEventTypeEnum = 15;</code>
   */
  int getPushEventTypeEnum();

  /**
   * <code>int32 AtTime = 17;</code>
   */
  int getAtTime();
}
