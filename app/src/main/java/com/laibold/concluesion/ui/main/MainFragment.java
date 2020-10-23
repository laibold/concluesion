package com.laibold.concluesion.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.model.Player;

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
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        final Game game = new Game();
        game.addPlayer(new Player("Player1"));
        game.addPlayer(new Player("Player2"));
        mViewModel.setGame(game);
        // TODO: Use the ViewModel

        final PlayerListAdapter adapter = new PlayerListAdapter(getContext(), mViewModel.getGame().getValue());
        final ListView listView = getView().findViewById(R.id.main_players_list_view);
        listView.setAdapter(adapter);

        final Button btnAddMore = new Button(getContext());
        btnAddMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.addPlayer(new Player(""));
                adapter.notifyDataSetChanged();

//                View lastCellElement = adapter.getViewByPosition(listView.getChildCount() - 1, listView);
//                EditText lastEditTextElement = lastCellElement.findViewById(R.id.main_player_cell_select_player_edit_text);
//                lastEditTextElement.requestFocus();
//                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(lastEditTextElement, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        btnAddMore.setText("+");
        listView.addFooterView(btnAddMore);
    }

}
