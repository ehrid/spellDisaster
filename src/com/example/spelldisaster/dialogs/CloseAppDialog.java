package com.example.spelldisaster.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.spelldisaster.R;
import com.example.spelldisaster.activity.MainActivity;

/**
 * @author horodysk
 */
public class CloseAppDialog extends Dialog implements android.view.View.OnClickListener {
    MainActivity rootView;

    /***/
    public CloseAppDialog(Context context) {
        super(context);
        rootView = (MainActivity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        // buttons
        }
    }
}
