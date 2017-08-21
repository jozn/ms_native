// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_del.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_PushMsgEvents}
 */
public  final class PB_PushMsgEvents extends
    com.google.protobuf.GeneratedMessageLite<
        PB_PushMsgEvents, PB_PushMsgEvents.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_PushMsgEvents)
    PB_PushMsgEventsOrBuilder {
  private PB_PushMsgEvents() {
    events_ = emptyProtobufList();
  }
  private int bitField0_;
  public static final int PUSH_FIELD_NUMBER = 1;
  private ir.ms.pb.PB_Push push_;
  /**
   * <code>.PB_Push Push = 1;</code>
   */
  public boolean hasPush() {
    return push_ != null;
  }
  /**
   * <code>.PB_Push Push = 1;</code>
   */
  public ir.ms.pb.PB_Push getPush() {
    return push_ == null ? ir.ms.pb.PB_Push.getDefaultInstance() : push_;
  }
  /**
   * <code>.PB_Push Push = 1;</code>
   */
  private void setPush(ir.ms.pb.PB_Push value) {
    if (value == null) {
      throw new NullPointerException();
    }
    push_ = value;
    
    }
  /**
   * <code>.PB_Push Push = 1;</code>
   */
  private void setPush(
      ir.ms.pb.PB_Push.Builder builderForValue) {
    push_ = builderForValue.build();
    
  }
  /**
   * <code>.PB_Push Push = 1;</code>
   */
  private void mergePush(ir.ms.pb.PB_Push value) {
    if (push_ != null &&
        push_ != ir.ms.pb.PB_Push.getDefaultInstance()) {
      push_ =
        ir.ms.pb.PB_Push.newBuilder(push_).mergeFrom(value).buildPartial();
    } else {
      push_ = value;
    }
    
  }
  /**
   * <code>.PB_Push Push = 1;</code>
   */
  private void clearPush() {  push_ = null;
    
  }

  public static final int EVENTS_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.PB_MsgEvent> events_;
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  public java.util.List<ir.ms.pb.PB_MsgEvent> getEventsList() {
    return events_;
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  public java.util.List<? extends ir.ms.pb.PB_MsgEventOrBuilder> 
      getEventsOrBuilderList() {
    return events_;
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  public int getEventsCount() {
    return events_.size();
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  public ir.ms.pb.PB_MsgEvent getEvents(int index) {
    return events_.get(index);
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  public ir.ms.pb.PB_MsgEventOrBuilder getEventsOrBuilder(
      int index) {
    return events_.get(index);
  }
  private void ensureEventsIsMutable() {
    if (!events_.isModifiable()) {
      events_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(events_);
     }
  }

  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void setEvents(
      int index, ir.ms.pb.PB_MsgEvent value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureEventsIsMutable();
    events_.set(index, value);
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void setEvents(
      int index, ir.ms.pb.PB_MsgEvent.Builder builderForValue) {
    ensureEventsIsMutable();
    events_.set(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void addEvents(ir.ms.pb.PB_MsgEvent value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureEventsIsMutable();
    events_.add(value);
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void addEvents(
      int index, ir.ms.pb.PB_MsgEvent value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureEventsIsMutable();
    events_.add(index, value);
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void addEvents(
      ir.ms.pb.PB_MsgEvent.Builder builderForValue) {
    ensureEventsIsMutable();
    events_.add(builderForValue.build());
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void addEvents(
      int index, ir.ms.pb.PB_MsgEvent.Builder builderForValue) {
    ensureEventsIsMutable();
    events_.add(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void addAllEvents(
      java.lang.Iterable<? extends ir.ms.pb.PB_MsgEvent> values) {
    ensureEventsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, events_);
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void clearEvents() {
    events_ = emptyProtobufList();
  }
  /**
   * <code>repeated .PB_MsgEvent Events = 2;</code>
   */
  private void removeEvents(int index) {
    ensureEventsIsMutable();
    events_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (push_ != null) {
      output.writeMessage(1, getPush());
    }
    for (int i = 0; i < events_.size(); i++) {
      output.writeMessage(2, events_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (push_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPush());
    }
    for (int i = 0; i < events_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, events_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_PushMsgEvents parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushMsgEvents parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_PushMsgEvents prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_PushMsgEvents}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_PushMsgEvents, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_PushMsgEvents)
      ir.ms.pb.PB_PushMsgEventsOrBuilder {
    // Construct using ir.ms.pb.PB_PushMsgEvents.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>.PB_Push Push = 1;</code>
     */
    public boolean hasPush() {
      return instance.hasPush();
    }
    /**
     * <code>.PB_Push Push = 1;</code>
     */
    public ir.ms.pb.PB_Push getPush() {
      return instance.getPush();
    }
    /**
     * <code>.PB_Push Push = 1;</code>
     */
    public Builder setPush(ir.ms.pb.PB_Push value) {
      copyOnWrite();
      instance.setPush(value);
      return this;
      }
    /**
     * <code>.PB_Push Push = 1;</code>
     */
    public Builder setPush(
        ir.ms.pb.PB_Push.Builder builderForValue) {
      copyOnWrite();
      instance.setPush(builderForValue);
      return this;
    }
    /**
     * <code>.PB_Push Push = 1;</code>
     */
    public Builder mergePush(ir.ms.pb.PB_Push value) {
      copyOnWrite();
      instance.mergePush(value);
      return this;
    }
    /**
     * <code>.PB_Push Push = 1;</code>
     */
    public Builder clearPush() {  copyOnWrite();
      instance.clearPush();
      return this;
    }

    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public java.util.List<ir.ms.pb.PB_MsgEvent> getEventsList() {
      return java.util.Collections.unmodifiableList(
          instance.getEventsList());
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public int getEventsCount() {
      return instance.getEventsCount();
    }/**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public ir.ms.pb.PB_MsgEvent getEvents(int index) {
      return instance.getEvents(index);
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder setEvents(
        int index, ir.ms.pb.PB_MsgEvent value) {
      copyOnWrite();
      instance.setEvents(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder setEvents(
        int index, ir.ms.pb.PB_MsgEvent.Builder builderForValue) {
      copyOnWrite();
      instance.setEvents(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder addEvents(ir.ms.pb.PB_MsgEvent value) {
      copyOnWrite();
      instance.addEvents(value);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder addEvents(
        int index, ir.ms.pb.PB_MsgEvent value) {
      copyOnWrite();
      instance.addEvents(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder addEvents(
        ir.ms.pb.PB_MsgEvent.Builder builderForValue) {
      copyOnWrite();
      instance.addEvents(builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder addEvents(
        int index, ir.ms.pb.PB_MsgEvent.Builder builderForValue) {
      copyOnWrite();
      instance.addEvents(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder addAllEvents(
        java.lang.Iterable<? extends ir.ms.pb.PB_MsgEvent> values) {
      copyOnWrite();
      instance.addAllEvents(values);
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder clearEvents() {
      copyOnWrite();
      instance.clearEvents();
      return this;
    }
    /**
     * <code>repeated .PB_MsgEvent Events = 2;</code>
     */
    public Builder removeEvents(int index) {
      copyOnWrite();
      instance.removeEvents(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_PushMsgEvents)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_PushMsgEvents();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        events_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_PushMsgEvents other = (ir.ms.pb.PB_PushMsgEvents) arg1;
        push_ = visitor.visitMessage(push_, other.push_);
        events_= visitor.visitList(events_, other.events_);
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
                ir.ms.pb.PB_Push.Builder subBuilder = null;
                if (push_ != null) {
                  subBuilder = push_.toBuilder();
                }
                push_ = input.readMessage(ir.ms.pb.PB_Push.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(push_);
                  push_ = subBuilder.buildPartial();
                }

                break;
              }
              case 18: {
                if (!events_.isModifiable()) {
                  events_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(events_);
                }
                events_.add(
                    input.readMessage(ir.ms.pb.PB_MsgEvent.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_PushMsgEvents.class) {
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


  // @@protoc_insertion_point(class_scope:PB_PushMsgEvents)
  private static final ir.ms.pb.PB_PushMsgEvents DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_PushMsgEvents();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_PushMsgEvents getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_PushMsgEvents> PARSER;

  public static com.google.protobuf.Parser<PB_PushMsgEvents> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

