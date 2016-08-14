package com.mardomsara.social;

import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.service.WSService;

/**
 * Created by Hamid on 6/8/2016.
 */
public class Init {
    public static void onAppStart(){

    }

    public static void onAfterAppStart(){
        //////////////
        AppFiles.buildAllDirs();
        //////////////
        Command cmd = new Command();
        cmd.Name = "Echo";
        WSService.sendCommand(cmd);
        Session.fetchUserInfoFromServer();
        /////////////
    }

}
