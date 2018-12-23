package com.example.popular.p_reminds;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = Info.class, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseAccessObject dbObject();

}
