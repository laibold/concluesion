package com.laibold.concluesion.model;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
public class Game {
    private CopyOnWriteArrayList<Player> players;
    private ListIterator<Player> iter;

    public Game() {
        this.players = new CopyOnWriteArrayList<>();
        this.iter = players.listIterator();
    }

    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
    }

    public void removePlayer(int index) {
        if (players.size() >= index + 1) {
            players.remove(index);
        }
    }

    public Player getNextPlayer() {
        if (!iter.hasNext()) {
            iter = players.listIterator(0);
        }
        return iter.next();
    }

    public int getNumberOfPlayers() {
        return players.size();
    }
}
