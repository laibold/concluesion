package com.laibold.concluesion.persistence.room.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laibold.concluesion.model.card.Card;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CardConverter {
    @TypeConverter
    public static ArrayList<Card> fromJson(String cardValue){
        Type listType = new TypeToken<ArrayList<Card>>() {}.getType();
        return new Gson().fromJson(cardValue, listType);
    }

    @TypeConverter
    public static String toJson(ArrayList<Card> cardArrayList){
        Gson gson = new Gson();
        return gson.toJson(cardArrayList);
    }
}
