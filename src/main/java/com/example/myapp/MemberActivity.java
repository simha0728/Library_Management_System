package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

    public class MemberActivity extends AppCompatActivity {
        private EditText CardNumber, Name, Address, PhoneNumber, UnpaidDues;
        private Button AddMember, UpdateMember, DeleteMember, ViewMember;
        private DBHandler_member dbHandler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.member);
/*
            //Option 1 : View Member
            Button view = findViewById(R.id.ViewMember);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(com.example.myapp.MemberActivity.this, ViewMember.class);
                    startActivity(intent);
                }
            });*/

            // initializing all our variables.
            CardNumber = findViewById(R.id.CardNumber);
            Name = findViewById(R.id.Name);
            Address = findViewById(R.id.Address);
            PhoneNumber = findViewById(R.id.PhoneNumber);
            UnpaidDues = findViewById(R.id.UnpaidDues);
            AddMember = findViewById(R.id.AddMember);
            UpdateMember = findViewById(R.id.UpdateMember);
            DeleteMember = findViewById(R.id.DeleteMember);
            ViewMember = findViewById(R.id.ViewMember);

            //Option 2 : Add Member
            AddMember.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // below line is to get data from all edit text fields.
                    String cardnumber = CardNumber.getText().toString();
                    String name = Name.getText().toString();
                    String address = Address.getText().toString();
                    String phonenumber = PhoneNumber.getText().toString();
                    String unpaiddues = UnpaidDues.getText().toString();

                    // validating if the text fields are empty or not.
                    if (cardnumber.isEmpty() && name.isEmpty() && address.isEmpty() && phonenumber.isEmpty() && unpaiddues.isEmpty()) {
                        Toast.makeText(com.example.myapp.MemberActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    dbHandler.addnewmember(cardnumber, name, address, phonenumber, unpaiddues);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(com.example.myapp.MemberActivity.this, "Member has been added.", Toast.LENGTH_SHORT).show();
                    CardNumber.setText("");
                    Name.setText("");
                    Address.setText("");
                    PhoneNumber.setText("");
                    UnpaidDues.setText("");
                }
            });

            //Option 3 : Update Member
            UpdateMember.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cardnumber = CardNumber.getText().toString();
                    String name = Name.getText().toString();
                    String address = Address.getText().toString();
                    String phonenumber = PhoneNumber.getText().toString();
                    String unpaiddues = UnpaidDues.getText().toString();

                    if (cardnumber.isEmpty() && name.isEmpty() && address.isEmpty() && phonenumber.isEmpty() && unpaiddues.isEmpty()) {
                        Toast.makeText(com.example.myapp.MemberActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    dbHandler.UpdateMember(cardnumber, name, address, phonenumber, unpaiddues);

                    Toast.makeText(MemberActivity.this, "Member has been updated.", Toast.LENGTH_SHORT).show();
                    CardNumber.setText("");
                    Name.setText("");
                    Address.setText("");
                    PhoneNumber.setText("");
                    UnpaidDues.setText("");
                }
            });

            DeleteMember.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cardnumber = CardNumber.getText().toString();
                    String name = Name.getText().toString();
                    String address = Address.getText().toString();
                    String phonenumber = PhoneNumber.getText().toString();
                    String unpaiddues = UnpaidDues.getText().toString();

                    if (cardnumber.isEmpty() && name.isEmpty() && address.isEmpty() && phonenumber.isEmpty() && unpaiddues.isEmpty()) {
                        Toast.makeText(com.example.myapp.MemberActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    dbHandler.DeleteMember(cardnumber);

                    Toast.makeText(MemberActivity.this, "Book has been deleted.", Toast.LENGTH_SHORT).show();
                    CardNumber.setText("");
                    Name.setText("");
                    Address.setText("");
                    PhoneNumber.setText("");
                    UnpaidDues.setText("");
                }
            });
        }
    }


