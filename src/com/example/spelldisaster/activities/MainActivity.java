package com.example.spelldisaster.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.spelldisaster.R;
import com.example.spelldisaster.interfaces.InterfaceMenu;

/**
 * @author horodysk
 */
public class MainActivity extends Activity implements OnClickListener {

    ImageView button_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_settings = (ImageView) findViewById(R.id.button_settings);
        button_settings.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            startSettings();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_settings:
                startSettings();
                break;
        }
    }

    private void startSettings() {
        Intent intent = new Intent(MainActivity.this, InterfaceMenu.class);
        startActivity(intent);
    }
}
