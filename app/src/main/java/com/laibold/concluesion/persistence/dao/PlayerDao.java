package com.laibold.concluesion.persistence.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.laibold.concluesion.model.Player;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM player")
    public Player[] loadAllPlayers();

    @Insert
    public void insertPlayer();
}
