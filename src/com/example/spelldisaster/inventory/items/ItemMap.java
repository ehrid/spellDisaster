package com.example.spelldisaster.inventory.items;

import com.example.spelldisaster.inventory.InventoryItem;

/**
 * @author horodysk
 */
public class ItemMap extends InventoryItem {

    /***/
    public ItemMap(int id, int icon, String name, double weight) {
        super(id, icon, name, weight);
    }

    @Override
    public String getType() {
        return "Map";
    }

}
