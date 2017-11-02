// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_sync.proto

package ir.ms.pb;

/**
 * <pre>
 *&#47;//////// Pushes /////////////
 *use this for pushing live data - instead of hacking rpc *yResponse* types
 * </pre>
 *
 * Protobuf type {@code PB_AllLivePushes}
 */
public  final class PB_AllLivePushes extends
    com.google.protobuf.GeneratedMessageLite<
        PB_AllLivePushes, PB_AllLivePushes.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_AllLivePushes)
    PB_AllLivePushesOrBuilder {
  private PB_AllLivePushes() {
  }
  public static final int GENERALUPDATES_FIELD_NUMBER = 2;
  private ir.ms.pb.PB_SyncResponse_GetGeneralUpdates generalUpdates_;
  /**
   * <pre>
   *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
   * </pre>
   *
   * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
   */
  public boolean hasGeneralUpdates() {
    return generalUpdates_ != null;
  }
  /**
   * <pre>
   *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
   * </pre>
   *
   * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
   */
  public ir.ms.pb.PB_SyncResponse_GetGeneralUpdates getGeneralUpdates() {
    return generalUpdates_ == null ? ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.getDefaultInstance() : generalUpdates_;
  }
  /**
   * <pre>
   *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
   * </pre>
   *
   * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
   */
  private void setGeneralUpdates(ir.ms.pb.PB_SyncResponse_GetGeneralUpdates value) {
    if (value == null) {
      throw new NullPointerException();
    }
    generalUpdates_ = value;
    
    }
  /**
   * <pre>
   *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
   * </pre>
   *
   * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
   */
  private void setGeneralUpdates(
      ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.Builder builderForValue) {
    generalUpdates_ = builderForValue.build();
    
  }
  /**
   * <pre>
   *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
   * </pre>
   *
   * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
   */
  private void mergeGeneralUpdates(ir.ms.pb.PB_SyncResponse_GetGeneralUpdates value) {
    if (generalUpdates_ != null &&
        generalUpdates_ != ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.getDefaultInstance()) {
      generalUpdates_ =
        ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.newBuilder(generalUpdates_).mergeFrom(value).buildPartial();
    } else {
      generalUpdates_ = value;
    }
    
  }
  /**
   * <pre>
   *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
   * </pre>
   *
   * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
   */
  private void clearGeneralUpdates() {  generalUpdates_ = null;
    
  }

  public static final int OFFLINE_MESSAGINGS_FIELD_NUMBER = 3;
  private ir.ms.pb.PB_Offline_Messagings offlineMessagings_;
  /**
   * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
   */
  public boolean hasOfflineMessagings() {
    return offlineMessagings_ != null;
  }
  /**
   * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
   */
  public ir.ms.pb.PB_Offline_Messagings getOfflineMessagings() {
    return offlineMessagings_ == null ? ir.ms.pb.PB_Offline_Messagings.getDefaultInstance() : offlineMessagings_;
  }
  /**
   * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
   */
  private void setOfflineMessagings(ir.ms.pb.PB_Offline_Messagings value) {
    if (value == null) {
      throw new NullPointerException();
    }
    offlineMessagings_ = value;
    
    }
  /**
   * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
   */
  private void setOfflineMessagings(
      ir.ms.pb.PB_Offline_Messagings.Builder builderForValue) {
    offlineMessagings_ = builderForValue.build();
    
  }
  /**
   * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
   */
  private void mergeOfflineMessagings(ir.ms.pb.PB_Offline_Messagings value) {
    if (offlineMessagings_ != null &&
        offlineMessagings_ != ir.ms.pb.PB_Offline_Messagings.getDefaultInstance()) {
      offlineMessagings_ =
        ir.ms.pb.PB_Offline_Messagings.newBuilder(offlineMessagings_).mergeFrom(value).buildPartial();
    } else {
      offlineMessagings_ = value;
    }
    
  }
  /**
   * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
   */
  private void clearOfflineMessagings() {  offlineMessagings_ = null;
    
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (generalUpdates_ != null) {
      output.writeMessage(2, getGeneralUpdates());
    }
    if (offlineMessagings_ != null) {
      output.writeMessage(3, getOfflineMessagings());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (generalUpdates_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getGeneralUpdates());
    }
    if (offlineMessagings_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getOfflineMessagings());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_AllLivePushes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_AllLivePushes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_AllLivePushes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_AllLivePushes parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_AllLivePushes prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   *&#47;//////// Pushes /////////////
   *use this for pushing live data - instead of hacking rpc *yResponse* types
   * </pre>
   *
   * Protobuf type {@code PB_AllLivePushes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_AllLivePushes, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_AllLivePushes)
      ir.ms.pb.PB_AllLivePushesOrBuilder {
    // Construct using ir.ms.pb.PB_AllLivePushes.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
     * </pre>
     *
     * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
     */
    public boolean hasGeneralUpdates() {
      return instance.hasGeneralUpdates();
    }
    /**
     * <pre>
     *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
     * </pre>
     *
     * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
     */
    public ir.ms.pb.PB_SyncResponse_GetGeneralUpdates getGeneralUpdates() {
      return instance.getGeneralUpdates();
    }
    /**
     * <pre>
     *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
     * </pre>
     *
     * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
     */
    public Builder setGeneralUpdates(ir.ms.pb.PB_SyncResponse_GetGeneralUpdates value) {
      copyOnWrite();
      instance.setGeneralUpdates(value);
      return this;
      }
    /**
     * <pre>
     *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
     * </pre>
     *
     * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
     */
    public Builder setGeneralUpdates(
        ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.Builder builderForValue) {
      copyOnWrite();
      instance.setGeneralUpdates(builderForValue);
      return this;
    }
    /**
     * <pre>
     *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
     * </pre>
     *
     * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
     */
    public Builder mergeGeneralUpdates(ir.ms.pb.PB_SyncResponse_GetGeneralUpdates value) {
      copyOnWrite();
      instance.mergeGeneralUpdates(value);
      return this;
    }
    /**
     * <pre>
     *    PB_SyncResponse_GetDirectUpdates DirectUpdates = 1;
     * </pre>
     *
     * <code>.PB_SyncResponse_GetGeneralUpdates GeneralUpdates = 2;</code>
     */
    public Builder clearGeneralUpdates() {  copyOnWrite();
      instance.clearGeneralUpdates();
      return this;
    }

    /**
     * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
     */
    public boolean hasOfflineMessagings() {
      return instance.hasOfflineMessagings();
    }
    /**
     * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
     */
    public ir.ms.pb.PB_Offline_Messagings getOfflineMessagings() {
      return instance.getOfflineMessagings();
    }
    /**
     * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
     */
    public Builder setOfflineMessagings(ir.ms.pb.PB_Offline_Messagings value) {
      copyOnWrite();
      instance.setOfflineMessagings(value);
      return this;
      }
    /**
     * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
     */
    public Builder setOfflineMessagings(
        ir.ms.pb.PB_Offline_Messagings.Builder builderForValue) {
      copyOnWrite();
      instance.setOfflineMessagings(builderForValue);
      return this;
    }
    /**
     * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
     */
    public Builder mergeOfflineMessagings(ir.ms.pb.PB_Offline_Messagings value) {
      copyOnWrite();
      instance.mergeOfflineMessagings(value);
      return this;
    }
    /**
     * <code>.PB_Offline_Messagings Offline_Messagings = 3;</code>
     */
    public Builder clearOfflineMessagings() {  copyOnWrite();
      instance.clearOfflineMessagings();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_AllLivePushes)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_AllLivePushes();
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
        ir.ms.pb.PB_AllLivePushes other = (ir.ms.pb.PB_AllLivePushes) arg1;
        generalUpdates_ = visitor.visitMessage(generalUpdates_, other.generalUpdates_);
        offlineMessagings_ = visitor.visitMessage(offlineMessagings_, other.offlineMessagings_);
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
              case 18: {
                ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.Builder subBuilder = null;
                if (generalUpdates_ != null) {
                  subBuilder = generalUpdates_.toBuilder();
                }
                generalUpdates_ = input.readMessage(ir.ms.pb.PB_SyncResponse_GetGeneralUpdates.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(generalUpdates_);
                  generalUpdates_ = subBuilder.buildPartial();
                }

                break;
              }
              case 26: {
                ir.ms.pb.PB_Offline_Messagings.Builder subBuilder = null;
                if (offlineMessagings_ != null) {
                  subBuilder = offlineMessagings_.toBuilder();
                }
                offlineMessagings_ = input.readMessage(ir.ms.pb.PB_Offline_Messagings.parser(), extensionRegistry);
                if (subBuilder != null) {
                  subBuilder.mergeFrom(offlineMessagings_);
                  offlineMessagings_ = subBuilder.buildPartial();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_AllLivePushes.class) {
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


  // @@protoc_insertion_point(class_scope:PB_AllLivePushes)
  private static final ir.ms.pb.PB_AllLivePushes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_AllLivePushes();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_AllLivePushes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_AllLivePushes> PARSER;

  public static com.google.protobuf.Parser<PB_AllLivePushes> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

