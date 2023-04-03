package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void move1(View view) {
        Intent intent = new Intent(MainActivity.this, clikerLayout.class);
        startActivity(intent);
    }

    public void move2(View view) {
        Intent intent = new Intent(MainActivity.this, AnimationLayout.class);
        startActivity(intent);
    }

    public void move3(View view) {
        Intent intent = new Intent(MainActivity.this, MapLayout.class);
        startActivity(intent);
    }

    public void move4(View view) {
        Intent intent = new Intent(MainActivity.this, WeatherLayout.class);
        startActivity(intent);
    }
}