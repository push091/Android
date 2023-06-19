package com.example.create_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button Return=findViewById(R.id.return_button_Third);
        Button Call=findViewById(R.id.Call);

        Call.setOnClickListener(this::Call);
        Return.setOnClickListener(this::Return);

    }

    private void Call(View view) {
        Intent dialIntent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"1234567890"));
        startActivity(dialIntent);
    }

    private void Return(View view) {

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}