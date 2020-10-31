package com.laibold.concluesion.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    Game testGame;
    Player testA;
    Player testB;

    @Before
    public void init() {
        this.testGame = new Game();

        testA = new Player("A");
        testB = new Player("B");
    }

    @Test
    public void addPlayer_isCorrect() {
        testGame.addPlayer(testA);
        assert (testGame.getNumberOfPlayers() == 4);
    }

    @Test
    public void removePlayer_isCorrect() {
        testGame.addPlayer(testA);
        testGame.addPlayer(testB);
        testGame.removePlayer(1);
        assert (testGame.getNumberOfPlayers() == 4);
    }

    @Test
    public void getNextPlayer_isCorrect() {
        this.setPlayerNames(testGame);
        testGame.addPlayer(testA);
        testGame.addPlayer(testB);

        assertEquals(testGame.getNextPlayer().getName(), "first");
        assertEquals(testGame.getNextPlayer().getName(), "second");
        assertEquals(testGame.getNextPlayer().getName(), "third");
        assertEquals(testGame.getNextPlayer(), testA);
        assertEquals(testGame.getNextPlayer(), testB);
        assertEquals(testGame.getNextPlayer().getName(), "first");
    }

    @Test
    public void hasAppUser_isCorrect() {
        assertFalse(testGame.hasAppUser());
        testGame.getPlayers().get(0).setAppUser(true);
        assertTrue(testGame.hasAppUser());
    }

    @Test
    public void playerNamesComplete_isCorrect() {
        assertFalse(testGame.playerNamesComplete());
        setPlayerNames(testGame);
        assertTrue(testGame.playerNamesComplete());
    }

    private void setPlayerNames(Game game) {
        game.getPlayers().get(0).setName("first");
        game.getPlayers().get(1).setName("second");
        game.getPlayers().get(2).setName("third");
    }
}
