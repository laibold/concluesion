package com.laibold.concluesion.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laibold.concluesion.model.Game;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<Game> game = new MutableLiveData<>();

    public void setGame(Game game) {
        this.game.setValue(game);
    }

    public LiveData<Game> getGame() {
        return this.game;
    }

}
