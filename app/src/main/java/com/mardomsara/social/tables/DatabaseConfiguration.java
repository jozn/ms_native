package com.mardomsara.social.tables;

import com.github.gfx.android.orma.annotation.Database;

@Database(
    databaseClassName = "OrmaDatabase",
    includes = { Todo.class }//, // Give model classes to handle
//    excludes = { /* ... */ } // Give model classes not to handle
)
// The annotated class is not used, but the package name is used to place the OrmaDatabase class.
public class DatabaseConfiguration { }