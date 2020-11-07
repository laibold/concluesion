package com.laibold.concluesion.model.card;

import java.util.Objects;

public class Card {

    private CardType cardType;
    private String name;
    private boolean checked;

    /**
     * Creates new Card
     *
     * @param cardType Type of Card
     * @param name     Name of Card
     */
    public Card(CardType cardType, String name) {
        this.cardType = cardType;
        this.name = name;
    }

    /**
     * @return Type of Card
     */
    public CardType getCardType() {
        return cardType;
    }

    /**
     * @param cardType Type of Card
     */
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    /**
     * @return Name of Card
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of Card
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return True if Card is definitely in a Player's hand
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Set if Card is definitely in a Player's hand
     * @param checked boolean
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * Switch checked state
     */
    public void toggleChecked() {
        this.checked = !this.checked;
    }

    /**
     * Compare two Cards
     * @param other Other Card
     * @return true if cards are equal
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Card card = (Card) other;
        return cardType == card.cardType &&
                Objects.equals(name, card.name);
    }
}
