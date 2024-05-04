// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: camera.proto

// Protobuf Java Version: 4.26.1
package grpc.camera;

public interface CameraResolutionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:camera.CameraResolutionRequest)
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
   * <code>.camera.CameraResolution resolution = 2;</code>
   * @return The enum numeric value on the wire for resolution.
   */
  int getResolutionValue();
  /**
   * <code>.camera.CameraResolution resolution = 2;</code>
   * @return The resolution.
   */
  grpc.camera.CameraResolution getResolution();
}