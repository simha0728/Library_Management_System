package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewBookLoan extends AppCompatActivity {

    EditText accessNumberEditText, branchIdEditText, cardNumberEditText;
    Button searchBookCopyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_book_loan);

        accessNumberEditText = findViewById(R.id.AccessNumber);
        branchIdEditText = findViewById(R.id.BranchID);
        cardNumberEditText = findViewById(R.id.Cardno);
        searchBookCopyButton = findViewById(R.id.SearchBookCopy);

        searchBookCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the EditTexts
                String accessNumber = accessNumberEditText.getText().toString();
                String branchId = branchIdEditText.getText().toString();
                String cardNumber = cardNumberEditText.getText().toString();

                // Check if any of the EditTexts are empty
                if (!accessNumber.isEmpty() && !branchId.isEmpty() && !cardNumber.isEmpty()) {
                    // Perform the search operation here, for example:
                    searchBookLoan(accessNumber, branchId, cardNumber);
                } else {
                    // If any EditText is empty, show a toast message
                    Toast.makeText(ViewBookLoan.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to perform search operation based on access number, branch ID, and card number
    private void searchBookLoan(String accessNumber, String branchId, String cardNumber) {
        // Here, you can implement the logic to search for the book loan based on the provided details
        // For now, let's just show a toast message with the provided details
        String message = "Searching for book loan with Access Number: " + accessNumber +
                ", Branch ID: " + branchId + ", Card Number: " + cardNumber;
        Toast.makeText(ViewBookLoan.this, message, Toast.LENGTH_SHORT).show();
    }
}
