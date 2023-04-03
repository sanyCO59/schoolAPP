package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class clikerLayout extends AppCompatActivity {
    TextView cliker;
    int click =0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliker_layout);
        cliker = findViewById(R.id.but_1);
    }

    public void click(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_cliker);
        cliker.startAnimation(animation);
        click=click+1;//click++;
        cliker.setText("Количество нажатий: "+click);
    }
}