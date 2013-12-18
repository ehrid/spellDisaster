package com.example.spelldisaster.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author horodysk
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "diaryPagesManaged";

    // Contacts table name
    private static final String TABLE_PAGES = "diaryPages";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";

    private static final String KEY_PAGE = "pageNumber";

    private static final String KEY_LEFT = "leftPage";

    private static final String KEY_RIGHT = "rightPage";

    /***/
    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getDiaryPagesCreateTableSQL());
    }

    private String getDiaryPagesCreateTableSQL() {
        return "CREATE TABLE " + TABLE_PAGES + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PAGE + " I," + KEY_LEFT + " TEXT," + KEY_RIGHT + " TEXT" +
            ")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAGES);

        // Create tables again
        onCreate(db);
    }

    /**
     * Adding new page
     */
    public void addDiaryPage(DiaryPageObject page) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PAGE, page.getPage());
        values.put(KEY_LEFT, page.getLeftPage());
        values.put(KEY_RIGHT, page.getRightPage());

        // Inserting Row
        db.insert(TABLE_PAGES, null, values);
        db.close(); // Closing database connection
    }

    /**
     * Getting single page
     */
    public DiaryPageObject getDiaryPage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        DiaryPageObject page = new DiaryPageObject(id, id, "", "");

        Cursor cursor = db.query(TABLE_PAGES, new String[] { KEY_ID, KEY_PAGE, KEY_LEFT, KEY_RIGHT }, KEY_ID + "=?",
            new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            if (cursor.getCount() > 0) {
                page.setLeftPage(cursor.getString(2));
                page.setRightPage(cursor.getString(3));
            }
        }

        return page;
    }

    /**
     * Getting all pages
     */
    public List<DiaryPageObject> getAllDiaryPages() {
        List<DiaryPageObject> diary = new ArrayList<DiaryPageObject>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PAGES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DiaryPageObject page = new DiaryPageObject(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
                    cursor.getString(2), cursor.getString(3));
                diary.add(page);
            }
            while (cursor.moveToNext());
        }

        return diary;
    }

    /**
     * Getting pages count
     */
    public int getPagesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PAGES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    /**
     * Updating single page
     */
    public int updateDiaryPage(DiaryPageObject page) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PAGE, page.getPage());
        values.put(KEY_LEFT, page.getLeftPage());
        values.put(KEY_RIGHT, page.getRightPage());

        // updating row
        return db.update(TABLE_PAGES, values, KEY_ID + " = ?", new String[] { String.valueOf(page.getId()) });

    }

    /**
     * Deleting single page
     */
    public void deleteContact(DiaryPageObject page) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PAGES, KEY_ID + " = ?", new String[] { String.valueOf(page.getId()) });
        db.close();
    }
}
