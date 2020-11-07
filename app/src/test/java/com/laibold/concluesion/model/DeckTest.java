package com.laibold.concluesion.model;

import com.laibold.concluesion.model.card.Card;
import com.laibold.concluesion.model.card.CardType;
import com.laibold.concluesion.model.card.Deck;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;

    @Before
    public void initDeck() {
        deck = new Deck();
        deck.addCard(new Card(CardType.CHARACTER, "test_character_1"));
        deck.addCard(new Card(CardType.WEAPON, "test_weapon_1"));
        deck.addCard(new Card(CardType.WEAPON, "test_weapon_2"));
        deck.addCard(new Card(CardType.ROOM, "test_room_1"));
        deck.addCard(new Card(CardType.ROOM, "test_room_2"));
        deck.addCard(new Card(CardType.ROOM, "test_room_3"));
    }

    @Test
    public void createDeck_isCorrect() {
        List<Card> cardList = deck.getCards();
        assertNotNull(cardList);

        checkCardList(cardList);
    }

    public void checkCardList(List<Card> cardList) {
        for (Card card : cardList) {
            assertNotNull(card.getName());
            assertNotNull(card.getCardType());
            assertNotEquals(card.getName(), "");
        }
    }

    @Test
    public void createCardMap_isCorrect() {
        HashMap<String, List<Card>> cardMap = deck.getCardMap();
        int expectedSize = CardType.values().length;

        assertSame(expectedSize, cardMap.size());
        assertSame(cardMap.get(CardType.CHARACTER.getTranslationString()).size(), 1);
        assertSame(cardMap.get(CardType.WEAPON.getTranslationString()).size(), 2);
        assertSame(cardMap.get(CardType.ROOM.getTranslationString()).size(), 3);

        for (String key : cardMap.keySet()) {
            List<Card> cardList = cardMap.get(key);
            assertNotNull(cardList);
            checkCardList(cardList);
        }
    }

}
