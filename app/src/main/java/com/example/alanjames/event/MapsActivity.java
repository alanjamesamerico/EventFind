package com.example.alanjames.event;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.alanjames.event.core.events.EventsContants;
import com.example.alanjames.event.core.events.EventsJSON;

import com.example.alanjames.event.core.utils.ConnHttp;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private EventsJSON api = new EventsJSON();
    ArrayList<HashMap<String,Object>> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.17944, -45.88694), 8));

        events = api.getEvents();
        Marker marker = null;

        for (HashMap<String,Object> e : events) {
            double lat = (Double) e.get("lat");
            double lng = (Double) e.get("lng");

            marker = mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng))
                                                              .title("Tema: " + e.get("title").toString())
                                                              .snippet(e.get("venue").toString()));
        }

        mMap.setOnMarkerClickListener(this);
    }

    /** Chamado quando o usuário clica em um marcador. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        Bundle bundle = new Bundle();
        bundle.putString("title", marker.getTitle());
        bundle.putString("subTitle", marker.getSnippet());

        if (marker.getSnippet().equals(EventsContants.SJC)) {
            bundle.putString("date", events.get(EventsContants.ID_SJC).get("date").toString());
            bundle.putString("time", events.get(EventsContants.ID_SJC).get("time").toString());
            bundle.putString("venue", events.get(EventsContants.ID_SJC).get("venue").toString());
        } else if (marker.getSnippet().equals(EventsContants.TTE)) {
            bundle.putString("date", events.get(EventsContants.ID_TTE).get("date").toString());
            bundle.putString("time", events.get(EventsContants.ID_TTE).get("time").toString());
            bundle.putString("venue", events.get(EventsContants.ID_TTE).get("venue").toString());
        } else if (marker.getSnippet().equals(EventsContants.SNT)) {
            bundle.putString("date", events.get(EventsContants.ID_SNT).get("date").toString());
            bundle.putString("time", events.get(EventsContants.ID_SNT).get("time").toString());
            bundle.putString("venue", events.get(EventsContants.ID_SNT).get("venue").toString());
        } else if (marker.getSnippet().equals(EventsContants.CPV)) {
            bundle.putString("date", events.get(EventsContants.ID_CPV).get("date").toString());
            bundle.putString("time", events.get(EventsContants.ID_CPV).get("time").toString());
            bundle.putString("venue", events.get(EventsContants.ID_CPV).get("venue").toString());
        } else if (marker.getSnippet().equals(EventsContants.LRN)) {
            bundle.putString("date", events.get(EventsContants.ID_LRN).get("date").toString());
            bundle.putString("time", events.get(EventsContants.ID_LRN).get("time").toString());
            bundle.putString("venue", events.get(EventsContants.ID_LRN).get("venue").toString());
        }

        Intent markerActivity = new Intent(this, MarkerActivity.class);
        markerActivity.putExtras(bundle);
        startActivity(markerActivity);

        return false;
    }
}
