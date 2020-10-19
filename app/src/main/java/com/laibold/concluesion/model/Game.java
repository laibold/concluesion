package com.laibold.concluesion.model;

import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

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
