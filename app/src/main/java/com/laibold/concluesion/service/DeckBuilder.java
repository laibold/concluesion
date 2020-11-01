package com.laibold.concluesion.service;

import com.laibold.concluesion.model.GameEdition;
import com.laibold.concluesion.model.card.Deck;
import com.laibold.concluesion.persistence.json.JsonHandler;

import java.io.InputStream;

/**
 * Builder for {@link Deck} class
 */
public class DeckBuilder {

    /**
     * Creates new {@link Deck} from resources
     * @param edition GameEdition
     * @param inputStream InputStream from .json Resource where cards can be found
     * @return New Deck
     */
    public static Deck buildDeck(GameEdition edition, InputStream inputStream) {
        JsonHandler jsonHandler = new JsonHandler();
        return jsonHandler.getDeck(edition, inputStream);
    }

}
