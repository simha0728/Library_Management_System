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

public class AuthorActivity extends AppCompatActivity {
    private EditText bookid, authorName;
    private Button AddAuthor, UpdateAuthor, DeleteAuthor, ViewAuthor;
    private DBHandler_author dbHandler;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author);


        //Option 1 : View Author
        Button view = findViewById(R.id.ViewAuthor);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.myapp.AuthorActivity.this, ViewAuthor.class);
                startActivity(intent);
            }
        });


        // initializing all our variables.
        bookid = findViewById(R.id.bookid);
        authorName = findViewById(R.id.authorName);
        AddAuthor = findViewById(R.id.AddAuthor);
        UpdateAuthor = findViewById(R.id.UpdateAuthor);
        DeleteAuthor = findViewById(R.id.DeleteAuthor);
        ViewAuthor = findViewById(R.id.ViewAuthor);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler_author(AuthorActivity.this);


        //Option 2 : Add Author
        AddAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String Bookid = bookid.getText().toString();
                String authorname = authorName.getText().toString();
                
                // validating if the text fields are empty or not.
                if (Bookid.isEmpty() && authorname.isEmpty()) {
                    Toast.makeText(com.example.myapp.AuthorActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addnewauthor(Bookid, authorname);

                // after adding the data we are displaying a toast message.
                Toast.makeText(com.example.myapp.AuthorActivity.this, "Author has been added.", Toast.LENGTH_SHORT).show();
                bookid.setText("");
                authorName.setText("");
            }
        });

        //Option 3 : Update Author
        UpdateAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Bookid = bookid.getText().toString();
                String authorname = authorName.getText().toString();

                if (Bookid.isEmpty() && authorname.isEmpty()) {
                    Toast.makeText(AuthorActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.UpdateAuthor(Bookid, authorname);

                Toast.makeText(AuthorActivity.this, "Author has been updated.", Toast.LENGTH_SHORT).show();
                bookid.setText("");
                authorName.setText("");
            }
        });

        //Option 4 : Delete Author
        DeleteAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Bookid = bookid.getText().toString();
                String authorname = authorName.getText().toString();

                if (Bookid.isEmpty() && authorname.isEmpty()) {
                    Toast.makeText(com.example.myapp.AuthorActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.DeleteAuthor(Bookid);

                Toast.makeText(AuthorActivity.this, "Author has been deleted.", Toast.LENGTH_SHORT).show();
                bookid.setText("");
                authorName.setText("");
            }
        });
    }
}


