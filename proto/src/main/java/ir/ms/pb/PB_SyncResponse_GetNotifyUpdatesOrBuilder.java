// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_rpc_sync.proto

package ir.ms.pb;

public interface PB_SyncResponse_GetNotifyUpdatesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PB_SyncResponse_GetNotifyUpdates)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>.PB_NotifyUpdatesView Updates = 1;</code>
   */
  boolean hasUpdates();
  /**
   * <code>.PB_NotifyUpdatesView Updates = 1;</code>
   */
  ir.ms.pb.PB_NotifyUpdatesView getUpdates();

  /**
   * <code>int64 LastId = 50;</code>
   */
  long getLastId();
}
