package com.example.spelldisaster.interfaces;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.GridView;

import com.example.spelldisaster.R;
import com.example.spelldisaster.inventory.InventoryGridViewAdapter;
import com.example.spelldisaster.inventory.InventoryItem;

/**
 * @author horodysk
 */
public class InterfaceInventory extends BaseInterfaceActivity {

    List<InventoryItem> gridArray = new ArrayList<InventoryItem>();

    InventoryGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();

        View inventory = inflated.findViewById(R.id.inventory);
        GridView container = (GridView) inventory.findViewById(R.id.inventory_countainer);

        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());
        gridArray.add(new InventoryItem());

        customGridAdapter = new InventoryGridViewAdapter(this, R.layout.inventory_item, gridArray);
        container.setAdapter(customGridAdapter);

    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_inventory);
        View inflated = stub.inflate();
        return inflated;
    }

    @Override
    protected void onClickAction(View v) {
        // TODO Auto-generated method stub

    }
}
