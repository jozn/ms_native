// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_chat.proto

package ir.ms.pb;

public interface PB_GroupMemberViewOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:PB_GroupMemberView)
    com.google.protobuf.MessageLiteOrBuilder {

  /** <code>int64 Id = 1;</code> */
  long getId();

  /** <code>int64 GroupId = 2;</code> */
  long getGroupId();

  /** <code>int32 UserId = 3;</code> */
  int getUserId();

  /** <code>int32 ByUserId = 4;</code> */
  int getByUserId();

  /** <code>int32 GroupRoleEnum = 5;</code> */
  int getGroupRoleEnum();

  /** <code>int32 CreatedTime = 6;</code> */
  int getCreatedTime();
}
