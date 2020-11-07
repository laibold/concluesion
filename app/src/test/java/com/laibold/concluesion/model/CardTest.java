package com.laibold.concluesion.model;

import com.laibold.concluesion.model.card.Card;
import com.laibold.concluesion.model.card.CardType;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void cardEquals_isCorrect() {
        Card card1 = new Card(CardType.CHARACTER, "test_character_1");
        Card cardDiffType = new Card(CardType.ROOM, "test_character_1");
        Card cardDiffName = new Card(CardType.CHARACTER, "test_character_2");
        Card cardBothDiff = new Card(CardType.WEAPON, "test_weapon_1");
        Card cardCharNull = new Card(null, "test_character_1");
        Card cardNameNull = new Card(CardType.CHARACTER, null);
        Card cardNameEmpty = new Card(CardType.CHARACTER, "");
        Card cardBothSame = new Card(CardType.CHARACTER, "test_character_1");
        Card cardReference;
        cardReference = card1;

        assertNotEquals(card1, cardDiffType);
        assertNotEquals(card1, cardDiffName);
        assertNotEquals(card1, cardBothDiff);
        assertNotEquals(card1, cardCharNull);
        assertNotEquals(card1, cardNameNull);
        assertNotEquals(card1, cardNameEmpty);
        assertEquals(card1, cardBothSame);
        assertEquals(card1, cardReference);
    }

}
