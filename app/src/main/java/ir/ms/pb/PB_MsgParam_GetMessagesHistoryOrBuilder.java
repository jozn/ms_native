// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

public interface PB_MsgParam_GetMessagesHistoryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_MsgParam_GetMessagesHistory)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int64 ChatId = 1;</code>
   */
  long getChatId();

  /**
   * <code>sint32 FromSeq = 2;</code>
   */
  int getFromSeq();

  /**
   * <code>sint32 EndSeq = 3;</code>
   */
  int getEndSeq();
}
