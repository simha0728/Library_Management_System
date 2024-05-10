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

public class BookLoanActivity extends AppCompatActivity {
    private EditText AccessNumber, BranchId, CardNumber, DateOut, DateDue, DateReturned;
    private Button AddBookLoan, UpdateBookLoan, DeleteBookLoan, ViewBookLoan;
    private DBHandler_bookloan dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_loan);

        /*
        //Option 1 : View BookLoan
        Button view = findViewById(R.id.ViewBookLoan);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookLoanActivity.this, ViewBookLoan.class);
                startActivity(intent);
            }
        });
*/

        // initializing all our variables.
        AccessNumber = findViewById(R.id.AccessNumber);
        BranchId = findViewById(R.id.BranchId);
        CardNumber = findViewById(R.id.CardNumber);
        DateOut = findViewById(R.id.DateOut);
        DateDue = findViewById(R.id.DateDue);
        DateReturned = findViewById(R.id.DateReturned);
        AddBookLoan = findViewById(R.id.AddBookLoan);
        UpdateBookLoan = findViewById(R.id.UpdateBookLoan);
        DeleteBookLoan = findViewById(R.id.DeleteBookLoan);
        ViewBookLoan= findViewById(R.id.ViewBookLoan);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler_bookloan(BookLoanActivity.this);


        //Option 2 : Add BookLoan
        AddBookLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String accessnumber = AccessNumber.getText().toString();
                String branchid = BranchId.getText().toString();
                String cardnumber = CardNumber.getText().toString();
                String dateout = DateOut.getText().toString();
                String datedue = DateDue.getText().toString();
                String datereturned = DateReturned.getText().toString();

                // validating if the text fields are empty or not.
                if (accessnumber.isEmpty() && branchid.isEmpty() && cardnumber.isEmpty() && dateout.isEmpty() && datedue.isEmpty() && datereturned.isEmpty()) {
                    Toast.makeText(BookLoanActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addnewbookloan(accessnumber, branchid, cardnumber, dateout, datedue, datereturned);

                // after adding the data we are displaying a toast message.
                Toast.makeText(BookLoanActivity.this, "Book Loan has been added.", Toast.LENGTH_SHORT).show();
                AccessNumber.setText("");
                BranchId.setText("");
                CardNumber.setText("");
                DateOut.setText("");
                DateDue.setText("");
                DateReturned.setText("");
            }
        });

        //Option 3 : Update BookLoan
        UpdateBookLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accessnumber = AccessNumber.getText().toString();
                String branchid = BranchId.getText().toString();
                String cardnumber = CardNumber.getText().toString();
                String dateout = DateOut.getText().toString();
                String datedue = DateDue.getText().toString();
                String datereturned = DateReturned.getText().toString();


                if (accessnumber.isEmpty() && branchid.isEmpty() && cardnumber.isEmpty() && dateout.isEmpty() && datedue.isEmpty() && datereturned.isEmpty()) {
                    Toast.makeText(BookLoanActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.UpdateBookLoan(accessnumber, branchid, cardnumber, dateout, datedue, datereturned);

                Toast.makeText(BookLoanActivity.this, "Book Loan has been updated.", Toast.LENGTH_SHORT).show();
                AccessNumber.setText("");
                BranchId.setText("");
                CardNumber.setText("");
                DateOut.setText("");
                DateDue.setText("");
                DateReturned.setText("");
            }
        });

        //Option 4 : Delete BookLoan
        DeleteBookLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accessnumber = AccessNumber.getText().toString();
                String branchid = BranchId.getText().toString();
                String cardnumber = CardNumber.getText().toString();
                String dateout = DateOut.getText().toString();
                String datedue = DateDue.getText().toString();
                String datereturned = DateReturned.getText().toString();

                if (accessnumber.isEmpty() && branchid.isEmpty() && cardnumber.isEmpty() && dateout.isEmpty() && datedue.isEmpty() && datereturned.isEmpty()) {
                    Toast.makeText(BookLoanActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.DeleteBookLoan(accessnumber);

                Toast.makeText(BookLoanActivity.this, "Book Loan has been deleted.", Toast.LENGTH_SHORT).show();
                AccessNumber.setText("");
                BranchId.setText("");
                CardNumber.setText("");
                DateOut.setText("");
                DateDue.setText("");
                DateReturned.setText("");
            }
        });
    }
}
