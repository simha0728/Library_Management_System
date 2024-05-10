package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_branch extends SQLiteOpenHelper {
    private static final String DB_NAME = "branchdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "branch";
    private static final String BRANCHID_COL = "BranchID";
    private static final String BRANCHNAME_COL = "BranchName";
    private static final String ADDRESS_COL = "Address";
    public DBHandler_branch(Context context) {
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
                + BRANCHID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BRANCHNAME_COL + " TEXT,"
                + ADDRESS_COL + "TEXT)";

        db.execSQL(query);
    }
    public void AddBranch(String branchid, String branchname, String address) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(BRANCHID_COL, branchid);
        values.put(BRANCHNAME_COL, branchname);
        values.put(ADDRESS_COL, address);

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

    public void DeleteBranch(String branchid) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting Row
        db.delete(TABLE_NAME, BRANCHID_COL + " = ?", new String[]{String.valueOf(branchid)});
        db.close();
    }

    public int UpdateBranch(String branchid, String branchname, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BRANCHID_COL, branchid);
        values.put(BRANCHNAME_COL, branchname);
        values.put(ADDRESS_COL, address);

        // Updating Row
        return db.update(TABLE_NAME, values, BRANCHID_COL + " = ?", new String[]{String.valueOf(branchid)});
    }
}
