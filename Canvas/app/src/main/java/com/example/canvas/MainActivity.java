package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable mAnimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView fps=findViewById(R.id.imageView4);
        ////////// Объявление и запуск покадровой анимации explosion.xml
        fps.setBackgroundResource(R.drawable.explosion);
        mAnimationDrawable = (AnimationDrawable) fps.getBackground();
        mAnimationDrawable.start();
        /////////// Создание Path
        ImageView anim=findViewById(R.id.imageView3);
        Path p = new Path();
        p.moveTo(50, 0);
        p.lineTo(25,100);
        p.lineTo(100,50);
        p.lineTo(0,50);
        p.lineTo(75,100);
        p.lineTo(50,0);
        ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
        d.setIntrinsicHeight(200);
        d.setIntrinsicWidth(200);
        d.getPaint().setColor(Color.RED);
        d.getPaint().setStyle(Paint.Style.STROKE);

        ///
       anim.setBackground(d);
        /// Добавление анимации преобразования для Path
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.total);

       anim.startAnimation(animation);

        ////////
        ShapeDrawable line = new ShapeDrawable(new RectShape());
        line.setIntrinsicHeight(2);
        line.setIntrinsicWidth(150);
        line.getPaint().setColor(Color.MAGENTA);
        ImageView cube=findViewById(R.id.imageView2);
        cube.setBackground(line);

    }
}