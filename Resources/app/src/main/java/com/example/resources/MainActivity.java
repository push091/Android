package com.example.resources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity { @Override
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

    final TextView my_text = (TextView)findViewById(R.id.my_text); my_text.setTypeface(Typeface.createFromAsset(
            getAssets(), "fonts/PenguinAttackCyrillic.otf"));
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { getMenuInflater().inflate(R.menu.menu, menu); return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout mylayout = (LinearLayout)findViewById(R.id.root);

        if (item.getItemId()==R.id.red){

            mylayout.setBackgroundColor(getResources().getColor(R.color.red));
            return true;
        } else if (item.getItemId()==R.id.green) {

            mylayout.setBackgroundColor(getResources().getColor(R.color.green));
            return true;
        } else if (item.getItemId()==R.id.blue) {

            mylayout.setBackgroundColor(getResources().getColor(R.color.blue));
            return true;
        } else if (item.getItemId()==R.id.backgrund1) {

                mylayout.setBackground(getResources().getDrawable(R.drawable.backgrund1));
                return true;
        }else if (item.getItemId()==R.id.backgrund2) {

            mylayout.setBackground(getResources().getDrawable(R.drawable.background2));
            return true;
        }else if (item.getItemId()==R.id.orentation_Horizontal) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            return true;
        }
        else if (item.getItemId()==R.id.orentation_vert) {

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            return true;
        }
        else if(item.getItemId()==R.id.exit){
            finish();
            return true;}


        return false;
    }
}
