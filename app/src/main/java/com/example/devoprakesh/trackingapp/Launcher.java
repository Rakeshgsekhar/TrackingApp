package com.example.devoprakesh.trackingapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Launcher extends AppCompatActivity {

    private static final int PERMISSION_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(Launcher.this,"Please enable Location Service",Toast.LENGTH_LONG).show();
            finish();
        }


        int permission = ContextCompat
                .checkSelfPermission(Launcher.this,
                        Manifest.permission.ACCESS_FINE_LOCATION);

        if(permission==PackageManager.PERMISSION_GRANTED){


        }else{

            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                    ,PERMISSION_REQUEST);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_REQUEST && grantResults.length==2
                && grantResults[0] == PackageManager.PERMISSION_GRANTED){

           /* Intent intent = new Intent(Launcher.this,MainActivity.class);
            startActivity(intent);
            finish();*/

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Launcher.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },5000);

        }else{

            finish();
        }
    }
}
