package com.example.spelldisaster.interfaces;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;

import com.example.spelldisaster.R;
import com.example.spelldisaster.inventory.InventoryItem;
import com.example.spelldisaster.inventory.InventoryListViewAdapter;

/**
 * @author horodysk
 */
public class InterfaceInventory extends BaseInterfaceDoubleViewsNoFrameActivity {

    List<InventoryItem> _items = new ArrayList<InventoryItem>();

    private ListView _container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();

        initializeContainer(inflated);
        addItems();
        setContainerAdapter();
    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_inventory);
        View inflated = stub.inflate();
        return inflated;
    }

    private void initializeContainer(View inflated) {
        _container = (ListView) inflated.findViewById(R.id.inventory_countainer);
    }

    private void addItems() {
        _items.add(new InventoryItem(1, R.drawable.icon_arrow, "Arrow", 10.1));
        _items.add(new InventoryItem(2, R.drawable.icon_axe, "Axe", 11.1));
        _items.add(new InventoryItem(3, R.drawable.icon_beer, "Beer", 1.1));
        _items.add(new InventoryItem(4, R.drawable.icon_bow, "Bow", 99.2));
        _items.add(new InventoryItem(5, R.drawable.icon_letter, "12 April, Adam", 0.1));
        _items.add(new InventoryItem(6, R.drawable.icon_mace, "Mace", 0.1));
        _items.add(new InventoryItem(7, R.drawable.icon_mandrake_root, "Mandrake root", 0.1));
        _items.add(new InventoryItem(8, R.drawable.icon_map, "Treasure map", 999.9));
        _items.add(new InventoryItem(9, R.drawable.icon_steel_armor, "Steel armor", 120.1));
        _items.add(new InventoryItem(10, R.drawable.icon_steel_boots, "Steel boots", 120.1));
        _items.add(new InventoryItem(11, R.drawable.icon_steel_gauntlets, "Steel gauntlets", 120.1));
        _items.add(new InventoryItem(12, R.drawable.icon_steel_greaves, "Steel greaves", 120.1));
        _items.add(new InventoryItem(13, R.drawable.icon_steel_helmet, "Steel helmet", 120.1));
        _items.add(new InventoryItem(14, R.drawable.icon_steel_shield, "Steel shield", 120.1));
        _items.add(new InventoryItem(15, R.drawable.icon_book, "Cook book", 99.2));
    }

    private void setContainerAdapter() {
        InventoryListViewAdapter adapter = new InventoryListViewAdapter(this, R.layout.dialog_inventory_item, _items);
        _container.setAdapter(adapter);
    }

    @Override
    protected void onClickAction(View v) {
        // TODO Auto-generated method stub

    }
}
