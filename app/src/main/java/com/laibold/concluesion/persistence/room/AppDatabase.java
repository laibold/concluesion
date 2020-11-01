package com.laibold.concluesion.persistence.room;

import android.content.Context;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.model.card.Deck;
import com.laibold.concluesion.persistence.room.converter.CardConverter;
import com.laibold.concluesion.persistence.room.converter.PlayerConverter;
import com.laibold.concluesion.persistence.room.dao.GameDao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Game.class, Deck.class}, version = 2, exportSchema = false)
@TypeConverters({PlayerConverter.class, CardConverter.class})
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

    public abstract GameDao gameDao();
}
