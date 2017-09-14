// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_chat.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_PushDirectLogViewsMany}
 */
public  final class PB_PushDirectLogViewsMany extends
    com.google.protobuf.GeneratedMessageLite<
        PB_PushDirectLogViewsMany, PB_PushDirectLogViewsMany.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_PushDirectLogViewsMany)
    PB_PushDirectLogViewsManyOrBuilder {
  private PB_PushDirectLogViewsMany() {
    rows_ = emptyProtobufList();
  }
  public static final int ROWS_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.ProtobufList<ir.ms.pb.PB_DirectLogView> rows_;
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  public java.util.List<ir.ms.pb.PB_DirectLogView> getRowsList() {
    return rows_;
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  public java.util.List<? extends ir.ms.pb.PB_DirectLogViewOrBuilder> 
      getRowsOrBuilderList() {
    return rows_;
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  public int getRowsCount() {
    return rows_.size();
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  public ir.ms.pb.PB_DirectLogView getRows(int index) {
    return rows_.get(index);
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  public ir.ms.pb.PB_DirectLogViewOrBuilder getRowsOrBuilder(
      int index) {
    return rows_.get(index);
  }
  private void ensureRowsIsMutable() {
    if (!rows_.isModifiable()) {
      rows_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(rows_);
     }
  }

  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void setRows(
      int index, ir.ms.pb.PB_DirectLogView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureRowsIsMutable();
    rows_.set(index, value);
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void setRows(
      int index, ir.ms.pb.PB_DirectLogView.Builder builderForValue) {
    ensureRowsIsMutable();
    rows_.set(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void addRows(ir.ms.pb.PB_DirectLogView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureRowsIsMutable();
    rows_.add(value);
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void addRows(
      int index, ir.ms.pb.PB_DirectLogView value) {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureRowsIsMutable();
    rows_.add(index, value);
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void addRows(
      ir.ms.pb.PB_DirectLogView.Builder builderForValue) {
    ensureRowsIsMutable();
    rows_.add(builderForValue.build());
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void addRows(
      int index, ir.ms.pb.PB_DirectLogView.Builder builderForValue) {
    ensureRowsIsMutable();
    rows_.add(index, builderForValue.build());
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void addAllRows(
      java.lang.Iterable<? extends ir.ms.pb.PB_DirectLogView> values) {
    ensureRowsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, rows_);
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void clearRows() {
    rows_ = emptyProtobufList();
  }
  /**
   * <code>repeated .PB_DirectLogView Rows = 1;</code>
   */
  private void removeRows(int index) {
    ensureRowsIsMutable();
    rows_.remove(index);
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < rows_.size(); i++) {
      output.writeMessage(1, rows_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < rows_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, rows_.get(i));
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_PushDirectLogViewsMany parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_PushDirectLogViewsMany prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_PushDirectLogViewsMany}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_PushDirectLogViewsMany, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_PushDirectLogViewsMany)
      ir.ms.pb.PB_PushDirectLogViewsManyOrBuilder {
    // Construct using ir.ms.pb.PB_PushDirectLogViewsMany.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public java.util.List<ir.ms.pb.PB_DirectLogView> getRowsList() {
      return java.util.Collections.unmodifiableList(
          instance.getRowsList());
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public int getRowsCount() {
      return instance.getRowsCount();
    }/**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public ir.ms.pb.PB_DirectLogView getRows(int index) {
      return instance.getRows(index);
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder setRows(
        int index, ir.ms.pb.PB_DirectLogView value) {
      copyOnWrite();
      instance.setRows(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder setRows(
        int index, ir.ms.pb.PB_DirectLogView.Builder builderForValue) {
      copyOnWrite();
      instance.setRows(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder addRows(ir.ms.pb.PB_DirectLogView value) {
      copyOnWrite();
      instance.addRows(value);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder addRows(
        int index, ir.ms.pb.PB_DirectLogView value) {
      copyOnWrite();
      instance.addRows(index, value);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder addRows(
        ir.ms.pb.PB_DirectLogView.Builder builderForValue) {
      copyOnWrite();
      instance.addRows(builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder addRows(
        int index, ir.ms.pb.PB_DirectLogView.Builder builderForValue) {
      copyOnWrite();
      instance.addRows(index, builderForValue);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder addAllRows(
        java.lang.Iterable<? extends ir.ms.pb.PB_DirectLogView> values) {
      copyOnWrite();
      instance.addAllRows(values);
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder clearRows() {
      copyOnWrite();
      instance.clearRows();
      return this;
    }
    /**
     * <code>repeated .PB_DirectLogView Rows = 1;</code>
     */
    public Builder removeRows(int index) {
      copyOnWrite();
      instance.removeRows(index);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_PushDirectLogViewsMany)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_PushDirectLogViewsMany();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        rows_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_PushDirectLogViewsMany other = (ir.ms.pb.PB_PushDirectLogViewsMany) arg1;
        rows_= visitor.visitList(rows_, other.rows_);
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
                if (!rows_.isModifiable()) {
                  rows_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(rows_);
                }
                rows_.add(
                    input.readMessage(ir.ms.pb.PB_DirectLogView.parser(), extensionRegistry));
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_PushDirectLogViewsMany.class) {
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


  // @@protoc_insertion_point(class_scope:PB_PushDirectLogViewsMany)
  private static final ir.ms.pb.PB_PushDirectLogViewsMany DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_PushDirectLogViewsMany();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_PushDirectLogViewsMany getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_PushDirectLogViewsMany> PARSER;

  public static com.google.protobuf.Parser<PB_PushDirectLogViewsMany> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

