package com.laibold.concluesion.persistence.room.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laibold.concluesion.model.Player;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PlayerConverter {
    @TypeConverter
    public static ArrayList<Player> fromJson(String playerValue){
        Type listType = new TypeToken<ArrayList<Player>>() {}.getType();
        return new Gson().fromJson(playerValue, listType);
    }

    @TypeConverter
    public static String toJson(ArrayList<Player> playerArrayList){
        Gson gson = new Gson();
        return gson.toJson(playerArrayList);
    }
}
