// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: camera.proto

// Protobuf Java Version: 4.26.1
package grpc.camera;

public interface SwitchRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:camera.SwitchRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string camera_id = 1;</code>
   * @return The cameraId.
   */
  java.lang.String getCameraId();
  /**
   * <code>string camera_id = 1;</code>
   * @return The bytes for cameraId.
   */
  com.google.protobuf.ByteString
      getCameraIdBytes();

  /**
   * <code>.camera.SwitchType switch_type = 2;</code>
   * @return The enum numeric value on the wire for switchType.
   */
  int getSwitchTypeValue();
  /**
   * <code>.camera.SwitchType switch_type = 2;</code>
   * @return The switchType.
   */
  grpc.camera.SwitchType getSwitchType();

  /**
   * <code>bool value = 3;</code>
   * @return The value.
   */
  boolean getValue();
}