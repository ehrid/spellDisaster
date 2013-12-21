package com.example.spelldisaster.interfaces;

import android.os.Bundle;
import android.view.View;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public abstract class BaseInterfaceDoubleViewsNoFrameActivity extends BaseInterfaceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_base_double_no_frame);
        initializeBaseItems();
    }

    @Override
    protected abstract void onClickAction(View v);
}
