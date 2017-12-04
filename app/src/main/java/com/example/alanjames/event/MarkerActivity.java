package com.example.alanjames.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by Alan James on 03/12/2017.
 */

public class MarkerActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        String title = data.get("title").toString();
        String venue = data.get("venue").toString();
        String date = data.get("date").toString();
        String time = data.get("time").toString();

        TextView contentTitle = (TextView) findViewById(R.id.textViewContentTitle);
        contentTitle.setText(title);

        TextView contentVenue = (TextView) findViewById(R.id.textViewContentVenue);
        contentVenue.setText(venue);

        TextView contentDate = (TextView) findViewById(R.id.textViewContentDate);
        contentDate.setText(date);

        TextView contentTime = (TextView) findViewById(R.id.textViewContentTime);
        contentTime.setText(time);

    }
}
