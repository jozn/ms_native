package com.mardomsara.social.models;

import com.github.gfx.android.orma.annotation.Database;
import com.mardomsara.social.base.old.Command;

/**
 * Created by Hamid on 9/1/2016.
 */
@Database(
        databaseClassName = "AppDB",
        includes = {
                ContactsCopy.class,
                Notify.class,
                Message.class,
                MsgFile.class,
				MsgSeen.class,
                Room.class,
				SearchTagHistory.class,
				SearchUserHistory.class,
                User.class,
                Command.class,



//                Item.class

        }, // Give model classes to handlePushes
        excludes = {  } // Give model classes not to handlePushes
)
// The annotated class is not used, but the package name is used to place the OrmaDatabase class.
public class AppDb_Config {
}
