package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewBranch extends AppCompatActivity {

    EditText branchIdEditText;
    Button searchBranchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_branch);

        branchIdEditText = findViewById(R.id.BranchId);
        searchBranchButton = findViewById(R.id.SearchBranch);

        searchBranchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the EditText
                String branchId = branchIdEditText.getText().toString();

                // Check if the EditText is empty
                if (!branchId.isEmpty()) {
                    // Perform the search operation here, for example:
                    searchBranch(branchId);
                } else {
                    // If EditText is empty, show a toast message
                    Toast.makeText(ViewBranch.this, "Please enter a branch ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to perform search operation based on the branch ID
    private void searchBranch(String branchId) {
        // Here, you can implement the logic to search for the branch based on the ID
        // For now, let's just show a toast message indicating the branch ID
        Toast.makeText(ViewBranch.this, "Searching for branch with ID: " + branchId, Toast.LENGTH_SHORT).show();
    }
}
