package com.laibold.concluesion.model.card;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

import java.util.ArrayList;

/**
 * Collection of Cards
 */
@Entity
public class Deck {

    @PrimaryKey(autoGenerate = true)
    private int deckId;

    public ArrayList<Card> cards;

    /**
     * Creates empty Deck
     */
    public Deck() {
        this.cards = new ArrayList<>();
    }

    /**
     * @return ID of Deck (for persistence)
     */
    public int getDeckId() {
        return deckId;
    }

    /**
     * @param deckId ID of Deck (for persistence)
     */
    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    /**
     * @return All Cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @param cards Cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * @param card Card
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }
}
