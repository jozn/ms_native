// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_FollowingList}
 */
public  final class PB_FollowingList extends
    com.google.protobuf.GeneratedMessageLite<
        PB_FollowingList, PB_FollowingList.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_FollowingList)
    PB_FollowingListOrBuilder {
  private PB_FollowingList() {
    name_ = "";
  }
  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 Id = 1;</code>
   */
  public int getId() {
    return id_;
  }
  /**
   * <code>int32 Id = 1;</code>
   */
  private void setId(int value) {
    
    id_ = value;
  }
  /**
   * <code>int32 Id = 1;</code>
   */
  private void clearId() {
    
    id_ = 0;
  }

  public static final int USERID_FIELD_NUMBER = 3;
  private int userId_;
  /**
   * <code>int32 UserId = 3;</code>
   */
  public int getUserId() {
    return userId_;
  }
  /**
   * <code>int32 UserId = 3;</code>
   */
  private void setUserId(int value) {
    
    userId_ = value;
  }
  /**
   * <code>int32 UserId = 3;</code>
   */
  private void clearUserId() {
    
    userId_ = 0;
  }

  public static final int LISTTYPE_FIELD_NUMBER = 5;
  private int listType_;
  /**
   * <code>int32 ListType = 5;</code>
   */
  public int getListType() {
    return listType_;
  }
  /**
   * <code>int32 ListType = 5;</code>
   */
  private void setListType(int value) {
    
    listType_ = value;
  }
  /**
   * <code>int32 ListType = 5;</code>
   */
  private void clearListType() {
    
    listType_ = 0;
  }

  public static final int NAME_FIELD_NUMBER = 7;
  private java.lang.String name_;
  /**
   * <code>string Name = 7;</code>
   */
  public java.lang.String getName() {
    return name_;
  }
  /**
   * <code>string Name = 7;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(name_);
  }
  /**
   * <code>string Name = 7;</code>
   */
  private void setName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    name_ = value;
  }
  /**
   * <code>string Name = 7;</code>
   */
  private void clearName() {
    
    name_ = getDefaultInstance().getName();
  }
  /**
   * <code>string Name = 7;</code>
   */
  private void setNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    name_ = value.toStringUtf8();
  }

  public static final int COUNT_FIELD_NUMBER = 9;
  private int count_;
  /**
   * <code>int32 Count = 9;</code>
   */
  public int getCount() {
    return count_;
  }
  /**
   * <code>int32 Count = 9;</code>
   */
  private void setCount(int value) {
    
    count_ = value;
  }
  /**
   * <code>int32 Count = 9;</code>
   */
  private void clearCount() {
    
    count_ = 0;
  }

  public static final int ISAUTO_FIELD_NUMBER = 11;
  private int isAuto_;
  /**
   * <code>int32 IsAuto = 11;</code>
   */
  public int getIsAuto() {
    return isAuto_;
  }
  /**
   * <code>int32 IsAuto = 11;</code>
   */
  private void setIsAuto(int value) {
    
    isAuto_ = value;
  }
  /**
   * <code>int32 IsAuto = 11;</code>
   */
  private void clearIsAuto() {
    
    isAuto_ = 0;
  }

  public static final int ISPIMIRY_FIELD_NUMBER = 13;
  private int isPimiry_;
  /**
   * <code>int32 IsPimiry = 13;</code>
   */
  public int getIsPimiry() {
    return isPimiry_;
  }
  /**
   * <code>int32 IsPimiry = 13;</code>
   */
  private void setIsPimiry(int value) {
    
    isPimiry_ = value;
  }
  /**
   * <code>int32 IsPimiry = 13;</code>
   */
  private void clearIsPimiry() {
    
    isPimiry_ = 0;
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
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (userId_ != 0) {
      output.writeInt32(3, userId_);
    }
    if (listType_ != 0) {
      output.writeInt32(5, listType_);
    }
    if (!name_.isEmpty()) {
      output.writeString(7, getName());
    }
    if (count_ != 0) {
      output.writeInt32(9, count_);
    }
    if (isAuto_ != 0) {
      output.writeInt32(11, isAuto_);
    }
    if (isPimiry_ != 0) {
      output.writeInt32(13, isPimiry_);
    }
    if (createdTime_ != 0) {
      output.writeInt32(15, createdTime_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, userId_);
    }
    if (listType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, listType_);
    }
    if (!name_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(7, getName());
    }
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, count_);
    }
    if (isAuto_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(11, isAuto_);
    }
    if (isPimiry_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, isPimiry_);
    }
    if (createdTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(15, createdTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_FollowingList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_FollowingList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_FollowingList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_FollowingList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_FollowingList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_FollowingList, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_FollowingList)
      ir.ms.pb.PB_FollowingListOrBuilder {
    // Construct using ir.ms.pb.PB_FollowingList.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 Id = 1;</code>
     */
    public int getId() {
      return instance.getId();
    }
    /**
     * <code>int32 Id = 1;</code>
     */
    public Builder setId(int value) {
      copyOnWrite();
      instance.setId(value);
      return this;
    }
    /**
     * <code>int32 Id = 1;</code>
     */
    public Builder clearId() {
      copyOnWrite();
      instance.clearId();
      return this;
    }

    /**
     * <code>int32 UserId = 3;</code>
     */
    public int getUserId() {
      return instance.getUserId();
    }
    /**
     * <code>int32 UserId = 3;</code>
     */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /**
     * <code>int32 UserId = 3;</code>
     */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /**
     * <code>int32 ListType = 5;</code>
     */
    public int getListType() {
      return instance.getListType();
    }
    /**
     * <code>int32 ListType = 5;</code>
     */
    public Builder setListType(int value) {
      copyOnWrite();
      instance.setListType(value);
      return this;
    }
    /**
     * <code>int32 ListType = 5;</code>
     */
    public Builder clearListType() {
      copyOnWrite();
      instance.clearListType();
      return this;
    }

    /**
     * <code>string Name = 7;</code>
     */
    public java.lang.String getName() {
      return instance.getName();
    }
    /**
     * <code>string Name = 7;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      return instance.getNameBytes();
    }
    /**
     * <code>string Name = 7;</code>
     */
    public Builder setName(
        java.lang.String value) {
      copyOnWrite();
      instance.setName(value);
      return this;
    }
    /**
     * <code>string Name = 7;</code>
     */
    public Builder clearName() {
      copyOnWrite();
      instance.clearName();
      return this;
    }
    /**
     * <code>string Name = 7;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setNameBytes(value);
      return this;
    }

    /**
     * <code>int32 Count = 9;</code>
     */
    public int getCount() {
      return instance.getCount();
    }
    /**
     * <code>int32 Count = 9;</code>
     */
    public Builder setCount(int value) {
      copyOnWrite();
      instance.setCount(value);
      return this;
    }
    /**
     * <code>int32 Count = 9;</code>
     */
    public Builder clearCount() {
      copyOnWrite();
      instance.clearCount();
      return this;
    }

    /**
     * <code>int32 IsAuto = 11;</code>
     */
    public int getIsAuto() {
      return instance.getIsAuto();
    }
    /**
     * <code>int32 IsAuto = 11;</code>
     */
    public Builder setIsAuto(int value) {
      copyOnWrite();
      instance.setIsAuto(value);
      return this;
    }
    /**
     * <code>int32 IsAuto = 11;</code>
     */
    public Builder clearIsAuto() {
      copyOnWrite();
      instance.clearIsAuto();
      return this;
    }

    /**
     * <code>int32 IsPimiry = 13;</code>
     */
    public int getIsPimiry() {
      return instance.getIsPimiry();
    }
    /**
     * <code>int32 IsPimiry = 13;</code>
     */
    public Builder setIsPimiry(int value) {
      copyOnWrite();
      instance.setIsPimiry(value);
      return this;
    }
    /**
     * <code>int32 IsPimiry = 13;</code>
     */
    public Builder clearIsPimiry() {
      copyOnWrite();
      instance.clearIsPimiry();
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

    // @@protoc_insertion_point(builder_scope:PB_FollowingList)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_FollowingList();
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
        ir.ms.pb.PB_FollowingList other = (ir.ms.pb.PB_FollowingList) arg1;
        id_ = visitor.visitInt(id_ != 0, id_,
            other.id_ != 0, other.id_);
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        listType_ = visitor.visitInt(listType_ != 0, listType_,
            other.listType_ != 0, other.listType_);
        name_ = visitor.visitString(!name_.isEmpty(), name_,
            !other.name_.isEmpty(), other.name_);
        count_ = visitor.visitInt(count_ != 0, count_,
            other.count_ != 0, other.count_);
        isAuto_ = visitor.visitInt(isAuto_ != 0, isAuto_,
            other.isAuto_ != 0, other.isAuto_);
        isPimiry_ = visitor.visitInt(isPimiry_ != 0, isPimiry_,
            other.isPimiry_ != 0, other.isPimiry_);
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

                id_ = input.readInt32();
                break;
              }
              case 24: {

                userId_ = input.readInt32();
                break;
              }
              case 40: {

                listType_ = input.readInt32();
                break;
              }
              case 58: {
                String s = input.readStringRequireUtf8();

                name_ = s;
                break;
              }
              case 72: {

                count_ = input.readInt32();
                break;
              }
              case 88: {

                isAuto_ = input.readInt32();
                break;
              }
              case 104: {

                isPimiry_ = input.readInt32();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_FollowingList.class) {
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


  // @@protoc_insertion_point(class_scope:PB_FollowingList)
  private static final ir.ms.pb.PB_FollowingList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_FollowingList();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_FollowingList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_FollowingList> PARSER;

  public static com.google.protobuf.Parser<PB_FollowingList> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

