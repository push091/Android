package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button SensorView = findViewById(R.id.sensView);
        Button AcelView=findViewById(R.id.AcelView);
        Button LighView=findViewById(R.id.lightView);

        SensorView.setOnClickListener(this::SensorView);
        LighView.setOnClickListener(this::LighView);
        AcelView.setOnClickListener(this::AcelView);
    }

    private void SensorView(View view) {
        Intent intent=new Intent();
        intent.setClass(this, MainActivity2.class);
        startActivity(intent);
    }

    private void LighView(View view) {
        Intent intent=new Intent();
        intent.setClass(this, MainActivity3.class);
        startActivity(intent);
    }

    private void AcelView(View view) {

        Intent intent=new Intent();
        intent.setClass(this, MainActivity4.class);
        startActivity(intent);
    }


}