package com.laibold.concluesion.model.card;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /**
     * Returns Card filtered by CardType
     * @param cardType Type the Deck should be filtered by
     * @return ArrayList of Cards with provided CardType
     */
    public ArrayList<Card> getCardsByType(final CardType cardType) {
        ArrayList<Card> filteredCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getCardType() == cardType) {
                filteredCards.add(card);
            }
        }

        return filteredCards;
    }

    /**
     * Creates HashMap with CardTypes as String key and Lists of belonging Cards as Values.
     * For Use in Expandable ListView.
     * @return HashMap<String, List<Card>>
     */
    public HashMap<String, List<Card>> getCardMap() {
        HashMap<String, List<Card>> cardMap = new HashMap<>();

        for (CardType type : CardType.values()) {
            String typeName = type.getTranslationString();
            List<Card> cardList = this.getCardsByType(type);
            cardMap.put(typeName, cardList);
        }

        return cardMap;
    }

}
