package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewPublisher extends AppCompatActivity {

    EditText nameEditText;
    Button searchPublisherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_publisher);

        nameEditText = findViewById(R.id.Name);
        searchPublisherButton = findViewById(R.id.SearchPublisher);

        searchPublisherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the EditText
                String name = nameEditText.getText().toString();

                // Check if the EditText is empty
                if (!name.isEmpty()) {
                    // Perform the search operation here, for example:
                    searchPublisher(name);
                } else {
                    // If EditText is empty, show a toast message
                    Toast.makeText(ViewPublisher.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to perform search operation based on the publisher name
    private void searchPublisher(String name) {
        // Here, you can implement the logic to search for the publisher based on the name
        // For now, let's just show a toast message indicating the name
        Toast.makeText(ViewPublisher.this, "Searching for publisher with name: " + name, Toast.LENGTH_SHORT).show();
    }
}
