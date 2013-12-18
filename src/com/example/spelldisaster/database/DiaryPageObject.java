package com.example.spelldisaster.database;

/**
 * @author horodysk
 */
public class DiaryPageObject {
    private int _id;

    private int _page;

    private String _leftPage;

    private String _rightPage;

    /***/
    public DiaryPageObject(int id, int page, String leftPage, String rightPage) {
        _id = id;
        _page = page;
        _leftPage = leftPage;
        _rightPage = rightPage;
    }

    /***/
    public int getId() {
        return _id;
    }

    /***/
    public int getPage() {
        return _page;
    }

    /***/
    public String getLeftPage() {
        return _leftPage;
    }

    /***/
    public void setLeftPage(String leftPage) {
        _leftPage = leftPage;
    }

    /***/
    public String getRightPage() {
        return _rightPage;
    }

    /***/
    public void setRightPage(String rightPage) {
        _rightPage = rightPage;
    }

    @Override
    public String toString() {
        return "Page " + _page;
    }
}
