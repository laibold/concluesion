package com.laibold.concluesion.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

import com.laibold.concluesion.model.card.Deck;

import java.util.ArrayList;

@Entity
@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int gameId;

    @ColumnInfo
    private ArrayList<Player> players;

    @ColumnInfo
    private int currPlayerIndex = -1;

    @Embedded
    private Deck deck;

    /**
     * Creates new Game
     */
    public Game() {
        this.players = new ArrayList<>();
        players.add(new Player(""));
        players.add(new Player(""));
        players.add(new Player(""));
    }

    /**
     * @return ID of Game (for persistence)
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * @param gameId ID of Game (for persistence)
     */
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    /**
     * Add Player to Game
     * @param newPlayer New Player
     */
    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
    }

    /**
     * Remove Player from Game
     * @param index Player to be removed
     */
    public void removePlayer(int index) {
        if (players.size() >= index + 1) {
            players.remove(index);
        }
    }

    /**
     * Returns Player who is next
     * @return Player
     */
    public Player getNextPlayer() {
        if (currPlayerIndex == (players.size() - 1)) {
            currPlayerIndex = 0;
            return players.get(currPlayerIndex);
        }
        currPlayerIndex++;
        return players.get(currPlayerIndex);
    }

    /**
     * @return Number of Players
     */
    public int getNumberOfPlayers() {
        return players.size();
    }

    /**
     * @return Index of current Player
     */
    public int getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    /**
     * @return List of Players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players List of Players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Sets index of the player who is on turn
     * @param currPlayerIndex Player's index
     */
    public void setCurrPlayerIndex(int currPlayerIndex) {
        this.currPlayerIndex = currPlayerIndex;
    }

    /**
     * @return Deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param deck Deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Returns if one player is marked as appUser
     * @return boolean
     */
    public boolean hasAppUser() {
        for (Player player : players) {
            if (player.isAppUser()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if every player has a name (no empty string)
     * @return boolean
     */
    public boolean playerNamesComplete() {
        for (Player player : players) {
            if (player.getName().equals("")) {
                return false;
            }
        }
        return true;
    }
}
