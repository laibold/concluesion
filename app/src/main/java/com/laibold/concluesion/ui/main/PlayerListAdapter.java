package com.laibold.concluesion.ui.main;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.model.Player;

import java.util.ArrayList;

public class PlayerListAdapter extends ArrayAdapter<Player> {

    private final static int LAYOUT = R.layout.main_player_cell;
    private final Context context;
    private final Game game;
    private final ArrayList<Player> players;

    public PlayerListAdapter(@NonNull Context context, @NonNull Game game) {
        super(context, LAYOUT, game.getPlayers());
        this.context = context;
        this.game = game;
        this.players = game.getPlayers();
    }

    @Override
    @NonNull
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        final Player player = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(LAYOUT, parent, false);
        }
        EditText nameText = (EditText) view.findViewById(R.id.main_player_cell_select_player_edit_text);
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.equals("")) {
                    players.get(position).setName(editable.toString());
                }
            }
        });
        nameText.setText(player.getName());

        Button removeButton = (Button) view.findViewById(R.id.main_player_cell_select_player_remove_btn);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.removePlayer(position);
                PlayerListAdapter.super.notifyDataSetChanged();
            }
        });

        return view;
    }



//    public View getViewByPosition(int pos, ListView listView) {
//        return listView.getAdapter().getView(pos, null, listView);
//    }

}
