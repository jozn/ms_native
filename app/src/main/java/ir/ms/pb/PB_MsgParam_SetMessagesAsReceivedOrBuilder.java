// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

public interface PB_MsgParam_SetMessagesAsReceivedOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_MsgParam_SetMessagesAsReceived)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   *    /&#42;int64 ChatId = 1;
   *    RoomTypeEnum RoomType = 2;
   *    repeated int64 MessageId = 3;
   *    repeated int64 DirectMessagesIds = 10;
   *    repeated int64 GroupMessagesIds = 20;*&#47;
   * </pre>
   *
   * <code>.PB_MessagesCollections MessagesCollections = 1;</code>
   */
  boolean hasMessagesCollections();
  /**
   * <pre>
   *    /&#42;int64 ChatId = 1;
   *    RoomTypeEnum RoomType = 2;
   *    repeated int64 MessageId = 3;
   *    repeated int64 DirectMessagesIds = 10;
   *    repeated int64 GroupMessagesIds = 20;*&#47;
   * </pre>
   *
   * <code>.PB_MessagesCollections MessagesCollections = 1;</code>
   */
  ir.ms.pb.PB_MessagesCollections getMessagesCollections();
}
