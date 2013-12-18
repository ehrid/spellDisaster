package com.example.spelldisaster.interfaces;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class InterfaceDiary extends BaseInterfaceNoFrameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();

        // fill
    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_diary);
        View inflated = stub.inflate();
        return inflated;
    }

    @Override
    protected void onClickAction(View v) {
        // fill
    }

}
