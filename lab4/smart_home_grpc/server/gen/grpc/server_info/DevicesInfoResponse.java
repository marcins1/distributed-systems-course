// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: serverInfo.proto

// Protobuf Java Version: 4.26.1
package grpc.server_info;

/**
 * Protobuf type {@code server_info.DevicesInfoResponse}
 */
public final class DevicesInfoResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:server_info.DevicesInfoResponse)
    DevicesInfoResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      DevicesInfoResponse.class.getName());
  }
  // Use DevicesInfoResponse.newBuilder() to construct.
  private DevicesInfoResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private DevicesInfoResponse() {
    devices_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.server_info.InfoProto.internal_static_server_info_DevicesInfoResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.server_info.InfoProto.internal_static_server_info_DevicesInfoResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.server_info.DevicesInfoResponse.class, grpc.server_info.DevicesInfoResponse.Builder.class);
  }

  public static final int DEVICES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringArrayList devices_ =
      com.google.protobuf.LazyStringArrayList.emptyList();
  /**
   * <code>repeated string devices = 1;</code>
   * @return A list containing the devices.
   */
  public com.google.protobuf.ProtocolStringList
      getDevicesList() {
    return devices_;
  }
  /**
   * <code>repeated string devices = 1;</code>
   * @return The count of devices.
   */
  public int getDevicesCount() {
    return devices_.size();
  }
  /**
   * <code>repeated string devices = 1;</code>
   * @param index The index of the element to return.
   * @return The devices at the given index.
   */
  public java.lang.String getDevices(int index) {
    return devices_.get(index);
  }
  /**
   * <code>repeated string devices = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the devices at the given index.
   */
  public com.google.protobuf.ByteString
      getDevicesBytes(int index) {
    return devices_.getByteString(index);
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
    for (int i = 0; i < devices_.size(); i++) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, devices_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < devices_.size(); i++) {
        dataSize += computeStringSizeNoTag(devices_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getDevicesList().size();
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
    if (!(obj instanceof grpc.server_info.DevicesInfoResponse)) {
      return super.equals(obj);
    }
    grpc.server_info.DevicesInfoResponse other = (grpc.server_info.DevicesInfoResponse) obj;

    if (!getDevicesList()
        .equals(other.getDevicesList())) return false;
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
    if (getDevicesCount() > 0) {
      hash = (37 * hash) + DEVICES_FIELD_NUMBER;
      hash = (53 * hash) + getDevicesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.server_info.DevicesInfoResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static grpc.server_info.DevicesInfoResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static grpc.server_info.DevicesInfoResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static grpc.server_info.DevicesInfoResponse parseFrom(
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
  public static Builder newBuilder(grpc.server_info.DevicesInfoResponse prototype) {
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
   * Protobuf type {@code server_info.DevicesInfoResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:server_info.DevicesInfoResponse)
      grpc.server_info.DevicesInfoResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.server_info.InfoProto.internal_static_server_info_DevicesInfoResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.server_info.InfoProto.internal_static_server_info_DevicesInfoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.server_info.DevicesInfoResponse.class, grpc.server_info.DevicesInfoResponse.Builder.class);
    }

    // Construct using grpc.server_info.DevicesInfoResponse.newBuilder()
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
      devices_ =
          com.google.protobuf.LazyStringArrayList.emptyList();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.server_info.InfoProto.internal_static_server_info_DevicesInfoResponse_descriptor;
    }

    @java.lang.Override
    public grpc.server_info.DevicesInfoResponse getDefaultInstanceForType() {
      return grpc.server_info.DevicesInfoResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.server_info.DevicesInfoResponse build() {
      grpc.server_info.DevicesInfoResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.server_info.DevicesInfoResponse buildPartial() {
      grpc.server_info.DevicesInfoResponse result = new grpc.server_info.DevicesInfoResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(grpc.server_info.DevicesInfoResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        devices_.makeImmutable();
        result.devices_ = devices_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.server_info.DevicesInfoResponse) {
        return mergeFrom((grpc.server_info.DevicesInfoResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.server_info.DevicesInfoResponse other) {
      if (other == grpc.server_info.DevicesInfoResponse.getDefaultInstance()) return this;
      if (!other.devices_.isEmpty()) {
        if (devices_.isEmpty()) {
          devices_ = other.devices_;
          bitField0_ |= 0x00000001;
        } else {
          ensureDevicesIsMutable();
          devices_.addAll(other.devices_);
        }
        onChanged();
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
              java.lang.String s = input.readStringRequireUtf8();
              ensureDevicesIsMutable();
              devices_.add(s);
              break;
            } // case 10
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

    private com.google.protobuf.LazyStringArrayList devices_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
    private void ensureDevicesIsMutable() {
      if (!devices_.isModifiable()) {
        devices_ = new com.google.protobuf.LazyStringArrayList(devices_);
      }
      bitField0_ |= 0x00000001;
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @return A list containing the devices.
     */
    public com.google.protobuf.ProtocolStringList
        getDevicesList() {
      devices_.makeImmutable();
      return devices_;
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @return The count of devices.
     */
    public int getDevicesCount() {
      return devices_.size();
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @param index The index of the element to return.
     * @return The devices at the given index.
     */
    public java.lang.String getDevices(int index) {
      return devices_.get(index);
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the devices at the given index.
     */
    public com.google.protobuf.ByteString
        getDevicesBytes(int index) {
      return devices_.getByteString(index);
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @param index The index to set the value at.
     * @param value The devices to set.
     * @return This builder for chaining.
     */
    public Builder setDevices(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureDevicesIsMutable();
      devices_.set(index, value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @param value The devices to add.
     * @return This builder for chaining.
     */
    public Builder addDevices(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureDevicesIsMutable();
      devices_.add(value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @param values The devices to add.
     * @return This builder for chaining.
     */
    public Builder addAllDevices(
        java.lang.Iterable<java.lang.String> values) {
      ensureDevicesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, devices_);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDevices() {
      devices_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string devices = 1;</code>
     * @param value The bytes of the devices to add.
     * @return This builder for chaining.
     */
    public Builder addDevicesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureDevicesIsMutable();
      devices_.add(value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:server_info.DevicesInfoResponse)
  }

  // @@protoc_insertion_point(class_scope:server_info.DevicesInfoResponse)
  private static final grpc.server_info.DevicesInfoResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.server_info.DevicesInfoResponse();
  }

  public static grpc.server_info.DevicesInfoResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DevicesInfoResponse>
      PARSER = new com.google.protobuf.AbstractParser<DevicesInfoResponse>() {
    @java.lang.Override
    public DevicesInfoResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<DevicesInfoResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DevicesInfoResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.server_info.DevicesInfoResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
