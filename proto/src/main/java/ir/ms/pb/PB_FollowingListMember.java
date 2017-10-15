// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_FollowingListMember}
 */
public  final class PB_FollowingListMember extends
    com.google.protobuf.GeneratedMessageLite<
        PB_FollowingListMember, PB_FollowingListMember.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_FollowingListMember)
    PB_FollowingListMemberOrBuilder {
  private PB_FollowingListMember() {
  }
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 Id = 1;</code>
   */
  public long getId() {
    return id_;
  }
  /**
   * <code>int64 Id = 1;</code>
   */
  private void setId(long value) {
    
    id_ = value;
  }
  /**
   * <code>int64 Id = 1;</code>
   */
  private void clearId() {
    
    id_ = 0L;
  }

  public static final int LISTID_FIELD_NUMBER = 3;
  private int listId_;
  /**
   * <code>int32 ListId = 3;</code>
   */
  public int getListId() {
    return listId_;
  }
  /**
   * <code>int32 ListId = 3;</code>
   */
  private void setListId(int value) {
    
    listId_ = value;
  }
  /**
   * <code>int32 ListId = 3;</code>
   */
  private void clearListId() {
    
    listId_ = 0;
  }

  public static final int USERID_FIELD_NUMBER = 5;
  private int userId_;
  /**
   * <code>int32 UserId = 5;</code>
   */
  public int getUserId() {
    return userId_;
  }
  /**
   * <code>int32 UserId = 5;</code>
   */
  private void setUserId(int value) {
    
    userId_ = value;
  }
  /**
   * <code>int32 UserId = 5;</code>
   */
  private void clearUserId() {
    
    userId_ = 0;
  }

  public static final int FOLLOWEDUSERID_FIELD_NUMBER = 7;
  private int followedUserId_;
  /**
   * <code>int32 FollowedUserId = 7;</code>
   */
  public int getFollowedUserId() {
    return followedUserId_;
  }
  /**
   * <code>int32 FollowedUserId = 7;</code>
   */
  private void setFollowedUserId(int value) {
    
    followedUserId_ = value;
  }
  /**
   * <code>int32 FollowedUserId = 7;</code>
   */
  private void clearFollowedUserId() {
    
    followedUserId_ = 0;
  }

  public static final int FOLLOWTYPE_FIELD_NUMBER = 9;
  private int followType_;
  /**
   * <code>int32 FollowType = 9;</code>
   */
  public int getFollowType() {
    return followType_;
  }
  /**
   * <code>int32 FollowType = 9;</code>
   */
  private void setFollowType(int value) {
    
    followType_ = value;
  }
  /**
   * <code>int32 FollowType = 9;</code>
   */
  private void clearFollowType() {
    
    followType_ = 0;
  }

  public static final int UPDATEDTIMEMS_FIELD_NUMBER = 11;
  private long updatedTimeMs_;
  /**
   * <code>int64 UpdatedTimeMs = 11;</code>
   */
  public long getUpdatedTimeMs() {
    return updatedTimeMs_;
  }
  /**
   * <code>int64 UpdatedTimeMs = 11;</code>
   */
  private void setUpdatedTimeMs(long value) {
    
    updatedTimeMs_ = value;
  }
  /**
   * <code>int64 UpdatedTimeMs = 11;</code>
   */
  private void clearUpdatedTimeMs() {
    
    updatedTimeMs_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (listId_ != 0) {
      output.writeInt32(3, listId_);
    }
    if (userId_ != 0) {
      output.writeInt32(5, userId_);
    }
    if (followedUserId_ != 0) {
      output.writeInt32(7, followedUserId_);
    }
    if (followType_ != 0) {
      output.writeInt32(9, followType_);
    }
    if (updatedTimeMs_ != 0L) {
      output.writeInt64(11, updatedTimeMs_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (listId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, listId_);
    }
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, userId_);
    }
    if (followedUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, followedUserId_);
    }
    if (followType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, followType_);
    }
    if (updatedTimeMs_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(11, updatedTimeMs_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_FollowingListMember parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingListMember parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_FollowingListMember parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_FollowingListMember parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_FollowingListMember prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_FollowingListMember}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_FollowingListMember, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_FollowingListMember)
      ir.ms.pb.PB_FollowingListMemberOrBuilder {
    // Construct using ir.ms.pb.PB_FollowingListMember.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 Id = 1;</code>
     */
    public long getId() {
      return instance.getId();
    }
    /**
     * <code>int64 Id = 1;</code>
     */
    public Builder setId(long value) {
      copyOnWrite();
      instance.setId(value);
      return this;
    }
    /**
     * <code>int64 Id = 1;</code>
     */
    public Builder clearId() {
      copyOnWrite();
      instance.clearId();
      return this;
    }

    /**
     * <code>int32 ListId = 3;</code>
     */
    public int getListId() {
      return instance.getListId();
    }
    /**
     * <code>int32 ListId = 3;</code>
     */
    public Builder setListId(int value) {
      copyOnWrite();
      instance.setListId(value);
      return this;
    }
    /**
     * <code>int32 ListId = 3;</code>
     */
    public Builder clearListId() {
      copyOnWrite();
      instance.clearListId();
      return this;
    }

    /**
     * <code>int32 UserId = 5;</code>
     */
    public int getUserId() {
      return instance.getUserId();
    }
    /**
     * <code>int32 UserId = 5;</code>
     */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /**
     * <code>int32 UserId = 5;</code>
     */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /**
     * <code>int32 FollowedUserId = 7;</code>
     */
    public int getFollowedUserId() {
      return instance.getFollowedUserId();
    }
    /**
     * <code>int32 FollowedUserId = 7;</code>
     */
    public Builder setFollowedUserId(int value) {
      copyOnWrite();
      instance.setFollowedUserId(value);
      return this;
    }
    /**
     * <code>int32 FollowedUserId = 7;</code>
     */
    public Builder clearFollowedUserId() {
      copyOnWrite();
      instance.clearFollowedUserId();
      return this;
    }

    /**
     * <code>int32 FollowType = 9;</code>
     */
    public int getFollowType() {
      return instance.getFollowType();
    }
    /**
     * <code>int32 FollowType = 9;</code>
     */
    public Builder setFollowType(int value) {
      copyOnWrite();
      instance.setFollowType(value);
      return this;
    }
    /**
     * <code>int32 FollowType = 9;</code>
     */
    public Builder clearFollowType() {
      copyOnWrite();
      instance.clearFollowType();
      return this;
    }

    /**
     * <code>int64 UpdatedTimeMs = 11;</code>
     */
    public long getUpdatedTimeMs() {
      return instance.getUpdatedTimeMs();
    }
    /**
     * <code>int64 UpdatedTimeMs = 11;</code>
     */
    public Builder setUpdatedTimeMs(long value) {
      copyOnWrite();
      instance.setUpdatedTimeMs(value);
      return this;
    }
    /**
     * <code>int64 UpdatedTimeMs = 11;</code>
     */
    public Builder clearUpdatedTimeMs() {
      copyOnWrite();
      instance.clearUpdatedTimeMs();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_FollowingListMember)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_FollowingListMember();
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
        ir.ms.pb.PB_FollowingListMember other = (ir.ms.pb.PB_FollowingListMember) arg1;
        id_ = visitor.visitLong(id_ != 0L, id_,
            other.id_ != 0L, other.id_);
        listId_ = visitor.visitInt(listId_ != 0, listId_,
            other.listId_ != 0, other.listId_);
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        followedUserId_ = visitor.visitInt(followedUserId_ != 0, followedUserId_,
            other.followedUserId_ != 0, other.followedUserId_);
        followType_ = visitor.visitInt(followType_ != 0, followType_,
            other.followType_ != 0, other.followType_);
        updatedTimeMs_ = visitor.visitLong(updatedTimeMs_ != 0L, updatedTimeMs_,
            other.updatedTimeMs_ != 0L, other.updatedTimeMs_);
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

                id_ = input.readInt64();
                break;
              }
              case 24: {

                listId_ = input.readInt32();
                break;
              }
              case 40: {

                userId_ = input.readInt32();
                break;
              }
              case 56: {

                followedUserId_ = input.readInt32();
                break;
              }
              case 72: {

                followType_ = input.readInt32();
                break;
              }
              case 88: {

                updatedTimeMs_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_FollowingListMember.class) {
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


  // @@protoc_insertion_point(class_scope:PB_FollowingListMember)
  private static final ir.ms.pb.PB_FollowingListMember DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_FollowingListMember();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_FollowingListMember getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_FollowingListMember> PARSER;

  public static com.google.protobuf.Parser<PB_FollowingListMember> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

