package com.example.spelldisaster.inventory;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class InventoryListViewAdapter extends ArrayAdapter<InventoryItem> {

    private int _resource;

    /***/
    public InventoryListViewAdapter(Context context, int resource, List<InventoryItem> items) {
        super(context, resource, items);
        _resource = resource;

    }

    /***/
    public InventoryItem getEvent(int position) {
        return getItem(position);
    }

    @Override
    public boolean isEnabled(@SuppressWarnings("unused") int position) {
        return false;
    }

    @Override
    public View getView(int position, View convertView, @SuppressWarnings("unused") ViewGroup parent) {
        LinearLayout inventoryItemView = inflateTheView(convertView);
        initializeVIewItems(position, inventoryItemView);

        return inventoryItemView;
    }

    private LinearLayout inflateTheView(View convertView) {
        LinearLayout inventoryItemView;
        if (convertView == null) {
            inventoryItemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(_resource, inventoryItemView, true);
        }
        else {
            inventoryItemView = (LinearLayout) convertView;
        }
        return inventoryItemView;
    }

    private void initializeVIewItems(int position, LinearLayout inventoryItemView) {
        InventoryItem item = getItem(position);

        ImageView icon = (ImageView) inventoryItemView.findViewById(R.id.inventory_item_icon);
        TextView name = (TextView) inventoryItemView.findViewById(R.id.inventory_item_name);
        TextView weight = (TextView) inventoryItemView.findViewById(R.id.inventory_item_weight);

        icon.setImageResource(item.getIcon());
        name.setText(item.getName());
        weight.setText(Double.toString(item.getWeight()));

        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/LibbyHand.ttf");
        name.setTypeface(font);
        weight.setTypeface(font);

    }

}