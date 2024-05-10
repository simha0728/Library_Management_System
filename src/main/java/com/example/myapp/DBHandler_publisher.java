package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_publisher extends SQLiteOpenHelper {
    private static final String DB_NAME = "publisherdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "publisher";
    private static final String PUBLISHERNAME_COL = "PublisherName";
    private static final String ADDRESS_COL = "Address";
    private static final String PHONENUMBER_COL = "PhoneNumber";
    public DBHandler_publisher(Context context) {
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
                + PUBLISHERNAME_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ADDRESS_COL + " TEXT,"
                + PHONENUMBER_COL + "TEXT)";

        db.execSQL(query);
    }
    public void addnewpublisher(String publishername, String address, String phonenumber) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PUBLISHERNAME_COL, publishername);
        values.put(ADDRESS_COL, address);
        values.put(PHONENUMBER_COL, phonenumber);

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

    public void DeletePublisher(String publishername) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting Row
        db.delete(TABLE_NAME, PUBLISHERNAME_COL + " = ?", new String[]{String.valueOf(publishername)});
        db.close();
    }

    public int UpdatePublisher(String publishername, String address, String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PUBLISHERNAME_COL, publishername);
        values.put(ADDRESS_COL, address);
        values.put(PHONENUMBER_COL, phonenumber);

        // Updating Row
        return db.update(TABLE_NAME, values, PUBLISHERNAME_COL + " = ?", new String[]{String.valueOf(publishername)});
    }
}
