// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_chat.proto

package ir.ms.pb;

public interface PB_RequestSetLastSeenMessagesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_RequestSetLastSeenMessages)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int64 RoomId = 1;</code>
   */
  long getRoomId();

  /**
   * <code>int64 FromMessageId = 2;</code>
   */
  long getFromMessageId();

  /**
   * <code>int32 ToMessageId = 3;</code>
   */
  int getToMessageId();

  /**
   * <code>int64 AtTimeMs = 4;</code>
   */
  long getAtTimeMs();
}
