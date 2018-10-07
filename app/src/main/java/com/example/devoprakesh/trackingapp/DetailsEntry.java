package com.example.devoprakesh.trackingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsEntry extends AppCompatActivity {

    private EditText regname,regphoneno;
    private Button submitdetails;
    private String name,phonenumber;
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_entry);

        submitdetails = findViewById(R.id.submitdetails);
        regname = findViewById(R.id.dname);
        regphoneno = findViewById(R.id.dphone);

        databaseReference = FirebaseDatabase.getInstance()
                .getReference("UsersParents");

        submitdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = regname.getText().toString();
                phonenumber = regphoneno.getText().toString();

                

            }
        });


    }
}
