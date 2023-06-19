package com.example.create_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_READ_CONTACTS=1;
    private static boolean READ_CONTACTS_GRANTED =false;
    private static final int CALL_PHONE_PERMISSION_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button Next= findViewById(R.id.next_button);
        Button Third=findViewById(R.id.third_Button);
        Button Contacts=findViewById(R.id.contacts);

        checkPermission(Manifest.permission.CALL_PHONE,CALL_PHONE_PERMISSION_CODE);



        Next.setOnClickListener(this::Next);
        Third.setOnClickListener(this::Third);
        Contacts.setOnClickListener(this::Contacts1);



    }

    private void checkPermission(String callPhone, int callPhonePermissionCode) {

        if ((ContextCompat.checkSelfPermission(MainActivity.this,callPhone))== PackageManager.PERMISSION_DENIED){

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{callPhone},callPhonePermissionCode);
    }


    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_READ_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                READ_CONTACTS_GRANTED = true;
            }
        }
        if(READ_CONTACTS_GRANTED){
            Toast.makeText(MainActivity.this,"Разрешение предоставлено",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Требуется установить разрешения", Toast.LENGTH_LONG).show();
        }

        /////////////////////////////////////////////////////////

        if (requestCode == CALL_PHONE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,"Разрешение предоставлено",Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(MainActivity.this,"Разрешение отклонено",Toast.LENGTH_SHORT).show();
            }
        }


    }


    private void Third(View view) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),ThirdActivity.class);
        startActivity(intent);

    }

    private void Next(View view) {

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),SecodActivity.class);
        startActivity(intent);
    }
    private void Contacts1(View view) {

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),Contact.class);
        startActivity(intent);
    }

}