// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_Activity}
 */
public  final class PB_Activity extends
    com.google.protobuf.GeneratedMessageLite<
        PB_Activity, PB_Activity.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_Activity)
    PB_ActivityOrBuilder {
  private PB_Activity() {
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

  public static final int ACTORUSERID_FIELD_NUMBER = 3;
  private int actorUserId_;
  /**
   * <code>int32 ActorUserId = 3;</code>
   */
  public int getActorUserId() {
    return actorUserId_;
  }
  /**
   * <code>int32 ActorUserId = 3;</code>
   */
  private void setActorUserId(int value) {
    
    actorUserId_ = value;
  }
  /**
   * <code>int32 ActorUserId = 3;</code>
   */
  private void clearActorUserId() {
    
    actorUserId_ = 0;
  }

  public static final int ACTIONTYPEID_FIELD_NUMBER = 5;
  private int actionTypeId_;
  /**
   * <code>int32 ActionTypeId = 5;</code>
   */
  public int getActionTypeId() {
    return actionTypeId_;
  }
  /**
   * <code>int32 ActionTypeId = 5;</code>
   */
  private void setActionTypeId(int value) {
    
    actionTypeId_ = value;
  }
  /**
   * <code>int32 ActionTypeId = 5;</code>
   */
  private void clearActionTypeId() {
    
    actionTypeId_ = 0;
  }

  public static final int ROWID_FIELD_NUMBER = 7;
  private int rowId_;
  /**
   * <code>int32 RowId = 7;</code>
   */
  public int getRowId() {
    return rowId_;
  }
  /**
   * <code>int32 RowId = 7;</code>
   */
  private void setRowId(int value) {
    
    rowId_ = value;
  }
  /**
   * <code>int32 RowId = 7;</code>
   */
  private void clearRowId() {
    
    rowId_ = 0;
  }

  public static final int ROOTID_FIELD_NUMBER = 9;
  private int rootId_;
  /**
   * <code>int32 RootId = 9;</code>
   */
  public int getRootId() {
    return rootId_;
  }
  /**
   * <code>int32 RootId = 9;</code>
   */
  private void setRootId(int value) {
    
    rootId_ = value;
  }
  /**
   * <code>int32 RootId = 9;</code>
   */
  private void clearRootId() {
    
    rootId_ = 0;
  }

  public static final int REFID_FIELD_NUMBER = 11;
  private long refId_;
  /**
   * <code>int64 RefId = 11;</code>
   */
  public long getRefId() {
    return refId_;
  }
  /**
   * <code>int64 RefId = 11;</code>
   */
  private void setRefId(long value) {
    
    refId_ = value;
  }
  /**
   * <code>int64 RefId = 11;</code>
   */
  private void clearRefId() {
    
    refId_ = 0L;
  }

  public static final int CREATEDAT_FIELD_NUMBER = 13;
  private int createdAt_;
  /**
   * <code>int32 CreatedAt = 13;</code>
   */
  public int getCreatedAt() {
    return createdAt_;
  }
  /**
   * <code>int32 CreatedAt = 13;</code>
   */
  private void setCreatedAt(int value) {
    
    createdAt_ = value;
  }
  /**
   * <code>int32 CreatedAt = 13;</code>
   */
  private void clearCreatedAt() {
    
    createdAt_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (actorUserId_ != 0) {
      output.writeInt32(3, actorUserId_);
    }
    if (actionTypeId_ != 0) {
      output.writeInt32(5, actionTypeId_);
    }
    if (rowId_ != 0) {
      output.writeInt32(7, rowId_);
    }
    if (rootId_ != 0) {
      output.writeInt32(9, rootId_);
    }
    if (refId_ != 0L) {
      output.writeInt64(11, refId_);
    }
    if (createdAt_ != 0) {
      output.writeInt32(13, createdAt_);
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
    if (actorUserId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, actorUserId_);
    }
    if (actionTypeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, actionTypeId_);
    }
    if (rowId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, rowId_);
    }
    if (rootId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, rootId_);
    }
    if (refId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(11, refId_);
    }
    if (createdAt_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, createdAt_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_Activity parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Activity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Activity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_Activity parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_Activity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Activity parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Activity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Activity parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_Activity parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_Activity parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_Activity prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_Activity}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_Activity, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_Activity)
      ir.ms.pb.PB_ActivityOrBuilder {
    // Construct using ir.ms.pb.PB_Activity.newBuilder()
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
     * <code>int32 ActorUserId = 3;</code>
     */
    public int getActorUserId() {
      return instance.getActorUserId();
    }
    /**
     * <code>int32 ActorUserId = 3;</code>
     */
    public Builder setActorUserId(int value) {
      copyOnWrite();
      instance.setActorUserId(value);
      return this;
    }
    /**
     * <code>int32 ActorUserId = 3;</code>
     */
    public Builder clearActorUserId() {
      copyOnWrite();
      instance.clearActorUserId();
      return this;
    }

    /**
     * <code>int32 ActionTypeId = 5;</code>
     */
    public int getActionTypeId() {
      return instance.getActionTypeId();
    }
    /**
     * <code>int32 ActionTypeId = 5;</code>
     */
    public Builder setActionTypeId(int value) {
      copyOnWrite();
      instance.setActionTypeId(value);
      return this;
    }
    /**
     * <code>int32 ActionTypeId = 5;</code>
     */
    public Builder clearActionTypeId() {
      copyOnWrite();
      instance.clearActionTypeId();
      return this;
    }

    /**
     * <code>int32 RowId = 7;</code>
     */
    public int getRowId() {
      return instance.getRowId();
    }
    /**
     * <code>int32 RowId = 7;</code>
     */
    public Builder setRowId(int value) {
      copyOnWrite();
      instance.setRowId(value);
      return this;
    }
    /**
     * <code>int32 RowId = 7;</code>
     */
    public Builder clearRowId() {
      copyOnWrite();
      instance.clearRowId();
      return this;
    }

    /**
     * <code>int32 RootId = 9;</code>
     */
    public int getRootId() {
      return instance.getRootId();
    }
    /**
     * <code>int32 RootId = 9;</code>
     */
    public Builder setRootId(int value) {
      copyOnWrite();
      instance.setRootId(value);
      return this;
    }
    /**
     * <code>int32 RootId = 9;</code>
     */
    public Builder clearRootId() {
      copyOnWrite();
      instance.clearRootId();
      return this;
    }

    /**
     * <code>int64 RefId = 11;</code>
     */
    public long getRefId() {
      return instance.getRefId();
    }
    /**
     * <code>int64 RefId = 11;</code>
     */
    public Builder setRefId(long value) {
      copyOnWrite();
      instance.setRefId(value);
      return this;
    }
    /**
     * <code>int64 RefId = 11;</code>
     */
    public Builder clearRefId() {
      copyOnWrite();
      instance.clearRefId();
      return this;
    }

    /**
     * <code>int32 CreatedAt = 13;</code>
     */
    public int getCreatedAt() {
      return instance.getCreatedAt();
    }
    /**
     * <code>int32 CreatedAt = 13;</code>
     */
    public Builder setCreatedAt(int value) {
      copyOnWrite();
      instance.setCreatedAt(value);
      return this;
    }
    /**
     * <code>int32 CreatedAt = 13;</code>
     */
    public Builder clearCreatedAt() {
      copyOnWrite();
      instance.clearCreatedAt();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_Activity)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_Activity();
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
        ir.ms.pb.PB_Activity other = (ir.ms.pb.PB_Activity) arg1;
        id_ = visitor.visitLong(id_ != 0L, id_,
            other.id_ != 0L, other.id_);
        actorUserId_ = visitor.visitInt(actorUserId_ != 0, actorUserId_,
            other.actorUserId_ != 0, other.actorUserId_);
        actionTypeId_ = visitor.visitInt(actionTypeId_ != 0, actionTypeId_,
            other.actionTypeId_ != 0, other.actionTypeId_);
        rowId_ = visitor.visitInt(rowId_ != 0, rowId_,
            other.rowId_ != 0, other.rowId_);
        rootId_ = visitor.visitInt(rootId_ != 0, rootId_,
            other.rootId_ != 0, other.rootId_);
        refId_ = visitor.visitLong(refId_ != 0L, refId_,
            other.refId_ != 0L, other.refId_);
        createdAt_ = visitor.visitInt(createdAt_ != 0, createdAt_,
            other.createdAt_ != 0, other.createdAt_);
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

                actorUserId_ = input.readInt32();
                break;
              }
              case 40: {

                actionTypeId_ = input.readInt32();
                break;
              }
              case 56: {

                rowId_ = input.readInt32();
                break;
              }
              case 72: {

                rootId_ = input.readInt32();
                break;
              }
              case 88: {

                refId_ = input.readInt64();
                break;
              }
              case 104: {

                createdAt_ = input.readInt32();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_Activity.class) {
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


  // @@protoc_insertion_point(class_scope:PB_Activity)
  private static final ir.ms.pb.PB_Activity DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_Activity();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_Activity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_Activity> PARSER;

  public static com.google.protobuf.Parser<PB_Activity> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

