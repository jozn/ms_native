// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

public interface PB_MsgParam_ForwardMessagesOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:PB_MsgParam_ForwardMessages)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   *
   *
   * <pre>
   *    /&#42;repeated int64 DirectMessagesIds = 1;
   *    repeated int64 GroupMessagesIds = 2;*&#47;
   * </pre>
   *
   * <code>.PB_MessagesCollections MessagesCollections = 1;</code>
   */
  boolean hasMessagesCollections();
  /**
   *
   *
   * <pre>
   *    /&#42;repeated int64 DirectMessagesIds = 1;
   *    repeated int64 GroupMessagesIds = 2;*&#47;
   * </pre>
   *
   * <code>.PB_MessagesCollections MessagesCollections = 1;</code>
   */
  ir.ms.pb.PB_MessagesCollections getMessagesCollections();

  /** <code>repeated int64 ToDirectChatIds = 3;</code> */
  java.util.List<java.lang.Long> getToDirectChatIdsList();
  /** <code>repeated int64 ToDirectChatIds = 3;</code> */
  int getToDirectChatIdsCount();
  /** <code>repeated int64 ToDirectChatIds = 3;</code> */
  long getToDirectChatIds(int index);

  /** <code>repeated int64 ToGroupChatIds = 4;</code> */
  java.util.List<java.lang.Long> getToGroupChatIdsList();
  /** <code>repeated int64 ToGroupChatIds = 4;</code> */
  int getToGroupChatIdsCount();
  /** <code>repeated int64 ToGroupChatIds = 4;</code> */
  long getToGroupChatIds(int index);
}
