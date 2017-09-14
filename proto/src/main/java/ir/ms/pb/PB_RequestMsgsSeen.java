// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_del.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_RequestMsgsSeen}
 */
public  final class PB_RequestMsgsSeen extends
    com.google.protobuf.GeneratedMessageLite<
        PB_RequestMsgsSeen, PB_RequestMsgsSeen.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_RequestMsgsSeen)
    PB_RequestMsgsSeenOrBuilder {
  private PB_RequestMsgsSeen() {
    seen_ = emptyProtobufList();
  }
  private int bitField0_;
  public static final int REQUEST_FIELD_NUMBER = 1;
  private ir.ms.pb.PB_Request request_;
  /**
   * <code>.PB_Request Request = 1;</code>
   */
  public boolean hasRequest() {
    return request_ != null;
  }
  /**
   * <code>.PB_Request Request = 1;</code>
   */
  public ir.ms.pb.PB_Request getRequest() {
    return request_ == null ? ir.ms.pb.PB_Request.getDefaultInstance() : request_;
  }
  /**
   * <code>.PB_Request Request = 1;</code>
   */
  private void setRequest(ir.ms.pb.PB_Request value) {
    if (value == null) {
      throw new NullPointerException();
    }
    request_ = value;
    
    }
  /**
   * <code>.PB_Request Request = 1;</code>
   */
  private void setRequest(
      ir.ms.pb.PB_Request.Builder builderForValue) {
    request_ = builderForValue.build();
    
  }
  /**
   * <code>.PB_Request Request = 1;</code>
   */
  private void mergeRequest(ir.ms.pb.PB_Request value) {
    if (request_ != null &&
        request_ != ir.ms.pb.PB_Request.getDefaultInstance()) {
      request_ =
        ir.ms.pb.PB_Request.newBuilder(request_).mergeFrom(value).buildPartial();
    } else {
      request_ = value;
    }
    
  }
  /**
   * <code>.PB_Request Request = 1;</code>
   */
  private void clearRequest() {  request_ = null;
    
  }

  public static final int SEEN_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.PB_MsgSeen> seen_;
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  public java.util.List<ir.ms.pb.PB_MsgSeen> getSeenList() {
    return seen_;
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  public java.util.List<? extends ir.ms.pb.PB_MsgSeenOrBuilder> 
      getSeenOrBuilderList() {
    return seen_;
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  public int getSeenCount() {
    return seen_.size();
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  public ir.ms.pb.PB_MsgSeen getSeen(int index) {
    return seen_.get(index);
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  public ir.ms.pb.PB_MsgSeenOrBuilder getSeenOrBuilder(
      int index) {
    return seen_.get(index);
  }
  private void ensureSeenIsMutable() {
    if (!seen_.isModifiable()) {
      seen_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(seen_);
     }
  }

  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void setSeen(
      int index, ir.ms.pb.PB_MsgSeen value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureSeenIsMutable();
    seen_.set(index, value);
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void setSeen(
      int index, ir.ms.pb.PB_MsgSeen.Builder builderForValue) {
    ensureSeenIsMutable();
    seen_.set(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void addSeen(ir.ms.pb.PB_MsgSeen value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureSeenIsMutable();
    seen_.add(value);
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void addSeen(
      int index, ir.ms.pb.PB_MsgSeen value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureSeenIsMutable();
    seen_.add(index, value);
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void addSeen(
      ir.ms.pb.PB_MsgSeen.Builder builderForValue) {
    ensureSeenIsMutable();
    seen_.add(builderForValue.build());
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void addSeen(
      int index, ir.ms.pb.PB_MsgSeen.Builder builderForValue) {
    ensureSeenIsMutable();
    seen_.add(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void addAllSeen(
      java.lang.Iterable<? extends ir.ms.pb.PB_MsgSeen> values) {
    ensureSeenIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, seen_);
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void clearSeen() {
    seen_ = emptyProtobufList();
  }
  /**
   * <code>repeated .PB_MsgSeen Seen = 2;</code>
   */
  private void removeSeen(int index) {
    ensureSeenIsMutable();
    seen_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (request_ != null) {
      output.writeMessage(1, getRequest());
    }
    for (int i = 0; i < seen_.size(); i++) {
      output.writeMessage(2, seen_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (request_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getRequest());
    }
    for (int i = 0; i < seen_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, seen_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_RequestMsgsSeen parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_RequestMsgsSeen prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_RequestMsgsSeen}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_RequestMsgsSeen, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_RequestMsgsSeen)
      ir.ms.pb.PB_RequestMsgsSeenOrBuilder {
    // Construct using ir.ms.pb.PB_RequestMsgsSeen.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>.PB_Request Request = 1;</code>
     */
    public boolean hasRequest() {
      return instance.hasRequest();
    }
    /**
     * <code>.PB_Request Request = 1;</code>
     */
    public ir.ms.pb.PB_Request getRequest() {
      return instance.getRequest();
    }
    /**
     * <code>.PB_Request Request = 1;</code>
     */
    public Builder setRequest(ir.ms.pb.PB_Request value) {
      copyOnWrite();
      instance.setRequest(value);
      return this;
      }
    /**
     * <code>.PB_Request Request = 1;</code>
     */
    public Builder setRequest(
        ir.ms.pb.PB_Request.Builder builderForValue) {
      copyOnWrite();
      instance.setRequest(builderForValue);
      return this;
    }
    /**
     * <code>.PB_Request Request = 1;</code>
     */
    public Builder mergeRequest(ir.ms.pb.PB_Request value) {
      copyOnWrite();
      instance.mergeRequest(value);
      return this;
    }
    /**
     * <code>.PB_Request Request = 1;</code>
     */
    public Builder clearRequest() {  copyOnWrite();
      instance.clearRequest();
      return this;
    }

    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public java.util.List<ir.ms.pb.PB_MsgSeen> getSeenList() {
      return java.util.Collections.unmodifiableList(
          instance.getSeenList());
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public int getSeenCount() {
      return instance.getSeenCount();
    }/**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public ir.ms.pb.PB_MsgSeen getSeen(int index) {
      return instance.getSeen(index);
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder setSeen(
        int index, ir.ms.pb.PB_MsgSeen value) {
      copyOnWrite();
      instance.setSeen(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder setSeen(
        int index, ir.ms.pb.PB_MsgSeen.Builder builderForValue) {
      copyOnWrite();
      instance.setSeen(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder addSeen(ir.ms.pb.PB_MsgSeen value) {
      copyOnWrite();
      instance.addSeen(value);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder addSeen(
        int index, ir.ms.pb.PB_MsgSeen value) {
      copyOnWrite();
      instance.addSeen(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder addSeen(
        ir.ms.pb.PB_MsgSeen.Builder builderForValue) {
      copyOnWrite();
      instance.addSeen(builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder addSeen(
        int index, ir.ms.pb.PB_MsgSeen.Builder builderForValue) {
      copyOnWrite();
      instance.addSeen(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder addAllSeen(
        java.lang.Iterable<? extends ir.ms.pb.PB_MsgSeen> values) {
      copyOnWrite();
      instance.addAllSeen(values);
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder clearSeen() {
      copyOnWrite();
      instance.clearSeen();
      return this;
    }
    /**
     * <code>repeated .PB_MsgSeen Seen = 2;</code>
     */
    public Builder removeSeen(int index) {
      copyOnWrite();
      instance.removeSeen(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_RequestMsgsSeen)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_RequestMsgsSeen();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        seen_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_RequestMsgsSeen other = (ir.ms.pb.PB_RequestMsgsSeen) arg1;
        request_ = visitor.visitMessage(request_, other.request_);
        seen_= visitor.visitList(seen_, other.seen_);
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
              case 10: {
                ir.ms.pb.PB_Request.Builder subBuilder = null;
                if (request_ != null) {
                  subBuilder = request_.toBuilder();
                }
                request_ = input.readMessage(ir.ms.pb.PB_Request.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(request_);
                  request_ = subBuilder.buildPartial();
                }

                break;
              }
              case 18: {
                if (!seen_.isModifiable()) {
                  seen_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(seen_);
                }
                seen_.add(
                    input.readMessage(ir.ms.pb.PB_MsgSeen.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_RequestMsgsSeen.class) {
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


  // @@protoc_insertion_point(class_scope:PB_RequestMsgsSeen)
  private static final ir.ms.pb.PB_RequestMsgsSeen DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_RequestMsgsSeen();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_RequestMsgsSeen getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_RequestMsgsSeen> PARSER;

  public static com.google.protobuf.Parser<PB_RequestMsgsSeen> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

