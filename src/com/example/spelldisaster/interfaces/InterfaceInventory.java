package com.example.spelldisaster.interfaces;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class InterfaceInventory extends BaseInterfaceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDialogBackground();

        View inflated = initializeDialogBody();
    }

    private void setDialogBackground() {
        RelativeLayout background = (RelativeLayout) findViewById(R.id.dialog_frame);
        background.setBackgroundResource(R.drawable.style_dialog_paper_background);
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
