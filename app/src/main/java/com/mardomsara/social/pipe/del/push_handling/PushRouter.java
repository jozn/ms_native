package com.mardomsara.social.pipe.del.push_handling;

import ir.ms.pb.PB_PushHolderView;

/**
 * Created by Hamid on 8/30/2017.
 */

public class PushRouter {
	public static void handle(PB_PushHolderView push){
		PushHandlerNewMessages.handle(push);
	}
}
