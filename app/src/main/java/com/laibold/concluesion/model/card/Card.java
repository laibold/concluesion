package com.laibold.concluesion.model.card;

import java.util.Objects;

public class Card {

    private CardType cardType;
    private String name;

    public Card(CardType cardType, String name) {
        this.cardType = cardType;
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardType == card.cardType &&
                Objects.equals(name, card.name);
    }
}
