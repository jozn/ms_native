// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_del.proto

package ir.ms.pb;

public interface PB_PushMsgEventsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:PB_PushMsgEvents)
    com.google.protobuf.MessageLiteOrBuilder {

  /** <code>.PB_Push Push = 1;</code> */
  boolean hasPush();
  /** <code>.PB_Push Push = 1;</code> */
  ir.ms.pb.PB_Push getPush();

  /** <code>repeated .PB_MsgEvent Events = 2;</code> */
  java.util.List<ir.ms.pb.PB_MsgEvent> getEventsList();
  /** <code>repeated .PB_MsgEvent Events = 2;</code> */
  ir.ms.pb.PB_MsgEvent getEvents(int index);
  /** <code>repeated .PB_MsgEvent Events = 2;</code> */
  int getEventsCount();
}
