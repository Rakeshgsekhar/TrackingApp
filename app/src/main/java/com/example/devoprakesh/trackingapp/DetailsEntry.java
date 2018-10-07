package com.example.devoprakesh.trackingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsEntry extends AppCompatActivity {

    private EditText regname,regphoneno;
    private Button submitdetails;
    private String name,phonenumber,useremail;
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_entry);

        sharedPreferences = getSharedPreferences("UserLoginDetails",
                MODE_PRIVATE);

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

                if(TextUtils.isEmpty(name) && TextUtils.isEmpty(phonenumber)){
                    Toast.makeText(DetailsEntry.this,"Feilds Cannot be Empty",
                            Toast.LENGTH_LONG).show();
                }else{
                    UserData userData = new UserData(name,phonenumber);
                    useremail = sharedPreferences.getString("EmailID",null);
                    databaseReference.child(useremail).setValue(userData)
                            .addOnCompleteListener(DetailsEntry.this,
                                    new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(DetailsEntry.this, "DataAdded Successfuly",
                                                Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(DetailsEntry.this,Home.class);
                                        startActivity(intent);
                                        finish();
                                    }else{

                                        Log.i("Detaisl Adding -> ","00"+task.getResult());
                                        Toast.makeText(DetailsEntry.this,"Something went Wrong",Toast.LENGTH_LONG)
                                                .show();
                                    }
                                }
                            });
                }



            }
        });


    }
}
