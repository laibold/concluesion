package com.laibold.concluesion.ui.deck;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.laibold.concluesion.R;
import com.laibold.concluesion.model.card.Card;

import java.util.HashMap;
import java.util.List;

public class DeckListAdapter extends BaseExpandableListAdapter {

    private final static int GROUP_LAYOUT = R.layout.deck_list_group;
    private final static int CELL_LAYOUT = R.layout.deck_list_cell;
    private final List<String> groupList;
    private final HashMap<String, List<Card>> itemMap;
    private final Context context;

    public DeckListAdapter(Context context, List<String> groupList, HashMap<String, List<Card>> itemMap) {
        this.context = context;
        this.groupList = groupList;
        this.itemMap = itemMap;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPos) {
        return itemMap.get(getGroup(groupPos)).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int groupPos, int childPos) {
        return itemMap.get(getGroup(groupPos)).get(childPos);
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
    }

    @Override
    public long getChildId(int groupPos, int childPos) {
        return childPos;
    }

    @Override
    public boolean hasStableIds() {
        // returns if the ids are specific ( unique for each group or item)
        // or relatives
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(GROUP_LAYOUT, null);
        }

        TextView groupNameText = convertView.findViewById(R.id.deck_fragment_group_name);
        TextView groupNumberText = convertView.findViewById(R.id.deck_fragment_group_number);

        groupNameText.setText((String) getGroup(groupPos));
        groupNumberText.setText("");

        return convertView;
    }

    @Override
    public View getChildView(final int groupPos, final int childPos, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(CELL_LAYOUT, null);
        }

        TextView itemNameText = convertView.findViewById(R.id.deck_fragment_cell_name);

        Card card = (Card) getChild(groupPos, childPos);
        itemNameText.setText(card.getName());
        if (card.isChecked()) {
            itemNameText.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            itemNameText.setPaintFlags(itemNameText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card card = (Card) getChild(groupPos, childPos);
                card.toggleChecked();
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPos, int childPos) {
        return true;
    }

}
