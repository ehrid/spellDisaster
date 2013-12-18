package com.example.spelldisaster.interfaces;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class InterfaceDiary extends BaseInterfaceNoFrameActivity {

    private EditText _leftPage;

    private EditText _rightPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        initializePages(inflated);
        setPagesFont();

    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_diary);
        View inflated = stub.inflate();
        return inflated;
    }

    private void initializePages(View inflated) {
        _leftPage = (EditText) inflated.findViewById(R.id.diary_left);
        _rightPage = (EditText) inflated.findViewById(R.id.diary_right);
    }

    private void setPagesFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ASafePlacetoFall.ttf");
        _leftPage.setTypeface(font);
        _rightPage.setTypeface(font);
    }

    @Override
    protected void onClickAction(View v) {
        // fill
    }

}
