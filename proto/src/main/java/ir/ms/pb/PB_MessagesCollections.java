// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_MessagesCollections}
 */
public  final class PB_MessagesCollections extends
    com.google.protobuf.GeneratedMessageLite<
        PB_MessagesCollections, PB_MessagesCollections.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_MessagesCollections)
    PB_MessagesCollectionsOrBuilder {
  private PB_MessagesCollections() {
    directMessagesIds_ = emptyLongList();
    groupMessagesIds_ = emptyLongList();
    broadCatMessagesIds_ = emptyLongList();
  }
  public static final int DIRECTMESSAGESIDS_FIELD_NUMBER = 10;
  private com.google.protobuf.Internal.LongList directMessagesIds_;
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  public java.util.List<java.lang.Long>
      getDirectMessagesIdsList() {
    return directMessagesIds_;
  }
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  public int getDirectMessagesIdsCount() {
    return directMessagesIds_.size();
  }
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  public long getDirectMessagesIds(int index) {
    return directMessagesIds_.getLong(index);
  }
  private void ensureDirectMessagesIdsIsMutable() {
    if (!directMessagesIds_.isModifiable()) {
      directMessagesIds_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(directMessagesIds_);
     }
  }
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  private void setDirectMessagesIds(
      int index, long value) {
    ensureDirectMessagesIdsIsMutable();
    directMessagesIds_.setLong(index, value);
  }
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  private void addDirectMessagesIds(long value) {
    ensureDirectMessagesIdsIsMutable();
    directMessagesIds_.addLong(value);
  }
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  private void addAllDirectMessagesIds(
      java.lang.Iterable<? extends java.lang.Long> values) {
    ensureDirectMessagesIdsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, directMessagesIds_);
  }
  /**
   * <code>repeated int64 DirectMessagesIds = 10;</code>
   */
  private void clearDirectMessagesIds() {
    directMessagesIds_ = emptyLongList();
  }

  public static final int GROUPMESSAGESIDS_FIELD_NUMBER = 20;
  private com.google.protobuf.Internal.LongList groupMessagesIds_;
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  public java.util.List<java.lang.Long>
      getGroupMessagesIdsList() {
    return groupMessagesIds_;
  }
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  public int getGroupMessagesIdsCount() {
    return groupMessagesIds_.size();
  }
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  public long getGroupMessagesIds(int index) {
    return groupMessagesIds_.getLong(index);
  }
  private void ensureGroupMessagesIdsIsMutable() {
    if (!groupMessagesIds_.isModifiable()) {
      groupMessagesIds_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(groupMessagesIds_);
     }
  }
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  private void setGroupMessagesIds(
      int index, long value) {
    ensureGroupMessagesIdsIsMutable();
    groupMessagesIds_.setLong(index, value);
  }
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  private void addGroupMessagesIds(long value) {
    ensureGroupMessagesIdsIsMutable();
    groupMessagesIds_.addLong(value);
  }
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  private void addAllGroupMessagesIds(
      java.lang.Iterable<? extends java.lang.Long> values) {
    ensureGroupMessagesIdsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, groupMessagesIds_);
  }
  /**
   * <code>repeated int64 GroupMessagesIds = 20;</code>
   */
  private void clearGroupMessagesIds() {
    groupMessagesIds_ = emptyLongList();
  }

  public static final int BROADCATMESSAGESIDS_FIELD_NUMBER = 21;
  private com.google.protobuf.Internal.LongList broadCatMessagesIds_;
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  public java.util.List<java.lang.Long>
      getBroadCatMessagesIdsList() {
    return broadCatMessagesIds_;
  }
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  public int getBroadCatMessagesIdsCount() {
    return broadCatMessagesIds_.size();
  }
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  public long getBroadCatMessagesIds(int index) {
    return broadCatMessagesIds_.getLong(index);
  }
  private void ensureBroadCatMessagesIdsIsMutable() {
    if (!broadCatMessagesIds_.isModifiable()) {
      broadCatMessagesIds_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(broadCatMessagesIds_);
     }
  }
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  private void setBroadCatMessagesIds(
      int index, long value) {
    ensureBroadCatMessagesIdsIsMutable();
    broadCatMessagesIds_.setLong(index, value);
  }
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  private void addBroadCatMessagesIds(long value) {
    ensureBroadCatMessagesIdsIsMutable();
    broadCatMessagesIds_.addLong(value);
  }
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  private void addAllBroadCatMessagesIds(
      java.lang.Iterable<? extends java.lang.Long> values) {
    ensureBroadCatMessagesIdsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, broadCatMessagesIds_);
  }
  /**
   * <code>repeated int64 BroadCatMessagesIds = 21;</code>
   */
  private void clearBroadCatMessagesIds() {
    broadCatMessagesIds_ = emptyLongList();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    for (int i = 0; i < directMessagesIds_.size(); i++) {
      output.writeInt64(10, directMessagesIds_.getLong(i));
    }
    for (int i = 0; i < groupMessagesIds_.size(); i++) {
      output.writeInt64(20, groupMessagesIds_.getLong(i));
    }
    for (int i = 0; i < broadCatMessagesIds_.size(); i++) {
      output.writeInt64(21, broadCatMessagesIds_.getLong(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < directMessagesIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(directMessagesIds_.getLong(i));
      }
      size += dataSize;
      size += 1 * getDirectMessagesIdsList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < groupMessagesIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(groupMessagesIds_.getLong(i));
      }
      size += dataSize;
      size += 2 * getGroupMessagesIdsList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < broadCatMessagesIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(broadCatMessagesIds_.getLong(i));
      }
      size += dataSize;
      size += 2 * getBroadCatMessagesIdsList().size();
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MessagesCollections parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MessagesCollections parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MessagesCollections parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MessagesCollections parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_MessagesCollections prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_MessagesCollections}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_MessagesCollections, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_MessagesCollections)
      ir.ms.pb.PB_MessagesCollectionsOrBuilder {
    // Construct using ir.ms.pb.PB_MessagesCollections.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public java.util.List<java.lang.Long>
        getDirectMessagesIdsList() {
      return java.util.Collections.unmodifiableList(
          instance.getDirectMessagesIdsList());
    }
    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public int getDirectMessagesIdsCount() {
      return instance.getDirectMessagesIdsCount();
    }
    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public long getDirectMessagesIds(int index) {
      return instance.getDirectMessagesIds(index);
    }
    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public Builder setDirectMessagesIds(
        int index, long value) {
      copyOnWrite();
      instance.setDirectMessagesIds(index, value);
      return this;
    }
    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public Builder addDirectMessagesIds(long value) {
      copyOnWrite();
      instance.addDirectMessagesIds(value);
      return this;
    }
    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public Builder addAllDirectMessagesIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      copyOnWrite();
      instance.addAllDirectMessagesIds(values);
      return this;
    }
    /**
     * <code>repeated int64 DirectMessagesIds = 10;</code>
     */
    public Builder clearDirectMessagesIds() {
      copyOnWrite();
      instance.clearDirectMessagesIds();
      return this;
    }

    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public java.util.List<java.lang.Long>
        getGroupMessagesIdsList() {
      return java.util.Collections.unmodifiableList(
          instance.getGroupMessagesIdsList());
    }
    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public int getGroupMessagesIdsCount() {
      return instance.getGroupMessagesIdsCount();
    }
    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public long getGroupMessagesIds(int index) {
      return instance.getGroupMessagesIds(index);
    }
    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public Builder setGroupMessagesIds(
        int index, long value) {
      copyOnWrite();
      instance.setGroupMessagesIds(index, value);
      return this;
    }
    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public Builder addGroupMessagesIds(long value) {
      copyOnWrite();
      instance.addGroupMessagesIds(value);
      return this;
    }
    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public Builder addAllGroupMessagesIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      copyOnWrite();
      instance.addAllGroupMessagesIds(values);
      return this;
    }
    /**
     * <code>repeated int64 GroupMessagesIds = 20;</code>
     */
    public Builder clearGroupMessagesIds() {
      copyOnWrite();
      instance.clearGroupMessagesIds();
      return this;
    }

    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public java.util.List<java.lang.Long>
        getBroadCatMessagesIdsList() {
      return java.util.Collections.unmodifiableList(
          instance.getBroadCatMessagesIdsList());
    }
    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public int getBroadCatMessagesIdsCount() {
      return instance.getBroadCatMessagesIdsCount();
    }
    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public long getBroadCatMessagesIds(int index) {
      return instance.getBroadCatMessagesIds(index);
    }
    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public Builder setBroadCatMessagesIds(
        int index, long value) {
      copyOnWrite();
      instance.setBroadCatMessagesIds(index, value);
      return this;
    }
    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public Builder addBroadCatMessagesIds(long value) {
      copyOnWrite();
      instance.addBroadCatMessagesIds(value);
      return this;
    }
    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public Builder addAllBroadCatMessagesIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      copyOnWrite();
      instance.addAllBroadCatMessagesIds(values);
      return this;
    }
    /**
     * <code>repeated int64 BroadCatMessagesIds = 21;</code>
     */
    public Builder clearBroadCatMessagesIds() {
      copyOnWrite();
      instance.clearBroadCatMessagesIds();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MessagesCollections)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_MessagesCollections();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        directMessagesIds_.makeImmutable();
        groupMessagesIds_.makeImmutable();
        broadCatMessagesIds_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_MessagesCollections other = (ir.ms.pb.PB_MessagesCollections) arg1;
        directMessagesIds_= visitor.visitLongList(directMessagesIds_, other.directMessagesIds_);
        groupMessagesIds_= visitor.visitLongList(groupMessagesIds_, other.groupMessagesIds_);
        broadCatMessagesIds_= visitor.visitLongList(broadCatMessagesIds_, other.broadCatMessagesIds_);
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
              case 80: {
                if (!directMessagesIds_.isModifiable()) {
                  directMessagesIds_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(directMessagesIds_);
                }
                directMessagesIds_.addLong(input.readInt64());
                break;
              }
              case 82: {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (!directMessagesIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                  directMessagesIds_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(directMessagesIds_);
                }
                while (input.getBytesUntilLimit() > 0) {
                  directMessagesIds_.addLong(input.readInt64());
                }
                input.popLimit(limit);
                break;
              }
              case 160: {
                if (!groupMessagesIds_.isModifiable()) {
                  groupMessagesIds_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(groupMessagesIds_);
                }
                groupMessagesIds_.addLong(input.readInt64());
                break;
              }
              case 162: {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (!groupMessagesIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                  groupMessagesIds_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(groupMessagesIds_);
                }
                while (input.getBytesUntilLimit() > 0) {
                  groupMessagesIds_.addLong(input.readInt64());
                }
                input.popLimit(limit);
                break;
              }
              case 168: {
                if (!broadCatMessagesIds_.isModifiable()) {
                  broadCatMessagesIds_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(broadCatMessagesIds_);
                }
                broadCatMessagesIds_.addLong(input.readInt64());
                break;
              }
              case 170: {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (!broadCatMessagesIds_.isModifiable() && input.getBytesUntilLimit() > 0) {
                  broadCatMessagesIds_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(broadCatMessagesIds_);
                }
                while (input.getBytesUntilLimit() > 0) {
                  broadCatMessagesIds_.addLong(input.readInt64());
                }
                input.popLimit(limit);
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_MessagesCollections.class) {
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


  // @@protoc_insertion_point(class_scope:PB_MessagesCollections)
  private static final ir.ms.pb.PB_MessagesCollections DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_MessagesCollections();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MessagesCollections getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MessagesCollections> PARSER;

  public static com.google.protobuf.Parser<PB_MessagesCollections> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

