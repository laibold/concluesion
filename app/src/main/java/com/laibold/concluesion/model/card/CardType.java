package com.laibold.concluesion.model.card;

import android.content.res.Resources;

import com.laibold.concluesion.App;
import com.laibold.concluesion.R;

import java.util.ArrayList;
import java.util.List;

public enum CardType {
    CHARACTER(R.string.character), WEAPON(R.string.weapon), ROOM(R.string.room);

    private final int stringResourceID;

    /**
     * Constructor
     * @param stringResourceID int if from R
     */
    CardType(int stringResourceID) {
        this.stringResourceID = stringResourceID;
    }

    /**
     * @return String value from R.strings
     */
    public String getTranslationString() {
        Resources resources = App.getAppResources();
        if (resources != null) {
            App.getAppResources().getString(stringResourceID);
        }
        return this.toString();
    }

    /**
     * @return List of Strings for every enum value
     */
    public static List<String> toStringList() {
        ArrayList<String> list = new ArrayList<>();
        for(CardType type : CardType.values()) {
            String name = type.getTranslationString();
            list.add(name);
        }
        return list;
    }
}
