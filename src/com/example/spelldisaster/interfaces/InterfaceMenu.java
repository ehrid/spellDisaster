package com.example.spelldisaster.interfaces;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class InterfaceMenu extends BaseInterfaceActivity {

    private Button _exit;

    private Button _settings;

    private Button _diary;

    private Button _inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        initializeButtons(inflated);
        setOnClickListener();
        setButtonsFont();
    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_menu);
        View inflated = stub.inflate();
        return inflated;
    }

    private void initializeButtons(View inflated) {
        _inventory = (Button) inflated.findViewById(R.id.menu_inventory);
        _diary = (Button) inflated.findViewById(R.id.menu_diary);
        _settings = (Button) inflated.findViewById(R.id.menu_settings);
        _exit = (Button) inflated.findViewById(R.id.menu_exit);
    }

    private void setOnClickListener() {
        _inventory.setOnClickListener(this);
        _diary.setOnClickListener(this);
        _settings.setOnClickListener(this);
        _exit.setOnClickListener(this);
    }

    private void setButtonsFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/YouRookMarbelous.ttf");
        _inventory.setTypeface(font);
        _diary.setTypeface(font);
        _settings.setTypeface(font);
        _exit.setTypeface(font);
    }

    @Override
    protected void onClickAction(View v) {
        switch (v.getId()) {
            case R.id.menu_inventory:
                startInventory();
                break;
            case R.id.menu_diary:
                startDiary();
                break;
            case R.id.menu_settings:
                startSettings();
                break;
            case R.id.menu_exit:
                // TODO disconnecting
                finish();
                moveTaskToBack(true);
                break;
        }
    }

    void startInventory() {
        Intent intent = new Intent(InterfaceMenu.this, InterfaceInventory.class);
        startActivity(intent);
        finish();
    }

    void startDiary() {
        Intent intent = new Intent(InterfaceMenu.this, InterfaceDiary.class);
        startActivity(intent);
        finish();
    }

    void startSettings() {
        Intent intent = new Intent(InterfaceMenu.this, InterfaceSettings.class);
        startActivity(intent);
        finish();
    }

}
