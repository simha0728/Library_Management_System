package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_member extends SQLiteOpenHelper {
    private static final String DB_NAME = "memberdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "member";
    private static final String CARDNUMBER_COL = "CardNumber";
    private static final String NAME_COL = "Name";
    private static final String ADDRESS_COL = "Address";
    private static final String PHONENUMBER_COL = "Phone_Number";
    private static final String UNPAIDDUES_COL = "Unpaid_Dues";
    public DBHandler_member(Context context) {
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
                + CARDNUMBER_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + PHONENUMBER_COL + "TEXT,"
                + UNPAIDDUES_COL + "TEXT)";

        db.execSQL(query);
    }
    public void addnewmember(String cardNumber, String name, String address, String phone_number, String unpaid_dues) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(CARDNUMBER_COL, cardNumber);
        values.put(NAME_COL, name);
        values.put(ADDRESS_COL, address);
                values.put(PHONENUMBER_COL, phone_number);
                values.put(UNPAIDDUES_COL, unpaid_dues);

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

    public void DeleteMember(String cardNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting Row
        db.delete(TABLE_NAME, CARDNUMBER_COL + " = ?", new String[]{String.valueOf(cardNumber)});
        db.close();
    }

    public int UpdateMember(String cardNumber, String name, String address, String phonenumber, String unpaiddues) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CARDNUMBER_COL, cardNumber);
        values.put(NAME_COL, name);
        values.put(ADDRESS_COL, address);
        values.put(PHONENUMBER_COL, phonenumber);
        values.put(UNPAIDDUES_COL, unpaiddues);
        // Updating Row
        return db.update(TABLE_NAME, values, CARDNUMBER_COL + " = ?", new String[]{String.valueOf(cardNumber)});
    }
}
