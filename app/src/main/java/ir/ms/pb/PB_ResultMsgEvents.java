// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_del.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_ResultMsgEvents}
 */
public  final class PB_ResultMsgEvents extends
    com.google.protobuf.GeneratedMessageLite<
        PB_ResultMsgEvents, PB_ResultMsgEvents.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_ResultMsgEvents)
    PB_ResultMsgEventsOrBuilder {
  private PB_ResultMsgEvents() {
  }
  public static final int RESULT_FIELD_NUMBER = 1;
  private ir.ms.pb.PB_Result result_;
  /**
   * <code>.PB_Result Result = 1;</code>
   */
  public boolean hasResult() {
    return result_ != null;
  }
  /**
   * <code>.PB_Result Result = 1;</code>
   */
  public ir.ms.pb.PB_Result getResult() {
    return result_ == null ? ir.ms.pb.PB_Result.getDefaultInstance() : result_;
  }
  /**
   * <code>.PB_Result Result = 1;</code>
   */
  private void setResult(ir.ms.pb.PB_Result value) {
    if (value == null) {
      throw new NullPointerException();
    }
    result_ = value;
    
    }
  /**
   * <code>.PB_Result Result = 1;</code>
   */
  private void setResult(
      ir.ms.pb.PB_Result.Builder builderForValue) {
    result_ = builderForValue.build();
    
  }
  /**
   * <code>.PB_Result Result = 1;</code>
   */
  private void mergeResult(ir.ms.pb.PB_Result value) {
    if (result_ != null &&
        result_ != ir.ms.pb.PB_Result.getDefaultInstance()) {
      result_ =
        ir.ms.pb.PB_Result.newBuilder(result_).mergeFrom(value).buildPartial();
    } else {
      result_ = value;
    }
    
  }
  /**
   * <code>.PB_Result Result = 1;</code>
   */
  private void clearResult() {  result_ = null;
    
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (result_ != null) {
      output.writeMessage(1, getResult());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (result_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getResult());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_ResultMsgEvents parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_ResultMsgEvents prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_ResultMsgEvents}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_ResultMsgEvents, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_ResultMsgEvents)
      ir.ms.pb.PB_ResultMsgEventsOrBuilder {
    // Construct using ir.ms.pb.PB_ResultMsgEvents.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>.PB_Result Result = 1;</code>
     */
    public boolean hasResult() {
      return instance.hasResult();
    }
    /**
     * <code>.PB_Result Result = 1;</code>
     */
    public ir.ms.pb.PB_Result getResult() {
      return instance.getResult();
    }
    /**
     * <code>.PB_Result Result = 1;</code>
     */
    public Builder setResult(ir.ms.pb.PB_Result value) {
      copyOnWrite();
      instance.setResult(value);
      return this;
      }
    /**
     * <code>.PB_Result Result = 1;</code>
     */
    public Builder setResult(
        ir.ms.pb.PB_Result.Builder builderForValue) {
      copyOnWrite();
      instance.setResult(builderForValue);
      return this;
    }
    /**
     * <code>.PB_Result Result = 1;</code>
     */
    public Builder mergeResult(ir.ms.pb.PB_Result value) {
      copyOnWrite();
      instance.mergeResult(value);
      return this;
    }
    /**
     * <code>.PB_Result Result = 1;</code>
     */
    public Builder clearResult() {  copyOnWrite();
      instance.clearResult();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_ResultMsgEvents)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_ResultMsgEvents();
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
        ir.ms.pb.PB_ResultMsgEvents other = (ir.ms.pb.PB_ResultMsgEvents) arg1;
        result_ = visitor.visitMessage(result_, other.result_);
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
                ir.ms.pb.PB_Result.Builder subBuilder = null;
                if (result_ != null) {
                  subBuilder = result_.toBuilder();
                }
                result_ = input.readMessage(ir.ms.pb.PB_Result.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(result_);
                  result_ = subBuilder.buildPartial();
                }

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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_ResultMsgEvents.class) {
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


  // @@protoc_insertion_point(class_scope:PB_ResultMsgEvents)
  private static final ir.ms.pb.PB_ResultMsgEvents DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_ResultMsgEvents();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_ResultMsgEvents getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_ResultMsgEvents> PARSER;

  public static com.google.protobuf.Parser<PB_ResultMsgEvents> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

