package ru.arcadudu.project_holydays;

import androidx.fragment.app.FragmentActivity;


import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity_main extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

      @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng krasnodar = new LatLng(45.044840, 38.9760300);
        googleMap.addMarker(new MarkerOptions().position(krasnodar).title("Marker in Krasnodar"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(krasnodar, 14f));
    }
}