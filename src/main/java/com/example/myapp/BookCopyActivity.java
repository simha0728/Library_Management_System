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

public class BookCopyActivity extends AppCompatActivity {
    private EditText BookId, BranchId, AccessNumber;
    private Button AddBookCopy, UpdateBookCopy, DeleteBookCopy, ViewBookCopy;
    private DBHandler_bookcopy dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_copy);

        /*
        //Option 1 : View BookCopy
        Button view = findViewById(R.id.ViewBookCopy);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookCopyActivity.this, ViewCopy.class);
                startActivity(intent);
            }
        });
*/

        // initializing all our variables.
        BookId = findViewById(R.id.BookId);
        BranchId = findViewById(R.id.BranchId);
        AccessNumber = findViewById(R.id.AccessNumber);
        AddBookCopy = findViewById(R.id.AddBookCopy);
        UpdateBookCopy = findViewById(R.id.UpdateBookCopy);
        DeleteBookCopy = findViewById(R.id.DeleteBookCopy);
        ViewBookCopy= findViewById(R.id.ViewBookCopy);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler_bookcopy(BookCopyActivity.this);


        //Option 2 : Add BookCopy
        AddBookCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String bookid = BookId.getText().toString();
                String branchid = BranchId.getText().toString();
                String accessnumber = AccessNumber.getText().toString();

                // validating if the text fields are empty or not.
                if (bookid.isEmpty() && branchid.isEmpty() && accessnumber.isEmpty()) {
                    Toast.makeText(BookCopyActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addnewbookcopy(bookid, branchid, accessnumber);

                // after adding the data we are displaying a toast message.
                Toast.makeText(BookCopyActivity.this, "Book Copy has been added.", Toast.LENGTH_SHORT).show();
                BookId.setText("");
                BranchId.setText("");
                AccessNumber.setText("");
            }
        });

        //Option 3 : Update BookCopy
        UpdateBookCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookid = BookId.getText().toString();
                String branchid = BranchId.getText().toString();
                String accessnumber = AccessNumber.getText().toString();

                if (bookid.isEmpty() && branchid.isEmpty() && accessnumber.isEmpty()) {
                    Toast.makeText(BookCopyActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.UpdateBookCopy(bookid, branchid, accessnumber);

                Toast.makeText(BookCopyActivity.this, "Book Copy has been updated.", Toast.LENGTH_SHORT).show();
                BookId.setText("");
                BranchId.setText("");
                AccessNumber.setText("");
            }
        });

        //Option 4 : Delete BookCopy
        DeleteBookCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookid = BookId.getText().toString();

                if (bookid.isEmpty()) {
                    Toast.makeText(BookCopyActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.DeleteBookCopy(bookid);

                Toast.makeText(BookCopyActivity.this, "Bok Copy has been deleted.", Toast.LENGTH_SHORT).show();
                BookId.setText("");
            }
        });

    }
}
