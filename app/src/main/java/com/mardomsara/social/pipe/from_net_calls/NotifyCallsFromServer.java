package com.mardomsara.social.pipe.from_net_calls;

import com.mardomsara.social.App;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Constants;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.HttpOld;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FileUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.models.MessageModel;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.events.NotifyAddedEvent;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.Notify;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.pipe.NetEventHandler;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddManyJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgAddOneJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgDeletedFromServerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgReceivedToPeerJson;
import com.mardomsara.social.pipe.from_net_calls.json.MsgSeenByPeerJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hamid on 5/2/2016.
 */
public class NotifyCallsFromServer {
    public static NetEventHandler NotifyRemoveMany = (data) ->{
		MsgAddOneJson jd = AppUtil.fromJson(data,MsgAddOneJson.class);
        if(jd==null || jd.Message == null )return;
        AppUtil.log("NotifyRemoveMany: -> "+data);

		App.getBus().post(jd);
    };

	public static NetEventHandler NotifyAddOne = (data) ->{
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
