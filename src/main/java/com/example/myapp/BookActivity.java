package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {
    private EditText BookId, Title, PublisherName;
    private Button AddBook, UpdateBook, DeleteBook, ViewBook;
    private DBHandler_book dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books);

        // initializing all our variables.
        BookId = findViewById(R.id.BookId);
        Title = findViewById(R.id.Title);
        PublisherName = findViewById(R.id.PublisherName);
        AddBook = findViewById(R.id.AddBook);
        UpdateBook = findViewById(R.id.UpdateBook);
        DeleteBook = findViewById(R.id.DeleteBook);
        ViewBook = findViewById(R.id.ViewBook);

        dbHandler = new DBHandler_book(BookActivity.this);

        UpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookId = BookId.getText().toString().trim();
                String title = Title.getText().toString().trim();
                String publisher = PublisherName.getText().toString().trim();

                if (bookId.isEmpty() && title.isEmpty() && publisher.isEmpty()) {
                    Toast.makeText(BookActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

              dbHandler.UpdateBook(bookId, title, publisher);

                Toast.makeText(BookActivity.this, "Book has been updated.", Toast.LENGTH_SHORT).show();
                BookId.setText("");
                Title.setText("");
                PublisherName.setText("");
            }
        });

        DeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookId = BookId.getText().toString().trim();

                if (bookId.isEmpty()) {
                    Toast.makeText(BookActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.DeleteBook(bookId);

                Toast.makeText(BookActivity.this, "Book has been deleted.", Toast.LENGTH_SHORT).show();
                BookId.setText("");
                Title.setText("");
                PublisherName.setText("");
            }
        });

        //Option 1 : View Book
        Button view = findViewById(R.id.ViewBook);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, ViewBook.class);
                startActivity(intent);
            }
        });

        //Option 2 : Add Book
        AddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String bookid = BookId.getText().toString();
                String title = Title.getText().toString();
                String publishername = PublisherName.getText().toString();

                // validating if the text fields are empty or not.
                if (bookid.isEmpty() && title.isEmpty() && publishername.isEmpty()) {
                    Toast.makeText(BookActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addnewbook(bookid, title, publishername);

                // after adding the data we are displaying a toast message.
                Toast.makeText(BookActivity.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                BookId.setText("");
                Title.setText("");
                PublisherName.setText("");
            }
        });
    }
}

