// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

public interface PB_CommentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_Comment)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int32 Id = 1;</code>
   */
  int getId();

  /**
   * <code>int32 UserId = 3;</code>
   */
  int getUserId();

  /**
   * <code>int32 PostId = 5;</code>
   */
  int getPostId();

  /**
   * <code>string Text = 7;</code>
   */
  java.lang.String getText();
  /**
   * <code>string Text = 7;</code>
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>int32 CreatedTime = 9;</code>
   */
  int getCreatedTime();
}
