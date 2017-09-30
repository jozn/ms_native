// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_sync.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_SyncResponse_GetGeneralUpdates}
 */
public  final class PB_SyncResponse_GetGeneralUpdates extends
    com.google.protobuf.GeneratedMessageLite<
        PB_SyncResponse_GetGeneralUpdates, PB_SyncResponse_GetGeneralUpdates.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_SyncResponse_GetGeneralUpdates)
    PB_SyncResponse_GetGeneralUpdatesOrBuilder {
  private PB_SyncResponse_GetGeneralUpdates() {
    userBlockedByMe_ = emptyProtobufList();
    userBlockedMe_ = emptyProtobufList();
  }
  private int bitField0_;
  public static final int USERBLOCKEDBYME_FIELD_NUMBER = 50;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.PB_UpdateUserBlocked> userBlockedByMe_;
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  public java.util.List<ir.ms.pb.PB_UpdateUserBlocked> getUserBlockedByMeList() {
    return userBlockedByMe_;
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  public java.util.List<? extends ir.ms.pb.PB_UpdateUserBlockedOrBuilder> 
      getUserBlockedByMeOrBuilderList() {
    return userBlockedByMe_;
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  public int getUserBlockedByMeCount() {
    return userBlockedByMe_.size();
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  public ir.ms.pb.PB_UpdateUserBlocked getUserBlockedByMe(int index) {
    return userBlockedByMe_.get(index);
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  public ir.ms.pb.PB_UpdateUserBlockedOrBuilder getUserBlockedByMeOrBuilder(
      int index) {
    return userBlockedByMe_.get(index);
  }
  private void ensureUserBlockedByMeIsMutable() {
    if (!userBlockedByMe_.isModifiable()) {
      userBlockedByMe_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(userBlockedByMe_);
     }
  }

  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void setUserBlockedByMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.set(index, value);
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void setUserBlockedByMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.set(index, builderForValue.build());
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void addUserBlockedByMe(ir.ms.pb.PB_UpdateUserBlocked value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.add(value);
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void addUserBlockedByMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.add(index, value);
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void addUserBlockedByMe(
      ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.add(builderForValue.build());
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void addUserBlockedByMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.add(index, builderForValue.build());
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void addAllUserBlockedByMe(
      java.lang.Iterable<? extends ir.ms.pb.PB_UpdateUserBlocked> values) {
    ensureUserBlockedByMeIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, userBlockedByMe_);
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void clearUserBlockedByMe() {
    userBlockedByMe_ = emptyProtobufList();
  }
  /**
   * <pre>
   *PB_GeneralUpdatesView Updates = 1;
   * </pre>
   *
   * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
   */
  private void removeUserBlockedByMe(int index) {
    ensureUserBlockedByMeIsMutable();
    userBlockedByMe_.remove(index);
  }

  public static final int USERBLOCKEDME_FIELD_NUMBER = 51;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.PB_UpdateUserBlocked> userBlockedMe_;
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  public java.util.List<ir.ms.pb.PB_UpdateUserBlocked> getUserBlockedMeList() {
    return userBlockedMe_;
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  public java.util.List<? extends ir.ms.pb.PB_UpdateUserBlockedOrBuilder> 
      getUserBlockedMeOrBuilderList() {
    return userBlockedMe_;
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  public int getUserBlockedMeCount() {
    return userBlockedMe_.size();
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  public ir.ms.pb.PB_UpdateUserBlocked getUserBlockedMe(int index) {
    return userBlockedMe_.get(index);
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  public ir.ms.pb.PB_UpdateUserBlockedOrBuilder getUserBlockedMeOrBuilder(
      int index) {
    return userBlockedMe_.get(index);
  }
  private void ensureUserBlockedMeIsMutable() {
    if (!userBlockedMe_.isModifiable()) {
      userBlockedMe_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(userBlockedMe_);
     }
  }

  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void setUserBlockedMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.set(index, value);
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void setUserBlockedMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.set(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void addUserBlockedMe(ir.ms.pb.PB_UpdateUserBlocked value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.add(value);
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void addUserBlockedMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.add(index, value);
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void addUserBlockedMe(
      ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.add(builderForValue.build());
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void addUserBlockedMe(
      int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.add(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void addAllUserBlockedMe(
      java.lang.Iterable<? extends ir.ms.pb.PB_UpdateUserBlocked> values) {
    ensureUserBlockedMeIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, userBlockedMe_);
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void clearUserBlockedMe() {
    userBlockedMe_ = emptyProtobufList();
  }
  /**
   * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
   */
  private void removeUserBlockedMe(int index) {
    ensureUserBlockedMeIsMutable();
    userBlockedMe_.remove(index);
  }

  public static final int LASTID_FIELD_NUMBER = 60;
  private long lastId_;
  /**
   * <code>int64 LastId = 60;</code>
   */
  public long getLastId() {
    return lastId_;
  }
  /**
   * <code>int64 LastId = 60;</code>
   */
  private void setLastId(long value) {
    
    lastId_ = value;
  }
  /**
   * <code>int64 LastId = 60;</code>
   */
  private void clearLastId() {
    
    lastId_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < userBlockedByMe_.size(); i++) {
      output.writeMessage(50, userBlockedByMe_.get(i));
    }
    for (int i = 0; i < userBlockedMe_.size(); i++) {
      output.writeMessage(51, userBlockedMe_.get(i));
    }
    if (lastId_ != 0L) {
      output.writeInt64(60, lastId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < userBlockedByMe_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(50, userBlockedByMe_.get(i));
    }
    for (int i = 0; i < userBlockedMe_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(51, userBlockedMe_.get(i));
    }
    if (lastId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(60, lastId_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_SyncResponse_GetGeneralUpdates prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_SyncResponse_GetGeneralUpdates}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_SyncResponse_GetGeneralUpdates, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_SyncResponse_GetGeneralUpdates)
      ir.ms.pb.PB_SyncResponse_GetGeneralUpdatesOrBuilder {
    // Construct using ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public java.util.List<ir.ms.pb.PB_UpdateUserBlocked> getUserBlockedByMeList() {
      return java.util.Collections.unmodifiableList(
          instance.getUserBlockedByMeList());
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public int getUserBlockedByMeCount() {
      return instance.getUserBlockedByMeCount();
    }/**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public ir.ms.pb.PB_UpdateUserBlocked getUserBlockedByMe(int index) {
      return instance.getUserBlockedByMe(index);
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder setUserBlockedByMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked value) {
      copyOnWrite();
      instance.setUserBlockedByMe(index, value);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder setUserBlockedByMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
      copyOnWrite();
      instance.setUserBlockedByMe(index, builderForValue);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder addUserBlockedByMe(ir.ms.pb.PB_UpdateUserBlocked value) {
      copyOnWrite();
      instance.addUserBlockedByMe(value);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder addUserBlockedByMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked value) {
      copyOnWrite();
      instance.addUserBlockedByMe(index, value);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder addUserBlockedByMe(
        ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
      copyOnWrite();
      instance.addUserBlockedByMe(builderForValue);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder addUserBlockedByMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
      copyOnWrite();
      instance.addUserBlockedByMe(index, builderForValue);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder addAllUserBlockedByMe(
        java.lang.Iterable<? extends ir.ms.pb.PB_UpdateUserBlocked> values) {
      copyOnWrite();
      instance.addAllUserBlockedByMe(values);
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder clearUserBlockedByMe() {
      copyOnWrite();
      instance.clearUserBlockedByMe();
      return this;
    }
    /**
     * <pre>
     *PB_GeneralUpdatesView Updates = 1;
     * </pre>
     *
     * <code>repeated .PB_UpdateUserBlocked UserBlockedByMe = 50;</code>
     */
    public Builder removeUserBlockedByMe(int index) {
      copyOnWrite();
      instance.removeUserBlockedByMe(index);
      return this;
    }

    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public java.util.List<ir.ms.pb.PB_UpdateUserBlocked> getUserBlockedMeList() {
      return java.util.Collections.unmodifiableList(
          instance.getUserBlockedMeList());
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public int getUserBlockedMeCount() {
      return instance.getUserBlockedMeCount();
    }/**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public ir.ms.pb.PB_UpdateUserBlocked getUserBlockedMe(int index) {
      return instance.getUserBlockedMe(index);
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder setUserBlockedMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked value) {
      copyOnWrite();
      instance.setUserBlockedMe(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder setUserBlockedMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
      copyOnWrite();
      instance.setUserBlockedMe(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder addUserBlockedMe(ir.ms.pb.PB_UpdateUserBlocked value) {
      copyOnWrite();
      instance.addUserBlockedMe(value);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder addUserBlockedMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked value) {
      copyOnWrite();
      instance.addUserBlockedMe(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder addUserBlockedMe(
        ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
      copyOnWrite();
      instance.addUserBlockedMe(builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder addUserBlockedMe(
        int index, ir.ms.pb.PB_UpdateUserBlocked.Builder builderForValue) {
      copyOnWrite();
      instance.addUserBlockedMe(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder addAllUserBlockedMe(
        java.lang.Iterable<? extends ir.ms.pb.PB_UpdateUserBlocked> values) {
      copyOnWrite();
      instance.addAllUserBlockedMe(values);
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder clearUserBlockedMe() {
      copyOnWrite();
      instance.clearUserBlockedMe();
      return this;
    }
    /**
     * <code>repeated .PB_UpdateUserBlocked UserBlockedMe = 51;</code>
     */
    public Builder removeUserBlockedMe(int index) {
      copyOnWrite();
      instance.removeUserBlockedMe(index);
      return this;
    }

    /**
     * <code>int64 LastId = 60;</code>
     */
    public long getLastId() {
      return instance.getLastId();
    }
    /**
     * <code>int64 LastId = 60;</code>
     */
    public Builder setLastId(long value) {
      copyOnWrite();
      instance.setLastId(value);
      return this;
    }
    /**
     * <code>int64 LastId = 60;</code>
     */
    public Builder clearLastId() {
      copyOnWrite();
      instance.clearLastId();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_SyncResponse_GetGeneralUpdates)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_SyncResponse_GetGeneralUpdates();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        userBlockedByMe_.makeImmutable();
        userBlockedMe_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_SyncResponse_GetGeneralUpdates other = (ir.ms.pb.PB_SyncResponse_GetGeneralUpdates) arg1;
        userBlockedByMe_= visitor.visitList(userBlockedByMe_, other.userBlockedByMe_);
        userBlockedMe_= visitor.visitList(userBlockedMe_, other.userBlockedMe_);
        lastId_ = visitor.visitLong(lastId_ != 0L, lastId_,
            other.lastId_ != 0L, other.lastId_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
          bitField0_ |= other.bitField0_;
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
              case 402: {
                if (!userBlockedByMe_.isModifiable()) {
                  userBlockedByMe_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(userBlockedByMe_);
                }
                userBlockedByMe_.add(
                    input.readMessage(ir.ms.pb.PB_UpdateUserBlocked.parser(), extensionRegistry));
                break;
              }
              case 410: {
                if (!userBlockedMe_.isModifiable()) {
                  userBlockedMe_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(userBlockedMe_);
                }
                userBlockedMe_.add(
                    input.readMessage(ir.ms.pb.PB_UpdateUserBlocked.parser(), extensionRegistry));
                break;
              }
              case 480: {

                lastId_ = input.readInt64();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.class) {
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


  // @@protoc_insertion_point(class_scope:PB_SyncResponse_GetGeneralUpdates)
  private static final ir.ms.pb.PB_SyncResponse_GetGeneralUpdates DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_SyncResponse_GetGeneralUpdates();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_SyncResponse_GetGeneralUpdates getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_SyncResponse_GetGeneralUpdates> PARSER;

  public static com.google.protobuf.Parser<PB_SyncResponse_GetGeneralUpdates> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

