package com.laibold.concluesion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.ui.main.MainFragment;
import com.laibold.concluesion.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

    }

    /**
     * Validates Game and starts it when everything is okay
     * @param view
     */
    public void startGame(View view) {
        Game game = mViewModel.getGame().getValue();

        if (!game.playerNamesComplete()) {
            Toast.makeText(getApplicationContext(), R.string.give_all_players_a_name, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!game.hasAppUser()) {
            Toast.makeText(getApplicationContext(), R.string.choose_yourself, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getApplicationContext(), "Subbä, Herr Laibold", Toast.LENGTH_SHORT).show();
        //TODO start Game
    }
}
