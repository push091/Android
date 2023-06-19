package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton Bolt;
    private TextView Main_text, Text_size;
    private RadioButton SansSerif,Monospace,Serif;
    private float mTextSize =32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button minus = findViewById(R.id.button_minus);
        Button plus = findViewById(R.id.button_plus);
        Main_text=findViewById(R.id.MainText);
        Text_size=findViewById(R.id.textsize_numb);
        Bolt = findViewById(R.id.toggleButton_B);
        ToggleButton i = findViewById(R.id.toggleButton_i);
        SansSerif=findViewById(R.id.radioButton_SansSerif);
        Serif=findViewById(R.id.radioButton_Serif);
        Main_text.setTextSize(mTextSize);
        Text_size.setText(String.format("%.0f",mTextSize));
        Monospace=findViewById(R.id.radioButton_Monospace);



        plus.setOnClickListener(this::Plus);
        minus.setOnClickListener(this::Minus);
        Bolt.setOnClickListener(this::b);
        i.setOnClickListener(this::i);
        SansSerif.setOnClickListener(this::Sans);
        Serif.setOnClickListener(this::Serif);
        Monospace.setOnClickListener(this::Monospace);
    }

    private void Monospace(View view) {
        if (Main_text.getTypeface().getStyle()== Typeface.ITALIC)
            Main_text.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
        else if (Main_text.getTypeface().getStyle()== Typeface.BOLD_ITALIC)
            Main_text.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
        else if (Main_text.getTypeface().getStyle()== Typeface.BOLD)
            Main_text.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
        else Main_text.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
    }

    private void Serif(View view) {
        if (Main_text.getTypeface().getStyle()== Typeface.ITALIC)
            Main_text.setTypeface(Typeface.SERIF, Typeface.ITALIC);
        else if (Main_text.getTypeface().getStyle()== Typeface.BOLD_ITALIC)
            Main_text.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
        else if (Main_text.getTypeface().getStyle()== Typeface.BOLD)
            Main_text.setTypeface(Typeface.SERIF, Typeface.BOLD);
        else Main_text.setTypeface(Typeface.SERIF, Typeface.NORMAL);
    }


    public void Plus (View v){
        if (mTextSize<72){
            mTextSize+=2;
            Main_text.setTextSize(mTextSize);
            Text_size.setText(String.format("%.0f",mTextSize));

        }
    }
    public void Minus (View v){
        if (mTextSize>18){
            mTextSize-=2;
            Main_text.setTextSize(mTextSize);
            Text_size.setText(String.format("%.0f",mTextSize));

        }
    }
    public void b (View v){
        if (Main_text.getTypeface().getStyle()==Typeface.ITALIC)
            Main_text.setTypeface(Main_text.getTypeface(),Typeface.BOLD_ITALIC);
        else if (Main_text.getTypeface().getStyle()==Typeface.BOLD_ITALIC)
            Main_text.setTypeface(Main_text.getTypeface(),Typeface.ITALIC);
        else if (Main_text.getTypeface().getStyle()==Typeface.BOLD)
            Main_text.setTypeface(Typeface.create(Main_text.getTypeface(),Typeface.NORMAL));
        else Main_text.setTypeface(Main_text.getTypeface(),Typeface.BOLD);



    }
    public void i (View v){
        if (Main_text.getTypeface().getStyle()==Typeface.BOLD)
            Main_text.setTypeface(Main_text.getTypeface(),Typeface.BOLD_ITALIC);
        else if (Main_text.getTypeface().getStyle()==Typeface.BOLD_ITALIC)
            Main_text.setTypeface(Main_text.getTypeface(),Typeface.BOLD);
        else if (Main_text.getTypeface().getStyle()==Typeface.ITALIC)
            Main_text.setTypeface(Typeface.create(Main_text.getTypeface(),Typeface.NORMAL));
        else Main_text.setTypeface(Main_text.getTypeface(),Typeface.ITALIC);

    }

    public void Sans (View v){

        if (Main_text.getTypeface().getStyle()== Typeface.ITALIC)
            Main_text.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
        else if (Main_text.getTypeface().getStyle()== Typeface.BOLD_ITALIC)
            Main_text.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        else if (Main_text.getTypeface().getStyle()== Typeface.BOLD)
            Main_text.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        else Main_text.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);


    }
}

