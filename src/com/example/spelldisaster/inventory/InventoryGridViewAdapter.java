package com.example.spelldisaster.inventory;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class InventoryGridViewAdapter extends ArrayAdapter<InventoryItem> {
    private Context _context;

    private int _layoutResourceId;

    private List<InventoryItem> _data = new ArrayList<InventoryItem>();

    /***/
    public InventoryGridViewAdapter(Context context, int layoutResourceId, List<InventoryItem> data) {
        super(context, layoutResourceId, data);
        _context = context;
        _layoutResourceId = layoutResourceId;
        _data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageView imageItem = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            row = inflater.inflate(_layoutResourceId, parent, false);
            imageItem = (ImageView) row.findViewById(R.id.inventory_item);
            row.setTag(imageItem);
        }
        else {
            imageItem = (ImageView) row.getTag();
        }
        InventoryItem item = _data.get(position);
        imageItem.setImageResource(item.getImage());
        return row;
    }
}
