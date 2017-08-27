package com.mardomsara.social.pipe_pb.from_net_calls;

import com.mardomsara.social.App;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.events.NotifyAddedEvent;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.pipe_pb.NetEventHandler_DEP;
import com.mardomsara.social.pipe_pb.PipeNetEventHandler;

/**
 * Created by Hamid on 5/2/2016.
 */
public class NotifyCallsFromServer {
    public static PipeNetEventHandler<String> NotifyRemoveMany = (data) ->{
		/*MsgAddOneJson jd = AppUtil.fromJson(data,MsgAddOneJson.class);
        if(jd==null || jd.Message == null )return;
        AppUtil.log("NotifyRemoveMany: -> "+data);

		App.getBus().post(jd);*/
    };

	public static NetEventHandler_DEP NotifyAddOne = (data) ->{
		AppUtil.log("NotifyAddOne: cmd -> "+data);
//		Helper.showDebugMessage("NotifyAddOne: "+data);

		Notify note = AppUtil.fromJson(data,Notify.class);
		if(note==null || note.Id <1 )return;

		AndroidUtil.runInBackgroundNoPanic(()->{
			note.save();
			NotifyAddedEvent event = new NotifyAddedEvent();
			event.notify= note;

			App.getBus().post(event);
		});

//		App.getBus().post(note);
	};


}
