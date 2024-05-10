package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PublisherActivity extends AppCompatActivity {
    private EditText PublisherName, Address, PhoneNumber;
    private Button AddPublisher, UpdatePublisher, DeletePublisher, ViewPublisher;
    private DBHandler_publisher dbHandler;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publisher);

        /*
        //Option 1 : View Publisher
        Button view = findViewById(R.id.ViewPublisher);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.myapp.PublisherActivity.this, ViewPublisher.class);
                startActivity(intent);
            }
        });
*/

        // initializing all our variables.
        PublisherName = findViewById(R.id.PublisherName);
        Address = findViewById(R.id.Address);
        PhoneNumber = findViewById(R.id.PhoneNumber);
        AddPublisher = findViewById(R.id.AddPublisher);
        UpdatePublisher = findViewById(R.id.UpdatePublisher);
        DeletePublisher = findViewById(R.id.DeletePublisher);
        ViewPublisher = findViewById(R.id.ViewPublisher);

        //Option 2 : Add Publisher
        AddPublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String publishername = PublisherName.getText().toString();
                String address = Address.getText().toString();
                String phonenumber = PhoneNumber.getText().toString();


                // validating if the text fields are empty or not.
                if (publishername.isEmpty() && address.isEmpty() && phonenumber.isEmpty()) {
                    Toast.makeText(com.example.myapp.PublisherActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addnewpublisher(publishername, address, phonenumber);

                // after adding the data we are displaying a toast message.
                Toast.makeText(com.example.myapp.PublisherActivity.this, "Publisher has been added.", Toast.LENGTH_SHORT).show();
                PublisherName.setText("");
                Address.setText("");
                PhoneNumber.setText("");
            }
        });

        //Option 3 : Update Publisher
        UpdatePublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String publishername = PublisherName.getText().toString().trim();
                String address = Address.getText().toString().trim();
                String phonenumber = PhoneNumber.getText().toString().trim();

                if (publishername.isEmpty() && address.isEmpty() && phonenumber.isEmpty()) {
                    Toast.makeText(PublisherActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.UpdatePublisher(publishername, address, phonenumber);

                Toast.makeText(PublisherActivity.this, "Publisher has been updated.", Toast.LENGTH_SHORT).show();
                PublisherName.setText("");
                Address.setText("");
                PhoneNumber.setText("");
            }
        });

        DeletePublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String publishername = PublisherName.getText().toString().trim();
                String address = Address.getText().toString().trim();
                String phonenumber = PhoneNumber.getText().toString().trim();

                if (publishername.isEmpty() && address.isEmpty() && phonenumber.isEmpty()) {
                    Toast.makeText(com.example.myapp.PublisherActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.DeletePublisher(publishername);

                Toast.makeText(PublisherActivity.this, "Publisher has been deleted.", Toast.LENGTH_SHORT).show();
                PublisherName.setText("");
                Address.setText("");
                PhoneNumber.setText("");
            }
        });
    }
}


