// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

public interface PB_DirectUpdateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_DirectUpdate)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int64 DirectUpdateId = 1;</code>
   */
  long getDirectUpdateId();

  /**
   * <code>int32 ToUserId = 3;</code>
   */
  int getToUserId();

  /**
   * <code>int64 MessageId = 5;</code>
   */
  long getMessageId();

  /**
   * <code>int64 MessageFileId = 7;</code>
   */
  long getMessageFileId();

  /**
   * <code>int64 OtherId = 9;</code>
   */
  long getOtherId();

  /**
   * <code>string ChatKey = 11;</code>
   */
  java.lang.String getChatKey();
  /**
   * <code>string ChatKey = 11;</code>
   */
  com.google.protobuf.ByteString
      getChatKeyBytes();

  /**
   * <code>int32 PeerUserId = 13;</code>
   */
  int getPeerUserId();

  /**
   * <code>int32 EventType = 15;</code>
   */
  int getEventType();

  /**
   * <code>int32 RoomLogTypeId = 17;</code>
   */
  int getRoomLogTypeId();

  /**
   * <code>int32 FromSeq = 19;</code>
   */
  int getFromSeq();

  /**
   * <code>int32 ToSeq = 21;</code>
   */
  int getToSeq();

  /**
   * <code>bytes ExtraPB = 23;</code>
   */
  com.google.protobuf.ByteString getExtraPB();

  /**
   * <code>string ExtraJson = 25;</code>
   */
  java.lang.String getExtraJson();
  /**
   * <code>string ExtraJson = 25;</code>
   */
  com.google.protobuf.ByteString
      getExtraJsonBytes();

  /**
   * <code>int64 AtTimeMs = 27;</code>
   */
  long getAtTimeMs();
}
