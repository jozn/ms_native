// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_MsgResponse_GetMessagesHistory}
 */
public  final class PB_MsgResponse_GetMessagesHistory extends
    com.google.protobuf.GeneratedMessageLite<
        PB_MsgResponse_GetMessagesHistory, PB_MsgResponse_GetMessagesHistory.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_MsgResponse_GetMessagesHistory)
    PB_MsgResponse_GetMessagesHistoryOrBuilder {
  private PB_MsgResponse_GetMessagesHistory() {
    messagesViews_ = emptyProtobufList();
  }
  public static final int MESSAGESVIEWS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.PB_MessageView> messagesViews_;
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  public java.util.List<ir.ms.pb.PB_MessageView> getMessagesViewsList() {
    return messagesViews_;
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  public java.util.List<? extends ir.ms.pb.PB_MessageViewOrBuilder> 
      getMessagesViewsOrBuilderList() {
    return messagesViews_;
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  public int getMessagesViewsCount() {
    return messagesViews_.size();
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  public ir.ms.pb.PB_MessageView getMessagesViews(int index) {
    return messagesViews_.get(index);
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  public ir.ms.pb.PB_MessageViewOrBuilder getMessagesViewsOrBuilder(
      int index) {
    return messagesViews_.get(index);
  }
  private void ensureMessagesViewsIsMutable() {
    if (!messagesViews_.isModifiable()) {
      messagesViews_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(messagesViews_);
     }
  }

  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void setMessagesViews(
      int index, ir.ms.pb.PB_MessageView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureMessagesViewsIsMutable();
    messagesViews_.set(index, value);
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void setMessagesViews(
      int index, ir.ms.pb.PB_MessageView.Builder builderForValue) {
    ensureMessagesViewsIsMutable();
    messagesViews_.set(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void addMessagesViews(ir.ms.pb.PB_MessageView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureMessagesViewsIsMutable();
    messagesViews_.add(value);
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void addMessagesViews(
      int index, ir.ms.pb.PB_MessageView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureMessagesViewsIsMutable();
    messagesViews_.add(index, value);
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void addMessagesViews(
      ir.ms.pb.PB_MessageView.Builder builderForValue) {
    ensureMessagesViewsIsMutable();
    messagesViews_.add(builderForValue.build());
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void addMessagesViews(
      int index, ir.ms.pb.PB_MessageView.Builder builderForValue) {
    ensureMessagesViewsIsMutable();
    messagesViews_.add(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void addAllMessagesViews(
      java.lang.Iterable<? extends ir.ms.pb.PB_MessageView> values) {
    ensureMessagesViewsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, messagesViews_);
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void clearMessagesViews() {
    messagesViews_ = emptyProtobufList();
  }
  /**
   * <code>repeated .PB_MessageView MessagesViews = 1;</code>
   */
  private void removeMessagesViews(int index) {
    ensureMessagesViewsIsMutable();
    messagesViews_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < messagesViews_.size(); i++) {
      output.writeMessage(1, messagesViews_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < messagesViews_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, messagesViews_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_MsgResponse_GetMessagesHistory prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_MsgResponse_GetMessagesHistory}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_MsgResponse_GetMessagesHistory, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_MsgResponse_GetMessagesHistory)
      ir.ms.pb.PB_MsgResponse_GetMessagesHistoryOrBuilder {
    // Construct using ir.ms.pb.PB_MsgResponse_GetMessagesHistory.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public java.util.List<ir.ms.pb.PB_MessageView> getMessagesViewsList() {
      return java.util.Collections.unmodifiableList(
          instance.getMessagesViewsList());
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public int getMessagesViewsCount() {
      return instance.getMessagesViewsCount();
    }/**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public ir.ms.pb.PB_MessageView getMessagesViews(int index) {
      return instance.getMessagesViews(index);
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder setMessagesViews(
        int index, ir.ms.pb.PB_MessageView value) {
      copyOnWrite();
      instance.setMessagesViews(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder setMessagesViews(
        int index, ir.ms.pb.PB_MessageView.Builder builderForValue) {
      copyOnWrite();
      instance.setMessagesViews(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder addMessagesViews(ir.ms.pb.PB_MessageView value) {
      copyOnWrite();
      instance.addMessagesViews(value);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder addMessagesViews(
        int index, ir.ms.pb.PB_MessageView value) {
      copyOnWrite();
      instance.addMessagesViews(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder addMessagesViews(
        ir.ms.pb.PB_MessageView.Builder builderForValue) {
      copyOnWrite();
      instance.addMessagesViews(builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder addMessagesViews(
        int index, ir.ms.pb.PB_MessageView.Builder builderForValue) {
      copyOnWrite();
      instance.addMessagesViews(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder addAllMessagesViews(
        java.lang.Iterable<? extends ir.ms.pb.PB_MessageView> values) {
      copyOnWrite();
      instance.addAllMessagesViews(values);
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder clearMessagesViews() {
      copyOnWrite();
      instance.clearMessagesViews();
      return this;
    }
    /**
     * <code>repeated .PB_MessageView MessagesViews = 1;</code>
     */
    public Builder removeMessagesViews(int index) {
      copyOnWrite();
      instance.removeMessagesViews(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MsgResponse_GetMessagesHistory)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_MsgResponse_GetMessagesHistory();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        messagesViews_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_MsgResponse_GetMessagesHistory other = (ir.ms.pb.PB_MsgResponse_GetMessagesHistory) arg1;
        messagesViews_= visitor.visitList(messagesViews_, other.messagesViews_);
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
                if (!messagesViews_.isModifiable()) {
                  messagesViews_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(messagesViews_);
                }
                messagesViews_.add(
                    input.readMessage(ir.ms.pb.PB_MessageView.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_MsgResponse_GetMessagesHistory.class) {
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


  // @@protoc_insertion_point(class_scope:PB_MsgResponse_GetMessagesHistory)
  private static final ir.ms.pb.PB_MsgResponse_GetMessagesHistory DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_MsgResponse_GetMessagesHistory();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MsgResponse_GetMessagesHistory getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MsgResponse_GetMessagesHistory> PARSER;

  public static com.google.protobuf.Parser<PB_MsgResponse_GetMessagesHistory> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

