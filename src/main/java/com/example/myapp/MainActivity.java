package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources.Theme Theme_AppCompat = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            setTheme(Theme_AppCompat);
        }
        setContentView(R.layout.activity_main);

        //Option 1 : Book
        CardView book = findViewById(R.id.bookCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });

        //Option 2 : Member
        CardView member = findViewById(R.id.memberCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Option 3 : Publisher
        CardView publisher = findViewById(R.id.publisherCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PublisherActivity.class);
                startActivity(intent);
            }
        });

        //Option 4 : Author
        CardView author = findViewById(R.id.authorCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(intent);
            }
        });

        //Option 5 : Branch
        CardView branch = findViewById(R.id.branchCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BranchActivity.class);
                startActivity(intent);
            }
        });

        //Option 6 : Book Loan
        CardView loan = findViewById(R.id.bookloanCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookLoanActivity.class);
                startActivity(intent);
            }
        });

        //Option 7 : Book Copy
        CardView copy = findViewById(R.id.bookcopyCard);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookCopyActivity.class);
                startActivity(intent);
            }
        });


    }

    private class Theme_AppCompat {
    }

}