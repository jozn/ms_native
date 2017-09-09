// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_msg.proto

package ir.ms.pb;

/**
 *
 *
 * <pre>
 * AddNewTextMessage
 * </pre>
 *
 * Protobuf type {@code PB_MsgParam_AddNewTextMessage}
 */
public final class PB_MsgParam_AddNewTextMessage
    extends com.google.protobuf.GeneratedMessageLite<
        PB_MsgParam_AddNewTextMessage, PB_MsgParam_AddNewTextMessage.Builder>
    implements
    // @@protoc_insertion_point(message_implements:PB_MsgParam_AddNewTextMessage)
    PB_MsgParam_AddNewTextMessageOrBuilder {
  private PB_MsgParam_AddNewTextMessage() {
    text_ = "";
  }

  public static final int TEXT_FIELD_NUMBER = 1;
  private java.lang.String text_;
  /** <code>string Text = 1;</code> */
  public java.lang.String getText() {
    return text_;
  }
  /** <code>string Text = 1;</code> */
  public com.google.protobuf.ByteString getTextBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(text_);
  }
  /** <code>string Text = 1;</code> */
  private void setText(java.lang.String value) {
    if (value == null) {
      throw new NullPointerException();
    }

    text_ = value;
  }
  /** <code>string Text = 1;</code> */
  private void clearText() {

    text_ = getDefaultInstance().getText();
  }
  /** <code>string Text = 1;</code> */
  private void setTextBytes(com.google.protobuf.ByteString value) {
    if (value == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(value);

    text_ = value.toStringUtf8();
  }

  public static final int PEERID_FIELD_NUMBER = 5;
  private int peerId_;
  /** <code>int32 PeerId = 5;</code> */
  public int getPeerId() {
    return peerId_;
  }
  /** <code>int32 PeerId = 5;</code> */
  private void setPeerId(int value) {

    peerId_ = value;
  }
  /** <code>int32 PeerId = 5;</code> */
  private void clearPeerId() {

    peerId_ = 0;
  }

  public static final int TIME_FIELD_NUMBER = 6;
  private int time_;
  /** <code>int32 Time = 6;</code> */
  public int getTime() {
    return time_;
  }
  /** <code>int32 Time = 6;</code> */
  private void setTime(int value) {

    time_ = value;
  }
  /** <code>int32 Time = 6;</code> */
  private void clearTime() {

    time_ = 0;
  }

  public static final int REPLYTOMESSAGEID_FIELD_NUMBER = 10;
  private long replyToMessageId_;
  /** <code>int64 ReplyToMessageId = 10;</code> */
  public long getReplyToMessageId() {
    return replyToMessageId_;
  }
  /** <code>int64 ReplyToMessageId = 10;</code> */
  private void setReplyToMessageId(long value) {

    replyToMessageId_ = value;
  }
  /** <code>int64 ReplyToMessageId = 10;</code> */
  private void clearReplyToMessageId() {

    replyToMessageId_ = 0L;
  }

  public static final int FORWARD_FIELD_NUMBER = 14;
  private ir.ms.pb.PB_MessageForwardedFrom forward_;
  /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
  public boolean hasForward() {
    return forward_ != null;
  }
  /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
  public ir.ms.pb.PB_MessageForwardedFrom getForward() {
    return forward_ == null ? ir.ms.pb.PB_MessageForwardedFrom.getDefaultInstance() : forward_;
  }
  /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
  private void setForward(ir.ms.pb.PB_MessageForwardedFrom value) {
    if (value == null) {
      throw new NullPointerException();
    }
    forward_ = value;
  }
  /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
  private void setForward(ir.ms.pb.PB_MessageForwardedFrom.Builder builderForValue) {
    forward_ = builderForValue.build();
  }
  /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
  private void mergeForward(ir.ms.pb.PB_MessageForwardedFrom value) {
    if (forward_ != null && forward_ != ir.ms.pb.PB_MessageForwardedFrom.getDefaultInstance()) {
      forward_ =
          ir.ms.pb.PB_MessageForwardedFrom.newBuilder(forward_).mergeFrom(value).buildPartial();
    } else {
      forward_ = value;
    }
  }
  /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
  private void clearForward() {
    forward_ = null;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!text_.isEmpty()) {
      output.writeString(1, getText());
    }
    if (peerId_ != 0) {
      output.writeInt32(5, peerId_);
    }
    if (time_ != 0) {
      output.writeInt32(6, time_);
    }
    if (replyToMessageId_ != 0L) {
      output.writeInt64(10, replyToMessageId_);
    }
    if (forward_ != null) {
      output.writeMessage(14, getForward());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!text_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeStringSize(1, getText());
    }
    if (peerId_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(5, peerId_);
    }
    if (time_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(6, time_);
    }
    if (replyToMessageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(10, replyToMessageId_);
    }
    if (forward_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(14, getForward());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ir.ms.pb.PB_MsgParam_AddNewTextMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   *
   *
   * <pre>
   * AddNewTextMessage
   * </pre>
   *
   * Protobuf type {@code PB_MsgParam_AddNewTextMessage}
   */
  public static final class Builder
      extends com.google.protobuf.GeneratedMessageLite.Builder<
          ir.ms.pb.PB_MsgParam_AddNewTextMessage, Builder>
      implements
      // @@protoc_insertion_point(builder_implements:PB_MsgParam_AddNewTextMessage)
      ir.ms.pb.PB_MsgParam_AddNewTextMessageOrBuilder {
    // Construct using ir.ms.pb.PB_MsgParam_AddNewTextMessage.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }

    /** <code>string Text = 1;</code> */
    public java.lang.String getText() {
      return instance.getText();
    }
    /** <code>string Text = 1;</code> */
    public com.google.protobuf.ByteString getTextBytes() {
      return instance.getTextBytes();
    }
    /** <code>string Text = 1;</code> */
    public Builder setText(java.lang.String value) {
      copyOnWrite();
      instance.setText(value);
      return this;
    }
    /** <code>string Text = 1;</code> */
    public Builder clearText() {
      copyOnWrite();
      instance.clearText();
      return this;
    }
    /** <code>string Text = 1;</code> */
    public Builder setTextBytes(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setTextBytes(value);
      return this;
    }

    /** <code>int32 PeerId = 5;</code> */
    public int getPeerId() {
      return instance.getPeerId();
    }
    /** <code>int32 PeerId = 5;</code> */
    public Builder setPeerId(int value) {
      copyOnWrite();
      instance.setPeerId(value);
      return this;
    }
    /** <code>int32 PeerId = 5;</code> */
    public Builder clearPeerId() {
      copyOnWrite();
      instance.clearPeerId();
      return this;
    }

    /** <code>int32 Time = 6;</code> */
    public int getTime() {
      return instance.getTime();
    }
    /** <code>int32 Time = 6;</code> */
    public Builder setTime(int value) {
      copyOnWrite();
      instance.setTime(value);
      return this;
    }
    /** <code>int32 Time = 6;</code> */
    public Builder clearTime() {
      copyOnWrite();
      instance.clearTime();
      return this;
    }

    /** <code>int64 ReplyToMessageId = 10;</code> */
    public long getReplyToMessageId() {
      return instance.getReplyToMessageId();
    }
    /** <code>int64 ReplyToMessageId = 10;</code> */
    public Builder setReplyToMessageId(long value) {
      copyOnWrite();
      instance.setReplyToMessageId(value);
      return this;
    }
    /** <code>int64 ReplyToMessageId = 10;</code> */
    public Builder clearReplyToMessageId() {
      copyOnWrite();
      instance.clearReplyToMessageId();
      return this;
    }

    /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
    public boolean hasForward() {
      return instance.hasForward();
    }
    /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
    public ir.ms.pb.PB_MessageForwardedFrom getForward() {
      return instance.getForward();
    }
    /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
    public Builder setForward(ir.ms.pb.PB_MessageForwardedFrom value) {
      copyOnWrite();
      instance.setForward(value);
      return this;
    }
    /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
    public Builder setForward(ir.ms.pb.PB_MessageForwardedFrom.Builder builderForValue) {
      copyOnWrite();
      instance.setForward(builderForValue);
      return this;
    }
    /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
    public Builder mergeForward(ir.ms.pb.PB_MessageForwardedFrom value) {
      copyOnWrite();
      instance.mergeForward(value);
      return this;
    }
    /** <code>.PB_MessageForwardedFrom Forward = 14;</code> */
    public Builder clearForward() {
      copyOnWrite();
      instance.clearForward();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_MsgParam_AddNewTextMessage)
  }

  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE:
        {
          return new ir.ms.pb.PB_MsgParam_AddNewTextMessage();
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
          ir.ms.pb.PB_MsgParam_AddNewTextMessage other =
              (ir.ms.pb.PB_MsgParam_AddNewTextMessage) arg1;
          text_ = visitor.visitString(!text_.isEmpty(), text_, !other.text_.isEmpty(), other.text_);
          peerId_ = visitor.visitInt(peerId_ != 0, peerId_, other.peerId_ != 0, other.peerId_);
          time_ = visitor.visitInt(time_ != 0, time_, other.time_ != 0, other.time_);
          replyToMessageId_ =
              visitor.visitLong(
                  replyToMessageId_ != 0L,
                  replyToMessageId_,
                  other.replyToMessageId_ != 0L,
                  other.replyToMessageId_);
          forward_ = visitor.visitMessage(forward_, other.forward_);
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
                case 10:
                  {
                    String s = input.readStringRequireUtf8();

                    text_ = s;
                    break;
                  }
                case 40:
                  {
                    peerId_ = input.readInt32();
                    break;
                  }
                case 48:
                  {
                    time_ = input.readInt32();
                    break;
                  }
                case 80:
                  {
                    replyToMessageId_ = input.readInt64();
                    break;
                  }
                case 114:
                  {
                    ir.ms.pb.PB_MessageForwardedFrom.Builder subBuilder = null;
                    if (forward_ != null) {
                      subBuilder = forward_.toBuilder();
                    }
                    forward_ =
                        input.readMessage(
                            ir.ms.pb.PB_MessageForwardedFrom.parser(), extensionRegistry);
                    if (subBuilder != null) {
                      subBuilder.mergeFrom(forward_);
                      forward_ = subBuilder.buildPartial();
                    }

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
            synchronized (ir.ms.pb.PB_MsgParam_AddNewTextMessage.class) {
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

  // @@protoc_insertion_point(class_scope:PB_MsgParam_AddNewTextMessage)
  private static final ir.ms.pb.PB_MsgParam_AddNewTextMessage DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PB_MsgParam_AddNewTextMessage();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_MsgParam_AddNewTextMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_MsgParam_AddNewTextMessage> PARSER;

  public static com.google.protobuf.Parser<PB_MsgParam_AddNewTextMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
