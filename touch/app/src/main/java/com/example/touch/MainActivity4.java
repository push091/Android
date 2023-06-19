package com.example.touch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    private GestureDetectorCompat myDetector; TextView myText;
    View myView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        myText = findViewById(R.id.myText);
        myView = findViewById(R.id.myView);
        GestureListener myGestures = new GestureListener();
        myDetector = new GestureDetectorCompat(this, myGestures);

        myView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myDetector.onTouchEvent(event);
            }
        });
        myDetector.setOnDoubleTapListener(myGestures);
    }

    public class GestureListener implements
            GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener { @Override
    public boolean onDown(MotionEvent event) {
        myText.append("\n onDown"); return true;
    }
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            myText.append("\n onFling"); return true;
        }
        @Override
        public void onLongPress(MotionEvent event) {
            myText.append("\n onLongPress");
        }
        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2,
                                float distanceX, float distanceY) {
            myText.append("\n onScroll"); return true;
        }
        @Override
        public void onShowPress(MotionEvent event) {
            myText.append("\n onShowPress");
        }
        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            myText.append("\n onSingleTapUp"); return true;
        }
        @Override
        public boolean onDoubleTap(MotionEvent event) {
            myText.append("\n onDoubleTap"); return true;
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            myText.append("\n onDoubleTapEvent"); return true;
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            myText.append("\n onSingleTapConfirmed"); return true;
        }
    }

    }