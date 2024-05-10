package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewBookCopy extends AppCompatActivity {

    EditText bookIdEditText, branchIdEditText;
    Button searchBookCopyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_book_copy);

        bookIdEditText = findViewById(R.id.BookId);
        branchIdEditText = findViewById(R.id.BranchId);
        searchBookCopyButton = findViewById(R.id.SearchBookCopy);

        searchBookCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the EditTexts
                String bookId = bookIdEditText.getText().toString();
                String branchId = branchIdEditText.getText().toString();

                // Check if any of the EditTexts are empty
                if (!bookId.isEmpty() && !branchId.isEmpty()) {
                    // Perform the search operation here, for example:
                    searchBookCopy(bookId, branchId);
                } else {
                    // If any EditText is empty, show a toast message
                    Toast.makeText(ViewBookCopy.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to perform search operation based on the book ID and branch ID
    private void searchBookCopy(String bookId, String branchId) {
        // Here, you can implement the logic to search for the book copy based on the provided details
        // For now, let's just show a toast message with the provided details
        String message = "Searching for book copy with Book ID: " + bookId + ", Branch ID: " + branchId;
        Toast.makeText(ViewBookCopy.this, message, Toast.LENGTH_SHORT).show();
    }
}
