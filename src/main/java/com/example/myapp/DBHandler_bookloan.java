package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_bookloan extends SQLiteOpenHelper {
    private static final String DB_NAME = "bookloandb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "bookloan";
    private static final String ACCESSNUMBER_COL = "AccessNumber";
    private static final String BRANCHID_COL = "BranchId";
    private static final String CARDNUMBER_COL = "CardNumber";
    private static final String DATEOUT_COL = "DateOut";
    private static final String DATEDUE_COL = "DateDue";
    private static final String DATERETURNED_COL = "DateReturned";
    public DBHandler_bookloan(Context context) {
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
                + ACCESSNUMBER_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BRANCHID_COL + " TEXT,"
                + CARDNUMBER_COL + " TEXT,"
                + DATEOUT_COL + " TEXT,"
                + DATEDUE_COL + " TEXT,"
                + DATERETURNED_COL + "TEXT)";

        db.execSQL(query);
    }
    public void addnewbookloan(String accessnumber, String branchid, String cardnumber, String dateout, String datedue, String datereturned) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ACCESSNUMBER_COL, accessnumber);
        values.put(BRANCHID_COL, branchid);
        values.put(CARDNUMBER_COL, cardnumber);
        values.put(DATEOUT_COL, dateout);
        values.put(DATEDUE_COL, datedue);
        values.put(DATERETURNED_COL, datereturned);

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

    public void DeleteBookLoan(String accessnumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting Row
        db.delete(TABLE_NAME, ACCESSNUMBER_COL + " = ?", new String[]{String.valueOf(accessnumber)});
        db.close();
    }

    public int UpdateBookLoan(String accessnumber, String branchid, String cardnumber, String dateout, String datedue, String datereturned) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ACCESSNUMBER_COL, accessnumber);
        values.put(BRANCHID_COL, branchid);
        values.put(CARDNUMBER_COL, cardnumber);
        values.put(DATEOUT_COL, dateout);
        values.put(DATEDUE_COL, datedue);
        values.put(DATERETURNED_COL, datereturned);

        // Updating Row
        return db.update(TABLE_NAME, values, ACCESSNUMBER_COL + " = ?", new String[]{String.valueOf(accessnumber)});
    }
}
