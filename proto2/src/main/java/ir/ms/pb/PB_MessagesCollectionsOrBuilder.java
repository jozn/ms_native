// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_chat.proto

package ir.ms.pb;

public interface PB_MessagesCollectionsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:PB_MessagesCollections)
    com.google.protobuf.MessageLiteOrBuilder {

  /** <code>repeated int64 DirectMessagesIds = 10;</code> */
  java.util.List<java.lang.Long> getDirectMessagesIdsList();
  /** <code>repeated int64 DirectMessagesIds = 10;</code> */
  int getDirectMessagesIdsCount();
  /** <code>repeated int64 DirectMessagesIds = 10;</code> */
  long getDirectMessagesIds(int index);

  /** <code>repeated int64 GroupMessagesIds = 20;</code> */
  java.util.List<java.lang.Long> getGroupMessagesIdsList();
  /** <code>repeated int64 GroupMessagesIds = 20;</code> */
  int getGroupMessagesIdsCount();
  /** <code>repeated int64 GroupMessagesIds = 20;</code> */
  long getGroupMessagesIds(int index);

  /** <code>repeated int64 BroadCatMessagesIds = 21;</code> */
  java.util.List<java.lang.Long> getBroadCatMessagesIdsList();
  /** <code>repeated int64 BroadCatMessagesIds = 21;</code> */
  int getBroadCatMessagesIdsCount();
  /** <code>repeated int64 BroadCatMessagesIds = 21;</code> */
  long getBroadCatMessagesIds(int index);
}
