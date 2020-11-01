package com.laibold.concluesion.persistence;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.model.Player;
import com.laibold.concluesion.model.card.Card;
import com.laibold.concluesion.model.card.CardType;
import com.laibold.concluesion.model.card.Deck;
import com.laibold.concluesion.persistence.room.AppDatabase;
import com.laibold.concluesion.persistence.room.dao.GameDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class GamePersistenceTest {

    private GameDao gameDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        db.clearAllTables();
        gameDao = db.gameDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void saveGameWithPlayers_isCorrect() throws Exception {
        Game game = new Game();
        Player player1 = new Player("Beggae");
        Player player2 = new Player("Mawien");

        game.addPlayer(player1);
        game.addPlayer(player2);

        gameDao.insert(game);

        Game loadedGame = gameDao.loadAll()[0];

        ArrayList<Player> players = loadedGame.getPlayers();

        assertEquals(players.size(), 5);
        assertEquals(players.get(0).getName(), "");
        assertEquals(players.get(1).getName(), "");
        assertEquals(players.get(2).getName(), "");
        assertEquals(players.get(3).getName(), "Beggae");
        assertEquals(players.get(4).getName(), "Mawien");
    }

    @Test
    public void saveGameWithDeck_isCorrect() {
        Game game = new Game();

        Deck deck = new Deck();
        Card testCard1 = new Card(CardType.CHARACTER, "test_character");
        Card testCard2 = new Card(CardType.WEAPON, "test_weapon");
        Card testCard3 = new Card(CardType.ROOM, "test_room");

        deck.addCard(testCard1);
        deck.addCard(testCard2);
        deck.addCard(testCard3);
        game.setDeck(deck);

        gameDao.insert(game);

        Game loadedGame = gameDao.loadAll()[0];
        Deck loadedDeck = loadedGame.getDeck();

        assertEquals(loadedDeck.getCards().size(), 3);
        assertEquals(loadedDeck.getCards().get(0), testCard1);
        assertEquals(loadedDeck.getCards().get(1), testCard2);
        assertEquals(loadedDeck.getCards().get(2), testCard3);
    }

}
