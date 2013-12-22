package com.example.spelldisaster.inventory.items;

import com.example.spelldisaster.inventory.InventoryItem;

/**
 * @author horodysk
 */
public class ItemPotions extends InventoryItem {

    /***/
    public ItemPotions(int id, int icon, String name, double weight) {
        super(id, icon, name, weight);
    }

    @Override
    public String getType() {
        return "Potion";
    }

}
