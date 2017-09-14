// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_user.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_UserOfflineResponse_UpdateAbout}
 */
public  final class PB_UserOfflineResponse_UpdateAbout extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UserOfflineResponse_UpdateAbout, PB_UserOfflineResponse_UpdateAbout.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UserOfflineResponse_UpdateAbout)
    PB_UserOfflineResponse_UpdateAboutOrBuilder {
  private PB_UserOfflineResponse_UpdateAbout() {
    newAbout_ = "";
  }
  public static final int USERID_FIELD_NUMBER = 1;
  private int userId_;
  /**
   * <code>int32 UserId = 1;</code>
   */
  public int getUserId() {
    return userId_;
  }
  /**
   * <code>int32 UserId = 1;</code>
   */
  private void setUserId(int value) {
    
    userId_ = value;
  }
  /**
   * <code>int32 UserId = 1;</code>
   */
  private void clearUserId() {
    
    userId_ = 0;
  }

  public static final int NEWABOUT_FIELD_NUMBER = 2;
  private java.lang.String newAbout_;
  /**
   * <code>string NewAbout = 2;</code>
   */
  public java.lang.String getNewAbout() {
    return newAbout_;
  }
  /**
   * <code>string NewAbout = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNewAboutBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(newAbout_);
  }
  /**
   * <code>string NewAbout = 2;</code>
   */
  private void setNewAbout(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    newAbout_ = value;
  }
  /**
   * <code>string NewAbout = 2;</code>
   */
  private void clearNewAbout() {
    
    newAbout_ = getDefaultInstance().getNewAbout();
  }
  /**
   * <code>string NewAbout = 2;</code>
   */
  private void setNewAboutBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    newAbout_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!newAbout_.isEmpty()) {
      output.writeString(2, getNewAbout());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, userId_);
    }
    if (!newAbout_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getNewAbout());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UserOfflineResponse_UpdateAbout prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_UserOfflineResponse_UpdateAbout}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UserOfflineResponse_UpdateAbout, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UserOfflineResponse_UpdateAbout)
      ir.ms.pb.PB_UserOfflineResponse_UpdateAboutOrBuilder {
    // Construct using ir.ms.pb.PB_UserOfflineResponse_UpdateAbout.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 UserId = 1;</code>
     */
    public int getUserId() {
      return instance.getUserId();
    }
    /**
     * <code>int32 UserId = 1;</code>
     */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /**
     * <code>int32 UserId = 1;</code>
     */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /**
     * <code>string NewAbout = 2;</code>
     */
    public java.lang.String getNewAbout() {
      return instance.getNewAbout();
    }
    /**
     * <code>string NewAbout = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNewAboutBytes() {
      return instance.getNewAboutBytes();
    }
    /**
     * <code>string NewAbout = 2;</code>
     */
    public Builder setNewAbout(
        java.lang.String value) {
      copyOnWrite();
      instance.setNewAbout(value);
      return this;
    }
    /**
     * <code>string NewAbout = 2;</code>
     */
    public Builder clearNewAbout() {
      copyOnWrite();
      instance.clearNewAbout();
      return this;
    }
    /**
     * <code>string NewAbout = 2;</code>
     */
    public Builder setNewAboutBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setNewAboutBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UserOfflineResponse_UpdateAbout)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UserOfflineResponse_UpdateAbout();
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
        ir.ms.pb.PB_UserOfflineResponse_UpdateAbout other = (ir.ms.pb.PB_UserOfflineResponse_UpdateAbout) arg1;
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        newAbout_ = visitor.visitString(!newAbout_.isEmpty(), newAbout_,
            !other.newAbout_.isEmpty(), other.newAbout_);
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

                userId_ = input.readInt32();
                break;
              }
              case 18: {
                String s = input.readStringRequireUtf8();

                newAbout_ = s;
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UserOfflineResponse_UpdateAbout.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UserOfflineResponse_UpdateAbout)
  private static final ir.ms.pb.PB_UserOfflineResponse_UpdateAbout DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UserOfflineResponse_UpdateAbout();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UserOfflineResponse_UpdateAbout getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UserOfflineResponse_UpdateAbout> PARSER;

  public static com.google.protobuf.Parser<PB_UserOfflineResponse_UpdateAbout> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

