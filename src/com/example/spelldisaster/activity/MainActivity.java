package com.example.spelldisaster.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class MainActivity extends Activity {

    ImageView controller_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
