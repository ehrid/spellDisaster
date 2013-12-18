package com.example.spelldisaster.interfaces;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;

import com.example.spelldisaster.R;
import com.example.spelldisaster.database.DataBaseHandler;
import com.example.spelldisaster.database.DiaryPageObject;

/**
 * @author horodysk
 */
public class InterfaceDiary extends BaseInterfaceNoFrameActivity {

    private EditText _leftPage;

    private EditText _rightPage;

    private DiaryPageObject _page;

    private DataBaseHandler _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        initializePages(inflated);
        setPagesFont();

        _db = new DataBaseHandler(this);
        _page = _db.getDiaryPage(0);
        _leftPage.setText(_page.getLeftPage());
        _rightPage.setText(_page.getRightPage());
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
        saveDiaryPagesState();
    }

    private void saveDiaryPagesState() {
        _db.updateDiaryPage(_page);
    }

}
