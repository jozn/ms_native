// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_user.proto

package ir.ms.pb;

/**
 * <pre>
 * UnBlockUser
 * </pre>
 *
 * Protobuf type {@code PB_UserParam_UnBlockUser}
 */
public  final class PB_UserParam_UnBlockUser extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UserParam_UnBlockUser, PB_UserParam_UnBlockUser.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UserParam_UnBlockUser)
    PB_UserParam_UnBlockUserOrBuilder {
  private PB_UserParam_UnBlockUser() {
  }
  public static final int OFFSET_FIELD_NUMBER = 1;
  private int offset_;
  /**
   * <code>int32 Offset = 1;</code>
   */
  public int getOffset() {
    return offset_;
  }
  /**
   * <code>int32 Offset = 1;</code>
   */
  private void setOffset(int value) {
    
    offset_ = value;
  }
  /**
   * <code>int32 Offset = 1;</code>
   */
  private void clearOffset() {
    
    offset_ = 0;
  }

  public static final int LIMIT_FIELD_NUMBER = 2;
  private int limit_;
  /**
   * <code>int32 Limit = 2;</code>
   */
  public int getLimit() {
    return limit_;
  }
  /**
   * <code>int32 Limit = 2;</code>
   */
  private void setLimit(int value) {
    
    limit_ = value;
  }
  /**
   * <code>int32 Limit = 2;</code>
   */
  private void clearLimit() {
    
    limit_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (offset_ != 0) {
      output.writeInt32(1, offset_);
    }
    if (limit_ != 0) {
      output.writeInt32(2, limit_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (offset_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, offset_);
    }
    if (limit_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, limit_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserParam_UnBlockUser parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UserParam_UnBlockUser prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * UnBlockUser
   * </pre>
   *
   * Protobuf type {@code PB_UserParam_UnBlockUser}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UserParam_UnBlockUser, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UserParam_UnBlockUser)
      ir.ms.pb.PB_UserParam_UnBlockUserOrBuilder {
    // Construct using ir.ms.pb.PB_UserParam_UnBlockUser.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 Offset = 1;</code>
     */
    public int getOffset() {
      return instance.getOffset();
    }
    /**
     * <code>int32 Offset = 1;</code>
     */
    public Builder setOffset(int value) {
      copyOnWrite();
      instance.setOffset(value);
      return this;
    }
    /**
     * <code>int32 Offset = 1;</code>
     */
    public Builder clearOffset() {
      copyOnWrite();
      instance.clearOffset();
      return this;
    }

    /**
     * <code>int32 Limit = 2;</code>
     */
    public int getLimit() {
      return instance.getLimit();
    }
    /**
     * <code>int32 Limit = 2;</code>
     */
    public Builder setLimit(int value) {
      copyOnWrite();
      instance.setLimit(value);
      return this;
    }
    /**
     * <code>int32 Limit = 2;</code>
     */
    public Builder clearLimit() {
      copyOnWrite();
      instance.clearLimit();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UserParam_UnBlockUser)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UserParam_UnBlockUser();
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
        ir.ms.pb.PB_UserParam_UnBlockUser other = (ir.ms.pb.PB_UserParam_UnBlockUser) arg1;
        offset_ = visitor.visitInt(offset_ != 0, offset_,
            other.offset_ != 0, other.offset_);
        limit_ = visitor.visitInt(limit_ != 0, limit_,
            other.limit_ != 0, other.limit_);
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

                offset_ = input.readInt32();
                break;
              }
              case 16: {

                limit_ = input.readInt32();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UserParam_UnBlockUser.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UserParam_UnBlockUser)
  private static final ir.ms.pb.PB_UserParam_UnBlockUser DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UserParam_UnBlockUser();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UserParam_UnBlockUser getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UserParam_UnBlockUser> PARSER;

  public static com.google.protobuf.Parser<PB_UserParam_UnBlockUser> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

