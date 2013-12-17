package com.example.spelldisaster.interfaces;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class BaseInterfaceActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_basic);

        // close button
        ImageView close = (ImageView) findViewById(R.id.button_close);
        close.setOnClickListener(this);

        // unclickable body
        RelativeLayout body = (RelativeLayout) findViewById(R.id.dialog_frame);
        body.setOnClickListener(this);

        // exit dialog upon clicking outside body
        RelativeLayout background = (RelativeLayout) findViewById(R.id.dialog_background);
        background.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_close:
                finish();
                break;
            case R.id.dialog_frame:
                // needs to be above R.id.dialog_background
                break;
            case R.id.dialog_background:
                finish();
                break;
        }
    }
}
