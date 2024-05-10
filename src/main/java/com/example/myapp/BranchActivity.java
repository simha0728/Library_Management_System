package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BranchActivity extends AppCompatActivity {
    private EditText BranchId, BranchName, Address;
    private Button AddBranch, UpdateBranch, DeleteBranch, ViewBranch;
    private DBHandler_branch dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branch);


        //Option 1 : View Branch
        Button view = findViewById(R.id.ViewBranch);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BranchActivity.this, ViewBranch.class);
                startActivity(intent);
            }
        });


        // initializing all our variables.
        BranchId = findViewById(R.id.BranchId);
        BranchName = findViewById(R.id.BranchName);
        Address = findViewById(R.id.Address);
        AddBranch = findViewById(R.id.AddBranch);
        UpdateBranch = findViewById(R.id.UpdateBranch);
        DeleteBranch = findViewById(R.id.DeleteBranch);
        ViewBranch = findViewById(R.id.ViewBranch);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler_branch(BranchActivity.this);

        //Option 2 : Add Branch
        AddBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String branchid = BranchId.getText().toString();
                String branchname = BranchName.getText().toString();
                String address = Address.getText().toString();

                // validating if the text fields are empty or not.
                if (branchid.isEmpty() && branchname.isEmpty() && address.isEmpty()) {
                    Toast.makeText(BranchActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.AddBranch(branchid, branchname, address);

                // after adding the data we are displaying a toast message.
                Toast.makeText(BranchActivity.this, "Branch has been added.", Toast.LENGTH_SHORT).show();
                BranchId.setText("");
                BranchName.setText("");
                Address.setText("");
            }
        });

        //Option 2 : Update Branch
        UpdateBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String branchid = BranchId.getText().toString();
                String branchname = BranchName.getText().toString();
                String address = Address.getText().toString();

                // validating if the text fields are empty or not.
                if (branchid.isEmpty() && branchname.isEmpty() && address.isEmpty()) {
                    Toast.makeText(BranchActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.UpdateBranch(branchid, branchname, address);

                // after adding the data we are displaying a toast message.
                Toast.makeText(BranchActivity.this, "Branch has been updated.", Toast.LENGTH_SHORT).show();
                BranchId.setText("");
                BranchName.setText("");
                Address.setText("");
            }
        });

        //Option 3 : Delete Branch
        DeleteBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String branchid = BranchId.getText().toString();
                String branchname = BranchName.getText().toString();
                String address = Address.getText().toString();

                // validating if the text fields are empty or not.
                if (branchid.isEmpty() && branchname.isEmpty() && address.isEmpty()) {
                    Toast.makeText(BranchActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.DeleteBranch(branchid);

                // after adding the data we are displaying a toast message.
                Toast.makeText(BranchActivity.this, "Branch has been deleted.", Toast.LENGTH_SHORT).show();
                BranchId.setText("");
                BranchName.setText("");
                Address.setText("");
            }
        });
    }
}
