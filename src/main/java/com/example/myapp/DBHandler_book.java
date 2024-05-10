package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHandler_book extends SQLiteOpenHelper {
    private static final String DB_NAME = "bookdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "book";
    private static final String BOOKID_COL = "Book_Id";
    private static final String TITLE_COL = "Title";
    private static final String PUBLISHERNAME_COL = "Publisher_Name";

    public DBHandler_book(Context context) {
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
                + TITLE_COL + " TEXT,"
                + PUBLISHERNAME_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addnewbook(String bookId, String title, String publisherName) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(BOOKID_COL, bookId);
        values.put(TITLE_COL, title);
        values.put(PUBLISHERNAME_COL, publisherName);

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

    public void DeleteBook(String bookId) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Deleting Row
        db.delete(TABLE_NAME, BOOKID_COL + " = ?", new String[]{String.valueOf(bookId)});
        db.close();
    }

    public int UpdateBook(String bookId, String title, String publisher) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOKID_COL, bookId);
        values.put(TITLE_COL, title);
        values.put(PUBLISHERNAME_COL, publisher);
        // Updating Row
        return db.update(TABLE_NAME, values, BOOKID_COL + " = ?", new String[]{String.valueOf(bookId)});
    }

    @SuppressLint("Range")
    public Book getBookById(String bookId) {
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = this.getReadableDatabase();

            // Query to find the book by ID
            cursor = db.query(
                    TABLE_NAME,
                    null,
                    BOOKID_COL + " = ?",
                    new String[]{bookId},
                    null,
                    null,
                    null
            );

            // Check if the cursor contains a valid record
            if (cursor != null && ((Cursor) cursor).moveToFirst()) {
                // Create a new book object and set its fields
                Book book = new Book();
                book.setBookid(cursor.getString(cursor.getColumnIndex(BOOKID_COL)));
                book.setBookTitle(cursor.getString(cursor.getColumnIndex(TITLE_COL)));
                book.setPublisherName(cursor.getString(cursor.getColumnIndex(PUBLISHERNAME_COL)));

                return book;
            }

            return null; // No book found
        } finally {
            // Ensure resources are closed properly
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
    }
}
