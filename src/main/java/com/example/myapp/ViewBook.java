package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ViewBook extends AppCompatActivity {
    private EditText bookIdSearchEdt;
    private TextView searchResultText;
    private DBHandler_book dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_book);

        // Initialize UI components
        bookIdSearchEdt = findViewById(R.id.BookId);
        Button searchButton = findViewById(R.id.SearchBook);
        searchResultText = findViewById(R.id.searchResult);

        // Initialize the database handler
        dbHandler = new DBHandler_book(ViewBook.this);

        // Set up the search button's onClickListener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Retrieve the inputted book ID
                String bookId = bookIdSearchEdt.getText().toString().trim();

                // Check if the book ID input is empty
                if (bookId.isEmpty()) {
                    Toast.makeText(ViewBook.this, "Please enter a book ID.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Attempt to fetch the book from the database
                try {
                    Book book = dbHandler.getBookById(bookId);

                    // If a book was found, display its details
                    if (book != null) {
                        String bookDetails = "Book ID: " + book.getBookId() + "\n"
                                + "Title: " + book.getBookTitle();
                        searchResultText.setText(bookDetails);
                    } else {
                        // If no book was found, display a "not found" message
                        searchResultText.setText("Book not found.");
                    }
                } catch (Exception e) {
                    // Handle any exceptions during the database query
                    Toast.makeText(ViewBook.this, "An error occurred while searching for the book.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
}