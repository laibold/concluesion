package com.laibold.concluesion.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.Player;

import java.util.ArrayList;

public class PlayerListAdapter extends ArrayAdapter<Player> {

    private final static int LAYOUT = R.layout.main_player_cell;
    private final Context context;
    private final ArrayList<Player> players;

    public PlayerListAdapter(@NonNull Context context, @NonNull ArrayList<Player> players) {
        super(context, LAYOUT, players);
        this.context = context;
        this.players = players;
    }

    @Override
    public void add(@Nullable Player player) {
        players.add(player);
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Nullable
    @Override
    public Player getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        // https://stackoverflow.com/questions/17525886/listview-with-add-and-delete-buttons-in-each-row-in-android
        // just return 0 if your list items do not have an Id variable.
        return 0;
    }

    @Override
    @NonNull
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        final Player player = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(LAYOUT, parent, false);
        }
        final EditText nameText = (EditText) view.findViewById(R.id.main_player_cell_select_player_edit_text);
        nameText.setText(player.getName());

        nameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    if (position < getCount()) {
                        // prevent null pointer when last element has focus and gets deleted
                        String name = nameText.getText().toString();
                        getItem(position).setName(name);
                    }
                }
            }
        });

        Button removeButton = (Button) view.findViewById(R.id.main_player_cell_select_player_remove_btn);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                players.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }

}
