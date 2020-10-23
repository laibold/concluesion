package com.laibold.concluesion.persistence;

import android.content.Context;

import androidx.room.Room;

import com.laibold.concluesion.persistence.dao.GameDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class GamePersistenceTest {

    private GameDao gameDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        /*Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        gameDao = db.gameDao();*/
    }

}
