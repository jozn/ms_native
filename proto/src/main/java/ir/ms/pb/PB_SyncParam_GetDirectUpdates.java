// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_sync.proto

package ir.ms.pb;

/**
 * <pre>
 *&#47;////////////////////////////
 * </pre>
 *
 * Protobuf type {@code PB_SyncParam_GetDirectUpdates}
 */
public  final class PB_SyncParam_GetDirectUpdates extends
    com.google.protobuf.GeneratedMessageLite<
        PB_SyncParam_GetDirectUpdates, PB_SyncParam_GetDirectUpdates.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_SyncParam_GetDirectUpdates)
    PB_SyncParam_GetDirectUpdatesOrBuilder {
  private PB_SyncParam_GetDirectUpdates() {
  }
  public static final int LASTID_FIELD_NUMBER = 1;
  private long lastId_;
  /**
   * <code>int64 LastId = 1;</code>
   */
  public long getLastId() {
    return lastId_;
  }
  /**
   * <code>int64 LastId = 1;</code>
   */
  private void setLastId(long value) {
    
    lastId_ = value;
  }
  /**
   * <code>int64 LastId = 1;</code>
   */
  private void clearLastId() {
    
    lastId_ = 0L;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (lastId_ != 0L) {
      output.writeInt64(1, lastId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (lastId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, lastId_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_SyncParam_GetDirectUpdates prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   *&#47;////////////////////////////
   * </pre>
   *
   * Protobuf type {@code PB_SyncParam_GetDirectUpdates}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_SyncParam_GetDirectUpdates, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_SyncParam_GetDirectUpdates)
      ir.ms.pb.PB_SyncParam_GetDirectUpdatesOrBuilder {
    // Construct using ir.ms.pb.PB_SyncParam_GetDirectUpdates.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int64 LastId = 1;</code>
     */
    public long getLastId() {
      return instance.getLastId();
    }
    /**
     * <code>int64 LastId = 1;</code>
     */
    public Builder setLastId(long value) {
      copyOnWrite();
      instance.setLastId(value);
      return this;
    }
    /**
     * <code>int64 LastId = 1;</code>
     */
    public Builder clearLastId() {
      copyOnWrite();
      instance.clearLastId();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_SyncParam_GetDirectUpdates)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_SyncParam_GetDirectUpdates();
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
        ir.ms.pb.PB_SyncParam_GetDirectUpdates other = (ir.ms.pb.PB_SyncParam_GetDirectUpdates) arg1;
        lastId_ = visitor.visitLong(lastId_ != 0L, lastId_,
            other.lastId_ != 0L, other.lastId_);
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_SyncParam_GetDirectUpdates.class) {
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


  // @@protoc_insertion_point(class_scope:PB_SyncParam_GetDirectUpdates)
  private static final ir.ms.pb.PB_SyncParam_GetDirectUpdates DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_SyncParam_GetDirectUpdates();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_SyncParam_GetDirectUpdates getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_SyncParam_GetDirectUpdates> PARSER;

  public static com.google.protobuf.Parser<PB_SyncParam_GetDirectUpdates> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

