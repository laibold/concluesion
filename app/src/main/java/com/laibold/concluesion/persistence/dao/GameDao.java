package com.laibold.concluesion.persistence.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.laibold.concluesion.model.Game;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game")
    public Game[] loadAllGames();

    @Insert
    public void insertGame();
}
