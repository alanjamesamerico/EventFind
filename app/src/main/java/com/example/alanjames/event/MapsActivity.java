package com.example.alanjames.event;

import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.alanjames.event.core.events.EventsJSON;
import com.example.alanjames.event.core.pojo.EventsPOJO;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EventsJSON api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.17944, -45.88694), 10));

        List<EventsPOJO> events = api.getEvents();

        for (EventsPOJO e : events) {
            LatLng marker = new LatLng(e.getLat(), e.getLng());
            mMap.addMarker(new MarkerOptions().position(marker).title(e.getTitle()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        }

        // TESTE
        LatLng uniao = new LatLng(-23.779, -45.3557);
        mMap.addMarker(new MarkerOptions().position(uniao).title("Ilha Bela"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uniao));
    }
}
