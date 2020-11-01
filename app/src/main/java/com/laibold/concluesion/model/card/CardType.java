package com.laibold.concluesion.model.card;

import com.laibold.concluesion.R;

public enum CardType {
    CHARACTER(R.string.character), WEAPON(R.string.weapon), ROOM(R.string.room);

    private final int stringResourceID;

    CardType(int stringResourceID) {
        this.stringResourceID = stringResourceID;
    }

    public int getStringResourceID() {
        return stringResourceID;
    }
}
