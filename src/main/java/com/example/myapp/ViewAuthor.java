package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewAuthor extends AppCompatActivity {

    EditText authorNameEditText;
    Button searchAuthorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_author);

        authorNameEditText = findViewById(R.id.AuthorName);
        searchAuthorButton = findViewById(R.id.SearchAuthor);

        searchAuthorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the EditText
                String authorName = authorNameEditText.getText().toString();

                // Check if the EditText is empty
                if (!authorName.isEmpty()) {
                    // Perform the search operation here, for example:
                    searchAuthor(authorName);
                } else {
                    // If EditText is empty, show a toast message
                    Toast.makeText(ViewAuthor.this, "Please enter an author name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to perform search operation based on the author name
    private void searchAuthor(String authorName) {
        // Here, you can implement the logic to search for the author based on the name
        // For now, let's just show a toast message indicating the author name
        Toast.makeText(ViewAuthor.this, "Searching for author with name: " + authorName, Toast.LENGTH_SHORT).show();
    }
}
