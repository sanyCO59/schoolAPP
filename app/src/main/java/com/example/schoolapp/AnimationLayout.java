package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationLayout extends AppCompatActivity {
ImageView img1, img2, img3, img4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout);
        img1 =findViewById(R.id.imageView1);
        img2 =findViewById(R.id.imageView2);
        img3 =findViewById(R.id.imageView3);
        img4 =findViewById(R.id.imageView4);
    }

    public void anim1(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        img1.startAnimation(animation);
    }

    public void anim2(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        img2.startAnimation(animation);
    }

    public void anim3(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        img3.startAnimation(animation);
    }

    public void anim4(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        img4.startAnimation(animation);
    }
}