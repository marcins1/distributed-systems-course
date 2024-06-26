// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fridge.proto

// Protobuf Java Version: 4.26.1
package grpc.fridge;

/**
 * Protobuf type {@code fridge.FridgeInfoResponse}
 */
public final class FridgeInfoResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:fridge.FridgeInfoResponse)
    FridgeInfoResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      FridgeInfoResponse.class.getName());
  }
  // Use FridgeInfoResponse.newBuilder() to construct.
  private FridgeInfoResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private FridgeInfoResponse() {
    id_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.fridge.FridgeProto.internal_static_fridge_FridgeInfoResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.fridge.FridgeProto.internal_static_fridge_FridgeInfoResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.fridge.FridgeInfoResponse.class, grpc.fridge.FridgeInfoResponse.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object id_ = "";
  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FREEZERON_FIELD_NUMBER = 2;
  private boolean freezerOn_ = false;
  /**
   * <code>bool freezerOn = 2;</code>
   * @return The freezerOn.
   */
  @java.lang.Override
  public boolean getFreezerOn() {
    return freezerOn_;
  }

  public static final int FRIDGEON_FIELD_NUMBER = 3;
  private boolean fridgeOn_ = false;
  /**
   * <code>bool fridgeOn = 3;</code>
   * @return The fridgeOn.
   */
  @java.lang.Override
  public boolean getFridgeOn() {
    return fridgeOn_;
  }

  public static final int FREEZERTEMPERATURE_FIELD_NUMBER = 4;
  private int freezerTemperature_ = 0;
  /**
   * <code>int32 freezerTemperature = 4;</code>
   * @return The freezerTemperature.
   */
  @java.lang.Override
  public int getFreezerTemperature() {
    return freezerTemperature_;
  }

  public static final int FRIDGETEMPERATURE_FIELD_NUMBER = 5;
  private int fridgeTemperature_ = 0;
  /**
   * <code>int32 fridgeTemperature = 5;</code>
   * @return The fridgeTemperature.
   */
  @java.lang.Override
  public int getFridgeTemperature() {
    return fridgeTemperature_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(id_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, id_);
    }
    if (freezerOn_ != false) {
      output.writeBool(2, freezerOn_);
    }
    if (fridgeOn_ != false) {
      output.writeBool(3, fridgeOn_);
    }
    if (freezerTemperature_ != 0) {
      output.writeInt32(4, freezerTemperature_);
    }
    if (fridgeTemperature_ != 0) {
      output.writeInt32(5, fridgeTemperature_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(id_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, id_);
    }
    if (freezerOn_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, freezerOn_);
    }
    if (fridgeOn_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, fridgeOn_);
    }
    if (freezerTemperature_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, freezerTemperature_);
    }
    if (fridgeTemperature_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, fridgeTemperature_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.fridge.FridgeInfoResponse)) {
      return super.equals(obj);
    }
    grpc.fridge.FridgeInfoResponse other = (grpc.fridge.FridgeInfoResponse) obj;

    if (!getId()
        .equals(other.getId())) return false;
    if (getFreezerOn()
        != other.getFreezerOn()) return false;
    if (getFridgeOn()
        != other.getFridgeOn()) return false;
    if (getFreezerTemperature()
        != other.getFreezerTemperature()) return false;
    if (getFridgeTemperature()
        != other.getFridgeTemperature()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + FREEZERON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getFreezerOn());
    hash = (37 * hash) + FRIDGEON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getFridgeOn());
    hash = (37 * hash) + FREEZERTEMPERATURE_FIELD_NUMBER;
    hash = (53 * hash) + getFreezerTemperature();
    hash = (37 * hash) + FRIDGETEMPERATURE_FIELD_NUMBER;
    hash = (53 * hash) + getFridgeTemperature();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.fridge.FridgeInfoResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static grpc.fridge.FridgeInfoResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static grpc.fridge.FridgeInfoResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static grpc.fridge.FridgeInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.fridge.FridgeInfoResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code fridge.FridgeInfoResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fridge.FridgeInfoResponse)
      grpc.fridge.FridgeInfoResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.fridge.FridgeProto.internal_static_fridge_FridgeInfoResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.fridge.FridgeProto.internal_static_fridge_FridgeInfoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.fridge.FridgeInfoResponse.class, grpc.fridge.FridgeInfoResponse.Builder.class);
    }

    // Construct using grpc.fridge.FridgeInfoResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      id_ = "";
      freezerOn_ = false;
      fridgeOn_ = false;
      freezerTemperature_ = 0;
      fridgeTemperature_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.fridge.FridgeProto.internal_static_fridge_FridgeInfoResponse_descriptor;
    }

    @java.lang.Override
    public grpc.fridge.FridgeInfoResponse getDefaultInstanceForType() {
      return grpc.fridge.FridgeInfoResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.fridge.FridgeInfoResponse build() {
      grpc.fridge.FridgeInfoResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.fridge.FridgeInfoResponse buildPartial() {
      grpc.fridge.FridgeInfoResponse result = new grpc.fridge.FridgeInfoResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(grpc.fridge.FridgeInfoResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.freezerOn_ = freezerOn_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.fridgeOn_ = fridgeOn_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.freezerTemperature_ = freezerTemperature_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.fridgeTemperature_ = fridgeTemperature_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.fridge.FridgeInfoResponse) {
        return mergeFrom((grpc.fridge.FridgeInfoResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.fridge.FridgeInfoResponse other) {
      if (other == grpc.fridge.FridgeInfoResponse.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getFreezerOn() != false) {
        setFreezerOn(other.getFreezerOn());
      }
      if (other.getFridgeOn() != false) {
        setFridgeOn(other.getFridgeOn());
      }
      if (other.getFreezerTemperature() != 0) {
        setFreezerTemperature(other.getFreezerTemperature());
      }
      if (other.getFridgeTemperature() != 0) {
        setFridgeTemperature(other.getFridgeTemperature());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              id_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              freezerOn_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              fridgeOn_ = input.readBool();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              freezerTemperature_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 40: {
              fridgeTemperature_ = input.readInt32();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      id_ = getDefaultInstance().getId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private boolean freezerOn_ ;
    /**
     * <code>bool freezerOn = 2;</code>
     * @return The freezerOn.
     */
    @java.lang.Override
    public boolean getFreezerOn() {
      return freezerOn_;
    }
    /**
     * <code>bool freezerOn = 2;</code>
     * @param value The freezerOn to set.
     * @return This builder for chaining.
     */
    public Builder setFreezerOn(boolean value) {

      freezerOn_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool freezerOn = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFreezerOn() {
      bitField0_ = (bitField0_ & ~0x00000002);
      freezerOn_ = false;
      onChanged();
      return this;
    }

    private boolean fridgeOn_ ;
    /**
     * <code>bool fridgeOn = 3;</code>
     * @return The fridgeOn.
     */
    @java.lang.Override
    public boolean getFridgeOn() {
      return fridgeOn_;
    }
    /**
     * <code>bool fridgeOn = 3;</code>
     * @param value The fridgeOn to set.
     * @return This builder for chaining.
     */
    public Builder setFridgeOn(boolean value) {

      fridgeOn_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>bool fridgeOn = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearFridgeOn() {
      bitField0_ = (bitField0_ & ~0x00000004);
      fridgeOn_ = false;
      onChanged();
      return this;
    }

    private int freezerTemperature_ ;
    /**
     * <code>int32 freezerTemperature = 4;</code>
     * @return The freezerTemperature.
     */
    @java.lang.Override
    public int getFreezerTemperature() {
      return freezerTemperature_;
    }
    /**
     * <code>int32 freezerTemperature = 4;</code>
     * @param value The freezerTemperature to set.
     * @return This builder for chaining.
     */
    public Builder setFreezerTemperature(int value) {

      freezerTemperature_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int32 freezerTemperature = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearFreezerTemperature() {
      bitField0_ = (bitField0_ & ~0x00000008);
      freezerTemperature_ = 0;
      onChanged();
      return this;
    }

    private int fridgeTemperature_ ;
    /**
     * <code>int32 fridgeTemperature = 5;</code>
     * @return The fridgeTemperature.
     */
    @java.lang.Override
    public int getFridgeTemperature() {
      return fridgeTemperature_;
    }
    /**
     * <code>int32 fridgeTemperature = 5;</code>
     * @param value The fridgeTemperature to set.
     * @return This builder for chaining.
     */
    public Builder setFridgeTemperature(int value) {

      fridgeTemperature_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>int32 fridgeTemperature = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearFridgeTemperature() {
      bitField0_ = (bitField0_ & ~0x00000010);
      fridgeTemperature_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:fridge.FridgeInfoResponse)
  }

  // @@protoc_insertion_point(class_scope:fridge.FridgeInfoResponse)
  private static final grpc.fridge.FridgeInfoResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.fridge.FridgeInfoResponse();
  }

  public static grpc.fridge.FridgeInfoResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FridgeInfoResponse>
      PARSER = new com.google.protobuf.AbstractParser<FridgeInfoResponse>() {
    @java.lang.Override
    public FridgeInfoResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<FridgeInfoResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FridgeInfoResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.fridge.FridgeInfoResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

