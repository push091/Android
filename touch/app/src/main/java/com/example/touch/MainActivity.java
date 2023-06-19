package com.example.touch;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Page1=findViewById(R.id.page_1);
        Button Page2=findViewById(R.id.page_2);
        Button Page3=findViewById(R.id.page_3);


        Page1.setOnClickListener(this::page1);
        Page2.setOnClickListener(this::page2);
        Page3.setOnClickListener(this::page3);
    }

    private void page2(View view) {
        Intent intent=new Intent();
        intent.setClass(getApplicationContext(),MainActivity3.class);
        startActivity(intent);
    }

    private void page3(View view) {

        Intent intent= new Intent();
        intent.setClass(getApplicationContext(), MainActivity4.class);
        startActivity(intent);
    }

    private void page1(View view) {

        Intent intent=new Intent();
        intent.setClass(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }

    public static class GestureListener {
    }
}



