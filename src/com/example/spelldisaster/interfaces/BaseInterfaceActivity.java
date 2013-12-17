package com.example.spelldisaster.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.spelldisaster.R;
import com.example.spelldisaster.activities.MenuActivity;

/**
 * @author horodysk
 */
public class BaseInterfaceActivity extends Activity implements OnClickListener {

    ImageView button_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_settings = (ImageView) findViewById(R.id.button_settings);
        button_settings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_settings:
                Intent intent = new Intent(BaseInterfaceActivity.this, MenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
