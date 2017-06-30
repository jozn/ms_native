package com.mardomsara.social.enums;

/**
 * Created by Hamid on 6/26/2017.
 */

public enum  MessageEvent {
	//This data is come from the pipe network
	RECEIVED_TO_PEER(1),
	DELETED_FROM_SERVER(2),
	SEEN_BY_PEER(3),

	;

	private int numId;
	MessageEvent(int number) {
		numId = number;
	}
}
