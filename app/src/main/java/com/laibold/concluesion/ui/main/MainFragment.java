package com.laibold.concluesion.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.model.Player;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        final Game game = new Game();
        mViewModel.setGame(game);

        ArrayList<Player> gamePlayers = mViewModel.getGame().getValue().getPlayers();
        final PlayerListAdapter adapter = new PlayerListAdapter(getContext(), gamePlayers);
        final ListView listView = getView().findViewById(R.id.main_players_list_view);
        listView.setAdapter(adapter);

        final Button btnAddPlayer = new Button(getContext());
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                adapter.add(new Player(""));
                adapter.notifyDataSetChanged();
            }
        });

        btnAddPlayer.setText("+");
        listView.addFooterView(btnAddPlayer);
    }

}
