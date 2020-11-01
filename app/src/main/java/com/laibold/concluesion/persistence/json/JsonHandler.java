package com.laibold.concluesion.persistence.json;

import android.content.res.Resources;

import com.laibold.concluesion.App;
import com.laibold.concluesion.model.GameEdition;
import com.laibold.concluesion.model.card.Card;
import com.laibold.concluesion.model.card.CardType;
import com.laibold.concluesion.model.card.Deck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonHandler {

    /**
     * Creates new Deck from json resource
     * @param edition GameEdition
     * @param inputStream InputStream from .json Resource where cards can be found
     * @return new Deck
     */
    public Deck getDeck(GameEdition edition, InputStream inputStream) {
        Deck deck = new Deck();
        ByteArrayOutputStream byteArrayOutputStream = readToOutputStream(inputStream);

        try {
            JSONObject jFileObject = new JSONObject(byteArrayOutputStream.toString());

            JSONObject editionObject = jFileObject.getJSONObject(edition.toString());

            for (int i = 0; i < CardType.values().length; i++) {
                CardType cardType = CardType.values()[i];
                String cardTypeName = cardType.toString();
                JSONArray names = editionObject.getJSONArray(cardTypeName);

                for (int j = 0; j < names.length(); j++) {
                    String nameIdentifier = (String) names.get(j);
                    String name = getStringResourceByName(nameIdentifier);
                    Card card = new Card(cardType, name);
                    deck.addCard(card);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return deck;
    }

    /**
     * Reads from InputStream and writes content to ByteArrayOutputStream
     * @param inputStream Inputstream
     * @return ByteArrayOutputStream
     */
    private ByteArrayOutputStream readToOutputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int data;
        try {
            data = inputStream.read();
            while (data != -1) {
                byteArrayOutputStream.write(data);
                data = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream;
    }

    /**
     * Returns string value from it's name
     * @param string identifier of string resource
     * @return content of string resource
     */
    private String getStringResourceByName(String string) {
        Resources resources = App.getAppResources();
        int identifier = resources.getIdentifier(string, "string", App.getAppPackageName());
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException e) {
            return string;
        }
    }
}
