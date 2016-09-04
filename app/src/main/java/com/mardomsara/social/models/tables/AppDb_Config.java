package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.Database;

/**
 * Created by Hamid on 9/1/2016.
 */
@Database(
        databaseClassName = "AppDB",
        includes = {
                ContactsCopy.class,
                Notify.class,
                Message.class,
                Room.class,
                User.class,

        }, // Give model classes to handle
        excludes = {  } // Give model classes not to handle
)
// The annotated class is not used, but the package name is used to place the OrmaDatabase class.
public class AppDb_Config {
}
