package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;


public class MapLayout extends AppCompatActivity {
   MapView map;
   MapController mapController;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_layout);
        map = findViewById(R.id.map);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        mapController = (MapController) map.getController();
        mapController.setZoom(15);
        GeoPoint geoPoint = new GeoPoint(51.347580, 42.129458);
        mapController.setCenter(geoPoint);
        GeoPoint startPoint = new GeoPoint(51.347580, 42.129458);
        Marker startMarker = new Marker(map);
        startMarker.setTitle("МБОУ БГО СОШ №3");
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_TOP, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startMarker);
    }
}