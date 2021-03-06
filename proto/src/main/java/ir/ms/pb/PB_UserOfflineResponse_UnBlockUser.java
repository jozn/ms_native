// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_user.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_UserOfflineResponse_UnBlockUser}
 */
public  final class PB_UserOfflineResponse_UnBlockUser extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UserOfflineResponse_UnBlockUser, PB_UserOfflineResponse_UnBlockUser.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UserOfflineResponse_UnBlockUser)
    PB_UserOfflineResponse_UnBlockUserOrBuilder {
  private PB_UserOfflineResponse_UnBlockUser() {
    users_ = emptyProtobufList();
  }
  public static final int USERS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.UserView> users_;
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  public java.util.List<ir.ms.pb.UserView> getUsersList() {
    return users_;
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  public java.util.List<? extends ir.ms.pb.UserViewOrBuilder> 
      getUsersOrBuilderList() {
    return users_;
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  public int getUsersCount() {
    return users_.size();
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  public ir.ms.pb.UserView getUsers(int index) {
    return users_.get(index);
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  public ir.ms.pb.UserViewOrBuilder getUsersOrBuilder(
      int index) {
    return users_.get(index);
  }
  private void ensureUsersIsMutable() {
    if (!users_.isModifiable()) {
      users_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(users_);
     }
  }

  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void setUsers(
      int index, ir.ms.pb.UserView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUsersIsMutable();
    users_.set(index, value);
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void setUsers(
      int index, ir.ms.pb.UserView.Builder builderForValue) {
    ensureUsersIsMutable();
    users_.set(index, builderForValue.build());
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void addUsers(ir.ms.pb.UserView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUsersIsMutable();
    users_.add(value);
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void addUsers(
      int index, ir.ms.pb.UserView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureUsersIsMutable();
    users_.add(index, value);
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void addUsers(
      ir.ms.pb.UserView.Builder builderForValue) {
    ensureUsersIsMutable();
    users_.add(builderForValue.build());
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void addUsers(
      int index, ir.ms.pb.UserView.Builder builderForValue) {
    ensureUsersIsMutable();
    users_.add(index, builderForValue.build());
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void addAllUsers(
      java.lang.Iterable<? extends ir.ms.pb.UserView> values) {
    ensureUsersIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, users_);
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void clearUsers() {
    users_ = emptyProtobufList();
  }
  /**
   * <code>repeated .UserView Users = 1;</code>
   */
  private void removeUsers(int index) {
    ensureUsersIsMutable();
    users_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < users_.size(); i++) {
      output.writeMessage(1, users_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < users_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, users_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UserOfflineResponse_UnBlockUser prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_UserOfflineResponse_UnBlockUser}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UserOfflineResponse_UnBlockUser, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UserOfflineResponse_UnBlockUser)
      ir.ms.pb.PB_UserOfflineResponse_UnBlockUserOrBuilder {
    // Construct using ir.ms.pb.PB_UserOfflineResponse_UnBlockUser.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public java.util.List<ir.ms.pb.UserView> getUsersList() {
      return java.util.Collections.unmodifiableList(
          instance.getUsersList());
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public int getUsersCount() {
      return instance.getUsersCount();
    }/**
     * <code>repeated .UserView Users = 1;</code>
     */
    public ir.ms.pb.UserView getUsers(int index) {
      return instance.getUsers(index);
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder setUsers(
        int index, ir.ms.pb.UserView value) {
      copyOnWrite();
      instance.setUsers(index, value);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder setUsers(
        int index, ir.ms.pb.UserView.Builder builderForValue) {
      copyOnWrite();
      instance.setUsers(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder addUsers(ir.ms.pb.UserView value) {
      copyOnWrite();
      instance.addUsers(value);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder addUsers(
        int index, ir.ms.pb.UserView value) {
      copyOnWrite();
      instance.addUsers(index, value);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder addUsers(
        ir.ms.pb.UserView.Builder builderForValue) {
      copyOnWrite();
      instance.addUsers(builderForValue);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder addUsers(
        int index, ir.ms.pb.UserView.Builder builderForValue) {
      copyOnWrite();
      instance.addUsers(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder addAllUsers(
        java.lang.Iterable<? extends ir.ms.pb.UserView> values) {
      copyOnWrite();
      instance.addAllUsers(values);
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder clearUsers() {
      copyOnWrite();
      instance.clearUsers();
      return this;
    }
    /**
     * <code>repeated .UserView Users = 1;</code>
     */
    public Builder removeUsers(int index) {
      copyOnWrite();
      instance.removeUsers(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UserOfflineResponse_UnBlockUser)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UserOfflineResponse_UnBlockUser();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        users_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_UserOfflineResponse_UnBlockUser other = (ir.ms.pb.PB_UserOfflineResponse_UnBlockUser) arg1;
        users_= visitor.visitList(users_, other.users_);
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
              case 10: {
                if (!users_.isModifiable()) {
                  users_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(users_);
                }
                users_.add(
                    input.readMessage(ir.ms.pb.UserView.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UserOfflineResponse_UnBlockUser.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UserOfflineResponse_UnBlockUser)
  private static final ir.ms.pb.PB_UserOfflineResponse_UnBlockUser DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UserOfflineResponse_UnBlockUser();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UserOfflineResponse_UnBlockUser getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UserOfflineResponse_UnBlockUser> PARSER;

  public static com.google.protobuf.Parser<PB_UserOfflineResponse_UnBlockUser> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

