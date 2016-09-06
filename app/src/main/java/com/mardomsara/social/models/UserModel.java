package com.mardomsara.social.models;

import android.support.annotation.Nullable;

import com.mardomsara.social.app.DB;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.models.tables.Message;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.service.WSService;

import java.util.List;

/**
 * Created by Hamid on 9/6/2016.
 */
public class UserModel {

    //////////// CRUD ///////////
    public static void create(User user){
        DB.db.insertIntoUser(user);
    }

    @Nullable
    public static User getByUserId(int id){
        return DB.db.selectFromUser().UserIdEq(id).getOrNull(0);
    }

    /////////////////////////////


    public static void onRecivedNewMsg(Message msg) {
        User user = getByUserId( msg.UserId );
        if(user == null){
            Command cmd = new Command();
            cmd.Name = "GetUserForTable";
            cmd.Data = ""+ msg.UserId;
            WSService.sendCommand(cmd);
        }
    }

    public static List<User> getAllFollowings() {
        return DB.db.selectFromUser().FollowingTypeEq(1).toList();
    }

    public static List<User> getAllRegisteredContacts() {
        return DB.db.selectFromUser().IsPhoneContactEq(1).toList();
    }

}
