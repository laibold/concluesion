package com.laibold.concluesion.ui.deck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.Game;
import com.laibold.concluesion.model.GameEdition;
import com.laibold.concluesion.model.card.Card;
import com.laibold.concluesion.model.card.CardType;
import com.laibold.concluesion.model.card.Deck;
import com.laibold.concluesion.service.DeckBuilder;
import com.laibold.concluesion.ui.main.MainViewModel;

import java.util.HashMap;
import java.util.List;

public class DeckFragment extends Fragment {

    private MainViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.deck_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        initListView();
    }

    /**
     * Creates ListAdapter for ExpandableListView and fills it
     */
    private void initListView() {
        Game game = mViewModel.getGame().getValue();
        assert game != null;
        Deck deck = game.getDeck();

        List<String> typeList = CardType.toStringList();
        HashMap<String, List<Card>> cardMap = deck.getCardMap();

        DeckListAdapter deckListAdapter = new DeckListAdapter(getContext(), typeList, cardMap);
        ExpandableListView expListView = getView().findViewById(R.id.deck_fragment_list_view);
        expListView.setAdapter(deckListAdapter);
    }
}
