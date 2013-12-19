package com.example.spelldisaster.interfaces;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
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

    private int _currentPage = 1;

    private Button _next;

    private Button _previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        initializePages(inflated);
        setPagesFont();

        initializeNavigationButtons(inflated);
        setNavigationButtonListeners();

        _db = new DataBaseHandler(this);

        _page = _db.getDiaryPage(_currentPage);
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

    private void initializeNavigationButtons(View inflated) {
        _next = (Button) inflated.findViewById(R.id.diary_next);
        _previous = (Button) inflated.findViewById(R.id.diary_previous);
    }

    private void setNavigationButtonListeners() {
        _next.setOnClickListener(this);
        _previous.setOnClickListener(this);
    }

    @Override
    protected void onClickAction(View v) {
        saveDiaryPagesState();
        switch (v.getId()) {
            case R.id.diary_next:
                _currentPage++;
                _page = _db.getDiaryPage(_currentPage);
                _leftPage.setText(_page.getLeftPage());
                _rightPage.setText(_page.getRightPage());
                break;
            case R.id.diary_previous:
                _currentPage = Math.max(1, _currentPage - 1);
                _page = _db.getDiaryPage(_currentPage);
                _leftPage.setText(_page.getLeftPage());
                _rightPage.setText(_page.getRightPage());
                break;
        }
    }

    private void saveDiaryPagesState() {
        _page.setLeftPage(_leftPage.getText().toString());
        _page.setRightPage(_rightPage.getText().toString());
        _db.updateDiaryPage(_page);
    }

}
