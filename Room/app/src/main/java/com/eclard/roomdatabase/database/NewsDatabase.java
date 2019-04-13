package com.eclard.roomdatabase.database;

import android.content.Context;

import com.eclard.roomdatabase.database.entity.News;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Milan on 4/13/19.
 */
@Database(version = 1, entities = {News.class})
public abstract class NewsDatabase extends RoomDatabase {
    private static NewsDatabase instance = null;

    public abstract NewsDao newsDao();

    /**
     *
     * @param appContext Application context.
     * @param inMemory in memory database or persistent database.
     * @return NewsDatabase instance.
     */
    public static synchronized NewsDatabase getInstance(Context appContext, boolean inMemory) {
        if (instance == null) {
            if (inMemory) {
                // Creates a RoomDatabase.Builder for an in memory database.
                // Information stored in an in memory database disappears when the
                // process is killed. Once a database is built, you should keep a
                // reference to it and re-use it.
                instance = Room.inMemoryDatabaseBuilder(appContext, NewsDatabase.class)
                        .build();
            } else {
                // Creates a RoomDatabase.Builder for a persistent database.
                // Once a database is built, you should keep a reference to it and re-use it.
                instance = Room.databaseBuilder(appContext,
                        NewsDatabase.class, "news-database").allowMainThreadQueries()
                        .build();

            }
        }

        return instance;
    }

    public static synchronized NewsDatabase getInstance(Context appContext) {
        return getInstance(appContext, false);
    }
}
