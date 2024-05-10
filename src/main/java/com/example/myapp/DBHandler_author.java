package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_author extends SQLiteOpenHelper {
    private static final String DB_NAME = "authordb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "author";
    private static final String BOOKID_COL = "BookId";
    private static final String AUTHORNAME_COL = "AuthorName";
    public DBHandler_author(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + BOOKID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AUTHORNAME_COL + "TEXT)";

        db.execSQL(query);
    }
    public void addnewauthor(String bookid, String authorname) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(BOOKID_COL, bookid);
        values.put(AUTHORNAME_COL, authorname);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void DeleteAuthor(String bookid) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting Row
        db.delete(TABLE_NAME, BOOKID_COL + " = ?", new String[]{String.valueOf(bookid)});
        db.close();
    }

    public int UpdateAuthor(String bookid, String authorname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOKID_COL, bookid);
        values.put(AUTHORNAME_COL, authorname);

        // Updating Row
        return db.update(TABLE_NAME, values, BOOKID_COL + " = ?", new String[]{String.valueOf(bookid)});
    }
}
