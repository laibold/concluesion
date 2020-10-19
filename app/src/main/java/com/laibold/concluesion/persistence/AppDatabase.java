package com.laibold.concluesion.persistence;

import android.content.Context;

import com.laibold.concluesion.R;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {}, version = 0)
public abstract class AppDatabase extends RoomDatabase {

    private static String DB_NAME;
    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            DB_NAME = context.getApplicationContext().getResources().getString(R.string.db_name);
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

}
