// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_del.proto

package ir.ms.pb;

public interface PB_MessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_Message)
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
   * <code>int64 PeerId = 20;</code>
   */
  long getPeerId();

  /**
   * <code>int32 RoomTypeId = 4;</code>
   */
  int getRoomTypeId();

  /**
   * <code>int32 MessageTypeId = 5;</code>
   */
  int getMessageTypeId();

  /**
   * <code>string Text = 6;</code>
   */
  java.lang.String getText();
  /**
   * <code>string Text = 6;</code>
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>string ExtraJson = 7;</code>
   */
  java.lang.String getExtraJson();
  /**
   * <code>string ExtraJson = 7;</code>
   */
  com.google.protobuf.ByteString
      getExtraJsonBytes();

  /**
   * <code>int32 IsByMe = 8;</code>
   */
  int getIsByMe();

  /**
   * <code>int32 IsStared = 9;</code>
   */
  int getIsStared();

  /**
   * <code>int64 CreatedMs = 10;</code>
   */
  long getCreatedMs();

  /**
   * <code>int64 CreatedDeviceMs = 11;</code>
   */
  long getCreatedDeviceMs();

  /**
   * <code>int64 SortId = 12;</code>
   */
  long getSortId();

  /**
   * <code>int64 PeerSeenTime = 13;</code>
   */
  long getPeerSeenTime();

  /**
   * <code>int64 ServerReceivedTime = 14;</code>
   */
  long getServerReceivedTime();

  /**
   * <code>int64 ServerDeletedTime = 15;</code>
   */
  long getServerDeletedTime();

  /**
   * <code>int64 ISeenTime = 16;</code>
   */
  long getISeenTime();

  /**
   * <code>int32 ToPush = 17;</code>
   */
  int getToPush();

  /**
   * <code>string MsgFile_LocalSrc = 18;</code>
   */
  java.lang.String getMsgFileLocalSrc();
  /**
   * <code>string MsgFile_LocalSrc = 18;</code>
   */
  com.google.protobuf.ByteString
      getMsgFileLocalSrcBytes();

  /**
   * <code>int32 MsgFile_Status = 19;</code>
   */
  int getMsgFileStatus();

  /**
   * <code>.PB_MsgFile File = 100;</code>
   */
  boolean hasFile();
  /**
   * <code>.PB_MsgFile File = 100;</code>
   */
  ir.ms.pb.PB_MsgFile getFile();
}
