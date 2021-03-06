// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_views.proto

package ir.ms.pb;

public interface PB_MessageFileViewOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_MessageFileView)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   *    option realm = "1";
   * </pre>
   *
   * <code>int64 MessageFileId = 1;</code>
   */
  long getMessageFileId();

  /**
   * <code>string MessageFileKey = 32;</code>
   */
  java.lang.String getMessageFileKey();
  /**
   * <code>string MessageFileKey = 32;</code>
   */
  com.google.protobuf.ByteString
      getMessageFileKeyBytes();

  /**
   * <code>int32 OriginalUserId = 2;</code>
   */
  int getOriginalUserId();

  /**
   * <code>string Name = 3;</code>
   */
  java.lang.String getName();
  /**
   * <code>string Name = 3;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 Size = 5;</code>
   */
  int getSize();

  /**
   * <code>int32 FileTypeEnumId = 7;</code>
   */
  int getFileTypeEnumId();

  /**
   * <code>int32 Width = 9;</code>
   */
  int getWidth();

  /**
   * <code>int32 Height = 11;</code>
   */
  int getHeight();

  /**
   * <code>int32 Duration = 13;</code>
   */
  int getDuration();

  /**
   * <code>string Extension = 15;</code>
   */
  java.lang.String getExtension();
  /**
   * <code>string Extension = 15;</code>
   */
  com.google.protobuf.ByteString
      getExtensionBytes();

  /**
   * <code>string HashMd5 = 17;</code>
   */
  java.lang.String getHashMd5();
  /**
   * <code>string HashMd5 = 17;</code>
   */
  com.google.protobuf.ByteString
      getHashMd5Bytes();

  /**
   * <code>int64 HashAccess = 19;</code>
   */
  long getHashAccess();

  /**
   * <code>int32 CreatedSe = 21;</code>
   */
  int getCreatedSe();

  /**
   * <code>string ServerSrc = 23;</code>
   */
  java.lang.String getServerSrc();
  /**
   * <code>string ServerSrc = 23;</code>
   */
  com.google.protobuf.ByteString
      getServerSrcBytes();

  /**
   * <pre>
   *del???
   * </pre>
   *
   * <code>string ServerPath = 25;</code>
   */
  java.lang.String getServerPath();
  /**
   * <pre>
   *del???
   * </pre>
   *
   * <code>string ServerPath = 25;</code>
   */
  com.google.protobuf.ByteString
      getServerPathBytes();

  /**
   * <code>string ServerThumbPath = 27;</code>
   */
  java.lang.String getServerThumbPath();
  /**
   * <code>string ServerThumbPath = 27;</code>
   */
  com.google.protobuf.ByteString
      getServerThumbPathBytes();

  /**
   * <code>string BucketId = 29;</code>
   */
  java.lang.String getBucketId();
  /**
   * <code>string BucketId = 29;</code>
   */
  com.google.protobuf.ByteString
      getBucketIdBytes();

  /**
   * <code>int32 ServerId = 31;</code>
   */
  int getServerId();

  /**
   * <code>int32 CanDel = 33;</code>
   */
  int getCanDel();

  /**
   * <pre>
   *just views
   * </pre>
   *
   * <code>string ServerThumbLocalSrc = 50;</code>
   */
  java.lang.String getServerThumbLocalSrc();
  /**
   * <pre>
   *just views
   * </pre>
   *
   * <code>string ServerThumbLocalSrc = 50;</code>
   */
  com.google.protobuf.ByteString
      getServerThumbLocalSrcBytes();

  /**
   * <pre>
   *local
   * </pre>
   *
   * <code>int64 RemoteMessageFileId = 100;</code>
   */
  long getRemoteMessageFileId();

  /**
   * <code>string LocalSrc = 101;</code>
   */
  java.lang.String getLocalSrc();
  /**
   * <code>string LocalSrc = 101;</code>
   */
  com.google.protobuf.ByteString
      getLocalSrcBytes();

  /**
   * <code>string ThumbLocalSrc = 104;</code>
   */
  java.lang.String getThumbLocalSrc();
  /**
   * <code>string ThumbLocalSrc = 104;</code>
   */
  com.google.protobuf.ByteString
      getThumbLocalSrcBytes();

  /**
   * <code>string MessageFileStatusId = 106;</code>
   */
  java.lang.String getMessageFileStatusId();
  /**
   * <code>string MessageFileStatusId = 106;</code>
   */
  com.google.protobuf.ByteString
      getMessageFileStatusIdBytes();
}
