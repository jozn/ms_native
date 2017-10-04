// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_views.proto

package ir.ms.pb;

public interface PB_MessageViewOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_MessageView)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int64 MessageId = 1;</code>
   */
  long getMessageId();

  /**
   * <code>string MessageKey = 3;</code>
   */
  java.lang.String getMessageKey();
  /**
   * <code>string MessageKey = 3;</code>
   */
  com.google.protobuf.ByteString
      getMessageKeyBytes();

  /**
   * <code>string RoomKey = 5;</code>
   */
  java.lang.String getRoomKey();
  /**
   * <code>string RoomKey = 5;</code>
   */
  com.google.protobuf.ByteString
      getRoomKeyBytes();

  /**
   * <code>int32 UserId = 7;</code>
   */
  int getUserId();

  /**
   * <code>int64 MessageFileId = 9;</code>
   */
  long getMessageFileId();

  /**
   * <code>int32 MessageTypeEnumId = 11;</code>
   */
  int getMessageTypeEnumId();

  /**
   * <code>string Text = 13;</code>
   */
  java.lang.String getText();
  /**
   * <code>string Text = 13;</code>
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>int32 CreatedSe = 15;</code>
   */
  int getCreatedSe();

  /**
   * <code>int32 PeerReceivedTime = 17;</code>
   */
  int getPeerReceivedTime();

  /**
   * <code>int32 PeerSeenTime = 19;</code>
   */
  int getPeerSeenTime();

  /**
   * <code>int32 DeliviryStatusEnumId = 21;</code>
   */
  int getDeliviryStatusEnumId();

  /**
   * <code>string ChatKey = 30;</code>
   */
  java.lang.String getChatKey();
  /**
   * <code>string ChatKey = 30;</code>
   */
  com.google.protobuf.ByteString
      getChatKeyBytes();

  /**
   * <code>int32 RoomTypeEnumId = 31;</code>
   */
  int getRoomTypeEnumId();

  /**
   * <code>bool IsByMe = 33;</code>
   */
  boolean getIsByMe();

  /**
   * <code>int64 RemoteId = 50;</code>
   */
  long getRemoteId();

  /**
   * <code>.PB_MessageFileView MessageFileView = 100;</code>
   */
  boolean hasMessageFileView();
  /**
   * <code>.PB_MessageFileView MessageFileView = 100;</code>
   */
  ir.ms.pb.PB_MessageFileView getMessageFileView();
}
