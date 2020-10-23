package com.laibold.concluesion.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {
    Game testGame = new Game();
    Player testA = new Player("A");
    Player testB = new Player("B");

    @Test
    public void addPlayer_isCorrect(){
        testGame.addPlayer(testA);
        assert(testGame.getNumberOfPlayers() == 1);
    }

    @Test
    public void removePlayer_isCorrect(){
        testGame.addPlayer(testA);
        testGame.addPlayer(testB);
        testGame.removePlayer(1);
        assert(testGame.getNumberOfPlayers() == 1);
    }

    @Test
    public void getNextPlayer_isCorrect(){
        testGame.addPlayer(testA);
        testGame.addPlayer(testB);
        assertEquals(testGame.getNextPlayer(), testA);
        assertEquals(testGame.getNextPlayer(), testB);
        assertEquals(testGame.getNextPlayer(), testA);
    }
}
