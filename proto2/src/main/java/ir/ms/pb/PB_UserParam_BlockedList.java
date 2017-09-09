// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_user.proto

package ir.ms.pb;

/**
 *
 *
 * <pre>
 * </pre>
 *
 * Protobuf type {@code PB_UserParam_BlockedList}
 */
public final class PB_UserParam_BlockedList
    extends com.google.protobuf.GeneratedMessageLite<
        PB_UserParam_BlockedList, PB_UserParam_BlockedList.Builder>
    implements
    // @@protoc_insertion_point(message_implements:PB_UserParam_BlockedList)
    PB_UserParam_BlockedListOrBuilder {
  private PB_UserParam_BlockedList() {
    userName_ = "";
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private int userId_;
  /** <code>int32 UserId = 1;</code> */
  public int getUserId() {
    return userId_;
  }
  /** <code>int32 UserId = 1;</code> */
  private void setUserId(int value) {

    userId_ = value;
  }
  /** <code>int32 UserId = 1;</code> */
  private void clearUserId() {

    userId_ = 0;
  }

  public static final int USERNAME_FIELD_NUMBER = 2;
  private java.lang.String userName_;
  /** <code>string UserName = 2;</code> */
  public java.lang.String getUserName() {
    return userName_;
  }
  /** <code>string UserName = 2;</code> */
  public com.google.protobuf.ByteString getUserNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(userName_);
  }
  /** <code>string UserName = 2;</code> */
  private void setUserName(java.lang.String value) {
    if (value == null) {
      throw new NullPointerException();
    }

    userName_ = value;
  }
  /** <code>string UserName = 2;</code> */
  private void clearUserName() {

    userName_ = getDefaultInstance().getUserName();
  }
  /** <code>string UserName = 2;</code> */
  private void setUserNameBytes(com.google.protobuf.ByteString value) {
    if (value == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(value);

    userName_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!userName_.isEmpty()) {
      output.writeString(2, getUserName());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(1, userId_);
    }
    if (!userName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeStringSize(2, getUserName());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_UserParam_BlockedList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ir.ms.pb.PB_UserParam_BlockedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   *
   *
   * <pre>
   * </pre>
   *
   * Protobuf type {@code PB_UserParam_BlockedList}
   */
  public static final class Builder
      extends com.google.protobuf.GeneratedMessageLite.Builder<
          ir.ms.pb.PB_UserParam_BlockedList, Builder>
      implements
      // @@protoc_insertion_point(builder_implements:PB_UserParam_BlockedList)
      ir.ms.pb.PB_UserParam_BlockedListOrBuilder {
    // Construct using ir.ms.pb.PB_UserParam_BlockedList.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }

    /** <code>int32 UserId = 1;</code> */
    public int getUserId() {
      return instance.getUserId();
    }
    /** <code>int32 UserId = 1;</code> */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /** <code>int32 UserId = 1;</code> */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /** <code>string UserName = 2;</code> */
    public java.lang.String getUserName() {
      return instance.getUserName();
    }
    /** <code>string UserName = 2;</code> */
    public com.google.protobuf.ByteString getUserNameBytes() {
      return instance.getUserNameBytes();
    }
    /** <code>string UserName = 2;</code> */
    public Builder setUserName(java.lang.String value) {
      copyOnWrite();
      instance.setUserName(value);
      return this;
    }
    /** <code>string UserName = 2;</code> */
    public Builder clearUserName() {
      copyOnWrite();
      instance.clearUserName();
      return this;
    }
    /** <code>string UserName = 2;</code> */
    public Builder setUserNameBytes(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setUserNameBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UserParam_BlockedList)
  }

  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE:
        {
          return new ir.ms.pb.PB_UserParam_BlockedList();
        }
      case IS_INITIALIZED:
        {
          return DEFAULT_INSTANCE;
        }
      case MAKE_IMMUTABLE:
        {
          return null;
        }
      case NEW_BUILDER:
        {
          return new Builder();
        }
      case VISIT:
        {
          Visitor visitor = (Visitor) arg0;
          ir.ms.pb.PB_UserParam_BlockedList other = (ir.ms.pb.PB_UserParam_BlockedList) arg1;
          userId_ = visitor.visitInt(userId_ != 0, userId_, other.userId_ != 0, other.userId_);
          userName_ =
              visitor.visitString(
                  !userName_.isEmpty(), userName_, !other.userName_.isEmpty(), other.userName_);
          if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {}
          return this;
        }
      case MERGE_FROM_STREAM:
        {
          com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
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
                default:
                  {
                    if (!input.skipField(tag)) {
                      done = true;
                    }
                    break;
                  }
                case 8:
                  {
                    userId_ = input.readInt32();
                    break;
                  }
                case 18:
                  {
                    String s = input.readStringRequireUtf8();

                    userName_ = s;
                    break;
                  }
              }
            }
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException(e.setUnfinishedMessage(this));
          } catch (java.io.IOException e) {
            throw new RuntimeException(
                new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
                    .setUnfinishedMessage(this));
          } finally {
          }
        }
      case GET_DEFAULT_INSTANCE:
        {
          return DEFAULT_INSTANCE;
        }
      case GET_PARSER:
        {
          if (PARSER == null) {
            synchronized (ir.ms.pb.PB_UserParam_BlockedList.class) {
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

  // @@protoc_insertion_point(class_scope:PB_UserParam_BlockedList)
  private static final ir.ms.pb.PB_UserParam_BlockedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PB_UserParam_BlockedList();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UserParam_BlockedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UserParam_BlockedList> PARSER;

  public static com.google.protobuf.Parser<PB_UserParam_BlockedList> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
