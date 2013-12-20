package com.example.spelldisaster.interfaces;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.spelldisaster.R;
import com.example.spelldisaster.inventory.InventoryItem;
import com.example.spelldisaster.inventory.InventoryListViewAdapter;

/**
 * @author horodysk
 */
public class InterfaceInventory extends BaseInterfaceNoFrameActivity {

    List<InventoryItem> gridArray = new ArrayList<InventoryItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        changeBaseLayoutPossition();

        ListView container = (ListView) inflated.findViewById(R.id.inventory_countainer);

        List<InventoryItem> items = new ArrayList<InventoryItem>();
        items.add(new InventoryItem(1, R.drawable.ic_launcher, "Item 1", 10.1));
        items.add(new InventoryItem(2, R.drawable.ic_launcher, "Item 2", 11.1));
        items.add(new InventoryItem(3, R.drawable.ic_launcher, "Item 3", 1.1));
        items.add(new InventoryItem(4, R.drawable.ic_launcher, "Item 4", 99.2));
        items.add(new InventoryItem(5, R.drawable.ic_launcher, "Item 5", 0.1));
        items.add(new InventoryItem(6, R.drawable.ic_launcher, "Item 6", 0.1));
        items.add(new InventoryItem(7, R.drawable.ic_launcher, "Item 7", 0.1));
        items.add(new InventoryItem(8, R.drawable.ic_launcher, "Item 8", 999.9));
        items.add(new InventoryItem(9, R.drawable.ic_launcher, "Item 9", 120.1));

        InventoryListViewAdapter adapter = new InventoryListViewAdapter(this, R.layout.dialog_inventory_item, items);
        container.setAdapter(adapter);

    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_inventory);
        View inflated = stub.inflate();
        return inflated;
    }

    private void changeBaseLayoutPossition() {
        RelativeLayout frame = (RelativeLayout) findViewById(R.id.dialog_frame);

        // TODO changeing possition
    }

    @Override
    protected void onClickAction(View v) {
        // TODO Auto-generated method stub

    }
}
