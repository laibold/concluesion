package com.laibold.concluesion.model;

import com.laibold.concluesion.model.card.CardType;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CardTypeTest {

    @Test
    public void toStringList_isCorrect() {
        List<String> stringList = CardType.toStringList();

        //No App instance available here so CardType will use default toString() method, that's okay
        assertEquals(stringList.size(), 3);
        assertEquals(stringList.get(0), "CHARACTER");
        assertEquals(stringList.get(1), "WEAPON");
        assertEquals(stringList.get(2), "ROOM");
    }
}
