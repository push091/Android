package com.example.create_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SecodActivity extends AppCompatActivity {

    public TextView stats;
    ArrayList<String> Stats = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secod);

        Button Return=findViewById(R.id.return_Button_Second);
        stats = findViewById(R.id.stats);


        Stats.add("onCreate");

        Return.setOnClickListener(this::Return);

    }

    private void Return(View view) {

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Stats.add("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Stats.add("onResume");
        String stat ="";
        for (int i=0;i<Stats.size();i++){

            stat=stat+Stats.get(i)+"\n";
        }
        stats.setText(stat);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Stats.add("onPause");
    }
}