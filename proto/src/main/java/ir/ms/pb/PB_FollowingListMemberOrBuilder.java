// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

public interface PB_FollowingListMemberOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_FollowingListMember)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int64 Id = 1;</code>
   */
  long getId();

  /**
   * <code>int32 ListId = 3;</code>
   */
  int getListId();

  /**
   * <code>int32 UserId = 5;</code>
   */
  int getUserId();

  /**
   * <code>int32 FollowedUserId = 7;</code>
   */
  int getFollowedUserId();

  /**
   * <code>int32 FollowType = 9;</code>
   */
  int getFollowType();

  /**
   * <code>int64 UpdatedTimeMs = 11;</code>
   */
  long getUpdatedTimeMs();
}
