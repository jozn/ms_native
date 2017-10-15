// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Bucket}
 */
public  final class PB_Bucket extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Bucket, PB_Bucket.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Bucket)
    PB_BucketOrBuilder {
  private PB_Bucket() {
    bucketName_ = "";
  }
  public static final int BUCKETID_FIELD_NUMBER = 1;
  private int bucketId_;
  /**
   * <code>int32 BucketId = 1;</code>
   */
  public int getBucketId() {
    return bucketId_;
  }
  /**
   * <code>int32 BucketId = 1;</code>
   */
  private void setBucketId(int value) {
    
    bucketId_ = value;
  }
  /**
   * <code>int32 BucketId = 1;</code>
   */
  private void clearBucketId() {
    
    bucketId_ = 0;
  }

  public static final int BUCKETNAME_FIELD_NUMBER = 3;
  private java.lang.String bucketName_;
  /**
   * <code>string BucketName = 3;</code>
   */
  public java.lang.String getBucketName() {
    return bucketName_;
  }
  /**
   * <code>string BucketName = 3;</code>
   */
  public com.google.protobuf.ByteString
      getBucketNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(bucketName_);
  }
  /**
   * <code>string BucketName = 3;</code>
   */
  private void setBucketName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    bucketName_ = value;
  }
  /**
   * <code>string BucketName = 3;</code>
   */
  private void clearBucketName() {
    
    bucketName_ = getDefaultInstance().getBucketName();
  }
  /**
   * <code>string BucketName = 3;</code>
   */
  private void setBucketNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    bucketName_ = value.toStringUtf8();
  }

  public static final int SERVER1ID_FIELD_NUMBER = 5;
  private int server1Id_;
  /**
   * <code>int32 Server1Id = 5;</code>
   */
  public int getServer1Id() {
    return server1Id_;
  }
  /**
   * <code>int32 Server1Id = 5;</code>
   */
  private void setServer1Id(int value) {
    
    server1Id_ = value;
  }
  /**
   * <code>int32 Server1Id = 5;</code>
   */
  private void clearServer1Id() {
    
    server1Id_ = 0;
  }

  public static final int SERVER2ID_FIELD_NUMBER = 7;
  private int server2Id_;
  /**
   * <code>int32 Server2Id = 7;</code>
   */
  public int getServer2Id() {
    return server2Id_;
  }
  /**
   * <code>int32 Server2Id = 7;</code>
   */
  private void setServer2Id(int value) {
    
    server2Id_ = value;
  }
  /**
   * <code>int32 Server2Id = 7;</code>
   */
  private void clearServer2Id() {
    
    server2Id_ = 0;
  }

  public static final int BACKUPSERVERID_FIELD_NUMBER = 9;
  private int backupServerId_;
  /**
   * <code>int32 BackupServerId = 9;</code>
   */
  public int getBackupServerId() {
    return backupServerId_;
  }
  /**
   * <code>int32 BackupServerId = 9;</code>
   */
  private void setBackupServerId(int value) {
    
    backupServerId_ = value;
  }
  /**
   * <code>int32 BackupServerId = 9;</code>
   */
  private void clearBackupServerId() {
    
    backupServerId_ = 0;
  }

  public static final int CONTENTOBJECTTYPEID_FIELD_NUMBER = 11;
  private int contentObjectTypeId_;
  /**
   * <code>int32 ContentObjectTypeId = 11;</code>
   */
  public int getContentObjectTypeId() {
    return contentObjectTypeId_;
  }
  /**
   * <code>int32 ContentObjectTypeId = 11;</code>
   */
  private void setContentObjectTypeId(int value) {
    
    contentObjectTypeId_ = value;
  }
  /**
   * <code>int32 ContentObjectTypeId = 11;</code>
   */
  private void clearContentObjectTypeId() {
    
    contentObjectTypeId_ = 0;
  }

  public static final int CONTENTOBJECTCOUNT_FIELD_NUMBER = 13;
  private int contentObjectCount_;
  /**
   * <code>int32 ContentObjectCount = 13;</code>
   */
  public int getContentObjectCount() {
    return contentObjectCount_;
  }
  /**
   * <code>int32 ContentObjectCount = 13;</code>
   */
  private void setContentObjectCount(int value) {
    
    contentObjectCount_ = value;
  }
  /**
   * <code>int32 ContentObjectCount = 13;</code>
   */
  private void clearContentObjectCount() {
    
    contentObjectCount_ = 0;
  }

  public static final int CREATEDTIME_FIELD_NUMBER = 15;
  private int createdTime_;
  /**
   * <code>int32 CreatedTime = 15;</code>
   */
  public int getCreatedTime() {
    return createdTime_;
  }
  /**
   * <code>int32 CreatedTime = 15;</code>
   */
  private void setCreatedTime(int value) {
    
    createdTime_ = value;
  }
  /**
   * <code>int32 CreatedTime = 15;</code>
   */
  private void clearCreatedTime() {
    
    createdTime_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (bucketId_ != 0) {
      output.writeInt32(1, bucketId_);
    }
    if (!bucketName_.isEmpty()) {
      output.writeString(3, getBucketName());
    }
    if (server1Id_ != 0) {
      output.writeInt32(5, server1Id_);
    }
    if (server2Id_ != 0) {
      output.writeInt32(7, server2Id_);
    }
    if (backupServerId_ != 0) {
      output.writeInt32(9, backupServerId_);
    }
    if (contentObjectTypeId_ != 0) {
      output.writeInt32(11, contentObjectTypeId_);
    }
    if (contentObjectCount_ != 0) {
      output.writeInt32(13, contentObjectCount_);
    }
    if (createdTime_ != 0) {
      output.writeInt32(15, createdTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (bucketId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, bucketId_);
    }
    if (!bucketName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getBucketName());
    }
    if (server1Id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, server1Id_);
    }
    if (server2Id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, server2Id_);
    }
    if (backupServerId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, backupServerId_);
    }
    if (contentObjectTypeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(11, contentObjectTypeId_);
    }
    if (contentObjectCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, contentObjectCount_);
    }
    if (createdTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(15, createdTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Bucket parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Bucket parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Bucket parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Bucket parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Bucket prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Bucket}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Bucket, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Bucket)
      ir.ms.pb.PB_BucketOrBuilder {
    // Construct using ir.ms.pb.PB_Bucket.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 BucketId = 1;</code>
     */
    public int getBucketId() {
      return instance.getBucketId();
    }
    /**
     * <code>int32 BucketId = 1;</code>
     */
    public Builder setBucketId(int value) {
      copyOnWrite();
      instance.setBucketId(value);
      return this;
    }
    /**
     * <code>int32 BucketId = 1;</code>
     */
    public Builder clearBucketId() {
      copyOnWrite();
      instance.clearBucketId();
      return this;
    }

    /**
     * <code>string BucketName = 3;</code>
     */
    public java.lang.String getBucketName() {
      return instance.getBucketName();
    }
    /**
     * <code>string BucketName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getBucketNameBytes() {
      return instance.getBucketNameBytes();
    }
    /**
     * <code>string BucketName = 3;</code>
     */
    public Builder setBucketName(
        java.lang.String value) {
      copyOnWrite();
      instance.setBucketName(value);
      return this;
    }
    /**
     * <code>string BucketName = 3;</code>
     */
    public Builder clearBucketName() {
      copyOnWrite();
      instance.clearBucketName();
      return this;
    }
    /**
     * <code>string BucketName = 3;</code>
     */
    public Builder setBucketNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setBucketNameBytes(value);
      return this;
    }

    /**
     * <code>int32 Server1Id = 5;</code>
     */
    public int getServer1Id() {
      return instance.getServer1Id();
    }
    /**
     * <code>int32 Server1Id = 5;</code>
     */
    public Builder setServer1Id(int value) {
      copyOnWrite();
      instance.setServer1Id(value);
      return this;
    }
    /**
     * <code>int32 Server1Id = 5;</code>
     */
    public Builder clearServer1Id() {
      copyOnWrite();
      instance.clearServer1Id();
      return this;
    }

    /**
     * <code>int32 Server2Id = 7;</code>
     */
    public int getServer2Id() {
      return instance.getServer2Id();
    }
    /**
     * <code>int32 Server2Id = 7;</code>
     */
    public Builder setServer2Id(int value) {
      copyOnWrite();
      instance.setServer2Id(value);
      return this;
    }
    /**
     * <code>int32 Server2Id = 7;</code>
     */
    public Builder clearServer2Id() {
      copyOnWrite();
      instance.clearServer2Id();
      return this;
    }

    /**
     * <code>int32 BackupServerId = 9;</code>
     */
    public int getBackupServerId() {
      return instance.getBackupServerId();
    }
    /**
     * <code>int32 BackupServerId = 9;</code>
     */
    public Builder setBackupServerId(int value) {
      copyOnWrite();
      instance.setBackupServerId(value);
      return this;
    }
    /**
     * <code>int32 BackupServerId = 9;</code>
     */
    public Builder clearBackupServerId() {
      copyOnWrite();
      instance.clearBackupServerId();
      return this;
    }

    /**
     * <code>int32 ContentObjectTypeId = 11;</code>
     */
    public int getContentObjectTypeId() {
      return instance.getContentObjectTypeId();
    }
    /**
     * <code>int32 ContentObjectTypeId = 11;</code>
     */
    public Builder setContentObjectTypeId(int value) {
      copyOnWrite();
      instance.setContentObjectTypeId(value);
      return this;
    }
    /**
     * <code>int32 ContentObjectTypeId = 11;</code>
     */
    public Builder clearContentObjectTypeId() {
      copyOnWrite();
      instance.clearContentObjectTypeId();
      return this;
    }

    /**
     * <code>int32 ContentObjectCount = 13;</code>
     */
    public int getContentObjectCount() {
      return instance.getContentObjectCount();
    }
    /**
     * <code>int32 ContentObjectCount = 13;</code>
     */
    public Builder setContentObjectCount(int value) {
      copyOnWrite();
      instance.setContentObjectCount(value);
      return this;
    }
    /**
     * <code>int32 ContentObjectCount = 13;</code>
     */
    public Builder clearContentObjectCount() {
      copyOnWrite();
      instance.clearContentObjectCount();
      return this;
    }

    /**
     * <code>int32 CreatedTime = 15;</code>
     */
    public int getCreatedTime() {
      return instance.getCreatedTime();
    }
    /**
     * <code>int32 CreatedTime = 15;</code>
     */
    public Builder setCreatedTime(int value) {
      copyOnWrite();
      instance.setCreatedTime(value);
      return this;
    }
    /**
     * <code>int32 CreatedTime = 15;</code>
     */
    public Builder clearCreatedTime() {
      copyOnWrite();
      instance.clearCreatedTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_Bucket)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Bucket();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_Bucket other = (ir.ms.pb.PB_Bucket) arg1;
        bucketId_ = visitor.visitInt(bucketId_ != 0, bucketId_,
            other.bucketId_ != 0, other.bucketId_);
        bucketName_ = visitor.visitString(!bucketName_.isEmpty(), bucketName_,
            !other.bucketName_.isEmpty(), other.bucketName_);
        server1Id_ = visitor.visitInt(server1Id_ != 0, server1Id_,
            other.server1Id_ != 0, other.server1Id_);
        server2Id_ = visitor.visitInt(server2Id_ != 0, server2Id_,
            other.server2Id_ != 0, other.server2Id_);
        backupServerId_ = visitor.visitInt(backupServerId_ != 0, backupServerId_,
            other.backupServerId_ != 0, other.backupServerId_);
        contentObjectTypeId_ = visitor.visitInt(contentObjectTypeId_ != 0, contentObjectTypeId_,
            other.contentObjectTypeId_ != 0, other.contentObjectTypeId_);
        contentObjectCount_ = visitor.visitInt(contentObjectCount_ != 0, contentObjectCount_,
            other.contentObjectCount_ != 0, other.contentObjectCount_);
        createdTime_ = visitor.visitInt(createdTime_ != 0, createdTime_,
            other.createdTime_ != 0, other.createdTime_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
              case 8: {

                bucketId_ = input.readInt32();
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                bucketName_ = s;
                break;
              }
              case 40: {

                server1Id_ = input.readInt32();
                break;
              }
              case 56: {

                server2Id_ = input.readInt32();
                break;
              }
              case 72: {

                backupServerId_ = input.readInt32();
                break;
              }
              case 88: {

                contentObjectTypeId_ = input.readInt32();
                break;
              }
              case 104: {

                contentObjectCount_ = input.readInt32();
                break;
              }
              case 120: {

                createdTime_ = input.readInt32();
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Bucket.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:PB_Bucket)
  private static final ir.ms.pb.PB_Bucket DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Bucket();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Bucket getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Bucket> PARSER;

  public static com.google.protobuf.Parser<PB_Bucket> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

