package com.mardomsara.social.pipe.table;

import com.github.gfx.android.orma.annotation.Database;

@Database(
        databaseClassName = "RpcDB",
        includes = {
                RpcOffline.class

        }, // Give model classes to handlePushes
        excludes = {  } // Give model classes not to handlePushes
)
// The annotated class is not used, but the package name is used to place the OrmaDatabase class.
public class RpcDb_Config {
}
