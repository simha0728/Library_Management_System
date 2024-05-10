package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

public class view_member extends AppCompatActivity {

    EditText cardNumberEditText;
    Button searchMemberButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

        cardNumberEditText = findViewById(R.id.CardNumber);
        searchMemberButton = findViewById(R.id.SearchMember);

        searchMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the EditText
                String cardNumber = cardNumberEditText.getText().toString();

                // Check if the EditText is empty
                if (!cardNumber.isEmpty()) {
                    // Perform the search operation here, for example:
                    searchMember(cardNumber);
                } else {
                    // If EditText is empty, show a toast message
                    Toast.makeText(view_member.this, "Please enter a card number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to perform search operation based on the card number
    private void searchMember(String cardNumber) {
        // Here, you can implement the logic to search for the member based on the card number
        // For now, let's just show a toast message indicating the card number
        Toast.makeText(view_member.this, "Searching for member with card number: " + cardNumber, Toast.LENGTH_SHORT).show();
    }
}
