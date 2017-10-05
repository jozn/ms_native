package com.mardomsara.social.del.pipe_pb.from_net_calls.json;

/**
 * Created by Hamid on 10/12/2016.
 */
public class MsgDeletedFromServerJson {
	public int ToUserId = 0;
	public int PeerUserId = 0;
	public String MsgKey="";
	public String RoomKey="";
	public int AtTime = 0;
}
/*
	type MsgDeletedFromServer struct {
	Id         int    `json:"Id"`         // Id -
	PeerUserId   int    `json:"PeerUserId"`   // PeerUserId -
	MsgKey     string `json:"MsgKey"`     // MsgKey -
	PeerUserId int    `json:"PeerUserId"` // PeerUserId -
	RoomKey    string `json:"RoomKey"`    // RoomKey -
	AtTime     int    `json:"AtTime"`     // AtTime -

	// xo fields
	_exists, _deleted bool
	}
*/
