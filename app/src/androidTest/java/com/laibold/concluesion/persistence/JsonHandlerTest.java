package com.laibold.concluesion.persistence;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.GameEdition;
import com.laibold.concluesion.model.card.CardType;
import com.laibold.concluesion.model.card.Deck;
import com.laibold.concluesion.persistence.json.JsonHandler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.io.InputStream;

@RunWith(AndroidJUnit4.class)
public class JsonHandlerTest {

    JsonHandler jsonHandler;
    Context context;

    @Before
    public void init() {
        this.jsonHandler = new JsonHandler();
        this.context = ApplicationProvider.getApplicationContext();
    }

    @Test
    public void readDeck_isCorrect() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.editions_test);
        Deck deck = jsonHandler.getDeck(GameEdition.TEST_EDITION, inputStream);

        assertEquals(deck.getCards().size(), 6);

        assertEquals(deck.getCards().get(0).getCardType(), CardType.CHARACTER);
        assertEquals(deck.getCards().get(0).getName(), "test_character_1");
        assertEquals(deck.getCards().get(1).getCardType(), CardType.CHARACTER);
        assertEquals(deck.getCards().get(1).getName(), "test_character_2");

        assertEquals(deck.getCards().get(2).getCardType(), CardType.WEAPON);
        assertEquals(deck.getCards().get(2).getName(), "test_weapon_1");

        assertEquals(deck.getCards().get(5).getCardType(), CardType.ROOM);
        assertEquals(deck.getCards().get(5).getName(), "test_room_2");
    }
}
