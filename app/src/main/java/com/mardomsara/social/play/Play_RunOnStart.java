package com.mardomsara.social.play;

import com.mardomsara.social.app.app_state.AppState;
import com.mardomsara.social.helpers.Helper;

/**
 * Created by Hamid on 10/15/2017.
 */

public class Play_RunOnStart {

	public static void run(){
		AppState.getDefault().getSettingClientEditor().setAutoDownloadCellularImage(2);
		AppState.getDefault().saveSettingClient();

		Helper.showDebugMessage("UUid of session: "+AppState.getDefault().getSession().getClientUuid());
		AppState.getDefault().saveSettingClient();
	}
}
