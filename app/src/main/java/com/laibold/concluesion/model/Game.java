package com.laibold.concluesion.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private ArrayList<Player> players;
    @ColumnInfo
    private int currPlayerIndex = -1;

    public Game() {
        this.players = new ArrayList<>();
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
        if (currPlayerIndex == (players.size() - 1)) {
            currPlayerIndex = 0;
            return players.get(currPlayerIndex);
        }
        currPlayerIndex++;
        return players.get(currPlayerIndex);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public int getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setCurrPlayerIndex(int currPlayerIndex) {
        this.currPlayerIndex = currPlayerIndex;
    }
}
