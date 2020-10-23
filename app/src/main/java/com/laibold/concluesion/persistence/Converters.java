package com.laibold.concluesion.persistence;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laibold.concluesion.model.Player;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<Player> fromPlayers(String value){
        Type listType = new TypeToken<ArrayList<Player>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Player> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
