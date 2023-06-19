package com.example.touch;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView downX; TextView downY;
    TextView upX; TextView upY;
    TextView moveX; TextView moveY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        downX = findViewById(R.id.down_x);
        downY = findViewById(R.id.down_y);
        upX = findViewById(R.id.up_x);
        upY = findViewById(R.id.up_y);
        moveX = findViewById(R.id.move_x);
        moveY = findViewById(R.id.move_y);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) { String x; String y;
        int action = event.getAction();
        x = Integer.toString((int)event.getX()); y = Integer.toString((int)event.getY()); switch (action) {
            case (MotionEvent.ACTION_DOWN): downX.setText(x); downY.setText(y);
                return true;
            case (MotionEvent.ACTION_MOVE): moveX.setText(x); moveY.setText(y); upX.setText("");
                upY.setText(""); return true;
            case (MotionEvent.ACTION_UP):
                upX.setText(x);
                upY.setText(y); moveX.setText("");
                moveY.setText(""); return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}
