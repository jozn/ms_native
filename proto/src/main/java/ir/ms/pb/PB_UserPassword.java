// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_UserPassword}
 */
public  final class PB_UserPassword extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UserPassword, PB_UserPassword.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UserPassword)
    PB_UserPasswordOrBuilder {
  private PB_UserPassword() {
    password_ = "";
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

  public static final int PASSWORD_FIELD_NUMBER = 3;
  private java.lang.String password_;
  /**
   * <code>string Password = 3;</code>
   */
  public java.lang.String getPassword() {
    return password_;
  }
  /**
   * <code>string Password = 3;</code>
   */
  public com.google.protobuf.ByteString
      getPasswordBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(password_);
  }
  /**
   * <code>string Password = 3;</code>
   */
  private void setPassword(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    password_ = value;
  }
  /**
   * <code>string Password = 3;</code>
   */
  private void clearPassword() {
    
    password_ = getDefaultInstance().getPassword();
  }
  /**
   * <code>string Password = 3;</code>
   */
  private void setPasswordBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    password_ = value.toStringUtf8();
  }

  public static final int CREATEDTIME_FIELD_NUMBER = 5;
  private int createdTime_;
  /**
   * <code>int32 CreatedTime = 5;</code>
   */
  public int getCreatedTime() {
    return createdTime_;
  }
  /**
   * <code>int32 CreatedTime = 5;</code>
   */
  private void setCreatedTime(int value) {
    
    createdTime_ = value;
  }
  /**
   * <code>int32 CreatedTime = 5;</code>
   */
  private void clearCreatedTime() {
    
    createdTime_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!password_.isEmpty()) {
      output.writeString(3, getPassword());
    }
    if (createdTime_ != 0) {
      output.writeInt32(5, createdTime_);
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
    if (!password_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getPassword());
    }
    if (createdTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, createdTime_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UserPassword parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserPassword parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserPassword parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserPassword parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UserPassword prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_UserPassword}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UserPassword, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UserPassword)
      ir.ms.pb.PB_UserPasswordOrBuilder {
    // Construct using ir.ms.pb.PB_UserPassword.newBuilder()
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
     * <code>string Password = 3;</code>
     */
    public java.lang.String getPassword() {
      return instance.getPassword();
    }
    /**
     * <code>string Password = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      return instance.getPasswordBytes();
    }
    /**
     * <code>string Password = 3;</code>
     */
    public Builder setPassword(
        java.lang.String value) {
      copyOnWrite();
      instance.setPassword(value);
      return this;
    }
    /**
     * <code>string Password = 3;</code>
     */
    public Builder clearPassword() {
      copyOnWrite();
      instance.clearPassword();
      return this;
    }
    /**
     * <code>string Password = 3;</code>
     */
    public Builder setPasswordBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setPasswordBytes(value);
      return this;
    }

    /**
     * <code>int32 CreatedTime = 5;</code>
     */
    public int getCreatedTime() {
      return instance.getCreatedTime();
    }
    /**
     * <code>int32 CreatedTime = 5;</code>
     */
    public Builder setCreatedTime(int value) {
      copyOnWrite();
      instance.setCreatedTime(value);
      return this;
    }
    /**
     * <code>int32 CreatedTime = 5;</code>
     */
    public Builder clearCreatedTime() {
      copyOnWrite();
      instance.clearCreatedTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UserPassword)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UserPassword();
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
        ir.ms.pb.PB_UserPassword other = (ir.ms.pb.PB_UserPassword) arg1;
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        password_ = visitor.visitString(!password_.isEmpty(), password_,
            !other.password_.isEmpty(), other.password_);
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

                userId_ = input.readInt32();
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                password_ = s;
                break;
              }
              case 40: {

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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UserPassword.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UserPassword)
  private static final ir.ms.pb.PB_UserPassword DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UserPassword();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UserPassword getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UserPassword> PARSER;

  public static com.google.protobuf.Parser<PB_UserPassword> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

